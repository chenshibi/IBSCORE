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
import com.huateng.report.dao.CrPbocD101DAO;
import com.huateng.report.dao.CrPbocD102DAO;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.utils.Base64Util;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.PbocUtils;
import com.huateng.report.utils.SM3;
import com.huateng.report.utils.XmlUtils;
import com.huateng.report.ws.WSDLClient;

import resource.bean.crms.CrPbocD101;
import resource.bean.crms.CrPbocD102;

/**
 * 
 * @author Grassy
 *
 */
@Service
public class PbocD101Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(PbocD101Service.class);
    @Autowired
    private CrPbocD101DAO pbocD101Dao;
    @Autowired
    private CrPbocD102DAO pbocD102Dao;

    @Autowired
    private BeanToXmlConverter beanToXmlConverter;
    
    @Autowired
    private WSDLClient wsdlClient;

    @Autowired
    private NewSysParamsService sysParamsService;
    
    public static PbocD101Service getInstance() {
        return ApplicationContextUtils.getBean(PbocD101Service.class);
    }

    /**
     * 个人单笔查询请求返回
     *
     * @param msg String
     * @return String
     */
    public QueryResult parseD102Xml(String uuid, String msg) {

        QueryResult queryResult = new QueryResult();
        queryResult.setCode(PbocConstants.QUERY_SUCCESS);
        queryResult.setId(uuid);
        String xmlStr = StringUtils.substring(msg, 78);
       /* int pos = StringUtils.indexOf(xmlStr, "</Document>") + "</Document>".length();
        xmlStr = StringUtils.substring(xmlStr, 0, pos);*/
        xmlStr.replaceAll("&#xD;&#xA;", "");
        LOGGER.info("解析报文信息为====="+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
        } catch (DocumentException e) {
            queryResult.setCode(PbocConstants.QUERY_FAILED_MAIN_XML);
            queryResult.setMsg(e.getMessage());
        }

        CrPbocD102 item = new CrPbocD102();
        item.setId(uuid);
        item.setResultCode(XmlUtils.getValue(document, "/Document/Msg/ResultCode"));
        item.setResultDesc(XmlUtils.getValue(document, "/Document/Msg/ResultDesc"));
        item.setReportName(XmlUtils.getValue(document, "/Document/Msg/ReportName"));
        item.setRecordStatus("03");
        String base64Msg = XmlUtils.getValue(document, "/Document/Msg/ReportMessage");
        base64Msg = StringUtils.trimToEmpty(base64Msg.replace("/r/n",""));
        base64Msg = StringUtils.trimToEmpty(base64Msg);
        String reportMsg = "";
        File rptFile = null;
        try {
        	reportMsg = Base64Util.decodeData(base64Msg);
            LOGGER.info("人行返回报文信息====="+reportMsg);
            rptFile = PbocUtils.saveFile(reportMsg, sysParamsService.getPersonalRecvPath(), uuid + "_report.xml");
        } catch (Exception e) {
            LOGGER.error("decode base64 failed, base64=[{}], detailMessage = {}", base64Msg, e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_REPORT_BASE64);
            queryResult.setMsg(e.getMessage());
            item.setRecordStatus("04");
        }

        try {
            if (StringUtils.isNotBlank(reportMsg)) {
                XmlUtils.parsePersonalReport(reportMsg, uuid);
            }
        } catch (Exception e) {
            LOGGER.error("parse xml failed, report xml=[{}], detailMessage = {}", reportMsg, e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_REPORT_XML);
            queryResult.setMsg(e.getMessage());
            item.setRecordStatus("04");
        }
        item.setReceiptTime(DateUtils.get14Time());
        item.setReportMessagePath(rptFile == null ? "" : rptFile.getPath());
       // pbocD101Service.pbocD102Dao.save(item);
        pbocD102Dao.save(item);
        return queryResult;
    }

    public QueryResult queryPersonal(Map<String,String> map) {
        String uuid = "";
        QueryResult queryResult = null;
        CrPbocD101 entity = null;
        try {
        //    Map<String, Object> map = JsonUtils.toMap(mapString);
            entity = genD101Entity(map);
            pbocD101Dao.save(entity);
            uuid = entity.getId();
            String msg = beanToXmlConverter.genD101Msg(entity);
            String signCertNo=sysParamsService.getPbocCertNo();
            PbocUtils.saveFile(msg, sysParamsService.getPersonalSendPath(), entity.getId() + "_send.msg");
            LOGGER.info("发送请求报文为----------------------" + msg);
            String signedTextB64 = HuaTengUtils.getSignResult(msg,signCertNo);
            StringBuffer sb=new StringBuffer();
            sb.append("{").append("S:").append(signedTextB64).append("}").append("\r\n");
            LOGGER.info("数字签名域发送的请求报文为----------------------" + msg.trim()+sb.toString());
            String result=wsdlClient.queryPersonal(msg.trim()+sb.toString());
        //    String result= testReadFile.readJsonData("D:\\eclipseWorkspace\\IBSCORE\\src\\basic\\resource\\personal\\result.txt");
            PbocUtils.saveFile(msg, sysParamsService.getPersonalRecvPath(), entity.getId() + "_recv.msg");
            LOGGER.info("返回webservice----------------------" + result);
            queryResult = parseD102Xml(uuid, result);

            entity.setStatus("03");
            entity.setRespTime(DateUtils.get14Time());
            pbocD101Dao.update(entity);

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
                    pbocD101Dao.update(entity);
                }
            } catch (Exception e1) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return queryResult;
    }
    
    public CrPbocD101 genD101Entity(Map<String, String> map) throws Exception {
        CrPbocD101 d101 = new CrPbocD101();
        d101.setMsgGenTime(DateUtils.get14Time());
        d101.setMsgRcvCode(sysParamsService.getPbocCode());
        d101.setMsgId(DateUtils.get8Date()+PbocUtils.genPbocMsgId());
        d101.setMsgRsv("00000000");
        d101.setMsgSndCode(sysParamsService.getBankCode());
        d101.setMsgStartFlag("B");
        d101.setMsgType("D101");
        d101.setMsgVersion(sysParamsService.getPersonalVer());

        d101.setQueryOrgCode(sysParamsService.getBankCode());
        d101.setUserCode((String) map.get("tlrno"));
        d101.setPassword(SM3.getHash(sysParamsService.getBankPwd()));

        d101.setOriginateOrgCode(sysParamsService.getBankCode());
        d101.setOriginateUserCode((String) map.get("tlrno"));
        d101.setName((String) map.get("name"));
        d101.setIdType((String) map.get("idType"));
        d101.setIdNum((String) map.get("idNum"));
        d101.setQueryReason((String) map.get("queryReason"));
        d101.setServiceCode((String) map.get("serviceCode"));
        d101.setRsv7((String) map.get("ip"));
        d101.setQueryDate(DateUtils.get8Date());
        d101.setCreateUser((String) map.get("tlrno"));
        d101.setCreateTime(DateUtils.get14Time());
        d101.setSendTime(DateUtils.get14Time());
        d101.setStatus("00");

        return d101;
    }

}
