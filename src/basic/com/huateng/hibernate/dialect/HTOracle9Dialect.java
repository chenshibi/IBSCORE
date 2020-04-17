package com.huateng.hibernate.dialect;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.NoArgSQLFunction;
import org.hibernate.dialect.function.NvlFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.exception.JDBCExceptionHelper;
import org.hibernate.exception.TemplatedViolatedConstraintNameExtracter;
import org.hibernate.exception.ViolatedConstraintNameExtracter;
import org.hibernate.util.ReflectHelper;

public class HTOracle9Dialect extends Dialect {
    static final String DEFAULT_BATCH_SIZE = "15";
    private static ViolatedConstraintNameExtracter _$1 = new TemplatedViolatedConstraintNameExtracter() {
        public String extractConstraintName(SQLException paramAnonymousSQLException) {
            int i = JDBCExceptionHelper.extractErrorCode(paramAnonymousSQLException);
            if ((i == 1) || (i == 2291) || (i == 2292)) {
                return extractUsingTemplate("constraint (", ") violated", paramAnonymousSQLException.getMessage());
            }
            if (i == 1400) {
                return null;
            }
            return null;
        }
    };
    int oracletypes_cursor_value = 0;

    public HTOracle9Dialect() {
        registerHibernateType(Types.NVARCHAR, Hibernate.STRING.getName());
        registerColumnType(-7, "number(1,0)");
        registerColumnType(-5, "number(19,0)");
        registerColumnType(5, "number(5,0)");
        registerColumnType(-6, "number(3,0)");
        registerColumnType(4, "number(10,0)");
        registerColumnType(1, "char(1 char)");
        registerColumnType(12, 4000, "varchar2($l char)");
        registerColumnType(12, "long");
        registerColumnType(6, "float");
        registerColumnType(8, "double precision");
        registerColumnType(91, "date");
        registerColumnType(92, "date");
        registerColumnType(93, "timestamp");
        registerColumnType(-3, 2000, "raw($l)");
        registerColumnType(-3, "long raw");
        registerColumnType(2, "number($p,$s)");
        registerColumnType(2004, "blob");
        registerColumnType(2005, "clob");
        registerHibernateType(1, Hibernate.STRING.getName());
        getDefaultProperties().setProperty("hibernate.jdbc.use_streams_for_binary", "true");
        getDefaultProperties().setProperty("hibernate.jdbc.batch_size", "15");
        registerFunction("abs", new StandardSQLFunction("abs"));
        registerFunction("sign", new StandardSQLFunction("sign", Hibernate.INTEGER));
        registerFunction("acos", new StandardSQLFunction("acos", Hibernate.DOUBLE));
        registerFunction("asin", new StandardSQLFunction("asin", Hibernate.DOUBLE));
        registerFunction("atan", new StandardSQLFunction("atan", Hibernate.DOUBLE));
        registerFunction("cos", new StandardSQLFunction("cos", Hibernate.DOUBLE));
        registerFunction("cosh", new StandardSQLFunction("cosh", Hibernate.DOUBLE));
        registerFunction("exp", new StandardSQLFunction("exp", Hibernate.DOUBLE));
        registerFunction("ln", new StandardSQLFunction("ln", Hibernate.DOUBLE));
        registerFunction("sin", new StandardSQLFunction("sin", Hibernate.DOUBLE));
        registerFunction("sinh", new StandardSQLFunction("sinh", Hibernate.DOUBLE));
        registerFunction("stddev", new StandardSQLFunction("stddev", Hibernate.DOUBLE));
        registerFunction("sqrt", new StandardSQLFunction("sqrt", Hibernate.DOUBLE));
        registerFunction("tan", new StandardSQLFunction("tan", Hibernate.DOUBLE));
        registerFunction("tanh", new StandardSQLFunction("tanh", Hibernate.DOUBLE));
        registerFunction("variance", new StandardSQLFunction("variance", Hibernate.DOUBLE));
        registerFunction("round", new StandardSQLFunction("round"));
        registerFunction("trunc", new StandardSQLFunction("trunc"));
        registerFunction("ceil", new StandardSQLFunction("ceil"));
        registerFunction("floor", new StandardSQLFunction("floor"));
        registerFunction("chr", new StandardSQLFunction("chr", Hibernate.CHARACTER));
        registerFunction("initcap", new StandardSQLFunction("initcap"));
        registerFunction("lower", new StandardSQLFunction("lower"));
        registerFunction("ltrim", new StandardSQLFunction("ltrim"));
        registerFunction("rtrim", new StandardSQLFunction("rtrim"));
        registerFunction("soundex", new StandardSQLFunction("soundex"));
        registerFunction("upper", new StandardSQLFunction("upper"));
        registerFunction("ascii", new StandardSQLFunction("ascii", Hibernate.INTEGER));
        registerFunction("length", new StandardSQLFunction("length", Hibernate.LONG));
        registerFunction("to_char", new StandardSQLFunction("to_char", Hibernate.STRING));
        registerFunction("to_date", new StandardSQLFunction("to_date", Hibernate.TIMESTAMP));
        registerFunction("current_date", new NoArgSQLFunction("current_date", Hibernate.DATE, false));
        registerFunction("current_time", new NoArgSQLFunction("current_timestamp", Hibernate.TIME, false));
        registerFunction("current_timestamp", new NoArgSQLFunction("current_timestamp", Hibernate.TIMESTAMP, false));
        registerFunction("lastday", new StandardSQLFunction("lastday", Hibernate.DATE));
        registerFunction("sysdate", new NoArgSQLFunction("sysdate", Hibernate.DATE, false));
        registerFunction("systimestamp", new NoArgSQLFunction("systimestamp", Hibernate.TIMESTAMP, false));
        registerFunction("uid", new NoArgSQLFunction("uid", Hibernate.INTEGER, false));
        registerFunction("user", new NoArgSQLFunction("user", Hibernate.STRING, false));
        registerFunction("rowid", new NoArgSQLFunction("rowid", Hibernate.LONG, false));
        registerFunction("rownum", new NoArgSQLFunction("rownum", Hibernate.LONG, false));
        registerFunction("concat", new VarArgsSQLFunction(Hibernate.STRING, "", "||", ""));
        registerFunction("instr", new StandardSQLFunction("instr", Hibernate.INTEGER));
        registerFunction("instrb", new StandardSQLFunction("instrb", Hibernate.INTEGER));
        registerFunction("lpad", new StandardSQLFunction("lpad", Hibernate.STRING));
        registerFunction("replace", new StandardSQLFunction("replace", Hibernate.STRING));
        registerFunction("rpad", new StandardSQLFunction("rpad", Hibernate.STRING));
        registerFunction("substr", new StandardSQLFunction("substr", Hibernate.STRING));
        registerFunction("substrb", new StandardSQLFunction("substrb", Hibernate.STRING));
        registerFunction("translate", new StandardSQLFunction("translate", Hibernate.STRING));
        registerFunction("substring", new StandardSQLFunction("substr", Hibernate.STRING));
        registerFunction("locate", new StandardSQLFunction("instr", Hibernate.INTEGER));
        registerFunction("bit_length", new SQLFunctionTemplate(Hibernate.INTEGER, "vsize(?1)*8"));
        registerFunction("coalesce", new NvlFunction());
        registerFunction("atan2", new StandardSQLFunction("atan2", Hibernate.FLOAT));
        registerFunction("log", new StandardSQLFunction("log", Hibernate.INTEGER));
        registerFunction("mod", new StandardSQLFunction("mod", Hibernate.INTEGER));
        registerFunction("nvl", new StandardSQLFunction("nvl"));
        registerFunction("nvl2", new StandardSQLFunction("nvl2"));
        registerFunction("power", new StandardSQLFunction("power", Hibernate.FLOAT));
        registerFunction("add_months", new StandardSQLFunction("add_months", Hibernate.DATE));
        registerFunction("months_between", new StandardSQLFunction("months_between", Hibernate.FLOAT));
        registerFunction("next_day", new StandardSQLFunction("next_day", Hibernate.DATE));
        registerFunction("str", new StandardSQLFunction("to_char", Hibernate.STRING));
    }

