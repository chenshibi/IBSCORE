/**
 *
 */
package com.huateng.ebank.business.common.getter;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * Title: SessionClearGetter Description: Copyright: Copyright (c) 2008 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2008-1-25
 */
public class SessionClearGetter extends BaseGetter {

    /*
     * (non-Javadoc)
     * 
     * @see com.huateng.commquery.process.call._CallGetter#call()
     */
    @Override
    public Result call() throws AppException {
        // TODO Auto-generated method stub
        String contextList = getCommQueryServletRequest().getParameter("contextList");
        if (!StringUtils.isEmpty(contextList)) {
            String[] contextAry = contextList.split(",");
            String id;
            for (int i = 0; i < contextAry.length; i++) {
                id = contextAry[i];
                getHttpReq().getSession().removeAttribute(id);
            }
        }
        return this.getResult();
    }

}
