package com.huateng.ebank.business.common;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.LogExceptionUtils;

import resource.bean.basic.FunctionInfo;
import resource.dao.basic.FunctionInfoDAO;

public class CommonFunctions {

    private static Logger log = Logger.getLogger(CommonFunctions.class);

    public static CommonFunctions getInstance() {
        return new CommonFunctions();
    }

    public static Date getEndDateByDays(Date startDate, int days) {
        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(startDate);
        calendarStartDate.add(6, days);

        return calendarStartDate.getTime();
    }

    public static StringBuffer getFunction(List<FunctionInfo> lst) throws CommonException {
        StringBuffer sb = new StringBuffer();
        Iterator it = lst.iterator();
        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            sb.append("\"");
            sb.append(f.getId());
            sb.append("|");
            sb.append(f.getLastdirectory());
            sb.append("|");
            if (f.getIsdirectory().intValue() == 1) {
                sb.append(f.getFuncname());
            } else {
                String fullpath = getFullPath(f.getId());
                sb.append("<input type='checkbox' id='id" + f.getId() + "' name='id' height='14pt' value='" + fullpath
                        + "'>" + f.getFuncname() + "</input>");
            }
            sb.append("\"");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }

    public static List<String> getFunctionList(List<FunctionInfo> lst) throws CommonException {
        Iterator it = lst.iterator();
        List<String> result = new ArrayList<String>();
        Map ht = transToHashtableByFunc(lst);

        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            StringBuffer sb = new StringBuffer();

            sb.append(f.getId().trim());
            sb.append("|");
            sb.append(f.getLastdirectory());
            sb.append("|");
            if (f.getIsdirectory().intValue() == 1) {
                sb.append(f.getFuncname().trim());
            } else {
                String fullpath = getFullPathByAllFuncList(f.getId().trim(), ht);
                sb.append("<input type='checkbox' id='id" + f.getId().trim() + "' name='id' height='14pt' value='"
                        + fullpath + "'>" + f.getFuncname().trim() + "</input>");
            }

            result.add(sb.toString());
        }
        return result;
    }

    public static List<String> getFunctionListCompar(List<FunctionInfo> lst) throws CommonException {
        Iterator it = lst.iterator();
        List<String> result = new ArrayList<String>();
        Map ht = transToHashtableByFunc(lst);

        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            StringBuffer sb = new StringBuffer();

            sb.append(f.getId().trim());
            sb.append("|");
            sb.append(f.getLastdirectory());
            sb.append("|");
            if (f.getIsdirectory().intValue() == 1) {
                sb.append(f.getFuncname().trim());
            } else {
                String fullpath = getFullPathByAllFuncList(f.getId().trim(), ht);
                sb.append("<input type='checkbox' id='id" + f.getId().trim() + "' name='id' height='14pt' value='"
                        + fullpath + "'>" + f.getFuncname().trim() + "</input>");
            }

            result.add(sb.toString());
        }
        return result;
    }

    public static String converDate8TO101(String date8) {
        if ((date8 != null) && (date8.length() == 8)) {
            String sYear = date8.substring(0, 4);
            String sMonth = date8.substring(4, 6);
            String sDay = date8.substring(6);
            return sYear + "-" + sMonth + "-" + sDay;
        }
        return date8;
    }

    public static String converDate12TO8(String data12) {
        if ((data12 != null) && (data12.length() == 12)) {
            String sYear = data12.substring(0, 4);
            String sMonth = data12.substring(5, 7);
            String sDay = data12.substring(8);
            return sYear + sMonth + sDay;
        }
        return data12;
    }

    public static String converStringTOTime(String time) {
        if ((time != null) && (time.length() == 6)) {
            String hh = time.substring(0, 2);
            String mi = time.substring(2, 4);
            String ss = time.substring(4);
            return hh + ":" + mi + ":" + ss;
        }
        return time;
    }

    public static final String formatLoaclAmt6ReqAmt(BigDecimal bigDec) {
        if (bigDec == null)
            return null;
        DecimalFormat formatter = new DecimalFormat("###############0.000000");
        return formatter.format(bigDec);
    }

    public static String getCurrDate() {
        String currentDate = null;

        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        currentDate = formater.format(new Date());
        return currentDate;
    }

    public static StringBuffer getRoleFunction(int iRoot, List lst, int iloc) throws CommonException {
        GlobalInfo global = GlobalInfo.getCurrentInstance();
        String sPath = global.getSContextPath();
        StringBuffer sb = new StringBuffer();
        Iterator it = lst.iterator();

        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            if ((f.getLastdirectory().equals(String.valueOf(iRoot))) && (f.getLocation().intValue() == iloc)) {
                String functionName = MessageResourceUtil.getBasicMessage("FUN." + f.getId().trim(), true, null);
                if ((functionName == null) || (!MessageResourceUtil.isIl8n())) {
                    functionName = f.getFuncname();
                }
                if (f.getIsdirectory().intValue() == 1) {
                    sb.append("0,'");
                    sb.append(
                            functionName + "','" + f.getId().trim() + "','" + functionName + "','','',4,'','','',-1,");
                    sb.append(getRoleFunction(Integer.parseInt(f.getId().trim()), lst, iloc));
                    sb.append("1,");
                    if (iRoot == 0)
                        sb.append("5,");
                } else {
                    sb.append("2,'" + functionName + "','" + f.getId().trim() + "','" + functionName + "','',3,'','"
                            + sPath + f.getPagepath() + "','',");
                }
            }
        }

        return sb;
    }

    public static StringBuffer getAdminRoleFunction(int iRoot, List lst, int iloc) throws CommonException {
        String sPath = "";
        StringBuffer sb = new StringBuffer();
        Iterator it = lst.iterator();
        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            if ((f.getLastdirectory().equals(String.valueOf(iRoot))) && (f.getLocation().intValue() == iloc)) {
                if (f.getIsdirectory().intValue() == 1) {
                    sb.append("0,'");
                    sb.append(f.getFuncname() + "','" + f.getFuncname() + "','" + f.getFuncname()
                            + "','','',4,'','','',-1,");
                    sb.append(getAdminRoleFunction(Integer.parseInt(f.getId()), lst, iloc));
                    sb.append("1,");
                    if (iRoot == 0)
                        sb.append("5,");
                } else {
                    sb.append("2,'" + f.getFuncname() + "','" + f.getFuncname() + "','" + f.getFuncname()
                            + "','',3,'','" + sPath + f.getPagepath() + "','',");
                }
            }
        }
        return sb;
    }

    public static StringBuffer getSvaeFolder(List lst) throws CommonException {
        StringBuffer sb = new StringBuffer();
        sb.append("0,'收藏夹','收藏夹','收藏夹','','',4,'','','',-1,");
        Iterator it = lst.iterator();
        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            sb.append("2,'" + f.getFuncname() + "','" + f.getId() + "','" + f.getFuncname() + "','',3,'','"
                    + f.getPagepath() + "','',");
        }
        sb.append("1,5,");
        return sb;
    }

    public static Map transToHashtableByFunc(List lst) {
        Map<String, FunctionInfo> mp = Collections.synchronizedMap(new LinkedHashMap<String, FunctionInfo>());
        Iterator it = lst.iterator();
        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            mp.put(f.getId().trim(), f);
        }
        return mp;
    }

    public static List getAllFuncList() {
        String str = "from FunctionInfo func";
        List list;
        try {
            list = getFunctionList(BaseDAOUtils.getHQLDAO().queryByQL2List(str));
        } catch (CommonException e) {
            LogExceptionUtils.logException(log, e);
            return new ArrayList();
        }

        return list;
    }

    public static Hashtable transToHashtableByFuncAdmin(List lst) {
        Hashtable<String, FunctionInfo> ht = new Hashtable<String, FunctionInfo>();
        Iterator it = lst.iterator();
        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            ht.put(f.getId(), f);
        }
        return ht;
    }

    public static String getFullPathByAllFuncList(String fid, Map ht) {
    	
        if (ht == null) {
            ht = transToHashtableByFunc(getAllFuncList());
        }

        FunctionInfo f = (FunctionInfo) ht.get(fid);
        if (f != null) {
            if (f.getLastdirectory().equals("0")) {
                return f.getId().trim();
            }
            return getFullPathByAllFuncList(f.getLastdirectory().toString().trim(), ht).trim() + "," + f.getId().trim();
        }

        return "";
    }

    public static String getFullPathByAllFuncListCompar(String fid, Map ht) {
        if (ht == null) {
            ht = transToHashtableByFunc(getAllFuncList());
        }

        FunctionInfo f = (FunctionInfo) ht.get(fid);
        if (f != null) {
            if (f.getLastdirectory().equals("0")) {
                return f.getId().trim();
            }
            return getFullPathByAllFuncListCompar(f.getLastdirectory().toString().trim(), ht).trim() + ","
                    + f.getId().trim();
        }

        return "";
    }

    public static String getFullPath(String fid) throws CommonException {
        GlobalInfo global = GlobalInfo.getCurrentInstance();
        Map ht = global.getAllFunctions();

        FunctionInfo f = (FunctionInfo) ht.get(fid);
        if (f != null) {
            System.out.println(fid + "-Lastdirectory=" + f.getLastdirectory());
            if (f.getLastdirectory().equals("0")) {
                return f.getId().trim();
            }
            return getFullPath(f.getLastdirectory().toString().trim()) + "," + f.getId().trim();
        }
        System.out.println(fid + "is null");
        return "";
    }

    public static int[] getAmountEveryNum(String sValue) {
        double amount = Double.parseDouble(sValue);
        if ((amount > 99999999999999.984D) || (amount < -99999999999999.984D))
            throw new IllegalArgumentException("参数值超出允许范围 (-99999999999999.99 ～ 99999999999999.99)！");
        long longvalue = Math.round(amount * 100.0D);
        int[] iResult = new int[10];
        for (int i = 0; i < 10; ++i) {
            iResult[i] = ((int) longvalue % 10);
            longvalue /= 10L;
        }
        return iResult;
    }

    public static String commonFillDefault(String sValue, int iType) throws CommonException {
        if (iType == SystemConstant.TYPE_STRING) {
            if ((sValue == null) || (sValue.equals(""))) {
                return " ";
            }
            return sValue;
        }

        if (iType == SystemConstant.TYPE_DATE) {
            if ((sValue == null) || (sValue.equals(""))) {
                return " ";
            }
            sValue = sValue.replace("-", "");
            sValue = sValue.replace("/", "");
            return sValue;
        }

        if (iType == SystemConstant.TYPE_AMOUNT) {
            if ((sValue == null) || (sValue.equals(""))) {
                return "0";
            }
            sValue = sValue.replace(",", "");
            if (sValue.indexOf("%") != -1) {
                sValue = sValue.replace("%", "");
                double amount = Double.parseDouble(sValue);
                sValue = String.valueOf(amount);
            }
            return sValue;
        }

        return " ";
    }

    public static final BigDecimal formatFenToBigDecimal(String a) {
        BigDecimal bigDec = new BigDecimal(a);
        bigDec = bigDec.movePointLeft(2);
        return bigDec.setScale(2);
    }

    public static final String formatBigDecimalToFen(BigDecimal bigDec) {
        if (bigDec.compareTo(new BigDecimal(0)) == 0) {
            return "00";
        }
        bigDec = bigDec.movePointRight(2);
        String str = bigDec.toString();
        return str;
    }

    public static final String formatLoalRate2ReqRate(BigDecimal bigDec) throws CommonException {
        if (bigDec == null)
            return null;
        DecimalFormat formatter = new DecimalFormat("0.000000");
        return formatter.format(bigDec);
    }

    public static final String formatLoaclAmt2ReqAmt(BigDecimal bigDec) throws CommonException {
        if (bigDec == null)
            return null;
        DecimalFormat formatter = new DecimalFormat("###############0.##");
        return formatter.format(bigDec);
    }

    public static final String formatAmt2ReqAmt(BigDecimal bigDec) throws CommonException {
        if (bigDec == null)
            return null;
        DecimalFormat formatter = new DecimalFormat("###,###,###,###,###,###,##0.00");
        return formatter.format(bigDec);
    }

    public static final String formatLoaclAmt2ReqAmt100(BigDecimal bigDec) throws CommonException {
        return formatLoaclAmt2ReqAmt(bigDec.multiply(new BigDecimal(100)));
    }

    public static final BigDecimal formatReqAmt2LoaclAmt100(BigDecimal bigDec) throws CommonException {
        return bigDec.divide(new BigDecimal(100));
    }

    public static List<String> getFunctionListAdmin(List<FunctionInfo> lst) throws CommonException {
        Iterator it = lst.iterator();
        List<String> result = new ArrayList<String>();
        while (it.hasNext()) {
            FunctionInfo f = (FunctionInfo) it.next();
            StringBuffer sb = new StringBuffer();

            sb.append(f.getId());
            sb.append("|");
            sb.append(f.getLastdirectory());
            sb.append("|");
            if (f.getIsdirectory().intValue() == 1) {
                sb.append(f.getFuncname());
            } else {
                String fullpath = getFullPathAdmin(f.getId());
                sb.append("<input type='checkbox' id='id" + f.getId() + "' name='id' height='14pt' value='" + fullpath
                        + "'>" + f.getFuncname() + "</input>");
            }

            result.add(sb.toString());
        }
        return result;
    }

    public static String getFullPathAdmin(String fid) throws CommonException {
        Map ht = transToHashtableByFunc(getAllFunctions(0));
        FunctionInfo f = (FunctionInfo) ht.get(fid);
        if (f.getLastdirectory().equals("0")) {
            return f.getId().toString();
        }
        return getFullPathAdmin(f.getLastdirectory()) + "," + f.getId().toString();
    }

    public static List getAllFunctions(int uid) throws CommonException {
        FunctionInfoDAO fdao = BaseDAOUtils.getFunctionInfoDAO();
        return fdao.findAll();
    }

    public static void mkDir(String path) {
        File dirFile = new File(path);
        if ((dirFile.isDirectory()) && (dirFile.exists()))
            return;
        try {
            FileUtils.forceMkdir(dirFile);
        } catch (IOException ioex) {
            throw new RuntimeException("create unmatch info diractory : [" + path + "] error", ioex);
        }
    }

    public static List<MenuFunction> getMenuFunctionList(Map funcMap) {
        List<MenuFunction> list = new ArrayList<MenuFunction>();
        Iterator it = funcMap.values().iterator();
        while (it.hasNext()) {
            FunctionInfo fi = (FunctionInfo) it.next();
            if ((fi.getLastdirectory() == null) || (fi.getLastdirectory().equals("0"))) {
                MenuFunction mf = new MenuFunction();
                mf.setMenuLevel(1);
                mf.setFunction(fi);

                getSubMenuFunctionList(funcMap, mf);
                list.add(mf);
            }
        }
        return list;
    }

    private static void getSubMenuFunctionList(Map funcMap, MenuFunction mf) {
        Iterator it = funcMap.values().iterator();
        while (it.hasNext()) {
            FunctionInfo subfun = (FunctionInfo) it.next();

            if ((!mf.getFunction().getId().trim().equals("1008"))
                    && (mf.getFunction().getId().trim().equals(subfun.getLastdirectory().toString()))) {
                MenuFunction subMf = new MenuFunction();
                subMf.setMenuLevel(mf.getMenuLevel() + 1);
                subMf.setFunction(subfun);
                mf.getSubMenuList().add(subMf);
                getSubMenuFunctionList(funcMap, subMf);
            }
        }
    }

    public static String createSubMenu(FunctionInfo func, List<FunctionInfo> allFuncList) throws CommonException {
        int width = 280;
        StringBuffer subMenu = new StringBuffer();
        subMenu.append("<div iconCls='" + func.getIconCls() + "' title='" + func.getFuncname() + "' >");
        subMenu.append("<span>" + func.getFuncname() + "</span>");
        subMenu.append("<div style='width:" + width + "px;'>");
        List<FunctionInfo> list = getSubFunction(func.getId(), allFuncList);
        for (FunctionInfo sub : list) {
            if (sub.getIsdirectory().intValue() != 1) {
                String clickEvent = "";
                if (StringUtils.isNotBlank(sub.getPagepath())) {
                    clickEvent = "onclick=\"doWork('" + sub.getId() + "','" + sub.getFuncname() + "','"
                            + sub.getPagepath() + "');\"";
                }
                subMenu.append("<div iconCls='" + sub.getIconCls() + "' title='" + sub.getFuncname() + "' " + clickEvent
                        + ">");
                subMenu.append(sub.getFuncname());
                subMenu.append("</div>");
            } else {
                subMenu.append(createSubMenu(sub, allFuncList));
            }
        }
        subMenu.append("</div>");
        subMenu.append("</div>");
        return subMenu.toString();

    }

    public static String createMenu(HttpSession session) throws CommonException {
        log.info("start to create menu " + session.getId());
        GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        GlobalInfo.setCurrentInstance(globalInfo);

        String reqtype = globalInfo.getMenuCode();
        List<FunctionInfo> allFuncList = getAllFunction(globalInfo.getTlrno());
        List<FunctionInfo> funcList = getSubFunction(reqtype, allFuncList);

        StringBuffer menuBar = new StringBuffer();

        for (int i = 0; i < funcList.size(); ++i) {
            FunctionInfo fi = (FunctionInfo) funcList.get(i);
            menuBar.append("<a id='mb" + fi.getId() + "' href='javascript:void(0)' menu='#mm" + fi.getId()
                    + "' class='easyui-menubutton' iconCls='" + fi.getIconCls() + "' duration='0'>" + fi.getFuncname()
                    + "</a>");

            if (fi.getIsdirectory().intValue() != 1) {
                continue;
            }
            try {
                int width = 280;
                StringBuffer menuDiv = new StringBuffer();
                menuDiv.append("<div id='mm" + fi.getId() + "' MENU_ITEM style='width:" + width + "px;' iconCls='"
                        + fi.getIconCls() + "'>");
                List<FunctionInfo> subList = getSubFunction(fi.getId(), allFuncList);
                for (FunctionInfo sub : subList) {
                    if (sub.getIsdirectory().intValue() != 1) {
                        String clickEvent = "";
                        if (StringUtils.isNotBlank(sub.getPagepath())) {
                            clickEvent = "onclick=\"doWork('" + sub.getId() + "','" + sub.getFuncname() + "','"
                                    + sub.getPagepath() + "');\"";
                        }
                        menuDiv.append("<div iconCls='" + sub.getIconCls() + "' title='" + sub.getFuncname() + "' "
                                + clickEvent + ">");
                        menuDiv.append(sub.getFuncname());
                        menuDiv.append("</div>");
                    } else {
                        String subMenu = createSubMenu(sub, allFuncList);
                        menuDiv.append(subMenu);
                    }
                }
                menuDiv.append("</div>");
                menuBar.append(menuDiv);
            } catch (Exception e) {
                LogExceptionUtils.logException(log, e);
                e.printStackTrace();
            }

        }
        log.info("create menu complete " + session.getId());
        return menuBar.toString();
    }

    public static List<FunctionInfo> getSubFunction(String funcId, List<FunctionInfo> allFunctionList)
            throws CommonException {
        List<FunctionInfo> subList = new ArrayList<FunctionInfo>();
        for (FunctionInfo func : allFunctionList) {
            if (StringUtils.equalsIgnoreCase(funcId, func.getLastdirectory())) {
                subList.add(func);
            }
        }
        return subList;
    }

    public static List<FunctionInfo> getAllFunction(String tlrNo) throws CommonException {
        log.info("getAllFunction tlrNo = " + tlrNo );
        try {
            HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
            StringBuffer sb = new StringBuffer();
            sb.append("select distinct func from ").append("TlrRoleRel tr,RoleFuncRel rr,FunctionInfo func ")
                    .append("where tr.roleId=rr.roleId and rr.funcid=func.id ").append("and tr.tlrno= ? ");
            sb.append(" and func.funcDesc!='INVISIBLE' ");
            sb.append(" and tr.roleId in ( select id from RoleInfo ) ");
            sb.append(" order by func.showseq");
            List<FunctionInfo> list = hqlDAO.queryByQL2List(sb.toString(), new String[] { tlrNo }, null);
            log.info("getAllFunction return " + list.size());
            return list;
        } catch (CommonException e) {
            log.error("getSubFunction(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_INFO_INVALID);
            return null;
        }
    }

    private static StringBuffer getSubDiv(FunctionInfo fi, String reqtype) throws CommonException {
        int width = 280;
        StringBuffer menuDiv = new StringBuffer();
        if (fi.getLastdirectory().equals(reqtype)) {
            menuDiv.append("<div id='mm" + fi.getId() + "' MENU_ITEM style='width:" + width + "px;' iconCls='"
                    + fi.getIconCls() + "'>");
            List<FunctionInfo> list = DAOUtils.getHQLDAO().queryByQL2List(
                    "from FunctionInfo po where po.lastdirectory=" + fi.getId() + " order by po.showseq");
            for (FunctionInfo fi2 : list) {
                menuDiv.append(getSubDiv(fi2, reqtype));
            }
            menuDiv.append("</div>");
            return menuDiv;
        }
        String clickEvent = "";
        if (fi.getPagepath() != null) {
            clickEvent = "onclick=\"doWork('" + fi.getId() + "','" + fi.getFuncname() + "','" + fi.getPagepath()
                    + "');\"";
        }
        menuDiv.append("<div iconCls='" + fi.getIconCls() + "' title='" + fi.getFuncname() + "' " + clickEvent + ">");
        List<FunctionInfo> list = DAOUtils.getHQLDAO()
                .queryByQL2List("from FunctionInfo po where po.lastdirectory=" + fi.getId() + " order by po.showseq");
        if ((fi.getIsdirectory().intValue() == 1) && (!list.isEmpty())) {
            StringBuffer subDiv = new StringBuffer();
            for (FunctionInfo fi2 : list) {
                subDiv.append(getSubDiv(fi2, reqtype));
            }
            if ((subDiv.length() == 0) || ("1008".equals(fi.getId()))) {
                menuDiv.append(fi.getFuncname());
            } else {
                menuDiv.append("<span>" + fi.getFuncname() + "</span>");
                menuDiv.append("<div style='width:" + width + "px;'>");
                menuDiv.append(subDiv);
                menuDiv.append("</div>");
            }
        } else {
            menuDiv.append(fi.getFuncname());
        }
        menuDiv.append("</div>");
        return menuDiv;
    }

    private static StringBuffer getSubDiv2(FunctionInfo fi, String reqtype, String tlrno) throws CommonException {
        int width = 280;
        StringBuffer menuDiv = new StringBuffer();
        if (fi.getLastdirectory().equals(reqtype)) {
            menuDiv.append("<div id='mm" + fi.getId() + "' MENU_ITEM style='width:" + width + "px;' iconCls='"
                    + fi.getIconCls() + "'>");

            StringBuffer sb = new StringBuffer();
            sb.append("select distinct func from ").append("TlrRoleRel tr,RoleFuncRel rr,FunctionInfo func ")
                    .append("where tr.roleId=rr.roleId and rr.funcid=func.id ").append(" and tr.tlrno= ? ")
                    .append(" and func.lastdirectory= ? ").append(" order by func.showseq");

            List<FunctionInfo> list = DAOUtils.getHQLDAO().queryByQL2List(sb.toString(),
                    new String[] { tlrno, fi.getId() }, null);
            for (FunctionInfo fi2 : list) {
                menuDiv.append(getSubDiv2(fi2, reqtype, tlrno));
            }
            menuDiv.append("</div>");
            return menuDiv;
        }
        String clickEvent = "";
        if (fi.getPagepath() != null) {
            clickEvent = "onclick=\"doWork('" + fi.getId() + "','" + fi.getFuncname() + "','" + fi.getPagepath()
                    + "');\"";
        }
        menuDiv.append("<div iconCls='" + fi.getIconCls() + "' title='" + fi.getFuncname() + "' " + clickEvent + ">");
        // List<FunctionInfo> list = DAOUtils.getHQLDAO().queryByQL2List("from
        // FunctionInfo po where po.lastdirectory=" + fi.getId() + " order by
        // po.showseq");
        StringBuffer sb = new StringBuffer();
        sb.append("select distinct func from ").append("TlrRoleRel tr,RoleFuncRel rr,FunctionInfo func ")
                .append("where tr.roleId=rr.roleId and rr.funcid=func.id ").append(" and tr.tlrno= ?")
                .append(" and func.lastdirectory= ? ").append(" order by func.showseq");
        List<FunctionInfo> list = DAOUtils.getHQLDAO().queryByQL2List(sb.toString(), new String[] { tlrno, fi.getId() },
                null);
        if ((fi.getIsdirectory().intValue() == 1) && (!list.isEmpty())) {
            StringBuffer subDiv = new StringBuffer();
            for (FunctionInfo fi2 : list) {
                subDiv.append(getSubDiv2(fi2, reqtype, tlrno));
            }
            if ((subDiv.length() == 0) || ("1008".equals(fi.getId()))) {
                menuDiv.append(fi.getFuncname());
            } else {
                menuDiv.append("<span>" + fi.getFuncname() + "</span>");
                menuDiv.append("<div style='width:" + width + "px;'>");
                menuDiv.append(subDiv);
                menuDiv.append("</div>");
            }
        } else {
            menuDiv.append(fi.getFuncname());
        }
        menuDiv.append("</div>");
        return menuDiv;
    }

    public static String getCurrent19Time() {

        String current19Time = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        current19Time = format.format(new Date());

        return current19Time;
    }

}