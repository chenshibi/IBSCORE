package com.huateng.report.pboc.operation;

import java.util.List;
import java.util.Map;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.excel.imp.QueryUntils;
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;

import resource.bean.basic.IndPermit;
import resource.bean.crms.CustPbocPerQuery;

/**
 * 
 * @author Grassy
 *
 */
public class QueryPersonalCrawlOperation extends BaseOperation {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(QueryPersonalCrawlOperation.class);
    @Override
    public void beforeProc(OperationContext context) throws CommonException {

    }

    @Override
    public void execute(OperationContext context){
        CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
        BusinessUploadService service=new BusinessUploadService();
        if ("INSERT".equals(context.getAttribute("CMD"))) {
            Map<String, String> map = (Map<String, String>) context.getAttribute("PersonalMakeMap");
            GlobalInfo globalInfo;
			try {
				globalInfo = GlobalInfo.getCurrentInstance();
				CustPbocPerQuery custPbocPerQuery = new CustPbocPerQuery();
				//Common Fields
				custPbocPerQuery.setRsv2("01");//爬网标识
				custPbocPerQuery.setCreateTime(DateUtil.get14Time());
				custPbocPerQuery.setCreateUser(globalInfo.getTlrno());
				custPbocPerQuery.setQueryDate(DateUtil.get8Date());
				//Biz Fields
				custPbocPerQuery.setName(map.get("name"));
				custPbocPerQuery.setIdType(map.get("idType"));
				custPbocPerQuery.setIdNum(map.get("idNum"));
				custPbocPerQuery.setQueryReason(map.get("queryReason"));
				custPbocPerQuery.setQueryLevel(map.get("queryLevel"));
				if("00".equals(map.get("serviceCode"))) {
					custPbocPerQuery.setServiceCode("FW_GRXYBG_0074");
				}else {
					custPbocPerQuery.setServiceCode("FW_GRXYBG_0010");
				}
				//已录入
				custPbocPerQuery.setStatus("00");
				custPbocPerQuery.setRsv4(QueryUntils.getRegionNo(globalInfo.getTlrno()));
				//custPbocPerQuery.setRsv3(DateUtil.get6Date());
				custPbocPerQuery.setRsv7(GlobalInfo.getCurrentInstance().getIp());
				custPbocPerQuery.setRsv8(map.get("query_org_code"));
				//add by chensibi start 添加主管批复文件路径
				custPbocPerQuery.setRsv3(map.get("nonWorkhourFilepath"));
				//add by chensibi end 添加主管批复文件路径
			//	custPbocPerQuery.setRsv9(map.get("user_code"));
				/*int size = QueryUntils.QueryMatchingPersoanl(map.get("idNum"), DataMyUtil.get16Date());
				if (size > 0) {
					custPbocPerQuery.setCertAuthStatus(QueryUntils.Successful);
				} else {
					custPbocPerQuery.setCertAuthStatus(QueryUntils.Default);
				}*/
				List<IndPermit> list=service.getIndPermitQuery(map.get("idType"), map.get("name"), map.get("idNum"));
				if(list!=null&&list.size()>0 ) {
					custPbocPerQuery.setCertAuthStatus(QueryUntils.Successful);
					custPbocPerQuery.setRsv10((list.get(0).getId().toString()));
				}else {
					custPbocPerQuery.setCertAuthStatus(QueryUntils.Default);
				}
				dao.save(custPbocPerQuery);
				context.setAttribute("id", custPbocPerQuery.getId());
			} catch (CommonException e) {
				e.printStackTrace();
			}
        }

    }


    @Override
    public void afterProc(OperationContext context) throws CommonException {

    }
}
