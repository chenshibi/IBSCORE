/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common;

import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.dao.*;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;

import resource.dao.basic.BctlDAO;
import resource.dao.basic.BizFuncInfoDAO;
import resource.dao.basic.BranchFuncRelDAO;
import resource.dao.basic.CurcdMapDAO;
import resource.dao.basic.DataDicDAO;
import resource.dao.basic.FunctionInfoDAO;
import resource.dao.basic.PfSysParamDAO;
import resource.dao.basic.RoleFuncRelDAO;
import resource.dao.basic.RoleInfoDAO;
import resource.dao.basic.SysParamsDAO;
import resource.dao.basic.SysTaskInfoDAO;
import resource.dao.basic.TblBizLogDAO;
import resource.dao.basic.TlrBctlRelDAO;
import resource.dao.basic.TlrInfoDAO;
import resource.dao.basic.TlrRoleRelDAO;
import resource.dao.boa.CustChildConnectDAO;
import resource.dao.boa.CustHolidayDAO;
import resource.dao.boa.CustReportDtlDAO;
import resource.dao.boa.CustStepInfoDAO;
import resource.dao.msg.CpgMsgUsrBranchDAO;
import resource.dao.msg.CpgMsgUsrDAO;
import resource.dao.msg.CpgUsrInfDAO;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen </a>
 * @version $Revision: 1.23 $
 *
 *          用来获得DAO实例的工具类. 主要是避免DAO的名称在各处的使用而导致以后修改出现困难.
 */
public class BaseDAOUtils {

    public static TblBizLogDAO getTblBizLogDAO() {
        return (TblBizLogDAO) ApplicationContextUtils.getBean("TblBizLogDAO");
    }

    final public static HQLDAO getHQLDAO() {
        return (HQLDAO) ApplicationContextUtils.getBean("HQLDAO");
    }

    final public static BctlDAO getBctlDAO() {
        return (BctlDAO) ApplicationContextUtils.getBean("BctlDAO");
    }

    final public static BranchFuncRelDAO getBranchFuncRelDAO() {
        return (BranchFuncRelDAO) ApplicationContextUtils.getBean("BranchFuncRelDAO");
    }

    final public static DataDicDAO getDataDicDAO() {
        return (DataDicDAO) ApplicationContextUtils.getBean("DataDicDAO");
    }

    final public static FunctionInfoDAO getFunctionInfoDAO() {
        return (FunctionInfoDAO) ApplicationContextUtils.getBean("FunctionInfoDAO");
    }

    final public static PfSysParamDAO getPfSysParamDAO() {
        return (PfSysParamDAO) ApplicationContextUtils.getBean("PfSysParamDAO");
    }

    final public static RoleFuncRelDAO getRoleFuncRelDAO() {
        return (RoleFuncRelDAO) ApplicationContextUtils.getBean("RoleFuncRelDAO");
    }

    final public static RoleInfoDAO getRoleInfoDAO() {
        return (RoleInfoDAO) ApplicationContextUtils.getBean("RoleInfoDAO");
    }

    final public static SysTaskInfoDAO getSysTaskInfoDAO() {
        return (SysTaskInfoDAO) ApplicationContextUtils.getBean("SysTaskInfoDAO");
    }

    final public static TlrInfoDAO getTlrInfoDAO() {
        return (TlrInfoDAO) ApplicationContextUtils.getBean("TlrInfoDAO");
    }

    final public static TlrBctlRelDAO getTlrBctlRelDAO() {
        return (TlrBctlRelDAO) ApplicationContextUtils.getBean("TlrBctlRelDAO");
    }

    final public static TlrRoleRelDAO getTlrRoleRelDAO() {
        return (TlrRoleRelDAO) ApplicationContextUtils.getBean("TlrRoleRelDAO");
    }

    public static BizFuncInfoDAO getBizFuncInfoDAO() {
        return (BizFuncInfoDAO) ApplicationContextUtils.getBean("BizFuncInfoDAO");
    }

    public static CustStepInfoDAO getCustStepInfoDAO() {
        return (CustStepInfoDAO) ApplicationContextUtils.getBean("CustStepInfoDAO");
    }

    public static CpgMsgUsrDAO getCpgMsgUsrDAO() {
        return (CpgMsgUsrDAO) ApplicationContextUtils.getBean("CpgMsgUsrDAO");
    }

