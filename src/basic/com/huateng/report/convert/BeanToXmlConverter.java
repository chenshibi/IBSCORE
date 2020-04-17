package com.huateng.report.convert;

import java.io.StringWriter;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.report.convert.bean.BizHead;
import com.huateng.report.convert.bean.FileBizHead;
import com.huateng.report.pboc.util.DevUtils;

import resource.bean.crms.CrPbocD101;
import resource.bean.crms.CrPbocD103;
import resource.bean.crms.CrPbocD501;
import resource.bean.crms.CrPbocD503;
import resource.bean.crms.CrPbocL101;
import resource.bean.crms.CrPbocR103;


/**
 * 实体转XML通用类
 * @author YiSiliang
 * @date 2019/1/2 22:02
 */
@Service
public class BeanToXmlConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanToXmlConverter.class);
    /*
     * 个人单笔请求报文头
     * @param d101Entity CrPbocD101Entity
     * @return  BizHead
     */
    private BizHead genD101BizHead(CrPbocD101 d101Entity) {
        BizHead d101BizHead = new BizHead();
        d101BizHead.setStartFlag(d101Entity.getMsgStartFlag());
        d101BizHead.setVersion(d101Entity.getMsgVersion());
        d101BizHead.setSendCode(d101Entity.getMsgSndCode());
        d101BizHead.setRecvCode(d101Entity.getMsgRcvCode());
        d101BizHead.setGenTime(d101Entity.getMsgGenTime());
        d101BizHead.setMsgType(d101Entity.getMsgType());
        d101BizHead.setMsgId(d101Entity.getMsgId());
        d101BizHead.setRsv(d101Entity.getMsgRsv());
        return d101BizHead;
    }
    
    
    /*
     * 修改密码请求
     * @param d101Entity CrPbocL101
     * @return  BizHead
     */
    private BizHead genL101BizHead(CrPbocL101 d101Entity) {
        BizHead d101BizHead = new BizHead();
        d101BizHead.setStartFlag(d101Entity.getMsgStartFlag());
        d101BizHead.setVersion(d101Entity.getMsgVersion());
        d101BizHead.setSendCode(d101Entity.getMsgSndCode());
        d101BizHead.setRecvCode(d101Entity.getMsgRcvCode());
        d101BizHead.setGenTime(d101Entity.getMsgGenTime());
        d101BizHead.setMsgType(d101Entity.getMsgType());
        d101BizHead.setMsgId(d101Entity.getMsgId());
        d101BizHead.setRsv(d101Entity.getMsgRsv());
        return d101BizHead;
    }

    /*
     * 个人批量查询请求报文头
     * @param CrPbocD501Entity d501Entity
     * @return  FileBizHead
     */
    private FileBizHead genD501BizHead(CrPbocD501 d501Entity) {
        FileBizHead d501BizHead = new FileBizHead();
        d501BizHead.setFileStartFlag(d501Entity.getFileStartFlag());
        d501BizHead.setFileVersion(d501Entity.getFileVersion());
        d501BizHead.setFileQryCode(d501Entity.getFileQryCode());
        d501BizHead.setFileGenTime(d501Entity.getFileGenTime());
        d501BizHead.setFileType(d501Entity.getFileType());
        d501BizHead.setRecordQryNum(d501Entity.getRecordQryNum());
        d501BizHead.setFileRsv(d501Entity.getFileRsv());
        return d501BizHead;
    }

    /*
     * 企业批量查询请求报文头
     * @param CrPbocD501Entity d501Entity
     * @return  FileBizHead
     */
    private FileBizHead genD503BizHead(CrPbocD503 d503Entity) {
        FileBizHead d503BizHead = new FileBizHead();
        d503BizHead.setFileStartFlag(d503Entity.getFileStartFlag());
        d503BizHead.setFileVersion(d503Entity.getFileVersion());
        d503BizHead.setFileQryCode(d503Entity.getFileQryCode());
        d503BizHead.setFileGenTime(d503Entity.getFileGenTime());
        d503BizHead.setFileType(d503Entity.getFileType());
        d503BizHead.setRecordQryNum(d503Entity.getRecordQryNum());
        d503BizHead.setFileRsv(d503Entity.getFileRsv());
        return d503BizHead;
    }


    /*
     * 企业单笔请求报文头
     * @param  d103Entity CrPbocD103Entity
     * @return BizHead
     */
    private BizHead genD103BizHead(CrPbocD103 d103Entity){
        BizHead d103BizHead = new BizHead();
        d103BizHead.setStartFlag(d103Entity.getMsgStartFlag());
        d103BizHead.setVersion(d103Entity.getMsgVersion());
        d103BizHead.setSendCode(d103Entity.getMsgSndCode());
        d103BizHead.setRecvCode(d103Entity.getMsgRcvCode());
        d103BizHead.setGenTime(d103Entity.getMsgGenTime());
        d103BizHead.setMsgType(d103Entity.getMsgType());
        d103BizHead.setMsgId(d103Entity.getMsgId());
        d103BizHead.setRsv(d103Entity.getMsgRsv());
        return d103BizHead;
    }
    
    
    /*
     * 企业抵押物请求报文头
     * @param  d103Entity CrPbocD103Entity
     * @return BizHead
     */
    private BizHead genR103BizHead(CrPbocR103 r103Entity){
        BizHead d103BizHead = new BizHead();
        d103BizHead.setStartFlag(r103Entity.getMsgStartFlag());
        d103BizHead.setVersion(r103Entity.getMsgVersion());
        d103BizHead.setSendCode(r103Entity.getMsgSndCode());
        d103BizHead.setRecvCode(r103Entity.getMsgRcvCode());
        d103BizHead.setGenTime(r103Entity.getMsgGenTime());
        d103BizHead.setMsgType(r103Entity.getMsgType());
        d103BizHead.setMsgId(r103Entity.getMsgId());
        d103BizHead.setRsv(r103Entity.getMsgRsv());
        return d103BizHead;
    }



    /**
     * 截取报文头
     * @param bizHead BizHead
     * @return String
     */
    private String genBizHeadString(BizHead bizHead) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(StringUtils.substring(bizHead.getStartFlag(), 0, 1));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getVersion()), 0, 5), 5, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getSendCode()), 0, 14), 14, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getRecvCode()), 0, 14), 14, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getGenTime()), 0, 14), 14, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getMsgType()), 0, 4), 4, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getMsgId()), 0, 16), 16, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getRsv()), 0, 10), 10, '0'));
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }

    /**
     * 截取报文头
     * @param bizHead BizHead
     * @return String
     */
    private String genBatchBizHeadString(FileBizHead bizHead) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(StringUtils.substring(bizHead.getFileStartFlag(), 0, 1));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getFileVersion()), 0, 5), 5, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getFileQryCode()), 0, 14), 14, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getFileGenTime()), 0, 14), 14, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getFileType()), 0, 4), 4, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getRecordQryNum().toString()), 0, 5), 5, ' '));
        stringBuffer.append(StringUtils.rightPad(StringUtils.substring(StringUtils.trimToEmpty(bizHead.getFileRsv()), 0, 7), 7, '0'));
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }

    /**
     * 获取个人单笔请求报文
     * @param entity  CrPbocD101Entity
     * @return String
     * @throws Exception
     */
    private String genD101BizXmlString(CrPbocD101 entity) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element element = null;

        Element root = document.addElement("Document");

        Element head = root.addElement("Head");
        element = head.addElement("QueryOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getQueryOrgCode()));
        element = head.addElement("UserCode");
        element.setText(StringUtils.trimToEmpty(entity.getUserCode()));
        element = head.addElement("Password");
        element.setText(StringUtils.trimToEmpty(entity.getPassword()));

        Element msg = root.addElement("Msg");
        element = msg.addElement("OriginateOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateOrgCode()));
        element = msg.addElement("OriginateUserCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateUserCode()));
        element = msg.addElement("Name");
        element.setText(StringUtils.trimToEmpty(entity.getName()));
        element = msg.addElement("IDType");
        element.setText(StringUtils.trimToEmpty(entity.getIdType()));
        element = msg.addElement("IDNum");
        element.setText(StringUtils.trimToEmpty(entity.getIdNum()));
        element = msg.addElement("QueryReason");
        element.setText(StringUtils.trimToEmpty(entity.getQueryReason()));
        element = msg.addElement("ServiceCode");
        element.setText(StringUtils.trimToEmpty(entity.getServiceCode()));

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        format.setIndent("  ");
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }

    /**
     * 获取修改密码请求报文
     * @param entity  CrPbocL101
     * @return String
     * @throws Exception
     */
    private String genL101BizXmlString(CrPbocL101 entity) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element element = null;

        Element root = document.addElement("Document");

        Element head = root.addElement("Head");
        element = head.addElement("QueryOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getQueryOrgCode()));
        element = head.addElement("UserCode");
        element.setText(StringUtils.trimToEmpty(entity.getUserCode()));
        element = head.addElement("Password");
        element.setText(StringUtils.trimToEmpty(entity.getPassword()));

        Element msg = root.addElement("Msg");
        element = msg.addElement("UserCode");
        element.setText(StringUtils.trimToEmpty(entity.getUserCode()));
        element = msg.addElement("OPassword");
        element.setText(StringUtils.trimToEmpty(entity.getOriginalPassword()));
        element = msg.addElement("NPassword");
        element.setText(StringUtils.trimToEmpty(entity.getNewPassword()));
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        format.setIndent("  ");
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }
    
    /**
     * 获取企业单笔请求报文
     * @param entity  CrPbocD101Entity
     * @return String
     * @throws Exception
     */
    private String genD103BizXmlString(CrPbocD103 entity) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element element = null;
        Element root = document.addElement("Document");
        Element head = root.addElement("Head");
        element = head.addElement("QueryOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getQueryOrgCode()));
        element = head.addElement("UserCode");
        element.setText(StringUtils.trimToEmpty(entity.getUserCode()));
        element = head.addElement("Password");
        element.setText(StringUtils.trimToEmpty(entity.getPassword()));
        Element msg = root.addElement("Msg");
        element = msg.addElement("OriginateOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateOrgCode()));
        element = msg.addElement("OriginateUserCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateUserCode()));
        element = msg.addElement("EntName");
        element.setText(StringUtils.trimToEmpty(DevUtils.TransferSpecial(entity.getEntName())));
        element = msg.addElement("EntCertType");
        element.setText(StringUtils.trimToEmpty(entity.getEntCertType()));
        element = msg.addElement("EntCertNum");
        element.setText(StringUtils.trimToEmpty(entity.getEntCertNum()));
        element = msg.addElement("QueryReason");
        element.setText(StringUtils.trimToEmpty(entity.getQueryReason()));
        element = msg.addElement("ServiceCode");
        element.setText(StringUtils.trimToEmpty(entity.getServiceCode()));
    //    OutputFormat format = OutputFormat.createCompactFormat();
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
     //   format.setIndent(" ");
        format.setNewLineAfterDeclaration(false);
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.setEscapeText(false);
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }
    
    
    /**
     * 获取企业单笔请求报文
     * @param entity  CrPbocD101Entity
     * @return String
     * @throws Exception
     */
    private String genR103BizXmlString(CrPbocR103 entity) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element element = null;

        Element root = document.addElement("Document");

        Element head = root.addElement("Head");
        element = head.addElement("QueryOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getQueryOrgCode()));
        element = head.addElement("UserCode");
        element.setText(StringUtils.trimToEmpty(entity.getUserCode()));
        element = head.addElement("Password");
        element.setText(StringUtils.trimToEmpty(entity.getPassword()));

        Element msg = root.addElement("Msg");
        element = msg.addElement("OriginateOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateOrgCode()));
        element = msg.addElement("OriginateUserCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateUserCode()));
        element = msg.addElement("EntName");
        element.setText(StringUtils.trimToEmpty(entity.getEntName()));
        element = msg.addElement("EntCertType");
        element.setText(StringUtils.trimToEmpty(entity.getEntCertType()));
        element = msg.addElement("EntCertNum");
        element.setText(StringUtils.trimToEmpty(entity.getEntCertNum()));
        element = msg.addElement("QueryReason");
        element.setText(StringUtils.trimToEmpty(entity.getQueryReason()));
        element = msg.addElement("ServiceCode");
        element.setText(StringUtils.trimToEmpty(entity.getServiceCode()));

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        format.setIndent("  ");
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }
    
    
    private String getD103BizXmlString(CrPbocD103 entity) throws Exception {
    	StringBuffer str=new StringBuffer();
    	str.append("&#xD;&#xA;&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;&lt;Document&gt;&lt;Head&gt;&lt;QueryOrgCode&gt;")
    	.append(StringUtils.trimToEmpty(entity.getQueryOrgCode())).append("&lt;/QueryOrgCode&gt;&lt;").append("UserCode&gt;").append(StringUtils.trimToEmpty(entity.getOriginateUserCode()))
    	.append("&lt;/UserCode&gt;&lt;").append("Password&gt;").append(StringUtils.trimToEmpty(entity.getPassword())).append("&lt;/Password&gt;&lt;")
    	.append("/Head&gt;&lt;").append("Msg&gt;&lt;").append("OriginateOrgCode&gt;").append(StringUtils.trimToEmpty(entity.getOriginateOrgCode()))
    	.append("&lt;/OriginateOrgCode&gt;&lt;").append("OriginateUserCode&gt;").append(StringUtils.trimToEmpty(entity.getOriginateUserCode()))
    	.append("&lt;/OriginateUserCode&gt;&lt;").append("EntName&gt;").append(StringUtils.trimToEmpty(entity.getEntName()))
    	.append("&lt;/EntName&gt;&lt;").append("EntCertType&gt;")
    	.append(StringUtils.trimToEmpty(entity.getEntCertType())).append("&lt;/EntCertType&gt;&lt;")
    	.append("EntCertNum&gt;").append(StringUtils.trimToEmpty(entity.getEntCertNum()))
    	.append("&lt;/EntCertNum&gt;&lt;")
    	.append("QueryReason&gt;").append(StringUtils.trimToEmpty(entity.getQueryReason()))
        .append("&lt;/QueryReason&gt;&lt;").append("ServiceCode&gt;").append(StringUtils.trimToEmpty(entity.getServiceCode()))
        .append("&lt;/ServiceCode")
        .append("&gt;&lt;/Msg&gt;&lt;/Document&gt;");
    	return str.toString();
    }
    
    
    
    

    /**
     * 生成个人批量请求报文头
     * @param entity  CrPbocD501Entity
     * @return String
     * @throws Exception
     */
    private String genD501BizXmlString(CrPbocD501 entity) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element element = null;

        Element root = document.addElement("Document");

        Element msg = root.addElement("Msg");
        element = msg.addElement("RequestId");
        element.setText(StringUtils.trimToEmpty(entity.getRequestid().toString()));
        element = msg.addElement("OriginateOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateOrgCode()));
        element = msg.addElement("OriginateUserCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateUserCode()));
        element = msg.addElement("Name");
        element.setText(StringUtils.trimToEmpty(entity.getName()));
        element = msg.addElement("IDType");
        element.setText(StringUtils.trimToEmpty(entity.getIdType()));
        element = msg.addElement("IDNum");
        element.setText(StringUtils.trimToEmpty(entity.getIdNum()));
        element = msg.addElement("QueryReason");
        element.setText(StringUtils.trimToEmpty(entity.getQueryReason()));
        element = msg.addElement("ServiceCode");
        element.setText(StringUtils.trimToEmpty(entity.getServiceCode()));

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        format.setIndent("  ");
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }

    /**
     *  生成企业批量请求报文头
     * @param entity  CrPbocD503Entity
     * @return String
     * @throws Exception
     */
    private String genD503BizXmlString(CrPbocD503 entity) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element element = null;

        Element root = document.addElement("Document");
        Element msg = root.addElement("Msg");
        element = msg.addElement("RequestId");
        element.setText(StringUtils.trimToEmpty(entity.getRequestid().toString()));
        element = msg.addElement("OriginateOrgCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateOrgCode()));
        element = msg.addElement("OriginateUserCode");
        element.setText(StringUtils.trimToEmpty(entity.getOriginateUserCode()));
        element = msg.addElement("EntName");
        element.setText(StringUtils.trimToEmpty(entity.getEntName()));
        element = msg.addElement("EntCertType");
        element.setText(StringUtils.trimToEmpty(entity.getEntCertType()));
        element = msg.addElement("EntCertNum");
        element.setText(StringUtils.trimToEmpty(entity.getEntCertNum()));
        element = msg.addElement("QueryReason");
        element.setText(StringUtils.trimToEmpty(entity.getQueryReason()));
        element = msg.addElement("ServiceCode");
        element.setText(StringUtils.trimToEmpty(entity.getServiceCode()));

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        format.setIndent("  ");
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }



    /**
     * 获取个人单笔请求信息
     * @param d101Entity CrPbocD101Entity
     * @return  String
     * @throws Exception
     */
    public String genD101Msg(CrPbocD101 d101Entity) throws Exception {
        BizHead bizHead = genD101BizHead(d101Entity);
        String bizHeadString = genBizHeadString(bizHead);
        String bizXmlString = genD101BizXmlString(d101Entity);
        return bizHeadString+bizXmlString;
    }

    

    /**
     * 获取密码修改请求信息
     * @param d101Entity CrPbocD101Entity
     * @return  String
     * @throws Exception
     */
    public String genL101Msg(CrPbocL101 d101Entity) throws Exception {
        BizHead bizHead = genL101BizHead(d101Entity);
        String bizHeadString = genBizHeadString(bizHead);
        String bizXmlString = genL101BizXmlString(d101Entity);
        return bizHeadString+bizXmlString;
    }

    /**
     * 获取企业单笔请求信息
     * @param d103Entity CrPbocD101Entity
     * @return  String
     * @throws Exception
     */
    public String genD103Msg(CrPbocD103 d103Entity) throws Exception {
        BizHead bizHead = genD103BizHead(d103Entity);
        String bizHeadString = genBizHeadString(bizHead);
       // String bizXmlString =  getD103BizXmlString(d103Entity);
        String bizXmlString = genD103BizXmlString(d103Entity);
        return bizHeadString+bizXmlString;
    }
    
    /**
     * 获取企业相关还款责任人及抵押物请求信息
     * @param r103Entity CrPbocR103
     * @return  String
     * @throws Exception
     */
    public String genR103Msg(CrPbocR103 r103Entity) throws Exception {
        BizHead bizHead = genR103BizHead(r103Entity);
        String bizHeadString = genBizHeadString(bizHead); 
        String bizXmlString = genR103BizXmlString(r103Entity);
        return bizHeadString+bizXmlString;
    }

    /**
     * 获取个人单笔请求信息
     * @param d501Entity CrPbocD101Entity
     * @return  String
     * @throws Exception
     */
    public String genD501Msg(CrPbocD501 d501Entity) throws Exception {
        FileBizHead bizHead = genD501BizHead(d501Entity);
        String bizHeadString = genBatchBizHeadString(bizHead);
        String bizXmlString = genD501BizXmlString(d501Entity);
        LOGGER.info("获取个人批量请求报文为======="+bizHeadString+bizXmlString);
        return bizHeadString+bizXmlString;
    }

    /**
     * 获取企业批量请求报文
     * @param d503Entity CrPbocD503Entity
     * @return  String
     * @throws Exception
     */
    public String genD503Msg(CrPbocD503 d503Entity) throws Exception {
        FileBizHead bizHead = genD503BizHead(d503Entity);
        String bizHeadString = genBatchBizHeadString(bizHead);
        String bizXmlString = genD503BizXmlString(d503Entity);
        LOGGER.info("获取企业批量请求报文为======="+bizHeadString+bizXmlString);
        return bizHeadString+bizXmlString;
    }


    private BizHead parseHead(String headStr) {
        BizHead bizHead = new BizHead();
        bizHead.setStartFlag(StringUtils.substring(headStr, 0, 1));
        bizHead.setVersion(StringUtils.substring(headStr, 1, 6));
        bizHead.setSendCode(StringUtils.substring(headStr, 6, 20));
        bizHead.setRecvCode(StringUtils.substring(headStr, 20, 34));
        bizHead.setGenTime(StringUtils.substring(headStr, 34, 48));
        bizHead.setMsgType(StringUtils.substring(headStr, 48, 52));
        bizHead.setMsgId(StringUtils.substring(headStr, 52, 68));
        bizHead.setRsv(StringUtils.substring(headStr, 68, 78));
        return bizHead;
    }

    /**
     * 处理XML报文头
     * @param querymessage
     * @return  String
     * @throws Exception
     */
    public String convertCorp(String querymessage) throws Exception {
        String headStr = querymessage.substring(0, 80);
        BizHead bizHead = parseHead(headStr);
        String xmlStr = StringUtils.substring(querymessage, 80);
        int pos = StringUtils.indexOf(xmlStr, "</Document>") + "</Document>".length();
        xmlStr = StringUtils.substring(xmlStr, 0, pos);
        return xmlStr;
    }

}
