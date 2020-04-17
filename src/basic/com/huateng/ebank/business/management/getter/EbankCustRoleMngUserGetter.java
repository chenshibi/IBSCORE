package com.huateng.ebank.business.management.getter;

import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.service.pub.RoleInfoService;

/**
 * @Description:
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @author: fubo
 * @date: 2010-8-3 涓婂崃10:31:30
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class EbankCustRoleMngUserGetter extends BaseGetter {

    @Override
    public Result call() throws AppException {
        try {
            List pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult, getResult());
            result.setContent(pageResult);
            result.getPage().setTotalPage(1);
            result.init();
            result.setTotal(pageResult.size());
            return result;
        } catch (CommonException e) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

    private List getData() throws CommonException {
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        String roleId = (String) getCommQueryServletRequest().getParameterMap().get("roleId");
        RoleInfoService roleInfoService = RoleInfoService.getInstance();
        List list = (List) roleInfoService.queryRoleInfo(roleId, pageIndex, pageSize);
        return list;
    }

}
