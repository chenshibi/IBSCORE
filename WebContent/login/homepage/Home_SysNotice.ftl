<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >

<#assign id=RequestParameters["id"]?default("")>
<@CommonQueryMacro.page title="">
 <table align="left" width="100%">
   <tr>
      <td >
      	<@CommonQueryMacro.CommonQuery id="Home_SysNotice" init="true" submitMode="current">
			<table width="100%">
				<tr>
					<td valign="top" width="50%">
						<FIELDSET name='group6' style="padding: 6px;">
						<LEGEND>系统公告列表</LEGEND>
							<@CommonQueryMacro.DataTable id="datatable1" fieldStr="noticeTitle[300],startDate[100],endDate[100],crtTm[180],crtTlr[120]" width="100%" hasFrame="true" height="330" readonly="true" />
						</FIELDSET>
					</td>
					<td width="45%">
						<@CommonQueryMacro.Group id="group1" label="系统公告信息"  fieldStr="startDate,endDate,crtTm,crtTlr,noticeTitle,noticeContent" colNm=2/>
					</td>
				</tr>
			</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">

	var id="${id}";

	function initCallGetter_post(){
		if(id != "" && id.length > 0){
			locate(id);
		}
	}

	//定位一条记录
	function locate(id) {
		var record = Home_SysNotice_dataset.find(["id"],[id]);
		if (record) {
			Home_SysNotice_dataset.setRecord(record);
		}
	}
</script>
</@CommonQueryMacro.page>