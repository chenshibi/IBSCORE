package com.huateng.ebank.business.management.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.remote.base.SessionFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.struts.BaseAction;
import com.huateng.service.pub.TlrLoginLogService;
import com.huateng.service.pub.UserMgrService;

public class LogoutAction extends BaseAction {

	private static final Logger logger = Logger.getLogger(LogoutAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward = null;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String tlrNo = "";
		try {
			tlrNo = GlobalInfo.getCurrentInstance().getTlrno();
			logger.info("=======================logOut start,operId:$"+tlrNo+"$=================================");
			if(request.getSession(false) != null){
				logger.info("=======================logOut getSession,operId:$"+tlrNo+"$,Session:$"+request.getSession(false)+"$=================================");
				//记录登录日志
				TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
				tlrLoginLogService.saveTlrLoginLog("logout", false, "退出系统");
				/*不是重新登陆才记录退出信息*/
//				if (StringUtils.isBlank(request.getParameter("relogin")))
				UserMgrService.getInstance().setLoginOutInfo(GlobalInfo.getCurrentInstance().getTlrno());
				//删除系统记录的session
				SessionFactory.getInstance().removeSession(request.getSession(false).getId());
				
			}
			destroySession(request);
			actionForward = mapping.findForward("success");
			logger.info("=======================logOut success end,operId:$"+tlrNo+"$=================================");
		} catch (Exception e) {
			logger.info("=======================logOut error:"+e.getMessage()+"operId:$"+tlrNo+"$=================================");
			actionForward = mapping.findForward("failure");
		}finally{
//			try {
//				if(!"".equals(tlrNo)){
//					TlrInfo tlrInfo = new TlrInfo();
//					TlrInfoDAO tiDao = BaseDAOUtils.getTlrInfoDAO();
//					tlrInfo = tiDao.query(tlrNo);
//					tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
//					tlrInfo.setLastlogouttm(DateUtil.getTimestamp());
//					tiDao.update(tlrInfo);
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				logger.info("=======================finally logOut error:"+e.getMessage()+"operId:$"+tlrNo+"$=================================");
//				e.printStackTrace();
//			}
		}
		return (actionForward);
	}
}