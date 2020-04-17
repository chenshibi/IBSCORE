<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>二代个人信贷交易明细</title>

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
        }

        .content_right {
            text-align: right;
            word-break: break-all;
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
    <h3 class="content_left" style="margin-left: 24px;"></h3>

    <h1>二代个人信贷交易明细</h1>
    <h2>信贷交易信息明细</h2>
    <h3>（一）被追偿信息 </h3>
    <#list map.PDA_AD01_C1! as PDA_AD01_C1>
        <#--基本信息-->
        <h4 class="title_left" style="margin-left:20px; ">账户 ${PDA_AD01_C1.PD01AI01!}</h4>
        <table class="fixedTable">
            <tr>
                <td class="title_center">管理机构</td>
                <td class="title_center">业务种类</td>
                <td class="title_center">债权接收日期</td>
                <td class="title_center">债权金额</td>
                <td class="title_center">债权转移时的还款状态</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6082",PDA_AD01_C1.PD01AD02)!} “${PDA_AD01_C1.PD01AI02!}”</td>
                <td class="content_center">${DataDicUtil.getDataDic("6020",PDA_AD01_C1.PD01AD03)!}</td>
                <td class="content_center">${PDA_AD01_C1.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_C1.PD01AJ01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6026",PDA_AD01_C1.PD01AD10)!}</td>
            </tr>
        </table>
        <#--最新表现信息-->
        <table class="fixedTable">
            <#if PDA_AD01_C1.PD01BD01??>
            <#if PDA_AD01_C1.PD01BD01 == '1'>
                <tr>
                    <td class="title_center no_border_top" colspan="3">截至${PDA_AD01_C1.PD01BR03!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">余额</td>
                    <td class="title_center">最近一次还款日期</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6031",PDA_AD01_C1.PD01BD01)!}</td>
                    <td class="content_center">${PDA_AD01_C1.PD01BJ01!}</td>
                    <td class="content_center">${PDA_AD01_C1.PD01BR02!}</td>
                </tr>
            <#elseif PDA_AD01_C1.PD01BD01 == '2'>
                <tr>
                    <td class="title_center no_border_top" colspan="2">截至${PDA_AD01_C1.PD01BR03!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">账户关闭日期</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6031",PDA_AD01_C1.PD01BD01)!}</td>
                    <td class="content_center">${PDA_AD01_C1.PD01BR01!}</td>
                </tr>
            </#if>
            </#if>
        </table>
        <#--特殊交易信息-->
        <#if map.PDA_AD01_C1_PD01FH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">特殊交易类型</td>
                    <td class="title_center no_border_top">发生日期</td>
                    <td class="title_center no_border_top">变更月数</td>
                    <td class="title_center no_border_top">发生金额</td>
                    <td class="title_center no_border_top">明细记录</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6037",map.PDA_AD01_C1_PD01FH.PD01FD01)!}</td>
                    <td class="content_center">${map.PDA_AD01_C1_PD01FH.PD01FR01!}</td>
                    <td class="content_center">${map.PDA_AD01_C1_PD01FH.PD01FS02!}</td>
                    <td class="content_center">${map.PDA_AD01_C1_PD01FH.PD01FJ01!}</td>
                    <td class="content_center">${map.PDA_AD01_C1_PD01FH.PD01FQ01!}</td>
                </tr>
            </table>
        </#if>
        <#--标注及声明信息-->
        <#if map.PDA_AD01_C1_PD01ZH??>
            <#list map.PDA_AD01_C1_PD01ZH! as PDA_AD01_C1_PD01ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${DataDicUtil.getDataDic("6039",PDA_AD01_C1_PD01ZH.PD01ZD01)!}</td>
                        <td class="title_center no_border_top">添加日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${PDA_AD01_C1_PD01ZH.PD01ZQ01!}</td>
                        <td class="content_center">${PDA_AD01_C1_PD01ZH.PD01ZR01!}</td>
                    </tr>
                </table>
            </#list>
        </#if>
        <br>
    </#list>

    <h3>（二）非循环贷账户(共${map.PDA_AD01_D1?size!}笔)</h3>
    <#list map.PDA_AD01_D1! as PDA_AD01_D1>
        <h4 class="title_left" style="margin-left:20px; ">账户${PDA_AD01_D1.PD01AI01!}（授信协议标识：）${PDA_AD01_D1.PD01AI04!}</h4>
        <#--基本信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center">管理机构</td>
                <td class="title_center">账户标识</td>
                <td class="title_center">开立日期</td>
                <td class="title_center">到期日期</td>
                <td class="title_center">借款金额</td>
                <td class="title_center">账户币种</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6082",PDA_AD01_D1.PD01AD02)!} ${PDA_AD01_D1.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AR02!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AJ01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6058",PDA_AD01_D1.PD01AD04)!}</td>
            </tr>
            <tr>
                <td class="title_center">业务种类</td>
                <td class="title_center">担保方式</td>
                <td class="title_center">还款期数</td>
                <td class="title_center">还款频率</td>
                <td class="title_center">还款方式</td>
                <td class="title_center">共同借款标志</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6020",PDA_AD01_D1.PD01AD03)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6024",PDA_AD01_D1.PD01AD07)!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AS01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6022",PDA_AD01_D1.PD01AD06)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6021",PDA_AD01_D1.PD01AD05)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6025",PDA_AD01_D1.PD01AD09)!}</td>
            </tr>
        </table>
        <#--最近一次月度表现信息 非 3-结清,4-呆账,5-转出 状态下显示-->
        <#if PDA_AD01_D1.PD01CD01??>
	        <#if !(PDA_AD01_D1.PD01CD01 == '3' || PDA_AD01_D1.PD01CD01 == '4' || PDA_AD01_D1.PD01CD01 == '5')>
	        <#--<#if PDA_AD01_D1.PD01BD01 == '1' || PDA_AD01_D1.PD01BD01 == '2' || PDA_AD01_D1.PD01BD01 == '6'|| PDA_AD01_D1.PD01BD01 == '7'|| PDA_AD01_D1.PD01BD01 == '8'>-->
	            <table class="fixedTable">
	                <tr>
	                    <td class="title_center no_border_top" colspan="8">截至${PDA_AD01_D1.PD01CR04!}</td>
	                </tr>
	                <tr>
	                    <td class="title_center" colspan="1">账户状态</td>
	                    <td class="title_center" colspan="1">五级分类</td>
	                    <td class="title_center" colspan="1">余额</td>
	                    <td class="title_center" colspan="1">剩余还款期数</td>
	                    <td class="title_center" colspan="1">本月应还款</td>
	                    <td class="title_center" colspan="1">应还款日</td>
	                    <td class="title_center" colspan="1">本月实还款</td>
	                    <td class="title_center" colspan="1">最近一次还款日期</td>
	                </tr>
	                <tr>
	                    <td class="content_center">${DataDicUtil.getDataDic("6027",PDA_AD01_D1.PD01CD01)!}</td>
	                    <td class="content_center">${DataDicUtil.getDataDic("6032",PDA_AD01_D1.PD01CD02)!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CJ01!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CS01!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CJ04!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CR02!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CJ05!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CR03!}</td>
	                </tr>
	            </table>
	            <table class="fixedTable">
	                <tr>
	                    <td class="title_center no_border_top">当前逾期期数</td>
	                    <td class="title_center no_border_top">当前逾期总额</td>
	                    <td class="title_center no_border_top">逾期31—60天未还本金</td>
	                    <td class="title_center no_border_top">逾期61—90天未还本金</td>
	                    <td class="title_center no_border_top">逾期91—180天未还本金</td>
	                    <td class="title_center no_border_top">逾期180天以上未还本金</td>
	                </tr>
	                <tr>
	                    <td class="content_center">${PDA_AD01_D1.PD01CS02!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CJ06!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CJ07!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CJ08!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CJ09!}</td>
	                    <td class="content_center">${PDA_AD01_D1.PD01CJ10!}</td>
	                </tr>
	            </table>
	        </#if>
	    </#if>	
        <#--最新表现信息-->
        <#if PDA_AD01_D1.PD01BD01??>
            <#if PDA_AD01_D1.PD01BD01 == '4'>
                <#--呆账-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="3">截至${PDA_AD01_D1.PD01BR03!}</td>
                    </tr>
                    <tr>
                        <td class="title_center">账户状态</td>
                        <td class="title_center">余额</td>
                        <td class="title_center">最近一次还款日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${DataDicUtil.getDataDic("6027",PDA_AD01_D1.PD01BD01)!}</td>
                        <td class="content_center">${PDA_AD01_D1.PD01BJ01!}</td>
                        <td class="content_center">${PDA_AD01_D1.PD01BR02!}</td>
                    </tr>
                </table>
            <#elseif PDA_AD01_D1.PD01BD01 == '5'>
                <#--转出-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="2">截至${PDA_AD01_D1.PD01BR03!}</td>
                    </tr>
                    <tr>
                        <td class="title_center">账户状态</td>
                        <td class="title_center">转出月份</td>
                    </tr>
                    <tr>
                        <td class="content_center">${DataDicUtil.getDataDic("6027",PDA_AD01_D1.PD01BD01)!}</td>
                        <td class="content_center">${PDA_AD01_D1.PD01BR04!}</td>
                    </tr>
                </table>
            <#elseif PDA_AD01_D1.PD01BD01 == '3'>
                <#--结清-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="2">截至${PDA_AD01_D1.PD01BR03!}</td>
                    </tr>
                    <tr>
                        <td class="title_center">账户状态</td>
                        <td class="title_center">关闭日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${DataDicUtil.getDataDic("6027",PDA_AD01_D1.PD01BD01)!}</td>
                        <td class="content_center">${PDA_AD01_D1.PD01BR01!}</td>
                    </tr>
                </table>
            <#else>
                <#--持续更新-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="5">${PDA_AD01_D1.PD01BR03!}以后的最新还款记录</td>
                    </tr>
                    <tr>
                        <td class="title_center">五级分类</td>
                        <td class="title_center">余额</td>
                        <td class="title_center">还款日期</td>
                        <td class="title_center">还款金额</td>
                        <td class="title_center">当前还款状态</td>
                    </tr>
                    <tr>
                        <td class="content_center">${DataDicUtil.getDataDic("6032",PDA_AD01_D1.PD01BD03)!}</td>
                        <td class="content_center">${PDA_AD01_D1.PD01BJ01!}</td>
                        <td class="content_center">${PDA_AD01_D1.PD01BR02!}</td>
                        <td class="content_center">${PDA_AD01_D1.PD01BJ02!}</td>
                        <td class="content_center">${PDA_AD01_D1.PD01BD04!}</td>
                    </tr>
                </table>
            </#if>
        </#if>
        <#--最近5年历史表现信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center no_border_top" colspan="13">${PDA_AD01_D1.PD01ER01!}—${PDA_AD01_D1.PD01ER02!}的还款记录</td>
            </tr>
            <tr>
                <td class="title_center"></td>
                <td class="title_center">1</td>
                <td class="title_center">2</td>
                <td class="title_center">3</td>
                <td class="title_center">4</td>
                <td class="title_center">5</td>
                <td class="title_center">6</td>
                <td class="title_center">7</td>
                <td class="title_center">8</td>
                <td class="title_center">9</td>
                <td class="title_center">10</td>
                <td class="title_center">11</td>
                <td class="title_center">12</td>
            </tr>
           <#list map.PDA_AD01_D1_PD01EH! as PDA_AD01_D1_PD01EH_OUTER>
            	<#if PDA_AD01_D1_PD01EH_OUTER.PARENT_ID == PDA_AD01_D1.ID>
            	<#list PDA_AD01_D1_PD01EH_OUTER.LIST! as PDA_AD01_D1_PD01EH>
                <tr>
                    <td class="title_center" rowspan="2">${PDA_AD01_D1_PD01EH.YEAR!}</td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M01??>
                            ${PDA_AD01_D1_PD01EH.M01.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M02??>
                            ${PDA_AD01_D1_PD01EH.M02.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M03??>
                            ${PDA_AD01_D1_PD01EH.M03.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M04??>
                            ${PDA_AD01_D1_PD01EH.M04.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M05??>
                            ${PDA_AD01_D1_PD01EH.M05.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M06??>
                            ${PDA_AD01_D1_PD01EH.M06.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M07??>
                            ${PDA_AD01_D1_PD01EH.M07.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M08??>
                            ${PDA_AD01_D1_PD01EH.M08.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M09??>
                            ${PDA_AD01_D1_PD01EH.M09.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M10??>
                            ${PDA_AD01_D1_PD01EH.M10.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M11??>
                            ${PDA_AD01_D1_PD01EH.M11.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M12??>
                            ${PDA_AD01_D1_PD01EH.M12.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M01??>
                            ${PDA_AD01_D1_PD01EH.M01.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M02??>
                            ${PDA_AD01_D1_PD01EH.M02.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M03??>
                            ${PDA_AD01_D1_PD01EH.M03.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M04??>
                            ${PDA_AD01_D1_PD01EH.M04.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M05??>
                            ${PDA_AD01_D1_PD01EH.M05.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M06??>
                            ${PDA_AD01_D1_PD01EH.M06.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M07??>
                            ${PDA_AD01_D1_PD01EH.M07.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M08??>
                            ${PDA_AD01_D1_PD01EH.M08.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M09??>
                            ${PDA_AD01_D1_PD01EH.M09.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M10??>
                            ${PDA_AD01_D1_PD01EH.M10.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M11??>
                            ${PDA_AD01_D1_PD01EH.M11.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M12??>
                            ${PDA_AD01_D1_PD01EH.M12.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                </tr>
            </#list>
            </#if>
            </#list>
            <#--<tr>
                <td class="title_center" rowspan="2">2015</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
            </tr>
            <tr>
                <td class="content_center no_border_top">16,200</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,400</td>
                <td class="content_center no_border_top">16,500</td>
                <td class="content_center no_border_top">16,600</td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
            </tr>
            <tr>
                <td class="title_center" rowspan="2">2014</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
            </tr>
            <tr>
                <td class="content_center no_border_top">16,200</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
            </tr>
            <tr>
                <td class="title_center" rowspan="2">2013</td>
                <td class="content_center" style="border-bottom: 1px dashed;">3</td>
                <td class="content_center" style="border-bottom: 1px dashed;">4</td>
                <td class="content_center" style="border-bottom: 1px dashed;">5</td>
                <td class="content_center" style="border-bottom: 1px dashed;">6</td>
                <td class="content_center" style="border-bottom: 1px dashed;">7</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
            </tr>
            <tr>
                <td class="content_center no_border_top">16,200</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
            </tr>-->
        </table>
        <#--特殊事件说明-->
        <#if map.PDA_AD01_D1_PD01GH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">特殊事件说明</td>
                </tr>
                <tr>
                    <td class="content_center">该账户${map.PDA_AD01_D1_PD01GH.PD01GR01!}${DataDicUtil.getDataDic("6038",map.PDA_AD01_D1_PD01GH.PD01GD01)!}</td>
                </tr>
            </table>
        </#if>
        <#--特殊交易信息-->
        <#if map.PDA_AD01_D1_PD01FH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">特殊交易类型</td>
                    <td class="title_center no_border_top">发生日期</td>
                    <td class="title_center no_border_top">变更月数</td>
                    <td class="title_center no_border_top">发生金额</td>
                    <td class="title_center no_border_top">明细记录</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6037",map.PDA_AD01_D1_PD01FH.PD01FD01)!}</td>
                    <td class="content_center">${map.PDA_AD01_D1_PD01FH.PD01FR01!}</td>
                    <td class="content_center">${map.PDA_AD01_D1_PD01FH.PD01FS02!}</td>
                    <td class="content_center">${map.PDA_AD01_D1_PD01FH.PD01FJ01!}</td>
                    <td class="content_center">${map.PDA_AD01_D1_PD01FH.PD01FQ01!}</td>
                </tr>
            </table>
        </#if>
        <#--标注及声明信息-->
        <#if map.PDA_AD01_D1_PD01ZH??>
            <#list map.PDA_AD01_D1_PD01ZH! as PDA_AD01_D1_PD01ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${DataDicUtil.getDataDic("6039",PDA_AD01_D1_PD01ZH.PD01ZD01)!}</td>
                        <td class="title_center no_border_top">添加日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${PDA_AD01_D1_PD01ZH.PD01ZQ01!}</td>
                        <td class="content_center">${PDA_AD01_D1_PD01ZH.PD01ZR01!}</td>
                    </tr>
                </table>
            </#list>
        </#if>
        <br>
    </#list>

    <h3>（三）循环额度下分账户 </h3>
    <div style="margin: 4px 0px;font-style: italic;font-size: 14px;">（由于该类账户的数量过大，本报告中仅展示最新的 N 个账户。）</div>
    <#list map.PDA_AD01_R4! as PDA_AD01_R4>
        <h4 class="title_left" style="margin-left:20px; ">账户${PDA_AD01_R4.PD01AI01!}（授信协议标识：）${PDA_AD01_R4.PD01AI04!}</h4>
        <#--基本信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center">管理机构</td>
                <td class="title_center">账户标识</td>
                <td class="title_center">开立日期</td>
                <td class="title_center">到期日期</td>
                <td class="title_center">借款金额</td>
                <td class="title_center">账户币种</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6082",PDA_AD01_R4.PD01AD02)!} “${PDA_AD01_R4.PD01AI02!}”</td>
                <td class="content_center">${PDA_AD01_R4.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AR02!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AJ01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6058",PDA_AD01_R4.PD01AD04)!}</td>
            </tr>
            <tr>
                <td class="title_center">业务种类</td>
                <td class="title_center">担保方式</td>
                <td class="title_center">还款期数</td>
                <td class="title_center">还款频率</td>
                <td class="title_center">还款方式</td>
                <td class="title_center">共同借款标志</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6020",PDA_AD01_R4.PD01AD03)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6024",PDA_AD01_R4.PD01AD07)!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AS01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6022",PDA_AD01_R4.PD01AD06)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6021",PDA_AD01_R4.PD01AD05)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6025",PDA_AD01_R4.PD01AD09)!}</td>
            </tr>
        </table>
        <#--最近一次月度表现信息 非 3-结清,4-呆账 状态下显示-->
        <#if PDA_AD01_R4.PD01BD01??>
        <#if !(PDA_AD01_R4.PD01BD01 == '3' || PDA_AD01_R4.PD01BD01 == '4')>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="8">截至${PDA_AD01_R4.PD01CR04!}</td>
                </tr>
                <tr>
                    <td class="title_center" colspan="1">账户状态</td>
                    <td class="title_center" colspan="1">五级分类</td>
                    <td class="title_center" colspan="1">余额</td>
                    <td class="title_center" colspan="1">剩余还款期数</td>
                    <td class="title_center" colspan="1">本月应还款</td>
                    <td class="title_center" colspan="1">应还款日</td>
                    <td class="title_center" colspan="1">本月实还款</td>
                    <td class="title_center" colspan="1">最近一次还款日期</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6030",PDA_AD01_R4.PD01CD01)!}</td>
                    <td class="content_center">${DataDicUtil.getDataDic("6032",PDA_AD01_R4.PD01CD02)!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CJ01!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CS01!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CJ04!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CR02!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CJ05!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CR03!}</td>
                </tr>
            </table>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">当前逾期期数</td>
                    <td class="title_center no_border_top">当前逾期总额</td>
                    <td class="title_center no_border_top">逾期31—60天未还本金</td>
                    <td class="title_center no_border_top">逾期61—90天未还本金</td>
                    <td class="title_center no_border_top">逾期91—180天未还本金</td>
                    <td class="title_center no_border_top">逾期180天以上未还本金</td>
                </tr>
                <tr>
                    <td class="content_center">${PDA_AD01_R4.PD01CS02!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CJ06!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CJ07!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CJ08!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CJ09!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CJ10!}</td>
                </tr>
            </table>
        </#if>
        </#if>
        <#--最新表现信息-->
        <#if PDA_AD01_R4.PD01BD01??>
            <#if PDA_AD01_R4.PD01BD01 == '4'>
                <#--呆账-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="3">截至${PDA_AD01_R4.PD01BR03!}</td>
                    </tr>
                    <tr>
                        <td class="title_center">账户状态</td>
                        <td class="title_center">余额</td>
                        <td class="title_center">最近一次还款日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${DataDicUtil.getDataDic("6030",PDA_AD01_R4.PD01BD01)!}</td>
                        <td class="content_center">${PDA_AD01_R4.PD01BJ01!}</td>
                        <td class="content_center">${PDA_AD01_R4.PD01BR02!}</td>
                    </tr>
                </table>
            <#elseif PDA_AD01_R4.PD01BD01 == '3'>
                <#--结清-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="6">截至${PDA_AD01_R4.PD01BR03!}</td>
                    </tr>
                    <tr>
                        <td class="title_center" colspan="3">账户状态</td>
                        <td class="title_center" colspan="3">关闭日期</td>
                    </tr>
                    <tr>
                        <td class="content_center" colspan="3">${DataDicUtil.getDataDic("6030",PDA_AD01_R4.PD01BD01)!}</td>
                        <td class="content_center" colspan="3">${PDA_AD01_R4.PD01BR01!}</td>
                    </tr>
                </table>
            <#else>
                <#--持续更新-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="5">${PDA_AD01_R4.PD01BR03!}以后的最新还款记录</td>
                    </tr>
                    <tr>
                        <td class="title_center">五级分类</td>
                        <td class="title_center">余额</td>
                        <td class="title_center">还款日期</td>
                        <td class="title_center">还款金额</td>
                        <td class="title_center">当前还款状态</td>
                    </tr>
                    <tr>
                        <td class="content_center">${DataDicUtil.getDataDic("6032",PDA_AD01_R4.PD01BD03)!}</td>
                        <td class="content_center">${PDA_AD01_R4.PD01BJ01!}</td>
                        <td class="content_center">${PDA_AD01_R4.PD01BR02!}</td>
                        <td class="content_center">${PDA_AD01_R4.PD01BJ02!}</td>
                        <td class="content_center">${PDA_AD01_R4.PD01BD04!}</td>
                    </tr>
                </table>
            </#if>
        </#if>
        <#--最近5年历史表现信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center no_border_top" colspan="13">${PDA_AD01_R4.PD01ER01!}—${PDA_AD01_R4.PD01ER02!}的还款记录</td>
            </tr>
            <tr>
                <td class="title_center"></td>
                <td class="title_center">1</td>
                <td class="title_center">2</td>
                <td class="title_center">3</td>
                <td class="title_center">4</td>
                <td class="title_center">5</td>
                <td class="title_center">6</td>
                <td class="title_center">7</td>
                <td class="title_center">8</td>
                <td class="title_center">9</td>
                <td class="title_center">10</td>
                <td class="title_center">11</td>
                <td class="title_center">12</td>
            </tr>
            <#list map.PDA_AD01_R4_PD01EH! as PDA_AD01_R4_PD01EH_OUTER>
            	<#if PDA_AD01_R4_PD01EH_OUTER.PARENT_ID == PDA_AD01_R4.ID>
            	<#list PDA_AD01_R4_PD01EH_OUTER.LIST! as PDA_AD01_R4_PD01EH>
                <tr>
                    <td class="title_center" rowspan="2">${PDA_AD01_R4_PD01EH.YEAR!}</td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M01??>
                            ${PDA_AD01_R4_PD01EH.M01.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M02??>
                            ${PDA_AD01_R4_PD01EH.M02.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M03??>
                            ${PDA_AD01_R4_PD01EH.M03.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M04??>
                            ${PDA_AD01_R4_PD01EH.M04.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M05??>
                            ${PDA_AD01_R4_PD01EH.M05.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M06??>
                            ${PDA_AD01_R4_PD01EH.M06.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M07??>
                            ${PDA_AD01_R4_PD01EH.M07.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M08??>
                            ${PDA_AD01_R4_PD01EH.M08.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M09??>
                            ${PDA_AD01_R4_PD01EH.M09.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M10??>
                            ${PDA_AD01_R4_PD01EH.M10.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M11??>
                            ${PDA_AD01_R4_PD01EH.M11.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M12??>
                            ${PDA_AD01_R4_PD01EH.M12.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M01??>
                            ${PDA_AD01_R4_PD01EH.M01.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M02??>
                            ${PDA_AD01_R4_PD01EH.M02.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M03??>
                            ${PDA_AD01_R4_PD01EH.M03.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M04??>
                            ${PDA_AD01_R4_PD01EH.M04.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M05??>
                            ${PDA_AD01_R4_PD01EH.M05.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M06??>
                            ${PDA_AD01_R4_PD01EH.M06.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M07??>
                            ${PDA_AD01_R4_PD01EH.M07.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M08??>
                            ${PDA_AD01_R4_PD01EH.M08.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M09??>
                            ${PDA_AD01_R4_PD01EH.M09.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M10??>
                            ${PDA_AD01_R4_PD01EH.M10.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M11??>
                            ${PDA_AD01_R4_PD01EH.M11.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M12??>
                            ${PDA_AD01_R4_PD01EH.M12.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                </tr>
            </#list>
             </#if>
            </#list>
            <#--<tr>
                <td class="title_center" rowspan="2">2015</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
                <td class="content_center" style="border-bottom: 1px dashed;"></td>
            </tr>
            <tr>
                <td class="content_center no_border_top">16,200</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,400</td>
                <td class="content_center no_border_top">16,500</td>
                <td class="content_center no_border_top">16,600</td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
                <td class="content_center no_border_top"></td>
            </tr>
            <tr>
                <td class="title_center" rowspan="2">2014</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
            </tr>
            <tr>
                <td class="content_center no_border_top">16,200</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
            </tr>
            <tr>
                <td class="title_center" rowspan="2">2013</td>
                <td class="content_center" style="border-bottom: 1px dashed;">3</td>
                <td class="content_center" style="border-bottom: 1px dashed;">4</td>
                <td class="content_center" style="border-bottom: 1px dashed;">5</td>
                <td class="content_center" style="border-bottom: 1px dashed;">6</td>
                <td class="content_center" style="border-bottom: 1px dashed;">7</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
                <td class="content_center" style="border-bottom: 1px dashed;">B</td>
            </tr>
            <tr>
                <td class="content_center no_border_top">16,200</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
                <td class="content_center no_border_top">16,300</td>
            </tr>-->
        </table>
        <#--特殊交易信息-->
        <#if map.PDA_AD01_R4_PD01FH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">特殊交易类型</td>
                    <td class="title_center no_border_top">发生日期</td>
                    <td class="title_center no_border_top">变更月数</td>
                    <td class="title_center no_border_top">发生金额</td>
                    <td class="title_center no_border_top">明细记录</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6037",map.PDA_AD01_R4_PD01FH.PD01FD01)!}</td>
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FR01!}</td>
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FS02!}</td>
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FJ01!}</td>
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FQ01!}</td>
                </tr>
            </table>
        <#else >--
        </#if>
        <#--标注及声明信息-->
        <#if map.PDA_AD01_R4_PD01ZH??>
            <#list map.PDA_AD01_R4_PD01ZH! as PDA_AD01_R4_PD01ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${DataDicUtil.getDataDic("6039",PDA_AD01_R4_PD01ZH.PD01ZD01)!}</td>
                        <td class="title_center no_border_top">添加日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${PDA_AD01_R4_PD01ZH.PD01ZQ01!}</td>
                        <td class="content_center">${PDA_AD01_R4_PD01ZH.PD01ZR01!}</td>
                    </tr>
                </table>
            </#list>
        </#if>
        <br>
    </#list>

    <h3>（四）循环贷账户</h3>
    <#list map.PDA_AD01_R1! as PDA_AD01_R1>
        <h4 class="title_left" style="margin-left:20px; ">账户${PDA_AD01_R1.PD01AI01!}（授信协议标识：）${PDA_AD01_R1.PD01AI04!}</h4>
        <#--基本信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center">管理机构</td>
                <td class="title_center">账户标识</td>
                <td class="title_center">开立日期</td>
                <td class="title_center">到期日期</td>
                <td class="title_center">借款金额</td>
                <td class="title_center">账户币种</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6082",PDA_AD01_R1.PD01AD02)!}${PDA_AD01_R1.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AR02!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AJ01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6058",PDA_AD01_R1.PD01AD04)!}</td>
            </tr>
            <tr>
                <td class="title_center">业务种类</td>
                <td class="title_center">担保方式</td>
                <td class="title_center">还款期数</td>
                <td class="title_center">还款频率</td>
                <td class="title_center">还款方式</td>
                <td class="title_center">共同借款标志</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6020",PDA_AD01_R1.PD01AD03)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6024",PDA_AD01_R1.PD01AD07)!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AS01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6022",PDA_AD01_R1.PD01AD06)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6021",PDA_AD01_R1.PD01AD05)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6025",PDA_AD01_R1.PD01AD09)!}</td>
            </tr>
        </table>
        <#--最近一次月度表现信息 非 3-结清,4-呆账 状态下显示-->
        <#if PDA_AD01_R1.PD01CD01??>
        <#if !(PDA_AD01_R1.PD01CD01 == '3' || PDA_AD01_R1.PD01CD01 == '4')>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="8">截至${PDA_AD01_R1.PD01CR04!}</td>
                </tr>
                <tr>
                    <td class="title_center" colspan="1">账户状态</td>
                    <td class="title_center" colspan="1">五级分类</td>
                    <td class="title_center" colspan="1">余额</td>
                    <td class="title_center" colspan="1">剩余还款期数</td>
                    <td class="title_center" colspan="1">本月应还款</td>
                    <td class="title_center" colspan="1">应还款日</td>
                    <td class="title_center" colspan="1">本月实还款</td>
                    <td class="title_center" colspan="1">最近一次还款日期</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6028",PDA_AD01_R1.PD01CD01)!}</td>
                    <td class="content_center">${DataDicUtil.getDataDic("6032",PDA_AD01_R1.PD01CD02)!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CJ01!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CS01!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CJ04!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CR02!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CJ05!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CR03!}</td>
                </tr>
            </table>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">当前逾期期数</td>
                    <td class="title_center no_border_top">当前逾期总额</td>
                    <td class="title_center no_border_top">逾期31—60天未还本金</td>
                    <td class="title_center no_border_top">逾期61—90天未还本金</td>
                    <td class="title_center no_border_top">逾期91—180天未还本金</td>
                    <td class="title_center no_border_top">逾期180天以上未还本金</td>
                </tr>
                <tr>
                    <td class="content_center">${PDA_AD01_R1.PD01CS02!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CJ06!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CJ07!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CJ08!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CJ09!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CJ10!}</td>
                </tr>
            </table>
        </#if>
        </#if>
        <#--最新表现信息-->
        <#if PDA_AD01_R1.PD01BD01??>
            <#if PDA_AD01_R1.PD01BD01 == '4'>
                <#--呆账-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="3">截至${PDA_AD01_R1.PD01BR03!}</td>
                    </tr>
                    <tr>
                        <td class="title_center">账户状态</td>
                        <td class="title_center">余额</td>
                        <td class="title_center">最近一次还款日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${DataDicUtil.getDataDic("6028",PDA_AD01_R1.PD01BD01)!}</td>
                        <td class="content_center">${PDA_AD01_R1.PD01BJ01!}</td>
                        <td class="content_center">${PDA_AD01_R1.PD01BR02!}</td>
                    </tr>
                </table>
            <#elseif PDA_AD01_R1.PD01BD01 == '3'>
                <#--结清-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="6">截至${PDA_AD01_R1.PD01BR03!}</td>
                    </tr>
                    <tr>
                        <td class="title_center" colspan="3">账户状态</td>
                        <td class="title_center" colspan="3">关闭日期</td>
                    </tr>
                    <tr>
                        <td class="content_center" colspan="3">${DataDicUtil.getDataDic("6028",PDA_AD01_R1.PD01BD01)!}</td>
                        <td class="content_center" colspan="3">${PDA_AD01_R1.PD01BR01!}</td>
                    </tr>
                </table>
            <#else>
                <#--持续更新-->
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top" colspan="5">${PDA_AD01_R1.PD01BR03!}以后的最新还款记录</td>
                    </tr>
                    <tr>
                        <td class="title_center">五级分类</td>
                        <td class="title_center">余额</td>
                        <td class="title_center">还款日期</td>
                        <td class="title_center">还款金额</td>
                        <td class="title_center">当前还款状态</td>
                    </tr>
                    <tr>
                        <td class="content_center">${DataDicUtil.getDataDic("6032",PDA_AD01_R1.PD01BD03)!}</td>
                        <td class="content_center">${PDA_AD01_R1.PD01BJ01!}</td>
                        <td class="content_center">${PDA_AD01_R1.PD01BR02!}</td>
                        <td class="content_center">${PDA_AD01_R1.PD01BJ02!}</td>
                        <td class="content_center">${PDA_AD01_R1.PD01BD04!}</td>
                    </tr>
                </table>
            </#if>
        </#if>
        <#--最近5年历史表现信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center no_border_top" colspan="13">${PDA_AD01_R1.PD01ER01!}—${PDA_AD01_R1.PD01ER02!}的还款记录</td>
            </tr>
            <tr>
                <td class="title_center"></td>
                <td class="title_center">1</td>
                <td class="title_center">2</td>
                <td class="title_center">3</td>
                <td class="title_center">4</td>
                <td class="title_center">5</td>
                <td class="title_center">6</td>
                <td class="title_center">7</td>
                <td class="title_center">8</td>
                <td class="title_center">9</td>
                <td class="title_center">10</td>
                <td class="title_center">11</td>
                <td class="title_center">12</td>
            </tr>
            <#list map.PDA_AD01_R1_PD01EH! as PDA_AD01_R1_PD01EH>
                <tr>
                    <td class="title_center" rowspan="2">${PDA_AD01_R1_PD01EH.YEAR!}</td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M01??>
                            ${PDA_AD01_R1_PD01EH.M01.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M02??>
                            ${PDA_AD01_R1_PD01EH.M02.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M03??>
                            ${PDA_AD01_R1_PD01EH.M03.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M04??>
                            ${PDA_AD01_R1_PD01EH.M04.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M05??>
                            ${PDA_AD01_R1_PD01EH.M05.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M06??>
                            ${PDA_AD01_R1_PD01EH.M06.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M07??>
                            ${PDA_AD01_R1_PD01EH.M07.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M08??>
                            ${PDA_AD01_R1_PD01EH.M08.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M09??>
                            ${PDA_AD01_R1_PD01EH.M09.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M10??>
                            ${PDA_AD01_R1_PD01EH.M10.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M11??>
                            ${PDA_AD01_R1_PD01EH.M11.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M12??>
                            ${PDA_AD01_R1_PD01EH.M12.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M01??>
                            ${PDA_AD01_R1_PD01EH.M01.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M02??>
                            ${PDA_AD01_R1_PD01EH.M02.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M03??>
                            ${PDA_AD01_R1_PD01EH.M03.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M04??>
                            ${PDA_AD01_R1_PD01EH.M04.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M05??>
                            ${PDA_AD01_R1_PD01EH.M05.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M06??>
                            ${PDA_AD01_R1_PD01EH.M06.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M07??>
                            ${PDA_AD01_R1_PD01EH.M07.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M08??>
                            ${PDA_AD01_R1_PD01EH.M08.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M09??>
                            ${PDA_AD01_R1_PD01EH.M09.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M10??>
                            ${PDA_AD01_R1_PD01EH.M10.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M11??>
                            ${PDA_AD01_R1_PD01EH.M11.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M12??>
                            ${PDA_AD01_R1_PD01EH.M12.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                </tr>
            </#list>
        </table>
        <#--特殊交易信息-->
        <#if map.PDA_AD01_R1_PD01FH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">特殊交易类型</td>
                    <td class="title_center no_border_top">发生日期</td>
                    <td class="title_center no_border_top">变更月数</td>
                    <td class="title_center no_border_top">发生金额</td>
                    <td class="title_center no_border_top">明细记录</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6037",map.PDA_AD01_R1_PD01FH.PD01FD01)!}</td>
                    <td class="content_center">${map.PDA_AD01_R1_PD01FH.PD01FR01!}</td>
                    <td class="content_center">${map.PDA_AD01_R1_PD01FH.PD01FS02!}</td>
                    <td class="content_center">${map.PDA_AD01_R1_PD01FH.PD01FJ01!}</td>
                    <td class="content_center">${map.PDA_AD01_R1_PD01FH.PD01FQ01!}</td>
                </tr>
            </table>
        </#if>
        <#--标注及声明信息-->
        <#if map.PDA_AD01_R1_PD01ZH??>
            <#list map.PDA_AD01_R1_PD01ZH! as PDA_AD01_R1_PD01ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${DataDicUtil.getDataDic("6039",PDA_AD01_R1_PD01ZH.PD01ZD01)!}</td>
                        <td class="title_center no_border_top">添加日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${PDA_AD01_R1_PD01ZH.PD01ZQ01!}</td>
                        <td class="content_center">${PDA_AD01_R1_PD01ZH.PD01ZR01!}</td>
                    </tr>
                </table>
            </#list>
        </#if>
        <br>
    </#list>

    <h3>（五）贷记卡账户</h3>
    <#list map.PDA_AD01_R2! as PDA_AD01_R2>
        <#--基本信息-->
        <h4 class="title_left" style="margin-left:20px; ">账户${PDA_AD01_R2.PD01AI01!}（授信协议标识：${PDA_AD01_R2.PD01AI04!}）</h4>
        <table class="fixedTable">
            <tr>
                <td class="title_center">发卡机构</td>
                <td class="title_center">账户标识</td>
                <td class="title_center">开立日期</td>
                <td class="title_center">账户授信额度</td>
                <td class="title_center">共享授信额度</td>
                <td class="title_center">币种</td>
                <td class="title_center">业务种类</td>
                <td class="title_center">担保方式</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6082",PDA_AD01_R2.PD01AD02)!}${PDA_AD01_R2.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AJ02!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AJ03!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6058",PDA_AD01_R2.PD01AD04)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6020",PDA_AD01_R2.PD01AD03)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6024",PDA_AD01_R2.PD01AD07)!}</td>
            </tr>
        </table>
        <#--最近一月表现信息 非 4-销户 5-呆账 6-未激活 状态下显示-->
        <#if PDA_AD01_R2.PD01CD01?? >
        <#if !(PDA_AD01_R2.PD01CD01 == '4' || PDA_AD01_R2.PD01CD01 == '5' || PDA_AD01_R2.PD01CD01 == '6')>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="7" >截至${PDA_AD01_R2.PD01CR04!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">余额</td>
                    <td class="title_center">已用额度</td>
                    <td class="title_center">未出单的大额<br>专项分期余额</td>
                    <td class="title_center">剩余分期期数</td>
                    <td class="title_center">最近 6 个月<br>平均使用额度</td>
                    <td class="title_center">最大使用额度</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6029",PDA_AD01_R2.PD01CD01)!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CJ01!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CJ02!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CJ03!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CS01!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CJ12!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CJ14!}</td>
                </tr>
                <tr>
                    <td class="title_center no_border_top">账单日</td>
                    <td class="title_center no_border_top">本月应还款</td>
                    <td class="title_center no_border_top">本月实还款</td>
                    <td class="title_center no_border_top">最近一次还款日期</td>
                    <td class="title_center no_border_top">当前逾期期数</td>
                    <td class="title_center no_border_top">最近当前逾期总额</td>
                </tr>
                <tr>
                    <td class="content_center">${PDA_AD01_R2.PD01CR02!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CJ04!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CJ05!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CR03!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CS02!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01CJ06!}</td>
                </tr>
            </table>
        </#if>
        </#if>
        <#--大额专项分期信息-->
        <#if map.PDA_AD01_R2_PD01HH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">大额专项分期信息</td>
                </tr>
                <tr>
                    <td class="title_center">大额专项分期额度</td>
                    <td class="title_center">分期额度生效日期</td>
                    <td class="title_center">分期额度到期日期</td>
                    <td class="title_center">已用分期金额</td>
                </tr>
                <tr>
                    <td class="content_center">${map.PDA_AD01_R2_PD01HH.PD01HJ01!}</td>
                    <td class="content_center">${map.PDA_AD01_R2_PD01HH.PD01HR01!}</td>
                    <td class="content_center">${map.PDA_AD01_R2_PD01HH.PD01HR02!}</td>
                    <td class="content_center">${map.PDA_AD01_R2_PD01HH.PD01HJ02!}</td>
                </tr>
            </table>
        </#if>
        <#--最新表现信息-->
         <#if PDA_AD01_R2.PD01BD01?? >
        <#if PDA_AD01_R2.PD01BD01 == '4' >
            <#--销户-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">截至${PDA_AD01_R2.PD01BR03!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">销户日期</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6029",PDA_AD01_R2.PD01BD01)!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BR01!}</td>
                </tr>
            </table>
        <#elseif PDA_AD01_R2.PD01BD01 == '5'>
            <#--呆账-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">截至${PDA_AD01_R2.PD01BR03!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">余额</td>
                    <td class="title_center">最近一次还款日期</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6029",PDA_AD01_R2.PD01BD01)!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BJ01!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BR02!}</td>
                </tr>
            </table>
        <#elseif PDA_AD01_R2.PD01BD01 == '6'>
            <#--未激活-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">截至${PDA_AD01_R2.PD01BR03!}，账户状态为“未激活”。</td>
                </tr>
            </table>
        <#else >
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">${PDA_AD01_R2.PD01BR03!}以后的最新还款记录</td>
                </tr>
                <tr>
                    <td class="title_center">五级分类</td>
                    <td class="title_center">余额</td>
                    <td class="title_center">还款日期</td>
                    <td class="title_center">还款金额</td>
                    <td class="title_center">当前还款状态</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6032",PDA_AD01_R2.PD01BD03)!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BJ01!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BR02!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BJ02!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BD04!}</td>
                </tr>
            </table>
        </#if>
        </#if>
        <#--最近5年历史表现信息 账户状态未激活状态下显示-->
         <#if PDA_AD01_R2.PD01CD01?? >
        <#if PDA_AD01_R2.PD01CD01 != '6'>
            <table class="fixedTable">
            <tr>
                <td class="title_center no_border_top" colspan="13">${PDA_AD01_R2.PD01ER01!}—${PDA_AD01_R2.PD01ER02!}的还款记录</td>
            </tr>
            <tr>
                <td class="title_center"></td>
                <td class="title_center">1</td>
                <td class="title_center">2</td>
                <td class="title_center">3</td>
                <td class="title_center">4</td>
                <td class="title_center">5</td>
                <td class="title_center">6</td>
                <td class="title_center">7</td>
                <td class="title_center">8</td>
                <td class="title_center">9</td>
                <td class="title_center">10</td>
                <td class="title_center">11</td>
                <td class="title_center">12</td>
            </tr>
            <#list map.PDA_AD01_R2_PD01EH! as PDA_AD01_R2_PD01EH_OUTER>
            	<#if PDA_AD01_R2_PD01EH_OUTER.PARENT_ID == PDA_AD01_R2.ID>
            	<#list PDA_AD01_R2_PD01EH_OUTER.LIST! as PDA_AD01_R2_PD01EH>
                <tr>
                    <td class="title_center" rowspan="2">${PDA_AD01_R2_PD01EH.YEAR!}</td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M01??>
                            ${PDA_AD01_R2_PD01EH.M01.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M02??>
                            ${PDA_AD01_R2_PD01EH.M02.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M03??>
                            ${PDA_AD01_R2_PD01EH.M03.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M04??>
                            ${PDA_AD01_R2_PD01EH.M04.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M05??>
                            ${PDA_AD01_R2_PD01EH.M05.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M06??>
                            ${PDA_AD01_R2_PD01EH.M06.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M07??>
                            ${PDA_AD01_R2_PD01EH.M07.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M08??>
                            ${PDA_AD01_R2_PD01EH.M08.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M09??>
                            ${PDA_AD01_R2_PD01EH.M09.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M10??>
                            ${PDA_AD01_R2_PD01EH.M10.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M11??>
                            ${PDA_AD01_R2_PD01EH.M11.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M12??>
                            ${PDA_AD01_R2_PD01EH.M12.PD01ED01!}
                        <#else >--
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M01??>
                            ${PDA_AD01_R2_PD01EH.M01.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M02??>
                            ${PDA_AD01_R2_PD01EH.M02.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M03??>
                            ${PDA_AD01_R2_PD01EH.M03.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M04??>
                            ${PDA_AD01_R2_PD01EH.M04.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M05??>
                            ${PDA_AD01_R2_PD01EH.M05.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M06??>
                            ${PDA_AD01_R2_PD01EH.M06.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M07??>
                            ${PDA_AD01_R2_PD01EH.M07.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M08??>
                            ${PDA_AD01_R2_PD01EH.M08.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M09??>
                            ${PDA_AD01_R2_PD01EH.M09.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M10??>
                            ${PDA_AD01_R2_PD01EH.M10.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M11??>
                            ${PDA_AD01_R2_PD01EH.M11.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M12??>
                            ${PDA_AD01_R2_PD01EH.M12.PD01EJ01!}
                        <#else >--
                        </#if>
                    </td>
                </tr>
            </#list>
             </#if>
            </#list>
        </table>
        </#if>
        </#if>
        <#--特殊事件说明-->
        <#if map.PDA_AD01_R2_PD01GH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">特殊事件说明</td>
                </tr>
                <tr>
                    <td class="content_center">该账户${map.PDA_AD01_R2_PD01GH.PD01GR01!}${map.PDA_AD01_R2_PD01GH.PD01GD01!}</td>
                </tr>
            </table>
        </#if>
        <#--特殊交易信息-->
        <#if map.PDA_AD01_R2_PD01FH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">特殊交易类型</td>
                    <td class="title_center no_border_top">发生日期</td>
                    <td class="title_center no_border_top">变更月数</td>
                    <td class="title_center no_border_top">发生金额</td>
                    <td class="title_center no_border_top">明细记录</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6037",map.PDA_AD01_R2_PD01FH.PD01FD01)!}</td>
                    <td class="content_center">${map.PDA_AD01_R2_PD01FH.PD01FR01!}</td>
                    <td class="content_center">${map.PDA_AD01_R2_PD01FH.PD01FS02!}</td>
                    <td class="content_center">${map.PDA_AD01_R2_PD01FH.PD01FJ01!}</td>
                    <td class="content_center">${map.PDA_AD01_R2_PD01FH.PD01FQ01!}</td>
                </tr>
            </table>
        </#if>
        <#--标注及声明信息-->
        <#if map.PDA_AD01_R2_PD01ZH??>
            <#list map.PDA_AD01_R2_PD01ZH! as PDA_AD01_R2_PD01ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${DataDicUtil.getDataDic("6039",PDA_AD01_R2_PD01ZH.PD01ZD01)!}</td>
                        <td class="title_center no_border_top">添加日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${PDA_AD01_R2_PD01ZH.PD01ZQ01!}</td>
                        <td class="content_center">${PDA_AD01_R2_PD01ZH.PD01ZR01!}</td>
                    </tr>
                </table>
            </#list>
        </#if>
        <br>
    </#list>

    <h3>（六）准贷记卡账户</h3>
    <#list map.PDA_AD01_R3! as PDA_AD01_R3>
        <#--基本信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center">发卡机构</td>
                <td class="title_center">账户标识</td>
                <td class="title_center">开立日期</td>
                <td class="title_center">账户授信额度</td>
                <td class="title_center">共享授信额度</td>
                <td class="title_center">币种</td>
                <td class="title_center">担保方式</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6082",PDA_AD01_R3.PD01AD02)!}${PDA_AD01_R3.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AJ02!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AJ03!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6058",PDA_AD01_R3.PD01AD04)!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6024",PDA_AD01_R3.PD01AD07)!}</td>
            </tr>
        </table>
        <#--最近一月表现信息 非 4-销户 5-呆账 6-未激活 状态下显示-->
        <#if PDA_AD01_R3.PD01CD01??>
        <#if !(PDA_AD01_R3.PD01CD01 == '4' || PDA_AD01_R3.PD01CD01 == '5' || PDA_AD01_R3.PD01CD01 == '6')>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="8" >截至${PDA_AD01_R3.PD01CR04!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">透支余额</td>
                    <td class="title_center">最近 6 个月平均透支余额</td>
                    <td class="title_center">最大透支余额</td>
                    <td class="title_center">账单日</td>
                    <td class="title_center">本月实还款</td>
                    <td class="title_center">最近一次还款日期</td>
                    <td class="title_center">透支 180 天以上未付余额</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6029",PDA_AD01_R3.PD01CD01)!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01CJ01!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01CJ13!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01CJ15!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01CR02!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01CJ04!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01CR03!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01CJ11!}</td>
                </tr>
            </table>
        </#if>
        </#if>
        <#--最新表现信息-->
        <#if PDA_AD01_R3.PD01BD01??>
        <#if PDA_AD01_R3.PD01BD01 == '4'>
            <#--销户-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="2">截至${PDA_AD01_R3.PD01BR03!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">销户日期</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6029",PDA_AD01_R3.PD01BD01)!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BR01!}</td>
                </tr>
            </table>
        <#elseif PDA_AD01_R3.PD01BD01 == '5'>
            <#--呆账-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="3">截至${PDA_AD01_R3.PD01BR03!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">余额</td>
                    <td class="title_center">最近一次还款日期</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6029",PDA_AD01_R3.PD01BD01)!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BJ01!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BR02!}</td>
                </tr>
            </table>
        <#elseif PDA_AD01_R3.PD01BD01 == '6'>
            <#--未激活-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="8">截至${PDA_AD01_R3.PD01BR03!}，账户状态为“未激活”。</td>
                </tr>
            </table>
        <#else >
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="5">${PDA_AD01_R3.PD01BR03!}以后的最新还款记录</td>
                </tr>
                <tr>
                    <td class="title_center">五级分类</td>
                    <td class="title_center">余额</td>
                    <td class="title_center">还款日期</td>
                    <td class="title_center">还款金额</td>
                    <td class="title_center">当前还款状态</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6032",PDA_AD01_R3.PD01BD03)!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BJ01!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BR02!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BJ02!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BD04!}</td>
                </tr>
            </table>
        </#if>
        </#if>
        <#--最近5年历史表现信息 账户状态未激活状态下显示-->
        <#if PDA_AD01_R3.PD01CD01??>
        <#if PDA_AD01_R3.PD01CD01 != '6'>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="13">${PDA_AD01_R3.PD01ER01!}—${PDA_AD01_R3.PD01ER02!}的还款记录</td>
                </tr>
                <tr>
                    <td class="title_center"></td>
                    <td class="title_center">1</td>
                    <td class="title_center">2</td>
                    <td class="title_center">3</td>
                    <td class="title_center">4</td>
                    <td class="title_center">5</td>
                    <td class="title_center">6</td>
                    <td class="title_center">7</td>
                    <td class="title_center">8</td>
                    <td class="title_center">9</td>
                    <td class="title_center">10</td>
                    <td class="title_center">11</td>
                    <td class="title_center">12</td>
                </tr>
                <#list map.PDA_AD01_R3_PD01EH! as PDA_AD01_R3_PD01EH>
                    <tr>
                        <td class="title_center" rowspan="2">${PDA_AD01_R3_PD01EH.YEAR!}</td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M01??>
                                ${PDA_AD01_R3_PD01EH.M01.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M02??>
                                ${PDA_AD01_R3_PD01EH.M02.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M03??>
                                ${PDA_AD01_R3_PD01EH.M03.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M04??>
                                ${PDA_AD01_R3_PD01EH.M04.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M05??>
                                ${PDA_AD01_R3_PD01EH.M05.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M06??>
                                ${PDA_AD01_R3_PD01EH.M06.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M07??>
                                ${PDA_AD01_R3_PD01EH.M07.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M08??>
                                ${PDA_AD01_R3_PD01EH.M08.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M09??>
                                ${PDA_AD01_R3_PD01EH.M09.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M10??>
                                ${PDA_AD01_R3_PD01EH.M10.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M11??>
                                ${PDA_AD01_R3_PD01EH.M11.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M12??>
                                ${PDA_AD01_R3_PD01EH.M12.PD01ED01!}
                            <#else >--
                            </#if>
                        </td>
                    </tr>
                    <tr>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M01??>
                                ${PDA_AD01_R3_PD01EH.M01.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M02??>
                                ${PDA_AD01_R3_PD01EH.M02.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M03??>
                                ${PDA_AD01_R3_PD01EH.M03.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M04??>
                                ${PDA_AD01_R3_PD01EH.M04.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M05??>
                                ${PDA_AD01_R3_PD01EH.M05.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M06??>
                                ${PDA_AD01_R3_PD01EH.M06.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M07??>
                                ${PDA_AD01_R3_PD01EH.M07.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M08??>
                                ${PDA_AD01_R3_PD01EH.M08.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M09??>
                                ${PDA_AD01_R3_PD01EH.M09.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M10??>
                                ${PDA_AD01_R3_PD01EH.M10.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M11??>
                                ${PDA_AD01_R3_PD01EH.M11.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M12??>
                                ${PDA_AD01_R3_PD01EH.M12.PD01EJ01!}
                            <#else >--
                            </#if>
                        </td>
                    </tr>
                </#list>
            </table>
        </#if>
        </#if>
        <#--特殊交易信息-->
        <#if map.PDA_AD01_R3_PD01FH??>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">特殊交易类型</td>
                    <td class="title_center no_border_top">发生日期</td>
                    <td class="title_center no_border_top">变更月数</td>
                    <td class="title_center no_border_top">发生金额</td>
                    <td class="title_center no_border_top">明细记录</td>
                </tr>
                <tr>
                    <td class="content_center">${DataDicUtil.getDataDic("6037",map.PDA_AD01_R3_PD01FH.PD01FD01)!}</td>
                    <td class="content_center">${map.PDA_AD01_R3_PD01FH.PD01FR01!}</td>
                    <td class="content_center">${map.PDA_AD01_R3_PD01FH.PD01FS02!}</td>
                    <td class="content_center">${map.PDA_AD01_R3_PD01FH.PD01FJ01!}</td>
                    <td class="content_center">${map.PDA_AD01_R3_PD01FH.PD01FQ01!}</td>
                </tr>
            </table>
        </#if>
        <#--标注及声明信息-->
        <#if map.PDA_AD01_R3_PD01ZH??>
            <#list map.PDA_AD01_R3_PD01ZH! as PDA_AD01_R3_PD01ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${DataDicUtil.getDataDic("6039",PDA_AD01_R3_PD01ZH.PD01ZD01)!}</td>
                        <td class="title_center no_border_top">添加日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${PDA_AD01_R3_PD01ZH.PD01ZQ01!}</td>
                        <td class="content_center">${PDA_AD01_R3_PD01ZH.PD01ZR01!}</td>
                    </tr>
                </table>
            </#list>
        </#if>
        <br>
    </#list>
    <br>

    <h3>（七）相关还款责任信息</h3>
    <h4>有相关还款责任的个人借款</h4>
    <#list map.PCR_AD08_1! as PCR_AD08_1>
        <h4 class="title_left" style="margin-left:20px;">账户${PCR_AD08_1_index + 1 }</h4>
        <#--基本信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center">管理机构</td>
                <td class="title_center">业务种类</td>
                <td class="title_center">开立日期</td>
                <td class="title_center">到期日期</td>
                <td class="title_center">责任人类型</td>
                <td class="title_center">还款责任金额</td>
                <td class="title_center">币种</td>
                <td class="title_center">保证合同编号</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6082",PCR_AD08_1.PD03AD01)!}${PCR_AD08_1.PD03AQ01}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6020",PCR_AD08_1.PD03AD02)!}</td>
                <td class="content_center">${PCR_AD08_1.PD03AR01!}</td>
                <td class="content_center">${PCR_AD08_1.PD03AR02!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6044",PCR_AD08_1.PD03AD03)!}</td>
                <td class="content_center">${PCR_AD08_1.PD03AJ01!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6058",PCR_AD08_1.PD03AD04)!}</td>
                <td class="content_center">${PCR_AD08_1.PD03AQ02!}</td>
            </tr>
        </table>
        <table class="fixedTable">
            <tr>
                <td class="title_center no_border_top" colspan="3">截至${PCR_AD08_1.PD03AR03}</td>
            </tr>
            <tr>
                <td class="title_center">余额</td>
                <td class="title_center">五级分类</td>
                <td class="title_center">还款状态</td>
            </tr>
            <tr>
                <td class="content_center">${PCR_AD08_1.PD03AJ02!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6032",PCR_AD08_1.PD03AD05)!}</td>
                <td class="content_center">${PCR_AD08_1.PD03AD07!}</td>
            </tr>
        </table>
        <#--标注及声明-->
       <#-- <#if map.PCR_AD08_1_PF03ZH??>
            <#list map.PCR_AD08_1_PF03ZH! as PCR_AD08_1_PF03ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${DataDicUtil.getDataDic("6039",PCR_AD08_1_PF03ZH.PF03ZD01)!}</td>
                        <td class="title_center no_border_top">添加日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${PCR_AD08_1_PF03ZH.PF03ZQ01!}</td>
                        <td class="content_center">${PCR_AD08_1_PF03ZH.PF03ZR01!}</td>
                    </tr>
                </table>
            </#list>
        </#if>-->
        <br>
    </#list>
    <br>
    <h4>有相关还款责任的企业借款</h4>
    <#list map.PCR_AD08_2! as PCR_AD08_2>
        <h4 class="title_left" style="margin-left:20px;">账户${PCR_AD08_2_index + 1 }</h4>
        <#--基本信息-->
        <table class="fixedTable">
            <tr>
                <td class="title_center">管理机构</td>
                <td class="title_center">业务种类</td>
                <td class="title_center">开立日期</td>
                <td class="title_center">到期日期</td>
                <td class="title_center">责任人类型</td>
                <td class="title_center">还款责任金额</td>
                <td class="title_center">币种</td>
                <td class="title_center">保证合同编号</td>
            </tr>
            <tr>
                <td class="content_center">${DataDicUtil.getDataDic("6082",PCR_AD08_2.PD03AD01)!} ${PCR_AD08_2.PD03AQ01}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6085",PCR_AD08_2.PD03AD02)!}</td>
                <td class="content_center">${PCR_AD08_2.PD03AR01}</td>
                <td class="content_center">${PCR_AD08_2.PD03AR02}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6044",PCR_AD08_2.PD03AD03)!}</td>
                <td class="content_center">${PCR_AD08_2.PD03AJ01}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6058",PCR_AD08_2.PD03AD04)!}</td>
                <td class="content_center">${PCR_AD08_2.PD03AQ02}</td>
            </tr>
        </table>
        <table class="fixedTable">
            <tr>
                <td class="title_center no_border_top" colspan="3">截至${PCR_AD08_2.PD03AR03!}</td>
            </tr>
            <tr>
                <td class="title_center">余额</td>
                <td class="title_center">五级分类</td>
                <td class="title_center">逾期月数</td>
            </tr>
            <tr>
                <td class="content_center">${PCR_AD08_2.PD03AJ02!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6032",PCR_AD08_2.PD03AD05)!}</td>
                <td class="content_center">${PCR_AD08_2.PD03AS01!}</td>
            </tr>
        </table>
        <#--标注及声明-->
        <#--<#if map.PCR_AD08_2_PF03ZH??>
            <#list map.PCR_AD08_2_PF03ZH! as PCR_AD08_2_PF03ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${DataDicUtil.getDataDic("6039",PCR_AD08_2_PF03ZH.PF03ZD01)!}</td>
                        <td class="title_center no_border_top">添加日期</td>
                    </tr>
                    <tr>
                        <td class="content_center">${PCR_AD08_2_PF03ZH.PF03ZQ01!}</td>
                        <td class="content_center">${PCR_AD08_2_PF03ZH.PF03ZR01!}</td>
                    </tr>
                </table>
            </#list>
        </#if>-->
        <br>
    </#list>
    <br>

    <h3>（八）授信协议信息 </h3>
    <#list map.CR_PER_PCA! as CR_PER_PCA>
        <h4 class="title_left" style="margin-left:20px; ">授信协议 ${CR_PER_PCA.PD02AI01!}</h4>
        <table class="fixedTable">
            <tr>
                <td class="title_center">管理机构</td>
                <td class="title_center">授信协议标识</td>
                <td class="title_center">生效日期</td>
                <td class="title_center">到期日期</td>
                <td class="title_center">授信额度用途</td>
            </tr>
            <tr>
                <td class="content_center">${CR_PER_PCA.PD02AI02!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AI03!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AR01!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AR02!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6040",CR_PER_PCA.PD02AD02)!}</td>
            </tr>
            <tr>
                <td class="title_center">授信额度</td>
                <td class="title_center">授信限额</td>
                <td class="title_center">授信限额编号</td>
                <td class="title_center">已用额度</td>
                <td class="title_center">币种</td>
            </tr>
            <tr>
                <td class="content_center">${CR_PER_PCA.PD02AJ01!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AJ03!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AI04!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AJ04!}</td>
                <td class="content_center">${DataDicUtil.getDataDic("6058",CR_PER_PCA.PD02AD03)!}</td>
            </tr>
        </table>
        <br>
    </#list>

   

</div>
</body>
</html>