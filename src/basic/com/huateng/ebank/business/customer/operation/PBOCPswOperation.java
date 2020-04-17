package com.huateng.ebank.business.customer.operation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.basic.SysParams;
import resource.bean.basic.TlrPbocUser;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.customer.getter.PersonalReportBean;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.Base64Util;
import com.huateng.service.pub.PasswordService;

public class PBOCPswOperation extends BaseOperation{
	private static final HtLog htlog = HtLogFactory
			.getLogger(PBOCPswOperation.class);
	public static final String ID = "customer.PBOCPswOperation";
	public static final String CMD = "CMD";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_OPERATION = "IN_OPERATION";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	
	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
		List<TlrPbocUser> tlrPbocUserList = (List) context.getAttribute(IN_PARAM);
		BusinessUploadService service = new BusinessUploadService();
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date nowDay = new Date();
	//	String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");
		for (int i = 0; i < tlrPbocUserList.size(); i++) {
			String userNo = tlrPbocUserList.get(i).getUserNo();
			String userPswdNow = tlrPbocUserList.get(i).getUserPswdNow();
			String userPswdOld = tlrPbocUserList.get(i).getUserPswdOld();
			String userType = tlrPbocUserList.get(i).getUserType();
			String statusPswd = tlrPbocUserList.get(i).getStatusPswd();
			 // 用户密码校验
				checkUserPwd(userNo, userPswdOld, userPswdNow,userType,statusPswd);
			
		    //md5
			//userPswdOld =PasswordService.getInstance().EncryptPassword(userPswdOld, encMethod);
		    //base64加密
		    userPswdOld=Base64Util.encodeData(userPswdOld);
			List<TlrPbocUser> tlrPbocUserOldList=getTlrPbocUser(userNo,userType);
	        //根据userno和usertype遍历出所有的用户
			for(TlrPbocUser tlrPbocUserOld:tlrPbocUserOldList){
				//若果密码状态时4，删除其它状态的记录
				if(statusPswd.equals("4")){
					if(!(tlrPbocUserOld.getStatusPswd()).equals("4")){
						rootDao.delete(tlrPbocUserOld);
						continue;
					}
				}
				//如果密码状态是0，将状态改成4
				if((tlrPbocUserOld.getStatusPswd()).equals("0")){
					tlrPbocUserOld.setStatusPswd("4");
					rootDao.saveOrUpdate(tlrPbocUserOld);
					System.out.println("list not null!!");
					htlog.info("修改tlrPbocUser表状态成功！");
				}
				
			
			}
			   // userPswdNow = PasswordService.getInstance().EncryptPassword(userPswdNow, encMethod);
			   //base64加密
		     	userPswdNow=Base64Util.encodeData(userPswdNow);
			    System.out.println("begin insert tlrPbocUser！！！！");
			    TlrPbocUser tlrPbocUser=new TlrPbocUser();
			    tlrPbocUser.setUserNo(userNo);
			    tlrPbocUser.setUserPswdNow(userPswdNow);
			    tlrPbocUser.setUserPswdOld(userPswdOld);
			    tlrPbocUser.setUserType((tlrPbocUserOldList.get(0)).getUserType());
			    tlrPbocUser.setStatusPswd("1");
			    tlrPbocUser.setLastUpdateTime(sdf.format(new Date()));
			    tlrPbocUser.setUpdateTlrInfo(globalinfo.getTlrno());
		        rootDao.save(tlrPbocUser);
		        htlog.info("写入tlrPbocUser表成功！");
		        System.out.println("写入tlrPbocUser表成功！");
		      
		}

	}
    @SuppressWarnings("unchecked")
	private String getOldPsw(String userNo,String userType,String statusPswd) throws CommonException{
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
	//	String hql = "select po from TlrPbocUser po where  po.userNo = ? collate chinese_prc_cs_as and userType=? and statusPswd= ? ";
    	String hql = "select po.user_pswd_now as userPswdNow from tlr_pboc_user po where 1=1 and po.user_no = '"
				+ userNo + "' collate chinese_prc_cs_as and po.user_type = '" + userType + "' and po.status_pswd= '"+statusPswd+"'";
//    	ArrayList<String> condList = new ArrayList<String>();
//		condList.add(userNo);
//		condList.add(userType);
//		condList.add(statusPswd);
//		List<TlrPbocUser> list=null;
//		try {
//			list = rootdao.queryByCondition(hql);
//			//list = rootdao.queryByCondition(hql, condList.toArray());
//		} catch (CommonException e) {
//			e.printStackTrace();
//		}
        Iterator it = rootdao.queryBySQL2(hql.toString());
        String psw="";
		while(it.hasNext()){
			Map map = (Map)it.next();
			psw=(String) map.get("userPswdNow");
			}
		return psw;
	}
    @SuppressWarnings("unchecked")
  	private List<String> getOldPsw(String userNo,String userType) throws CommonException {
      	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
      	 List<String> list = new ArrayList(); 
  		//String hql = "select po. from TlrPbocUser po where  po.userNo = ? collate chinese_prc_cs_as and userType=? and statusPswd= '3' ";
      	String hql = "select po.user_pswd_now as userPswdNow from tlr_pboc_user po where  po.user_no = '"
				+ userNo + "' collate chinese_prc_cs_as and po.user_type = '" + userType + "' and po.status_pswd= '3'";
      System.out.println(hql);
      	 Iterator it = rootdao.queryBySQL2(hql.toString());
         String psw="";
 		while(it.hasNext()){
 			Map map = (Map)it.next();
 			psw=(String) map.get("userPswdNow");
 			list.add(psw);
 			}
  		return list;
  	}

    private void checkUserPwd(String userNo, String userPswdOld,
			String userPswdNow,String userType,String statusPswd) throws CommonException{
    	//数据库中即将过去的密码
    	String pswn=getOldPsw(userNo,userType,statusPswd);
    	List<String> tlrPbocUserList=getOldPsw(userNo,userType);
    	//输入的新旧密码不能相同
    	if(true == userPswdNow.trim().equals(userPswdOld.trim())){
    		ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_NEW_OLD_PWD_IS_SAME);
    	}
