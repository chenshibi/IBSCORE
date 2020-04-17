package com.huateng.ebank.business.customer.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;

import jxl.Sheet;
import jxl.Workbook;
import resource.bean.basic.CorpCust;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.IndScrubInfo;
import resource.bean.basic.InqCust;
import resource.bean.basic.SysParams;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.TCorpDetailApp;
import resource.bean.basic.TCorpPermit;


public class BusinessUploadService {

	private static final String DATASET_ID = "BusinessUploadService";
	private static final HtLog htlog = HtLogFactory.getLogger(BusinessUploadService.class);

	private ROOTDAO rootDao;

	public synchronized static BusinessUploadService getInstance() {
		return (BusinessUploadService) ApplicationContextUtils.getBean(DATASET_ID);
	}

	public <T> void delete(String id, Class classs) throws CommonException {
		rootDao = ROOTDAOUtils.getROOTDAO();
		rootDao.delete(classs, id);
	}

	public <T> void save(T t) throws CommonException {
		rootDao = ROOTDAOUtils.getROOTDAO();
		rootDao.saveOrUpdate(t);
	}

	public <T> void update(T t) throws CommonException {

		rootDao = ROOTDAOUtils.getROOTDAO();
		rootDao.saveOrUpdate(t);

	}

	// 获得要操作的Item
	@SuppressWarnings("unchecked")
	public Iterator selectByid(String id, String hql) {
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();

		try {
			return rootDAO.queryByQL(hql);
		} catch (CommonException e) {
			e.printStackTrace();
			return null;
		}

	}

	// 通过id来获取实体映射类
	@SuppressWarnings("unchecked")
	public <T> T selectById(String id, T t) {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		T t1 = null;
		try {
			t1 = (T) rootdao.query(t.getClass(), id);
		} catch (CommonException e) {
			htlog.info("对象不存在");
			e.printStackTrace();
		}
		return t1;
	}

