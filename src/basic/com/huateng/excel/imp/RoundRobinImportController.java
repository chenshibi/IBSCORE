package com.huateng.excel.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.pboc.dao.BizFileImportrecsDao;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.pboc.util.PropertiesUtil;
import com.huateng.report.service.NewSysParamsService;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.FilePermissonUtils;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.ZdIbScoreBizLogUtils;

import resource.bean.crms.BizFileImportrecs;
import resource.bean.crms.CustPbocEntQuery;
import resource.bean.crms.CustPbocPerQuery;

/**
 * 
 * @author Grassy
 *
 */
public class RoundRobinImportController extends MultiActionController {
	
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(RoundRobinImportController.class);

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
		String recordType="";
		if("CustPbocEntQuery".equals(fileflag)){
			recordType="1";
		}else {
			recordType="0";
		}
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
			//记录文件上传记录
	        String operatorName = globalInfo.getTlrno();
	        BizFileImportrecs fileinport = setFileImportrecs(operatorName, uploadFile,recordType);
	        //对上传文件进行判断
			// 获取原上传文件名
			String originalFilename = file.getOriginalFilename();
			String resultInfo = checkFileData(uploadFile,
					fileinport, originalFilename);
			if (originalFilename.indexOf("_")==-1) {
				errorList.add("【"+originalFilename+"】文件名称不正确，正确格式为 YYYYMMDD_XXX.xlsx,请下载专用模板");
				return modelAndView;
			}else if ((originalFilename.substring(originalFilename.lastIndexOf("_")+1, originalFilename.lastIndexOf(".")).length()!=3)) {
				errorList.add("【"+originalFilename+"】文件名称不正确，正确格式为 YYYYMMDD_XXX.xlsx,请下载专用模板");
				return modelAndView;
			} else if (QueryUntils.getBatchMessage(fileflag,originalFilename) == 1) {
				// 批次重复
			//	errorList.add("当前批次信息已经录入，请检查批次信息后重新导入");
				errorList.add("批次信息已完成导入，请修改批次号及导入内容后重新导入");
				return modelAndView;
			}else if((resultInfo != null) && (!resultInfo.equals(""))) {
				errorList.add(resultInfo);
				return modelAndView;
			} else {
				if ("CustPbocEntQuery".equals(fileflag)) {
					 //记录文件上传记录
					 BizFileImportrecsDao dao = ApplicationContextUtils.getBean(BizFileImportrecsDao.class);
			         dao.save(fileinport);
			         logger.info("将文件上传记录保存到数据库结束");
			         // 批量导入
					importCorpExcelData(originalFilename, fullFileName, workDate, globalInfo);
					ZdIbScoreBizLogUtils.setLogToBizLog(globalInfo, "Updater.log",
							new String[] { globalInfo.getTlrno(),
									"部门号:【" + QueryUntils.getRegionNo(globalInfo.getTlrno() + "】"),
									"企业征信批量查询导入-工作日期【" + workDate + "】 文件名称【" + originalFilename + "】" },
							"征信批量查询导入");
				} else if("CustPbocPerQuery".equals(fileflag)){
					 //记录文件上传记录
					 BizFileImportrecsDao dao = ApplicationContextUtils.getBean(BizFileImportrecsDao.class);
			         dao.save(fileinport);
			         logger.info("将文件上传记录保存到数据库结束");
			         // 批量导入
						importPersonalExcelData(originalFilename, fullFileName, workDate, globalInfo);
						ZdIbScoreBizLogUtils.setLogToBizLog(globalInfo, "Updater.log",
								new String[] { globalInfo.getTlrno(),
										"部门号:【" + QueryUntils.getRegionNo(globalInfo.getTlrno() + "】"),
										"企业征信批量查询导入-工作日期【" + workDate + "】 文件名称【" + originalFilename + "】" },
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
     * 设置导入文件记录参数
     *
     * @param uploadFile
     * @return
     */
    public BizFileImportrecs setFileImportrecs(String operatorName, File uploadFile,String recordType) {
        String upLoadFilePath = (String) PropertiesUtil
                .getProperty("upLoadFilePath");
        String errorFilePath = (String) PropertiesUtil
                .getProperty("errorFilePath");
        BizFileImportrecs fileinport = new BizFileImportrecs();
        // 设置主键
        fileinport.setId(UUID.randomUUID().toString());
        fileinport.setFileName(uploadFile.getName());
        fileinport.setFilePath(upLoadFilePath);
        fileinport.setTotalRecords("0");// 总笔数
        fileinport.setSuccessRecords("0");// 成功笔数
        fileinport.setFailRecords("0");// 失败笔数
        fileinport.setImportedBy(operatorName);
        fileinport.setImportedDateTime(DateUtil.get14Time());
        fileinport.setFlag(Constant.FLAG_NEW);
        fileinport.setErrorFilename("");// 错误文件名
        fileinport.setErrorFilepath(errorFilePath);
        fileinport.setImportType(Constant.UPLOAD_EXCEL);// 手工上传EXCEL
        fileinport.setRecordType(recordType);
        return fileinport;
    }

    private String checkFileData(File importFile, BizFileImportrecs fileinport,
                                 String uploadFileName) {

        LOGGER.info("对上传文件进行校验开始");
        File uploadFile = null;
        InputStream iStream = null;
        String returnInfo = null;// 错误返回信息
        try {
            returnInfo = uploadFileName;// 错误返回信息
            uploadFile=importFile;
            // 1.校验文件是否为EXCEL格式，如果不是则，提供错误
            String hzm = uploadFileName.substring(uploadFileName.indexOf("."));// 得到文件后缀名
            LOGGER.info("导入文件后缀名:" + hzm);
            if ((hzm == null)
                    || (((!hzm.toLowerCase().equals(".xls")) && (!hzm
                    .toLowerCase().equals(".xlsx"))))) {
                returnInfo = returnInfo + ";不是EXCEL文件,不能上传";

            }
            // 2.校验文件是否已经上传过，如果上传过，则不允许上传
          /*  BizFileImportrecsDao dao = ApplicationContextUtils.getBean(BizFileImportrecsDao.class);
            List<BizFileImportrecs> fileImportrecsList = dao.findByFileName(fileinport);
            if ((fileImportrecsList != null) && (fileImportrecsList.size() > 0)) {
                  returnInfo = returnInfo + "; 已处理过,同一文件禁止重复上传处理";
            }*/
            if (returnInfo.equals(uploadFileName)) {
                returnInfo = "";
            }
            LOGGER.info("导入文件校验结果：" + returnInfo);
            iStream = new FileInputStream(uploadFile);
        }catch (FileNotFoundException e) {
            returnInfo = "文件不存在:" + uploadFileName;
            return returnInfo;
        } catch (IOException e) {
            LOGGER.info("文件处理异常:", e);
            returnInfo = "文件处理异常:" + e.getMessage();
            return returnInfo;
        }finally {
            if (iStream != null) {
                try {
                    iStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.info("文件处理异常:", e);
                }
            }
            if (!returnInfo.equals("") && uploadFile.exists()) {
                uploadFile.delete();
                LOGGER.info("删除验证失败文件成功");

            }

        }
        return returnInfo;
    }
	
	/**
	 * 
	 * @Title: import503xcelData @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param fileName @param @param
	 * filePath @param @param workDate @param @param globalInfo @param @throws
	 * Exception 参数 @return void 返回类型 @throws
	 */
	@SuppressWarnings("resource")
	protected void importCorpExcelData(String fileName, String filePath, String workDate, GlobalInfo globalInfo)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
		logger.info("===========企业征信批量查询导入开始时间:" + sdf.format(new Date()) + "=================");
		logger.info("===========导入文件名称：" + fileName + "=============================");
		InputStream is = new FileInputStream(new File(filePath));
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
		BusinessUploadService service=new BusinessUploadService();
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
			ArrayList<CustPbocEntQuery> beanlist = new ArrayList<CustPbocEntQuery>();
			String entName = null;
			String entCertType = null;
			String entCertNum = null;
			String queryReason = null;
			String serviceCode = null;
			int error_row = 1;
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				CustPbocEntQuery bean = new CustPbocEntQuery();
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
					entCertType =  entCertType.substring(0,entCertType.lastIndexOf("-"));
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
					queryReason = queryReason.substring(0,queryReason.lastIndexOf("-"));
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
					
					bean.setEntCertNum(entCertNum);
					// 根据企业身份标识号进行匹配
					/*int size = QueryUntils.QueryMatching(entCertNum, DataMyUtil.get16Date());
					if (size > 0) {
						bean.setCertAuthStatus(QueryUntils.Successful);
					} else {
						bean.setCertAuthStatus(QueryUntils.Default);
					}*/
					// 批次。从文件名称获得批次和日期
					bean.setQueryDate(DateUtils.get8Date());
					bean.setRsv2(fileName.trim().toUpperCase().substring(fileName.lastIndexOf(".") - 3,
							fileName.lastIndexOf(".")));
					bean.setEntCertType(entCertType);
					bean.setEntName(entName);
					bean.setQueryReason(queryReason);
					bean.setServiceCode(serviceCode);
					bean.setStatus(Constant.ADD_QUERY_STATUS);
					// 备用字段2用来存储YYYYMMDD日期格式，备用字段3来存储部门号
					/*bean.setRsv3(fileName.trim().toUpperCase().substring(fileName.lastIndexOf("_") - 8,
							fileName.lastIndexOf("_")).substring(0, 6));*/
					bean.setRsv4(QueryUntils.getRegionNo(globalInfo.getTlrno()));
					bean.setRsv7(GlobalInfo.getCurrentInstance().getIp());
					bean.setRsv8(sysParamsService.getBankCode());
					bean.setRsv9(globalInfo.getTlrno());
				    bean.setQueryLevel("0");
				    bean.setCertAuthStatus(QueryUntils.Successful);
				//	bean.setImportBy("0");
				//	List<TCorpPermit> list = service.getTCorpPermitQuery2(entCertNum,new Date());
				/*	if(list!=null&&list.size()>0 ) {
						bean.setRsv10((list.get(0).getId().toString()));
					}else {
						bean.setCertAuthStatus(QueryUntils.Default);
					}*/
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
				for (CustPbocEntQuery csc : beanlist) {
					if (csc != null) {
						csc.setCreateUser(globalInfo.getTlrno());
						csc.setCreateTime(creatTime);
						rootdao.save(csc);
					}
				}
				beanlist.clear();
			}
			logger.info("===========企业征信查询批量导入结束时间:" + sdf.format(new Date()) + "=================");
		}

		wb.close();
		is.close();
	}
	

