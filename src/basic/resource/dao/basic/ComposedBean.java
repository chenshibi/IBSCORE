package resource.dao.basic;

import java.util.List;

/**
 * @desc 动态HQL拼装返回类
 */

public class ComposedBean {

    private String sql;// 查询sql

    private List params;// 查询参数

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List getParams() {
        return params;
    }

    public void setParams(List params) {
        this.params = params;
    }

}
