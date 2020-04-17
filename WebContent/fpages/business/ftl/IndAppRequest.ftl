<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />

<@CommonQueryMacro.page title="IndAppRequest.title">
<table align="left" width="100%"><tr><td>
<input type="hidden"  name="openertext" id="feedBackTxt"  value="" size="30" >
<@CommonQueryMacro.CommonQuery id="IndAppRequest" init=init submitMode="current">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table  width="80%">
	<tr>
		<td  align="left">
			<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="inqCustName,inqCustId,inqCustIdType,queryReason,inqCustType,relName,relNamec,relCorpId,relCustId,relCustIdType" colNm=1 /></br>
		</td>
	</tr>
	</table>
</@CommonQueryMacro.GroupBox>	
</@CommonQueryMacro.CommonQuery>

</td></tr>
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="IndAppCommon" init="false" submitMode="all">
	<table  width="80%">
		 <tr id="usrMsg1_tr" style="display: ">
		<td valign="top" >
			 <table width="100%" id ="usr1" >
			 	<tr>
			      	<td  align="left">
							<@CommonQueryMacro.DataTable id ="usrMsg1"  paginationbar="companyBtNew,companyBtDel" fieldStr="inqCustName,inqCustId,inqCustIdType,queryReason" width="100%" hasFrame="true" height="300" readonly="false"/>
			        </td>
			        </td>共同借款人信息</td>
			    </tr>
			</table>
       	</td>
       	</tr>	
       
	</table>

	<table width="100%"  >
			 	<tr>
    		<td colspan="2" align="center">
				<@CommonQueryMacro.Button id= "btSave"/>
				<@CommonQueryMacro.Button id= "uploadFile"/>
    		</td>
    	</tr>	
			</table>
		
</@CommonQueryMacro.CommonQuery>

