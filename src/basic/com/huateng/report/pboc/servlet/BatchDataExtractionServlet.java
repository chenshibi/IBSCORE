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
import com.huateng.report.pboc.service.DataExtractionWriteExcelService;
import com.huateng.report.pboc.util.DevUtils;
import com.huateng.report.utils.DateUtils;

public class BatchDataExtractionServlet extends HttpServlet
{
  private static final Logger logger = Logger.getLogger(BatchDataExtractionServlet.class);

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
      DataExtractionWriteExcelService dataExtractionWriteExcelService = DataExtractionWriteExcelService.getInstance();
      String firstMonthDay = DateUtils.getFirstMonthDay();
      String lastMonthDay = DateUtils.getLastMonthDay();
      DataExtractionEntity bean = null;
      List<DataExtractionEntity> list = new ArrayList<DataExtractionEntity>();
      StringBuffer sql = new StringBuffer();
      sql.append("select  \r\n(select data_name from data_dic where data_no=city and DATA_TYPE_NO='503.00') as 'city',\r\n(select data_name from data_dic where data_no=DEPARTMENT and DATA_TYPE_NO='501.00') as 'department',\r\nB.rsv3 as queryMonth,\r\nB.QUERY_DATE as queryDate,\r\nC.ID as id\r\nfrom  CR_COM_EAA C\r\nleft join CUST_PBOC_ENT_QUERY B on B.RESP_ID=C.ID\r\nleft join TLR_INFO A on A.TLRNO=B.CREATE_USER  ") 
      .append("where B.QUERY_DATE BETWEEN ").append("'").append(firstMonthDay).append("'").append(" ")
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
      List<DataExtractionEntity> newList = DevUtils.getNewList(list);
      for (int i = 0; i < newList.size(); i++)
      {
        DataExtractionEntity dataExtractionEntity = (DataExtractionEntity)newList.get(i);
        String queryMonth = dataExtractionEntity.getQueryMonth();
        String queryDate = dataExtractionEntity.getQueryDate();
        String city = dataExtractionEntity.getCity();
        String department = dataExtractionEntity.getDepartment();
        String id = dataExtractionEntity.getId();
        String filepath = "C:\\DataExtraction\\corp" + File.separator + queryMonth + File.separator + city + File.separator + department + File.separator;
        dataExtractionWriteExcelService.excelCrComEaaWrite(filepath, id);
        dataExtractionWriteExcelService.excelCrComEa01ChExport(filepath, id);
        dataExtractionWriteExcelService.excelCrComEca(filepath, id);
        dataExtractionWriteExcelService.excelCrComEc02oh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEc03oh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEc05oh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEba(filepath, id);
        dataExtractionWriteExcelService.excelCrComEbb(filepath, id);
        dataExtractionWriteExcelService.excelCrComEb02ah(filepath, id);
        dataExtractionWriteExcelService.excelCrComEb02bh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEb02ch(filepath, id);
        dataExtractionWriteExcelService.excelCrComEbc(filepath, id);
        dataExtractionWriteExcelService.excelCrComEb03ah(filepath, id);
        dataExtractionWriteExcelService.excelCrComEb03bh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEbd(filepath, id);
        dataExtractionWriteExcelService.excelCrComEbe(filepath, id);
        dataExtractionWriteExcelService.excelCrComEb05ah(filepath, id);
        dataExtractionWriteExcelService.excelCrComEb05bh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEda(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd01(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd02(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd03(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd01bh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd01ch(filepath, id);
        dataExtractionWriteExcelService.excelCrComEdb(filepath, id);
        dataExtractionWriteExcelService.excelCrComEdb04(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd04b(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd05(filepath, id);
        dataExtractionWriteExcelService.excelCrComEdc(filepath, id);
        dataExtractionWriteExcelService.excelCrComEdd(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd07(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd08(filepath, id);
        dataExtractionWriteExcelService.excelCrComEd09(filepath, id);
        dataExtractionWriteExcelService.excelCrComEea(filepath, id);
        dataExtractionWriteExcelService.excelCrComEe01bh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEfa(filepath, id);
        dataExtractionWriteExcelService.excelCrComEfb(filepath, id);
        dataExtractionWriteExcelService.excelCrComEfc(filepath, id);
        dataExtractionWriteExcelService.excelCrComEfd(filepath, id);
        dataExtractionWriteExcelService.excelCrComEf05bh(filepath, id);
        dataExtractionWriteExcelService.excelCrComEfe(filepath, id);
        dataExtractionWriteExcelService.excelCrComEff(filepath, id);
        dataExtractionWriteExcelService.excelCrComEfg(filepath, id);
        dataExtractionWriteExcelService.excelCrComEga(filepath, id);
        dataExtractionWriteExcelService.excelCrComEha(filepath, id);
        dataExtractionWriteExcelService.excelCrComEia(filepath, id);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}