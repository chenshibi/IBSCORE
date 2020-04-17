/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.FunctionInfo;
import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.view.FunctionInfoView;
import resource.bean.basic.view.RoleInfoView;

/**
 * @author fanissac
 * @date 2007-12-14
 * @desc
 */
public class FunctionInfoGetter extends BaseGetter {

    public Result call() throws AppException {
        // TODO Auto-generated method stub
        try {

            OperationContext oc = new OperationContext();
            RoleInfoView riv = new RoleInfoView();
            BeanUtilsEx(riv, getCommQueryServletRequest().getParameterMap());
            // Map<String, String> paramMap =
            // getCommQueryServletRequest().getParameterMap();

            PageQueryResult pageResult = getData(riv);

            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());

            result.setContent(pageResult.getQueryResult());
            if (pageResult.getQueryResult().size() == 0) {
                result.getPage().setTotalPage(0);
            } else {
                result.getPage().setTotalPage(1);
            }

            result.init();
            result.setTotal(pageResult.getTotalCount());
            return result;

        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see com.extra.common.ObjectDataGetter#getData()
     */
    protected PageQueryResult getData(RoleInfoView riv) throws Exception {

        List<FunctionInfo> list;
        List<FunctionInfoView> list2;
        String role_id = "";

        PageQueryResult pageQueryResult = new PageQueryResult();

        role_id = (riv.getRoleid());
        String roleName = riv.getRolename();
        ArrayList<String> condList = new ArrayList<String>();
        list2 = new ArrayList();
        list = DAOUtils.getFunctionInfoDAO().queryByCondition(" po.status = '1'  order by po.id");
        condList.add(role_id);
        List tlist = DAOUtils.getRoleFuncRelDAO().queryByCondition(" po.roleId = ? ", condList.toArray(), null);
        for (int i = 0; i < list.size(); i++) {
            FunctionInfo finfo = (FunctionInfo) list.get(i);
            FunctionInfoView fview = new FunctionInfoView();
            String funccode = DataFormat.trim(finfo.getId());

            if (exist(tlist, funccode)) {
                fview.setSelect(true);
            } else {
                fview.setSelect(false);
            }
            fview.setFunccode(finfo.getId());
            fview.setFuncname(finfo.getFuncname());
            fview.setRoleid(role_id);
            fview.setRolename(roleName);
            list2.add(fview);
        }

        if (list2 != null && list2.size() > 0) {
            pageQueryResult.setTotalCount(list2.size());
        } else {
            pageQueryResult.setTotalCount(0);
        }
        pageQueryResult.setQueryResult(list2);

        return pageQueryResult;
    }

    private boolean exist(List list, String funcCode) {
        for (int i = 0; i < list.size(); i++) {
            RoleFuncRel rfr = (RoleFuncRel) list.get(i);
            // 不能写成rfr.getFuncid() == funcCode因为这样比的是地址
            // 同时一定要把空格去掉用DataFormat.trim()方法
            if (DataFormat.trim(rfr.getFuncid()).equals(funcCode)) {
                return true;
            }
        }
        return false;
    }
}
