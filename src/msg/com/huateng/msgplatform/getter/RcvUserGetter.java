package com.huateng.msgplatform.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.msg.CpgMsgGroup;
import resource.bean.msg.CpgMsgGroupTmp;
import resource.bean.msg.CpgUsrInf;

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
public class RcvUserGetter extends BaseGetter {

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
        // add by zhangdianchao 20160314 start
        String userId = (String) getCommQueryServletRequest().getParameterMap().get("userId");
        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        String pageType = (String) getCommQueryServletRequest().getParameterMap().get("pageType");
        if ("new".equals(type)) {
            return new PageQueryResult();
        }
        // add by zhangdianchao 20160314 end
        String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("tlrno");
        String roleGroup = (String) getCommQueryServletRequest().getParameterMap().get("qroleGroup");
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        ArrayList<String> condList = new ArrayList<String>();
        String hql = "from CpgUsrInf t where 1=1 ";
        // add by zhangdianchao 20160314 start
        if (!DataFormat.isEmpty(userId)) {
            hql += " and t.userId = ? ";
            condList.add(userId);
        }
        if (roleGroup != null && !"".equals(roleGroup)) {
            hql += " and t.roleGroup = '" + roleGroup + "'";
        }
        hql += " order by t.createdDate desc";
        // add by zhangdianchao 20160314 end
        List<CpgUsrInf> list = rootdao.queryByQL2List(hql, condList.toArray(), null);

        String groupId = (String) getCommQueryServletRequest().getParameterMap().get("qgroupId");

        if ("groupDtlPage".equals(pageType)) {
            ArrayList<String> condList1 = new ArrayList<String>();
            condList1.add(groupId);
            String hql_fp = "from CpgMsgGroup where groupId = ? ";
            List<CpgMsgGroup> list_fp = rootdao.queryByQL2List(hql_fp, condList1.toArray(), null);
            if (list_fp.size() > 0) {
                for (CpgMsgGroup fp : list_fp) {
                    String brno_fp = fp.getUserId();
                    for (CpgUsrInf bc : list) {
                        String brno = bc.getUserId();
                        if (brno.equals(brno_fp)) {
                            bc.setSelected(true);
                        }
                    }
                }
            }
        }
        if ("groupTmpDtlPage".equals(pageType)) {
            ArrayList<String> condList1 = new ArrayList<String>();
            condList1.add(groupId);
            String hql_fp = "from CpgMsgGroupTmp where groupId = '" + groupId + "'";
            List<CpgMsgGroupTmp> list_fp = rootdao.queryByQL2List(hql_fp, condList1.toArray(), null);
            if (list_fp.size() > 0) {
                for (CpgMsgGroupTmp fp : list_fp) {
                    String brno_fp = fp.getUserId();
                    for (CpgUsrInf bc : list) {
                        String brno = bc.getUserId();
                        if (brno.equals(brno_fp)) {
                            bc.setSelected(true);
                        }
                    }
                }
            }
        }

        PageQueryResult pageQueryResult = new PageQueryResult();

        if ("groupDtlPage".equals(pageType) || "groupTmpDtlPage".equals(pageType)) {
            pageQueryResult.setTotalCount(list.size());
            pageQueryResult.setQueryResult(list);
        } else {
            int pageIndex = getResult().getPage().getCurrentPage();
            int pageSize = getResult().getPage().getEveryPage();
            int maxIndex = pageIndex * pageSize;
            /** 对最后一页的处理 */
            if (maxIndex > list.size()) {
                maxIndex = list.size();
            }
            List rs = new ArrayList();
            rs = list.subList((pageIndex - 1) * pageSize, maxIndex);
            pageQueryResult.setTotalCount(list.size());
            pageQueryResult.setQueryResult(rs);
        }

        return pageQueryResult;
    }

}
