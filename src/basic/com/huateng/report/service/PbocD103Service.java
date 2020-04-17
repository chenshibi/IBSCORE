package com.huateng.report.service;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.convert.BeanToXmlConverter;
import com.huateng.report.dao.CrPbocD103DAO;
import com.huateng.report.dao.CrPbocD104DAO;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.GZIPUtils;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.PbocUtils;
import com.huateng.report.utils.SM3;
import com.huateng.report.utils.XmlUtils;
import com.huateng.report.ws.WsClientRunner;

import resource.bean.crms.CrPbocD103;
import resource.bean.crms.CrPbocD104;
/**
 * 
 * @author Grassy
 *
 */
@Service
public class PbocD103Service
{
  private static final Logger LOGGER = LoggerFactory.getLogger(PbocD103Service.class);

  @Autowired
  private CrPbocD104DAO pbocD104Dao;

  @Autowired
  private CrPbocD103DAO pbocD103Dao;

  @Autowired
  private BeanToXmlConverter beanToXmlConverter;

  @Autowired
  private WsClientRunner webservice;

  @Autowired
  private NewSysParamsService sysParamsService;

  public static PbocD103Service getInstance() { return (PbocD103Service)ApplicationContextUtils.getBean(PbocD103Service.class);
  }

  public QueryResult queryEnterprise(Map<String, String> requestMap)
  {
    String uuid = "";
    QueryResult queryResult = null;
    CrPbocD103 entity = null;
    try {
      entity = genD103Entity(requestMap);
      this.pbocD103Dao.save(entity);
      uuid = entity.getId();
      String msg = this.beanToXmlConverter.genD103Msg(entity);
      String signCertNo = this.sysParamsService.getPbocCertNo();
      LOGGER.info("送往数字签名服务器的证书号为----------------------" + signCertNo);
      String signedTextB64 = HuaTengUtils.getSignResult(msg, signCertNo);
      StringBuffer sb = new StringBuffer();
      sb.append(msg).append("{").append("S:").append(signedTextB64).append(":S").append("}");
      String request = sb.toString();
      PbocUtils.saveFile(request, this.sysParamsService.getCorpSendPath(), entity.getId() + "_send.msg");
      LOGGER.info("数字签名域发往人行的请求报文为----------------------" + request);
      String result = this.webservice.queryCorp(request);
      LOGGER.info("返回webservice----------------------" + result);
      PbocUtils.saveFile(result, this.sysParamsService.getCorpRecvPath(), entity.getId() + "_recv.msg");
      queryResult = parseD104Xml(uuid, result);
      entity.setStatus("03");
      entity.setRespTime(DateUtils.get14Time());
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      queryResult = new QueryResult();
      queryResult.setMsg(e.getMessage());
      queryResult.setCode("0003");
      queryResult.setId(uuid);
      try {
        if (entity != null) {
          entity.setStatus("04");
          entity.setRsv10(e.getMessage());
          entity.setRespTime(DateUtils.get14Time());
          this.pbocD103Dao.update(entity);
        }
      } catch (Exception e1) {
        LOGGER.error(e.getMessage(), e);
      }
    }
    return queryResult;
  }

  public QueryResult parseD104Xml(String uuid, String msg)
    throws Exception
  {
    QueryResult queryResult = new QueryResult();
    queryResult.setCode("0000");
    queryResult.setId(uuid);
    String xmlStr = StringUtils.substring(msg, 78).trim();

    xmlStr.replaceAll("&#xD;&#xA;", "");
    Document document = null;
    try {
      document = DocumentHelper.parseText(xmlStr);
    } catch (DocumentException e) {
      queryResult.setCode("0001");
      queryResult.setMsg(e.getMessage());
    }

    CrPbocD104 item = new CrPbocD104();
    item.setId(uuid);
    item.setResultCode(XmlUtils.getValue(document, "/Document/Msg/ResultCode"));
    item.setResultDesc(XmlUtils.getValue(document, "/Document/Msg/ResultDesc"));
    item.setReportName(XmlUtils.getValue(document, "/Document/Msg/ReportName"));
    item.setRecordStatus("03");
    String base64Msg = XmlUtils.getValue(document, "/Document/Msg/ReportMessage");
    String reportMsg = "";
    File rptFile = null;
    try {
      if (StringUtils.isNoneBlank(new CharSequence[] { base64Msg }))
        reportMsg = GZIPUtils.DecompressToBase64(base64Msg);
      else {
        queryResult.setCode("00005");
      }

      rptFile = PbocUtils.saveFile(reportMsg, this.sysParamsService.getCorpRecvPath(), uuid + "_report.xml");
    } catch (Exception e) {
      LOGGER.error("decode base64 failed, base64=[{}], detailMessage = {}", base64Msg, e.getMessage());
      queryResult.setCode("0004");
      queryResult.setMsg(e.getMessage());
      item.setRecordStatus("04");
    }
    try
    {
      if (StringUtils.isNotBlank(reportMsg))
        XmlUtils.parseCorpReport(reportMsg, uuid);
    }
    catch (Exception e) {
      LOGGER.error("parse xml failed, report xml=[{}], detailMessage = {}", reportMsg, e.getMessage());
      queryResult.setCode("0002");
      queryResult.setMsg(e.getMessage());
      item.setRecordStatus("04");
    }
    item.setReceiptTime(DateUtils.get14Time());
    item.setReportMessagePath(rptFile == null ? "" : rptFile.getPath());
    this.pbocD104Dao.save(item);
    return queryResult;
  }

  public CrPbocD103 genD103Entity(Map<String, String> map) throws Exception {
    CrPbocD103 d103 = new CrPbocD103();
    d103.setMsgGenTime(DateUtils.get14Time());
    d103.setMsgRcvCode(this.sysParamsService.getPbocCode());
    d103.setMsgId(DateUtils.get8Date() + PbocUtils.genPbocMsgId());
    d103.setMsgRsv("0000000000");
    d103.setMsgSndCode(this.sysParamsService.getBankCode());
    d103.setMsgStartFlag("B");
    d103.setMsgType("D103");
    d103.setMsgVersion(this.sysParamsService.getCorpVer());

    d103.setQueryOrgCode(this.sysParamsService.getBankCode());
    d103.setUserCode(this.sysParamsService.getBankUser());
    String pwd = this.sysParamsService.getBankPwd();
    d103.setPassword(SM3.getHash(pwd));

    d103.setOriginateOrgCode(this.sysParamsService.getBankCode());

    d103.setOriginateUserCode(this.sysParamsService.getBankUser());
    d103.setEntName((String)map.get("entName"));
    d103.setEntCertType((String)map.get("entCertType"));
    d103.setEntCertNum((String)map.get("entCertNum"));
    d103.setQueryReason((String)map.get("queryReason"));
    d103.setServiceCode("FW_QYXYBG_0043");

    d103.setQueryDate(DateUtils.get8Date());
    d103.setCreateUser((String)map.get("tlrno"));
    d103.setCreateTime(DateUtils.get14Time());
    d103.setStatus("00");

    return d103;
  }

  public static String replaceBlank(String str) {
    String dest = "";
    if (str != null) {
      Pattern p = Pattern.compile("\\s*|\t|\r|\n");
      Matcher m = p.matcher(str);
      dest = m.replaceAll("");
    }
    return dest;
  }
}