package com.huateng.msgplatform.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author zhangdianchao
 *
 */
public class Failed2SndMsgQryGetter extends BaseGetter {

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
        String dateStart = (String) getCommQueryServletRequest().getParameterMap().get("dateStart");
        String dateEnd = (String) getCommQueryServletRequest().getParameterMap().get("dateEnd");
        PageQueryResult pageQueryResult = new PageQueryResult();
        List<MsgLogBean> list = new ArrayList<MsgLogBean>();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        ArrayList<String> condList = new ArrayList<String>();
        StringBuffer hql = new StringBuffer();
        // id,brno,msgName,subType,msgSysId,msgLogHead,createdDate,source,status
        // 消息发送失败查询

        hql.append(
                "SELECT  B.ID as id,  A.BRNO as brno, D.MSG_NAME as msgName,D.SUB_TYPE as subType, A.MSG_SYS_ID as msgSysId, ")
                .append(" A.MSG_LOG_HEAD as msgLogHead, A.CREATED_DATE as createdDate,A.SOURCE as source, B.STATUS as status,  ")
                .append(" B.FAILED_REASON as failedReason FROM CPG_MSG_POOL A, CPG_MSG_SND_DTL B,CPG_MSG_CTL D where 1=1")
                .append(" and a.ID = b.MSG_LOG_ID and d.MSG_ID = b.MSG_ID ");

        if (!DataFormat.isEmpty(dateStart)) {
            hql.append(" and B.SEND_DATE >= ? ");
            condList.add(dateStart + "000000");
        }
        if (!DataFormat.isEmpty(dateEnd)) {
            hql.append(" and B.SEND_DATE <= ? ");
            condList.add(dateEnd + "235959");
        }
        hql.append(" and B.STATUS ='2'");// 0-待发送，1-成功，2-失败
        hql.append(" order by B.SEND_DATE desc");

        Iterator it = rootdao.queryBySQL2(hql.toString(), condList.toArray());
        while (it.hasNext()) {
            Map map = (Map) it.next();
            // String msgId = (String)map.get("msgId");
            MsgLogBean bean = new MsgLogBean();
            // BaseUpdate.mapToObject(bean, map);
            bean.setMsgSysId((String) map.get("MSGSYSID"));
            bean.setSource((String) map.get("SOURCE"));
            bean.setBrno((String) map.get("BRNO"));
            bean.setCreatedDate((String) map.get("CREATEDDATE"));
            bean.setSubType((String) map.get("SUBTYPE"));
            bean.setId((String) map.get("ID"));
            bean.setMsgName((String) map.get("MSGNAME"));
            bean.setStatus((String) map.get("STATUS"));
            bean.setMsgLogHead((String) map.get("MSGLOGHEAD"));
            bean.setFailedReason((String) map.get("FAILEDREASON"));
            list.add(bean);
        }

        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
        /** 对最后一页的处理 */
        if (maxIndex > list.size()) {
            maxIndex = list.size();
        }
        List result = new ArrayList();
        result = list.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(result);
        return pageQueryResult;
    }
}
