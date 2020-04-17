package com.huateng.htaml.reportForm.util;

import com.huateng.common.DateUtil;

public class TblCsBizLogFormOutStandingBean {
		private String trlname;
		private String misc;
		private String operstarttime;
		private String operendtime;
		private String ipadr;
		private String txnbizlog1;
		public String getTrlname() {
			return trlname;
		}
		public void setTrlname(String trlname) {
			this.trlname = trlname;
		}
		public String getMisc() {
			return misc;
		}
		public void setMisc(String misc) {
			this.misc=misc;
		}
		public String getOperstarttime() {
			return operstarttime;
		}
		public void setOperstarttime(String operstarttime) {
			if(operstarttime != null){
				this.operstarttime = DateUtil.get19Date(operstarttime);
			}else{
				this.operstarttime ="";
			}
		}
		public String getOperendtime() {
			return operendtime;
		}
		public void setOperendtime(String operendtime) {
			if(operendtime != null){
				this.operendtime = DateUtil.get19Date(operendtime);
			}else{
				this.operendtime ="";
			}
		}
		public String getIpadr() {
			return ipadr;
		}
		public void setIpadr(String ipadr) {
			this.ipadr = ipadr;
		}
		public String getTxnbizlog1() {
			return txnbizlog1;
		}
		public void setTxnbizlog1(String txnbizlog1) {
			this.txnbizlog1 = txnbizlog1;
		}
}
