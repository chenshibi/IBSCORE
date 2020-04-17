package com.huateng.report.service;

import java.io.File;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.common.PbocConstants;
import com.huateng.report.convert.BeanToXmlConverter;
import com.huateng.report.dao.CrPbocR103Dao;
import com.huateng.report.dao.CrPbocR104Dao;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.utils.Base64Util;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.PbocUtils;
import com.huateng.report.utils.SM3;
import com.huateng.report.utils.XmlUtils;
import com.huateng.report.ws.WSDLClient;

import resource.bean.crms.CrPbocR103;
import resource.bean.crms.CrPbocR104;
/**
 * 
 * @author Grassy
 *
 */
@Service
public class PbocR103Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(PbocR103Service.class);
    
	@Autowired
    private CrPbocR103Dao pbocR103Dao;
    @Autowired
    private CrPbocR104Dao pbocR104Dao;
    @Autowired
    private BeanToXmlConverter beanToXmlConverter;
    @Autowired
    private WSDLClient wsdlClient;
    @Autowired
    private NewSysParamsService sysParamsService;
 
    public static PbocR103Service getInstance() {
        return ApplicationContextUtils.getBean(PbocR103Service.class);
    }
    
    /**
     * 企业抵押物查询
     *
     * @param mapString String
     * @return String
     */
    public QueryResult queryCollateral(Map<String,String> requestMap) {
        String uuid = "";
        QueryResult queryResult = null;
        CrPbocR103 entity = null;
        try {
            entity = genR103Entity(requestMap);
            pbocR103Dao.save(entity);
            uuid = entity.getId();
            String msg = beanToXmlConverter.genR103Msg(entity);
            PbocUtils.saveFile(msg, sysParamsService.getCollateralSendPath(), entity.getId() + "_send.msg");
            LOGGER.info("发送请求报文为----------------------" + msg);
         //   String result= testReadFile.readJsonData("E:\\devWorkspace\\IBSCORE\\src\\basic\\resource\\corp\\response.txt");
            String result=wsdlClient.queryCollateral(msg.trim());
            LOGGER.info("返回webservice----------------------" + result);
            PbocUtils.saveFile(msg, sysParamsService.getCollateralRecvPath(), entity.getId() + "_recv.msg");
            queryResult = parseR104Xml(uuid, result);
            entity.setStatus("03");
            entity.setRespTime(DateUtils.get14Time());

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            queryResult=new QueryResult();
            queryResult.setMsg(e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_WSDL);
            queryResult.setId(uuid);
            try {
                if (entity != null) {
                    entity.setStatus("04");
                    entity.setRsv10(e.getMessage());
                    entity.setRespTime(DateUtils.get14Time());
                    pbocR103Dao.update(entity);
                }
            } catch (Exception e1) {
               LOGGER.error(e.getMessage(), e);
            }
        }
        return queryResult;
    }
    
    
    /**
     * 企业抵押物返回
     *
     * @param msg String
     * @return String
     */
    public QueryResult parseR104Xml(String uuid, String msg) throws Exception {

        QueryResult queryResult = new QueryResult();
        queryResult.setCode(PbocConstants.QUERY_SUCCESS);
        queryResult.setId(uuid);
        String xmlStr = StringUtils.substring(msg, 78).trim();
        xmlStr.replaceAll("&#xD;&#xA;", "");
        LOGGER.info("========需要解析报文信息为====="+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            LOGGER.info("=============解析的document为======================="+document.asXML());            
        } catch (DocumentException e) {
            queryResult.setCode(PbocConstants.QUERY_FAILED_MAIN_XML);
            queryResult.setMsg(e.getMessage());
        }

        CrPbocR104 item = new CrPbocR104();
        item.setId(uuid);
        item.setResultCode(XmlUtils.getValue(document, "/Document/Msg/ResultCode"));
        item.setResultDesc(XmlUtils.getValue(document, "/Document/Msg/ResultDesc"));
        item.setReportName(XmlUtils.getValue(document, "/Document/Msg/ReportName"));
        item.setRecordStatus("03");
        String base64Msg = XmlUtils.getValue(document, "/Document/Msg/ReportMessage");
        String reportMsg = "";
        File rptFile = null;
        try {
            reportMsg = Base64Util.decodeData(base64Msg);
            LOGGER.info("报文明细信息为====="+reportMsg);
            rptFile = PbocUtils.saveFile(reportMsg, sysParamsService.getCollateralRecvPath(), uuid + "_report.xml");
        } catch (Exception e) {
            LOGGER.error("decode base64 failed, base64=[{}], detailMessage = {}", base64Msg, e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_REPORT_BASE64);
            queryResult.setMsg(e.getMessage());
            item.setRecordStatus("04");
        }

        try {
            if (StringUtils.isNotBlank(reportMsg)) {
                XmlUtils.parseCorpReport(reportMsg, uuid);
            }
        } catch (Exception e) {
            LOGGER.error("parse xml failed, report xml=[{}], detailMessage = {}", reportMsg, e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_REPORT_XML);
            queryResult.setMsg(e.getMessage());
            item.setRecordStatus("04");
        }
        item.setReceiptTime(DateUtils.get14Time());
        item.setReportMessagePath(rptFile == null ? "" : rptFile.getPath());
        pbocR104Dao.save(item);
        return queryResult;
    }
    
    public CrPbocR103 genR103Entity(Map<String, String> map) throws Exception {
        CrPbocR103 r103 = new CrPbocR103();
        r103.setMsgStartFlag(Constant.MSG_FLAG);
        r103.setMsgVersion(sysParamsService.getCorpVer());
        r103.setMsgSndCode(sysParamsService.getBankCode());
        r103.setMsgRcvCode(sysParamsService.getPbocCode());
        r103.setMsgGenTime(DateUtils.get14Time());
        r103.setMsgType(Constant.MSG_TYPE);
        r103.setMsgId(DateUtils.get8Date()+PbocUtils.genPbocMsgId());
        r103.setMsgRsv(Constant.RESERVED_FIELD);
        r103.setQueryOrgCode(sysParamsService.getBankCode());
        r103.setUserCode(sysParamsService.getBankUser());
        r103.setPassword(SM3.getHash(sysParamsService.getBankPwd()));
        r103.setOriginateOrgCode(sysParamsService.getBankCode());
        r103.setOriginateUserCode(sysParamsService.getBankUser());
        r103.setEntName((String) map.get("entName"));
        r103.setEntCertType((String) map.get("entCertType"));
        r103.setEntCertNum((String) map.get("entCertNum"));
        r103.setQueryReason((String) map.get("queryReason"));
        r103.setServiceCode((String) map.get("serviceCode"));
        r103.setQueryDate(DateUtils.get8Date());
        r103.setCreateUser((String) map.get("tlrno"));
        r103.setCreateTime(DateUtils.get14Time());
        r103.setStatus(Constant.ADD_QUERY_STATUS);
        return r103;
    }
    



}
