
package com.huateng.excel.imp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.report.utils.FilePermissonUtils;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.report.utils.ReportUtils;

/**
 * author: kin wong
 *
 * class desc:批量导入统一控制器（黑白名单、第三方网址等名单导入、模板下载）
 */
public class BatchImportController extends MultiActionController {
    public static final long FILE_MAX_SIZE = 1024 * 1024 * 10;

    public CommonsMultipartResolver getMultipartResolver() {
        return multipartResolver;
    }

    protected Logger logger = Logger.getLogger(getClass());

    protected String result;// 结果返回页面
    protected CommonsMultipartResolver multipartResolver;// 文件上传
    // protected BatchImportService batchImportService;//批量导入服务

    public void setResult(String result) {
        this.result = result;
    }

    public void setMultipartResolver(CommonsMultipartResolver multipartResolver) {
        this.multipartResolver = multipartResolver;
    }

    // public void setbatchImportService(BatchImportService batchImportService)
    // {
    // this.batchImportService = batchImportService;
    // }

    /**
     * <b>method desc:接收页面请求，上传文件并调用后台进行导入处理</b> <br>
     * method detail:操作流程如下： <br>
     * 1、封装页面返回对象 <br>
     * 2、接收文件信息，验证文件和上传的文件路径 <br>
     * 3、上传文件至服务器 <br>
     * 4、调用后台对应的DAO <br>
     * 5、删除文件，返回结果
     * 
     * @param request
     *            页面请求对象
     * @param reponse
     *            响应页面对象
     * @return 页面数据模型对象
     * @throws Exception
     *             异常
     */
    @SuppressWarnings({ "unused", "deprecation", "unchecked", "rawtypes" })
    public ModelAndView uploadImport(HttpServletRequest request, HttpServletResponse reponse) throws Exception {
        File uploadFile = null;
        String f = request.getQueryString();
        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest mrequest = resolver.resolveMultipart(request);
        String fileflag = mrequest.getParameter("fileflag");
        String fullFileName = mrequest.getParameter("filename");
        String flag = mrequest.getParameter("flag");
        boolean bool = false;
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
            file.getOriginalFilename();
            // if(!file.getOriginalFilename().equals(Config.getValue(fileflag)+".xls")){
            // errorList.add("导入文件错误,请导入文件:"+Config.getValue(fileflag)+".xls");
            // return modelAndView;
            // }
            if (file.getSize() > FILE_MAX_SIZE) {
                errorList.add("文件大小超过导入限制,只能输入10M以内");
                return modelAndView;
            }

            // 验证上传文件路径（是否存在，是否符合格式）
            // String uploadPath
            // =PropertiesUtils.getProperty("excel_upload_path");//文件路径
            // String path="/creditreport/source/upload/";
            // String path="/home/topreport/upload/credit";
            String path = ReportUtils.getSysParamsValue("UPLOAD", "PATH");

            mkdirIfNotExists(path);

            // 上传文件到指定的文件夹（用时间作为文件名保存防止文件重名）
            String currentTime = DataMyUtil.getFullDateTime();
            fullFileName = path + currentTime + ".xls";// String
                                                       // fullFileName =
                                                       // path + "/" +
                                                       // currentTime +
                                                       // ".xls";
            uploadFile = new File(fullFileName);
            file.transferTo(uploadFile);

        } catch (Exception e) {
            LogExceptionUtils.logException(logger, e);
            e.printStackTrace();
            bool = true;
            errorList.add("系统内部出错，错误信息：" + e.toString());
        } finally {
            if (!"0".equals(flag) || bool == true) {
                if (uploadFile.exists()) {
                    uploadFile.delete();
                }
            }
        }

        return modelAndView;
    }

    // public BatchImportService getBatchImportService() {
    // return batchImportService;
    // }
    //
    // public void setBatchImportService(BatchImportService batchImportService)
    // {
    // this.batchImportService = batchImportService;
    // }

    public String getResult() {
        return result;
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

    /**
     * <b>method desc:下载模板文件</b> <br/>
     * method detail:
     *
     * @param request
     *            页面请求对象
     * @param response
     *            响应页面对象
     * @return 页面数据模型对象
     * @throws Exception
     *             异常
     */
    @SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
    public ModelAndView downloadTemp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 封装页面返回对象
        List errorList = new ArrayList();
        ModelMap mmap = new ModelMap();
        mmap.addObject("errors", errorList);
        ModelAndView modelAndView = new ModelAndView(result, mmap);

        String fileflag = request.getParameter("fileflag");

        String modulePath = "fpages/creditreport/excel/modelexcel/";
        modulePath = modulePath.replace("/", File.separator);
        StringBuffer excelDownLoadPath = new StringBuffer();

        excelDownLoadPath.append(getServletContext().getRealPath("/")).append(modulePath);

        String downloadPath = excelDownLoadPath.toString();
        // String downloadPath =
        // PropertiesUtils.getProperty("excel_download_path");

        String fileName = Config.getValue(fileflag) + ".xls";

        mkdirIfNotExists(downloadPath);

        excelDownLoadPath.append(fileName);

        File file = new File(excelDownLoadPath.toString());

        if (!file.exists()) {
            errorList.add("模板文件[" + fileName + "]不存在;");
        } else {
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;

            try {
                response.setContentType("application/x-msdownload");
                response.setHeader("Content-disposition",
                        "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));// 进行编码

                bis = new BufferedInputStream(new FileInputStream(excelDownLoadPath.toString()));
                bos = new BufferedOutputStream(response.getOutputStream());
                byte[] buff = new byte[2048];
                int bytesRead;
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
            } catch (Exception e) {
                LogExceptionUtils.logException(logger, e);
                errorList.add("系统内部出错：" + e.toString());
            } finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                } catch (IOException e2) {
                    LogExceptionUtils.logException(logger, e2);
                    errorList.add("系统内部出错：" + e2.toString());
                }
            }
        }

        if (errorList.size() > 0)
            return modelAndView;
        return null;
    }

}