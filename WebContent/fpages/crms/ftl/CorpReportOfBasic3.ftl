<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<html  oncontextmenu="return false" onselectstart="return false" ondragstart="return false" onbeforecopy="return false" oncopy=document.selection.empty() onselect=document.selection.empty()>
<head>
    <title>二代企业信息核验</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <style>
       .table-data-td {
            white-space: nowrap;
            padding-left: 8px;
            font-size: 14px;
        }
       
       td {
            border: solid black 1px;
        }

        .labeltd {
            background: #f7fbfc;
            text-align:center;
            padding-right:8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
            width: 15%;
        }
        .labeltd-3 {
            
            text-align:center;
            padding-right:8px;
            font-size: 16px;
            width: 15%;
        }
        .labeltd-3-1 {
            
            text-align:center;
            padding-right:8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
            width: 15%;
        }
        .labeltd-3-2 {
            
            text-align:center;
            padding-right:8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
            width: 15%;
        }
          .labeltd-2 {
            background: #f7fbfc;
            text-align:center;
            padding-right: 8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
        }
        .titletd {
            text-align: left;
            width: 15%;
            color: black;
            font-weight: bold;
            font-size: 16px;
            border: 0px;
        }
        .titletd-r {
            text-align: right;
            width: 15%;
            color: black;
            font-weight: bold;
            font-size: 16px;
            border: 0px;
        }
        .titletd-2 {
            text-align: left;
            width: 5%;
            color: black;
            font-weight: bold;
            font-size: 16px;
            border: 0px;
        }
         .titletd-3 {
            text-align: left;
            color: black;
            font-weight: bold;
            font-size: 14px;
            border: 0px;
        }
        .datatd {
            background: #f7fbfc;
            white-space: nowrap;
            padding-left: 8px;
            font-size: 14px;
        }
        .datatd-1 {
            white-space: nowrap;
            padding-left: 8px;
            font-size: 14px;
        }
        .datatd_ {
            background: #f7fbfc;
           
            font-size: 14px;
        }
        .datatd-number {
            background: #f7fbfc;
            white-space: nowrap;
            padding-left: 8px;
            font-size: 14px;
            text-align: right;
        }
        .tabletd {
            width: 100%;
        }

        .table-label-td {
        	background: #f7fbfc;
            font-weight: bold;
            font-size: 14px;
            text-align:center;
        }
        .table-label-td-1 {
        	background: #f7fbfc;
            font-weight: bold;
            font-size: 14px;
            text-align:left;
             color: blue;
        }

        .datatd {
            font-size: 14px;
        }

        .table-head-td {
            font-weight: bold;
            font-size: 14px;
            text-align: center;
            border: 0px;
        }

        body {
            text-align: center;
        }

        #mainDiv {
            width: 80%;
            padding-right: 10%;
            padding-left: 10%;
        }

        fieldset {
            border-width: 1px;
        }

        .mainTable {
            width: 100%;
            border-collapse: collapse;
            border: none;
        }

        .secondTable {
            width: 80%;
            border-collapse: collapse;
            border: none;
            margin-left: 10%;
            margin-bottom: 10px;
        }

        @media print {
            td {
                font-size: 8pt !important;
            }

            #mainDiv {
                width: 100%;
                padding-right: 0;
                padding-left: 0;
            }

            #printBtn {
                display: none;
            }
        }
         
    </style>

    <script type="text/javascript">
        <#assign uuid = RequestParameters["uuid"]?default("")>
        var uuid = "${uuid}";

        function printRpt() {
            window.print();
        }
        function financeServer(type,year,uuid){
  			var params = {}
        	params.uuid=uuid;
        	params.type=type;
        	params.year=year;
        	openWindowWithPost("${contextPath}/FinanceReportServlet", params);
		}
		
		function creditloanServer(type,uuid){
  			var params = {}
        	params.uuid=uuid;
        	params.type=type;
        	openWindowWithPost("${contextPath}/CreditLoanReportServlet", params);
		}
		
		
		
		
		function openWindowWithPost(url, data) {
    		var form = document.createElement("form");
    		form.target = "_blank";
   		 	form.method = "POST";
   		 	form.action = url;
    		form.style.display = "none";

    		for (var key in data) {
        		var input = document.createElement("input");
        		input.type = "hidden";
        		input.name = key;
        		input.value = data[key];
        		form.appendChild(input);
    		}

    		document.body.appendChild(form);
    		form.submit();
    		document.body.removeChild(form);
		}
		
    </script>
