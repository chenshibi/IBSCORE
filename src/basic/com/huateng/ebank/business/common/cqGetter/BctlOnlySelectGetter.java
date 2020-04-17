package com.huateng.ebank.business.common.cqGetter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class BctlOnlySelectGetter extends BaseGetter {

    public Result call() throws AppException {
        try {
            OperationContext oc = new OperationContext();
            // CustomerQueryCondition qc = new CustomerQueryCondition();
            // BeanUtils.populate(qc, getCommQueryServletRequest()
            // .getParameterMap());

            List list = null;

            list = BctlService.getInstance().getOnlyEnableBctl();
            // ------------------------------------------------------------
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
            result.setContent(list);
            result.getPage().setTotalPage(1);
            result.init();
            result.setTotal(list.size());
            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
