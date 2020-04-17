package com.huateng.report.system.updater;

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
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.system.operation.TaskListOperation;
import com.huateng.report.system.service.UndoConfirmService;
import com.huateng.report.utils.ReportEnum.REPORT_TASK_FUNCID;
import com.huateng.report.utils.ReportEnum.REPORT_TASK_TRANS_CD;

import resource.bean.basic.SysTaskInfo;

public class TaskListUpdate extends BaseUpdate {
    /**
     * @author jianxue.zhang 审批操作的update
     */
    private final static String COMMON_DATASET_ID = "approve_common";
    private String dataset_id = null;

    // private final static String TaskListOperation
    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
            throws AppException {
        try {

            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            // 先从commondataset种获取数据;
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(COMMON_DATASET_ID);
            String approveResult = null;
            String approveRemark = null;
            String intInsId = null;
            // Class cls=null;
            // String beanName=null;
            if (updateResultBean.hasNext()) {
                Map map = updateResultBean.next();
                approveResult = (String) map.get("approveResult");
                approveRemark = (String) map.get("approveRemark");
                intInsId = (String) map.get("intInsId");
            }
            if ((intInsId != null)) {
                if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100199.value)) {
                    dataset_id = "approve_bctl";

                }

                else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)) {
                    dataset_id = "approve_role";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                    dataset_id = "approve_tlrInfo";
                }

                else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100599.value)) {
                    dataset_id = "approve_workdate";
                }

                else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100799.value)) {
                    dataset_id = "approve_SysParamsEntry";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120299.value)) {
                    dataset_id = "approve_SysParamsEntry";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120399.value)) {
                    dataset_id = "approve_SysParamsEntry";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100899.value)) {
                    dataset_id = "approve_pfSysParams";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_110199.value)) {
                    dataset_id = "approve_currency";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_110499.value)) {
                    dataset_id = "approve_biNation";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_110599.value)) {
                    dataset_id = "approve_biMonth";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_110699.value)) {
                    dataset_id = "approve_biDay";
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                    dataset_id = "approve_sysNotice";
                }

            }
            UpdateResultBean updateRecodeBean = multiUpdateResultBean.getUpdateResultBeanByID(dataset_id);

            List<SysTaskInfo> updateList = new ArrayList<SysTaskInfo>();
            List<SysTaskInfo> insertList = new ArrayList<SysTaskInfo>();
            List<SysTaskInfo> delList = new ArrayList<SysTaskInfo>();
            // List setList = new ArrayList();
            // List otherList = new ArrayList();
            SysTaskInfo bean = new SysTaskInfo();
            UndoConfirmService ucs = UndoConfirmService.getInstance();
            String id = null;
            String ss = null;
            Map map;
            while (updateRecodeBean.hasNext()) {
                map = updateRecodeBean.next();
                id = (String) map.get("id");
                ss = (String) map.get("updTransCd");
                bean = ucs.load(id);
                if (ss.equals(REPORT_TASK_TRANS_CD.NEW.value)) {
                    insertList.add(bean);
                } else if (ss.equals(REPORT_TASK_TRANS_CD.DEL.value)) {
                    delList.add(bean);
                } else if (ss.equals(REPORT_TASK_TRANS_CD.EDIT.value)) {
                    updateList.add(bean);
                }

                /*
                 * else if (ss.equals(REPORT_TASK_TRANS_CD.SET.value)) {
                 * //setList.add(bean); }
                 * 
                 * else if (ss.equals(REPORT_TASK_TRANS_CD.OTHER.value)) {
                 * //otherList.add(bean); }
                 */
            }
            OperationContext context = new OperationContext();
            // new
            // context.setAttribute(TaskListOperation.CLASS,
            // cls);
            context.setAttribute(TaskListOperation.INSERTLIST, insertList);
            context.setAttribute(TaskListOperation.UPDATELIST, updateList);
            context.setAttribute(TaskListOperation.DELLIST, delList);
            // context.setAttribute(TaskListOperation.SETLIST, setList);
            // context.setAttribute(TaskListOperation.OTHERLIST, otherList);
            context.setAttribute(TaskListOperation.CMD, "APPROVE");
            context.setAttribute(TaskListOperation.APPREMARK, approveRemark);
            context.setAttribute(TaskListOperation.APPRESULT, approveResult);
            context.setAttribute(TaskListOperation.INTINSID, intInsId);
            OPCaller.call(TaskListOperation.ID, context);
            return updateReturnBean;

        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }
}
