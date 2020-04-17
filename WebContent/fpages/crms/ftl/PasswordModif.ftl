<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<@CommonQueryMacro.page title="二代征信修改密码">
		<@CommonQueryMacro.CommonQuery id="updatePwd">
		<table width="100%" align="left" >
        <tr>
         <td>
			<@CommonQueryMacro.Group id="group1" label="二代修改密码" fieldStr="oldPassWord,newPassWord,againNewPassWord" colNm=2/>
         </td>
        </tr>
        <tr>
        <td align="center">
			<@CommonQueryMacro.Button id= "btSave"/>
        </td>
        </tr>
        </table>
        </@CommonQueryMacro.CommonQuery>
		<@CommonQueryMacro.CommonQuery id="PasswordModify" init="true" submitMode="current" navigate="false" >
			<table align="right"  width="100%">
				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="10" showArrow="true" />
					</td>
		    	</tr>
		    	<tr >
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1"  fitColumns="true" fieldStr="userCode,resultCode,resultDesc,reportName,reportMessagePath,receiptTime,recordStatus"  hasFrame="true" width="100%"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
 function btSave_onClickCheck(button) {
  var oldPasswd = updatePwd_dataset.getValue("oldPassWord");
  var newPasswd = updatePwd_dataset.getValue("newPassWord");
  var newPasswdSure = updatePwd_dataset.getValue("againNewPassWord");
  if(oldPasswd=="" || newPasswd=="" || newPasswdSure==""){
   alert("请检查参数后再进行提交！");
   return false;
  }
	if(newPasswd!=newPasswdSure){
		alert("两次输入的新密码不相同");
		return false;
		
	}
	return true;
 }
 
 function btSave_postSubmit(button){
        if(button.returnParam.errMsg!=null){
          alert(button.returnParam.errMsg);
        }if(button.returnParam.successMsg!=null){
          alert(button.returnParam.successMsg);
        }
        }
 
</script>
</@CommonQueryMacro.page>