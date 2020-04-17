package com.huateng.excel.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.service.NewSysParamsService;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.FilePermissonUtils;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.SM3;
import com.huateng.report.utils.ZdIbScoreBizLogUtils;
import com.huateng.report.ws.WSDLClient;

import resource.bean.crms.CrPbocD501;
import resource.bean.crms.CrPbocD503;
import resource.bean.crms.IbscoreBatchqueryLog;

/**
 * author: kin wong
 *
 * class desc:批量导入统一控制器
 */
public class BatchXLSImportController extends MultiActionController {

	public CommonsMultipartResolver getMultipartResolver() {
		return multipartResolver;
	}

	protected Logger logger = Logger.getLogger(getClass());
	protected String result;// 结果返回页面
	protected CommonsMultipartResolver multipartResolver;// 文件上传

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setMultipartResolver(CommonsMultipartResolver multipartResolver) {
		this.multipartResolver = multipartResolver;
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public ModelAndView uploadBlackName(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		File uploadFile = null;
		MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest mrequest = resolver.resolveMultipart(request);
		String fileflag = mrequest.getParameter("fileflag");
		String workDate = mrequest.getParameter("workDate");
		HttpSession httpSession = request.getSession();
		GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
		GlobalInfo.setCurrentInstance(globalInfo);
		// 封装页面返回对象
		List errorList = new ArrayList();
		ModelMap mmap = new ModelMap();
		mmap.addObject("errors", errorList);
		ModelAndView modelAndView = new ModelAndView(result, mmap);
		try {
			// 验证上传的文件大小限制
			mrequest.setCharacterEncoding("UTF-8");
			MultipartFile file = mrequest.getFile("uploadFile");

			String path = ReportUtils.getSysParamsValue("UPLOAD", "PATH");

			mkdirIfNotExists(path);
			// 上传文件到指定的文件夹（用时间作为文件名保存防止文件重名）
			String currentTime = DataMyUtil.getFullDateTime();
			String fullFileName = path + currentTime + ".xls";
			uploadFile = new File(fullFileName);
			file.transferTo(uploadFile);
			// 获取原上传文件名
			String originalFilename = file.getOriginalFilename();
			if (originalFilename.indexOf("_")==-1) {
				errorList.add("【"+originalFilename+"】文件名称不正确，正确格式为 YYYYMMDD_XXX.xlsx,请下载专用模板");
				return modelAndView;
			}else if ((originalFilename.substring(originalFilename.lastIndexOf("_")+1, originalFilename.lastIndexOf(".")).length()!=3)) {
				errorList.add("【"+originalFilename+"】文件名称不正确，正确格式为 YYYYMMDD_XXX.xlsx,请下载专用模板");
				return modelAndView;
			} else if (QueryUntils.getBatchMessage(fileflag,originalFilename) == 1) {
				// 批次重复
				errorList.add("当前批次信息已经录入，请检查批次信息后重新导入");
				return modelAndView;
			} else {
				if ("CrPbocD503".equals(fileflag)){// 批量导入
					import503xcelData(originalFilename, fullFileName, workDate, globalInfo);
					ZdIbScoreBizLogUtils.setLogToBizLog(globalInfo, "Updater.log",
							new String[] { globalInfo.getTlrno(),
									"部门号:【" + QueryUntils.getRegionNo(globalInfo.getTlrno() + "】"),
									"企业征信批量查询导入-工作日期【" + workDate + "】 文件名称【" + originalFilename + "】" },
							"征信批量查询导入");
				} else if ("CrPbocD501".equals(fileflag)){
					import501xcelData(originalFilename, fullFileName, workDate, globalInfo);
					ZdIbScoreBizLogUtils.setLogToBizLog(globalInfo, "Updater.log",
							new String[] { globalInfo.getTlrno(),
									"部门号:【" + QueryUntils.getRegionNo(globalInfo.getTlrno() + "】"),
									"个人征信批量查询导入-工作日期【" + workDate + "】 文件名称【" + originalFilename + "】" },
							"征信批量查询导入");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("系统内部出错，错误信息：" + e.toString());
		} finally {
			if (uploadFile != null) {
				uploadFile.delete();
			}
		}
		return modelAndView;
	}

	/**
	 * 
	 * @Title: import503xcelData @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param fileName @param @param
	 * filePath @param @param workDate @param @param globalInfo @param @throws
	 * Exception 参数 @return void 返回类型 @throws
	 */
	@SuppressWarnings("resource")
	protected void import503xcelData(String fileName, String filePath, String workDate, GlobalInfo globalInfo)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
		System.out.println("====================================================================");
		System.out.println("===========企业征信批量查询导入开始时间:" + sdf.format(new Date()) + "=================");
		System.out.println("===========导入文件名称：" + fileName + "=============================");
		System.out.println("====================================================================");
		InputStream is = new FileInputStream(new File(filePath));
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		List<String> err_list = new ArrayList<String>();
		String errmsg = null;
		Workbook wb = null;
		if (fileName.endsWith("xlsx")) {// 根据导入文件名称判断读取03还是10版excel
			wb = new XSSFWorkbook(is);
		} else {
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = null;
		int RECORD_QRY_NUM = 0;
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			sheet = wb.getSheetAt(i);
			// 查询记录笔数
			RECORD_QRY_NUM = RECORD_QRY_NUM + sheet.getLastRowNum();
			ArrayList<CrPbocD503> beanlist = new ArrayList<CrPbocD503>();
			CrPbocD503 bean = new CrPbocD503();
			String entName = null;
			String entCertType = null;
			String entCertNum = null;
			String queryReason = null;
			String serviceCode = null;
			// String id = null;
			String REQUESTID = null;
			int error_row = 1;
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				if (sheet.getLastRowNum() > 2000) {
					errmsg = "每个sheet页的数据条数不能超过2000条";
					err_list.add(errmsg);
					break;
				}
				if (!QueryUntils.isBlankRow(sheet.getRow(rowNum))) {
					Row row = sheet.getRow(rowNum);
					error_row = rowNum + 1;
					entName = QueryUntils.getCellStringValue(row.getCell(0)).trim();
					if (entName.length() > 80) {
						errmsg = "企业名称的长度不能超过80";
						err_list.add(errmsg);
						break;
					}
					entCertType = QueryUntils.getCellStringValue(row.getCell(1)).trim();
					if (entCertType.length() > 2) {
						errmsg = "企业身份标识类型的长度不能超过2";
						err_list.add(errmsg);
						break;
					}
					entCertNum = QueryUntils.getCellStringValue(row.getCell(2)).trim();
					if (entCertNum.length() > 40) {
						errmsg = "企业身份标识号码的长度不能超过40";
						err_list.add(errmsg);
						break;
					}

					queryReason = QueryUntils.getCellStringValue(row.getCell(3)).trim();
					if (queryReason.length() > 2) {
						errmsg = "查询原因的长度不能超过2";
						err_list.add(errmsg);
						break;
					}
					serviceCode = QueryUntils.getCellStringValue(row.getCell(4)).trim();
					if (queryReason.length() > 100) {
						errmsg = "服务代码的长度不能超过100";
						err_list.add(errmsg);
						break;
					}
					// 信息记录标识号
					REQUESTID = QueryUntils.getCellStringValue(row.getCell(5)).trim();
					if (REQUESTID.length() > 5) {
						errmsg = "信息记录标识号的长度不能超过5";
						err_list.add(errmsg);
						break;
					}
					// id = QueryUntils.get32UUID();
					bean.setEntCertNum(entCertNum);
					// 根据企业身份标识号进行匹配
					int size = QueryUntils.QueryMatching(entCertNum, DataMyUtil.get16Date());
					if (size > 0) {
						bean.setStatus(QueryUntils.Successful);
					} else {
						bean.setStatus(QueryUntils.Default);
					}
					// 批次。从文件名称获得批次和日期
					bean.setRsv1(fileName.trim().toUpperCase().substring(fileName.lastIndexOf(".") - 3,
							fileName.lastIndexOf(".")));
					bean.setEntCertType(entCertType);
					bean.setEntName(entName);
					// bean.setId(id);
					bean.setQueryReason(queryReason);
					bean.setServiceCode(serviceCode);
					bean.setRequestid(REQUESTID);
					// 备用字段2用来存储YYYYMMDD日期格式，备用字段3来存储部门号
					bean.setRsv2(fileName.trim().toUpperCase().substring(fileName.lastIndexOf("_") - 8,
							fileName.lastIndexOf("_")));
					bean.setRsv3(QueryUntils.getRegionNo(globalInfo.getTlrno()));
					beanlist.add(bean);

				}
			}

			if (err_list.size() > 0) {
				beanlist.clear();
				throw new Exception(
						"sheet[" + sheet.getSheetName() + "]第" + (error_row) + "行数据错误！错误原因：" + err_list.get(0));
			} else {
				// 数据没有问题。进行匹配更新状态值。
				String creatTime = DataMyUtil.getDateTime();
				IbscoreBatchqueryLog IbLog = new IbscoreBatchqueryLog();
				IbLog.setFileName(fileName);
				for (CrPbocD503 csc : beanlist) {
					if (csc != null) {
						// 查询机构代码
						csc.setFileQryCode(globalInfo.getBrcode());
						csc.setUserCode(globalInfo.getTlrno());
						csc.setRecordQryNum(String.valueOf(RECORD_QRY_NUM));
						csc.setFileGenTime(creatTime);
						csc.setCreateUser(globalInfo.getTlrno());
						csc.setCreateTime(creatTime);
						rootdao.save(csc);
						// 存记录表
//						IbLog.setId(csc.getId());
						IbLog.setFileId(csc.getId());				
						IbLog.setCreateTime(creatTime);
						IbLog.setUserId(globalInfo.getTlrno());
						rootdao.save(IbLog);
					}
				}
				beanlist.clear();
			}
			System.out.println("====================================================================");
			System.out.println("===========企业征信查询批量导入结束时间:" + sdf.format(new Date()) + "=================");
			System.out.println("====================================================================");
		}

		wb.close();
		is.close();
	}

	
	/**
	 * 
	* @Title: import501xcelData
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param fileName
	* @param @param filePath
	* @param @param workDate
	* @param @param globalInfo
	* @param @throws Exception    参数
	* @return void    返回类型
	* @throws
	 */
	@SuppressWarnings("resource")
	protected void import501xcelData(String fileName, String filePath, String workDate, GlobalInfo globalInfo)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
		System.out.println("====================================================================");
		System.out.println("===========个人征信批量查询导入开始时间:" + sdf.format(new Date()) + "=================");
		System.out.println("===========导入文件名称：" + fileName + "=============================");
		System.out.println("====================================================================");
		InputStream is = new FileInputStream(new File(filePath));
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

		List<String> err_list = new ArrayList<String>();
		String errmsg = null;
		Workbook wb = null;
		if (fileName.endsWith("xlsx")) {// 根据导入文件名称判断读取03还是10版excel
			wb = new XSSFWorkbook(is);
		} else {
			wb = new HSSFWorkbook(is);
		}
		Sheet sheet = null;
		int RECORD_QRY_NUM = 0;
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			sheet = wb.getSheetAt(i);
			// 查询记录笔数
			RECORD_QRY_NUM = RECORD_QRY_NUM + sheet.getLastRowNum();
			ArrayList<CrPbocD501> beanlist = new ArrayList<CrPbocD501>();
			CrPbocD501 bean = new CrPbocD501();
			String name = null;
			String idType = null;
			String idNum = null;
			String queryReason = null;
			String serviceCode = null;
			// String id = null;
			String REQUESTID = null;
			int error_row = 1;
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				if (sheet.getLastRowNum() > 2000) {
					errmsg = "每个sheet页的数据条数不能超过2000条";
					err_list.add(errmsg);
					break;
				}
				if (!QueryUntils.isBlankRow(sheet.getRow(rowNum))) {
					Row row = sheet.getRow(rowNum);
					error_row = rowNum + 1;
					name = QueryUntils.getCellStringValue(row.getCell(0)).trim();
					if (name.length() > 30) {
						errmsg = "姓名的长度不能超过30";
						err_list.add(errmsg);
						break;
					}
					idType = QueryUntils.getCellStringValue(row.getCell(1)).trim();
					if (idType.length() > 2) {
						errmsg = "信息主体证件类型的长度不能超过2";
						err_list.add(errmsg);
						break;
					}
					idNum = QueryUntils.getCellStringValue(row.getCell(2)).trim();
					if (idNum.length() > 32) {
						errmsg = "信息主体证件号码的长度不能超过32";
						err_list.add(errmsg);
						break;
					}

					queryReason = QueryUntils.getCellStringValue(row.getCell(3)).trim();
					if (queryReason.length() > 2) {
						errmsg = "查询原因的长度不能超过2";
						err_list.add(errmsg);
						break;
					}
					serviceCode = QueryUntils.getCellStringValue(row.getCell(4)).trim();
					if (queryReason.length() > 100) {
						errmsg = "服务代码的长度不能超过100";
						err_list.add(errmsg);
						break;
					}
					// 信息记录标识号
					REQUESTID = QueryUntils.getCellStringValue(row.getCell(5)).trim();
					if (REQUESTID.length() > 5) {
						errmsg = "信息记录标识号的长度不能超过5";
						err_list.add(errmsg);
						break;
					}
					bean.setIdNum(idNum);
					// 根据证件号进行匹配
					int size = QueryUntils.QueryMatching(idNum, DataMyUtil.get16Date());
					if (size > 0) {
						bean.setStatus(QueryUntils.Successful);
					} else {
						bean.setStatus(QueryUntils.Default);
					}
					NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
					bean.setFileStartFlag("A");
					bean.setFileVersion(sysParamsService.getBatchPersonalVer());
					bean.setFileQryCode(sysParamsService.getBankCode());
					bean.setFileGenTime(DateUtils.get14Time());
					bean.setFileType("D501");
					bean.setFileRsv(Constant.RESERVED_FIELD);

					bean.setQueryOrgCode(sysParamsService.getBankCode());
					bean.setUserCode(sysParamsService.getBankUser());
					bean.setPassword(SM3.getHash(sysParamsService.getBankPwd()));
					// 批次。从文件名称获得批次和日期
					bean.setRsv1(fileName.trim().toUpperCase().substring(fileName.lastIndexOf(".") - 3,
							fileName.lastIndexOf(".")));
					bean.setIdType(idType);
					bean.setName(name);
					bean.setQueryReason(queryReason);
					bean.setServiceCode(serviceCode);
					bean.setRequestid(REQUESTID);
					// 备用字段2用来存储YYYYMMDD日期格式，备用字段3来存储部门号
					bean.setRsv2(fileName.trim().toUpperCase().substring(fileName.lastIndexOf("_") - 8,
							fileName.lastIndexOf("_")));
					bean.setRsv3(QueryUntils.getRegionNo(globalInfo.getTlrno()));
					beanlist.add(bean);

				}
			}

