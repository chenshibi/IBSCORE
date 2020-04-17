<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>二代个人汇总报告</title>

    <style>
        body{
            font-size: 18px;
            background-color: #F8F8FF;
        }

        p{
            text-align: left;
            font-family: 宋体;
            font-size: 16px;
        }

        td {
            border: solid #222222 1px;
            padding: 4px 8px;
        }

        h1{
            margin: 14px 0;
            font-family: 宋体;
        }

        h2{
            margin: 10px 0;
            font-family: 宋体;
        }

        h3{
            margin: 6px 0;
            font-family: 宋体;
        }

        h4{
            margin: 2px 0;
        }

        .fixedTable{
            width: 100%;
            border-collapse: collapse;
            border: none;
            table-layout: fixed;
        }

        .content_left {
            text-align: left;
            word-break: break-all;
            font-weight: bold;
        }

        .content_right {
            text-align: right;
            word-break: break-all;
            font-weight: bold;
        }

        .content_center {
            text-align: center;
            word-break: break-all;
        }

        .title_center {
            text-align: center;
            font-size: 16px;
            font-weight: bold;
            word-break: break-all;
        }

        .title_left {
            text-align: left;
            font-size: 14px;
            font-weight: bold;
        }
        .title_right {
            text-align: right;
            font-size: 14px;
            font-weight: bold;
        }

        .no_border_top{
            border-top: none;
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
</head>
<body>
<div id="mainDiv">
    <h1>二代个人汇总报告</h1> 
    
    <#if map.CR_PER_PSM.PC010Q01??>
    <h3>（一）个人信用报告“数字解读”</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center">数字解读</td>
            <td class="title_center">相对位置</td>
            <td class="title_center" width="45%">说明</td>
        </tr>
        <tr>
        	
            <td class="content_center" rowspan="2">${map.CR_PER_PSM.PC010Q01!}</td>
            <td class="content_center" rowspan="2">>${map.CR_PER_PSM.PC010Q02!}%</td>
            
            <#list map.CR_PER_PSM.PC010D01 as PC010D01>
            <#if PC010D01_index gt 0></tr><tr></#if>
            <td class="content_center">
                <#if PC010D01.PC010D01_ITEM!="" && PC010D01.PC010D01_ITEM??>
                    	影响因素${PC010D01_index+1!}:${DataDicUtil.getDataDic("6010",PC010D01.PC010D01_ITEM)!}
                <#else >&nbsp;
                </#if>
            </td>
        	</#list>
            
            <#--
            <td class="content_center"> <#list map.CR_PER_PSM.PC010D01?split(",") as  aaaa> <br/>
                                               影响因素 :${DataDicUtil.getDataDic("6010",aaaa)!} </#list>
         	</td> 
        	-->
        	
        </tr>
    </table> 
    </#if> 
    <br>
    <h3>（二）信贷交易信息提示</h3>
    
	<table class="fixedTable">
	    <colgroup>
	        <col width=12%>
	        <col>
	        <col width=8%>
	        <col width=25%>
	    </colgroup>
	    <tr>
	        <td class="title_center" colspan="2">业务类型</td>
	        <td class="title_center" width="8%">账户数</td>
	        <td class="title_center" width="25%">首笔业务发放月份</td>
	    </tr>
	   <tr>
	        <#list map.CR_PER_PC02AH! as CR_PER_PC02AH>
	            <#if CR_PER_PC02AH_index gt 0></tr><tr></#if>
	            <td class="title_center" rowspan=${CR_PER_PC02AH.PC02AD02_COUNT!}>${DataDicUtil.getDataDic("6012",CR_PER_PC02AH.PC02AD02)!}</td>
	            <#list CR_PER_PC02AH.PC02AD02_ITEM as PC02AD02_ITEM>
	                <#if PC02AD02_ITEM_index gt 0></tr><tr></#if>
	                <td class="content_center">${DataDicUtil.getDataDic("6011",PC02AD02_ITEM.PC02AD01)!}</td>
	                <td class="content_center">${PC02AD02_ITEM.PC02AS03!}</td>
	                <td class="content_center">${PC02AD02_ITEM.PC02AR01!}</td>
	            </#list>
	        </#list>
	    </tr>
	    <tr>
	        <td class="title_center" colspan="2">合计</td>
	        <td class="content_center">${map.CR_PER_PCO.PC02AS01!}</td>
	        <td class="content_center">--</td>
	    </tr>
	</table>
	<br>
    
    <#--<table class="fixedTable">
        <colgroup>
            <col width=12%>
            <col>
            <col width=8%>
            <col width=25%>
        </colgroup>
        <tr>
            <td class="title_center" colspan="2">业务类型</td>
            <td class="title_center" width="8%">账户数</td>
            <td class="title_center" width="25%">首笔业务发放月份</td>
        </tr>
       <tr>
       		<td class="title_center" rowspan="3">贷款</td>
       		<td class="title_center" >个人住房贷款</td>
            <td class="content_center">${map.CR_PER_PC02AH_1_11.PC02AS03!}</td>
            <td class="content_center">${map.CR_PER_PC02AH_1_11.PC02AR01!}</td>
       </tr>    
       <tr>
       		<td class="title_center" >个人商用房贷款（包括商住两用房）</td>
            <td class="content_center">${map.CR_PER_PC02AH_1_12.PC02AS03!}</td>
            <td class="content_center">${map.CR_PER_PC02AH_1_12.PC02AR01!}</td>
       </tr>    
       <tr>
       		<td class="title_center" >其他类贷款</td>
            <td class="content_center">${map.CR_PER_PC02AH_1_19.PC02AS03!}</td>
            <td class="content_center">${map.CR_PER_PC02AH_1_19.PC02AR01!}</td>
       </tr>
       <tr>
       		<td class="title_center" rowspan="2">信用卡</td>
       		<td class="title_center" >贷记卡</td>
            <td class="content_center">${map.CR_PER_PC02AH_2_21.PC02AS03!}</td>
            <td class="content_center">${map.CR_PER_PC02AH_2_21.PC02AR01!}</td>
       </tr> 
       <tr>
       		<td class="title_center" >准贷记卡</td>
            <td class="content_center">${map.CR_PER_PC02AH_2_22.PC02AS03!}</td>
            <td class="content_center">${map.CR_PER_PC02AH_2_22.PC02AR01!}</td>
       </tr> 
       <tr>
       		<td class="title_center" >其他</td>
       		<td class="title_center" >其他</td>
       		<#if map.CR_PER_PC02AH_9_99??>
            <td class="content_center">${map.CR_PER_PC02AH_9_99.PC02AS03!}</td>
            <#else> --
            </#if>
            <#if map.CR_PER_PC02AH_9_99??>
            <td class="content_center">${map.CR_PER_PC02AH_9_99.PC02AR01!}</td>
            <#else> --
            </#if>
       </tr> 
       
       <tr>
            <td class="title_center" colspan="2">合计</td>
            <td class="content_center">${map.CR_PER_PCO.PC02AS01!}</td>
            <td class="content_center">--</td>
       </tr>
    </table>
    <br>-->
    
    <h3>（三）信贷交易违约信息概要</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">被追偿信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">业务类型</td>
            <td class="title_center">账户数</td>
            <td class="title_center">余额</td>
        </tr>
        <#list map.CR_PER_PC02BH! as CR_PER_PC02BH>
        <tr>
             <td class="title_center">${DataDicUtil.getDataDic("6013",CR_PER_PC02BH.PC02BD01)!}</td>
             <td class="content_center">${CR_PER_PC02BH.PC02BS03!}</td>
             <td class="content_center">${CR_PER_PC02BH.PC02BJ02!}</td>
        </tr>
        </#list>
        
        <#--
        <tr>
             <td class="title_center">资产处置业务</td>
             <td class="content_center">${map.CR_PER_PC02BH_1.PC02BS03!}</td>
             <td class="content_center">${map.CR_PER_PC02BH_1.PC02BJ02!}</td>
        </tr>
        <tr>
             <td class="title_center">垫款业务</td>
             <td class="content_center">${map.CR_PER_PC02BH_2.PC02BS03!}</td>
             <td class="content_center">${map.CR_PER_PC02BH_2.PC02BJ02!}</td>
        </tr>
        -->
        <tr>
            <td class="title_center">合计</td>
            <td class="content_center">${map.CR_PER_PCO.PC02BS01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02BJ01!}</td>
        </tr>
    </table>
    <br>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="2">呆账信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">账户数</td>
            <td class="title_center">余额</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02CS01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02CJ01!}</td>
        </tr>
    </table>
    <br>
    <table class="fixedTable">
        <colgroup>
            <col>
            <col width=8%>
            <col width=12%>
            <col>
            <col>
        </colgroup>
        <tr>
            <td class="title_center" colspan="5">逾期（透支）信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">账户类型</td>
            <td class="title_center">账户数</td>
            <td class="title_center">月份数</td>
            <td class="title_center">单月最高逾期/透支总额</td>
            <td class="title_center">最长逾期/透支月数</td>
        </tr>
		<#list map.CR_PER_PC02DH! as CR_PER_PC02DH>
            <tr>
                <td class="title_center">${DataDicUtil.getDataDic("6014",CR_PER_PC02DH.PC02DD01)!}</td>
                <td class="content_center">${CR_PER_PC02DH.PC02DS02!}</td>
                <td class="content_center">${CR_PER_PC02DH.PC02DS03!}</td>
                <td class="content_center">${CR_PER_PC02DH.PC02DJ01!}</td>
                <td class="content_center">${CR_PER_PC02DH.PC02DS04!}</td>
            </tr>
        </#list>
		
		<#--
		<tr>
            <td class="title_center">非循环贷账户</td>
            <td class="content_center">${map.CR_PER_PC02DH_1.PC02DS02!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_1.PC02DS03!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_1.PC02DJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_1.PC02DS04!}</td>
        </tr>
		<tr>
            <td class="title_center">循环额度下分账户</td>
            <td class="content_center">${map.CR_PER_PC02DH_2.PC02DS02!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_2.PC02DS03!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_2.PC02DJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_2.PC02DS04!}</td>
        </tr>
		<tr>
            <td class="title_center">循环贷账户</td>
            <td class="content_center">${map.CR_PER_PC02DH_3.PC02DS02!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_3.PC02DS03!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_3.PC02DJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_3.PC02DS04!}</td>
        </tr>
		<tr>
            <td class="title_center">贷记卡账户</td>
            <td class="content_center">${map.CR_PER_PC02DH_4.PC02DS02!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_4.PC02DS03!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_4.PC02DJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_4.PC02DS04!}</td>
        </tr>
		<tr>
            <td class="title_center">准贷记卡账户</td>
            <td class="content_center">${map.CR_PER_PC02DH_5.PC02DS02!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_5.PC02DS03!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_5.PC02DJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02DH_5.PC02DS04!}</td>
        </tr>
        -->
    </table >
    <br>
    <h3>（四）信贷交易授信及负债信息概要</h3>
    <#--非循环贷账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">非循环贷账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">账户数</td>
            <td class="title_center">余额</td>
            <td class="title_center">最近 6 个月平均应还款</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02ES02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02EJ02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02EJ03!}</td>
        </tr>
    </table >
    <br>

    <#--循环额度下分账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">循环额度下分账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">账户数</td>
            <td class="title_center">余额</td>
            <td class="title_center">最近 6 个月平均应还款</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02FS02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02FJ02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02FJ03!}</td>
        </tr>
    </table>
    <br>

    <#--循环贷账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">循环贷账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">账户数</td>
            <td class="title_center">余额</td>
            <td class="title_center">最近 6 个月平均应还款</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02GS02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02GJ02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02GJ03!}</td>
        </tr>
    </table>
    <br>

    <#--贷记卡账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="4">贷记卡账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">账户数</td>
            <td class="title_center">授信总额</td>
            <td class="title_center">已用额度</td>
            <td class="title_center">最近6个月<br>平均使用额度</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02HS02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HJ01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HJ04!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HJ05!}</td>
        </tr>
    </table>
    <br>

    <#--准贷记卡账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="4">准贷记卡账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">账户数</td>
            <td class="title_center">授信总额</td>
            <td class="title_center">已用额度</td>
            <td class="title_center">最近6个月<br>平均使用额度</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02IS02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02IJ01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02IJ04!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02IJ05!}</td>
        </tr>
    </table>
    <br>

    <#--相关还款责任信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="6">相关还款责任信息汇总</td>
        </tr>
        <tr>
            <td class="title_center" colspan="6">为个人</td>
        </tr>
        <tr>
            <td class="title_center" colspan="3">担保责任</td>
            <td class="title_center" colspan="3">其他相关还款责任</td>
        </tr>
        <tr>
            <td class="title_center">账户数</td>
            <td class="title_center">担保金额</td>
            <td class="title_center">余额</td>
            <td class="title_center">账户数</td>
            <td class="title_center">还款责任金额</td>
            <td class="title_center">余额</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PC02KH_1_1.PC02KS02!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_1_1.PC02KJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_1_1.PC02KJ02!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_1_9.PC02KS02!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_1_9.PC02KJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_1_9.PC02KJ02!}</td>
        </tr>
        <tr>
            <td class="title_center" colspan="6">为企业</td>
        </tr>
        <tr>
            <td class="title_center" colspan="3">担保责任</td>
            <td class="title_center" colspan="3">其他相关还款责任</td>
        </tr>
        <tr>
            <td class="title_center">账户数</td>
            <td class="title_center">担保金额</td>
            <td class="title_center">余额</td>
            <td class="title_center">账户数</td>
            <td class="title_center">还款责任金额</td>
            <td class="title_center">余额</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PC02KH_2_1.PC02KS02!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_2_1.PC02KJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_2_1.PC02KJ02!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_2_9.PC02KS02!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_2_9.PC02KJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02KH_2_9.PC02KJ02!}</td>
        </tr>
    </table>
    <br>
    
    <h2>五 公共信息明细</h2>
    <h3>（一）欠税记录 </h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">主管税务机关</td>
            <td class="title_center">欠税总额</td>
            <td class="title_center">欠税统计日期</td>
        </tr>
        <#list map.CR_PER_POT! as CR_PER_POT>
            <tr>
                <td class="content_center">${CR_PER_POT_index + 1 !}</td>
                <td class="content_center">${CR_PER_POT.PF01AQ01!}</td>
                <td class="content_center">${CR_PER_POT.PF01AJ01!}</td>
                <td class="content_center">${CR_PER_POT.PF01AR01!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（二）民事判决记录</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">立案法院</td>
            <td class="title_center" width="35%">案由</td>
            <td class="title_center" width="15%">立案日期</td>
            <td class="title_center" width="15%">结案方式</td>
        </tr>
        <#list map.CR_PER_PCJ! as CR_PER_PCJ>
            <tr>
                <td class="content_center">${CR_PER_PCJ_index + 1 !}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AQ01!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AQ02!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AR01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6049",CR_PER_PCJ.PF02AD01)!}</td>
            </tr>
        </#list>
    </table>
    <table class="fixedTable">
        <tr>
            <td class="title_center no_border_top" width="6%">编号</td>
            <td class="title_center no_border_top">判决/调解结果</td>
            <td class="title_center no_border_top" width="15%">判决/调解生效日期</td>
            <td class="title_center no_border_top" width="25%">诉讼标的</td>
            <td class="title_center no_border_top" width="15%">诉讼标的金额</td>
        </tr>
        <#list map.CR_PER_PCJ! as CR_PER_PCJ>
            <tr>
                <td class="content_center">${CR_PER_PCJ_index + 1 !}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AQ03!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AR02!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AQ04!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AJ01!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（三）强制执行记录</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">立案法院</td>
            <td class="title_center" width="35%">案由</td>
            <td class="title_center" width="15%">立案日期</td>
            <td class="title_center" width="15%">结案方式</td>
        </tr>
        <#list map.CR_PER_PCE! as CR_PER_PCE>
            <tr>
                <td class="content_center">${CR_PER_PCE_index + 1 !}</td>
                <td class="content_center">${CR_PER_PCE.PF03AQ01!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AQ02!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AR01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6050",CR_PER_PCE.PF03AD01)!}</td>
            </tr>
        </#list>
    </table>
    <table class="fixedTable">
        <tr>
            <td class="title_center no_border_top" width="6%">编号</td>
            <td class="title_center no_border_top">案件状态</td>
            <td class="title_center no_border_top">结案日期</td>
            <td class="title_center no_border_top">申请执行标的</td>
            <td class="title_center no_border_top">申请执行标的价值</td>
            <td class="title_center no_border_top">已执行标的</td>
            <td class="title_center no_border_top">已执行标的金额</td>
        </tr>
        <#list map.CR_PER_PCE! as CR_PER_PCE>
            <tr>
                <td class="content_center">${CR_PER_PCE_index + 1 !}</td>
                <td class="content_center">${CR_PER_PCE.PF03AQ03!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AR02!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AQ04!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AJ01!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AQ05!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AJ02!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（四）行政处罚记录</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">处罚机构</td>
            <td class="title_center">处罚内容</td>
            <td class="title_center" width="10%">处罚金额</td>
            <td class="title_center" width="10%">生效日期</td>
            <td class="title_center" width="10%">截止日期</td>
            <td class="title_center" width="12%">行政复议结果</td>
        </tr>
        <#list map.CR_PER_PAP! as CR_PER_PAP>
            <tr>
                <td class="content_center">${CR_PER_PAP_index + 1 !}</td>
                <td class="content_center">${CR_PER_PAP.PF04AQ01!}</td>
                <td class="content_center">${CR_PER_PAP.PF04AQ02!}</td>
                <td class="content_center">${CR_PER_PAP.PF04AJ01!}</td>
                <td class="content_center">${CR_PER_PAP.PF04AR01!}</td>
                <td class="content_center">${CR_PER_PAP.PF04AR02!}</td>
                <td class="content_center">${CR_PER_PAP.PF04AQ03!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（五）住房公积金参缴记录</h3>
    <#list map.CR_PER_PHF! as CR_PER_PHF>
        <table class="fixedTable">
            <tr>
                <td class="title_center">参缴地</td>
                <td class="title_center">参缴日期</td>
                <td class="title_center">初缴月份</td>
                <td class="title_center">缴至月份</td>
                <td class="title_center">缴费状态</td>
                <td class="title_center">月缴存额</td>
                <td class="title_center">个人缴存比例</td>
                <td class="title_center">单位缴存比例</td>
            </tr>
            <tr>
                <td class="content_center">${CR_PER_PHF.PF05AQ01!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AR01!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AR02!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AR03!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6051",CR_PER_PHF.PF05AD01)!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AJ01!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AQ03!}%</td>
                <td class="content_center">${CR_PER_PHF.PF05AQ02!}%</td>
            </tr>
            <tr>
                <td class="title_center" colspan="7">缴费单位</td>
                <td class="title_center">信息更新日期</td>
            </tr>
            <tr>
                <td class="content_center" colspan="7">${CR_PER_PHF.PF05AQ04!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AR04!}</td>
            </tr>
        </table>
        <br>
    </#list>
    <br>

    <h3>（六）低保救助记录</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">人员类别</td>
            <td class="title_center">所在地</td>
            <td class="title_center" width="25%">工作单位</td>
            <td class="title_center">家庭月收入</td>
            <td class="title_center">申请日期</td>
            <td class="title_center">批准日期</td>
            <td class="title_center">信息更新日期</td>
        </tr>
        <#list map.CR_PER_PBS! as CR_PER_PBS>
            <tr>
                <td class="content_center">${CR_PER_PBS_index + 1 !}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6052",CR_PER_PBS.PF06AD01)!}</td>
                <td class="content_center">${CR_PER_PBS.PF06AQ01!}</td>
                <td class="content_center">${CR_PER_PBS.PF06AQ02!}</td>
                <td class="content_center">${CR_PER_PBS.PF06AQ03!}</td>
                <td class="content_center">${CR_PER_PBS.PF06AR01!}</td>
                <td class="content_center">${CR_PER_PBS.PF06AR02!}</td>
                <td class="content_center">${CR_PER_PBS.PF06AR03!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（七）执业资格记录</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">执业资格名称</td>
            <td class="title_center">等级</td>
            <td class="title_center" width="10%">获得日期</td>
            <td class="title_center" width="10%">到期日期</td>
            <td class="title_center" width="10%">吊销日期</td>
            <td class="title_center">颁发机构</td>
            <td class="title_center">机构所在地</td>
        </tr>
        <#list map.CR_PER_PPQ! as CR_PER_PPQ>
            <tr>
                <td class="content_center">${CR_PER_PPQ_index + 1 !}</td>
                <td class="content_center">${CR_PER_PPQ.PF07AQ01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6053",CR_PER_PPQ.PF07AD01)!}</td>
                <td class="content_center">${CR_PER_PPQ.PF07AR01!}</td>
                <td class="content_center">${CR_PER_PPQ.PF07AR02!}</td>
                <td class="content_center">${CR_PER_PPQ.PF07AR03!}</td>
                <td class="content_center">${CR_PER_PPQ.PF07AD02!}</td>
                <td class="content_center">${CR_PER_PPQ.PF07AQ02!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（八）行政奖励记录</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">奖励机构</td>
            <td class="title_center">奖励内容</td>
            <td class="title_center" width="10%">生效日期</td>
            <td class="title_center" width="10%">截止日期</td>
        </tr>
        <#list map.CR_PER_PAH! as CR_PER_PAH>
            <tr>
                <td class="content_center">${CR_PER_PAH_index + 1 !}</td>
                <td class="content_center">${CR_PER_PAH.PF08AQ01!}</td>
                <td class="content_center">${CR_PER_PAH.PF08AQ02!}</td>
                <td class="content_center">${CR_PER_PAH.PF08AR01!}</td>
                <td class="content_center">${CR_PER_PAH.PF08AR02!}</td>
            </tr>
        </#list>
    </table>
    <br>

</div>
</body>
</html>