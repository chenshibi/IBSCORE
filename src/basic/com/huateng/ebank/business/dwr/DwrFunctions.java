package com.huateng.ebank.business.dwr;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.UpdateReturnBean;
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
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.excel.imp.DataMyUtil;
import com.huateng.excel.imp.QueryUntils;
import com.huateng.exception.AppException;
import com.huateng.msgplatform.service.MsgSendSettingService;
import com.huateng.report.common.PbocConstants;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;
import com.huateng.report.pboc.entity.DataExtractionEntity;
import com.huateng.report.pboc.operation.QueryCorpOperation;
import com.huateng.report.pboc.operation.QueryPersonalCrawlOperation;
import com.huateng.report.pboc.operation.QueryPersonalOperation;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.service.NewSysParamsService;
import com.huateng.report.service.PbocD101Service;
import com.huateng.report.service.PbocD103Service;
import com.huateng.report.utils.JsonUtils;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportUtils;
import com.huateng.service.pub.UserMgrService;

import edu.emory.mathcs.backport.java.util.Arrays;
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
import resource.bean.basic.TlrRoleRel;
import resource.bean.crms.CrPbocD501;
import resource.bean.crms.CrPbocD503;
import resource.bean.crms.CustPbocPerQuery;
import resource.dao.basic.BranchFuncRelDAO;
import resource.dao.basic.RoleFuncRelDAO;

public class DwrFunctions extends HibernateDaoSupport {
	private Logger logger = LoggerFactory.getLogger(DwrFunctions.class);
	
/*	@Autowired
	PbocD103Service pbocD103Services;*/

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

	public void setCurrentTabId(String id){
		GlobalInfo gi;
		try {
			gi = GlobalInfo.getCurrentInstance();
			gi.setCurrentTabId(id);
		} catch (CommonException e) {
		}
	}

	/**
	 * 通过所有获得权限
	 */
	public List<String> getFuncArray(HttpServletRequest request) {
		try {
			// String str = "from FunctionInfo func WHERE func.id like '60%'";
			String str = "from FunctionInfo func";
			List<String> list = CommonFunctions.getFunctionList(DAOUtils
					.getHQLDAO().queryByQL2List(str));
			// for(int i=0;i<list.size();i++){
			// System.out.println(list.get(i).toString());
			// }
			return list;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			return new ArrayList<String>();
		}
	}

	/**
	 * 通过所有获得权限
	 */
	public List<String> getFuncArrayBySysname(HttpServletRequest request,
			String sysname) {
		try {
			// String str = "from FunctionInfo func WHERE func.id like '60%'";
			String str = "from FunctionInfo func where funcDesc = ? ";
			List<String> list = CommonFunctions.getFunctionList(DAOUtils
					.getHQLDAO().queryByQL2List(str, new String[] { sysname },
							null));
			// for(int i=0;i<list.size();i++){
			// System.out.println(list.get(i).toString());
			// }
			return list;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			return new ArrayList<String>();
		}
	}

	public List<String> getFuncArrayCopram(HttpServletRequest request) {
		try {
			String str = "from FunctionInfo func";
			List<String> list = CommonFunctions.getFunctionListCompar(DAOUtils
					.getHQLDAO().queryByQL2List(str));
			// for(int i=0;i<list.size();i++){
			// System.out.println(list.get(i).toString());
			// }
			return list;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			return new ArrayList<String>();
		}
	}

	// public String getCurrentBctlNo(HttpServletRequest request) throws
	// CommonException {
	// GlobalInfo globalInfobctl = (GlobalInfo)
	// request.getSession(false).getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
	// GlobalInfo.setCurrentInstance(globalInfobctl);
	// return globalInfobctl.getBrno();
	// }

	public String setCurrentBctlNo(HttpServletRequest request, String selBctlNo)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		UserMgrService service = UserMgrService.getInstance();
		Bctl bt = BctlService.getInstance().getBctlByBrno(selBctlNo);

		GlobalInfo globalInfobctl = (GlobalInfo) request.getSession(false)
				.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		// String oldbctlNo = globalInfobctl.getBrno();

		SessionManager.getInstance().setSessionObject(request,
				"SESSION_CURRENT_BCTL_NO", selBctlNo);
		// 更新当前用户机构
		// TlrInfo info = service.getUserInfo(globalInfobctl.getTlrno());
		// info.setBrcode(bt.getBrcode());
		// rootdao.saveOrUpdate(info);

		// globalInfobctl.setBrno(selBctlNo);
		globalInfobctl.setBrcode(bt.getBrcode());
		globalInfobctl.setBrName(bt.getBrname());
		globalInfobctl.setBrClass(bt.getBrclass());

		GlobalInfo.setCurrentInstance(globalInfobctl);

