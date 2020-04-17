<%@ page contentType="text/html;charset=utf-8" language="java"%>
<html>
<head>
<title>menu</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript">
<!--
function turnit(ss)
{
	var oldStatus = ss.style.display;
	closeall();
	if (oldStatus=="none")
		{ss.style.display="";}
	else
		{ss.style.display="none";}
}

function closeit(ss)
{
	   ss.style.display="none";
}

function closeall()
{
   <app:authorize menulevel="0" menuid = "9910101">
	closeit(menu_01);
   </app:authorize>
   <app:authorize menulevel="0" menuid = "9910102">
	closeit(menu_02);
   </app:authorize>
    <app:authorize menulevel="0" menuid = "9910103">
	closeit(menu_03);
   </app:authorize>
}


function init()
{
	closeall();
}
//-->
</script>
<link href="../css/font.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-image: url(../images/left04.jpg);
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
</head>

<body leftmargin="0" rightmargin="0" topmargin="0" marginwidth="0"
	marginheight="0" onLoad="init();">
<TABLE width=138 height="100%" border=0 cellPadding=0 cellSpacing=0>
	<TBODY>
		<TR>
		<tr>
			<td><img src="../images/left01.jpg" width="138" height="13" /></td>
		</tr>
		<TD vAlign=top align="center" height=100% width="100%">
		<TABLE height=1 cellSpacing=0 cellPadding=0 width=100% border=0>
			<TBODY>
				<TR>
					<TD width=100%>
					<TABLE cellSpacing=0 cellPadding=0 width=100% border=0>
						<TBODY>
							<TR>
								<TD vAlign=top width="100%"><!--Menu 01, Begin--> <app:authorize
									menulevel="0" menuid="9910101">

									<TABLE width="100%" border=0 cellPadding=0 cellSpacing=0
										background="../images/left02.jpg">
										<TBODY>
											<TR>
												<TD nowrap height="26" class="leftmenu"
													style="padding-left: 19"
													onmouseup="javascript:turnit(menu_01);">对公客户管理</TD>
											</TR>
										</TBODY>
									</TABLE>

									<TABLE id="menu_01" width="100%" border=0 cellPadding=0
										cellSpacing=0 background="../images/left02.jpg">

										<app:authorize menulevel="0" menuid="10101">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/fpages/customer/ftl/CreateCustCorpBasicInfo.ftl?_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户建立</span></a></TD>

											</TR>
										</app:authorize>


											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/fpages/customer/ftl/ModifyCustCorpInfoQry.ftl?_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户维护</span></a></TD>

											</TR>


											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/fpages/customer/ftl/QueryCustCorpInfoQry.ftl?_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户查询</span></a></TD>

											</TR>

											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_CustomerHandoverQry&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户移交</span></a></TD>

											</TR>



											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_CustomerAidanceManageInfo&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户协管维护</span></a></TD>
											</TR>



											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_CustomerFreeze&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户冻结</span></a></TD>

											</TR>


											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_CustomerUnfreeze&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户解冻</span></a></TD>

											</TR>



											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_CustomerDelete&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户删除</span></a></TD>

											</TR>


										<app:authorize menulevel="0" menuid="10109">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_CustomerResumption&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户恢复</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10110">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_QueryCustomerBlackListInfo&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公黑名单查询</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10111">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_CustomerSynchronize&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">对公客户同步</span></a></TD>

											</TR>
										</app:authorize>
									</TABLE>

								</app:authorize> <!--Menu 01, End--> <!--Menu 02, Begin--> <app:authorize
									menulevel="0" menuid="9910102">
									<TABLE vAlign=top align="center"
										background=../images/left02.jpg height=100% width="100%">
										<TBODY>
											<TR>
												<TD nowrap height="26" class="leftmenu"
													style="padding-left: 15"
													onmouseup="javascript:turnit(menu_02);">自然人客户管理</TD>
											</TR>
										</TBODY>
									</TABLE>

									<TABLE id="menu_02" width="100%" border=0 cellPadding=0
										cellSpacing=0 background="../images/left02.jpg">

										<app:authorize menulevel="0" menuid="10201">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/fpages/customer/ftl/CreateCustIndvBasicInfo.ftl?_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户建立</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10202">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/fpages/customer/ftl/ModifyCustIndvInfoQry.ftl?_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户维护</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10203">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/fpages/customer/ftl/QueryCustIndvInfoQry.ftl?_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户查询</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10204">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_CustIndvHandoverQry&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户移交</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10205">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_IndvCustomerAidanceManageInfo&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户协管维护</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10206">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_IndvCustomerFreeze&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户冻结</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10207">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_IndvCustomerUnfreeze&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户解冻</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10208">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_IndvCustomerDelete&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户删除</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10209">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_IndvCustomerResumption&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户恢复</span></a></TD>

											</TR>
										</app:authorize>

                                       	<app:authorize menulevel="0" menuid="10210">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_QueryIndvCustomerBlackListInfo&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人黑名单查询</span></a></TD>
											</TR>
										</app:authorize>
										
										<!--  
										<app:authorize menulevel="0" menuid="10211">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_IndvCustomerSynchronize&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">自然人客户同步</span></a></TD>
											</TR>
										</app:authorize>
										-->
										
									</TABLE>

								</app:authorize> <!--Menu 02, End--> <!--Menu 03, Begin--> <app:authorize
									menulevel="0" menuid="9910103">
									<TABLE vAlign=top align="center"
										background=../images/left02.jpg height=100% width="100%">
										<TBODY>
											<TR>
												<TD nowrap height="26" class="leftmenu"
													style="padding-left: 15"
													onmouseup="javascript:turnit(menu_03);">合作商协议管理</TD>
											</TR>
										</TBODY>
									</TABLE>

									<TABLE id="menu_03" width="100%" border=0 cellPadding=0
										cellSpacing=0 background="../images/left02.jpg">

										<app:authorize menulevel="0" menuid="10301">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/fpages/customer/ftl/CreateCoopInfoQry.ftl?_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">合作商协议建立</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10302">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/fpages/customer/ftl/ModifyCoopProtInfoQry.ftl?_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">合作商协议维护</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10303">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_TerminateCoopProtInfoQry&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">合作商协议终止</span></a></TD>
											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10304">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_RenewCoopProtInfoQry&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">合作商协议恢复</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10305">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_FreezeCoopProtInfoQry&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">合作商协议冻结</span></a></TD>

											</TR>
										</app:authorize>




										<app:authorize menulevel="0" menuid="10306">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_ThawCoopProtInfoQry&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">合作商协议解冻</span></a></TD>

											</TR>
										</app:authorize>

										<app:authorize menulevel="0" menuid="10307">
											<tr>
												<td class="leftmenu" style="padding-left: 15"><img
												src="../images/left05.jpg" width="119" height="2" /></td>
											</tr>
											<TR height=20>
												<TD class="menu_level2"><a
													href='<%=response.encodeURL(request.getContextPath()+"/trans/CommQueryServlet?CQId=Customer_QueryCoopProtInfoQry&_cds_=0")%>'
													target="businessfrm"><span class="leftmenubranch">合作商协议查询</span></a></TD>

											</TR>
										</app:authorize>
									</TABLE>
								</app:authorize> <!--Menu 03, End--></TD>
						</TBODY>
					</TABLE>
					</TD>
				</TR>
			</TBODY>
			<TABLE cellSpacing=0 cellPadding=0 width=100% border=0>
				<TBODY>
					<TR>
						<TD><img src="../images/left03.jpg" width="138" height="15" /></TD>
					</TR>
				</TBODY>
			</TABLE>
		</TABLE>
		</TD>
	</TBODY>
</TABLE>
</body>
</html>
