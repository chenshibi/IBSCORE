<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st=RequestParameters["st"]?default("")>
<@CommonQueryMacro.page title="系统公告维护">
<table width="100%" align="left">
<tr>
<td width="50%" valign="top">
	<@CommonQueryMacro.CommonQuery id="SysNoticeOld" init="true" navigate="false" submitMode="all" >
		<table width="100%">
			<tr>
				<td width="100%" id="oldHead" nowrap style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改前 </td>
			</tr>
			<tr>
				<td width="100%">
				<@CommonQueryMacro.Group id ="group1" label="系统公告详细信息" fieldStr="startDate,endDate,noticeTitle,noticeContent" colNm=2/>
				</td>
			</tr>
			<tr>
				<td>
					<@CommonQueryMacro.Button id="btBack"/>
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
</td>
<td width="50%" valign="top">
	<table width="100%" id="newHead"><tr><td width="100%">
	<@CommonQueryMacro.CommonQuery id="SysNoticeNew" init="true" navigate="false" submitMode="all" >
		<table width="100%">
			<tr>
				<td width="100%" nowrap style="BORDER-BOTTOM: #ccc 1px solid; TEXT-ALIGN: center; BORDER-LEFT: #ccc 1px solid; PADDING-LEFT: 10px; BACKGROUND: #d6e5f8; HEIGHT: 25px; BORDER-TOP: #ccc 1px solid; BORDER-RIGHT: #ccc 1px solid" align="center"> 修改后 </td>
			</tr>
			<tr>
				<td width="100%">
				<@CommonQueryMacro.Group id ="group2" label="系统公告详细信息" fieldStr="startDate,endDate,noticeTitle,noticeContent" colNm=2/>
				</td>
			</tr>
		</table>
	</@CommonQueryMacro.CommonQuery>
	</td></tr></table>
</td>
</tr>
</table>

<script language="javascript">

	var st = "${st}";

	function initCallGetter_post(dataset){
		if(st != "2"){
			document.getElementById("oldHead").style.display="none";
			document.getElementById("newHead").style.display="none";
		}
		SysNoticeOld_dataset.setFieldReadOnly("startDate",true);
		SysNoticeOld_dataset.setFieldReadOnly("endDate",true);
		SysNoticeOld_dataset.setFieldReadOnly("noticeTitle",true);
		SysNoticeOld_dataset.setFieldReadOnly("noticeContent",true);
		SysNoticeNew_dataset.setFieldReadOnly("startDate",true);
		SysNoticeNew_dataset.setFieldReadOnly("endDate",true);
		SysNoticeNew_dataset.setFieldReadOnly("noticeTitle",true);
		SysNoticeNew_dataset.setFieldReadOnly("noticeContent",true);
	}

	function btBack_onClick(button){
       closeWin();
    }
</script>
</@CommonQueryMacro.page>