	/**
	 * 
	 * @Title: import503xcelData @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param fileName @param @param
	 * filePath @param @param workDate @param @param globalInfo @param @throws
	 * Exception 参数 @return void 返回类型 @throws
	 */
	@SuppressWarnings("resource")
	protected void importPersonalExcelData(String fileName, String filePath, String workDate, GlobalInfo globalInfo)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
		logger.info("===========个人征信批量查询导入开始时间:" + sdf.format(new Date()) + "=================");
		logger.info("===========导入文件名称：" + fileName + "=============================");
		InputStream is = new FileInputStream(new File(filePath));
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
		BusinessUploadService service=new BusinessUploadService();
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
			ArrayList<CustPbocPerQuery> beanlist = new ArrayList<CustPbocPerQuery>();
			String name = null;
			String idType = null;
			String idNum = null;
			String queryReason = null;
			String serviceCode = null;
			int error_row = 1;
			for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
				CustPbocPerQuery bean = new CustPbocPerQuery();
				if (sheet.getLastRowNum() > 2000) {
					errmsg = "每个sheet页的数据条数不能超过2000条";
					err_list.add(errmsg);
					break;
				}
				if (!QueryUntils.isBlankRow(sheet.getRow(rowNum))) {
					Row row = sheet.getRow(rowNum);
					error_row = rowNum + 1;
					name = QueryUntils.getCellStringValue(row.getCell(0)).trim();
					if (name.length() > 80) {
						errmsg = "个人姓名的长度不能超过80";
						err_list.add(errmsg);
						break;
					}
					idType = QueryUntils.getCellStringValue(row.getCell(1)).trim();
					idType=idType.substring(0,idType.lastIndexOf("-"));
					
					if (idType.length() > 2) {
						errmsg = "个人证件类型的长度不能超过2";
						err_list.add(errmsg);
						break;
					}
					idNum = QueryUntils.getCellStringValue(row.getCell(2)).trim();
					if (idNum.length() > 40) {
						errmsg = "个人证件号码的长度不能超过40";
						err_list.add(errmsg);
						break;
					}

					queryReason = QueryUntils.getCellStringValue(row.getCell(3)).trim();
					queryReason =  queryReason.substring(0,queryReason.lastIndexOf("-"));
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
					
				    bean.setIdNum(idNum);
					// 根据证件类型、姓名、证件号码进行匹配
			/*	    List<IndPermit> list=service.getIndPermitQuery(idType,name,idNum);
				    if(list!=null&&list.size()>0 ) {
				    	bean.setCertAuthStatus(QueryUntils.Successful);
						bean.setRsv10((list.get(0).getId().toString()));
					}else {
						bean.setCertAuthStatus(QueryUntils.Default);
					}*/
					/*int size = QueryUntils.QueryMatchingPersoanl(idNum, DataMyUtil.get16Date());
					if (size > 0) {
						bean.setCertAuthStatus(QueryUntils.Successful);
					} else {
						bean.setCertAuthStatus(QueryUntils.Default);
					}*/
				    bean.setCertAuthStatus(QueryUntils.Successful);
				    bean.setQueryDate(DateUtils.get8Date());
					bean.setRsv2("01"); 
					bean.setRsv5(fileName.trim().toUpperCase().substring(fileName.lastIndexOf(".") - 3,
							fileName.lastIndexOf(".")));
					bean.setIdType(idType);
					bean.setName(name);
					bean.setQueryReason(queryReason);
					bean.setServiceCode(serviceCode);
					bean.setStatus(Constant.ADD_QUERY_STATUS);
					// 备用字段3用来存储YYYYMM日期格式
					/*bean.setRsv3(fileName.trim().toUpperCase().substring(fileName.lastIndexOf("_") - 8,
							fileName.lastIndexOf("_")).substring(0, 6));*/
					//备用字段4来存储部门号
					bean.setRsv4(QueryUntils.getRegionNo(globalInfo.getTlrno()));
					bean.setRsv7(GlobalInfo.getCurrentInstance().getIp());
					bean.setRsv8(sysParamsService.getBankCode());
				//	bean.setRsv9(globalInfo.getTlrno());
				//	bean.setImportBy("0");
					bean.setQueryLevel("0");
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
				for (CustPbocPerQuery csc : beanlist) {
					if (csc != null) {
						csc.setCreateUser(globalInfo.getTlrno());
						csc.setCreateTime(creatTime);
						rootdao.save(csc);
					}
				}
				beanlist.clear();
			}
			logger.info("===========个人征信查询批量导入结束时间:" + sdf.format(new Date()) + "=================");
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