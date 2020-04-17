/**
 *
 */
package com.huateng.ebank.framework.web.commQuery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;

/**
 * Title: TxnPrivilegeMng Description: 权限管理类 Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2008-4-9
 */
public class TxnPrivilegeMng {
    private static final Logger log = Logger.getLogger(TxnPrivilegeMng.class);

    /**
     * @param request
     * @param cqId
     * @return
     * @throws CommonException
     */
    public static String checkTxnPrivilege(HttpServletRequest request, String cqId) throws CommonException {
        try {
            List txnList = CommonQueryUtil.getCommonQueryConfigTxn(cqId);
            UserSessionInfo userInfo = (UserSessionInfo) request.getSession().getAttribute("USER_SESSION_INFO");
            // Hashtable userFunctions = userInfo.getUserFunctions();
            if (txnList.isEmpty()) {
                log.warn("CommonQueryCOnfig Id = " + cqId + " not found txn,now return 0");
                return "";
            } else {
                return (String) txnList.get(0);
            }
        } catch (CommonException cex) {
            throw cex;
        } catch (AppException aex) {
            ExceptionUtil.throwCommonException(aex.getLocalizedMessage(), ErrorCode.ERROR_CODE_TLRNO_NO_FUNCTION, aex);
        } catch (Exception ex) {
            ExceptionUtil.throwCommonException("操作员没有此权限.", ErrorCode.ERROR_CODE_TLRNO_NO_FUNCTION, ex);
        }
        return null;
    }
}
