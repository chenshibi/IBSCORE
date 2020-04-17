package com.huateng.report.pboc.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.report.pboc.entity.DataExtractionEntity;
import com.huateng.report.pboc.service.PersonalDataExtractionExcelService;
import com.huateng.report.utils.DateUtils;

public class BatchPersonalDataExtractionServlet extends HttpServlet
{
  private static final Logger logger = Logger.getLogger(BatchPersonalDataExtractionServlet.class);

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
  {
    logger.error("don't support get method!");
    throw new ServletException("Security Issue detected!");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    HttpSession httpSession = request.getSession();
    if (httpSession == null)
      throw new ServletException("Security Issue detected!");

    GlobalInfo globalInfo = (GlobalInfo)httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
    String flag = request.getParameter("flag");
    if (globalInfo != null) {
      GlobalInfo.setCurrentInstance(globalInfo);
      String sessionId = httpSession.getId();
      globalInfo.setSessionId(sessionId);
    } else {
      throw new ServletException("User not login!");
    }
    try
    {
      PersonalDataExtractionExcelService personalDataExtractionExcelService = PersonalDataExtractionExcelService.getInstance();
      String firstMonthDay = DateUtils.getFirstMonthDay();
      String lastMonthDay = DateUtils.getLastMonthDay();
      DataExtractionEntity bean = null;
      List<DataExtractionEntity> list = new ArrayList<DataExtractionEntity>();
      StringBuffer sql = new StringBuffer();
      sql.append("select  \r\n" + 
      		"(select data_name from data_dic where data_no=city and DATA_TYPE_NO='503.00') as 'city',\r\n" + 
      		"(select data_name from data_dic where data_no=DEPARTMENT and DATA_TYPE_NO='501.00') as 'department',\r\n" + 
      		"B.rsv3 as queryMonth,\r\n" + 
      		"B.QUERY_DATE as queryDate,\r\n" + 
      		"C.BATCH_ID as id\r\n" + 
      		"from  CR_PER_PRH C\r\n" + 
      		"left join CUST_PBOC_PER_QUERY B on B.RESP_ID=C.BATCH_ID\r\n" + 
      		"left join TLR_INFO A on A.TLRNO=B.CREATE_USER\r\n").append("where B.QUERY_DATE BETWEEN ").append("'").append(firstMonthDay).append("'").append(" ")
            .append("and ").append("'").append(lastMonthDay).append("'").append(" ").append("ORDER BY B.QUERY_DATE DESC"); 
      ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
      Iterator it = rootdao.queryBySQLExcel(sql.toString());
      while (it.hasNext()) {
        Map map = (Map)it.next();
        bean = new DataExtractionEntity();
        if (map.get("city") != null)
          bean.setCity(map.get("city").toString());
        if (map.get("department") != null)
          bean.setDepartment(map.get("department").toString());
        if (map.get("id") != null)
          bean.setId(map.get("id").toString());
        if (map.get("queryDate") != null)
          bean.setQueryDate(map.get("queryDate").toString());
        if (map.get("queryMonth") != null)
          bean.setQueryMonth(map.get("queryMonth").toString());

        list.add(bean);
      }
      List<DataExtractionEntity> newList = getNewList(list);
      for (int i = 0; i < newList.size(); i++)
      {
        DataExtractionEntity dataExtractionEntity = (DataExtractionEntity)newList.get(i);
        String queryMonth = dataExtractionEntity.getQueryMonth();
        String queryDate = dataExtractionEntity.getQueryDate();
        String city = dataExtractionEntity.getCity();
        String department = dataExtractionEntity.getDepartment();
        String id = dataExtractionEntity.getId();
        String filepath = "C:\\DataExtraction\\personal" + File.separator + queryMonth + File.separator + city + File.separator + department + File.separator;
        personalDataExtractionExcelService.excelCrPerPahExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPa01chExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPoqExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPqoExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPbsExcel(filepath,id);
        personalDataExtractionExcelService.excelCrPerPf06zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPnoExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPc03ohExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPpoExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPc04ohExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPapExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPf04zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPahExcel(filepath, id);
       
        
     //   personalDataExtractionExcelService.excelCrPerPd01ghExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPndExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPe01zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPf01zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPmmExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPdaExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPd01zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPd01hhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPd01fhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPd01ghExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPd01dhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPd01ehExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPrmExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPcjExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPf02zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPsmExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPosExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPotExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPceExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPf03zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPimExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPb01bhExcel(filepath,id);
        personalDataExtractionExcelService.excelCrPerPcaExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPd02zhExcel(filepath,id);
        personalDataExtractionExcelService.excelCrPerPcrExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPd03zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPcoExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPc02bhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPc02khExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPc02ahExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPc02dhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPpqExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPf07zhExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPomExcel(filepath,id);
        personalDataExtractionExcelService.excelCrPerPhfExcel(filepath, id);
        personalDataExtractionExcelService.excelCrPerPf05zhExcel(filepath, id);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
	
  private static List<DataExtractionEntity> getNewList(List<DataExtractionEntity> list) {
	    Map<String,DataExtractionEntity> tempMap=new  HashMap<String,DataExtractionEntity>();
	    for(DataExtractionEntity entity: list){
	    	String city=entity.getCity();
	    	String departMent=entity.getDepartment();
	    	String id=entity.getId();
	    	if(tempMap.containsKey(city+"_"+departMent)){
	    		DataExtractionEntity dataExtractionEntity=new DataExtractionEntity();
	    		dataExtractionEntity.setCity(city);
	    		dataExtractionEntity.setQueryDate(entity.getQueryDate());
	    		dataExtractionEntity.setQueryMonth(entity.getQueryMonth());
	    		dataExtractionEntity.setDepartment(departMent);
	    		dataExtractionEntity.setId(tempMap.get(city+"_"+departMent).getId()+","+entity.getId());
	    		tempMap.put(city+"_"+departMent, dataExtractionEntity);
	    	}else {
	    		tempMap.put(city+"_"+departMent, entity);
	    	}
	    }
	    
	    List<DataExtractionEntity> newList=new ArrayList<DataExtractionEntity>();
	    for(String o:tempMap.keySet()) {
	    	 newList.add(tempMap.get(o));
	    }
		return newList;
  
}}