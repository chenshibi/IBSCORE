package com.huateng.boa.tools;

import org.apache.commons.lang.StringUtils;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class GenDetailFrontPage {

    public static String filepath = System.getProperty("user.dir") + File.separator + "src"  + File.separator + "boa"+ File.separator + "java"
            + File.separator + "com" + File.separator + "huateng" + File.separator + "boa" + File.separator + "tools"
            + File.separator + "code" + File.separator;

    public static LinkedHashMap<String, String> condMap = new LinkedHashMap<String, String>();
    public static LinkedHashMap<String, String> viewMap = new LinkedHashMap<String, String>();
    public static LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();

    public static String XML_HEAD_LINE_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n";
    public static String XML_HEAD_LINE_2 = "<CommQry title=\"${title}\" type=\"call\" interface=\"true\" navigate=\"\"  pagesize=\"10\"\n";
    public static String XML_HEAD_LINE_3 = "    async=\"true\" databusid=\"\" transdataactionurl=\"/trans/TransDataAction.do\"\n";
    public static String XML_HEAD_LINE_4 = "    getterclassname=\"com.huateng.${module}.getter.${getterclassname}\">\n\n";
    public static String XML_HEAD_LINE_5 = "    <Include id=\"BankParam\" />\n\n";
    public static String XML_HEAD_LINE_6 = "    <PageQryExp type=\"XLS\" limit=\"true\" encoding=\"UTF-8\" url=\"/trans/qryExp.do\" desc=\"数据导出--${title}\"  />\n\n";

    public static String XML_HEAD_LINE_7 = "    <Fields>\n";
    public static String XML_HEAD_LINE_8 = "    </Fields>\n\n";
    public static String XML_HEAD_LINE_9 = "    <Where>\n";
    public static String XML_HEAD_LINE_10 = "    </Where>\n\n";
    public static String XML_HEAD_LINE_11 = "</CommQry>\n\n";

    public static String FTL_HEAD_LINE_1 = "<#import \"/templets/commonQuery/CommonQueryTagMacro.ftl\" as CommonQueryMacro>\n";
    public static String FTL_HEAD_LINE_2 = "<#import \"/templets/ui18n.ftl\" as ui18n />\n";
    public static String FTL_HEAD_LINE_3 = "<@CommonQueryMacro.page title=\"${title}\">\n";
    public static String FTL_HEAD_LINE_7 = "<@CommonQueryMacro.CommonQuery id=\"${getterclassname}\" init=\"true\" submitMode=\"current\">\n";
    public static String FTL_HEAD_LINE_8 = "    <table width=\"100%\"  class=\"grouptable\">\n";

    public static String FTL_HEAD_LINE_20 = "       <tr>\n";
    public static String FTL_HEAD_LINE_21 = "           <td></td>\n";
    public static String FTL_HEAD_LINE_22 = "           <td align=\"right\"><@CommonQueryMacro.Button id= \"btClose\"/></td>\n";
    public static String FTL_HEAD_LINE_23 = "           <td></td>\n";
    public static String FTL_HEAD_LINE_24 = "           <td></td>\n";
    public static String FTL_HEAD_LINE_27 = "       </tr>\n";
    public static String FTL_HEAD_LINE_28 = "   </table>\n";
    public static String FTL_HEAD_LINE_29 = "</@CommonQueryMacro.CommonQuery>\n";

    public static String FTL_HEAD_LINE_33 = "<script language=\"JavaScript\">\n";
    public static String FTL_HEAD_LINE_3A = "    function btClose_onClickCheck(button){\n";
    public static String FTL_HEAD_LINE_3B = "        unloadPageWindows(\"partWin\");\n";
    public static String FTL_HEAD_LINE_3C = "        return false;\n";
    public static String FTL_HEAD_LINE_3D = "    }\n";
    public static String FTL_HEAD_LINE_3E = "\n";

    public static String FTL_HEAD_LINE_34 = "</script>\n";
    public static String FTL_HEAD_LINE_35 = "</@CommonQueryMacro.page>\n";

    public static String JAVA_HEAD_LINE_1 = "package com.huateng.${module}.getter;\n\n";
    public static String JAVA_HEAD_LINE_2 = "import java.util.ArrayList;\nimport org.apache.commons.lang.StringUtils;\n";
    public static String JAVA_HEAD_LINE_3 = "import com.huateng.common.err.Module;\n";
    public static String JAVA_HEAD_LINE_4 = "import com.huateng.common.err.Rescode;\n";
    public static String JAVA_HEAD_LINE_5 = "import com.huateng.commquery.result.Result;\n";
    public static String JAVA_HEAD_LINE_6 = "import com.huateng.commquery.result.ResultMng;\n";
    public static String JAVA_HEAD_LINE_7 = "import com.huateng.ebank.business.common.PageQueryResult;\n";
    public static String JAVA_HEAD_LINE_8 = "\n";
    public static String JAVA_HEAD_LINE_9 = "import com.huateng.ebank.business.common.ROOTDAOUtils;\n";
    public static String JAVA_HEAD_LINE_10 = "import com.huateng.ebank.framework.web.commQuery.BaseGetter;\n";
    public static String JAVA_HEAD_LINE_11 = "import com.huateng.exception.AppException;\n\n";

    public static String JAVA_HEAD_LINE_12 = "public class ${getterclassname} extends BaseGetter {\n";
    public static String JAVA_HEAD_LINE_13 = "    public Result call() throws AppException {\n";
    public static String JAVA_HEAD_LINE_14 = "        try {\n";
    public static String JAVA_HEAD_LINE_15 = "            PageQueryResult pageResult = getData();\n";
    public static String JAVA_HEAD_LINE_16 = "            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());\n";
    public static String JAVA_HEAD_LINE_17 = "            result.setContent(pageResult.getQueryResult());\n";
    public static String JAVA_HEAD_LINE_18 = "            result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));\n";
    public static String JAVA_HEAD_LINE_19 = "            result.init();\n";
    public static String JAVA_HEAD_LINE_20 = "            result.setTotal(pageResult.getTotalCount());\n";
    public static String JAVA_HEAD_LINE_21 = "            return result;\n";
    public static String JAVA_HEAD_LINE_22 = "        } catch (AppException appEx) {\n";
    public static String JAVA_HEAD_LINE_23 = "            throw appEx;\n";
    public static String JAVA_HEAD_LINE_24 = "        } catch (Exception ex) {\n";
    public static String JAVA_HEAD_LINE_25 = "            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);\n";
    public static String JAVA_HEAD_LINE_26 = "        }\n";
    public static String JAVA_HEAD_LINE_27 = "    }\n\n";

    public static String JAVA_HEAD_LINE_28 = "    protected PageQueryResult getData() throws Exception {\n";
    public static String JAVA_HEAD_LINE_29 = "        PageQueryResult queryResult = new PageQueryResult();\n";
    public static String JAVA_HEAD_LINE_29_1 = "        PageQueryCondition queryCondition = new PageQueryCondition();\n";
    public static String JAVA_HEAD_LINE_29_2 = "        int pageSize = getResult().getPage().getEveryPage();\n";
    public static String JAVA_HEAD_LINE_29_3 = "        int pageIndex = getResult().getPage().getCurrentPage();\n";
    public static String JAVA_HEAD_LINE_30 = "        queryCondition.setPageIndex(pageIndex);\n";
    public static String JAVA_HEAD_LINE_30_1 = "        queryCondition.setPageSize(pageSize);\n";
    public static String JAVA_HEAD_LINE_31 = "        ArrayList<String> condList = new ArrayList<String>();\n";
    public static String JAVA_HEAD_LINE_32 = "        StringBuffer hql = new StringBuffer();\n";
    public static String JAVA_HEAD_LINE_33 = "\n";

    public static String JAVA_HEAD_LINE_34 = "        queryCondition.setObjArray(condList.toArray());\n";
    public static String JAVA_HEAD_LINE_35 = "        queryCondition.setQueryString(hql.toString());\n";
    public static String JAVA_HEAD_LINE_36 = "        queryResult = ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);\n";
    public static String JAVA_HEAD_LINE_37 = "        return queryResult;\n";
    public static String JAVA_HEAD_LINE_38 = "    }\n";
    public static String JAVA_HEAD_LINE_39 = "}\n";

    public static String getGetterClassName(ArrayList<String> addTableList) {
        StringBuffer sb = new StringBuffer();
        for (String table : addTableList) {
            sb.append(ColumnItem.getClassName(table));
        }
        sb.append("QueryDetailGetter");
        return sb.toString();
    }

    public static String upperFirst(String str) {
        if (str == null) {
            return "";
        }
        str = str.trim();
        if (str.length() <= 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }

        return String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static String getFieldName(String name) {
        String words[] = name.split("_");
        StringBuffer sb = new StringBuffer();
        boolean firstLower = true;
        for (String word : words) {
            if (firstLower) {
                sb.append(word.toLowerCase());
                firstLower = false;
            } else {
                sb.append(upperFirst(word));
            }
        }

        return sb.toString();
    }

    public static String getJavaName(String name) {
        String words[] = name.split("_");
        StringBuffer sb = new StringBuffer();
        boolean firstLower = true;
        for (String word : words) {
            if (firstLower) {
                sb.append(word.toLowerCase());
                firstLower = false;
            } else {
                sb.append(upperFirst(word));
            }
        }

        return sb.toString();
    }

    public static String getJavaName(String tableName, String columnName) {

        ArrayList<ColumnItem> list = ParseSQL.hibernateMap.get(tableName);
        if (list == null) {
            return getJavaName(columnName);
        } else {
            for (ColumnItem item : list) {
                if (StringUtils.endsWithIgnoreCase(item.getName(), columnName)) {
                    return item.getJavaVarName();
                }
            }
        }
        return getJavaName(columnName);
    }

    public static String getJavaType(String tableName, String columnName) {

        ArrayList<ColumnItem> list = ParseSQL.hibernateMap.get(tableName);
        if (list == null) {
            return getJavaName(columnName);
        } else {
            for (ColumnItem item : list) {
                if (StringUtils.endsWithIgnoreCase(item.getName(), columnName)) {
                    return item.getJavaType();
                }
            }
        }
        return getJavaName(columnName);
    }

    public static String getJavaTableName(String tableName) {

        TableItem item = ParseSQL.tableInfo.get(tableName);
        if (item == null) {
            return tableName;
        } else {
            return item.getClassname();
        }
    }

    public static String genSQL(String title, String module, DefaultTableModel tableTable,
                                ArrayList<String> addTableList, String baseWhere) throws Exception {
        StringBuffer sb = new StringBuffer();

        String selectSQL = "select new com.huateng.${module}.getter.${getterclassname}View( ".replace("${module}", module).replace("${getterclassname}", getGetterClassName(addTableList));
        String condSQL = " \nwhere 0 = 0 ";
        for (int i = 0; i < tableTable.getRowCount(); i++) {
            // "表名", "列名", "列描述", "查询条件", "条件类型", "结果列表", "明细页面", "edittype",
            // "datatype", "length", "translated"
            String tableName = tableTable.getValueAt(i, 0).toString().trim();
            String columnName = tableTable.getValueAt(i, 1).toString();
            String fieldName = getFieldName(
                    tableTable.getValueAt(i, 0).toString() + "_" + tableTable.getValueAt(i, 1).toString());
            String fieldDesc = (tableTable.getValueAt(i, 2).toString());
            String inWhere = (tableTable.getValueAt(i, 3).toString());
            String whereType = (tableTable.getValueAt(i, 4).toString());
            String inResult = (tableTable.getValueAt(i, 5).toString());
            String inDetail = (tableTable.getValueAt(i, 6).toString());
            String editType = (tableTable.getValueAt(i, 7).toString());
            String dataType = (tableTable.getValueAt(i, 8).toString());
            String len = (tableTable.getValueAt(i, 9).toString());
            String dropType = (tableTable.getValueAt(i, 10).toString());
            String isKey = (tableTable.getValueAt(i, 11).toString());

            if (StringUtils.equalsIgnoreCase(inDetail, "true")) {
                selectSQL = selectSQL + " tbl_" + tableName + "." + getJavaName(tableName, columnName) + " as " + fieldName + ",\n";

                viewMap.put(fieldName, getJavaType(tableName, columnName));
            }

            if (StringUtils.equalsIgnoreCase(isKey, "true")) {
                String cond = " and tbl_" + tableName + "." + getJavaName(tableName, columnName) + " = ? ";
                condMap.put(fieldName, cond);
            }

        }

        if (selectSQL.endsWith(",\n")) {
            selectSQL = selectSQL.substring(0, selectSQL.length() - 2);
            selectSQL = selectSQL + " \n";
        }
        selectSQL = selectSQL + ") ";

        String fromSQL = " from ";
        for (String table : addTableList) {
            fromSQL = fromSQL + " " + getJavaTableName(table) + " tbl_" + table + ",";
        }
        if (fromSQL.endsWith(",")) {
            fromSQL = fromSQL.substring(0, fromSQL.length() - 1);
        }
        fromSQL = fromSQL + " ";

        String baseW = " and ";
        if (StringUtils.isNotBlank(baseWhere)) {
            String bases[] = baseWhere.split(" ");
            for (String base : bases) {
                String strs[] = base.split("\\.");
                if (strs.length == 2) {
                    String tmpTab = strs[0];
                    String tmpCol = strs[1];
                    baseW = baseW + " tbl_" + tmpTab + "." + getJavaName(tmpTab, tmpCol);
                } else {
                    baseW = baseW + " " + base + " ";
                }
            }
        } else {
            baseW = " ";
        }

        String sql = selectSQL + fromSQL + " \nwhere 0 = 0 \n" + baseW;

        return sql;

    }

    public static void genXmlFile(String title, String module, DefaultTableModel tableTable,
                                  ArrayList<String> addTableList) throws Exception {
        String filename = filepath + getGetterClassName(addTableList) + ".xml";

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file, false);
        out.write(XML_HEAD_LINE_1.getBytes("UTF-8"));
        out.write(XML_HEAD_LINE_2.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(XML_HEAD_LINE_3.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(XML_HEAD_LINE_4.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(XML_HEAD_LINE_5.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(XML_HEAD_LINE_6.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(XML_HEAD_LINE_7.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));


        for (int i = 0; i < tableTable.getRowCount(); i++) {
            // "表名", "列名", "列描述", "查询条件", "条件类型", "结果列表", "明细页面", "edittype",
            // "datatype", "length", "translated"
            String tableNmae = tableTable.getValueAt(i, 0).toString();
            String fieldName = getFieldName(
                    tableTable.getValueAt(i, 0).toString() + "_" + tableTable.getValueAt(i, 1).toString());
            String fieldDesc = (tableTable.getValueAt(i, 2).toString());
            String inWhere = (tableTable.getValueAt(i, 3).toString());
            String whereType = (tableTable.getValueAt(i, 4).toString());
            String inResult = (tableTable.getValueAt(i, 5).toString());
            String inDetail = (tableTable.getValueAt(i, 6).toString());
            String editType = (tableTable.getValueAt(i, 7).toString());
            String dataType = (tableTable.getValueAt(i, 8).toString());
            String len = (tableTable.getValueAt(i, 9).toString());
            String dropType = (tableTable.getValueAt(i, 10).toString());

            String translated = "";
            if (StringUtils.isNotBlank(dropType)) {
                translated = " translated=\"" + dropType + "\" ";
            }
            String lenStr = "";
            if (StringUtils.endsWithIgnoreCase(len, "0") == false) {
                translated = " size=\"" + len + "\" ";
            }
            if (StringUtils.endsWithIgnoreCase(inDetail, "true")) {
                out.write(("        <Field id=\"" + fieldName + "\" desc=\"" + fieldDesc + "\" edittype=\"" + editType
                        + "\" status=\"F\" datatype=\"" + dataType + "\" readonly=\"true\" xpath=\"/"
                        + getJavaName(tableNmae, fieldName) + "\" " + lenStr + translated + " width=\"95%\"/> \n")
                        .getBytes("UTF-8"));


                fieldMap.put(fieldName, fieldDesc);
            }
        }

        out.write(XML_HEAD_LINE_8.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(XML_HEAD_LINE_9.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));

        int index = 1;
        for (int i = 0; i < tableTable.getRowCount(); i++) {
            // "表名", "列名", "列描述", "查询条件", "条件类型", "结果列表", "明细页面", "edittype",
            // "datatype", "length", "translated"
            String fieldName = getFieldName(
                    tableTable.getValueAt(i, 0).toString() + "_" + tableTable.getValueAt(i, 1).toString());
            String fieldDesc = (tableTable.getValueAt(i, 2).toString());
            String inWhere = (tableTable.getValueAt(i, 3).toString());
            String whereType = (tableTable.getValueAt(i, 4).toString());
            String inResult = (tableTable.getValueAt(i, 5).toString());
            String inDetail = (tableTable.getValueAt(i, 6).toString());
            String editType = (tableTable.getValueAt(i, 7).toString());
            String dataType = (tableTable.getValueAt(i, 8).toString());
            String len = (tableTable.getValueAt(i, 9).toString());
            String dropType = (tableTable.getValueAt(i, 10).toString());
            String isKey = (tableTable.getValueAt(i, 11).toString());

            if (StringUtils.equalsIgnoreCase(isKey, "true")) {
                out.write(("        <TextBox id=\"query" + fieldName + "\" require=\"false\" " + " desc=\""
                        + fieldDesc + "\" datatype=\"" + dataType + "\" index=\"" + index + "\" " + " size=\""
                        + len + "\"" + "/>\n").getBytes("UTF-8"));
                index++;
            }
        }
        out.write(XML_HEAD_LINE_10.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));


        out.write(("    <Operations>\n"
                + "        <Button id=\"btClose\" name=\"btClose\" desc=\"返回\" operation=\"syncsubmit\" url=\"#\" txn=\"\" />\n"
                + "    </Operations>\n\n").getBytes("UTF-8"));


        out.write(XML_HEAD_LINE_11.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.close();
    }

    public static void genFtlFile(String title, String module, DefaultTableModel tableTable,
                                  ArrayList<String> addTableList) throws Exception {
        String filename = filepath + getGetterClassName(addTableList) + ".ftl";

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        String fieldStr = "";
        for (int i = 0; i < tableTable.getRowCount(); i++) {
            // "表名", "列名", "列描述", "查询条件", "条件类型", "结果列表", "明细页面", "edittype",
            // "datatype", "length", "translated"
            String fieldName = getFieldName(
                    tableTable.getValueAt(i, 0).toString() + "_" + tableTable.getValueAt(i, 1).toString());
            String inDetail = (tableTable.getValueAt(i, 6).toString());
            if (StringUtils.equalsIgnoreCase(inDetail, "true")) {
                fieldStr = fieldStr + "," + fieldName;
            }

        }
        if (fieldStr.startsWith(",")) {
            fieldStr = fieldStr.substring(1);
        }

        FileOutputStream out = new FileOutputStream(file, false);
        out.write(FTL_HEAD_LINE_1.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_2.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_3.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_7.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_8.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));

        int i = 0;
        boolean hasEnd = false;
        for (String field : fieldMap.keySet()) {

            if (i % 2 == 0) {
                out.write(("        <tr>\n").getBytes("UTF-8"));
                hasEnd = false;
            }
            out.write(("            <td align=\"center\" nowrap class=\"labeltd\" width=\"25%\">" + fieldMap.get(field) + "</td>\n").getBytes("UTF-8"));
            out.write(("            <td class=\"datatd\" width=\"25%\"><@CommonQueryMacro.SingleField fId=\"" + field + "\"/></td>\n").getBytes("UTF-8"));
            if ((i + 1) % 2 == 0) {
                out.write(("        </tr>\n").getBytes("UTF-8"));
                hasEnd = true;
            }
            i++;
        }
        if (!hasEnd) {
            out.write(("        </tr>\n").getBytes("UTF-8"));
        }


        out.write(FTL_HEAD_LINE_20.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_21.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_22.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_23.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_24.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_27.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_28.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_29.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));

        out.write(FTL_HEAD_LINE_33.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_3A.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_3B.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_3C.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_3D.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_3E.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_34.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(FTL_HEAD_LINE_35.replace("${title}", title).replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));

        out.close();
    }

    public static String genPOJOFunc(String var, String type) {
        StringBuffer sb = new StringBuffer();
        sb.append("    public ");
        sb.append(type + " get" + upperFirst(var) + "(){");
        sb.append("\n");
        sb.append("    ");
        sb.append("    ");
        sb.append("return " + var + ";");
        sb.append("\n");
        sb.append("    ");
        sb.append("}\n");

        sb.append("    public void ");
        sb.append("set" + upperFirst(var) + "(" + type + " " + var + "){");
        sb.append("\n");
        sb.append("    ");
        sb.append("    ");
        sb.append("this." + var + " = " + var + ";");
        sb.append("\n");
        sb.append("    ");
        sb.append("}\n\n");
        return sb.toString();
    }

    public static void genGetterViewClass(String title, String module, DefaultTableModel tableTable,
                                          ArrayList<String> addTableList, String baseWhere) throws Exception {
        String filename = filepath + getGetterClassName(addTableList) + "View.java";

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file, false);

        out.write(JAVA_HEAD_LINE_1.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write("public class ${getterclassname}View {\n\n".replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write("    private static final long serialVersionUID = 1L;\n".getBytes("UTF-8"));

        for (String var : viewMap.keySet()) {
            out.write(("    " + "java.lang.Object" + " " + var + ";\n").getBytes("UTF-8"));
        }

        out.write("\n".getBytes("UTF-8"));

        out.write(("    public ${getterclassname}View(\n").replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        StringBuffer sb = new StringBuffer();
        for (String var : viewMap.keySet()) {
            sb.append("                    " + "java.lang.Object" + " " + var + ",\n");
        }
        String conSQL = sb.toString();
        if (conSQL.endsWith(",\n")) {
            conSQL = conSQL.substring(0, conSQL.length() - 2);
            conSQL = conSQL + "){ \n";
        }
        out.write(conSQL.getBytes("UTF-8"));
        StringBuffer sb1 = new StringBuffer();

        for (String var : viewMap.keySet()) {
            sb1.append("        this." + var + " = " + var + ";\n");
        }

        out.write(sb1.toString().getBytes("UTF-8"));

        out.write("    }\n\n".getBytes("UTF-8"));


        for (String var : viewMap.keySet()) {
            out.write((genPOJOFunc(var, "java.lang.Object")).getBytes("UTF-8"));
            out.write("\n".getBytes("UTF-8"));
        }


        out.write("}\n".getBytes("UTF-8"));

        out.close();
    }

    public static void genGetterClass(String title, String module, DefaultTableModel tableTable,
                                      ArrayList<String> addTableList, String baseWhere) throws Exception {
        String filename = filepath + getGetterClassName(addTableList) + ".java";

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file, false);
        out.write(JAVA_HEAD_LINE_1.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_2.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_3.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_4.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_5.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_6.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_7.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write("import com.huateng.ebank.business.common.PageQueryCondition;\n".getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_8.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_9.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_10.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_11.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_12.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_13.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_14.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_15.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_16.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_17.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_18.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_19.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_20.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_21.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_22.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_23.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_24.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_25.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_26.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_27.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_28.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_29.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_29_1.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_29_2.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_29_3.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_30.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_30_1.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_31.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_32.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_33.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));

        String sql = genSQL(title, module, tableTable, addTableList, baseWhere);

        String[] lines = sql.split("\n");
        for (String line : lines) {
            sql = "        hql.append(\"" + line + "\");\n";
            out.write(sql.getBytes("UTF-8"));
        }

        for (String key : condMap.keySet()) {
            String line1 = "        String query" + key + " = (String) getCommQueryServletRequest().getParameterMap().get(\"query"
                    + key + "\");\n";
            String line2 = "        if(StringUtils.isNotBlank(query" + key + ")){ \n";
            String line3 = "             hql.append(\"" + condMap.get(key) + "\");\n";
            String line4 = "             condList.add(query" + key + ");\n";
            String line5 = "        }\n";
            out.write(line1.getBytes("UTF-8"));
            out.write(line2.getBytes("UTF-8"));
            out.write(line3.getBytes("UTF-8"));
            out.write(line4.getBytes("UTF-8"));
            out.write(line5.getBytes("UTF-8"));
        }

        out.write(JAVA_HEAD_LINE_34.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_35.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_36.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_37.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_38.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));
        out.write(JAVA_HEAD_LINE_39.replace("${module}", module)
                .replace("${getterclassname}", getGetterClassName(addTableList)).getBytes("UTF-8"));

        out.close();
    }

    public static void genFrontPage(String title, String module, DefaultTableModel tableTable,
                                    ArrayList<String> addTableList, String baseWhere) throws Exception {
        condMap.clear();
        viewMap.clear();

        genXmlFile(title, module, tableTable, addTableList);
        genFtlFile(title, module, tableTable, addTableList);
        genGetterClass(title, module, tableTable, addTableList, baseWhere);
        genGetterViewClass(title, module, tableTable, addTableList, baseWhere);
    }

    public static void main(String[] args) {
        String bases[] = " BCTL.BRNO =   TLR_INFO.BRCODE   ".split("\n");
        for (String base : bases) {
            System.out.println(base);
        }

        // String str = " BCTL.BRNO = TLR_INFO.BRCODE,";
        // str = str.substring(0, str.length() - 1);
        // System.out.println(str);
    }
}