		// globalInfobctl.addBizLog("Updater.log", new String[] {
		// info.getTlrno(), selBctlNo,
		// "用户"+info.getTlrName()+"由机构["+oldbctlNo+"]切换至["+selBctlNo+"]!" });
		return selBctlNo;
	}

	public String getUserInfo(HttpServletRequest request) {
		UserSessionInfo userInfo = (UserSessionInfo) request.getSession(false)
				.getAttribute("USER_SESSION_INFO");
		setGlobalInfo(request);
		GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();

		String tbsDay = DataFormat.dateToString(userInfo.getTxDate());
		StringBuffer sb = new StringBuffer(256);
		sb.append("工作日期：").append(tbsDay.substring(0, 4)).append("年")
				.append(tbsDay.substring(5, 7)).append("月")
				.append(tbsDay.substring(8, 10)).append("日").append("   操作员号：")
				.append(userInfo.getTlrNo()).append("  操作员名：")
				.append(userInfo.getTlrName());
		// .append("  分行号：").append(gi.getBrno()).append("  分行名：")
		// .append(gi.getBrName());
		return sb.toString();
	}

	public void saveFavt(HttpServletRequest request, List<String> funcIds)
			throws CommonException {
		setGlobalInfo(request);

		OperationContext oc = new OperationContext();
		oc.setAttribute(FavOperation.CMD, FavOperation.OP_FAVT);
		oc.setAttribute(FavOperation.IN_FAVT, funcIds);
		OPCaller.call(FavOperation.ID, oc);
	}

	/**
	 * 查询机构ID的权限
	 */
	public List<FunctionInfo> getFunctionByBranchId(String brcode) {

		try {
			// int branchid = Integer.parseInt(brcode);
			String str = "select ltrim(rtrim(func.id)) from FunctionInfo func,BranchFuncRel bfl where bfl.funcid = func.id and func.isdirectory=0 and  bfl.brcode = "
					+ brcode;
			return DAOUtils.getHQLDAO().queryByQL2List(str);
		} catch (CommonException e) {
			return null;
		}
	}

	/**
	 * 修改机构权限
	 */
	public int updateBranchFunc(String brcode, String funcs) {
		Hashtable<String, BranchFuncRel> oldfuncs = new Hashtable<String, BranchFuncRel>();
		Hashtable<String, String> newfuncs = new Hashtable<String, String>();
		BranchFuncRelDAO bfrd = DAOUtils.getBranchFuncRelDAO();
		// List rfuncs = bfrd.findByBranchid(Integer.parseInt(branchId));
		List rfuncs = bfrd.findByBranchid(brcode.trim());
		Iterator it = rfuncs.iterator();
		while (it.hasNext()) {
			BranchFuncRel bfr = (BranchFuncRel) it.next();
			oldfuncs.put(bfr.getFuncid().trim(), bfr);
		}
		StringTokenizer st = new StringTokenizer(funcs, ",");
		while (st.hasMoreTokens()) {
			String fid = st.nextToken();
			if (newfuncs.containsKey(fid) == false)
				newfuncs.put(fid, fid);
		}
		Iterator itnew = newfuncs.keySet().iterator();
		while (itnew.hasNext()) {
			String newfid = (String) itnew.next();
			if (oldfuncs.containsKey(newfid)) {
				oldfuncs.remove(newfid);
			} else {
				BranchFuncRel newbfr = new BranchFuncRel();
				newbfr.setFuncid(newfid);
				newbfr.setBrcode(brcode);
				bfrd.save(newbfr);
			}
		}
		Enumeration en = oldfuncs.keys();
		while (en.hasMoreElements()) {
			Object key_num = en.nextElement();
			BranchFuncRel oldbfr = oldfuncs.get(key_num);
			bfrd.delete(oldbfr);
		}
		return 0;
	}

	/**
	 * @desc 获取岗位对应的权限
	 * @author fubo
	 * @param roleId
	 * @return
	 * @throws CommonException
	 */
	public List<FunctionInfo> getRoleFuncByid(String roleId)
			throws CommonException {

		String str = "select ltrim(rtrim(funInfo.id)) from FunctionInfo funInfo,RoleFuncRel rolefun where funInfo.id= rolefun.funcid and funInfo.isdirectory=0"
				+ "and rolefun.roleId = '" + roleId + "'";
		List list = DAOUtils.getHQLDAO().queryByQL2List(str);
		return list;
	}

	/**
	 * 角色信息对比
	 * 
	 * @param roleId
	 * @param st
	 * @param flag
	 * @param tskId
	 * @return
	 * @throws CommonException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<String> getRoleFuncByIdCom(String roleId, String st,
			String flag, String tskId) throws CommonException, IOException,
			ClassNotFoundException {
		List<String> list = new ArrayList<String>();
		if (flag.equals("0")) {
			String str = "select ltrim(rtrim(funInfo.id)) from FunctionInfo funInfo,RoleFuncRel rolefun where funInfo.id= rolefun.funcid and funInfo.isdirectory=0"
					+ " and rolefun.roleId = '" + roleId + "'";
			list = DAOUtils.getHQLDAO().queryByQL2List(str);
		}
		if (flag.equals("1")) {
			ReportTaskUtil rt = new ReportTaskUtil();
			SysTaskLog systasklog = ReportShowDetailService.getInstance()
					.selectTaskLog(tskId);
			RoleInfo oldValue = null;
			if (systasklog.getOldVal1() != null) {
				oldValue = (RoleInfo) ReportTaskUtil
						.getOldObjectByTaskLog(systasklog);
			}
			if (oldValue != null && oldValue.getRoleList() != null
					&& oldValue.getRoleList().length() > 0) {
				list = Arrays.asList(oldValue.getRoleList().split(","));
			}
		}
		return list;
	}

	/**
	 * 序列化角色信息新内容
	 * 
	 * @param roleId
	 * @param st
	 * @param flag
	 * @param tskId
	 * @return
	 * @throws CommonException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public List<String> getRoleFuncByIdComSeri(String roleId, String st,
			String flag, String tskId) throws CommonException, IOException,
			ClassNotFoundException {
		List<String> list = new ArrayList<String>();
		if (flag.equals("0")) {
			if (st.equals("2")) {
				ReportTaskUtil rt = new ReportTaskUtil();
				List<SysTaskInfo> taskList = ROOTDAOUtils.getROOTDAO()
						.queryByQL2List(
								"from SysTaskInfo where intInsId='100299' and adtRcdPk='"
										+ roleId + "'");
				if (taskList.size() > 0) {
					RoleInfo roleInfoSeri = (RoleInfo) ReportTaskUtil
							.getObjctBySysTaskInfo(taskList.get(0));
					if (roleInfoSeri != null
							&& roleInfoSeri.getRoleList() != null
							&& roleInfoSeri.getRoleList().length() > 0) {
						list = Arrays.asList(roleInfoSeri.getRoleList().split(
								","));
					}
				}
			}
		}
		if (flag.equals("1")) {
			ReportTaskUtil rt = new ReportTaskUtil();
			SysTaskLog systasklog = ReportShowDetailService.getInstance()
					.selectTaskLog(tskId);
			RoleInfo newValue = null;
			if (systasklog.getNewVal1() != null) {
				newValue = (RoleInfo) ReportTaskUtil
						.getNewObjectByTaskLog(systasklog);
			}
			if (newValue != null && newValue.getRoleList() != null
					&& newValue.getRoleList().length() > 0) {
				list = Arrays.asList(newValue.getRoleList().split(","));
			}
		}
		return list;
	}

	/**
	 * @desc 更新角色的权限
	 * @author fubo
	 * @param rid
	 * @param funcs
	 * @return
	 */
	public int updateRoleFunc(String rid, String funcs) {

		Hashtable<String, RoleFuncRel> oldfuncs = new Hashtable<String, RoleFuncRel>();
		Hashtable<String, String> newfuncs = new Hashtable<String, String>();

		RoleFuncRelDAO rfrd = DAOUtils.getRoleFuncRelDAO();
		List rfuncs = rfrd.findByRoleid(Integer.parseInt(rid));

		Iterator it = rfuncs.iterator();
		while (it.hasNext()) {
			RoleFuncRel rfr = (RoleFuncRel) it.next();
			oldfuncs.put(rfr.getFuncid().toString(), rfr);
		}

		StringTokenizer st = new StringTokenizer(funcs, ",");
		while (st.hasMoreTokens()) {
			String fid = st.nextToken();
			if (newfuncs.containsKey(fid) == false)
				newfuncs.put(fid, fid);
		}

		Iterator itnew = newfuncs.keySet().iterator();
		while (itnew.hasNext()) {
			String newfid = (String) itnew.next();
			if (oldfuncs.containsKey(newfid)) {
				oldfuncs.remove(newfid);
			} else {
				RoleFuncRel newrfr = new RoleFuncRel();
				newrfr.setFuncid(newfid);
				newrfr.setRoleId((rid));
				rfrd.save(newrfr);
			}
		}
		Enumeration en = oldfuncs.keys();
		while (en.hasMoreElements()) {
			Object key_num = en.nextElement();
			RoleFuncRel oldrfr = oldfuncs.get(key_num);
			rfrd.delete(oldrfr);
		}

		return 0;
	}

	public String getcurrentFileType(String appType, String currentFileType)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String fileTypeId = "";

		PageQueryCondition queryCondition = new PageQueryCondition();

		StringBuffer hql = new StringBuffer(
				"select dd.id from DataDic dd where 1=1 ");

		if (StringUtils.isNotBlank(appType)
				&& StringUtils.isNotBlank(currentFileType)) {
			hql.append(" and dd.dataNo ='").append(appType)
					.append("' and dd.dataTypeNo= 17");
		} else
			return currentFileType;

		List list = rootdao.queryByQL2List(hql.toString());

		if (!list.isEmpty()) {
			fileTypeId = "" + (Integer) list.get(0);
		} else
			return currentFileType;

		if (!StringUtils.isEmpty(fileTypeId)
				&& !StringUtils.isEmpty(currentFileType)) {
			StringBuffer hql1 = new StringBuffer(
					"select dd.dataName from DataDic dd where 1=1 ");
			hql1.append(" and dd.miscflgs = '").append(fileTypeId).append("'");
			hql1.append(" and dd.dataNo = '").append(currentFileType)
					.append("'");
			list = rootdao.queryByQL2List(hql1.toString());

			if (!list.isEmpty()) {
				return (String) list.get(0);
			}
		}

		return currentFileType;
	}

	/**
	 * 通过个人用户权限
	 * 
	 * @throws CommonException
	 */
	public List<String> getFuncArrayByFavt(HttpServletRequest request)
			throws CommonException {
		HttpSession httpSession = request.getSession(false);
		GlobalInfo globalInfo = (GlobalInfo) httpSession
				.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		GlobalInfo.setCurrentInstance(globalInfo);
		List<FunctionInfo> funcInfoList = new ArrayList<FunctionInfo>();
		UserMgrService.getInstance().getUserFunctionsByMenuType(
				globalInfo.getTlrno(), globalInfo.getMenuCode(), funcInfoList);
		// UserMgrService.getInstance().getUserFunctionsByMenuType_favt(globalInfo.getTlrno(),
		// globalInfo.getMenuCode(),funcInfoList);
		// for (int i = 0; i < funcInfoList.size(); i++) {
		//
		// }
		// for (Iterator iterator = funmap.keySet().iterator();
		// iterator.hasNext();) {
		// String funcId = (String) iterator.next();
		//
		// FunctionInfo fun = (FunctionInfo)funmap.get(funcId);
		// //调整主管确认
		// if (fun.getId().trim().equals(ReportConstant.APPROVE_FUNC_ID)) {
		// fun.setIsdirectory(0);//调整为不是目录
		// }
		// if (fun.getLastdirectory()!=null &&
		// fun.getLastdirectory().equals(ReportConstant.APPROVE_FUNC_ID)) {
		// continue;
		// }
		// funcInfoList.add(fun);
		// }
		List<String> list = CommonFunctions.getFunctionList(funcInfoList);
		return list;
	}

	/*
	 * public boolean getMsg1(HttpServletRequest request, String filePath)
	 * throws CommonException { setGlobalInfo(request); Date
	 * date=DateUtil.stringToDate2(reportDate); String
	 * reportdate=DateUtil.dateToString(date); String
	 * path="D:\\TFMS\\report\\"+reportdate; String
	 * fileName="Status_Interface_eBBS_IDNumber_"+reportdate+".xls"; File
	 * file=new File(path+"\\"+fileName); if(!file.exists()){ return false; }
	 * return true; String filepath=request.getParameter("consentFilePath");
	 * File file=new File(filepath); if(!file.exists()){ return false; } return
	 * true; }
	 */

	public List<String> getFavtList(HttpServletRequest request)
			throws CommonException {
		List<String> selList = new ArrayList<String>();
		List list = ReportCommonService.getInstance()
				.getFunctionInfoListByFavt(request.getSession(false));
		for (int i = 0; i < list.size(); i++) {
			FunctionInfo ft = (FunctionInfo) list.get(i);
			selList.add(ft.getId().trim());
		}
		return selList;
	}

	/**
	 * 消息平台模块中，消息发送配置维护明细，选择下拉消息ID时，查询消息的已配置的发送用户。
	 * 
	 * @param request
	 * @param funcIds
	 * @throws CommonException
	 */
	public List<String> getUsrByMsgId(HttpServletRequest request, String msgId)
			throws CommonException {
		setGlobalInfo(request);
		return MsgSendSettingService.getInstance().getUsrListByMsgId(msgId);
	}

	// 判断担保人是否有许可文件
	@SuppressWarnings("unchecked")
	public List<IndPermit> permitFlag(String idType, String name,
			String individualId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuilder sb=new StringBuilder(); 
	/*	String hql = "select po from IndPermit po where 1=1 and status='1' and po.idType =? and po.name =? and po.individualId =?";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(idType);
		condList.add(name);
		condList.add(individualId);
		@SuppressWarnings("unchecked")
		List<IndPermit> list = rootdao
				.queryByCondition(hql.toString(), condList.toArray());*/
		sb.append("select po from IndPermit po where 1=1 and status='1'").append(" and po.idType =").append("'").append(idType).append("'")
		.append(" and po.name =").append("'").append(name).append("'").append(" and po.individualId =").append("'").append(individualId).append("'");
		List<IndPermit> list =rootdao.queryByCondition(sb.toString());
		return list;
	}

	// 判断担保公司是否有许可文件
	public static String permitFlagCompany(String loadCarNo)
			throws CommonException {
		if ("".equals(loadCarNo)) {
			return "1";
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from TCorpPermit po where 1=1 and po.loanCardNo = ? and status='1'";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(loadCarNo);
		@SuppressWarnings("unchecked")
		List<TCorpPermit> list = rootdao
				.queryByCondition(hql, condList.toArray());
		if (list.size() > 0) {
			return "1";
		}
		return "0";
	}

	// 判断是否在工作时间之内
	public static boolean isWorkTime() throws Exception {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add("NON_WORK");
		condList.add("START");
		@SuppressWarnings("unchecked")
		List<SysParams> list = rootdao
				.queryByCondition(hql, condList.toArray());
		String start = list.get(0).getParamVal();// 工作起始时间

		String hql2 = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
		ArrayList<String> condList2 = new ArrayList<String>();
		condList2.add("NON_WORK");
		condList2.add("OFF");
		@SuppressWarnings("unchecked")
		List<SysParams> list2 = rootdao.queryByCondition(hql2,
				condList2.toArray());
		String off = list2.get(0).getParamVal();// 工作截止时间

		Calendar calendar = Calendar.getInstance();
		String[] startTime = start.split(":");
		calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(startTime[0]));
		calendar.set(Calendar.MINUTE, Integer.valueOf(startTime[1]));
		calendar.set(Calendar.SECOND, Integer.valueOf(startTime[2]));
		calendar.set(Calendar.MILLISECOND, 0);

		long startTimeL = calendar.getTimeInMillis();

		String[] offTime = off.split(":");
		calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(offTime[0]));
		calendar.set(Calendar.MINUTE, Integer.valueOf(offTime[1]));
		calendar.set(Calendar.SECOND, Integer.valueOf(offTime[2]));
		calendar.set(Calendar.MILLISECOND, 0);

		long offTimeL = calendar.getTimeInMillis();

		Date now = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		String nowTime1 = sdf.format(now);

		String[] nowTime = nowTime1.split(":");
		calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(nowTime[0]));
		calendar.set(Calendar.MINUTE, Integer.valueOf(nowTime[1]));
		calendar.set(Calendar.SECOND, Integer.valueOf(nowTime[2]));
		calendar.set(Calendar.MILLISECOND, 0);

		long nowTimeL = calendar.getTimeInMillis();

		return nowTimeL >= startTimeL && nowTimeL <= offTimeL;
	}

	public static boolean tCorpPermit12month(String loadCarNo) throws Exception {
		if ("".equals(loadCarNo)) {
			return true;
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//sqlserver 转oracle
		//String hql = "select po from TCorpPermit po where po.inputTime>DATEADD(MONTH,-12,GETDATE()) and  po.loanCardNo = ? ";  //add_months(sysdate,-12)
		String hql = "select po from TCorpPermit po where po.inputTime>add_months(sysdate,-12) and  po.loanCardNo = ? ";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(loadCarNo);
		@SuppressWarnings("unchecked")
		List<IndPermit> list = rootdao
				.queryByCondition(hql, condList.toArray());
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	public static boolean tCorpCust12month(String loadCarNo) throws Exception {
		if ("".equals(loadCarNo)) {
			return true;
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//String hql = "select po from CorpCust po where po.createTime>DATEADD(MONTH,-12,GETDATE()) and  po.corpCustLoancard = ? ";
		String hql = "select po from CorpCust po where po.createTime>add_months(sysdate,-12) and  po.corpCustLoancard = ? ";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(loadCarNo);
		@SuppressWarnings("unchecked")
		List<IndPermit> list = rootdao
				.queryByCondition(hql, condList.toArray());
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	public static String IndPermit12month(String idType, String name,
			String individualId) throws CommonException {
		if ("".equals(idType) || "".equals(name) || "".equals(individualId)) {
			return "1";
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//String hql = "select po from IndPermit po where 1=1 and po.inputTime>DATEADD(MONTH,-12,GETDATE()) and po.idType = ? and po.name = ? and po.individualId = ? ";
		String hql = "select po from IndPermit po where 1=1 and po.inputTime>add_months(sysdate,-12) and po.idType = ? and po.name = ? and po.individualId = ? ";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(idType);
		condList.add(name);
		condList.add(individualId);
		@SuppressWarnings("unchecked")
		List<IndPermit> list = rootdao
				.queryByCondition(hql, condList.toArray());
		if (list.size() > 0) {
			return "1";
		}
		return "0";
	}

	public static String InqCust2month(String idType, String name,
			String individualId) throws CommonException {
		if ("".equals(idType) || "".equals(name) || "".equals(individualId)) {
			return "1";
		}
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		//String hql = "select po from InqCust po where 1=1 and po.createTime>DATEADD(MONTH,-12,GETDATE()) and po.inqCustIdType = ? and po.inqCustName = ? and po.inqCustId = ? ";
		String hql = "select po from InqCust po where 1=1 and po.createTime>add_months(sysdate,-12) and po.inqCustIdType = ? and po.inqCustName = ? and po.inqCustId = ? ";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(idType);
		condList.add(name);
		condList.add(individualId);
		@SuppressWarnings("unchecked")
		List<InqCust> list = rootdao.queryByCondition(hql, condList.toArray());
		if (list.size() > 0) {
			return "1";
		}
		return "0";
	}

	/**
	 * 企业
	 * 
	 * **/
	public static String test(String rptKey) throws CommonException {
		String returnTime = "";
		String loancarid = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select ia from TCorpApp ia where ia.rptKey='" + rptKey + "'");
		List<TCorpApp> listApp = rootdao.queryByCondition(hql.toString());
		if (listApp.size() > 0) {
			rptKey = listApp.get(0).getRptKey();
			loancarid = listApp.get(0).getLoanCardNo();
			if (null != listApp.get(0).getQueryTime()) {
				returnTime = String.valueOf(listApp.get(0).getQueryTime())
						.substring(0, 10);
			}
		}
		String fileName = loancarid + "Expend.html";
		SysParams params = new SysParams();
		params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
				"CORP", "STIRPATH"));
		String filePath = params.getParamVal();
		String path = filePath + returnTime;
		File file = new File(path + "/" + "Normal" + "/" + rptKey + "/"
				+ fileName);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	public boolean queryFileExist(String path) throws CommonException {
		File file = new File(path);
		System.out.println(file);
		if (!file.exists()) {
			System.out.println("file not exists");
			return false;
		}
		System.out.println("file exists");
		return true;
	}

	public static String indQueryPermit(String id) throws CommonException {
		String customerConUp = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select ia from IndPermit ia where ia.id='" + id + "'");
		List<IndPermit> listApp = rootdao.queryByCondition(hql.toString());
		if (listApp.size() > 0) {
			customerConUp = listApp.get(0).getCustomerConUp();
		}

		File file = new File(customerConUp);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	public static String tCorpQueryPermit(String id) throws CommonException {
		String customerConUp = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select ia from TCorpPermit ia where ia.id='" + id + "'");
		List<TCorpPermit> listApp = rootdao.queryByCondition(hql.toString());
		if (listApp.size() > 0) {
			customerConUp = listApp.get(0).getCustomerConUp();
		}

		File file = new File(customerConUp);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	public static String test1(String rptKey) throws CommonException {
		String returnTime = "";
		String loancarid = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select ia from TCorpApp ia where ia.rptKey='" + rptKey + "'");
		List<TCorpApp> listApp = rootdao.queryByCondition(hql.toString());
		if (listApp.size() > 0) {
			rptKey = listApp.get(0).getRptKey();
			loancarid = listApp.get(0).getLoanCardNo();
			if (null != listApp.get(0).getQueryTime()) {
				returnTime = String.valueOf(listApp.get(0).getQueryTime())
						.substring(0, 10);
				System.out.println(returnTime);
			}
		}
		String fileName = loancarid + "mergeHtml.html";
		// SysParams params = new SysParams();
		// params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
		// "CORP", "FILEPATH"));
		// String filePath=params.getParamVal();
		String filePath = ReportUtils.getSysParamsValue("CORP", "FILEPATH");
		String path = filePath + returnTime;
		System.out.println(path);
		File file = new File(path + "\\" + "Normal" + "\\" + rptKey + "\\"
				+ fileName);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	public static String test2(String detailrptKey) throws CommonException {
		String returnTime = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select ia from TCorpDetailApp ia where ia.rptKey='"
						+ detailrptKey + "'");
		List<TCorpDetailApp> listApp = rootdao.queryByCondition(hql.toString());
		if (listApp.size() > 0) {
			detailrptKey = listApp.get(0).getRptKey();
			if (null != listApp.get(0).getQueryTime()) {
				returnTime = String.valueOf(listApp.get(0).getQueryTime())
						.substring(0, 10);
				System.out.println(returnTime);
			}
		}
		String fileName = detailrptKey + "Detail.zip";
		System.out.println(fileName);
		SysParams params = new SysParams();
		params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
				"CORPDETAIL", "FILEPATH"));
		String filePath = params.getParamVal();
		String path = filePath + returnTime + "\\" + "Detail" + "\\"
				+ detailrptKey + "\\" + "DetailZip";
		System.out.println(path);
		File file = new File(path + "\\" + fileName);
		System.out.println("文件路径=" + file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	public static String test5(String Id) throws CommonException {
		String consentFilePath = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if (null == Id || "".equals(Id)) {
			consentFilePath = "";
		} else {
			StringBuffer hql = new StringBuffer(
					"select consentFilePath from CorpCust where id='" + Id
							+ "'");
			consentFilePath = (String) rootdao.queryByCondition(hql.toString())
					.get(0);
		}
		File file = new File(consentFilePath);
		System.out.println("文件路径=" + file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}
	/*二代个人信用信息查询 查询授权书下载*/
	public static String test6(String idNum,String idType) throws CommonException {
		String customerConUp = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<IndPermit> list=null;
		if (null == idNum || "".equals(idNum)) {
			customerConUp = "";
		} else {
			StringBuffer hql = new StringBuffer();
			hql.append("from IndPermit where status ='1' and individualId=").append("'").append(idNum).append("'")
			.append(" and idType=").append("'").append(idType).append("'");
			list = rootdao.queryByCondition(hql.toString());
			if(list !=null && list.size()>0) {
				customerConUp=list.get(0).getCustomerConUp();
			}
		}
		File file = new File(customerConUp);
		System.out.println("文件路径=" + file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}
	/*二代企业信用信息查询 查询授权书下载*/
	public static String test7(String entCertType,String entCertNum) throws CommonException {
		String customerConUp = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<TCorpPermit> list=null;
		if (null == entCertNum || "".equals(entCertNum)) {
			customerConUp = "";
		} else {
			StringBuffer hql = new StringBuffer();
					hql.append("from TCorpPermit where status='1'").append(" and loanCardNo =").append("'").append(entCertNum).append("'");
				    list=rootdao.queryByCondition(hql.toString());
					if(list!=null && list.size()>0) {
						customerConUp=list.get(0).getCustomerConUp() ;
					}
		}
		File file = new File(customerConUp);
		System.out.println("文件路径=" + file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * 个人
	 * 
	 * **/
	@SuppressWarnings("unchecked")
	public static String test3(String rptId) throws CommonException {
		String IndividualId = "";
		String name = "";
		String returnTime = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select ia from IndApp ia where ia.rptId='" + rptId + "'");
		List<IndApp> listApp = rootdao.queryByCondition(hql.toString());
		if (listApp.size() > 0) {
			rptId = listApp.get(0).getRptId();
			IndividualId = listApp.get(0).getIndividualId();
			name = listApp.get(0).getName();
			returnTime = listApp.get(0).getReturnTime().toString()
					.substring(0, 10);
		}
		String fileName = rptId + "." + IndividualId + "." + name + ".html";
		SysParams params = new SysParams();
		params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
				"PERSONAL", "FILEPATH"));
		String filePath = params.getParamVal();
		String path = filePath + returnTime;
		File file = new File(path + "\\" + fileName);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	public static String test4(String id) throws CommonException {
		String consentFilePath = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		if (null == id || "".equals(id)) {
			consentFilePath = "";
		} else {
			StringBuffer hql = new StringBuffer(
					"select consentFilePath from InqCust where id='" + id + "'");
			consentFilePath = (String) rootdao.queryByCondition(hql.toString())
					.get(0);
		}
		File file = new File(consentFilePath);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}
	
	
	public boolean getMsg(HttpServletRequest request, String reportDate)
			throws CommonException {
		setGlobalInfo(request);
		Date date = DateUtil.stringToDate2(reportDate);
		String reportdate = DateUtil.dateToString(date);
		String path = ReportUtils.getSysParamsValue("UserReport", "User");
		String fileName = "User_Report_" + reportdate + ".xls";
		logger.info("********************************************************chensibi"+fileName);
		File file = new File(path + "/" + fileName);
		logger.info("*************************************************************chensibi1"+file);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean getMsgMail(HttpServletRequest request, String reportDate)
			throws CommonException {
		setGlobalInfo(request);
		Date date = DateUtil.stringToDate2(reportDate);
		String reportdate = DateUtil.dateToString(date).replaceAll("-", "");
		String path = ReportUtils.getSysParamsValue("Doubtful", "xls");
		String fileName = path + reportdate + "/" + "zip" + "/" + reportdate
				+ ".zip";
		File file = new File(fileName);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean getMsgMatrix(HttpServletRequest request)
			throws CommonException {
		setGlobalInfo(request);
		String path = ReportUtils.getSysParamsValue("UserReport", "User");
		String fileName = "matrix.xls";
		File file = new File(path + "/" + fileName);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean getMsg1(HttpServletRequest request, String reportDate)
			throws CommonException {
		setGlobalInfo(request);
		String path = ReportUtils.getSysParamsValue("BATCH_APP", "LOAD_PATH");
		String fileName = reportDate + ".xls";
		File file = new File(path + "\\" + fileName);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean getMsg2(HttpServletRequest request, String reportDate)
			throws CommonException {
		setGlobalInfo(request);
		String path = ReportUtils.getSysParamsValue("COMP_DIALY", "COMP_REP");
		String fileName = "monthly_corp_bureau_inquiry_record_" + reportDate
				+ ".xls";
		File file = new File(path + "\\" + fileName);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean getMsg3(HttpServletRequest request, String reportDate)
			throws CommonException {
		setGlobalInfo(request);
		String path = ReportUtils.getSysParamsValue("PER_DIALY", "DIA_REPORT");
		String fileName = "monthly_ind_bureau_inquiry_record_" + reportDate
				+ ".xls";
		File file = new File(path + "\\" + fileName);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean getMsg4(HttpServletRequest request, String reportDate)
			throws CommonException {
		setGlobalInfo(request);
		String path = ReportUtils.getSysParamsValue("PER_DIALY", "NA_REPORT");
		String fileName = "monthly_nature_bureau_inquiry_record_" + reportDate
				+ ".xls";
		File file = new File(path + "\\" + fileName);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean getAssureReport(HttpServletRequest request, String reportDate)
			throws CommonException {
		setGlobalInfo(request);
		String path = ReportUtils.getSysParamsValue("ASS_DIALY", "NA_REPORT");
		String fileName = "monthly_nature_loancardno_inquiry_record_" + reportDate
				+ ".xls";
		File file = new File(path + "\\" + fileName);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean getAssureCorpReport(HttpServletRequest request,
			String reportDate) throws CommonException {
		setGlobalInfo(request);
		String path = ReportUtils.getSysParamsValue("ASS_DIALY", "NA_REPORT");
		String fileName = "monthly_corp_loancardno_inquiry_record_"
				+ reportDate + ".xls";
		File file = new File(path + "\\" + fileName);
		System.out.println(file);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean isFileNotExists(String date, String id)
			throws CommonException {
		String fileName = "";

		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		System.out.println(fileName);
		SysParams params = new SysParams();
		params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
				"XML", "FILEPATH"));
		String filePath = params.getParamVal();
		String datePath = filePath + date + "/";
		if (id.equals("downLoadind")) {
			fileName = searchFile("W10312900H0012_GRZXCXMX_", datePath);
		} else {
			fileName = searchFile("W10312900H0012_QYZXCXMX_", datePath);
		}
		File file = new File(datePath + fileName);
		System.out.println(file);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public static String searchFile(String start, String path) {
		String loadName = null;
		if (new File(path).exists()) {
			File file = new File(path);
			File[] fl = file.listFiles();
			int temp = 0000;
			for (int i = 0; i < fl.length; i++) {
				if (fl[i].isFile()) {
					if (fl[i].getName().startsWith(start)
							&& fl[i].getName().endsWith(".txt")) {
						System.out.println(fl[i].getName());
						int time = Integer.parseInt(fl[i].getName()
								.replace(start, "").replace(".txt", "")
								.substring(11));
						System.out.println(time);
						if (time > temp) {
							loadName = fl[i].getName();
						}

					}
				}
			}
		}
		return loadName;
	}

	/**
	 * 企业查询授权书下载
	 * 
	 * **/
	public static String getMsgTcorpPermitQuery(String id)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select customerConUp from TCorpPermit po where id='" + id
						+ "'");
		String consentFilePath = (String) rootdao.queryByCondition(
				hql.toString()).get(0);
		if (null == consentFilePath) {
			consentFilePath = "";
		}
		File file = new File(consentFilePath);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * 企业查询授权书下载
	 * 
	 * **/
	public static String getMsgIndPermitQuery(String id) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select customerConUp from IndPermit po where id='" + id + "'");
		String consentFilePath = (String) rootdao.queryByCondition(
				hql.toString()).get(0);
		if (null == consentFilePath) {
			consentFilePath = "";
		}
		File file = new File(consentFilePath);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * 
	 * @param loanCardNo
	 * @param queryReason
	 * @return 0：没有许可文件 。1：许可文件过期，2：正常
	 * @throws Exception
	 */
	public String isCompanyExpire(String loanCardNo, String queryReason)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date PermitQuerynowDay = new Date();
		Date today = sdf.parse(sdf.format(PermitQuerynowDay));
		Date indPermitInputTime = null;
		List<TCorpPermit> listTCorpPermitQuery = getTCorpPermitQuery(loanCardNo);
		Date expireDate = null;
		String paramgroupId = "MANAGEMENT";
		String paramId = null;
		if (listTCorpPermitQuery == null || listTCorpPermitQuery.size() == 0) {
			return "0";// 没有许可文件
		} else {
			for (TCorpPermit tCorpPermit : listTCorpPermitQuery) {
				indPermitInputTime = sdf.parse(sdf.format(tCorpPermit.getInputTime()));
				expireDate = sdf.parse(sdf.format(tCorpPermit.getExpireDate()));
			}
			if (queryReason.equals("03")) {
				paramId = "CORP";
			} else {
				paramId = "NO_CORP";
			}

			int lastDate = getparamValue(paramgroupId, paramId);
			Calendar cal = Calendar.getInstance();
			cal.setTime(indPermitInputTime);
			cal.add(Calendar.DAY_OF_YEAR, lastDate);
			long inputTime = cal.getTimeInMillis();
			long expireTime = expireDate.getTime();
			long todayTime = today.getTime();

			if (todayTime > inputTime || todayTime > expireTime) {
				return "1";
			}
			return "2";
		}
	}

	public int getparamValue(String paramgroupId, String paramId)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		String hql = "select po from SysParams po where 1=1 and po.id.paramgroupId = '"
				+ paramgroupId + "' and po.id.paramId = '" + paramId + "'";
		@SuppressWarnings("unchecked")
		// ArrayList<String> condList = new ArrayList<String>();
		// condList.add(paramgroupId);
		// condList.add(paramId);
		List<SysParams> list = rootdao.queryByCondition(hql);
		String last = list.get(0).getParamVal();
		int lastDate = Integer.parseInt(last);
		return lastDate;
	}

	// 根据条件查询企业许可文件
	public List<TCorpPermit> getTCorpPermitQuery(String loanCardNo)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from TCorpPermit po where 1=1 and po.loanCardNo = ? and status='1'";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(loanCardNo);
		@SuppressWarnings("unchecked")
		List<TCorpPermit> list = rootdao.queryByCondition(hql,
				condList.toArray());
		if (null != list && list.size() > 0) {
			return list;
		}
		return null;
	}

	public String isExpire(String idType, String name, String individualId,
			String queryReason) throws Exception {
		String name1 = URLDecoder.decode(name, "utf-8");
		String individualId1 = URLDecoder.decode(individualId, "utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date PermitQuerynowDay = new Date();
		Date today = sdf.parse(sdf.format(PermitQuerynowDay));
		List<IndPermit> listPermitQuery = permitFlag(idType, name1,
				individualId1);
		Date indPermitInputTime = null;
		Date expireDate = null;
		String paramgroupId = "MANAGEMENT";
		String paramId = null;
		if (listPermitQuery == null || listPermitQuery.size() == 0) {
			return "0";
		} else {
			for (IndPermit indPermit2 : listPermitQuery) {
				indPermitInputTime = sdf.parse(sdf.format(indPermit2
						.getInputTime()));
				expireDate = sdf.parse(sdf.format(indPermit2.getExpireDate()));
			}
			if (queryReason.equals("01")) {
				paramId = "IND";
			} else {
				paramId = "NO_IND";
			}
			int lastDate = getparamValue(paramgroupId, paramId);

			Calendar cal = Calendar.getInstance();
			cal.setTime(indPermitInputTime);
			cal.add(Calendar.DAY_OF_YEAR, lastDate);
			long inputTime = cal.getTimeInMillis();
			long expireTime = expireDate.getTime();
			long todayTime = today.getTime();

			if (todayTime > inputTime || todayTime > expireTime) {
				return "1";
			}
			return "2";
		}
	}

	public String isNatureExpire(String idType, String name, String individualId)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date PermitQuerynowDay = new Date();
		Date today = sdf.parse(sdf.format(PermitQuerynowDay));
		List<IndPermit> listPermitQuery = permitFlag(idType, name, individualId);
		Date indPermitInputTime = null;
		Date expireDate = null;
		if (listPermitQuery == null || listPermitQuery.size() == 0) {
			return "0";// 没有许可文件
		} else {
			for (IndPermit indPermit2 : listPermitQuery) {
				indPermitInputTime = sdf.parse(sdf.format(indPermit2
						.getInputTime()));
				expireDate = sdf.parse(sdf.format(indPermit2.getExpireDate()));
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(indPermitInputTime);
			long expireTime = expireDate.getTime();
			long todayTime = today.getTime();

			if (todayTime > expireTime) {
				return "1";
			}
			return "2";
		}
	}

	public boolean isNatureExist(String individualId, String queryTime,
			String rptKey) throws Exception {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		SysParams params = new SysParams();
		params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
				"CORPDETAIL", "FILEPATH"));
		String filePath = params.getParamVal();
		StringBuffer date = new StringBuffer(queryTime);
		date.insert(4, "-").insert(7, "-");
		String datePath = filePath + date + "/Natural/" + rptKey;
		File file = new File(datePath);
		File[] fileList = file.listFiles();
		if (fileList == null) {
			return false;
		}
		String fileName = individualId + "megHtml.html";
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isFile()) {
				System.out.println(fileList[i].getName());
				if (fileList[i].getName().equals(fileName)) {
					return true;
				}

			}
		}
		return false;
	}

	
	public static boolean haveRole(String tlrno,String time,String type) {
		String role = "";
		if("ind".equals(type)){
			role = ",241,242,";
		}else if("corp".equals(type)){
			role = ",243,244,";
		}
		boolean dayOf31 = false;  
		boolean haveRole = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		long nowTime = new Date().getTime();
		long returnTime;
		try {
			returnTime = sdf.parse(time).getTime();
			if((nowTime - returnTime) /  (24 * 60 * 60 * 1000) < 31){ //是否31天内
				dayOf31 = true;
			}
		
		
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			StringBuffer hql = new StringBuffer("select ia from TlrRoleRel ia where ia.tlrno='" + tlrno + "'");
			List<TlrRoleRel> listTlrRoleRel = rootdao.queryByCondition(hql.toString());
			for(int i = 0 ;i < listTlrRoleRel.size();i++){
				TlrRoleRel tlrRoleRel = listTlrRoleRel.get(i);
				if(role.indexOf(tlrRoleRel.getRoleId()) > -1){  //有无权限
					haveRole = true;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return haveRole || dayOf31;
	}
	
	
	
	
	/**
	 * 自然人对外担保查询下载（原始报告）
	 * 
	 * **/
	public static String assureDownloadReport(String rptKey)
			throws CommonException {
		String IndividualId = "";
		String name = "";
		String queryTime = "";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select ia from AssureIndApp ia where ia.rptKey='" + rptKey
						+ "'");
		List<AssureIndApp> listAssureIndApp = rootdao.queryByCondition(hql
				.toString());
		if (listAssureIndApp.size() > 0) {
			rptKey = listAssureIndApp.get(0).getRptKey();
			IndividualId = listAssureIndApp.get(0).getIndividualId();
			name = listAssureIndApp.get(0).getName();
			queryTime = listAssureIndApp.get(0).getQueryTime().toString()
					.substring(0, 10);
			System.out.println(queryTime);
		}
		String fileName = IndividualId + "megHtml" + ".html";
		System.out.println(fileName);
		SysParams params = new SysParams();
		params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
				"ASSURE", "ASSUR_LOAD"));
		String filePath = params.getParamVal();
		String path = filePath + queryTime + "/" + "Assure" + "/" + rptKey;
		System.out.println(path);
		File file = new File(path + "\\" + fileName);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * 自然人对外担保授权书下载
	 * 
	 * **/
	public static String assureDownloadPermit(String id) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select consentFilePath from AssureIndApp where id='" + id
						+ "'");
		String consentFilePath = (String) rootdao.queryByCondition(
				hql.toString()).get(0);
		if (null == consentFilePath) {
			consentFilePath = "";
		}
		File file = new File(consentFilePath);
		System.out.println(file);
		if (file.exists()) {
			return "1";
		} else {
			return "0";
		}
	}

	@SuppressWarnings("unchecked")
	public static String getDataDicNameByNo(Integer dataTypeNo, String dataNo)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select po from DataDic po where 1=1 ");
		hql.append(" and po.dataTypeNo=" + dataTypeNo + " and po.dataNo="
				+ dataNo);
		List<DataDic> list = rootdao.queryByCondition(hql.toString());

		return list.get(0).getDataName();
	}

	public static Boolean cheackPswOld(String userNo, String userPswdOld) {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		StringBuffer hql = new StringBuffer(
				"select po from TlrPbocUser po where 1=1 ");
		hql.append(" and po.userNo=" + userNo + " and po.userPswdOld="
				+ userPswdOld);
		try {
			List<TlrPbocUser> list = rootdao.queryByCondition(hql.toString());
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return false;
	}
	
    public String dealPersonalData(String name,String idType,String idNum,String queryReason,String serviceCode,String flag,String queryLevel) throws AppException {

        try {
       // 	UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        	GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
        	NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
        	String result="已录入，请等待查询";
            Map<String,String> paramMap=new HashMap<String,String>();
            paramMap.put("tlrno", currentInstance.getTlrno());
            paramMap.put("brno", currentInstance.getBrcode());
            paramMap.put("name", name);
            paramMap.put("idType", idType);
            paramMap.put("idNum", idNum);
            paramMap.put("queryReason", queryReason);
            paramMap.put("serviceCode", serviceCode);
            paramMap.put("query_org_code", sysParamsService.getBankCode());
            paramMap.put("user_code", currentInstance.getTlrno());
            paramMap.put("queryLeval", queryLevel);
            OperationContext context = new OperationContext();
            context.setAttribute("CMD", "INSERT");
            context.setAttribute("PersonalMakeMap", paramMap);
            boolean isOk = true;
            String rptId = "";
            String id="";
            if("00".equals(flag)) {
            	OPCaller.call(QueryPersonalOperation.class, context);
                PbocD101Service service = PbocD101Service.getInstance();
                try {
                        QueryResult queryResult = service.queryPersonal(paramMap);
                        if (StringUtils.equals(queryResult.getCode(), "0000")) {
                            logger.info("queryResult = " + queryResult);
                            context.setAttribute("status", "success");
                            rptId = StringUtils.trimToEmpty(queryResult.getId());
                            context.setAttribute("uuid", rptId);
                            context.setAttribute("CMD", "UPDATE");
                            id=(String)context.getAttribute("id");
    	                    context.setAttribute("status", "success");
    	                    context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
    	                    context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
    	                    OPCaller.call(QueryPersonalOperation.class, context);
    	                //    updateReturnBean.setParameter("uuid", rptId);
    	                //    result="success";
                        } else {
                            isOk = false;
                            logger.error("queryResult = " + queryResult);
                            rptId = StringUtils.trimToEmpty(queryResult.getId());
                            context.setAttribute("id", id);	                        
                            context.setAttribute("uuid", rptId);
                            context.setAttribute("CMD", "UPDATE");
                            context.setAttribute("status", "failed");
                            OPCaller.call(QueryPersonalOperation.class, context);
                    //        result="fail";
                            ExceptionUtil.throwCommonException("企业查询失败");
                        }

                } catch (Exception e) {
                    isOk = false;
                    context.setAttribute("id", id);	                        
                    context.setAttribute("uuid", rptId);
                    context.setAttribute("status", "failed");
                    context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
                    context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
                    OPCaller.call(QueryPersonalOperation.class, context);
               //     result="fail";
                    ExceptionUtil.throwCommonException("企业查询异常");
                }
               return rptId;
            }else {
            	 OPCaller.call(QueryPersonalCrawlOperation.class, context);
            	 return result;
            }
        
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }
	
	
	    public String dealCorpData(String entName,String entCertType,String entCertNum,String queryReason,String serviceCode) throws AppException {

	        try {
	        	UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	        	GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
	        	String result="";
	            Map<String,String> paramMap=new HashMap<String,String>();
	            paramMap.put("tlrno", currentInstance.getTlrno());
	            paramMap.put("brno", currentInstance.getBrcode());
	            paramMap.put("entName", entName);
	            paramMap.put("entCertType", entCertType);
	            paramMap.put("entCertNum", entCertNum);
	            paramMap.put("queryReason", queryReason);
	            paramMap.put("serviceCode", "FW_QYXYBG_0043");
	        //    String custCorpId=request.getParameter("id");
	            OperationContext context = new OperationContext();
	            context.setAttribute("CMD", "INSERT");
	            context.setAttribute("CorpMakeMap", paramMap);
	            OPCaller.call(QueryCorpOperation.class, context);
	            boolean isOk = true;
	            String rptId = "";
	            String id="";
	            PbocD103Service service = PbocD103Service.getInstance();
	            try {
	                    QueryResult queryResult = service.queryEnterprise(paramMap);
	                    if (StringUtils.equals(queryResult.getCode(), "0000")) {
	                        logger.info("queryResult = " + queryResult);
	                        context.setAttribute("status", "success");
	                        rptId = StringUtils.trimToEmpty(queryResult.getId());
	                        context.setAttribute("uuid", rptId);
	                        context.setAttribute("CMD", "UPDATE");
	                        id=(String)context.getAttribute("id");
	                        rptId = StringUtils.trimToEmpty(queryResult.getId());
		                    context.setAttribute("rptId", rptId);
		                    context.setAttribute("status", "success");
		                    context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
		                    context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
		                    OPCaller.call(QueryCorpOperation.class, context);
	                    } else if(StringUtils.equals(queryResult.getCode(), PbocConstants.QUERY_EMPTY_XML)){
	                    	isOk = false;
	                    	logger.error("queryResult = " + queryResult);
	                    	rptId = StringUtils.trimToEmpty(queryResult.getId());
	                    	id=(String)context.getAttribute("id");
	                        rptId = StringUtils.trimToEmpty(queryResult.getId());
	                        context.setAttribute("id", id);	                        
	                        context.setAttribute("uuid", rptId);
	                        context.setAttribute("CMD", "UPDATE");
	                        context.setAttribute("status", "failed");
	                        OPCaller.call(QueryCorpOperation.class, context);
	                        ExceptionUtil.throwCommonException("人行返回企业明细信息为空");
	                    }else {
	                        isOk = false;
	                        logger.error("queryResult = " + queryResult);
	                        rptId = StringUtils.trimToEmpty(queryResult.getId());
                            context.setAttribute("id", id);	                        
	                        context.setAttribute("uuid", rptId);
	                        context.setAttribute("CMD", "UPDATE");
	                        context.setAttribute("status", "failed");
	                        OPCaller.call(QueryCorpOperation.class, context);
	                        ExceptionUtil.throwCommonException("企业查询失败");
	                    }

	            } catch (Exception e) {
	                isOk = false;
	                context.setAttribute("id", id);	                        
                    context.setAttribute("uuid", rptId);
                    context.setAttribute("CMD", "UPDATE");
	                context.setAttribute("status", "failed");
	                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
	                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
	                OPCaller.call(QueryCorpOperation.class, context);
	            //    result="fail";
	                ExceptionUtil.throwCommonException("企业查询异常");
	            }
	            return rptId;
	        } catch (AppException appEx) {
	            throw appEx;
	        } catch (Exception ex) {
	            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
	        }
	    }
	  

	    public String dealBatchCorpData(String params) throws AppException {
	           boolean isOk = true;
	            String rptId = "";
	            String id="";
	            OperationContext context = new OperationContext();
	     //       List<String> rptIdList=new ArrayList<String>();
	            List<String> sussessList=new ArrayList<String>();
	            List<String> errList=new ArrayList<String>();
	            List<String> exceptionList=new ArrayList<String>();
	            List<String> emptyList=new ArrayList<String>();
	            PbocD103Service service = PbocD103Service.getInstance();
	            CustPbocEntQueryDAO dao = ROOTDAOUtils.getCustPbocEntQueryDAO();
	        //    context.setAttribute("CMD", "BatchUpdate");
	         //   List list = Arrays.asList(params);
	           String msg="";
	           ArrayList<HashMap<String, String>> list = JsonUtils.toList2(params);
				try {
	                for(int i=0;i<list.size();i++){
	                    Map<String, String> map = list.get(i);
	                    if(!"00".equals(map.get("status"))) {
	         			   context.setAttribute("CMD", "ReQuery"); 
	           			   context.setAttribute("reQueryMap", map);
	           			   OPCaller.call(QueryCorpOperation.class, context);
	         		   }else {
	         			   context.setAttribute("id", (String)map.get("id"));
	         		   }
	                    map.put("serviceCode","FW_QYXYBG_0043");
	                    QueryResult queryResult = service.queryEnterprise(map);
	   		            if (StringUtils.equals(queryResult.getCode(), "0000")) {
	   		                        logger.info("queryResult = " + queryResult);
	   		                        context.setAttribute("status", "success");
	   		                        rptId = StringUtils.trimToEmpty(queryResult.getId());
	   		                        context.setAttribute("uuid", rptId);
	  	                            context.setAttribute("CMD", "UPDATE");
	  	                            id=(String)context.getAttribute("id");
	   		                        context.setAttribute("rptId", rptId);
	   		                        context.setAttribute("status", "success");
	   		                        context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
	   		                        context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
	   		                        OPCaller.call(QueryCorpOperation.class, context);
	   		                        sussessList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
	   		                    }else if(StringUtils.equals(queryResult.getCode(),PbocConstants.QUERY_EMPTY_XML)){
	   		                        context.setAttribute("CMD", "BatchUpdate");
	   	                            id=(String)context.getAttribute("id");
	   		                        isOk = false;
	   		                        logger.error("queryResult = " + queryResult);
	   		                        context.setAttribute("status", "failed");
	   		                        OPCaller.call(QueryCorpOperation.class, context);
	   		                        emptyList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
	   		                    }else {
	   		                        isOk = false;
	   		                        context.setAttribute("CMD", "UPDATE");
	  	                            id=(String)context.getAttribute("id");
	   		                        logger.error("queryResult = " + queryResult);
	   		                        context.setAttribute("status", "failed");
	   		                        OPCaller.call(QueryCorpOperation.class, context);
	   		                        errList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
	   		                    }
	   		                   
	                    
	                }
	                if(sussessList!=null && sussessList.size()>0) {
                     	 StringBuffer sb=new StringBuffer();
                     	 for(String s:sussessList) {
                         	    sb.append(s).append("\r\n");
                            }
                     	 msg="企业标识号码和企业"+"\r\n"+sb+"\r\n"+"的企业查询成功,请至二代企业信用信息查询菜单下查收征信结果！";
                     }
	                if(emptyList!=null && emptyList.size()>0) {
	                   	 StringBuffer sb=new StringBuffer();
	                   	 for(String s:emptyList) {
	                       	    sb.append(s).append("\r\n");
	                          }
	                   	 msg="企业身份标识号码和企业"+"\r\n"+sb+"\r\n"+"的企业查询人行返回明细信息为空！";
	                   }
	                if(errList!=null && errList.size()>0) {
	                   	 StringBuffer sb=new StringBuffer();
	                   	 for(String s:errList) {
	                       	    sb.append(s).append("\r\n");
	                          }
	                     msg="企业身份标识号码和企业"+"\r\n"+sb+"\r\n"+"的企业查询失败！";
	                   } 

	       } catch (Exception e) {
	                isOk = false;
	                context.setAttribute("CMD", "UPDATE");
                    id=(String)context.getAttribute("id");
	                context.setAttribute("status", "failed");
	                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
	                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
	                OPCaller.call(QueryCorpOperation.class, context);
	                exceptionList.add(context.getAttribute("entCertNum").toString()+" "+","+" "+context.getAttribute("entName").toString());
	            }
			    if(exceptionList!=null && exceptionList.size()>0) {
	            	StringBuffer sb=new StringBuffer();
	            	for(String s:exceptionList) {
	            		sb.append(s).append("\r\n");
	            	}
	                 msg="企业身份标识号码和企业"+"\r\n"+sb+"\r\n"+"的企业查询异常！";
	            } 
	            return msg;
	        }
	       
	            
	   public String dealBatchPersonalData(String params) throws AppException {
		   boolean isOk = true;
           String rptId = "";
           OperationContext context = new OperationContext();
        //   List<String> rptIdList=new ArrayList<String>();
           PbocD101Service service = PbocD101Service.getInstance();
           CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
           ArrayList<HashMap<String, String>> list = JsonUtils.toList2(params);
           List<String> sussessList=new ArrayList<String>();
           List<String> errList=new ArrayList<String>();
           List<String> exceptionList=new ArrayList<String>();
           String id="";
           String msg="";
           try {
               for(int i=0;i<list.size();i++){
                   Map<String, String> map = list.get(i);
                   if(!"00".equals(map.get("status"))) {
        			   context.setAttribute("CMD", "ReQuery"); 
          			   context.setAttribute("reQueryMap", map);
          			   OPCaller.call(QueryPersonalOperation.class, context);
        		   }else {
        			   context.setAttribute("id", (String)map.get("id"));
        		   }
                   QueryResult queryResult = service.queryPersonal(map);
  		                    if (StringUtils.equals(queryResult.getCode(), "0000")) {
  		                        logger.info("queryResult = " + queryResult);
  		                        context.setAttribute("CMD", "UPDATE");
  		                        context.setAttribute("status", "success");
  		                        rptId = StringUtils.trimToEmpty(queryResult.getId());
  		                        context.setAttribute("uuid", rptId);
  	                            context.setAttribute("CMD", "UPDATE");
  	                            id=(String)context.getAttribute("id");
  		                        context.setAttribute("status", "success");
  		                        context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
  		                        context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
  		                        OPCaller.call(QueryPersonalOperation.class, context);
  		                //        rptIdList.add(rptId);
  		                      sussessList.add(map.get("idNum").toString()+" "+","+" "+map.get("name").toString());
  		                    } else {
  		                        isOk = false;
  		                        logger.error("queryResult = " + queryResult);
  		                        id=(String)context.getAttribute("id");
  		                        context.setAttribute("CMD", "UPDATE");
  		                        context.setAttribute("status", "failed");
  		                        OPCaller.call(QueryPersonalOperation.class, context);
  		                        errList.add(map.get("idNum").toString()+" "+","+" "+map.get("name").toString());
  		                     //   ExceptionUtil.throwCommonException("个人查询失败");
  		                    }
               }
               if(sussessList!=null && sussessList.size()>0) {
                 	 StringBuffer sb=new StringBuffer();
                 	 for(String s:sussessList) {
                     	    sb.append(s).append("\r\n");
                        }
                 	 msg="个人身份证号和姓名"+"\r\n"+sb+"\r\n"+"的个人查询成功,请至二代个人信用信息查询菜单下查收征信结果！";
                 }
               if(errList!=null && errList.size()>0) {
               	 StringBuffer sb=new StringBuffer();
               	 for(String s:errList) {
                   	    sb.append(s).append("\r\n");
                      }
               	 msg="个人身份证号和姓名"+"\r\n"+sb+"\r\n"+"的个人查询失败！";
               }
            } catch (Exception e){
               isOk = false;
               id=(String)context.getAttribute("id");
               context.setAttribute("CMD", "UPDATE");
               context.setAttribute("status", "failed");
               context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
               context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
               OPCaller.call(QueryPersonalOperation.class, context);
               exceptionList.add(context.getAttribute("idNum").toString()+" "+","+" "+context.getAttribute("name").toString());
             //  ExceptionUtil.throwCommonException("个人查询异常");
           }
           if(exceptionList!=null && exceptionList.size()>0) {
             	 StringBuffer sb=new StringBuffer();
             	 for(String s:exceptionList) {
                 	    sb.append(s).append("\r\n");
                    }
             	 msg="个人身份证号和姓名"+"\r\n"+sb+"\r\n"+"的个人查询异常！";
             }
           return msg;
	   }
	    
	    
	   public String  RematchMessage(String qworkDateStart,String qworkDateEnd,String brcode,String fileflag ){
			List list = null;
			String msg="无可用数据，请查询后重新匹配";
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			StringBuilder hql = new StringBuilder(" SELECT model FROM "+fileflag+" model WHERE status="+QueryUntils.Default+" ");
			if (!DataFormat.isEmpty(qworkDateStart)) {
				hql.append(" and fileGenTime  >= '"+qworkDateStart+"000000"+"'");	
			}
			if (!DataFormat.isEmpty(qworkDateEnd)) {
				hql.append(" and fileGenTime  <= '"+qworkDateEnd+"240000"+"' ");
			}
			if (!DataFormat.isEmpty(brcode)) {
				hql.append(" and RSV3='"+brcode+"'");
			}
			try {
				list = rootdao.queryByQL2List(hql.toString());
				if (list!=null) {
					if (list.size()!=0) {
						for (int i = 0; i < list.size(); i++) {
							if (fileflag.equals("CrPbocD503")) {
								CrPbocD503 bean = (CrPbocD503) list.get(i);	
								int size=QueryUntils.QueryMatching(bean.getEntCertNum(), DataMyUtil.get16Date());
								if (size>0) {
									bean.setStatus(QueryUntils.Successful);
									rootdao.save(bean);
								}
							}else if (fileflag.equals("CrPbocD501")) {
								CrPbocD501 bean = (CrPbocD501) list.get(i);	
								int size=QueryUntils.QueryMatching(bean.getIdNum(), DataMyUtil.get16Date());
								if (size>0) {
									bean.setStatus(QueryUntils.Successful);
									rootdao.save(bean);
								}
							}
				
						
						}
			    	msg="信息已经重新匹配，请检查并重新查询";
					}
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}

		   return msg;
	   }
	   
		private static String getDataExtraction2(String dataTypeNo) throws CommonException {
			 GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
			 DataExtractionEntity bean = null;
			 String tlrNo;
			 StringBuffer sql = new StringBuffer();
			 String dataNo = null;
			try {
				  tlrNo=currentInstance.getTlrno();
				  if("503".equals(dataTypeNo)) {
					  sql.append("select B.data_no as dataNo from TLR_INFO A inner join DATA_DIC B on A.city=B.data_no where 1=1");
				  }else {
					  sql.append("select B.data_no as dataNo from TLR_INFO A inner join DATA_DIC B on A.department=B.data_no where 1=1");					  
				  }
			      if (!DataFormat.isEmpty(tlrNo)) {
		            	 sql.append(" and A.TLRNO='").append(tlrNo).append("' ");			
		             }
			      sql.append("and B.data_Type_No").append("=").append("'").append(dataTypeNo).append("'");
			      ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			      Iterator it = rootdao.queryBySQL(sql.toString());
			      while(it.hasNext()) {
			    	  Map map = (Map)it.next();
			    	  if (map.get("DATANO") != null) {
			    		  dataNo= map.get("DATANO").toString();
			    	  }
			      }
			} catch (Exception e1) {
			     
			}
			return dataNo;
		 }
		
		/**
		 * 二代个人原始报告下载检验文件是否存在
		 * QX
		 * **/
			public static String test33(String respId) throws CommonException {
				String RSV9 = "";
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
				StringBuffer hql = new StringBuffer(
						"select cppq from CustPbocPerQuery cppq  where cppq.respId ='" + respId + "'");
				List<CustPbocPerQuery> list = rootdao.queryByCondition(hql.toString());
				if (list.size() > 0) {
					RSV9 = list.get(0).getRsv9();
				}
				File file = new File(RSV9);
				System.out.println(file);
				if (file.exists()) {
					return "1";
				} else {
					return "0";
				}
			}
	   
/*	private static List<DataExtractionEntity> getDataExtraction() throws CommonException {
		 GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
		 DataExtractionEntity bean = null;
		 String tlrNo;
		 StringBuffer sql = new StringBuffer();
		 List<DataExtractionEntity> list = new ArrayList<DataExtractionEntity>();
		try {
			  tlrNo=currentInstance.getTlrno();
		      sql.append("select distinct (select data_name from data_dic where data_no=city and DATA_TYPE_NO='503.00') as 'city',\n" + 
		      		"(select data_name from data_dic where data_no=DEPARTMENT and DATA_TYPE_NO='501.00') as 'department'\n" + 
		      		" from TLR_INFO A left join CUST_PBOC_ENT_QUERY B on A.TLRNO=B.CREATE_USER where 1=1 "); 
		      if (!DataFormat.isEmpty(tlrNo)) {
	            	 sql.append(" and  A.TLRNO='").append(tlrNo).append("' ");			
	             }
		      sql.append("  group by  city ,department");
		      ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		      Iterator it = rootdao.queryBySQL(sql.toString());
		      while (it.hasNext()) {
		        Map map = (Map)it.next();
		        bean = new DataExtractionEntity();
		        if (map.get("city") != null)
		          bean.setCity(map.get("city").toString());
		        if (map.get("department") != null)
		          bean.setDepartment(map.get("department").toString());
		        list.add(bean);
		      }
		} catch (Exception e1) {
		     
		}
		return list;
	 }*/
	 
	public String getCityNo() throws CommonException {
		return getDataExtraction2("503");
	 }
	public String getReginonNo() throws CommonException {
		return getDataExtraction2("501");
	 }
	  
	  
}
