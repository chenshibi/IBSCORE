
<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<html>
<head>
    <title>企业信用报告</title>
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
            
            text-align:left;
            padding-right:8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
            width: 15%;
        }
        .labeltd-3-2 {
            
            text-align:left;
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
         .titletd-4 {
            text-align: right;
            color: black;
            font-size: 14px;
            border: 0px;
        }
        .titletd-5 {
            text-align: left;
            width: 15%;
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
     <h1>企业信用报告</h1>
     <h3>(授信机构版)</h3>
     <br>
    <!--
    <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/> <br>
   -->
           <table class="mainTable">
            <tr>
                <td class="labeltd-3-1" style="border-collapse: collapse; border: none" border="0">报告编号:</td>
                <td class="datatd-1" style="border-collapse: collapse; border: none" border="0">${map.EAA.EA01AI01!}</td>
                <td class="labeltd-3-2" style="border-collapse: collapse; border: none" border="0">报告时间:</td>
                <td class="datatd-1" style="border-collapse: collapse; border: none" border="0">${map.EAA.EA01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd-3-1" style="border-collapse: collapse; border: none" border="0">查询机构代码:</td>
                <td class="datatd-1" style="border-collapse: collapse; border: none" border="0">${map.EAA.EA01BI01!}</td>
                <td class="labeltd-3-2" style="border-collapse: collapse; border: none" border="0">查询原因代码:</td>
                <td class="datatd-1" style="border-collapse: collapse; border: none" border="0">${DataDicUtil.getDataDic("6066",map.EAA.EA01BD02)!}</td>
            </tr>
           </table>
           
           <h2>身份标识</h2>
           <table class="mainTable">
                        <#--  
                        <tr>
                            <td colspan="2" class="table-head-td">企业身份标识列表(总计${map.EA01CH?size!}条记录)</td>
                        </tr>
                        
                        <tr>
                            <td class="table-label-td" style="width:50%;">被查询者企业身份标识类型</td>
                            <td class="table-label-td" style="width:50%;">被查询者企业身份标识号码</td>
                        </tr>
                        -->
                        <tr>
                            <td class="table-label-td-1" style="width:50%;">企业名称</td>
                            <td class="datatd" style="width:50%;">${map.EAA.EA01CQ01!}</td>
                        </tr>
                        <tr>
                            <td class="table-label-td-1" style="width:50%;">身份标识类型(总计${map.EA01CH?size!}条记录)</td>
                            <td class="table-label-td-1" style="width:50%;">身份标识号码</td>
                        </tr>
                        <#list map.EA01CH! as EA01CH>
                        <tr>
                            <td class="datatd">${DataDicUtil.getDataDic("6065",EA01CH.EA01CD01)!}</td>
                            <td class="datatd">${EA01CH.EA01CI01!}</td>
                        </tr>
                        </#list>
                    </table><br>
                    
            <h2>异议提示</h2>
            <table class="mainTable">
            	<tr>
                	<td class="labeltd-3" style="border-collapse: collapse; border: none" border="0">
                		信息主体对信用报告内容提出了  ${map.EAA.EA01DS01!}  笔异议且正在处理中，请浏览时注意阅读相关内容。
                	</td>
                </tr>
            </table><br>
            <#--
            <table class="mainTable">
            <tr>
                <td class="labeltd">查询机构代码</td>
                <td class="datatd">${map.EAA.EA01BI01!}</td>
                <td class="labeltd">查询原因代码</td>
                <td class="datatd">${DataDicUtil.getDataDic("6066",map.EAA.EA01BD02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">美元折人民币汇率</td>
                <td class="datatd">${map.EAA.EA01EQ01!}</td>
                <td class="labeltd">汇率有效日期</td>
                <td class="datatd">${map.EAA.EA01ER01!}</td>
            </tr>
             
            <tr>
                <td class="labeltd">异议标注数目</td>
                <td class="datatd">${map.EAA.EA01DS01!}</td>
            </tr>
            
            </table>
             -->
             <#--
      	<h2>身份标识</h2>      
            <table class="mainTable">
             <tr>
                <td class="labeltd">企业名称</td>
                <td class="datatd">${DataDicUtil.getDataDic("6122", map.ECA.EC010D01)!}</td>
            </tr>
             <tr>
                <td class="labeltd">中征码</td>
                <td class="datatd">${DataDicUtil.getDataDic("6122", map.ECA.EC010D01)!}</td>
            </tr>
              <tr>
                <td class="labeltd">统一社会信用代码</td>
                <td class="datatd">${DataDicUtil.getDataDic("6122", map.ECA.EC010D01)!}</td>
            </tr>
              <tr>
                <td class="labeltd">组织机构代码</td>
                <td class="datatd">${DataDicUtil.getDataDic("6122", map.ECA.EC010D01)!}</td>
            </tr>
            </table><br> 
            -->
            
            <h2>信息概要</h2>  
            
              <table class="mainTable">
        <!--     <tr>
                <td class="titletd" colspan="4">
                    <li>信贷交易提示信息单元</li>
                </td>
            </tr>-->
            <tr>
                <td class="labeltd">首次有信贷交易的年份</td>
                <td class="labeltd">首次有相关还款责任的年份</td>
                <td class="labeltd">发生信贷交易的机构数</td>
                <td class="labeltd">当前有未结清信贷交易的机构数</td>
            </tr>
            <tr>
                <td class="datatd">${map.EBA.EB01AR01!}</td>
                <td class="datatd">${map.EBA.EB01AR02!}</td>
                <td class="datatd">${map.EBA.EB01AS01!}</td>
                <td class="datatd">${map.EBA.EB01AS02!}</td>
            </tr>
            
            </table><br>
            
            
              <table class="mainTable">
              <tr>
              	<td class="labeltd" colspan="2">借贷交易</td>
              	<td class="labeltd" colspan="2">担保交易</td>
              </tr>
              <tr>
                <td class="labeltd">借贷交易余额</td>
                <td class="datatd">
                 <#if map.EBA.EB01AJ01??>
                    ${DataDicUtil.getPoint(map.EBA.EB01AJ01)!}
                <#else >
                </#if>
               </td>
               <td class="labeltd">担保交易余额</td>
                <td class="datatd" >
                     <#if map.EBA.EB01AJ05??>
                         ${DataDicUtil.getPoint(map.EBA.EB01AJ05)!}
                     <#else >
                     </#if>
                </td>
                
            </tr>
            <tr>
            <td class="labeltd">被追偿的借贷交易余额</td>
                <td class="datatd">
                     <#if map.EBA.EB01AJ02??>
                         ${DataDicUtil.getPoint(map.EBA.EB01AJ02)!}
                     <#else >
                     </#if>
                </td>
               <td class="labeltd">关注类担保交易余额</td>
                <td class="datatd" >
                      <#if map.EBA.EB01AJ06??>
                          ${DataDicUtil.getPoint(map.EBA.EB01AJ06)!}
                      <#else >
                      </#if>
                </td>
            </tr>
            <tr>
                 <td class="labeltd">关注类借贷交易余额</td>
                <td class="datatd">
                  <#if map.EBA.EB01AJ03??>
                      ${DataDicUtil.getPoint(map.EBA.EB01AJ03)!}
                  <#else >
                  </#if>
                 </td>
                  <td class="labeltd">不良类担保交易余额</td>
                <td class="datatd">
                    <#if map.EBA.EB01AJ07??>
                        ${DataDicUtil.getPoint(map.EBA.EB01AJ07)!}
                    <#else >
                    </#if>
                </td>
                
            </tr>
            <tr>
               <td class="labeltd">不良类借贷交易余额</td>
                <td class="datatd">
                    <#if map.EBA.EB01AJ04??>
                        ${DataDicUtil.getPoint(map.EBA.EB01AJ04)!}
                    <#else >
                    </#if>
                </td>
                
                <td>
                </td>
                <td>
                </td>
            </tr>
            
            </table><br>
            
             <table class="mainTable">
            
         <!--    <tr>
                <td class="titletd" colspan="4">
                    <li>非信贷交易提示信息单元</li>
                </td>
            </tr>
            -->
            <tr>
                <td class="labeltd">非信贷交易账户数</td>
                <td class="labeltd">欠税记录条数</td>
                <td class="labeltd">民事判决记录条数</td>
                <td class="labeltd">强制执行记录条数</td>
                <td class="labeltd">行政处罚记录条数</td>
            </tr>
            <tr>
             	<td class="datatd">${map.EBA.EB01BS01!}</td>
             	<td class="datatd">${map.EBA.EB01BS02!}</td>
                <td class="datatd">${map.EBA.EB01BS03!}</td>
                <td class="datatd">${map.EBA.EB01BS04!}</td>
                <td class="datatd">${map.EBA.EB01BS05!}</td>
            </tr>
             </table><br>
            
            
            
             <table class="mainTable">
            <tr>
                <td class="titletd" colspan="9">
                    <li>未结清借贷交易汇总信息单元</li>
                </td>
            </tr>
             <tr>
            	<td colspan="3" class="table-label-td"> 由资产管理公司处置的债务</td>
            	<td colspan="3" class="table-label-td"> 垫款</td>
            	<td colspan="3" class="table-label-td"> 逾期</td>
            </tr>
            <tr>
            <td class="table-label-td">账户数</td>
            <td class="table-label-td">余额</td>
            <td class="table-label-td">最近一次处置日期</td>
            
            <td class="table-label-td">账户数</td>
            <td class="table-label-td">余额</td>
            <td class="table-label-td">最近一次处置日期</td>
            
            <td class="table-label-td">总额</td>
            <td class="table-label-td">本金</td>
            <td class="table-label-td">利息及其他</td>
            </tr>
            
            <tr>
                <td class="datatd">${map.EBB.EB02AS01!}</td>
                <td class="datatd">
                     <#if map.EBB.EB02AJ01??>
                         ${DataDicUtil.getPoint(map.EBB.EB02AJ01)!}
                     <#else >
                     </#if>
                </td>
                <td class="datatd">${map.EBB.EB02AR01!}</td>
                <td class="datatd">${map.EBB.EB02AS02!}</td>
                <td class="datatd">
                      <#if map.EBB.EB02AJ02??>
                          ${DataDicUtil.getPoint(map.EBB.EB02AJ02)!}
                      <#else >
                      </#if>
                </td>
                <td class="datatd">${map.EBB.EB02AR02!}</td>
                <td class="datatd">
                  <#if map.EBB.EB02AJ03??>
                      ${ DataDicUtil.getPoint(map.EBB.EB02AJ03)!}
                  <#else >
                  </#if>
                </td>
                <td class="datatd">
                    <#if map.EBB.EB02AJ04??>
                        ${ DataDicUtil.getPoint(map.EBB.EB02AJ04)!}
                    <#else >
                    </#if>
                </td>
                <td class="datatd">
                       <#if map.EBB.EB02AJ05??>
                           ${ DataDicUtil.getPoint(map.EBB.EB02AJ05)!}
                       <#else >
                       </#if>
                </td>
            </tr>
            </table><br>
            
            
         
            
             <table class="mainTable">
            <tr>
            	<td class="table-label-td" rowspan="2"> </td>
            	<td class="table-label-td" colspan="2">正常类</td>
            	<td class="table-label-td" colspan="2">关注类</td>
            	<td class="table-label-td" colspan="2">不良类</td>
            	<td class="table-label-td" colspan="2">合计</td>
            </tr>
            
            <tr>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            </tr>
            
            <tr>
           		 <td class="labeltd">中长期借款 </td>
           		 <td class="datatd">
            		<#if map.EB02AH_1_1.EB02AS04??>
                        ${map.EB02AH_1_1.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_1_1.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_1_1.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_1_2.EB02AS04??>
                        ${map.EB02AH_1_2.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_1_2.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_1_2.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_1_3.EB02AS04??>
                        ${map.EB02AH_1_3.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_1_3.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_1_3.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_1_0.EB02AS04??>
                        ${map.EB02AH_1_0.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_1_0.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_1_0.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            
            
            
            </tr>
             <tr>
           		 <td class="labeltd">短期借款 </td>
             <td class="datatd">
            		<#if map.EB02AH_2_1.EB02AS04??>
                        ${map.EB02AH_2_1.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_2_1.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_2_1.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_2_2.EB02AS04??>
                        ${map.EB02AH_2_2.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_2_2.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_2_2.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_2_3.EB02AS04??>
                        ${map.EB02AH_2_3.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_2_3.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_2_3.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_2_0.EB02AS04??>
                        ${map.EB02AH_2_0.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_2_0.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_2_0.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            </tr>
             <tr>
           		 <td class="labeltd">循环透支 </td>
             <td class="datatd">
            		<#if map.EB02AH_3_1.EB02AS04??>
                        ${map.EB02AH_3_1.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_3_1.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_3_1.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_3_2.EB02AS04??>
                        ${map.EB02AH_3_2.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_3_2.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_3_2.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_3_3.EB02AS04??>
                        ${map.EB02AH_3_3.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_3_3.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_3_3.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_3_0.EB02AS04??>
                        ${map.EB02AH_3_0.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_3_0.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_3_0.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            </tr>
             <tr>
           		 <td class="labeltd">票据贴现</td>
             <td class="datatd">
            		<#if map.EB02AH_4_1.EB02AS04??>
                        ${map.EB02AH_4_1.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_4_1.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_4_1.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_4_2.EB02AS04??>
                        ${map.EB02AH_4_2.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_4_2.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_4_2.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_4_3.EB02AS04??>
                        ${map.EB02AH_4_3.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_4_3.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_4_3.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_4_0.EB02AS04??>
                        ${map.EB02AH_4_0.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_4_0.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_4_0.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            </tr>
           <tr>
           		 <td class="labeltd">合计 </td>
             <td class="datatd">
            		<#if map.EB02AH_0_1.EB02AS04??>
                        ${map.EB02AH_0_1.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_0_1.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_0_1.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_0_2.EB02AS04??>
                        ${map.EB02AH_0_2.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_0_2.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_0_2.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_0_3.EB02AS04??>
                        ${map.EB02AH_0_3.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_0_3.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_0_3.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB02AH_0_0.EB02AS04??>
                        ${map.EB02AH_0_0.EB02AS04!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB02AH_0_0.EB02AJ06??>
                        ${DataDicUtil.getPoint(map.EB02AH_0_0.EB02AJ06)!}
                    <#else >--
                    </#if>
            	  </td>
            </tr> 
            
            </table><br>
            
            
             <table class="mainTable">
            <tr>
            	<td class="table-label-td" rowspan="2"> </td>
            	<td class="table-label-td" colspan="2">正常类</td>
            	<td class="table-label-td" colspan="2">关注类</td>
            	<td class="table-label-td" colspan="2">不良类</td>
            	<td class="table-label-td" colspan="2">合计</td>
            </tr>
            
            <tr>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            </tr>
            
            <tr>
           		 <td class="labeltd">银行承兑汇票 </td>
             <td class="datatd">
            		<#if map.EB03AH_1_1.EB03AS02??>
                        ${map.EB03AH_1_1.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_1_1.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_1_1.EB03AJ01)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB03AH_1_2.EB03AS02??>
                        ${map.EB03AH_1_2.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_1_2.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_1_2.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_1_3.EB03AS02??>
                        ${map.EB03AH_1_3.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_1_3.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_1_3.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_1_0.EB03AS02??>
                        ${map.EB03AH_1_0.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_1_0.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_1_0.EB03AJ01)!}
                    <#else >--
                    </#if>
            	  </td>
            </tr>
             <tr>
           		 <td class="labeltd">信用证</td>
              <td class="datatd">
            		<#if map.EB03AH_2_1.EB03AS02??>
                        ${map.EB03AH_2_1.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_2_1.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_2_1.EB03AJ01)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB03AH_2_2.EB03AS02??>
                        ${map.EB03AH_2_2.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_2_2.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_2_2.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_2_3.EB03AS02??>
                        ${map.EB03AH_2_3.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_2_3.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_2_3.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_2_0.EB03AS02??>
                        ${map.EB03AH_2_0.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_2_0.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_2_0.EB03AJ01)!}
                    <#else >--
                    </#if>
            </tr>
             <tr>
           		 <td class="labeltd">合计 </td>
              <td class="datatd">
            		<#if map.EB03AH_0_1.EB03AS02??>
                        ${map.EB03AH_0_1.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_0_1.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_0_1.EB03AJ01)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB03AH_0_2.EB03AS02??>
                        ${map.EB03AH_0_2.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_0_2.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_0_2.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_0_3.EB03AS02??>
                        ${map.EB03AH_0_3.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_0_3.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_0_3.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_0_0.EB03AS02??>
                        ${map.EB03AH_0_0.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_0_0.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_0_0.EB03AJ01)!}
                    <#else >--
                    </#if>
            </tr>
            
            </table><br>
            
            
            
            
             <table class="mainTable">
            <tr>
            	<td class="table-label-td" rowspan="2"> </td>
            	<td class="table-label-td" colspan="2">正常类</td>
            	<td class="table-label-td" colspan="2">关注类</td>
            	<td class="table-label-td" colspan="2">不良类</td>
            	<td class="table-label-td" colspan="2">合计</td>
            </tr>
            
            <tr>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            </tr>
            
            <tr>
           		 <td class="labeltd">银行保函 </td>
              <td class="datatd">
            		<#if map.EB03AH_3_1.EB03AS02??>
                        ${map.EB03AH_3_1.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_3_1.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_3_1.EB03AJ01)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB03AH_3_2.EB03AS02??>
                        ${map.EB03AH_3_2.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_3_2.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_3_2.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_3_3.EB03AS02??>
                        ${map.EB03AH_3_3.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_3_3.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_3_3.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_3_0.EB03AS02??>
                        ${map.EB03AH_3_0.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_3_0.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_3_0.EB03AJ01)!}
                    <#else >--
                    </#if>
            </tr>
             <tr>
           		 <td class="labeltd">其他担保交易</td>
              <td class="datatd">
            		<#if map.EB03AH_9_1.EB03AS02??>
                        ${map.EB03AH_9_1.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_9_1.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_9_1.EB03AJ01)!}
                    <#else >--
                    </#if>
            	  </td>
            	  
            	  <td class="datatd">
            		<#if map.EB03AH_9_2.EB03AS02??>
                        ${map.EB03AH_9_2.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_9_2.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_9_2.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_9_3.EB03AS02??>
                        ${map.EB03AH_9_3.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_9_3.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_9_3.EB03AJ01)!}
                    <#else >--
                    </#if>
                    
                     <td class="datatd">
            		<#if map.EB03AH_9_0.EB03AS02??>
                        ${map.EB03AH_9_0.EB03AS02!}
                    <#else >--
                    </#if>
            	  </td>
            		<td class="datatd">
            		<#if map.EB03AH_9_0.EB03AJ01??>
                        ${DataDicUtil.getPoint(map.EB03AH_9_0.EB03AJ01)!}
                    <#else >--
                    </#if>
            </tr>
            
            </table><br>
            
            
            
            
             <table class="mainTable">
             
             <tr>
             <td class="table-label-td" colspan="3">非循环信用额度</td>
             <td class="table-label-td" colspan="3">循环信用额度</td>
             </tr>
             
             <tr>
           	  	<td class="table-label-td">总额</td>
           	  	<td class="table-label-td">已用额度</td>
             	<td class="table-label-td">剩余可用额度</td>
             	<td class="table-label-td">总额</td>
             	<td class="table-label-td">已用额度</td>
             	<td class="table-label-td">剩余可用额度</td>
             </tr>
             <tr>
              	<td class="datatd">
                  <#if map.EBD.EB040J01??>
                      ${DataDicUtil.getPoint(map.EBD.EB040J01)!}
                  <#else >
                  </#if>
                </td>
              	<td class="datatd">
                  <#if map.EBD.EB040J02??>
                      ${DataDicUtil.getPoint(map.EBD.EB040J02)!}
                  <#else >
                  </#if>
               	 </td>
              	 <td class="datatd">
                      <#if map.EBD.EB040J03??>
                          ${DataDicUtil.getPoint(map.EBD.EB040J03)!}
                      <#else >
                      </#if>
                  </td>
                  <td class="datatd">
                      <#if map.EBD.EB040J04??>
                          ${DataDicUtil.getPoint(map.EBD.EB040J04)!}
                      <#else >
                      </#if>
                 </td>
                  <td class="datatd">
                      <#if map.EBD.EB040J05??>
                          ${DataDicUtil.getPoint(map.EBD.EB040J05)!}
                      <#else >
                      </#if>
                 </td>
                <td class="datatd">
                    <#if map.EBD.EB040J06??>
                        ${DataDicUtil.getPoint(map.EBD.EB040J06)!}
                    <#else >
                    </#if>
                 </td>
             </tr>
              </table><br>
            
            
           <table class="mainTable">
				<td class="titletd" colspan="9">
                    <li>相关还款责任信息概要</li>
                </td>
                
                  <tr>
            	<td class="table-label-td" rowspan="2">责任类型 </td>
            	<td class="table-label-td" colspan="3">被追偿业务</td>
            	<td class="table-label-td" colspan="5">其他借贷交易</td>
            </tr>
            
            <tr>
            	<td class="table-label-td">还款责任金额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">还款责任金额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">关注类余额</td>
            	<td class="table-label-td">不良类余额</td>
            </tr>
            
            <tr>
            	<td class="labeltd">个人信贷交易共同还款人/共同债务人</td>
            	<td class="datatd">
                  <#if map.EB05AH_1.EB05AJ01??>
                      ${DataDicUtil.getPoint(map.EB05AH_1.EB05AJ01)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_1.EB05AS02??>
                      ${map.EB05AH_1.EB05AS02!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_1.EB05AJ02??>
                      ${DataDicUtil.getPoint(map.EB05AH_1.EB05AJ02)!}
                  <#else>--
                  </#if>
                </td>
                
                <td class="datatd">
                  <#if map.EB05AH_1.EB05AJ03??>
                      ${DataDicUtil.getPoint(map.EB05AH_1.EB05AJ03)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_1.EB05AS03??>
                      ${map.EB05AH_1.EB05AS03!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_1.EB05AJ04??>
                      ${DataDicUtil.getPoint(map.EB05AH_1.EB05AJ04)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_1.EB05AJ05??>
                      ${DataDicUtil.getPoint(map.EB05AH_1.EB05AJ05)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_1.EB05AJ06??>
                      ${DataDicUtil.getPoint(map.EB05AH_1.EB05AJ06)!}
                  <#else>--
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">保证人/反担保人</td>
                <td class="datatd">
                  <#if map.EB05AH_2.EB05AJ01??>
                      ${DataDicUtil.getPoint(map.EB05AH_2.EB05AJ01)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_2.EB05AS02??>
                      ${map.EB05AH_2.EB05AS02!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_2.EB05AJ02??>
                      ${DataDicUtil.getPoint(map.EB05AH_2.EB05AJ02)!}
                  <#else>--
                  </#if>
                </td>
                
                <td class="datatd">
                  <#if map.EB05AH_2.EB05AJ03??>
                      ${DataDicUtil.getPoint(map.EB05AH_2.EB05AJ03)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_2.EB05AS03??>
                      ${map.EB05AH_2.EB05AS03!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_2.EB05AJ04??>
                      ${DataDicUtil.getPoint(map.EB05AH_2.EB05AJ04)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_2.EB05AJ05??>
                      ${DataDicUtil.getPoint(map.EB05AH_2.EB05AJ05)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_2.EB05AJ06??>
                      ${DataDicUtil.getPoint(map.EB05AH_2.EB05AJ06)!}
                  <#else>--
                  </#if>
                </td>
            </tr>
            <tr>
            	<td class="labeltd">其他</td>
            	<td class="datatd">
                  <#if map.EB05AH_9.EB05AJ01??>
                      ${DataDicUtil.getPoint(map.EB05AH_9.EB05AJ01)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_9.EB05AS02??>
                      ${map.EB05AH_9.EB05AS02!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_9.EB05AJ02??>
                      ${DataDicUtil.getPoint(map.EB05AH_9.EB05AJ02)!}
                  <#else>--
                  </#if>
                </td>
                
                <td class="datatd">
                  <#if map.EB05AH_9.EB05AJ03??>
                      ${DataDicUtil.getPoint(map.EB05AH_9.EB05AJ03)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_9.EB05AS03??>
                      ${map.EB05AH_9.EB05AS03!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_9.EB05AJ04??>
                      ${DataDicUtil.getPoint(map.EB05AH_9.EB05AJ04)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_9.EB05AJ05??>
                      ${DataDicUtil.getPoint(map.EB05AH_9.EB05AJ05)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_9.EB05AJ06??>
                      ${DataDicUtil.getPoint(map.EB05AH_9.EB05AJ06)!}
                  <#else>--
                  </#if>
                </td>
            </tr>
            <tr>
            	<td class="labeltd">合计</td>
            	<td class="datatd">
                  <#if map.EB05AH_0.EB05AJ01??>
                      ${DataDicUtil.getPoint(map.EB05AH_0.EB05AJ01)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_0.EB05AS02??>
                      ${map.EB05AH_0.EB05AS02!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_0.EB05AJ02??>
                      ${DataDicUtil.getPoint(map.EB05AH_0.EB05AJ02)!}
                  <#else>--
                  </#if>
                </td>
                
                <td class="datatd">
                  <#if map.EB05AH_0.EB05AJ03??>
                      ${DataDicUtil.getPoint(map.EB05AH_0.EB05AJ03)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_0.EB05AS03??>
                      ${map.EB05AH_0.EB05AS03!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_0.EB05AJ04??>
                      ${DataDicUtil.getPoint(map.EB05AH_0.EB05AJ04)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_0.EB05AJ05??>
                      ${DataDicUtil.getPoint(map.EB05AH_0.EB05AJ05)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05AH_0.EB05AJ06??>
                      ${DataDicUtil.getPoint(map.EB05AH_0.EB05AJ06)!}
                  <#else>--
                  </#if>
                </td>
            </tr>	
			</table><br>  
            
              <table class="mainTable">
                
                  <tr>
            	<td class="table-label-td" rowspan="2">责任类型 </td>
            	<td class="table-label-td" colspan="5">担保交易</td>
            </tr>
            
            <tr>
            	<td class="table-label-td">还款责任金额</td>
            	<td class="table-label-td">账户数</td>
            	<td class="table-label-td">余额</td>
            	<td class="table-label-td">关注类余额</td>
            	<td class="table-label-td">不良类余额</td>
            </tr>
            
            <tr>
            	<td class="labeltd">个人信贷交易共同还款人/共同债务人</td>
            	<td class="datatd">
                  <#if map.EB05BH_1.EB05BJ01??>
                      ${DataDicUtil.getPoint(map.EB05BH_1.EB05BJ01)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_1.EB05BS02??>
                      ${map.EB05BH_1.EB05BS02!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_1.EB05BJ02??>
                      ${DataDicUtil.getPoint(map.EB05BH_1.EB05BJ02)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_1.EB05BJ03??>
                      ${DataDicUtil.getPoint(map.EB05BH_1.EB05BJ03)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_1.EB05BJ04??>
                      ${DataDicUtil.getPoint(map.EB05BH_1.EB05BJ04)!}
                  <#else>--
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">保证人/反担保人</td>
                <td class="datatd">
                  <#if map.EB05BH_2.EB05BJ01??>
                      ${DataDicUtil.getPoint(map.EB05BH_2.EB05BJ01)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_2.EB05BS02??>
                      ${map.EB05BH_2.EB05BS02!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_2.EB05BJ02??>
                      ${DataDicUtil.getPoint(map.EB05BH_2.EB05BJ02)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_2.EB05BJ03??>
                      ${DataDicUtil.getPoint(map.EB05BH_2.EB05BJ03)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_2.EB05BJ04??>
                      ${DataDicUtil.getPoint(map.EB05BH_2.EB05BJ04)!}
                  <#else>--
                  </#if>
                </td>
            </tr>
            <tr>
            	<td class="labeltd">其他</td>
            	<td class="datatd">
                  <#if map.EB05BH_9.EB05BJ01??>
                      ${DataDicUtil.getPoint(map.EB05BH_9.EB05BJ01)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_9.EB05BS02??>
                      ${map.EB05BH_9.EB05BS02!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_9.EB05BJ02??>
                      ${DataDicUtil.getPoint(map.EB05BH_9.EB05BJ02)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_9.EB05BJ03??>
                      ${DataDicUtil.getPoint(map.EB05BH_9.EB05BJ03)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_9.EB05BJ04??>
                      ${DataDicUtil.getPoint(map.EB05BH_9.EB05BJ04)!}
                  <#else>--
                  </#if>
                </td>
            </tr>
            <tr>
            	<td class="labeltd">合计</td>
            	<td class="datatd">
                  <#if map.EB05BH_0.EB05BJ01??>
                      ${DataDicUtil.getPoint(map.EB05BH_0.EB05BJ01)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_0.EB05BS02??>
                      ${map.EB05BH_0.EB05BS02!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_0.EB05BJ02??>
                      ${DataDicUtil.getPoint(map.EB05BH_0.EB05BJ02)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_0.EB05BJ03??>
                      ${DataDicUtil.getPoint(map.EB05BH_0.EB05BJ03)!}
                  <#else>--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB05BH_0.EB05BJ04??>
                      ${DataDicUtil.getPoint(map.EB05BH_0.EB05BJ04)!}
                  <#else>--
                  </#if>
                </td>
            </tr>	
			</table><br>  
            
             <table class="mainTable">
            <tr>
                <td class="titletd" colspan="9">
                    <li>已结清信贷信息概要</li>
                </td>
            </tr>
             <tr>
            	<td colspan="3" class="table-label-td"> 由资产管理公司处置的债务</td>
            	<td colspan="3" class="table-label-td"> 垫款</td>
            </tr>
            <tr>
            <td class="table-label-td">账户数</td>
            <td class="table-label-td">金额</td>
            <td class="table-label-td">处置完成日期</td>
            
            <td class="table-label-td">账户数</td>
            <td class="table-label-td">金额</td>
            <td class="table-label-td">结清日期</td>
            
            </tr>
            
            <tr>
                <td class="datatd">${map.EBB1.EB02BS01!}</td>
                <td class="datatd">
                     <#if map.EBB1.EB02BJ01??>
                         ${ DataDicUtil.getPoint(map.EBB1.EB02BJ01)!}
                     <#else >
                     </#if>
                </td>
                <td class="datatd">${map.EBB1.EB02BR01!}</td>
                <td class="datatd">${map.EBB1.EB02BS02!}</td>
                <td class="datatd">
                      <#if map.EBB1.EB02BJ02??>
                          ${ DataDicUtil.getPoint(map.EBB1.EB02BJ02)!}
                      <#else >
                      </#if>
                </td>
                <td class="datatd">${map.EBB1.EB02BR02!}</td>
            </tr>
            </table><br>
            
            
         
            
             <table class="mainTable">
            <tr>
            	<td class="table-label-td"> </td>
            	<td class="table-label-td">正常类账户数</td>
            	<td class="table-label-td">关注类账户数</td>
            	<td class="table-label-td">不良类账户数</td>
            	<td class="table-label-td">合计</td>
            </tr>
            
            
            <tr>
           		 <td class="labeltd">中长期借款 </td>
            	 <td class="datatd">
                  <#if map.EB02BH_1_1.EB02BS04??>
                      ${ map.EB02BH_1_1.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_1_2.EB02BS04??>
                      ${ map.EB02BH_1_2.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_1_3.EB02BS04??>
                      ${ map.EB02BH_1_3.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_1_0.EB02BS04??>
                      ${ map.EB02BH_1_0.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
            </tr>
             <tr>
           		 <td class="labeltd">短期借款 </td>
            <td class="datatd">
                  <#if map.EB02BH_2_1.EB02BS04??>
                      ${ map.EB02BH_2_1.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_2_2.EB02BS04??>
                      ${ map.EB02BH_2_2.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_2_3.EB02BS04??>
                      ${ map.EB02BH_2_3.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_2_0.EB02BS04??>
                      ${ map.EB02BH_2_0.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
            </tr>
             <tr>
           		 <td class="labeltd">循环透支 </td>
            <td class="datatd">
                  <#if map.EB02BH_3_1.EB02BS04??>
                      ${ map.EB02BH_3_1.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_3_2.EB02BS04??>
                      ${ map.EB02BH_3_2.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_3_3.EB02BS04??>
                      ${ map.EB02BH_3_3.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_3_0.EB02BS04??>
                      ${ map.EB02BH_3_0.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
            </tr>
             <tr>
           		 <td class="labeltd">票据贴现 </td>
            <td class="datatd">
                  <#if map.EB02BH_4_1.EB02BS04??>
                      ${ map.EB02BH_4_1.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_4_2.EB02BS04??>
                      ${ map.EB02BH_4_2.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_4_3.EB02BS04??>
                      ${ map.EB02BH_4_3.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_4_0.EB02BS04??>
                      ${ map.EB02BH_4_0.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
            </tr>
             <tr>
           		 <td class="labeltd">合计 </td>
            <td class="datatd">
                  <#if map.EB02BH_0_1.EB02BS04??>
                      ${ map.EB02BH_0_1.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_0_2.EB02BS04??>
                      ${ map.EB02BH_0_2.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_0_3.EB02BS04??>
                      ${ map.EB02BH_0_3.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB02BH_0_0.EB02BS04??>
                      ${ map.EB02BH_0_0.EB02BS04!}
                  <#else >--
                  </#if>
                </td>
            </tr>
            
            </table><br>

            
             <table class="mainTable">
            <tr>
            	<td class="table-label-td"> </td>
            	<td class="table-label-td">正常类账户数</td>
            	<td class="table-label-td">关注类账户数</td>
            	<td class="table-label-td">不良类账户数</td>
            	<td class="table-label-td">合计</td>
            </tr>
            
            
            <tr>
           		 <td class="labeltd">银行承兑汇票 </td>
             <td class="datatd">
                  <#if map.EB03BH_1_1.EB03BS02??>
                      ${ map.EB03BH_1_1.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_1_2.EB03BS02??>
                      ${ map.EB03BH_1_2.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_1_3.EB03BS02??>
                      ${ map.EB03BH_1_3.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_1_0.EB03BS02??>
                      ${ map.EB03BH_1_0.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
            </tr>
             <tr>
           		 <td class="labeltd">信用证</td>
             <td class="datatd">
                  <#if map.EB03BH_2_1.EB03BS02??>
                      ${ map.EB03BH_2_1.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_2_2.EB03BS02??>
                      ${ map.EB03BH_2_2.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_2_3.EB03BS02??>
                      ${ map.EB03BH_2_3.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_2_0.EB03BS02??>
                      ${ map.EB03BH_2_0.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
            </tr>
             <tr>
           		 <td class="labeltd">合计 </td>
             <td class="datatd">
                  <#if map.EB03BH_0_1.EB03BS02??>
                      ${ map.EB03BH_0_1.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_0_2.EB03BS02??>
                      ${ map.EB03BH_0_2.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_0_3.EB03BS02??>
                      ${ map.EB03BH_0_3.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_0_0.EB03BS02??>
                      ${ map.EB03BH_0_0.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
            </tr>
            
            </table><br>
            
            
            
            
             <table class="mainTable">
            <tr>
            	<td class="table-label-td"> </td>
            	<td class="table-label-td">正常类账户数</td>
            	<td class="table-label-td">关注类账户数</td>
            	<td class="table-label-td">不良类账户数</td>
            	<td class="table-label-td">合计</td>
            </tr>
            
            
            <tr>
           		 <td class="labeltd">银行保函 </td>
             <td class="datatd">
                  <#if map.EB03BH_3_1.EB03BS02??>
                      ${ map.EB03BH_3_1.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_3_2.EB03BS02??>
                      ${ map.EB03BH_3_2.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_3_3.EB03BS02??>
                      ${ map.EB03BH_3_3.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_3_0.EB03BS02??>
                      ${ map.EB03BH_3_0.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
            </tr>
             <tr>
           		 <td class="labeltd">其他担保交易</td>
             <td class="datatd">
                  <#if map.EB03BH_9_1.EB03BS02??>
                      ${ map.EB03BH_9_1.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_9_2.EB03BS02??>
                      ${ map.EB03BH_9_2.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_9_3.EB03BS02??>
                      ${ map.EB03BH_9_3.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
                <td class="datatd">
                  <#if map.EB03BH_9_0.EB03BS02??>
                      ${ map.EB03BH_9_0.EB03BS02!}
                  <#else >--
                  </#if>
                </td>
            </tr>
            
            </table><br>
            
             <table class="mainTable">
           <tr>
                <td class="titletd" colspan="11">
                    <li>负债历史</li>
                </td>
            </tr>
                        <tr>
                            <td colspan="11" class="table-head-td">负债历史汇总信息列表(总计${map.EB02CH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd-2"> </td>
                            <td class="labeltd-2" colspan="2">全部负债 </td>
                            <td class="labeltd-2" colspan="2">关注类负债 </td>
                            <td class="labeltd-2" colspan="2">不良类负债 </td>
                            <td class="labeltd-2" colspan="4">逾期类负债</td>
                        </tr>
                        <tr>
                            <td class="labeltd-2">月份</td>
                            <td class="labeltd-2">全部负债账户数</td>
                            <td class="labeltd-2">全部负债余额</td>
                            <td class="labeltd-2">关注类负债账户数</td>
                            <td class="labeltd-2">关注类负债余额</td>
                            <td class="labeltd-2">不良类负债账户数</td>
                            <td class="labeltd-2">不良类负债余额</td>
                            <td class="labeltd-2">逾期账户数</td>
                            <td class="labeltd-2">逾期总额</td>
                            <td class="labeltd-2">逾期本金账户数</td>
                            <td class="labeltd-2">逾期本金</td>
                        </tr>
                        <#list map.EB02CH! as EB02CH>
                        <tr>
                            <td class="datatd">${EB02CH.EB02CR01!}</td>
                            <td class="datatd">${EB02CH.EB02CS02!}</td>
                            <td class="datatd">
                               <#if EB02CH.EB02CJ01??>
                                   ${DataDicUtil.getPoint(EB02CH.EB02CJ01)!}
                               <#else >
                               </#if>
                            </td>
                            <td class="datatd">${EB02CH.EB02CS03!}</td>
                            <td class="datatd">
                              <#if EB02CH.EB02CJ02??>
                                  ${DataDicUtil.getPoint(EB02CH.EB02CJ02)!}
                              <#else >
                              </#if>
                            </td>
                            <td class="datatd">${EB02CH.EB02CS04!}</td>
                            <td class="datatd">
                                  <#if EB02CH.EB02CJ03??>
                                      ${DataDicUtil.getPoint(EB02CH.EB02CJ03)!}
                                  <#else >
                                  </#if>
                            </td>
                            <td class="datatd">${EB02CH.EB02CS05!}</td>
                            <td class="datatd">
                              <#if EB02CH.EB02CJ04??>
                                  ${DataDicUtil.getPoint(EB02CH.EB02CJ04)!}
                              <#else >
                              </#if>
                             </td>
                            <td class="datatd">${EB02CH.EB02CS06!}</td>
                            <td class="datatd">${EB02CH.EB02CJ05!}
                                <#if EB02CH.EB02CJ05??>
                                    ${DataDicUtil.getPoint(EB02CH.EB02CJ05)!}
                                <#else >
                                </#if>
                             </td>
                        </tr>
                        </#list>
                    </table>
            
            
            
            
           <h2>基本信息</h2>
           <table class="mainTable">
           <tr>
                <td class="titletd" colspan="4">
                    <li>基本概况信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经济类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6122", map.ECA.EC010D01)!}</td>
                <td class="labeltd">组织机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6121", map.ECA.EC010D02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">企业规模</td>
                <td class="datatd">${DataDicUtil.getDataDic("6067", map.ECA.EC010D03)!}</td>
                <td class="labeltd">所属行业</td>
                <td class="datatd">${DataDicUtil.getDataDic("6064", map.ECA.EC010D04)!}</td>
            </tr>

            <tr>
                
                <td class="labeltd">成立年份</td>
                <td class="datatd">${map.ECA.EC010R01!}</td>
                 <td class="labeltd">登记证书有效截止日期</td>
                <td class="datatd">${map.ECA.EC010R02!}</td>
            </tr>
            <tr>
				<td class="labeltd">登记地址</td>
                <td class="datatd" colspan="3">${map.ECA.EC010Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">办公/经营地址</td>
                <td class="datatd" colspan="3">${map.ECA.EC010Q02!}</td>
            </tr>
            <tr>
                <td class="labeltd">存续状态</td>
                <td class="datatd" colspan="3">${DataDicUtil.getDataDic("6068", map.ECA.EC010D05)!}</td>
            </tr>
            </table><br>
             <table>
           		 <tr>
             	   <td class="titletd" colspan="6">
                    <li>注册资本及主要出资人信息单元</li>
               	   </td>
                   <td class="titletd" colspan="6"> 
              		   注册资本折人民币合计 ${DataDicUtil.getPoint(map.ECA.EC020J01)!} 元
                   </td>
             	 </tr>
 			 </table>
 			 
 			  <table class="mainTable">
                        <tr>
                            <td colspan="6" class="table-head-td">注册资本及主要出资人信息</td>
                        </tr>
                        <tr>
                            <td class="labeltd">出资人类型</td>
                            <td class="labeltd">出资人名称</td>
                            <td class="labeltd">出资人身份标识类型</td>
                            <td class="labeltd">出资人身份标识号码</td>
                            <td class="labeltd">出资比例</td>
                        </tr>
                    
                       <#list map.EC020H! as EC020H>
                        <tr>
                            <td class="datatd">${DataDicUtil.getDataDic("6069", EC020H.EC020D01)!}</td>
                            
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
          
        <!--    <tr>
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
  			<table>
           	   <tr>
             	   <td class="titletd" colspan="6">
              	      <li>上级机构信息单元</li>
             	   </td>
           	   </tr>
           	 </table>
           	 <table class="mainTable">
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
                	 	<#else>
                	 	</#if>
                	 </td>
                	 <td class="datatd">${ECAList.EC040I01!}</td>
                	 <td class="datatd">
                	 	<#if ECAList.EC040R01??>
                	 	${ECAList.EC040R01!}
                	 	<#else>
                	 	</#if>
                	 </td>
            	 </tr>
            	 </#list>
  			 </table><br>


			 <table>
				<tr>
               		 <td class="titletd" colspan="4">
                   		 <li>实际控制人信息单元</li>
                	</td>
           		</tr>
 			 </table>
			 <table class="mainTable">
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
                         	<#else>
                         	</#if>
                         </td>
                   </tr>
                  </#list>
               </table><br>
               
     <h2>	信贷记录明细</h2>          
        
       		 <table>
           	    <tr>
             	   <td class="titletd-2" colspan="8">
              	      <li>被追偿记录</li>       
              	      		总计共${map.ED01_51Size?size!}笔，共${map.ED01_51List?size!}条记录
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
               		<#list map.ED01_51! as ED01_51>
               		<tr>
               			<td class="datatd" rowspan="2">${ED01_51.ED01AI01!}</td>
               			<td class="datatd">${ED01_51.ED01AI02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6043",ED01_51.ED01AD05)!}</td>
               			<td class="datatd">${ED01_51.ED01AR01!}</td>
               			<td class="datatd">${ED01_51.ED01AD07!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_51.ED01AJ01)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_51.ED01BJ01)!}</td>
               			<td class="datatd" rowspan="2">${ED01_51.ED01AR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">
               					${ ED01_51.ED01AR03!}
               			</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_51.ED01BD01)!}</td>
               			<td class="datatd">${ED01_51.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_51.ED01BJ02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_51.ED01BD02)!}</td>
               			<td class="datatd"><a url=''   name ='${ED01_51.ED01AI01!}'>查看</a></td>
               		</tr>
               		</#list>
               		<#if (map.ED01_51List?size>1)>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
	            	</#if>
                </table><br>
                
               <table>
           	    	<tr>
             	   		<td class="titletd-2" colspan="6">
              	      		<li>未结清信贷</li>
             	   		</td>
           	    	 </tr>
           		 </table>
             
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="6">
              	      		 欠息 
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 总计共${map.ED03List?size!}笔，共${map.ED03List?size!}条记录
             	   		</td>
           	    	 </tr>
           	    	    <tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
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
               		<#list map.ED03! as ED03>               		
               		<tr>
               			<td class="datatd">${ED03.ED030I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6103",ED03.ED030D03)!}</td>
						<td class="datatd">${ED03.ED030D02!}</td>
						<td class="datatd">${DataDicUtil.getPoint(ED03.ED030J01)!}</td>
						<td class="datatd">${ED03.ED030R01!}</td>
						<td class="datatd">${ED03.ED030R02!}</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
			   
			   
               
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 中长期借款
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 总计共${map.ED01_1_23Size?size!}笔，共${map.ED01_1_23List?size!}条记录
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
               		<#list map.ED01_1_23! as ED01_1_23>               		
               		<tr>
               			<td class="datatd" rowspan="3">${ED01_1_23.ED01AI01!}</td>
               			<td class="datatd">${ED01_1_23.ED01AI02!}</td>
               			<#if ED01_1_23.ED01AD05??>
               			<#if (ED01_1_23.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_23.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_23.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_23.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_23.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_23.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_23.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_23.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_23.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_23.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${ED01_1_23.ED01AR01!}</td>
               			<td class="datatd">${ED01_1_23.ED01AR02!}</td>
               			<td class="datatd">${ED01_1_23.ED01AD07!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_23.ED01AJ01)!}</td>
               			<td class="datatd">${ED01_1_23.ED01AD10!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6096",ED01_1_23.ED01AD08)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_23.ED01BJ01)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_1_23.ED01BD01)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_23.ED01BJ04)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_23.ED01BJ05)!}</td>
               			<td class="datatd">${ED01_1_23.ED01BS02!}</td>
               			<td class="datatd">${ED01_1_23.ED01BR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_23.ED01BJ02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_1_23.ED01BD02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6102",ED01_1_23.ED01CD01)!}</td>
               			<td class="datatd">
               				<#if ED01_1_23.ED01AI03??>
               				${ED01_1_23.ED01AI03!}
               				<#else>
               				</#if>
               			</td>
               			<td class="datatd">查看</td>
               			<td class="datatd" colspan="2">
	               			<#if ED01_1_23.ED01BR01??>
	               			${ED01_1_23.ED01BR01!}
	               			<#else >
	               			</#if>
               			</td>
               		</tr>
               		</#list>
               		<#if (map.ED01_1_23Size?size>1) >
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
	            	</#if>
               </table><br>
               
              
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 短期借款
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		总计 共${map.ED01_1_1Size?size!}笔，共${map.ED01_1_1List?size!}条记录
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
               		<#list map.ED01_1_1! as ED01_1_1>
               		<tr>
               			<td class="datatd" rowspan="3">${ED01_1_1.ED01AI01!}</td>
               			<td class="datatd">${ED01_1_1.ED01AI02!}</td>
               			<#if ED01_1_1.ED01AD05??>
               			<#if (ED01_1_1.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_1.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_1.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${ED01_1_1.ED01AR01!}</td>
               			<td class="datatd">${ED01_1_1.ED01AR02!}</td>
               			<td class="datatd">${ED01_1_1.ED01AD07!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_1.ED01AJ01)!}</td>
               			<td class="datatd">${ED01_1_1.ED01AD10!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6096",ED01_1_1.ED01AD08)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_1.ED01BJ01)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_1_1.ED01BD01)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_1.ED01BJ04)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_1.ED01BJ05)!}</td>
               			<td class="datatd">${ED01_1_1.ED01BS02!}</td>
               			<td class="datatd">${ED01_1_1.ED01BR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_1.ED01BJ02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_1_1.ED01BD02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6102",ED01_1_1.ED01CD01)!}</td>
               			<td class="datatd">
               				<#if ED01_1_1.ED01AI03??>
               				${ED01_1_1.ED01AI03!}
               				<#else>
               				</#if>
               			</td>
               			<td class="datatd">查看</td>
               			<td class="datatd" colspan="2">${ED01_1_1.ED01BR01!}</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               		
               </table><br>
			   
			   
               
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 循环透支
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		总计 共${map.ED01_1_R1Size?size!}笔，共${map.ED01_1_R1List?size!}条记录
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
               		<#list map.ED01_1_R1! as ED01_1_R1>
               		<tr>
               			<td class="datatd" rowspan="3">${ED01_1_R1.ED01AI01!}</td>
               			<td class="datatd">${ED01_1_R1.ED01AI02!}</td>
               			<#if ED01_1_R1.ED01AD05??>
               			<#if (ED01_1_R1.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_R1.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_R1.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_R1.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_R1.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_R1.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_R1.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_R1.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_1_R1.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_1_R1.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${ED01_1_R1.ED01AR01!}</td>
               			<td class="datatd">${ED01_1_R1.ED01AR02!}</td>
               			<td class="datatd">${ED01_1_R1.ED01AD07!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_R1.ED01AJ01)!}</td>
               			<td class="datatd">${ED01_1_R1.ED01AD10!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getDataDic("6096",ED01_1_R1.ED01AD08)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_R1.ED01BJ01)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_1_R1.ED01BD01)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_R1.ED01BJ04)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_R1.ED01BJ05)!}</td>
               			<td class="datatd">${ED01_1_R1.ED01BS02!}</td>
               			<td class="datatd">${ED01_1_R1.ED01BR04!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_1_R1.ED01BJ02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_1_R1.ED01BD02)!}</td>
               			<td class="datatd">${ED01_1_R1.ED01BS03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6102",ED01_1_R1.ED01CD01)!}</td>
               			<td class="datatd">${ED01_1_R1.ED01AI03!}</td>
               			<td class="datatd">查看</td>
               			<td class="datatd">${ED01_1_R1.ED01BR01!}</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
			   
			   
              
                 <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="7">
              	      		贴现 
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 总计共${map.ED02List?size!}笔，共${map.ED02List?size!}条记录
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
						<td class="datatd">${DataDicUtil.getPoint(ED02.ED020J01)!}</td>
						<td class="datatd">${DataDicUtil.getPoint(ED02.ED020J02)!}</td>
						<td class="datatd">${DataDicUtil.getPoint(ED02.ED020J03)!}</td>
               		</tr>
  					</#list>
  					<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
			   
			   
              
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="9">
              	      		银行承兑汇票和信用证
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		总计 共${map.ED05_51_61List1?size!}笔，共${map.ED05_51_61List1?size!}条记录
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
               		<#list map.ED05_51_61List1! as ED05>
               		<tr>
               			<td class="datatd">${ED05.ED050I02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6095",ED05.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05.ED050D03)!}</td>
               			<td class="datatd">${ED05.ED050S01!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED05.ED050J02)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED05.ED050J03)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED05.ED050J04)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED05.ED050J05)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED05.ED050J01)!}</td>
               		</tr>
  					</#list>
  					<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
              
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="9">
              	      		银行保函及其他业务
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		总计 共${map.ED05_51_otherList?size!}笔，共${map.ED05_51_otherList?size!}条记录
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
               			<td class="datatd">${DataDicUtil.getPoint(ED05.ED050J01)!}</td>
               		 </tr>	
               		 </#list>
               		 <tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
                </table><br>
                
                
                 <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="7">
              	      		授信信息
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		总计 共${map.EDCList1?size!}笔，共${map.EDCList?size!}条记录
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
               		<#list map.EDCList1! as EDC>
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
               			<td class="datatd">${DataDicUtil.getPoint(EDC.ED060J01)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(EDC.ED060J04)!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(EDC.ED060J03)!}</td>
               			<td class="datatd">${EDC.ED060I03!}</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
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
             	   		<td class="titletd-3" colspan="6">
              	      		 总计共${map.ED01_2_23Size?size!}笔，共${map.ED01_2_23List?size!}条记录
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
               		<#list map.ED01_2_23! as ED01_2_23>
               		<tr>
               			<td class="datatd" rowspan="2">${ED01_2_23.ED01AI01!}</td>
               			<td class="datatd">${ED01_2_23.ED01AI02!}</td>
               			<#if ED01_2_23.ED01AD05?? >
               			<#if (ED01_2_23.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_23.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_23.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_23.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_23.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_23.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_23.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_23.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_2_23.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_23.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_2_23.ED01AD06)!}</td>
               			</#if></#if>
               			<td class="datatd">${ED01_2_23.ED01AI02!}</td>
               			<td class="datatd">${ED01_2_23.ED01AR02!}</td>
               			<td class="datatd">${ED01_2_23.ED01AD07!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_2_23.ED01AJ01)!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_2_23.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_2_23.ED01BD01)!}</td>
               			<td class="datatd">${ED01_2_23.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_2_23.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
               
              
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 短期借款
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 总计共${map.ED01_2_1Size?size!}笔，共${map.ED01_2_1List?size!}条记录
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
               		<#list map.ED01_2_1! as ED01_2_1>
               		<tr>
               			<td class="datatd" rowspan="2">${ED01_2_1.ED01AI01!}</td>
               			<td class="datatd">${ED01_2_1.ED01AI02!}</td>
               			<#if (ED01_2_1.ED01AD05??) >
               			<#if (ED01_2_1.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_1.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_1.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_1.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_1.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_1.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_1.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_1.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_1.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_2_1.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${ED01_2_1.ED01AI02!}</td>
               			<td class="datatd">${ED01_2_1.ED01AR02!}</td>
               			<td class="datatd">${ED01_2_1.ED01AD07!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_2_1.ED01AJ01)!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_2_1.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_2_1.ED01BD01)!}</td>
               			<td class="datatd">${ED01_2_1.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_2_1.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
               
               
               
              
                <table>
           	    	<tr>
           	    		<td class="titletd-3" colspan="6">
              	      		 循环透支
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 总计共${map.ED01_2_R1Size?size!}笔，共${map.ED01_2_R1List?size!}条记录
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
               		<#list map.ED01_2_R1! as ED01_2_R1>
               		<tr>
               			<td class="datatd" rowspan="2">${ED01_2_R1.ED01AI01!}</td>
               			<td class="datatd">${ED01_2_R1.ED01AI02!}</td>
               			<#if (ED01_2_R1.ED01AD05??) >
               			<#if (ED01_2_R1.ED01AD05=='10') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6084",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_R1.ED01AD05=='11') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6085",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_R1.ED01AD05=='12') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6086",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_R1.ED01AD05=='13') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6087",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_R1.ED01AD05=='14') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6088",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_R1.ED01AD05=='15') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6089",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_R1.ED01AD05=='16') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6090",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_R1.ED01AD05=='21') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			<#if (ED01_2_R1.ED01AD05=='31') >
               				<td class="datatd"> ${DataDicUtil.getDataDic("6092",ED01_2_R1.ED01AD06)!}</td>
               			</#if>
               			</#if>
               			<td class="datatd">${ED01_2_R1.ED01AI02!}</td>
               			<td class="datatd">${ED01_2_R1.ED01AR02!}</td>
               			<td class="datatd">${ED01_2_R1.ED01AD07!}</td>
               			<td class="datatd">${DataDicUtil.getPoint(ED01_2_R1.ED01AJ01)!}</td>
               		</tr>
               		<tr>
               			<td class="datatd">${ED01_2_R1.ED01AR03!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED01_2_R1.ED01BD01)!}</td>
               			<td class="datatd">${ED01_2_R1.ED01BR04!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6101",ED01_2_R1.ED01BD02)!}</td>
               			<td class="datatd" colspan="2">查看</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
               
               
                 <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="7">
              	      		贴现 
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		总计 共${map.ED02List1?size!}笔，共${map.ED02List1?size!}条记录
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
               		<#list map.ED02List1! as ED02>
               		<tr>
               			<td class="datatd">${ED02.ED020I02!}</td>
               			<td class="datatd"> ${DataDicUtil.getDataDic("6091",ED02.ED020D02)!}</td>
						<td class="datatd">${DataDicUtil.getDataDic("6032",ED02.ED020D03)!}</td>
               			<td class="datatd">${ED02.ED020S02!}</td>
						<td class="datatd">${DataDicUtil.getPoint(ED02.ED020J04)!}</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
               
               
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="5">
              	      		银行承兑汇票和信用证
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		总计 共${map.ED05_51_61List2?size!}笔，共${map.ED05_51_61List2?size!}条记录
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
               		<#list map.ED05_51_61List2! as ED05>
               		<tr>
           	    	 	<td class="datatd">${ED05.ED050I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6095",ED05.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05.ED050D03)!}</td>
               			<td class="datatd">${ED05.ED050S02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6075",ED05.ED050D04)!}</td>
               		 </tr>
               		 </#list>
               		 <tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
               </table><br>
               
               
                <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="5">
              	      		银行保函及其他业务
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 总计共${map.ED05_51_otherList1?size!}笔，共${map.ED05_51_otherList1?size!}条记录
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
               		<#list map.ED05_51_otherList1! as ED05>
               		<tr>
           	    	 	<td class="datatd">${ED05.ED050I02!}</td>
           	    	 	<td class="datatd">${DataDicUtil.getDataDic("6095",ED05.ED050D02)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",ED05.ED050D03)!}</td>
               			<td class="datatd">${ED05.ED050S02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6075",ED05.ED050D04)!}</td>
               		 </tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
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
             		<td class="titletd-5" >
                   		*为其他借款人承担的相关还款责任
               		</td>
             	</tr>
           	    	<tr>
             	   		<td class="titletd-3" colspan="10">
              	      		除贴现外的其他业务
             	   		</td>
             	   		<td class="titletd-3">总计共 ${map.EDD_1?size!} 笔 ，共${map.EDD_1?size!}条记录   </td>
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
                          ${DataDicUtil.getPoint(EDD.ED070J01)!}
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
                         		${DataDicUtil.getPoint(EDD.ED070J05)!}
                    		 <#else >
                     		</#if>
               			</td>
               			<td class="datatd">
                  			<#if EDD.ED070J02??>
                         		${DataDicUtil.getPoint(EDD.ED070J02)!}
                    		 <#else >
                     		</#if>
               			</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",EDD.ED070D08)!}</td>
               			<td class="datatd">
                    		 <#if EDD.ED070J03??>
                        		 ${DataDicUtil.getPoint(EDD.ED070J03)!}
                     		<#else >
                     		</#if>
                		</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6026",EDD.ED070D09)!}</td>
               			<td class="datatd">${EDD.ED070S01!}</td>
               			<td class="datatd">${EDD.ED070S02!}</td>
               			<td class="datatd" colspan='2'>${EDD.ED070R03!}</td>
               		</tr>
               		 </#list>
               		 <tr>
		                <td class="titletd-4" colspan="10">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
                </table><br>         
                
                    <table>
           	    	<tr>
             	   		<td class="titletd-3" colspan="9">
              	      		贴现
             	   		</td>
             	   		<td class="titletd-3">总计共 ${map.EDD_2?size!}笔，共${map.EDD_2?size!}条记录    </td>
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
                          		${DataDicUtil.getPoint(EDD.ED080J01)!}
                      		<#else >
                      		</#if>
                		</td>
                		<td class="datatd">${EDD.ED080I02!}</td>
                		<td class="datatd">${DataDicUtil.getDataDic("6091",EDD.ED080D03)!}</td>
                		<td class="datatd">${DataDicUtil.getDataDic("6032",EDD.ED080D04)!}</td>
                		<td class="datatd">${EDD.ED080S01!}</td>
                		<td class="datatd">
                 			<#if EDD.ED080J05??>
                      			${DataDicUtil.getPoint(EDD.ED080J05)!}
                  			<#else >
                  			</#if>
                		</td>
                		<td class="datatd">
                   			<#if EDD.ED080J02??>
                       			${DataDicUtil.getPoint(EDD.ED080J02)!}
                   			<#else >
                   			</#if>
                		</td>
                		<td class="datatd">
                   			<#if EDD.ED080J03??>
                       			${DataDicUtil.getPoint(EDD.ED080J03)!}
                   			<#else >
                   			</#if>
               			 </td>
               			 <td class="datatd">
                     		<#if EDD.ED080J04??>
                         		${DataDicUtil.getPoint(EDD.ED080J04)!}
                     		<#else >
                    		 </#if>
                		  </td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="11">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
                </table><br>  
                
                
                
                
                
                  <table>
                  	<tr>
             			<td class="titletd-5"  >
                   			*为担保交易承担的相关还款责任
               			</td>
             		</tr>
           	    	<tr>
             	   		<td class="titletd-3">总计  共 ${map.EDD_3?size!} 笔  ，共${map.EDD_3?size!}条记录</td>
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
                       			${DataDicUtil.getPoint(EDD.ED090J01)!}
                   			<#else >
                   			</#if>
                		</td>
               			<td class="datatd">${EDD.ED090I02!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6095",EDD.ED090D03)!}</td>
               			<td class="datatd">${DataDicUtil.getDataDic("6032",EDD.ED090D04)!}</td>
               			<td class="datatd">${EDD.ED090S01!}</td>
               			<td class="datatd">
                     		<#if EDD.ED100J03??>
                         		${DataDicUtil.getPoint(EDD.ED100J03)!}
                     		<#else >
                     		</#if>
                		</td>
               			<td class="datatd">
                    		<#if EDD.ED090J02??>
                         		${DataDicUtil.getPoint(EDD.ED090J02)!}
                     		<#else >
                     		</#if>
                		</td>
               		</tr>
               		</#list>
               		<tr>
		                <td class="titletd-4" colspan="9">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
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
                        ${DataDicUtil.getPoint(map.EEA.EE01AJ01)!}
                    <#else >
                    </#if>
                </td>
                <td class="datatd">${map.EEA.EE01AR01!}</td>
            </tr>
            <tr>
            	<td class="titletd-4"  colspan="9">
            	(过去24个月缴费情况见 ：弹出内容展示 - （十）非信贷记录)
            	</td>
            </tr>
 		</table>
               
               
    <h2>公共记录明细</h2>
    
    
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
                     				  ${DataDicUtil.getPoint(EFA.EF010J01)!}
                  				 <#else>
                   				</#if>
               			 </td>
               			 <td class="datatd">${EFA.EF010R01!}</td>
                   </tr>
  				 </#list>    
  
               </table><br>
                 

          
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
                        ${DataDicUtil.getPoint(EFB.EF020J01)!}
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
                          ${DataDicUtil.getPoint(EFB.EF030J01)!}
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
                       ${DataDicUtil.getPoint(EFB.EF030J02)!}
                   <#else>
                   </#if>
                </td>
            </tr>
            </#list>
        </table><br>
      
          
               
               
              
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
                      ${DataDicUtil.getPoint(EFC.EF040J01)!}
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
                      ${DataDicUtil.getPoint(map.EFD.EF05AJ02)!}
                  <#else>
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">统计年月</td>
                <td class="datatd" colspan="3">${map.EFD.EF05AR04!}</td>
            </tr>
            <tr>
            	<td class="titletd-4"  colspan="9">
            	(过去24个月缴费情况 见：弹出内容展示 - （十一）公共记录)
            	</td>
            </tr>
          </table>
          
          
          
          
                  
       
          
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_10??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_10)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_10??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_10)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_10??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_10)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_20??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_20)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_20??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_20)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_20??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_20)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_30??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_30)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_30??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_30)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_30??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_30)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_40??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_40)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_40??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_40)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_40??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_40)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_50??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_50)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_50??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_50)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_50??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_50)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_60??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_60)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_60??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_60)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_60??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_60)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_1_70??>
            			<a href=JavaScript:financeServer('fuzha','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_1_70)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_1_2_70??>
            			<a href=JavaScript:financeServer('fuzha','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_2_70)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_1_3_70??>
            			<a href=JavaScript:financeServer('fuzha','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_1_3_70)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_10??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_10)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_10??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_10)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_10??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_10)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_20??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_20)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_20??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_20)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_20??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_20)!}
            			</a>
            		<#else >
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
            		<#else >            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_30??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_30)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_30??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_30)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_30??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_30)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_40??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_40)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_40??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_40)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_40??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_40)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_50??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_50)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_50??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_50)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_50??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_50)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_60??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_60)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_60??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_60)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_60??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_60)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_1_70??>
            			<a href=JavaScript:financeServer('shouru','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_1_70)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_2_2_70??>
            			<a href=JavaScript:financeServer('shouru','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_2_70)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_2_3_70??>
            			<a href=JavaScript:financeServer('shouru','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_2_3_70)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_10??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_10)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_10??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_10)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_10??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_10)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_20??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_20)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_20??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_20)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_20??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_20)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_30??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_30)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_30??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_30)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_30??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_30)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_40??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_40)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_40??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_40)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_40??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_40)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_50??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_50)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_50??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_50)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_50??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_50)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_60??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_60)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_60??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_60)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_60??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_60)!}
            			</a>
            		<#else >
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
            		<#else >
            		</#if>	
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_1_70??>
            			<a href=JavaScript:financeServer('xianjin','${map.year1!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_1_70)!}
            			</a>
            		<#else >
            		</#if>
            	</td>
            	
            	<td class="datatd">
            		<#if map.EGA_3_2_70??>
            			<a href=JavaScript:financeServer('xianjin','${map.year2!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_2_70)!}
            			</a>
            		<#else >
            		</#if>	
            	</td>
            	<td class="datatd">
            		<#if map.EGA_3_3_70??>
            			<a href=JavaScript:financeServer('xianjin','${map.year3!}','${map.uuid!}')>
            				${DataDicUtil.getDataDic("6118", map.EGA_3_3_70)!}
            			</a>
            		<#else >
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
        
       <h1>弹出内容展示</h1> 
       
      <#-- 注释掉报告内容主体内容，和下面的历史信息冲突  add by chensibi -->
     <#--
  	<h2>(一)报告主体内容补充</H2>
  	
   		
   		<table>
           	    <tr>
             	   <td class="titletd" colspan="8">
              	      <li>被追偿记录</li>
             	   </td>
             	   <td colspan="2" class="table-head-td">共${map.ED01_51List?size!}条</td>
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
             	   		<td class="titletd-3" colspan="6">
              	      		 欠息 
             	   		</td>
             	   		<td class="titletd-3" colspan="6">
              	      		 共${map.ED03List?size!}条
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
               </table><br>
   		<table>
			<tr>
             	<td class="titletd-3" colspan="1">
                   	中长期借款
                </td>
                <td colspan="2" class="table-head-td">共${map.ED01_1_23List?size!}条</td>
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
             	   	 <td colspan="2" class="table-head-td">共${map.ED01_1_1List?size!}条</td>
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
             	   		<td colspan="2" class="table-head-td">共${map.ED01_1_R1List?size!}条</td>
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
              	      		 共${map.ED02List?size!}条
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
              	      		 共${map.ED05_51_61List?size!}条
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
              	      		 共${map.ED05_51_otherList?size!}条
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
             	   		<td colspan="2" class="table-head-td">共${map.EDCList?size!}条</td>
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
               		 <tr>
		                <td class="titletd-4" colspan="10">
		                    (更多详情见：历史表现)
		                </td>
	            	</tr>
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
             	   		<td colspan="2" class="table-head-td">共${map.ED01_2_23List?size!}条</td>
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
             	   		<td colspan="2" class="table-head-td">共${map.ED01_2_1List?size!}条</td>
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
             	   		<td colspan="2" class="table-head-td">共${map.ED01_2_R1List?size!}条</td>
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
              	      		 共${map.ED02List?size!}条
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
              	      		 共${map.ED05_51_61List?size!}条
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
              	      		 共${map.ED05_51_otherList?size!}条
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
                --> 
        
  	<h2>(一)被追偿记录的历史表现</H2>
  		
  		<table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_41_51List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_41_51List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_41_51List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_41_51List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_41_51List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_41_51List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_41_51List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_41_51List.ED01BD02)!}</td>
            </tr>	
        	</#list>
        </table>
        <br>
  		
  		<table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_41_51List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_41_51List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_41_51List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BR03!}</td>
            	<td  class="table-data-td">${ED01_1_41_51List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_41_51List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_41_51List.ED01BD02)!}</td>
            </tr>	
        	</#list>
        </table>
        <br>
  		
  		
   
   <h2>(二)中长期借款的历史表现</H2> 
   	    
   	    <table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_1_23List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_23List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_23List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_23List.ED01BJ04)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_23List.ED01BJ05)!}</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_23List.ED01BJ03)!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_23List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_1_23List.ED01BD02)!}</td>
           	</tr>
            <tr>
            	<td>特定交易提示--></td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6102",ED01_1_1_23List.ED01CD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01CR01!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_23List.ED01CJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01CS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_23List.ED01CQ01!}</td>
            </tr>	
        	</#list>
        </table>
        <br>
        
        <table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_2_23List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_23List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_23List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_23List.ED01BJ04)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_23List.ED01BJ05)!}</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_23List.ED01BJ03)!}</td>
            	<td  class="table-data-td">${ED01_1_2_23List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_23List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_23List.ED01BD02)!}</td>
           	</tr>
         	</#list>
         </table>
         <br>
         
    <h2>(三)短期借款的历史表现</H2> 
   	    <table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_1_1List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_1List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_1List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_1List.ED01BJ04)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_1List.ED01BJ05)!}</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_1List.ED01BJ03)!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_1List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_1_1List.ED01BD02)!}</td>
           	</tr>
            <tr>
            	<td>特定交易提示--></td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6102",ED01_1_1_1List.ED01CD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01CR01!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_1List.ED01CJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01CS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_1List.ED01CQ01!}</td>
            </tr>	
        	</#list>
        </table>
        <br>
        
        <table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_2_1List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_1List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_1List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_1List.ED01BJ04)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_1List.ED01BJ05)!}</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_1List.ED01BJ03)!}</td>
            	<td  class="table-data-td">${ED01_1_2_1List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_1List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_1List.ED01BD02)!}</td>
           	</tr>
         	</#list>
         </table>
         <br>
   	    
    <h2>(四)循环透支的历史表现</H2> 
   	    <table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_1_R1List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_R1List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_R1List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_R1List.ED01BJ04)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_R1List.ED01BJ05)!}</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_R1List.ED01BJ03)!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_R1List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_1_R1List.ED01BD02)!}</td>
            	<td colspan="2" class="table-data-td">${ED01_1_1_R1List.ED01BS03!}</td>
           	</tr>
            
            <tr>
            	<td>特定交易提示--></td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6102",ED01_1_1_R1List.ED01CD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01CR01!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_R1List.ED01CJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_R1List.ED01CS02!}</td>
            	<td colspan="2" class="table-data-td">${ED01_1_1_R1List.ED01CQ01!}</td>
            </tr>	
	        </#list>
        </table>
        <br>
        
        <table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED01_1_2_R1List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_R1List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_R1List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_R1List.ED01BJ04)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_R1List.ED01BJ05)!}</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_R1List.ED01BJ03)!}</td>
            	<td  class="table-data-td">${ED01_1_2_R1List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_R1List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_R1List.ED01BD02)!}</td>
            	<td colspan="2" class="table-data-td">${ED01_1_2_R1List.ED01BS03!}</td>
           	</tr>
	        </#list>
         </table>
         <br>
	
	
	<h2>(五)	贴现的信贷明细、历史表现</H2> 
         <table>
			<tr>
				<li>1.未结清</li>
				<td class="titletd" colspan="1">
                   	<li>*信贷明细</li>
                </td>
				<td colspan="2" class="table-head-td">共${map.ED01_1_1_D2List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_D2List.ED01AJ01)!}</td>
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
                   	<td colspan="2" class="table-head-td">共${map.ED01_1_1_D2List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_D2List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_1_D2List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_D2List.ED01BJ04)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_D2List.ED01BJ05)!}</td>
           	</tr>
           	<tr>
           		<td rowspan="2" class="datatd">${DataDicUtil.getDataDic("6091",ED01_1_1_D2List.ED01AD06)!}</td>
           		
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BS02!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BR05!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_D2List.ED01BJ03)!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_D2List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_1_D2List.ED01BD02)!}</td>
           	</tr>
            <tr>
            	<td>特定交易提示--></td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6102",ED01_1_1_D2List.ED01CD01)!}</td>
            	<td  class="table-data-td">${ED01_1_1_D2List.ED01CR01!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_1_D2List.ED01CJ01)!}</td>
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
				<td colspan="2" class="table-head-td">共${map.ED01_1_2_D2List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_D2List.ED01AJ01)!}</td>
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
                <td colspan="2" class="table-head-td">共${map.ED01_1_2_D2List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_D2List.ED01BJ01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR02!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6032",ED01_1_2_D2List.ED01BD01)!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR03!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_D2List.ED01BJ04)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_D2List.ED01BJ05)!}</td>
           	</tr>
           	<tr>
           		<td class="datatd">${DataDicUtil.getDataDic("6091",ED01_1_2_D2List.ED01AD06)!}</td> 
           	
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BS02!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR05!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_D2List.ED01BJ03)!}</td>
            	<td  class="table-data-td">${ED01_1_2_D2List.ED01BR04!}</td>
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED01_1_2_D2List.ED01BJ02)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6101",ED01_1_2_D2List.ED01BD02)!}</td>
           	</tr>
	         </#list>
         </table>
         <br>
 		
 	<h2>(六)银行承兑汇票和信用证的信贷明细</h2>
 		<table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED04_1_51_61List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED04_1_51_61List.ED04AJ01)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6096",ED04_1_51_61List.ED04AD05)!}</td>
           	</tr>
            <tr>
            	<td class="datatd">${DataDicUtil.getDataDic("6032",ED04_1_51_61List.ED04BD02)!}</td>
            
	           	<td  class="table-data-td">${ED04_1_51_61List.ED04AQ01!}</td>
	           	<td  class="table-data-td">${DataDicUtil.getPoint(ED04_1_51_61List.ED04BJ01)!}</td>
	           	<td  class="table-data-td">${DataDicUtil.getPoint(ED04_1_51_61List.ED04BJ02)!}</td>
	           	<td  class="table-data-td">${ED04_1_51_61List.ED04AI03!}</td>
	           	<td  class="table-data-td">${ED04_1_51_61List.ED04BR01!}</td>
	        </tr>
	 		</#list>
 		</table>
 		<br>
 		
 		<table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED04_2_51_61List?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED04_2_51_61List.ED04AJ01)!}</td>
            	<td class="table-data-td">${ED04_2_51_61List.ED04BR02!}</td>
            	<td class="table-data-td">${DataDicUtil.getDataDic("6075",ED04_2_51_61List.ED04BD03)!}</td>
           	</tr>
	 		</#list>
 		</table>
 		<br>
 		
 	<h2>(七)银行保函及其他业务的信贷明细</h2>
 		<table>
			<tr>
				<li>1.未结清</li>
				<td colspan="2" class="table-head-td">共${map.ED04_1_51_61otherList?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED04_1_51_61otherList.ED04AJ01)!}</td>
            	<td  class="table-data-td">${DataDicUtil.getDataDic("6096",ED04_1_51_61otherList.ED04AD05)!}</td>
           	</tr>
            <tr>
            	<td class="datatd">${DataDicUtil.getDataDic("6032",ED04_1_51_61otherList.ED04BD02)!}</td>
            
	           	<td  class="table-data-td">${ED04_1_51_61otherList.ED04AQ01!}</td>
	           	<td  class="table-data-td">${DataDicUtil.getPoint(ED04_1_51_61otherList.ED04BJ01)!}</td>
	           	<td  class="table-data-td">${DataDicUtil.getPoint(ED04_1_51_61otherList.ED04BJ02)!}</td>
	           	<td colspan="2" class="table-data-td">${ED04_1_51_61otherList.ED04BR01!}</td>
	        </tr>
	 		</#list>
 		</table>
 		<br>
 		
 		<table>
			<tr>
				<li>2.已结清</li>
				<td colspan="2" class="table-head-td">共${map.ED04_2_51_61otherList?size!}条</td>
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
            	<td  class="table-data-td">${DataDicUtil.getPoint(ED04_2_51_61otherList.ED04AJ01)!}</td>
            	<td class="table-data-td">${ED04_2_51_61otherList.ED04BR02!}</td>
            	<td class="table-data-td">${DataDicUtil.getDataDic("6075",ED04_2_51_61otherList.ED04BD03)!}</td>
           	</tr>
	 		</#list>
 		</table>
 		<br>
 		
 		
 	<h2>(八)非信贷记录</h2>
 		<table class="mainTable">
           	<tr>
             	<td class="titletd" >
                   	*公共事业历史缴费记录明细
                </td>
           	</tr><br>
         </table>
         <table class="mainTable">
           	<tr>
           		<td  class="labeltd">公用事业单位名称:</td> 
            	<td class="datatd">${map.EEA.EE01AQ01!}</td>    
            	<td  class="labeltd">业务类型：</td> 
            	<td class="datatd">${DataDicUtil.getDataDic("6105",map.EEA.EE01AD01)!}</td>
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
                                   ${DataDicUtil.getPoint(EE01BH.EE01BJ01)!}
                               <#else>
                               </#if>
                            </td>
                            <td class="datatd">
                              <#if EE01BH.EE01BJ02??>
                                  ${DataDicUtil.getPoint(EE01BH.EE01BJ02)!}
                              <#else>
                              </#if>
                            </td>
                            <td class="datatd">
                              <#if EE01BH.EE01BJ03??>
                                  ${DataDicUtil.getPoint(EE01BH.EE01BJ03)!}
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
 		
        
        <h2>(九)公共记录</h2>
        
          <table class="mainTable">
            <tr>
             	<td class="titletd" >
                   	*住房公积金历史缴费记录明细
                </td>
           	</tr><br>
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
                                     ${DataDicUtil.getPoint(EF05BH.EF05BJ01)!}
                                 <#else >
                                 </#if>
                            </td>
                            <td class="datatd">
                               <#if EF05BH.EF05BJ02??>
                                   ${DataDicUtil.getPoint(EF05BH.EF05BJ02)!}
                               <#else >
                               </#if>
                            </td>
                            <td class="datatd">
                                <#if EF05BH.EF05BJ03??>
                                    ${DataDicUtil.getPoint(EF05BH.EF05BJ03)!}
                                <#else >
                                </#if>
                            </td>
                        </tr>
                        </#list>
                          <#else >
                                </#if>
                    </table><br>
        
        
        
        
        
        
        
        
        
       
           
 
  
    <fieldset>
        <h2><legend align="center">(十)财务报表</legend></h2>
        
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
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ01)!}
                  <#else >
                  </#if>
                </td>
				<td class="labeltd">短期借款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ45??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ45)!}
                   <#else >
                   </#if>
                </td>     
            </tr>
			<tr>
			 <td class="labeltd">短期投资</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ02??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ02)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">应付票据</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ46??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ46)!}
                   <#else >
                   </#if>
                </td>
			 </tr>	
            <tr>
                <td class="labeltd">应收票据</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ03??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ03)!}
                   <#else >
                   </#if>
                </td>
				 <td class="labeltd">应付账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ47??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ47)!}
                   <#else >
                   </#if>
                </td>    
            </tr>
            <tr>
			 <td class="labeltd">应收股利</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ04??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ04)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">预收账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ48??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ48)!}
                   <#else >
                   </#if>
                </td>
			</tr>	
			<tr>
                <td class="labeltd">应收利息</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ05??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ05)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">应付工资</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ49??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ49)!}
                   <#else >
                   </#if>
                </td>
			</tr>
			<tr>
                <td class="labeltd">应收账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ06??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ06)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">应付福利费</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ50??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ50)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他应收款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ07??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ07)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">应付利润</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ51??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ51)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">预付账款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ08??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ08)!}
                  <#else >
                  </#if>
                </td>
				<td class="labeltd">应交税金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ52??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ52)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">期货保证金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ09??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ09)!}
                   <#else >
                   </#if>
                </td>
				 <td class="labeltd">其他应交款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ53??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ53)!}
                   <#else >
                   </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">应收补贴款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ10??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ10)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">其他应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ54??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ54)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收出口退税</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ11??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ11)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">预提费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ55??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ55)!}
                   <#else >
                   </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">存货</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ12??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ12)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">预计负债</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ56??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ56)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">存货原材料</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ13??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ13)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">一年内到期的长期负债</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ57??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ57)!}
                   <#else >
                   </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">存货产成品</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ14??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ14)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">其他流动负债</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ58??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ58)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待摊费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ15??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ15)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">流动负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ59??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ59)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">待处理流动资产净损失</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ16??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ16)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">长期借款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ60??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ60)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">一年内到期的长期债权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ17??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ17)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">应付债券</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ61??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ61)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">其他流动资产</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ18??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ18)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">长期应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ62??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ62)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">流动资产合计</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ19??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ19)!}
                    <#else >
                    </#if>
                </td>
				 <td class="labeltd">专项应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ63??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ63)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">长期投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ20??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ20)!}
                    <#else >
                    </#if>
                </td>
				 <td class="labeltd">其他长期负债</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ64??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ64)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期股权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ21??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ21)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">（其他长期负债科目下）特准储备基金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ65??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ65)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">长期债权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ22??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ22)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">长期负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ66??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ66)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">合并价差</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ23??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ23)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">递延税款贷项</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ67??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ67)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">长期投资合计</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ24??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ24)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ68??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ68)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产原价</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ25??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ25)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">少数股东权益</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ69??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ69)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">累计折旧</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ26??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ26)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">实收资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ70??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ70)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产净值</td>
                <td class="datatd-number">
                     <#if map.EGA.EG01BJ27??>
                         ${DataDicUtil.getPoint(map.EGA.EG01BJ27)!}
                     <#else >
                     </#if>
                </td>
				<td class="labeltd">国家资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ71??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ71)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">固定资产值减值准备</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ28??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ28)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">集体资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ72??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ72)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产净额</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ29??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ29)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ73??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ73)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">固定资产清理</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ30??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ30)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">（法人资本科目下）国有法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ74??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ74)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">工程物资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ31??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ31)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">（法人资本科目下）集体法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ75??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ75)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">在建工程</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ32??>
                        ${DataDicUtil.getPoint(map.EGA.EG01BJ32)!}
                    <#else >
                    </#if>
                </td>
				<td class="labeltd">个人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ76??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ76)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待处理固定资产净损失</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ33??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ33)!}
                   <#else >
                   </#if>
                </td>
				 <td class="labeltd">外商资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ77??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ77)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">固定资产合计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ34??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ34)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">资本公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ78??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ78)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">无形资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ35??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ35)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">盈余公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ79??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ79)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">（无形资产科目下）土地使用权</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ36??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ36)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">（盈余公积科目下）法定盈余公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ80??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ80)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ37??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ37)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">（盈余公积科目下）公益金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ81??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ81)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">（递延资产科目下）固定资产修理</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ38??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ38)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">（盈余公积科目下）补充流动资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ82??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ82)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（递延资产科目下）固定资产改良支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ39??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ39)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">未确认的投资损失</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ83??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ83)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">其他长期资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ40??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ40)!}
                   <#else >
                   </#if>
                </td>
				<td class="labeltd">未分配利润</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ84??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ84)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（其他长期资产科目下）特准储备物资</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ41??>
                     ${DataDicUtil.getPoint(map.EGA.EG01BJ41)!}
                 <#else >
                 </#if>
                </td>
				<td class="labeltd">外币报表折算差额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ85??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ85)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">无形及其他资产合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ42??>
                     ${DataDicUtil.getPoint(map.EGA.EG01BJ42)!}
                 <#else >
                 </#if>
                </td>
				<td class="labeltd">所有者权益合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ86??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ86)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延税款借项</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ43??>
                     ${DataDicUtil.getPoint(map.EGA.EG01BJ43)!}
                 <#else >
                 </#if>
                </td>
				<td class="labeltd">负债和所有者权益总计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ87??>
                      ${DataDicUtil.getPoint(map.EGA.EG01BJ87)!}
                  <#else >
                  </#if>
                </td>
			</tr>
			<tr>	
                <td class="labeltd">资产总计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ44??>
                       ${DataDicUtil.getPoint(map.EGA.EG01BJ44)!}
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
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ01)!}
                 <#else >
                 </#if>
                </td>
				 <td class="labeltd">短期借款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ32??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ32)!}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>  
                <td class="labeltd">交易性金融资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ02??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ02)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">交易性金融负债</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ33??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ33)!}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收票据</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ03??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ03)!}
                 <#else >
                 </#if>
                </td>
				 <td class="labeltd">应付票据</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ34??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ34)!}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>   
                <td class="labeltd">应收账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ04??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ04)!}
                <#else >
                </#if>
                </td>
			 <td class="labeltd">应付账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ35??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ35)!}
                <#else >
                </#if>
                </td>
            </tr>   
            <tr>
                <td class="labeltd">预付账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ05??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ05)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">预收账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ36??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ36)!}
                 <#else >
                 </#if>
            </tr>   
            <tr>   
                </td>
                <td class="labeltd">应收利息</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ06??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ06)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应付利息</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ37??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ37)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收股利</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ07??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ07)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应付职工薪酬</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ38??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ38)!}
                 <#else >
                 </#if>
                </td>
			 </tr>   
            <tr>	
                <td class="labeltd">其他应收款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ08??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ08)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应交税费</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ39??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ39)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">存货</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ09??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ09)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应付股利</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ40??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ40)!}
                 <#else >
                 </#if>
                </td>
            </tr>   
            <tr>  
                <td class="labeltd">一年内到期的非流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ10??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ10)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">其他应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ41??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ41)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ11??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ11)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">一年内到期的非流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ42??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ42)!}
                 <#else >
                 </#if>
                </td>
             </tr>   
            <tr>   
                <td class="labeltd">流动资产合计</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ12??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ12)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">其他流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ43??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ43)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">可供出售的金融资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ13??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ13)!}
                <#else >
                </#if>
                </td>
				 <td class="labeltd">流动负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ44??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ44)!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>  
                <td class="labeltd">持有至到期投资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ14??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ14)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">长期借款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ45??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ45)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期股权投资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ15??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ15)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">应付债券</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ46??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ46)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd">长期应收款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ16??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ16)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">长期应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ47??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ47)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资性房地产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ17??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ17)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">专项应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ48??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ48)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd">固定资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ18??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ18)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">预计负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ49??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ49)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">在建工程</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ19??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ19)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">递延所得税负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ50??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ50)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd">工程物资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ20??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ20)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">其他非流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ51??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ51)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产清理</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ21??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ21)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">非流动负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ52??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ52)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd">生产性生物资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ22??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ22)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ53??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ53)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">油气资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ23??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ23)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">实收资本（或股本）</td>
                <td class="datatd-number">
                  <#if map.EGA.EG02BJ54??>
                      ${DataDicUtil.getPoint(map.EGA.EG02BJ54)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd">无形资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ24??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ24)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">资本公积</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ55??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ55)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">开发支出</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ25??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ25)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">减：库存股</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ56??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ56)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd">商誉</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ26??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ26)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">盈余公积</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ57??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ57)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期待摊费用</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ27??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ27)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">未分配利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ58??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ58)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>  
                <td class="labeltd">递延所得税资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ28??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ28)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">所有者权益合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ59??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ59)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他非流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ29??>
                    ${DataDicUtil.getPoint(map.EGA.EG02BJ29)!}
                <#else >
                </#if>
                </td>
				<td class="labeltd">负债和所有者权益合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ60??>
                     ${DataDicUtil.getPoint(map.EGA.EG02BJ60)!}
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
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ01)!}
                  <#else >
                  </#if>
                </td>
                </tr>
            <tr>
                <td class="labeltd" colspan="2">（主营业务收入科目下）出口产品销售收入</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ02??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ02)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（主营业务收入科目下）进口产品销售收入</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ03??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ03)!}
                  <#else >
                  </#if>
                </td>
                </tr>
            <tr>
                <td class="labeltd" colspan="2">销售折扣与折让</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ04??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ04)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">主营业务收入净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ05??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ05)!}
                  <#else >
                  </#if>
                </td>
                </tr>
            <tr>
                <td class="labeltd" colspan="2">主营业务成本</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ06??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ06)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">主营业务成本科目下）出口产品销售成本</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ07??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ07)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">主营业务税金及附加</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ08??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ08)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营费用</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ09??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ09)!}
                  <#else >
                  </#if>
                </td>
                </tr>
            <tr>
                <td class="labeltd" colspan="2">其他（业务成本）</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ10??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ10)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">递延收益</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG03BJ11??>
                      ${DataDicUtil.getPoint(map.EGA.EG03BJ11)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">代购代销收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ12??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ12)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他（收入）</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ13??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ13)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">主营业务利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ14??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ14)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他业务利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ15??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ15)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">营业费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ16??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ16)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">管理费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ17??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ17)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">财务费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ18??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ18)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他（费用）</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ19??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ19)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">营业利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ20??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ20)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ21??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ21)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">期货收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ22??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ22)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">补贴收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ23??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ23)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">（补贴收入科目下）补贴前亏损的企业补贴收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ24??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ24)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业外收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ25??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ25)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">（营业外收入科目下）处置固定资产净收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ26??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ26)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（营业外收入科目下）非货币性交易收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ27??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ27)!}
                 <#else>
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">（营业外收入科目下）出售无形资产收益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ28??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ28)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（营业外收入科目下）罚款净收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ29??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ29)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">其他（利润）</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ30??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ30)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（其他科目下）用以前年度含量工资节余弥补利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ31??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ31)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">营业外支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ32??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ32)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（营业外支出科目下）处置固定资产净损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ33??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ33)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">（营业外支出科目下）债务重组损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ34??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ34)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（营业外支出科目下）罚款支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ35??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ35)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">（营业外支出科目下）捐赠支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ36??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ36)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ37??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ37)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">（其他支出）结转的含量工资包干节余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ38??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ38)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">利润总额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ39??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ39)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">所得税</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ40??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ40)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">少数股东损益</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ41??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ41)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">未确认的投资损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ42??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ42)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">净利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ43??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ43)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">年初未分配利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ44??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ44)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">盈余公积补亏</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ45??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ45)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">其他调整因素</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ46??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ46)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">可供分配的利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ47??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ47)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">单项留用的利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ48??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ48)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">补充流动资本</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ49??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ49)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">提取法定盈余公积</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ50??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ50)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">提取法定公益金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ51??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ51)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">提取职工奖励及福利基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ52??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ52)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">提取储备基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ53??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ53)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">提取企业发展基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ54??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ54)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">利润归还投资</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ55??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ55)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">（可供分配的利润科目下）其他</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ56??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ56)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">可供投资者分配的利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ57??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ57)!}
                 <#else >
                 </#if>
                </td>
           </tr>
            <tr>     
                <td class="labeltd" colspan="2">应付优先股股利</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ58??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ58)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">提取任意盈余公积</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ59??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ59)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">应付普通股股利</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ60??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ60)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">转作资本的普通股股利</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ61??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ61)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">（可供投资者分配的利润科目下）其他</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ62??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ62)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">未分配利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ63??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ63)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">（未分配利润科目下）应由以后年度税前利润弥补的亏损</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG03BJ64??>
                     ${DataDicUtil.getPoint(map.EGA.EG03BJ64)!}
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
                        ${DataDicUtil.getPoint(map.EGA.EG04BJ01)!}
                    <#else >
                    </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">营业成本</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ02??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ02)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业税金及附加</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ03??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ03)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">销售费用</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ04??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ04)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">管理费用</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ05??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ05)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">财务费用</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ06??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ06)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">资产减值损失</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ07??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ07)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">公允价值变动净收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ08??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ08)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资净收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ09??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ09)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">对联营企业和合营企业的投资收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ10??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ10)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业利润</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ11??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ11)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">营业外收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ12??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ12)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">营业外支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ13??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ13)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">非流动资产损失（其中：非流动资产处置损失）</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ14??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ14)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">利润总额</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ15??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ15)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">所得税费用</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ16??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ16)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">净利润</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ17??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ17)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">基本每股收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ18??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ18)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">稀释每股收益</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG04BJ19??>
                       ${DataDicUtil.getPoint(map.EGA.EG04BJ19)!}
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
                       ${DataDicUtil.getPoint(map.EGA.EG05BJ01)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">收到的税费返还</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ02??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ02)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收到的其他与经营活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ03??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ03)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ04??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ04)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">购买商品、接受劳务支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ05??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ05)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支付给职工以及为职工支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ06??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ06)!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">支付的各项税费</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ07??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ07)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支付的其他与经营活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ08??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ08)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ09??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ09)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ10??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ10)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收回投资所收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ11??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ11)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">取得投资收益所收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ12??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ12)!}
                  <#else>
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">处置固定资产无形资产和其他长期资产所收回的现金净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ13??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ13)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">收到的其他与投资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ14??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ14)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ15??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ15)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">购建固定资产无形资产和其他长期资产所支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ16??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ16)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资所支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ17??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ17)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">支付的其他与投资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ18??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ18)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG04BJ19??>
                      ${DataDicUtil.getPoint(map.EGA.EG04BJ19)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">投资活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ20??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ20)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">吸收投资所收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ21??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ21)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">借款所收到的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ22??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ22)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收到的其他与筹资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ23??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ23)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">筹资活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ24??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ24)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">偿还债务所支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ25??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ25)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">分配股利、利润或偿付利息所支付的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ26??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ26)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">支付的其他与筹资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ27??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ27)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">筹资活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ28??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ28)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">筹集活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ29??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ29)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">汇率变动对现金的影响</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ30??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ30)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金及现金等价物净增加额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ31??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ31)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">净利润</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ32??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ32)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">计提的资产减值准备</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ33??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ33)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">固定资产拆旧</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ34??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ34)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产摊销</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ35??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ35)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">长期待摊费用摊销</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ36??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ36)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">待摊费用减少</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ37??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ37)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">预提费用增加</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ38??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ38)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">处置固定资产无形资产和其他长期资产的损失</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ39??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ39)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">固定资产报废损失</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ40??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ40)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">财务费用</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ41??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ41)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">投资损失</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ42??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ42)!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">递延税款贷项</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ43??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ43)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">存货的减少</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ44??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ44)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营性应收项目的减少</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ45??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ45)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营性应付项目的增加</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ46??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ46)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（净利润调节为经营活动现金流量科目下）其他</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ47??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ47)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ48??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ48)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">债务转为资本</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ49??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ49)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">一年内到期的可转换公司债券</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ50??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ50)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">融资租入固定资产</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ51??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ51)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">（不涉及现金收支的投资和筹资活动科目下）其他</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ52??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ52)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金的期末余额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ53??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ53)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">现金的期初余额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ54??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ54)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金等价物的期末余额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ55??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ55)!}
                  <#else >
                  </#if>
                </td>
           </tr>
            <tr>     
                <td class="labeltd" colspan="2">现金等价物的期初余额</td>
                <td class="datatd-number" colspan="2">${map.EGA.EG05BJ56!}
                  <#if map.EGA.EG05BJ56??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ56)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金及现金等价物净增加额</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG05BJ57??>
                      ${DataDicUtil.getPoint(map.EGA.EG05BJ57)!}
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
                      ${DataDicUtil.getPoint(map.EGA.EG06BJ01)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">收到的税费返还</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG06BJ02??>
                      ${DataDicUtil.getPoint(map.EGA.EG06BJ02)!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">收到其他与经营活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG06BJ03??>
                      ${DataDicUtil.getPoint(map.EGA.EG06BJ03)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">经营活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ04??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ04)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">购买商品、接受劳务支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ05??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ05)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支付给职工以及为职工支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ06??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ06)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">支付的各项税费</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ07??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ07)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">支付其他与经营活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ08??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ08)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ09??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ09)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">经营活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ10??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ10)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">收回投资所收到的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ11??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ11)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">取得投资收益所收到的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ12??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ12)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">处置固定资产无形资产和其他长期资产所收回的现金净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ13??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ13)!}
                 <#else>
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">处置子公司及其他营业单位收到的现金净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ14??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ14)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收到其他与投资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ15??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ15)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">投资活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ16??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ16)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">购建固定资产无形资产和其他长期资产所支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ17??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ17)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">投资所支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ18??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ18)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">取得子公司及其他营业单位支付的现金净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ19??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ19)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支付其他与投资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ20??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ20)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ21??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ21)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">投资活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ22??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ22)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">吸收投资收到的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ23??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ23)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">取得借款收到的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ24??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ24)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收到其他与筹资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ25??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ25)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">筹资活动现金流入小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ26??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ26)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">偿还债务所支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ27??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ27)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">分配股利、利润或偿付利息所支付的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ28??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ28)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">支付其他与筹资活动有关的现金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ29??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ29)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">筹资活动现金流出小计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ30??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ30)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">筹集活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ31??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ31)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">汇率变动对现金及现金等价物的影响</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ32??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ32)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金及现金等价物净增加额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ33??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ33)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">期初现金及现金等价物余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ34??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ34)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">期末现金及现金等价物余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ35??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ35)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">净利润</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ36??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ36)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">资产减值准备</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ37??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ37)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产折旧、油气资产折耗、生产性生物资产折旧</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ38??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ38)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产摊销</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ39??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ39)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">长期待摊费用摊销</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ40??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ40)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">待摊费用减少</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ41??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ41)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">预提费用增加</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ42??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ42)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">处置固定资产无形资产和其他长期资产的损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ43??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ43)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产报废损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ44??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ44)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">公允价值变动损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ45??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ45)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">财务费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ46??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ46)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">投资损失</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ47??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ47)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr> 
                <td class="labeltd" colspan="2">递延所得税资产减少</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ48??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ48)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">递延所得税负债增加</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ49??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ49)!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">存货的减少</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ50??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ50)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营性应收项目的减少</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ51??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ51)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr> 
                <td class="labeltd" colspan="2">经营性应付项目的增加</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ52??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ52)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（净利润调节为经营活动现金流量科目下）其他</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ53??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ53)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">经营活动产生的现金流量净额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ54??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ54)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">债务转为资本</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ55??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ55)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr> 
                <td class="labeltd" colspan="2">一年内到期的可转换公司债券</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ56??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ56)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">融资租入固定资产</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ57??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ57)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金的期末余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ58??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ58)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金的期初余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ59??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ59)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">现金等价物的期末余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ60??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ60)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">现金等价物的期初余额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ61??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ61)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">现金及现金等价物净增加额</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ62??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ62)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">（不涉及现金收支的投资和筹资活动科目下）其他</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG06BJ63??>
                     ${DataDicUtil.getPoint(map.EGA.EG06BJ63)!}
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
                       ${DataDicUtil.getPoint(map.EGA.EG07BJ01)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">银行存款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ02??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ02)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应收票据</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG07BJ03??>
                      ${DataDicUtil.getPoint(map.EGA.EG07BJ03)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应收账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ04??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ04)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">预付账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ05??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ05)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">其他应收款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ06??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ06)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">材料</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ07??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ07)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">产成品</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ08??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ08)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">对外投资</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ09??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ09)!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ10??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ10)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ11??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ11)!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">资产合计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG07BJ12??>
                      ${DataDicUtil.getPoint(map.EGA.EG07BJ12)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">拨出经费</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ13??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ13)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">拨出专款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ14??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ14)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">专款支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ15??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ15)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">事业支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ16??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ16)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ17??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ17)!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">成本费用</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ18??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ18)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">销售税金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ19??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ19)!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">上缴上级支出</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ20??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ20)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">对附属单位补助</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ21??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ21)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">结转自筹基建</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ22??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ22)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">支出合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ23??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ23)!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr>
                <td class="labeltd" colspan="2">资产部类总计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ24??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ24)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">借记款项</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ25??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ25)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应付票据</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ26??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ26)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应付账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ27??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ27)!}
                 <#else >
                 </#if>
                </td>
              </tr>
            <tr> 
                <td class="labeltd" colspan="2">预收账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ28??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ28)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他应付款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ29??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ29)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴预算款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ30??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ30)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴财政专户款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ31??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ31)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应交税金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ32??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ32)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">负债合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ33??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ33)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>  
                <td class="labeltd" colspan="2">事业基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ34??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ34)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">一般基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ35??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ35)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">投资基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ36??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ36)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">固定基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ37??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ37)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">专用基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ38??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ38)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">事业结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ39??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ39)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">经营结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ40??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ40)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">净资产合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ41??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ41)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">财政补助收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ42??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ42)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">上级补助收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ43??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ43)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">拨入专款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ44??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ44)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ45??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ45)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">经营收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ46??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ46)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">附属单位缴款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ47??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ47)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">其他收入</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ48??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ48)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收入合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ49??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ49)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">负债部类总计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG07BJ50??>
                     ${DataDicUtil.getPoint(map.EGA.EG07BJ50)!}
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
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ01)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">短期投资</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ02??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ02)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">财政应返还额度</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ03??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ03)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">应收票据</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ04??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ04)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应收账款</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ05??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ05)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">预付账款</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ06??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ06)!}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">其他应收款</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ07??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ07)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">存货</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ08??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ08)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他流动资产</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ09??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ09)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">流动资产合计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ10??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ10)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">长期投资</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ11??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ11)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ12??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ12)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">固定资产原价</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ13??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ13)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">累计折旧</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ14??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ14)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">在建工程</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ15??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ15)!}
                  <#else >
                  </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ16??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ16)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">无形资产原价</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ17??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ17)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">累计摊销</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ18??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ18)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">待处置资产损溢</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ19??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ19)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">非流动资产合计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG08BJ20??>
                      ${DataDicUtil.getPoint(map.EGA.EG08BJ20)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">资产总计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ21??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ21)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">短期借款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ22??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ22)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴税费</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ23??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ23)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">应缴国库款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ24??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ24)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴财政专户款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ25??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ25)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">应付职工薪酬</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ26??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ26)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应付票据</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ27??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ27)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">应付账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ28??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ28)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">预收账款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ29??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ29)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">其他应付款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ30??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ30)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他流动负债</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ31??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ31)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">流动负债合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ32??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ32)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">长期借款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ33??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ33)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">长期应付款</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ34??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ34)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">非流动负债合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ35??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ35)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">负债合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ36??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ36)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">事业基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ37??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ37)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">非流动资产基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ38??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ38)!}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd" colspan="2">专用基金</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ39??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ39)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">财政补助结转</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ40??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ40)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">财政补助结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ41??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ41)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">非财政补助结转</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ42??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ42)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">非财政补助结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ43??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ43)!}
                 <#else >
                 </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">事业结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ44??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ44)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营结余</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ45??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ45)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">净资产合计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ46??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ46)!}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">负债和净资产总计</td>
                <td class="datatd-number" colspan="2">
                 <#if map.EGA.EG08BJ47??>
                     ${DataDicUtil.getPoint(map.EGA.EG08BJ47)!}
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
                      ${DataDicUtil.getPoint(map.EGA.EG09BJ01)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">上级补助收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ02??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ02)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">附属单位缴款</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ03??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ03)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">事业收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ04??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ04)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">预算外资金收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ05??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ05)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">其他收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ06??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ06)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业收入小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ07??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ07)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ08??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ08)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营收入小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ09??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ09)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">拨入专款</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ10??>
                      ${DataDicUtil.getPoint(map.EGA.EG09BJ10)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">拨入专款小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ11??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ11)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">收入总计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ12??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ12)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">拨出经费</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ13??>
                      ${DataDicUtil.getPoint(map.EGA.EG09BJ13)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">上缴上级支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ14??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ14)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">对附属单位补助</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ15??>
                      ${DataDicUtil.getPoint(map.EGA.EG09BJ15)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">事业支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ16??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ16)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">财政补助支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ17??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ17)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">预算外资金支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ18??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ18)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">销售税金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ19??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ19)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">结转自筹基建</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ20??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ20)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业支出小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ21??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ21)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营支出</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ22??>
                      ${DataDicUtil.getPoint(map.EGA.EG09BJ22)!}
                  <#else >
                  </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">销售税金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ23??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ23)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">经营支出小计</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG09BJ24??>
                      ${DataDicUtil.getPoint(map.EGA.EG09BJ24)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">拨出专款</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ25??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ25)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">专款支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ26??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ26)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">专款小计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ27??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ27)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">支出总计</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ28??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ28)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ29??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ29)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">正常收入结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ30??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ30)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">收回以前年度事业支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ31??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ31)!}
                   <#else >
                   </#if>
                </td>
           </tr>
            <tr>     
                <td class="labeltd" colspan="2">经营结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ33??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ33)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">以前年度经营亏损</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ33??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ33)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">结余分配</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ34??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ34)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应交所得税</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ35??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ35)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">提取专用基金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ36??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ36)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">转入事业基金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ37??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ37)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">其他结余分配</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG09BJ38??>
                       ${DataDicUtil.getPoint(map.EGA.EG09BJ38)!}
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
                          ${DataDicUtil.getPoint(map.EGA.EG09BJ38)!}
                      <#else >
                      </#if>
                </td>
             </tr>
            <tr>   
                <td class="labeltd" colspan="2">财政补助收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ02??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ02)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业支出（财政补助支出）</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ03??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ03)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">本期事业结转结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ04??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ04)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业类收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ05??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ05)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">事业收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ06??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ06)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">上级补助收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ07??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ07)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>    
                <td class="labeltd" colspan="2">附属单位上缴收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ08??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ08)!}
                   <#else >
                   </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ09??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ09)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">（其他收入科目下）捐赠收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ10??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ10)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">事业类支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ11??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ11)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">事业支出（非财政补助支出）</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ12??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ12)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">上缴上级支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ13??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ13)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr>
                <td class="labeltd" colspan="2">对附属单位补助支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ14??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ14)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">其他支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ15??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ15)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">本期经营结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ16??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ16)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">经营收入</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ17??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ17)!}
                   <#else >
                   </#if>
                </td>
             </tr>
            <tr> 
                <td class="labeltd" colspan="2">经营支出</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ18??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ18)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">弥补以前年度亏损后的经营结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ19??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ19)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr> 
                <td class="labeltd" colspan="2">本年非财政补助结转结余</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG10BJ20??>
                      ${DataDicUtil.getPoint(map.EGA.EG10BJ20)!}
                  <#else >
                  </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">非财政补助结转</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG10BJ21??>
                      ${DataDicUtil.getPoint(map.EGA.EG10BJ21)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">本年非财政补助结余</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ22??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ22)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">应缴企业所得税</td>
                <td class="datatd-number" colspan="2">
                  <#if map.EGA.EG10BJ23??>
                      ${DataDicUtil.getPoint(map.EGA.EG10BJ23)!}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">提取专用基金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ24??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ24)!}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd" colspan="2">转入事业基金</td>
                <td class="datatd-number" colspan="2">
                   <#if map.EGA.EG10BJ25??>
                       ${DataDicUtil.getPoint(map.EGA.EG10BJ25)!}
                   <#else >
                   </#if>
                </td>
            </tr>
        </table>
    </fieldset>            
                
                
                
                
    <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/>
</div>
</body>

</html>
