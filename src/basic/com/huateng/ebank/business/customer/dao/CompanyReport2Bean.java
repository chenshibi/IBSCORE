package com.huateng.ebank.business.customer.dao;

import java.util.List;
import java.util.Map;

/**
 * @desc 动态HQL拼装返回类
 */

public class CompanyReport2Bean {
	
	   private String sql;//查询sql

	   private List params;//查询参数

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