    public static CpgUsrInfDAO getCpgUsrInfDAO() {
        return (CpgUsrInfDAO) ApplicationContextUtils.getBean("CpgUsrInfDAO");
    }

    public static CpgMsgUsrBranchDAO getCpgMsgUsrBranchDAO() {
        return (CpgMsgUsrBranchDAO) ApplicationContextUtils.getBean("CpgMsgUsrBranchDAO");
    }

    public static CustHolidayDAO getCustHolidayDAO() {
        return (CustHolidayDAO) ApplicationContextUtils.getBean("CustHolidayDAO");
    }

    public static CustChildConnectDAO getCustChildConnectDAO() {
        return (CustChildConnectDAO) ApplicationContextUtils.getBean("CustChildConnectDAO");
    }

    public static CustReportDtlDAO getCustReportDtlDAO() {
        return (CustReportDtlDAO) ApplicationContextUtils.getBean("CustReportDtlDAO");
    }

    public static CurcdMapDAO getCurcdMapDAO() {
        return (CurcdMapDAO) ApplicationContextUtils.getBean("CurcdMapDAO");
    }
    
    public static PbocQueryHistoryQueryDAO getPbocQueryHistoryQueryDAO() {
        return (PbocQueryHistoryQueryDAO) ApplicationContextUtils.getBean("PbocQueryHistoryQueryDAO");
    }
    
    public static CrPbocD103DAO getCrPbocD103DAO(){
    	return (CrPbocD103DAO)ApplicationContextUtils.getBean(CrPbocD103DAO.class);
    }
    
    public static CrComEa01chDAO getCrComEa01chDao() {
    	return (CrComEa01chDAO)ApplicationContextUtils.getBean(CrComEa01chDAO.class);
    }
    
    public static CollateralEa01ahDao getCollateralEa01ahDao() {
    	return (CollateralEa01ahDao)ApplicationContextUtils.getBean(CollateralEa01ahDao.class);
    }
    
    public static CrComEaaDAO getCrComEaaDAO() {
        return (CrComEaaDAO)ApplicationContextUtils.getBean(CrComEaaDAO.class);
    }
    
    public static CollateralEaaDao getCollateralEaaDao() {
    	 return (CollateralEaaDao)ApplicationContextUtils.getBean(CollateralEaaDao.class);
    }
    
    public static CrComEb02ahDAO getCrComEb02ahDAO() {
    	return (CrComEb02ahDAO)ApplicationContextUtils.getBean(CrComEb02ahDAO.class);
    }
    
    public static CrComEb02bhDAO getCrComEb02bhDAO() {
        return (CrComEb02bhDAO)ApplicationContextUtils.getBean(CrComEb02bhDAO.class);
    }
    
    public static CrComEb02chDAO getCrComEb02chDAO() {
    	return (CrComEb02chDAO)ApplicationContextUtils.getBean(CrComEb02chDAO.class);
    }
    
    public static CrComEb03ahDAO getCrComEb03ahDAO() {
    	return (CrComEb03ahDAO)ApplicationContextUtils.getBean(CrComEb03ahDAO.class);
    }
    
    public static CrComEb03bhDAO getCrComEb03bhDAO() {
    	return (CrComEb03bhDAO)ApplicationContextUtils.getBean(CrComEb03bhDAO.class);
    }
    
    public static CrComEb05ahDAO getCrComEb05ahDAO() {
    	return (CrComEb05ahDAO)ApplicationContextUtils.getBean(CrComEb05ahDAO.class);
    }
    
    public static CrComEb05bhDAO getCrComEb05bhDAO() {
    	return (CrComEb05bhDAO)ApplicationContextUtils.getBean(CrComEb05bhDAO.class);
    }
    
    public static CrComEbaDAO getCrComEbaDAO() {
    	return (CrComEbaDAO)ApplicationContextUtils.getBean(CrComEbaDAO.class);
    }
    
    public static CrComEbbDAO getCrComEbbDAO() {
    	return (CrComEbbDAO)ApplicationContextUtils.getBean(CrComEbbDAO.class);
    }
    
    public static CrComEbcDAO getCrComEbcDAO() {
    	return (CrComEbcDAO)ApplicationContextUtils.getBean(CrComEbcDAO.class);
    }
    
