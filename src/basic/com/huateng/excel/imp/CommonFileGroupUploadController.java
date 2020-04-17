package com.huateng.excel.imp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.customer.operation.CommonFileGroupUploadOperation;
import com.huateng.ebank.business.customer.operation.FileGroupUploadOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.ZdIbScoreBizLogUtils;

/**
 * 
 * @author Grassy
 *
 */
public class CommonFileGroupUploadController extends MultiActionController {
	
	private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(CommonFileGroupUploadController.class);

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
	public ModelAndView uploadBlackName(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		List errorList = new ArrayList();
		ModelMap mmap = new ModelMap();
		mmap.addObject("errors", errorList);
		ModelAndView modelAndView = new ModelAndView(result, mmap);
		GlobalInfo globalInfo=null;
		try {
			globalInfo = GlobalInfo.getFromRequest(req);
		//	HttpSession httpSession = req.getSession();
		   // globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			GlobalInfo.setCurrentInstance(globalInfo);
		} catch (CommonException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("start upload file！");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1024 * 1024 * 50);
			OperationContext context = new OperationContext();
			List<FileItem> list = upload.parseRequest(req);
			Map<String, String> fieldMap = new HashMap<String, String>();
			MultipartResolver resolver = new CommonsMultipartResolver(req.getSession().getServletContext());
			MultipartHttpServletRequest mrequest = resolver.resolveMultipart(req);
			String dp = mrequest.getParameter("department");
			fieldMap.put("department", dp);
			String TargetPath = ReportUtils.getSysParamsValue("FILE_PATH",
					"FILE_PATH") + DateUtil.get14Time();

			String fileName = null;
			// 遍历FileItem对象
			for (FileItem item : list) {
				if (item.isFormField()) {
					// 将字段存放在map中
					fieldMap.put(item.getFieldName(), item.getString("utf-8"));
				}
			}
			for (FileItem item : list) {
				if (!(item.isFormField())) {
					// 获取文件名
					String upLoadFileName = item.getName();
					if ("".equals(upLoadFileName)) {
						req.setAttribute("fileName", upLoadFileName);
						errorList.add("获取文件失败！");
					}
					if (upLoadFileName.indexOf("\\") > 0) {
						fileName = upLoadFileName.substring(upLoadFileName
										.lastIndexOf("\\") + 1);
						fieldMap.put("fileName", upLoadFileName.substring(upLoadFileName.lastIndexOf("\\") + 1));
					} else {
						fileName =  upLoadFileName;
						fieldMap.put("fileName", upLoadFileName);
					}
					
					try {
						// 创建指定路径文件夹
						FileUtils.forceMkdir(new File(TargetPath));
						// 获取许可文件全路径
						String fullUpPath = TargetPath + "/" + fileName;
						fieldMap.put("filepath", fullUpPath);
						// 上传文件
						System.out.println("uploadfile" + fullUpPath);
						File file = new File(fullUpPath);
						System.out.println("file");
						item.write(file);
					} catch (Exception e) {
						errorList.add("获取文件失败！");
						e.printStackTrace();
					}

				}
			}
			if (QueryUntils.getMatchMessage(fileName,(String) fieldMap.get("department")) == 1) {
				errorList.add("有已用文件存在，请更新状态后再次上传!");
				return modelAndView;
			}
			context.setAttribute(CommonFileGroupUploadOperation.FILIED_MAP, fieldMap);
			OPCaller.call(CommonFileGroupUploadOperation.class, context);
			ZdIbScoreBizLogUtils.setLogToBizLog(globalInfo, "Updater.log",
					new String[] { globalInfo.getTlrno(),
							"部门号:【" + QueryUntils.getRegionNo(globalInfo.getTlrno() + "】"),
							"公共文件上传-工作日期【" + DateUtil.get8Date() + "】 文件名称【" + fileName + "】" },
					"公共文件上传");
		} catch (Exception e) {
			e.printStackTrace();
			errorList.add("解析request请求失败！！");

		}
		

		return modelAndView;
	}

}