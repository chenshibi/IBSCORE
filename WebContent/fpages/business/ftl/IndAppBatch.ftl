<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<%
	String contextPath = request.getContextPath();//获取应用名称
	String servletPath=contextPath+"/servlet/UploadServlet";
	String info = (String)request.getAttribute("info");
%>
<@CommonQueryMacro.page title="IndAppRequest.title">
<table align="left" width="100%"><tr><td>
<@CommonQueryMacro.CommonQuery id="IndAppRequest" init="false" submitMode="current">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table id="listTable" width="98%" align="center" border="0">
				<form name="excelForm" method="post" ENCTYPE="multipart/form-data"  >
					<tr class="text01" bgcolor="#FFFFFF" style="">
						<td width="15%"></td>
						<td width="21%" align="right">文件位置：&nbsp;</td>
						<td width="54%">
							<input type="file" id="filePath" name="filePath" class="input02" size="20" 
								onpaste="return false" onkeydown="return false" >
						</td>
						<td width="10%"></td>
					</tr>
					<tr class="text01" bgcolor="#FFFFFF" height="30">
						<td colspan="3" valign="bottom" align="center">
							<input type="button" id="uploadBtn" name="uploadBtn" class="button" 
								style="width:100px;height:20px" value="提交" onclick="uploadFile();">
						</td>
						<td></td>
					</tr>
				</form>
			</table>
</@CommonQueryMacro.GroupBox>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">
function uploadFile() {
		var filePath = excelForm.filePath.value;
		if( _check(excelForm) ){
			if(filePath!=''){	
					excelForm.action="<%=servletPath%>?method=uploadFile&fieldKey=filePath";
					excelForm.submit();
			}else {
				showMsg( '请选择上传的文件！' , "error" , "1" );
				disableBtns(false);
				return false;
			}
		}else{
			disableBtns(false);
			return false;
		}
	}
</script>
</@CommonQueryMacro.page>