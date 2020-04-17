package com.huateng.report.pboc.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.pboc.dao.BizFileImportrecsDao;
import com.huateng.report.pboc.operation.QueryCorpOperation;
import com.huateng.report.pboc.result.JsonUtils;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.pboc.util.PropertiesUtil;
import com.huateng.report.service.PbocD103Service;
import com.huateng.report.utils.ExcelReaderUtil;
import com.huateng.report.utils.ResultJsonUtil;

import resource.bean.crms.BizFileImportrecs;

/**
 * @author Grassy
 * @date 2019/6/19 16:11
 * @jdk.version 1.8
 * @desc
 */
public class CrmsBatchCorpServlet extends HttpServlet {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CrmsBatchCorpServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     super.doGet(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename=request.getParameter("fileName");
        String corpFlag=request.getParameter("flag");
        filename=StringEscapeUtils.unescapeJavaScript(filename);
        String filePath = (String) PropertiesUtil.getProperty("upLoadFilePath");
        try {
                Map<String, Object> resultMap = importModelData(request,filename, filePath,corpFlag);
                response.setHeader("content-type", "text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                String json = JsonUtils.toJson(resultMap);
                out.print(json);
                out.flush();
                out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 处理导入的数据
     * @param filenames
     * @param filepaths
     * @return
     */
    public Map<String, Object> importModelData(HttpServletRequest request,String filenames, String filepaths,String corpFlag)throws Exception {
        logger.info("将已上传文件内容导入数据库开始");
        HttpSession httpSession = request.getSession();
        if (httpSession == null) {
            throw new ServletException("Security Issue detected!");
        }
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        String brno="";
        String tlrno="";
        if (null != globalInfo) {
            GlobalInfo.setCurrentInstance(globalInfo);
            String sessionId = httpSession.getId();
            globalInfo.setSessionId(sessionId);
            brno=globalInfo.getBrcode();
            tlrno=globalInfo.getTlrno();
        } else {
            throw new ServletException("User not login!");
        }
        String errorMsg = "";
        // 1.获得文件名，文件路径 参数
        String filename = filenames;
        String filepath = filepaths;
        logger.info("文件名：" + filename);
        logger.info("文件路径：" + filepath);
        // 2.根据文件名从文件记录表中查询导入记录
        BizFileImportrecs fileinport=new BizFileImportrecs();
        fileinport.setFileName(filename);
        BizFileImportrecsDao dao = ApplicationContextUtils.getBean(BizFileImportrecsDao.class);
        List<BizFileImportrecs> fileImportrecsList = dao.findByFileName(fileinport);
        if(fileImportrecsList!=null && fileImportrecsList.size()>0){
            fileinport = fileImportrecsList.get(0);
        }else {
            Map<String, Object> resultMap = ResultJsonUtil.getResultErrorMap();
            resultMap.put(ResultJsonUtil.ERROR_MSG, "文件:" + filename
                    + "未查询到导入记录");
            return resultMap;
        }
        if (!fileinport.getFlag().equals("0")) {
            // 如果状态不为0,则表示此记录已处理过,不能再次处理
            Map<String, Object> resultMap = ResultJsonUtil.getResultErrorMap();
            resultMap.put(ResultJsonUtil.ERROR_MSG, "文件:" + filename
                    + "已将内容导入表中,不能重复执行");
            return resultMap;
        }
        File uploadFile = new File(filepath + filename);
        if (uploadFile == null || !uploadFile.exists()) {
            Map<String, Object> resultMap = ResultJsonUtil.getResultErrorMap();
            resultMap.put(ResultJsonUtil.ERROR_MSG, "文件:" + filepath + filename
                    + "不存在");
            return resultMap;
        }
        // 3.将文件上传记录的状态更改为处理中
        fileinport.setFlag(Constant.FLAG_DOING);
        dao.update(fileinport);
        // 4.将文件内容导入表中,并修改文件记录状态为已导入,记录总记录数,成功笔数,失败笔数(后续完成)
        //解析个人批量查询条件
        String realPath=filepath+filename;
        List<LinkedHashMap<String, String>> list  = ExcelReaderUtil.parseExcel(realPath, brno, tlrno,corpFlag);
        logger.info("将已上传文件内容导入数据库结束");
        LinkedHashMap<String, String> paramMap=null;
        OperationContext context = new OperationContext();
       /* for (Map<String, Object> map : list) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                  paramMap.put(entry.getKey(),entry.getValue());
            }

        }*/
        if(list!=null && list.size()>0){
            for(int i=0;i<list.size();i++){
                paramMap = list.get(i);
                context.setAttribute("CMD", "INSERT");
                context.setAttribute("CorpMakeMap", paramMap);
                OPCaller.call(QueryCorpOperation.class, context);
                context.setAttribute("CMD", "UPDATE");
            }

        }
        boolean isOk = true;
        String rptId = "";
        PbocD103Service service = PbocD103Service.getInstance();
        List<String> rptIdList=new ArrayList<String>();
        try {
        	for(int i=0;i<list.size();i++) {
        		LinkedHashMap<String, String> linkedHashMap = list.get(i);
        		 QueryResult queryResult = service.queryEnterprise(linkedHashMap);
        				if (StringUtils.equals(queryResult.getCode(), "0000")) {
        					logger.info("queryResult = " + queryResult);
        					context.setAttribute("status", "success");
        				} else {
        					isOk = false;
        					logger.error("queryResult = " + queryResult);
        					context.setAttribute("status", "failed");
        					OPCaller.call(QueryCorpOperation.class, context);
        					Map<String, Object> resultMap = ResultJsonUtil.getResultErrorMap();
        					resultMap.put(ResultJsonUtil.ERROR_MSG, "查询失败");
        					return resultMap;
        				}
        				context.setAttribute("CMD", "UPDATE");
        				rptId = StringUtils.trimToEmpty(queryResult.getId());
        				rptIdList.add(rptId);
        				context.setAttribute("rptId", rptId);
        				context.setAttribute("status", "success");
        				context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
        				context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
        				OPCaller.call(QueryCorpOperation.class, context);
        	}
        } catch (Exception e) {
            isOk = false;
            context.setAttribute("status", "failed");
            context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
            context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
            OPCaller.call(QueryCorpOperation.class, context);
            Map<String, Object> resultMap = ResultJsonUtil.getResultErrorMap();
            resultMap.put(ResultJsonUtil.ERROR_MSG, "查询异常");
            logger.error(e.getMessage(), e);
            return resultMap;
        }

      return ResultJsonUtil.getCorpResultMap(rptIdList);
    }
}
