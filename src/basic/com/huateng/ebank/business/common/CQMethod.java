package com.huateng.ebank.business.common;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.commquery.config.bean.base.ICommonQueryBaseBean;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.exception.HuatengException;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.service.pub.RoleMgrService;

import resource.bean.basic.Bctl;
import resource.bean.basic.BizFuncInfo;
import resource.bean.basic.DataDic;
import resource.bean.basic.TlrInfo;
import resource.dao.basic.BizFuncInfoDAO;

public class CQMethod {
    private static Logger log = Logger.getLogger(CQMethod.class);

    /**
     * get data_dic_name by translated
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getDataDicName(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        String translated = element.getAnyValue("translated");
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(translated) || !translated.startsWith("DATA_DIC.")) {
            return value;
        }
        String dicType = translated.substring(translated.indexOf(".") + 1);
        String dicName = DataDicUtils.getDicName(dicType, value);
        return dicName;
    }

    /**
     * @author Hanziyang
     * @desc getRoleName
     * @date 20100421
     * @return String roleName
     * @throws HuatengException
     */
    public static String getRoleName(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {

        RoleMgrService roleMgrService = RoleMgrService.getInstance();

        if (StringUtils.isEmpty(value)) {
            return "";
        }
        String rolename = null;
        try {
            rolename = roleMgrService.getRoleById(value).getRoleName();
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
        }
        if (StringUtils.isEmpty(rolename)) {
            return value;
        }
        return rolename;
    }

    /**
     *
     * get getUbankName by no
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getUbankNamebyNo(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {

        if (StringUtils.isEmpty(value)) {
            return "";
        }
        String ubankName = null;
        try {
            // ubankName =
            // DAOUtils.getTblEbUnionBankDAO().getUnionBankByNo(value).getUbankName();
        } catch (Exception e) {
        }
        if (StringUtils.isEmpty(ubankName)) {
            return value;
        }
        return ubankName;
    }

    /**
     *
     * get getUbankName by no
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getRMBCapitalMoney(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {

        if (StringUtils.isEmpty(value)) {
            return "";
        }
        return DataFormat.getRMBCapitalMoney(Double.parseDouble(value));
    }

    /** add by junyun.lin 2010-05-20 HTEBANK-10 begin */
    /**
     *
     * 将用string表示的以分为单位的金额字符串转换成以元为单位 如：以分为单位的String a = 2000，转换成 BigDecimal
     * 20.00
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public final static String formatFenToBigDecimal(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        if (value == null || "".equals(value)) {
            return "";
        }
        BigDecimal bigDec = new BigDecimal(value);
        bigDec = bigDec.movePointLeft(2);
        return String.valueOf(bigDec.setScale(2));
    }

    /**
     *
     * get getUbankName by no
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getRMBCapitalformatFenMoney(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {

        if (StringUtils.isEmpty(value)) {
            return "";
        }
        BigDecimal bigDec = new BigDecimal(value);
        bigDec = bigDec.movePointLeft(2);
        value = String.valueOf(bigDec.setScale(2));
        return DataFormat.getRMBCapitalMoney(Double.parseDouble(value));
    }

    /** add by junyun.lin 2010-05-20 HTEBANK-10 end */

    /**
     *
     * 将用string表示的以分为单位的金额字符串转换成以元为单位,带分隔符的 如：以分为单位的String a = 123456，转换成 String
     * 1,234.56
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public final static String formatFenToCurrency(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        if (value == null || "".equals(value)) {
            return "";
        }
        BigDecimal bigDec = new BigDecimal(value);
        bigDec = bigDec.movePointLeft(2);
        bigDec = bigDec.setScale(2);
        return DataFormat.doubleToCurrencyRA(bigDec.doubleValue());
    }

    /**
     *
     * get getBrhName by id
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    /**
    public static String getBrhName(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        if (StringUtils.isEmpty(value)) {
            return value;
        }
        BctlService bctlService = BctlService.getInstance();

        if (StringUtils.isEmpty(value)) {
            return "";
        } else {
//            String brhName = null;
//            try {
//                brhName = bctlService.getBctlByBrcode(value).getBrname();
//            } catch (Exception e) {
//                LogExceptionUtils.logException(log, e);
//            }
            if (StringUtils.isEmpty(value)) {
                return value;
            }
//            if (DataFormat.isEmpty(brhName)) {
//                brhName = "";
//            }
//            return brhName;
        }

    }
    */
    // del by zhaozhiguo
    // /**
    // *
    // * 获取保险公司名称
    // */
    // public static String getInsurer(ICommonQueryBaseBean element, String
    // value,
    // ServletRequest request) throws HuatengException {
    // if (StringUtils.isEmpty(value)) {
    // return "";
    // } else {
    // try {
    // StringBuffer hql = new StringBuffer();
    // hql.append("select po.cname from CustomerInfo po where po.custType = '")
    // .append(SystemConstant.CUST_TYPE_FINANCIAL);
    // hql.append("'");
    // hql.append(" and (po.cname like '").append(value).append("'");
    // hql.append(" or po.custno like '").append(value).append("')");
    //
    // CustomerInfoDAO dao = BaseDAOUtils.getCustomerInfoDAO();
    // CustomerInfo customerInfo = dao.query(value);
    // if(customerInfo != null) {
    // return customerInfo.getCname();
    // } else {
    // return "";
    // }
    //
    // } catch (Exception e) {
    // return "";
    // }
    // }
    //
    // }

    /**
     * 根据外部机构号获取机构名称 机构名称格式为: brname
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getBrnoName(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {

        /*
         * mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 begin BctlService
         * bctlService = BctlService.getInstance(); if
         * (StringUtils.isEmpty(value)) { return ""; } String brname =
         * bctlService.getBranchName(value); if (StringUtils.isEmpty(brname)) {
         * return value; }
         */
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        List l = DAOUtils.getBctlDAO().queryByCondition("po.brno = '" + value + "'");
        if (l == null || l.isEmpty()) {
            // 未查到时返回原来机构代码，不渲染
            return value;
        } else {
            Bctl bctl = (Bctl) l.get(0);
            return bctl.getBrname();
        }
        /* mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 end */
    }

