<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >

<@CommonQueryMacro.page title="">
<@CommonQueryMacro.CommonQuery id="CicsActinfoModAdd" init="true" insertOnEmpty="true" >

	
<table width="100%"  align="center">
	<tr>
		<td>
		<@CommonQueryMacro.GroupBox id="CicsActinfoModAdd" label="客户账户信息维护" expand="true">
			<table frame=void class="grouptable" width="100%" align="center">
				<tr>
					<td align="center" nowrap class="labeltd" >账号 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="actNo"/> </td>
                    
				    <td align="center" nowrap class="labeltd" >币种 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="curCd"/> </td>
                   
				</tr>
				<tr>
					<td align="center" nowrap class="labeltd" >证件类型 </td>
	                <td class="datatd" ><@CommonQueryMacro.SingleField fId="cmpCodeType"/> </td>
	                
				    <td align="center" nowrap class="labeltd" >证件号码 </td>
	                <td class="datatd" ><@CommonQueryMacro.SingleField fId="cmpCode"/> </td>
               
                </tr>
                <tr>
					<td align="center" nowrap class="labeltd" >账户名称 </td>
	                <td class="datatd" colspan="3"  ><@CommonQueryMacro.SingleField fId="actName"/> </td>
	                
                </tr>
				<tr>
					<td align="center" nowrap class="labeltd" >账户类型 </td>
	                <td class="datatd" ><@CommonQueryMacro.SingleField fId="actType"/> </td>
	                
				    <td align="center" nowrap class="labeltd" >状态 </td>
	                <td class="datatd" ><@CommonQueryMacro.SingleField fId="status"/> </td>
                </tr>
            	<tr>

                	<td align="center" nowrap class="labeltd" >开户日期 </td>
                	<td class="datatd" ><@CommonQueryMacro.SingleField fId="opnDate"/> </td>
                    
                    <td align="center" nowrap class="labeltd" >关户日期 </td>
                    <td class="datatd" ><@CommonQueryMacro.SingleField fId="clsDate"/> </td>
                   
				</tr>
				<tr>
                     <td align="center" nowrap class="labeltd" >地址 </td>
                     <td class="datatd" colspan="3" ><@CommonQueryMacro.SingleField fId="addr"/> </td>
				</tr>
            	<tr>

	            	<td align="center" nowrap class="labeltd" >邮编 </td>
	            	<td class="datatd" ><@CommonQueryMacro.SingleField fId="post"/> </td>
	                
	                <td align="center" nowrap class="labeltd" >电话 </td>
	                <td class="datatd" ><@CommonQueryMacro.SingleField fId="tel"/> </td>
               
                </tr>
				<tr>
                    <td align="center" nowrap class="labeltd" >备注 </td>
                    <td class="datatd" colspan="3" ><@CommonQueryMacro.SingleField fId="remarks"/> </td>
				</tr>
			</table>
		 </@CommonQueryMacro.GroupBox>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.Button id= "btSave"/>
			<@CommonQueryMacro.Button id= "btBack"/>
		</td>
	</tr>
</table>

</@CommonQueryMacro.CommonQuery>
<script language="javascript">

	var op = "${RequestParameters["op"]?default('')}";

	function initCallGetter_post(dataset) {
		if ("new" == op) {
		} 
		else {
			CicsActinfoModAdd_dataset.setFieldReadOnly("actNo",true);
		}
	}
	
</script>
</@CommonQueryMacro.page>