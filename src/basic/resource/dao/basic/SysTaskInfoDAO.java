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

import org.apache.log4j.Logger;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.SysTaskInfo;

/**
 * @author valley
 * @date 2005-06-01
 * @desc 数据库访问类
 */
public class SysTaskInfoDAO extends HibernateDaoSupport {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(SysTaskInfoDAO.class);

    public SysTaskInfoDAO() {
        super();
    }

    /**
     * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
     *
     * @param id
     * @return SysTaskInfo
     * @throws CommonException
     */
    public SysTaskInfo query(String id) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("query(String) - start"); //$NON-NLS-1$
        }

        try {
            SysTaskInfo returnTlrInfo = (SysTaskInfo) this.getHibernateTemplate().get(SysTaskInfo.class, id);
            if (logger.isDebugEnabled()) {
                logger.info("query(String) - end"); //$NON-NLS-1$
            }
            return returnTlrInfo;
        } catch (Exception e) {
            logger.error("query(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("query(String) - end"); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 根据Hibernate ID查询记录，如果没有找到记录，返回null,不抛出异常
     *
     * @param id
     * @return SysTaskInfo
     * @throws CommonException
     * @author yjw add
     */
    public SysTaskInfo queryById(String id) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("query(String) - start"); //$NON-NLS-1$
        }

        try {
            SysTaskInfo returnTlrInfo = (SysTaskInfo) this.getHibernateTemplate().get(SysTaskInfo.class, id);
            if (logger.isDebugEnabled()) {
                logger.info("query(String) - end"); //$NON-NLS-1$
            }
            return returnTlrInfo;
        } catch (Exception e) {
            logger.error("query(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("query(String) - end"); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 根据业务主键查询，如果没有找到记录，则返回null
     *
     * @param key1
     * @param key2
     * @return SysTaskInfo
     * @throws CommonException
     *             public SysTaskInfo query(String key1, String key2) throws
     *             CommonException { List list = new ArrayList(); try {
     *             StringBuffer whereString = new StringBuffer();
     *             whereString.append("po.key1 = '").append(key1).append( "' and
     *             po.key2 = '").append(key2).append("'"); list =
     *             queryByCondition(whereString.toString()); } catch (Exception
     *             e) { ExceptionUtil.throwCommonException(e.getMessage(),
     *             ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e); }
     *
     *             if (list.size() != 1) { return null; } else { return
     *             (SysTaskInfo) list.get(0); } }
     */

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @param objArray
     * @param typeArray
     * @return ??SysTaskInfo?????List
     * @throws CommonException
     */
    public List queryByCondition(String whereString, Object[] objArray, Type[] typeArray) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String, Object[], Type[]) - start"); //$NON-NLS-1$
        }

        try {
            List list = this.getHibernateTemplate().find("from SysTaskInfo po where " + whereString, objArray);

            if (logger.isDebugEnabled()) {
                logger.info("queryByCondition(String, Object[], Type[]) - end"); //$NON-NLS-1$
            }
            return list;
        } catch (Exception e) {
            logger.error("queryByCondition(String, Object[], Type[])", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String, Object[], Type[]) - end"); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @return ??SysTaskInfo?????List
     * @throws CommonException
     */
    public List queryByCondition(String whereString) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String) - start"); //$NON-NLS-1$
        }

        try {
            List list = this.getHibernateTemplate().find("from SysTaskInfo po where " + whereString);

            if (logger.isDebugEnabled()) {
                logger.info("queryByCondition(String) - end"); //$NON-NLS-1$
            }
            return list;
        } catch (Exception e) {
            logger.error("queryByCondition(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String) - end"); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 更新记录
     *
     * @param po
     * @throws CommonException
     */
    public void update(SysTaskInfo po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("update(SysTaskInfo) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().update(po);
        } catch (Exception e) {
            logger.error("update(SysTaskInfo)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("update(SysTaskInfo) - end"); //$NON-NLS-1$
        }
    }

    public int update(String queryString, Object[] values) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("update(SysTaskInfo) - start"); //$NON-NLS-1$
        }
        int updateRow = 0;
        try {

            if (values == null) {
                updateRow = this.getHibernateTemplate().bulkUpdate(queryString);
            } else {
                updateRow = this.getHibernateTemplate().bulkUpdate(queryString, values);
            }
        } catch (Exception e) {
            logger.error("update(String,Object[])", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
        }
        if (logger.isDebugEnabled()) {
            logger.info("update(SysTaskInfo) - end"); //$NON-NLS-1$
        }
        return updateRow;
    }

    /**
     * 插入记录
     *
     * @param po
     * @throws CommonException
     */
    public void insert(SysTaskInfo po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("insert(SysTaskInfo) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().save(po);
        } catch (Exception e) {
            logger.error("insert(SysTaskInfo)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("insert(SysTaskInfo) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 插入或更新记录
     *
     * @param po
     * @throws CommonException
     */
    public void saveOrUpdate(SysTaskInfo po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("update(SysTaskInfo) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().saveOrUpdate(po);
        } catch (Exception e) {
            logger.error("update(SysTaskInfo)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_UPDATE, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("update(SysTaskInfo) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 删除记录
     *
     * @param po
     * @throws CommonException
     */
    public void delete(SysTaskInfo po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("delete(SysTaskInfo) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().delete(po);
        } catch (Exception e) {
            logger.error("delete(SysTaskInfo)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("delete(SysTaskInfo) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 根据Hibernate ID删除记录
     *
     * @param id
     * @throws CommonException
     */
    public void delete(String id) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("delete(String) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().delete(query(id));
        } catch (Exception e) {
            logger.error("delete(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("delete(String) - end"); //$NON-NLS-1$
        }
    }

    public List<SysTaskInfo> queryByProp( String intInsCd, String adtRcdPK, String updTransCd)
            throws CommonException {  if (logger.isDebugEnabled()) {
                logger.info("delete(String) - start"); //$NON-NLS-1$
            }

            try {
                String queryString = "from SysTaskInfo as model where  model.intInsId = ? "
                        + " and model.adtRcdPk = ? and model.updTransCd = ? ";
                return getHibernateTemplate().find(queryString, new String[] { intInsCd, adtRcdPK, updTransCd });
            } catch (Exception e) {
                logger.error("delete(String)", e); //$NON-NLS-1$

                ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
            }

            if (logger.isDebugEnabled()) {
                logger.info("delete(String) - end"); //$NON-NLS-1$
            }
            return null;
        
}

    public List<SysTaskInfo> queryByRoleInfo(String rolename) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("delete(String) - start"); //$NON-NLS-1$
        }

        try {
            String queryString = "from SysTaskInfo as model where model.intInsId = '100299' "
                    + " and model.adtRcdPk = ? and model.updTransCd = '01' ";
            return getHibernateTemplate().find(queryString, new String[] { rolename });
        } catch (Exception e) {
            logger.error("delete(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_DELETE, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("delete(String) - end"); //$NON-NLS-1$
        }
        return null;
    }

}