    /**
     * 根据外部机构号获取机构名称 机构名称格式为: brno-brname
     *
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getBrhNameByBrno(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {

        /*
         * mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 begin BctlService
         * bctlService = BctlService.getInstance(); if
         * (StringUtils.isEmpty(value)) { return ""; } String brname =
         * bctlService.getBranchName(value); if (StringUtils.isEmpty(brname)) {
         * return value; }
         */
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        List l = DAOUtils.getBctlDAO().queryByCondition("po.brno = '" + value + "'");
        if (l == null || l.isEmpty()) {
            return "";
        } else {
            Bctl bctl = (Bctl) l.get(0);
            return value + "-" + bctl.getBrname();
        }
        /* mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 end */
    }

    /**
     * 翻译功能码名称
     * 
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getBizFuncNameById(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        if (StringUtils.isEmpty(value)) {
            return "";
        } else {
            try {
                BizFuncInfoDAO dao = BaseDAOUtils.getBizFuncInfoDAO();
                List list = dao.queryByCondition(" po.id = '" + value + "'");
                if (list != null && list.size() > 0) {
                    BizFuncInfo info = (BizFuncInfo) list.get(0);
                    return info.getBizFuncName();
                } else {
                    return value;
                }

            } catch (Exception e) {
                LogExceptionUtils.logException(log, e);
                return value;
            }
        }

    }

    /**
     * 翻译操作员名称
     * 
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getTlrNameById(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        if (StringUtils.isEmpty(value)) {
            return "";
        } else {
            try {
                String tlrName = "";
                TlrInfo info = DAOUtils.getTlrInfoDAO().queryById(value);
                if (info != null) {
                    tlrName = info.getTlrName();
                }
                return tlrName;

            } catch (Exception e) {
                LogExceptionUtils.logException(log, e);
                return value;
            }
        }

    }

    public static String getTreeCodeName(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        String headNodeNo = element.getAnyValue("headnodeno");
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(headNodeNo)) {
            return value;
        }
        DataDicService dataDicService = DataDicService.getInstance();
        Map<String, String> map = new HashMap<String, String>();
        dataDicService.getDataTreeNoName(headNodeNo, value, map);
        if (!map.containsKey(value)) {
            return value;
        } else {
            return map.get(value);
        }
    }

    public static String getTreeCodeNameByNavition(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        String headNodeNo = "23";
        if (StringUtils.isEmpty(value)) {
            return value;
        }
        String[] strs = value.split(",");
        if (strs.length != 2) {
            return value;
        }
        if (strs[0].equals("CHN")) {
            headNodeNo = "16";
        }
        DataDicService dataDicService = DataDicService.getInstance();
        Map<String, String> map = new HashMap<String, String>();
        dataDicService.getDataTreeNoName(headNodeNo, strs[1], map);
        if (!map.containsKey(strs[1])) {
            return strs[1];
        } else {
            return map.get(strs[1]);
        }
    }

    /**
     *
     * @Description: 根据币种英文简称 查询对应的中文名称
     * @author yang_hui
     * @Created 2013-3-8
     * @param element
     * @param value
     * @param request
     * @return
     * @throws HuatengException
     */
    public static String getMoneyKindName(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        if (StringUtils.isEmpty(value)) {
            return StringUtils.EMPTY;
        }
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List list = rootdao.queryByQL2List(" FROM DataDic WHERE dataNo = '" + value + "'");
        if (list == null || list.isEmpty()) {
            return "";
        } else {
            DataDic dataDic = (DataDic) list.get(0);
            return dataDic.getDataName();
        }
    }

    public static String getTodayDate() throws HuatengException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = sdf.format(date);
        return todayDate;
    }

    /** add by zhangdianchao 20160229 format string14 to time start */
    public static String format2Time(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        if (StringUtils.isEmpty(value)) {
            return value;
        }
        Date date = null;
        String str = null;
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss").parse(value);
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            return value;
        }
        return str;
    }

    public static String getTlrName(ICommonQueryBaseBean element, String value, ServletRequest request)
            throws HuatengException {
        if (StringUtils.isEmpty(value)) {
            return value;
        }
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        TlrInfo tlr = null;
        String tlrName = null;
        try {
            List<TlrInfo> list = rootdao
                    .queryByCondition("select t from TlrInfo t where 1=1 and t.tlrno = '" + value + "'");
            tlr = (TlrInfo) list.get(0);
            tlrName = tlr.getTlrName();
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            return value;
        }
        return tlrName;
    }

}
