package com.huateng.report.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.service.NewSysParamsService;
import com.huateng.report.ws.scb_web_service.IServiceAcceptWSQuery;
import com.huateng.report.ws.scb_web_service.IServiceAcceptWSQuery_Service;

/** 
* @author Grassy 
* @version 创建时间：2020年1月13日 下午2:45:05 
* 类说明 
*/
@Service
public class WsClientRunner {
	 private static final Logger LOGGER = LoggerFactory.getLogger(WsClientRunner.class);
	 
	/* @Autowired
	  private IServiceAcceptWSQuery serviceAcceptWSQuery;*/
	 
	 @Autowired
	 private NewSysParamsService sysParamsService;
	 
	  public static WsClientRunner getInstance() {
	        return ApplicationContextUtils.getBean(WsClientRunner.class);
	    }
	  
	 public String queryCorp(String querymessage) {
		 URL url;
		 String bsCreditReportQueryReq = null;
		 Properties proxyMap = getProxyMap();
		try {
	         LOGGER.info("========代理主机与地址为=========="+"set proxy {}:{}", proxyMap.get("http.proxyHost"), proxyMap.get("http.proxyPort"));
			url = new URL(sysParamsService.getCorpWsUrl());
			IServiceAcceptWSQuery serviceAcceptWSQueryWithUrl = new IServiceAcceptWSQuery_Service(url).getServiceAcceptWSQueryImplPort();
			bsCreditReportQueryReq = serviceAcceptWSQueryWithUrl.bsCreditReportQueryReq(querymessage);
			LOGGER.info("返回的webService信息为========="+bsCreditReportQueryReq);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return bsCreditReportQueryReq;
		 
	//	 String bsCreditReportQueryReq = serviceAcceptWSQuery.bsCreditReportQueryReq(querymessage);
	 }
	 
	   public Properties getProxyMap() {
	    	Properties systemProps = System.getProperties();
	    	systemProps.put("proxySet", "true");
	        systemProps.put("http.proxyHost", sysParamsService.gerProxyIp());
	        systemProps.put("http.proxyPort", sysParamsService.gerProxyHost());
			return systemProps;
	    }
}
