package com.huateng.report.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.dao.basic.SysParamsDAO;

/**
 * @author YiSiliang
 * @date 2019/1/4 14:38
 */
@Service
public class NewSysParamsService {
    @Autowired
    private SysParamsDAO sysParamsDao;
    
   /* public synchronized static NewSysParamsService getInstance() {
        return (NewSysParamsService) ApplicationContextUtils.getBean(NewSysParamsService.class.getName());
    }*/
    
    public static NewSysParamsService getInstance() {
        return ApplicationContextUtils.getBean(NewSysParamsService.class);
    }

    public String getParaValue(String groupId, String paramId) {
    	SysParams params= null;
		try {
			params = sysParamsDao.findById(new SysParamsPK(groupId, paramId));
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (params != null) {
            return StringUtils.trimToEmpty(params.getParamVal());
        } else {
            return null;
        }
    }
    
    public String gerProxyIp() {
    	return getParaValue("PROXY", "PROXY_IP");
    }
    
    public String gerProxyHost() {
    	return getParaValue("PROXY", "PROXY_HOST");
    }

    public String getCorpWsUrl() {
        return getParaValue("PBOC", "CORP_URL");
    }

    public String getPersonalWsUrl() {
        return getParaValue("PBOC", "PERSON_URL");
    }

    public String getBatchPersonalWsUrl(){
        return getParaValue("PBOC", "BATCH_PERSON_URL");
    }

    public String getBatchCorpWsUrl(){
        return getParaValue("CORP", "BATCH_CORP_URL");
    }

    public String getPwdSendPath() {
    	return getParaValue("PWD", "SEND_PATH");
    }
    
    public String getUpdatePwdUrl() {
    	return getParaValue("PWD", "PWD_URL");
    }
    
    public String getPwdRecvPath() {
    	return getParaValue("PWD", "RECV_PATH");
    }
    
    public String getPbocCode() {
        return getParaValue("PBOC", "CODE");
    }

    public String getCorpVer() {
        return getParaValue("PBOC", "CORP_VER");
    }

    public String getPersonalVer() {
        return getParaValue("PBOC", "PERSON_VER");
    }

    public String getBatchPersonalVer(){
        return getParaValue("PBOC", "BATCH_PERSON_VER");
    }

    public String getBatchCorpVer(){
        return getParaValue("CORP", "BATCH_CORP_VER");
    }

    public String getBankCode() {
        return getParaValue("BANK", "CODE");
    }


    public String getBankUser() {
        return getParaValue("BANK", "USER");
    }

    public String getBankPwd() {
        return getParaValue("BANK", "PWD");
    }

    public String getPersonalSendPath() {
        return getParaValue("PERSONAL", "SEND_PATH");
    }

    public String getPersonalRecvPath() {
        return getParaValue("PERSONAL", "RECV_PATH");
    }

    public String getCorpSendPath() {
        return getParaValue("CORP", "SEND_PATH");
    }
    
    public String getCollateralSendPath() {
        return getParaValue("Collateral", "SEND_PATH");
    }

    public String getCorpRecvPath() {
        return getParaValue("CORP", "RECV_PATH");
    }
    
    public String getCollateralRecvPath() {
        return getParaValue("Collateral", "RECV_PATH");
    }

    public String getBatchPersonalSendPath(){
        return getParaValue("PERSONAL","SEND_BATCH_PATH");
    }

    public String getBatchPersonalRecvPath(){
        return getParaValue("PERSONAL","SEND_BATCH_PATH");
    }

    public String getBatchCorpRecvPath(){
        return getParaValue("CORP","RECV_BATCH_PATH");
    }

    public String getBatchCorpSendPath(){
        return getParaValue("CORP","SEND_BATCH_PATH");
    }
    
    public String getPbocCertNo(){
    	return getParaValue("PBOC","SIGN_CERT");
    }
}