//    	String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");
//        String pwd = PasswordService.getInstance().EncryptPassword(userPswdOld, encMethod);
        //输入的密码加密处理
    	String pwd =Base64Util.encodeData(userPswdOld);
    	String upn=Base64Util.encodeData(userPswdNow);
        //输入的旧密码加密后和数据库中密码比较
    	if (!pswn.equals(pwd)) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_PWD_INVALID);
        }
    	for(String tlrPbocUserTemp:tlrPbocUserList){
    		if (tlrPbocUserTemp.equals(upn)) {
                ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_NEW_OLD_PWD_IS_SAME);
            }
    	}
	}

	@SuppressWarnings("unchecked")
	public List<TlrPbocUser> getTlrPbocUser(String userNo,String userType) throws CommonException {
    		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
    		List list = new ArrayList(); 
    		//String hql = "select po from TlrPbocUser po where  po.userNo = ?  collate chinese_prc_cs_as and po.userType = ? ";
    		String hql = "select po.id as id,po.user_pswd_now as userPswdNow,po.user_pswd_old as userPswdOld, po.last_update_time as lastUpdateTime,po.update_tlr_info as updateTlrInfo, po.status_pswd as statusPswd,po.user_type as userType from tlr_pboc_user po where  po.user_no = '"
    				+ userNo + "' collate chinese_prc_cs_as and po.user_type = '" + userType + "'";
    		 System.out.println(hql);
          	 Iterator it = rootdao.queryBySQL2(hql.toString());
          	TlrPbocUser bean=null;
             String psw="";
     		  while(it.hasNext()){
     			Map map = (Map)it.next();
     			bean=new TlrPbocUser();
     			bean.setId((Integer) map.get("id"));
     			bean.setUserNo(userNo);
     			bean.setUserPswdNow((String)map.get("userPswdNow"));
     			bean.setUserPswdOld((String)map.get("userPswdOld"));
     			bean.setStatusPswd((String)map.get("statusPswd"));
     			bean.setUserType((String)map.get("userType"));
     			bean.setLastUpdateTime((String)map.get("lastUpdateTime"));
     			bean.setUpdateTlrInfo((String)map.get("updateTlrInfo"));
     			list.add(bean);
     			}
    		return list;
    }
	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
}
