package com.huateng.report.ws;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.service.NewSysParamsService;
import com.huateng.report.ws.pboc_password_service.PasswordModifReq;
import com.huateng.report.ws.pboc_password_service.PasswordModifReqResponse;
import com.huateng.report.ws.pboc_web_service.BatchBsCreditReportQueryReqRequest;
import com.huateng.report.ws.pboc_web_service.BatchBsCreditReportQueryReqResponse;
import com.huateng.report.ws.pboc_web_service.BatchPsCreditReportQueryReqRequest;
import com.huateng.report.ws.pboc_web_service.BatchPsCreditReportQueryReqResponse;
import com.huateng.report.ws.pboc_web_service.BsCreditReportQueryReq;
import com.huateng.report.ws.pboc_web_service.BsCreditReportQueryReqResponse;
import com.huateng.report.ws.pboc_web_service.BsRlAndMoQueryReq;
import com.huateng.report.ws.pboc_web_service.PsCreditReportQueryReq;
import com.huateng.report.ws.pboc_web_service.PsCreditReportQueryReqResponse;
/**
 * 
 * @author Grassy
 *
 */
@Service
public class WSDLClient extends WebServiceGatewaySupport {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(WSDLClient.class);
	
	 @Autowired
	 private NewSysParamsService sysParamsService;
	 
	  public static WSDLClient getInstance() {
	        return ApplicationContextUtils.getBean(WSDLClient.class);
	    }

    public WSDLClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.huateng.report.ws.pboc_web_service");
    //    this.setDefaultUri("http://9.24.15.100/creditreference/v2/test/channel-query/serviceAccept?wsdl");
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);
    }

    public String queryCorp(String querymessage) {
        BsCreditReportQueryReq request = new BsCreditReportQueryReq();
        request.setQuerymessage(querymessage);
        LOGGER.info("======发往webservice地址为========"+sysParamsService.getCorpWsUrl());
        Properties proxyMap = getProxyMap();
        LOGGER.info("========代理主机与地址为=========="+"set proxy {}:{}", proxyMap.get("http.proxyHost"), proxyMap.get("http.proxyPort"));
        BsCreditReportQueryReqResponse response = (BsCreditReportQueryReqResponse) getWebServiceTemplate().marshalSendAndReceive(sysParamsService.getCorpWsUrl(), request);
        return response.getResult();
    }
    
    public String queryPersonal(String querymessage) {
        PsCreditReportQueryReq request = new PsCreditReportQueryReq();
        request.setQuerymessage(querymessage);
        Properties proxyMap = getProxyMap();
        LOGGER.info("========代理主机与地址为=========="+"set proxy {}:{}", proxyMap.get("http.proxyHost"), proxyMap.get("http.proxyPort"));
        PsCreditReportQueryReqResponse response = (PsCreditReportQueryReqResponse) getWebServiceTemplate().marshalSendAndReceive(
        		sysParamsService.getPersonalWsUrl(), request);
        return response.getResult();
    }

    public String queryBatchPersonal(String querymessage){
        BatchPsCreditReportQueryReqRequest request = new BatchPsCreditReportQueryReqRequest();
        request.setQuerymessage(querymessage);
        Properties proxyMap = getProxyMap();
        LOGGER.info("========代理主机与地址为=========="+"set proxy {}:{}", proxyMap.get("http.proxyHost"), proxyMap.get("http.proxyPort"));
        BatchPsCreditReportQueryReqResponse  response=(BatchPsCreditReportQueryReqResponse)getWebServiceTemplate().marshalSendAndReceive(
        		sysParamsService.getBatchPersonalWsUrl(), request);
        return response.getResult();
    }

    public String queryBatchCorp(String querymessage){
        BatchBsCreditReportQueryReqRequest request = new BatchBsCreditReportQueryReqRequest();
        request.setQuerymessage(querymessage);
        BatchBsCreditReportQueryReqResponse  response=(BatchBsCreditReportQueryReqResponse)getWebServiceTemplate().marshalSendAndReceive(
        		sysParamsService.getBatchCorpWsUrl(), request);
        return response.getResult();
    }
    
    public String updatePwd(String querymessage) {
    	 PasswordModifReq request = new PasswordModifReq();
    	 request.setQuerymessage(querymessage);
    	 Properties proxyMap = getProxyMap();
         LOGGER.info("========代理主机与地址为=========="+"set proxy {}:{}", proxyMap.get("http.proxyHost"), proxyMap.get("http.proxyPort"));
         PasswordModifReqResponse  response=(PasswordModifReqResponse)getWebServiceTemplate().marshalSendAndReceive(
          		sysParamsService.getUpdatePwdUrl(), request);
          return response.getResult();
    }
    
    public String queryCollateral(String querymessage) {
    	BsRlAndMoQueryReq request = new BsRlAndMoQueryReq();
        request.setQuerymessage(querymessage);
        LOGGER.info("======发往webservice地址为========"+sysParamsService.getCorpWsUrl());
        Properties proxyMap = getProxyMap();
        LOGGER.info("========代理主机与地址为=========="+"set proxy {}:{}", proxyMap.get("http.proxyHost"), proxyMap.get("http.proxyPort"));
        BsCreditReportQueryReqResponse response = (BsCreditReportQueryReqResponse) getWebServiceTemplate().marshalSendAndReceive(sysParamsService.getCorpWsUrl(), request);
        return response.getResult();
    }
    
    public Properties getProxyMap() {
    	Properties systemProps = System.getProperties();
    	systemProps.put("proxySet", "true");
        systemProps.put("http.proxyHost", sysParamsService.gerProxyIp());
        systemProps.put("http.proxyPort", sysParamsService.gerProxyHost());
		return systemProps;
    }

}
