<#import "/templets/commonQuery/CommonQueryTagMacroMng.ftl" as CommonQueryMacro>
<#assign st=RequestParameters["st"]?default("")>
<#assign flag=RequestParameters["flag"]?default("")>
<@CommonQueryMacro.page title="操作员角色管理">
<table width="100%" align="left">
<tr>
<td width="50%" valign="top">
	<table align="left" width="100%">
		<tr align="center">
			<td width="100%" valign="top">
				<@CommonQueryMacro.CommonQuery id="operMngModCom" init="true" navigate="false" submitMode="all" >
						<table frame=void class="grouptable" width="100%">
						<tr>
							<td id="oldHead" nowrap colspan="4" style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改前 </td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd" width="25%"> User NO</td>
							<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrno"/></td>
							<td align="center" nowrap class="labeltd"  width="25%"> User Name </td>
							<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrName" /></td>
						</tr>
						<tr>
		                  <td align="center" nowrap class="labeltd" width="25%">Status Valid</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="flag"/></td>
						  <td align="center" nowrap class="labeltd" width="25%">Lock Status</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="isLock"/></td>
						</tr>
						<tr>
		                  <td align="center" nowrap class="labeltd" width="25%">Login State</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="status"/></td>
						</tr>
					   </table>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr>
			<td width="100%">
				<@CommonQueryMacro.CommonQuery id="operMngRoleInfoCom" init="true" submitMode="selected" navigate="false">
					<@CommonQueryMacro.GroupBox id="guoup2" label="Role Information" expand="true">
						<table frame=void width="100%">
					      	<tr>
					      		<td valign="top">
										<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="roleId[160],sysGroup[160],roleName[450]" hasFrame="true" height="300" width="100%" readonly="false"/>
								</td>
						 	</tr>
						 </table>
					 </@CommonQueryMacro.GroupBox>
					 <br>
					 <table width="100%">
							<tr>
						    	<td colspan="5" align="right">		    				
			    					<@CommonQueryMacro.Button id= "btCancel" />
								</td>
							</tr>
						</table>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
</td>
<td width="50%" valign="top">
	<table align="left" width="100%" id="comSeri">
		<tr id="comSeriReset">
			<td width="100%">
				<table class="grouptable" width="100%">
					<tr>
						<td nowrap style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改后 </td>
					</tr>
					<tr>
						<td nowrap style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 重置密码 </td>
					</tr>
				</table>
			</td>
		</tr>
		<tr align="center" id="ComSeri1">
			<td width="100%">
				<@CommonQueryMacro.CommonQuery id="operMngModComSeri" init="true" navigate="false" submitMode="all" >
						<table frame=void class="grouptable" width="100%">
						<tr>
							<td nowrap colspan="4" style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改后 </td>
						</tr>
						<tr>
							<td align="center" nowrap class="labeltd" width="25%"> Operator NO </td>
							<td class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrno"/></td>
							<td align="center" nowrap class="labeltd"  width="25%"> Operator Name</td>
							<td  class="datatd"  width="25%"><@CommonQueryMacro.SingleField fId="tlrName" /></td>
						</tr>
						<tr>
		                  <td align="center" nowrap class="labeltd" width="25%">Status Valid</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="flag"/></td>
						  <td align="center" nowrap class="labeltd" width="25%">Lock Status</td>
						  <td class="datatd" nowrap><@CommonQueryMacro.SingleField fId="isLock"/></td>
						</tr>
						<tr>
		                  <td align="center" nowrap class="labeltd" width="25%">Login State</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="status"/></td>
						  <td align="center" nowrap class="labeltd" width="25%">EMAIL</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="email"/></td>
						</tr>
                        <tr>
		                  <td align="center" nowrap class="labeltd" width="25%">Contact Way</td>
						  <td class="datatd" nowrap ><@CommonQueryMacro.SingleField fId="contactWay"/></td>
						</tr>
					   </table>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
		<tr id="ComSeri3">
			<td width="100%">
				<@CommonQueryMacro.CommonQuery id="operMngRoleInfoComSeri" init="true" submitMode="selected" navigate="false">
					<@CommonQueryMacro.GroupBox id="guoup2" label="Role Information" expand="true">
						<table frame=void width="100%">
					      	<tr>
					      		<td valign="top">
										<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="roleId[160],sysGroup[160],roleName[450]" hasFrame="true" height="300" width="100%" readonly="false"/>
								</td>
						 	</tr>
						 </table>
					 </@CommonQueryMacro.GroupBox>
				</@CommonQueryMacro.CommonQuery>
			</td>
		</tr>
	</table>
</td>
</tr>
<script language="javascript">
	var st = "${st}";
	var flag = "${flag}";
	function initCallGetter_post(dataset){
		var backOp = operMngModComSeri_dataset.getValue("reset");
		if(st != "2" && flag != "1"){
			document.getElementById("comSeri").style.display="none";
			document.getElementById("oldHead").style.display="none";
		} else if (st == "2" && backOp == "reset") {
			document.getElementById("ComSeri1").style.display="none";
			document.getElementById("ComSeri2").style.display="none";
			document.getElementById("ComSeri3").style.display="none";
		} else if (st == "2" && backOp != "reset") {
			document.getElementById("comSeriReset").style.display="none";
		} else if (st == "1" && flag == "1") {
			document.getElementById("comSeriReset").style.display="none";
		}
	}

	function btCancel_onClick(button) {
		 closeWin();
	}
</script>
</@CommonQueryMacro.page>
