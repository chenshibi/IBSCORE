package com.huateng.ebank.framework.web.tag;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.framework.util.DataFormat;

public class UserInfoTag extends TagSupport {
    public int doStartTag() throws JspException {
        try {
            HttpSession session = pageContext.getSession();
            UserSessionInfo userInfo = (UserSessionInfo) session.getAttribute("USER_SESSION_INFO");

            if (userInfo != null) {
                String tbsDay = DataFormat.dateToString(userInfo.getTxDate());
                StringBuffer sb = new StringBuffer(256);
                sb.append("工作日期：").append(tbsDay.substring(0, 4)).append("年").append(tbsDay.substring(5, 7)).append("月")
                        .append(tbsDay.substring(8, 10)).append("日").append("&nbsp;&nbsp;&nbsp;操作员号：")
                        .append(userInfo.getTlrNo()).append("&nbsp;&nbsp;操作员名：").append(userInfo.getTlrName());
              //  sb.append("&nbsp;&nbsp;分行号：").append(userInfo.getBrNo()).append("&nbsp;&nbsp;分行行名：")
              //          .append(userInfo.getBrName());
                JspWriter out = pageContext.getOut();
                out.print(sb.toString());
                out.clear(); 
                out=pageContext.pushBody();
            }
        } catch (Exception e) {
            throw new JspException("[pocompl] Exception in AuthorizeTag : condition " + e.getMessage());
        }

        return 0;
    }

    public int doEndTag() throws JspException {
        return 6;
    }

    public void release() {
        super.release();
    }
}
