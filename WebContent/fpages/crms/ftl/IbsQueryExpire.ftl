<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="查询授权有效期设置">

<@CommonQueryMacro.CommonQuery id="IbsQueryExpire" init="false" submitMode="selected" navigate="false">
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<table  width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	<tr>
	</tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="modelDownload,-,importBN" fieldStr="userName[150],centralCode[100],clientLeId,customerName[100],updateTime[100],expireTime[100],status" readonly="true" width="95%"/><br/>
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>

</@CommonQueryMacro.page>
<script  language="JavaScript">
    var sysTxdate = ${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()?string("yyyyMMdd")};  
	function importBN_onClick(){
		currentSubWin = openSubWin("pageWinId", "导入查询授权请求文件", "/fpages/business/jsp/ibsQueryExpire.jsp?fileflag=1&workDate="+sysTxdate,"600","200");
	}
	
   function modelDownload_onClick(){
        var form = document.createElement("FORM");
        form.method = "post";
        form.action=_application_root +"/CertFileXLSXDownloadServlet";
        document.body.appendChild(form);
        form.submit();
    }
</script>