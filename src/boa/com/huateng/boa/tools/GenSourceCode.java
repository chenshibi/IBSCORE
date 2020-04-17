package com.huateng.boa.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 源代码生成类，代码会生成在此文件所在的目录中
 * 
 * @author YiSiliang
 * 
 * 
 *         目前只支持单主键的表 可以生成如下文件： 1.hibernate映射xml文件 2.POJO基类 3.POJO类 4.DAO类
 *         计划增加生成flowpower的ftl文件、xml文件和getter类
 */

public class GenSourceCode {

    /**
     * 表所在的数据库
     */
      public static String dbDriver = "oracle.jdbc.driver.OracleDriver";
   //  public static String dbUrl = "jdbc:oracle:thin:@192.168.1.160:16521:xe";
   //  public static String dbDriver="net.sourceforge.jtds.jdbc.Driver";
      public static String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
      public static String dbUser = "CRMS_DEV";
      public static String dbPwd = "CRMS_DEV";
//    public static String dbUrl = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=bureauibs";
//    public static String dbUser = "gk";
//    public static String dbPwd = "bureau";

    public static String table;
    public static String module;
    public static String classname;
    public static String filepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "boa"
            + File.separator + "com" + File.separator + "huateng" + File.separator + "boa" + File.separator + "tools"
            + File.separator + "code" + File.separator;
    
    public static String daoPath="D:\\eclipseWorkspace\\IBSCORE\\src\\basic\\com\\huateng\\report\\dao\\";
    
    public static String fileHbmPath="D:\\eclipseWorkspace\\IBSCORE\\src\\resource\\hbm\\crms\\";
    
    public static String basePojoPath="D:\\eclipseWorkspace\\IBSCORE\\src\\basic\\resource\\bean\\crms\\base\\";
    
    public static String pojoPath="D:\\eclipseWorkspace\\IBSCORE\\src\\basic\\resource\\bean\\crms\\";

    public static List<ColumnItem> colList = new ArrayList<ColumnItem>();
    public static List<String> keyList = new ArrayList<String>();

    public static String HBM_HEAD_LINE_1 = "<?xml version=\"1.0\"?>\n";
    public static String HBM_HEAD_LINE_2 = "<!DOCTYPE hibernate-mapping PUBLIC\n";
    public static String HBM_HEAD_LINE_3 = "    \"-//Hibernate/Hibernate Mapping DTD//EN\"\n";
    public static String HBM_HEAD_LINE_4 = "    \"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd\" >\n";
    public static String HBM_HEAD_LINE_5 = "\n\n";
   // public static String HBM_HEAD_LINE_6 = "<hibernate-mapping package=\"resource.bean.${module}\">\n";
    public static String HBM_HEAD_LINE_6 = "<hibernate-mapping package=\"resource.bean.crms\">\n";
    // public static String HBM_HEAD_LINE_7 = " <class name=\"Cxcl\"
    // table=\"CICS_cxcl\">";
    public static String HBM_HEAD_LINE_8 = "        <meta attribute=\"sync-DAO\">false</meta>\n";

    public static String HBM_TAIL_LINE_1 = "    </class>\n";
    public static String HBM_TAIL_LINE_2 = "</hibernate-mapping>\n";

    public static void usage() {
        System.out.println("usage : Module Table");
    }

    public static void main(String[] args) throws Exception {
       if (getColumnList(args) == false) {
            return;
        }
        genHBM();
        genBasePOJO();
        genPOJO();
        genDAO();
    }

    public static boolean getColumnList(String[] args) throws Exception {
      /*  if (args.length != 2) {
            usage();
            return false;
        }*/

      /*  module = args[0].toLowerCase();
        table = args[1].toUpperCase();*/
    	module="IBSCORE_BatchQuery_Log";
    	table="IBSCORE_BatchQuery_Log";
        classname = ColumnItem.getClassName(table);

        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);

        String ind_sql = "select COLUMN_NAME from user_ind_columns where index_name =( "
                + "select index_name from user_indexes where table_type = 'TABLE' "
                + " and table_name = ? and uniqueness = 'UNIQUE' and rownum = 1)";
        PreparedStatement ind_state = conn.prepareStatement(ind_sql);
        ind_state.setString(1, table);
        ResultSet ind_rs = ind_state.executeQuery();
        while (ind_rs.next()) {
            String key = ind_rs.getString("COLUMN_NAME");
            keyList.add(key);
        }

        ind_rs.close();
        ind_state.close();

