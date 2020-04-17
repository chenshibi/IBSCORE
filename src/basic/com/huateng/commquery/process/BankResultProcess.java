package com.huateng.commquery.process;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.process.base._ResultViewProcess;
import com.huateng.commquery.process.call.BaseCallGetterProcess;
import com.huateng.commquery.result.ResultParamBean;
import com.huateng.exception.AppException;

public class BankResultProcess extends _ResultViewProcess {
    public ResultParamBean processAsyncBean(Map<String, String> paramMap, HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse) throws AppException {
        ResultParamBean localResultParamBean;
        try {
            ICommonQueryBean localICommonQueryBean = getCommonQueryBean((String) paramMap.get("CQId"));
            String str = localICommonQueryBean.getAnyValue("type");
            if ((str != null) && (str.equalsIgnoreCase("call"))) {
                localResultParamBean = BaseCallGetterProcess.processAsync(paramMap, paramHttpServletRequest,
                        paramHttpServletResponse);
            } else {
                localResultParamBean = processAsyncBeanSql(paramMap, paramHttpServletRequest, paramHttpServletResponse);
            }
        } catch (AppException localAppException) {
            localAppException.printStackTrace();
            localResultParamBean = new ResultParamBean();
            localResultParamBean.setResCd(localAppException.getErrCd());
            localResultParamBean.setResMsg(localAppException.getMessage());
        } catch (Exception localException) {
            localException.printStackTrace();
            localResultParamBean = new ResultParamBean();
            localResultParamBean.setResCd("999999");
            localResultParamBean.setResMsg(localException.getMessage());
        }
        return localResultParamBean;
    }

}
