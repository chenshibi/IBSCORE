<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >

<@CommonQueryMacro.page title="系统公告详细信息">
 <table align="left" width="900px">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="SysNoticeDetail" init="true" submitMode="current">
		     <@CommonQueryMacro.Group id ="group1" label="系统公告详细信息" fieldStr="startDate,endDate,crtTm,crtTlr,lstUpdTm,lstUpdTlr,noticeTitle,noticeContent" colNm=4/>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">

	function initCallGetter_post(){
		SysNoticeDetail_dataset.setFieldReadOnly("startDate", true);
		SysNoticeDetail_dataset.setFieldReadOnly("endDate", true);
		SysNoticeDetail_dataset.setFieldReadOnly("crtTm", true);
		SysNoticeDetail_dataset.setFieldReadOnly("crtTlr", true);
		SysNoticeDetail_dataset.setFieldReadOnly("lstUpdTm", true);
		SysNoticeDetail_dataset.setFieldReadOnly("lstUpdTlr", true);
		SysNoticeDetail_dataset.setFieldReadOnly("noticeTitle", true);
		SysNoticeDetail_dataset.setFieldReadOnly("noticeContent", true);
	}

</script>
</@CommonQueryMacro.page>