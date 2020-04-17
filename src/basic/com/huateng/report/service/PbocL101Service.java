package com.huateng.report.service;


import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.bean.ChangePwdForm;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.common.PbocConstants;
import com.huateng.report.convert.BeanToXmlConverter;
import com.huateng.report.dao.CrPbocL101DAO;
import com.huateng.report.dao.CrPbocL102DAO;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.PbocUtils;
import com.huateng.report.utils.SM3;
import com.huateng.report.utils.XmlUtils;
import com.huateng.report.ws.WSDLClientPwd;

import resource.bean.crms.CrPbocL101;
import resource.bean.crms.CrPbocL102;


/**
 * 密码修改接口
 * @author Grassy
 *
 */
@Service
public class PbocL101Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(PbocL101Service.class);
    @Autowired
    private CrPbocL101DAO pbocL101Dao;
    @Autowired
    private CrPbocL102DAO pbocL102Dao;

    @Autowired
    private BeanToXmlConverter beanToXmlConverter;
    
    @Autowired
    private WSDLClientPwd wSDLClientPwd;

    @Autowired
    private NewSysParamsService sysParamsService;
    
    public static PbocL101Service getInstance() {
        return ApplicationContextUtils.getBean(PbocL101Service.class);
    }

    /**
     * 修改密码接口
     *
     * @param msg String
     * @return String
     */
    public QueryResult parseL102Xml(String uuid, String msg) {

        QueryResult queryResult = new QueryResult();
        queryResult.setId(uuid);
        String xmlStr = StringUtils.substring(msg, 78).trim();
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

        CrPbocL102 item = new CrPbocL102();
        try {
        	item.setId(uuid);
        	item.setUserCode(XmlUtils.getValue(document, "/Document/Msg/UserCode"));
        	item.setResultCode(XmlUtils.getValue(document, "/Document/Msg/ResultCode"));
        	item.setResultDesc(XmlUtils.getValue(document, "/Document/Msg/ResultDesc"));
        	item.setReportName(XmlUtils.getValue(document, "/Document/Msg/ModifResultCode"));
        	item.setRecordStatus("03");
        	queryResult.setCode(item.getResultCode());
        	
        } catch (Exception e) {
        	   queryResult.setCode(PbocConstants.QUERY_FAILED_REPORT_XML);
               queryResult.setMsg(e.getMessage());
               item.setRecordStatus("04");
        }
        item.setReceiptTime(DateUtils.get14Time());
        pbocL102Dao.save(item);
        return queryResult;
    }

    public QueryResult updatePassword(ChangePwdForm cpf) {
        String uuid = "";
        QueryResult queryResult = null;
        CrPbocL101 entity = null;
        try {
            entity = genL101Entity(cpf);
            pbocL101Dao.save(entity);
            uuid = entity.getId();
            String msg = beanToXmlConverter.genL101Msg(entity);
            PbocUtils.saveFile(msg, sysParamsService.getPwdSendPath(), entity.getId() + "_send.msg");
            String signCertNo=sysParamsService.getPbocCertNo();
            String signedTextB64 = HuaTengUtils.getSignResult(msg,signCertNo);
            StringBuffer sb=new StringBuffer();
            sb.append(msg).append("{").append("S:").append(signedTextB64).append(":S").append("}");
            String request = sb.toString();
            PbocUtils.saveFile(request, sysParamsService.getPwdSendPath(), entity.getId() + "_send.msg");
            LOGGER.info("数字签名域发送请求报文为----------------------" + request);
            String result = wSDLClientPwd.updatePwd(request);
            PbocUtils.saveFile(msg, sysParamsService.getPwdRecvPath(), entity.getId() + "_recv.msg");
            LOGGER.info("返回webservice----------------------" + result);
            queryResult = parseL102Xml(uuid, result);
            entity.setStatus("03");
            entity.setRespTime(DateUtils.get14Time());
            pbocL101Dao.update(entity);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            queryResult=new QueryResult();
            queryResult.setMsg(e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_WSDL);
            queryResult.setId(uuid);
            try {
                if (entity != null) {
                	entity.setId(uuid);
                    entity.setStatus("04");
                    entity.setRsv9(e.getMessage());
                    entity.setRespTime(DateUtils.get14Time());
                    pbocL101Dao.update(entity);
                }
            } catch (Exception e1) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return queryResult;
    }
    
    public CrPbocL101 genL101Entity(ChangePwdForm cpf) throws Exception {
        CrPbocL101 d101 = new CrPbocL101();
        d101.setMsgGenTime(DateUtils.get14Time());
        d101.setMsgRcvCode(sysParamsService.getPbocCode());
        d101.setMsgId(DateUtils.get8Date()+PbocUtils.genPbocMsgId());
        d101.setMsgRsv("0000000000");
        d101.setMsgSndCode(sysParamsService.getBankCode());
        d101.setMsgStartFlag("B");
        d101.setMsgType("L101");
        d101.setMsgVersion(sysParamsService.getPersonalVer());

        d101.setQueryOrgCode(sysParamsService.getBankCode());
        d101.setUserCode(sysParamsService.getBankUser());
        d101.setPassword(SM3.getHash(sysParamsService.getBankPwd()));

        d101.setUserName(cpf.getTlrno());
        d101.setOriginalPassword((cpf.getOldPassWord()));
        d101.setNewPassword((cpf.getNewPassWord()));
        d101.setIp(GlobalInfo.getCurrentInstance().getIp());
        d101.setCreateUser(cpf.getTlrno());
        d101.setCreateTime(DateUtils.get14Time());
        d101.setSendTime(DateUtils.get14Time());
        d101.setStatus("00");

        return d101;
    }

}