    public String getAddColumnString() {
        return "add";
    }

    public String getSequenceNextValString(String paramString) {
        return "select " + getSelectSequenceNextValString(paramString) + " from dual";
    }

    public String getSelectSequenceNextValString(String paramString) {
        return paramString + ".nextval";
    }

    public String getCreateSequenceString(String paramString) {
        return "create sequence " + paramString;
    }

    public String getDropSequenceString(String paramString) {
        return "drop sequence " + paramString;
    }

    public String getCascadeConstraintsString() {
        return " cascade constraints";
    }

    public boolean dropConstraints() {
        return false;
    }

    public String getForUpdateNowaitString() {
        return " for update nowait";
    }

    public boolean supportsSequences() {
        return true;
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String paramString, boolean paramBoolean) {
        paramString = paramString.trim();
        int i = 0;
        if (paramString.toLowerCase().endsWith(" for update")) {
            paramString = paramString.substring(0, paramString.length() - 11);
            i = 1;
        }
        StringBuffer localStringBuffer = new StringBuffer(paramString.length() + 100);
        if (paramBoolean) {
            localStringBuffer.append("select * from ( select row_.*, rownum rownum_ from ( ");
        } else {
            localStringBuffer.append("select * from ( ");
        }
        localStringBuffer.append(paramString);
        if (paramBoolean) {
            localStringBuffer.append(" ) row_ where rownum <= ?) where rownum_ > ?");
        } else {
            localStringBuffer.append(" ) where rownum <= ?");
        }
        if (i != 0) {
            localStringBuffer.append(" for update");
        }
        return localStringBuffer.toString();
    }

