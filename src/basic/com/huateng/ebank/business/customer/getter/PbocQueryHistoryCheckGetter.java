package com.huateng.ebank.business.customer.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.hibernate.CommonDAO;

public class PbocQueryHistoryCheckGetter  extends BaseGetter {

	@Override
	public Result call() throws AppException {
	    try {
	    	 ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
	    	Integer pageSize = new Integer(getResult().getPage().getEveryPage());
			Integer pageIndex = new Integer(getResult().getPage().getCurrentPage());
			String etlDate = (String) getCommQueryServletRequest().getParameterMap().get("etlDate");
			String entCertNum = (String) getCommQueryServletRequest().getParameterMap().get("entCertNum");
			String entName = (String) getCommQueryServletRequest().getParameterMap().get("entName");
	    	StringBuffer hql=new StringBuffer("select po from CustPbocHistoryQuery po where 1=1");
	    	hql.append(" and po.status in ('01','02')");
	    	if (!DataFormat.isEmpty(etlDate)) {
				hql.append(" and po.queryDate='").append(etlDate).append("' ");			
			}
	    	if (!DataFormat.isEmpty(entCertNum)) {
				hql.append(" and po.entCertNum='").append(entCertNum).append("' ");			
			}
	    	if (!DataFormat.isEmpty(entName)) {
				hql.append(" and po.entName='").append(entName).append("' ");			
			}
            
	        PageQueryResult pageResult = rootdao.pageQueryByHql(pageIndex, pageSize,hql.toString());
		
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());
            result.setContent(pageResult.getQueryResult());
            result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
            result.init();
            result.setTotal(pageResult.getTotalCount());
            
            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
	}

	
}
