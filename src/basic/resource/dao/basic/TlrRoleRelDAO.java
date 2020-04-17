/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package resource.dao.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.TlrRoleRel;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class TlrRoleRelDAO extends HibernateDaoSupport {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TlrRoleRelDAO.class);

    public TlrRoleRelDAO() {
        super();
    }

    /**
     * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
     *
     * @param id
     * @return TlrInfo
     * @throws CommonException
     */
    public TlrRoleRel query(String id) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("query(String) - start"); //$NON-NLS-1$
        }

        try {
            TlrRoleRel returnTlrRoleRelation = (TlrRoleRel) this.getHibernateTemplate().load(TlrRoleRel.class, id);
            if (logger.isDebugEnabled()) {
                logger.info("query(String) - end"); //$NON-NLS-1$
            }
            return returnTlrRoleRelation;
        } catch (Exception e) {
            logger.error("query(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("query(String) - end"); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @return 包含TlrInfo对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String) - start"); //$NON-NLS-1$
        }

        try {
            List list = this.getHibernateTemplate().find("from TlrRoleRel po where " + whereString);
            if (logger.isDebugEnabled()) {
                logger.info("queryByCondition(String) - end"); //$NON-NLS-1$
            }
            return list;
        } catch (Exception e) {
            logger.error("queryByCondition(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String) - end"); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @param objArray
     * @param typeArray
     * @return 包含TlrRoleRelation对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString, Object[] objArray, Type[] typeArray) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String, Object[], Type[]) - start"); //$NON-NLS-1$
        }

        try {
            List list = this.getHibernateTemplate().find("from TlrRoleRel po where " + whereString, objArray);

            if (logger.isDebugEnabled()) {
                logger.info("queryByCondition(String, Object[], Type[]) - end"); //$NON-NLS-1$
            }
            return list;
        } catch (Exception e) {
            logger.error("queryByCondition(String, Object[], Type[])", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String, Object[], Type[]) - end"); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 插入记录
     *
     * @param po
     * @throws CommonException
     */
    public void insert(TlrRoleRel po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("insert(TlrRoleRel) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().save(po);
        } catch (Exception e) {
            logger.error("insert(TlrRoleRel)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("insert(TlrRoleRel) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 删除记录
     *
     * @param po
     * @throws CommonException
     */
    public void delete(TlrRoleRel po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("delete(TlrRoleRel) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().delete(po);
        } catch (Exception e) {
            logger.error("delete(TlrRoleRel)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_DELETE, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("delete(TlrRoleRel) - end"); //$NON-NLS-1$
        }
    }

    /**
     * add by NT 2007-09-29 根据输入的条件字串查询对象集合
     *
     * @param String
     *            whereString 条件集合 例如 "po.name = 'user1' and po.level = '1' or
     *            ...."
     * @param int
     *            startPage 展现层的开始页数
     * @param int
     *            maxRows 展现层的每页记录数 -1 :全部; 0 :默认值; 其他:实际值
     * @return List 对象集合
     * @throws DAOException
     */
    public List queryByCondition(String whereString, int startPage, int maxRows) throws CommonException {
        List returnValue = new ArrayList();
        startPage = startPage >= 1 ? startPage : 1;
        int firstResult = (startPage - 1) * (maxRows > 0 ? maxRows : SystemConstant.MAX_ROWS);
        int rows = maxRows;
        rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);

        try {

            String hql = "from TlrRoleRel as po where ";
            hql = hql + whereString;

            Query query = this.getSession().createQuery(hql);
            query.setFirstResult(firstResult);
            if (rows != -1) {
                query.setMaxResults(rows + 1);
            }
            returnValue = query.list();

        } catch (HibernateException e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
        }
        return returnValue;
    }

    // del by zhaozhiguo
    // /**
    // * 根据输入的组合条件查询对象集合
    // *
    // * @param Set conditionSet 条件集合
    // * 例如
    // Set set = new HashSet();
    // QueryCondition qc;
    // qc = new QueryCondition("oprId", "=", "'1'");
    // set.add(qc);
    // qc = new QueryCondition("bizId", "=", "'2'");
    // set.add(qc);
    // List list = bizLogDAO.queryByCondition(set, 1, 0);
    //
    // * @param int startPage 展现层的开始页数
    // * @param int maxRows 展现层的每页记录数
    // -1 :全部;
    // 0 :默认值;
    // 其他:实际值
    // * @return List 对象集合
    // * @throws DAOException
    // */
    // public List queryByCondition(Set conditionSet, int startPage, int
    // maxRows)
    // throws CommonException {
    // List returnValue = new ArrayList();
    // startPage = startPage >= 1 ? startPage : 1;
    // int firstResult = (startPage - 1) * (maxRows > 0 ? maxRows :
    // SystemConstant.MAX_ROWS);
    // int rows = maxRows;
    // rows = (rows == 0 ? SystemConstant.MAX_ROWS : rows);
    //
    // try {
    //
    // String hql = "from TlrRoleRel as po ";
    // if (conditionSet.size() > 0) {
    // hql = hql + "where 0=0 ";
    // Iterator it = conditionSet.iterator();
    // while (it.hasNext()) {
    // QueryCondition qc = (QueryCondition) it.next();
    // hql =
    // hql
    // + "and po."
    // + qc.getProperty()
    // + " "
    // + qc.getCondition()
    // + " "
    // + qc.getValue()
    // + " ";
    // }
    // }
    //
    // Query query = this.getSession().createQuery(hql);
    // query.setFirstResult(firstResult);
    // if (rows != -1) {
    // query.setMaxResults(rows + 1);
    // }
    // returnValue = query.list();
    //
    // } catch (HibernateException e) {
    // ExceptionUtil.throwCommonException(e.getMessage(),
    // ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
    // }
    // return returnValue;
    // }
}