			if (err_list.size() > 0) {
				beanlist.clear();
				throw new Exception(
						"sheet[" + sheet.getSheetName() + "]第" + (error_row) + "行数据错误！错误原因：" + err_list.get(0));
			} else {
				// 数据没有问题。进行匹配更新状态值。
				String creatTime = DataMyUtil.getDateTime();
				IbscoreBatchqueryLog IbLog = new IbscoreBatchqueryLog();
				IbLog.setFileName(fileName);
				for (CrPbocD501 csc : beanlist) {
					if (csc != null) {
						// 查询机构代码
						csc.setUserCode(globalInfo.getTlrno());
						csc.setRecordQryNum(String.valueOf(RECORD_QRY_NUM));
						csc.setFileGenTime(creatTime);
						csc.setCreateUser(globalInfo.getTlrno());
						csc.setCreateTime(creatTime);
						csc.setOriginateOrgCode(globalInfo.getBrcode());
						csc.setOriginateUserCode(globalInfo.getTlrno());
						csc.setStatus(Constant.ADD_QUERY_STATUS);
						rootdao.save(csc);
						// 存记录表
//						IbLog.setId(csc.getId());
						IbLog.setFileId(csc.getId());
						IbLog.setCreateTime(creatTime);
						IbLog.setUserId(globalInfo.getTlrno());					
						rootdao.save(IbLog);
					}
				}

				beanlist.clear();
				String content = QueryUntils.writeFileToEnc(fileName, beanlist);
				String signCertNo="";
				String signedTextB64 = HuaTengUtils.getSignResult(content,signCertNo);
		        StringBuffer sb=new StringBuffer();
		        sb.append("{").append("S:").append(signedTextB64).append("}").append("\r\n");
		        WSDLClient ws = WSDLClient.getInstance();
		        String result = ws.queryBatchPersonal(sb.toString());
			}
			System.out.println("====================================================================");
			System.out.println("===========个人征信查询批量导入结束时间:" + sdf.format(new Date()) + "=================");
			System.out.println("====================================================================");
		}

		wb.close();
		is.close();
	}
	/**
	 * 文件目录不存在则创建文件目录，带层级
	 * 
	 * @param path
	 */
	private void mkdirIfNotExists(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
			FilePermissonUtils.setPermission755(path);
		}
	}

}