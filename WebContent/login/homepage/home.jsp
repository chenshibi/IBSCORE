<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.huateng.ebank.framework.util.DateUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.huateng.report.downloadfile.utils.ReportDownLoadFileResource"%>
<%@page import="com.huateng.report.downloadfile.bean.DataDownLoadFileBean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/easyui/themes/blue/easyui.css">
<style type="text/css">
	.bodycls{
		overflow:hidden;
		padding:0px;
		margin:3px;
		font-size:12px;
		font-family: Arial,Helvetica,sans-serif;
	}
	.tabletop{
		border: 1px solid #aed0ea;
	}
	 .tabletoptd1{
		border-bottom: 1px solid #aed0ea;
		background:#e8f3fb url("<%=request.getContextPath()%>/login/homepage/image/home_titbg.gif") repeat-x;
		padding-left: 2px;
	}

	/* .tabletoptd1div{
		margin-right: 1px;
		margin-top: 1px;
		height:26px;
		line-height: 26px;
		font-size: 12px;
		border: 1px solid #aed0ea;
		border-bottom-width:0px;
		background:#ffffff;
		position: relative;
		z-index: 10;
		bottom: -1px;
		cursor: default;
		color: #336699;
		font-weight:600;
		float: left;
	} */

	/* .tabletoptd2div{
		margin-right: 1px;
		font-size: 12px;
		border: 1px solid #aed0ea;
		border-bottom-width:0px;
		position: relative;
		z-index: 10;
		cursor: pointer;
		color: #336699;
		font-weight:600;
		float: left;
		bottom:0px;
		background:#f2f7fb;
		margin-top: 2px;
		height:25px;
		line-height: 25px;
	} */

	.tabletoptd2{
		width:100%;
		height:100%;
	}
	a{
		text-decoration: none;
	}

</style>

</head>
<body scroll="no" class="bodycls" bgcolor="#ffffff">
<div id="maxWin" style="border: 1px solid #aed0ea;display: none;"></div>
<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%">
<tr height="100%" >
	<td width="180px">
	<table cellpadding="0" cellspacing="5" border="0" width="180px" height="100%">
		<tr>
		<td height="100%" class="tabletop"   id="td_frame0">
		<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%"  ondblclick="maxFrm(0)">
		<tr>
			<td class="tabletoptd1" nowrap="nowrap" valign="bottom" width="100%">
			<a class="tabletoptd1div">&nbsp;&nbsp;个人收藏夹&nbsp;&nbsp;</a>
			</td>
			<td width="60px" style="padding-right: 8px" class="tabletoptd1"  nowrap="nowrap" align="right">
				<img src="<%=request.getContextPath()%>/login/homepage/image/home_ref.gif" border="0" style="cursor: pointer;" title="刷新" onclick="refFrm('frame0')"/>
				<img src="<%=request.getContextPath()%>/login/homepage/image/home_max.gif" border="0" style="cursor: pointer;" title="最大化" onclick="maxFrm(0)"/>
			</td>
			</tr>
			<tr>
			<td class="tabletoptd2" valign="top" colspan="2">
			<iframe id="frame0" height="100%" width="100%"  scrolling="auto" frameborder="0" src="<%=request.getContextPath() %>/login/homepage/home_favorites.jsp" ></iframe>
			</td>
		</tr>
		</table>
		</td>
		</tr>
	</table>
	</td>
	<td width="100%">
		<table cellpadding="0" cellspacing="5" border="0" width="100%" height="100%">
			<tr>
			<td  height="200px" class="tabletop"  id="td_frame1">
				<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" ondblclick="maxFrm(1)">
					<tr>
						<td class="tabletoptd1" nowrap="nowrap" valign="bottom" width="100%">
						<a class="tabletoptd1div" onclick="changeSel(this,1,'<%=request.getContextPath() %>/login/homepage/home_login.jsp');return false;" href='javascript:void(0);'>&nbsp;&nbsp;登录信息&nbsp;&nbsp;</a>
						</td>
						<td width="60px" style="padding-right: 8px" class="tabletoptd1"  nowrap="nowrap" align="right">
							<img src="<%=request.getContextPath()%>/login/homepage/image/home_ref.gif" border="0" style="cursor: pointer;" title="刷新" onclick="refFrm('frame1')"/>
							<img src="<%=request.getContextPath()%>/login/homepage/image/home_max.gif" border="0" style="cursor: pointer;" title="最大化" onclick="maxFrm(1)"/>
						</td>
					</tr>
					<tr>
						<td class="tabletoptd2" valign="top">
						<iframe id="frame1" height="100%" width="100%"  scrolling="auto" frameborder="0"  src="<%=request.getContextPath() %>/login/homepage/home_login.jsp"></iframe>
						</td>
					</tr>
				</table>
			</td>
			</tr>
			<tr>
			
			</tr>
			
		</table>
	</td>
	
		</tr>
	</table>
	</td>
</tr>
</table>
<input type="hidden" name="noticeView" id="noticeView" value="">
<script type="text/javascript">
	function refFrm(frmnm){
		window.setTimeout("document.getElementById('"+frmnm+"').contentWindow.location.reload()",0);
	}

	function maxFrm(seq){
		var mw = document.getElementById("maxWin");
		if(mw.style.display=="none"){
			var tmp = document.getElementById("td_frame"+seq).innerHTML;
			if(tmp!=null && tmp.length>0){
				tmp = tmp.replace("home_max.gif","home_min.gif").replace("最大化","还原");
				if(seq==0){
					var reg=new RegExp("(/login/homepage/home_favorites.jsp)","g");
					tmp = tmp.replace(reg,"/fpages/management/jsp/favorites_set.jsp");
				}if(seq==1){
					var reg=new RegExp("(/login/homepage/home_login.jsp)","g");
					tmp = tmp.replace(reg,"/login/homepage/home_login.jsp");
				}else if(seq==2){
					var reg=new RegExp("(home_CreditMonitor.jsp)","g");
					tmp = tmp.replace(reg,"CreditMonitor.jsp");
				}else if(seq==10){
					var id = document.getElementById("noticeView").value;
					if(id != null && id.length > 0){
						tmp = tmp.replace("/login/homepage/home_notice.jsp","/login/homepage/Home_SysNotice.ftl?id=" + id);
					} else {
						tmp = tmp.replace("/login/homepage/home_notice.jsp","/login/homepage/Home_SysNotice.ftl");
					}
					document.getElementById("noticeView").value = "";
				}
				var str =  "<table cellpadding='0' cellspacing='0' border='1' width='100%' height='100%'><tr><td>"+tmp+"</td></tr></table>";
				mw.innerHTML =str;
				mw.style.display = "";
			}
		}else{
			mw.style.display = "none";
			mw.innerHTML = "";
			if(seq==0){
				refFrm("frame0");
			}
		}
	}

	function SaveAs(url){
	    var a  = document.getElementById("filedownloadfrm");
	    a.src = url;
	    return false;
  	}


	 function changeSel(obj,idx,url){
		var nodes = obj.parentNode.childNodes;
		for(var i=0;i<nodes.length;i++){
			if(nodes[i].tagName=="A" && nodes[i]!=obj){
				nodes[i].className = "tabletoptd2div";
			}
		}
		obj.className = "tabletoptd1div";

		document.getElementById("frame"+idx).src = url;
	}
 

</script>
</body>
</html>