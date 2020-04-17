package com.huateng.ebank.business.management.getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.boa.enterprise.instrumentation.core.types.NameValue;
import com.huateng.boa.log4j.monitor.Actions;
import com.huateng.boa.log4j.monitor.CustLogMonitorService;
import com.huateng.boa.log4j.monitor.ProprieraryDataLabels;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.service.pub.RoleInfoService;

import resource.bean.basic.RoleInfo;

/**
 * @Description: 企业岗位查询
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @author: fubo
 * @date: 2010-7-29 下午04:09:49
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class EbankCustRoleMngGetter extends BaseGetter {

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
        } finally {
            try {
                if (result != null && result.getContent() != null && result.getContent().size() > 0) {

                    List<List<NameValue>> proprieraryDataResords = new ArrayList<List<NameValue>>();

                    List<RoleInfo> list = (List<RoleInfo>) result.getContent();
                    for (RoleInfo objs : list) {
                        List<NameValue> valueList = new ArrayList<NameValue>();
                        RoleInfo j = (RoleInfo) objs;
                        valueList.add(new NameValue(ProprieraryDataLabels.ROLE_NAME, j.getRoleName()));
                        valueList.add(new NameValue(ProprieraryDataLabels.ROLE_STATUS, j.getStatus()));
                        valueList.add(new NameValue(ProprieraryDataLabels.ROLE_EMAIL, j.getMail()));
                        proprieraryDataResords.add(valueList);
                    }
                    CustLogMonitorService service = CustLogMonitorService.getInstance();
                    service.BOALogMonitorProprierary(httpReq, GlobalInfo.getCurrentInstance().getTlrno(), Actions.READ,
                            proprieraryDataResords, com.boa.enterprise.instrumentation.core.types.Result.SUCCEEDED,
                            null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private PageQueryResult getData() throws CommonException {
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        String qroleName = (String) getCommQueryServletRequest().getParameterMap().get("qroleName");
        String qroleGroup = (String) getCommQueryServletRequest().getParameterMap().get("qroleGroup");
        RoleInfoService roleInfoService = RoleInfoService.getInstance();
        PageQueryResult list = new PageQueryResult();
        try {
            list = roleInfoService.queryRoleByRolegroup(pageIndex, pageSize, qroleName, qroleGroup);
        } catch (IllegalAccessException e) {
            ExceptionUtil.throwCommonException("岗位查询失败!");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            ExceptionUtil.throwCommonException("岗位查询失败!");
            e.printStackTrace();
        }

        return list;
    }

}
