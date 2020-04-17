/**
 *
 */
package com.huateng.ebank.business.customer.update;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import resource.bean.basic.TCorpLoancardInq;
import resource.bean.basic.TCorpPermit;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.customer.operation.LoanCardNoInquirySingleOperation;
import com.huateng.ebank.business.customer.operation.TCorpPermitOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.utils.ReportUtils;

/**
 * @author 
 *
 */
public class LoanCardNoInquirySingleUpdate extends BaseUpdate {

    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
            HttpServletResponse response) throws AppException {
        try {

            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("LoanCardNoInquiry");
            List<TCorpLoancardInq> paramList = new ArrayList<TCorpLoancardInq>();
            TCorpLoancardInq tcorpLoancardInq=new TCorpLoancardInq();
            while (updateResultBean.hasNext()) {
            	tcorpLoancardInq = new TCorpLoancardInq();
                Map map = updateResultBean.next();
                mapToObject(tcorpLoancardInq, map);
            }
            paramList.add(tcorpLoancardInq);
            OperationContext oc = new OperationContext();
            oc.setAttribute(LoanCardNoInquirySingleOperation.IN_PARAM,paramList);
            oc.setAttribute(LoanCardNoInquirySingleOperation.IN_OPERATION, tcorpLoancardInq);
            OPCaller.call(LoanCardNoInquirySingleOperation.ID, oc);

            return updateReturnBean;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
