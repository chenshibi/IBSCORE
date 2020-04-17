<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="原始企业征信报告查询">
<style>
a:link,a:visited{font-size:16px}
</style>
<@CommonQueryMacro.CommonQuery id="CompanyReport" init="false" submitMode="current" navigate="false">
	<table align="left" width="100%">
     <tr valign="center">
       			<td valign="top">
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
				</td>
     </tr>
     <tr>
      		<td valign="top">
      			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
      		</td>
	 </tr>
     <tr>
      		<td>
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="opr[200],rptKey[180],corpCustLoancard[120],corpCustCompanyname[200],entCertType,entCertNum,corpCustType,queryReason,serviceCode,status[120],detailstatus[120],createTime[120],createUser[80],consentFilePath[200],detailFlag,ccreturnTime[140],tcdareturnTime[140],relName,relCorpId,down[300]" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function CompanyReport_interface_dataset_btnSubmit_onClickCheck(){
	var corpCustLoancard = CompanyReport_interface_dataset.getValue("corpCustLoancard");
	var corpCustCompanyname = CompanyReport_interface_dataset.getValue("corpCustCompanyname");
	var rptKey = CompanyReport_interface_dataset.getValue("rptKey");
	var MyQuery = CompanyReport_interface_dataset.getValue("MyQuery");
	if((corpCustLoancard==null||corpCustLoancard=="")&&(corpCustCompanyname==null||corpCustCompanyname=="")
	&&(rptKey==null||rptKey=="")&&(MyQuery==null||MyQuery=="")){
		alert("请至少选填一个查询条件！");
		return false;
	}
}
function datatable1_down_onRefresh(cell,value,record) {
	var nonWorkhourFilepath=record.getValue("nonWorkhourFilepath");
	var nonWorkhourFile=nonWorkhourFilepath.substring(nonWorkhourFilepath.lastIndexOf("\/")+1,nonWorkhourFilepath.length);
	var htmlStr = "<center>";
	htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:downNonWorkFile('"+nonWorkhourFilepath+"')\">"+nonWorkhourFile+"</a>";
	cell.innerHTML=htmlStr;
	
}
//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var ccreturnTime=record.getValue("ccreturnTime").format("yyyyMMdd HH:mm:ss");
	var consentFilePath2=record.getValue("consentFilePath2");
	var detailrptKey = record.getValue("detailrptKey");
	var relName = record.getValue("relName");
	var relCorpId = record.getValue("relCorpId");
	var Id = record.getValue("id");
	var status = record.getValue("status");
	var corpCustType="";
	var CorpCustType = record.getValue("corpCustType");//客户属性
	var entName=record.getValue("corpCustCompanyname");
//	var entCertType=record.getValue("corpCustLoancard");
	var queryReason=record.getValue("queryReason");
	var createUser=record.getValue("createUser");
	if("1-借款公司"==CorpCustType){
		corpCustType="1";
	}
	else if("2-担保公司"==CorpCustType){
		corpCustType="2";
	}
	else {
		corpCustType="";
	}
