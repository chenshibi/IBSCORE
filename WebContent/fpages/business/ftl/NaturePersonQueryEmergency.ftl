<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />

<@CommonQueryMacro.page title="NaturePersonQuery.title">
<table align="left" width="100%"><tr><td>
<input type="hidden"  name="openertext" id="feedBackTxt"  value="" size="30" >
<@CommonQueryMacro.CommonQuery id="NaturePersonQuery" init="false" submitMode="current">
	<table  width="80%">
	<tr>
		<td  align="left">
			<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="individualIdType,individualId,name" colNm=1 /></br>
		</td>
	</tr>
		<tr>
    		<td colspan="2" align="center">
				<@CommonQueryMacro.Button id= "btSave"/>
				<@CommonQueryMacro.Button id= "uploadFile"/>
    		</td>
    	</tr>	
	</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">

 function initCallGetter_post(dataset) {		
	}
	
 function btSave_onClickCheck(button){
	 var nonConsentFilePath=document.getElementById("feedBackTxt").value;
	   NaturePersonQuery_dataset.setValue("nonConsentFilePath",nonConsentFilePath);
		 dwr.engine.setAsync(false);
		 var flag=PrivAction.isWorkTime();
		 dwr.engine.setAsync(false);
		 if(flag=="0" && document.getElementById("feedBackTxt").value==""){
			 alert("非工作时间，需上传主管批复文件！");
			uploadFile.disable(false);
			return false;
		 }
		 
			var name=NaturePersonQuery_dataset.getValue("name");
			var id=NaturePersonQuery_dataset.getValue("individualId");
			var idType=NaturePersonQuery_dataset.getValue("individualIdType");
			name1=encodeURI(encodeURI(name));
			id1=encodeURI(encodeURI(id));
			idType1=encodeURI(encodeURI(idType));
			 dwr.engine.setAsync(false);
			 var flag=PrivAction.isNatureExpire(idType,name,id);
			 dwr.engine.setAsync(false);
			 if(flag == "0"){
				 alert("没有查询授权书！");
			        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ name1 + "&individualId=" + id1 + "&idType="+idType1,300,300,window);
			        return false;
			 }
 }
 
 function uploadFile_onClickCheck(button){
 	 showWin("主管查询授权书", "/fpages/business/ftl/nonWorkhourFileUpload.jsp",300,300,window);
  }
 function btSave_postSubmit(button){ 
	 button.url="/fpages/business/ftl/NaturePersonQueryEmergency.ftl";
		alert("提交成功，由于查询时间较长，请稍候在查询界面查看返回结果......");
 }
</script>
</@CommonQueryMacro.page>