<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />

<@CommonQueryMacro.page title="">
<table align="left" width="100%"><tr><td>
<input type="hidden"  name="openertext" id="feedBackTxt"  value="" size="30" >
<@CommonQueryMacro.CommonQuery id="PbocBatchCorpsEnquiry" init="false" submitMode="current">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table  width="80%">
	<tr>
		<td  align="left">
			<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="corpCustLoancard,corpCustPswd,corpCustCompanyname,entCertType,entCertNum,queryReason,serviceCode,corpCustType,queryType,detailFlag,relCorpId,relName" colNm=1 /></br>
		</td>
	</tr>
	</table>
</@CommonQueryMacro.GroupBox>	
</@CommonQueryMacro.CommonQuery>

</td></tr>
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="PbocCompany" init="false" submitMode="all">
	<table  width="80%">
		 <tr id="usrMsg1_tr" style="display: ">
		<td valign="top" >
			 <table width="100%" id ="usr1" >
			 	<tr>
			      	<td  align="left">
							<@CommonQueryMacro.DataTable id ="usrMsg1"  paginationbar="BtNew,BtDel" fieldStr="corpCustLoancard,corpCustPswd,corpCustCompanyname,detailFlag,queryReason" width="100%" hasFrame="true" height="300" readonly="false"/>
			        </td>
			        </td>担保公司信息</td>
			    </tr>
			</table>
       	</td>
       	</tr>	
       
	</table>
		
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="IndAppCommonForCom" init="false" submitMode="all">
	<table  width="80%">
		 <tr id="usrMsg2_tr" style="display: " >
		<td valign="top" >
			 <table width="100%" id ="usr2" >
			 	<tr>
			      	<td  align="left">
							<@CommonQueryMacro.DataTable id ="usrMsg2"  paginationbar="companyBtNew,companyBtDel" fieldStr="inqCustId,inqCustIdType,inqCustName,queryReasonInd" width="100%" hasFrame="true" height="300" readonly="false"/>
			        </td>
			         </td>担保人信息</td>
			    </tr>
			</table>
       	</td>
       	</tr>	
       
	</table>

	<table width="100%"  >
			 	<tr>
    		<td colspan="2" align="center">
				<@CommonQueryMacro.Button id= "buttonSave"/>
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
	    PbocBatchCorpsEnquiry_dataset.setValue("queryType","online");
	    PbocBatchCorpsEnquiry_dataset.setValue("detailFlag",1);
     	var corpCustType=PbocBatchCorpsEnquiry_dataset.getValue("corpCustType");
		if(corpCustType==""){
			PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustType",true);
	    	 $("#fldlabel_relCorpId").parent().parent().css({"display":"none"});
			 $("#fldlabel_relName").parent().parent().css({"display":"none"});
            document.getElementById("usrMsg1_tr").style.display= 'none';
            document.getElementById("usrMsg2_tr").style.display= 'none';

        }
	}
	
	function PbocBatchCorpsEnquiry_dataset_afterChange(dataset) {
		var corpCustType=PbocBatchCorpsEnquiry_dataset.getValue("corpCustType");
		
		 if(corpCustType!=""){
	    	PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustType",true);
	    	changeField();
		 }
	}
	function changeField(){
		var corpCustType=PbocBatchCorpsEnquiry_dataset.getValue("corpCustType");
		if(corpCustType=="2"){
			PbocCompany_dataset.setFieldRequired("corpCustLoancard",false);
			PbocCompany_dataset.setFieldRequired("corpCustPswd",false);
			PbocCompany_dataset.setFieldRequired("corpCustCompanyname",false);
			PbocCompany_dataset.setFieldRequired("detailFlag",false);
			PbocCompany_dataset.setFieldRequired("queryReason",false);
			
			IndAppCommonForCom_dataset.setFieldRequired("inqCustId",false);
			IndAppCommonForCom_dataset.setFieldRequired("inqCustIdType",false);
			IndAppCommonForCom_dataset.setFieldRequired("inqCustName",false);
			IndAppCommonForCom_dataset.setFieldRequired("queryReasonInd",false);
			
			PbocBatchCorpsEnquiry_dataset.setFieldRequired("relCorpId",true);
			PbocBatchCorpsEnquiry_dataset.setFieldRequired("relName",true);
			
			 $("#fldlabel_relCorpId").parent().parent().css({"display":""});
			 $("#fldlabel_relName").parent().parent().css({"display":""});
			document.getElementById("usrMsg1_tr").style.display= 'none';
			document.getElementById("usrMsg2_tr").style.display= 'none';
		}else if(corpCustType=="1"){
			PbocCompany_dataset.setFieldRequired("corpCustLoancard",true);
			//PbocCompany_dataset.setFieldRequired("corpCustPswd",true);
			PbocCompany_dataset.setFieldRequired("corpCustCompanyname",true);
			PbocCompany_dataset.setFieldRequired("detailFlag",true);
			PbocCompany_dataset.setFieldRequired("queryReason",true);
			
			IndAppCommonForCom_dataset.setFieldRequired("inqCustId",true);
			IndAppCommonForCom_dataset.setFieldRequired("inqCustIdType",true);
			IndAppCommonForCom_dataset.setFieldRequired("inqCustName",true);
			IndAppCommonForCom_dataset.setFieldRequired("queryReasonInd",true);
			
			PbocBatchCorpsEnquiry_dataset.setFieldRequired("relCorpId",false);
			PbocBatchCorpsEnquiry_dataset.setFieldRequired("relName",false);
			
			 $("#fldlabel_relCorpId").parent().parent().css({"display":"none"});
			 $("#fldlabel_relName").parent().parent().css({"display":"none"});
		    document.getElementById("usrMsg1_tr").style.display= '';
		    document.getElementById("usrMsg2_tr").style.display= '';

		}
	}
	
	function BtNew_onClick(button){
		var reg=/^[\s ]|[ ]$/gi;
		 var lenght=countCurrentAvailbleDataset(PbocCompany_dataset);
			if(lenght>1)
			{
			var record = PbocCompany_dataset.lastUnit;
				do{
					record=record.prevUnit;
				}while(record.recordState =="delete" || record.recordState =="discard");
				var corpCustCompanyname1 = record.getValue("corpCustCompanyname");
				if(reg.test(corpCustCompanyname1)){
	                alert("Company Name开头或者结尾处存在空格！");
	                return false;
	            }
				corpCustCompanyname=encodeURI(encodeURI(corpCustCompanyname1));
				var corpCustLoancard1 = record.getValue("corpCustLoancard");
				if(reg.test(corpCustLoancard1)){
	                alert("LoanCard ID 开头或者结尾处存在空格！");
	                return false;
	            }
		    	 var corpCustPswd1=record.getValue("corpCustPswd");
		    	 if(reg.test(corpCustPswd1)){
		                alert("LEID开头或者结尾处存在空格！");
		                return false;
		            }
		    	 corpCustLoancard=encodeURI(encodeURI(corpCustLoancard1));
		    	 corpCustPswd=encodeURI(encodeURI(corpCustPswd1));
		    	 var queryReason1 = record.getValue("queryReason");
		    	 queryReason = encodeURI(encodeURI(queryReason1));
				 dwr.engine.setAsync(false);
				 var isCompanyExpire=PrivAction.isCompanyExpire(corpCustLoancard,queryReason);//有无授权书标志
				 dwr.engine.setAsync(false);
				 if(isCompanyExpire == "0"){
					 alert("Name="+corpCustCompanyname1+",ID="+corpCustLoancard1+ " 没有查询授权书！");
			    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN.ftl?corpCustCompanyname=" + corpCustCompanyname + "&corpCustLoancard=" + corpCustLoancard + "&corpCustPswd="+corpCustPswd,300,300,window);
			    	 return false;
				 }
				 if(isCompanyExpire == "1"){
					 alert("Name="+corpCustCompanyname1+",ID="+corpCustLoancard1+ " 查询授权书过期！");
			    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN.ftl?corpCustCompanyname=" + corpCustCompanyname + "&corpCustLoancard=" + corpCustLoancard + "&corpCustPswd="+corpCustPswd,300,300,window);
			    	 return false;
				 }
			}	
	  
	}
	function companyBtNew_onClick(button){
		var reg=/^[\s ]|[ ]$/gi;
	    var lenght=countCurrentAvailbleDataset(IndAppCommonForCom_dataset);
		if(lenght>1)
		{
		var record = IndAppCommonForCom_dataset.lastUnit;
			do{
				record=record.prevUnit;
			}while(record.recordState =="delete" || record.recordState =="discard");
			
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
			var inqCustIdType1 = record.getValue("inqCustIdType");
			var queryReason=record.getValue("queryReasonInd");
			inqCustId=encodeURI(encodeURI(inqCustId1));
			queryReason1=encodeURI(encodeURI(queryReason));
			inqCustIdType=encodeURI(encodeURI(inqCustIdType1));
			 dwr.engine.setAsync(false);
			 var isExpire=PrivAction.isExpire(inqCustIdType1,inqCustName1,inqCustId1,queryReason1);
			 dwr.engine.setAsync(false);
			 if(isExpire == "0"){
				 alert("Name="+inqCustName1+",ID="+inqCustId1+ " 没有查询授权书！");
			        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
			 }else if(isExpire == "1"){
				 alert("Name="+inqCustName1+",ID="+inqCustId1+ "查询授权书过期！");
			        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
			 }
		}	
	  
	}
	var v1=0;
	function buttonSave_onClickCheck(button){
		var reg=/^[\s ]|[ ]$/gi;
		var nonWorkhourFilepath=document.getElementById("feedBackTxt").value;
		PbocBatchCorpsEnquiry_dataset.setValue("nonWorkhourFilepath",nonWorkhourFilepath);
		 dwr.engine.setAsync(false);
 		 var flag=PrivAction.isWorkTime();
 		 dwr.engine.setAsync(false);
 		 if(flag=="0" && document.getElementById("feedBackTxt").value==""){
 			 alert("非工作时间，需上传文件！");
 			uploadFile.disable(false);
 			return false;
 		 }
 		 PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustLoancard",true);
	     //PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustPswd",true);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustCompanyname",true);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("queryReason",true);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustType",true);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("queryType",true);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("detailFlag",true);
 		 var corpCustType=PbocBatchCorpsEnquiry_dataset.getValue("corpCustType");
 		 PbocBatchCorpsEnquiry_dataset.setFieldRequired("serviceCode",true);
 		 PbocBatchCorpsEnquiry_dataset.setFieldRequired("entCertType",true);
 		 PbocBatchCorpsEnquiry_dataset.setFieldRequired("entCertNum",true);
		if(corpCustType=="2"){
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("relCorpId",true);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("relName",true); 
		}
		if(corpCustType=="1"){
		//检验担保公司
		var lenght=countCurrentAvailbleDataset(PbocCompany_dataset);
		var loanQReson=PbocBatchCorpsEnquiry_dataset.getValue("queryReason");
		if(lenght>0){
			var record = PbocCompany_dataset.firstUnit;
			while(record){
				if(record.recordState !="delete" && record.recordState !="discard"){
				var corpCustCompanyname1 = record.getValue("corpCustCompanyname");
				 if(reg.test(corpCustCompanyname1)){
		                alert("担保公司Company Name开头或者结尾处存在空格！");
		                return false;
		            }
				var corpCustLoancard1 = record.getValue("corpCustLoancard");
				if(reg.test(corpCustLoancard1)){
	                alert("担保公司LoanCard ID开头或者结尾处存在空格！");
	                return false;
	            }
				var corpCustPswd1 = record.getValue("corpCustPswd");
				if(reg.test(corpCustPswd1)){
	                alert("担保公司LEID开头或者结尾处存在空格！");
	                return false;
	            }
				corpCustCompanyname=encodeURI(encodeURI(corpCustCompanyname1));
				var queryReason1 = record.getValue("queryReason");
				queryReason = encodeURI(encodeURI(queryReason1));
				corpCustLoancard=encodeURI(encodeURI(corpCustLoancard1));
				corpCustPswd=encodeURI(encodeURI(corpCustPswd1));
				 dwr.engine.setAsync(false);
				 var flagtp=PrivAction.tCorpPermit12month(corpCustLoancard1);//12个月有无查询记录标志
				 var flagtc=PrivAction.tCorpCust12month(corpCustLoancard1);//授权书12月内录入标志
				 var isCompanyExpire=PrivAction.isCompanyExpire(corpCustLoancard1,queryReason);//有无授权书标志
				 dwr.engine.setAsync(false);
				 if(isCompanyExpire == "0"){
					 alert("Name="+corpCustCompanyname1+",ID="+corpCustLoancard1+ " 没有查询授权书！");
			    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN.ftl?corpCustCompanyname=" + corpCustCompanyname + "&corpCustLoancard=" + corpCustLoancard + "&corpCustPswd="+corpCustPswd,300,300,window);
			    	 return false;
				 }else if(isCompanyExpire == "1"){
					 alert("Name="+corpCustCompanyname1+",ID="+corpCustLoancard1+ " 查询授权书过期！");
			    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN.ftl?corpCustCompanyname=" + corpCustCompanyname + "&corpCustLoancard=" + corpCustLoancard + "&corpCustPswd="+corpCustPswd,300,300,window);
			    	 return false;
				 }else{
					 if(!flagtp && !flagtc && record.getValue("confirmFlag")!="1"){
						 if(confirm("Name="+corpCustCompanyname1+",ID="+corpCustLoancard1+ "12个月内无查询记录，确定要查询吗？")){
							 record.setValue("confirmFlag","1");
						 }else{
							 record.setValue("confirmFlag","0");
							 return false;
							 }
					 }
				 }
				 if(((loanQReson=="01"||loanQReson=="02"||loanQReson=="03")&&(queryReason!=loanQReson))||((loanQReson=="04"||loanQReson=="05")&&(queryReason!=""))){
					 alert("借款公司和担保公司查询原因不匹配,请重新选择!");
					 return false;
				 }
				}
				record=record.nextUnit;
			}
		}
		
		//检验担保人
		var count=countCurrentAvailbleDataset(IndAppCommonForCom_dataset);
		if(count>0){
			var record = IndAppCommonForCom_dataset.firstUnit;
			while(record){
				if(record.recordState !="delete" && record.recordState !="discard"){
					var inqCustName1 = record.getValue("inqCustName");
					 if(reg.test(inqCustName1)){
			                alert("担保人Name开头或者结尾处存在空格！");
			                return false;
			            }
					var inqCustId1 = record.getValue("inqCustId");
					 if(reg.test(inqCustId1)){
			                alert("担保人ID开头或者结尾处存在空格！");
			                return false;
			            }
					var inqCustIdType1 = record.getValue("inqCustIdType");
					var queryReason=record.getValue("queryReasonInd");
					queryReason1=encodeURI(encodeURI(queryReason));
					inqCustName=encodeURI(encodeURI(inqCustName1));
					inqCustId=encodeURI(encodeURI(inqCustId1));
					inqCustIdType=encodeURI(encodeURI(inqCustIdType1));
					 dwr.engine.setAsync(false);
					 var flagip=PrivAction.IndPermit12month(inqCustIdType1,inqCustName1,inqCustId1);
					 var flagic=PrivAction.InqCust2month(inqCustIdType1,inqCustName1,inqCustId1);
					 var isExpire=PrivAction.isExpire(inqCustIdType1,inqCustName1,inqCustId1,queryReason1);
					 dwr.engine.setAsync(false);
					 if(isExpire == "0"){
						 v1=1;
						 alert("Name="+inqCustName1+",ID="+inqCustId1+ " 没有查询授权书！");
					        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
					        return false;
					 }else if(isExpire == "1"){
						 v1=1;
						 alert("Name="+inqCustName1+",ID="+inqCustId1+ " 查询授权书过期！");
					        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ inqCustName + "&individualId=" + inqCustId + "&idType="+inqCustIdType,300,300,window);
					        return false;
					 }else{
						 if(flagip=="0" && flagic=="0"&& record.getValue("confirmFlag")!="1"){
							 if(confirm("Name="+inqCustName1+",ID="+inqCustId1+ "12个月内无查询记录，确定要查询吗？")){
								 record.setValue("confirmFlag","1");
							 }else{
								 record.setValue("confirmFlag","0");
								 return false;
								 }
						 }
					 }
					 if(((loanQReson=="01"||loanQReson=="02")&&(queryReason!="08"))||((loanQReson=="03")&&(queryReason!="01"))||((loanQReson=="04"||loanQReson=="05")&&(queryReason!=""))){
						 alert("借款公司和担保人查询原因不匹配,请重新选择!");
						 return false;
					 }
				}
				record=record.nextUnit;
			}
		}
		}
		var corpCustLoancard=PbocBatchCorpsEnquiry_dataset.getValue("corpCustLoancard");
		 if(reg.test(corpCustLoancard)){
             alert("被查询公司贷款卡卡号/中征码开头或者结尾处存在空格！");
             return false;
         }
		var corpCustCompanyname=PbocBatchCorpsEnquiry_dataset.getValue("corpCustCompanyname");
		 if(reg.test(corpCustCompanyname)){
             alert("被查询公司名称开头或者结尾处存在空格！");
             return false;
         }
		var corpCustPswd=PbocBatchCorpsEnquiry_dataset.getValue("corpCustPswd");
		if(reg.test(corpCustPswd)){
            alert("被查询公司LEID开头或者结尾处存在空格！");
            return false;
        }
		var queryReason1 = PbocBatchCorpsEnquiry_dataset.getValue("queryReason");
		queryReason = encodeURI(encodeURI(queryReason1));
		corpCustLoancard1=encodeURI(encodeURI(corpCustLoancard));
		corpCustCompanyname1=encodeURI(encodeURI(corpCustCompanyname));
		corpCustPswd1=encodeURI(encodeURI(corpCustPswd));
		 dwr.engine.setAsync(false);
		 var flagtp=PrivAction.tCorpPermit12month(corpCustLoancard);//12个月有无查询记录标志
		 var flagtc=PrivAction.tCorpCust12month(corpCustLoancard);//授权书12月内录入标志
		 var isCompanyExpire=PrivAction.isCompanyExpire(corpCustLoancard1,queryReason);//有无授权书标志
		 dwr.engine.setAsync(false);
		 if(corpCustLoancard==""||corpCustCompanyname==""){
			 alert("必输选项不能为空！");
			 return false;
		 }
		 if(isCompanyExpire == "0"){
			 v1=1;
			 alert("Name="+corpCustCompanyname+",ID="+corpCustLoancard+ " 没有查询授权书！");
	    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN.ftl?corpCustCompanyname=" + corpCustCompanyname1 + "&corpCustLoancard=" + corpCustLoancard1 + "&corpCustPswd="+corpCustPswd1,300,300,window);
	    	 return false;
		 }else if(isCompanyExpire == "1"){
			 alert("Name="+corpCustCompanyname+",ID="+corpCustLoancard+ " 查询授权书过期！");
	    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN.ftl?corpCustCompanyname=" + corpCustCompanyname1 + "&corpCustLoancard=" + corpCustLoancard1 + "&corpCustPswd="+corpCustPswd1,300,300,window);
	    	 return false;
		 }else{
			 if(!flagtp && !flagtc && PbocBatchCorpsEnquiry_dataset.getValue("confirmFlag")!="1"){
				 if(confirm("Name="+corpCustCompanyname+",ID="+corpCustLoancard+ "12个月内无查询记录，确定要查询吗？")){
					 PbocBatchCorpsEnquiry_dataset.setValue("confirmFlag","1");
				 }else{
					 PbocBatchCorpsEnquiry_dataset.setValue("confirmFlag","0");
					 return false;
					 }
			 }
		 }
		 if(queryReason1=="01"){
		 if(confirm("请确认‘贷前（保前）审查’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、该客户正在进行业务申请/或为真实业务申请做担保")){
		 }else{
			 return false;
		 }
	 }else if(queryReason1=="02"){
		 if(confirm("请确认‘贷中操作’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、其业务背景的真实性")){
		 }else{
			 return false;
		 }
	 }else if(queryReason1=="03"){
		 if(confirm("请确认‘贷后（在保）管理’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、与我行信贷业务尚未终止")){
		 }else{
			 return false;
		 }
	 }else if(queryReason1=="04"){
		 if(confirm("请确认‘关联查询’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、其业务背景的真实性")){
		 }else{
			 return false;
		 }
	 }else{
		 if(confirm("请确认‘其它理由’查询的:\n1、客户信息正确，\n2、查询授权书有效，及\n3、其业务背景的真实性")){
		 }else{
			 return false;
		 }
		 }
	}
	
    function buttonSave_postSubmit(button){
    	var retParam =button.returnParam;
		var flag = retParam.flag;
    	if(flag=="1"){
    		var corpCustCompanyname1 = PbocBatchCorpsEnquiry_dataset.getValue("corpCustCompanyname");
			var corpCustLoancard1 = PbocBatchCorpsEnquiry_dataset.getValue("corpCustLoancard");
			var corpCustPswd1 = PbocBatchCorpsEnquiry_dataset.getValue("corpCustPswd");
			corpCustCompanyname=encodeURI(encodeURI(corpCustCompanyname1));
			corpCustLoancard=encodeURI(encodeURI(corpCustLoancard1));
			corpCustPswd=encodeURI(encodeURI(corpCustPswd1));
			alert("Name="+corpCustCompanyname1+",ID="+corpCustLoancard1+ " 没有查询授权书！");
	    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN.ftl?corpCustCompanyname=" + corpCustCompanyname + "&corpCustLoancard=" + corpCustLoancard + "&corpCustPswd="+corpCustPswd,300,300,window);		
    		closeWin();
    	}else{
        	button.url="/fpages/business/ftl/PbocBatchCorpsEnquiry.ftl";
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
    	 PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustLoancard",false);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustPswd",false);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustCompanyname",false);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("queryReason",false);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("corpCustType",false);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("queryType",false);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("detailFlag",false);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("relCorpId",false);
	     PbocBatchCorpsEnquiry_dataset.setFieldRequired("relName",false);
	     */
    	 showWin("主管查询授权书", "/fpages/business/ftl/nonWorkhourFileUpload.jsp",300,300,window);
     }
    
    function BtNew_onClickCheck(button){
    	var count=countCurrentAvailbleDataset(PbocCompany_dataset);
    	if(count>=4){
    		BtNew.disable(true);
    	}
    	}
    function BtDel_onClickCheck(button){
    	BtNew.disable(false);
    }
    function companyBtNew_onClickCheck(button){
    	var count=countCurrentAvailbleDataset(IndAppCommonForCom_dataset);
    	if(count>=4){
    		companyBtNew.disable(true);
    	}
    	}
    function companyBtDel_onClickCheck(button){
    	companyBtNew.disable(false);
    }
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