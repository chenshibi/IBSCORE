/**
 *
 */
package com.huateng.report.pboc.updater;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.bean.ChangePwdForm;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.operation.QueryCrPbocL102Operation;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.service.PbocL101Service;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.SM3;
/**
 * 
 * @author Grassy
 *
 */
public class ChangePwdUpdate extends BaseUpdate {

	
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("updatePwd");
			ChangePwdForm cpf = new ChangePwdForm();
			while (updateResultBean.hasNext()) {
				mapToObject(cpf, updateResultBean.next());
			}
			if(!(cpf.getOldPassWord().equals(ReportUtils.getSysParamsValue("BANK", "PWD")))) {
				ExceptionUtil.throwCommonException("用户当前密码输入错误",ErrorCode.ERROR_CODE_USER_PWD_INVALID);
			}
		    	if(!(cpf.getNewPassWord().equals(cpf.getAgainNewPassWord()))){
					ExceptionUtil.throwCommonException("新密码两次输入不一致",ErrorCode.ERROR_CODE_NEW_AGAIN_PWD_IS_NOT_SAME);
				}
				cpf.setTlrno(GlobalInfo.getCurrentInstance().getTlrno().toString());
			   OperationContext context = new OperationContext();
		       boolean isOk = true;
	            String rptId = "";
	            String id="";
	            PbocL101Service service = PbocL101Service.getInstance();
	            try {
	                    QueryResult queryResult = service.updatePassword(cpf);
	                    if (StringUtils.equals(queryResult.getCode(), "AAA003")) {
	                        logger.info("queryResult = " + queryResult);
	                        context.setAttribute("status", "success");
	                        context.setAttribute("value", cpf.getAgainNewPassWord());
	                        rptId = StringUtils.trimToEmpty(queryResult.getId());
		                    context.setAttribute("uuid", rptId);
		                    context.setAttribute("status", "success");
		                    OPCaller.call(QueryCrPbocL102Operation.class, context);
		                    updateReturnBean.setParameter("success", "修改密码成功");
	                    } else {
	                        isOk = false;
	                        logger.error("queryResult = " + queryResult);
	                        rptId = StringUtils.trimToEmpty(queryResult.getId());
	                        context.setAttribute("id", rptId);	                        
	                        context.setAttribute("uuid", rptId);
	                        context.setAttribute("status", "failed");
	                        OPCaller.call(QueryCrPbocL102Operation.class, context);
	                        updateReturnBean.setParameter("errMsg", "修改密码失败");
	                    }

	            } catch (Exception e) {
	                context.setAttribute("status", "exception");
	                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
	                ExceptionUtil.throwCommonException("修改密码异常");
	            }
	            return updateReturnBean;
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

}
