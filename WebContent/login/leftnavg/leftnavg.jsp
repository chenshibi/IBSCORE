<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.List"%>
<%@page import="com.huateng.report.utils.ReportUtils"%>
<%@page import="resource.bean.report.SysBusinavConf"%>
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.framework.util.DateUtil"%>
<%@page import="com.huateng.ebank.business.common.DataDicUtils"%>
<%@page import="com.huateng.ebank.framework.report.common.ReportConstant"%>
<%@page import="com.huateng.report.common.service.ReportCommonService"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/login/css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/login/leftnavg/css/leftnavg.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/login/leftnavg/js/leftnavg.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/login/ymPrompt/dhtml/ymPrompt.css">
<script type='text/javascript' src='<%=request.getContextPath()%>/login/ymPrompt/ymPrompt.js'> </script>
<script type='text/javascript' src='<%=request.getContextPath()%>/js/report.js'> </script>
<%
String code = request.getParameter("code");
//Modify by cwenao 2014/1/17
//&funcId
String funcId = request.getParameter("funcId");

String type = request.getParameter("type")==null?"write":request.getParameter("type");

boolean isAnanly = true;
String workdate = "";
String dicName = "";
List leftNvgList = null;
String tlrNo="";
String paramValue = ReportUtils.getSysParamsValue("100","0001");
if(paramValue.equals("1") && type.equals("write")){
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
GlobalInfo.setCurrentInstance(globalInfo);
workdate = DateUtil.dateToNumber(globalInfo.getTxdate());
ReportCommonService commonService = ReportCommonService.getInstance();
SysBusinavConf busiconf = commonService.getSysBusinavConf(code);
dicName = DataDicUtils.getDicName(String.valueOf(ReportConstant.DATA_DIC_BUSI_TYPE_NO), busiconf.getBusiType());
//Modify by cwenao 2014/1/17
//获取登录用户ID
tlrNo = globalInfo.getTlrno();

}
//List leftList = ReportUtils.getLeftNavgList(code);

//Modify by cwenao 2014/1/17
//修改获取列表方法
List leftList = ReportUtils.getLeftNavgList(code,funcId,tlrNo);
if(leftList==null||leftList.size()==0){
%>
<script type="text/javascript">
document.write("未传入业务编码或编码不存在！");
</script>
<%return;} %>
</head>
<body scroll="no" class="bodycls">
<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%">
<tr height="100%">
<td width="140px" valign="top" nowrap="nowrap" id="leftTd">
<%
String currentTab = "";
for(int i=0;i<leftList.size();i++){
	SysBusinavConf conf = (SysBusinavConf)leftList.get(i);
	String url = "";
	if(type.equalsIgnoreCase("write")){
		url = conf.getUrlPath()==null?"":request.getContextPath()+conf.getUrlPath().trim();
	}else if(type.equalsIgnoreCase("approve")){
		url = conf.getApproveUrl()==null?"":request.getContextPath()+conf.getApproveUrl().trim();
	}else if(type.equalsIgnoreCase("query")){
		url = conf.getQueryUrl()==null?"":request.getContextPath()+conf.getQueryUrl().trim();
	}else if(type.equalsIgnoreCase("file")){
		url = conf.getMakefileUrl()==null?"":request.getContextPath()+conf.getMakefileUrl().trim();
	}
%>
<div class="DivAround_blur" id="tab_<%=conf.getId() %>" title="<%=conf.getBusiNm() %>" onClick="ChangeFocus('<%=conf.getId() %>');" onmouseover="tabMouseOver(this);" onmouseout="tabMouserOut(this);"><%=conf.getBusiNm() %>
<input type="hidden" name="leftTab" value="<%=conf.getId() %>"/>
<input type="hidden" id="tab_url_<%=conf.getId() %>" value="<%= url %>"/>
</div>
<%} %>
<div style="width: 100%;height: 100%;cursor: default;" ondblclick="showOrHiddenLeft(2)" title="双击隐藏或显示左侧导航" id="leftDivBtn"></div>
</td>
<td valign="top" width="100%">
<input type="hidden" id="curretnTab" value="<%=currentTab %>">
<div class="DivAround_content" id="frmDiv">
<div id="msgDiv" style="display: none;width: 90%;line-height:30px;padding-top: 20px;padding-left: 20px;font-size: 16px;"></div>
<iframe id="leftNavgframe" height="100%" width="100%"  scrolling="auto" frameborder="0"></iframe>
</div>
</td>
</tr>
</table>
<script type="text/javascript">
	window.onload= function(){
		initLeft(0);
	}
</script>
</body>
</html>