    public static CrComEbdDAO getCrComEbdDAO() {
    	return (CrComEbdDAO)ApplicationContextUtils.getBean(CrComEbdDAO.class);
    }
    
    public static CrComEbeDAO getCrComEbeDAO() {
    	return (CrComEbeDAO)ApplicationContextUtils.getBean(CrComEbeDAO.class);
    }
    
    public static CrComEc020hDAO getCrComEc020hDAO() {
    	return (CrComEc020hDAO)ApplicationContextUtils.getBean(CrComEc020hDAO.class);
    }
    
    public static CrComEc030hDAO getCrComEc030hDAO() {
    	return (CrComEc030hDAO)ApplicationContextUtils.getBean(CrComEc030hDAO.class);
    }
    
    public static CrComEc050hDAO getCrComEc050hDAO() {
    	return (CrComEc050hDAO)ApplicationContextUtils.getBean(CrComEc050hDAO.class);
    }
    
    public static CrComEcaDAO getCrComEcaDAO() {
    	return (CrComEcaDAO)ApplicationContextUtils.getBean(CrComEcaDAO.class);
    }
    
    public static CrComEd01bDAO getCrComEd01bDAO() {
    	return (CrComEd01bDAO)ApplicationContextUtils.getBean(CrComEd01bDAO.class);
    }
    
    public static CrComEd01bhDAO getCrComEd01bhDAO() {
    	return (CrComEd01bhDAO)ApplicationContextUtils.getBean(CrComEd01bhDAO.class);
    }
    
    public static CrComEd01cDAO getCrComEd01cDAO() {
    	return (CrComEd01cDAO)ApplicationContextUtils.getBean(CrComEd01cDAO.class);
    }
    
    public static CrComEd01chDAO getCrComEd01chDAO() {
    	return (CrComEd01chDAO)ApplicationContextUtils.getBean(CrComEd01chDAO.class);
    }
    
    public static CrComEd01DAO getCrComEd01DAO() {
    	return (CrComEd01DAO)ApplicationContextUtils.getBean(CrComEd01DAO.class);
    }
    
    public static CrComEd02DAO getCrComEd02DAO() {
        return (CrComEd02DAO)ApplicationContextUtils.getBean(CrComEd02DAO.class);
    }
    
    public static CrComEd03DAO getCrComEd03DAO() {
        return (CrComEd03DAO)ApplicationContextUtils.getBean(CrComEd03DAO.class);
    }
    public static CrComEd04DAO getCrComEd04DAO() {
        return (CrComEd04DAO)ApplicationContextUtils.getBean(CrComEd04DAO.class);
    }
    
    public static CrComEd04bDAO getCrComEd04bDAO() {
    	return  (CrComEd04bDAO)ApplicationContextUtils.getBean(CrComEd04bDAO.class);
    }
    
    public static CrComEd05DAO getCrComEd05DAO() {
        return (CrComEd05DAO)ApplicationContextUtils.getBean(CrComEd05DAO.class);
    }
    
    
    public static CrComEd07DAO getCrComEd07DAO() {
        return (CrComEd07DAO)ApplicationContextUtils.getBean(CrComEd07DAO.class);
    }
    
    
    public static CrComEd08DAO getCrComEd08DAO() {
        return (CrComEd08DAO)ApplicationContextUtils.getBean(CrComEd08DAO.class);
    }
    
    
    public static CrComEd09DAO getCrComEd09DAO() {
        return (CrComEd09DAO)ApplicationContextUtils.getBean(CrComEd09DAO.class);
    }
    
    public static CrComEdaDAO getCrComEdaDAO() {
        return (CrComEdaDAO)ApplicationContextUtils.getBean(CrComEdaDAO.class);
    }
    
    public static CrComEdbDAO getCrComEdbDAO() {
        return (CrComEdbDAO)ApplicationContextUtils.getBean(CrComEdbDAO.class);
    }
    
    public static CrComEdcDAO getCrComEdcDAO() {
    	 return (CrComEdcDAO)ApplicationContextUtils.getBean(CrComEdcDAO.class);
    }
    
    public static CrComEddDAO getCrComEddDAO() {
    	return (CrComEddDAO)ApplicationContextUtils.getBean(CrComEddDAO.class);
    }
    
    public static CrComEe01bhDAO getCrComEe01bhDAO() {
    	return (CrComEe01bhDAO)ApplicationContextUtils.getBean(CrComEe01bhDAO.class);
    }
    
