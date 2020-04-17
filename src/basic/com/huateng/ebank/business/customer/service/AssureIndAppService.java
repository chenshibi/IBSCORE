package com.huateng.ebank.business.customer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.basic.AssureIndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.SysParams;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;


public class AssureIndAppService {

    private static final String DATASET_ID = "AssureIndAppService";
    @SuppressWarnings("unused")
	private static final HtLog htlog = HtLogFactory.getLogger(AssureIndAppService.class);
	


    public synchronized static AssureIndAppService getInstance() {
        return (AssureIndAppService) ApplicationContextUtils.getBean(DATASET_ID);
    }

    public int getAssureIndApp(String individualIdType,String individualId) throws CommonException {
      	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
          String sql = "select po.return_time as returnTime,po.id as id from Assure_Ind_App po where 1=1 and  po.individual_id_type = "+individualIdType+" and po.individual_id = '"+individualId+"' collate Chinese_PRC_CS_AI_WS order by input_time desc ";
          Iterator it = ROOTDAOUtils.getROOTDAO().queryBySQL2(sql.toString());
          Date returnTime=null;
          int id = 0;
          while(it.hasNext()){
        	  Map map = (Map)it.next();
        	  returnTime=(Date) map.get("returnTime");
        	  id=(Integer) map.get("id");
        		  break;
          }
    		if(returnTime !=null){
    		int r=getR("ASSURE","IND");
			boolean blean=checkReportInrDays(returnTime,r);
			if(blean){
              return id;
              }
    		}
			return 0;
      }
    
    public int getR(String paramgroupId,String paramId) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
	  	String hql = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
	       ArrayList<String> condList = new ArrayList<String>();
	       condList.add(paramgroupId);
	       condList.add(paramId);
	  	@SuppressWarnings("unchecked")
		List<SysParams> list = rootdao.queryByCondition(hql,condList.toArray());
	  	String value=list.get(0).getParamVal();
	  	int r=Integer.parseInt(value);
		return r;
  }
    
    public boolean checkReportInrDays(Date returnTime,int r) {
  	  if(DateUtil.getDaysBetween(returnTime, DateUtil.getCurrentDate())<r){
  		  return true;
  	  }
  	return false;
    }
    
    @SuppressWarnings("unchecked")
	public List<IndPermit> getIndPermitQuery(String idType,String name,String individualId) throws CommonException {
      	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
      	String hql = "select po from IndPermit po where 1=1 and status='1' and po.idType = ? and po.name = ? and po.individualId = ? ";
           ArrayList<String> condList = new ArrayList<String>();
           condList.add(idType);
           condList.add(name);
           condList.add(individualId);
      	List<IndPermit> list = rootdao.queryByCondition(hql,condList.toArray());
    		return list;
      }
}

