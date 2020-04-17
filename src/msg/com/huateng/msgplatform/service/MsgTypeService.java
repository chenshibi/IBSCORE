package com.huateng.msgplatform.service;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.msg.CpgMsgCtl;
import resource.bean.msg.CpgMsgCtlTmp;

public class MsgTypeService extends CommonService {
    private static final String DATASET_ID = "MsgTypeService";
    private static final Logger logger = Logger.getLogger(MsgTypeService.class);
    private static final HtLog htlog = HtLogFactory.getLogger(MsgTypeService.class);
    private ROOTDAO rootDao;

    /**
     * Default constructor
     */
    protected MsgTypeService() {
    }

    /**
     * get instance
     */
    public synchronized static MsgTypeService getInstance() {
        return (MsgTypeService) ApplicationContextUtils.getBean(DATASET_ID);
    }

    public <T> void delete(String id, Class classs) throws CommonException {
        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.delete(classs, id);
    }

    public <T> void save(T t) throws CommonException {
        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.saveOrUpdate(t);
    }

    public <T> void update(T t) throws CommonException {

        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.saveOrUpdate(t);

    }

    // 获得要操作的Item
    @SuppressWarnings("unchecked")
    public Iterator selectByid(String id, String hql) {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();

        try {
            return rootDAO.queryByQL(hql);
        } catch (CommonException e) {
            e.printStackTrace();
            return null;
        }

    }

    // 通过id来获取实体映射类
    @SuppressWarnings("unchecked")
    public <T> T selectById(String id, T t) {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        T t1 = null;
        try {
            t1 = (T) rootdao.query(t.getClass(), id);
        } catch (CommonException e) {
            htlog.info("对象不存在");
            e.printStackTrace();
        }
        return t1;
    }

    public void deleteBySql(String sql) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        rootdao.executeSql(sql);
    }

    public void updateBySql(String sql) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        rootdao.executeSql(sql);
    }

    public void changeStatus(CpgMsgCtl bean) throws CommonException {
        CpgMsgCtlTmp tmp = new CpgMsgCtlTmp();
        MsgplatformStatusUtil.setMsgStatus(tmp, MsgplatformStatusUtil.OP_ADD);
        if ("0".equals(bean.getStatus())) {
            tmp.setOptType("5");// 有效时则置为无效
        } else if ("1".equals(bean.getStatus())) {
            tmp.setOptType("4");// 无效时则置为有效
        }
        tmp.setMsgId(bean.getMsgId());
        tmp.setSysType(bean.getSysType());
        tmp.setMsgName(bean.getMsgName());
        tmp.setType(bean.getType());
        tmp.setSubType(bean.getSubType());
        tmp.setStatus(bean.getStatus());
        this.save(tmp);
    }

    // 审核
    public void check(CpgMsgCtlTmp tmp) throws CommonException {
        // 检查重复操作
        MsgTypeService.beforeCheck(tmp);
        MsgplatformStatusUtil.setAuditMsgStatus(tmp, "1", "");// 1-已审核,2-已拒绝
        this.save(tmp);

        // this.changeStatus(tmp.getMsgId(), tmp.getStatus());
        List<CpgMsgCtl> list;
        String hql = "select po from CpgMsgCtl po where po.msgId = '" + tmp.getMsgId() + "'";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        list = rootdao.queryByCondition(hql);
        CpgMsgCtl bean = list.get(0);
        bean.setModUser(tmp.getCreator());
        bean.setModDate(tmp.getCreatedDate());
        bean.setCheckUser(tmp.getCheckUser());
        bean.setCheckDate(tmp.getCheckDate());
        if ("0".equals(tmp.getStatus())) {
            bean.setStatus("1");
        } else if ("1".equals(tmp.getStatus())) {
            bean.setStatus("0");
        }
        this.update(bean);
    }

    // 拒绝
    public void reject(CpgMsgCtlTmp tmp) throws CommonException {
        // 检查重复操作
        MsgTypeService.beforeCheck(tmp);
        MsgplatformStatusUtil.setAuditMsgStatus(tmp, "2", "");// 1-已审核,2-已拒绝
        System.out.println("createdDate is:" + tmp.getCreatedDate());
        this.update(tmp);
    }

    public static void beforeSubmit(String opType, String msgId) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        if ("new".equals(opType)) {
            // String sql1 = "select po from CpgUsrInf po where 1=1 and
            // po.userId = '"+userId+"'";
            // List list1 = rootdao.queryByCondition(sql1);
            // if(list1 != null && list1.size() > 0){
            // ExceptionUtil.throwCommonException("操作员ID已存在，请核对！","提交操作错误");
            // }
            // String sql2 = "select po from CpgUsrInfTmp po where 1=1 and
            // po.userId = '"+userId+"' and po.optStatus = '0'";
            // List list2 = rootdao.queryByCondition(sql2);
            // if(list2 != null && list2.size() > 0){
            // ExceptionUtil.throwCommonException("操作员ID已存在，请核对！","提交操作错误");
            // }

        } else {
            String sql = "select t from CpgMsgCtlTmp t where 1=1 and t.msgId = '" + msgId + "' and t.optStatus = '0'";
            List list = rootdao.queryByCondition(sql);
            if (list != null && list.size() > 0)
                ExceptionUtil.throwCommonException("该记录已录入待审核，请勿重复提交！", "提交操作错误");
        }
    }

    public static void beforeCheck(CpgMsgCtlTmp bean) throws CommonException {
        String oprNo = GlobalInfo.getCurrentInstance().getTlrno();
        String creator = bean.getCreator();
        if (oprNo.equals(creator)) {
            ExceptionUtil.throwCommonException("审核和录入是同一操作人，不能审核！\r\n", "审核操作错误");
        }

        String sql = "select po from CpgMsgCtlTmp po where po.id = '" + bean.getId() + "'";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<CpgMsgCtlTmp> list = rootdao.queryByCondition(sql);
        String optStatus = list.get(0).getOptStatus();
        if (!"0".equals(optStatus)) {
            ExceptionUtil.throwCommonException("该记录已被审核，请勿重复提交！", "提交操作错误");
        }
    }

}
