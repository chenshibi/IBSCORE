package com.huateng.report.pboc.servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.report.pboc.entity.DataExtractionEntity;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.PackZipUtil;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.WriteDbToExcelUtil;
/**
 * 
 * @author Grass
 * Servlet implementation class DownloadZipServlet
 *
 */
public class DownloadZipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadZipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession httpSession = request.getSession();
        if (httpSession == null) {
            throw new ServletException("Security Issue detected!");
        }
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        String flag=request.getParameter("flag");
        String trlNo="";
        if (null != globalInfo) {
            GlobalInfo.setCurrentInstance(globalInfo);
            String sessionId = httpSession.getId();
            globalInfo.setSessionId(sessionId);
            trlNo=globalInfo.getTlrno();
        } else {
            throw new ServletException("User not login!");
        }
        DataExtractionEntity bean=null;
        List<DataExtractionEntity> list = new ArrayList<DataExtractionEntity>();
        String firstMonthDay = DateUtils.getFirstMonthDay();
        firstMonthDay=firstMonthDay.replace("-", "");
        String lastMonthDay = DateUtils.getLastMonthDay();
        lastMonthDay=lastMonthDay.replace("-", "");
/*        StringBuffer sql = new StringBuffer();
        if("1".equals(flag)) {
        	sql.append("select  \r\n" + 
        			"substr(B.QUERY_DATE,1,6) as queryMonth,\r\n" + 
        			"B.QUERY_DATE as queryDate,\r\n"+ 
        			"C.ID as id \r\n" + 
        			"from  CR_COM_EAA C\r\n" + 
        			"left join CUST_PBOC_ENT_QUERY B on B.RESP_ID=C.ID\r\n" + 
        			"where 1=1 and substr(B.RESP_TIME,1,8) BETWEEN ").append("'").append(firstMonthDay).append("'").append(" ")
            .append("and ").append("'").append(lastMonthDay).append("'").append(" ");
        	sql.append("ORDER BY B.QUERY_DATE DESC");
        	
        }else {
        	sql.append("select  \r\n" + 
        			"substr(B.QUERY_DATE,1,6) as queryMonth,\r\n" + 
        			"B.QUERY_DATE as queryDate,\r\n"+ 
        			"C.BATCH_ID as id \r\n" + 
        			"from  CR_PER_PRH C\r\n" + 
        			"left join CUST_PBOC_PER_QUERY B on B.RESP_ID=C.BATCH_ID\r\n" + 
        			"where 1=1 and B.QUERY_DATE BETWEEN ").append("'").append(firstMonthDay).append("'").append(" ")
            .append("and ").append("'").append(lastMonthDay).append("'").append(" ");
        	sql.append("ORDER BY B.QUERY_DATE DESC");
        }
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        Iterator it;
		try {
			it = rootdao.queryBySQLExcel(sql.toString());
			while(it.hasNext()){
				Map map = (Map)it.next();
				bean=new DataExtractionEntity();
			if(map.get("id")!=null) {
					bean.setId(map.get("id").toString());
				}if(map.get("queryDate")!=null) {
					bean.setQueryDate(map.get("queryDate").toString());
				}if(map.get("queryMonth")!=null) {
					bean.setQueryMonth(map.get("queryMonth").toString());
				}
				list.add(bean);
			}
		} catch (CommonException e1) {
			e1.printStackTrace();
		}*/
		
        //将文件进行打包下载
		try
	    {
	        String queryMonth=firstMonthDay.substring(0, 6);
	        OutputStream out = response.getOutputStream();
	        String filepath;
	        String downloadName;
	        if ("1".equals(flag)) {
	          filepath = ReportUtils.getSysParamsValue("DATA", "GENCORP") + File.separator + queryMonth+ File.separator;
	          WriteDbToExcelUtil.isChartPathExist(filepath);
	          downloadName = "corp_" + queryMonth + "_" + ".zip";
	        } else {
	          filepath = ReportUtils.getSysParamsValue("DATA", "GENPER") + File.separator + queryMonth + File.separator;
	          WriteDbToExcelUtil.isChartPathExist(filepath);
	          downloadName = "persoanl_" + queryMonth + "_" + ".zip";
	        }
	        byte[] data = PackZipUtil.createZip(filepath);
	        response.reset();
	        response.setHeader("Content-Disposition", "attachment;fileName=" + downloadName);
	        response.addHeader("Content-Length", ""+data.length);
	        response.setContentType("application/octet-stream;charset=UTF-8");
	        IOUtils.write(data, out);
	        out.flush();
	        out.close();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
        
        
	}


}
