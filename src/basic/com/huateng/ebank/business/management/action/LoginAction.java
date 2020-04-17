package com.huateng.ebank.business.management.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import resource.bean.basic.TlrInfo;
import resource.dao.basic.TlrInfoDAO;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCodeUtil;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.business.common.operator.LoginManagerOP;
import com.huateng.ebank.business.management.bean.LoginForm;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.struts.BaseAction;
import com.huateng.service.pub.TlrLoginLogService;
/**
 * <strong>TemplateAction</strong> demonstrates how an action class is called
 * within the struts framework For the purposes of this sample, we simple
 * demonstrate how the perform is called, a sample action, and a return
 *
 * @author James Wu . Huateng Software Co., Ltd.
 */
public class LoginAction extends BaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ErrorCodeUtil.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - start"); //$NON-NLS-1$
		}
		// super.init(request);
		ActionForward actionForward = null;
		LoginForm formLogin = (LoginForm) form;
		String sessionId = null;
		try {
			// Create the container for any errors that occur
			// 第一步：获取上下文对象
			OperationContext operContext = new OperationContext();
			GlobalInfo globalInfo = new GlobalInfo();
			/* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 begin .*/
			Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);
			if (locale != null) {
				globalInfo.setLocale(locale);
			}
			//设置session超时时间，默认为15分钟
			int sessionTimeout = 6000*6000;
			try{
	//			sessionTimeout = Integer.parseInt(SessionTimeoutConfig.getValue("sessionTimeout"));
			}catch(Exception e){
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(sessionTimeout);
			/* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 end .*/
			globalInfo.setIp(request.getRemoteAddr());
			globalInfo.setTlrno(formLogin.getUserName());
			globalInfo.setTxtime(DateUtil.getCurrentTime());
			sessionId = getSessionID(request);
			globalInfo.setSessionId(sessionId);
			//globalInfo.setBrno(formLogin.getBrCode());
			GlobalInfo.setCurrentInstance(globalInfo);
			// 第二步：把数据放到对象内
			operContext.setAttribute(LoginManagerOP.IN_TLR_NO, formLogin.getUserName());
			operContext.setAttribute(LoginManagerOP.IN_TLR_PWD, formLogin.getPassWord());
		//	operContext.setAttribute(LoginManagerOP.IN_TLR_BRNO, formLogin.getBrCode());
			operContext.setAttribute(LoginManagerOP.IN_GLOBALINFO, globalInfo);
			operContext.setAttribute(LoginManagerOP.CONTEXT_PATH, request.getContextPath());
			operContext.setAttribute(GlobalInfo.KEY_GLOBAL_INFO, globalInfo);
			OPCaller.call(LoginManagerOP.ID, operContext);
			// 第四步：从返回对象中获取返回值
			UserSessionInfo userSessionInfo = new UserSessionInfo();
			userSessionInfo = (UserSessionInfo) operContext
					.getAttribute(LoginManagerOP.OUT_USER_SESSION_INFO);
			GlobalInfo gi = new GlobalInfo();
			gi = (GlobalInfo) operContext.getAttribute(LoginManagerOP.OUT_GLOBALINFO_INFO);

			// 第五步：从返回对象中获取返回值
			setSessionObject(request, LoginManagerOP.OUT_USER_SESSION_INFO,userSessionInfo);
			setSessionObject(request, GlobalInfo.KEY_GLOBAL_INFO, gi);
			setSessionObject(request, SystemConstant.WEB_SESSION_ID, this.getSessionID(request));
			//菜单
			StringBuffer tree = new StringBuffer();
			StringBuffer menu = new StringBuffer();
			tree = (StringBuffer)operContext.getAttribute(LoginManagerOP.OUT_TREE);
			menu = (StringBuffer)operContext.getAttribute(LoginManagerOP.OUT_MENU);

			setSessionObject(request, "tree", tree);
			setSessionObject(request, "menu", menu);

			setSessionObject(request, "tlrname", userSessionInfo.getTlrName());
			setSessionObject(request, "tlrno", userSessionInfo.getTlrNo());
			setSessionObject(request, "custNo", "");
			setSessionObject(request, "busidate", globalInfo.getTxdate());
			setSessionObject(request, "lastlogintime", userSessionInfo.getLastLoginTime());
			//add by zhaozhiguo 2011-6-20 BMS-3153
			if (GlobalInfo.getCurrentInstance().isPswdForcedToChange()) {
				//首次登录强制修改密码时设置为未登录状态
				try {
					String tlrNo = userSessionInfo.getTlrNo();
					if(tlrNo!=null && !"".equals(tlrNo)){
						TlrInfo tlrInfo = new TlrInfo();
						TlrInfoDAO tiDao = BaseDAOUtils.getTlrInfoDAO();
						tlrInfo = tiDao.query(tlrNo);
						tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
						tiDao.update(tlrInfo);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return mapping.findForward("chgpwd");
			}
			actionForward = mapping.findForward("success");
			if (logger.isDebugEnabled()) {
				logger.debug("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - actionForward.getPath()" + actionForward.getPath()); //$NON-NLS-1$
			}
			//记录登录日志
			TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
			tlrLoginLogService.saveTlrLoginLog("login", true, "登录成功");
			logger.info("==================operId:$"+userSessionInfo.getTlrNo()+"$login successs========================");
		} catch (CommonException e) {
			logger.error("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)", e); //$NON-NLS-1$
			request.setAttribute("REQ_CODE",e.getKey());
			String reqMsg = ErrorCodeUtil.convertErrorMessage(logger, e);
			request.setAttribute("REQ_MSG", reqMsg);
			request.setAttribute("UserName", formLogin.getUserName());
			//记录登录日志
			TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
			tlrLoginLogService.saveTlrLoginLog("login", false, reqMsg.trim());

			actionForward = mapping.findForward("login");
		} catch (Exception e) {
			logger.error("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse)", e); //$NON-NLS-1$

			//记录登录日志
			TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
			tlrLoginLogService.saveTlrLoginExceptionLog(formLogin.getUserName(),  request.getRemoteAddr(), sessionId);

			actionForward = mapping.findForward("error");
		}

		// Forward control to the appropriate URI as determined by the action.
		ActionForward returnActionForward = (actionForward);
		if (logger.isDebugEnabled()) {
			logger.debug("execute(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse) - end"); //$NON-NLS-1$
		}
		return returnActionForward;
	}

}
