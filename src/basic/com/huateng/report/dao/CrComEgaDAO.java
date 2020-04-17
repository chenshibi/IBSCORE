package com.huateng.report.dao;

import java.util.List;

import javax.annotation.Resource;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.huateng.report.pboc.util.DevUtils;

import resource.bean.crms.CrComEfg;
import resource.bean.crms.CrComEga;
@Repository
public class CrComEgaDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEgaDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEga pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEga pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEga pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEga findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEga)this.getHibernateTemplate().get(CrComEga.class, id);
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public boolean isNotBlankOrNull(Object o){
        if(o == null){
            return false;
        }
        if(o instanceof java.lang.String){
            return StringUtils.isNotBlank((String) o);
        }
        else {
            return true;
        }
    }

    public List<CrComEga> findByProperties(CrComEga pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEga as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEg01ai01())){
                queryString.append(" and model.eg01ai01 = ? ");
                binds.add(pojo.getEg01ai01());
            }
            if(isNotBlankOrNull(pojo.getEg01ad01())){
                queryString.append(" and model.eg01ad01 = ? ");
                binds.add(pojo.getEg01ad01());
            }
            if(isNotBlankOrNull(pojo.getEg01ai02())){
                queryString.append(" and model.eg01ai02 = ? ");
                binds.add(pojo.getEg01ai02());
            }
            if(isNotBlankOrNull(pojo.getEg01ar01())){
                queryString.append(" and model.eg01ar01 = ? ");
                binds.add(pojo.getEg01ar01());
            }
            if(isNotBlankOrNull(pojo.getEg01ad02())){
                queryString.append(" and model.eg01ad02 = ? ");
                binds.add(pojo.getEg01ad02());
            }
            if(isNotBlankOrNull(pojo.getEg01ad03())){
                queryString.append(" and model.eg01ad03 = ? ");
                binds.add(pojo.getEg01ad03());
            }
            if(isNotBlankOrNull(pojo.getEg01bj01())){
                queryString.append(" and model.eg01bj01 = ? ");
                binds.add(pojo.getEg01bj01());
            }
            if(isNotBlankOrNull(pojo.getEg01bj02())){
                queryString.append(" and model.eg01bj02 = ? ");
                binds.add(pojo.getEg01bj02());
            }
            if(isNotBlankOrNull(pojo.getEg01bj03())){
                queryString.append(" and model.eg01bj03 = ? ");
                binds.add(pojo.getEg01bj03());
            }
            if(isNotBlankOrNull(pojo.getEg01bj04())){
                queryString.append(" and model.eg01bj04 = ? ");
                binds.add(pojo.getEg01bj04());
            }
            if(isNotBlankOrNull(pojo.getEg01bj05())){
                queryString.append(" and model.eg01bj05 = ? ");
                binds.add(pojo.getEg01bj05());
            }
            if(isNotBlankOrNull(pojo.getEg01bj06())){
                queryString.append(" and model.eg01bj06 = ? ");
                binds.add(pojo.getEg01bj06());
            }
            if(isNotBlankOrNull(pojo.getEg01bj07())){
                queryString.append(" and model.eg01bj07 = ? ");
                binds.add(pojo.getEg01bj07());
            }
            if(isNotBlankOrNull(pojo.getEg01bj08())){
                queryString.append(" and model.eg01bj08 = ? ");
                binds.add(pojo.getEg01bj08());
            }
            if(isNotBlankOrNull(pojo.getEg01bj09())){
                queryString.append(" and model.eg01bj09 = ? ");
                binds.add(pojo.getEg01bj09());
            }
            if(isNotBlankOrNull(pojo.getEg01bj10())){
                queryString.append(" and model.eg01bj10 = ? ");
                binds.add(pojo.getEg01bj10());
            }
            if(isNotBlankOrNull(pojo.getEg01bj11())){
                queryString.append(" and model.eg01bj11 = ? ");
                binds.add(pojo.getEg01bj11());
            }
            if(isNotBlankOrNull(pojo.getEg01bj12())){
                queryString.append(" and model.eg01bj12 = ? ");
                binds.add(pojo.getEg01bj12());
            }
            if(isNotBlankOrNull(pojo.getEg01bj13())){
                queryString.append(" and model.eg01bj13 = ? ");
                binds.add(pojo.getEg01bj13());
            }
            if(isNotBlankOrNull(pojo.getEg01bj14())){
                queryString.append(" and model.eg01bj14 = ? ");
                binds.add(pojo.getEg01bj14());
            }
            if(isNotBlankOrNull(pojo.getEg01bj15())){
                queryString.append(" and model.eg01bj15 = ? ");
                binds.add(pojo.getEg01bj15());
            }
            if(isNotBlankOrNull(pojo.getEg01bj16())){
                queryString.append(" and model.eg01bj16 = ? ");
                binds.add(pojo.getEg01bj16());
            }
            if(isNotBlankOrNull(pojo.getEg01bj17())){
                queryString.append(" and model.eg01bj17 = ? ");
                binds.add(pojo.getEg01bj17());
            }
            if(isNotBlankOrNull(pojo.getEg01bj18())){
                queryString.append(" and model.eg01bj18 = ? ");
                binds.add(pojo.getEg01bj18());
            }
            if(isNotBlankOrNull(pojo.getEg01bj19())){
                queryString.append(" and model.eg01bj19 = ? ");
                binds.add(pojo.getEg01bj19());
            }
            if(isNotBlankOrNull(pojo.getEg01bj20())){
                queryString.append(" and model.eg01bj20 = ? ");
                binds.add(pojo.getEg01bj20());
            }
            if(isNotBlankOrNull(pojo.getEg01bj21())){
                queryString.append(" and model.eg01bj21 = ? ");
                binds.add(pojo.getEg01bj21());
            }
            if(isNotBlankOrNull(pojo.getEg01bj22())){
                queryString.append(" and model.eg01bj22 = ? ");
                binds.add(pojo.getEg01bj22());
            }
            if(isNotBlankOrNull(pojo.getEg01bj23())){
                queryString.append(" and model.eg01bj23 = ? ");
                binds.add(pojo.getEg01bj23());
            }
            if(isNotBlankOrNull(pojo.getEg01bj24())){
                queryString.append(" and model.eg01bj24 = ? ");
                binds.add(pojo.getEg01bj24());
            }
            if(isNotBlankOrNull(pojo.getEg01bj25())){
                queryString.append(" and model.eg01bj25 = ? ");
                binds.add(pojo.getEg01bj25());
            }
            if(isNotBlankOrNull(pojo.getEg01bj26())){
                queryString.append(" and model.eg01bj26 = ? ");
                binds.add(pojo.getEg01bj26());
            }
            if(isNotBlankOrNull(pojo.getEg01bj27())){
                queryString.append(" and model.eg01bj27 = ? ");
                binds.add(pojo.getEg01bj27());
            }
            if(isNotBlankOrNull(pojo.getEg01bj28())){
                queryString.append(" and model.eg01bj28 = ? ");
                binds.add(pojo.getEg01bj28());
            }
            if(isNotBlankOrNull(pojo.getEg01bj29())){
                queryString.append(" and model.eg01bj29 = ? ");
                binds.add(pojo.getEg01bj29());
            }
            if(isNotBlankOrNull(pojo.getEg01bj30())){
                queryString.append(" and model.eg01bj30 = ? ");
                binds.add(pojo.getEg01bj30());
            }
            if(isNotBlankOrNull(pojo.getEg01bj31())){
                queryString.append(" and model.eg01bj31 = ? ");
                binds.add(pojo.getEg01bj31());
            }
            if(isNotBlankOrNull(pojo.getEg01bj32())){
                queryString.append(" and model.eg01bj32 = ? ");
                binds.add(pojo.getEg01bj32());
            }
            if(isNotBlankOrNull(pojo.getEg01bj33())){
                queryString.append(" and model.eg01bj33 = ? ");
                binds.add(pojo.getEg01bj33());
            }
            if(isNotBlankOrNull(pojo.getEg01bj34())){
                queryString.append(" and model.eg01bj34 = ? ");
                binds.add(pojo.getEg01bj34());
            }
            if(isNotBlankOrNull(pojo.getEg01bj35())){
                queryString.append(" and model.eg01bj35 = ? ");
                binds.add(pojo.getEg01bj35());
            }
            if(isNotBlankOrNull(pojo.getEg01bj36())){
                queryString.append(" and model.eg01bj36 = ? ");
                binds.add(pojo.getEg01bj36());
            }
            if(isNotBlankOrNull(pojo.getEg01bj37())){
                queryString.append(" and model.eg01bj37 = ? ");
                binds.add(pojo.getEg01bj37());
            }
            if(isNotBlankOrNull(pojo.getEg01bj38())){
                queryString.append(" and model.eg01bj38 = ? ");
                binds.add(pojo.getEg01bj38());
            }
            if(isNotBlankOrNull(pojo.getEg01bj39())){
                queryString.append(" and model.eg01bj39 = ? ");
                binds.add(pojo.getEg01bj39());
            }
            if(isNotBlankOrNull(pojo.getEg01bj40())){
                queryString.append(" and model.eg01bj40 = ? ");
                binds.add(pojo.getEg01bj40());
            }
            if(isNotBlankOrNull(pojo.getEg01bj41())){
                queryString.append(" and model.eg01bj41 = ? ");
                binds.add(pojo.getEg01bj41());
            }
            if(isNotBlankOrNull(pojo.getEg01bj42())){
                queryString.append(" and model.eg01bj42 = ? ");
                binds.add(pojo.getEg01bj42());
            }
            if(isNotBlankOrNull(pojo.getEg01bj43())){
                queryString.append(" and model.eg01bj43 = ? ");
                binds.add(pojo.getEg01bj43());
            }
            if(isNotBlankOrNull(pojo.getEg01bj44())){
                queryString.append(" and model.eg01bj44 = ? ");
                binds.add(pojo.getEg01bj44());
            }
            if(isNotBlankOrNull(pojo.getEg01bj45())){
                queryString.append(" and model.eg01bj45 = ? ");
                binds.add(pojo.getEg01bj45());
            }
            if(isNotBlankOrNull(pojo.getEg01bj46())){
                queryString.append(" and model.eg01bj46 = ? ");
                binds.add(pojo.getEg01bj46());
            }
            if(isNotBlankOrNull(pojo.getEg01bj47())){
                queryString.append(" and model.eg01bj47 = ? ");
                binds.add(pojo.getEg01bj47());
            }
            if(isNotBlankOrNull(pojo.getEg01bj48())){
                queryString.append(" and model.eg01bj48 = ? ");
                binds.add(pojo.getEg01bj48());
            }
            if(isNotBlankOrNull(pojo.getEg01bj49())){
                queryString.append(" and model.eg01bj49 = ? ");
                binds.add(pojo.getEg01bj49());
            }
            if(isNotBlankOrNull(pojo.getEg01bj50())){
                queryString.append(" and model.eg01bj50 = ? ");
                binds.add(pojo.getEg01bj50());
            }
            if(isNotBlankOrNull(pojo.getEg01bj51())){
                queryString.append(" and model.eg01bj51 = ? ");
                binds.add(pojo.getEg01bj51());
            }
            if(isNotBlankOrNull(pojo.getEg01bj52())){
                queryString.append(" and model.eg01bj52 = ? ");
                binds.add(pojo.getEg01bj52());
            }
            if(isNotBlankOrNull(pojo.getEg01bj53())){
                queryString.append(" and model.eg01bj53 = ? ");
                binds.add(pojo.getEg01bj53());
            }
            if(isNotBlankOrNull(pojo.getEg01bj54())){
                queryString.append(" and model.eg01bj54 = ? ");
                binds.add(pojo.getEg01bj54());
            }
            if(isNotBlankOrNull(pojo.getEg01bj55())){
                queryString.append(" and model.eg01bj55 = ? ");
                binds.add(pojo.getEg01bj55());
            }
            if(isNotBlankOrNull(pojo.getEg01bj56())){
                queryString.append(" and model.eg01bj56 = ? ");
                binds.add(pojo.getEg01bj56());
            }
            if(isNotBlankOrNull(pojo.getEg01bj57())){
                queryString.append(" and model.eg01bj57 = ? ");
                binds.add(pojo.getEg01bj57());
            }
            if(isNotBlankOrNull(pojo.getEg01bj58())){
                queryString.append(" and model.eg01bj58 = ? ");
                binds.add(pojo.getEg01bj58());
            }
            if(isNotBlankOrNull(pojo.getEg01bj59())){
                queryString.append(" and model.eg01bj59 = ? ");
                binds.add(pojo.getEg01bj59());
            }
            if(isNotBlankOrNull(pojo.getEg01bj60())){
                queryString.append(" and model.eg01bj60 = ? ");
                binds.add(pojo.getEg01bj60());
            }
            if(isNotBlankOrNull(pojo.getEg01bj61())){
                queryString.append(" and model.eg01bj61 = ? ");
                binds.add(pojo.getEg01bj61());
            }
            if(isNotBlankOrNull(pojo.getEg01bj62())){
                queryString.append(" and model.eg01bj62 = ? ");
                binds.add(pojo.getEg01bj62());
            }
            if(isNotBlankOrNull(pojo.getEg01bj63())){
                queryString.append(" and model.eg01bj63 = ? ");
                binds.add(pojo.getEg01bj63());
            }
            if(isNotBlankOrNull(pojo.getEg01bj64())){
                queryString.append(" and model.eg01bj64 = ? ");
                binds.add(pojo.getEg01bj64());
            }
            if(isNotBlankOrNull(pojo.getEg01bj65())){
                queryString.append(" and model.eg01bj65 = ? ");
                binds.add(pojo.getEg01bj65());
            }
            if(isNotBlankOrNull(pojo.getEg01bj66())){
                queryString.append(" and model.eg01bj66 = ? ");
                binds.add(pojo.getEg01bj66());
            }
            if(isNotBlankOrNull(pojo.getEg01bj67())){
                queryString.append(" and model.eg01bj67 = ? ");
                binds.add(pojo.getEg01bj67());
            }
            if(isNotBlankOrNull(pojo.getEg01bj68())){
                queryString.append(" and model.eg01bj68 = ? ");
                binds.add(pojo.getEg01bj68());
            }
            if(isNotBlankOrNull(pojo.getEg01bj69())){
                queryString.append(" and model.eg01bj69 = ? ");
                binds.add(pojo.getEg01bj69());
            }
            if(isNotBlankOrNull(pojo.getEg01bj70())){
                queryString.append(" and model.eg01bj70 = ? ");
                binds.add(pojo.getEg01bj70());
            }
            if(isNotBlankOrNull(pojo.getEg01bj71())){
                queryString.append(" and model.eg01bj71 = ? ");
                binds.add(pojo.getEg01bj71());
            }
            if(isNotBlankOrNull(pojo.getEg01bj72())){
                queryString.append(" and model.eg01bj72 = ? ");
                binds.add(pojo.getEg01bj72());
            }
            if(isNotBlankOrNull(pojo.getEg01bj73())){
                queryString.append(" and model.eg01bj73 = ? ");
                binds.add(pojo.getEg01bj73());
            }
            if(isNotBlankOrNull(pojo.getEg01bj74())){
                queryString.append(" and model.eg01bj74 = ? ");
                binds.add(pojo.getEg01bj74());
            }
            if(isNotBlankOrNull(pojo.getEg01bj75())){
                queryString.append(" and model.eg01bj75 = ? ");
                binds.add(pojo.getEg01bj75());
            }
            if(isNotBlankOrNull(pojo.getEg01bj76())){
                queryString.append(" and model.eg01bj76 = ? ");
                binds.add(pojo.getEg01bj76());
            }
            if(isNotBlankOrNull(pojo.getEg01bj77())){
                queryString.append(" and model.eg01bj77 = ? ");
                binds.add(pojo.getEg01bj77());
            }
            if(isNotBlankOrNull(pojo.getEg01bj78())){
                queryString.append(" and model.eg01bj78 = ? ");
                binds.add(pojo.getEg01bj78());
            }
            if(isNotBlankOrNull(pojo.getEg01bj79())){
                queryString.append(" and model.eg01bj79 = ? ");
                binds.add(pojo.getEg01bj79());
            }
            if(isNotBlankOrNull(pojo.getEg01bj80())){
                queryString.append(" and model.eg01bj80 = ? ");
                binds.add(pojo.getEg01bj80());
            }
            if(isNotBlankOrNull(pojo.getEg01bj81())){
                queryString.append(" and model.eg01bj81 = ? ");
                binds.add(pojo.getEg01bj81());
            }
            if(isNotBlankOrNull(pojo.getEg01bj82())){
                queryString.append(" and model.eg01bj82 = ? ");
                binds.add(pojo.getEg01bj82());
            }
            if(isNotBlankOrNull(pojo.getEg01bj83())){
                queryString.append(" and model.eg01bj83 = ? ");
                binds.add(pojo.getEg01bj83());
            }
            if(isNotBlankOrNull(pojo.getEg01bj84())){
                queryString.append(" and model.eg01bj84 = ? ");
                binds.add(pojo.getEg01bj84());
            }
            if(isNotBlankOrNull(pojo.getEg01bj85())){
                queryString.append(" and model.eg01bj85 = ? ");
                binds.add(pojo.getEg01bj85());
            }
            if(isNotBlankOrNull(pojo.getEg01bj86())){
                queryString.append(" and model.eg01bj86 = ? ");
                binds.add(pojo.getEg01bj86());
            }
            if(isNotBlankOrNull(pojo.getEg01bj87())){
                queryString.append(" and model.eg01bj87 = ? ");
                binds.add(pojo.getEg01bj87());
            }
            if(isNotBlankOrNull(pojo.getEg02ai01())){
                queryString.append(" and model.eg02ai01 = ? ");
                binds.add(pojo.getEg02ai01());
            }
            if(isNotBlankOrNull(pojo.getEg02ad01())){
                queryString.append(" and model.eg02ad01 = ? ");
                binds.add(pojo.getEg02ad01());
            }
            if(isNotBlankOrNull(pojo.getEg02ai02())){
                queryString.append(" and model.eg02ai02 = ? ");
                binds.add(pojo.getEg02ai02());
            }
            if(isNotBlankOrNull(pojo.getEg02ar01())){
                queryString.append(" and model.eg02ar01 = ? ");
                binds.add(pojo.getEg02ar01());
            }
            if(isNotBlankOrNull(pojo.getEg02ad02())){
                queryString.append(" and model.eg02ad02 = ? ");
                binds.add(pojo.getEg02ad02());
            }
            if(isNotBlankOrNull(pojo.getEg02ad03())){
                queryString.append(" and model.eg02ad03 = ? ");
                binds.add(pojo.getEg02ad03());
            }
            if(isNotBlankOrNull(pojo.getEg02bj01())){
                queryString.append(" and model.eg02bj01 = ? ");
                binds.add(pojo.getEg02bj01());
            }
            if(isNotBlankOrNull(pojo.getEg02bj02())){
                queryString.append(" and model.eg02bj02 = ? ");
                binds.add(pojo.getEg02bj02());
            }
            if(isNotBlankOrNull(pojo.getEg02bj03())){
                queryString.append(" and model.eg02bj03 = ? ");
                binds.add(pojo.getEg02bj03());
            }
            if(isNotBlankOrNull(pojo.getEg02bj04())){
                queryString.append(" and model.eg02bj04 = ? ");
                binds.add(pojo.getEg02bj04());
            }
            if(isNotBlankOrNull(pojo.getEg02bj05())){
                queryString.append(" and model.eg02bj05 = ? ");
                binds.add(pojo.getEg02bj05());
            }
            if(isNotBlankOrNull(pojo.getEg02bj06())){
                queryString.append(" and model.eg02bj06 = ? ");
                binds.add(pojo.getEg02bj06());
            }
            if(isNotBlankOrNull(pojo.getEg02bj07())){
                queryString.append(" and model.eg02bj07 = ? ");
                binds.add(pojo.getEg02bj07());
            }
            if(isNotBlankOrNull(pojo.getEg02bj08())){
                queryString.append(" and model.eg02bj08 = ? ");
                binds.add(pojo.getEg02bj08());
            }
            if(isNotBlankOrNull(pojo.getEg02bj09())){
                queryString.append(" and model.eg02bj09 = ? ");
                binds.add(pojo.getEg02bj09());
            }
            if(isNotBlankOrNull(pojo.getEg02bj10())){
                queryString.append(" and model.eg02bj10 = ? ");
                binds.add(pojo.getEg02bj10());
            }
            if(isNotBlankOrNull(pojo.getEg02bj11())){
                queryString.append(" and model.eg02bj11 = ? ");
                binds.add(pojo.getEg02bj11());
            }
            if(isNotBlankOrNull(pojo.getEg02bj12())){
                queryString.append(" and model.eg02bj12 = ? ");
                binds.add(pojo.getEg02bj12());
            }
            if(isNotBlankOrNull(pojo.getEg02bj13())){
                queryString.append(" and model.eg02bj13 = ? ");
                binds.add(pojo.getEg02bj13());
            }
            if(isNotBlankOrNull(pojo.getEg02bj14())){
                queryString.append(" and model.eg02bj14 = ? ");
                binds.add(pojo.getEg02bj14());
            }
            if(isNotBlankOrNull(pojo.getEg02bj15())){
                queryString.append(" and model.eg02bj15 = ? ");
                binds.add(pojo.getEg02bj15());
            }
            if(isNotBlankOrNull(pojo.getEg02bj16())){
                queryString.append(" and model.eg02bj16 = ? ");
                binds.add(pojo.getEg02bj16());
            }
            if(isNotBlankOrNull(pojo.getEg02bj17())){
                queryString.append(" and model.eg02bj17 = ? ");
                binds.add(pojo.getEg02bj17());
            }
            if(isNotBlankOrNull(pojo.getEg02bj18())){
                queryString.append(" and model.eg02bj18 = ? ");
                binds.add(pojo.getEg02bj18());
            }
            if(isNotBlankOrNull(pojo.getEg02bj19())){
                queryString.append(" and model.eg02bj19 = ? ");
                binds.add(pojo.getEg02bj19());
            }
            if(isNotBlankOrNull(pojo.getEg02bj20())){
                queryString.append(" and model.eg02bj20 = ? ");
                binds.add(pojo.getEg02bj20());
            }
            if(isNotBlankOrNull(pojo.getEg02bj21())){
                queryString.append(" and model.eg02bj21 = ? ");
                binds.add(pojo.getEg02bj21());
            }
            if(isNotBlankOrNull(pojo.getEg02bj22())){
                queryString.append(" and model.eg02bj22 = ? ");
                binds.add(pojo.getEg02bj22());
            }
            if(isNotBlankOrNull(pojo.getEg02bj23())){
                queryString.append(" and model.eg02bj23 = ? ");
                binds.add(pojo.getEg02bj23());
            }
            if(isNotBlankOrNull(pojo.getEg02bj24())){
                queryString.append(" and model.eg02bj24 = ? ");
                binds.add(pojo.getEg02bj24());
            }
            if(isNotBlankOrNull(pojo.getEg02bj25())){
                queryString.append(" and model.eg02bj25 = ? ");
                binds.add(pojo.getEg02bj25());
            }
            if(isNotBlankOrNull(pojo.getEg02bj26())){
                queryString.append(" and model.eg02bj26 = ? ");
                binds.add(pojo.getEg02bj26());
            }
            if(isNotBlankOrNull(pojo.getEg02bj27())){
                queryString.append(" and model.eg02bj27 = ? ");
                binds.add(pojo.getEg02bj27());
            }
            if(isNotBlankOrNull(pojo.getEg02bj28())){
                queryString.append(" and model.eg02bj28 = ? ");
                binds.add(pojo.getEg02bj28());
            }
            if(isNotBlankOrNull(pojo.getEg02bj29())){
                queryString.append(" and model.eg02bj29 = ? ");
                binds.add(pojo.getEg02bj29());
            }
            if(isNotBlankOrNull(pojo.getEg02bj30())){
                queryString.append(" and model.eg02bj30 = ? ");
                binds.add(pojo.getEg02bj30());
            }
            if(isNotBlankOrNull(pojo.getEg02bj31())){
                queryString.append(" and model.eg02bj31 = ? ");
                binds.add(pojo.getEg02bj31());
            }
            if(isNotBlankOrNull(pojo.getEg02bj32())){
                queryString.append(" and model.eg02bj32 = ? ");
                binds.add(pojo.getEg02bj32());
            }
            if(isNotBlankOrNull(pojo.getEg02bj33())){
                queryString.append(" and model.eg02bj33 = ? ");
                binds.add(pojo.getEg02bj33());
            }
            if(isNotBlankOrNull(pojo.getEg02bj34())){
                queryString.append(" and model.eg02bj34 = ? ");
                binds.add(pojo.getEg02bj34());
            }
            if(isNotBlankOrNull(pojo.getEg02bj35())){
                queryString.append(" and model.eg02bj35 = ? ");
                binds.add(pojo.getEg02bj35());
            }
            if(isNotBlankOrNull(pojo.getEg02bj36())){
                queryString.append(" and model.eg02bj36 = ? ");
                binds.add(pojo.getEg02bj36());
            }
            if(isNotBlankOrNull(pojo.getEg02bj37())){
                queryString.append(" and model.eg02bj37 = ? ");
                binds.add(pojo.getEg02bj37());
            }
            if(isNotBlankOrNull(pojo.getEg02bj38())){
                queryString.append(" and model.eg02bj38 = ? ");
                binds.add(pojo.getEg02bj38());
            }
            if(isNotBlankOrNull(pojo.getEg02bj39())){
                queryString.append(" and model.eg02bj39 = ? ");
                binds.add(pojo.getEg02bj39());
            }
            if(isNotBlankOrNull(pojo.getEg02bj40())){
                queryString.append(" and model.eg02bj40 = ? ");
                binds.add(pojo.getEg02bj40());
            }
            if(isNotBlankOrNull(pojo.getEg02bj41())){
                queryString.append(" and model.eg02bj41 = ? ");
                binds.add(pojo.getEg02bj41());
            }
            if(isNotBlankOrNull(pojo.getEg02bj42())){
                queryString.append(" and model.eg02bj42 = ? ");
                binds.add(pojo.getEg02bj42());
            }
            if(isNotBlankOrNull(pojo.getEg02bj43())){
                queryString.append(" and model.eg02bj43 = ? ");
                binds.add(pojo.getEg02bj43());
            }
            if(isNotBlankOrNull(pojo.getEg02bj44())){
                queryString.append(" and model.eg02bj44 = ? ");
                binds.add(pojo.getEg02bj44());
            }
            if(isNotBlankOrNull(pojo.getEg02bj45())){
                queryString.append(" and model.eg02bj45 = ? ");
                binds.add(pojo.getEg02bj45());
            }
            if(isNotBlankOrNull(pojo.getEg02bj46())){
                queryString.append(" and model.eg02bj46 = ? ");
                binds.add(pojo.getEg02bj46());
            }
            if(isNotBlankOrNull(pojo.getEg02bj47())){
                queryString.append(" and model.eg02bj47 = ? ");
                binds.add(pojo.getEg02bj47());
            }
            if(isNotBlankOrNull(pojo.getEg02bj48())){
                queryString.append(" and model.eg02bj48 = ? ");
                binds.add(pojo.getEg02bj48());
            }
            if(isNotBlankOrNull(pojo.getEg02bj49())){
                queryString.append(" and model.eg02bj49 = ? ");
                binds.add(pojo.getEg02bj49());
            }
            if(isNotBlankOrNull(pojo.getEg02bj50())){
                queryString.append(" and model.eg02bj50 = ? ");
                binds.add(pojo.getEg02bj50());
            }
            if(isNotBlankOrNull(pojo.getEg02bj51())){
                queryString.append(" and model.eg02bj51 = ? ");
                binds.add(pojo.getEg02bj51());
            }
            if(isNotBlankOrNull(pojo.getEg02bj52())){
                queryString.append(" and model.eg02bj52 = ? ");
                binds.add(pojo.getEg02bj52());
            }
            if(isNotBlankOrNull(pojo.getEg02bj53())){
                queryString.append(" and model.eg02bj53 = ? ");
                binds.add(pojo.getEg02bj53());
            }
            if(isNotBlankOrNull(pojo.getEg02bj54())){
                queryString.append(" and model.eg02bj54 = ? ");
                binds.add(pojo.getEg02bj54());
            }
            if(isNotBlankOrNull(pojo.getEg02bj55())){
                queryString.append(" and model.eg02bj55 = ? ");
                binds.add(pojo.getEg02bj55());
            }
            if(isNotBlankOrNull(pojo.getEg02bj56())){
                queryString.append(" and model.eg02bj56 = ? ");
                binds.add(pojo.getEg02bj56());
            }
            if(isNotBlankOrNull(pojo.getEg02bj57())){
                queryString.append(" and model.eg02bj57 = ? ");
                binds.add(pojo.getEg02bj57());
            }
            if(isNotBlankOrNull(pojo.getEg02bj58())){
                queryString.append(" and model.eg02bj58 = ? ");
                binds.add(pojo.getEg02bj58());
            }
            if(isNotBlankOrNull(pojo.getEg02bj59())){
                queryString.append(" and model.eg02bj59 = ? ");
                binds.add(pojo.getEg02bj59());
            }
            if(isNotBlankOrNull(pojo.getEg02bj60())){
                queryString.append(" and model.eg02bj60 = ? ");
                binds.add(pojo.getEg02bj60());
            }
            if(isNotBlankOrNull(pojo.getEg03ai01())){
                queryString.append(" and model.eg03ai01 = ? ");
                binds.add(pojo.getEg03ai01());
            }
            if(isNotBlankOrNull(pojo.getEg03ad01())){
                queryString.append(" and model.eg03ad01 = ? ");
                binds.add(pojo.getEg03ad01());
            }
            if(isNotBlankOrNull(pojo.getEg03ai02())){
                queryString.append(" and model.eg03ai02 = ? ");
                binds.add(pojo.getEg03ai02());
            }
            if(isNotBlankOrNull(pojo.getEg03ar01())){
                queryString.append(" and model.eg03ar01 = ? ");
                binds.add(pojo.getEg03ar01());
            }
            if(isNotBlankOrNull(pojo.getEg03ad02())){
                queryString.append(" and model.eg03ad02 = ? ");
                binds.add(pojo.getEg03ad02());
            }
            if(isNotBlankOrNull(pojo.getEg03ad03())){
                queryString.append(" and model.eg03ad03 = ? ");
                binds.add(pojo.getEg03ad03());
            }
            if(isNotBlankOrNull(pojo.getEg03bj01())){
                queryString.append(" and model.eg03bj01 = ? ");
                binds.add(pojo.getEg03bj01());
            }
            if(isNotBlankOrNull(pojo.getEg03bj02())){
                queryString.append(" and model.eg03bj02 = ? ");
                binds.add(pojo.getEg03bj02());
            }
            if(isNotBlankOrNull(pojo.getEg03bj03())){
                queryString.append(" and model.eg03bj03 = ? ");
                binds.add(pojo.getEg03bj03());
            }
            if(isNotBlankOrNull(pojo.getEg03bj04())){
                queryString.append(" and model.eg03bj04 = ? ");
                binds.add(pojo.getEg03bj04());
            }
            if(isNotBlankOrNull(pojo.getEg03bj05())){
                queryString.append(" and model.eg03bj05 = ? ");
                binds.add(pojo.getEg03bj05());
            }
            if(isNotBlankOrNull(pojo.getEg03bj06())){
                queryString.append(" and model.eg03bj06 = ? ");
                binds.add(pojo.getEg03bj06());
            }
            if(isNotBlankOrNull(pojo.getEg03bj07())){
                queryString.append(" and model.eg03bj07 = ? ");
                binds.add(pojo.getEg03bj07());
            }
            if(isNotBlankOrNull(pojo.getEg03bj08())){
                queryString.append(" and model.eg03bj08 = ? ");
                binds.add(pojo.getEg03bj08());
            }
            if(isNotBlankOrNull(pojo.getEg03bj09())){
                queryString.append(" and model.eg03bj09 = ? ");
                binds.add(pojo.getEg03bj09());
            }
            if(isNotBlankOrNull(pojo.getEg03bj10())){
                queryString.append(" and model.eg03bj10 = ? ");
                binds.add(pojo.getEg03bj10());
            }
            if(isNotBlankOrNull(pojo.getEg03bj11())){
                queryString.append(" and model.eg03bj11 = ? ");
                binds.add(pojo.getEg03bj11());
            }
            if(isNotBlankOrNull(pojo.getEg03bj12())){
                queryString.append(" and model.eg03bj12 = ? ");
                binds.add(pojo.getEg03bj12());
            }
            if(isNotBlankOrNull(pojo.getEg03bj13())){
                queryString.append(" and model.eg03bj13 = ? ");
                binds.add(pojo.getEg03bj13());
            }
            if(isNotBlankOrNull(pojo.getEg03bj14())){
                queryString.append(" and model.eg03bj14 = ? ");
                binds.add(pojo.getEg03bj14());
            }
            if(isNotBlankOrNull(pojo.getEg03bj15())){
                queryString.append(" and model.eg03bj15 = ? ");
                binds.add(pojo.getEg03bj15());
            }
            if(isNotBlankOrNull(pojo.getEg03bj16())){
                queryString.append(" and model.eg03bj16 = ? ");
                binds.add(pojo.getEg03bj16());
            }
            if(isNotBlankOrNull(pojo.getEg03bj17())){
                queryString.append(" and model.eg03bj17 = ? ");
                binds.add(pojo.getEg03bj17());
            }
            if(isNotBlankOrNull(pojo.getEg03bj18())){
                queryString.append(" and model.eg03bj18 = ? ");
                binds.add(pojo.getEg03bj18());
            }
            if(isNotBlankOrNull(pojo.getEg03bj19())){
                queryString.append(" and model.eg03bj19 = ? ");
                binds.add(pojo.getEg03bj19());
            }
            if(isNotBlankOrNull(pojo.getEg03bj20())){
                queryString.append(" and model.eg03bj20 = ? ");
                binds.add(pojo.getEg03bj20());
            }
            if(isNotBlankOrNull(pojo.getEg03bj21())){
                queryString.append(" and model.eg03bj21 = ? ");
                binds.add(pojo.getEg03bj21());
            }
            if(isNotBlankOrNull(pojo.getEg03bj22())){
                queryString.append(" and model.eg03bj22 = ? ");
                binds.add(pojo.getEg03bj22());
            }
            if(isNotBlankOrNull(pojo.getEg03bj23())){
                queryString.append(" and model.eg03bj23 = ? ");
                binds.add(pojo.getEg03bj23());
            }
            if(isNotBlankOrNull(pojo.getEg03bj24())){
                queryString.append(" and model.eg03bj24 = ? ");
                binds.add(pojo.getEg03bj24());
            }
            if(isNotBlankOrNull(pojo.getEg03bj25())){
                queryString.append(" and model.eg03bj25 = ? ");
                binds.add(pojo.getEg03bj25());
            }
            if(isNotBlankOrNull(pojo.getEg03bj26())){
                queryString.append(" and model.eg03bj26 = ? ");
                binds.add(pojo.getEg03bj26());
            }
            if(isNotBlankOrNull(pojo.getEg03bj27())){
                queryString.append(" and model.eg03bj27 = ? ");
                binds.add(pojo.getEg03bj27());
            }
            if(isNotBlankOrNull(pojo.getEg03bj28())){
                queryString.append(" and model.eg03bj28 = ? ");
                binds.add(pojo.getEg03bj28());
            }
            if(isNotBlankOrNull(pojo.getEg03bj29())){
                queryString.append(" and model.eg03bj29 = ? ");
                binds.add(pojo.getEg03bj29());
            }
            if(isNotBlankOrNull(pojo.getEg03bj30())){
                queryString.append(" and model.eg03bj30 = ? ");
                binds.add(pojo.getEg03bj30());
            }
            if(isNotBlankOrNull(pojo.getEg03bj31())){
                queryString.append(" and model.eg03bj31 = ? ");
                binds.add(pojo.getEg03bj31());
            }
            if(isNotBlankOrNull(pojo.getEg03bj32())){
                queryString.append(" and model.eg03bj32 = ? ");
                binds.add(pojo.getEg03bj32());
            }
            if(isNotBlankOrNull(pojo.getEg03bj33())){
                queryString.append(" and model.eg03bj33 = ? ");
                binds.add(pojo.getEg03bj33());
            }
            if(isNotBlankOrNull(pojo.getEg03bj34())){
                queryString.append(" and model.eg03bj34 = ? ");
                binds.add(pojo.getEg03bj34());
            }
            if(isNotBlankOrNull(pojo.getEg03bj35())){
                queryString.append(" and model.eg03bj35 = ? ");
                binds.add(pojo.getEg03bj35());
            }
            if(isNotBlankOrNull(pojo.getEg03bj36())){
                queryString.append(" and model.eg03bj36 = ? ");
                binds.add(pojo.getEg03bj36());
            }
            if(isNotBlankOrNull(pojo.getEg03bj37())){
                queryString.append(" and model.eg03bj37 = ? ");
                binds.add(pojo.getEg03bj37());
            }
            if(isNotBlankOrNull(pojo.getEg03bj38())){
                queryString.append(" and model.eg03bj38 = ? ");
                binds.add(pojo.getEg03bj38());
            }
            if(isNotBlankOrNull(pojo.getEg03bj39())){
                queryString.append(" and model.eg03bj39 = ? ");
                binds.add(pojo.getEg03bj39());
            }
            if(isNotBlankOrNull(pojo.getEg03bj40())){
                queryString.append(" and model.eg03bj40 = ? ");
                binds.add(pojo.getEg03bj40());
            }
            if(isNotBlankOrNull(pojo.getEg03bj41())){
                queryString.append(" and model.eg03bj41 = ? ");
                binds.add(pojo.getEg03bj41());
            }
            if(isNotBlankOrNull(pojo.getEg03bj42())){
                queryString.append(" and model.eg03bj42 = ? ");
                binds.add(pojo.getEg03bj42());
            }
            if(isNotBlankOrNull(pojo.getEg03bj43())){
                queryString.append(" and model.eg03bj43 = ? ");
                binds.add(pojo.getEg03bj43());
            }
            if(isNotBlankOrNull(pojo.getEg03bj44())){
                queryString.append(" and model.eg03bj44 = ? ");
                binds.add(pojo.getEg03bj44());
            }
            if(isNotBlankOrNull(pojo.getEg03bj45())){
                queryString.append(" and model.eg03bj45 = ? ");
                binds.add(pojo.getEg03bj45());
            }
            if(isNotBlankOrNull(pojo.getEg03bj46())){
                queryString.append(" and model.eg03bj46 = ? ");
                binds.add(pojo.getEg03bj46());
            }
            if(isNotBlankOrNull(pojo.getEg03bj47())){
                queryString.append(" and model.eg03bj47 = ? ");
                binds.add(pojo.getEg03bj47());
            }
            if(isNotBlankOrNull(pojo.getEg03bj48())){
                queryString.append(" and model.eg03bj48 = ? ");
                binds.add(pojo.getEg03bj48());
            }
            if(isNotBlankOrNull(pojo.getEg03bj49())){
                queryString.append(" and model.eg03bj49 = ? ");
                binds.add(pojo.getEg03bj49());
            }
            if(isNotBlankOrNull(pojo.getEg03bj50())){
                queryString.append(" and model.eg03bj50 = ? ");
                binds.add(pojo.getEg03bj50());
            }
            if(isNotBlankOrNull(pojo.getEg03bj51())){
                queryString.append(" and model.eg03bj51 = ? ");
                binds.add(pojo.getEg03bj51());
            }
            if(isNotBlankOrNull(pojo.getEg03bj52())){
                queryString.append(" and model.eg03bj52 = ? ");
                binds.add(pojo.getEg03bj52());
            }
            if(isNotBlankOrNull(pojo.getEg03bj53())){
                queryString.append(" and model.eg03bj53 = ? ");
                binds.add(pojo.getEg03bj53());
            }
            if(isNotBlankOrNull(pojo.getEg03bj54())){
                queryString.append(" and model.eg03bj54 = ? ");
                binds.add(pojo.getEg03bj54());
            }
            if(isNotBlankOrNull(pojo.getEg03bj55())){
                queryString.append(" and model.eg03bj55 = ? ");
                binds.add(pojo.getEg03bj55());
            }
            if(isNotBlankOrNull(pojo.getEg03bj56())){
                queryString.append(" and model.eg03bj56 = ? ");
                binds.add(pojo.getEg03bj56());
            }
            if(isNotBlankOrNull(pojo.getEg03bj57())){
                queryString.append(" and model.eg03bj57 = ? ");
                binds.add(pojo.getEg03bj57());
            }
            if(isNotBlankOrNull(pojo.getEg03bj58())){
                queryString.append(" and model.eg03bj58 = ? ");
                binds.add(pojo.getEg03bj58());
            }
            if(isNotBlankOrNull(pojo.getEg03bj59())){
                queryString.append(" and model.eg03bj59 = ? ");
                binds.add(pojo.getEg03bj59());
            }
            if(isNotBlankOrNull(pojo.getEg03bj60())){
                queryString.append(" and model.eg03bj60 = ? ");
                binds.add(pojo.getEg03bj60());
            }
            if(isNotBlankOrNull(pojo.getEg03bj61())){
                queryString.append(" and model.eg03bj61 = ? ");
                binds.add(pojo.getEg03bj61());
            }
            if(isNotBlankOrNull(pojo.getEg03bj62())){
                queryString.append(" and model.eg03bj62 = ? ");
                binds.add(pojo.getEg03bj62());
            }
            if(isNotBlankOrNull(pojo.getEg03bj63())){
                queryString.append(" and model.eg03bj63 = ? ");
                binds.add(pojo.getEg03bj63());
            }
            if(isNotBlankOrNull(pojo.getEg03bj64())){
                queryString.append(" and model.eg03bj64 = ? ");
                binds.add(pojo.getEg03bj64());
            }
            if(isNotBlankOrNull(pojo.getEg04ai01())){
                queryString.append(" and model.eg04ai01 = ? ");
                binds.add(pojo.getEg04ai01());
            }
            if(isNotBlankOrNull(pojo.getEg04ad01())){
                queryString.append(" and model.eg04ad01 = ? ");
                binds.add(pojo.getEg04ad01());
            }
            if(isNotBlankOrNull(pojo.getEg04ai02())){
                queryString.append(" and model.eg04ai02 = ? ");
                binds.add(pojo.getEg04ai02());
            }
            if(isNotBlankOrNull(pojo.getEg04ar01())){
                queryString.append(" and model.eg04ar01 = ? ");
                binds.add(pojo.getEg04ar01());
            }
            if(isNotBlankOrNull(pojo.getEg04ad02())){
                queryString.append(" and model.eg04ad02 = ? ");
                binds.add(pojo.getEg04ad02());
            }
            if(isNotBlankOrNull(pojo.getEg04ad03())){
                queryString.append(" and model.eg04ad03 = ? ");
                binds.add(pojo.getEg04ad03());
            }
            if(isNotBlankOrNull(pojo.getEg04bj01())){
                queryString.append(" and model.eg04bj01 = ? ");
                binds.add(pojo.getEg04bj01());
            }
            if(isNotBlankOrNull(pojo.getEg04bj02())){
                queryString.append(" and model.eg04bj02 = ? ");
                binds.add(pojo.getEg04bj02());
            }
            if(isNotBlankOrNull(pojo.getEg04bj03())){
                queryString.append(" and model.eg04bj03 = ? ");
                binds.add(pojo.getEg04bj03());
            }
            if(isNotBlankOrNull(pojo.getEg04bj04())){
                queryString.append(" and model.eg04bj04 = ? ");
                binds.add(pojo.getEg04bj04());
            }
            if(isNotBlankOrNull(pojo.getEg04bj05())){
                queryString.append(" and model.eg04bj05 = ? ");
                binds.add(pojo.getEg04bj05());
            }
            if(isNotBlankOrNull(pojo.getEg04bj06())){
                queryString.append(" and model.eg04bj06 = ? ");
                binds.add(pojo.getEg04bj06());
            }
            if(isNotBlankOrNull(pojo.getEg04bj07())){
                queryString.append(" and model.eg04bj07 = ? ");
                binds.add(pojo.getEg04bj07());
            }
            if(isNotBlankOrNull(pojo.getEg04bj08())){
                queryString.append(" and model.eg04bj08 = ? ");
                binds.add(pojo.getEg04bj08());
            }
            if(isNotBlankOrNull(pojo.getEg04bj09())){
                queryString.append(" and model.eg04bj09 = ? ");
                binds.add(pojo.getEg04bj09());
            }
            if(isNotBlankOrNull(pojo.getEg04bj10())){
                queryString.append(" and model.eg04bj10 = ? ");
                binds.add(pojo.getEg04bj10());
            }
            if(isNotBlankOrNull(pojo.getEg04bj11())){
                queryString.append(" and model.eg04bj11 = ? ");
                binds.add(pojo.getEg04bj11());
            }
            if(isNotBlankOrNull(pojo.getEg04bj12())){
                queryString.append(" and model.eg04bj12 = ? ");
                binds.add(pojo.getEg04bj12());
            }
            if(isNotBlankOrNull(pojo.getEg04bj13())){
                queryString.append(" and model.eg04bj13 = ? ");
                binds.add(pojo.getEg04bj13());
            }
            if(isNotBlankOrNull(pojo.getEg04bj14())){
                queryString.append(" and model.eg04bj14 = ? ");
                binds.add(pojo.getEg04bj14());
            }
            if(isNotBlankOrNull(pojo.getEg04bj15())){
                queryString.append(" and model.eg04bj15 = ? ");
                binds.add(pojo.getEg04bj15());
            }
            if(isNotBlankOrNull(pojo.getEg04bj16())){
                queryString.append(" and model.eg04bj16 = ? ");
                binds.add(pojo.getEg04bj16());
            }
            if(isNotBlankOrNull(pojo.getEg04bj17())){
                queryString.append(" and model.eg04bj17 = ? ");
                binds.add(pojo.getEg04bj17());
            }
            if(isNotBlankOrNull(pojo.getEg04bj18())){
                queryString.append(" and model.eg04bj18 = ? ");
                binds.add(pojo.getEg04bj18());
            }
            if(isNotBlankOrNull(pojo.getEg04bj19())){
                queryString.append(" and model.eg04bj19 = ? ");
                binds.add(pojo.getEg04bj19());
            }
            if(isNotBlankOrNull(pojo.getEg05ai01())){
                queryString.append(" and model.eg05ai01 = ? ");
                binds.add(pojo.getEg05ai01());
            }
            if(isNotBlankOrNull(pojo.getEg05ad01())){
                queryString.append(" and model.eg05ad01 = ? ");
                binds.add(pojo.getEg05ad01());
            }
            if(isNotBlankOrNull(pojo.getEg05ai02())){
                queryString.append(" and model.eg05ai02 = ? ");
                binds.add(pojo.getEg05ai02());
            }
            if(isNotBlankOrNull(pojo.getEg05ar01())){
                queryString.append(" and model.eg05ar01 = ? ");
                binds.add(pojo.getEg05ar01());
            }
            if(isNotBlankOrNull(pojo.getEg05ad02())){
                queryString.append(" and model.eg05ad02 = ? ");
                binds.add(pojo.getEg05ad02());
            }
            if(isNotBlankOrNull(pojo.getEg05ad03())){
                queryString.append(" and model.eg05ad03 = ? ");
                binds.add(pojo.getEg05ad03());
            }
            if(isNotBlankOrNull(pojo.getEg05bj01())){
                queryString.append(" and model.eg05bj01 = ? ");
                binds.add(pojo.getEg05bj01());
            }
            if(isNotBlankOrNull(pojo.getEg05bj02())){
                queryString.append(" and model.eg05bj02 = ? ");
                binds.add(pojo.getEg05bj02());
            }
            if(isNotBlankOrNull(pojo.getEg05bj03())){
                queryString.append(" and model.eg05bj03 = ? ");
                binds.add(pojo.getEg05bj03());
            }
            if(isNotBlankOrNull(pojo.getEg05bj04())){
                queryString.append(" and model.eg05bj04 = ? ");
                binds.add(pojo.getEg05bj04());
            }
            if(isNotBlankOrNull(pojo.getEg05bj05())){
                queryString.append(" and model.eg05bj05 = ? ");
                binds.add(pojo.getEg05bj05());
            }
            if(isNotBlankOrNull(pojo.getEg05bj06())){
                queryString.append(" and model.eg05bj06 = ? ");
                binds.add(pojo.getEg05bj06());
            }
            if(isNotBlankOrNull(pojo.getEg05bj07())){
                queryString.append(" and model.eg05bj07 = ? ");
                binds.add(pojo.getEg05bj07());
            }
            if(isNotBlankOrNull(pojo.getEg05bj08())){
                queryString.append(" and model.eg05bj08 = ? ");
                binds.add(pojo.getEg05bj08());
            }
            if(isNotBlankOrNull(pojo.getEg05bj09())){
                queryString.append(" and model.eg05bj09 = ? ");
                binds.add(pojo.getEg05bj09());
            }
            if(isNotBlankOrNull(pojo.getEg05bj10())){
                queryString.append(" and model.eg05bj10 = ? ");
                binds.add(pojo.getEg05bj10());
            }
            if(isNotBlankOrNull(pojo.getEg05bj11())){
                queryString.append(" and model.eg05bj11 = ? ");
                binds.add(pojo.getEg05bj11());
            }
            if(isNotBlankOrNull(pojo.getEg05bj12())){
                queryString.append(" and model.eg05bj12 = ? ");
                binds.add(pojo.getEg05bj12());
            }
            if(isNotBlankOrNull(pojo.getEg05bj13())){
                queryString.append(" and model.eg05bj13 = ? ");
                binds.add(pojo.getEg05bj13());
            }
            if(isNotBlankOrNull(pojo.getEg05bj14())){
                queryString.append(" and model.eg05bj14 = ? ");
                binds.add(pojo.getEg05bj14());
            }
            if(isNotBlankOrNull(pojo.getEg05bj15())){
                queryString.append(" and model.eg05bj15 = ? ");
                binds.add(pojo.getEg05bj15());
            }
            if(isNotBlankOrNull(pojo.getEg05bj16())){
                queryString.append(" and model.eg05bj16 = ? ");
                binds.add(pojo.getEg05bj16());
            }
            if(isNotBlankOrNull(pojo.getEg05bj17())){
                queryString.append(" and model.eg05bj17 = ? ");
                binds.add(pojo.getEg05bj17());
            }
            if(isNotBlankOrNull(pojo.getEg05bj18())){
                queryString.append(" and model.eg05bj18 = ? ");
                binds.add(pojo.getEg05bj18());
            }
            if(isNotBlankOrNull(pojo.getEg05bj19())){
                queryString.append(" and model.eg05bj19 = ? ");
                binds.add(pojo.getEg05bj19());
            }
            if(isNotBlankOrNull(pojo.getEg05bj20())){
                queryString.append(" and model.eg05bj20 = ? ");
                binds.add(pojo.getEg05bj20());
            }
            if(isNotBlankOrNull(pojo.getEg05bj21())){
                queryString.append(" and model.eg05bj21 = ? ");
                binds.add(pojo.getEg05bj21());
            }
            if(isNotBlankOrNull(pojo.getEg05bj22())){
                queryString.append(" and model.eg05bj22 = ? ");
                binds.add(pojo.getEg05bj22());
            }
            if(isNotBlankOrNull(pojo.getEg05bj23())){
                queryString.append(" and model.eg05bj23 = ? ");
                binds.add(pojo.getEg05bj23());
            }
            if(isNotBlankOrNull(pojo.getEg05bj24())){
                queryString.append(" and model.eg05bj24 = ? ");
                binds.add(pojo.getEg05bj24());
            }
            if(isNotBlankOrNull(pojo.getEg05bj25())){
                queryString.append(" and model.eg05bj25 = ? ");
                binds.add(pojo.getEg05bj25());
            }
            if(isNotBlankOrNull(pojo.getEg05bj26())){
                queryString.append(" and model.eg05bj26 = ? ");
                binds.add(pojo.getEg05bj26());
            }
            if(isNotBlankOrNull(pojo.getEg05bj27())){
                queryString.append(" and model.eg05bj27 = ? ");
                binds.add(pojo.getEg05bj27());
            }
            if(isNotBlankOrNull(pojo.getEg05bj28())){
                queryString.append(" and model.eg05bj28 = ? ");
                binds.add(pojo.getEg05bj28());
            }
            if(isNotBlankOrNull(pojo.getEg05bj29())){
                queryString.append(" and model.eg05bj29 = ? ");
                binds.add(pojo.getEg05bj29());
            }
            if(isNotBlankOrNull(pojo.getEg05bj30())){
                queryString.append(" and model.eg05bj30 = ? ");
                binds.add(pojo.getEg05bj30());
            }
            if(isNotBlankOrNull(pojo.getEg05bj31())){
                queryString.append(" and model.eg05bj31 = ? ");
                binds.add(pojo.getEg05bj31());
            }
            if(isNotBlankOrNull(pojo.getEg05bj32())){
                queryString.append(" and model.eg05bj32 = ? ");
                binds.add(pojo.getEg05bj32());
            }
            if(isNotBlankOrNull(pojo.getEg05bj33())){
                queryString.append(" and model.eg05bj33 = ? ");
                binds.add(pojo.getEg05bj33());
            }
            if(isNotBlankOrNull(pojo.getEg05bj34())){
                queryString.append(" and model.eg05bj34 = ? ");
                binds.add(pojo.getEg05bj34());
            }
            if(isNotBlankOrNull(pojo.getEg05bj35())){
                queryString.append(" and model.eg05bj35 = ? ");
                binds.add(pojo.getEg05bj35());
            }
            if(isNotBlankOrNull(pojo.getEg05bj36())){
                queryString.append(" and model.eg05bj36 = ? ");
                binds.add(pojo.getEg05bj36());
            }
            if(isNotBlankOrNull(pojo.getEg05bj37())){
                queryString.append(" and model.eg05bj37 = ? ");
                binds.add(pojo.getEg05bj37());
            }
            if(isNotBlankOrNull(pojo.getEg05bj38())){
                queryString.append(" and model.eg05bj38 = ? ");
                binds.add(pojo.getEg05bj38());
            }
            if(isNotBlankOrNull(pojo.getEg05bj39())){
                queryString.append(" and model.eg05bj39 = ? ");
                binds.add(pojo.getEg05bj39());
            }
            if(isNotBlankOrNull(pojo.getEg05bj40())){
                queryString.append(" and model.eg05bj40 = ? ");
                binds.add(pojo.getEg05bj40());
            }
            if(isNotBlankOrNull(pojo.getEg05bj41())){
                queryString.append(" and model.eg05bj41 = ? ");
                binds.add(pojo.getEg05bj41());
            }
            if(isNotBlankOrNull(pojo.getEg05bj42())){
                queryString.append(" and model.eg05bj42 = ? ");
                binds.add(pojo.getEg05bj42());
            }
            if(isNotBlankOrNull(pojo.getEg05bj43())){
                queryString.append(" and model.eg05bj43 = ? ");
                binds.add(pojo.getEg05bj43());
            }
            if(isNotBlankOrNull(pojo.getEg05bj44())){
                queryString.append(" and model.eg05bj44 = ? ");
                binds.add(pojo.getEg05bj44());
            }
            if(isNotBlankOrNull(pojo.getEg05bj45())){
                queryString.append(" and model.eg05bj45 = ? ");
                binds.add(pojo.getEg05bj45());
            }
            if(isNotBlankOrNull(pojo.getEg05bj46())){
                queryString.append(" and model.eg05bj46 = ? ");
                binds.add(pojo.getEg05bj46());
            }
            if(isNotBlankOrNull(pojo.getEg05bj47())){
                queryString.append(" and model.eg05bj47 = ? ");
                binds.add(pojo.getEg05bj47());
            }
            if(isNotBlankOrNull(pojo.getEg05bj48())){
                queryString.append(" and model.eg05bj48 = ? ");
                binds.add(pojo.getEg05bj48());
            }
            if(isNotBlankOrNull(pojo.getEg05bj49())){
                queryString.append(" and model.eg05bj49 = ? ");
                binds.add(pojo.getEg05bj49());
            }
            if(isNotBlankOrNull(pojo.getEg05bj50())){
                queryString.append(" and model.eg05bj50 = ? ");
                binds.add(pojo.getEg05bj50());
            }
            if(isNotBlankOrNull(pojo.getEg05bj51())){
                queryString.append(" and model.eg05bj51 = ? ");
                binds.add(pojo.getEg05bj51());
            }
            if(isNotBlankOrNull(pojo.getEg05bj52())){
                queryString.append(" and model.eg05bj52 = ? ");
                binds.add(pojo.getEg05bj52());
            }
            if(isNotBlankOrNull(pojo.getEg05bj53())){
                queryString.append(" and model.eg05bj53 = ? ");
                binds.add(pojo.getEg05bj53());
            }
            if(isNotBlankOrNull(pojo.getEg05bj54())){
                queryString.append(" and model.eg05bj54 = ? ");
                binds.add(pojo.getEg05bj54());
            }
            if(isNotBlankOrNull(pojo.getEg05bj55())){
                queryString.append(" and model.eg05bj55 = ? ");
                binds.add(pojo.getEg05bj55());
            }
            if(isNotBlankOrNull(pojo.getEg05bj56())){
                queryString.append(" and model.eg05bj56 = ? ");
                binds.add(pojo.getEg05bj56());
            }
            if(isNotBlankOrNull(pojo.getEg05bj57())){
                queryString.append(" and model.eg05bj57 = ? ");
                binds.add(pojo.getEg05bj57());
            }
            if(isNotBlankOrNull(pojo.getEg06ai01())){
                queryString.append(" and model.eg06ai01 = ? ");
                binds.add(pojo.getEg06ai01());
            }
            if(isNotBlankOrNull(pojo.getEg06ad01())){
                queryString.append(" and model.eg06ad01 = ? ");
                binds.add(pojo.getEg06ad01());
            }
            if(isNotBlankOrNull(pojo.getEg06ai02())){
                queryString.append(" and model.eg06ai02 = ? ");
                binds.add(pojo.getEg06ai02());
            }
            if(isNotBlankOrNull(pojo.getEg06ar01())){
                queryString.append(" and model.eg06ar01 = ? ");
                binds.add(pojo.getEg06ar01());
            }
            if(isNotBlankOrNull(pojo.getEg06ad02())){
                queryString.append(" and model.eg06ad02 = ? ");
                binds.add(pojo.getEg06ad02());
            }
            if(isNotBlankOrNull(pojo.getEg06ad03())){
                queryString.append(" and model.eg06ad03 = ? ");
                binds.add(pojo.getEg06ad03());
            }
            if(isNotBlankOrNull(pojo.getEg06bj01())){
                queryString.append(" and model.eg06bj01 = ? ");
                binds.add(pojo.getEg06bj01());
            }
            if(isNotBlankOrNull(pojo.getEg06bj02())){
                queryString.append(" and model.eg06bj02 = ? ");
                binds.add(pojo.getEg06bj02());
            }
            if(isNotBlankOrNull(pojo.getEg06bj03())){
                queryString.append(" and model.eg06bj03 = ? ");
                binds.add(pojo.getEg06bj03());
            }
            if(isNotBlankOrNull(pojo.getEg06bj04())){
                queryString.append(" and model.eg06bj04 = ? ");
                binds.add(pojo.getEg06bj04());
            }
            if(isNotBlankOrNull(pojo.getEg06bj05())){
                queryString.append(" and model.eg06bj05 = ? ");
                binds.add(pojo.getEg06bj05());
            }
            if(isNotBlankOrNull(pojo.getEg06bj06())){
                queryString.append(" and model.eg06bj06 = ? ");
                binds.add(pojo.getEg06bj06());
            }
            if(isNotBlankOrNull(pojo.getEg06bj07())){
                queryString.append(" and model.eg06bj07 = ? ");
                binds.add(pojo.getEg06bj07());
            }
            if(isNotBlankOrNull(pojo.getEg06bj08())){
                queryString.append(" and model.eg06bj08 = ? ");
                binds.add(pojo.getEg06bj08());
            }
            if(isNotBlankOrNull(pojo.getEg06bj09())){
                queryString.append(" and model.eg06bj09 = ? ");
                binds.add(pojo.getEg06bj09());
            }
            if(isNotBlankOrNull(pojo.getEg06bj10())){
                queryString.append(" and model.eg06bj10 = ? ");
                binds.add(pojo.getEg06bj10());
            }
            if(isNotBlankOrNull(pojo.getEg06bj11())){
                queryString.append(" and model.eg06bj11 = ? ");
                binds.add(pojo.getEg06bj11());
            }
            if(isNotBlankOrNull(pojo.getEg06bj12())){
                queryString.append(" and model.eg06bj12 = ? ");
                binds.add(pojo.getEg06bj12());
            }
            if(isNotBlankOrNull(pojo.getEg06bj13())){
                queryString.append(" and model.eg06bj13 = ? ");
                binds.add(pojo.getEg06bj13());
            }
            if(isNotBlankOrNull(pojo.getEg06bj14())){
                queryString.append(" and model.eg06bj14 = ? ");
                binds.add(pojo.getEg06bj14());
            }
            if(isNotBlankOrNull(pojo.getEg06bj15())){
                queryString.append(" and model.eg06bj15 = ? ");
                binds.add(pojo.getEg06bj15());
            }
            if(isNotBlankOrNull(pojo.getEg06bj16())){
                queryString.append(" and model.eg06bj16 = ? ");
                binds.add(pojo.getEg06bj16());
            }
            if(isNotBlankOrNull(pojo.getEg06bj17())){
                queryString.append(" and model.eg06bj17 = ? ");
                binds.add(pojo.getEg06bj17());
            }
            if(isNotBlankOrNull(pojo.getEg06bj18())){
                queryString.append(" and model.eg06bj18 = ? ");
                binds.add(pojo.getEg06bj18());
            }
            if(isNotBlankOrNull(pojo.getEg06bj19())){
                queryString.append(" and model.eg06bj19 = ? ");
                binds.add(pojo.getEg06bj19());
            }
            if(isNotBlankOrNull(pojo.getEg06bj20())){
                queryString.append(" and model.eg06bj20 = ? ");
                binds.add(pojo.getEg06bj20());
            }
            if(isNotBlankOrNull(pojo.getEg06bj21())){
                queryString.append(" and model.eg06bj21 = ? ");
                binds.add(pojo.getEg06bj21());
            }
            if(isNotBlankOrNull(pojo.getEg06bj22())){
                queryString.append(" and model.eg06bj22 = ? ");
                binds.add(pojo.getEg06bj22());
            }
            if(isNotBlankOrNull(pojo.getEg06bj23())){
                queryString.append(" and model.eg06bj23 = ? ");
                binds.add(pojo.getEg06bj23());
            }
            if(isNotBlankOrNull(pojo.getEg06bj24())){
                queryString.append(" and model.eg06bj24 = ? ");
                binds.add(pojo.getEg06bj24());
            }
            if(isNotBlankOrNull(pojo.getEg06bj25())){
                queryString.append(" and model.eg06bj25 = ? ");
                binds.add(pojo.getEg06bj25());
            }
            if(isNotBlankOrNull(pojo.getEg06bj26())){
                queryString.append(" and model.eg06bj26 = ? ");
                binds.add(pojo.getEg06bj26());
            }
            if(isNotBlankOrNull(pojo.getEg06bj27())){
                queryString.append(" and model.eg06bj27 = ? ");
                binds.add(pojo.getEg06bj27());
            }
            if(isNotBlankOrNull(pojo.getEg06bj28())){
                queryString.append(" and model.eg06bj28 = ? ");
                binds.add(pojo.getEg06bj28());
            }
            if(isNotBlankOrNull(pojo.getEg06bj29())){
                queryString.append(" and model.eg06bj29 = ? ");
                binds.add(pojo.getEg06bj29());
            }
            if(isNotBlankOrNull(pojo.getEg06bj30())){
                queryString.append(" and model.eg06bj30 = ? ");
                binds.add(pojo.getEg06bj30());
            }
            if(isNotBlankOrNull(pojo.getEg06bj31())){
                queryString.append(" and model.eg06bj31 = ? ");
                binds.add(pojo.getEg06bj31());
            }
            if(isNotBlankOrNull(pojo.getEg06bj32())){
                queryString.append(" and model.eg06bj32 = ? ");
                binds.add(pojo.getEg06bj32());
            }
            if(isNotBlankOrNull(pojo.getEg06bj33())){
                queryString.append(" and model.eg06bj33 = ? ");
                binds.add(pojo.getEg06bj33());
            }
            if(isNotBlankOrNull(pojo.getEg06bj34())){
                queryString.append(" and model.eg06bj34 = ? ");
                binds.add(pojo.getEg06bj34());
            }
            if(isNotBlankOrNull(pojo.getEg06bj35())){
                queryString.append(" and model.eg06bj35 = ? ");
                binds.add(pojo.getEg06bj35());
            }
            if(isNotBlankOrNull(pojo.getEg06bj36())){
                queryString.append(" and model.eg06bj36 = ? ");
                binds.add(pojo.getEg06bj36());
            }
            if(isNotBlankOrNull(pojo.getEg06bj37())){
                queryString.append(" and model.eg06bj37 = ? ");
                binds.add(pojo.getEg06bj37());
            }
            if(isNotBlankOrNull(pojo.getEg06bj38())){
                queryString.append(" and model.eg06bj38 = ? ");
                binds.add(pojo.getEg06bj38());
            }
            if(isNotBlankOrNull(pojo.getEg06bj39())){
                queryString.append(" and model.eg06bj39 = ? ");
                binds.add(pojo.getEg06bj39());
            }
            if(isNotBlankOrNull(pojo.getEg06bj40())){
                queryString.append(" and model.eg06bj40 = ? ");
                binds.add(pojo.getEg06bj40());
            }
            if(isNotBlankOrNull(pojo.getEg06bj41())){
                queryString.append(" and model.eg06bj41 = ? ");
                binds.add(pojo.getEg06bj41());
            }
            if(isNotBlankOrNull(pojo.getEg06bj42())){
                queryString.append(" and model.eg06bj42 = ? ");
                binds.add(pojo.getEg06bj42());
            }
            if(isNotBlankOrNull(pojo.getEg06bj43())){
                queryString.append(" and model.eg06bj43 = ? ");
                binds.add(pojo.getEg06bj43());
            }
            if(isNotBlankOrNull(pojo.getEg06bj44())){
                queryString.append(" and model.eg06bj44 = ? ");
                binds.add(pojo.getEg06bj44());
            }
            if(isNotBlankOrNull(pojo.getEg06bj45())){
                queryString.append(" and model.eg06bj45 = ? ");
                binds.add(pojo.getEg06bj45());
            }
            if(isNotBlankOrNull(pojo.getEg06bj46())){
                queryString.append(" and model.eg06bj46 = ? ");
                binds.add(pojo.getEg06bj46());
            }
            if(isNotBlankOrNull(pojo.getEg06bj47())){
                queryString.append(" and model.eg06bj47 = ? ");
                binds.add(pojo.getEg06bj47());
            }
            if(isNotBlankOrNull(pojo.getEg06bj48())){
                queryString.append(" and model.eg06bj48 = ? ");
                binds.add(pojo.getEg06bj48());
            }
            if(isNotBlankOrNull(pojo.getEg06bj49())){
                queryString.append(" and model.eg06bj49 = ? ");
                binds.add(pojo.getEg06bj49());
            }
            if(isNotBlankOrNull(pojo.getEg06bj50())){
                queryString.append(" and model.eg06bj50 = ? ");
                binds.add(pojo.getEg06bj50());
            }
            if(isNotBlankOrNull(pojo.getEg06bj51())){
                queryString.append(" and model.eg06bj51 = ? ");
                binds.add(pojo.getEg06bj51());
            }
            if(isNotBlankOrNull(pojo.getEg06bj52())){
                queryString.append(" and model.eg06bj52 = ? ");
                binds.add(pojo.getEg06bj52());
            }
            if(isNotBlankOrNull(pojo.getEg06bj53())){
                queryString.append(" and model.eg06bj53 = ? ");
                binds.add(pojo.getEg06bj53());
            }
            if(isNotBlankOrNull(pojo.getEg06bj54())){
                queryString.append(" and model.eg06bj54 = ? ");
                binds.add(pojo.getEg06bj54());
            }
            if(isNotBlankOrNull(pojo.getEg06bj55())){
                queryString.append(" and model.eg06bj55 = ? ");
                binds.add(pojo.getEg06bj55());
            }
            if(isNotBlankOrNull(pojo.getEg06bj56())){
                queryString.append(" and model.eg06bj56 = ? ");
                binds.add(pojo.getEg06bj56());
            }
            if(isNotBlankOrNull(pojo.getEg06bj57())){
                queryString.append(" and model.eg06bj57 = ? ");
                binds.add(pojo.getEg06bj57());
            }
            if(isNotBlankOrNull(pojo.getEg06bj58())){
                queryString.append(" and model.eg06bj58 = ? ");
                binds.add(pojo.getEg06bj58());
            }
            if(isNotBlankOrNull(pojo.getEg06bj59())){
                queryString.append(" and model.eg06bj59 = ? ");
                binds.add(pojo.getEg06bj59());
            }
            if(isNotBlankOrNull(pojo.getEg06bj60())){
                queryString.append(" and model.eg06bj60 = ? ");
                binds.add(pojo.getEg06bj60());
            }
            if(isNotBlankOrNull(pojo.getEg06bj61())){
                queryString.append(" and model.eg06bj61 = ? ");
                binds.add(pojo.getEg06bj61());
            }
            if(isNotBlankOrNull(pojo.getEg06bj62())){
                queryString.append(" and model.eg06bj62 = ? ");
                binds.add(pojo.getEg06bj62());
            }
            if(isNotBlankOrNull(pojo.getEg06bj63())){
                queryString.append(" and model.eg06bj63 = ? ");
                binds.add(pojo.getEg06bj63());
            }
            if(isNotBlankOrNull(pojo.getEg07ai01())){
                queryString.append(" and model.eg07ai01 = ? ");
                binds.add(pojo.getEg07ai01());
            }
            if(isNotBlankOrNull(pojo.getEg07ad01())){
                queryString.append(" and model.eg07ad01 = ? ");
                binds.add(pojo.getEg07ad01());
            }
            if(isNotBlankOrNull(pojo.getEg07ai02())){
                queryString.append(" and model.eg07ai02 = ? ");
                binds.add(pojo.getEg07ai02());
            }
            if(isNotBlankOrNull(pojo.getEg07ar01())){
                queryString.append(" and model.eg07ar01 = ? ");
                binds.add(pojo.getEg07ar01());
            }
            if(isNotBlankOrNull(pojo.getEg07ad02())){
                queryString.append(" and model.eg07ad02 = ? ");
                binds.add(pojo.getEg07ad02());
            }
            if(isNotBlankOrNull(pojo.getEg07ad03())){
                queryString.append(" and model.eg07ad03 = ? ");
                binds.add(pojo.getEg07ad03());
            }
            if(isNotBlankOrNull(pojo.getEg07bj01())){
                queryString.append(" and model.eg07bj01 = ? ");
                binds.add(pojo.getEg07bj01());
            }
            if(isNotBlankOrNull(pojo.getEg07bj02())){
                queryString.append(" and model.eg07bj02 = ? ");
                binds.add(pojo.getEg07bj02());
            }
            if(isNotBlankOrNull(pojo.getEg07bj03())){
                queryString.append(" and model.eg07bj03 = ? ");
                binds.add(pojo.getEg07bj03());
            }
            if(isNotBlankOrNull(pojo.getEg07bj04())){
                queryString.append(" and model.eg07bj04 = ? ");
                binds.add(pojo.getEg07bj04());
            }
            if(isNotBlankOrNull(pojo.getEg07bj05())){
                queryString.append(" and model.eg07bj05 = ? ");
                binds.add(pojo.getEg07bj05());
            }
            if(isNotBlankOrNull(pojo.getEg07bj06())){
                queryString.append(" and model.eg07bj06 = ? ");
                binds.add(pojo.getEg07bj06());
            }
            if(isNotBlankOrNull(pojo.getEg07bj07())){
                queryString.append(" and model.eg07bj07 = ? ");
                binds.add(pojo.getEg07bj07());
            }
            if(isNotBlankOrNull(pojo.getEg07bj08())){
                queryString.append(" and model.eg07bj08 = ? ");
                binds.add(pojo.getEg07bj08());
            }
            if(isNotBlankOrNull(pojo.getEg07bj09())){
                queryString.append(" and model.eg07bj09 = ? ");
                binds.add(pojo.getEg07bj09());
            }
            if(isNotBlankOrNull(pojo.getEg07bj10())){
                queryString.append(" and model.eg07bj10 = ? ");
                binds.add(pojo.getEg07bj10());
            }
            if(isNotBlankOrNull(pojo.getEg07bj11())){
                queryString.append(" and model.eg07bj11 = ? ");
                binds.add(pojo.getEg07bj11());
            }
            if(isNotBlankOrNull(pojo.getEg07bj12())){
                queryString.append(" and model.eg07bj12 = ? ");
                binds.add(pojo.getEg07bj12());
            }
            if(isNotBlankOrNull(pojo.getEg07bj13())){
                queryString.append(" and model.eg07bj13 = ? ");
                binds.add(pojo.getEg07bj13());
            }
            if(isNotBlankOrNull(pojo.getEg07bj14())){
                queryString.append(" and model.eg07bj14 = ? ");
                binds.add(pojo.getEg07bj14());
            }
            if(isNotBlankOrNull(pojo.getEg07bj15())){
                queryString.append(" and model.eg07bj15 = ? ");
                binds.add(pojo.getEg07bj15());
            }
            if(isNotBlankOrNull(pojo.getEg07bj16())){
                queryString.append(" and model.eg07bj16 = ? ");
                binds.add(pojo.getEg07bj16());
            }
            if(isNotBlankOrNull(pojo.getEg07bj17())){
                queryString.append(" and model.eg07bj17 = ? ");
                binds.add(pojo.getEg07bj17());
            }
            if(isNotBlankOrNull(pojo.getEg07bj18())){
                queryString.append(" and model.eg07bj18 = ? ");
                binds.add(pojo.getEg07bj18());
            }
            if(isNotBlankOrNull(pojo.getEg07bj19())){
                queryString.append(" and model.eg07bj19 = ? ");
                binds.add(pojo.getEg07bj19());
            }
            if(isNotBlankOrNull(pojo.getEg07bj20())){
                queryString.append(" and model.eg07bj20 = ? ");
                binds.add(pojo.getEg07bj20());
            }
            if(isNotBlankOrNull(pojo.getEg07bj21())){
                queryString.append(" and model.eg07bj21 = ? ");
                binds.add(pojo.getEg07bj21());
            }
            if(isNotBlankOrNull(pojo.getEg07bj22())){
                queryString.append(" and model.eg07bj22 = ? ");
                binds.add(pojo.getEg07bj22());
            }
            if(isNotBlankOrNull(pojo.getEg07bj23())){
                queryString.append(" and model.eg07bj23 = ? ");
                binds.add(pojo.getEg07bj23());
            }
            if(isNotBlankOrNull(pojo.getEg07bj24())){
                queryString.append(" and model.eg07bj24 = ? ");
                binds.add(pojo.getEg07bj24());
            }
            if(isNotBlankOrNull(pojo.getEg07bj25())){
                queryString.append(" and model.eg07bj25 = ? ");
                binds.add(pojo.getEg07bj25());
            }
            if(isNotBlankOrNull(pojo.getEg07bj26())){
                queryString.append(" and model.eg07bj26 = ? ");
                binds.add(pojo.getEg07bj26());
            }
            if(isNotBlankOrNull(pojo.getEg07bj27())){
                queryString.append(" and model.eg07bj27 = ? ");
                binds.add(pojo.getEg07bj27());
            }
            if(isNotBlankOrNull(pojo.getEg07bj28())){
                queryString.append(" and model.eg07bj28 = ? ");
                binds.add(pojo.getEg07bj28());
            }
            if(isNotBlankOrNull(pojo.getEg07bj29())){
                queryString.append(" and model.eg07bj29 = ? ");
                binds.add(pojo.getEg07bj29());
            }
            if(isNotBlankOrNull(pojo.getEg07bj30())){
                queryString.append(" and model.eg07bj30 = ? ");
                binds.add(pojo.getEg07bj30());
            }
            if(isNotBlankOrNull(pojo.getEg07bj31())){
                queryString.append(" and model.eg07bj31 = ? ");
                binds.add(pojo.getEg07bj31());
            }
            if(isNotBlankOrNull(pojo.getEg07bj32())){
                queryString.append(" and model.eg07bj32 = ? ");
                binds.add(pojo.getEg07bj32());
            }
            if(isNotBlankOrNull(pojo.getEg07bj33())){
                queryString.append(" and model.eg07bj33 = ? ");
                binds.add(pojo.getEg07bj33());
            }
            if(isNotBlankOrNull(pojo.getEg07bj34())){
                queryString.append(" and model.eg07bj34 = ? ");
                binds.add(pojo.getEg07bj34());
            }
            if(isNotBlankOrNull(pojo.getEg07bj35())){
                queryString.append(" and model.eg07bj35 = ? ");
                binds.add(pojo.getEg07bj35());
            }
            if(isNotBlankOrNull(pojo.getEg07bj36())){
                queryString.append(" and model.eg07bj36 = ? ");
                binds.add(pojo.getEg07bj36());
            }
            if(isNotBlankOrNull(pojo.getEg07bj37())){
                queryString.append(" and model.eg07bj37 = ? ");
                binds.add(pojo.getEg07bj37());
            }
            if(isNotBlankOrNull(pojo.getEg07bj38())){
                queryString.append(" and model.eg07bj38 = ? ");
                binds.add(pojo.getEg07bj38());
            }
            if(isNotBlankOrNull(pojo.getEg07bj39())){
                queryString.append(" and model.eg07bj39 = ? ");
                binds.add(pojo.getEg07bj39());
            }
            if(isNotBlankOrNull(pojo.getEg07bj40())){
                queryString.append(" and model.eg07bj40 = ? ");
                binds.add(pojo.getEg07bj40());
            }
            if(isNotBlankOrNull(pojo.getEg07bj41())){
                queryString.append(" and model.eg07bj41 = ? ");
                binds.add(pojo.getEg07bj41());
            }
            if(isNotBlankOrNull(pojo.getEg07bj42())){
                queryString.append(" and model.eg07bj42 = ? ");
                binds.add(pojo.getEg07bj42());
            }
            if(isNotBlankOrNull(pojo.getEg07bj43())){
                queryString.append(" and model.eg07bj43 = ? ");
                binds.add(pojo.getEg07bj43());
            }
            if(isNotBlankOrNull(pojo.getEg07bj44())){
                queryString.append(" and model.eg07bj44 = ? ");
                binds.add(pojo.getEg07bj44());
            }
            if(isNotBlankOrNull(pojo.getEg07bj45())){
                queryString.append(" and model.eg07bj45 = ? ");
                binds.add(pojo.getEg07bj45());
            }
            if(isNotBlankOrNull(pojo.getEg07bj46())){
                queryString.append(" and model.eg07bj46 = ? ");
                binds.add(pojo.getEg07bj46());
            }
            if(isNotBlankOrNull(pojo.getEg07bj47())){
                queryString.append(" and model.eg07bj47 = ? ");
                binds.add(pojo.getEg07bj47());
            }
            if(isNotBlankOrNull(pojo.getEg07bj48())){
                queryString.append(" and model.eg07bj48 = ? ");
                binds.add(pojo.getEg07bj48());
            }
            if(isNotBlankOrNull(pojo.getEg07bj49())){
                queryString.append(" and model.eg07bj49 = ? ");
                binds.add(pojo.getEg07bj49());
            }
            if(isNotBlankOrNull(pojo.getEg07bj50())){
                queryString.append(" and model.eg07bj50 = ? ");
                binds.add(pojo.getEg07bj50());
            }
            if(isNotBlankOrNull(pojo.getEg08ai01())){
                queryString.append(" and model.eg08ai01 = ? ");
                binds.add(pojo.getEg08ai01());
            }
            if(isNotBlankOrNull(pojo.getEg08ad01())){
                queryString.append(" and model.eg08ad01 = ? ");
                binds.add(pojo.getEg08ad01());
            }
            if(isNotBlankOrNull(pojo.getEg08ai02())){
                queryString.append(" and model.eg08ai02 = ? ");
                binds.add(pojo.getEg08ai02());
            }
            if(isNotBlankOrNull(pojo.getEg08ar01())){
                queryString.append(" and model.eg08ar01 = ? ");
                binds.add(pojo.getEg08ar01());
            }
            if(isNotBlankOrNull(pojo.getEg08ad02())){
                queryString.append(" and model.eg08ad02 = ? ");
                binds.add(pojo.getEg08ad02());
            }
            if(isNotBlankOrNull(pojo.getEg08ad03())){
                queryString.append(" and model.eg08ad03 = ? ");
                binds.add(pojo.getEg08ad03());
            }
            if(isNotBlankOrNull(pojo.getEg08bj01())){
                queryString.append(" and model.eg08bj01 = ? ");
                binds.add(pojo.getEg08bj01());
            }
            if(isNotBlankOrNull(pojo.getEg08bj02())){
                queryString.append(" and model.eg08bj02 = ? ");
                binds.add(pojo.getEg08bj02());
            }
            if(isNotBlankOrNull(pojo.getEg08bj03())){
                queryString.append(" and model.eg08bj03 = ? ");
                binds.add(pojo.getEg08bj03());
            }
            if(isNotBlankOrNull(pojo.getEg08bj04())){
                queryString.append(" and model.eg08bj04 = ? ");
                binds.add(pojo.getEg08bj04());
            }
            if(isNotBlankOrNull(pojo.getEg08bj05())){
                queryString.append(" and model.eg08bj05 = ? ");
                binds.add(pojo.getEg08bj05());
            }
            if(isNotBlankOrNull(pojo.getEg08bj06())){
                queryString.append(" and model.eg08bj06 = ? ");
                binds.add(pojo.getEg08bj06());
            }
            if(isNotBlankOrNull(pojo.getEg08bj07())){
                queryString.append(" and model.eg08bj07 = ? ");
                binds.add(pojo.getEg08bj07());
            }
            if(isNotBlankOrNull(pojo.getEg08bj08())){
                queryString.append(" and model.eg08bj08 = ? ");
                binds.add(pojo.getEg08bj08());
            }
            if(isNotBlankOrNull(pojo.getEg08bj09())){
                queryString.append(" and model.eg08bj09 = ? ");
                binds.add(pojo.getEg08bj09());
            }
            if(isNotBlankOrNull(pojo.getEg08bj10())){
                queryString.append(" and model.eg08bj10 = ? ");
                binds.add(pojo.getEg08bj10());
            }
            if(isNotBlankOrNull(pojo.getEg08bj11())){
                queryString.append(" and model.eg08bj11 = ? ");
                binds.add(pojo.getEg08bj11());
            }
            if(isNotBlankOrNull(pojo.getEg08bj12())){
                queryString.append(" and model.eg08bj12 = ? ");
                binds.add(pojo.getEg08bj12());
            }
            if(isNotBlankOrNull(pojo.getEg08bj13())){
                queryString.append(" and model.eg08bj13 = ? ");
                binds.add(pojo.getEg08bj13());
            }
            if(isNotBlankOrNull(pojo.getEg08bj14())){
                queryString.append(" and model.eg08bj14 = ? ");
                binds.add(pojo.getEg08bj14());
            }
            if(isNotBlankOrNull(pojo.getEg08bj15())){
                queryString.append(" and model.eg08bj15 = ? ");
                binds.add(pojo.getEg08bj15());
            }
            if(isNotBlankOrNull(pojo.getEg08bj16())){
                queryString.append(" and model.eg08bj16 = ? ");
                binds.add(pojo.getEg08bj16());
            }
            if(isNotBlankOrNull(pojo.getEg08bj17())){
                queryString.append(" and model.eg08bj17 = ? ");
                binds.add(pojo.getEg08bj17());
            }
            if(isNotBlankOrNull(pojo.getEg08bj18())){
                queryString.append(" and model.eg08bj18 = ? ");
                binds.add(pojo.getEg08bj18());
            }
            if(isNotBlankOrNull(pojo.getEg08bj19())){
                queryString.append(" and model.eg08bj19 = ? ");
                binds.add(pojo.getEg08bj19());
            }
            if(isNotBlankOrNull(pojo.getEg08bj20())){
                queryString.append(" and model.eg08bj20 = ? ");
                binds.add(pojo.getEg08bj20());
            }
            if(isNotBlankOrNull(pojo.getEg08bj21())){
                queryString.append(" and model.eg08bj21 = ? ");
                binds.add(pojo.getEg08bj21());
            }
            if(isNotBlankOrNull(pojo.getEg08bj22())){
                queryString.append(" and model.eg08bj22 = ? ");
                binds.add(pojo.getEg08bj22());
            }
            if(isNotBlankOrNull(pojo.getEg08bj23())){
                queryString.append(" and model.eg08bj23 = ? ");
                binds.add(pojo.getEg08bj23());
            }
            if(isNotBlankOrNull(pojo.getEg08bj24())){
                queryString.append(" and model.eg08bj24 = ? ");
                binds.add(pojo.getEg08bj24());
            }
            if(isNotBlankOrNull(pojo.getEg08bj25())){
                queryString.append(" and model.eg08bj25 = ? ");
                binds.add(pojo.getEg08bj25());
            }
            if(isNotBlankOrNull(pojo.getEg08bj26())){
                queryString.append(" and model.eg08bj26 = ? ");
                binds.add(pojo.getEg08bj26());
            }
            if(isNotBlankOrNull(pojo.getEg08bj27())){
                queryString.append(" and model.eg08bj27 = ? ");
                binds.add(pojo.getEg08bj27());
            }
            if(isNotBlankOrNull(pojo.getEg08bj28())){
                queryString.append(" and model.eg08bj28 = ? ");
                binds.add(pojo.getEg08bj28());
            }
            if(isNotBlankOrNull(pojo.getEg08bj29())){
                queryString.append(" and model.eg08bj29 = ? ");
                binds.add(pojo.getEg08bj29());
            }
            if(isNotBlankOrNull(pojo.getEg08bj30())){
                queryString.append(" and model.eg08bj30 = ? ");
                binds.add(pojo.getEg08bj30());
            }
            if(isNotBlankOrNull(pojo.getEg08bj31())){
                queryString.append(" and model.eg08bj31 = ? ");
                binds.add(pojo.getEg08bj31());
            }
            if(isNotBlankOrNull(pojo.getEg08bj32())){
                queryString.append(" and model.eg08bj32 = ? ");
                binds.add(pojo.getEg08bj32());
            }
            if(isNotBlankOrNull(pojo.getEg08bj33())){
                queryString.append(" and model.eg08bj33 = ? ");
                binds.add(pojo.getEg08bj33());
            }
            if(isNotBlankOrNull(pojo.getEg08bj34())){
                queryString.append(" and model.eg08bj34 = ? ");
                binds.add(pojo.getEg08bj34());
            }
            if(isNotBlankOrNull(pojo.getEg08bj35())){
                queryString.append(" and model.eg08bj35 = ? ");
                binds.add(pojo.getEg08bj35());
            }
            if(isNotBlankOrNull(pojo.getEg08bj36())){
                queryString.append(" and model.eg08bj36 = ? ");
                binds.add(pojo.getEg08bj36());
            }
            if(isNotBlankOrNull(pojo.getEg08bj37())){
                queryString.append(" and model.eg08bj37 = ? ");
                binds.add(pojo.getEg08bj37());
            }
            if(isNotBlankOrNull(pojo.getEg08bj38())){
                queryString.append(" and model.eg08bj38 = ? ");
                binds.add(pojo.getEg08bj38());
            }
            if(isNotBlankOrNull(pojo.getEg08bj39())){
                queryString.append(" and model.eg08bj39 = ? ");
                binds.add(pojo.getEg08bj39());
            }
            if(isNotBlankOrNull(pojo.getEg08bj40())){
                queryString.append(" and model.eg08bj40 = ? ");
                binds.add(pojo.getEg08bj40());
            }
            if(isNotBlankOrNull(pojo.getEg08bj41())){
                queryString.append(" and model.eg08bj41 = ? ");
                binds.add(pojo.getEg08bj41());
            }
            if(isNotBlankOrNull(pojo.getEg08bj42())){
                queryString.append(" and model.eg08bj42 = ? ");
                binds.add(pojo.getEg08bj42());
            }
            if(isNotBlankOrNull(pojo.getEg08bj43())){
                queryString.append(" and model.eg08bj43 = ? ");
                binds.add(pojo.getEg08bj43());
            }
            if(isNotBlankOrNull(pojo.getEg08bj44())){
                queryString.append(" and model.eg08bj44 = ? ");
                binds.add(pojo.getEg08bj44());
            }
            if(isNotBlankOrNull(pojo.getEg08bj45())){
                queryString.append(" and model.eg08bj45 = ? ");
                binds.add(pojo.getEg08bj45());
            }
            if(isNotBlankOrNull(pojo.getEg08bj46())){
                queryString.append(" and model.eg08bj46 = ? ");
                binds.add(pojo.getEg08bj46());
            }
            if(isNotBlankOrNull(pojo.getEg08bj47())){
                queryString.append(" and model.eg08bj47 = ? ");
                binds.add(pojo.getEg08bj47());
            }
            if(isNotBlankOrNull(pojo.getEg09ai01())){
                queryString.append(" and model.eg09ai01 = ? ");
                binds.add(pojo.getEg09ai01());
            }
            if(isNotBlankOrNull(pojo.getEg09ad01())){
                queryString.append(" and model.eg09ad01 = ? ");
                binds.add(pojo.getEg09ad01());
            }
            if(isNotBlankOrNull(pojo.getEg09ai02())){
                queryString.append(" and model.eg09ai02 = ? ");
                binds.add(pojo.getEg09ai02());
            }
            if(isNotBlankOrNull(pojo.getEg09ar01())){
                queryString.append(" and model.eg09ar01 = ? ");
                binds.add(pojo.getEg09ar01());
            }
            if(isNotBlankOrNull(pojo.getEg09ad02())){
                queryString.append(" and model.eg09ad02 = ? ");
                binds.add(pojo.getEg09ad02());
            }
            if(isNotBlankOrNull(pojo.getEg09ad03())){
                queryString.append(" and model.eg09ad03 = ? ");
                binds.add(pojo.getEg09ad03());
            }
            if(isNotBlankOrNull(pojo.getEg09bj01())){
                queryString.append(" and model.eg09bj01 = ? ");
                binds.add(pojo.getEg09bj01());
            }
            if(isNotBlankOrNull(pojo.getEg09bj02())){
                queryString.append(" and model.eg09bj02 = ? ");
                binds.add(pojo.getEg09bj02());
            }
            if(isNotBlankOrNull(pojo.getEg09bj03())){
                queryString.append(" and model.eg09bj03 = ? ");
                binds.add(pojo.getEg09bj03());
            }
            if(isNotBlankOrNull(pojo.getEg09bj04())){
                queryString.append(" and model.eg09bj04 = ? ");
                binds.add(pojo.getEg09bj04());
            }
            if(isNotBlankOrNull(pojo.getEg09bj05())){
                queryString.append(" and model.eg09bj05 = ? ");
                binds.add(pojo.getEg09bj05());
            }
            if(isNotBlankOrNull(pojo.getEg09bj06())){
                queryString.append(" and model.eg09bj06 = ? ");
                binds.add(pojo.getEg09bj06());
            }
            if(isNotBlankOrNull(pojo.getEg09bj07())){
                queryString.append(" and model.eg09bj07 = ? ");
                binds.add(pojo.getEg09bj07());
            }
            if(isNotBlankOrNull(pojo.getEg09bj08())){
                queryString.append(" and model.eg09bj08 = ? ");
                binds.add(pojo.getEg09bj08());
            }
            if(isNotBlankOrNull(pojo.getEg09bj09())){
                queryString.append(" and model.eg09bj09 = ? ");
                binds.add(pojo.getEg09bj09());
            }
            if(isNotBlankOrNull(pojo.getEg09bj10())){
                queryString.append(" and model.eg09bj10 = ? ");
                binds.add(pojo.getEg09bj10());
            }
            if(isNotBlankOrNull(pojo.getEg09bj11())){
                queryString.append(" and model.eg09bj11 = ? ");
                binds.add(pojo.getEg09bj11());
            }
            if(isNotBlankOrNull(pojo.getEg09bj12())){
                queryString.append(" and model.eg09bj12 = ? ");
                binds.add(pojo.getEg09bj12());
            }
            if(isNotBlankOrNull(pojo.getEg09bj13())){
                queryString.append(" and model.eg09bj13 = ? ");
                binds.add(pojo.getEg09bj13());
            }
            if(isNotBlankOrNull(pojo.getEg09bj14())){
                queryString.append(" and model.eg09bj14 = ? ");
                binds.add(pojo.getEg09bj14());
            }
            if(isNotBlankOrNull(pojo.getEg09bj15())){
                queryString.append(" and model.eg09bj15 = ? ");
                binds.add(pojo.getEg09bj15());
            }
            if(isNotBlankOrNull(pojo.getEg09bj16())){
                queryString.append(" and model.eg09bj16 = ? ");
                binds.add(pojo.getEg09bj16());
            }
            if(isNotBlankOrNull(pojo.getEg09bj17())){
                queryString.append(" and model.eg09bj17 = ? ");
                binds.add(pojo.getEg09bj17());
            }
            if(isNotBlankOrNull(pojo.getEg09bj18())){
                queryString.append(" and model.eg09bj18 = ? ");
                binds.add(pojo.getEg09bj18());
            }
            if(isNotBlankOrNull(pojo.getEg09bj19())){
                queryString.append(" and model.eg09bj19 = ? ");
                binds.add(pojo.getEg09bj19());
            }
            if(isNotBlankOrNull(pojo.getEg09bj20())){
                queryString.append(" and model.eg09bj20 = ? ");
                binds.add(pojo.getEg09bj20());
            }
            if(isNotBlankOrNull(pojo.getEg09bj21())){
                queryString.append(" and model.eg09bj21 = ? ");
                binds.add(pojo.getEg09bj21());
            }
            if(isNotBlankOrNull(pojo.getEg09bj22())){
                queryString.append(" and model.eg09bj22 = ? ");
                binds.add(pojo.getEg09bj22());
            }
            if(isNotBlankOrNull(pojo.getEg09bj23())){
                queryString.append(" and model.eg09bj23 = ? ");
                binds.add(pojo.getEg09bj23());
            }
            if(isNotBlankOrNull(pojo.getEg09bj24())){
                queryString.append(" and model.eg09bj24 = ? ");
                binds.add(pojo.getEg09bj24());
            }
            if(isNotBlankOrNull(pojo.getEg09bj25())){
                queryString.append(" and model.eg09bj25 = ? ");
                binds.add(pojo.getEg09bj25());
            }
            if(isNotBlankOrNull(pojo.getEg09bj26())){
                queryString.append(" and model.eg09bj26 = ? ");
                binds.add(pojo.getEg09bj26());
            }
            if(isNotBlankOrNull(pojo.getEg09bj27())){
                queryString.append(" and model.eg09bj27 = ? ");
                binds.add(pojo.getEg09bj27());
            }
            if(isNotBlankOrNull(pojo.getEg09bj28())){
                queryString.append(" and model.eg09bj28 = ? ");
                binds.add(pojo.getEg09bj28());
            }
            if(isNotBlankOrNull(pojo.getEg09bj29())){
                queryString.append(" and model.eg09bj29 = ? ");
                binds.add(pojo.getEg09bj29());
            }
            if(isNotBlankOrNull(pojo.getEg09bj30())){
                queryString.append(" and model.eg09bj30 = ? ");
                binds.add(pojo.getEg09bj30());
            }
            if(isNotBlankOrNull(pojo.getEg09bj31())){
                queryString.append(" and model.eg09bj31 = ? ");
                binds.add(pojo.getEg09bj31());
            }
            if(isNotBlankOrNull(pojo.getEg09bj32())){
                queryString.append(" and model.eg09bj32 = ? ");
                binds.add(pojo.getEg09bj32());
            }
            if(isNotBlankOrNull(pojo.getEg09bj33())){
                queryString.append(" and model.eg09bj33 = ? ");
                binds.add(pojo.getEg09bj33());
            }
            if(isNotBlankOrNull(pojo.getEg09bj34())){
                queryString.append(" and model.eg09bj34 = ? ");
                binds.add(pojo.getEg09bj34());
            }
            if(isNotBlankOrNull(pojo.getEg09bj35())){
                queryString.append(" and model.eg09bj35 = ? ");
                binds.add(pojo.getEg09bj35());
            }
            if(isNotBlankOrNull(pojo.getEg09bj36())){
                queryString.append(" and model.eg09bj36 = ? ");
                binds.add(pojo.getEg09bj36());
            }
            if(isNotBlankOrNull(pojo.getEg09bj37())){
                queryString.append(" and model.eg09bj37 = ? ");
                binds.add(pojo.getEg09bj37());
            }
            if(isNotBlankOrNull(pojo.getEg09bj38())){
                queryString.append(" and model.eg09bj38 = ? ");
                binds.add(pojo.getEg09bj38());
            }
            if(isNotBlankOrNull(pojo.getEg10ai01())){
                queryString.append(" and model.eg10ai01 = ? ");
                binds.add(pojo.getEg10ai01());
            }
            if(isNotBlankOrNull(pojo.getEg10ad01())){
                queryString.append(" and model.eg10ad01 = ? ");
                binds.add(pojo.getEg10ad01());
            }
            if(isNotBlankOrNull(pojo.getEg10ai02())){
                queryString.append(" and model.eg10ai02 = ? ");
                binds.add(pojo.getEg10ai02());
            }
            if(isNotBlankOrNull(pojo.getEg10ar01())){
                queryString.append(" and model.eg10ar01 = ? ");
                binds.add(pojo.getEg10ar01());
            }
            if(isNotBlankOrNull(pojo.getEg10ad02())){
                queryString.append(" and model.eg10ad02 = ? ");
                binds.add(pojo.getEg10ad02());
            }
            if(isNotBlankOrNull(pojo.getEg10ad03())){
                queryString.append(" and model.eg10ad03 = ? ");
                binds.add(pojo.getEg10ad03());
            }
            if(isNotBlankOrNull(pojo.getEg10bj01())){
                queryString.append(" and model.eg10bj01 = ? ");
                binds.add(pojo.getEg10bj01());
            }
            if(isNotBlankOrNull(pojo.getEg10bj02())){
                queryString.append(" and model.eg10bj02 = ? ");
                binds.add(pojo.getEg10bj02());
            }
            if(isNotBlankOrNull(pojo.getEg10bj03())){
                queryString.append(" and model.eg10bj03 = ? ");
                binds.add(pojo.getEg10bj03());
            }
            if(isNotBlankOrNull(pojo.getEg10bj04())){
                queryString.append(" and model.eg10bj04 = ? ");
                binds.add(pojo.getEg10bj04());
            }
            if(isNotBlankOrNull(pojo.getEg10bj05())){
                queryString.append(" and model.eg10bj05 = ? ");
                binds.add(pojo.getEg10bj05());
            }
            if(isNotBlankOrNull(pojo.getEg10bj06())){
                queryString.append(" and model.eg10bj06 = ? ");
                binds.add(pojo.getEg10bj06());
            }
            if(isNotBlankOrNull(pojo.getEg10bj07())){
                queryString.append(" and model.eg10bj07 = ? ");
                binds.add(pojo.getEg10bj07());
            }
            if(isNotBlankOrNull(pojo.getEg10bj08())){
                queryString.append(" and model.eg10bj08 = ? ");
                binds.add(pojo.getEg10bj08());
            }
            if(isNotBlankOrNull(pojo.getEg10bj09())){
                queryString.append(" and model.eg10bj09 = ? ");
                binds.add(pojo.getEg10bj09());
            }
            if(isNotBlankOrNull(pojo.getEg10bj10())){
                queryString.append(" and model.eg10bj10 = ? ");
                binds.add(pojo.getEg10bj10());
            }
            if(isNotBlankOrNull(pojo.getEg10bj11())){
                queryString.append(" and model.eg10bj11 = ? ");
                binds.add(pojo.getEg10bj11());
            }
            if(isNotBlankOrNull(pojo.getEg10bj12())){
                queryString.append(" and model.eg10bj12 = ? ");
                binds.add(pojo.getEg10bj12());
            }
            if(isNotBlankOrNull(pojo.getEg10bj13())){
                queryString.append(" and model.eg10bj13 = ? ");
                binds.add(pojo.getEg10bj13());
            }
            if(isNotBlankOrNull(pojo.getEg10bj14())){
                queryString.append(" and model.eg10bj14 = ? ");
                binds.add(pojo.getEg10bj14());
            }
            if(isNotBlankOrNull(pojo.getEg10bj15())){
                queryString.append(" and model.eg10bj15 = ? ");
                binds.add(pojo.getEg10bj15());
            }
            if(isNotBlankOrNull(pojo.getEg10bj16())){
                queryString.append(" and model.eg10bj16 = ? ");
                binds.add(pojo.getEg10bj16());
            }
            if(isNotBlankOrNull(pojo.getEg10bj17())){
                queryString.append(" and model.eg10bj17 = ? ");
                binds.add(pojo.getEg10bj17());
            }
            if(isNotBlankOrNull(pojo.getEg10bj18())){
                queryString.append(" and model.eg10bj18 = ? ");
                binds.add(pojo.getEg10bj18());
            }
            if(isNotBlankOrNull(pojo.getEg10bj19())){
                queryString.append(" and model.eg10bj19 = ? ");
                binds.add(pojo.getEg10bj19());
            }
            if(isNotBlankOrNull(pojo.getEg10bj20())){
                queryString.append(" and model.eg10bj20 = ? ");
                binds.add(pojo.getEg10bj20());
            }
            if(isNotBlankOrNull(pojo.getEg10bj21())){
                queryString.append(" and model.eg10bj21 = ? ");
                binds.add(pojo.getEg10bj21());
            }
            if(isNotBlankOrNull(pojo.getEg10bj22())){
                queryString.append(" and model.eg10bj22 = ? ");
                binds.add(pojo.getEg10bj22());
            }
            if(isNotBlankOrNull(pojo.getEg10bj23())){
                queryString.append(" and model.eg10bj23 = ? ");
                binds.add(pojo.getEg10bj23());
            }
            if(isNotBlankOrNull(pojo.getEg10bj24())){
                queryString.append(" and model.eg10bj24 = ? ");
                binds.add(pojo.getEg10bj24());
            }
            if(isNotBlankOrNull(pojo.getEg10bj25())){
                queryString.append(" and model.eg10bj25 = ? ");
                binds.add(pojo.getEg10bj25());
            }
            if(isNotBlankOrNull(pojo.getRsv1())){
                queryString.append(" and model.rsv1 = ? ");
                binds.add(pojo.getRsv1());
            }
            if(isNotBlankOrNull(pojo.getRsv2())){
                queryString.append(" and model.rsv2 = ? ");
                binds.add(pojo.getRsv2());
            }
            if(isNotBlankOrNull(pojo.getRsv3())){
                queryString.append(" and model.rsv3 = ? ");
                binds.add(pojo.getRsv3());
            }
            if(isNotBlankOrNull(pojo.getRsv4())){
                queryString.append(" and model.rsv4 = ? ");
                binds.add(pojo.getRsv4());
            }
            if(isNotBlankOrNull(pojo.getRsv5())){
                queryString.append(" and model.rsv5 = ? ");
                binds.add(pojo.getRsv5());
            }
            if(isNotBlankOrNull(pojo.getRsv6())){
                queryString.append(" and model.rsv6 = ? ");
                binds.add(pojo.getRsv6());
            }
            if(isNotBlankOrNull(pojo.getRsv7())){
                queryString.append(" and model.rsv7 = ? ");
                binds.add(pojo.getRsv7());
            }
            if(isNotBlankOrNull(pojo.getRsv8())){
                queryString.append(" and model.rsv8 = ? ");
                binds.add(pojo.getRsv8());
            }
            if(isNotBlankOrNull(pojo.getRsv9())){
                queryString.append(" and model.rsv9 = ? ");
                binds.add(pojo.getRsv9());
            }
            if(isNotBlankOrNull(pojo.getRsv10())){
                queryString.append(" and model.rsv10 = ? ");
                binds.add(pojo.getRsv10());
            }
            return (List<CrComEga>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    
    public List<CrComEga> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEga as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEga>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}

