package com.huateng.ebank.business.management.service;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;

import resource.bean.basic.Bctl;
import resource.bean.basic.SysTaskInfo;

/*
 * 
 * author by jixiang  
 */
public class branchManageDetailService {

    public static Bctl selectById(String id) {
        {
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            Bctl bctl = null;
            try {

                bctl = (Bctl) rootdao.query(Bctl.class, id);

            } catch (CommonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return bctl;
        }

    }

    // author by 计翔 2012.9.5 序列化对象写入taskinfo表
    public static void addTosystaskinfo(SysTaskInfo systackinfo) {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        try {
            rootDAO.saveOrUpdate(systackinfo);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void addEntity(Bctl bctl) {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        try {
            rootDAO.saveOrUpdate(bctl);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}