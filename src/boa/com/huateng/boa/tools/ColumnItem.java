package com.huateng.boa.tools;

public class ColumnItem {
    private String name;
    private String javaVarName;

    public String getJavaVarName() {
        return javaVarName;
    }

    public void setJavaVarName(String javaVarName) {
        this.javaVarName = javaVarName;
    }

    public String hibVarType;

    public String getHibVarType() {
        return hibVarType;
    }

    public void setHibVarType(String hibVarType) {
        this.hibVarType = hibVarType;
    }

    private int len;
    private String type;
    private boolean key;
    private boolean cannull;
    private int data_precision;
    private int data_scale;

    public boolean isCannull() {
        return cannull;
    }

    public void setCannull(boolean cannull) {
        this.cannull = cannull;
    }

    public int getData_precision() {
        return data_precision;
    }

    public void setData_precision(int data_precision) {
        this.data_precision = data_precision;
    }

    public int getData_scale() {
        return data_scale;
    }

    public void setData_scale(int data_scale) {
        this.data_scale = data_scale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
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

    public static String getClassName(String name) {

        String words[] = name.split("_");
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(upperFirst(word));
        }

        return sb.toString();
    }

    public String getFuncName() {

        String words[] = name.split("_");
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(upperFirst(word));
        }

        return sb.toString();
    }

    public String getJavaName() {
//        if (this.isKey()) {
//            return "id";
//        }
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

    public java.lang.String getJavaType() {
        if (type == null) {
            return "java.lang.String";
        }
        if (type.equals("CHAR")) {
            return "java.lang.String";
        } else if (type.contains("VARCHAR")) {
            return "java.lang.String";
        } else if (type.equals("TINYINT")) {
            return "java.lang.Byte";
        } else if (type.equals("SMALLINT")) {
            return "java.lang.Short";
        } else if (type.equals("INGEGER")) {
            return "java.lang.Integer";
        } else if (type.equals("BIGINT")) {
            return "java.lang.Long";
        } else if (type.equals("FLOAT")) {
            return "java.lang.Float";
        } else if (type.equals("DOUBLE")) {
            return "java.lang.Double";
        } else if (type.equals("NUMBER")) {
            if (data_scale == 0) {
                /**
                 * 此处为粗略判断，INT最大值为2147483647，LONG最大值为9223372036854775807
                 */
                if (data_precision <= 10) {
                    return "java.lang.Integer";
                } else if (data_precision > 10 && data_precision <= 19) {
                    return "java.lang.Long";
                }
            } else {
                return "java.math.BigDecimal";
            }
        }
        return "java.lang.String";
    }

    public boolean needWriteLength() {
        if ("java.lang.String".equalsIgnoreCase(getJavaType())) {
            return true;
        } else {
            return false;
        }
    }

    public java.lang.String getHibernateType() {
        if (type.equals("CHAR")) {
            return "string";
        } else if (type.contains("VARCHAR")) {
            return "string";
        } else if (type.equals("TINYINT")) {
            return "byte";
        } else if (type.equals("SMALLINT")) {
            return "short";
        } else if (type.equals("INGEGER")) {
            return "integer";
        } else if (type.equals("BIGINT")) {
            return "long";
        } else if (type.equals("FLOAT")) {
            return "float";
        } else if (type.equals("DOUBLE")) {
            return "double";
        } else if (type.equals("NUMBER")) {
            return "big_decimal";
        }
        return "string";
    }

    public String genHBM() {

        if (isKey()) {
            StringBuffer sb = new StringBuffer();
            sb.append("        ");
            String lenstr = "";
            if (needWriteLength()) {
                lenstr = " length=\"" + getLen() + "\"";
            }

            sb.append("<id name=\"" + getJavaName() + "\" column=\"" + getName() + "\" type=\"" + getHibernateType()
                    + "\" " + lenstr + " >");
            sb.append("\n");
            sb.append("            <generator class=\"com.huateng.aml.oracle.pk.GeneratePK\" />\n");
            sb.append("        </id>\n\n");

            return sb.toString();

        } else {
            StringBuffer sb = new StringBuffer();
            sb.append("        ");
            String lenstr = "";
            if (needWriteLength()) {
                lenstr = " length=\"" + getLen() + "\"";
            }

            sb.append("<property name=\"" + getJavaName() + "\" column=\"" + getName() + "\" type=\""
                    + getHibernateType() + "\" not-null=\"" + !isCannull() + "\"" + lenstr + " />");
            sb.append("\n");
            return sb.toString();
        }
    }

    public String genPOJODef() {
        StringBuffer sb = new StringBuffer();
        sb.append("    ");
        sb.append(getJavaType() + " " + getJavaName() + ";");
        sb.append("\n");
        return sb.toString();
    }

    public String genPOJOFunc() {
        StringBuffer sb = new StringBuffer();
        sb.append("    public ");
        sb.append(getJavaType() + " get" + getFuncName() + "(){");
        sb.append("\n");
        sb.append("    ");
        sb.append("    ");
        sb.append("return " + getJavaName() + ";");
        sb.append("\n");
        sb.append("    ");
        sb.append("}\n");

        sb.append("    public void ");
        sb.append("set" + getFuncName() + "(" + getJavaType() + " " + getJavaName() + "){");
        sb.append("\n");
        sb.append("    ");
        sb.append("    ");
        sb.append("this." + getJavaName() + " = " + getJavaName() + ";");
        sb.append("\n");
        sb.append("    ");
        sb.append("}\n\n");
        return sb.toString();
    }

    public String genToString() {
        StringBuffer sb = new StringBuffer();
        sb.append("        sb.append(\"" + getJavaName() + " = [\" + " + getJavaName() + " + \"], \");\n");
        // sb.append("recId = ["recId], )
        return sb.toString();
    }

}
