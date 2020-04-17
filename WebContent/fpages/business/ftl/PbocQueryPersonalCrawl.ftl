<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<input type="hidden"  name="openertext" id="feedBackTxt"  value="" size="30" >
<@CommonQueryMacro.page title="二代个人征信报告查询">
<@CommonQueryMacro.CommonQuery id="PbocQueryPersonalCrawl" init="false" submitMode="current">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table  width="80%">
	<tr>
		<td  align="left">
			<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="name,idType,idNum,queryReason,serviceCode,queryLevel" colNm=1 /></br>
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
      PbocQueryPersonalCrawl_dataset.setValue("serviceCode","FW_GRXYBG_0074");
      PbocQueryPersonalCrawl_dataset.setValue("queryLevel","1");
    }

var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};

   	function btSearch_onClickCheck(button){
      var name=PbocQueryPersonalCrawl_dataset.getValue("name");
      var idType=PbocQueryPersonalCrawl_dataset.getValue("idType");
      var idNum_1=PbocQueryPersonalCrawl_dataset.getValue("idNum");
      var queryReason=PbocQueryPersonalCrawl_dataset.getValue("queryReason");
      var serviceCode=PbocQueryPersonalCrawl_dataset.getValue("serviceCode");
      if(name==""){
         alert("用户姓名不可为空");
         return false;
      }
      if(idType==""){
         alert("证件类型不可为空");
         return false;
      }
      if(idNum_1==""){
         alert("证件号码不可为空");
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
      if(idType=="10"){
      var iSum=0 ;
      var info="" ;
      var idNum="";
      if(!/^\d{17}(\d|x)$/i.test(idNum_1)){
         alert("你输入的身份证长度或格式错误");
         return false;
      } 
       idNum=idNum_1.replace(/x$/i,"a");
      if(aCity[parseInt(idNum.substr(0,2))]==null){
        alert("你的身份证地区非法");
        return false;
      } 
      sBirthday=idNum.substr(6,4)+"-"+Number(idNum.substr(10,2))+"-"+Number(idNum.substr(12,2));
      var d=new Date(sBirthday.replace(/-/g,"/")) ;
      if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate())) {
        alert("身份证上的出生日期非法");
        return false;
       }
      for(var i = 17;i>=0;i --) iSum += (Math.pow(2,i) % 11) * parseInt(idNum.charAt(17 - i),11) ;
      if(iSum%11!=1) {
         alert("你输入的身份证号非法");
         return false;
      }
       }
       
       var nonWorkhourFilepath=document.getElementById("feedBackTxt").value;
	   PbocQueryPersonalCrawl_dataset.setValue("nonWorkhourFilepath",nonWorkhourFilepath);
	   dwr.engine.setAsync(false);
 	   var flag=PrivAction.isWorkTime();
 	   dwr.engine.setAsync(false);
 	   if(flag=="0" && document.getElementById("feedBackTxt").value==""){
 			alert("非工作时间8:00-22:00，需上传文件！");
 			uploadFile.disable(false);
 			return false;
 		 }
 		 
      dwr.engine.setAsync(false);
      var isExpire=PrivAction.isExpire(idType,name,idNum_1,queryReason);
	  dwr.engine.setAsync(false);
	  if(isExpire == "0"){
						 alert("Name="+name+",ID="+idNum_1+ " 没有查询授权书！");
					        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ encodeURI(encodeURI(name)) + "&individualId=" + idNum_1 + "&idType="+idType,300,300,window);
				        return false;
					 }
	   if(isExpire == "1"){
						 alert("Name="+name+",ID="+idNum_1+ " 查询授权书过期！");
					        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ encodeURI(encodeURI(name)) + "&individualId=" + idNum_1 + "&idType="+idType,300,300,window);
				        return false;
					 }
       
      <#-- 注释
      dwr.engine.setAsync(false); 
      var flag=PrivAction.isWorkTime();
      dwr.engine.setAsync(false);
      if(flag){
      dwr.engine.setAsync(false);
      var isExpire=PrivAction.isExpire(idType,name,idNum_1,queryReason);
	  dwr.engine.setAsync(false);
	  if(isExpire == "0"){
						 alert("Name="+name+",ID="+idNum_1+ " 没有查询授权书！");
					        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ encodeURI(encodeURI(name)) + "&individualId=" + idNum_1 + "&idType="+idType,300,300,window);
				        return false;
					 }
	   if(isExpire == "1"){
						 alert("Name="+name+",ID="+idNum_1+ " 查询授权书过期！");
					        showWin("查询授权书上传", "/fpages/business/ftl/IndPermitUploadN.ftl?name="+ encodeURI(encodeURI(name)) + "&individualId=" + idNum_1 + "&idType="+idType,300,300,window);
				        return false;
					 }
      }else{
           alert("非工作时间段8:00-22:00,不允许查询！");
           return false;
      }
      -->  
  
	}
   
    function uploadFile_onClickCheck(button){
   	 showWin("主管查询授权书", "/fpages/business/ftl/nonWorkhourFileUpload.jsp",300,300,window);
    }
   
    function btSearch_postSubmit(button) {
       if (button.returnParam && button.returnParam.result) {
            alert('录入成功！请等待查询结果！');
            return false;
        } else {
            alert("录入失败！");
        }
 }
    

</script>
</@CommonQueryMacro.page>