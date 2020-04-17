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
import com.huateng.msgplatform.getter.BctlBean;
import com.huateng.msgplatform.service.MsgplatformStatusUtil;
import com.huateng.msgplatform.service.RcvUserService;

import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgUsr;
import resource.bean.msg.CpgMsgUsrBranchTmp;
import resource.bean.msg.CpgMsgUsrTmp;
import resource.bean.msg.CpgUsrInf;
import resource.bean.msg.CpgUsrInfTmp;

public class RcvUserOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(RcvUserOperation.class);
    public static final String ID = "RcvUserOperation";
    public static final String CMD = "CMD";
    public static final String IN_PARAM = "IN_PARAM";
    public static final String CMD_INSERT = "CMD_INSERT";
    public static final String CMD_UPDATE = "CMD_UPDATE";
    public static final String CMD_DELETE = "CMD_DELETE";
    // 主要关联企业段数据项
    public static final String IN_PARAM_INSERT = "IN_PARAM_INSERT";
    public static final String IN_PARAM_MOD = "IN_PARAM_MOD";
    public static final String IN_PARAM_DEL = "IN_PARAM_DEL";

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
        RcvUserService service = RcvUserService.getInstance();
        String mainId = null;// 从保存的实体中获取id 保存子表mainid
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        CpgUsrInf usrInf = (CpgUsrInf) context.getAttribute(IN_OPERATION);
        CpgMsgUsrTmp msgUsrTmp = new CpgMsgUsrTmp();
        CpgMsgUsrBranchTmp msgUsrBranchTmp = new CpgMsgUsrBranchTmp();// Branch
                                                                      // 暂不处理

        // List<CpgUsrInf> delList = (List<CpgUsrInf>)
        // context.getAttribute(IN_PARAM_DEL);
        List<CpgMsgUsr> insertList = (List<CpgMsgUsr>) context.getAttribute(IN_PARAM_INSERT);
        List<BctlBean> updateList = (List<BctlBean>) context.getAttribute(IN_PARAM_MOD);

        CpgUsrInfTmp usrInfTmp = new CpgUsrInfTmp();
        if (usrInf != null) {
            usrInfTmp.setUserId(usrInf.getUserId());
            usrInfTmp.setUserName(usrInf.getUserName());
            usrInfTmp.setUserType(usrInf.getUserType());
            usrInfTmp.setInnerId(usrInf.getId());
        }
        if (CMD_INSERT.equalsIgnoreCase(cmd)) {
            MsgplatformStatusUtil.setMsgStatus(usrInfTmp, MsgplatformStatusUtil.OP_ADD);
            mainId = (String) ROOTDAOUtils.getROOTDAO().save(usrInfTmp);
           
            String userId = usrInfTmp.getUserId();
            String userName = usrInfTmp.getUserName();
            String userType=usrInfTmp.getUserType();
            for (int i = 0; i < insertList.size(); i++) {
                msgUsrTmp.setInnerId(mainId);
                msgUsrTmp.setUserId(userId);
                msgUsrTmp.setSendType(insertList.get(i).getSendType());
                msgUsrTmp.setRcvInf(insertList.get(i).getRcvInf());
                MsgplatformStatusUtil.setMsgStatus(msgUsrTmp, MsgplatformStatusUtil.OP_ADD);
                // 保存发送方式到 cpg_msg_uer_tmp 表
                service.save(msgUsrTmp);
                
                CpgUsrInfTmp cpgUsrInfTmp=new CpgUsrInfTmp();
                cpgUsrInfTmp.setId(mainId);
                cpgUsrInfTmp.setInnerId("");
                cpgUsrInfTmp.setUserId(userId);
                cpgUsrInfTmp.setUserName(userName);
                MsgplatformStatusUtil.setMsgStatus(cpgUsrInfTmp, MsgplatformStatusUtil.OP_ADD);
                service.save(cpgUsrInfTmp);
              //保存成员到CpgUsrInf表
                CpgUsrInf cpgUsrInf=new CpgUsrInf();
                cpgUsrInf.setId(mainId);
                cpgUsrInf.setUserId(userId);
                cpgUsrInf.setUserName(userName);
                cpgUsrInf.setCreator(globalInfo.getTlrno());
                cpgUsrInf.setCreatedDate(DateUtil.get14Date());
                service.save(cpgUsrInf);
                //保存成员到CpgMsgUsr表
                CpgMsgUsr cpgMsgUsr=new CpgMsgUsr();
                cpgMsgUsr.setId(mainId);
                cpgMsgUsr.setUserId(userId);
                cpgMsgUsr.setSendType("02");
                cpgMsgUsr.setCreator(globalInfo.getTlrno());
                cpgMsgUsr.setCreatedDate(DateUtil.get14Date())	;
                cpgMsgUsr.setRcvInf(insertList.get(i).getRcvInf());
                service.save(cpgMsgUsr);
            }
//            for (int i = 0; i < updateList.size(); i++) {
//                msgUsrBranchTmp.setInnerId(mainId);
//                msgUsrBranchTmp.setUserId(userId);
//                msgUsrBranchTmp.setBrno(updateList.get(i).getBrno());
//                msgUsrBranchTmp.setBrname(updateList.get(i).getBrname());
//                MsgplatformStatusUtil.setMsgStatus(msgUsrBranchTmp, MsgplatformStatusUtil.OP_ADD);
//                // 保存分行号到 CpgMsgUsrBranchTmp 表
//                service.save(msgUsrBranchTmp);
//            }
            saveLog("接收用户维护-新增");
        } else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
            MsgplatformStatusUtil.setMsgStatus(usrInfTmp, MsgplatformStatusUtil.OP_MOD);
            mainId = (String) ROOTDAOUtils.getROOTDAO().save(usrInfTmp);
            String userId = usrInfTmp.getUserId();
            String userName = usrInfTmp.getUserName();
            String userType=usrInfTmp.getUserType();
            for (int i = 0; i < insertList.size(); i++) {
                msgUsrTmp.setInnerId(mainId);
                msgUsrTmp.setUserId(userId);
                msgUsrTmp.setSendType(insertList.get(i).getSendType());
                msgUsrTmp.setRcvInf(insertList.get(i).getRcvInf());
                MsgplatformStatusUtil.setMsgStatus(msgUsrTmp, MsgplatformStatusUtil.OP_MOD);
                // 保存发送方式到 cpg_msg_uer_tmp 表
                service.save(msgUsrTmp);
                
                CpgUsrInfTmp cpgUsrInfTmp=new CpgUsrInfTmp();
                cpgUsrInfTmp.setId(mainId);
                cpgUsrInfTmp.setInnerId("");
                cpgUsrInfTmp.setUserId(userId);
                cpgUsrInfTmp.setUserName(userName);
                MsgplatformStatusUtil.setMsgStatus(cpgUsrInfTmp, MsgplatformStatusUtil.OP_MOD);
                service.save(cpgUsrInfTmp);
          
                //保存成员到CpgMsgUsr表
                CpgMsgUsr cpgMsgUsr=new CpgMsgUsr();
                List<CpgMsgUsrTmp> list=service.QuCpgMsgUsrtmp(userId);
                String  revInf=list.get(0).getRcvInf();
                List<CpgMsgUsr> list2=service.QuCpgMsgUsr(userId);
                if(list2 !=null && list2.size()>0){
                String sql="update Cpg_Msg_Usr set rcv_Inf= '"+revInf+"' where 1=1 and user_Id='"+userId+"' " ;
                service.updateBySql(sql);
                }
            }
