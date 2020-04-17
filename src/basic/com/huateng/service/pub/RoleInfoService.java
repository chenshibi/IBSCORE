package com.huateng.service.pub;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.bean.CustAdminOperatorBean;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.FunctionInfo;
import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.RoleInfo;
import resource.bean.basic.TlrInfo;
import resource.bean.basic.TlrRoleRel;
import resource.bean.basic.view.FunctionInfoView;
import resource.bean.basic.view.RoleInfoView;
import resource.dao.basic.RoleInfoDAO;

/**
 * @author hyurain_yang
 * @date 2008/7/2
 * @desc 角色控制表service
 */
public class RoleInfoService {
    private static final Logger logger = Logger.getLogger(RoleInfoService.class);

    protected RoleInfoService() {
    }

    /**
     * get instance.
     *
     * @return
     */
    public synchronized static RoleInfoService getInstance() {
        return (RoleInfoService) ApplicationContextUtils.getBean(RoleInfoService.class.getName());
    }

    /**
     * 检查是否为总行
     */
    public void checkBrcode() throws CommonException {
        String brcode = GlobalInfo.getCurrentInstance().getBrcode();
        String brclass = BctlService.getInstance().getBrclass(brcode);
        if (!brclass.equals(SystemConstant.BRCODE_CLASS_HEAD)) {

            ExceptionUtil.throwCommonException("您不是总行，无权进行角色权限设置", ErrorCode.ERROR_CODE_NO_PERMISSION);
        }
    }

    /**
     * 修改角色权限
     *
     * @param list
     * @throws CommonException
     */
    public void updateRoleInfoFuncService(List mylist) throws CommonException {
        // this.checkBrcode();
        String role_id = "";
        for (int i = 0; i < mylist.size(); i++) {
            FunctionInfoView finfoview = (FunctionInfoView) mylist.get(i);
            role_id = finfoview.getRoleid();
            List list2 = BaseDAOUtils.getRoleFuncRelDAO().queryByCondition(
                    "po.funcCode='" + String.valueOf(finfoview.getFunccode()) + "'  and po.roleId='" + role_id + "'");
            RoleFuncRel rfinfo = null;
            // role_id funcCode对存在 role_Func_Relation中
            if (list2 != null && list2.size() != 0)
                rfinfo = (RoleFuncRel) list2.get(0);
            if (rfinfo == null && finfoview.isSelect()) {
                // 如果不存在，但是被选中，插入
                RoleFuncRel rfinfo2 = new RoleFuncRel();

                rfinfo2.setFuncid(finfoview.getFunccode());
                rfinfo2.setRoleId((role_id));
                BaseDAOUtils.getRoleFuncRelDAO().insert(rfinfo2);
            } else if (rfinfo != null && !finfoview.isSelect())
                // 原来存在但是没有选中 删除
                BaseDAOUtils.getRoleFuncRelDAO().delete(rfinfo);
        }
    }

    /**
     * 修改角色报表权限
     *
     * @param list
     * @throws CommonException
     */
    public void updateRoleInfoReportService(List mylist) throws CommonException {
        // this.checkBrcode();
        // int role_id = 0;
        //
        // for (int i = 0; i < mylist.size(); i++) {
        // ReportInfoView infoview = (ReportInfoView) mylist.get(i);
        // role_id = infoview.getRoleid();
        // List list2 = BaseDAOUtils.getRoleReportParamDAO().queryByCondition(
        // "po.reportType='" + String.valueOf(infoview.getReporttype()) + "' and
        // po.roleId=" + role_id);
        // RoleReportParam param = null;
        //
        // if (list2 != null && list2.size() != 0)
        // param = (RoleReportParam) list2.get(0);
        //
        // if (param == null && infoview.isSelected()) {
        // // 如果不存在，但是被选中，插入
        // RoleReportParam param2 = new RoleReportParam();
        // param2.setReportType(infoview.getReporttype());
        // param2.setRoleId(new Integer(role_id));
        // BaseDAOUtils.getRoleReportParamDAO().insert(param2);
        // } else if (param != null && !infoview.isSelected())
        // // 原来存在但是没有选中 删除
        // BaseDAOUtils.getRoleReportParamDAO().delete(param);
        // }
    }

