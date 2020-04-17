<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >

<@CommonQueryMacro.page title="">
 <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="CicsActinfoEntryQuery" init="true" submitMode="current">
      		<table width="100%">

      			<tr>
      			  <td colspan="2" valign="top">
      			    <@CommonQueryMacro.Interface id="interface" label="CicsActinfoEntry.interface.interface.label" />
      			  </td>
      			</tr>

      			<tr>

      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>
      			</tr>
      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" fieldStr="actNo[200],curCd[100],cmpCodeType[160],cmpCode[150],actName[300],actType[200],status[50],opnBranchCode[50],opnDate[50],clsDate[50],addr[200],post[100],tel[50],remarks[200],lastUpdTime[150]" width="100%" hasFrame="true" height="350" readonly="true"/>
      			  </td>
      			 </tr>
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
</@CommonQueryMacro.page>