</td>
</tr>
</table>
<script language="JavaScript">

	function initCallGetter_post(dataset) {
 		
     	var inqCustType=IndAppRequest_dataset.getValue("inqCustType");
     	<!--客户属性 未选为空，隐藏以下待选查询条件项 -->
		if(inqCustType==""){
	    	 IndAppRequest_dataset.setFieldRequired("inqCustType",true);
	    	 $("#fldlabel_relName").parent().parent().css({"display":"none"});	<!--主借款人名称-->
	    	 $("#fldlabel_relNamec").parent().parent().css({"display":"none"});	<!--借款公司名称-->
	    	 $("#fldlabel_relCustId").parent().parent().css({"display":"none"});<!--主借款人证件号-->
			 $("#fldlabel_relCustIdType").parent().parent().css({"display":"none"});<!--主借款人证件类型-->
			 $("#fldlabel_relCorpId").parent().parent().css({"display":"none"});	<!--借款公司中证码-->
            document.getElementById("usrMsg1_tr").style.display= 'none';
	
        }
	}
	
	function IndAppRequest_dataset_afterChange(dataset) {
	
		var inqCustType=IndAppRequest_dataset.getValue("inqCustType");
		
		 if(inqCustType!=""){
	    	IndAppRequest_dataset.setFieldRequired("inqCustType",true);
	    	changeField();
		 }
	}
	function changeField(){
		var inqCustType=IndAppRequest_dataset.getValue("inqCustType");
		if(inqCustType=="1"){//担保人
			IndAppCommon_dataset.setFieldRequired("inqCustName",false);
			IndAppCommon_dataset.setFieldRequired("inqCustId",false);
			IndAppCommon_dataset.setFieldRequired("inqCustIdType",false);
			IndAppCommon_dataset.setFieldRequired("queryReason",false);
			IndAppRequest_dataset.setFieldRequired("relNamec",true);
			IndAppRequest_dataset.setFieldRequired("relName",false);
			IndAppRequest_dataset.setFieldRequired("relCustId",false);
			IndAppRequest_dataset.setFieldRequired("relCustIdType",false);
			IndAppRequest_dataset.setFieldRequired("relCorpId",true);
			$("#fldlabel_relCustId").parent().parent().css({"display":"none"});
			$("#fldlabel_relCustIdType").parent().parent().css({"display":"none"});
			$("#fldlabel_relName").parent().parent().css({"display":"none"});
			$("#fldlabel_relNamec").parent().parent().css({"display":""});
			$("#fldlabel_relCorpId").parent().parent().css({"display":""});
			document.getElementById("usrMsg1_tr").style.display= 'none';
		}else if(inqCustType=="2"){//主借款人
			IndAppRequest_dataset.setFieldRequired("relName",false);
			IndAppRequest_dataset.setFieldRequired("relNamec",false);
			IndAppRequest_dataset.setFieldRequired("relCustId",false);
			IndAppRequest_dataset.setFieldRequired("relCustIdType",false);
			IndAppRequest_dataset.setFieldRequired("relCorpId",false);
			IndAppCommon_dataset.setFieldRequired("inqCustName",true);
			IndAppCommon_dataset.setFieldRequired("inqCustId",true);
			IndAppCommon_dataset.setFieldRequired("inqCustIdType",true);
			IndAppCommon_dataset.setFieldRequired("queryReason",true);
			$("#fldlabel_relName").parent().parent().css({"display":"none"});
			$("#fldlabel_relNamec").parent().parent().css({"display":"none"});
			$("#fldlabel_relCustId").parent().parent().css({"display":"none"});
			$("#fldlabel_relCustIdType").parent().parent().css({"display":"none"});
			$("#fldlabel_relCorpId").parent().parent().css({"display":"none"});
		    document.getElementById("usrMsg1_tr").style.display= '';

		}else if(inqCustType=="3"){//共同借款人
			IndAppCommon_dataset.setFieldRequired("inqCustName",false);
			IndAppCommon_dataset.setFieldRequired("inqCustId",false);
			IndAppCommon_dataset.setFieldRequired("inqCustIdType",false);
			IndAppCommon_dataset.setFieldRequired("queryReason",false);
			IndAppRequest_dataset.setFieldRequired("relNamec",false);
			IndAppRequest_dataset.setFieldRequired("relName",true);
			IndAppRequest_dataset.setFieldRequired("relCustId",true);
			IndAppRequest_dataset.setFieldRequired("relCustIdType",true);
			IndAppRequest_dataset.setFieldRequired("relCorpId",false);
			$("#fldlabel_relName").parent().parent().css({"display":""});
			$("#fldlabel_relNamec").parent().parent().css({"display":"none"});
			$("#fldlabel_relCustId").parent().parent().css({"display":""});
			$("#fldlabel_relCustIdType").parent().parent().css({"display":""});
			$("#fldlabel_relCorpId").parent().parent().css({"display":"none"});
			document.getElementById("usrMsg1_tr").style.display= 'none';
	
		}
	}
	
	function companyBtNew_onClick(button){
		
	    var lenght=countCurrentAvailbleDataset(IndAppCommon_dataset);
		if(lenght>1)
		{
		var record = IndAppCommon_dataset.lastUnit;
			do{
				record=record.prevUnit;
			}while(record.recordState =="delete" || record.recordState =="discard");
			var reg=/^[\s ]|[ ]$/gi;
			var inqCustName1 = record.getValue("inqCustName");
			if(reg.test(inqCustName1)){
				alert("Name开头或者结尾处存在空格！");
				return false;
			}
			inqCustName=encodeURI(encodeURI(inqCustName1));
			var inqCustId1 = record.getValue("inqCustId");
			if(reg.test(inqCustId1)){
				alert("ID开头或者结尾处存在空格！");
				return false;
			}
			inqCustId=encodeURI(encodeURI(inqCustId1));
			var inqCustIdType = record.getValue("inqCustIdType");
			var queryReason = record.getValue("queryReason");
			 dwr.engine.setAsync(false);
			 var isExpire=PrivAction.isExpire(inqCustIdType,inqCustName1,inqCustId1,queryReason);
			 dwr.engine.setAsync(false);
			 if(isExpire == "0"){
				 alert("Name="+inqCustName1+",ID="+inqCustId1+ " 没有查询授权书！");
			        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
			 }
			 if(isExpire == "1"){
				 alert("Name="+inqCustName1+",ID="+inqCustId1+ " 查询授权书过期！");
			        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
			 }
		}	
	  
	}

	var v1=0;
	function btSave_onClickCheck(button){
		var reg=/^[\s ]|[ ]$/gi;
		var nonWorkhourFilepath=document.getElementById("feedBackTxt").value;
		IndAppRequest_dataset.setValue("nonWorkhourFilepath",nonWorkhourFilepath);
		 dwr.engine.setAsync(false);
 		 var flag=PrivAction.isWorkTime();
 		 dwr.engine.setAsync(false);
 		 if(flag=="0" && document.getElementById("feedBackTxt").value==""){
 			 alert("非工作时间，需上传文件！");
 			uploadFile.disable(false);
 			return false;
 		 }
 		var inqCustType=IndAppRequest_dataset.getValue("inqCustType");
 		if(inqCustType=="2"){
		var lenght=countCurrentAvailbleDataset(IndAppCommon_dataset);
		var loanQReson=IndAppRequest_dataset.getValue("queryReason");
		if(lenght>0){
			var record = IndAppCommon_dataset.firstUnit;
			while(record){
				if(record.recordState !="delete" && record.recordState !="discard"){
					var inqCustName1 = record.getValue("inqCustName");
			         if(reg.test(inqCustName1)){
			                alert("共同借款人Name开头或者结尾处存在空格！");
			                return false;
			            }
					inqCustName=encodeURI(encodeURI(inqCustName1));
					var inqCustId1 = record.getValue("inqCustId");
					if(reg.test(inqCustId1)){
		                alert("共同借款人ID开头或者结尾处存在空格！");
		                return false;
		            }
					inqCustId=encodeURI(encodeURI(inqCustId1));
					var inqCustIdType = record.getValue("inqCustIdType");
					var queryReason = record.getValue("queryReason");
					 dwr.engine.setAsync(false);
					 var isExpire=PrivAction.isExpire(inqCustIdType,inqCustName1,inqCustId1,queryReason);
					 dwr.engine.setAsync(false);
					 if(isExpire == "0"){
						 v1=1;
						 alert("Name="+inqCustName1+",ID="+inqCustId1+ " 没有查询授权书！");
					        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
				        return false;
					 }
					 if(isExpire == "1"){
						 v1=1;
						 alert("Name="+inqCustName1+",ID="+inqCustId1+ " 查询授权书过期！");
					        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
				        return false;
					 }
					 if(((loanQReson=="01"||loanQReson=="02")&&(queryReason!=loanQReson))||((loanQReson=="03"||loanQReson=="08")&&(queryReason!=""))){
						 alert("主借款人和共同借款人查询原因不匹配,请重新选择!");
						 return false;
					 }
				}
				record=record.nextUnit;
			}
		}
		}
		var inqCustName=IndAppRequest_dataset.getValue("inqCustName");
		if(reg.test(inqCustName)){
            alert("被查询客户姓名开头或者结尾处存在空格！");
            return false;
        }
		var inqCustId=IndAppRequest_dataset.getValue("inqCustId");
		if(reg.test(inqCustId)){
            alert("被查询客户证件号开头或者结尾处存在空格！");
            return false;
        }
		var inqCustIdType=IndAppRequest_dataset.getValue("inqCustIdType");
		var queryReason=IndAppRequest_dataset.getValue("queryReason");
		inqCustName1=encodeURI(encodeURI(inqCustName));
		inqCustId1=encodeURI(encodeURI(inqCustId));
		inqCustIdType1=encodeURI(encodeURI(inqCustIdType));
		queryReason1=encodeURI(encodeURI(queryReason));
			 dwr.engine.setAsync(false);
			 var isExpire=PrivAction.isExpire(inqCustIdType,inqCustName,inqCustId,queryReason1);
			 var flagip=PrivAction.IndPermit12month(inqCustIdType,inqCustName,inqCustId);
			 var flagic=PrivAction.InqCust2month(inqCustIdType,inqCustName,inqCustId);
			 dwr.engine.setAsync(false);
			 if(isExpire == "0"){
				 alert("Name="+inqCustName+",ID="+inqCustId+ " 没有查询授权书！");
			        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName1 + "&individualId=" + inqCustId1 + "&idType="+inqCustIdType1,300,300,window);
			        return false;
			 }else if(isExpire == "1"){
				 alert("Name="+inqCustName+",ID="+inqCustId+ " 查询授权书过期！");
			        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName1 + "&individualId=" + inqCustId1 + "&idType="+inqCustIdType1,300,300,window);
			        return false;
			 }else{
				 if(flagip=="0" && flagic=="0"&& IndAppRequest_dataset.getValue("confirmFlag")!="1"){
					 if(confirm("Name="+inqCustName+",ID="+inqCustId+ "12个月内无查询记录，确定要查询吗？")){
						 IndAppRequest_dataset.setValue("confirmFlag","1");
					 }else{
						 IndAppRequest_dataset.setValue("confirmFlag","0");
						 return false;
						 }
				 }
			 }
			 
			 if(queryReason1=="01"){
				 if(confirm("请确认‘贷后管理’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、与我行信贷业务尚未终止")){
				 }else{
					 return false;
				 }
		}if(queryReason1=="02"){
				 if(confirm("请确认‘贷款审批’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、该客户正在进行业务申请")){
				 }else{
					 return false;
				 }
		}
		if(queryReason1=="03"){
				 if(confirm("请确认‘信用卡审批’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、其业务背景的真实性")){
				 }else{
					 return false;
				 }
		}
		if(queryReason1=="08"){
				 if(confirm("请确认‘担保资格审查’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、该客户正在为真实业务申请做担保")){
				 }else{
					 return false;
				 }
		}
		
	}
    function btSave_postSubmit(button){
    	var retParam =button.returnParam;
		var flag = retParam.flag;
    	if(flag=="1"){
    		var inqCustName1=IndAppRequest_dataset.getValue("inqCustName");
			inqCustName=encodeURI(encodeURI(inqCustName1));
    		var inqCustId1=IndAppRequest_dataset.getValue("inqCustId");
    		inqCustId=encodeURI(encodeURI(inqCustId1));
    		var inqCustIdType=IndAppRequest_dataset.getValue("inqCustIdType");
			 alert("Name="+inqCustName1+",ID="+inqCustId1+ " 没有查询授权书！");
	        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
    		closeWin();
    	}else{
    		button.url="/fpages/business/ftl/IndAppRequest.ftl";
    		alert("提交成功，由于查询时间较长，请稍候在查询界面查看返回结果......");
    	}
	}
    
    function uploadFile_onClickCheck(button){
   	/* dwr.engine.setAsync(false);
		 var flag=PrivAction.isWorkTime();
		 dwr.engine.setAsync(false);
		 if(flag=="1"){
			 alert("当前为工作时间，无需上传！");
			uploadFile.disable(true);
			return false;
		 }
    	// PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustLoancard",false);
	  */
   	 showWin("主管查询授权书", "/fpages/business/ftl/nonWorkhourFileUpload.jsp",300,300,window);
    }
    
    function companyBtNew_onClickCheck(button){
    	var count=countCurrentAvailbleDataset(IndAppCommon_dataset);
    	if(count>=4){
    		companyBtNew.disable(true);
    	}
    	}
    function companyBtDel_onClickCheck(button){
    	companyBtNew.disable(false);
    }
  //或许表格中记录实际条数
  function countCurrentAvailbleDataset(dataset){
	  var cnt=0;
	  var b=dataset.firstUnit;
	  while(b){
		  if(b.recordState !="delete" && b.recordState !="discard" ){
			  cnt=cnt+1;
		  }
		  b=b.nextUnit;
	  }
	  return cnt;
  }
	
</script>
</@CommonQueryMacro.page>