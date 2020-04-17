<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人数据提取">
		<@CommonQueryMacro.CommonQuery id="DataExtraction" init="true" submitMode="all" navigate="false">
			<table align="left"  width="100%">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="etlDateStart,etlDateEnd,type,corpTableName,personalTableName"  colNm=1 /></br>
					</td>
				</tr>

			</table>
		</@CommonQueryMacro.CommonQuery>
		
		<@CommonQueryMacro.CommonQuery id="DataExtraction" init="true" submitMode="all" navigate="false">
			<table width="100%"  >
			<tr>
    		<td  align="center">
				<@CommonQueryMacro.Button id= "btDownload"/>
				<@CommonQueryMacro.Button id= "importBN"/>
				<@CommonQueryMacro.Button id= "downloadGen"/>
    		</td>
    	   </tr>	
			</table>
		</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">

 function initCallGetter_post() {
 //   var sysTxdate = ${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()?string("yyyyMMdd")};
 
 //  var etlDateStart = DataExtraction_dataset.getString("etlDateStart");
 //  var etlDateEnd = DataExtraction_dataset.getString("etlDateEnd");
    var currentDate_mon = new Date();       
   //获取当前月的第一天       
    var currentMonthFirst = getCurrentMonthFirst(currentDate_mon);       
   //获取当前日期     
    var currentMonthLast =  getNowFormatDate(currentDate_mon);
  //  var countryNo=getCountryNo();
  //  var branchNo=getBranchNo();
    DataExtraction_dataset.setValue("etlDateStart",currentMonthFirst); 
    DataExtraction_dataset.setValue("etlDateEnd",currentMonthLast); 
 //   DataExtraction_dataset.setValue("branch",branchNo);
 //   DataExtraction_dataset.setValue("country",countryNo);
    $("#fldlabel_corpTableName").parent().parent().css({"display":"none"});
    $("#fldlabel_personalTableName").parent().parent().css({"display":"none"});
}

function DataExtraction_dataset_afterChange(dataset) {
		var type=DataExtraction_dataset.getValue("type");
		 if(type!=""){
	    	changeField();
		 }
	}
 
function changeField(){
var type=DataExtraction_dataset.getValue("type");
 if(type=="1"){
         $("#fldlabel_corpTableName").parent().parent().css({"display":""});
         $("#fldlabel_personalTableName").parent().parent().css({"display":"none"});
     }else if(type=="2"){
         $("#fldlabel_personalTableName").parent().parent().css({"display":""});
          $("#fldlabel_corpTableName").parent().parent().css({"display":"none"});
     }
}
    
   function btDownload_onClickCheck() {
   //  var sDate=DataExtraction_dataset.getValue("etlDateStart");
 //    var eDate=DataExtraction_dataset.getValue("etlDateEnd"); 
     var sDate = DataExtraction_dataset.getString("etlDateStart");
     var eDate = DataExtraction_dataset.getString("etlDateEnd");
   //  sDate=getNowFormatDate(sDate);
  //   sDate=sDate.replace("\\","");
 //    sDate=sDate.replace(/-/g,"");
 //    eDate=getCurrentMonthLast(eDate);
 //    eDate=eDate.replace("\\","");
 //    eDate=eDate.replace(/-/g,"");
     var type=DataExtraction_dataset.getValue("type");
     var tableName=DataExtraction_dataset.getValue("corpTableName");
     var pTableName=DataExtraction_dataset.getValue("personalTableName");
     if(type==""){
        alert("请选择类型");
        return false;
     }
     if(type=="1"){
        if(tableName==""){
        alert("请选择企业表名！");
        return false;
     }
     else {
        var form = document.createElement("FORM");
        form.method = "post";
        form.action=_application_root +"/DataExtractionServlet?flag="+tableName+"&startDate="+sDate+"&endDate="+eDate;
        document.body.appendChild(form);
        form.submit();
      } 
     }
     if(type=="2"){
        if(pTableName==""){
           alert("请选择个人数据表名");
           return false;
        }else{
           var form = document.createElement("FORM");
           form.method = "post";
           form.action=_application_root +"/PersonalDataExtractionServlet?flag="+pTableName+"&startDate="+sDate+"&endDate="+eDate;
           document.body.appendChild(form);
           form.submit();
        }
       }
      
      
   }


function batchDownload_onClickCheck(button) {
var type=DataExtraction_dataset.getValue("type");
if(type=="1"){
     var form = document.createElement("FORM");
     form.method = "post";
     form.action=_application_root +"/BatchDataExtractionServlet";
     document.body.appendChild(form);
     form.submit();
}else {
     var form = document.createElement("FORM");
     form.method = "post";
     form.action=_application_root +"/BatchPersonalDataExtractionServlet";
     document.body.appendChild(form);
     form.submit();
 }

}

function importBN_onClickCheck(button) {
     var type=DataExtraction_dataset.getValue("type");
     if(type==""){
         alert("请选择上传类型");
         return false;
     }
     var form = document.createElement("FORM");
     form.method = "post";
     form.action=_application_root +"/DownloadZipServlet?flag="+type;
     document.body.appendChild(form);
     form.submit();
}

function downloadGen_onClickCheck(button){
     var form = document.createElement("FORM");
     form.method = "post";
     form.action=_application_root +"/DownloadGenZipServlet";
     document.body.appendChild(form);
     form.submit();
}


function getCurrentMonthFirst(d){    
 var date = new Date(d);    
 date.setDate(1);    
 var month = parseInt(date.getMonth()+1);    
 var day = date.getDate();    
 if (month < 10) {      
     month = '0' + month    
   }    
 if (day < 10) {        
   day = '0' + day    
  }   
  
   return date.getFullYear() + '-' + month + '-' + day;
   
  }
  
 function getCurrentMonthLast(d){    
  var date=new Date(d);    
  var currentMonth=date.getMonth();   
  var nextMonth=++currentMonth;   
  var nextMonthFirstDay=new Date(date.getFullYear(),nextMonth,1);
  var oneDay=1000*60*60*24;    
  var lastTime = new Date(nextMonthFirstDay-oneDay);    
  var month = parseInt(lastTime.getMonth()+1);    
  var day = lastTime.getDate();    
  if (month < 10) {        
       month = '0' + month   
    }    
    if (day < 10) {    
        day = '0' + day   
        }    
        return date.getFullYear() + '-' + month + '-' + day;
  }
  
  
  function getNowFormatDate(d) {
            var date = new Date(d);
            var seperator1 = "-";
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = year + seperator1 + month + seperator1 + strDate;
            return currentdate;
        }
</script>
</@CommonQueryMacro.page>