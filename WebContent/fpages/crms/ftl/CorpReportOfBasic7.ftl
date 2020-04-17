<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<html oncontextmenu="return false" onselectstart="return false" ondragstart="return false" onbeforecopy="return false" oncopy=document.selection.empty() onselect=document.selection.empty()>
<head>
    <title>二代企业信息汇总</title>
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
     <h1>二代企业信息汇总</h1>
     	<table class="mainTable">
            <tr>
                <td class="labeltd-3-1" style="border-collapse: collapse; border: none" border="0">报告编号:</td>
                <td class="datatd-1" style="border-collapse: collapse; border: none" border="0">${map.EAA.EA01AI01!}</td>
                <td class="labeltd-3-2" style="border-collapse: collapse; border: none" border="0">报告时间:</td>
                <td class="datatd-1" style="border-collapse: collapse; border: none" border="0">${map.EAA.EA01AR01!}</td>
            </tr>
         </table><br>
   	 
   	 <h2>身份标识</h2>
         <table class="mainTable">
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
			<#-- 
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
             -->
            </table><br>
           
            <table>
           		 <tr>
             	   <td class="titletd" colspan="6">
                    <li>注册资本及主要出资人信息单元</li>
               	   </td>
                   <td class="titletd-r" colspan="6"> 
              		   注册资本折人民币合计 ${map.ECA.EC020J01!}
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
							
                           <#if (EC020H.EC020D02=='1') >
								<td class="datatd">${DataDicUtil.getDataDic("6002", EC020H.EC020D03)!}</td>
							<#else >
								<td class="datatd">${DataDicUtil.getDataDic("6065", EC020H.EC020D03)!}</td>
							</#if>                            <td class="datatd">${EC020H.EC020I01!}</td>
                            <td class="datatd">${EC020H.EC020Q02!}%</td>
                        </tr>
                        </#list>
               </table><br>
          
        <#--    <tr>
                <td class="labeltd">主要组成人员个数</td>
                <td class="datatd">${map.ECA.EC030S01!}</td>
            </tr>-->
                <#-- 
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
                    -->
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
                         	<#else>--
                         	</#if>
                         </td>
                   </tr>
                  </#list>
               </table><br>
               
        <h2>信息概要</h2>  
        	<table class="mainTable">
              <tr>
              	<td class="labeltd" colspan="2">借贷交易</td>
              	<td class="labeltd" colspan="2">担保交易</td>
              </tr>
              <tr>
                <td class="labeltd">借贷交易余额</td>
                <td class="datatd">
                 <#if map.EBA.EB01AJ01??>
                    ${map.EBA.EB01AJ01!}
                <#else >
                </#if>
               </td>
               <td class="labeltd">担保交易余额</td>
                <td class="datatd" >
                     <#if map.EBA.EB01AJ05??>
                         ${map.EBA.EB01AJ05!}
                     <#else >
                     </#if>
                </td>
                
            </tr>
            <tr>
            <td class="labeltd">被追偿的借贷交易余额</td>
                <td class="datatd">
                     <#if map.EBA.EB01AJ02??>
                         ${ map.EBA.EB01AJ02!}
                     <#else >
                     </#if>
                </td>
               <td class="labeltd">关注类担保交易余额</td>
                <td class="datatd" >
                      <#if map.EBA.EB01AJ06??>
                          ${ map.EBA.EB01AJ06!}
                      <#else >
                      </#if>
                </td>
            </tr>
            <tr>
                 <td class="labeltd">关注类借贷交易余额</td>
                <td class="datatd">
                  <#if map.EBA.EB01AJ03??>
                      ${ map.EBA.EB01AJ03!}
                  <#else >
                  </#if>
                 </td>
                  <td class="labeltd">不良类担保交易余额</td>
                <td class="datatd">
                    <#if map.EBA.EB01AJ07??>
                        ${ map.EBA.EB01AJ07!}
                    <#else >
                    </#if>
                </td>
                
            </tr>
            <tr>
               <td class="labeltd">不良类借贷交易余额</td>
                <td class="datatd">
                    <#if map.EBA.EB01AJ04??>
                        ${ map.EBA.EB01AJ04!}
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
                <#-- <td class="labeltd">非信贷交易账户数</td>-->
                <td class="labeltd">欠税记录条数</td>
                <#-- <td class="labeltd">民事判决记录条数</td>-->
                <td class="labeltd">强制执行记录条数</td>
                <td class="labeltd">行政处罚记录条数</td>
            </tr>
            <tr>
             	<#--<td class="datatd">${map.EBA.EB01BS01!}</td>-->
             	<td class="datatd">${map.EBA.EB01BS02!}</td>
                <#--<td class="datatd">${map.EBA.EB01BS03!}</td>-->
                <td class="datatd">${map.EBA.EB01BS04!}</td>
                <td class="datatd">${map.EBA.EB01BS05!}</td>
            </tr>
             </table><br>
             
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
               			
               			<td class="datatd">${map.ED01_2_23.ED01AR01!}</td>
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
               			
               			<td class="datatd">${map.ED01_2_1.ED01AR01!}</td>
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
            	<td>特定交易提示--></td>
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
            	<td>特定交易提示--></td>
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
            	<td>特定交易提示--></td>
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
            	<td>特定交易提示--></td>
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
                      
     
</div>
</body>

</html>
