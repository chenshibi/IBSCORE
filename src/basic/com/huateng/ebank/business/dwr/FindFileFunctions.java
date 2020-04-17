package com.huateng.ebank.business.dwr;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import resource.bean.basic.AssureIndApp;
import resource.bean.basic.Bctl;
import resource.bean.basic.BranchFuncRel;
import resource.bean.basic.DataDic;
import resource.bean.basic.FunctionInfo;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.InqCust;
import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.RoleInfo;
import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.SysTaskLog;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.TCorpDetailApp;
import resource.bean.basic.TCorpPermit;
import resource.bean.basic.TlrPbocUser;
import resource.dao.basic.BranchFuncRelDAO;
import resource.dao.basic.RoleFuncRelDAO;

import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.management.operation.FavOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.session.SessionManager;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.msgplatform.service.MsgSendSettingService;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportUtils;
import com.huateng.service.pub.UserMgrService;

import edu.emory.mathcs.backport.java.util.Arrays;

public class FindFileFunctions {
	private Logger logger = LoggerFactory.getLogger(FindFileFunctions.class);

	private void setGlobalInfo(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		if (null != httpSession) {
			Object o = httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			if (null != o && o instanceof GlobalInfo) {
				GlobalInfo globalInfo = (GlobalInfo) o;
				GlobalInfo.setCurrentInstance(globalInfo);
			}
		}
	}

	public void setCurrentTabId(String id) {
		GlobalInfo gi;
		try {
			gi = GlobalInfo.getCurrentInstance();
			gi.setCurrentTabId(id);
		} catch (CommonException e) {
		}
	}

	public boolean queryFileExist(String path)
			throws CommonException {
		File file = new File(path);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

}
