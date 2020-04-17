package com.huateng.report.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.pboc.util.PropertiesUtil;

import cn.com.infosec.netsign.agent.NetSignAgent;

/** 
* @author Grassy 
* @version 创建时间：2019年11月12日 下午5:59:54 
* 类说明 
*/
@Service
public class InitNetSignService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(InitNetSignService.class);
	
	   public static InitNetSignService getInstance() {
	        return ApplicationContextUtils.getBean(InitNetSignService.class);
	    }
	   
	static{
		try{
			LOGGER.info("===========初始化签名服务器开始=========");
			NetSignAgent.initialize(PropertiesUtil.getNetsafeUrl());
			LOGGER.info("===========初始化签名服务器结束=========");
		}catch( Exception e ){
			e.printStackTrace();
		}
	}
}
