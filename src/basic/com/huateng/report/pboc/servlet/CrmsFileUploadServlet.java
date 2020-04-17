package com.huateng.report.pboc.servlet;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.servlet.BaseServlet;
import com.huateng.report.pboc.dao.BizFileImportrecsDao;
import com.huateng.report.pboc.result.JsonUtils;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.pboc.util.PropertiesUtil;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.ResultJsonUtil;

import resource.bean.crms.BizFileImportrecs;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Grassy
 * @date 2019/2/22 16:00
 * @jdk.version 1.8
 * @desc
 */
public class CrmsFileUploadServlet extends BaseServlet {
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(CrmsFileUploadServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> uploadMap = upload(req, resp);
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String json = JsonUtils.toJson(uploadMap);
        out.print(json);
        out.flush();
        out.close();
    }

    public Map<String, Object> upload(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String fileName=null;
        File uploadFile = null;
        String recordType=request.getParameter("flag");
        try {
            GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
            // 1.将文件上传服务器
            MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
            //  MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("uploadFile");
            // 获得用户上传的原始文件名
            String uploadFileName = file.getOriginalFilename();
            uploadFile = uploadFile(request, resp, file);
            // 2.记录文件上传记录
            BizFileImportrecs fileImportrecs = new BizFileImportrecs();
            String operatorName = globalInfo.getTlrno();
            BizFileImportrecs fileinport = setFileImportrecs(operatorName, uploadFile,recordType);
            // 3.对上传文件进行判断
            String resultInfo = checkFileData(uploadFile,
                    fileinport, uploadFileName);
            if ((resultInfo != null) && (!resultInfo.equals(""))) {
                // 如果校验不通过,则返回错误信息
                Map<String, Object> resultMap = ResultJsonUtil.getResultErrorMap();
                resultMap.put(ResultJsonUtil.ERROR_MSG, resultInfo);
                return resultMap;
            }
            // 3.将文件上传记录写入数据库中
            BizFileImportrecsDao dao = ApplicationContextUtils.getBean(BizFileImportrecsDao.class);
            dao.save(fileinport);
            //4、将入库文件名称返回给前端
            fileName=fileinport.getFileName();

            LOGGER.info("导入数据结束");

        } catch (CommonException e) {
            e.printStackTrace();
        }
        return ResultJsonUtil.getFileResultMap(fileName);
    }

    private File uploadFile(HttpServletRequest request, HttpServletResponse response,CommonsMultipartFile file) {
        LOGGER.info("将文件上传到服务器指定目录开始");
        // 获得文件名
        String realFileName = file.getOriginalFilename();
        // 获取路径
        String ctxPath = (String) PropertiesUtil.getProperty("upLoadFilePath");
        // 创建文件/**/
        File dirPath = new File(ctxPath);
        if (!dirPath.exists()) {
             dirPath.mkdirs();
        }
        realFileName=HuaTengUtils.toStringAndTrim(realFileName);
        File uploadFile = new File(ctxPath + UUID.randomUUID() + "_"
                + realFileName);
    //    File uploadFile = new File(ctxPath + realFileName);
        try {
            FileCopyUtils.copy(file.getBytes(), uploadFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("将文件上传到服务器指定目录结束");
        return uploadFile;

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
            BizFileImportrecsDao dao = ApplicationContextUtils.getBean(BizFileImportrecsDao.class);
            List<BizFileImportrecs> fileImportrecsList = dao.findByFileName(fileinport);
            if ((fileImportrecsList != null) && (fileImportrecsList.size() > 0)) {
                  returnInfo = returnInfo + "; 已处理过,同一文件禁止重复上传处理";

            }
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
          /*  if (!returnInfo.equals("") && uploadFile.exists()) {
                uploadFile.delete();
                LOGGER.info("删除验证失败文件成功");

            }*/

        }
        return returnInfo;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request,response);
    }
}
