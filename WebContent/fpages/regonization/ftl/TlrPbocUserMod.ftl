<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="操作员角色管理">
<table align="left" width="100%">
    <tr align="center">
        <td width="100%" colspan="6">
<@CommonQueryMacro.CommonQuery id="PBOCPswChange" init="init" navigate="false" submitMode="all">
<FIELDSET name='guoup' style="padding: 6px;">
 <LEGEND extra="groupboxtitle">修改密码</LEGEND>
   <table frame=void class="grouptable" width="100%"  >
                        <tr>
                            <td align="right" nowrap class="labeltd" width="40%"> 账号：</td>
                            <td class="datatd" width="50%"><@CommonQueryMacro.SingleField fId="userNo"/></td>
                        </tr> 
                        <tr > 
                        <td>&nbsp;</td>
                        </tr>
                        <tr > 
                            <td align="right" nowrap class="labeltd" width="40%"> 原始密码：</td>
                            <td class="datatd" width="50%"><@CommonQueryMacro.SingleField fId="userPswdOld" /></td>
                        </tr> 
                        <tr > 
                        <td>&nbsp;</td>
                        </tr>
                        <tr > 
                            <td align="right" nowrap class="labeltd" width="40%"> 新密码：</td>
                            <td class="datatd" width="50%"><@CommonQueryMacro.SingleField fId="userPswdNow" /></td>
                        </tr> 
                        <tr>
                         <td>&nbsp;</td>
                         </tr>
                          <tr > 
                            <td align="right" nowrap class="labeltd" width="40%"> 确认新密码：</td>
                            <td class="datatd" width="50%"><@CommonQueryMacro.SingleField fId="userPswdNowConfirm" /></td>
                        </tr> 
                          <tr>
                         <td>&nbsp;</td>
                         </tr>
                          <tr>
                         <td>&nbsp;</td>
                         </tr>
                <tr>
    		<td colspan="2" align="center">
				<@CommonQueryMacro.Button id= "btSave"/>
				<@CommonQueryMacro.Button id= "btCancel"/>
    		</td>
    	</tr>	
                        
                    </table>
	 	
	
 </FIELDSET>

</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>
<script language="javascript">

  function initCallGetter_post(dataset) {
	  var userNo=PBOCPswChange_dataset.getParameter("userNo");
	  var userType=PBOCPswChange_dataset.getParameter("userType");
	  var statusPswd=PBOCPswChange_dataset.getParameter("statusPswd");
	  PBOCPswChange_dataset.setValue("userNo",userNo);
	  PBOCPswChange_dataset.setValue("userType",userType);
	  PBOCPswChange_dataset.setValue("statusPswd",statusPswd);
	  PBOCPswChange_dataset.setFieldReadOnly("userNo", true);
    }
  function btSave_onClickCheck(button){
	  var userNo=PBOCPswChange_dataset.getValue("userNo");
	  var oldUserPswd=PBOCPswChange_dataset.getParameter("userPswdOld");
	  oldUserPswd=decodeURI(decodeURI(oldUserPswd));
	  oldUserPswd=oldUserPswd.replace(" ","")
	  var userPswdNowConfirm=PBOCPswChange_dataset.getValue("userPswdNowConfirm");
	  var userPswdNow=PBOCPswChange_dataset.getValue("userPswdNow");
	  var userPswdOld=PBOCPswChange_dataset.getValue("userPswdOld");
	  if(userPswdNowConfirm!=userPswdNow){
		  alert("两次新密码不一样，请确认后输入！");
		  return false;
	  }
	  if(userPswdOld==userPswdNow){
		  alert("新密码和原始密码相同！");
		  return false;
	  }
  }
  function btSave_postSubmit(button){
	//  button.url="/fpages/regonization/ftl/TlrPbocUserMod.ftl";
	  alert("修改完成！");
	  button.url="/fpages/regonization/ftl/PBOCPswChange.ftl";
  }
</script>
</@CommonQueryMacro.page>
