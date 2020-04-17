package com.huateng.excel.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.FilePermissonUtils;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.ZdIbScoreBizLogUtils;

import resource.bean.basic.IndPermit;
import resource.bean.basic.TCorpPermit;
import resource.bean.crms.IbsQueryExpire;
/**
 * 
 * @author Grassy
 *
 */
public class QueryExpireXLSImportController extends MultiActionController {

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

			String path = ReportUtils.getSysParamsValue("EXPIRE", "PATH");
			mkdirIfNotExists(path);
			// 上传文件到指定的文件夹（用时间作为文件名保存防止文件重名）
			String currentTime = DataMyUtil.getFullDateTime();
			String fullFileName = currentTime+ ".xls";
			uploadFile = new File(fullFileName);
			file.transferTo(uploadFile);
			// 获取原上传文件名
			String originalFilename = file.getOriginalFilename();
				if ("1".equals(fileflag)) {// 导入
					insertData(originalFilename, fullFileName, workDate, globalInfo);
					ZdIbScoreBizLogUtils.setLogToBizLog(globalInfo, "Updater.log",
							new String[] { globalInfo.getTlrno(),
									"部门号:【" + QueryUntils.getRegionNo(globalInfo.getTlrno() + "】"),
									"查询文件有效期设置导入-工作日期【" + workDate + "】 文件名称【" + originalFilename + "】" },
							"查询文件有效期设置导入");
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
	protected void insertData(String fileName, String filePath, String workDate, GlobalInfo globalInfo)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
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
	    sheet = wb.getSheetAt(0);
			// 查询记录笔数
			RECORD_QRY_NUM = RECORD_QRY_NUM + sheet.getLastRowNum();
			ArrayList<IbsQueryExpire> beanlist = new ArrayList<IbsQueryExpire>();
			String centralCode = null;
			String clientLeId = null;
			String customerName = null;
		    String expireTime = null;
		    String status=null;
		    String userName=null;
			int error_row = 1;
			for (int rowNum = 1; rowNum <= RECORD_QRY_NUM; rowNum++) {
				IbsQueryExpire bean = new IbsQueryExpire();
				if (sheet.getLastRowNum() > 2000) {
					errmsg = "每个sheet页的数据条数不能超过2000条";
					err_list.add(errmsg);
					break;
				}
				if (!QueryUntils.isBlankRow(sheet.getRow(rowNum))) {
					Row row = sheet.getRow(rowNum);
					error_row = rowNum + 1;
					userName = QueryUntils.getCellStringValue(row.getCell(0)).trim();
					if (userName.length() > 40) {
						errmsg = "用户姓名的长度不能超过40";
						err_list.add(errmsg);
						break;
					}
					centralCode = QueryUntils.getCellStringValue(row.getCell(1)).trim();
					if (centralCode.length() > 32) {
						errmsg = "中征码的长度不能超过32";
						err_list.add(errmsg);
						break;
					}
					clientLeId = QueryUntils.getCellStringValue(row.getCell(2)).trim();
					if (clientLeId.length() > 50) {
						errmsg = "Client LEID的长度不能超过50";
						err_list.add(errmsg);
						break;
					}
					customerName = QueryUntils.getCellStringValue(row.getCell(3)).trim();
					if (customerName.length() > 40) {
						errmsg = "客户姓名的长度不能超过40";
						err_list.add(errmsg);
						break;
					}
                    
					expireTime = QueryUntils.getCellStringValue(row.getCell(5)).trim();
					if (expireTime.length() > 8) {
						errmsg = "有效期时间的长度不能超过8";
						err_list.add(errmsg);
						break;
					}
					status = QueryUntils.getCellStringValue(row.getCell(6)).trim();
					if (status.length() > 2) {
						errmsg = "状态的长度不能超过2";
						err_list.add(errmsg);
						break;
					}
					bean.setUserName(userName);
				    bean.setCustomerName(customerName);
				  
				//	bean.setUserName(globalInfo.getTlrno());
				    bean.setCentralCode(centralCode);
				    bean.setClientLeId(clientLeId);
				    bean.setExpireTime(DateUtils.parseTime8(expireTime));
				    bean.setUpdateTime(DateUtils.getTimestamp());
				/*    ind.setIndividualId(centralCode);
			        ind.setName(userName);
			        ind.setInputTime(DateUtil.getTimestamp());
			        ind.setExpireDate(DateUtils.parseTime8(expireTime));
			        ind.setStatus("1");
				    */
					// 根据中征码进行匹配
					 List<IndPermit> queryMatchingPersoanl2 = QueryUntils.QueryMatchingPersoanl2(centralCode);
					if (queryMatchingPersoanl2 !=null && queryMatchingPersoanl2.size()>0) {
						for(IndPermit indPermit: queryMatchingPersoanl2) {
							indPermit.setExpireDate(DateUtils.parseTime8(expireTime));
							rootdao.update(indPermit);
						}
					}
					List<TCorpPermit> tCorpPermitList = QueryUntils.QueryMatching2(centralCode);
					if(tCorpPermitList!=null && tCorpPermitList.size()>0) {
						for(TCorpPermit tcorpPermit: tCorpPermitList) {
							tcorpPermit.setExpireDate(DateUtils.getTimestamp());
							rootdao.update(tcorpPermit);
						}
					}
					
					beanlist.add(bean);
				}
			}
			
			/*for(IndPermit indPermit:indlist) {
					rootdao.save(indPermit);
			}
			*/
			if (err_list.size() > 0) {
				beanlist.clear();
				throw new Exception(
						"sheet[" + sheet.getSheetName() + "]第" + (error_row) + "行数据错误！错误原因：" + err_list.get(0));
			} else {
				//更新日志表
				for (IbsQueryExpire csc : beanlist) {
					if (csc != null) {
						csc.setStatus("00");
						rootdao.save(csc);
					}else {
						csc.setStatus("01");
						rootdao.save(csc);
					}
				}
				beanlist.clear();
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