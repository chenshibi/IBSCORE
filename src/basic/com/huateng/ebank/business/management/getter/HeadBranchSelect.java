package com.huateng.ebank.business.management.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.Bctl;
import resource.dao.basic.BctlDAO;

/**
 * Title: com.huateng.ebank.business.management.getter.HeadBranchSelect.java
 * Description: TODO Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version v1.0,2008-6-22
 */
public class HeadBranchSelect extends BaseGetter {

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
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }

    }

    protected PageQueryResult getData() throws Exception {
        GlobalInfo.getFromRequest(httpReq);
        PageQueryResult pageQueryResult = new PageQueryResult();
        BctlService bctlservice = BctlService.getInstance();
        BctlDAO dao = BaseDAOUtils.getBctlDAO();
        Bctl headquarter = dao.getHeadBranch();
        List<Bctl> list = bctlservice.getBranchList();
        list.add(0, headquarter);
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(list);
        return pageQueryResult;
    }

}
