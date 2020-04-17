package com.huateng.msgplatform.opertation;

import java.util.List;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.msgplatform.getter.MsgSndSettingBean;
import com.huateng.msgplatform.getter.RcvObjBean;
import com.huateng.msgplatform.service.MsgSendSettingService;
import com.huateng.msgplatform.service.MsgplatformStatusUtil;

import resource.bean.msg.CpgMsgCtl;
import resource.bean.msg.CpgMsgCtlTmp;
import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgSndCtlTmp;

public class MsgSendSettingOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(MsgSendSettingOperation.class);
    public static final String ID = "MsgSendSettingOperation";
    public static final String CMD = "CMD";
    public static final Object CMD_AUDIT = "CMD_AUDIT";
    public static final String CMD_INSERT = "CMD_INSERT";
    public static final String CMD_UPDATE = "CMD_UPDATE";
    public static final String CMD_DELETE = "CMD_DELETE";

    // 主要关联企业段数据项
    public static final String IN_PARAM = "IN_PARAM";
    public static final String IN_OPERATION = "IN_OPERATION";
    public static final String IN_PARAM_INSERT = "IN_PARAM_INSERT";
    public static final String IN_PARAM_MOD = "IN_PARAM_MOD";
    public static final String IN_PARAM_DEL = "IN_PARAM_DEL";

    public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
    public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";

    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(OperationContext context) throws CommonException {
        String cmd = (String) context.getAttribute(CMD);
        MsgSendSettingService service = MsgSendSettingService.getInstance();
        String mainId = null;// 从保存的实体中获取id 保存子表mainid
        MsgSndSettingBean msgSndSettingBean = (MsgSndSettingBean) context.getAttribute(IN_OPERATION);
        GlobalInfo globalInfo=GlobalInfo.getCurrentInstance();
        CpgMsgSndCtl cpgMsgSndCtl = new CpgMsgSndCtl();
        CpgMsgSndCtlTmp cpgMsgSndCtlTmp = new CpgMsgSndCtlTmp();
        CpgMsgCtl cpgMsgCt=new CpgMsgCtl();
        CpgMsgCtlTmp cpgMsgCtTmp=new CpgMsgCtlTmp();
        // List<RcvObjBean> delList = (List<RcvObjBean>)
        // context.getAttribute(IN_PARAM_DEL);
        List<RcvObjBean> insertList = (List<RcvObjBean>) context.getAttribute(IN_PARAM_INSERT);
        List<RcvObjBean> updateList = (List<RcvObjBean>) context.getAttribute(IN_PARAM_MOD);

        if (CMD_INSERT.equalsIgnoreCase(cmd)) {
        	String msgId = msgSndSettingBean.getMsgId();
            service.deleteFromEntry(msgId);
            String msgName = msgSndSettingBean.getMsgName();
            String subType = msgSndSettingBean.getSubType();
            // mainId = (String) ROOTDAOUtils.getROOTDAO().save(usrInfTmp);
            for (int i = 0; i < insertList.size(); i++) {
                cpgMsgSndCtlTmp.setMsgId(msgId);
                cpgMsgSndCtlTmp.setOppIdType("1");// 1-用户,2-用户组
                cpgMsgSndCtlTmp.setOppId(insertList.get(i).getUserId());
                MsgplatformStatusUtil.setMsgStatus(cpgMsgSndCtlTmp, MsgplatformStatusUtil.OP_ADD);
                // 保存到 CpgMsgSndCtlTmp 表
                service.save(cpgMsgSndCtlTmp);
            }
            for (int i = 0; i < updateList.size(); i++) {
                cpgMsgSndCtlTmp.setMsgId(msgId);
                cpgMsgSndCtlTmp.setOppIdType("2");// 1-用户,2-用户组
                cpgMsgSndCtlTmp.setOppId(updateList.get(i).getGroupId());
                MsgplatformStatusUtil.setMsgStatus(cpgMsgSndCtlTmp, MsgplatformStatusUtil.OP_ADD);
                // 保存到 CpgMsgSndCtlTmp 表
                service.save(cpgMsgSndCtlTmp);
                
                
            }
            List<CpgMsgSndCtlTmp> list =service.getSndCtlTmp(msgId);
            for (CpgMsgSndCtlTmp SndCtlTmp : list) {
                cpgMsgSndCtl.setMsgId(SndCtlTmp.getMsgId());
                cpgMsgSndCtl.setOppIdType(SndCtlTmp.getOppIdType());
                cpgMsgSndCtl.setOppId(SndCtlTmp.getOppId());
                cpgMsgSndCtl.setCreator(SndCtlTmp.getCreator());
                cpgMsgSndCtl.setCreatedDate(SndCtlTmp.getCreatedDate());
                service.save(cpgMsgSndCtl);
            	
			}
            saveLog("消息发送配置维护-新增");
        } else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
            String msgId = msgSndSettingBean.getMsgId();
            service.deleteFromEntry(msgId);
            for (int i = 0; i < insertList.size(); i++) {
                cpgMsgSndCtlTmp.setMsgId(msgId);
                cpgMsgSndCtlTmp.setOppIdType("1");// 1-用户,2-用户组
                cpgMsgSndCtlTmp.setOppId(insertList.get(i).getUserId());
                MsgplatformStatusUtil.setMsgStatus(cpgMsgSndCtlTmp, MsgplatformStatusUtil.OP_MOD);
                // 保存到 CpgMsgSndCtlTmp 表
                service.save(cpgMsgSndCtlTmp);
            }
            for (int i = 0; i < updateList.size(); i++) {
                cpgMsgSndCtlTmp.setMsgId(msgId);
                cpgMsgSndCtlTmp.setOppIdType("2");// 1-用户,2-用户组
                cpgMsgSndCtlTmp.setOppId(updateList.get(i).getGroupId());
                MsgplatformStatusUtil.setMsgStatus(cpgMsgSndCtlTmp, MsgplatformStatusUtil.OP_MOD);
                // 保存到 CpgMsgSndCtlTmp 表
                service.save(cpgMsgSndCtlTmp);
            }
            List<CpgMsgSndCtlTmp> list =service.getSndCtlTmp2(msgId);
            for (CpgMsgSndCtlTmp SndCtlTmp : list) {
                cpgMsgSndCtl.setMsgId(SndCtlTmp.getMsgId());
                cpgMsgSndCtl.setOppIdType(SndCtlTmp.getOppIdType());
                cpgMsgSndCtl.setOppId(SndCtlTmp.getOppId());
                cpgMsgSndCtl.setCreator(SndCtlTmp.getCreator());
                cpgMsgSndCtl.setCreatedDate(SndCtlTmp.getCreatedDate());
                service.save(cpgMsgSndCtl);
            }
            saveLog("消息发送配置维护-修改");
            
        } else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
            String msgId = msgSndSettingBean.getMsgId();
            service.deleteFromEntry(msgId);
            // 删除操作只存主表
            for (int i = 0; i < insertList.size(); i++) {
                cpgMsgSndCtlTmp.setMsgId(msgId);
                cpgMsgSndCtlTmp.setOppIdType("1");// 1-用户,2-用户组
                cpgMsgSndCtlTmp.setOppId(insertList.get(i).getUserId());
                MsgplatformStatusUtil.setMsgStatus(cpgMsgSndCtlTmp, MsgplatformStatusUtil.OP_DEL);
                // 保存到 CpgMsgSndCtlTmp 表
                service.save(cpgMsgSndCtlTmp);
            }
            for (int i = 0; i < updateList.size(); i++) {
                cpgMsgSndCtlTmp.setMsgId(msgId);
                cpgMsgSndCtlTmp.setOppIdType("2");// 1-用户,2-用户组
                cpgMsgSndCtlTmp.setOppId(updateList.get(i).getGroupId());
                MsgplatformStatusUtil.setMsgStatus(cpgMsgSndCtlTmp, MsgplatformStatusUtil.OP_DEL);
                // 保存到 CpgMsgSndCtlTmp 表
                service.save(cpgMsgSndCtlTmp);
            }
            saveLog("消息发送配置维护-删除");
        } else if (CMD_AUDIT.equals(cmd)) {
            List<MsgSndSettingBean> list = (List<MsgSndSettingBean>) context.getAttribute(IN_PARAM);
            String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
            String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
            service.auditRcvUsrInf(approveStatusChoose, approveResultChoose, list);
            saveLog("消息发送配置维护-审核");
        }

    }

    private void saveLog(String bussiness) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        globalInfo.addBizLog("Updater.log",
                new String[] { globalInfo.getTlrno(),  "消息平台-->" + bussiness });
        htlog.info("Updater.log", new String[] { globalInfo.getTlrno(),  "消息平台-->" + bussiness });
    }

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }
}
