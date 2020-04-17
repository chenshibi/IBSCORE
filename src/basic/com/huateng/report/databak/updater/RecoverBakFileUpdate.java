package com.huateng.report.databak.updater;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.databak.bean.RecoverBakFileBean;
import com.huateng.report.databak.service.ReportDataBakService;

/**
 *
 * @author shishu.zhang
 *
 *         2012-10-10下午3:30:39
 */
public class RecoverBakFileUpdate extends BaseUpdate {
    private static final HtLog htlog = HtLogFactory.getLogger(UpdateReturnBean.class);

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
            HttpServletResponse respone) throws AppException {

        try {
            GlobalInfo info = GlobalInfo.getCurrentInstance();

            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("recoverBakFile");

            RecoverBakFileBean bakFileBean = null;
            String zipFileName = null;
            String remark = null;
            while (updateResultBean.hasNext()) {
                bakFileBean = new RecoverBakFileBean();
                mapToObject(bakFileBean, updateResultBean.next());
                zipFileName = bakFileBean.getFilePath();
                remark = bakFileBean.getRecoverReason();
            }
            // bakFileBean
            // TODO 数据恢复调用
            ReportDataBakService.getInstance().recoveryDataBak(zipFileName);

            info.addBizLog("Updater.log", new String[] { info.getTlrno(), "执行业务数据恢复:" + remark });
            htlog.info("Updater.log", new String[] { info.getTlrno(),"执行业务数据恢复:" + remark });

            return updateReturnBean;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
