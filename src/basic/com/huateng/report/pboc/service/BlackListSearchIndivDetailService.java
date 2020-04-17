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
public class BlackListSearchIndivDetailService
{
  private static final Logger logger = Logger.getLogger(BlackListSearchIndivDetailService.class);

  public static BlackListSearchIndivDetailService getInstance() {
    return (BlackListSearchIndivDetailService)ApplicationContextUtils.getBean(BlackListSearchIndivDetailService.class);
  }

  public static boolean isNotEmpty(List list)
  {
    return (list != null) && (list.size() != 0);
  }
  
  public Map<String, Object> getIndivDetail(String uuid)
  {
    Map map = new HashMap();
    map.put("uuid", uuid);
    try {
      HQLDAO hqldao = ROOTDAOUtils.getHQLDAO();
      String[] objArg = { uuid };
      List list = null;
      
      list = hqldao.queryBySQL2List("SELECT * FROM T_BLACKLIST where CUST_ID = ? ",objArg,null);
      map.put("BLACKLIST", isNotEmpty(list) ? list.get(0) : new HashMap());
      
    }
    catch (Exception e)
    {
      logger.error(e.getMessage(), e);
    }
    return map;
  }


}