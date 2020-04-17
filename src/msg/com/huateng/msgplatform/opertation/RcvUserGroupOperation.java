package com.huateng.msgplatform.opertation;

import java.util.List;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.msgplatform.service.MsgplatformStatusUtil;
import com.huateng.msgplatform.service.RcvUserGroupService;

import resource.bean.msg.CpgGroupInf;
import resource.bean.msg.CpgGroupInfTmp;
import resource.bean.msg.CpgMsgGroup;
import resource.bean.msg.CpgMsgGroupTmp;
import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgUsrInf;

/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:借款人机构信息
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class RcvUserGroupOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(RcvUserGroupOperation.class);
    public static final String ID = "RcvUserGroupOperation";
    public static final String CMD = "CMD";
    public static final String IN_PARAM = "IN_PARAM";
    public static final String CMD_INSERT = "CMD_INSERT";
    public static final String CMD_UPDATE = "CMD_UPDATE";
    public static final String CMD_DELETE = "CMD_DELETE";

    public static final String IN_AUDIT_STATUS = "IN_AUDIT_STATUS";
    public static final String IN_AUDIT_RESULT = "IN_AUDIT_RESULT";
    public static final Object CMD_AUDIT = "CMD_AUDIT";
    public static final String IN_OPERATION = "IN_OPERATION";

    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(OperationContext context) throws CommonException {
        String cmd = (String) context.getAttribute(CMD);
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        RcvUserGroupService service = RcvUserGroupService.getInstance();
        String mainId = null;// 从保存的实体中获取id 保存子表mainid
        CpgGroupInf groupInf = (CpgGroupInf) context.getAttribute(IN_OPERATION);
        List<CpgUsrInf> paramList = (List) context.getAttribute(IN_PARAM);

        CpgGroupInfTmp groupInfTmp = new CpgGroupInfTmp();
        if (groupInf != null) {
            groupInfTmp.setGroupId(groupInf.getGroupId());
            groupInfTmp.setGroupName(groupInf.getGroupName());
            groupInfTmp.setInnerId(groupInf.getId());
        
        }
        if (CMD_INSERT.equalsIgnoreCase(cmd)) {
            MsgplatformStatusUtil.setMsgStatus(groupInfTmp, MsgplatformStatusUtil.OP_ADD);
            mainId = (String) ROOTDAOUtils.getROOTDAO().save(groupInfTmp);
            for (int i = 0; i < paramList.size(); i++) {
                String userId = paramList.get(i).getUserId();
                CpgMsgGroupTmp msgGroupTmp = new CpgMsgGroupTmp();
                msgGroupTmp.setInnerId(mainId);
                msgGroupTmp.setUserId(userId);
                msgGroupTmp.setGroupId(groupInfTmp.getGroupId());
                MsgplatformStatusUtil.setMsgStatus(msgGroupTmp, MsgplatformStatusUtil.OP_ADD);
                // 保存组成员到CpgMsgGroupTmp表
                service.save(msgGroupTmp);
                
                
                CpgUsrInf cpgUsrInf=new CpgUsrInf();
                cpgUsrInf.setId(mainId);
                cpgUsrInf.setUserId(userId);
                
                CpgMsgGroup msgGroup=new CpgMsgGroup();
                msgGroup.setId(mainId);
                msgGroup.setGroupId(groupInfTmp.getGroupId());
                msgGroup.setUserId(userId);
                msgGroup.setCreator(globalinfo.getTlrno());
                msgGroup.setCreatedDate(DateUtil.get14Date());
                service.save(msgGroup);
                
            }
                CpgGroupInf  cgroupInf=new  CpgGroupInf();
                cgroupInf.setId(mainId);
                cgroupInf.setGroupId(groupInfTmp.getGroupId());
                cgroupInf.setGroupName(groupInf.getGroupName());
                cgroupInf.setCreator(globalinfo.getTlrno());
                cgroupInf.setCreatedDate(DateUtil.get14Date());
                service.save(cgroupInf);
                
            saveLog("新增");
        } else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
            MsgplatformStatusUtil.setMsgStatus(groupInfTmp, MsgplatformStatusUtil.OP_MOD);
            mainId = (String) ROOTDAOUtils.getROOTDAO().save(groupInfTmp);
            for (int i = 0; i < paramList.size(); i++) {
                String userId = paramList.get(i).getUserId();
                CpgMsgGroupTmp msgGroupTmp = new CpgMsgGroupTmp();
                msgGroupTmp.setInnerId(mainId);
                msgGroupTmp.setUserId(userId);
                msgGroupTmp.setGroupId(groupInfTmp.getGroupId());
                MsgplatformStatusUtil.setMsgStatus(msgGroupTmp, MsgplatformStatusUtil.OP_MOD);
                // 保存接收对象和用户组到CpgMsgGroupTmp表
                service.save(msgGroupTmp);
                
                CpgMsgGroup msgGroup=new CpgMsgGroup();
                msgGroup.setId(mainId);
                msgGroup.setGroupId(groupInfTmp.getGroupId());
                msgGroup.setUserId(userId);
                msgGroup.setCreator(globalinfo.getTlrno());
                msgGroup.setCreatedDate(DateUtil.get14Date());
                service.save(msgGroup);
                
                String sql = "delete from CPG_MSG_GROUP where group_id = '" + groupInfTmp.getGroupId()+ "'";
                service.deleteBySql(sql);
            }
            saveLog("修改");
        } else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
            MsgplatformStatusUtil.setMsgStatus(groupInfTmp, MsgplatformStatusUtil.OP_DEL);
            service.save(groupInfTmp);
            List<CpgMsgGroup> list1=service.queryMsg(groupInfTmp.getGroupId());
            List<CpgGroupInf> list2=service.queryInf(groupInfTmp.getGroupId());
            List<CpgMsgSndCtl> list3=service.querySnd(groupInfTmp.getGroupId());
            if(list1 != null && list1.size()>0){
            	  String sql1 = "delete from CPG_MSG_GROUP where group_id = '" + groupInfTmp.getGroupId()+ "'";
                  service.deleteBySql(sql1);
            }
            if(list2 != null && list2.size()>0){
            	 String sql2 = "delete from CPG_GROUP_INF where group_id = '" + groupInfTmp.getGroupId() + "'";
                 service.deleteBySql(sql2);
            }
            if(list3 != null && list3.size()>0){
            	  String sql3 = "delete from CPG_MSG_SND_CTL where opp_id_type = '2' and opp_id = '" + groupInfTmp.getGroupId() + "'";
            	  service.deleteBySql(sql3);
            }
            saveLog("删除");
        } else if (CMD_AUDIT.equals(cmd)) {
//            List<CpgGroupInfTmp> list = (List<CpgGroupInfTmp>) context.getAttribute(IN_PARAM);
//            String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
//            String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
//            service.auditRcvUGroupInf(approveStatusChoose, approveResultChoose, list);
//            saveLog("审核");
        }

    }

    private void saveLog(String bussiness) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        globalInfo.addBizLog("Updater.log",
                new String[] { globalInfo.getTlrno(),  "消息平台-->接收用户组维护-->" + bussiness });
        htlog.info("Updater.log",
                new String[] { globalInfo.getTlrno(), "消息平台-->接收用户组维护-->" + bussiness });
    }

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }
}
