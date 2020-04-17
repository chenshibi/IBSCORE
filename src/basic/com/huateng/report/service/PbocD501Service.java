package com.huateng.report.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.common.PbocConstants;
import com.huateng.report.common.QueryResult;
import com.huateng.report.convert.BeanToXmlConverter;
import com.huateng.report.dao.CrPbocD501DAO;
import com.huateng.report.dao.CrPbocD502DAO;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.JsonUtils;
import com.huateng.report.utils.PbocUtils;
import com.huateng.report.utils.SM3;
import com.huateng.report.utils.XmlUtils;
import com.huateng.report.ws.WSDLClient;

import resource.bean.crms.CrPbocD501;
import resource.bean.crms.CrPbocD502;


@Service
public class PbocD501Service {

    @Autowired
    private CrPbocD501DAO crPbocD501Dao;
    @Autowired
    private CrPbocD502DAO crPbocD502Dao;

    @Autowired
    private BeanToXmlConverter beanToXmlConverter;

    @Autowired
    private WSDLClient wsdlClient;

    @Autowired
    private NewSysParamsService sysParamsService;
    
    public static PbocD501Service getInstance() {
        return ApplicationContextUtils.getBean(PbocD501Service.class);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(PbocD501Service.class);

    public List<QueryResult> batchQueryPersonal(String arrString) {
        QueryResult queryResult = null;
        List<QueryResult> list=new ArrayList<QueryResult>();
        ArrayList<HashMap<String, Object>> hashMaps = JsonUtils.toList(arrString);
        HashMap<String, Object> paramHashMap = null;
        if (!CollectionUtils.isEmpty(hashMaps)) {
            int pointsDataLimit = 1000;
            Integer size = hashMaps.size();
            if (pointsDataLimit < size) {
                int part = size / pointsDataLimit;
                LOGGER.info("共有 ： " + size + "条，！" + " 分为 ：" + part + "批");
                for (int i = 0; i < part; i++) {
                    List<HashMap<String, Object>> dataList = hashMaps.subList(0, pointsDataLimit);
                    for (int j = 0; j < dataList.size(); j++) {
                        paramHashMap = dataList.get(j);
                        try {
                            queryResult = dealBatchPersonal(paramHashMap);
                            list.add(queryResult);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    hashMaps.subList(0, pointsDataLimit).clear();
                }
                if (!hashMaps.isEmpty()) {
                    for (int i = 0; i < hashMaps.size(); i++) {
                        paramHashMap = hashMaps.get(i);
                        try {
                            queryResult = dealBatchPersonal(paramHashMap);
                            list.add(queryResult);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            } else {
                for (int i = 0; i < size; i++) {
                    paramHashMap = hashMaps.get(i);
                    try {
                        queryResult = dealBatchPersonal(paramHashMap);
                        list.add(queryResult);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            LOGGER.info("没有数据!!!");
        }

        return list;
    }


    public QueryResult dealBatchPersonal(HashMap<String, Object> paramHashMap) throws Exception {
        String uuid = "";
        QueryResult queryResult = null;
        CrPbocD501 entity = null;
        try {
            entity = genD501Entity(paramHashMap);
            crPbocD501Dao.save(entity);
            uuid = entity.getId();
            String msg = beanToXmlConverter.genD501Msg(entity);
            PbocUtils.saveFile(msg, sysParamsService.getBatchPersonalSendPath(), entity.getId() + "_send.msg");
            String result = wsdlClient.queryBatchPersonal(msg);
            PbocUtils.saveFile(msg, sysParamsService.getBatchPersonalRecvPath(), entity.getId() + "_recv.msg");
            LOGGER.info("返回webservice----------------------" + result);
            queryResult = parseD502Xml(uuid, result);
       //     queryResult.setSendId(paramHashMap.get("id").toString());
            entity.setStatus("03");
            entity.setRespTime(DateUtils.get14Time());
            crPbocD501Dao.save(entity);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            queryResult.setMsg(e.getMessage());
            queryResult.setCode(PbocConstants.QUERY_FAILED_WSDL);
            queryResult.setId(uuid);
    //        queryResult.setSendId(paramHashMap.get("id").toString());
            try {
                if (entity != null) {
                    entity.setStatus("04");
                    entity.setRespTime(DateUtils.get14Time());
                    crPbocD501Dao.save(entity);
                }
            } catch (Exception e1) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return queryResult;

    }



    public QueryResult parseD502Xml(String uuid, String msg) throws Exception {

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

        CrPbocD502 item = new CrPbocD502();
        item.setId(uuid);
        item.setFileStartFlag(StringUtils.substring(xmlHead, 0, 1));
        item.setFileVersion(StringUtils.substring(xmlHead, 1, 6));
        item.setOriginalSendFileName(StringUtils.substring(xmlHead, 7, 36));
        item.setFeedbackFlag(StringUtils.substring(xmlHead, 36, 37));
        item.setFileGenTime(StringUtils.substring(xmlHead, 37, 51));
        item.setFileType(StringUtils.substring(xmlHead, 51, 55));
        item.setQrySuccNum(StringUtils.substring(xmlHead, 55, 60));
        item.setQryFailNum(StringUtils.substring(xmlHead, 60, 65));
        item.setFileRsv(StringUtils.substring(xmlHead, 65, 73));
        item.setRequestid(XmlUtils.getValue(document, "/Document/Msg/RequestId"));
        item.setOriginateOrgCode(XmlUtils.getValue(document, "/Document/Msg/OriginateOrgCode"));
        item.setOriginateUserCode(XmlUtils.getValue(document, "/Document/Msg/OriginateUserCode"));
        item.setName(XmlUtils.getValue(document, "/Document/Msg/Name"));
        item.setIdType(XmlUtils.getValue(document, "/Document/Msg/IDType"));
        item.setIdNum(XmlUtils.getValue(document, "/Document/Msg/IDNum"));
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
         //   reportMsg = new String(Base64Utils.decodeFromString(base64Msg), "UTF-8");
            rptFile = PbocUtils.saveFile(reportMsg, sysParamsService.getBatchPersonalRecvPath(), uuid + "_report.xml");
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
        item.setReportMessagePath(rptFile == null ? "" : rptFile.getPath());
        item.setReceiptTime(DateUtils.get14Time());
        item.setRecordStatus("03");
      //  ApplicationContextUtil.getBean(CrPbocD502Dao.class).save(item);
        return queryResult;
    }


    public CrPbocD501 genD501Entity(Map<String, Object> hashMap) throws Exception {
        CrPbocD501 d501 = new CrPbocD501();
        d501.setFileStartFlag("A");
        d501.setFileVersion(sysParamsService.getBatchPersonalVer());
        d501.setFileQryCode("31029000001300");
        d501.setFileGenTime(DateUtils.get14Time());
        d501.setFileType("D501");
        d501.setRecordQryNum("2");
        d501.setFileRsv("0000000");

        d501.setQueryOrgCode(sysParamsService.getBankCode());
        d501.setUserCode(sysParamsService.getBankUser());
        d501.setPassword(SM3.getHash(sysParamsService.getBankPwd()));

        d501.setRequestid(((String) hashMap.get("requestId")));
        d501.setOriginateOrgCode((String) hashMap.get("brno"));
        d501.setOriginateUserCode((String) hashMap.get("tlrno"));

        d501.setName((String) hashMap.get("name"));
        d501.setIdType((String) hashMap.get("idType"));
        d501.setIdNum((String) hashMap.get("idNum"));
        d501.setQueryReason((String) hashMap.get("queryReason"));
        d501.setServiceCode((String) hashMap.get("serviceCode"));

        d501.setQueryDate(DateUtils.get8Date());
        d501.setCreateUser((String) hashMap.get("tlrno"));
        d501.setCreateTime(DateUtils.get14Time());
        d501.setStatus("03");
        return d501;
    }


}