    /**
     * 获得角色交易权限
     *
     * @param RoleInfoView
     *            riv
     * @throws Exception
     */
    public List getRoleInfoFuncData(RoleInfoView riv) throws Exception {
        List<FunctionInfo> list;
        List<FunctionInfoView> list2;
        List<RoleFuncRel> tlist;
        RoleInfo roleInfo = BaseDAOUtils.getRoleInfoDAO().query(riv.getRoleid());
        // String roleName = riv.getRolename();
        list2 = new ArrayList();
        list = BaseDAOUtils.getFunctionInfoDAO()
                .queryByCondition("po.menuFlag = '1' and po.status = '1' order by po.funcCode");
        tlist = BaseDAOUtils.getRoleFuncRelDAO().queryByCondition(" po.roleId = '" + riv.getRoleid() + "'");
        for (int i = 0; i < list.size(); i++) {
            FunctionInfo finfo = (FunctionInfo) list.get(i);
            FunctionInfoView fview = new FunctionInfoView();
            String funccode = finfo.getId();

            if (existForFunc(tlist, funccode)) {
                fview.setSelect(true);
            } else {
                fview.setSelect(false);
            }
            fview.setFunccode(finfo.getId());
            fview.setFuncname(finfo.getFuncname());
            fview.setRoleid(riv.getRoleid());
            fview.setRolename(roleInfo.getRoleName());
            list2.add(fview);
        }
        return list2;
    }

