<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人征信报告批量查询">
		<@CommonQueryMacro.CommonQuery id="CrmsBatchQueryPersonalReport" init="false" submitMode="selected" navigate="false" >
			<table align="left"  width="100%">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm="4"/>
					</td>
				</tr>
				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="10" showArrow="true" />
					</td>
		    	</tr>
		    	<tr >
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="modelDownload,-,importBN"  fitColumns="false" fieldStr="select,rsv5,createUser,name,idType,idNum[200],queryReason[100],serviceCode,certAuthStatus[100],rsv7[100],queryDate,sendTime,respTime,status"  hasFrame="true" width="100%"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
//导入数据
    var sysTxdate = ${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()?string("yyyyMMdd")};  
	function importBN_onClick(){
		currentSubWin = openSubWin("pageWinId", "批量导入查询请求文件", "/fpages/business/jsp/CrmsBatchQueryCorpReport.jsp?fileflag=CustPbocPerQuery&workDate="+sysTxdate,"600","200");
	}
    
    function modelDownload_onClick(){
        var form = document.createElement("FORM");
        form.method = "post";
        form.action=_application_root +"/CommFileXLSXDownloadServlet?flag=0";
        document.body.appendChild(form);
        form.submit();
    }
    
   function roundRobinQuery_onClickCheck() {
    if (!isRecordSelected(CrmsBatchQueryPersonalReport_dataset)) {
        alert("请选择一条记录！");
        return false;
    }
     var level=CrmsBatchQueryPersonalReport_dataset.getValue("certAuthStatus");
     if(level!='01'){
         alert("勾选的必须已授权,请先授权！");
         return false;
     }
    return true;
}
function flushData() {
    CrmsBatchQueryPersonalReport_dataset.flushData(1);
}

function rematch_onClickCheck() {
    if (!isRecordSelected(CrmsBatchQueryPersonalReport_dataset)) {
        alert("请选择一条记录！");
        return false;
    }
   var st = CrmsBatchQueryPersonalReport_dataset.getValue("certAuthStatus");
   if(st=="01"){
      alert("已授权,无需重新匹配");
      return false;
   }
    return true;
}
    
  //重新匹配
  function rematch_postSubmit(button){
      alert("更新成功"); 
      flushData();  			
   	} 	

function isRecordSelected(dataset) {
    var record = dataset.getFirstRecord();
    var hasSelected = false;
    while (record) {
        var v_selected = record.getValue("select");
        if (v_selected == true) {
            hasSelected = true;
        }
        record = record.getNextRecord();
    }
    if (!hasSelected) {
        return false;
    }
    return true;
}
function roundRobinQuery_postSubmit(button) {
    flushData();
        if(button.returnParam.authErrMsg!=null){
           alert(button.returnParam.authErrMsg);
        }if(button.returnParam.errMsg!=null){
            alert(button.returnParam.errMsg);
        }
        if(button.returnParam.list!=null){
            paramList=button.returnParam.list;
            if(confirm("一个月内查过的确认要重新查询吗?")){
            dwr.engine.setAsync(false);
            var result=PrivAction.dealBatchPersonalData(paramList);
            dwr.engine.setAsync(false);
            alert(result);
//           var params = {}
//            var t1=ids.replace("[","");
//           var t2=t1.replace("]","");
//           var str= t2.split(",");
//            var len=str.length;
//            for(var i=0;i<len;i++){
//                params.uuid=Trim(str[i]);
//                alert('查询成功，将在新窗口打开征信查询结果页面');
//                OpenWindowWithPost("${contextPath}/PersonalReportServlet", null, "_blank", params);
//            }
         }
         
             }
             
         if(button.returnParam.result!=null){
             alert(button.returnParam.result);
         }  
         
         if(button.returnParam.errList!=null){
             alert(button.returnParam.errList);
         } 
          
          if(button.returnParam.exceptionList!=null){
             alert(button.returnParam.exceptionList);
         }   
             
             
//     else  if(button.returnParam.uuid!=[]) {
//            var params = {};
//            params.uuid=button.returnParam.uuid;
//            var temp=params.uuid;
//            var t=temp.toString();
//            var t1=t.replace("[","");
//            var t2=t1.replace("]","");
//            var str= t2.split(",");
//            var len=str.length;
//            for(var i=0;i<len;i++){
//                params.uuid=Trim(str[i]);
//               alert('查询成功，将在新窗口打开征信查询结果页面');
//                OpenWindowWithPost("${contextPath}/PersonalReportServlet", null, "_blank", params);
//            }
//    } else {
//       alert("查询失败！");
//    }
}

 function batchNoQuery_onClickCheck() {
    if (!isRecordSelected(CrmsBatchQueryPersonalReport_dataset)) {
        alert("请任意勾选一笔未查即可实现对所有未查记录查询！");
        return false;
    }
     var st= CrmsBatchQueryPersonalReport_dataset.getValue("status");
        if(st!='00'){
           alert("勾选的不是未查的,请重新选择！");
           return false;
        }
     var level=CrmsBatchQueryPersonalReport_dataset.getValue("certAuthStatus");
     if(level!='01'){
         alert("勾选的必须已授权,请先授权！");
         return false;
     }
    return true;
}

