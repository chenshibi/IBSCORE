/**
 *
 */
package resource.dao.basic;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;

/**
 * Title: PfSysParamDAO Description: Copyright: Copyright (c) 2008 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2008-4-15
 */
public class SysParamsDAO extends HibernateDaoSupport {

    /**
     * 根据Hibernate ID查询记录，如果没有找到记录，则抛出异常
     *
     * @param id
     * @return PfSysParamDef
     * @throws CommonException
     */
    public SysParams query(java.lang.String magicId, java.lang.String paramId) throws CommonException {
        return findById(new SysParamsPK(magicId, paramId));
    }
    public SysParams findById(SysParamsPK pk) throws CommonException {
        try {
            return (SysParams) this.getHibernateTemplate().get(SysParams.class, pk);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }
        return null;
    }
    
    public List findByProperty(String propertyName, Object value) {  
        try {
            String queryString = "from SysParams as model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * @return
     * @throws CommonException
     */
    public List loadAll() throws CommonException {
        try {
            return (List) this.getHibernateTemplate().loadAll(SysParams.class);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }
        return null;
    }
    /**
     * 更新记录
     *
     * @param po
     * @throws CommonException
     */
    public void saveOrUpdate(SysParams po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("insert(SysParams) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().saveOrUpdate(po);
        } catch (Exception e) {
            logger.error("insert(SysParams)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("insert(SysParams) - end"); //$NON-NLS-1$
        }
    }

}