    public static CrComEeaDAO getCrComEeaDAO() {
    	return (CrComEeaDAO)ApplicationContextUtils.getBean(CrComEeaDAO.class);
    }
    
    public static CrComEf05bhDAO getCrComEf05bhDAO() {
    	return (CrComEf05bhDAO)ApplicationContextUtils.getBean(CrComEf05bhDAO.class);
    }
    
    public static CrComEfaDAO getCrComEfaDAO() {
    	return (CrComEfaDAO)ApplicationContextUtils.getBean(CrComEfaDAO.class);
    }
    
    public static CrComEfbDAO getCrComEfbDAO() {
    	return (CrComEfbDAO)ApplicationContextUtils.getBean(CrComEfbDAO.class);
    }
    
    public static CrComEfcDAO getCrComEfcDAO() {
    	return (CrComEfcDAO)ApplicationContextUtils.getBean(CrComEfcDAO.class);
    }
    
    public static CrComEfdDAO getCrComEfdDAO() {
    	return (CrComEfdDAO)ApplicationContextUtils.getBean(CrComEfdDAO.class);
    }
    
    public static CrComEfeDAO getCrComEfeDAO() {
    	return (CrComEfeDAO)ApplicationContextUtils.getBean(CrComEfeDAO.class);
    }
    
    public static CrComEffDAO getCrComEffDAO() {
    	return (CrComEffDAO)ApplicationContextUtils.getBean(CrComEffDAO.class);
    }
    
    public static CrComEfgDAO getCrComEfgDAO() {
    	return (CrComEfgDAO)ApplicationContextUtils.getBean(CrComEfgDAO.class);
    }
    
    public static CrComEgaDAO getCrComEgaDAO() {
    	return (CrComEgaDAO)ApplicationContextUtils.getBean(CrComEgaDAO.class);
    }
    
    public static CrComEhaDAO getCrComEhaDAO() {
    	return (CrComEhaDAO)ApplicationContextUtils.getBean(CrComEhaDAO.class);
    }
    
    public static CrComEiaDAO getCrComEiaDAO() {
    	return (CrComEiaDAO)ApplicationContextUtils.getBean(CrComEiaDAO.class);
    }
    
    
    
    public static CrEuserCertDAO getCrEuserCertDAO() {
    	return (CrEuserCertDAO)ApplicationContextUtils.getBean(CrEuserCertDAO.class);
    }
    
    public static CrPbocD101DAO getCrPbocD101DAO() {
    	return (CrPbocD101DAO)ApplicationContextUtils.getBean(CrPbocD101DAO.class);
    }
    
    public static CrPbocD102DAO getCrPbocD102DAO() {
    	return (CrPbocD102DAO)ApplicationContextUtils.getBean(CrPbocD102DAO.class);
    }
    
    public static CrPbocD201DAO getCrPbocD201DAO() {
    	return (CrPbocD201DAO)ApplicationContextUtils.getBean(CrPbocD201DAO.class);
    }
    
    public static CrPbocD202DAO getCrPbocD202DAO() {
    	return (CrPbocD202DAO)ApplicationContextUtils.getBean(CrPbocD202DAO.class);
    }
    
    public static CrPbocD501DAO getCrPbocD501DAO() {
    	return (CrPbocD501DAO)ApplicationContextUtils.getBean(CrPbocD501DAO.class);
    }
    
    public static CrPbocD502DAO getCrPbocD502DAO() {
    	return (CrPbocD502DAO)ApplicationContextUtils.getBean(CrPbocD502DAO.class);
    }
    
    public static CrPbocD503DAO getCrPbocD503DAO() {
    	return (CrPbocD503DAO)ApplicationContextUtils.getBean(CrPbocD503DAO.class);
    }
    
    public static CrPbocD504DAO getCrPbocD504DAO() {
    	return (CrPbocD504DAO)ApplicationContextUtils.getBean(CrPbocD504DAO.class);
    }
    public static CustPbocEntQueryDAO getCustPbocEntQueryDAO() {
    	return (CustPbocEntQueryDAO)ApplicationContextUtils.getBean(CustPbocEntQueryDAO.class);
    }
    
