<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign type = RequestParameters["type"]?default("")>
<#assign v_orgcode = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getBrno()>
<@CommonQueryMacro.page title="贷款业务信息补录">
<table width="95%" align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="creditReport_loancontracts" init="true" submitMode="current">
			<table width="100%">



		  		<#-- 查询列表-->
		  		<tr>
		      		<td valign="top">
		      			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="" fieldStr="orgcode[200],loancontNo,cardNo[200],startDate,endDateSpan,nameSpan,yintuanFlag,trust,effectFlag,assureFlag,ywdate,operationType,incenter,recStatus,approveStatus,repStatus,lstUpdTlr,lstUpdTm[150]" width="100%" readonly="true"/><br />
		          	</td>
		        </tr>

   			</table>
			</@CommonQueryMacro.CommonQuery>
		</tr>
	</td>
</table>
<@CommonQueryMacro.WindowElement skin="web"/>
<script language="javascript">
     //获取系统当前日期
     var _sysTxdate = ${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()?string("yyyyMMdd")};   
     
     function datatable1_enddatespan_onRefresh(cell,value,record){
		var endDate=record.getValue("endDate");
	    var newEndDate =  formatDateTime(endDate,"postdate");
	    var effectFlag = record.getValue("effectFlag");
	    var flag = countDate(newEndDate,_sysTxdate,effectFlag);	 
		if(flag){
		     cell.innerHTML ="<font color='red'>"+value+"</font>"
		}else{
		     cell.innerHTML ="<font >"+value+"</font>"
		}
		
	}
	function datatable1_namespan_onRefresh(cell,value,record){
	   
		var name = record.getValue("name");		
		var endDate = record.getValue("endDate");
		var effectFlag = record.getValue("effectFlag");	
		var newEndDate =  formatDateTime(endDate,"postdate");	
		var flag = countDate(newEndDate,_sysTxdate,effectFlag);		
		if(flag){
		     cell.innerHTML ="<font color='red'>"+name+"</font>"
		}else{
		     cell.innerHTML ="<font >"+name+"</font>"
		}
			
	}
	
	//日期天数计算
     function countDate(date1,date3,effectFlag){          
       var date2 = date3.toString() ;  
       var endDate =  new Date(date1.substring(0,4),date1.substring(4,6),date1.substring(6,8)); 
       var sysDate = new Date(date2.substring(0,4),date2.substring(4,6),date2.substring(6,8));     
       var days = endDate.getTime() - sysDate.getTime();     
       var time = days/(1000 * 60 * 60 * 24);          
       if(time<=7&&time>=0){
          return true;
       }else if(time<0){
         if("1" == effectFlag){
           return true;
         }else{
           return false;
         }
       }else{
          return false;
       }     
    }
</script>
</@CommonQueryMacro.page>