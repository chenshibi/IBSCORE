package com.huateng.ebank.business.bizlog.service;

import com.huateng.ebank.business.bizlog.bean.BizLogQueryBean;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;

public class BizLogQueryService {
    protected BizLogQueryService() {
    }

    /**
     * Get instance of common service
     *
     * @return
     */
    public synchronized static BizLogQueryService getInstance() {

        return (BizLogQueryService) ApplicationContextUtils.getBean(BizLogQueryService.class.getName());
    }

    public PageQueryResult getBizLogResult(BizLogQueryBean queryBean, int pageSize, int pageIndex)
            throws CommonException {
        PageQueryResult result = new PageQueryResult();
        PageQueryCondition condition = new PageQueryCondition();
        StringBuffer sb = new StringBuffer();
        sb.append(" select po from BizLog po, BizFuncInfo bf where 1=1 ");
        sb.append(" and po.bizFuncCode = bf.id ");
        if (!DataFormat.isEmpty(queryBean.getBranchId())) {
            sb.append(" and po.brcode =").append(queryBean.getBranchId());
            if (!DataFormat.isEmpty(queryBean.getTlrno())) {
                sb.append(" and po.tlrno =").append(queryBean.getTlrno());
            }
        }
        if (!DataFormat.isEmpty(queryBean.getTxnDate())) {
            sb.append(" and po.txdate =  '").append(queryBean.getTxnDate() + "' ");
        }
        if (!DataFormat.isEmpty(queryBean.getTxnDateStart())) {
            sb.append(" and po.txdate >=  '").append(queryBean.getTxnDateStart() + "'  ");
        }
        if (!DataFormat.isEmpty(queryBean.getTxnDateEnd())) {
            sb.append(" and po.txdate <=  '").append(queryBean.getTxnDateEnd() + "'  ");
        }
        if (!DataFormat.isEmpty(queryBean.getBizFuncType())) {
            sb.append(" and bf.bizFuncType = ").append(queryBean.getBizFuncType());
        }
        sb.append(" order by po.txtime desc");
        condition.setPageIndex(pageIndex);
        condition.setPageSize(pageSize);
        condition.setQueryString(sb.toString());
        result = DAOUtils.getHQLDAO().pageQueryByQL(condition);
        return result;
    }
}
