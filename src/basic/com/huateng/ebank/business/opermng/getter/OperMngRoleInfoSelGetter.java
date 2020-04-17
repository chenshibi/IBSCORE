package com.huateng.ebank.business.opermng.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.RoleInfo;
import resource.bean.basic.TlrRoleRel;
import resource.bean.basic.view.TlrRoleRelationView;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngRoleInfoSelGetter extends BaseGetter {

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

    private PageQueryResult getData() throws CommonException {
        PageQueryResult pageQueryResult = new PageQueryResult();

        String tlrno = getCommQueryServletRequest().getParameter("tlrno");
        OperationContext oc = new OperationContext();
        String op = (String) getCommQueryServletRequest().getParameterMap().get("op");
        String roleGroup = (String) getCommQueryServletRequest().getParameterMap().get("qroleGroup");
        List roleList = null;
        String wherestring = null;
        if (op.equals("modify")) {
            wherestring = " 1=1 and po.st ='4'";
        } else {
            wherestring = " po.st ='4' ";
        }

        if (roleGroup != null) {
            wherestring = wherestring + " and po.roleGroup = '" + roleGroup + "' ";
        }

        wherestring = wherestring + " order by po.roleGroup";

        roleList = DAOUtils.getRoleInfoDAO().queryByCondition(wherestring);
        ArrayList<String> condList = new ArrayList<String>();
        condList.add(tlrno);
        List urrlist = DAOUtils.getTlrRoleRelDAO().queryByCondition(" po.tlrno = ? and status <> 0", condList.toArray(),
                null);
        String roleStr = "|";
        for (Iterator it = urrlist.iterator(); it.hasNext();) {
            TlrRoleRel rr = (TlrRoleRel) it.next();
            roleStr += rr.getRoleId() + "|";
        }
        List<TlrRoleRelationView> tlrRoleViewList = new ArrayList<TlrRoleRelationView>();
        // 对以有的操作员岗位在岗位列表中显示
        for (int i = 0; i < roleList.size(); i++) {
            RoleInfo roleInfo = (RoleInfo) roleList.get(i);
            TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
            if (roleStr.contains("|" + roleInfo.getId() + "|") == false) {
                tlrRoleView.setRoleId(String.valueOf(roleInfo.getId()));
                tlrRoleView.setRoleName(roleInfo.getRoleName());
                tlrRoleView.setSelected(false);
                tlrRoleView.setSysGroup(roleInfo.getRoleGroup());
                tlrRoleViewList.add(tlrRoleView);
            }
        }

        if (tlrRoleViewList != null && tlrRoleViewList.size() > 0) {
            pageQueryResult.setTotalCount(tlrRoleViewList.size());
        } else {
            pageQueryResult.setTotalCount(0);
        }
        pageQueryResult.setQueryResult(tlrRoleViewList);

        return pageQueryResult;
    }
}
