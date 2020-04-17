package com.huateng.ebank.business.common.cqGetter;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class BctlAllSelectGetter extends BaseGetter {

    public Result call() throws AppException {
        try {
            String orgCode = this.getCommQueryServletRequest().getParameter("value");
            String orgCodeName = this.getCommQueryServletRequest().getParameter("valueName");
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            ArrayList<String> condList = new ArrayList<String>();
            StringBuffer hql = new StringBuffer("select po from Bctl po where po.status='"
                    + SystemConstant.VALID_FLAG_VALID + "' and po.lock = 'F' and po.del = 'F' ");

            if (StringUtils.isNotBlank(orgCode) && !orgCode.equals("%%")) {
                hql.append(" and po.brno = ? ");
                condList.add(orgCode);
            }
            if (StringUtils.isNotBlank(orgCodeName) && !orgCodeName.equals("%%")) {
                hql.append(" and po.brname like ? ");
                condList.add("%" + orgCodeName.trim() + "%");
            }
            GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
            String bctlList = BctlService.getInstance().getAllBlnBrcodeStr(globalInfo.getBrcode());
            hql.append(" and po.brcode in (" + bctlList + ") ");
            hql.append("order by po.brclass");
            Page page = getResult().getPage();
            for (String s : condList) {
                System.out.println(s);
            }
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
