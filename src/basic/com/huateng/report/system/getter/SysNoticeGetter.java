package com.huateng.report.system.getter;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

@SuppressWarnings("unchecked")
public class SysNoticeGetter extends BaseGetter {

    @Override
    public Result call() throws AppException {
        try {
            PageQueryResult pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());
            result.setContent(pageResult.getQueryResult());
            result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
            result.init();
            result.setTotal(pageResult.getTotalCount());
            return result;
        } catch (CommonException e) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

    private PageQueryResult getData() throws AppException {
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        Map paramMap = getCommQueryServletRequest().getParameterMap();
        ArrayList<String> condList = new ArrayList<String>();
        String st = (String) paramMap.get("st");
        String noticeTitle = (String) paramMap.get("noticeTitle");
        String crtTlr = (String) paramMap.get("crtTlr");
        String startDate = (String) paramMap.get("startDate");
        String endDate = (String) paramMap.get("endDate");
        String id = (String) paramMap.get("id");
        // 组装hql语句
        StringBuffer hql = new StringBuffer(" from SysNotice dd where 1=1");
        if (StringUtils.isNotBlank(id)) {
            hql.append(" and dd.id= ? ");
            condList.add(id);
        }
        if (StringUtils.isNotBlank(st)) {
            hql.append(" and dd.st=? ");
            condList.add(st);
        }
        if (StringUtils.isNotBlank(noticeTitle)) {
            hql.append(" and dd.noticeTitle like ? ");
            condList.add("%" + noticeTitle.trim() + "%");
        }
        if (StringUtils.isNotBlank(crtTlr)) {
            hql.append(" and dd.crtTlr=? ");
            condList.add(crtTlr);
        }
        if (StringUtils.isNotBlank(startDate)) {
            hql.append(" and dd.startDate>=? ");
            condList.add(startDate);
        }
        if (!DataFormat.isEmpty(endDate)) {
            hql.append(" and dd.endDate<=? ");
            condList.add(endDate);
        }
        hql.append(" order by dd.lstUpdTm desc");
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        return rootdao.pageQueryByHql(pageIndex, pageSize, hql.toString(), condList.toArray());
    }

}