    public static CollateralEntQueryDao getCollateralEntQueryDAO(){
    	return (CollateralEntQueryDao)ApplicationContextUtils.getBean(CollateralEntQueryDao.class);
    }
    
    public static CustPbocPerQueryDAO getCustPbocPerQueryDAO() {
    	return (CustPbocPerQueryDAO)ApplicationContextUtils.getBean(CustPbocPerQueryDAO.class);
    }
   
    public static CrPerPa01chDAO getCrPerPa01chDAO() {
    	return (CrPerPa01chDAO)ApplicationContextUtils.getBean(CrPerPa01chDAO.class);
    }
    
    public static CrPerPahDAO getCrPerPahDAO() {
    	return (CrPerPahDAO)ApplicationContextUtils.getBean(CrPerPahDAO.class);
    }
    
    public static CrPerPapDAO getCrPerPapDAO() {
    	return (CrPerPapDAO)ApplicationContextUtils.getBean(CrPerPapDAO.class);
    }
    
    public static CrPerPb01bhDAO getCrPerPb01bhDAO() {
    	return (CrPerPb01bhDAO)ApplicationContextUtils.getBean(CrPerPb01bhDAO.class);
    }
    
    public static CrPerPbsDAO getCrPerPbsDAO() {
    	return (CrPerPbsDAO)ApplicationContextUtils.getBean(CrPerPbsDAO.class);
    }
    
    public static CrPerPc02ahDAO getCrPerPc02ahDAO() {
    	return (CrPerPc02ahDAO)ApplicationContextUtils.getBean(CrPerPc02ahDAO.class);
    }
    
    public static CrPerPc02bhDAO getCrPerPc02bhDAO() {
    	return (CrPerPc02bhDAO)ApplicationContextUtils.getBean(CrPerPc02bhDAO.class);
    }
    
    public static CrPerPc02dhDAO getCrPerPc02dhDAO() {
    	return (CrPerPc02dhDAO)ApplicationContextUtils.getBean(CrPerPc02dhDAO.class);
    }
    
    public static CrPerPc02khDAO getCrPerPc02khDAO() {
    	return (CrPerPc02khDAO)ApplicationContextUtils.getBean(CrPerPc02khDAO.class);
    }
    
    public static CrPerPc030hDAO getCrPerPc030hDAO() {
    	return (CrPerPc030hDAO)ApplicationContextUtils.getBean(CrPerPc030hDAO.class);
    }
    
    public static CrPerPc040hDAO getCrPerPc040hDAO() {
    	return (CrPerPc040hDAO)ApplicationContextUtils.getBean(CrPerPc040hDAO.class);
    }
    
    public static CrPerPcaDAO getCrPerPcaDAO() {
    	return (CrPerPcaDAO)ApplicationContextUtils.getBean(CrPerPcaDAO.class);
    }
    
    public static CrPerPceDAO getCrPerPceDAO() {
    	return (CrPerPceDAO)ApplicationContextUtils.getBean(CrPerPceDAO.class);
    }
    
    public static CrPerPcjDAO getCrPerPcjDAO() {
    	return (CrPerPcjDAO)ApplicationContextUtils.getBean(CrPerPcjDAO.class);
    }
    
    public static CrPerPcoDAO getCrPerPcoDAO() {
    	return (CrPerPcoDAO)ApplicationContextUtils.getBean(CrPerPcoDAO.class);
    }
    
    public static CrPerPcrDAO getCrPerPcrDAO() {
    	return (CrPerPcrDAO)ApplicationContextUtils.getBean(CrPerPcrDAO.class);
    }
    
    public static CrPerPd01dhDAO getCrPerPd01dhDAO() {
    	return (CrPerPd01dhDAO)ApplicationContextUtils.getBean(CrPerPd01dhDAO.class);
    }
    
    public static CrPerPd01ehDAO getCrPerPd01ehDAO() {
    	return (CrPerPd01ehDAO)ApplicationContextUtils.getBean(CrPerPd01ehDAO.class);
    }
    
    public static CrPerPd01fhDAO getCrPerPd01fhDAO() {
    	return (CrPerPd01fhDAO)ApplicationContextUtils.getBean(CrPerPd01fhDAO.class);
    }
    
    public static CrPerPd01ghDAO getCrPerPd01ghDAO() {
    	return (CrPerPd01ghDAO)ApplicationContextUtils.getBean(CrPerPd01ghDAO.class);
    }
    
