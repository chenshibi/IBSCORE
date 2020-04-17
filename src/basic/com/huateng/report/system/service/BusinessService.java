package com.huateng.report.system.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.utils.ReportEnum;

import resource.bean.basic.PfSysParam;
import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.basic.SysTaskInfo;

/*
 * 系统参数service
 *
 */
public class BusinessService {
    private static final HtLog htlog = HtLogFactory.getLogger(BusinessService.class);

    /*
     * 获得自身的实例
     *
     */
    public static synchronized BusinessService getInstance() {
        return (BusinessService) ApplicationContextUtils.getBean("businessService");
    }

    /*
     * 分页查询
     * 
     * @param paramgroupId 参数段编号
     */

    public PageQueryResult pageQueryByHql(int pageIndex, int maxRows, String paramgroupId, String qst) {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        PageQueryResult pageQueryResult = null;
        PageQueryCondition queryCondition = new PageQueryCondition();
        ArrayList<String> condList = new ArrayList<String>();
        String hql = "from SysParams sysParams where sysParams.del='F' and sysParams.sys_name='CCIS'";
        if (paramgroupId != null && !"".equals(paramgroupId)) {
            hql += ("and sysParams.id.paramgroupId like ? ");
            condList.add("%" + paramgroupId.trim() + "%");
        }
        if (qst != null && qst.length() > 0) {
            hql += " and sysParams.st = ? ";
            condList.add(qst);
        } else {
            hql += " and sysParams.st<>'" + ReportEnum.REPORT_ST1.N.value + "'";
        }

        try {
            queryCondition.setQueryString(hql);
            queryCondition.setPageIndex(pageIndex);
            queryCondition.setPageSize(maxRows);
            queryCondition.setObjArray(condList.toArray());
            pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pageQueryResult;
    }
    /*
     *
     * 参数段编号下拉框(获得所有参数段编号,不是模糊筛选框)
     *
     */

    public List<SysParams> paramgroupIdSelect() {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        String hql = "select distinct sysParams.id.paramgroupId from SysParams sysParams ";
        List<SysParams> list = new ArrayList<SysParams>();
        try {
            Iterator it = (Iterator) rootDAO.queryByQL(hql);
            while (it.hasNext()) {
                SysParams sysParamsTemp = new SysParams();
                SysParamsPK sysParamsPKTemp = new SysParamsPK();
                sysParamsPKTemp.setParamgroupId((String) it.next());
                sysParamsTemp.setId(sysParamsPKTemp);
                list.add(sysParamsTemp);
            }
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /*
     *
     * 参数段编号下拉框(获得所有参数段编号,模糊筛选框)
     * 
     * @param paramgroupId
     */
    public PageQueryResult paramgroupIdSelect(int pageIndex, int pageSize, String paramgroupId) {
        String hql = "from SysParams sysParams where sysParams.sys_name = 'CCIS' ";
        if (StringUtils.isNotBlank(paramgroupId))
            hql += " and sysParams.id.paramgroupId like '" + paramgroupId + "'";
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        // PageQueryCondition queryCondition = new PageQueryCondition();
        // queryCondition.setPageIndex(pageIndex);
        // queryCondition.setPageSize(pageSize);
        // queryCondition.setQueryString(hql);
        List<SysParams> list = new ArrayList<SysParams>();
        Set<String> set = new HashSet<String>();
        PageQueryResult pageQueryResult = new PageQueryResult();
        try {
            List<SysParams> tempList = rootDAO.queryByQL2List((hql));
            // 去除重复的参数段编号
            for (SysParams o : tempList) {
                // SysParams sysParams = (SysParams) ((Object[]) o)[0];
                set.add(o.getId().getParamgroupId());
            }
            for (String s : set) {
                SysParams sysParamsTemp = new SysParams();
                SysParamsPK sysParamsPKTemp = new SysParamsPK();
                sysParamsPKTemp.setParamgroupId(s);
                sysParamsTemp.setId(sysParamsPKTemp);
                list.add(sysParamsTemp);
            }
            pageQueryResult.setQueryResult(list);
            pageQueryResult.setTotalCount(list.size());
        } catch (CommonException e) {
            e.printStackTrace();
        }
        return pageQueryResult;
    }

    /*
     * 更新系统参数
     * 
     * @param sysParams
     *
     */
    public void mergeSysParamsEntity(SysParams sysParams) {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        try {
            rootDAO.update(sysParams);

        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     *
     * 查询某条需要修改的ITEM
     */
    public Iterator selectByid(String paramgroupid, String paramid) {

        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();

        try {
            return rootDAO.queryByQL("from SysParams sysParams where sysParams.id.paramgroupId='" + paramgroupid
                    + "'and sysParams.id.paramId='" + paramid + "'");
            // return rootDAO.queryBySQL("select * from sys_params where
            // PARAMGROUP_ID ='"+paramgroupid+"' and PARAM_ID='"+paramid+"'"
            // );
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    /*
     * 对象序列化后写入taskinfo auto by 计翔
     */
    public void addTosystaskinfo(SysTaskInfo systackinfo) {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        try {
            rootDAO.saveOrUpdate(systackinfo);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 通过联合主键来获取操作对象
    public SysParams selectById(SysParamsPK id) {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        SysParams sysparams = null;
        try {

            sysparams = (SysParams) rootdao.query(SysParams.class, id);

        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return sysparams;
    }

    // 通过联合主键来获取操作对象
    public String getParaVal(String paramgroupId, String paramId) {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        SysParams sysparams = null;
        try {

            sysparams = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(paramgroupId, paramId));
            if (sysparams == null || sysparams.getParamVal() == null) {
                return null;
            } else {
                return sysparams.getParamVal().trim();
            }

        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /*
     * 获取安全参数操作对象 public PfSysParam selectId(PfSysParamPK id){ ROOTDAO
     * rootdao=ROOTDAOUtils.getROOTDAO(); PfSysParam pfsysparam = null; try {
     * 
     * pfsysparam= (PfSysParam)rootdao.query(PfSysParam.class, id);
     * 
     * } catch (CommonException e) { // TODO Auto-generated catch block
     * e.printStackTrace(); }
     * 
     * return pfsysparam; }
     * 
     */
    public Iterator selectID(String magicId, String paramId) {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        try {
            return rootDAO.queryByQL("from PfSysParam pfsysparam where pfsysparam.id.magicId='" + magicId
                    + "'and pfsysparam.id.paramId='" + paramId + "'");
        } catch (CommonException e) {

            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Description 安全参数查询
     * @return
     * @throws CommonException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public PageQueryResult querySysParam(int pageIndex, int pageSize, String qst) throws CommonException {
        StringBuffer sb = new StringBuffer("");
        sb.append(" FROM PfSysParam WHERE id.paramId = 'PSWD'");

        Object[] parameters = null;
        if (StringUtils.isNotBlank(qst)) {
            sb.append(" AND st = ? ");
            parameters = new Object[] { qst };
        }

        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(sb.toString());
        if (null != parameters) {
            queryCondition.setObjArray(parameters);
        }

        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);

        PageQueryResult pageQueryResult = rootdao.pageQueryByQL(queryCondition);
        return pageQueryResult;
    }

    /**
     *
     * @desc 安全参数修改
     * @param param
     * @throws CommonException
     */
    public void saveSecParam(PfSysParam param) throws CommonException {

        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

        PfSysParam sysparam = (PfSysParam) rootdao.query(PfSysParam.class, param.getId());
        sysparam.setParamValueTx(param.getParamValueTx());
        rootdao.update(sysparam);
        GlobalInfo.getCurrentInstance().addBizLog("Updater.log",
                new String[] { gi.getTlrno(),  "修改安全参数" });
        htlog.info("Updater.log", new String[] { gi.getTlrno(),  "修改安全参数" });

    }

    public void savePfParam(PfSysParam param) {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        try {
            rootdao.saveOrUpdate(param);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
