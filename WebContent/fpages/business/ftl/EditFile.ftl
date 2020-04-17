<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="文件编辑">
<@CommonQueryMacro.CommonQuery id="EditFile" init="false" submitMode="all" navigate="false" >
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table  width="100%">
		<tr>
			<td width="100%" align="left">
				<@CommonQueryMacro.Group id="group1" label="文件编辑"  fieldStr="sgement,product,scope,note,flag" colNm=1 /></br>
			</td>
		</tr>
		<tr>
    		<td  align="center">
				<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;  
    		</td>
    	</tr>
	</table>
	</@CommonQueryMacro.GroupBox>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
 
function initCallGetter_post(dataset) {
	var sgement=EditFile_dataset.getParameter("sgement");
	var id=EditFile_dataset.getParameter("id");
	var product=EditFile_dataset.getParameter("product");
	var scope=EditFile_dataset.getParameter("scope");
	var note=EditFile_dataset.getParameter("note");
	var flag=EditFile_dataset.getParameter("flag");
	EditFile_dataset.setValue("sgement",sgement);
	EditFile_dataset.setValue("id",id);
	EditFile_dataset.setValue("product",product);
	EditFile_dataset.setValue("scope",scope);
	EditFile_dataset.setValue("note",note);
	EditFile_dataset.setValue("flag",flag);

}
 function btSave_postSubmit(button){
   		alert("提交成功！");
   		closeWin();
	}
</script>
</@CommonQueryMacro.page>