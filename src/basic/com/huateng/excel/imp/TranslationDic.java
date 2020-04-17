package com.huateng.excel.imp;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;

import resource.bean.basic.DataDic;

public class TranslationDic {

    private ROOTDAO rootdao; // Dao层对象
    // 单元格值翻译方法

    public String translationDic(String cellValue, String dicValue) throws CommonException {
        rootdao = ROOTDAOUtils.getROOTDAO();

        if (dicValue != null && dicValue.length() != 0 && cellValue != null && cellValue.length() != 0) {
            // 校验是不是全数字
            String regEx = "^[0-9]+$";
            Pattern pat = Pattern.compile(regEx);
            Matcher mat = pat.matcher(dicValue);
            boolean rs = mat.find();
            if (rs) {
                // 取数据字典表查对应的值
                String hql = "from DataDic where dataTypeNo = '" + dicValue + "' and dataName like '%" + cellValue
                        + "%'";
                DataDic dic = new DataDic();
                List dicList = rootdao.queryByQL2List(hql);

                if (dicList.size() == 0) {
                    // 返回数据字典值不存在
                    throw new CommonException("数据字典值不存在[" + dicValue + "]");
                } else if (dicList.size() > 1) {
                    // 值输入模糊请准确输入
                    throw new CommonException("值输入模糊请准确输入[" + dicValue + "]");
                }
                dic = (DataDic) dicList.get(0);
                cellValue = dic.getDataNo();
                return cellValue;
            } else {
                // 通过表信息翻译部分
                String[] s = dicValue.split("\\.");
                String sql = "select " + s[1] + " from " + s[0] + " where " + s[2] + " like '%" + cellValue + "%'";
                List tableList = rootdao.queryByQL2List(sql);
                cellValue = (String) tableList.get(0);
                return cellValue;
            }
        } else {
            return cellValue;
        }

    }
}
