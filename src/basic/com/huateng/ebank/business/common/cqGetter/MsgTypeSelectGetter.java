package com.huateng.ebank.business.common.cqGetter;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class MsgTypeSelectGetter extends BaseGetter {

    public Result call() throws AppException {
        try {
            String msgId = this.getCommQueryServletRequest().getParameter("value");
            String msgName = this.getCommQueryServletRequest().getParameter("valueName");
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            ArrayList<String> condList = new ArrayList<String>();

            StringBuffer hql = new StringBuffer("select po from CpgMsgCtl po where 1=1 ");
            if (StringUtils.isNotBlank(msgId) && !msgId.equals("%%")) {
                hql.append(" and po.msgId = ? ");
                condList.add(msgId);
            }
            if (StringUtils.isNotBlank(msgName) && !msgName.equals("%%")) {
                hql.append(" and po.msgName like ? ");
                condList.add("%" + msgName + "%");
            }
            hql.append("order by po.msgId asc");
            Page page = getResult().getPage();
            PageQueryResult queryResult = rootdao.pageQueryByHql(page.getCurrentPage(), page.getEveryPage(),
                    hql.toString(), condList.toArray());

            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), queryResult.getQueryResult(),
                    getResult());
            result.setContent(queryResult.getQueryResult());
            result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
            result.init();
            result.setTotal(queryResult.getTotalCount());
            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
