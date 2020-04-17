<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>二代个人信息汇总</title>

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
            font-size: 14px;
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
    <h1>二代个人信息汇总</h1> 
    <table class="fixedTable">
    	<tr>
		    <td class="content_left" style="border-collapse: collapse; border: none" border="0">报告编号：${map.CR_PER_PRH.PA01AI01!}</td>
		    <td class="content_right" style="border-collapse: collapse; border: none" border="0">报告时间：${map.CR_PER_PRH.PA01AR01!}</td>
		</tr>
    </table>
    <br>
    <table class="fixedTable">
        <tr>
            <td class="title_center">被查询者姓名</td>
            <td class="title_center">被查询者证件类型</td>
            <td class="title_center">被查询者证件号码</td>
        </tr>
        <tr>
            <td class="content_center"  >${map.CR_PER_PRH.PA01BQ01!}</td>
            <td class="content_center" >${DataDicUtil.getDataDic("6002",map.CR_PER_PRH.PA01BD01)!}</td>
            <td class="content_center" >${map.CR_PER_PRH.PA01BI01!}</td>
        </tr>
    </table>
    <br>
    
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="2">异议信息提示</td>
        </tr>
        <tr>
            <td class="content_center" colspan="2">信息主体对信用报告内容提出了${map.CR_PER_PRH.PA01ES01!}笔异议且正在处理中，请浏览时注意阅读相关内容。</td>
        </tr>
    </table>
    <br>
     <h2>一  个人基本信息 </h2>
    <h3>身份信息 </h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">性别</td>
            <td class="title_center">出生日期</td>
            <td class="title_center">婚姻状况</td>
            <td class="title_center">学历</td>
            <td class="title_center">学位</td>
            <td class="title_center">就业状况</td>
            <td class="title_center">国籍</td>
            <td class="title_center" width="25%">电子邮箱</td>
        </tr>
        <tr>
            <td class="content_center">${DataDicUtil.getDataDic("6059",map.CR_PER_PIM.PB01AD01)!}</td>
            <td class="content_center">${map.CR_PER_PIM.PB01AR01!}</td>
            <td class="content_center">${DataDicUtil.getDataDic("6063",map.CR_PER_PMM.PB020D01)!}</td>
            <td class="content_center">${DataDicUtil.getDataDic("6060",map.CR_PER_PIM.PB01AD02)!}</td>
            <td class="content_center">${DataDicUtil.getDataDic("6061",map.CR_PER_PIM.PB01AD03)!}</td>
            <td class="content_center">${DataDicUtil.getDataDic("6062",map.CR_PER_PIM.PB01AD04)!}</td>
            <td class="content_center">${map.CR_PER_PIM.PB01AD05!}</td>
            <td class="content_center">${map.CR_PER_PIM.PB01AQ01!}</td>
        </tr>

        <tr>
            <td class="title_center" colspan="5">通讯地址</td>
            <td class="title_center" colspan="3">户籍地址</td>
        </tr>
        <tr>
            <td class="content_center" colspan="5">${map.CR_PER_PIM.PB01AQ02!}</td>
            <td class="content_center" colspan="3">${map.CR_PER_PIM.PB01AQ03!}</td>
        </tr>
        <tr>
            <td class="title_center" width="6%">编号(共${map.CR_PER_PB01BH?size!}条)</td>
            <td class="title_center" colspan="4">手机号码</td>
            <td class="title_center" colspan="3">信息更新日期</td>
        </tr>
        <#list map.CR_PER_PB01BH! as CR_PER_PB01BH>
            <tr>
                <td class="content_center" colspan="1">${CR_PER_PB01BH_index + 1!}</td>
                <td class="content_center" colspan="4">${CR_PER_PB01BH.PB01BQ01!}</td>
                <td class="content_center" colspan="3">${CR_PER_PB01BH.PB01BR01!}</td>
            </tr>
        </#list>
    </table>
    <br>
    <h3>配偶信息 </h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="10%">姓名</td>
            <td class="title_center" width="16%">证件类型</td>
            <td class="title_center" width="16%">证件号码</td>
            <td class="title_center">工作单位</td>
            <td class="title_center" width="10%">联系电话</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PMM.PB020Q01!}</td>
            <td class="content_center">${DataDicUtil.getDataDic("6002",map.CR_PER_PMM.PB020D02)!}</td>
            <td class="content_center">${map.CR_PER_PMM.PB020I01!}</td>
            <td class="content_center">${map.CR_PER_PMM.PB020Q02!}</td>
            <td class="content_center">${map.CR_PER_PMM.PB020Q03!}</td>
        </tr>
    </table>
    <br>
    <h3>居住信息 </h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">居住地址</td>
            <td class="title_center" width="10%">居住状况</td>
            <td class="title_center" width="16%">信息更新日期</td>
        </tr>
        <tr>
            <#list map.CR_PER_PRM! as CR_PER_PRM>
                <tr>
                    <td class="content_center">${CR_PER_PRM_index + 1 !}</td>
                    <td class="content_center">${CR_PER_PRM.PB030Q01!}</td>
                    <td class="content_center">${DataDicUtil.getDataDic("6005",CR_PER_PRM.PB030D01)!}</td>
                    <td class="content_center">${CR_PER_PRM.PB030R01!}</td>
                </tr>
            </#list>
        </tr>
    </table>
    <br>
    <h3>职业信息 </h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center" width="20%">工作单位</td>
            <td class="title_center" colspan="3">单位性质</td>
            <td class="title_center" width="16%">单位电话</td>
        </tr>
        <#list map.CR_PER_POM! as CR_PER_POM>
            <tr>
                <td class="content_center">${CR_PER_POM_index + 1 !}</td>
                <td class="content_center">${CR_PER_POM.PB040Q01!}</td>
                <td class="content_center" colspan="3">${DataDicUtil.getDataDic("6006",CR_PER_POM.PB040D02)!}</td>
                <td class="content_center">${CR_PER_POM.PB040Q03!}</td>
            </tr>
        </#list>
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center" >职业</td>
            <td class="title_center" >职务</td>
            <td class="title_center" >职称</td>
            <td class="title_center" >进入本单位年份</td>
            <td class="title_center" >信息更新日期</td>
        </tr>
        <#list map.CR_PER_POM! as CR_PER_POM>
            <tr>
                <td class="content_center">${CR_PER_POM_index + 1 !}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6007",CR_PER_POM.PB040D04)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6008",CR_PER_POM.PB040D05)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6009",CR_PER_POM.PB040D06)!}</td>
                <td class="content_center">${CR_PER_POM.PB040R01!}</td>
                <td class="content_center">${CR_PER_POM.PB040R02!}</td>
            </tr>
        </#list>
    </table>
    <br>
    
    <h2>二  信息概要</h2>
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
    </table> </#if> 
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
            <td class="title_center" colspan="5">非循环贷账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">管理机构数</td>
            <td class="title_center">账户数</td>
            <td class="title_center">授信总额</td>
            <td class="title_center">余额</td>
            <td class="title_center">最近 6 个月平均应还款</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02ES01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02ES02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02EJ01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02EJ02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02EJ03!}</td>
        </tr>
    </table >
    <br>

    <#--循环额度下分账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="5">循环额度下分账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">管理机构数</td>
            <td class="title_center">账户数</td>
            <td class="title_center">授信总额</td>
            <td class="title_center">余额</td>
            <td class="title_center">最近 6 个月平均应还款</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02FS01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02FS02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02FJ01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02FJ02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02FJ03!}</td>
        </tr>
    </table>
    <br>

    <#--循环贷账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="5">循环贷账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">管理机构数</td>
            <td class="title_center">账户数</td>
            <td class="title_center">授信总额</td>
            <td class="title_center">余额</td>
            <td class="title_center">最近 6 个月平均应还款</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02GS01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02GS02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02GJ01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02GJ02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02GJ03!}</td>
        </tr>
    </table>
    <br>

    <#--贷记卡账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="7">贷记卡账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">发卡机构数</td>
            <td class="title_center">账户数</td>
            <td class="title_center">授信总额</td>
            <td class="title_center">单家机构<br>最高授信额</td>
            <td class="title_center">单家机构<br>最低授信额</td>
            <td class="title_center">已用额度</td>
            <td class="title_center">最近6个月<br>平均使用额度</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02HS01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HS02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HJ01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HJ02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HJ03!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HJ04!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02HJ05!}</td>
        </tr>
    </table>
    <br>

    <#--准贷记卡账户信息汇总-->
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="7">准贷记卡账户信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">发卡机构数</td>
            <td class="title_center">账户数</td>
            <td class="title_center">授信总额</td>
            <td class="title_center">单家机构<br>最高授信额</td>
            <td class="title_center">单家机构<br>最低授信额</td>
            <td class="title_center">已用额度</td>
            <td class="title_center">最近6个月<br>平均使用额度</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PCO.PC02IS01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02IS02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02IJ01!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02IJ02!}</td>
            <td class="content_center">${map.CR_PER_PCO.PC02IJ03!}</td>
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

    <h3>（五）非信贷交易信息概要</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">后付费业务欠费信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">业务类型</td>
            <td class="title_center">账户数</td>
            <td class="title_center">欠费金额</td>
        </tr>
        
        <#--
        <tr>
            <td class="title_center">电信业务</td>
            <td class="content_center">${map.CR_PER_PC030H_1.PC030S02!}</td>
            <td class="content_center">${map.CR_PER_PC030H_1.PC030J01!}</td>
        </tr>
        -->
        
        <#list map.CR_PER_PC030H! as CR_PER_PC030H>
            <tr>
                <td class="title_center">${DataDicUtil.getDataDic("6016",CR_PER_PC030H.PC030D01)!}</td>
                <td class="content_center">${CR_PER_PC030H.PC030S02!}</td>
                <td class="content_center">${CR_PER_PC030H.PC030J01!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（六）公共信息概要</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">公共信息汇总</td>
        </tr>
        <tr>
            <td class="title_center">信息类型</td>
            <td class="title_center">记录数</td>
            <td class="title_center">涉及金额</td>
        </tr>
        <#list map.CR_PER_PC040H! as CR_PER_PC040H>
            <tr>
                <td class="title_center">${DataDicUtil.getDataDic("6017",CR_PER_PC040H.PC040D01)!}</td>
                <td class="content_center">${CR_PER_PC040H.PC040S02!}</td>
                <td class="content_center">${CR_PER_PC040H.PC040J01!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（九）查询记录概要</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">上一次查询记录</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PQO.PC05AR01!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05AI01!}</td>
            <td class="content_center">${DataDicUtil.getDataDic("6004",map.CR_PER_PQO.PC05AQ01)!}</td>
        </tr>
    </table>
    <br>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">最近1个月内的查询机构数</td>
            <td class="title_center" colspan="3">最近1个月内的查询次数 </td>
            <td class="title_center" colspan="2">最近2年内的查询次数</td>
        </tr>
        <tr>
            <td class="content_center">贷款审批</td>
            <td class="content_center">信用卡审批</td>
            <td class="content_center">贷款审批</td>
            <td class="content_center">信用卡审批</td>
            <td class="content_center">本人查询</td>
            <td class="content_center">贷后管理</td>
            <td class="content_center">担保资格审查</td>
            <td class="content_center">特约商户实名审查</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PQO.PC05BS01!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05BS02!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05BS03!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05BS04!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05BS05!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05BS06!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05BS07!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05BS08!}</td>
        </tr>
    </table>
    <br>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="2">异议及说明信息</td>
        </tr>
        <tr>
            <td class="title_center">异议标注</td>
            <td class="title_center">添加日期</td>
        </tr>
        <tr>
            <td class="content_center">信贷交易信息提示正处于异议处理中。</td>
            <td class="content_center">2015.04.22</td>
        </tr>
    </table>
    <br>
    

</div>
</body>
</html>