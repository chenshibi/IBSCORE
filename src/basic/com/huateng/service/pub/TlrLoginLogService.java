/*
 * Created on 2004-10-12
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.huateng.service.pub;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huateng.GetMacAddress;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportUtils;

import resource.bean.basic.TlrLoginLog;

/**
 * @author Administrator
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TlrLoginLogService {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TlrLoginLogService.class);

    /**
     * get instance.
     *
     * @return
     */
    public synchronized static TlrLoginLogService getInstance() {
        return (TlrLoginLogService) ApplicationContextUtils.getBean(TlrLoginLogService.class.getName());
    }

    public TlrLoginLogService() {
    }

    public void saveTlrLoginLog(String opType, boolean successFlag, String remark) throws CommonException {
        HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
//        String loginMax = null;
//        String loginName = null;
//        GetMacAddress gma = new GetMacAddress();
//        loginMax = gma.getMacAddress(gi.getIp());
//        InetAddress addr;
//		try {
////			addr = InetAddress.getByName(gi.getIp());
////		    loginName=addr.getHostName().toString(); //获取本机计算机名称  
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		}
        if (opType.equals("login")) {
            TlrLoginLog tlrLoginLog = new TlrLoginLog();
            tlrLoginLog.setId(ReportUtils.getUUID());
            tlrLoginLog.setCrtTm(DateUtil.get14Time());
            tlrLoginLog.setLoginAddr(gi.getIp());
            if (successFlag) {
                tlrLoginLog.setLoginSucTm(DateUtil.get14Time());
            } else {
                tlrLoginLog.setLoginFailTm(DateUtil.get14Time());
            }
            tlrLoginLog.setSessionId(gi.getSessionId());
            tlrLoginLog.setTlrNo(gi.getTlrno());
            tlrLoginLog.setLoginRemark(remark);
//            tlrLoginLog.setLoginMax(loginMax);
//            tlrLoginLog.setLoginName(loginName);
            try {
                hqldao.getHibernateTemplate().save(tlrLoginLog);
            } catch (Exception e) {
                logger.error("update(TlrInfo)", e);
                ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
            }
        } else {
            String sessionId = gi.getSessionId();
            List<TlrLoginLog> list = hqldao.queryByQL2List("from TlrLoginLog where sessionId='" + sessionId
                    + "' and crtTm=(select max(log.crtTm) from TlrLoginLog log where sessionId='" + sessionId + "')");
            try {
                if (list.size() > 0) {
                    TlrLoginLog tlrLoginLog = list.get(0);
                    tlrLoginLog.setLoginOutTm(DateUtil.get14Time());
                    hqldao.getHibernateTemplate().saveOrUpdate(tlrLoginLog);
                }
            } catch (Exception e) {
                logger.error("update(TlrInfo)", e); //$NON-NLS-1$
                ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
            }
        }
    }

    public PageQueryResult queryTlrLoginLOg(int pageIndex, int pageSize, String qtlrNo,String qloginAddr,
            String startDate, String endDate) throws CommonException {
        StringBuffer sb = new StringBuffer("");
        List<Object> list = new ArrayList<Object>();
        sb.append("select log from TlrLoginLog log where 1=1");
        if (!DataFormat.isEmpty(qtlrNo)) {
            sb.append(" and log.tlrNo = ? ");
            list.add(qtlrNo);
        }
        if (!DataFormat.isEmpty(qloginAddr)) {
            sb.append(" and log.loginAddr = ? ");
            list.add(qloginAddr);
        }
        if (!DataFormat.isEmpty(startDate)) {
            //sb.append(" and substring(log.crtTm,0,8)>=? ");//0,8
            sb.append(" and substr(log.crtTm,0,8)>=? ");//0,8
            // list.add(DateUtil.stringToDate2(startDate));
            list.add(CommonFunctions.converDate12TO8(startDate));
        }
        if (!DataFormat.isEmpty(endDate)) {
            sb.append(" and substr(log.crtTm,0,8)<=? ");
            // list.add(DateUtil.getStartDateByDays(DateUtil.stringToDate2(endDate),
            // -1));
            list.add(CommonFunctions.converDate12TO8(endDate));

        }
        sb.append(" order by log.crtTm desc ");
        HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(sb.toString());
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        queryCondition.setObjArray(list.toArray());
        PageQueryResult pageQueryResult = hqldao.pageQueryByQL(queryCondition);
        return pageQueryResult;
    }

    public void saveTlrLoginExceptionLog(String userName,  String ip, String sessionId)
            throws CommonException {
        HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
        TlrLoginLog tlrLoginLog = new TlrLoginLog();
        tlrLoginLog.setId(ReportUtils.getUUID());
        tlrLoginLog.setCrtTm(DateUtil.get14Time());
        tlrLoginLog.setLoginAddr(ip);
        tlrLoginLog.setLoginFailTm(DateUtil.get14Time());
        tlrLoginLog.setSessionId(sessionId);
        tlrLoginLog.setTlrNo(userName);
        tlrLoginLog.setLoginRemark("系统异常");
        try {
            hqldao.getHibernateTemplate().save(tlrLoginLog);
        } catch (Exception e) {
            logger.error("update(TlrInfo)", e);
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }
    }

    public PageQueryResult queryTlrLogDetail(int pageIndex, int pageSize, String qtlrNo, String stdate,
            String endate) throws CommonException {
        StringBuffer sb = new StringBuffer("");
        List<Object> list = new ArrayList<Object>();
        // sb.append("select log from TlrLoginLog log where 1=1");
        sb.append("select  distinct tl.tlrNo , " + "count(tl.tlrNo),max(tl.crtTm) , min(tl.crtTm) "
                + "  from   TlrLoginLog tl  where 1=1  ");
        if (!DataFormat.isEmpty(qtlrNo)) {
            sb.append(" and  tl.tlrNo= ? ");
            list.add(qtlrNo);
        }

        if (!DataFormat.isEmpty(stdate)) {
            sb.append(" and tl.crtTm>=? ");
            list.add(DateUtil.stringToDate2(stdate));
        }
        if (!DataFormat.isEmpty(endate)) {
            sb.append(" and tl.crtTm<? ");
            list.add(DateUtil.getStartDateByDays(DateUtil.stringToDate2(endate), -1));
        }

        sb.append(" group  by  tl.tlrNo ");

        HQLDAO hqldao = BaseDAOUtils.getHQLDAO();

        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(sb.toString());
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        queryCondition.setObjArray(list.toArray());
        PageQueryResult pageQueryResult = hqldao.pageQueryByQL(queryCondition);
        return pageQueryResult;
    }

}
