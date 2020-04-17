package com.huateng.report.pboc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

@Service
public class BlackListSearchCompanyDetailService
{
  private static final Logger logger = Logger.getLogger(BlackListSearchCompanyDetailService.class);

  public static BlackListSearchCompanyDetailService getInstance() {
    return (BlackListSearchCompanyDetailService)ApplicationContextUtils.getBean(BlackListSearchCompanyDetailService.class);
  }

  public static boolean isNotEmpty(List list)
  {
    return (list != null) && (list.size() != 0);
  }
  
  public Map<String, Object> getCompanyDetail(String uuid)
  {
    Map map = new HashMap();
    map.put("uuid", uuid);
    try {
      HQLDAO hqldao = ROOTDAOUtils.getHQLDAO();
      String[] objArg = { uuid };
      List list = null;
      
      list = hqldao.queryBySQL2List("SELECT * FROM T_COMPANY where REG_ID = ? ",objArg,null);
      map.put("T_Company", isNotEmpty(list) ? list.get(0) : new HashMap());
      
      list = hqldao.queryBySQL2List("SELECT * FROM T_BLACKLIST where COMP_REG_ID = ? ",objArg,null);
      map.put("T_blackList_List", isNotEmpty(list) ? list : new ArrayList());
      
    }
    catch (Exception e)
    {
      logger.error(e.getMessage(), e);
    }
    return map;
  }


}