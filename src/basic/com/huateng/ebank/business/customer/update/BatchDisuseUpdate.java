package com.huateng.ebank.business.customer.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.dwr.DwrFunctions;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.common.PbocConstants;
import com.huateng.report.dao.FileSubmitDao;

import resource.bean.basic.FileSubmit;

/**
 * 
 * @author Grassy
 *
 */
public class BatchDisuseUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
	      try {
	            List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	            UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("CommonFileGroupUpload");
	            while (updateResultBean.hasNext()) {
	                Map<String, String> map = updateResultBean.next();
	                if (map.get("select").equals("true")) {
	                    list.add(map);
	                }
	            }
	            DwrFunctions dw=new DwrFunctions();
	            FileSubmitDao dao = BaseDAOUtils.fileSubmitDao();
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	            for(int i=0;i<list.size();i++) {
	            	Map<String, String> map = list.get(i);
	            	Integer id=Integer.valueOf(map.get("id"));
	                     FileSubmit fileSubmit = dao.findById(id);
	                     fileSubmit.setStatus(PbocConstants.DISUSE_UPLOAD_STATUS);
	                     dao.update(fileSubmit);
	            }
	            return updateReturnBean;
	        } catch (AppException appEx) {
	            throw appEx;
	        } catch (Exception ex) {
	            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
	        }
}
	}
