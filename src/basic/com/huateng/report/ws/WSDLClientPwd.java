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
/**
 * 
 * @author Grassy
 *
 */
@Service
public class WSDLClientPwd extends WebServiceGatewaySupport {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(WSDLClientPwd.class);
	
	 @Autowired
	 private NewSysParamsService sysParamsService;
	 
	  public static WSDLClientPwd getInstance() {
	        return ApplicationContextUtils.getBean(WSDLClientPwd.class);
	    }

    public WSDLClientPwd() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.huateng.report.ws.pboc_password_service");
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);
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
    

    
    public Properties getProxyMap() {
    	Properties systemProps = System.getProperties();
    	systemProps.put("proxySet", "true");
        systemProps.put("http.proxyHost", sysParamsService.gerProxyIp());
        systemProps.put("http.proxyPort", sysParamsService.gerProxyHost());
		return systemProps;
    }


}
