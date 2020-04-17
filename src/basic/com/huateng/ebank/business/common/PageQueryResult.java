/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common;

import java.util.List;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.2 $
 * @date 2005-7-14
 * 
 *       查询结果.
 */
public class PageQueryResult {
    private int totalCount; /* 总记录数 */
    private List queryResult; /* 查询结果 */

    /**
     * @return Returns the queryResult.
     */
    public List getQueryResult() {
        return queryResult;
    }

    /**
     * @param queryResult
     *            The queryResult to set.
     */
    public void setQueryResult(List queryResult) {
        this.queryResult = queryResult;
    }

    /**
     * @return Returns the totalCount.
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount
     *            The totalCount to set.
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount(int pageSize) {
        int pageCount = 0;
        if (totalCount % pageSize == 0) {
            pageCount = totalCount / pageSize;
        } else {
            pageCount = totalCount / pageSize + 1;
        }

        return pageCount;
    }
}