//	var corpCustLoancard = record.getValue("corpCustLoancard");//中征码
//	var corpCustCompanyname = record.getValue("corpCustCompanyname");//客户名称
    var entCertType=record.getValue("entCertType"); //企业身份标识类型
    var entCertNum=record.getValue("entCertNum"); //企业身份标识号码
    var serviceCode=record.getValue("serviceCode"); //服务代码
	var funcid1 = record.getValue("funcid1");//关联信息
	var funcid2 = record.getValue("funcid2");//身份信息
	var funcid3 = record.getValue("funcid3");//主要出资人信息、高管人员信息(
	var funcid4 = record.getValue("funcid4");//有直接关联关系的其他企业
	var funcid5 = record.getValue("funcid5");//信息概要 
	var funcid6 = record.getValue("funcid6");//信贷记录明细
	var funcid7 = record.getValue("funcid7");//公共记录明细
	var funcid8 = record.getValue("funcid8");//声明信息明细
	var funcid10 = record.getValue("funcid10");
	var funcid11 = record.getValue("funcid11");
	var funcid12 = record.getValue("funcid12");
	var funcid13 = record.getValue("funcid13");
	var funcid14 = record.getValue("funcid14");
	var funcid15 = record.getValue("funcid15");
	var htmlStr = "<center>";
	var tlrno = "${v_tlrno}";
	dwr.engine.setAsync(false);
    var flag=PrivAction.haveRole(tlrno,ccreturnTime,"corp");    //30天内或有权限
 	dwr.engine.setAsync(false);
 	 
	if (record) {//当存在记录时
		if(flag){
		
		if("66662404"==funcid13){
			htmlStr=htmlStr+"<a href=\"javascript:dodownloadStair('"+rptKey+"','"+status+"')\">企业一般信用报告</a>";
		}
		if("66662402"==funcid11){
			htmlStr=htmlStr+"&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"JavaScript:showCompanyInfo('"+rptKey+"','"+ccreturnTime+"','"+corpCustType+"','"+Id+"','"+relName+"','"+relCorpId+"','"+funcid1+"','"+funcid2+"','"+funcid3+"','"+funcid4+"','"+funcid5+"','"+funcid6+"','"+funcid7+"','"+funcid8+"','"+status+"')\">企业信息汇总</a>";
		}	
		if("66662405"==funcid14){
			htmlStr=htmlStr+"&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"JavaScript:showCompanyInfoCheck('"+rptKey+"','"+corpCustType+"','"+Id+"','"+relName+"','"+relCorpId+"','"+funcid1+"','"+funcid2+"','"+funcid3+"','"+funcid4+"','"+funcid5+"','"+funcid6+"','"+funcid7+"','"+funcid8+"','"+status+"')\">企业信息核验</a>";
		}
			
		if("66662401"==funcid10){
			htmlStr=htmlStr+"&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:dodownload('"+rptKey+"','"+status+"')\">企业一般信息展开(二级)</a>";
		}
		if("66662403"==funcid12){
			htmlStr=htmlStr+"&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:dodownload1('"+detailrptKey+"','"+status+"')\">企业明细信息展开</a>"
		}
		}
		if("66662406"==funcid15){
			htmlStr=htmlStr+"&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:dodownload2('"+Id+"')\">查询授权书下载</a>";
		}
		 //htmlStr=htmlStr+"&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:twoService('"+entName+"','"+entCertType+"','"+entCertNum+"','"+queryReason+"','"+serviceCode+"')\">二代接口</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function downNonWorkFile(nonWorkhourFilepath){
		alert (nonWorkhourFilepath);
	window.location.href="${contextPath}/DownloadNonWorkFileAction.do?nonWorkhourFilepath="+nonWorkhourFilepath;
	}
function dodownloadStair(rptKey,status){
	if(status!="0"){
		alert("未成功查询!");
	}else
	if("-" != rptKey && "" != rptKey.trim()){
		dwr.engine.setAsync(false);
		var flag=PrivAction.test(rptKey);
		dwr.engine.setAsync(false);
		if(flag=="1"){
	//alert(rptKey);
		window.location.href="${contextPath}/DownloadStirCorpCustAction.do?rptKey="+rptKey;}
		else{
			alert("The file does not exists！");
		}
	}else{
			alert("报告不存在!");
	}
}
function dodownload(rptKey,status){
	if(status!="0"){
		alert("未成功查询!");
	}else
	if("-" != rptKey && "" != rptKey.trim()){
		dwr.engine.setAsync(false);
		var flag=PrivAction.test1(rptKey);
		dwr.engine.setAsync(false);
		dwr.engine.setAsync(false);
		if(flag=="1"){
	window.location.href="${contextPath}/DownloadCorpCustAction.do?rptId="+rptKey;}
		else{
			alert("The file does not exists！");
		}
	}else{
		alert("报告不存在！");
	}
}

function dodownload1(detailrptKey,status){
	if(status!="0"){
		alert("未成功查询!");
	}else
	if("-" != detailrptKey && "" != detailrptKey.trim()){
		dwr.engine.setAsync(false);
		var flag=PrivAction.test2(detailrptKey);
		dwr.engine.setAsync(false);
		if(flag=="1"){
	window.location.href="${contextPath}/DownloadDetailInfoAction.do?detailrptKey="+detailrptKey;}
		else{
			alert("The file does not exists！");
		}
	}else{
		alert("报告不存在！");
	}
}

