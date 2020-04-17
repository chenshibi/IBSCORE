package com.huateng.report.pboc.getter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author Grassy
 * @date 2019/2/19 12:11
 * @jdk.version 1.8
 * @desc
 */
public class CustPbocEntQueryGetter extends BaseGetter {
    @Override
    public Result call() throws AppException {
        try {
            PageQueryResult pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
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

    private PageQueryResult getData() throws Exception {
    	
        PageQueryResult queryResult = new PageQueryResult();
        PageQueryCondition queryCondition = new PageQueryCondition();
        int pageSize = getResult().getPage().getEveryPage();
        int pageIndex = getResult().getPage().getCurrentPage();
        String nowDate=DateUtil.get8Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		Date newtfmstime=df.parse(nowDate);
		Calendar c=Calendar.getInstance();
		c.setTime(newtfmstime);
		c.add(Calendar.DAY_OF_MONTH, -6);
			
		Calendar d=Calendar.getInstance();
		d.setTime(newtfmstime);
		d.add(Calendar.DAY_OF_MONTH, -29);
			
		String beginTimeOf30=DateUtil.get14Date(d).substring(0,8)+"000000";
		String nowTime=DateUtil.get14Date().substring(0,8)+DateUtil.get14Date().substring(8,10)+DateUtil.get14Date().substring(10,12)+DateUtil.get14Date().substring(12,14);
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
    //    ArrayList<String> condList = new ArrayList<String>();
        StringBuffer hql = new StringBuffer();
        hql.append(" from CustPbocEntQuery ");
        hql.append("where 0 = 0 ");
        GlobalInfo info = GlobalInfo.getCurrentInstance();
        String opr=info.getTlrno();
        String entName = (String) getCommQueryServletRequest().getParameterMap().get("entName");
        if (StringUtils.isNotBlank(entName)){
            hql.append(" and entName like").append("'%").append(entName).append("%'");
           // condList.add(entName);
        }
        String entCertNum = (String) getCommQueryServletRequest().getParameterMap().get("entCertNum");
        if (StringUtils.isNotBlank(entCertNum)){
            hql.append(" and entCertNum like").append("'%").append(entCertNum).append("%'");
         //   condList.add(entCertNum);
        }
        String qtlrno = (String) getCommQueryServletRequest().getParameterMap().get("qtlrno");
        if (!DataFormat.isEmpty(qtlrno)) {
            hql.append("and createUser like").append("'%").append(qtlrno).append("%'");
        //    condList.add(qtlrno.toLowerCase());
        }
        String st=(String) getCommQueryServletRequest().getParameterMap().get("status");
        if(StringUtils.isNotBlank(st)){
            hql.append("and status like").append("'%").append(st).append("%'");
       //     condList.add(st);
        }
        hql.append("and createUser=").append("'").append(opr);
        hql.append("' and CREATE_TIME>'"+beginTimeOf30+"' and CREATE_TIME<'"+nowTime+"' ");
        hql.append("  order by CERT_AUTH_STATUS desc").append(",").append("STATUS").append(" ").append("ASC").append(",").append("RESP_TIME").append(" ").append("desc").append(",").append("QUERY_LEVEL").append(" ").append("desc");
     //   queryCondition.setObjArray(condList.toArray());
        queryCondition.setQueryString(hql.toString());
        queryResult = ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
        return queryResult;
    }
}
