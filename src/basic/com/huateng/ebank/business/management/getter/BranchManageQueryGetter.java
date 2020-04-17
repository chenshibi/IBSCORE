package com.huateng.ebank.business.management.getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.utils.ReportEnum;

import resource.bean.basic.Bctl;
import resource.bean.basic.DataDic;

public class BranchManageQueryGetter extends BaseGetter {

    public Result call() throws AppException {
        try {

            /** 获取查询条件 */
            Map param = this.getCommQueryServletRequest().getParameterMap();

            /** 获取everyPage：每页包含的记录数 */
            int everypage = Integer.parseInt(param.get("everyPage").toString());

            /** 获取nextPage：表示下一页是第几页 */
            int nextpage = Integer.parseInt(param.get("nextPage").toString());

            /** 获取所有查询结果 */
            // String brcode = GlobalInfo.getCurrentInstance().getBrcode();

            // mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 begin
            // List list =
            // BctlService.getInstance().getAllEnableBctl();//.getAllDownBrcodeList(brcode);
            String brno = (String) param.get("brhNo");
            String brname = (String) param.get("brhName");
            String qst = getCommQueryServletRequest().getParameter("st");
            String hql = "po.del='F'";
            ArrayList<String> condList = new ArrayList<String>();
            if (!DataFormat.isEmpty(brno)) {
                hql = "brno like ?  and " + hql;
                condList.add(brno);
            }
            if (!DataFormat.isEmpty(brname)) {
                hql = "brname like ?  and " + hql;
                condList.add(brname);
            }
            if (qst != null && qst.length() > 0) {
                hql += (" and po.st = ? ");
                condList.add(qst);
            } else {
                hql += (" and po.st<>'" + ReportEnum.REPORT_ST1.N.value + "'");
            }
            hql += (" order by po.brclass,po.brcode");
            List list = DAOUtils.getBctlDAO().queryByCondition(hql, condList.toArray(), null);
            // mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 end
            int maxIndex = nextpage * everypage;

            /** 对最后一页的处理 */
            if (maxIndex > list.size()) {
                maxIndex = list.size();
            }
            List resultList = list.subList((nextpage - 1) * everypage, maxIndex);
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), resultList, getResult());

            result.setContent(resultList);

            result.getPage().setTotalPage((list.size() - 1) / everypage + 1);
            result.init();
            result.setTotal(list.size());
            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }

    }

    public static String getTime(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    protected PageQueryResult getData() throws Exception {
        PageQueryResult pageQueryResult = new PageQueryResult();

        String brcode = GlobalInfo.getCurrentInstance().getBrcode();

        List list = BctlService.getInstance().getAllDownBrcodeList(brcode);

        pageQueryResult.setQueryResult(list);

        return pageQueryResult;

    }

    protected Class getDataObjectClass() {
        // TODO Auto-generated method stub
        return Bctl.class;
    }

    private String getName(List list, String datano) {
        for (int i = 0; i < list.size(); i++) {
            DataDic dd = (DataDic) list.get(i);
            if (dd.getDataNo().equals(datano)) {
                return dd.getDataName();
            }
        }
        return null;
    }

}
