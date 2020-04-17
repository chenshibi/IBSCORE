package com.huateng.ebank.business.opermng.update;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boa.enterprise.instrumentation.core.types.NameValue;
import com.huateng.boa.log4j.monitor.Actions;
import com.huateng.boa.log4j.monitor.CustLogMonitorService;
import com.huateng.boa.log4j.monitor.ProprieraryDataLabels;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.opermng.operation.OperMngOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import resource.bean.basic.TlrInfo;

public class OperFlagChgUpdate extends BaseUpdate {

    private final static String PARAM_FLAG = "flag";
    private final static String DATASET_ID = "operMngEntry";
    private final static String OPER_ID = "tlrno";

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest arg1,
            HttpServletResponse arg2) throws AppException {
        try {
            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
            if (updateResultBean.hasNext()) {
                String tlrno = updateResultBean.next().get(OPER_ID);
                String flag = updateResultBean.getParameter(PARAM_FLAG);
                OperationContext oc = new OperationContext();
                oc.setAttribute(OperMngOperation.CMD, "flag");
                oc.setAttribute(OperMngOperation.IN_TLRNO, tlrno);
                oc.setAttribute(OperMngOperation.FLAG, flag);
                OPCaller.call(OperMngOperation.ID, oc);

                try {
                    TlrInfo j = ROOTDAOUtils.getTlrInfoDAO().query(tlrno);
                    if (j != null) {
                        List<List<NameValue>> proprieraryDataResords = new ArrayList<List<NameValue>>();

                        List<NameValue> valueList = new ArrayList<NameValue>();

                        valueList.add(new NameValue(ProprieraryDataLabels.USER_ID, j.getTlrno()));
                        valueList.add(new NameValue(ProprieraryDataLabels.USER_NAME, j.getTlrName()));
                        valueList.add(new NameValue(ProprieraryDataLabels.USER_EMAIL, j.getEmail()));
                        valueList.add(new NameValue(ProprieraryDataLabels.USER_STATUS, j.getStatus()));
                        proprieraryDataResords.add(valueList);

                        CustLogMonitorService service = CustLogMonitorService.getInstance();
                        service.BOALogMonitorProprierary(httpReq, GlobalInfo.getCurrentInstance().getTlrno(),
                                Actions.UPDATE, proprieraryDataResords,
                                com.boa.enterprise.instrumentation.core.types.Result.SUCCEEDED, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                ExceptionUtil.throwAppException("请选择一条记录", ErrorCode.ERROR_CODE_NORMAL);
            }

            return updateReturnBean;
        } catch (CommonException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