</head>

<body>
<div id="mainDiv">
     <h1>二代企业信息核验</h1>
    	<table class="mainTable">
            <tr>
                <td class="labeltd-3-1" style="border-collapse: collapse; border: none" border="0">报告编号:</td>
                <td class="datatd-1" style="border-collapse: collapse; border: none" border="0">${map.EAA.EA01AI01!}</td>
                <td class="labeltd-3-2" style="border-collapse: collapse; border: none" border="0">报告时间:</td>
                <td class="datatd-1" style="border-collapse: collapse; border: none" border="0">${map.EAA.EA01AR01!}</td>
            </tr>
         </table><br>
             
         <table>
           		 <tr>
             	   <td class="titletd" colspan="6">
                    <li>注册资本及主要出资人信息单元</li>
               	   </td>
                   <td class="titletd-r" colspan="6"> 
              		   注册资本折人民币合计 ${map.ECA.EC020J01!}元
                   </td>
             	 </tr>
 			 </table>
 			 
 			  <table class="mainTable">
            <#--	<tr>
                   <#if map.ECA.EC020J01??>
                       ${map.ECA.EC020J01!}
                   <#else >
                   </#if>
                </td>
           	 	</tr>
 
            <tr>
                <td class="labeltd">主要出资人个数</td>
                <td class="datatd">${map.ECA.EC020S01!}</td>
            </tr>
			-->
                        <tr>
                            <td colspan="6" class="table-head-td">注册资本及主要出资人信息(总计${map.EC020H?size!}条记录)</td>
                        </tr>
                        <tr>
                           <#--  <td class="labeltd">出资人类型</td>  --> 
                            <td class="labeltd">出资人名称</td>
                            <td class="labeltd">出资人身份标识类型</td>
                            <td class="labeltd">出资人身份标识号码</td>
                            <td class="labeltd">出资比例</td>
                        </tr>
                        <#list map.EC020H! as EC020H>
                        <tr>
                         <#--   <td class="datatd">${DataDicUtil.getDataDic("6069", EC020H.EC020D01)!}</td> --> 
                        <#--    <td class="datatd">${DataDicUtil.getDataDic("6001", EC020H.EC020D02)!}</td>-->
                            <td class="datatd">${EC020H.EC020Q01!}</td>
							<#if (EC020H.EC020D02=='1')??>
								<td class="datatd">${DataDicUtil.getDataDic("6002", EC020H.EC020D03)!}</td>
							<#else >
								<td class="datatd">${DataDicUtil.getDataDic("6065", EC020H.EC020D03)!}</td>
							</#if>
                            <td class="datatd">${EC020H.EC020I01!}</td>
                            <td class="datatd">${EC020H.EC020Q02!}%</td>
                        </tr>
                        </#list>
               </table><br>
          
        <#--    <tr>
                <td class="labeltd">主要组成人员个数</td>
                <td class="datatd">${map.ECA.EC030S01!}</td>
            </tr>-->
                
                  <table>
               		 <tr>
               			 <td class="titletd" colspan="4">
                  			  <li>主要组成人员信息单元</li>
               			 </td>
           			 </tr>
           	 	 </table>
           	 	 
                 <table class="mainTable">
                      <tr>
                          <td colspan="6" class="table-head-td">主要组成人员信息列表(总计${map.EC030H?size!}条记录)</td>
                      </tr>
                      <tr>
                         	<td class="labeltd" colspan="2">职位</td>
                            <td class="labeltd">姓名</td>
                            <td class="labeltd">证件类型</td>
                            <td class="labeltd" colspan="2">证件号码</td>
                       </tr>
                        <#list map.EC030H! as EC030H>
                        <tr>
                        	<td class="datatd" colspan="2">${DataDicUtil.getDataDic("6070", EC030H.EC030D02)!}</td>
                            <td class="datatd">${EC030H.EC030Q01!}</td>
                            <td class="datatd">${DataDicUtil.getDataDic("6002", EC030H.EC030D01)!}</td>
                            <td class="datatd" colspan="2">${EC030H.EC030I01!}</td>
                            
                        </tr>
                        </#list>
                        <tr>
                        	 <td colspan="6" class="labeltd">	更新日期：${map.ECA.EC030R01!}</td>
                        </tr>
                   </table><br>
          
          <#if map.ECAList??>         
          <table>
           	   <tr>
             	   <td class="titletd" colspan="6">
              	      <li>上级机构信息单元</li>
             	   </td>
           	   </tr>
           	 </table>
           	 <table class="mainTable">
           	 	<tr>
                     <td colspan="6" class="table-head-td">上级机构信息列表(总计${map.ECAList?size!}条记录)</td>
                 </tr>
                 <tr>
              		   <td class="labeltd">上级机构类型</td>
              		   <td class="labeltd">上级机构名称</td>
             		   <td class="labeltd">上级机构身份标识类型</td>
             		   <td class="labeltd">上级机构身份标识号码</td>
                	   <td class="labeltd">更新日期</td>
                
           		 </tr>
            	 <#list map.ECAList! as ECAList>
            	 <tr>
               		 <td class="datatd">${DataDicUtil.getDataDic("6071", ECAList.EC040D01)!}</td>
               		 <td class="datatd">
               		 	<#if ECAList.EC040Q01??>
                	 	${ECAList.EC040Q01!}
                	 	<#else>--
                	 	</#if>
               		 </td>
                	 <td class="datatd">
                	 	<#if ECAList.EC040D02??>
                	 	${DataDicUtil.getDataDic("6065", ECAList.EC040D02)!}
                	 	<#else>--
                	 	</#if>
                	 </td>
                	 <td class="datatd">${ECAList.EC040I01!}</td>
                	 <td class="datatd">
                	 	<#if ECAList.EC040R01??>
                	 	${ECAList.EC040R01!}
                	 	<#else>--
                	 	</#if>
                	 </td>
            	 </tr>
            	 </#list>
  			 </table><br>
			</#if>
			
			<#if map.EC050H??>
			 <table>
				<tr>
               		 <td class="titletd" colspan="4">
                   		 <li>实际控制人信息单元(总计${map.EC050H?size!}条记录)</li>
                	</td>
           		</tr>
 			 </table>
			 <table class="mainTable">
			 	<tr>
                     <td colspan="6" class="table-head-td">实际控制人信息列表(总计${map.EC050H?size!}条记录)</td>
                 </tr>
                 <tr>
                 		<td class="labeltd">实际控制人身份类型</td>
             			<td class="labeltd">实际控制人名称</td>
                        <td class="labeltd">实际控制人身份标识类型</td>
                        <td class="labeltd">实际控制人身份标识号码</td>
                        <td class="labeltd">更新日期</td>
                 </tr>      
            	 <#list map.EC050H! as EC050H>
                 <tr>
                         <td class="datatd">${DataDicUtil.getDataDic("6123", EC050H.EC050D01)!}</td>
                         <td class="datatd">${EC050H.EC050Q01!}</td>
                         
                         
                         <#if EC050H.EC050D01??>
                         <#-- 判断实际控制人身份类型为1-自然人 还是 2-组织机构，相对应实际控制人身份标识类型为 个人证件类型 或 企业身份标识类型 
                         	qx.20190515
                         -->
                         <#if (EC050H.EC050D01) == '1'>
                         	<td class="datatd">${DataDicUtil.getDataDic("6002", EC050H.EC050D02)!}</td>
                         <#elseif (EC050H.EC050D01) == '2'>
                         	<td class="datatd">${DataDicUtil.getDataDic("6065", EC050H.EC050D02)!}</td>
                         </#if>
                         </#if>
                         <td class="datatd">${EC050H.EC050I01!}</td>
                         
                         <td class="datatd">
                         	<#if map.ECA.EC050R01??>
                         	${map.ECA.EC050R01!}
                         	<#else>--
                         	</#if>
                         </td>
                   </tr>
                  </#list>
               </table><br>
               </#if>  
</div>
</body>

</html>