    private boolean existForFunc(List list, String funcCode) {
        for (int i = 0; i < list.size(); i++) {
            RoleFuncRel rfr = (RoleFuncRel) list.get(i);
            if (rfr.getFuncid().equals(funcCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Description: 根据角色编号获取角色信息
     *
     * @param
     * @return RoleInfo
     * @exception @author
     *                shen_antonio
     * @version v1.0,2008-8-25
     */
    public RoleInfo getRoleInfoByRoleId(String roleId) throws CommonException {
        RoleInfo roleInfo = BaseDAOUtils.getRoleInfoDAO().query(roleId);
        return roleInfo;
    }

    /*-----------------------------------------------------*/
    /**
     * 获得角色报表权限-----为编译通过，暂时注释掉
     *
     * @param RoleInfoView
     *            riv
     * @throws CommonException
     * @throws Exception
     */
    public List getRoleInfoReportData(RoleInfoView riv) throws CommonException {
        // int role_id = Integer.parseInt(riv.getRoleid());
        // RoleInfo roleInfo = BaseDAOUtils.getRoleInfoDAO().query(role_id);
        // // role_id = Integer.parseInt(riv.getRoleid());
        // // String roleName = riv.getRolename();
        //
        List list2 = new ArrayList();
        // List list = BaseDAOUtils.getReportInfoDAO().queryByCondition("1=1");
        // List tlist =
        // BaseDAOUtils.getRoleReportParamDAO().queryByCondition("po.roleId = "
        // + role_id);
        // for (int i = 0; i < list.size(); i++) {
        // ReportInfo ri = (ReportInfo) list.get(i);
        // ReportInfoView rview = new ReportInfoView();
        // rview.setRoleid(role_id);
        // rview.setRoleName(roleInfo.getRoleName());
        // rview.setReporttype(ri.getReportType());
        // rview.setReportname(ri.getReportName());
        //
        // if (existForReport(tlist, ri.getReportType())) {
        // rview.setSelected(true);
        // } else {
        // rview.setSelected(false);
        // }
        // list2.add(rview);
        // }
        return list2;
    }

    /**
     *
     * Description: 通过角色名称获取角色编号
     *
     * @param
     * @return RoleInfo
     * @exception @author
     *                hyurain_yang
     * @version v1.0,2008-9-18
     */
    public RoleInfo getRoleInfoByRoleName(String roleName) throws CommonException {
        RoleInfoDAO dao = BaseDAOUtils.getRoleInfoDAO();
        List list = null;
        RoleInfo roleInfo = null;
        list = dao.queryByCondition("po.roleName=?", new Object[] { roleName }, null);
        if (list.size() == 0) {
            ExceptionUtil.throwCommonException("没有符合条件的对象", "default");
        } else {
            roleInfo = (RoleInfo) list.get(0);
        }
        return roleInfo;
    }

    /***************************************************************************
     * 为编译通过，暂时注释掉
     **************************************************************************/
    private boolean existForReport(List list, String reportType) {
        // for (int i = 0; i < list.size(); i++) {
        // RoleReportParam rrp = (RoleReportParam) list.get(i);
        // if (rrp.getReportType().equals(reportType)) {
        // return true;
        // }
        // }
        return false;
    }

    /*-----------------------------------------------------*/

    /**
     * @author fubo
     * @Description 角色信息查询
     * @return
     * @throws CommonException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public PageQueryResult queryRole(int pageIndex, int pageSize)
            throws CommonException, IllegalAccessException, InvocationTargetException {
        StringBuffer sb = new StringBuffer("");
        sb.append("select roleInfo from RoleInfo roleInfo where 1=1");
       // sb.append(" and brno = ").append(GlobalInfo.getCurrentInstance().getBrno()).append("");
        /** add by zhiyang.he 双岗复核，无效状态过滤 2012-09-07 begin */
        sb.append(" and (st <> 5 or st is null )");
        /** add by zhiyang.he 双岗复核，无效状态过滤 2012-09-07 end */
        sb.append(" order by roleInfo.id ");
        HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(sb.toString());
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);
        Iterator iter = pageQueryResult.getQueryResult().iterator();
        List<RoleInfo> outList = new ArrayList<RoleInfo>();
        while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();
            RoleInfo roleInfo = (RoleInfo) obj[0];
            outList.add(roleInfo);
        }
        pageQueryResult.setQueryResult(outList);
        System.out.println("pageQueryResult.getTotalCount() = " + pageQueryResult.getTotalCount());
        return pageQueryResult;
    }

    /**
     * @author fubo
     * @desc 角色增删改
     * @param insertList
     * @param delList
     * @param updateList
     * @throws CommonException
     */
    public void saveCustRole(List<RoleInfo> insertList, List<RoleInfo> delList, List<RoleInfo> updateList)
            throws CommonException {

        GlobalInfo gi = GlobalInfo.getCurrentInstance();

        RoleInfoDAO roleInfoDAO = BaseDAOUtils.getRoleInfoDAO();

        // 新增角色
        for (RoleInfo bean : insertList) {
            RoleInfo roleInfo = null;

            // mod by zhaozhiguo 2012/2/16 FPP-9 用户,角色及机构的管理页面优化调整 begin
            roleInfo = new RoleInfo();
            // roleInfo = roleInfoDAO.findById(bean.getId());
            // if (roleInfo != null) {
            // ExceptionUtil.throwCommonException("已经存在角色编号："
            // + roleInfo.getId() + "，不能新增此角色",
            // ErrorCode.ERROR_CODE_CANNOT_SUBMIT);
            // } else {
            // roleInfo = new RoleInfo();
            // }
            //
            // roleInfo.setId(bean.getId());
            // mod by zhaozhiguo 2012/2/16 FPP-9 用户,角色及机构的管理页面优化调整 end
            roleInfo.setEffectDate(bean.getEffectDate());
            roleInfo.setExpireDate(bean.getExpireDate());
            roleInfo.setStatus(bean.getStatus());
            roleInfo.setRoleName(bean.getRoleName());
            roleInfo.setLastUpdDate(DateUtil.get14Time());
            roleInfo.setBrclass(bean.getBrclass());
            roleInfo.setLastUpdTlr(gi.getTlrno());
            roleInfo.setLastUpdFunc("");
            roleInfo.setMisc("");
            roleInfo.setMiscflgs("");
            roleInfo.setTimestamps(DateUtil.get14Time());

            roleInfoDAO.save(roleInfo);
        }

        // 删除角色
        for (RoleInfo roleInfo : delList) {
            try {
                roleInfo.setStatus(SystemConstant.FLAG_OFF);
                roleInfoDAO.update(roleInfo);
            } catch (Exception e) {
                ExceptionUtil.throwCommonException("保存失败！", "角色号为：" + roleInfo.getId() + "删除失败");
            }
        }

        // 跟新角色
        for (RoleInfo bean : updateList) {
            RoleInfo roleInfo = new RoleInfo();
            if (!DataFormat.isNull(bean.getId())) {
                roleInfo = roleInfoDAO.findById(bean.getId());

                roleInfo.setEffectDate(bean.getEffectDate());
                roleInfo.setExpireDate(bean.getExpireDate());
                roleInfo.setRoleName(bean.getRoleName());
                roleInfo.setStatus(bean.getStatus());
                roleInfo.setBrclass(bean.getBrclass());
                roleInfo.setLastUpdDate(DateUtil.get14Time());
                roleInfo.setLastUpdTlr(gi.getTlrno());
                roleInfoDAO.update(roleInfo);
            }
        }
    }

    /**
     * @author fubo
     * @desc 查询特定角色下人员信息
     * @param roleId
     * @param pageSize
     * @param pageIndex
     * @return
     * @throws CommonException
     */
    public List queryRoleInfo(String roleId, int pageIndex, int pageSize) throws CommonException {

        HQLDAO dao = BaseDAOUtils.getHQLDAO();
        RoleInfo roleInfo = (RoleInfo) dao.getHibernateTemplate().get(RoleInfo.class, roleId);
        ArrayList<String> condList = new ArrayList<String>();
        StringBuffer tlrRoleRel = new StringBuffer("select tlrRole from TlrRoleRel tlrRole where tlrRole.roleId = ? ");
        condList.add(roleId);
        List<TlrRoleRel> listRole = dao.queryByQL2List(tlrRoleRel.toString(), condList.toArray(), null);
        List<TlrInfo> listInfo = null;
        CustAdminOperatorBean outCust = null;
        List<CustAdminOperatorBean> resultList = new ArrayList<CustAdminOperatorBean>();
        PageQueryResult pageQueryResult = new PageQueryResult();

        if (null == listRole || listRole.size() == 0) {
            outCust = new CustAdminOperatorBean();
            outCust.setId(roleId);
            outCust.setRoleName(roleInfo.getRoleName());
            resultList.add(outCust);
        } else {
            for (TlrRoleRel tlrRole : listRole) {
                ArrayList<String> condList1 = new ArrayList<String>();
                StringBuffer sb = new StringBuffer("select tlr from TlrInfo tlr where tlr.tlrno =  ? ");
                sb.append(" order by tlr.tlrno ");
                condList1.add(tlrRole.getTlrno());
                listInfo = dao.queryByQL2List(sb.toString(), condList1.toArray(), null);

                for (TlrInfo tlrInfo : listInfo) {
                    outCust = new CustAdminOperatorBean();

                    outCust.setId(roleId);
                    outCust.setRoleName(roleInfo.getRoleName());
                    outCust.setTlrno(tlrInfo.getTlrno());
                    outCust.setTlrName(tlrInfo.getTlrName());
                    outCust.setStatus(tlrInfo.getStatus());
                    outCust.setLastaccesstm(tlrInfo.getLastaccesstm());
                    outCust.setFlag(tlrInfo.getFlag());
                    resultList.add(outCust);
                }

            }
        }

        return resultList;
    }

    /**
     * 查询所有角色信息
     *
     * @throws CommonException
     */
    public List selectAllRoleInfoService() throws CommonException {
        RoleInfoDAO roleInfoDao = BaseDAOUtils.getRoleInfoDAO();
        List info = roleInfoDao.queryByCondition("1=1 order by po.status desc,po.id");
        return info;
    }

    /**
     * @author fubo
     * @Description 角色信息查询
     * @return
     * @throws CommonException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public PageQueryResult queryRoleByRolegroup(int pageIndex, int pageSize, String rolename, String rolegroup)
            throws CommonException, IllegalAccessException, InvocationTargetException {
        StringBuffer sb = new StringBuffer("");
        ArrayList<String> condList = new ArrayList<String>();
        sb.append("select roleInfo from RoleInfo roleInfo where 1=1");
       // sb.append(" and brno = ").append(GlobalInfo.getCurrentInstance().getBrno()).append("");
        /** add by zhiyang.he 双岗复核，无效状态过滤 2012-09-07 begin */
        sb.append(" and (st <> 5 or st is null )");
        if (!DataFormat.isEmpty(rolename)) {
            sb.append(" and roleName like ? ");
            condList.add("%" + rolename + "%");
        }

        if (!DataFormat.isEmpty(rolegroup)) {
            sb.append(" and roleGroup = ? ");
            condList.add(rolegroup);
        }
        /** add by zhiyang.he 双岗复核，无效状态过滤 2012-09-07 end */
        sb.append(" order by roleInfo.id ");
        HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(sb.toString());
        queryCondition.setObjArray(condList.toArray());
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        PageQueryResult pageQueryResult = hqlDAO.pageQueryByQL(queryCondition);
        Iterator iter = pageQueryResult.getQueryResult().iterator();
        List<RoleInfo> outList = new ArrayList<RoleInfo>();
        while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();
            RoleInfo roleInfo = (RoleInfo) obj[0];
            outList.add(roleInfo);
        }
        pageQueryResult.setQueryResult(outList);
        System.out.println("pageQueryResult.getTotalCount() = " + pageQueryResult.getTotalCount());
        return pageQueryResult;
    }

}
