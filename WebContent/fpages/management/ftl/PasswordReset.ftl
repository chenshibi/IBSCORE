<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="操作员密码重置">

<@CommonQueryMacro.CommonQuery id="passwordReset" >

<table width="">
<tr>
<td>
			<@CommonQueryMacro.Group id="group1" label="操作员密码置" fieldStr="tlrno" colNm=2/>
</td>
</tr>
<tr>
<td align="center">
			<@CommonQueryMacro.Button id= "btUpd"/>
</td>
</tr>
</table>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.page>