//批量查询未查
function batchNoQuery_postSubmit(button){
        if(button.returnParam.authErrMsg!=null){
          alert(button.returnParam.authErrMsg);
        }if(button.returnParam.errMsg!=null){
          alert(button.returnParam.errMsg);
        }
        if(button.returnParam.list!=null){
            if(confirm("一个月内查询过的确认要重新查询吗?")){
            var paramList=button.returnParam.list;
            dwr.engine.setAsync(false);
            var result=PrivAction.dealBatchPersonalData(paramList);
            dwr.engine.setAsync(false);
            alert(result);
//            var params = {}
//            var t1=ids.replace("[","");
//            var t2=t1.replace("]","");
//            var str= t2.split(",");
//            var len=str.length;
//            for(var i=0;i<len;i++){
//                params.uuid=Trim(str[i]);
//                alert('查询成功，将在新窗口打开征信查询结果页面');
//                OpenWindowWithPost("${contextPath}/PersonalReportServlet", null, "_blank", params);
//            }


         }
        }
        
         if(button.returnParam.result!=null){
            alert(button.returnParam.result);
         }
         if(button.returnParam.errList!=null){
             alert(button.returnParam.errList);
         }
          if(button.returnParam.exceptionList!=null){
             alert(button.returnParam.exceptionList);
         }         
    
//    else if (button.returnParam.uuid!=[]) {
//            var params = {}
//            params.uuid=button.returnParam.uuid;
//            var temp=params.uuid;
//            var t=temp.toString();
//            var t1=t.replace("[","");
//            var t2=t1.replace("]","");
//            var str= t2.split(",");
//            var len=str.length;
//            for(var i=0;i<len;i++){
//                params.uuid=Trim(str[i]);
//                alert('查询成功，将在新窗口打开征信查询结果页面');
            //    OpenWindowWithPost("${contextPath}/PersonalReportServlet", null, "_blank", params);
//            }
//    } else {
//        alert("查询失败！");
//    }


}



function batchDel_onClickCheck(){
  if (!isRecordSelected(CrmsBatchQueryPersonalReport_dataset)) {
        alert("请选择一条记录！");
        return false;
    }
    var st = CrmsBatchQueryPersonalReport_dataset.getValue("status");
    if(st!="00"){
        alert("只能删除未查的数据,请重新选择！");
        return false;
    }
    return true;
} 

  //删除
  function batchDel_postSubmit(button){
         if(button.returnParam.errMsg!=null){
            alert(button.returnParam.errMsg);
         }
        if(button.returnParam.notDel!=null){
            alert(button.returnParam.notDel); 
        }
        if(button.returnParam.result!=null){
            alert(button.returnParam.result); 
        }
      flushData();  			
   	}    

 function datatable1_certauthstatus_onRefresh(cell,value,record){
        if(record!=null){
           var id=record.getValue("id");
           var idType=record.getValue("idType");
           var name=record.getValue("name");
           var idNum = record.getValue("idNum");
           var queryReason= record.getValue("queryReason");
           var certAuthStatus=record.getValue("certAuthStatus");
           if(certAuthStatus=='02'){
            cell.innerHTML = "<a href=\"Javascript:showPermit('" + id + "','" + idType + "','" + name + "','"+idNum+"','" + queryReason + "')\">"+value+"</a>";
           }else{
              cell.innerHTML =value;
           }
        }else{
             cell.innerHTML = ""
        }
    }
    
    
  function showPermit(id,idType,name,idNum,queryReason){
      dwr.engine.setAsync(false);
      var isExpire=PrivAction.isExpire(idType,name,idNum,queryReason);
      dwr.engine.setAsync(false);
      var skip="P";
	   if(isExpire == "0"){
						 alert("Name="+name+",ID="+idNum+ " 没有查询授权书！");
						  window.location.href="${contextPath}/fpages/business/ftl/IndPermitUploadP.ftl?id="+id+"&name="+ encodeURI(encodeURI(name)) + "&individualId=" + idNum + "&idType="+idType;
				        return false;
					 }
	   if(isExpire == "1"){
						 alert("Name="+name+",ID="+idNum+ " 查询授权书过期！");
						 window.location.href="${contextPath}/fpages/business/ftl/IndPermitUploadP.ftl?id="+id+"&name="+ encodeURI(encodeURI(name)) + "&individualId=" + idNum + "&idType="+idType;
				        return false;
					 }
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
    window.open(_application_root + "/common/blank.html", target, windowoption);
    form.submit();
    document.body.removeChild(form);
 }
    

/**
 * 去掉字符串前后空格
 * @param str
 * @returns {void | string}
 * @constructor
 */
function Trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

function isEmpty(obj) {
if(!obj && obj !== 0 && obj !== '') {　
  return true;
}else{
  return false;
}
if(Array.prototype.isPrototypeOf(obj) && obj.length === 0) { 
   return true;
  }else{
   return false;
  }
if(Object.prototype.isPrototypeOf(obj) && Object.keys(obj).length === 0) { 
   return true;
  }else{
   return false;
  }　
  
  }


</script>
</@CommonQueryMacro.page>