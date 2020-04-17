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

import resource.bean.basic.CurcdMap;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class CurcdMapDAO extends HibernateDaoSupport {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(CurcdMapDAO.class);

    public CurcdMapDAO() {
        super();
    }

    /**
     * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
     *
     * @param id
     * @return TlrInfo
     * @throws CommonException
     */
    public CurcdMap query(String curcd) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("query(String) - start"); //$NON-NLS-1$
        }

        try {
            CurcdMap returnCurcdMap = (CurcdMap) this.getHibernateTemplate().get(CurcdMap.class, curcd);
            if (logger.isDebugEnabled()) {
                logger.info("query(String) - end"); //$NON-NLS-1$
            }
            return returnCurcdMap;
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
            List list = this.getHibernateTemplate().find("from CurcdMap po where " + whereString);
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
            List list = this.getHibernateTemplate().find("from CurcdMap po where " + whereString, objArray);

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
    public void insert(CurcdMap po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("insert(CurcdMap) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().save(po);
        } catch (Exception e) {
            logger.error("insert(CurcdMap)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("insert(CurcdMap) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 删除记录
     *
     * @param po
     * @throws CommonException
     */
    public void delete(CurcdMap po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("delete(CurcdMap) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().delete(po);
        } catch (Exception e) {
            logger.error("delete(CurcdMap)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_DELETE, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("delete(CurcdMap) - end"); //$NON-NLS-1$
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

            String hql = "from CurcdMap as po where ";
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
}
