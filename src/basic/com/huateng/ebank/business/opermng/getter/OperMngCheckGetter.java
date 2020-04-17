package com.huateng.ebank.business.opermng.getter;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.system.service.UndoConfirmService;

public class OperMngCheckGetter extends BaseGetter {
    /**
     * @author jianxue.zhang 用于获取待办事项的数据
     */
    @Override
    public Result call() throws AppException {
        try {
            PageQueryResult pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());
            result.setContent(pageResult.getQueryResult());
            result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
            result.setTotal(pageResult.getTotalCount());

            result.init();

            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

    private PageQueryResult getData() throws AppException {
        // 获取参数集合
        Map paramMap = this.getCommQueryServletRequest().getParameterMap();
        // 也可以这样 getCommQueryServletRequest().getParameter("qDataTypeNo");
        // 获取参数id,insCd,intInsId,updTransCd
        String id = (String) paramMap.get("id");
        String intInsId = (String) paramMap.get("intInsId");
        String updTransCd = (String) paramMap.get("updTransCd");
        // 获取页面的pageSize
        int pageSize = this.getResult().getPage().getEveryPage();
        // 获取页面的当前页
        int pageIndex = this.getResult().getPage().getCurrentPage();
        ArrayList<String> condList = new ArrayList<String>();
        // 组装hql语句
        StringBuffer hql = new StringBuffer("from SysTaskInfo dd where 1=1");
        // String codes = ReportUtils.getConfrimCodes(codesList);
        String codes = "('100399')";
        hql.append(" and dd.intInsId in ").append(codes);
        if (StringUtils.isNotBlank(id)) {
            hql.append(" and dd.id like ? ");
            condList.add("%" + id.trim() + "%");
        }
        if (StringUtils.isNotBlank(intInsId)) {
            hql.append(" and dd.intInsId= ? ");
            condList.add(intInsId);
        }
        if (StringUtils.isNotBlank(updTransCd)) {
            hql.append(" and dd.updTransCd= ? ");
            condList.add(updTransCd);
        }
        hql.append(" order by dd.id  desc");
        return UndoConfirmService.getInstance().list(pageIndex, pageSize, hql.toString(), condList);
    }
}