    public static CrPerPd01hhDAO getCrPerPd01hhDAO() {
    	return (CrPerPd01hhDAO)ApplicationContextUtils.getBean(CrPerPd01hhDAO.class);
    }
    
    public static CrPerPd01zhDAO getCrPerPd01zhDAO() {
    	return (CrPerPd01zhDAO)ApplicationContextUtils.getBean(CrPerPd01zhDAO.class);
    }
    
    public static CrPerPd02zhDAO getCrPerPd02zhDAO() {
    	return (CrPerPd02zhDAO)ApplicationContextUtils.getBean(CrPerPd02zhDAO.class);
    }
    
    public static CrPerPd03zhDAO getCrPerPd03zhDAO() {
    	return (CrPerPd03zhDAO)ApplicationContextUtils.getBean(CrPerPd03zhDAO.class);
    }
    
    
    public static CrPerPdaDAO getCrPerPdaDAO() {
    	return (CrPerPdaDAO)ApplicationContextUtils.getBean(CrPerPdaDAO.class);
    }
    
    public static CrPerPe01zhDAO getCrPerPe01zhDAO() {
    	return (CrPerPe01zhDAO)ApplicationContextUtils.getBean(CrPerPe01zhDAO.class);
    }
    

    public static CrPerPf01zhDAO getCrPerPf01zhDAO() {
    	return (CrPerPf01zhDAO)ApplicationContextUtils.getBean(CrPerPf01zhDAO.class);
    }
    
    public static CrPerPf02zhDAO getCrPerPf02zhDAO() {
    	return (CrPerPf02zhDAO)ApplicationContextUtils.getBean(CrPerPf02zhDAO.class);
    }
    
    public static CrPerPf03zhDAO getCrPerPf03zhDAO() {
    	return (CrPerPf03zhDAO)ApplicationContextUtils.getBean(CrPerPf03zhDAO.class);
    }
    
    public static CrPerPf04zhDAO getCrPerPf04zhDAO() {
    	return (CrPerPf04zhDAO)ApplicationContextUtils.getBean(CrPerPf04zhDAO.class);
    }
    
    public static CrPerPf05zhDAO getCrPerPf05zhDAO() {
    	return (CrPerPf05zhDAO)ApplicationContextUtils.getBean(CrPerPf05zhDAO.class);
    }
    
    public static CrPerPf06zhDAO getCrPerPf06zhDAO() {
    	return (CrPerPf06zhDAO)ApplicationContextUtils.getBean(CrPerPf06zhDAO.class);
    }
    
    public static CrPerPf07zhDAO getCrPerPf07zhDAO() {
    	return (CrPerPf07zhDAO)ApplicationContextUtils.getBean(CrPerPf07zhDAO.class);
    }
    
    public static CrPerPf08zhDAO getCrPerPf08zhDAO() {
    	return (CrPerPf08zhDAO)ApplicationContextUtils.getBean(CrPerPf08zhDAO.class);
    }
    
    public static CrPerPg010hDAO getCrPerPg010hDAO() {
    	return (CrPerPg010hDAO)ApplicationContextUtils.getBean(CrPerPg010hDAO.class);
    }
    
    public static CrPerPhfDAO getCrPerPhfDAO() {
    	return (CrPerPhfDAO)ApplicationContextUtils.getBean(CrPerPhfDAO.class);
    }
    
    public static CrPerPimDAO getCrPerPimDAO() {
    	return (CrPerPimDAO)ApplicationContextUtils.getBean(CrPerPimDAO.class);
    }
    
    public static CrPerPmmDAO getCrPerPmmDAO() {
    	return (CrPerPmmDAO)ApplicationContextUtils.getBean(CrPerPmmDAO.class);
    }
    
    public static CrPerPndDAO getCrPerPndDAO() {
    	return (CrPerPndDAO)ApplicationContextUtils.getBean(CrPerPndDAO.class);
    }
    
    public static CrPerPnoDAO getCrPerPnoDAO() {
    	return (CrPerPnoDAO)ApplicationContextUtils.getBean(CrPerPnoDAO.class);
    }
    
    public static CrPerPomDAO getCrPerPomDAO() {
    	return (CrPerPomDAO)ApplicationContextUtils.getBean(CrPerPomDAO.class);
    }
    
