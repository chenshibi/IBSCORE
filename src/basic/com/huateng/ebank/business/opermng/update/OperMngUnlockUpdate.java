package com.huateng.ebank.business.opermng.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import resource.bean.basic.TlrInfo;
import resource.dao.basic.TlrInfoDAO;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngUnlockUpdate extends BaseUpdate {

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
            throws AppException {
        try {
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("operMngEntry");
            String tlrno = updateResultBean.getParameter("tlrno");
            TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
            tlrInfo.setIsLock("0");
            rootdao.saveOrUpdate(tlrInfo);
            // OperationContext oc = new OperationContext();
            // oc.setAttribute(OperMngOperation.CMD, "unlock");
            // oc.setAttribute(OperMngOperation.IN_TLRNO, tlrno);
            // OPCaller.call(OperMngOperation.ID, oc);

            return updateReturnBean;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
