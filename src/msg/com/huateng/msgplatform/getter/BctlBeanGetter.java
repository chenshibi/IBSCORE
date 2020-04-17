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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.Bctl;

/**
 * @author zhangdianchao
 *
 */
public class BctlBeanGetter extends BaseGetter {

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
        String userId = (String) getCommQueryServletRequest().getParameterMap().get("userId");
        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        PageQueryResult pageQueryResult = new PageQueryResult();
        List<BctlBean> total = new ArrayList<BctlBean>();

        if ("new".equals(type)) {
            // 新增时查询所有记录
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            List<Bctl> list = new ArrayList<Bctl>();
            StringBuffer hql = new StringBuffer("select po from Bctl po where 1=1 ");
            hql.append(" order by po.id");
            list = rootdao.queryByCondition(hql.toString());
            for (int i = 0; i < list.size(); i++) {
                BctlBean bean = new BctlBean();
                bean.setBrcode(list.get(i).getBrcode());
                bean.setBrno(list.get(i).getBrno());
                bean.setBrname(list.get(i).getBrname());
                bean.setSelect(false);
                total.add(bean);
            }
        } else {
            // 修改 或 删除时 分两次查询 用select区分
            ROOTDAO rootdao1 = ROOTDAOUtils.getROOTDAO();
            List<Bctl> list1 = new ArrayList<Bctl>();
            ArrayList<String> condList = new ArrayList<String>();
            StringBuffer hql1 = new StringBuffer("select po from Bctl po where 1=1 ");
            hql1.append(" and po.brno in (select b.brno from CpgMsgUsrBranch b where b.userId = ? )");
            hql1.append(" order by po.id");
            condList.add(userId);
            list1 = rootdao1.queryByCondition(hql1.toString(), condList.toArray());

            ROOTDAO rootdao2 = ROOTDAOUtils.getROOTDAO();
            List<Bctl> list2 = new ArrayList<Bctl>();
            StringBuffer hql2 = new StringBuffer("select po from Bctl po where 1=1 ");
            hql2.append(" and po.brno not in (select b.brno from CpgMsgUsrBranch b where b.userId = ? )");
            hql2.append(" order by po.id");
            list2 = rootdao2.queryByCondition(hql2.toString(), condList.toArray());

            for (int i = 0; i < list1.size(); i++) {
                BctlBean bean = new BctlBean();
                bean.setBrcode(list1.get(i).getBrcode());
                bean.setBrno(list1.get(i).getBrno());
                bean.setBrname(list1.get(i).getBrname());
                bean.setSelect(true);
                total.add(bean);
            }

            for (int i = 0; i < list2.size(); i++) {
                BctlBean bean = new BctlBean();
                bean.setBrcode(list2.get(i).getBrcode());
                bean.setBrno(list2.get(i).getBrno());
                bean.setBrname(list2.get(i).getBrname());
                bean.setSelect(false);
                total.add(bean);
            }
        }

        // int pageIndex = getResult().getPage().getCurrentPage();
        // int pageSize = getResult().getPage().getEveryPage();
        // int maxIndex = pageIndex * pageSize;
        // /** 对最后一页的处理 */
        // if (maxIndex > total.size()) {
        // maxIndex = total.size();
        // }
        // List rs = new ArrayList();
        // rs = total.subList((pageIndex - 1) * pageSize, maxIndex);
        //
        pageQueryResult.setTotalCount(total.size());
        // pageQueryResult.setQueryResult(rs);
        pageQueryResult.setQueryResult(total);
        return pageQueryResult;
    }
}
