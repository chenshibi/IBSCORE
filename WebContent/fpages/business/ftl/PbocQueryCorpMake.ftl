<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<@CommonQueryMacro.page title="二代企业征信报告查询">
<@CommonQueryMacro.CommonQuery id="PbocQueryCorpMake" init="false" submitMode="current">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
<input type="hidden"  name="openertext" id="feedBackTxt"  value="" size="30" >
	<table  width="80%">
	<tr>
		<td  align="left">
			<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="entName,entCertType,entCertNum,queryReason,serviceCode,queryLevel" colNm=1 /></br>
		</td>
	</tr>
	</table>
	
		<table width="100%"  >
			 	<tr>
    		<td  align="center">
				<@CommonQueryMacro.Button id= "btSearch"/>
				<@CommonQueryMacro.Button id= "uploadFile"/>
    		</td>
    	</tr>	
			</table>
</@CommonQueryMacro.GroupBox>	
</@CommonQueryMacro.CommonQuery>

<script language="javascript">

    function initCallGetter_post(dataset) {
      PbocQueryCorpMake_dataset.setValue("serviceCode","FW_QYXYBG_0043");
      PbocQueryCorpMake_dataset.setValue("queryLevel","1");
    }

  	function btSearch_onClickCheck(button){
      var entName=PbocQueryCorpMake_dataset.getValue("entName");
      var entCertType=PbocQueryCorpMake_dataset.getValue("entCertType");
      var entCertNum=PbocQueryCorpMake_dataset.getValue("entCertNum");
      var queryReason=PbocQueryCorpMake_dataset.getValue("queryReason");
   //   var serviceCode=PbocQueryCorpMake_dataset.getValue("serviceCode");
      var serviceCode=PbocQueryCorpMake_dataset.getValue("serviceCode");
      if(entName==""){
         alert("企业名称不可为空");
         return false;
      }
      if(entCertType==""){
         alert("企业身份标识类型不可为空");
         return false;
      }
      if("10"==entCertType){
      if(entCertNum.length>16){
           alert("企业身份标识号码不可以大于16位");
           return false;
       }
      }
      
      if("30"==entCertType){
         if(entCertNum.length>12){
           alert("企业身份标识号码不可以大于12位");
           return false;
       }
      }
      
      if(entCertNum==""){
         alert("企业身份标识号码不可为空");
         return false;
      }
      if(queryReason==""){
         alert("查询原因不可为空");
         return false;
      }
      if(serviceCode==""){
         alert("服务代码不可为空");
         return false;
      }
       var nonWorkhourFilepath=document.getElementById("feedBackTxt").value;
	   PbocQueryCorpMake_dataset.setValue("nonWorkhourFilepath",nonWorkhourFilepath);
	   dwr.engine.setAsync(false);
 	   var flag=PrivAction.isWorkTime();
 	   dwr.engine.setAsync(false);
 	   if(flag=="0" && document.getElementById("feedBackTxt").value==""){
 			alert("非工作时间8:00-22:00，需上传文件！");
 			uploadFile.disable(false);
 			return false;
 		 }
 		 
 	  dwr.engine.setAsync(false);
      var isCompanyExpire=PrivAction.isCompanyExpire(entCertNum,queryReason);//有无授权书标志
	  dwr.engine.setAsync(false);
	  if(isCompanyExpire == "0"){
					 alert("Name="+entName+",ID="+entCertNum+ " 没有查询授权书！");
			    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN2.ftl?type="+entCertType+"&corpCustCompanyname=" + encodeURI(encodeURI(entName)) + "&corpCustLoancard=" + entCertNum,300,300,window);
			    	 return false;
				 }
				 if(isCompanyExpire == "1"){
					 alert("Name="+entName+",ID="+entCertNum+ " 查询授权书过期！");
			    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN2.ftl?type="+entCertType+"&corpCustCompanyname=" + encodeURI(encodeURI(entName)) + "&corpCustLoancard=" + entCertNum,300,300,window);
			    	 return false;
				 }
	}

    function uploadFile_onClickCheck(button){
   	 showWin("主管查询授权书", "/fpages/business/ftl/nonWorkhourFileUpload.jsp",300,300,window);
    }

    function btSearch_postSubmit(button) {
        if(button.returnParam.errMsg!=null){
            alert(button.returnParam.errMsg);
            var entName=button.returnParam.entName;
            var entCertType=button.returnParam.entCertType;
            var entCertNum=button.returnParam.entCertNum;
            var queryReason=button.returnParam.queryReason;
            var serviceCode=button.returnParam.serviceCode;
            if(confirm("一个月内查过的确认要重新查询吗?")){
                reQuery(entName,entCertType,entCertNum,queryReason,serviceCode);
            }else{
              return false;
            }
       }
      else  if (button.returnParam.uuid !=null){
            var params = {};
            params.uuid = button.returnParam.uuid;
            alert('查询成功，将在新窗口打开征信查询结果页面');
            OpenWindowWithPost("${contextPath}/CorpReportServlet", null, "_blank", params);
            return false;
        } else {
            alert("查询失败！");
        }
    }
    
  function reQuery(entName,entCertType,entCertNum,queryReason,serviceCode){
	  dwr.engine.setAsync(false);
      var isCompanyExpire=PrivAction.isCompanyExpire(entCertNum,queryReason);//有无授权书标志
	  dwr.engine.setAsync(false);
	  if(isCompanyExpire == "0"){
					 alert("Name="+entName+",ID="+entCertNum+ " 没有查询授权书！");
			    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN2.ftl?corpCustCompanyname=" + encodeURI(encodeURI(entName)) + "&corpCustLoancard=" + entCertNum,300,300,window);
			    	 return false;
				 }
				 if(isCompanyExpire == "1"){
					 alert("Name="+entName+",ID="+entCertNum+ " 查询授权书过期！");
			    	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN2.ftl?corpCustCompanyname=" + encodeURI(encodeURI(entName)) + "&corpCustLoancard=" + entCertNum,300,300,window);
			    	 return false;
				 }
	  var result=PrivAction.dealCorpData(entName,entCertType,entCertNum,queryReason,serviceCode);
      if (result!=null) {
             var params = {};
             params.uuid=result;
             alert('查询成功，将在新窗口打开征信查询结果页面');
             OpenWindowWithPost("${contextPath}/CorpReportServlet",null, "_blank", params);
     }else{
          alert("查询失败");
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

    //note I am using a post.htm page since I did not want to make double request to the page
    //it might have some Page_Load call which might screw things up.
    window.open(_application_root + "/common/blank.html", target, windowoption);

    form.submit();

    document.body.removeChild(form);
 }
    

</script>
</@CommonQueryMacro.page>