/*package com.huateng.report.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;

import com.huateng.report.common.PbocConstants;
import com.huateng.report.common.QueryResult;
import com.huateng.report.convert.BeanToXmlConverter;
import com.huateng.report.dao.CrPbocD503Dao;
import com.huateng.report.dao.CrPbocD504Dao;
import com.huateng.report.entity.CrPbocD503Entity;
import com.huateng.report.entity.CrPbocD504Entity;
import com.huateng.report.utils.ApplicationContextUtil;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.JsonUtils;
import com.huateng.report.utils.PbocUtils;
import com.huateng.report.utils.SM3;
import com.huateng.report.utils.XmlUtils;
import com.huateng.report.ws.WSDLClient;

*//**
 * @author Grassy
 * @date 2019/1/7 11:23
 * @jdk.version 1.8
 * @desc 征信企业批量查询
 *//*
@Service
public class PbocD503Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(PbocD103Service.class);

    @Autowired
    private CrPbocD503Dao pbocD503Dao;
    @Autowired
    private BeanToXmlConverter beanToXmlConverter;

    @Autowired
    private WSDLClient wsdlClient;

    @Autowired
    private NewSysParamsService sysParamsService;

    *//**
     * 企业批量查询请求
     *
     * @param arrString String
     * @return QueryResult
     *//*
    public QueryResult queryBatchEnterprise(String arrString) {

        String uuid = "";
        QueryResult queryResult = null;
        CrPbocD503Entity entity = null;
        ArrayList<HashMap<String, Object>> hashMaps = null;
        HashMap<String, Object> paramHashMap = null;
        try {
            hashMaps = JsonUtils.toList(arrString);
            if (!CollectionUtils.isEmpty(hashMaps)) {
                for (int i = 0; i < hashMaps.size(); i++) {
                    paramHashMap = hashMaps.get(i);
                    entity = genD503Entity(paramHashMap);
                    pbocD503Dao.save(entity);
                    uuid = entity.getId();
                    String msg = beanToXmlConverter.genD503Msg(entity);
                    PbocUtils.saveFile(msg, sysParamsService.getBatchCorpSendPath(), entity.getId() + "_send.msg");
                    String result = wsdlClient.queryBatchCorp(msg);
                    PbocUtils.saveFile(msg, sysParamsService.getBatchCorpRecvPath(), entity.getId() + "_recv.msg");
                    LOGGER.info("返回webservice----------------------" + result);
                    queryResult = parseD504Xml(uuid, result);
                    entity.setStatus("01");
                    entity.setRespTime(DateUtils.get14Time());
                    pbocD503Dao.save(entity);
                }

            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            queryResult.setMsg(e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_WSDL);
            queryResult.setId(uuid);
            try {
                if (entity != null) {
                    entity.setStatus("02");
                    entity.setRespTime(DateUtils.get14Time());
                    pbocD503Dao.save(entity);
                }
            } catch (Exception e1) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return queryResult;
    }

    *//**
     * 企业批量查询请求返回
     *
     * @param msg String
     * @return String
     *//*
    public QueryResult parseD504Xml(String uuid, String msg) throws Exception {

        QueryResult queryResult = new QueryResult();
        queryResult.setCode(PbocConstants.QUERY_SUCCESS);
        queryResult.setId(uuid);
        String xmlHead = StringUtils.substring(msg, 0, 75);
        String xmlStr = StringUtils.substring(msg, 75);
        int pos = StringUtils.indexOf(xmlStr, "</Document>") + "</Document>".length();
        xmlStr = StringUtils.substring(xmlStr, 0, pos);

        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
        } catch (DocumentException e) {
            queryResult.setCode(PbocConstants.QUERY_FAILED_MAIN_XML);
            queryResult.setMsg(e.getMessage());
        }

        CrPbocD504Entity item = new CrPbocD504Entity();
        item.setId(uuid);
        item.setFileStartFlag(StringUtils.substring(xmlHead, 0, 1));
        item.setFileVersion(StringUtils.substring(xmlHead, 1, 6));
        item.setOriginalSendFileName(StringUtils.substring(xmlHead, 7, 36));
        item.setfeedBackFlag(StringUtils.substring(xmlHead, 36, 37));
        item.setFileGenTime(StringUtils.substring(xmlHead, 37, 51));
        item.setFileType(StringUtils.substring(xmlHead, 51, 55));
        item.setQrySuccNum(Integer.parseInt(StringUtils.substring(xmlHead, 55, 60)));
        item.setQryFailNum(Integer.parseInt(StringUtils.substring(xmlHead, 60, 65)));
        item.setFileRsv(StringUtils.substring(xmlHead, 65, 73));
        item.setRequestId(Integer.parseInt(XmlUtils.getValue(document, "/Document/Msg/RequestId")));
        item.setOriginateOrgCode(XmlUtils.getValue(document, "/Document/Msg/OriginateOrgCode"));
        item.setOriginateUserCode(XmlUtils.getValue(document, "/Document/Msg/OriginateUserCode"));
        item.setEntName(XmlUtils.getValue(document, "/Document/Msg/EntName"));
        item.setEntCertType(XmlUtils.getValue(document, "/Document/Msg/EntCertType"));
        item.setEntCertNum(XmlUtils.getValue(document, "/Document/Msg/EntCertNum"));
        item.setQueryReason(XmlUtils.getValue(document, "/Document/Msg/QueryReason"));
        item.setServiceCode(XmlUtils.getValue(document, "/Document/Msg/ServiceCode"));

        item.setResultCode(XmlUtils.getValue(document, "/Document/Msg/ResultCode"));
        item.setResultDesc(XmlUtils.getValue(document, "/Document/Msg/ResultDesc"));
        item.setReportName(XmlUtils.getValue(document, "/Document/Msg/ReportName"));
        String base64Msg = XmlUtils.getValue(document, "/Document/Msg/ReportMessage");
        base64Msg = StringUtils.trimToEmpty(base64Msg);
        String reportMsg = "";
        File rptFile = null;
        try {
            reportMsg = new String(Base64Utils.decodeFromString(base64Msg), "UTF-8");
            rptFile = PbocUtils.saveFile(reportMsg, sysParamsService.getCorpRecvPath(), uuid + "_report.xml");
        } catch (Exception e) {
            LOGGER.error("decode base64 failed, base64=[{}], detailMessage = {}", base64Msg, e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_REPORT_BASE64);
            queryResult.setMsg(e.getMessage());
            item.setRecordStatus("02");
        }

        try {
            if (StringUtils.isNotBlank(reportMsg)) {
                XmlUtils.parseCorpReport(reportMsg, uuid);
            }
        } catch (Exception e) {
            LOGGER.error("parse xml failed, report xml=[{}], detailMessage = {}", reportMsg, e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_REPORT_XML);
            queryResult.setMsg(e.getMessage());
            item.setRecordStatus("02");
        }
        item.setRecordStatus("01");
        item.setReceiptTime(DateUtils.get14Time());
        item.setReportMessagePath(rptFile == null ? "" : rptFile.getPath());
        ApplicationContextUtil.getBean(CrPbocD504Dao.class).save(item);
        return queryResult;
    }


    public CrPbocD503Entity genD503Entity(Map<String, Object> map) throws Exception {
        CrPbocD503Entity d503 = new CrPbocD503Entity();
        d503.setFileStartFlag("A");
        d503.setFileVersion(sysParamsService.getBatchCorpVer());
        d503.setFileQryCode("31029000001300");
        d503.setFileGenTime(DateUtils.get14Time());
        d503.setFileType("D503");
        d503.setRecordQryNum(2);
        d503.setFileRsv("0000000");
        ;

        d503.setQueryOrgCode(sysParamsService.getBankCode());
        d503.setUserCode(sysParamsService.getBankUser());
        d503.setPassword(SM3.getHash(sysParamsService.getBankPwd()));

        d503.setRequestId(Integer.parseInt((String)map.get("requestId")));
        d503.setOriginateOrgCode((String) map.get("brno"));
        d503.setOriginateUserCode((String) map.get("tlrno"));
        d503.setEntName((String) map.get("entName"));
        d503.setEntCertType((String) map.get("entCertType"));
        d503.setEntCertNum((String) map.get("entCertNum"));
        d503.setQueryReason((String) map.get("queryReason"));
        d503.setServiceCode((String) map.get("serviceCode"));

        d503.setQueryDate(DateUtils.get8Date());
        d503.setCreateUser((String) map.get("tlrno"));
        d503.setCreateTime(DateUtils.get14Time());
        d503.setStatus("00");

        return d503;
    }

}
*/