function dodownload2(Id){
	dwr.engine.setAsync(false);
	var flag=PrivAction.test5(Id);
	dwr.engine.setAsync(false);
	if(flag=="1"){
	 var paramMap = new Map();
	 paramMap.put("Id",Id);
	window.location.href="${contextPath}/DownloadLoaAction.do?Id="+Id;}
	else{
		alert("The file does not exists！");
	}
}

function twoService(entName,entCertType,entCertNum,queryReason,serviceCode){
  dwr.engine.setAsync(false);
  var result=PrivAction.dealCorpData(entName,entCertType,entCertNum,queryReason,serviceCode);
  dwr.engine.setAsync(false);
  alert(result);
  if (result!=null) {
             var params = {}
             params.uuid=result;
             alert('查询成功，将在新窗口打开征信查询结果页面');
             OpenWindowWithPost("${contextPath}/CorpReportServlet", null, "_blank", params);
   }
  
  //  if(result="success"){
   //   OpenWindowWithPost("${contextPath}/CorpReportServlet", null, "_blank", params);
    //  }

  // PrivAction.getJsonMessage();
  //    window.location.href="${contextPath}/QueryCorpUpdate.do?Id="+Id;
//    var params = {};
   // params.uuid=Id;
  //  OpenWindowWithPost("${contextPath}/CorpReportServlet", null, "_blank", params);
   
}



function OpenWindowWithPost(url, windowoption, target, params)
{
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", url);
    if (target === "_blank") {
        target = "Window" + (new Date()).valueOf();
    }
    form.setAttribute("target", target);

    for (var i in params) {
        if (params.hasOwnProperty(i)) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = i;
            input.value = params[i];
            form.appendChild(input);
        }
    }

    document.body.appendChild(form);

    //note I am using a post.htm page since I did not want to make double request to the page
    //it might have some Page_Load call which might screw things up.
    window.open(_application_root + "/common/blank.html", target, windowoption);

    form.submit();

    document.body.removeChild(form);
}



