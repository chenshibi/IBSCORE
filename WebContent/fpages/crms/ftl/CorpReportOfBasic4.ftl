<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<html  oncontextmenu="return false" onselectstart="return false" ondragstart="return false" onbeforecopy="return false" oncopy=document.selection.empty() onselect=document.selection.empty()>
<head>
    <title>企业一般信息展开(二级)</title>
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
     <h1>企业一般信息展开(二级)</h1>
    <!--
    <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/> <br>
   -->
                   
       
  	<h2>(一)报告主体内容补充</H2>
   		<table>
           	    <tr>
             	   <td class="titletd" colspan="8">
              	      <li>被追偿记录</li>
             	   </td>
             	   <td colspan="2" class="table-head-td">共${map.ED01_51List?size!}笔</td>
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
               		
               		<#list map.ED01_51List! as ED01_51List>
               		<tr>
               			<td class="datatd" rowspan="2">${ED01_51List.ED01AI01!}</td>
               			<td class="datatd">${ED01_51List.ED01AI02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6043",ED01_51List.ED01AD05)!}</td>
               			<td class="datatd">${ED01_51List.ED01AR01!}</td>
               			<td class="datatd">${ED01_51List.ED01AD07!}</td>
               			<td class="datatd">${ED01_51List.ED01AJ01!}</td>
               			<td class="datatd">${ED01_51List.ED01BJ01!}</td>
               			<td class="datatd" rowspan="2">${ED01_51List.ED01BR01!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_51List.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_51List.ED01BD01)!}</td>
               			<td class="datatd">${ED01_51List.ED01BR04!}</td>
               			<td class="datatd">${ED01_51List.ED01BJ02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_51List.ED01BD02)!}</td>
               			<td class="datatd">查看</td>
               		</tr>
               		</#list>
                </table><br>
   		
   		<table>
			<tr>
             	<td class="titletd-2" colspan="1">
                   	<li>未结清信贷</li>
                </td>
           	</tr>
 		</table>
   		<table>
			<tr>
             	<td class="titletd-3" colspan="1">
                   	中长期借款
                </td>
                <td colspan="2" class="table-head-td">共${map.ED01_1_23List?size!}笔</td>
           	</tr>
 		</table>
 		
 		<table class="mainTable">
        	
             		<tr>
             			<td rowspan="3" class="labeltd-2">账户编号</td>
             			<td  class="labeltd-2">授信机构</td>
             			<td  class="labeltd-2">业务种类</td>
             			<td  class="labeltd-2">开立日期</td>
             			<td  class="labeltd-2">到期日</td>
             			<td  class="labeltd-2">币种</td>
             			<td  class="labeltd-2">借款金额</td>
             			<td  class="labeltd-2">发放形式</td>
             		</tr>
             		<tr>
             			<td  class="labeltd-2">担保方式</td>
             			<td  class="labeltd-2">余额</td>
             			<td  class="labeltd-2">五级分类</td>
             			<td  class="labeltd-2">逾期总额</td>
             			<td  class="labeltd-2">逾期本金</td>
             			<td  class="labeltd-2">逾期月数</td>
             			<td  class="labeltd-2">最近一次还款日期</td>
             		</tr>
             		<tr>
             			<td  class="labeltd-2">最近一次还款总额</td>
             			<td  class="labeltd-2">最近一次还款形式</td>
             			<td  class="labeltd-2">特定交易提示</td>
             			<td  class="labeltd-2">授信协议编号</td>
             			<td  class="labeltd-2">历史表现</td>
             			<td colspan="2" class="labeltd-2">信息报告日期</td>
             		</tr>
             		
             		<#list map.ED01_1_23List! as ED01_1_23List>
					<tr>
						<td rowspan="3" class="datatd">${ED01_1_23List.ED01AI01!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01AI02!}</td>
            			<td  class="datatd">${DataDicUtil.getDataDic("6085",ED01_1_23List.ED01AD06)!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01AR01!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01AR02!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01AD07!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01AJ01!}</td>
            			<td  class="datatd">${DataDicUtil.getDataDic("6099",ED01_1_23List.ED01AD10)!}</td>
           			</tr>
             		<tr>
            			<td  class="datatd">${DataDicUtil.getDataDic("6096",ED01_1_23List.ED01AD08)!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01BJ01!}</td>
            			<td  class="datatd">${DataDicUtil.getDataDic("6032",ED01_1_23List.ED01BD01)!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01BJ04!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01BJ05!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01BS02!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01BR04!}</td>
           			</tr>
             		<tr>
            			<td  class="datatd">${ED01_1_23List.ED01BJ02!}</td>
            			<td  class="datatd">${DataDicUtil.getDataDic("6101",ED01_1_23List.ED01BD02)!}</td>
            			<td  class="datatd">${DataDicUtil.getDataDic("6102",ED01_1_23List.ED01CD01)!}</td>
            			<td  class="datatd">${ED01_1_23List.ED01AI03!}</td>
            			<td  class="datatd">查看</td>
            			<td colspan="2"  class="datatd">${ED01_1_23List.ED01BR01!}</td>
           			</tr>
           			</#list>
        </table><br>
        
        <table>
           	   <tr>
           	    	<td class="titletd-3" colspan="6">
              	      		 短期借款
             	   	</td>
             	   	 <td colspan="2" class="table-head-td">共${map.ED01_1_1List?size!}笔</td>
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
               		
               		<#list map.ED01_1_1List! as ED01_1_1List>
               		<tr>
               			<td class="datatd" rowspan="3">${ED01_1_1List.ED01AI01!}</td>
               			<td class="datatd">${ED01_1_1List.ED01AI02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_1List.ED01AD06)!}</td>
               			<td class="datatd">${ED01_1_1List.ED01AR01!}</td>
               			<td class="datatd">${ED01_1_1List.ED01AR02!}</td>
               			<td class="datatd">${ED01_1_1List.ED01AD07!}</td>
               			<td class="datatd">${ED01_1_1List.ED01AJ01!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6099",ED01_1_1List.ED01AD10)!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6096",ED01_1_1List.ED01AD08)!}</td>
               			<td class="datatd">${ED01_1_1List.ED01BJ01!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_1_1List.ED01BD01)!}</td>
               			<td class="datatd">${ED01_1_1List.ED01BJ04!}</td>
               			<td class="datatd">${ED01_1_1List.ED01BJ05!}</td>
               			<td class="datatd">${ED01_1_1List.ED01BS02!}</td>
               			<td class="datatd">${ED01_1_1List.ED01BR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_1_1List.ED01BJ02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_1_1List.ED01BD02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6102",ED01_1_1List.ED01CD01)!}</td>
               			<td class="datatd">${ED01_1_1List.ED01AI03!}</td>
               			<td class="datatd">查看</td>
               			<td class="datatd" colspan="2">${ED01_1_1List.ED01BR01!}</td>
               		</tr>
               		</#list>
               		
        </table><br>
        
        
        <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 循环透支
             	   		</td>
             	   		<td colspan="2" class="table-head-td">共${map.ED01_1_R1List?size!}笔</td>
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
               		
               		<#list map.ED01_1_R1List! as ED01_1_R1List>
               		<tr>
               			<td class="datatd" rowspan="3">${ED01_1_R1List.ED01AI01!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01AI02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_R1List.ED01AD06)!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01AR01!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01AR02!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01AD07!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01AJ01!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6099",ED01_1_R1List.ED01AD10)!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6096",ED01_1_R1List.ED01AD08)!}/td>
               			<td class="datatd">${ED01_1_R1List.ED01BJ01!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_1_R1List.ED01BD01)!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01BJ04!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01BJ05!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01BS02!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01BR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_1_R1List.ED01BJ02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_1_R1List.ED01BD02)!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01BS03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6102",ED01_1_R1List.ED01CD01)!}</td>
               			<td class="datatd">${ED01_1_R1List.ED01AI03!}</td>
               			<td class="datatd">查看</td>
               			<td class="datatd">${ED01_1_R1List.ED01BR01!}</td>
               		</tr>
               		</#list>
               		
               </table><br>
               
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
               		<#list map.ED02List! as ED02List>
               		<tr>
               			<td class="datatd">${ED02List.ED020I02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED02List.ED020D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED02List.ED020D03)!}</td>
						<td class="datatd">${ED02List.ED020S01!}</td>
						<td class="datatd">${ED02List.ED020J01!}</td>
						<td class="datatd">${ED02List.ED020J02!}</td>
						<td class="datatd">${ED02List.ED020J03!}</td>
               		</tr>
  					</#list>
               </table><br>
               
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
               		<#list map.ED05_51_61List! as ED05_51_61List>
               		<tr>
               			<td class="datatd">${ED05_51_61List.ED050I02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6095",ED05_51_61List.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05_51_61List.ED050D03)!}</td>
               			<td class="datatd">${ED05_51_61List.ED050S01!}</td>
               			<td class="datatd">${ED05_51_61List.ED050J02!}</td>
               			<td class="datatd">${ED05_51_61List.ED050J03!}</td>
               			<td class="datatd">${ED05_51_61List.ED050J04!}</td>
               			<td class="datatd">${ED05_51_61List.ED050J05!}</td>
               			<td class="datatd">${ED05_51_61List.ED050J01!}</td>
               		</tr>
  					</#list>
               </table><br>
               
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
               		<#list map.ED05_51_otherList! as ED05_51_otherList>
           	    	 <tr>
           	    	 	<td class="datatd">${ED05_51_otherList.ED050I02!}</td>
           	    	 	<td class="datatd"> ${DataDicUtil.getDataDic("6095",ED05_51_otherList.ED050D02)!}</td>
           	    	 	<td class="datatd">${DataDicUtil.getDataDic("6032",ED05_51_otherList.ED050D03)!}</td>
               			<td class="datatd">${ED05_51_otherList.ED050S01!}</td>
               			<td class="datatd">${ED05_51_otherList.ED050J01!}</td>
               		 </tr>	
               		 </#list>
                </table><br>
               
               <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="7">
              	      		授信信息
             	   		</td>
             	   		<td colspan="2" class="table-head-td">共${map.EDCList?size!}笔</td>
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
               		<#list map.EDCList! as EDCList>
               		<tr>
                 		<td class="datatd" rowspan="2">${EDCList.ED060I01!}</td>
               			<td class="datatd">${EDCList.ED060I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6098",EDCList.ED060D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6104",EDCList.ED060D03)!}</td>
               			<td class="datatd">${EDCList.ED060R01!}</td>
               			<td class="datatd">${EDCList.ED060R02!}</td>
               			<td class="datatd" rowspan="2">${EDCList.ED060R03!}</td>
               		</tr>
               		<tr>
                 		<td class="datatd">${EDCList.ED060D04!}</td>
               			<td class="datatd">${EDCList.ED060J01!}</td>
               			<td class="datatd">${EDCList.ED060J04!}</td>
               			<td class="datatd">${EDCList.ED060J03!}</td>
               			<td class="datatd">${EDCList.ED060I03!}</td>
               		</tr>
               		</#list>
                </table><br>
                
        
        <table>
           	    	<tr>
             	   		<td class="titletd-2" colspan="6">
              	      		<li>已结清信贷</li>
             	   		</td>
           	    	 </tr>
           		 </table>  
                
            <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 中长期借款
             	   		</td>
             	   		<td colspan="2" class="table-head-td">共${map.ED01_2_23List?size!}笔</td>
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
               		
               		<#list map.ED01_2_23List! as ED01_2_23List>
               		<tr>
               			<td class="datatd" rowspan="2">${ED01_2_23List.ED01AI01!}</td>
               			<td class="datatd">${ED01_2_23List.ED01AI02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6085",ED01_2_23List.ED01AD06)!}</td>
               			<td class="datatd">${ED01_2_23List.ED01AR01!}</td>
               			<td class="datatd">${ED01_2_23List.ED01AR02!}</td>
               			<td class="datatd">${ED01_2_23List.ED01AD07!}</td>
               			<td class="datatd">${ED01_2_23List.ED01AJ01!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_2_23List.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_2_23List.ED01BD01)!}</td>
               			<td class="datatd">${ED01_2_23List.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_2_23List.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               		</#list>
               </table><br>
               
               <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 短期借款
             	   		</td>
             	   		<td colspan="2" class="table-head-td">共${map.ED01_2_1List?size!}笔</td>
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
               		
               		<#list map.ED01_2_1List! as ED01_2_1List>
               		<tr>
               			<td class="datatd" rowspan="2">${ED01_2_1List.ED01AI01!}</td>
               			<td class="datatd">${ED01_2_1List.ED01AI02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6085",ED01_2_1List.ED01AD06)!}</td>
               			<td class="datatd">${ED01_2_1List.ED01AR01!}</td>
               			<td class="datatd">${ED01_2_1List.ED01AR02!}</td>
               			<td class="datatd">${ED01_2_1List.ED01AD07!}</td>
               			<td class="datatd">${ED01_2_1List.ED01AJ01!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_2_1List.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_2_1List.ED01BD01)!}</td>
               			<td class="datatd">${ED01_2_1List.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_2_1List.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               		</#list>
               </table><br>
               
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 循环透支
             	   		</td>
             	   		<td colspan="2" class="table-head-td">共${map.ED01_2_R1List?size!}笔</td>
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
               		
               		<#list map.ED01_2_R1List! as ED01_2_R1List>
               		<tr>
               			<td class="datatd" rowspan="2">${ED01_2_R1List.ED01AI01!}</td>
               			<td class="datatd">${ED01_2_R1List.ED01AI02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6090",ED01_2_R1List.ED01AD06)!}</td>
               			<td class="datatd">${ED01_2_R1List.ED01AR01!}</td>
               			<td class="datatd">${ED01_2_R1List.ED01AR02!}</td>
               			<td class="datatd">${ED01_2_R1List.ED01AD07!}</td>
               			<td class="datatd">${ED01_2_R1List.ED01AJ01!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_2_R1List.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_2_R1List.ED01BD01)!}</td>
               			<td class="datatd">${ED01_2_R1List.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_2_R1List.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               		</#list>
               </table><br>
               
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
               		<#list map.ED02List! as ED02List>
               		<tr>
               			<td class="datatd">${ED02List.ED020I02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED02List.ED020D02)!}</td>
						<td class="datatd">${DataDicUtil.getDataDic("6032",ED02List.ED020D03)!}</td>
               			<td class="datatd">${ED02List.ED020S02!}</td>
						<td class="datatd">${ED02List.ED020J04!}</td>
               		</tr>
               		</#list>
               </table><br>
               
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
               		<#list map.ED05_51_61List! as ED05_51_61List>
               		<tr>
           	    	 	<td class="datatd">${ED05_51_61List.ED050I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6095",ED05_51_61List.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05_51_61List.ED050D03)!}</td>
               			<td class="datatd">${ED05_51_61List.ED050S02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("66075",ED05_51_61List.ED050D04)!}</td>
               		 </tr>
               		 </#list>
               </table><br>
               
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
               		<#list map.ED05_51_otherList! as ED05_51_otherList>
               		<tr>
           	    	 	<td class="datatd">${ED05_51_otherList.ED050I02!}</td>
           	    	 	<td class="datatd">${DataDicUtil.getDataDic("6095",ED05_51_otherList.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05_51_otherList.ED050D03)!}</td>
               			<td class="datatd">${ED05_51_otherList.ED050S02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("66075",ED05_51_otherList.ED050D04)!}</td>
               		 </tr>
               		</#list>
                </table><br>   
        
  	<h2>(三)被追偿记录的历史表现</H2>
  		
  		<table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_41_51List?size!}笔</td>
           	</tr>
 		</table> 
  		
 		<table class="mainTable">
        	
        	<tr>
        		<td  class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
            	<td  class="labeltd">业务种类:</td>
        		
            	<td  class="labeltd">信息报告日期</td>     
            	<td  class="labeltd">余额</td>     
            	<td  class="labeltd">余额变化日期</td>     
            	<td  class="labeltd">五级分类</td>     
            	<td  class="labeltd">五级分类认定日期</td>     
            	<td  class="labeltd">最近一次实际还款日期</td>     
            	<td  class="labeltd">最近一次实还总额</td>     
            	<td  class="labeltd">最近一次还款形式</td>     
            </tr>
         	<#list map.ED01_41_51List! as ED01_41_51List>
            <tr>
            	<td class="datatd">${ED01_41_51List.ED01AI01!}</td>
            	<td class="datatd">${ED01_41_51List.ED01AI02!}</td>    
            	<td class="datatd">${DataDicUtil.getDataDic("6043",ED01_41_51List.ED01AD05)!}</td>
            
            	<td  class="table-data-td">${ED01_41_51List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_41_51List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_41_51List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_41_51List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_41_51List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_41_51List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_41_51List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_41_51List.ED01BD02)!}</td>
            </tr>	
        	</#list>
        </table>
        <br>
  		
  		<table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_41_51List?size!}笔</td>
           	</tr>
 		</table> 
  		
 		<table class="mainTable">
        	<tr>
        		<td  class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
            	<td  class="labeltd">业务种类:</td> 
        	
            	<td  class="labeltd">信息报告日期</td>     
            	<td  class="labeltd">余额</td>     
            	<td  class="labeltd">余额变化日期</td>     
            	<td  class="labeltd">五级分类</td>     
            	<td  class="labeltd">五级分类认定日期</td>     
            	<td  class="labeltd">最近一次实际还款日期</td>     
            	<td  class="labeltd">最近一次实还总额</td>     
            	<td  class="labeltd">最近一次还款形式</td>     
            </tr>
            
            <#list map.ED01_1_41_51List! as ED01_1_41_51List>
            <tr>
            	<td class="datatd">${ED01_1_41_51List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_41_51List.ED01AI02!}</td>    
            	<td class="datatd">${DataDicUtil.getDataDic("6043",ED01_1_41_51List.ED01AD05)!}</td>
            
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_41_51List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_41_51List.ED01BD02)!}</td>
            </tr>	
        	</#list>
        </table>
        <br>
  		
  		
   
   <h2>(四)中长期借款的历史表现</H2> 
   	    
   	    <table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_1_23List?size!}笔</td>
           	</tr>
 		</table> 
 		
 		<table class="mainTable">
        	<tr>
        		<td  rowspan="3" class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
            	
            	<td rowspan="3" class="labeltd">信用报告日期</td>
            	<td  class="labeltd">余额</td>
             	<td  class="labeltd">余额变化日期</td>
             	<td  class="labeltd">五级分类</td>
             	<td  class="labeltd">五级分类认定日期</td>
             	<td  class="labeltd">逾期总额</td>
             	<td  class="labeltd">逾期本金</td>
             </tr>
             <tr>
             	<td  rowspan="2" class="labeltd">业务种类:</td>
             	
             	<td  class="labeltd">逾期月数</td>
             	<td  class="labeltd">最近一次约定还款日期</td>
             	<td  class="labeltd">最近一次应还总额</td>
             	<td  class="labeltd">最近一次实际还款日期</td>
             	<td  class="labeltd">最近一次实还总额</td>
             	<td  class="labeltd">最近一次还款形式</td>
             </tr>
             <tr>
             	<th>特定交易提示</th>
            	<td  class="labeltd">交易类型</td>     
            	<td  class="labeltd">交易日期</td>     
            	<td  class="labeltd">交易金额</td>     
            	<td  class="labeltd">到期日期变更月数</td>     
            	<td  class="labeltd">交易明细信息</td>     
            </tr>
            
            <#list map.ED01_1_1_23List! as ED01_1_1_23List>
            <tr>
             	<td rowspan="3" class="datatd">${ED01_1_1_23List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_1_23List.ED01AI02!}</td>  
             	
            	<td rowspan="3" class="table-data-td">${ED01_1_1_23List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_23List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BJ04!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BJ05!}</td>
           	</tr>
           	<tr>
           		<#if (ED01_1_1_23List.ED01AD05=='10') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_23List.ED01AD05=='11') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_23List.ED01AD05=='12') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_23List.ED01AD05=='13') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_23List.ED01AD05=='14') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_23List.ED01AD05=='15') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_23List.ED01AD05=='16') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_23List.ED01AD05=='21') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_23List.ED01AD05=='31') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_1_23List.ED01AD06)!}</td>
               			</#if>
           		
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BR05!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BJ03!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_1_23List.ED01BD02)!}</td>
           	</tr>
            <tr>
            	<th>特定交易提示--></th>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6102",ED01_1_1_23List.ED01CD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01CR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01CJ01!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01CS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01CQ01!}</td>
            </tr>	
        	</#list>
        </table>
        <br>
        
        <table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_2_23List?size!}笔</td>
           	</tr>
 		</table> 
 		
 		<table class="mainTable">
        	<tr>
        		<td  rowspan="2" class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
        	
            	<td rowspan="2" class="labeltd">信用报告日期</td>
            	<td  class="labeltd">余额</td>
             	<td  class="labeltd">余额变化日期</td>
             	<td  class="labeltd">五级分类</td>
             	<td  class="labeltd">五级分类认定日期</td>
             	<td  class="labeltd">逾期总额</td>
             	<td  class="labeltd">逾期本金</td>
             </tr>
             <tr>
             	<td  class="labeltd">业务种类:</td>
             
             	<td  class="labeltd">逾期月数</td>
             	<td  class="labeltd">最近一次约定还款日期</td>
             	<td  class="labeltd">最近一次应还总额</td>
             	<td  class="labeltd">最近一次实际还款日期</td>
             	<td  class="labeltd">最近一次实还总额</td>
             	<td  class="labeltd">最近一次还款形式</td>
             </tr>
            
             <#list map.ED01_1_2_23List! as ED01_1_2_23List>
             <tr>
             	<td rowspan="2" class="datatd">${ED01_1_2_23List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_2_23List.ED01AI02!}</td>  
             
            	<td rowspan="2" class="table-data-td">${ED01_1_2_23List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_23List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BJ04!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BJ05!}</td>
           	</tr>
           	<tr>
           		<#if (ED01_1_2_23List.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_23List.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_23List.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_23List.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_23List.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_23List.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_23List.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_23List.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_23List.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_2_23List.ED01AD06)!}</td>
               			</#if>
           		
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BS02!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BR05!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BJ03!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_23List.ED01BD02)!}</td>
           	</tr>
         	</#list>
         </table>
         <br>
         
    <h2>(五)短期借款的历史表现</H2> 
   	    <table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_1_1List?size!}笔</td>
           	</tr>
 		</table> 
 		
 		<table class="mainTable">
        	<tr>
        		<td  rowspan="3" class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
            	
            	<td rowspan="3" class="labeltd">信用报告日期</td>
            	<td  class="labeltd">余额</td>
             	<td  class="labeltd">余额变化日期</td>
             	<td  class="labeltd">五级分类</td>
             	<td  class="labeltd">五级分类认定日期</td>
             	<td  class="labeltd">逾期总额</td>
             	<td  class="labeltd">逾期本金</td>
             </tr>
             <tr>
             	<td  rowspan="2" class="labeltd">业务种类:</td>
             	
             	<td  class="labeltd">逾期月数</td>
             	<td  class="labeltd">最近一次约定还款日期</td>
             	<td  class="labeltd">最近一次应还总额</td>
             	<td  class="labeltd">最近一次实际还款日期</td>
             	<td  class="labeltd">最近一次实还总额</td>
             	<td  class="labeltd">最近一次还款形式</td>
             </tr>
             <tr>
             	<th>特定交易提示</th>
            	<td  class="labeltd">交易类型</td>     
            	<td  class="labeltd">交易日期</td>     
            	<td  class="labeltd">交易金额</td>     
            	<td  class="labeltd">到期日期变更月数</td>     
            	<td  class="labeltd">交易明细信息</td>     
            </tr>
            
            <#list map.ED01_1_1_1List! as ED01_1_1_1List>
            <tr>
             	<td rowspan="3" class="datatd">${ED01_1_1_1List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_1_1List.ED01AI02!}</td>  
             	
            	<td rowspan="3" class="table-data-td">${ED01_1_1_1List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_1List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BJ04!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BJ05!}</td>
           	</tr>
           	<tr>
           		<#if (ED01_1_1_1List.ED01AD05=='10') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_1List.ED01AD05=='11') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_1List.ED01AD05=='12') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_1List.ED01AD05=='13') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_1List.ED01AD05=='14') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_1List.ED01AD05=='15') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_1List.ED01AD05=='16') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_1List.ED01AD05=='21') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_1List.ED01AD05=='31') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_1_1List.ED01AD06)!}</td>
               			</#if>
           		
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BR05!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BJ03!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_1_1List.ED01BD02)!}</td>
           	</tr>
            <tr>
            	<th>特定交易提示--></th>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6102",ED01_1_1_1List.ED01CD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01CR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01CJ01!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01CS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01CQ01!}</td>
            </tr>	
        	</#list>
        </table>
        <br>
        
        <table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_2_1List?size!}笔</td>
           	</tr>
 		</table> 
 		
 		<table class="mainTable">
        	<tr>
        		<td  rowspan="2" class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
        	
            	<td rowspan="2" class="labeltd">信用报告日期</td>
            	<td  class="labeltd">余额</td>
             	<td  class="labeltd">余额变化日期</td>
             	<td  class="labeltd">五级分类</td>
             	<td  class="labeltd">五级分类认定日期</td>
             	<td  class="labeltd">逾期总额</td>
             	<td  class="labeltd">逾期本金</td>
             </tr>
             <tr>
             	<td  class="labeltd">业务种类:</td>
             
             	<td  class="labeltd">逾期月数</td>
             	<td  class="labeltd">最近一次约定还款日期</td>
             	<td  class="labeltd">最近一次应还总额</td>
             	<td  class="labeltd">最近一次实际还款日期</td>
             	<td  class="labeltd">最近一次实还总额</td>
             	<td  class="labeltd">最近一次还款形式</td>
             </tr>
            
             <#list map.ED01_1_2_1List! as ED01_1_2_1List>
             <tr>
             	<td rowspan="2" class="datatd">${ED01_1_2_1List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_2_1List.ED01AI02!}</td>  
             
            	<td rowspan="2" class="table-data-td">${ED01_1_2_1List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_1List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BJ04!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BJ05!}</td>
           	</tr>
           	<tr>
           		<#if (ED01_1_2_1List.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_1List.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_1List.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_1List.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_1List.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_1List.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_1List.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_1List.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_1List.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_2_1List.ED01AD06)!}</td>
               			</#if>
           		
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BS02!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BR05!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BJ03!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_1List.ED01BD02)!}</td>
           	</tr>
         	</#list>
         </table>
         <br>
   	    
    <h2>(六)循环透支的历史表现</H2> 
   	    <table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_1_R1List?size!}笔</td>
           	</tr>
 		</table> 
   	    
 		
 		<table class="mainTable">
        	<tr>
        		<td rowspan="3" class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
        		
            	<td rowspan="3" class="labeltd">信用报告日期</td>
            	<td  class="labeltd">余额</td>
             	<td  class="labeltd">余额变化日期</td>
             	<td  class="labeltd">五级分类</td>
             	<td  class="labeltd">五级分类认定日期</td>
             	<td  class="labeltd">逾期总额</td>
             	<td  class="labeltd">逾期本金</td>
             	<td  class="labeltd">逾期月数</td>
             </tr>
             <tr>
             	<td rowspan="2" class="labeltd">业务种类:</td> 
             	
             	<td  class="labeltd">最近一次约定还款日期</td>
             	<td  class="labeltd">最近一次应还总额</td>
             	<td  class="labeltd">最近一次实际还款日期</td>
             	<td  class="labeltd">最近一次实还总额</td>
             	<td  class="labeltd">最近一次还款形式</td>
             	<td colspan="2" class="labeltd">剩余还款月数</td>
             </tr>
             <tr>
            	<th>特定交易提示</th>
            	<td  class="labeltd">交易类型</td>     
            	<td  class="labeltd">交易日期</td>     
            	<td  class="labeltd">交易金额</td>     
            	<td  class="labeltd">到期日期变更月数</td>     
            	<td colspan="2" class="labeltd">交易明细信息</td>     
            </tr>
             
             <#list map.ED01_1_1_R1List! as ED01_1_1_R1List>
             <tr>
             	<td rowspan="3" class="datatd">${ED01_1_1_R1List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_1_R1List.ED01AI02!}</td>
             
            	<td rowspan="3" class="table-data-td">${ED01_1_1_R1List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_R1List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BJ04!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BJ05!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BS02!}</td>
           	</tr>
           	<tr>
           		<#if (ED01_1_1_R1List.ED01AD05=='10') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_R1List.ED01AD05=='11') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_R1List.ED01AD05=='12') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_R1List.ED01AD05=='13') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_R1List.ED01AD05=='14') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_R1List.ED01AD05=='15') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_R1List.ED01AD05=='16') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_R1List.ED01AD05=='21') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1_R1List.ED01AD05=='31') >
               				<td rowspan="2" class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_1_R1List.ED01AD06)!}</td>
               			</#if>
           		
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BR05!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BJ03!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_1_R1List.ED01BD02)!}</td>
            	<td colspan="2" class="table-data-td">${ED01_1_1_R1List.ED01BS03!}</td>
           	</tr>
            
            <tr>
            	<th>特定交易提示--></th>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6102",ED01_1_1_R1List.ED01CD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01CR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01CJ01!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01CS02!}</td>
            	<td colspan="2" class="table-data-td">${ED01_1_1_R1List.ED01CQ01!}</td>
            </tr>	
	        </#list>
        </table>
        <br>
        
        <table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_2_R1List?size!}笔</td>
           	</tr>
 		</table> 
 		
 		<table class="mainTable">
        	<tr>
        		<td rowspan="2" class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
        		
            	<td rowspan="2" class="labeltd">信用报告日期</td>
            	<td  class="labeltd">余额</td>
             	<td  class="labeltd">余额变化日期</td>
             	<td  class="labeltd">五级分类</td>
             	<td  class="labeltd">五级分类认定日期</td>
             	<td  class="labeltd">逾期总额</td>
             	<td  class="labeltd">逾期本金</td>
             	<td  class="labeltd">逾期月数</td>
             </tr>
             <tr>
             	<td  class="labeltd">业务种类:</td> 
             
             	<td  class="labeltd">最近一次约定还款日期</td>
             	<td  class="labeltd">最近一次应还总额</td>
             	<td  class="labeltd">最近一次实际还款日期</td>
             	<td  class="labeltd">最近一次实还总额</td>
             	<td  class="labeltd">最近一次还款形式</td>
             	<td colspan="2" class="labeltd">剩余还款月数</td>
             </tr>
             
             <#list map.ED01_1_2_R1List! as ED01_1_2_R1List>
             <tr>
             	<td rowspan="2" class="datatd">${ED01_1_2_R1List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_2_R1List.ED01AI02!}</td>    
             
            	<td rowspan="2" class="table-data-td">${ED01_1_2_R1List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_R1List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BJ04!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BJ05!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BS02!}</td>
           	</tr>
           	<tr>
           		<#if (ED01_1_2_R1List.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_R1List.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_R1List.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_R1List.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_R1List.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_R1List.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_R1List.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_R1List.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_2_R1List.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_2_R1List.ED01AD06)!}</td>
               			</#if>
           	
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BR05!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BJ03!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_R1List.ED01BD02)!}</td>
            	<td colspan="2" class="table-data-td">${ED01_1_2_R1List.ED01BS03!}</td>
           	</tr>
	        </#list>
         </table>
         <br>
	
	
	<h2>(七)	贴现的信贷明细、历史表现</H2> 
         <table>
			<tr>
				<li>1.未结清</li>
				<td class="titletd" colspan="1">
                   	<li>*信贷明细</li>
                </td>
				<td colspan="2" class="table-head-td">共${map.ED01_1_1_D2List?size!}笔</td>
           	</tr>
 		</table> 
   	    
            	
 		<table class="mainTable">
        	<tr>
        		<td  class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
            	<td  class="labeltd">业务种类:</td> 
        	
            	<td class="labeltd">开户日期</td>
            	<td class="labeltd">到期日</td>
            	<td class="labeltd">币种</td>
            	<td class="labeltd">贴现金额</td>
            	<td class="labeltd">担保方式</td>
            	<td class="labeltd">五级分类</td>
            	<td class="labeltd">授信协议编号</td>
            	<td class="labeltd">信息报告日期</td>
 			</tr>
 			<#list map.ED01_1_1_D2List! as ED01_1_1_D2List>
 			<tr>
 				<td class="datatd">${ED01_1_1_D2List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_1_D2List.ED01AI02!}</td>    
            	<td class="datatd">${DataDicUtil.getDataDic("6091",ED01_1_1_D2List.ED01AD06)!}</td> 
 			
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01AR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01AR02!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01AD07!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01AJ01!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6096",ED01_1_1_D2List.ED01AD08)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_D2List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01AI03!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01AR04!}</td>
           	</tr>
	     	</#list>
     	</table>
     	<br>
 		
 		<table>
			<tr>
             	<td class="titletd" colspan="1">
                   	<li>*历史表现</li>
                   	<td colspan="2" class="table-head-td">共${map.ED01_1_1_D2List?size!}笔</td>
                </td>
           	</tr>
 		</table>
   	    
 		<table class="mainTable">
        	<tr>
        		<td rowspan="3" class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
        		
            	<td rowspan="3" class="labeltd">信用报告日期</td>
            	<td  class="labeltd">余额</td>
             	<td  class="labeltd">余额变化日期</td>
             	<td  class="labeltd">五级分类</td>
             	<td  class="labeltd">五级分类认定日期</td>
             	<td  class="labeltd">逾期总额</td>
             	<td  class="labeltd">逾期本金</td>
             </tr>
             <tr>
             	<td rowspan="2" class="labeltd">业务种类:</td>
             	
             	<td  class="labeltd">逾期月数</td>
             	<td  class="labeltd">最近一次约定还款日期</td>
             	<td  class="labeltd">最近一次应还总额</td>
             	<td  class="labeltd">最近一次实际还款日期</td>
             	<td  class="labeltd">最近一次实还总额</td>
             	<td  class="labeltd">最近一次还款形式</td>
             </tr>
             <tr>
            	<th>特定交易提示</th>
            
            	<td  class="labeltd">交易类型</td>     
            	<td  class="labeltd">交易日期</td>     
            	<td  class="labeltd">交易金额</td>     
            	<td  class="labeltd">到期日期变更月数</td>     
            	<td  class="labeltd">交易明细信息</td>     
            </tr>
             <#list map.ED01_1_1_D2List! as ED01_1_1_D2List>
             <tr>
             	<td rowspan="3" class="datatd">${ED01_1_1_D2List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_1_D2List.ED01AI02!}</td>  
             
            	<td rowspan="3" class="table-data-td">${ED01_1_1_D2List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_D2List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BJ04!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BJ05!}</td>
           	</tr>
           	<tr>
           		<td rowspan="2" class="datatd">${DataDicUtil.getDataDic("6091",ED01_1_1_D2List.ED01AD06)!}</td>
           		
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BR05!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BJ03!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_1_D2List.ED01BD02)!}</td>
           	</tr>
            <tr>
            	<th>特定交易提示--></th>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6102",ED01_1_1_D2List.ED01CD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01CR01!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01CJ01!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01CS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01CQ01!}</td>
            </tr>	
	        </#list>
        </table>
        <br>
        
 		
 		<table>
			<tr>
				<li>2.已结清</li>
				<td class="titletd" colspan="1">
                   	<li>*信贷明细</li>
                </td>
				<td colspan="2" class="table-head-td">共${map.ED01_1_2_D2List?size!}笔</td>
           	</tr>
 		</table> 
   	   
 		<table class="mainTable">
        	<tr>
        		<td  class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
            	<td  class="labeltd">业务种类:</td>
        		
            	<td class="labeltd">开户日期</td>
            	<td class="labeltd">到期日</td>
            	<td class="labeltd">币种</td>
            	<td class="labeltd">贴现金额</td>
            	<td class="labeltd">关闭日期</td>
            	<td class="labeltd">五级分类</td>
            	<td class="labeltd">最后一次还款日期</td>
            	<td class="labeltd">最后一次还款形式</td>
 			</tr>
 			 <#list map.ED01_1_2_D2List! as ED01_1_2_D2List>
 			<tr>
 				<td class="datatd">${ED01_1_2_D2List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_2_D2List.ED01AI02!}</td>    
            	<td class="datatd">${DataDicUtil.getDataDic("6091",ED01_1_2_D2List.ED01AD06)!}</td> 
 			
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01AR01!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01AR02!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01AD07!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01AJ01!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01AR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_D2List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_D2List.ED01BD02)!}</td>
           	</tr>
	     	</#list>
     	</table>
     	<br>
 		
 		<table>
			<tr>
             	<td class="titletd" colspan="1">
                   	<li>*历史表现</li>
                </td>
                <td colspan="2" class="table-head-td">共${map.ED01_1_2_D2List?size!}笔</td>
           	</tr>
 		</table>
 		
   	    
 		<table class="mainTable">
        	<tr>
        		<td rowspan="2" class="labeltd">账户编号:</td>     
            	<td  class="labeltd">授信机构:</td> 
        	
            	<td rowspan="2" class="labeltd">信用报告日期</td>
            	<td  class="labeltd">余额</td>
             	<td  class="labeltd">余额变化日期</td>
             	<td  class="labeltd">五级分类</td>
             	<td  class="labeltd">五级分类认定日期</td>
             	<td  class="labeltd">逾期总额</td>
             	<td  class="labeltd">逾期本金</td>
             </tr>
             <tr>
             	<td  class="labeltd">业务种类:</td> 
             
             	<td  class="labeltd">逾期月数</td>
             	<td  class="labeltd">最近一次约定还款日期</td>
             	<td  class="labeltd">最近一次应还总额</td>
             	<td  class="labeltd">最近一次实际还款日期</td>
             	<td  class="labeltd">最近一次实还总额</td>
             	<td  class="labeltd">最近一次还款形式</td>
             </tr>
             
             <#list map.ED01_1_2_D2List! as ED01_1_2_D2List>
             <tr>
             	<td rowspan="2" class="datatd">${ED01_1_2_D2List.ED01AI01!}</td>
            	<td class="datatd">${ED01_1_2_D2List.ED01AI02!}</td>  
             
            	<td rowspan="2" class="table-data-td">${ED01_1_2_D2List.ED01BR01!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BJ01!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_D2List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BJ04!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BJ05!}</td>
           	</tr>
           	<tr>
           		<td class="datatd">${DataDicUtil.getDataDic("6091",ED01_1_2_D2List.ED01AD06)!}</td> 
           	
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BS02!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR05!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BJ03!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR04!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BJ02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_D2List.ED01BD02)!}</td>
           	</tr>
	         </#list>
         </table>
         <br>
 		
 	<h2>(八)银行承兑汇票和信用证的信贷明细</h2>
 		<table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED04_1_51_61List?size!}笔</td>
           	</tr>
 		</table> 
 		
 		
 		<table class="mainTable">
 			<tr>
 				<td rowspan="2" class="labeltd">授信机构:</td> 
            	<td  class="labeltd">业务种类:</td> 
 			
 				<td rowspan="2" class="labeltd">账户编号</td>
 				<td  class="labeltd">开立日期</td>
             	<td  class="labeltd">到期日</td>
             	<td  class="labeltd">币种</td>
             	<td  class="labeltd">金额</td>
             	<td  class="labeltd">反担保方式</td>
            </tr>
 			<tr>
 				<td  class="labeltd">五级分类:</td>     
 			
             	<td  class="labeltd">保证金比例</td>
             	<td  class="labeltd">余额</td>
             	<td  class="labeltd">风险敞口</td>
             	<td  class="labeltd">授信协议编号</td>
             	<td  class="labeltd">信息报告日期</td>
            </tr>
 			<#list map.ED04_1_51_61List! as ED04_1_51_61List>
 			<tr>
 				<td rowspan="2" class="datatd">${ED04_1_51_61List.ED04AI02!}</td>    
            	<td class="datatd">${DataDicUtil.getDataDic("6095",ED04_1_51_61List.ED04AD03)!}</td>
 			
            	<td rowspan="2" class="table-data-td">${ED04_1_51_61List.ED04AI01!}</td>
            	<td  class="table-data-td">${ED04_1_51_61List.ED04AR01!}</td>
            	<td  class="table-data-td">${ED04_1_51_61List.ED04AR02!}</td>
            	<td  class="table-data-td">${ED04_1_51_61List.ED04AD04!}</td>
            	<td  class="table-data-td">${ED04_1_51_61List.ED04AJ01!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6096",ED04_1_51_61List.ED04AD05)!}</td>
           	</tr>
            <tr>
            	<td class="datatd">${DataDicUtil.getDataDic("6032",ED04_1_51_61List.ED04BD02)!}</td>
            
	           	<td  class="table-data-td">${ED04_1_51_61List.ED04AQ01!}</td>
	           	<td  class="table-data-td">${ED04_1_51_61List.ED04BJ01!}</td>
	           	<td  class="table-data-td">${ED04_1_51_61List.ED04BJ02!}</td>
	           	<td  class="table-data-td">${ED04_1_51_61List.ED04AI03!}</td>
	           	<td  class="table-data-td">${ED04_1_51_61List.ED04BR01!}</td>
	        </tr>
	 		</#list>
 		</table>
 		<br>
 		
 		<table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED04_2_51_61List?size!}笔</td>
           	</tr>
 		</table> 
 		
 		
 		<table class="mainTable">
 			<tr>
 				<td  class="labeltd">授信机构:</td> 
            	<td  class="labeltd">业务种类:</td> 
                <td  class="labeltd">五级分类:</td>    
 			
 				<td class="labeltd">账户编号</td>
 				<td class="labeltd">开立日期</td>
 				<td class="labeltd">到期日</td>
 				<td class="labeltd">币种</td>
 				<td class="labeltd">金额</td>
 				<td class="labeltd">关闭日期</td>
 				<td class="labeltd">垫款标志</td>
 					
 			</tr>
 			
 			<#list map.ED04_2_51_61List! as ED04_2_51_61List>
 			<tr>
 				<td class="datatd">${ED04_2_51_61List.ED04AI02!}</td>    
            	<td class="datatd">${DataDicUtil.getDataDic("6095",ED04_2_51_61List.ED04AD03)!}</td>
            	<td class="datatd">${DataDicUtil.getDataDic("6032",ED04_2_51_61List.ED04BD02)!}</td>
 			
            	<td  class="table-data-td">${ED04_2_51_61List.ED04AI01!}</td>
            	<td  class="table-data-td">${ED04_2_51_61List.ED04AR01!}</td>
            	<td  class="table-data-td">${ED04_2_51_61List.ED04AR02!}</td>
            	<td  class="table-data-td">${ED04_2_51_61List.ED04AD04!}</td>
            	<td  class="table-data-td">${ED04_2_51_61List.ED04AJ01!}</td>
            	<td class="table-data-td">${ED04_2_51_61List.ED04BR02!}</td>
            	<td class="table-data-td">${DataDicUtil.getDataDic("6075",ED04_2_51_61List.ED04BD03)!}</td>
           	</tr>
	 		</#list>
 		</table>
 		<br>
 		
 	<h2>(九)银行保函及其他业务的信贷明细</h2>
 		<table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED04_1_51_61otherList?size!}笔</td>
           	</tr>
 		</table> 
 		
 		
 		<table class="mainTable">
 			<tr>
 				<td rowspan="2" class="labeltd">授信机构:</td> 
            	<td  class="labeltd">业务种类:</td>
 			
 				<td rowspan="2" class="labeltd">账户编号</td>
 				<td  class="labeltd">开立日期</td>
             	<td  class="labeltd">到期日</td>
             	<td  class="labeltd">币种</td>
             	<td  class="labeltd">金额</td>
             	<td  class="labeltd">反担保方式</td>
            </tr>
 			<tr>
 				<td  class="labeltd">五级分类:</td>
 			
             	<td  class="labeltd">保证金比例</td>
             	<td  class="labeltd">余额</td>
             	<td  class="labeltd">风险敞口</td>
             	<td colspan="2" class="labeltd">信息报告日期</td>
            </tr>
 			
 			<#list map.ED04_1_51_61otherList! as ED04_1_51_61otherList>
 			<tr>
 				<td rowspan="2" class="datatd">${ED04_1_51_61otherList.ED04AI02!}</td>    
            	<td class="datatd">${DataDicUtil.getDataDic("6095",ED04_1_51_61otherList.ED04AD03)!}</td>
 			
            	<td rowspan="2" class="table-data-td">${ED04_1_51_61otherList.ED04AI01!}</td>
            	<td  class="table-data-td">${ED04_1_51_61otherList.ED04AR01!}</td>
            	<td  class="table-data-td">${ED04_1_51_61otherList.ED04AR02!}</td>
            	<td  class="table-data-td">${ED04_1_51_61otherList.ED04AD04!}</td>
            	<td  class="table-data-td">${ED04_1_51_61otherList.ED04AJ01!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6096",ED04_1_51_61otherList.ED04AD05)!}</td>
           	</tr>
            <tr>
            	<td class="datatd">${DataDicUtil.getDataDic("6032",ED04_1_51_61otherList.ED04BD02)!}</td>
            
	           	<td  class="table-data-td">${ED04_1_51_61otherList.ED04AQ01!}</td>
	           	<td  class="table-data-td">${ED04_1_51_61otherList.ED04BJ01!}</td>
	           	<td  class="table-data-td">${ED04_1_51_61otherList.ED04BJ02!}</td>
	           	<td colspan="2" class="table-data-td">${ED04_1_51_61otherList.ED04BR01!}</td>
	        </tr>
	 		</#list>
 		</table>
 		<br>
 		
 		<table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED04_2_51_61otherList?size!}笔</td>
           	</tr>
 		</table> 
 		
 		<table class="mainTable">
 			<tr>
 				<td  class="labeltd">授信机构:</td> 
            	<td  class="labeltd">业务种类:</td> 
                <td  class="labeltd">五级分类:</td>   
 			
 				<td class="labeltd">账户编号</td>
 				<td class="labeltd">开立日期</td>
 				<td class="labeltd">到期日</td>
 				<td class="labeltd">币种</td>
 				<td class="labeltd">金额</td>
 				<td class="labeltd">关闭日期</td>
 				<td class="labeltd">垫款标志</td>
 			</tr>
 			<#list map.ED04_2_51_61otherList! as ED04_2_51_61otherList>
 			<tr>
 				<td class="datatd">${ED04_2_51_61otherList.ED04AI02!}</td>    
            	<td class="datatd">${DataDicUtil.getDataDic("6095",ED04_2_51_61otherList.ED04AD03)!}</td>
            	<td class="datatd">${DataDicUtil.getDataDic("6032",ED04_2_51_61otherList.ED04BD02)!}</td>
 			
            	<td  class="table-data-td">${ED04_2_51_61otherList.ED04AI01!}</td>
            	<td  class="table-data-td">${ED04_2_51_61otherList.ED04AR01!}</td>
            	<td  class="table-data-td">${ED04_2_51_61otherList.ED04AR02!}</td>
            	<td  class="table-data-td">${ED04_2_51_61otherList.ED04AD04!}</td>
            	<td  class="table-data-td">${ED04_2_51_61otherList.ED04AJ01!}</td>
            	<td class="table-data-td">${ED04_2_51_61otherList.ED04BR02!}</td>
            	<td class="table-data-td">${DataDicUtil.getDataDic("6075",ED04_2_51_61otherList.ED04BD03)!}</td>
           	</tr>
	 		</#list>
 		</table>
 		<br>
 		
 		
 	<h2>(十)非信贷记录</h2>
 		<table class="mainTable">
			<tr>
             	<td class="titletd" colspan="1">
                   	<li>*公用事业历史缴费记录明细</li>
                </td>
           	</tr>
           	<tr>
           		<td  class="labeltd">公用事业单位名称:</td> 
            	<td class="datatd"></td>    
            	<td  class="labeltd">业务类型：</td> 
            	<td class="datatd"></td>
           	</tr> 		
           	</table> 
 		
 		<table class="mainTable">
 			<tr>
 				<td class="labeltd">统计年月</td>
 				<td class="labeltd">缴费状态</td>
 				<td class="labeltd">本月应缴金额</td>
 				<td class="labeltd">本月实缴金额</td>
 				<td class="labeltd">累计欠费金额</td>
 					
 			</tr>
 			<tr>
            	<td class="table-data-td"></td>
            	<td class="table-data-td"></td>
            	<td class="table-data-td"></td>
            	<td class="table-data-td"></td>
            	<td class="table-data-td"></td>
           	</tr>
 		</table>
        
        
        
        
        
        
        
        
        
        
        
        
       
          
 
  
    <fieldset>
        <legend align="center">财务信息单元</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>企业资产负债表（2002版）信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG01AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG01AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG01AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG01AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG01AD03)!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>企业资产负债表（2002 版）单元</li>
                </td>
            <tr>
                <td class="labeltd">货币资金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ01??>
                      ${map.EGA.EG01BJ01!}
                  <#else >
                  </#if>
                </td>
				<td class="labeltd">短期借款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ45??>
                       ${map.EGA.EG01BJ45!}
                   <#else >
                   </#if>
                </td>     
            </tr>
			<tr>
			 <td class="labeltd">短期投资</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ02??>
                       ${map.EGA.EG01BJ02!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">应付票据</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ46??>
                       ${map.EGA.EG01BJ46!}
                   <#else >
                   </#if>
                </td>
			 </tr>	
            <tr>
                <td class="labeltd">应收票据</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ03??>
                       ${map.EGA.EG01BJ03!}
                   <#else >
                   </#if>
                </td>
				 <td class="labeltd">应付账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ47??>
                       ${map.EGA.EG01BJ47!}
                   <#else >
                   </#if>
                </td>    
            </tr>
            <tr>
			 <td class="labeltd">应收股利</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ04??>
                       ${map.EGA.EG01BJ04!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">预收账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ48??>
                       ${map.EGA.EG01BJ48!}
                   <#else >
                   </#if>
                </td>
			</tr>	
			<tr>
                <td class="labeltd">应收利息</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ05??>
                       ${map.EGA.EG01BJ05!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">应付工资</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ49??>
                       ${map.EGA.EG01BJ49!}
                   <#else >
                   </#if>
                </td>
			</tr>
			<tr>
                <td class="labeltd">应收账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ06??>
                       ${map.EGA.EG01BJ06!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">应付福利费</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ50??>
                       ${map.EGA.EG01BJ50!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他应收款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ07??>
                       ${map.EGA.EG01BJ07!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">应付利润</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ51??>
                      ${map.EGA.EG01BJ51!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">预付账款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ08??>
                      ${map.EGA.EG01BJ08!}
                  <#else >
                  </#if>
                </td>
				<td class="labeltd">应交税金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ52??>
                      ${map.EGA.EG01BJ52!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">期货保证金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ09??>
                       ${map.EGA.EG01BJ09!}
                   <#else >
                   </#if>
                </td>
				 <td class="labeltd">其他应交款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ53??>
                       ${map.EGA.EG01BJ53!}
                   <#else >
                   </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">应收补贴款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ10??>
                       ${map.EGA.EG01BJ10!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">其他应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ54??>
                      ${map.EGA.EG01BJ54!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收出口退税</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ11??>
                       ${map.EGA.EG01BJ11!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">预提费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ55??>
                       ${map.EGA.EG01BJ55!}
                   <#else >
                   </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">存货</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ12??>
                       ${map.EGA.EG01BJ12!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">预计负债</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ56??>
                       ${map.EGA.EG01BJ56!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">存货原材料</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ13??>
                       ${map.EGA.EG01BJ13!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">一年内到期的长期负债</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ57??>
                       ${map.EGA.EG01BJ57!}
                   <#else >
                   </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">存货产成品</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ14??>
                       ${map.EGA.EG01BJ14!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">其他流动负债</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ58??>
                      ${map.EGA.EG01BJ58!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待摊费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ15??>
                       ${map.EGA.EG01BJ15!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">流动负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ59??>
                      ${map.EGA.EG01BJ59!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">待处理流动资产净损失</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ16??>
                       ${map.EGA.EG01BJ16!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">长期借款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ60??>
                      ${map.EGA.EG01BJ60!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">一年内到期的长期债权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ17??>
                        ${map.EGA.EG01BJ17!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">应付债券</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ61??>
                      ${map.EGA.EG01BJ61!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">其他流动资产</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ18??>
                        ${map.EGA.EG01BJ18!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">长期应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ62??>
                      ${map.EGA.EG01BJ62!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">流动资产合计</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ19??>
                        ${map.EGA.EG01BJ19!}
                    <#else >
                    </#if>
                </td>
				 <td class="labeltd">专项应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ63??>
                      ${map.EGA.EG01BJ63!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">长期投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ20??>
                        ${map.EGA.EG01BJ20!}
                    <#else >
                    </#if>
                </td>
				 <td class="labeltd">其他长期负债</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ64??>
                      ${map.EGA.EG01BJ64!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期股权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ21??>
                        ${map.EGA.EG01BJ21!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">（其他长期负债科目下）特准储备基金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ65??>
                      ${map.EGA.EG01BJ65!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">长期债权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ22??>
                        ${map.EGA.EG01BJ22!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">长期负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ66??>
                      ${map.EGA.EG01BJ66!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">合并价差</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ23??>
                        ${map.EGA.EG01BJ23!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">递延税款贷项</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ67??>
                      ${map.EGA.EG01BJ67!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">长期投资合计</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ24??>
                        ${map.EGA.EG01BJ24!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ68??>
                      ${map.EGA.EG01BJ68!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产原价</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ25??>
                        ${map.EGA.EG01BJ25!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">少数股东权益</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ69??>
                      ${map.EGA.EG01BJ69!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">累计折旧</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ26??>
                        ${map.EGA.EG01BJ26!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">实收资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ70??>
                      ${map.EGA.EG01BJ70!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产净值</td>
                <td class="datatd-number">
                     <#if map.EGA.EG01BJ27??>
                         ${map.EGA.EG01BJ27!}
                     <#else >
                     </#if>
                </td>
				<td class="labeltd">国家资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ71??>
                      ${map.EGA.EG01BJ71!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">固定资产值减值准备</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ28??>
                        ${map.EGA.EG01BJ28!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">集体资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ72??>
                      ${map.EGA.EG01BJ72!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产净额</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ29??>
                        ${map.EGA.EG01BJ29!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ73??>
                      ${map.EGA.EG01BJ73!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">固定资产清理</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ30??>
                        ${map.EGA.EG01BJ30!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">（法人资本科目下）国有法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ74??>
                      ${map.EGA.EG01BJ74!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">工程物资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ31??>
                        ${map.EGA.EG01BJ31!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">（法人资本科目下）集体法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ75??>
                      ${map.EGA.EG01BJ75!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">在建工程</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ32??>
                        ${map.EGA.EG01BJ32!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">个人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ76??>
                      ${map.EGA.EG01BJ76!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待处理固定资产净损失</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ33??>
                       ${map.EGA.EG01BJ33!}
                   <#else >
                   </#if>
                </td>
				 <td class="labeltd">外商资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ77??>
                      ${map.EGA.EG01BJ77!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">固定资产合计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ34??>
                       ${map.EGA.EG01BJ34!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">资本公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ78??>
                      ${map.EGA.EG01BJ78!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">无形资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ35??>
                       ${map.EGA.EG01BJ35!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">盈余公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ79??>
                      ${map.EGA.EG01BJ79!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">（无形资产科目下）土地使用权</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ36??>
                       ${map.EGA.EG01BJ36!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">（盈余公积科目下）法定盈余公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ80??>
                      ${map.EGA.EG01BJ80!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ37??>
                       ${map.EGA.EG01BJ37!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">（盈余公积科目下）公益金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ81??>
                      ${map.EGA.EG01BJ81!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">（递延资产科目下）固定资产修理</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ38??>
                       ${map.EGA.EG01BJ38!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">（盈余公积科目下）补充流动资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ82??>
                      ${map.EGA.EG01BJ82!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（递延资产科目下）固定资产改良支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ39??>
                       ${map.EGA.EG01BJ39!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">未确认的投资损失</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ83??>
                      ${map.EGA.EG01BJ83!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">其他长期资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ40??>
                       ${map.EGA.EG01BJ40!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">未分配利润</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ84??>
                      ${map.EGA.EG01BJ84!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（其他长期资产科目下）特准储备物资</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ41??>
                     ${map.EGA.EG01BJ41!}
                 <#else >
                 </#if>
                </td>
				<td class="labeltd">外币报表折算差额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ85??>
                      ${map.EGA.EG01BJ85!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">无形及其他资产合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ42??>
                     ${map.EGA.EG01BJ42!}
                 <#else >
                 </#if>
                </td>
				<td class="labeltd">所有者权益合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ86??>
                      ${map.EGA.EG01BJ86!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延税款借项</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ43??>
                     ${map.EGA.EG01BJ43!}
                 <#else >
                 </#if>
                </td>
				<td class="labeltd">负债和所有者权益总计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ87??>
                      ${map.EGA.EG01BJ87!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">资产总计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ44??>
                       ${map.EGA.EG01BJ44!}
                   <#else >
                   </#if>
                </td>
            </tr>
 
            <tr>
                <td class="titletd" colspan="4">
                    <li>企业资产负债表（2007版)基本单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG02AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG02AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG02AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG02AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG02AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG02AD03)!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>企业资产负债表（2007版）单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">货币资金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ01??>
                     ${map.EGA.EG02BJ01!}
                 <#else >
                 </#if>
                </td>
				 <td class="labeltd">短期借款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ32??>
                    ${map.EGA.EG02BJ32!}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>  
                <td class="labeltd">交易性金融资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ02??>
                    ${map.EGA.EG02BJ02!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">交易性金融负债</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ33??>
                    ${map.EGA.EG02BJ33!}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收票据</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ03??>
                     ${map.EGA.EG02BJ03!}
                 <#else >
                 </#if>
                </td>
				 <td class="labeltd">应付票据</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ34??>
                    ${map.EGA.EG02BJ34!}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>   
                <td class="labeltd">应收账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ04??>
                    ${map.EGA.EG02BJ04!}
                <#else >
                </#if>
                </td>
			 <td class="labeltd">应付账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ35??>
                    ${map.EGA.EG02BJ35!}
                <#else >
                </#if>
                </td>
            </tr>   
            <tr>
                <td class="labeltd">预付账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ05??>
                    ${map.EGA.EG02BJ05!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">预收账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ36??>
                     ${map.EGA.EG02BJ36!}
                 <#else >
                 </#if>
            </tr>   
            <tr>   
                </td>
                <td class="labeltd">应收利息</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ06??>
                    ${map.EGA.EG02BJ06!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应付利息</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ37??>
                     ${map.EGA.EG02BJ37!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收股利</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ07??>
                    ${map.EGA.EG02BJ07!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应付职工薪酬</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ38??>
                     ${map.EGA.EG02BJ38!}
                 <#else >
                 </#if>
                </td>
			 </tr>   
            <tr>	
                <td class="labeltd">其他应收款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ08??>
                    ${map.EGA.EG02BJ08!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应交税费</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ39??>
                     ${map.EGA.EG02BJ39!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">存货</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ09??>
                    ${map.EGA.EG02BJ09!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应付股利</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ40??>
                     ${map.EGA.EG02BJ40!}
                 <#else >
                 </#if>
                </td>
            </tr>   
            <tr>  
                <td class="labeltd">一年内到期的非流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ10??>
                    ${map.EGA.EG02BJ10!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">其他应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ41??>
                     ${map.EGA.EG02BJ41!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ11??>
                    ${map.EGA.EG02BJ11!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">一年内到期的非流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ42??>
                     ${map.EGA.EG02BJ42!}
                 <#else >
                 </#if>
                </td>
             </tr>   
            <tr>   
                <td class="labeltd">流动资产合计</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ12??>
                    ${map.EGA.EG02BJ12!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">其他流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ43??>
                     ${map.EGA.EG02BJ43!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">可供出售的金融资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ13??>
                    ${map.EGA.EG02BJ13!}
                <#else >
                </#if>
                </td>
				 <td class="labeltd">流动负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ44??>
                     ${map.EGA.EG02BJ44!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>  
                <td class="labeltd">持有至到期投资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ14??>
                    ${map.EGA.EG02BJ14!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">长期借款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ45??>
                     ${map.EGA.EG02BJ45!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期股权投资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ15??>
                    ${map.EGA.EG02BJ15!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应付债券</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ46??>
                     ${map.EGA.EG02BJ46!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd">长期应收款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ16??>
                    ${map.EGA.EG02BJ16!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">长期应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ47??>
                     ${map.EGA.EG02BJ47!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资性房地产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ17??>
                    ${map.EGA.EG02BJ17!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">专项应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ48??>
                     ${map.EGA.EG02BJ48!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd">固定资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ18??>
                    ${map.EGA.EG02BJ18!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">预计负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ49??>
                     ${map.EGA.EG02BJ49!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">在建工程</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ19??>
                    ${map.EGA.EG02BJ19!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">递延所得税负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ50??>
                     ${map.EGA.EG02BJ50!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd">工程物资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ20??>
                    ${map.EGA.EG02BJ20!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">其他非流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ51??>
                     ${map.EGA.EG02BJ51!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产清理</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ21??>
                    ${map.EGA.EG02BJ21!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">非流动负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ52??>
                     ${map.EGA.EG02BJ52!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd">生产性生物资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ22??>
                    ${map.EGA.EG02BJ22!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ53??>
                     ${map.EGA.EG02BJ53!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">油气资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ23??>
                    ${map.EGA.EG02BJ23!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">实收资本（或股本）</td>
                <td class="datatd-number">
                  <#if map.EGA.EG02BJ54??>
                      ${map.EGA.EG02BJ54!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd">无形资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ24??>
                    ${map.EGA.EG02BJ24!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">资本公积</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ55??>
                     ${map.EGA.EG02BJ55!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">开发支出</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ25??>
                    ${map.EGA.EG02BJ25!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">减：库存股</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ56??>
                     ${map.EGA.EG02BJ56!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd">商誉</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ26??>
                    ${map.EGA.EG02BJ26!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">盈余公积</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ57??>
                     ${map.EGA.EG02BJ57!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期待摊费用</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ27??>
                    ${map.EGA.EG02BJ27!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">未分配利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ58??>
                     ${map.EGA.EG02BJ58!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>  
                <td class="labeltd">递延所得税资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ28??>
                    ${map.EGA.EG02BJ28!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">所有者权益合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ59??>
                     ${map.EGA.EG02BJ59!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他非流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ29??>
                    ${map.EGA.EG02BJ29!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">负债和所有者权益合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ60??>
                     ${map.EGA.EG02BJ60!}
                 <#else >
                 </#if>
             </tr>
            <tr>    
                </td>
            </tr>
 			
 			<tr>
                <td class="titletd" colspan="4">
                    <li>企业利润表及利润分配表（2002版）信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG03AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG03AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG03AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG03AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG03AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG03AD03)!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>企业利润表及利润分配表（2002版）单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">主营业务收入</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ01??>
                      ${map.EGA.EG03BJ01!}
                  <#else >
                  </#if>
                </td>
                </tr>
            <tr>
                <td class="labeltd" colspan="2">（主营业务收入科目下）出口产品销售收入</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ02??>
                      ${map.EGA.EG03BJ02!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（主营业务收入科目下）进口产品销售收入</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ03??>
                      ${map.EGA.EG03BJ03!}
                  <#else >
                  </#if>
                </td>
                </tr>
            <tr>
                <td class="labeltd" colspan="2">销售折扣与折让</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ04??>
                      ${map.EGA.EG03BJ04!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">主营业务收入净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ05??>
                      ${map.EGA.EG03BJ05!}
                  <#else >
                  </#if>
                </td>
                </tr>
            <tr>
                <td class="labeltd" colspan="2">主营业务成本</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ06??>
                     ${map.EGA.EG03BJ06!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">主营业务成本科目下）出口产品销售成本</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ07??>
                      ${map.EGA.EG03BJ07!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">主营业务税金及附加</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ08??>
                      ${map.EGA.EG03BJ08!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营费用</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ09??>
                      ${map.EGA.EG03BJ09!}
                  <#else >
                  </#if>
                </td>
                </tr>
            <tr>
                <td class="labeltd" colspan="2">其他（业务成本）</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ10??>
                      ${map.EGA.EG03BJ10!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">递延收益</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ11??>
                      ${map.EGA.EG03BJ11!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">代购代销收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ12??>
                     ${map.EGA.EG03BJ12!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他（收入）</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ13??>
                     ${map.EGA.EG03BJ13!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">主营业务利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ14??>
                     ${map.EGA.EG03BJ14!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他业务利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ15??>
                     ${map.EGA.EG03BJ15!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">营业费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ16??>
                     ${map.EGA.EG03BJ16!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">管理费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ17??>
                     ${map.EGA.EG03BJ17!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">财务费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ18??>
                     ${map.EGA.EG03BJ18!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他（费用）</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ19??>
                     ${map.EGA.EG03BJ19!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">营业利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ20??>
                     ${map.EGA.EG03BJ20!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ21??>
                     ${map.EGA.EG03BJ21!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">期货收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ22??>
                     ${map.EGA.EG03BJ22!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">补贴收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ23??>
                     ${map.EGA.EG03BJ23!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">（补贴收入科目下）补贴前亏损的企业补贴收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ24??>
                     ${map.EGA.EG03BJ24!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业外收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ25??>
                     ${map.EGA.EG03BJ25!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">（营业外收入科目下）处置固定资产净收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ26??>
                     ${map.EGA.EG03BJ26!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（营业外收入科目下）非货币性交易收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ27??>
                     ${map.EGA.EG03BJ27!}
                 <#else>
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">（营业外收入科目下）出售无形资产收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ28??>
                     ${map.EGA.EG03BJ28!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（营业外收入科目下）罚款净收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ29??>
                     ${map.EGA.EG03BJ29!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">其他（利润）</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ30??>
                     ${map.EGA.EG03BJ30!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（其他科目下）用以前年度含量工资节余弥补利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ31??>
                     ${map.EGA.EG03BJ31!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">营业外支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ32??>
                     ${map.EGA.EG03BJ32!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（营业外支出科目下）处置固定资产净损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ33??>
                     ${map.EGA.EG03BJ33!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">（营业外支出科目下）债务重组损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ34??>
                     ${map.EGA.EG03BJ34!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（营业外支出科目下）罚款支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ35??>
                     ${map.EGA.EG03BJ35!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">（营业外支出科目下）捐赠支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ36??>
                     ${map.EGA.EG03BJ36!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ37??>
                     ${map.EGA.EG03BJ37!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">（其他支出）结转的含量工资包干节余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ38??>
                     ${map.EGA.EG03BJ38!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">利润总额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ39??>
                     ${map.EGA.EG03BJ39!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">所得税</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ40??>
                     ${map.EGA.EG03BJ40!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">少数股东损益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ41??>
                     ${map.EGA.EG03BJ41!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">未确认的投资损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ42??>
                     ${map.EGA.EG03BJ42!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">净利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ43??>
                     ${map.EGA.EG03BJ43!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">年初未分配利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ44??>
                     ${map.EGA.EG03BJ44!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">盈余公积补亏</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ45??>
                     ${map.EGA.EG03BJ45!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">其他调整因素</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ46??>
                     ${map.EGA.EG03BJ46!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">可供分配的利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ47??>
                     ${map.EGA.EG03BJ47!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">单项留用的利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ48??>
                     ${map.EGA.EG03BJ48!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">补充流动资本</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ49??>
                     ${map.EGA.EG03BJ49!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">提取法定盈余公积</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ50??>
                     ${map.EGA.EG03BJ50!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">提取法定公益金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ51??>
                     ${map.EGA.EG03BJ51!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">提取职工奖励及福利基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ52??>
                     ${map.EGA.EG03BJ52!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">提取储备基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ53??>
                     ${map.EGA.EG03BJ53!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">提取企业发展基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ54??>
                     ${map.EGA.EG03BJ54!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">利润归还投资</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ55??>
                     ${map.EGA.EG03BJ55!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">（可供分配的利润科目下）其他</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ56??>
                     ${map.EGA.EG03BJ56!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">可供投资者分配的利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ57??>
                     ${map.EGA.EG03BJ57!}
                 <#else >
                 </#if>
                </td>
           </tr>
            <tr>     
                <td class="labeltd" colspan="2">应付优先股股利</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ58??>
                     ${map.EGA.EG03BJ58!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">提取任意盈余公积</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ59??>
                     ${map.EGA.EG03BJ59!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">应付普通股股利</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ60??>
                     ${map.EGA.EG03BJ60!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">转作资本的普通股股利</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ61??>
                     ${map.EGA.EG03BJ61!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">（可供投资者分配的利润科目下）其他</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ62??>
                     ${map.EGA.EG03BJ62!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">未分配利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ63??>
                     ${map.EGA.EG03BJ63!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">（未分配利润科目下）应由以后年度税前利润弥补的亏损</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ64??>
                     ${map.EGA.EG03BJ64!}
                 <#else >
                 </#if>
                </td>
            </tr>
			
			<tr>
                <td class="titletd" colspan="4">
                    <li>企业利润表及利润分配表（2007版）单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG04AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG04AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG04AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG04AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG04AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG04AD03)!}</td>
            </tr>
			
              <tr>
                <td class="titletd" colspan="4">
                    <li>企业利润表及利润分配表（2007版）单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业收入</td>
                <td class="datatd-number" colspan="2">
                    <#if map.EGA.EG04BJ01??>
                        ${map.EGA.EG04BJ01!}
                    <#else >
                    </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">营业成本</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ02??>
                       ${map.EGA.EG04BJ02!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业税金及附加</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ03??>
                       ${map.EGA.EG04BJ03!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">销售费用</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ04??>
                       ${map.EGA.EG04BJ04!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">管理费用</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ05??>
                       ${map.EGA.EG04BJ05!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">财务费用</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ06??>
                       ${map.EGA.EG04BJ06!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">资产减值损失</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ07??>
                       ${map.EGA.EG04BJ07!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">公允价值变动净收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ08??>
                       ${map.EGA.EG04BJ08!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资净收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ09??>
                       ${map.EGA.EG04BJ09!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">对联营企业和合营企业的投资收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ10??>
                       ${map.EGA.EG04BJ10!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业利润</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ11??>
                       ${map.EGA.EG04BJ11!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">营业外收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ12??>
                       ${map.EGA.EG04BJ12!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业外支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ13??>
                       ${map.EGA.EG04BJ13!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">非流动资产损失（其中：非流动资产处置损失）</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ14??>
                       ${map.EGA.EG04BJ14!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">利润总额</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ15??>
                       ${map.EGA.EG04BJ15!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">所得税费用</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ16??>
                       ${map.EGA.EG04BJ16!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">净利润</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ17??>
                       ${map.EGA.EG04BJ17!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">基本每股收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ18??>
                       ${map.EGA.EG04BJ18!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">稀释每股收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ19??>
                       ${map.EGA.EG04BJ19!}
                   <#else >
                   </#if>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>企业现金流量表（2002版）信息单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG05AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG05AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG05AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG05AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG05AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG05AD03)!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>企业现金流量表（2002版）单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">销售商品和提供劳务收到的现金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG05BJ01??>
                       ${map.EGA.EG05BJ01!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">收到的税费返还</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ02??>
                      ${map.EGA.EG05BJ02!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收到的其他与经营活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ03??>
                      ${map.EGA.EG05BJ03!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ04??>
                      ${map.EGA.EG05BJ04!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">购买商品、接受劳务支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ05??>
                      ${map.EGA.EG05BJ05!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支付给职工以及为职工支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ06??>
                      ${map.EGA.EG05BJ06!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">支付的各项税费</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ07??>
                      ${map.EGA.EG05BJ07!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支付的其他与经营活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ08??>
                      ${map.EGA.EG05BJ08!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ09??>
                      ${map.EGA.EG05BJ09!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ10??>
                      ${map.EGA.EG05BJ10!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收回投资所收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ11??>
                      ${map.EGA.EG05BJ11!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">取得投资收益所收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ12??>
                      ${map.EGA.EG05BJ12!}
                  <#else>
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">处置固定资产无形资产和其他长期资产所收回的现金净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ13??>
                      ${map.EGA.EG05BJ13!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">收到的其他与投资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ14??>
                      ${map.EGA.EG05BJ14!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ15??>
                      ${map.EGA.EG05BJ15!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">购建固定资产无形资产和其他长期资产所支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ16??>
                      ${map.EGA.EG05BJ16!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资所支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ17??>
                      ${map.EGA.EG05BJ17!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">支付的其他与投资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ18??>
                      ${map.EGA.EG05BJ18!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG04BJ19??>
                      ${map.EGA.EG04BJ19!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">投资活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ20??>
                      ${map.EGA.EG05BJ20!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">吸收投资所收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ21??>
                      ${map.EGA.EG05BJ21!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">借款所收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ22??>
                      ${map.EGA.EG05BJ22!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收到的其他与筹资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ23??>
                      ${map.EGA.EG05BJ23!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">筹资活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ24??>
                      ${map.EGA.EG05BJ24!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">偿还债务所支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ25??>
                      ${map.EGA.EG05BJ25!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">分配股利、利润或偿付利息所支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ26??>
                      ${map.EGA.EG05BJ26!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">支付的其他与筹资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ27??>
                      ${map.EGA.EG05BJ27!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">筹资活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ28??>
                      ${map.EGA.EG05BJ28!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">筹集活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ29??>
                      ${map.EGA.EG05BJ29!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">汇率变动对现金的影响</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ30??>
                      ${map.EGA.EG05BJ30!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金及现金等价物净增加额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ31??>
                      ${map.EGA.EG05BJ31!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">净利润</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ32??>
                      ${map.EGA.EG05BJ32!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">计提的资产减值准备</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ33??>
                      ${map.EGA.EG05BJ33!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">固定资产拆旧</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ34??>
                      ${map.EGA.EG05BJ34!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产摊销</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ35??>
                      ${map.EGA.EG05BJ35!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">长期待摊费用摊销</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ36??>
                      ${map.EGA.EG05BJ36!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">待摊费用减少</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ37??>
                      ${map.EGA.EG05BJ37!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">预提费用增加</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ38??>
                      ${map.EGA.EG05BJ38!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">处置固定资产无形资产和其他长期资产的损失</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ39??>
                      ${map.EGA.EG05BJ39!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">固定资产报废损失</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ40??>
                      ${map.EGA.EG05BJ40!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">财务费用</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ41??>
                      ${map.EGA.EG05BJ41!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">投资损失</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ42??>
                      ${map.EGA.EG05BJ42!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">递延税款贷项</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ43??>
                      ${map.EGA.EG05BJ43!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">存货的减少</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ44??>
                      ${map.EGA.EG05BJ44!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营性应收项目的减少</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ45??>
                      ${map.EGA.EG05BJ45!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营性应付项目的增加</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ46??>
                      ${map.EGA.EG05BJ46!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（净利润调节为经营活动现金流量科目下）其他</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ47??>
                      ${map.EGA.EG05BJ47!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ48??>
                      ${map.EGA.EG05BJ48!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">债务转为资本</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ49??>
                      ${map.EGA.EG05BJ49!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">一年内到期的可转换公司债券</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ50??>
                      ${map.EGA.EG05BJ50!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">融资租入固定资产</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ51??>
                      ${map.EGA.EG05BJ51!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">（不涉及现金收支的投资和筹资活动科目下）其他</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ52??>
                      ${map.EGA.EG05BJ52!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金的期末余额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ53??>
                      ${map.EGA.EG05BJ53!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">现金的期初余额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ54??>
                      ${map.EGA.EG05BJ54!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金等价物的期末余额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ55??>
                      ${map.EGA.EG05BJ55!}
                  <#else >
                  </#if>
                </td>
           </tr>
            <tr>     
                <td class="labeltd" colspan="2">现金等价物的期初余额</td>
                <td class="datatd-number" colspan="2">${map.EGA.EG05BJ56!}
                  <#if map.EGA.EG05BJ56??>
                      ${map.EGA.EG05BJ56!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金及现金等价物净增加额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ57??>
                      ${map.EGA.EG05BJ57!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>企业现金流量表（2007版）信息单元
                    </li>
                </td>
            </tr>

            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG06AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG06AD01)!}</td>
            </tr>

            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG06AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG06AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG06AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG06AD03)!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>企业现金流量表（2007版）单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">销售商品和提供劳务收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG06BJ01??>
                      ${map.EGA.EG06BJ01!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">收到的税费返还</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG06BJ02??>
                      ${map.EGA.EG06BJ02!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">收到其他与经营活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG06BJ03??>
                      ${map.EGA.EG06BJ03!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">经营活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ04??>
                     ${map.EGA.EG06BJ04!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">购买商品、接受劳务支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ05??>
                     ${map.EGA.EG06BJ05!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支付给职工以及为职工支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ06??>
                     ${map.EGA.EG06BJ06!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">支付的各项税费</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ07??>
                     ${map.EGA.EG06BJ07!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">支付其他与经营活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ08??>
                     ${map.EGA.EG06BJ08!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ09??>
                     ${map.EGA.EG06BJ09!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">经营活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ10??>
                     ${map.EGA.EG06BJ10!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">收回投资所收到的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ11??>
                     ${map.EGA.EG06BJ11!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">取得投资收益所收到的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ12??>
                     ${map.EGA.EG06BJ12!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">处置固定资产无形资产和其他长期资产所收回的现金净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ13??>
                     ${map.EGA.EG06BJ13!}
                 <#else>
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">处置子公司及其他营业单位收到的现金净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ14??>
                     ${map.EGA.EG06BJ14!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收到其他与投资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ15??>
                     ${map.EGA.EG06BJ15!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">投资活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ16??>
                     ${map.EGA.EG06BJ16!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">购建固定资产无形资产和其他长期资产所支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ17??>
                     ${map.EGA.EG06BJ17!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">投资所支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ18??>
                     ${map.EGA.EG06BJ18!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">取得子公司及其他营业单位支付的现金净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ19??>
                     ${map.EGA.EG06BJ19!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支付其他与投资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ20??>
                     ${map.EGA.EG06BJ20!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ21??>
                     ${map.EGA.EG06BJ21!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">投资活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ22??>
                     ${map.EGA.EG06BJ22!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">吸收投资收到的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ23??>
                     ${map.EGA.EG06BJ23!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">取得借款收到的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ24??>
                     ${map.EGA.EG06BJ24!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收到其他与筹资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ25??>
                     ${map.EGA.EG06BJ25!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">筹资活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ26??>
                     ${map.EGA.EG06BJ26!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">偿还债务所支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ27??>
                     ${map.EGA.EG06BJ27!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">分配股利、利润或偿付利息所支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ28??>
                     ${map.EGA.EG06BJ28!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">支付其他与筹资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ29??>
                     ${map.EGA.EG06BJ29!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">筹资活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ30??>
                     ${map.EGA.EG06BJ30!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">筹集活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ31??>
                     ${map.EGA.EG06BJ31!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">汇率变动对现金及现金等价物的影响</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ32??>
                     ${map.EGA.EG06BJ32!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金及现金等价物净增加额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ33??>
                     ${map.EGA.EG06BJ33!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">期初现金及现金等价物余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ34??>
                     ${map.EGA.EG06BJ34!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">期末现金及现金等价物余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ35??>
                     ${map.EGA.EG06BJ35!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">净利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ36??>
                     ${map.EGA.EG06BJ36!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">资产减值准备</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ37??>
                     ${map.EGA.EG06BJ37!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产折旧、油气资产折耗、生产性生物资产折旧</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ38??>
                     ${map.EGA.EG06BJ38!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产摊销</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ39??>
                     ${map.EGA.EG06BJ39!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">长期待摊费用摊销</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ40??>
                     ${map.EGA.EG06BJ40!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">待摊费用减少</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ41??>
                     ${map.EGA.EG06BJ41!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">预提费用增加</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ42??>
                     ${map.EGA.EG06BJ42!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">处置固定资产无形资产和其他长期资产的损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ43??>
                     ${map.EGA.EG06BJ43!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产报废损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ44??>
                     ${map.EGA.EG06BJ44!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">公允价值变动损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ45??>
                     ${map.EGA.EG06BJ45!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">财务费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ46??>
                     ${map.EGA.EG06BJ46!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ47??>
                     ${map.EGA.EG06BJ47!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr> 
                <td class="labeltd" colspan="2">递延所得税资产减少</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ48??>
                     ${map.EGA.EG06BJ48!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">递延所得税负债增加</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ49??>
                     ${map.EGA.EG06BJ49!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">存货的减少</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ50??>
                     ${map.EGA.EG06BJ50!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营性应收项目的减少</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ51??>
                     ${map.EGA.EG06BJ51!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr> 
                <td class="labeltd" colspan="2">经营性应付项目的增加</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ52??>
                     ${map.EGA.EG06BJ52!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（净利润调节为经营活动现金流量科目下）其他</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ53??>
                     ${map.EGA.EG06BJ53!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">经营活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ54??>
                     ${map.EGA.EG06BJ54!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">债务转为资本</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ55??>
                     ${map.EGA.EG06BJ55!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr> 
                <td class="labeltd" colspan="2">一年内到期的可转换公司债券</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ56??>
                     ${map.EGA.EG06BJ56!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">融资租入固定资产</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ57??>
                     ${map.EGA.EG06BJ57!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金的期末余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ58??>
                     ${map.EGA.EG06BJ58!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金的期初余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ59??>
                     ${map.EGA.EG06BJ59!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">现金等价物的期末余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ60??>
                     ${map.EGA.EG06BJ60!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金等价物的期初余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ61??>
                     ${map.EGA.EG06BJ61!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">现金及现金等价物净增加额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ62??>
                     ${map.EGA.EG06BJ62!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（不涉及现金收支的投资和筹资活动科目下）其他</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ63??>
                     ${map.EGA.EG06BJ63!}
                 <#else >
                 </#if>
                </td>
            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位资产负债表（1997版）信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG07AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG07AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG07AI02!}</td>
                <td class="labeltd" >报表年份</td>
                <td class="datatd">${map.EGA.EG07AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG07AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG07AD03)!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位资产负债表（1997版）单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG07BJ01??>
                       ${map.EGA.EG07BJ01!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">银行存款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ02??>
                     ${map.EGA.EG07BJ02!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应收票据</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG07BJ03??>
                      ${map.EGA.EG07BJ03!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应收账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ04??>
                     ${map.EGA.EG07BJ04!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">预付账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ05??>
                     ${map.EGA.EG07BJ05!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">其他应收款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ06??>
                     ${map.EGA.EG07BJ06!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">材料</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ07??>
                     ${map.EGA.EG07BJ07!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">产成品</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ08??>
                     ${map.EGA.EG07BJ08!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">对外投资</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ09??>
                     ${map.EGA.EG07BJ09!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ10??>
                     ${map.EGA.EG07BJ10!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ11??>
                     ${map.EGA.EG07BJ11!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">资产合计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG07BJ12??>
                      ${map.EGA.EG07BJ12!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">拨出经费</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ13??>
                     ${map.EGA.EG07BJ13!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">拨出专款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ14??>
                     ${map.EGA.EG07BJ14!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">专款支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ15??>
                     ${map.EGA.EG07BJ15!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">事业支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ16??>
                     ${map.EGA.EG07BJ16!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ17??>
                     ${map.EGA.EG07BJ17!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">成本费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ18??>
                     ${map.EGA.EG07BJ18!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">销售税金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ19??>
                     ${map.EGA.EG07BJ19!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">上缴上级支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ20??>
                     ${map.EGA.EG07BJ20!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">对附属单位补助</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ21??>
                     ${map.EGA.EG07BJ21!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">结转自筹基建</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ22??>
                     ${map.EGA.EG07BJ22!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">支出合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ23??>
                     ${map.EGA.EG07BJ23!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">资产部类总计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ24??>
                     ${map.EGA.EG07BJ24!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">借记款项</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ25??>
                     ${map.EGA.EG07BJ25!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应付票据</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ26??>
                     ${map.EGA.EG07BJ26!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应付账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ27??>
                     ${map.EGA.EG07BJ27!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr> 
                <td class="labeltd" colspan="2">预收账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ28??>
                     ${map.EGA.EG07BJ28!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他应付款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ29??>
                     ${map.EGA.EG07BJ29!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴预算款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ30??>
                     ${map.EGA.EG07BJ30!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴财政专户款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ31??>
                     ${map.EGA.EG07BJ31!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应交税金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ32??>
                     ${map.EGA.EG07BJ32!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">负债合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ33??>
                     ${map.EGA.EG07BJ33!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>  
                <td class="labeltd" colspan="2">事业基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ34??>
                     ${map.EGA.EG07BJ34!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">一般基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ35??>
                     ${map.EGA.EG07BJ35!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">投资基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ36??>
                     ${map.EGA.EG07BJ36!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">固定基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ37??>
                     ${map.EGA.EG07BJ37!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">专用基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ38??>
                     ${map.EGA.EG07BJ38!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">事业结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ39??>
                     ${map.EGA.EG07BJ39!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">经营结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ40??>
                     ${map.EGA.EG07BJ40!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">净资产合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ41??>
                     ${map.EGA.EG07BJ41!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">财政补助收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ42??>
                     ${map.EGA.EG07BJ42!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">上级补助收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ43??>
                     ${map.EGA.EG07BJ43!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">拨入专款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ44??>
                     ${map.EGA.EG07BJ44!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ45??>
                     ${map.EGA.EG07BJ45!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">经营收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ46??>
                     ${map.EGA.EG07BJ46!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">附属单位缴款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ47??>
                     ${map.EGA.EG07BJ47!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">其他收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ48??>
                     ${map.EGA.EG07BJ48!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收入合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ49??>
                     ${map.EGA.EG07BJ49!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">负债部类总计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ50??>
                     ${map.EGA.EG07BJ50!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位资产负债表（2013版）信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG08AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG08AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG08AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG08AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG08AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG08AD03)!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位资产负债表（2013版）单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">货币资金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ01??>
                      ${map.EGA.EG08BJ01!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">短期投资</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ02??>
                      ${map.EGA.EG08BJ02!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">财政应返还额度</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ03??>
                      ${map.EGA.EG08BJ03!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应收票据</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ04??>
                      ${map.EGA.EG08BJ04!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应收账款</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ05??>
                      ${map.EGA.EG08BJ05!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">预付账款</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ06??>
                      ${map.EGA.EG08BJ06!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">其他应收款</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ07??>
                      ${map.EGA.EG08BJ07!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">存货</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ08??>
                      ${map.EGA.EG08BJ08!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他流动资产</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ09??>
                      ${map.EGA.EG08BJ09!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">流动资产合计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ10??>
                      ${map.EGA.EG08BJ10!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">长期投资</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ11??>
                      ${map.EGA.EG08BJ11!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ12??>
                      ${map.EGA.EG08BJ12!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产原价</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ13??>
                      ${map.EGA.EG08BJ13!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">累计折旧</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ14??>
                      ${map.EGA.EG08BJ14!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">在建工程</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ15??>
                      ${map.EGA.EG08BJ15!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ16??>
                      ${map.EGA.EG08BJ16!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产原价</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ17??>
                     ${map.EGA.EG08BJ17!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">累计摊销</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ18??>
                      ${map.EGA.EG08BJ18!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">待处置资产损溢</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ19??>
                     ${map.EGA.EG08BJ19!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">非流动资产合计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ20??>
                      ${map.EGA.EG08BJ20!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">资产总计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ21??>
                     ${map.EGA.EG08BJ21!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">短期借款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ22??>
                     ${map.EGA.EG08BJ22!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴税费</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ23??>
                     ${map.EGA.EG08BJ23!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">应缴国库款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ24??>
                     ${map.EGA.EG08BJ24!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴财政专户款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ25??>
                     ${map.EGA.EG08BJ25!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">应付职工薪酬</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ26??>
                     ${map.EGA.EG08BJ26!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应付票据</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ27??>
                     ${map.EGA.EG08BJ27!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">应付账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ28??>
                     ${map.EGA.EG08BJ28!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">预收账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ29??>
                     ${map.EGA.EG08BJ29!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">其他应付款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ30??>
                     ${map.EGA.EG08BJ30!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他流动负债</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ31??>
                     ${map.EGA.EG08BJ31!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">流动负债合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ32??>
                     ${map.EGA.EG08BJ32!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">长期借款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ33??>
                     ${map.EGA.EG08BJ33!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">长期应付款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ34??>
                     ${map.EGA.EG08BJ34!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">非流动负债合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ35??>
                     ${map.EGA.EG08BJ35!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">负债合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ36??>
                     ${map.EGA.EG08BJ36!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">事业基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ37??>
                     ${map.EGA.EG08BJ37!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">非流动资产基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ38??>
                     ${map.EGA.EG08BJ38!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">专用基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ39??>
                     ${map.EGA.EG08BJ39!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">财政补助结转</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ40??>
                     ${map.EGA.EG08BJ40!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">财政补助结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ41??>
                     ${map.EGA.EG08BJ41!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">非财政补助结转</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ42??>
                     ${map.EGA.EG08BJ42!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">非财政补助结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ43??>
                     ${map.EGA.EG08BJ43!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">事业结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ44??>
                     ${map.EGA.EG08BJ44!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ45??>
                     ${map.EGA.EG08BJ45!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">净资产合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ46??>
                     ${map.EGA.EG08BJ46!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">负债和净资产总计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ47??>
                     ${map.EGA.EG08BJ47!}
                 <#else >
                 </#if>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位收入支出表（1997）版信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd" >财务报表编号</td>
                <td class="datatd">${map.EGA.EG09AI01!}</td>
                <td class="labeltd" >业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG09AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd" >业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG09AI02!}</td>
                <td class="labeltd" >报表年份</td>
                <td class="datatd">${map.EGA.EG09AR01!}</td>
            </tr>

            <tr>
                <td class="labeltd" >报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG09AD02)!}</td>
                <td class="labeltd" >报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG09AD03)!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位收入支出表（1997）版单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">财政补助收入</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ01??>
                      ${map.EGA.EG09BJ01!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">上级补助收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ02??>
                       ${map.EGA.EG09BJ02!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">附属单位缴款</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ03??>
                       ${map.EGA.EG09BJ03!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">事业收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ04??>
                       ${map.EGA.EG09BJ04!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">预算外资金收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ05??>
                       ${map.EGA.EG09BJ05!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">其他收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ06??>
                       ${map.EGA.EG09BJ06!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业收入小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ07??>
                       ${map.EGA.EG09BJ07!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ08??>
                       ${map.EGA.EG09BJ08!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营收入小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ09??>
                       ${map.EGA.EG09BJ09!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">拨入专款</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ10??>
                      ${map.EGA.EG09BJ10!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">拨入专款小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ11??>
                       ${map.EGA.EG09BJ11!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">收入总计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ12??>
                       ${map.EGA.EG09BJ12!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">拨出经费</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ13??>
                      ${map.EGA.EG09BJ13!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">上缴上级支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ14??>
                       ${map.EGA.EG09BJ14!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">对附属单位补助</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ15??>
                      ${map.EGA.EG09BJ15!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">事业支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ16??>
                       ${map.EGA.EG09BJ16!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">财政补助支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ17??>
                       ${map.EGA.EG09BJ17!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">预算外资金支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ18??>
                       ${map.EGA.EG09BJ18!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">销售税金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ19??>
                       ${map.EGA.EG09BJ19!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">结转自筹基建</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ20??>
                       ${map.EGA.EG09BJ20!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业支出小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ21??>
                       ${map.EGA.EG09BJ21!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营支出</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ22??>
                      ${map.EGA.EG09BJ22!}
                  <#else >
                  </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">销售税金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ23??>
                       ${map.EGA.EG09BJ23!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营支出小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ24??>
                      ${map.EGA.EG09BJ24!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">拨出专款</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ25??>
                       ${map.EGA.EG09BJ25!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">专款支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ26??>
                       ${map.EGA.EG09BJ26!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">专款小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ27??>
                       ${map.EGA.EG09BJ27!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支出总计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ28??>
                       ${map.EGA.EG09BJ28!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ29??>
                       ${map.EGA.EG09BJ29!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">正常收入结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ30??>
                       ${map.EGA.EG09BJ30!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收回以前年度事业支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ31??>
                       ${map.EGA.EG09BJ31!}
                   <#else >
                   </#if>
                </td>
           </tr>
            <tr>     
                <td class="labeltd" colspan="2">经营结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ33??>
                       ${map.EGA.EG09BJ33!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">以前年度经营亏损</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ33??>
                       ${map.EGA.EG09BJ33!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">结余分配</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ34??>
                       ${map.EGA.EG09BJ34!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应交所得税</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ35??>
                       ${map.EGA.EG09BJ35!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">提取专用基金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ36??>
                       ${map.EGA.EG09BJ36!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">转入事业基金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ37??>
                       ${map.EGA.EG09BJ37!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">其他结余分配</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ38??>
                       ${map.EGA.EG09BJ38!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="2">
                    <li>事业单位收入支出表（2013）版信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd" >财务报表编号</td>
                <td class="datatd">${map.EGA.EG10AI01!}</td>
                <td class="labeltd" >业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG10AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd" >业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG10AI02!}</td>
                <td class="labeltd" >报表年份</td>
                <td class="datatd">${map.EGA.EG10AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd" >报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG10AD02)!}</td>
                <td class="labeltd" >报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG10AD03)!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位收入支出表（2013）版单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">本期财政补助结转结余</td>
                <td class="datatd-number" colspan="2">${map.EGA.EG10BJ01!}
                      <#if map.EGA.EG09BJ38??>
                          ${map.EGA.EG09BJ38!}
                      <#else >
                      </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">财政补助收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ02??>
                       ${map.EGA.EG10BJ02!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业支出（财政补助支出）</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ03??>
                       ${map.EGA.EG10BJ03!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">本期事业结转结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ04??>
                       ${map.EGA.EG10BJ04!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业类收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ05??>
                       ${map.EGA.EG10BJ05!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">事业收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ06??>
                       ${map.EGA.EG10BJ06!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">上级补助收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ07??>
                       ${map.EGA.EG10BJ07!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">附属单位上缴收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ08??>
                       ${map.EGA.EG10BJ08!}
                   <#else >
                   </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ09??>
                       ${map.EGA.EG10BJ09!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">（其他收入科目下）捐赠收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ10??>
                       ${map.EGA.EG10BJ10!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业类支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ11??>
                       ${map.EGA.EG10BJ11!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">事业支出（非财政补助支出）</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ12??>
                       ${map.EGA.EG10BJ12!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">上缴上级支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ13??>
                       ${map.EGA.EG10BJ13!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">对附属单位补助支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ14??>
                       ${map.EGA.EG10BJ14!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ15??>
                       ${map.EGA.EG10BJ15!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">本期经营结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ16??>
                       ${map.EGA.EG10BJ16!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ17??>
                       ${map.EGA.EG10BJ17!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">经营支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ18??>
                       ${map.EGA.EG10BJ18!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">弥补以前年度亏损后的经营结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ19??>
                       ${map.EGA.EG10BJ19!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr> 
                <td class="labeltd" colspan="2">本年非财政补助结转结余</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG10BJ20??>
                      ${map.EGA.EG10BJ20!}
                  <#else >
                  </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">非财政补助结转</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG10BJ21??>
                      ${map.EGA.EG10BJ21!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">本年非财政补助结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ22??>
                       ${map.EGA.EG10BJ22!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴企业所得税</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG10BJ23??>
                      ${map.EGA.EG10BJ23!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">提取专用基金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ24??>
                       ${map.EGA.EG10BJ24!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">转入事业基金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ25??>
                       ${map.EGA.EG10BJ25!}
                   <#else >
                   </#if>
                </td>
            </tr>
        </table>
    </fieldset>            
                
                
                
                
    <!-- <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/> -->
</div>
</body>

</html>
