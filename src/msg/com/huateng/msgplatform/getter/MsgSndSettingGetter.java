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
public class MsgSndSettingGetter extends BaseGetter {

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
        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        if ("new".equals(type))
            return new PageQueryResult();// 新增页面
        String pageType = (String) getCommQueryServletRequest().getParameterMap().get("pageType");
        String msgId = (String) getCommQueryServletRequest().getParameterMap().get("msgId");
        String msgName = (String) getCommQueryServletRequest().getParameterMap().get("msgName");
        PageQueryResult pageQueryResult = new PageQueryResult();
        List<MsgSndSettingBean> list = new ArrayList<MsgSndSettingBean>();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        StringBuffer hql = new StringBuffer();
        if ("entryPage".equals(pageType)) {
            // 维护页面
            // msgId,msgName,subType,creator,createdDate,checkUser,checkUser
            hql.append(
                    "SELECT distinct A.MSG_ID as msgId, B.MSG_NAME as msgName, B.SUB_TYPE as subType, A.CREATOR as creator, ")
                    .append(" A.CREATED_DATE as createdDate, A.CHECK_USER as checkUser, A.CHECK_DATE as checkDate ")
                    .append(" FROM CPG_MSG_SND_CTL A LEFT OUTER JOIN CPG_MSG_CTL B ON  A.MSG_ID = B.MSG_ID where 1=1");
        } else if ("checkPage".equals(pageType)) {
            // 审核页面 msgId,msgName,subType,optType,creator,createdDate
            hql.append("SELECT distinct A.MSG_ID as msgId, B.MSG_NAME as msgName, B.SUB_TYPE as subType,")
                    .append(" A.OPT_TYPE as optType, A.CREATOR as creator, A.CREATED_DATE as createdDate ")
                    .append(" FROM CPG_MSG_SND_CTL_TMP A LEFT OUTER JOIN CPG_MSG_CTL B ON  A.MSG_ID = B.MSG_ID where 1=1")
                    .append(" AND A.OPT_STATUS = '0' ");// 审核时只查询未审核的记录
        }
        ArrayList<String> condList = new ArrayList<String>();
        if (!DataFormat.isEmpty(msgId)) {
            hql.append(" and A.MSG_ID = ? ");
            condList.add(msgId);
        }
        if (!DataFormat.isEmpty(msgName)) {
            hql.append(" and B.MSG_NAME like ? ");
            condList.add("%" + msgName + "%");
        }
        hql.append(" order by A.CREATED_DATE desc");
        Iterator it = rootdao.queryBySQL2(hql.toString(), condList.toArray());
        while (it.hasNext()) {
            Map map = (Map) it.next();
            String MsgId = (String)map.get("MSGID");
            MsgSndSettingBean bean = new MsgSndSettingBean();
            // BaseUpdate.mapToObject(bean, map);
//            bean.setCheckDate((String) map.get("CHECKDATE"));
//            bean.setCheckUser((String) map.get("CHECKUSER"));
            bean.setCreatedDate((String) map.get("CREATEDDATE"));
            bean.setCreator((String) map.get("CREATOR"));
            bean.setMsgId(MsgId);
            bean.setMsgName((String) map.get("MSGID"));
            bean.setOptType((String) map.get("OPTTYPE"));
            bean.setSubType((String) map.get("SUBTYPE"));
            list.add(bean);
        }
/*        while (it.hasNext()) {
        	Map map = (Map) it.next();
        	String MsgId = (String)map.get("msgId");
        	MsgSndSettingBean bean = new MsgSndSettingBean();
        	// BaseUpdate.mapToObject(bean, map);
//            bean.setCheckDate((String) map.get("CHECKDATE"));
//            bean.setCheckUser((String) map.get("CHECKUSER"));
        	bean.setCreatedDate((String) map.get("createdDate"));
        	bean.setCreator((String) map.get("creator"));
        	bean.setMsgId(MsgId);
        	bean.setMsgName((String) map.get("MsgId"));
        	bean.setOptType((String) map.get("optType"));
        	bean.setSubType((String) map.get("subType"));
        	list.add(bean);
        }
*/
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
