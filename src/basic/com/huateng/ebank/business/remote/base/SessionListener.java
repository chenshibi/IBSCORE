package com.huateng.ebank.business.remote.base;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;

import resource.bean.basic.TlrInfo;
import resource.dao.basic.TlrInfoDAO;

public class SessionListener implements HttpSessionListener {
    private static Logger log = Logger.getLogger(SessionListener.class);

    public void sessionCreated(HttpSessionEvent event) {
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        String sessionId = event.getSession().getId();
        log.info("destroyed session id is :" + sessionId);
        try {
            String tlrNo = null;
            GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
            if (gi == null) {
                Object o = event.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
                if (null != o && o instanceof GlobalInfo) {
                    GlobalInfo globalInfo = (GlobalInfo) o;
                    tlrNo = globalInfo.getTlrno();
                }
            } else {
                tlrNo = gi.getTlrno();
            }
            if (tlrNo != null) {
                TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
                TlrInfo tlrInfo = tlrInfoDAO.queryById(tlrNo);
                if (tlrInfo != null) {
                    tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
                    // 最近登出时间
                    tlrInfo.setLastlogouttm(DateUtil.get14Time());
                    tlrInfoDAO.update(tlrInfo);
                }
            }
            // UserMgrService.getInstance().setLoginOutInfo(tlrNo);
        } catch (CommonException e) {
            e.printStackTrace();
        }
        SessionFactory.getInstance().removeSession(sessionId);

    }

}
