package com.huateng.ebank.business.opermng.getter;

import java.util.ArrayList;
import java.util.List;

import com.boa.enterprise.instrumentation.core.types.NameValue;
import com.huateng.boa.log4j.monitor.Actions;
import com.huateng.boa.log4j.monitor.CustLogMonitorService;
import com.huateng.boa.log4j.monitor.ProprieraryDataLabels;
import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.RoleInfo;
import resource.bean.basic.TlrBctlRel;
import resource.bean.basic.TlrInfo;
import resource.dao.basic.TlrBctlRelDAO;

/**
 * 
 * Filename:LoanersQueryGetter.java Description:借款人机构信息第一屏 Copyright:Copyright
 * (c)2012 Company: HuaTeng
 * 
 * @author: shijie.zhu
 * @version: 1.0
 * @Create: 2013-1-1 Modification History: Date Author Version
 *          ------------------------------------------------------------------
 *          2013-1-1上午11:01:01 shijie.zhu 1.0
 */
@SuppressWarnings("unchecked")
public class OperMngEntryGetter extends BaseGetter {

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
        } finally {
            try {
                if (result != null && result.getContent() != null && result.getContent().size() > 0) {

                    List<List<NameValue>> proprieraryDataResords = new ArrayList<List<NameValue>>();

                    List<Object[]> list = (List<Object[]>) result.getContent();
                    for (Object[] objs : list) {
                        List<NameValue> valueList = new ArrayList<NameValue>();
                        TlrInfo j = (TlrInfo) objs[0];
                        valueList.add(new NameValue(ProprieraryDataLabels.USER_ID, j.getTlrno()));
                        valueList.add(new NameValue(ProprieraryDataLabels.USER_NAME, j.getTlrName()));
                        valueList.add(new NameValue(ProprieraryDataLabels.USER_EMAIL, j.getEmail()));
                        valueList.add(new NameValue(ProprieraryDataLabels.USER_STATUS, j.getStatus()));
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
        String qtlrnoName = (String) getCommQueryServletRequest().getParameterMap().get("qtlrnoName");
        String qtlrno = (String) getCommQueryServletRequest().getParameterMap().get("qtlrno");

        int pageSize = getResult().getPage().getEveryPage();
        int pageIndex = getResult().getPage().getCurrentPage();
        PageQueryResult queryResult = new PageQueryResult();
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        ArrayList<String> condList = new ArrayList<String>();
        String hql = " from TlrInfo a where 0=0 ";

        if (!DataFormat.isEmpty(qtlrno)) {
            hql += "and a.tlrno = ?";
            condList.add(qtlrno.toLowerCase());
        }
        if (!DataFormat.isEmpty(qtlrnoName)) {
            hql += "and a.tlrName like ? ";
            condList.add("%" + qtlrnoName + "%");
        }
    //    hql += " and a.tlrno in ( select tlrNo from TlrBctlRel ) ";
        //condList.add(brno);
        hql += " order by a.tlrno ";
        queryCondition.setQueryString(hql);
        queryCondition.setObjArray(condList.toArray());
        queryResult = rootDao.pageQueryByQL(queryCondition);
        List<Object[]> result = queryResult.getQueryResult();
        List list = new ArrayList();
        for (Object[] objs : result) {
            TlrInfo j = (TlrInfo) objs[0];
            j.setGwxx(getRoleID(j.getTlrno()));
//            j.setSqjgxx(getBrnoList(j.getTlrno()));
//            j.setFlag(getBrnoStatus(j.getTlrno(), brno));
            list.add(objs);
        }

        queryResult.setQueryResult(list);
        return queryResult;
    }

    public String getRoleID(String tlrno) {
        String gwxx = "";
        String[] conds = new String[1];
        conds[0] = tlrno;
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        List<Object[]> roleRellist;
        try {
            roleRellist = rootDao.queryByCondition(
                    "from TlrRoleRel a,RoleInfo b where a.roleId= b.id and a.tlrno = ? ",
                    conds);
            // roleRellist = rootDao
            // .queryByQL2List("from TlrRoleRel a,RoleInfo b where a.roleId=
            // b.id and a.tlrno = ? ");
            for (int k = 0; k < roleRellist.size(); k++) {
                Object[] objs = (Object[]) roleRellist.get(k);
                RoleInfo roleInfo = (RoleInfo) objs[1];
                gwxx = gwxx +roleInfo.getRoleName() + ";";
            }
        } catch (CommonException e) {
            e.printStackTrace();
        }
        return gwxx;

    }

    public String getBrnoStatus(String tlrno, String brno) {
        TlrBctlRelDAO dao = ROOTDAOUtils.getTlrBctlRelDAO();
        String[] conds = new String[1];
        conds[0] = tlrno;
        try {
            TlrBctlRel rel = dao.findByTlrBctl(tlrno, brno);
            if (rel == null) {
                return "0";
            } else {
                return rel.getStatus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";

    }

    public String getBrnoList(String tlrno) {
        String bctlxx = "";
        TlrBctlRelDAO dao = ROOTDAOUtils.getTlrBctlRelDAO();
        String[] conds = new String[1];
        conds[0] = tlrno;
        try {
            List<TlrBctlRel> bctllist = dao.findEffectiveByTlr(tlrno);
            if (bctllist != null) {
                for (TlrBctlRel rel : bctllist) {
                    bctlxx = bctlxx + rel.getBrNo() + ";";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bctlxx;

    }
}
