/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package resource.dao.basic;

import java.util.List;

import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.BizFuncInfo;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class BizFuncInfoDAO extends HibernateDaoSupport {

    public BizFuncInfoDAO() {
        super();
    }

    /**
     * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
     *
     * @param id
     * @return BizFuncInfo
     * @throws CommonException
     */
    public BizFuncInfo query(String id) throws CommonException {
        try {
            return (BizFuncInfo) this.getHibernateTemplate().load(BizFuncInfo.class, id);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_BIZ_LOG_SELECT, e);
        }
        return null;
    }

    /**
     * 根据业务主键查询，如果没有找到记录，则返回null
     *
     * @param key1
     * @param key2
     * @return BizFuncInfo
     * @throws CommonException
     *             public BizFuncInfo query(String key1, String key2) throws
     *             CommonException { List list = new ArrayList(); try {
     *             StringBuffer whereString = new StringBuffer();
     *             whereString.append("po.key1 = '").append(key1).append( "' and
     *             po.key2 = '").append(key2).append("'"); list =
     *             queryByCondition(whereString.toString()); } catch (Exception
     *             e) { ExceptionUtil.throwCommonException(e.getMessage(),
     *             ErrorCode.ERROR_CODE_BIZ_LOG_SELECT, e); }
     * 
     *             if (list.size() != 1) { return null; } else { return
     *             (BizFuncInfo) list.get(0); } }
     */

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @param objArray
     * @param typeArray
     * @return 包含BizFuncInfo对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString, Object[] objArray, Type[] typeArray) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find("from BizFuncInfo po where " + whereString, objArray);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_BIZ_LOG_SELECT, e);
        }
        return null;
    }

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @return 包含BizFuncInfo对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find("from BizFuncInfo po where " + whereString);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_BIZ_LOG_SELECT, e);
        }
        return null;
    }

    /**
     * 更新记录
     *
     * @param po
     * @throws CommonException
     */
    public void update(BizFuncInfo po) throws CommonException {
        try {
            this.getHibernateTemplate().update(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_BIZ_LOG_UPDATE, e);
        }
    }

    /**
     * 插入记录
     *
     * @param po
     * @throws CommonException
     */
    public void insert(BizFuncInfo po) throws CommonException {
        try {
            this.getHibernateTemplate().save(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_BIZ_LOG_INSERT, e);
        }
    }

    /**
     * 删除记录
     *
     * @param po
     * @throws CommonException
     */
    public void delete(BizFuncInfo po) throws CommonException {
        try {
            this.getHibernateTemplate().delete(po);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_BIZ_LOG_DELETE, e);
        }
    }

    /**
     * 根据Hibernate ID删除记录
     *
     * @param id
     * @throws CommonException
     */
    public void delete(String id) throws CommonException {
        try {
            this.getHibernateTemplate().delete(query(id));
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_BIZ_LOG_DELETE, e);
        }
    }
}
