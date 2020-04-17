/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.htaml.reportForm.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.MessageResources;

/**
 * Implementation of <strong>ExceptionHandler </strong> that handles any
 * Exceptions that are bubbled up to the Action layer. This allows us to remove
 * generic try/catch statements from our Action Classes.
 * 
 * <p>
 * <a href="ActionExceptionHandler.java.html"> <i>View Source </i> </a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible </a>
 */
public final class ActionExceptionHandler extends ExceptionHandler {
	//~ Instance fields
	// ========================================================

	private static final Log log = LogFactory
			.getLog(ActionExceptionHandler.class);

	//~ Methods
	// ================================================================

	/**
	 * This method handles any java.lang.Exceptions that are not caught in
	 * previous classes. It will loop through and get all the causes (exception
	 * chain), create ActionErrors, add them to the request and then forward to
	 * the input.
	 * 
	 * @see org.apache.struts.action.ExceptionHandler#execute (
	 *      java.lang.Exception, org.apache.struts.config.ExceptionConfig,
	 *      org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse )
	 */
	@Override
	public ActionForward execute(Exception ex, ExceptionConfig ae,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		ActionForward forward = super.execute(ex, ae, mapping, formInstance,
				request, response);

		// log the exception to the default logger
		//ex.printStackTrace();
		//log.error("异常",ex);

		String msg = convertErrorMessage(ex);
		throw new ServletException(msg, ex);
	}

	/**
	 * This method overrides the the ExceptionHandler's storeException method in
	 * order to create more than one error message.
	 * 
	 * @param request -
	 *            The request we are handling
	 * @param property -
	 *            The property name to use for this error
	 * @param error -
	 *            The error generated from the exception mapping
	 * @param forward -
	 *            The forward generated from the input path (from the form or
	 *            exception mapping)
	 */
	protected void storeException(HttpServletRequest request, String property,
			ActionMessage error, ActionForward forward) {
		ActionMessages errors = (ActionMessages) request
				.getAttribute(Globals.ERROR_KEY);
		if (errors == null) {
			errors = new ActionMessages();
		}
		errors.add(property, error);
		request.setAttribute(Globals.ERROR_KEY, errors);
	}

	/**
	 * Overrides logException method in ExceptionHandler to print the stackTrace
	 * 
	 * @see org.apache.struts.action.ExceptionHandler#logException(java.lang.Exception)
	 */
	@Override
	protected void logException(Exception ex) {
//		StringWriter sw = new StringWriter();
//		ex.printStackTrace(new PrintWriter(sw));
//		log.error(sw.toString());
	}

	public static String convertErrorMessage(Exception ex) {
		log.error("异常",ex);
		//Throwable t = ex.getCause();
		
		String errorMsg = "";
		String detailMsg = ex.getMessage();

		if (ex instanceof CommonException) {
			CommonException ce = (CommonException) ex;
			Object[] objs = ce.getObjs();
			String key = ce.getKey();

			errorMsg = "";
			if (DataFormat.trim(key) == "") {
				errorMsg = "没有错误代码";
			} else {
				MessageResources mr = MessageResources.getInstance();
				errorMsg = mr.getMessage(key, objs);
				if (null == errorMsg) {
					errorMsg = "未知的错误代码定义: " + key + ".";
				} else {
					errorMsg = "错误信息:" + errorMsg + ".";
				}
			}
		}

		StringBuffer sb = new StringBuffer(errorMsg);
		if (null != detailMsg && !"".equals(detailMsg)) {
			if ( -1 == detailMsg.indexOf("exception") ){//如果不是数据库操作掷出的异常信息,进行显示.
				sb.append("\n详细信息:").append(detailMsg).append(".");
			}
		}
		
		/*
		if (sb.toString().length() < 256) {
			if (t != null) {
				String m = t.getMessage();
				sb.append("\n调试信息:").append(m).append(".");
			}
		}
		*/

		String msg = sb.toString();
		if (msg.length() > 256) {
			msg = msg.substring(0, 256) + "......";
		}
		return msg;
	}
}