        String col_sql = "SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH, DATA_PRECISION, DATA_SCALE, CHAR_LENGTH, NULLABLE"
                + " FROM SYS.USER_TAB_COLUMNS where table_name = ? ORDER BY COLUMN_ID ASC";
        PreparedStatement state = conn.prepareStatement(col_sql);
        state.setString(1, table);
        ResultSet rs = state.executeQuery();
        while (rs.next()) {
            ColumnItem item = new ColumnItem();
            String COLUMN_NAME = rs.getString("COLUMN_NAME");
            String DATA_TYPE = rs.getString("DATA_TYPE");
            String NULLABLE = rs.getString("NULLABLE");
            int DATA_LENGTH = rs.getInt("DATA_LENGTH");
            int DATA_PRECISION = rs.getInt("DATA_PRECISION");
            int DATA_SCALE = rs.getInt("DATA_SCALE");
            int CHAR_LENGTH = rs.getInt("CHAR_LENGTH");

            if ("Y".equalsIgnoreCase(NULLABLE)) {
                item.setCannull(true);
            } else {
                item.setCannull(false);
            }

            item.setData_precision(DATA_PRECISION);
            item.setData_scale(DATA_SCALE);
            item.setType(DATA_TYPE);
            if ("java.lang.String".equalsIgnoreCase(item.getJavaType())) {
                item.setLen(CHAR_LENGTH);
            } else {
                item.setLen(DATA_LENGTH);
            }
            item.setName(COLUMN_NAME);

            if (keyList.contains(COLUMN_NAME)) {
                item.setKey(true);
            } else {
                item.setKey(false);
            }

            colList.add(item);
        }
        rs.close();
        state.close();
        return true;

    }

    public static void genHBM() throws Exception {

        String filename = fileHbmPath + classname + ".hbm.xml";

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file, false);
        out.write(HBM_HEAD_LINE_1.getBytes("UTF-8"));
        out.write(HBM_HEAD_LINE_2.getBytes("UTF-8"));
        out.write(HBM_HEAD_LINE_3.getBytes("UTF-8"));
        out.write(HBM_HEAD_LINE_4.getBytes("UTF-8"));
        out.write(HBM_HEAD_LINE_5.getBytes("UTF-8"));
        String HBM_HEAD_LINE_6_TMP = HBM_HEAD_LINE_6.replace("${module}", module);
        out.write(HBM_HEAD_LINE_6_TMP.getBytes("UTF-8"));
        String HBM_HEAD_LINE_7 = "    <class name=\"" + classname + "\" table=\"" + table + "\" >\n";
        out.write(HBM_HEAD_LINE_7.getBytes("UTF-8"));
        out.write(HBM_HEAD_LINE_8.getBytes("UTF-8"));

        for (ColumnItem item : colList) {
            String str = item.genHBM();
            out.write(str.getBytes("UTF-8"));
        }
        out.write(HBM_TAIL_LINE_1.getBytes("UTF-8"));
        out.write(HBM_TAIL_LINE_2.getBytes("UTF-8"));
        out.close();
    }

    public static void genBasePOJO() throws Exception {

        String filename = basePojoPath + "Base" + ColumnItem.getClassName(table) + ".java";

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file, false);
    //    out.write("package resource.bean.${module}.base;\n\n".replace("${module}", module).getBytes("UTF-8"));
         out.write("package resource.bean.crms.base;\n".getBytes("UTF-8"));
    //    out.write("package com.huateng.report.entity;\n\n".replace("${module}", module).getBytes("UTF-8"));
        out.write("import java.io.Serializable;\n\n".getBytes("UTF-8"));
        out.write("public abstract class Base${classname} implements Serializable {\n\n"
                .replace("${classname}", classname).getBytes("UTF-8"));

        out.write("\n".getBytes("UTF-8"));
        out.write("    private static final long serialVersionUID = 1L;\n".getBytes("UTF-8"));
        out.write("\n".getBytes("UTF-8"));

        out.write("\n".getBytes("UTF-8"));
        for (ColumnItem item : colList) {
            String str = item.genPOJODef();
            out.write(str.getBytes("UTF-8"));
        }
        out.write("\n".getBytes("UTF-8"));

        out.write("\n".getBytes("UTF-8"));
        for (ColumnItem item : colList) {
            String str = item.genPOJOFunc();
            out.write(str.getBytes("UTF-8"));
        }
        out.write("\n".getBytes("UTF-8"));

        out.write("    public String toString(){\n".getBytes("UTF-8"));
        out.write("        StringBuffer sb = new StringBuffer();\n".getBytes("UTF-8"));
        for (ColumnItem item : colList) {
            String str = item.genToString();
            out.write(str.getBytes("UTF-8"));
        }
        out.write("        return sb.toString();\n".getBytes("UTF-8"));
        out.write("    }\n\n".getBytes("UTF-8"));

        out.write("}\n\n".getBytes("UTF-8"));

        out.close();
    }

    public static void genPOJO() throws Exception {

        String filename = pojoPath + ColumnItem.getClassName(table) + ".java";

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file, false);
      //  out.write("package resource.bean.${module};\n\n".replace("${module}", module).getBytes("UTF-8"));
        out.write("package resource.bean.crms;\n".getBytes("UTF-8"));
      //  out.write("package com.huateng.report.entity;\n\n".replace("${module}", module).getBytes("UTF-8"));
        out.write("import resource.bean.crms.base.Base${classname};\n\n".replace("${module}", module)
                .replace("${classname}", classname).getBytes("UTF-8"));
        out.write("public class ${classname} extends Base${classname} {\n\n".replace("${classname}", classname)
                .getBytes("UTF-8"));
        out.write("    private static final long serialVersionUID = 1L;\n\n"
                .getBytes("UTF-8"));
        out.write("}\n\n".getBytes("UTF-8"));

        out.close();
    }

    public static void genDAO() throws Exception {

        String filename = daoPath + ColumnItem.getClassName(table) + "DAO.java";

        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(file, false);
      //  out.write("package resource.dao.${module};\n\n".replace("${module}", module).getBytes("UTF-8"));
        out.write("package com.huateng.report.dao;\n".getBytes("UTF-8"));
        out.write("import java.util.List;\n".getBytes("UTF-8"));
        out.write("import java.util.ArrayList;\n\n".getBytes("UTF-8"));

        out.write("import org.apache.commons.lang.StringUtils;\n".getBytes("UTF-8"));
        out.write("import org.apache.log4j.Logger;\n".getBytes("UTF-8"));
        out.write("import org.springframework.orm.hibernate3.support.HibernateDaoSupport;\n\n".getBytes("UTF-8"));

       /* out.write("import resource.bean.${module}.${classname};\n\n".replace("${module}", module)
                .replace("${classname}", classname).getBytes("UTF-8"));*/
        
        out.write("import resource.bean.${module};\n\n".replace("${module}", module).getBytes("UTF-8"));


    //    out.write("import com.huateng.report.entity.${module};\n".getBytes("UTF-8"));
        out.write("public class ${classname}DAO extends HibernateDaoSupport {\n\n".replace("${classname}", classname)
                .getBytes("UTF-8"));

        out.write("    private static final Logger log = Logger.getLogger(${classname}DAO.class);\n\n"
                .replace("${classname}", classname).getBytes("UTF-8"));

        /**
         * update
         */
        out.write("    public void update(${classname} pojo) {\n".replace("${classname}", classname).getBytes("UTF-8"));
        out.write("        log.info(\"update pojo instance with id: \" + pojo.getId());\n".getBytes("UTF-8"));
        out.write("        try {\n".getBytes("UTF-8"));
        out.write("            this.getHibernateTemplate().update(pojo);\n".getBytes("UTF-8"));
        out.write("            log.info(\"update successful \" + pojo.toString());\n".getBytes("UTF-8"));
        out.write("        } catch (RuntimeException re) {\n".getBytes("UTF-8"));
        out.write("            log.error(\"update failed\", re);\n".getBytes("UTF-8"));
        out.write("            throw re;\n".getBytes("UTF-8"));
        out.write("        }\n".getBytes("UTF-8"));
        out.write("    }\n".getBytes("UTF-8"));
        out.write("\n".getBytes("UTF-8"));

        /**
         * save
         */
        out.write("    public void save(${classname} pojo) {\n".replace("${classname}", classname).getBytes("UTF-8"));
        out.write("        log.info(\"save pojo instance with id: \" + pojo.getId());\n".getBytes("UTF-8"));
        out.write("        try {\n".getBytes("UTF-8"));
        out.write("        	this.getHibernateTemplate().save(pojo);\n".getBytes("UTF-8"));
        out.write("            log.info(\"save successful \" + pojo.toString());\n".getBytes("UTF-8"));
        out.write("        } catch (RuntimeException re) {\n".getBytes("UTF-8"));
        out.write("            log.error(\"save failed\", re);\n".getBytes("UTF-8"));
        out.write("            throw re;\n".getBytes("UTF-8"));
        out.write("        }\n".getBytes("UTF-8"));
        out.write("    }\n".getBytes("UTF-8"));
        out.write("\n".getBytes("UTF-8"));
        /**
         * delete
         */
        out.write("    public void delete(${classname} pojo) {\n".replace("${classname}", classname).getBytes("UTF-8"));
        out.write("        log.info(\"delete pojo instance with id: \" + pojo.getId());\n".getBytes("UTF-8"));
        out.write("        try {\n".getBytes("UTF-8"));
        out.write("            this.getHibernateTemplate().delete(pojo);\n".getBytes("UTF-8"));
        out.write("            log.info(\"delete successful \" + pojo.toString());\n".getBytes("UTF-8"));
        out.write("        } catch (RuntimeException re) {\n".getBytes("UTF-8"));
        out.write("            log.error(\"delete failed\", re);\n".getBytes("UTF-8"));
        out.write("            throw re;\n".getBytes("UTF-8"));
        out.write("        }\n".getBytes("UTF-8"));
        out.write("    }\n".getBytes("UTF-8"));
        out.write("\n".getBytes("UTF-8"));

        /**
         * findById
         */
        String idType = null;
        for (ColumnItem item : colList) {
            if (item.isKey()) {
                idType = item.getJavaType();
                break;
            }
        }
        if (idType == null) {
            idType = "java.lang.String";
        }

        out.write("    public ${classname} findById(${id_type} id) {\n".replace("${classname}", classname)
                .replace("${id_type}", idType).getBytes("UTF-8"));
        out.write("        log.info(\"getting pojo instance with id: \" + id);\n".getBytes("UTF-8"));
        out.write("        try {\n".getBytes("UTF-8"));
        out.write("            return (${classname})this.getHibernateTemplate().get(${classname}.class, id);\n"
                .replace("${classname}", classname).getBytes("UTF-8"));
        out.write("        } catch (RuntimeException re) {\n".getBytes("UTF-8"));
        out.write("            log.error(\"get failed\", re);\n".getBytes("UTF-8"));
        out.write("            throw re;\n".getBytes("UTF-8"));
        out.write("        }\n".getBytes("UTF-8"));
        out.write("    }\n".getBytes("UTF-8"));
        out.write("\n".getBytes("UTF-8"));

        /**
         * isNotBlankOrNull
         */
        out.write("    public boolean isNotBlankOrNull(Object o){\n".getBytes("UTF-8"));
        out.write("        if(o == null){\n".getBytes("UTF-8"));
        out.write("            return false;\n".getBytes("UTF-8"));
        out.write("        }\n".getBytes("UTF-8"));
        out.write("        if(o instanceof java.lang.String){\n".getBytes("UTF-8"));
        out.write("            return StringUtils.isNotBlank((String) o);\n".getBytes("UTF-8"));
        out.write("        }\n".getBytes("UTF-8"));
        out.write("        else {\n".getBytes("UTF-8"));
        out.write("            return true;\n".getBytes("UTF-8"));
        out.write("        }\n".getBytes("UTF-8"));
        out.write("    }\n".getBytes("UTF-8"));
        out.write("\n".getBytes("UTF-8"));

        /**
         * findByProperties
         */
        out.write("    public List<${classname}> findByProperties(${classname} pojo) {\n"
                .replace("${classname}", classname).getBytes("UTF-8"));
        out.write(
                "        log.info(\"finding pojo instance with properties: \" + pojo.toString());\n".getBytes("UTF-8"));
        out.write("        try {\n".getBytes("UTF-8"));
        out.write("            StringBuffer queryString = new StringBuffer();\n".getBytes("UTF-8"));
        out.write("            queryString.append(\"from ${classname} as model where 0= 0 \");\n"
                .replace("${classname}", classname).getBytes("UTF-8"));
        out.write("            List<Object> binds = new ArrayList<Object>();\n".getBytes("UTF-8"));

        for (ColumnItem item : colList) {
            out.write(("            if(isNotBlankOrNull(pojo.get" + item.getFuncName() + "())){\n").getBytes("UTF-8"));
            out.write(("                queryString.append(\" and model." + item.getJavaName() + " = ? \");\n")
                    .getBytes("UTF-8"));
            out.write(("                binds.add(pojo.get" + item.getFuncName() + "());\n").getBytes("UTF-8"));
            out.write("            }\n".getBytes("UTF-8"));
        }

        out.write(
                "            return (List<${classname}>)getHibernateTemplate().find(queryString.toString(), binds.toArray());\n"
                        .replace("${classname}", classname).getBytes("UTF-8"));
        out.write("        } catch (RuntimeException re) {\n".getBytes("UTF-8"));
        out.write("            log.error(\"find by properties failed\", re);\n".getBytes("UTF-8"));
        out.write("            throw re;\n".getBytes("UTF-8"));
        out.write("        }\n".getBytes("UTF-8"));
        out.write("    }\n".getBytes("UTF-8"));
        out.write("\n".getBytes("UTF-8"));

        out.write("}\n\n".getBytes("UTF-8"));

        out.close();
    }

}
