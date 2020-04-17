<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<style>
body { 
font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
color: #4f6b72; 
} 
#mytable { 
width: 100%; 
padding: 0; 
margin: 0; 
} 
td{
padding: 0; 
margin: 0; 
height:40px;
}
tr{
padding: 0; 
margin: 0; 
}

</style> 

  <body >
	<table id="mytable">
		<tr>
			<td align="left" bgcolor="ECF1F4">
				<span>
				<font class="gray">
				<% 
		 			List errorList = (List)request.getAttribute("errors");
	   				if(errorList == null || errorList.isEmpty()) {
	   	 		%>
					导入成功
				<%
   					}else{
   				%>
   				    导入时发生错误，错误信息如下：</font>
				</span></td>
		</tr>
		<tr>
			<td class="listcenter_right">
			 	<ul>
   				<%
	   				for(int i = 0; i < errorList.size(); i++){
				%>
	   	 		<li>
				<%=errorList.get(i).toString()%>
				<%}
   				}
   				%>
   				</ul>
			</td>
		</tr>
		<tr>
			<td class="listcenter_right">
				<a href="javascript:history.go(-1);">返回导入页面</a>
			</td>
		</tr>
	</table>
  </body>
  
  <script type="text/javascript">
	function goHistory(p){
		window.setTimeout("historyA",3000,p);
	}
	function historyA(p){
		history.go(p);
	}
	</script>
</html>
