<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<html  oncontextmenu="return false" onselectstart="return false" ondragstart="return false" onbeforecopy="return false" oncopy=document.selection.empty() onselect=document.selection.empty()>
<head>
    <title>企业明细信息展开</title>
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
     <h1>企业明细信息展开</h1>
    <!--
    <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/> <br>
   -->
               
     <h2>	信贷记录明细</h2>          
          <#if (map.ED01_51List?size>0)>
       		 <table>
           	    <tr>
             	   <td class="titletd-2" colspan="8">
              	      <li>被追偿记录</li>       
              	      		共${map.ED01_51Size?size!}笔
             	   </td>
           	    </tr>
           	 </table>        
               
               <table class="mainTable">
               		<tr>
               			<td class="labeltd-2" rowspan="2">账户编号</td>
               			<td class="labeltd-2">债权机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">接收日期</td>
               			<td class="labeltd-2">币种</td>
               			<td class="labeltd-2">借款金额</td>
               			<td class="labeltd-2">余额</td>
               			<td class="labeltd-2" rowspan="2">信息报告日期</td>
               		</tr>
               		<tr>
               			<td class="labeltd">关闭日期</td>
               			<td class="labeltd">五级分类</td>
               			<td class="labeltd">最近一次还款日期</td>
               			<td class="labeltd">最近一次还款总额</td>
               			<td class="labeltd">最近一次还款形式</td>
               			<td class="labeltd">历史表现</td>
               		</tr>
               		<tr>
               			<td class="datatd" rowspan="2">${map.ED01_51.ED01AI01!}</td>
               			<td class="datatd">${map.ED01_51.ED01AI02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6043",map.ED01_51.ED01AD05)!}</td>
               			<td class="datatd">${map.ED01_51.ED01AR01!}</td>
               			<td class="datatd">${map.ED01_51.ED01AD07!}</td>
               			<td class="datatd">${map.ED01_51.ED01AJ01!}</td>
               			<td class="datatd">${map.ED01_51.ED01BJ01!}</td>
               			<td class="datatd" rowspan="2">${map.ED01_51.ED01AR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">
               					${ map.ED01_51.ED01AR03!}
               			</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",map.ED01_51.ED01BD01)!}</td>
               			<td class="datatd">${map.ED01_51.ED01BR04!}</td>
               			<td class="datatd">${map.ED01_51.ED01BJ02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",map.ED01_51.ED01BD02)!}</td>
               			<td class="datatd"><a url=''   name ='${map.ED01_51.ED01AI01!}'>查看</a></td>
               		</tr>
                </table><br></#if>
               <table>
           	    	<tr>
             	   		<td class="titletd-2" colspan="6">
              	      		<li>未结清信贷</li>
             	   		</td>
           	    	 </tr>
           		 </table>
               <#if (map.ED03List?size>0)>
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="6">
              	      		 欠息 
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED03List?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
               
                <table class="mainTable">
               		<tr>
               			<td class="labeltd">授信机构</td>
               			<td class="labeltd">欠息类型</td>
               			<td class="labeltd">币种</td>
               			<td class="labeltd">欠息余额</td>
               			<td class="labeltd">余额变化日期</td>
               			<td class="labeltd">信息报告日期</td>
               		</tr>
               		<tr>
               			<td class="datatd">${map.ED03.ED030I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6103",map.ED03.ED030D03)!}</td>
						<td class="datatd">${map.ED03.ED030D02!}</td>
						<td class="datatd">${map.ED03.ED030J01!}</td>
						<td class="datatd">${map.ED03.ED030R01!}</td>
						<td class="datatd">${map.ED03.ED030R02!}</td>
               		</tr>
               </table><br></#if>
			   
			   
                <#if (map.ED01_1_23List?size>0) >
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 中长期借款
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED01_1_23Size?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
               
                <table class="mainTable">
               		<tr>
               			<td class="labeltd-2" rowspan="3">账户编号</td>
               			<td class="labeltd-2">授信机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">开立日期</td>
               			<td class="labeltd-2">到期日</td>
               			<td class="labeltd-2">币种</td>
               			<td class="labeltd-2">借款金额</td>
               			<td class="labeltd-2">发放形式</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">担保方式</td>
               			<td class="labeltd-2">余额</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">逾期总额</td>
               			<td class="labeltd-2">逾期本金</td>
               			<td class="labeltd-2">逾期月数</td>
               			<td class="labeltd-2">最近一次还款日期</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">最近一次还款总额</td>
               			<td class="labeltd-2">最近一次还款形式</td>
               			<td class="labeltd-2">特定交易提示</td>
               			<td class="labeltd-2">授信协议编号</td>
               			<td class="labeltd-2">历史表现</td>
               			<td class="labeltd-2" colspan="2">信息报告日期</td>
               		</tr>
               		<tr>
               			<td class="datatd" rowspan="3">${map.ED01_1_23.ED01AI01!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01AI02!}</td>
               			<#if map.ED01_1_23.ED01AD05??>
               			<#if (map.ED01_1_23.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_23.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_23.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_23.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_23.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_23.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_23.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_23.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_23.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",map.ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${map.ED01_1_23.ED01AR01!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01AR02!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01AD07!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01AJ01!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01AD10!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6096",map.ED01_1_23.ED01AD08)!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01BJ01!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",map.ED01_1_23.ED01BD01)!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01BJ04!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01BJ05!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01BS02!}</td>
               			<td class="datatd">${map.ED01_1_23.ED01BR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${map.ED01_1_23.ED01BJ02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",map.ED01_1_23.ED01BD02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6102",map.ED01_1_23.ED01CD01)!}</td>
               			<td class="datatd">
               				<#if map.ED01_1_23.ED01AI03??>
               				${map.ED01_1_23.ED01AI03!}
               				<#else>--
               				</#if>
               			</td>
               			<td class="datatd">查看</td>
               			<td class="datatd" colspan="2">
	               			<#if map.ED01_1_23.ED01BR01??>
	               			${map.ED01_1_23.ED01BR01!}
	               			<#else >--
	               			</#if>
               			</td>
               		</tr>
               </table><br></#if>
               
               <#if (map.ED01_1_1List?size>0) >
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 短期借款
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED01_1_1Size?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
           		 
                <table class="mainTable">
               		<tr>
               			<td class="labeltd-2" rowspan="3">账户编号</td>
               			<td class="labeltd-2">授信机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">开立日期</td>
               			<td class="labeltd-2">到期日</td>
               			<td class="labeltd-2">币种</td>
               			<td class="labeltd-2">借款金额</td>
               			<td class="labeltd-2">发放形式</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">担保方式</td>
               			<td class="labeltd-2">余额</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">逾期总额</td>
               			<td class="labeltd-2">逾期本金</td>
               			<td class="labeltd-2">逾期月数</td>
               			<td class="labeltd-2">最近一次还款日期</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">最近一次还款总额</td>
               			<td class="labeltd-2">最近一次还款形式</td>
               			<td class="labeltd-2">特定交易提示</td>
               			<td class="labeltd-2">授信协议编号</td>
               			<td class="labeltd-2">历史表现</td>
               			<td class="labeltd-2" colspan="2">信息报告日期</td>
               		</tr>
               		<tr>
               			<td class="datatd" rowspan="3">${map.ED01_1_1.ED01AI01!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01AI02!}</td>
               			<#if map.ED01_1_1.ED01AD05??>
               			<#if (map.ED01_1_1.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_1.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_1.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_1.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_1.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_1.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_1.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_1.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_1.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",map.ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${map.ED01_1_1.ED01AR01!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01AR02!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01AD07!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01AJ01!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01AD10!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6096",map.ED01_1_1.ED01AD08)!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01BJ01!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",map.ED01_1_1.ED01BD01)!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01BJ04!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01BJ05!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01BS02!}</td>
               			<td class="datatd">${map.ED01_1_1.ED01BR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${map.ED01_1_1.ED01BJ02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",map.ED01_1_1.ED01BD02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6102",map.ED01_1_1.ED01CD01)!}</td>
               			<td class="datatd">
               				<#if map.ED01_1_1.ED01AI03??>
               				${map.ED01_1_1.ED01AI03!}
               				<#else>--
               				</#if>
               			</td>
               			<td class="datatd">查看</td>
               			<td class="datatd" colspan="2">${map.ED01_1_1.ED01BR01!}</td>
               		</tr>
               		
               </table><br></#if>
			   
			   
               <#if (map.ED01_1_R1List?size>0) >
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 循环透支
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED01_1_R1Size?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
           		 
                <table class="mainTable">
               		<tr>
               			<td class="labeltd-2" rowspan="3">账户编号</td>
               			<td class="labeltd-2">授信机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">开立日期</td>
               			<td class="labeltd-2">到期日</td>
               			<td class="labeltd-2">币种</td>
               			<td class="labeltd-2">借款金额</td>
               			<td class="labeltd-2">发放形式</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">担保方式</td>
               			<td class="labeltd-2">余额</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">逾期总额</td>
               			<td class="labeltd-2">逾期本金</td>
               			<td class="labeltd-2">逾期月数</td>
               			<td class="labeltd-2">最近一次还款日期</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">最近一次还款总额</td>
               			<td class="labeltd-2">最近一次还款形式</td>
               			<td class="labeltd-2">剩余还款月数</td>
               			<td class="labeltd-2">特定交易提示</td>
               			<td class="labeltd-2">授信协议编号</td>
               			<td class="labeltd-2">历史表现</td>
               			<td class="labeltd-2">信息报告日期</td>
               		</tr>
               		<tr>
               			<td class="datatd" rowspan="3">${map.ED01_1_R1.ED01AI01!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01AI02!}</td>
               			<#if map.ED01_1_R1.ED01AD05??>
               			<#if (map.ED01_1_R1.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_R1.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_R1.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_R1.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_R1.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_R1.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_R1.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_R1.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_1_R1.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",map.ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${map.ED01_1_R1.ED01AR01!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01AR02!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01AD07!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01AJ01!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01AD10!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6096",map.ED01_1_R1.ED01AD08)!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01BJ01!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",map.ED01_1_R1.ED01BD01)!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01BJ04!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01BJ05!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01BS02!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01BR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${map.ED01_1_R1.ED01BJ02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",map.ED01_1_R1.ED01BD02)!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01BS03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6102",map.ED01_1_R1.ED01CD01)!}</td>
               			<td class="datatd">${map.ED01_1_R1.ED01AI03!}</td>
               			<td class="datatd">查看</td>
               			<td class="datatd">${map.ED01_1_R1.ED01BR01!}</td>
               		</tr>
               		
               </table><br></#if>
			   
			   
               <#if (map.ED02List?size>0) >
                 <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="7">
              	      		贴现 
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED02List?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
               
                <table class="mainTable">
               		<tr>
               			<td class="labeltd">授信机构</td>
               			<td class="labeltd">业务种类</td>
               			<td class="labeltd">五级分类</td>
               			<td class="labeltd">账户数</td>
               			<td class="labeltd">余额</td>
               			<td class="labeltd">逾期总额</td>
               			<td class="labeltd">逾期本金</td>
               			
               		</tr>
               		<#list map.ED02List! as ED02>
               		<tr>
               			<td class="datatd">${ED02.ED020I02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED02.ED020D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED02.ED020D03)!}</td>
						<td class="datatd">${ED02.ED020S01!}</td>
						<td class="datatd">${ED02.ED020J01!}</td>
						<td class="datatd">${ED02.ED020J02!}</td>
						<td class="datatd">${ED02.ED020J03!}</td>
               		</tr>
  					</#list>
               </table><br></#if>
			   
			   
               <#if (map.ED05_51_61List?size>0) >
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="9">
              	      		银行承兑汇票和信用证
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED05_51_61List?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
               
                <table class="mainTable">
               		<tr>
               			<td class="labeltd-2" rowspan="2">授信机构</td>
               			<td class="labeltd-2" rowspan="2">业务种类</td>
               			<td class="labeltd-2" rowspan="2">五级分类</td>
               			<td class="labeltd-2" rowspan="2">账户数</td>
               			<td class="labeltd-2" colspan="5">余额</td>
               			
               		</tr>
               		<tr>
               			<td class="labeltd-2">到期日≤30 天</td>
               			<td class="labeltd-2">到期日≤60 天</td>
               			<td class="labeltd-2">到期日≤90 天</td>
               			<td class="labeltd-2">到期日>90 天</td>
               			<td class="labeltd-2">合计</td>
               		</tr>
               		<#list map.ED05_51_61List! as ED05>
               		<tr>
               			<td class="datatd">${ED05.ED050I02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6095",ED05.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05.ED050D03)!}</td>
               			<td class="datatd">${ED05.ED050S01!}</td>
               			<td class="datatd">${ED05.ED050J02!}</td>
               			<td class="datatd">${ED05.ED050J03!}</td>
               			<td class="datatd">${ED05.ED050J04!}</td>
               			<td class="datatd">${ED05.ED050J05!}</td>
               			<td class="datatd">${ED05.ED050J01!}</td>
               		</tr>
  					</#list>
               </table><br></#if>
               <#if (map.ED05_51_otherList?size>0) >
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="9">
              	      		银行保函及其他业务
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED05_51_otherList?size!}笔
             	   		</td>
           	    	 </tr>
           	    	 
           		 </table>  
                 <table class="mainTable">
                 	<tr>
               			<td class="labeltd">授信机构</td>
               			<td class="labeltd">业务种类</td>
               			<td class="labeltd">五级分类</td>
               			<td class="labeltd">账户数</td>
               			<td class="labeltd">余额</td>
               		</tr>
               		<#list map.ED05_51_otherList! as ED05>
           	    	 <tr>
           	    	 	<td class="datatd">${ED05.ED050I02!}</td>
           	    	 	<td class="datatd"> ${DataDicUtil.getDataDic("6095",ED05.ED050D02)!}</td>
           	    	 	<td class="datatd">${DataDicUtil.getDataDic("6032",ED05.ED050D03)!}</td>
               			<td class="datatd">${ED05.ED050S01!}</td>
               			<td class="datatd">${ED05.ED050J01!}</td>
               		 </tr>	
               		 </#list>
                </table><br></#if>
                
                <#if (map.EDCList?size>0) >
                 <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="7">
              	      		授信信息
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.EDCList?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
                 <table class="mainTable">
                 	<tr>
                 		<td class="labeltd" rowspan="2">授信协议编号</td>
               			<td class="labeltd">授信机构</td>
               			<td class="labeltd">授信额度类型</td>
               			<td class="labeltd">额度循环标志</td>
               			<td class="labeltd">生效日期</td>
               			<td class="labeltd">到期日</td>
               			<td class="labeltd" rowspan="2">信息报告日期</td>
               		</tr>
               		<tr>
                 		<td class="labeltd">币种</td>
               			<td class="labeltd">授信额度</td>
               			<td class="labeltd">已用额度</td>
               			<td class="labeltd">授信限额</td>
               			<td class="labeltd">授信限额编号</td>
               		</tr>
               		<#list map.EDCList! as EDC>
               		<tr>
                 		<td class="datatd" rowspan="2">${EDC.ED060I01!}</td>
               			<td class="datatd">${EDC.ED060I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6098",EDC.ED060D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6104",EDC.ED060D03)!}</td>
               			<td class="datatd">${EDC.ED060R01!}</td>
               			<td class="datatd">${EDC.ED060R02!}</td>
               			<td class="datatd" rowspan="2">${EDC.ED060R03!}</td>
               		</tr>
               		<tr>
                 		<td class="datatd">${EDC.ED060D04!}</td>
               			<td class="datatd">${EDC.ED060J01!}</td>
               			<td class="datatd">${EDC.ED060J04!}</td>
               			<td class="datatd">${EDC.ED060J03!}</td>
               			<td class="datatd">${EDC.ED060I03!}</td>
               		</tr>
               		</#list>
                </table><br></#if>
                
              <table>
           	    	<tr>
             	   		<td class="titletd-2" colspan="6">
              	      		<li>已结清信贷</li>
             	   		</td>
           	    	 </tr>
           		 </table>  
                <#if (map.ED01_2_23List?size>0) >
            <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 中长期借款
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED01_2_23Size?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
               
                <table class="mainTable">
               		<tr>
               			<td class="labeltd-2" rowspan="2">账户编号</td>
               			<td class="labeltd-2">授信机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">开立日期</td>
               			<td class="labeltd-2">到期日</td>
               			<td class="labeltd-2">币种</td>
               			<td class="labeltd-2">借款金额</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">关闭日期</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">最近一次还款日期</td>
               			<td class="labeltd-2">最近一次还款形式</td>
               			<td class="labeltd-2" colspan="2">历史表现</td>
               		</tr>
               		
               		<tr>
               			<td class="datatd" rowspan="2">${map.ED01_2_23.ED01AI01!}</td>
               			<td class="datatd">${map.ED01_2_23.ED01AI02!}</td>
               			<#if map.ED01_2_23.ED01AD05?? >
               			<#if (map.ED01_2_23.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",map.ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_23.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",map.ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_23.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",map.ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_23.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",map.ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_23.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",map.ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_23.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",map.ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_23.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",map.ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_23.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",map.ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_23.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",map.ED01_2_23.ED01AD06)!}</td>
               			</#if></#if>
               			<td class="datatd">${map.ED01_2_23.ED01AI02!}</td>
               			<td class="datatd">${map.ED01_2_23.ED01AR02!}</td>
               			<td class="datatd">${map.ED01_2_23.ED01AD07!}</td>
               			<td class="datatd">${map.ED01_2_23.ED01AJ01!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${map.ED01_2_23.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",map.ED01_2_23.ED01BD01)!}</td>
               			<td class="datatd">${map.ED01_2_23.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",map.ED01_2_23.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               		
               </table><br></#if>
               
               <#if (map.ED01_2_1List?size>0) >
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 短期借款
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED01_2_1Size?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
           		 
                <table class="mainTable">
               		<tr>
               			<td class="labeltd-2" rowspan="2">账户编号</td>
               			<td class="labeltd-2">授信机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">开立日期</td>
               			<td class="labeltd-2">到期日</td>
               			<td class="labeltd-2">币种</td>
               			<td class="labeltd-2">借款金额</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">关闭日期</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">最近一次还款日期</td>
               			<td class="labeltd-2">最近一次还款形式</td>
               			<td class="labeltd-2" colspan="2">历史表现</td>
               		</tr>
               		<tr>
               			<td class="datatd" rowspan="2">${map.ED01_2_1.ED01AI01!}</td>
               			<td class="datatd">${map.ED01_2_1.ED01AI02!}</td>
               			<#if (map.ED01_2_1.ED01AD05??) >
               			<#if (map.ED01_2_1.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_1.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_1.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_1.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_1.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_1.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_1.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_1.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_1.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",map.ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${map.ED01_2_1.ED01AI02!}</td>
               			<td class="datatd">${map.ED01_2_1.ED01AR02!}</td>
               			<td class="datatd">${map.ED01_2_1.ED01AD07!}</td>
               			<td class="datatd">${map.ED01_2_1.ED01AJ01!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${map.ED01_2_1.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",map.ED01_2_1.ED01BD01)!}</td>
               			<td class="datatd">${map.ED01_2_1.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",map.ED01_2_1.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               </table><br></#if>
               
               
               
               <#if (map.ED01_2_R1List?size>0) >
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 循环透支
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED01_2_R1Size?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
           		 
                <table class="mainTable">
               		<tr>
               			<td class="labeltd-2" rowspan="2">账户编号</td>
               			<td class="labeltd-2">授信机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">开立日期</td>
               			<td class="labeltd-2">到期日</td>
               			<td class="labeltd-2">币种</td>
               			<td class="labeltd-2">信用额度</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">关闭日期</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">最近一次还款日期</td>
               			<td class="labeltd-2">最近一次还款形式</td>
               			<td class="labeltd-2" colspan="2">历史表现</td>
               		</tr>
               		<tr>
               			<td class="datatd" rowspan="2">${map.ED01_2_R1.ED01AI01!}</td>
               			<td class="datatd">${map.ED01_2_R1.ED01AI02!}</td>
               			<#if (map.ED01_2_R1.ED01AD05??) >
               			<#if (map.ED01_2_R1.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_R1.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_R1.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_R1.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_R1.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_R1.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_R1.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_R1.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (map.ED01_2_R1.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",map.ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${map.ED01_2_R1.ED01AI02!}</td>
               			<td class="datatd">${map.ED01_2_R1.ED01AR02!}</td>
               			<td class="datatd">${map.ED01_2_R1.ED01AD07!}</td>
               			<td class="datatd">${map.ED01_2_R1.ED01AJ01!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${map.ED01_2_R1.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",map.ED01_2_R1.ED01BD01)!}</td>
               			<td class="datatd">${map.ED01_2_R1.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",map.ED01_2_R1.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               </table><br></#if>
               
               
               <#if (map.ED02List?size>0) >
                 <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="7">
              	      		贴现 
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED02List?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
               
                <table class="mainTable">
               		<tr>
               			<td class="labeltd">授信机构</td>
               			<td class="labeltd">业务种类</td>
               			<td class="labeltd">五级分类</td>
               			<td class="labeltd">账户数</td>
               			<td class="labeltd">贴现金额</td>
               		</tr>
               		<#list map.ED02List! as ED02>
               		<tr>
               			<td class="datatd">${ED02.ED020I02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED02.ED020D02)!}</td>
						<td class="datatd">${DataDicUtil.getDataDic("6032",ED02.ED020D03)!}</td>
               			<td class="datatd">${ED02.ED020S02!}</td>
						<td class="datatd">${ED02.ED020J04!}</td>
               		</tr>
               		</#list>
               </table></#if><br>
               
               
                <#if (map.ED05_51_61List?size>0) >
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="5">
              	      		银行承兑汇票和信用证
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED05_51_61List?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
              
                <table class="mainTable">
               		<tr>
               			<td class="labeltd">授信机构</td>
               			<td class="labeltd">业务种类</td>
               			<td class="labeltd">五级分类</td>
               			<td class="labeltd">账户数</td>
               			<td class="labeltd">垫款标志</td>
               		</tr>
               		<#list map.ED05_51_61List! as ED05>
               		<tr>
           	    	 	<td class="datatd">${ED05.ED050I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6095",ED05.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05.ED050D03)!}</td>
               			<td class="datatd">${ED05.ED050S02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6075",ED05.ED050D04)!}</td>
               		 </tr>
               		 </#list>
               </table></#if><br>
               
               
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="5">
              	      		银行保函及其他业务
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED05_51_otherList?size!}笔
             	   		</td>
           	    	 </tr>
           		 </table>  
                 <table class="mainTable">
                 	<tr>
               			<td class="labeltd">授信机构</td>
               			<td class="labeltd">业务种类</td>
               			<td class="labeltd">五级分类</td>
               			<td class="labeltd">账户数</td>
               			<td class="labeltd">垫款标志</td>
               		</tr>
               		<#list map.ED05_51_otherList! as ED05>
               		<tr>
           	    	 	<td class="datatd">${ED05.ED050I02!}</td>
           	    	 	<td class="datatd">${DataDicUtil.getDataDic("6095",ED05.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05.ED050D03)!}</td>
               			<td class="datatd">${ED05.ED050S02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6075",ED05.ED050D04)!}</td>
               		 </tr>
               		</#list>
                </table><br>   
              <table>
           	    	<tr>
             	   		<td class="titletd-2" colspan="6">
              	      		<li> 相关还款责任</li>
             	   		</td>
           	    	 </tr>
           		 </table>     
             <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="9">
              	      		除贴现外的其他业务
             	   		</td>
             	   		<td class="titletd-3">共 ${map.EDD_1?size!} 笔    </td>
           	    	 </tr>
           		 </table>  
                 <table class="mainTable">
                 	<tr>
               			<td class="labeltd-2" rowspan='2'>账户编号</td>
               			<td class="labeltd-2">责任类型</td>
               			<td class="labeltd-2">保证合同编号</td>
               			<td class="labeltd-2">币种</td>
               			<td class="labeltd-2">还款责任金额</td>
               			<td class="labeltd-2">授信机构/债权机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">开立日期/接收日期</td>
               			<td class="labeltd-2">到期日</td>
               			<td class="labeltd-2">币种</td>
               		</tr>
               		<tr>
               			<td class="labeltd-2">借款金额/信用额度</td>
						<td class="labeltd-2">余额</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">逾期总额</td>
               			<td class="labeltd-2">逾期本金</td>
               			<td class="labeltd-2">逾期月数/还款状态</td>
               			<td class="labeltd-2">剩余还款月数</td>
               			<td class="labeltd-2" colspan='2'>信息报告日期</td>
               		</tr>
               		<#list map.EDD_1! as EDD>
               		<tr>
               		 <td class="datatd" rowspan='2'>${EDD.ED070I01!}</td>
               		 <td class="datatd">${DataDicUtil.getDataDic("6044",EDD.ED070D03)!}</td>
               		 <td class="datatd">${EDD.ED070I03!}</td>
               		 <td class="datatd">${EDD.ED070D07!}</td>
               		 <td class="datatd">
               		 <#if EDD.ED070J01??>
                          ${EDD.ED070J01!}
                      <#else >
                      </#if>
                      </td>
                      <td class="datatd">${EDD.ED070I02!}</td>
                      <td class="datatd">${DataDicUtil.getDataDic("6083",EDD.ED070D05)!}</td>
                      <td class="datatd">${EDD.ED070R01!}</td>
                      <td class="datatd">${EDD.ED070R02!}</td>
                      <td class="datatd">${EDD.ED070D10!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">
                  			<#if EDD.ED070J05??>
                         		${EDD.ED070J05!}
                    		 <#else >
                     		</#if>
               			</td>
               			<td class="datatd">
                  			<#if EDD.ED070J02??>
                         		${EDD.ED070J02!}
                    		 <#else >
                     		</#if>
               			</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",EDD.ED070D08)!}</td>
               			<td class="datatd">
                    		 <#if EDD.ED070J03??>
                        		 ${EDD.ED070J03!}
                     		<#else >
                     		</#if>
                		</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6026",EDD.ED070D09)!}</td>
               			<td class="datatd">${EDD.ED070S01!}</td>
               			<td class="datatd">${EDD.ED070S02!}</td>
               			<td class="datatd" colspan='2'>${EDD.ED070R03!}</td>
               		</tr>
               		 </#list>
                </table><br>         
                
                    <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="9">
              	      		贴现
             	   		</td>
             	   		<td class="titletd-3">共 ${map.EDD_2?size!}笔    </td>
           	    	 </tr>
           		 </table>  
                 <table class="mainTable">
                 	<tr>
               			<td class="labeltd-2">责任类型</td>
               			<td class="labeltd-2">保证合同编号</td>
               			<td class="labeltd-2">还款责任金额</td>
               			<td class="labeltd-2">授信机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">账户数</td>
               			<td class="labeltd-2">借款金额</td>
               			<td class="labeltd-2">余额</td>
               			<td class="labeltd-2">逾期总额</td>
               			<td class="labeltd-2">逾期本金</td>
               		</tr>
               		<#list map.EDD_2! as EDD>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6080",EDD.ED080D01)!}</td>
               			<td class="datatd">${EDD.ED080I01!}</td>
               			<td class="datatd">
                      		<#if EDD.ED080J01??>
                          		${EDD.ED080J01!}
                      		<#else >
                      		</#if>
                		</td>
                		<td class="datatd">${EDD.ED080I02!}</td>
                		<td class="datatd">${DataDicUtil.getDataDic("6091",EDD.ED080D03)!}</td>
                		<td class="datatd">${DataDicUtil.getDataDic("6032",EDD.ED080D04)!}</td>
                		<td class="datatd">${EDD.ED080S01!}</td>
                		<td class="datatd">
                 			<#if EDD.ED080J05??>
                      			${EDD.ED080J05!}
                  			<#else >
                  			</#if>
                		</td>
                		<td class="datatd">
                   			<#if EDD.ED080J02??>
                       			${EDD.ED080J02!}
                   			<#else >
                   			</#if>
                		</td>
                		<td class="datatd">
                   			<#if EDD.ED080J03??>
                       			${EDD.ED080J03!}
                   			<#else >
                   			</#if>
               			 </td>
               			 <td class="datatd">
                     		<#if EDD.ED080J04??>
                         		${EDD.ED080J04!}
                     		<#else >
                    		 </#if>
                		  </td>
               		</tr>
               		</#list>
                </table><br>  
                
                
                
                
                
                  <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="8">
              	      		为担保交易承担的相关还款责任
             	   		</td>
             	   		<td class="titletd-3">共 ${map.EDD_3?size!} 笔    </td>
           	    	 </tr>
           		 </table>  
                 <table class="mainTable">
                 	<tr>
               			<td class="labeltd-2">责任类型</td>
               			<td class="labeltd-2">保证合同编号</td>
               			<td class="labeltd-2">还款责任金额</td>
               			<td class="labeltd-2">授信机构</td>
               			<td class="labeltd-2">业务种类</td>
               			<td class="labeltd-2">五级分类</td>
               			<td class="labeltd-2">账户数</td>
               			<td class="labeltd-2">担保金额</td>
               			<td class="labeltd-2">余额</td>
               		</tr>
               		<#list map.EDD_3! as EDD>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6080",EDD.ED090D01)!}</td>
               			<td class="datatd">${EDD.ED090I01!}</td>
               			<td class="datatd">
                   			<#if EDD.ED090J01??>
                       			${EDD.ED090J01!}
                   			<#else >
                   			</#if>
                		</td>
               			<td class="datatd">${EDD.ED090I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6095",EDD.ED090D03)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",EDD.ED090D04)!}</td>
               			<td class="datatd">${EDD.ED090S01!}</td>
               			<td class="datatd">
                     		<#if EDD.ED100J03??>
                         		${EDD.ED100J03!}
                     		<#else >
                     		</#if>
                		</td>
               			<td class="datatd">
                    		<#if EDD.ED090J02??>
                         		${EDD.ED090J02!}
                     		<#else >
                     		</#if>
                		</td>
               		</tr>
               		</#list>
                </table><br>  
                
                
                
     <h2>非信贷记录明细</h2>
     <table class="mainTable">
       		<tr>
                <td class="titletd" colspan="6">
                    <li>公共事业缴费信息基本信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">公用事业缴费账户编号</td>
                <td class="labeltd">公用事业单位名称</td>
                <td class="labeltd">业务类型</td>
                <td class="labeltd">缴费状态</td>
                <td class="labeltd">累计欠费金额</td>
                <td class="labeltd">统计年月</td>
            </tr>
            <tr>
             	<td class="datatd">${map.EEA.EE01AI01!}</td>
                <td class="datatd">${map.EEA.EE01AQ01!}</td>
                <td class="datatd">${DataDicUtil.getDataDic("6105",map.EEA.EE01AD01)!}</td>
                <td class="datatd">${DataDicUtil.getDataDic("6107",map.EEA.EE01AD02)!}</td>
                <td class="datatd">
                    <#if map.EEA.EE01AJ01??>
                        ${map.EEA.EE01AJ01!}
                    <#else >
                    </#if>
                </td>
                <td class="datatd">${map.EEA.EE01AR01!}</td>
            </tr>
 		</table>
 		
 		<#if (map.EE01BH?size>0) >
 		  <table class="mainTable">
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="mainTable">
                        <tr>
                            <td colspan="5" class="table-head-td">缴费情况记录列表(总计${map.EE01BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">统计年月</td>
                            <td class="labeltd">缴费状态</td>
                            <td class="labeltd">本月应缴金额</td>
                            <td class="labeltd">本月实缴金额</td>
                            <td class="labeltd">累计欠费金额</td>
                        </tr>
                        <#list map.EE01BH! as EE01BH>
                        <tr>
                            <td class="datatd">${EE01BH.EE01BR01!}</td>
                            <td class="datatd">${DataDicUtil.getDataDic("6048",EE01BH.EE01BD01)!}</td>
                            <td class="datatd">
                               <#if EE01BH.EE01BJ01??>
                                   ${EE01BH.EE01BJ01!}
                               <#else>
                               </#if>
                            </td>
                            <td class="datatd">
                              <#if EE01BH.EE01BJ02??>
                                  ${EE01BH.EE01BJ02!}
                              <#else>
                              </#if>
                            </td>
                            <td class="datatd">
                              <#if EE01BH.EE01BJ03??>
                                  ${EE01BH.EE01BJ03!}
                              <#else >
                              </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
     </#if>
     
     
     
               
               
    <h2>公共记录明细</h2>
    
    
     <#if (map.EFAList?size>0)>       
                <table>
				<tr>
               		 <td class="titletd-2" colspan="1">
                   		 <li>欠税记录</li>
                	</td>
           		</tr>
 			 </table>
			 <table class="mainTable">
                 <tr>
                 		 <td class="labeltd">欠税记录编号</td>
             			 <td class="labeltd">主管税务机关名称</td>
               			 <td class="labeltd">欠税总额(元)</td>
               			 <td class="labeltd">欠税统计时间</td>
                 </tr> 
                      
                    <#list map.EFAList! as EFA>
   					<tr>
                 		 <td class="datatd">${EFA.EF010I01!}</td>
                         <td class="datatd">${EFA.EF010Q01!}</td>
               			 <td class="datatd">
                  				 <#if map.EFA.EF010J01??>
                     				  ${EFA.EF010J01!}
                  				 <#else>
                   				</#if>
               			 </td>
               			 <td class="datatd">${EFA.EF010R01!}</td>
                   </tr>
  				 </#list>    
  
               </table><br>
        <#else>
          </#if>        
               
               
               
               

       <#if (map.EFBList?size>0)>        
               <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>民事判决记录信息单元</li>
                </td>
            </tr>
              <#list map.EFBList! as EFB>
            <tr>
                <td class="labeltd">民事判决记录编号</td>
                <td class="datatd">${EFB.EF020I01!}</td>
                <td class="labeltd">立案法院名称</td>
                <td class="datatd">${EFB.EF020Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">案号</td>
                <td class="datatd">${EFB.EF020I02!}</td>
                <td class="labeltd">立案日期</td>
                <td class="datatd">${EFB.EF020R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">案由</td>
                <td class="datatd">${EFB.EF020Q02!}</td>
                <td class="labeltd">诉讼地位</td>
                <td class="datatd">${DataDicUtil.getDataDic("6109", EFB.EF020D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">审判程序</td>
                <td class="datatd">${DataDicUtil.getDataDic("6110", EFB.EF020D02)!}</td>
                <td class="labeltd">诉讼标的</td>
                <td class="datatd">${EFB.EF020Q03!}</td>
            </tr>
            <tr>
                <td class="labeltd">诉讼标的金额</td>
                <td class="datatd">
                    <#if EFB.EF020J01??>
                        ${EFB.EF020J01!}
                    <#else>
                    </#if>
               </td>
                <td class="labeltd">结案方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6111", EFB.EF020D03)!}</td>
            </tr>
            <tr>
                <td class="labeltd">判决/调解生效日期</td>
                <td class="datatd" colspan="3">${EFB.EF020R02!}</td>
                </tr>
                <tr>
                <td class="labeltd">判决/调解结果</td>
                <td class="datatd_" colspan="3">${EFB.EF020Q04!}</td>
            </tr>
            </#list>   
                </table><br>
           <#else>
         </#if>      
                
                
                
      <#if (map.EFBList?size>0)>              
             <table class="mainTable">
                <tr>
                <td class="titletd" colspan="4">
                    <li>强制执行记录信息单元</li>
                </td>
            </tr>
            
            <#list map.EFBList! as EFB>
            <tr>
                <td class="labeltd">强制执行记录编号</td>
                <td class="datatd">${EFB.EF030I01!}</td>
                <td class="labeltd">执行法院名称</td>
                <td class="datatd">${EFB.EF030Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">案号</td>
                <td class="datatd">${EFB.EF030I02!}</td>
                <td class="labeltd">立案日期</td>
                <td class="datatd">${EFB.EF030R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">执行案由</td>
                <td class="datatd">${EFB.EF030Q02!}</td>
                <td class="labeltd">申请执行标的</td>
                <td class="datatd">${EFB.EF030Q03!}</td>
            </tr>
            <tr>
                <td class="labeltd">申请执行标的金额</td>
                <td class="datatd">
                      <#if EFB.EF030J01??>
                          ${EFB.EF030J01!}
                      <#else>
                      </#if>
                </td>
                <td class="labeltd">案件状态</td>
                <td class="datatd">${EFB.EF030Q04!}</td>
            </tr>
            <tr>
                <td class="labeltd">结案方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6112", EFB.EF030D01)!}</td>
                <td class="labeltd">已执行标的</td>
                <td class="datatd">${EFB.EF030Q05!}</td>
            </tr>
            <tr>
                <td class="labeltd">已执行标的金额</td>
                <td class="datatd"  colspan="3">
                   <#if map.EFB.EF030J02??>
                       ${EFB.EF030J02!}
                   <#else>
                   </#if>
                </td>
            </tr>
            </#list>
        </table><br>
      <#else >
       </#if>         
               
               
     <#if (map.EFCList?size>0)>            
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>行政处罚记录信息单元</li>
                </td>
            </tr>
            
            <#list map.EFCList! as EFC>
            <tr>
                <td class="labeltd">行政处罚记录编号</td>
                <td class="datatd">${EFC.EF040I01!}</td>
                <td class="labeltd">处罚机构名称</td>
                <td class="datatd">${EFC.EF040Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚决定书文号</td>
                <td class="datatd">${EFC.EF040I02!}</td>
                <td class="labeltd">违法行为</td>
                <td class="datatd">${EFC.EF040Q02!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚决定</td>
                <td class="datatd">${EFC.EF040Q03!}</td>
                <td class="labeltd">处罚日期</td>
                <td class="datatd">${EFC.EF040R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚金额</td>
                <td class="datatd">
                  <#if map.EFC.EF040J01??>
                      ${EFC.EF040J01!}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">处罚执行情况</td>
                <td class="datatd">${EFC.EF040Q04!}</td>
            </tr>
            <tr>
                <td class="labeltd">行政复议结果</td>
                <td class="datatd" colspan="3">${EFC.EF040Q05!}</td>
            </tr><br>
            
              </#list>
        </table><br>
       <#else >
         </#if> 
        
        
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>住房公积金缴费记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户编号</td>
                <td class="datatd">${map.EFD.EF05AI01!}</td>
                <td class="labeltd">初缴年月</td>
                <td class="datatd">${map.EFD.EF05AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">职工人数</td>
                <td class="datatd">${map.EFD.EF05AS01!}</td>
                <td class="labeltd">缴费基数</td>
                <td class="datatd">
                     <#if map.EFD.EF05AJ01??>
                         ${map.EFD.EF05AJ01!}
                     <#else >
                     </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最近一次缴费日期</td>
                <td class="datatd">${map.EFD.EF05AR02!}</td>
                <td class="labeltd">缴至年月</td>
                <td class="datatd">${map.EFD.EF05AR03!}</td>
            </tr>
            <tr>
                <td class="labeltd">缴费状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6113", map.EFD.EF05AD01)!}</td>
                <td class="labeltd">累计欠费金额</td>
                <td class="datatd">
                  <#if map.EFD.EF05AJ02??>
                      ${map.EFD.EF05AJ02!}
                  <#else>
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">统计年月</td>
                <td class="datatd" colspan="3">${map.EFD.EF05AR04!}</td>
            </tr>
          </table>
          
          
          
          
                    <table class="mainTable">
                        <tr>
                     <td class="table-head-td" colspan="2">      过去24个月缴费情况信息单元  </td>
                            <td colspan="2" class="table-head-td">缴费情况信息列表(总计${map.EF05BH?size!}条记录)</td>
                        </tr>
                         <#if (map.EF05BH?size>0)>           
                        <tr>
                            <td class="labeltd">统计年月</td>
                            <td class="labeltd">缴费状态</td>
                            <td class="labeltd">本月应缴金额</td>
                            <td class="labeltd">本月实缴金额</td>
                            <td class="labeltd">累计欠费金额</td>
                        </tr>
                        <#list map.EF05BH! as EF05BH>
                        <tr>
                            <td class="datatd">${EF05BH.EF05BR01!}</td>
                            <td class="datatd">${DataDicUtil.getDataDic("6113", EF05BH.EF05BD01)!}</td>
                            <td class="datatd">
                                 <#if EF05BH.EF05BJ01??>
                                     ${EF05BH.EF05BJ01!}
                                 <#else >
                                 </#if>
                            </td>
                            <td class="datatd">
                               <#if EF05BH.EF05BJ02??>
                                   ${EF05BH.EF05BJ02!}
                               <#else >
                               </#if>
                            </td>
                            <td class="datatd">
                                <#if EF05BH.EF05BJ03??>
                                    ${EF05BH.EF05BJ03!}
                                <#else >
                                </#if>
                            </td>
                        </tr>
                        </#list>
                          <#else >
                                </#if>
                    </table><br>
       
    <#if (map.EFEList?size>0)>           
       <table class="mainTable">
            <tr>
                <td class="titletd" colspan="6">
                    <li>获得许可记录信息单元</li>
                </td>
            </tr>
            
            
            <tr>
                <td class="labeltd">许可记录编号</td>
                <td class="labeltd">许可部门名称</td>
                <td class="labeltd">许可类型</td>
                <td class="labeltd">许可日期</td>
                <td class="labeltd">截止日期</td>
                <td class="labeltd">许可内容</td>
            </tr>
            <#list map.EFEList! as EFE>
            <#if EFE.EF060I01??>
            <tr>
                <td class="datatd">${EFE.EF060I01!}</td>
                <td class="datatd">${EFE.EF060Q01!}</td>
                <td class="datatd">${EFE.EF060Q02!}</td>
                <td class="datatd">${EFE.EF060R01!}</td>
                <td class="datatd">${EFE.EF060R02!}</td>
                <td class="datatd">${EFE.EF060Q03!}</td>
            </tr>
            <#else >
             </#if>
              </#list>
              </table><br>
        <#else >
             </#if>
       
      <#if (map.EFEList?size>0)>       
       <table class="mainTable">
            <tr>
                <td class="titletd" colspan="6">
                    <li>获得认证记录信息单元</li>
                </td>
            </tr>
            
            <tr>
                <td class="labeltd">认证记录编号</td>
                <td class="labeltd">认证部门名称</td>
                <td class="labeltd">认证类型</td>
                <td class="labeltd">认证日期</td>
                <td class="labeltd">截止日期</td>
                <td class="labeltd">认证内容</td>
            </tr>
             <#list map.EFEList! as EFE>
             <#if EFE.EF070I01??>
            <tr>
             	<td class="datatd">${EFE.EF070I01!}</td>
                <td class="datatd">${EFE.EF070Q01!}</td>
                <td class="datatd">${EFE.EF070Q02!}</td>
                <td class="datatd">${EFE.EF070R01!}</td>
                <td class="datatd">${EFE.EF070R02!}</td>
                <td class="datatd">${EFE.EF070Q03!}</td>
            </tr>
             <#else>
             </#if>
            </#list>
              </table><br>
         <#else>
             </#if>
       
     <#if (map.EFEList?size>0)>        
       <table class="mainTable">
            <tr>
                <td class="titletd" colspan="6">
                    <li>获得资质记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资质记录编号</td>
                <td class="labeltd">认定部门名称</td>
                <td class="labeltd">资质类型</td>
                <td class="labeltd">批准日期</td>
                <td class="labeltd">截止日期</td>
                <td class="labeltd">资质内容</td>
            </tr>
            <#list map.EFEList! as EFE>
             <#if EFE.EF080I01??>
            <tr>
            	<td class="datatd">${EFE.EF080I01!}</td>
                <td class="datatd">${EFE.EF080Q01!}</td>
                <td class="datatd">${EFE.EF080Q02!}</td>
                <td class="datatd">${EFE.EF080R01!}</td>
                <td class="datatd">${EFE.EF080R02!}</td>
                <td class="datatd">${EFE.EF080Q03!}</td>
            </tr>
             <#else>
             </#if>
             </#list>
              </table><br>
               <#else>
             </#if>
       
       
     <#if (map.EFEList?size>0)>      
       <table class="mainTable">
            <tr>
                <td class="titletd" colspan="6">
                    <li>获得奖励记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">奖励记录编号</td>
                <td class="labeltd">奖励部门名称</td>
                <td class="labeltd">奖励名称</td>
                <td class="labeltd">授予日期</td>
                <td class="labeltd">截止日期</td>
                <td class="labeltd">奖励内容</td>
            </tr>
            <#list map.EFEList! as EFE>
             <#if EFE.EF090I01??>
            <tr>
            	<td class="datatd">${EFE.EF090I01!}</td>
            	<td class="datatd">${EFE.EF090Q01!}</td>
                <td class="datatd">${EFE.EF090Q02!}</td>
                <td class="datatd">${EFE.EF090R01!}</td>
                <td class="datatd">${EFE.EF090R02!}</td>
                <td class="datatd">${EFE.EF090Q03!}</td>
            </tr>
              <#else>
             </#if>
             </#list>
  </table><br>
       <#else>
             </#if>
             
             
       
        <#if (map.EFEList?size>0)>           
       <table class="mainTable">
            <tr>
                <td class="titletd" colspan="6">
                    <li>拥有专利情况信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="labeltd">专利名称</td>
                <td class="labeltd">专利号</td>
                <td class="labeltd">申请日期</td>
                <td class="labeltd">授予日期</td>
                <td class="labeltd">专利有效期</td>
            </tr>
           <#list map.EFEList! as EFE>
             <#if EFE.EF100I01??>
            <tr>
            	<td class="datatd">${EFE.EF100I01!}</td>
            	<td class="datatd">${EFE.EF100Q01!}</td>
                <td class="datatd">${EFE.EF100I02!}</td>
                <td class="datatd">${EFE.EF100R01!}</td>
                <td class="datatd">${EFE.EF100R02!}</td>
                <td class="datatd">${EFE.EF100S01!}</td>
            </tr>
             <#else>
             </#if>
             </#list>
        </table><br>
        <#else>
             </#if>
             
             
             
        
               
            <#if (map.EFFList?size>0)>            
            <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>出入境检验检疫绿色通道信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="labeltd">批准部门名称</td>
                <td class="labeltd">出口商品名称</td>
                <td class="labeltd">生效日期</td>
            </tr>
             <#list map.EFFList! as EFF>
             <#if EFF.EF110I01??>
            <tr>
           		<td class="datatd">${EFF.EF110I01!}</td>
            	<td class="datatd">${EFF.EF110Q01!}</td>
                <td class="datatd">${EFF.EF110Q02!}</td>
                <td class="datatd">${EFF.EF110R01!}</td>
            </tr>
            <#else>
             </#if>
            </#list>
            </table><br>
            <#else>
             </#if>
            
            
               
             <#if (map.EFFList?size>0)>        
            <table class="mainTable">
            <tr>
                <td class="titletd" colspan="5">
                    <li>进出口商品免验信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="labeltd">批准部门名称</td>
                <td class="labeltd">免验商品名称</td>
                <td class="labeltd">免验号</td>
                <td class="labeltd">截止日期</td>
            </tr>
            <#list map.EFFList! as EFF>
            <#if EFF.EF120I01??>
            <tr>
            	<td class="datatd">${EFF.EF120I01!}</td>
                <td class="datatd">${EFF.EF120Q01!}</td>
                <td class="datatd">${EFF.EF120Q02!}</td>
                <td class="datatd">${EFF.EF120I01!}</td>
                <td class="datatd">${EFF.EF120R02!}</td>
            </tr>
            <#else>
             </#if>
            </#list>
            </table><br>
              <#else>
             </#if>
             
             
             
             
              
          <#if (map.EFFList?size>0)>     
            <table class="mainTable">
            <tr>
                <td class="titletd" colspan="6">
                    <li>进出口商品检验分类监管信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="labeltd">监管部门名称</td>
                <td class="labeltd">管辖直属局</td>
                <td class="labeltd">监管级别</td>
                <td class="labeltd">生效日期</td>
                <td class="labeltd">截至日期</td>
            </tr>
            <#list map.EFFList! as EFF>
            <#if EFF.EF130I01??>
            <tr>
            	<td class="datatd">${EFF.EF130I01!}</td>
            	<td class="datatd">${EFF.EF130Q01!}</td>
                <td class="datatd">${EFF.EF130Q02!}</td>
                <td class="datatd">${DataDicUtil.getDataDic("6114", EFF.EF130D01)!}</td>
                <td class="datatd">${EFF.EF130R01!}</td>
                <td class="datatd" >${EFF.EF130R02!}</td>
            </tr>
            <#else>
             </#if>
            </#list>
        </table>    <br>
               <#else>
             </#if>
               
     <#if (map.EFGList?size>0)>
                        
                            
               <table class="mainTable">
            <tr>
                <td class="titletd" colspan="5">
                    <li>融资规模控制信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="labeltd">所属名录</td>
                <td class="labeltd">融资控制类型</td>
                <td class="labeltd">年度</td>
                <td class="labeltd">规模</td>
            </tr>
            <#list map.EFGList! as EFG>
            <tr>
            	<td class="datatd">${EFG.EF140I01!}</td>
            	<td class="datatd">${DataDicUtil.getDataDic("6115", EFG.EF140D01)!}</td>
                <td class="datatd">${DataDicUtil.getDataDic("6116", EFG.EF140D02)!}</td>
                <td class="datatd">${EFG.EF140R01!}</td>
                <td class="datatd">
                  <#if EFG.EF140J01??>
                      ${EFG.EF140J01!}
                  <#else >
                  </#if>
                </td>
            </tr>
            </#list>
        </table><br>
        
        <#else >
        </#if>
        
           <h2>财务信息单元</h2>     
          <table class="mainTable">
          <tr>
                <td class="titletd" colspan="5">
                    <li>企业资产负债表/事业单位资产负债表</li>
                </td>
            </tr>
             <tr>
            	<td class="labeltd">报表类型</td>
           		<td class="labeltd">${map.nowyear!}</td>
           		<td class="labeltd">${map.year1!}</td>
           		<td class="labeltd">${map.year2!}</td>
           		<td class="labeltd">${map.year3!}</td>
            </tr>
             <tr>
            	<td class="labeltd">年报</td>
            	<td class="datatd">
            		<#if map.EGA_1_0_10??>
            			<a href=JavaScript:financeServer('fuzha','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_0_10)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_10??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_10)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_10??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_10)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_10??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_10)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">半年报（上）</td>
            					<td class="datatd">
            		<#if map.EGA_1_0_20??>
            			<a href=JavaScript:financeServer('fuzha','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_0_20)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_20??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_20)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_20??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_20)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_20??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_20)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">半年报（下）</td>
            					<td class="datatd">
            		<#if map.EGA_1_0_30??>
            			<a href=JavaScript:financeServer('fuzha','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_0_30)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_30??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_30)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_30??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_30)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_30??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_30)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（一）</td>
            					<td class="datatd">
            		<#if map.EGA_1_0_40??>
            			<a href=JavaScript:financeServer('fuzha','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_0_40)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_40??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_40)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_40??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_40)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_40??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_40)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（二）</td>
            					<td class="datatd">
            		<#if map.EGA_1_0_50??>
            			<a href=JavaScript:financeServer('fuzha','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_0_50)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_50??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_50)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_50??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_50)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_50??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_50)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（三）</td>
            					<td class="datatd">
            		<#if map.EGA_1_0_60??>
            			<a href=JavaScript:financeServer('fuzha','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_0_60)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_60??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_60)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_60??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_60)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_60??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_60)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（四）</td>
            					<td class="datatd">
            		<#if map.EGA_1_0_70??>
            			<a href=JavaScript:financeServer('fuzha','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_0_70)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_70??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_70)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_70??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_70)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_70??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_70)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
           </table><br>
           
           
           <table class="mainTable">
            <tr>
                <td class="titletd" colspan="5">
                    <li>企业利润表/事业单位收入支出表</li>
                </td>
            </tr>
            <tr>
            	<td class="labeltd">报表类型</td>
           		<td class="labeltd">${map.nowyear!}</td>
           		<td class="labeltd">${map.year1!}</td>
           		<td class="labeltd">${map.year2!}</td>
           		<td class="labeltd">${map.year3!}</td>
            </tr>
             <tr>
            	<td class="labeltd">年报</td>
            	<td class="datatd">
            		<#if map.EGA_2_0_10??>
            			<a href=JavaScript:financeServer('shouru','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_0_10)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_10??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_10)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_10??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_10)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_10??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_10)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">半年报（上）</td>
            					<td class="datatd">
            		<#if map.EGA_2_0_20??>
            			<a href=JavaScript:financeServer('shouru','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_0_20)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_20??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_20)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_20??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_20)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_20??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_20)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">半年报（下）</td>
            					<td class="datatd">
            		<#if map.EGA_2_0_30??>
            			<a href=JavaScript:financeServer('shouru','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_0_30)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_30??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_30)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_30??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_30)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_30??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_30)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（一）</td>
            					<td class="datatd">
            		<#if map.EGA_2_0_40??>
            			<a href=JavaScript:financeServer('shouru','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_0_40)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_40??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_40)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_40??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_40)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_40??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_40)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（二）</td>
            					<td class="datatd">
            		<#if map.EGA_2_0_50??>
            			<a href=JavaScript:financeServer('shouru','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_0_50)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_50??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_50)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_50??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_50)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_50??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_50)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（三）</td>
            					<td class="datatd">
            		<#if map.EGA_2_0_60??>
            			<a href=JavaScript:financeServer('shouru','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_0_60)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_60??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_60)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_60??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_60)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_60??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_60)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（四）</td>
            					<td class="datatd">
            		<#if map.EGA_2_0_70??>
            			<a href=JavaScript:financeServer('shouru','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_0_70)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_70??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_70)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_70??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_70)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_70??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_70)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
           </table><br>
          
          
          <table class="mainTable">
          <tr>
                <td class="titletd" colspan="5">
                    <li>企业现金流量表</li>
                </td>
            </tr>
             <tr>
            	<td class="labeltd">报表类型</td>
           		<td class="labeltd">${map.nowyear!}</td>
           		<td class="labeltd">${map.year1!}</td>
           		<td class="labeltd">${map.year2!}</td>
           		<td class="labeltd">${map.year3!}</td>
            </tr>
            <tr>
            	<td class="labeltd">年报</td>
            	<td class="datatd">
            		<#if map.EGA_3_0_10??>
            			<a href=JavaScript:financeServer('xianjin','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_0_10)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_10??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_10)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_10??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_10)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_10??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_10)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">半年报（上）</td>
            					<td class="datatd">
            		<#if map.EGA_3_0_20??>
            			<a href=JavaScript:financeServer('xianjin','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_0_20)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_20??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_20)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_20??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_20)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_20??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_20)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">半年报（下）</td>
            					<td class="datatd">
            		<#if map.EGA_3_0_30??>
            			<a href=JavaScript:financeServer('xianjin','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_0_30)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_30??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_30)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_30??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_30)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_30??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_30)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（一）</td>
            					<td class="datatd">
            		<#if map.EGA_3_0_40??>
            			<a href=JavaScript:financeServer('xianjin','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_0_40)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_40??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_40)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_40??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_40)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_40??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_40)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（二）</td>
            					<td class="datatd">
            		<#if map.EGA_3_0_50??>
            			<a href=JavaScript:financeServer('xianjin','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_0_50)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_50??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_50)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_50??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_50)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_50??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_50)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（三）</td>
            					<td class="datatd">
            		<#if map.EGA_3_0_60??>
            			<a href=JavaScript:financeServer('xianjin','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_0_60)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_60??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_60)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_60??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_60)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_60??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_60)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
            <tr>
            	<td class="labeltd">季报（四）</td>
            					<td class="datatd">
            		<#if map.EGA_3_0_70??>
            			<a href=JavaScript:financeServer('xianjin','${map.nowyear!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_0_70)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_70??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_70)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_70??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_70)!}
            			</a>
            		<#else >--
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_70??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_70)!}
            			</a>
            		<#else >--
            		</#if>
            	</td>
            </tr>
           </table><br>
           
                <h2>评级信息</h2>
        <table class="mainTable">
            <tr>
                <td class="labeltd">评级信息编号</td>
                <td class="labeltd">评级机构名称</td>
                <td class="labeltd">评级日期</td>
                <td class="labeltd">评级结果</td>
            </tr>
            <tr>
             	<td class="datatd">${map.EHA.EH010I01!}</td>
             	<td class="datatd">${map.EHA.EH010Q01!}</td>
              	<td class="datatd">${map.EHA.EH010R01!}</td>
                <td class="datatd">${map.EHA.EH010D01!}</td>
            </tr>
        </table> <br>
        
        
        
         <h2>声明及标注信息</h2>
        <table class="mainTable">
            <tr>
                <td class="labeltd">对象类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6054", map.EIA.EI010D01)!}</td>
                <td class="labeltd">对象标识</td>
                <td class="datatd">${DataDicUtil.getDataDic("6055", map.EIA.EI010I01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">标注及声明类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6120", map.EIA.EI010D02)!}</td>
                <td class="labeltd">添加日期</td>
                <td class="datatd">${map.EIA.EI010R01!}</td>
            </tr>
            <tr>
                
                <td class="labeltd">标注或声明内容</td>
                <td class="datatd" colspan="3">${map.EIA.EI010Q01!}</td>
            </tr>
        </table>       
                
    <!-- <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/> -->
</div>
</body>

</html>
