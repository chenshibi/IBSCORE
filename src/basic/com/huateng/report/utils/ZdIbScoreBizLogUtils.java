package com.huateng.report.utils;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.inter.I18MReadLogMsg;

import resource.bean.basic.TblCsBizLog;
import resource.dao.basic.TblBizLogDAO;

public class ZdIbScoreBizLogUtils {

	
	private static final HtLog logger = HtLogFactory.getLogger(ZdIbScoreBizLogUtils.class);
	
	public static ResourceBundle logMsg = new I18MReadLogMsg().getResourceBundle();
		
	public static void setLogToBizLog (GlobalInfo globalInfo,String id, String[] obj1,String pageFlag) {
		
		Object obj = null;
		try {
			if (obj1 == null) {

				String value = logMsg.getString(id);
				if (value != null && !value.equals("")) {
					obj = value;
				} else {
					obj = id;
				}

			} else {
				String value = logMsg.getString(id);
				if (value != null && !value.equals("")) {
					for (int i = 0; i < obj1.length; i++) {
						value = value.replace("${" + i + "}", obj1[i]);
					}
				}
				obj = value;
			}
		} catch (Exception e) {
			obj = id;
		}
		
		
		try {
			TblBizLogDAO tblBizLogDAO = DAOUtils.getTblBizLogDAO();
			TblCsBizLog bizLog = new TblCsBizLog();
			
			Date startTime = new Date();
			Date endTime = new Date();
			if (null == globalInfo.getTxnDate() || null == globalInfo.getTxnStartTime()) {
				bizLog.setTxnDate(DateUtil.dateToNumber(startTime));
				bizLog.setTxnStartTime(DateUtil.onlyTimeToString(startTime));
				bizLog.setTxnRunTime(Long.valueOf(DateUtil.comparaTime(startTime, endTime)));
			}else {
				bizLog.setTxnDate(DateUtil.dateToNumber(globalInfo.getTxnDate()));
				bizLog.setTxnStartTime(DateUtil.onlyTimeToString(globalInfo.getTxnStartTime()));
				bizLog.setTxnRunTime(Long.valueOf(DateUtil.comparaTime(globalInfo.getTxnStartTime(), endTime)));
			}
			bizLog.setId(UUID.randomUUID().toString().replaceAll("-", ""));
//            bizLog.setLogId(((UUID)HtBaseLog.uuid.get()).toString());
			bizLog.setLogId(UUID.randomUUID().toString().replaceAll("-", ""));
			
			String endTimeString = DateUtil.onlyTimeToString(endTime);
			bizLog.setTxnEndTime(endTimeString);
			
//			bizLog.setBrCode(globalInfo.getBrcode());
			bizLog.setOprCode(globalInfo.getTlrno());
			bizLog.setIpAdr(globalInfo.getIp());
			bizLog.setFuncId(globalInfo.getFuncId());
//            bizLog.setOprTxnCd(oprTxnCd);
			bizLog.setTxnBizLog1((String)obj);
//            bizLog.setTxnBizLog2(txnDesc[1]);
			bizLog.setTxnBizLog2(pageFlag);
			bizLog.setTxnStatus("02");
			
			tblBizLogDAO.insert(bizLog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
