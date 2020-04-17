package com.huateng.ebank.business.datadic.service;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

import resource.bean.basic.DataDic;

public class DataDicService {

    public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(hql);
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        HQLDAO hqlDAO = DAOUtils.getHQLDAO();
        return hqlDAO.pageQueryByQL(queryCondition);
    }

    public PageQueryResult list(int pageIndex, int pageSize, String hql, Object[] objs) throws CommonException {
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(hql);
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        queryCondition.setObjArray(objs);
        HQLDAO hqlDAO = DAOUtils.getHQLDAO();
        return hqlDAO.pageQueryByQL(queryCondition);
    }

    public synchronized static DataDicService getInstance() {

        return (DataDicService) ApplicationContextUtils.getBean("DataDicService");
    }

    public DataDic load(Integer id, String datadic) {// datadic只是为了区分，无实际意义
        return DAOUtils.getDataDicDAO().findById(id, datadic);
    }

    /**
     * 查询data_dic表是否存在对应data_type_no,data_no
     * 
     * @param dd
     * @return
     * @throws CommonException
     */
    public boolean queryDataDic(DataDic dd) throws CommonException {
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        String hql = "select count(model) from DataDic model where model.dataTypeNo=" + dd.getDataTypeNo()
                + " and model.dataNo='" + dd.getDataNo() + "'";
        Integer num = rootDao.queryByHqlToCount(hql);
        if (num > 0) {
            return true;
        }
        return false;
    }

}