	public void deleteBySql(String sql) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		rootdao.executeSql(sql);
	}

	public void updateBySql(String sql) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		rootdao.executeSql(sql);
	}

	@SuppressWarnings("unchecked")
	public List<IndApp> queryIndApp(FormFile excelFile) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		InputStream in;
		try {
			in = excelFile.getInputStream();
			Workbook book = Workbook.getWorkbook(in);
			Sheet sheet = book.getSheet(0);
			int rownum = sheet.getRows();// 行数
			for (int i = 1; i < rownum; i++) {// 从第二行开始
				String name = sheet.getCell(0, i).getContents();
				String idType = sheet.getCell(1, i).getContents();
				String individualId = sheet.getCell(2, i).getContents();
				String sql = "select po from IndApp po where 1=1 and  po.idType = '"
						+ idType
						+ "' and po.name='"
						+ name
						+ "' and po.individualId='" + individualId + "'";
				@SuppressWarnings("unchecked")
				List<IndApp> list = rootdao.queryByCondition(sql);

				return list;
			}
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("查询IndApp表失败！");
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<TCorpApp> queryTCorpApp(FormFile excelFile)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		InputStream in;
		try {
			in = excelFile.getInputStream();
			Workbook book = Workbook.getWorkbook(in);
			Sheet sheet = book.getSheet(0);
			int rownum = sheet.getRows();// 行数
			for (int i = 1; i < rownum; i++) {// 从第二行开始
				String corpName = sheet.getCell(9, i).getContents();
				String loanCardNo = sheet.getCell(10, i).getContents();
				String sql = "select po from TCorpApp po where 1=1 and  po.corpName = '"
						+ corpName + "' and po.loanCardNo='" + loanCardNo + "'";
				@SuppressWarnings("unchecked")
				List<TCorpApp> list = rootdao.queryByCondition(sql);

				return list;
			}
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("查询IndApp表失败！");
			e.printStackTrace();
		}
		return null;
	}

	// 根据条件查ind_app
	public List<IndApp> getIndApp(String idType, String name,
			String individualId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String sql = "select po from IndApp po where 1=1 and  po.idType = ? and po.name = ? and po.individualId = ? order by input_time desc";
		@SuppressWarnings("unchecked")
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(idType);
		condList.add(name);
		condList.add(individualId);
		List<IndApp> list = rootdao.queryByCondition(sql, condList.toArray());
		return list;
	}

	// 根据条件查ind_app 查询原因是主借款人
	public List<IndApp> getIndAppQuery1(String idType, String name,
			String individualId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String sql = "select po from IndApp po where 1=1 and  po.idType = ? and po.name = ? and po.individualId = ?  and (status<>'10' or status<>'11')order by input_time desc";
		@SuppressWarnings("unchecked")
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(idType);
		condList.add(name);
		condList.add(individualId);
		List<IndApp> list = rootdao.queryByCondition(sql, condList.toArray());
		return list;
	}

	// 根据条件查ind_app 查询原因是担保人
	@SuppressWarnings("unchecked")
	public List<IndApp> getIndAppQuery(String idType, String name,
			String individualId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String sql = "select po from IndApp po where 1=1 and  po.idType = '"+idType+"' and po.name = '"+name+"' and po.individualId = '"+individualId+"' order by input_time desc";
		//【queryByCondition方法查不到表里已经存在的相同记录,故替换方法】
//		ArrayList<String> condList = new ArrayList<String>();
//		condList.add(idType);
//		condList.add(name);
//		condList.add(individualId);
//		@SuppressWarnings("unchecked")
//		List<IndApp> list = rootdao.queryByCondition(sql, condList.toArray());
		List<IndApp> list = rootdao.queryByQL2List(sql);
		if (null != list && list.size() > 0) {
			IndApp indapp = (IndApp) list.get(0);
			Date returnTime = indapp.getReturnTime();
			if (returnTime != null) {
				int r = getR("EMERGENCY", "IND");
				boolean blean = checkReportInrDays(returnTime, r);
				if (blean) {
					return list;
				}
			}
		}
		return null;
	}

	// 根据条件查ind_Permit 校验有无许可证
	public List<IndPermit> getIndPermitQuery(String idType, String name,
			String individualId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();//INDIVIDUAL_ID
		                                            //individualId
		String hql = "select po from IndPermit po where 1=1 and status='1' and po.idType ='"+idType+"' and po.name = '"+name+"' and po.individualId ='"+individualId+"' ";
		@SuppressWarnings("unchecked")
//		ArrayList<String> condList = new ArrayList<String>();
//		condList.add(idType);
//		condList.add(name);
//		condList.add(individualId);
		//List<IndPermit> list = rootdao.queryByCondition(hql, condList.toArray());
		List<IndPermit> list = rootdao.queryByQL2List(hql);
		return list;
	}
			//查为空,已替换为上面的方法.
	/*public List<IndPermit> getIndPermitQuery(String idType, String name,
			String individualId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from IndPermit po where 1=1 and status='1' and po.idType = ? and po.name = ? and po.individualId = ? ";
		@SuppressWarnings("unchecked")
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(idType);
		condList.add(name);
		condList.add(individualId);
		List<IndPermit> list = rootdao
				.queryByCondition(hql, condList.toArray());
		return list;
	}*/
	
	// 二代根据条件查ind_Permit 校验有无许可证
	public List<IndPermit> getIndPermitQuery3(String idType, String name,
			String individualId,Date date) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from IndPermit po where 1=1 and status='1' and po.idType = ? and po.name = ? and po.individualId = ? "
				+ "and po.expireDate >= ? ";
		@SuppressWarnings("unchecked")
		ArrayList<Object> condList = new ArrayList<Object>();
		condList.add(idType);
		condList.add(name);
		condList.add(individualId);
		condList.add(date);
		List<IndPermit> list = rootdao
				.queryByCondition(hql, condList.toArray());
		return list;
	}

	public List<CorpCust> getCorpCust(String loanCardId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select co from CorpCust co where 1=1 and co.corpCustLoancard = ?  order by createTime desc";
		@SuppressWarnings("unchecked")
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(loanCardId);
		List<CorpCust> list = rootdao.queryByCondition(hql, condList.toArray());
		return list;
	}

	// 根据条件查TCorpApp
	public List<TCorpApp> getTCorpAppQuery(String loanCardNo)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from TCorpApp po where 1=1 and po.loanCardNo = ?  order by input_time desc";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(loanCardNo);
		@SuppressWarnings("unchecked")
		List<TCorpApp> list = rootdao.queryByCondition(hql, condList.toArray());
		if (null != list && list.size() > 0) {
			TCorpApp corpapp = (TCorpApp) list.get(0);
			Date returnTime = corpapp.getReturnTime();
			if (returnTime != null) {
				int r = getR("EMERGENCY", "CORP");
				boolean blean = checkReportInrDays(returnTime, r);
				if (blean) {
					return list;
				}
			}
		}
		return null;
	}

	// 根据条件查InqCust
	public List<InqCust> getInqCustQuery(String Name, String CustId,
			String CustIdType) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from InqCust po where 1=1 and po.inqCustName = ? and po.inqCustId = ? and po.inqCustIdType = ? order by id desc";
		@SuppressWarnings("unchecked")
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(Name);
		condList.add(CustId);
		condList.add(CustIdType);
		List<InqCust> list = rootdao.queryByCondition(hql, condList.toArray());
		return list;
	}

	@SuppressWarnings("unused")
	/**
	 *判断日期是否在30天内
	 * @param inputTime
	 * @return
	 */
	public boolean checkReportIn30Days(Date inputTime) {
		if (DateUtil.getDaysBetween(inputTime, DateUtil.getCurrentDate()) < 30) {
			return true;
		}
		return false;
	}

	public int getR(String paramgroupId, String paramId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(paramgroupId);
		condList.add(paramId);
		@SuppressWarnings("unchecked")
		List<SysParams> list = rootdao
				.queryByCondition(hql, condList.toArray());
		String value = list.get(0).getParamVal();
		int r = Integer.parseInt(value);
		return r;
	}

	public boolean checkReportInrDays(Date returnTime, int r) {
		if (DateUtil.getDaysBetween(returnTime, DateUtil.getCurrentDate()) < r) {
			return true;
		}
		return false;
	}

	public Boolean isExpire(List<IndPermit> listPermitQuery, String queryReason)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date PermitQuerynowDay = new Date();
		Date today = sdf.parse(sdf.format(PermitQuerynowDay));
		Date indPermitInputTime = null;
		Date expireDate = null;
		String paramgroupId = "MANAGEMENT";
		String paramId = null;
		for (IndPermit indPermit2 : listPermitQuery) {
			indPermitInputTime = sdf
					.parse(sdf.format(indPermit2.getInputTime()));
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
		Date date = cal.getTime();
		long inputTime = cal.getTimeInMillis();
		long expireTime = expireDate.getTime();
		long todayTime = today.getTime();

		if (todayTime > inputTime || todayTime > expireTime) {
			return false;
		}
		return true;
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

	public List<TCorpDetailApp> getTCorpDetailAppQuery(String loanCardId)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from TCorpDetailApp po where 1=1 and po.loanCardNo = ?  order by input_time desc";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(loanCardId);
		@SuppressWarnings("unchecked")
		List<TCorpDetailApp> list = rootdao.queryByCondition(hql,
				condList.toArray());
		if (null != list && list.size() > 0) {
			TCorpDetailApp tCorpDetailApp = (TCorpDetailApp) list.get(0);
			Date returnTime = tCorpDetailApp.getReturnTime();
			if (returnTime != null) {
				int r = getR("EMERGENCY", "CORP");
				boolean blean = checkReportInrDays(returnTime, r);
				if (blean) {
					return list;
				}
			}
		}
		return null;
	}

	public List<IndScrubInfo> getIndScrubInfoQuerycount()
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select count(id) from IndScrubInfo where status = '2' ";

		List<IndScrubInfo> list = rootdao.queryByCondition(hql);
		return list;
	}

	public Boolean isCompanyExpire(List<TCorpPermit> listTCorpPermitQuery,
			String queryReason) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date PermitQuerynowDay = new Date();
		Date today = sdf.parse(sdf.format(PermitQuerynowDay));
		Date indPermitInputTime = null;
		Date expireDate = null;
		String paramgroupId = "MANAGEMENT";
		String paramId = null;
		for (TCorpPermit tCorpPermit : listTCorpPermitQuery) {
			indPermitInputTime = sdf.parse(sdf.format(tCorpPermit
					.getInputTime()));
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
			return false;
		}
		return true;
	}

	// 根据条件查询企业许可文件
	/*public List<TCorpPermit> getTCorpPermitQuery(String loanCardNo)
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
	}*/
	
	// 根据条件查询企业许可文件
		public List<TCorpPermit> getTCorpPermitQuery(String loanCardNo)
				throws CommonException {
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String hql = "select po from TCorpPermit po where 1=1 and po.loanCardNo = '"+loanCardNo+"' and status='1'";
//			ArrayList<String> condList = new ArrayList<String>();
//			condList.add(loanCardNo);
			@SuppressWarnings("unchecked")
//			List<TCorpPermit> list = rootdao.queryByCondition(hql,
//					condList.toArray());
			List<TCorpPermit> list = rootdao.queryByQL2List(hql);
			if (null != list && list.size() > 0) {
				return list;
			}
			return null;
		}
	
	
	// 二代根据条件查询企业许可文件
	public List<TCorpPermit> getTCorpPermitQuery2(String loanCardNo,Date date)
			throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select po from TCorpPermit po where 1=1 and po.loanCardNo = ?  and status='1' and po.expireDate>=?";
		ArrayList<Object> condList = new ArrayList<Object>();
		condList.add(loanCardNo);
		condList.add(date);
		@SuppressWarnings("unchecked")
		List<TCorpPermit> list = rootdao.queryByCondition(hql,
				condList.toArray());
		if (null != list && list.size() > 0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings({ "unchecked" })
	public boolean checkStatus(String loanCardNo) throws CommonException {
		String status="";
		String statusc="";
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = "select cc from CorpCust cc where 1=1 and cc.corpCustLoancard = ?  order by create_time desc";
		ArrayList<String> condList = new ArrayList<String>();
		condList.add(loanCardNo);
		List<CorpCust> list = rootdao.queryByCondition(hql, condList.toArray());
		if (null != list && list.size() > 0) {
			String hql1 = "select po from TCorpApp po where 1=1 and po.id = ?  order by input_time desc";
			ArrayList<Integer> condList1 = new ArrayList<Integer>();
			condList1.add(list.get(0).getCorpCustAppid());
			List<TCorpApp> list1 = rootdao.queryByCondition(hql1, condList1.toArray());
			if(list.get(0).getCorpCustDetailId()!=null)
			 {
				String hql2 = "select ta from TCorpDetailApp ta where 1=1 and ta.id = ?  order by input_time desc";
				ArrayList<Integer> condList2 = new ArrayList<Integer>();
				condList2.add(list.get(0).getCorpCustDetailId());
				List<TCorpDetailApp> list2 = rootdao.queryByCondition(hql2, condList2.toArray());
				if(list2.size()==0){
					return true;
				}else{
					statusc=list2.get(0).getStatus();
				}
			}
			if (list1.size() == 0) {
				return true;
			}else{
				status=list1.get(0).getStatus();
			}
			if(status.equals("0")||status.equals("1")||status.equals("2")||status.equals("4")||status.equals("9")||status.equals("")){
				if(statusc.equals("0")||statusc.equals("1")||statusc.equals("2")||statusc.equals("4")||statusc.equals("9")||statusc.equals("")){
					return true;
				}
			}
			return false;
		}
		return true;
	}
}
