package com.huateng.report.databak.getter;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.databak.bean.RecoverBakFileBean;
import com.huateng.report.utils.ReportUtils;

/**
 * 
 * @author shishu.zhang
 * 
 *         2012-10-10下午2:33:28
 */
@SuppressWarnings("unchecked")
public class RecoverBakFileGetter extends BaseGetter {

    @Override
    public Result call() throws AppException {
        try {
            PageQueryResult pageQueryResult = getData();

            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(),
                    pageQueryResult.getQueryResult(), getResult());
            result.setContent(pageQueryResult.getQueryResult());
            result.getPage().setTotalPage(pageQueryResult.getPageCount(getResult().getPage().getEveryPage()));
            result.init();
            result.setTotal(pageQueryResult.getTotalCount());
            return result;
        } catch (CommonException e) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

    public PageQueryResult getData() throws CommonException {
        PageQueryResult queryRst = new PageQueryResult();
        queryRst.setTotalCount(1);

        RecoverBakFileBean recoverBakFileBean = new RecoverBakFileBean();

        String filePath = ReportUtils.getSysParamsValue("BAK", "PATH");
        filePath += ReportConstant.BAK_DATA_FILE_NAME;

        File recoverFile = new File(filePath);
        if (!recoverFile.exists()) {
            recoverBakFileBean.setExits("N");
        } else {
            DecimalFormat formatter = new DecimalFormat("###,###,###,###,###,###,###");
            recoverBakFileBean.setFileSize(formatter.format(new BigDecimal(recoverFile.length())) + " byte");
            recoverBakFileBean.setLastModifyTime(new Date(recoverFile.lastModified()));
            recoverBakFileBean.setFilePath(ReportConstant.BAK_DATA_FILE_NAME);
            recoverBakFileBean.setExits("Y");
        }
        List list = new ArrayList();
        list.add(recoverBakFileBean);
        queryRst.setQueryResult(list);
        return queryRst;
    }
}
