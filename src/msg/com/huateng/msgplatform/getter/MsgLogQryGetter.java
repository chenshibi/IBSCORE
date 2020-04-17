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
public class MsgLogQryGetter extends BaseGetter {

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
        ArrayList<String> condList = new ArrayList<String>();
        String pageType = (String) getCommQueryServletRequest().getParameterMap().get("pageType");
        // 详细页面的参数id
        String id = (String) getCommQueryServletRequest().getParameterMap().get("id");
        // 主页面查询条件：sendDate,msgSysId,msgId,userName,msgLogHead
        String dateStart = (String) getCommQueryServletRequest().getParameterMap().get("dateStart");
        String dateEnd = (String) getCommQueryServletRequest().getParameterMap().get("dateEnd");
        String status = (String) getCommQueryServletRequest().getParameterMap().get("status");
        String msgId = (String) getCommQueryServletRequest().getParameterMap().get("msgId");
        String userName = (String) getCommQueryServletRequest().getParameterMap().get("userName");
        String msgLogHead = (String) getCommQueryServletRequest().getParameterMap().get("msgLogHead");
        PageQueryResult pageQueryResult = new PageQueryResult();
        List<MsgLogBean> list = new ArrayList<MsgLogBean>();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        StringBuffer hql = new StringBuffer();
        if ("entryPage".equals(pageType) || "faildPage".equals(pageType)) {
            // B.ID,B.MSG_ID,D.MSG_NAME,A.MSG_SYS_ID,B.OPP_ID,C.USER_NAME,A.MSG_LOG_HEAD,B.SEND_DATE
            // FROM CPG_MSG_POOL A, CPG_MSG_SND_DTL B, CPG_USR_INF C,
            // CPG_MSG_CTL D
            // WHERE A.ID = B.MSG_LOG_ID AND B.MSG_ID = D.MSG_ID AND B.OPP_ID =
            // C.USER_ID ^ AND SUBSTR(A.CREATED_DATE, 1, 8) >= :x1 ^ AND
            // SUBSTR(A.CREATED_DATE, 1, 8) <= :x2 ^
            // AND A.MSG_ID = :x3 ^ AND A.SOURCE = :x4 ^ AND A.MSG_SYS_ID = :x5
            // ^ AND A.MSG_LOG_HEAD = :x6 ^ AND B.OPP_ID = :x7 ^
            // id,msgId,msgName,msgSysId,oppId,userName,msgLogHead,sendDate
            // id,brno,msgName,subType,msgSysId,msgLogHead,createdDate,source,status
            // 消息发送失败查询
            // hql.append(
            // "SELECT B.send_type as sendType, B.ID as id, B.MSG_ID as msgId,
            // D.MSG_NAME as msgName, A.MSG_SYS_ID as msgSysId, D.SUB_TYPE as
            // subType,")
            // .append(" B.OPP_ID as oppId, C.USER_NAME as userName,
            // A.MSG_LOG_HEAD as msgLogHead, B.SEND_DATE as sendDate, B.STATUS
            // as status, ")
            // .append(" B.rcv_Inf as rcvInf ")
            // .append(" FROM CPG_MSG_POOL A, CPG_MSG_SND_DTL B, CPG_USR_INF C,
            // CPG_MSG_CTL D where 1=1 ")
            // .append(" and a.ID = b.MSG_LOG_ID and b.opp_id = c.user_id and
            // d.MSG_ID = b.MSG_ID ");
            hql.append("SELECT  B.ID as bId, A.ID as aId,  A.MSG_ID as msgId,  D.MSG_NAME as msgName,")
                    .append(" B.OPP_ID as oppId, C.USER_NAME as userName,  A.BRNO as brno,  D.TYPE as type,  D.SUB_TYPE as subType, ")
                    .append(" A.MSG_SYS_ID as msgSysId, A.SOURCE as source, B.SEND_DATE as sendDate, B.STATUS as status,")
                    .append(" A.CREATED_DATE as createdDate, A.MSG_LOG_HEAD as msgLogHead, A.MSG_LOG as msgLog, B.rcv_Inf as rcvInf,"
                            + " b.failed_reason as failedReason ")
                    .append(" FROM CPG_MSG_POOL A, CPG_MSG_SND_DTL B, CPG_USR_INF C, CPG_MSG_CTL D")
                    .append(" WHERE A.ID = B.MSG_LOG_ID AND B.OPP_ID = C.USER_ID AND A.MSG_ID = D.MSG_ID ");

            if (!DataFormat.isEmpty(dateStart)) {
                hql.append(" and B.SEND_DATE >= ? ");
                condList.add(dateStart + "000000");
            }
            if (!DataFormat.isEmpty(dateEnd)) {
                hql.append(" and B.SEND_DATE <= ? ");
                condList.add(dateEnd + "235959");
            }
            if (!DataFormat.isEmpty(status)) {
                hql.append(" and b.status = ? ");
                condList.add(status);
            }
            if (!DataFormat.isEmpty(msgId)) {
                hql.append(" and B.MSG_ID = ? ");
                condList.add(msgId);
            }
            if (!DataFormat.isEmpty(userName)) {
                hql.append(" and C.USER_NAME = ? ");
                condList.add(userName);
            }
            if (!DataFormat.isEmpty(msgLogHead)) {
                hql.append(" and A.MSG_LOG_HEAD = ? ");
                condList.add(msgLogHead);
            }
            if ("faildPage".equals(pageType)) {
                hql.append(" and B.STATUS ='2'");// 0-待发送，1-成功，2-失败
            }
            hql.append(" order by B.SEND_DATE desc");
        } else if ("detailPage".equals(pageType)) {
            // SELECT B.ID BID, A.ID AID, A.MSG_ID, D.MSG_NAME, B.OPP_ID,
            // C.USER_NAME, A.BRNO, D.TYPE, D.SUB_TYPE,
            // A.CREATED_DATE, A.MSG_SYS_ID, A.SOURCE, B.SEND_DATE, B.STATUS,
            // A.MSG_LOG_HEAD, A.MSG_LOG
            // FROM CPG_MSG_POOL A, CPG_MSG_SND_DTL B, CPG_USR_INF C,
            // CPG_MSG_CTL D
            // WHERE A.ID = B.MSG_LOG_ID AND B.OPP_ID = C.USER_ID AND A.MSG_ID =
            // D.MSG_ID ^ AND B.ID = :x1 ^

            // bId,aId,msgId,msgName,oppId,userName,brno,type,subType,createdDate,msgSysId,source,sendDate,status,msgLogHead,msgLog
            hql.append(
                    "SELECT  B.ID as aId, B.MSG_ID as msgId, A.MSG_SYS_ID as bID,B.OPP_ID as oppId,C.USER_NAME as userName,B.RCV_INF as rcvInf,")
                    .append("A.MSG_LOG_HEAD as msgLogHead,B.SEND_DATE as sendDate,B.STATUS as status,b.failed_reason as failedReason")
                    .append(" FROM CPG_MSG_POOL A, CPG_MSG_SND_DTL B, CPG_USR_INF C, CPG_MSG_CTL D")
                    .append(" WHERE A.ID = B.MSG_LOG_ID AND B.OPP_ID = C.USER_ID AND A.MSG_ID = D.MSG_ID ");
            if (!DataFormat.isEmpty(msgId)) {
                hql.append(" and B.MSG_ID = ? ");
                condList.add(msgId);
            }
            if (!DataFormat.isEmpty(id)) {
                hql.append(" and B.ID = ? ");
                condList.add(id);
            }

        }

        Iterator it = rootdao.queryBySQL2(hql.toString(), condList.toArray());
        while (it.hasNext()) {
            Map map = (Map) it.next();
            // String msgId = (String)map.get("msgId");
            MsgLogBean bean = new MsgLogBean();
            // BaseUpdate.mapToObject(bean, map);
            bean.setId((String) map.get("AID"));
            bean.setMsgId((String) map.get("BID"));
            bean.setMsgSysId((String) map.get("MSGSYSID"));
            bean.setOppId((String) map.get("OPPID"));
            bean.setUserName((String) map.get("USERNAME"));
            bean.setRcvInf((String) map.get("RCVINF"));
            bean.setMsgLogHead((String) map.get("MSGLOGHEAD"));
            bean.setSendDate((String) map.get("SENDDATE"));
            bean.setStatus((String) map.get("STATUS"));
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