    public static CrPerPoqDAO getCrPerPoqDAO() {
    	return (CrPerPoqDAO)ApplicationContextUtils.getBean(CrPerPoqDAO.class);
    }
    
    public static CrPerPosDAO getCrPerPosDAO() {
    	return (CrPerPosDAO)ApplicationContextUtils.getBean(CrPerPosDAO.class);
    }
    
    public static CrPerPotDAO getCrPerPotDAO() {
    	return (CrPerPotDAO)ApplicationContextUtils.getBean(CrPerPotDAO.class);
    }
    
    public static CrPerPpoDAO getCrPerPpoDAO() {
    	return (CrPerPpoDAO)ApplicationContextUtils.getBean(CrPerPpoDAO.class);
    }
    
    public static CrPerPpqDAO getCrPerPpqDAO() {
    	return (CrPerPpqDAO)ApplicationContextUtils.getBean(CrPerPpqDAO.class);
    }
    
    public static CrPerPqoDAO getCrPerPqoDAO() {
    	return (CrPerPqoDAO)ApplicationContextUtils.getBean(CrPerPqoDAO.class);
    }
    
    public static CrPerPrhDAO getCrPerPrhDAO() {
    	return (CrPerPrhDAO)ApplicationContextUtils.getBean(CrPerPrhDAO.class);
    }
    
    public static CrPerPrmDAO getCrPerPrmDAO() {
    	return (CrPerPrmDAO)ApplicationContextUtils.getBean(CrPerPrmDAO.class);
    }
    
    public static CrPerPsmDAO getCrPerPsmDAO() {
    	return (CrPerPsmDAO)ApplicationContextUtils.getBean(CrPerPsmDAO.class);
    }
    
    public static CrPbocD503DAO getCrPbocD503Dao() {
    	return (CrPbocD503DAO)ApplicationContextUtils.getBean(CrPbocD503DAO.class);
    }
   
    public static CrPbocL102DAO getCrPbocL102DAO() {
    	return (CrPbocL102DAO)ApplicationContextUtils.getBean(CrPbocL102DAO.class);
    }
    
    public static SysParamsDAO getSysParamsDAO() {
    	return (SysParamsDAO)ApplicationContextUtils.getBean(SysParamsDAO.class);
    }

    public static CollateralEbaDao getCollateralEbaDao() {
    	return (CollateralEbaDao)ApplicationContextUtils.getBean(CollateralEbaDao.class);
    }
    
    public static CollateralEb01bhDao getCollateralEb01bhDao() {
    	return (CollateralEb01bhDao)ApplicationContextUtils.getBean(CollateralEb01bhDao.class);
    }
    
    public static CollateralEb01cDao getCollateralEb01cDao() {
    	return (CollateralEb01cDao)ApplicationContextUtils.getBean(CollateralEb01cDao.class);
    }
    
    public static CollateralEcaDao getCollateralEcaDao() {
    	return (CollateralEcaDao)ApplicationContextUtils.getBean(CollateralEcaDao.class);
    }
    
    public static CollateralEc01bhDao getCollateralEc01bhDao() {
    	return (CollateralEc01bhDao)ApplicationContextUtils.getBean(CollateralEc01bhDao.class);
    }
    
    public static CollateralEc01cDao getCollateralEc01cDao() {
    	return (CollateralEc01cDao)ApplicationContextUtils.getBean(CollateralEc01cDao.class);
    }
    
    public static CollateralEdaDao getCollateralEdaDao() {
    	return (CollateralEdaDao)ApplicationContextUtils.getBean(CollateralEdaDao.class);
    }
    public static CollateralEd01bhDao getCollateralEd01bhDao() {
    	return (CollateralEd01bhDao)ApplicationContextUtils.getBean(CollateralEd01bhDao.class);
    } 
    
    public static CollateralEd01chDao getCollateralEd01chDao() {
    	return (CollateralEd01chDao)ApplicationContextUtils.getBean(CollateralEd01chDao.class);
    } 
    
    public static CrComEd06DAO getCrComEd06Dao() {
		return (CrComEd06DAO)ApplicationContextUtils.getBean(CrComEd06DAO.class);
    } 
    
    public static FileSubmitDao fileSubmitDao() {
  		return (FileSubmitDao)ApplicationContextUtils.getBean(FileSubmitDao.class);
    }
}