    public String getForUpdateString(String paramString) {
        return getForUpdateString() + " of " + paramString;
    }

    public String getForUpdateNowaitString(String paramString) {
        return getForUpdateString() + " of " + paramString + " nowait";
    }

    public boolean bindLimitParametersInReverseOrder() {
        return true;
    }

    public boolean useMaxForLimit() {
        return true;
    }

    public boolean forUpdateOfColumns() {
        return true;
    }

    public String getQuerySequencesString() {
        return "select sequence_name from user_sequences";
    }

    public String getSelectGUIDString() {
        return "select rawtohex(sys_guid()) from dual";
    }

    public ViolatedConstraintNameExtracter getViolatedConstraintNameExtracter() {
        return _$1;
    }

    public int registerResultSetOutParameter(CallableStatement paramCallableStatement, int paramInt)
            throws SQLException {
        if (oracletypes_cursor_value == 0) {
            try {
                Class localClass = ReflectHelper.classForName("oracle.jdbc.driver.OracleTypes");
                oracletypes_cursor_value = localClass.getField("CURSOR").getInt(localClass.newInstance());
            } catch (Exception localException) {
                throw new HibernateException("Problem while trying to load or access OracleTypes.CURSOR value",
                        localException);
            }
        }
        paramCallableStatement.registerOutParameter(paramInt, oracletypes_cursor_value);
        paramInt++;
        return paramInt;
    }

    public ResultSet getResultSet(CallableStatement paramCallableStatement) throws SQLException {
        paramCallableStatement.execute();
        ResultSet localResultSet = (ResultSet) paramCallableStatement.getObject(1);
        return localResultSet;
    }

    public boolean supportsUnionAll() {
        return true;
    }

    public boolean supportsCommentOn() {
        return true;
    }

    public boolean supportsTemporaryTables() {
        return true;
    }

    public String generateTemporaryTableName(String paramString) {
        String str = super.generateTemporaryTableName(paramString);
        return str.length() > 30 ? str.substring(1, 30) : str;
    }

    public String getCreateTemporaryTableString() {
        return "create global temporary table";
    }

    public String getCreateTemporaryTablePostfix() {
        return "on commit delete rows";
    }

    public boolean dropTemporaryTableAfterUse() {
        return false;
    }

    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    public String getCurrentTimestampSelectString() {
        return "select systimestamp from dual";
    }

    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }
}
