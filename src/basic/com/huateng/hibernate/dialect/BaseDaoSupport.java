package com.huateng.hibernate.dialect;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;

/**
 * @author YiSiliang
 * @date 2018/12/24 16:15
 */
public class BaseDaoSupport extends HibernateDaoSupport {
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