//            for (int i = 0; i < updateList.size(); i++) {
//                msgUsrBranchTmp.setInnerId(mainId);
//                msgUsrBranchTmp.setUserId(userId);
//                msgUsrBranchTmp.setBrno(updateList.get(i).getBrno());
//                msgUsrBranchTmp.setBrname(updateList.get(i).getBrname());
//                MsgplatformStatusUtil.setMsgStatus(msgUsrBranchTmp, MsgplatformStatusUtil.OP_MOD);
//                // 保存分行号到 CpgMsgUsrBranchTmp 表
//                service.save(msgUsrBranchTmp);
//            }
            saveLog("接收用户维护-修改");

        } else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
            MsgplatformStatusUtil.setMsgStatus(usrInfTmp, MsgplatformStatusUtil.OP_DEL);
            // 删除操作只存主表
            mainId = (String) ROOTDAOUtils.getROOTDAO().save(usrInfTmp);
            String userId = usrInfTmp.getUserId();
            String userName = usrInfTmp.getUserName();
            String userType=usrInfTmp.getUserType();
            CpgUsrInfTmp cpgUsrInfTmp=new CpgUsrInfTmp();
            cpgUsrInfTmp.setId(mainId);
            cpgUsrInfTmp.setInnerId("");
            cpgUsrInfTmp.setUserId(userId);
            cpgUsrInfTmp.setUserName(userName);
            MsgplatformStatusUtil.setMsgStatus(cpgUsrInfTmp, MsgplatformStatusUtil.OP_DEL);
            service.save(cpgUsrInfTmp);
            
            CpgUsrInf   cpgUsrInf=new CpgUsrInf();
            CpgMsgUsr cpgMsgUsr=new CpgMsgUsr();
            List<CpgUsrInf> list=service.QuCpgUsrInf(userId);
            List<CpgMsgUsr> list2=service.QuCpgMsgUsr(userId);
            List< CpgMsgSndCtl> list3=service.querySnd(userId);
            String Sql1= "delete from Cpg_Usr_Inf where user_id = '" + userId + "'";
            String Sql2 =  "delete from CPG_MSG_USR where user_id = '" +userId + "'";
            String Sql3 = "delete from CPG_MSG_SND_CTL where opp_id_type = '1' and opp_id = '" + userId+ "'";
            if(list != null && list.size()>0){
            	service.deleteBySql(Sql1);
            }
            if(list2 != null && list2.size()>0){
            	service.deleteBySql(Sql2);
            }
            if(list3 != null && list3.size()>0){
            	service.deleteBySql(Sql3);
            }
            saveLog("接收用户维护-删除");
        } else if (CMD_AUDIT.equals(cmd)) {
//            List<CpgUsrInfTmp> list = (List<CpgUsrInfTmp>) context.getAttribute(IN_PARAM);
//            String approveStatusChoose = (String) context.getAttribute(IN_AUDIT_STATUS);
//            String approveResultChoose = (String) context.getAttribute(IN_AUDIT_RESULT);
//            service.auditRcvUsrInf(approveStatusChoose, approveResultChoose, list);
//            saveLog("接收用户维护-审核");
        }

    }

    private void saveLog(String bussiness) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        globalInfo.addBizLog("Updater.log",
                new String[] { globalInfo.getTlrno(),"消息平台-->" + bussiness });
        htlog.info("Updater.log", new String[] { globalInfo.getTlrno(),"消息平台-->" + bussiness });
    }

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }
}