/*function dodownload3(Id){
	var paramMap = new Map();
	paramMap.put("Id",Id);
	window.location.href="${contextPath}/DownloadReplyAction.do?Id="+Id;
}*/
function showCompanyInfo(rptKey,ccreturnTime,corpCustType,Id,relName,relCorpId,funcid1,funcid2,funcid3,funcid4,funcid5,funcid6,funcid7,funcid8,status){
	if(status!="0"){
		alert("未成功查询!");
	}else
	if("-" != rptKey && "" != rptKey.trim()){
	var tcdareturnTime=CompanyReport_dataset.getValue("tcdareturnTime").format("yyyyMMdd HH:mm:ss");
	//var ccreturnTime=CompanyReport_dataset.getValue("ccreturnTime").format("yyyyMMdd HH:mm:ss");
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("ccreturnTime",ccreturnTime);
	 paramMap.put("tcdareturnTime",tcdareturnTime);
	 paramMap.put("corpCustType",corpCustType);
	 paramMap.put("Id",Id);
	/* paramMap.put("corpCustLoancard",corpCustLoancard);
	 paramMap.put("corpCustCompanyname",encodeURI(encodeURI(corpCustCompanyname)));*/
	// paramMap.put("relName",encodeURI(encodeURI(relName)));
	 paramMap.put("relCorpId",relCorpId);
	 paramMap.put("funcid1",funcid1);
	 paramMap.put("funcid2",funcid2);
	 paramMap.put("funcid3",funcid3);
	 paramMap.put("funcid4",funcid4);
	 paramMap.put("funcid5",funcid5);
	 paramMap.put("funcid6",funcid6);
	 paramMap.put("funcid7",funcid7);
	 paramMap.put("funcid8",funcid8);
	//var url = "/fpages/business/ftl/CompanyReportTotalNew.ftl?rptKey="+rptKey+"&corpCustType="+corpCustType+"&Id="+Id+"&tcdareturnTime="+tcdareturnTime+"&relName="+relName+"&relCorpId="+relCorpId+"&funcid1="+funcid1+"&funcid2="+funcid2+"&funcid3="+funcid3+"&funcid4="+funcid4+"&funcid5="+funcid5+"&funcid6="+funcid6+"&funcid7="+funcid7+"&funcid8="+funcid8;

	 var url = "/fpages/business/ftl/CompanyReportTotal.ftl?rptKey="+rptKey+"&corpCustType="+corpCustType+"&Id="+Id+"&ccreturnTime="+ccreturnTime+"&tcdareturnTime="+tcdareturnTime+"&relCorpId="+relCorpId+"&funcid1="+funcid1+"&funcid2="+funcid2+"&funcid3="+funcid3+"&funcid4="+funcid4+"&funcid5="+funcid5+"&funcid6="+funcid6+"&funcid7="+funcid7+"&funcid8="+funcid8;
   
	 showWin("企业一般信息汇总", url, "window", "flushPage()", window);
    
	}
	else{
		alert("报告不存在！");
	}
//	loadPageWindows("partWin","查看明细","/fpages/business/ftl/CompanyReportTotal.ftl", paramMap, "winZone");
//	window.location.href="${contextPath}/fpages/business/ftl/CompanyReportTotal.ftl?rptKey="+rptKey+"&corpCustType="+corpCustType+"&Id="+Id+"&tcdareturnTime="+tcdareturnTime+"&relName="+relName+"&relCorpId="+relCorpId+"&funcid1="+funcid1+"&funcid2="+funcid2+"&funcid3="+funcid3+"&funcid4="+funcid4+"&funcid5="+funcid5+"&funcid6="+funcid6+"&funcid7="+funcid7+"&funcid8="+funcid8;
}
	
	function showCompanyInfoCheck(rptKey,corpCustType,Id,relName,relCorpId,funcid1,funcid2,funcid3,funcid4,funcid5,funcid6,funcid7,funcid8,status){
		if(status!="0"){
			alert("未成功查询!");
		}else
		if("-" != rptKey && "" != rptKey.trim()){
	 var tcdareturnTime=CompanyReport_dataset.getValue("tcdareturnTime").format("yyyyMMdd HH:mm:ss");
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("tcdareturnTime",tcdareturnTime);
	 paramMap.put("corpCustType",corpCustType);
	 paramMap.put("Id",Id);
	/* paramMap.put("corpCustLoancard",corpCustLoancard);
	 paramMap.put("corpCustCompanyname",encodeURI(encodeURI(corpCustCompanyname)));*/
	 //paramMap.put("relName",encodeURI(encodeURI(relName)));
	 paramMap.put("relCorpId",relCorpId);
	 paramMap.put("funcid1",funcid1);
	 paramMap.put("funcid2",funcid2);
	 paramMap.put("funcid3",funcid3);
	 paramMap.put("funcid4",funcid4);
	 paramMap.put("funcid5",funcid5);
	 paramMap.put("funcid6",funcid6);
	 paramMap.put("funcid7",funcid7);
	 paramMap.put("funcid8",funcid8);
	 var url = "/fpages/business/ftl/CompanyReportCheck.ftl?rptKey="+rptKey+"&corpCustType="+corpCustType+"&Id="+Id+"&tcdareturnTime="+tcdareturnTime+"&relCorpId="+relCorpId+"&funcid1="+funcid1+"&funcid2="+funcid2+"&funcid3="+funcid3+"&funcid4="+funcid4+"&funcid5="+funcid5+"&funcid6="+funcid6+"&funcid7="+funcid7+"&funcid8="+funcid8;
    showWin("企业信息核验", url, "window", "flushPage()", window);
	}
	else{
		alert("报告不存在！");
	}
//	loadPageWindows("partWin","查看明细","/fpages/business/ftl/CompanyReportTotal.ftl", paramMap, "winZone");
//	window.location.href="${contextPath}/fpages/business/ftl/CompanyReportTotal.ftl?rptKey="+rptKey+"&corpCustType="+corpCustType+"&Id="+Id+"&tcdareturnTime="+tcdareturnTime+"&relName="+relName+"&relCorpId="+relCorpId+"&funcid1="+funcid1+"&funcid2="+funcid2+"&funcid3="+funcid3+"&funcid4="+funcid4+"&funcid5="+funcid5+"&funcid6="+funcid6+"&funcid7="+funcid7+"&funcid8="+funcid8;
}
	
</script>
</@CommonQueryMacro.page>
