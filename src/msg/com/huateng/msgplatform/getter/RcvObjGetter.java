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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.msg.CpgGroupInf;
import resource.bean.msg.CpgUsrInf;

/**
 * @author zhangdianchao
 */
public class RcvObjGetter extends BaseGetter {

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
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<RcvObjBean> list = new ArrayList<RcvObjBean>();
        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        String msgId = (String) getCommQueryServletRequest().getParameterMap().get("msgId");
        String pageType = (String) getCommQueryServletRequest().getParameterMap().get("pageType");
        String objType = (String) getCommQueryServletRequest().getParameterMap().get("objType");
        String roleGroup = (String) getCommQueryServletRequest().getParameterMap().get("qroleGroup");

        if ("user".equals(objType)) {
            StringBuffer hql1 = new StringBuffer("select po from CpgUsrInf po where 1=1");
            if (roleGroup != null && !"".equals(roleGroup)) {
                hql1.append(" and po.roleGroup like '%" + roleGroup + "%'");
            }
            hql1.append(" order by po.createdDate desc");
            List<CpgUsrInf> list1 = rootdao.queryByCondition(hql1.toString());
            for (int i = 0; i < list1.size(); i++) {
                RcvObjBean rsBean = new RcvObjBean();
                rsBean.setUserId(list1.get(i).getUserId());
                rsBean.setUserName(list1.get(i).getUserName());
                rsBean.setRsv1(list1.get(i).getRsv1());
                if ("new".equals(type)) {
                    rsBean.setSelect(false);
                } else {
                    Boolean b = isSelected(pageType, msgId, "1", rsBean.getUserId());// 1-用户,2-组
                    rsBean.setSelect(b);
                }
                list.add(rsBean);
            }
        } else if ("group".equals(objType)) {
            StringBuffer hql2 = new StringBuffer("select po from CpgGroupInf po where 1=1");
            hql2.append(" order by po.createdDate desc");
            List<CpgGroupInf> list2 = rootdao.queryByCondition(hql2.toString());
            for (int i = 0; i < list2.size(); i++) {
                RcvObjBean rsBean = new RcvObjBean();
                rsBean.setGroupId(list2.get(i).getGroupId());
                rsBean.setGroupName(list2.get(i).getGroupName());
                if ("new".equals(type)) {
                    rsBean.setSelect(false);
                } else {
                    Boolean b = isSelected(pageType, msgId, "2", rsBean.getGroupId());// 1-用户,2-组
                    rsBean.setSelect(b);
                }
                list.add(rsBean);
            }
        }
        // int pageIndex = getResult().getPage().getCurrentPage();
        // int pageSize = getResult().getPage().getEveryPage();
        // int maxIndex = pageIndex * pageSize;
        // /** 对最后一页的处理 */
        // if (maxIndex > list.size()) {
        // maxIndex = list.size();
        // }
        // List rs = new ArrayList();
        // rs = list.subList((pageIndex - 1) * pageSize, maxIndex);
        // pageQueryResult.setTotalCount(list.size());
        // pageQueryResult.setQueryResult(rs);
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(list);
        return pageQueryResult;
    }

    public Boolean isSelected(String pageType, String msgId, String objType, String objId) throws CommonException {

        StringBuffer hql = new StringBuffer();
        if ("entryPage".equals(pageType)) {
            hql.append("select po from CpgMsgSndCtl po where 1=1 ");
        } else if ("checkPage".equals(pageType)) {
            hql.append("select po from CpgMsgSndCtlTmp po where 1=1 and po.optStatus = '0'");
        }
        ArrayList<String> condList = new ArrayList<String>();
        condList.add(msgId);
        condList.add(objType);
        condList.add(objId);
        hql.append(" and po.msgId = ? ");
        // oppType 和 oppId 同时满足的情况下，查到结果则需要勾选
        hql.append(" and po.oppIdType = ? ");
        hql.append(" and po.oppId = ? ");
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List list = rootdao.queryByCondition(hql.toString(), condList.toArray());
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }
}
