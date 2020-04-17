<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信用报告</title>

    <style>
        body{
            font-size: 18px;
            background-color: #bbbda9;
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
    <h3 class="content_left" style="margin-left: 24px;">附件 2-1</h3>

    <h1>个人信用报告</h1>
    <h3>（授信机构版）</h3>
    <table class="fixedTable">
        <tr>
            <td class="content_left" colspan="3" default_val="--">报告编号：${map.CR_PER_PRH.PA01AI01!}</td>
            <td class="content_right" colspan="2" default_val="--">报告时间：${map.CR_PER_PRH.PA01AR01!}</td>
        </tr>
        <tr>
            <td class="title_center">被查询者姓名</td>
            <td class="title_center">被查询者证件类型</td>
            <td class="title_center">被查询者证件号码</td>
            <td class="title_center">查询机构</td>
            <td class="title_center">查询原因</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PRH.PA01BQ01!}</td>
            <td class="content_center">${map.CR_PER_PRH.PA01BD01!}</td>
            <td class="content_center">${map.CR_PER_PRH.PA01BI01!}</td>
            <td class="content_center">${map.CR_PER_PRH.PA01BI02!}</td>
            <td class="content_center">${map.CR_PER_PRH.PA01BD02!}</td>
        </tr>
    </table>
    <br>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="2">其他证件信息</td>
        </tr>
        <tr>
            <td class="title_center">证件类型</td>
            <td class="title_center">证件号码</td>
        </tr>
        <#list map.CR_PER_PA01CH! as CR_PER_PA01CH>
            <tr>
                <td class="content_center">${CR_PER_PA01CH.PA01CD01!}</td>
                <td class="content_center">${CR_PER_PA01CH.PA01CI01!}</td>
            </tr>
        </#list>
    </table>
    <br>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="2">防欺诈警示</td>
        </tr>
        <tr>
            <td class="content_center" colspan="2">${map.CR_PER_PRH.PA01DQ01!}，联系电话：${map.CR_PER_PRH.PA01DQ02!} </td>
        </tr>
        <tr>
            <td class="title_center">生效日期</td>
            <td class="title_center">截止日期</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PRH.PA01DR01!}</td>
            <td class="content_center">${map.CR_PER_PRH.PA01DR02!}</td>
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
    <h3>（一）身份信息 </h3>
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
            <td class="content_center">${map.CR_PER_PIM.PB01AD01!}</td>
            <td class="content_center">${map.CR_PER_PIM.PB01AR01!}</td>
            <td class="content_center">${map.CR_PER_PMM.PB020D01!}</td>
            <td class="content_center">${map.CR_PER_PIM.PB01AD02!}</td>
            <td class="content_center">${map.CR_PER_PIM.PB01AD03!}</td>
            <td class="content_center">${map.CR_PER_PIM.PB01AD04!}</td>
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
            <td class="title_center" width="6%">编号</td>
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
    <h3>（二）配偶信息 </h3>
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
            <td class="content_center">${map.CR_PER_PMM.PB020D02!}</td>
            <td class="content_center">${map.CR_PER_PMM.PB020I01!}</td>
            <td class="content_center">${map.CR_PER_PMM.PB020Q02!}</td>
            <td class="content_center">${map.CR_PER_PMM.PB020Q03!}</td>
        </tr>
    </table>
    <br>
    <h3>（三）居住信息 </h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">居住地址</td>
            <td class="title_center" width="16%">住宅电话</td>
            <td class="title_center" width="10%">居住状况</td>
            <td class="title_center" width="16%">信息更新日期</td>
        </tr>
        <tr>
            <#list map.CR_PER_PRM! as CR_PER_PRM>
                <tr>
                    <td class="content_center">${CR_PER_PRM_index!}</td>
                    <td class="content_center">${CR_PER_PRM.PB030Q01!}</td>
                    <td class="content_center">${CR_PER_PRM.PB030Q02!}</td>
                    <td class="content_center">${CR_PER_PRM.PB030D01!}</td>
                    <td class="content_center">${CR_PER_PRM.PB030R01!}</td>
                </tr>
            </#list>
        </tr>
    </table>
    <br>
    <h3>（四）职业信息 </h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center" width="20%">工作单位</td>
            <td class="title_center" width="12%">单位性质</td>
            <td class="title_center" colspan="3">单位地址</td>
            <td class="title_center" width="16%">单位电话</td>
        </tr>
        <#list map.CR_PER_POM! as CR_PER_POM>
            <tr>
                <td class="content_center">${CR_PER_POM_index!}</td>
                <td class="content_center">${CR_PER_POM.PB040Q01!}</td>
                <td class="content_center">${CR_PER_POM.PB040D02!}</td>
                <td class="content_center" colspan="3">${CR_PER_POM.PB040Q02!}</td>
                <td class="content_center">${CR_PER_POM.PB040Q03!}</td>
            </tr>
        </#list>
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">职业</td>
            <td class="title_center">行业</td>
            <td class="title_center">职务</td>
            <td class="title_center">职称</td>
            <td class="title_center">进入本单位年份</td>
            <td class="title_center">信息更新日期</td>
        </tr>
        <#list map.CR_PER_POM! as CR_PER_POM>
            <tr>
                <td class="content_center">${CR_PER_POM_index!}</td>
                <td class="content_center">${CR_PER_POM.PB040D04!}</td>
                <td class="content_center">${CR_PER_POM.PB040D03!}</td>
                <td class="content_center">${CR_PER_POM.PB040D05!}</td>
                <td class="content_center">${CR_PER_POM.PB040D06!}</td>
                <td class="content_center">${CR_PER_POM.PB040R01!}</td>
                <td class="content_center">${CR_PER_POM.PB040R02!}</td>
            </tr>
        </#list>
    </table>
    <br>
    <h2>二  信息概要</h2>
    <h3>（一）个人信用报告“数字解读”</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center">数字解读</td>
            <td class="title_center">相对位置</td>
            <td class="title_center" width="45%">说明</td>
        </tr>
        <tr>
            <#--<td class="content_center">${map.CR_PER_POM.PC010Q01!}</td>-->
            <#--<td class="content_center">${map.CR_PER_POM.PC010Q02!}</td>-->
            <#--<td class="content_center">${map.CR_PER_POM.PC010D01!}</td>-->
        </tr>
    </table>
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
       <#-- <tr>
            <#list map.CR_PER_PC02AH! as CR_PER_PC02AH>
                <td class="title_center">${CR_PER_PC02AH.PC02AD02!}</td>
                <td class="content_center">${CR_PER_PC02AH.PC02AS03!}</td>
                <td class="content_center">${CR_PER_PC02AH.PC02AR01!}</td>
            </#list>
        </tr>-->

        <#--<tr>-->
            <#--<td class="title_center" colspan="2">合计</td>-->
            <#--<td class="content_center">${map.CR_PER_PCO.PC02AS01!}</td>-->
            <#--<td class="content_center">--</td>-->
        <#--</tr>-->
    </table>
    <br>
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
                <td class="title_center">${CR_PER_PC02BH.PC02BD01!}</td>
                <td class="content_center">${CR_PER_PC02BH.PC02BS03!}</td>
                <td class="content_center">${CR_PER_PC02BH.PC02BJ02!}</td>
            </tr>
        </#list>
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
                <td class="title_center">${CR_PER_PC02DH.PC02DD01!}</td>
                <td class="content_center">${CR_PER_PC02DH.PC02DS02!}</td>
                <td class="content_center">${CR_PER_PC02DH.PC02DS03!}</td>
                <td class="content_center">${CR_PER_PC02DH.PC02DJ01!}</td>
                <td class="content_center">${CR_PER_PC02DH.PC02DS04!}</td>
            </tr>
        </#list>
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
            <td class="content_center">${map.CR_PER_PC02KH.PC02KS02!}</td>
            <td class="content_center">${map.CR_PER_PC02KH.PC02KJ01!}</td>
            <td class="content_center">${map.CR_PER_PC02KH.PC02KJ02!}</td>
            <td class="content_center">3</td>
            <td class="content_center">200,000</td>
            <td class="content_center">200,000</td>
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
            <td class="content_center">1</td>
            <td class="content_center">200,000</td>
            <td class="content_center">200,000</td>
            <td class="content_center">3</td>
            <td class="content_center">200,000</td>
            <td class="content_center">200,000</td>
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
        <#list map.CR_PER_PC030H! as CR_PER_PC030H>
            <tr>
                <td class="title_center">${CR_PER_PC030H.PC030D01!}</td>
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
                <td class="title_center">${CR_PER_PC040H.PC040D01!}</td>
                <td class="content_center">${CR_PER_PC040H.PC040S02!}</td>
                <td class="content_center">${CR_PER_PC040H.PC040J01!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h3>（七）查询记录概要</h3>
    <table class="fixedTable">
        <tr>
            <td class="title_center" colspan="3">上一次查询记录</td>
        </tr>
        <tr>
            <td class="content_center">${map.CR_PER_PQO.PC05AR01!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05AI01!}</td>
            <td class="content_center">${map.CR_PER_PQO.PC05AQ01!}</td>
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

    <h2>三  信贷交易信息明细</h2>
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
                <td class="content_center">${PDA_AD01_C1.PD01AD02!}${PDA_AD01_C1.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_C1.PD01AD03!}</td>
                <td class="content_center">${PDA_AD01_C1.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_C1.PD01AJ01!}</td>
                <td class="content_center">${PDA_AD01_C1.PD01AD10!}</td>
            </tr>
        </table>
        <#--最新表现信息-->
        <table class="fixedTable">
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
                    <td class="content_center">${PDA_AD01_C1.PD01BD01!}</td>
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
                    <td class="content_center">${PDA_AD01_C1.PD01BD01!}</td>
                    <td class="content_center">${PDA_AD01_C1.PD01BR01!}</td>
                </tr>
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
                    <td class="content_center">${map.PDA_AD01_C1_PD01FH.PD01FD01!}</td>
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
                        <td class="title_center no_border_top">${PDA_AD01_C1_PD01ZH.PD01ZD01!}</td>
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

    <h3>（二）非循环贷账户</h3>
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
                <td class="content_center">${PDA_AD01_D1.PD01AD02!}${PDA_AD01_D1.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AR02!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AJ01!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AD04!}</td>
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
                <td class="content_center">${PDA_AD01_D1.PD01AD03!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AD07!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AS01!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AD06!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AD05!}</td>
                <td class="content_center">${PDA_AD01_D1.PD01AD09!}</td>
            </tr>
        </table>
        <#--最近一次月度表现信息 非 3-结清,4-呆账,5-转出 状态下显示-->
        <#if !(PDA_AD01_D1.PD01BD01 == '3' || PDA_AD01_D1.PD01BD01 == '4' || PDA_AD01_D1.PD01BD01 == '5')>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="5">截至${PDA_AD01_D1.PD01CR01!}</td>
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
                    <td class="content_center">${PDA_AD01_D1.PD01CD01!}</td>
                    <td class="content_center">${PDA_AD01_D1.PD01CD02!}</td>
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
                        <td class="content_center">${PDA_AD01_D1.PD01BD01!}</td>
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
                        <td class="content_center">${PDA_AD01_D1.PD01BD01!}</td>
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
                        <td class="content_center">${PDA_AD01_D1.PD01BD01!}</td>
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
                        <td class="content_center">${PDA_AD01_D1.PD01BD03!}</td>
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
            <#list map.PDA_AD01_D1_PD01EH! as PDA_AD01_D1_PD01EH>
                <tr>
                    <td class="title_center" rowspan="2">${PDA_AD01_D1_PD01EH.YEAR!}</td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M01??>
                            ${PDA_AD01_D1_PD01EH.M01.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M02??>
                            ${PDA_AD01_D1_PD01EH.M02.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M03??>
                            ${PDA_AD01_D1_PD01EH.M03.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M04??>
                            ${PDA_AD01_D1_PD01EH.M04.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M05??>
                            ${PDA_AD01_D1_PD01EH.M05.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M06??>
                            ${PDA_AD01_D1_PD01EH.M06.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M07??>
                            ${PDA_AD01_D1_PD01EH.M07.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M08??>
                            ${PDA_AD01_D1_PD01EH.M08.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M09??>
                            ${PDA_AD01_D1_PD01EH.M09.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M10??>
                            ${PDA_AD01_D1_PD01EH.M10.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M11??>
                            ${PDA_AD01_D1_PD01EH.M11.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_D1_PD01EH.M12??>
                            ${PDA_AD01_D1_PD01EH.M12.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M01??>
                            ${PDA_AD01_D1_PD01EH.M01.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M02??>
                            ${PDA_AD01_D1_PD01EH.M02.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M03??>
                            ${PDA_AD01_D1_PD01EH.M03.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M04??>
                            ${PDA_AD01_D1_PD01EH.M04.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M05??>
                            ${PDA_AD01_D1_PD01EH.M05.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M06??>
                            ${PDA_AD01_D1_PD01EH.M06.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M07??>
                            ${PDA_AD01_D1_PD01EH.M07.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M08??>
                            ${PDA_AD01_D1_PD01EH.M08.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M09??>
                            ${PDA_AD01_D1_PD01EH.M09.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M10??>
                            ${PDA_AD01_D1_PD01EH.M10.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M11??>
                            ${PDA_AD01_D1_PD01EH.M11.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_D1_PD01EH.M12??>
                            ${PDA_AD01_D1_PD01EH.M12.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                </tr>
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
                    <td class="content_center">该账户${map.PDA_AD01_D1_PD01GH.PD01GR01!}${map.PDA_AD01_D1_PD01GH.PD01GD01!}</td>
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
                    <td class="content_center">${map.PDA_AD01_D1_PD01FH.PD01FD01!}</td>
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
                        <td class="title_center no_border_top">${PDA_AD01_D1_PD01ZH.PD01ZD01!}</td>
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
                <td class="content_center">${PDA_AD01_R4.PD01AD02!}${PDA_AD01_R4.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AR02!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AJ01!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AD04!}</td>
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
                <td class="content_center">${PDA_AD01_R4.PD01AD03!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AD07!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AS01!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AD06!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AD05!}</td>
                <td class="content_center">${PDA_AD01_R4.PD01AD09!}</td>
            </tr>
        </table>
        <#--最近一次月度表现信息 非 3-结清,4-呆账 状态下显示-->
        <#if !(PDA_AD01_R4.PD01BD01 == '3' || PDA_AD01_R4.PD01BD01 == '4')>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="5">截至${PDA_AD01_R4.PD01CR01!}</td>
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
                    <td class="content_center">${PDA_AD01_R4.PD01CD01!}</td>
                    <td class="content_center">${PDA_AD01_R4.PD01CD02!}</td>
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
                        <td class="content_center">${PDA_AD01_R4.PD01BD01!}</td>
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
                        <td class="content_center" colspan="3">${PDA_AD01_R4.PD01BD01!}</td>
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
                        <td class="content_center">${PDA_AD01_R4.PD01BD03!}</td>
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
            <#list map.PDA_AD01_R4_PD01EH! as PDA_AD01_R4_PD01EH>
                <tr>
                    <td class="title_center" rowspan="2">${PDA_AD01_R4_PD01EH.YEAR!}</td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M01??>
                            ${PDA_AD01_R4_PD01EH.M01.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M02??>
                            ${PDA_AD01_R4_PD01EH.M02.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M03??>
                            ${PDA_AD01_R4_PD01EH.M03.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M04??>
                            ${PDA_AD01_R4_PD01EH.M04.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M05??>
                            ${PDA_AD01_R4_PD01EH.M05.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M06??>
                            ${PDA_AD01_R4_PD01EH.M06.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M07??>
                            ${PDA_AD01_R4_PD01EH.M07.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M08??>
                            ${PDA_AD01_R4_PD01EH.M08.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M09??>
                            ${PDA_AD01_R4_PD01EH.M09.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M10??>
                            ${PDA_AD01_R4_PD01EH.M10.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M11??>
                            ${PDA_AD01_R4_PD01EH.M11.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R4_PD01EH.M12??>
                            ${PDA_AD01_R4_PD01EH.M12.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M01??>
                            ${PDA_AD01_R4_PD01EH.M01.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M02??>
                            ${PDA_AD01_R4_PD01EH.M02.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M03??>
                            ${PDA_AD01_R4_PD01EH.M03.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M04??>
                            ${PDA_AD01_R4_PD01EH.M04.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M05??>
                            ${PDA_AD01_R4_PD01EH.M05.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M06??>
                            ${PDA_AD01_R4_PD01EH.M06.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M07??>
                            ${PDA_AD01_R4_PD01EH.M07.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M08??>
                            ${PDA_AD01_R4_PD01EH.M08.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M09??>
                            ${PDA_AD01_R4_PD01EH.M09.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M10??>
                            ${PDA_AD01_R4_PD01EH.M10.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M11??>
                            ${PDA_AD01_R4_PD01EH.M11.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R4_PD01EH.M12??>
                            ${PDA_AD01_R4_PD01EH.M12.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                </tr>
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
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FD01!}</td>
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FR01!}</td>
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FS02!}</td>
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FJ01!}</td>
                    <td class="content_center">${map.PDA_AD01_R4_PD01FH.PD01FQ01!}</td>
                </tr>
            </table>
        </#if>
        <#--标注及声明信息-->
        <#if map.PDA_AD01_R4_PD01ZH??>
            <#list map.PDA_AD01_R4_PD01ZH! as PDA_AD01_R4_PD01ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${PDA_AD01_R4_PD01ZH.PD01ZD01!}</td>
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
                <td class="content_center">${PDA_AD01_R1.PD01AD02!}${PDA_AD01_R1.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AR02!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AJ01!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AD04!}</td>
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
                <td class="content_center">${PDA_AD01_R1.PD01AD03!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AD07!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AS01!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AD06!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AD05!}</td>
                <td class="content_center">${PDA_AD01_R1.PD01AD09!}</td>
            </tr>
        </table>
        <#--最近一次月度表现信息 非 3-结清,4-呆账 状态下显示-->
        <#if !(PDA_AD01_R1.PD01BD01 == '3' || PDA_AD01_R1.PD01BD01 == '4')>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="5">截至${PDA_AD01_R1.PD01CR01!}</td>
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
                    <td class="content_center">${PDA_AD01_R1.PD01CD01!}</td>
                    <td class="content_center">${PDA_AD01_R1.PD01CD02!}</td>
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
                        <td class="content_center">${PDA_AD01_R1.PD01BD01!}</td>
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
                        <td class="content_center" colspan="3">${PDA_AD01_R1.PD01BD01!}</td>
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
                        <td class="content_center">${PDA_AD01_R1.PD01BD03!}</td>
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
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M02??>
                            ${PDA_AD01_R1_PD01EH.M02.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M03??>
                            ${PDA_AD01_R1_PD01EH.M03.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M04??>
                            ${PDA_AD01_R1_PD01EH.M04.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M05??>
                            ${PDA_AD01_R1_PD01EH.M05.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M06??>
                            ${PDA_AD01_R1_PD01EH.M06.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M07??>
                            ${PDA_AD01_R1_PD01EH.M07.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M08??>
                            ${PDA_AD01_R1_PD01EH.M08.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M09??>
                            ${PDA_AD01_R1_PD01EH.M09.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M10??>
                            ${PDA_AD01_R1_PD01EH.M10.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M11??>
                            ${PDA_AD01_R1_PD01EH.M11.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R1_PD01EH.M12??>
                            ${PDA_AD01_R1_PD01EH.M12.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M01??>
                            ${PDA_AD01_R1_PD01EH.M01.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M02??>
                            ${PDA_AD01_R1_PD01EH.M02.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M03??>
                            ${PDA_AD01_R1_PD01EH.M03.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M04??>
                            ${PDA_AD01_R1_PD01EH.M04.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M05??>
                            ${PDA_AD01_R1_PD01EH.M05.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M06??>
                            ${PDA_AD01_R1_PD01EH.M06.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M07??>
                            ${PDA_AD01_R1_PD01EH.M07.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M08??>
                            ${PDA_AD01_R1_PD01EH.M08.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M09??>
                            ${PDA_AD01_R1_PD01EH.M09.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M10??>
                            ${PDA_AD01_R1_PD01EH.M10.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M11??>
                            ${PDA_AD01_R1_PD01EH.M11.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R1_PD01EH.M12??>
                            ${PDA_AD01_R1_PD01EH.M12.PD01EJ01!}
                        <#else >
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
                    <td class="content_center">${map.PDA_AD01_R1_PD01FH.PD01FD01!}</td>
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
                        <td class="title_center no_border_top">${PDA_AD01_R1_PD01ZH.PD01ZD01!}</td>
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
                <td class="content_center">${PDA_AD01_R2.PD01AD02!}${PDA_AD01_R2.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AJ02!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AJ03!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AD04!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AD03!}</td>
                <td class="content_center">${PDA_AD01_R2.PD01AD07!}</td>
            </tr>
        </table>
        <#--最近一月表现信息 非 4-销户 5-呆账 6-未激活 状态下显示-->
        <#if !(PDA_AD01_R2.PD01BD01 == '4' || PDA_AD01_R2.PD01BD01 == '5' || PDA_AD01_R2.PD01BD01 == '6')>
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
                    <td class="content_center">${PDA_AD01_R2.PD01CD01!}</td>
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
                    <td class="content_center">${PDA_AD01_R2.PD01BD01!}</td>
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
                    <td class="content_center">${PDA_AD01_R2.PD01BD01!}</td>
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
                    <td class="content_center">${PDA_AD01_R2.PD01BD03!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BJ01!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BR02!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BJ02!}</td>
                    <td class="content_center">${PDA_AD01_R2.PD01BD04!}</td>
                </tr>
            </table>
        </#if>
        <#--最近5年历史表现信息 账户状态未激活状态下显示-->
        <#if PDA_AD01_R2.PD01BD01 != '6'>
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
            <#list map.PDA_AD01_R2_PD01EH! as PDA_AD01_R2_PD01EH>
                <tr>
                    <td class="title_center" rowspan="2">${PDA_AD01_R2_PD01EH.YEAR!}</td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M01??>
                            ${PDA_AD01_R2_PD01EH.M01.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M02??>
                            ${PDA_AD01_R2_PD01EH.M02.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M03??>
                            ${PDA_AD01_R2_PD01EH.M03.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M04??>
                            ${PDA_AD01_R2_PD01EH.M04.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M05??>
                            ${PDA_AD01_R2_PD01EH.M05.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M06??>
                            ${PDA_AD01_R2_PD01EH.M06.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M07??>
                            ${PDA_AD01_R2_PD01EH.M07.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M08??>
                            ${PDA_AD01_R2_PD01EH.M08.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M09??>
                            ${PDA_AD01_R2_PD01EH.M09.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M10??>
                            ${PDA_AD01_R2_PD01EH.M10.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M11??>
                            ${PDA_AD01_R2_PD01EH.M11.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center" style="border-bottom: 1px dashed;">
                        <#if PDA_AD01_R2_PD01EH.M12??>
                            ${PDA_AD01_R2_PD01EH.M12.PD01ED01!}
                        <#else >
                        </#if>
                    </td>
                </tr>
                <tr>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M01??>
                            ${PDA_AD01_R2_PD01EH.M01.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M02??>
                            ${PDA_AD01_R2_PD01EH.M02.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M03??>
                            ${PDA_AD01_R2_PD01EH.M03.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M04??>
                            ${PDA_AD01_R2_PD01EH.M04.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M05??>
                            ${PDA_AD01_R2_PD01EH.M05.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M06??>
                            ${PDA_AD01_R2_PD01EH.M06.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M07??>
                            ${PDA_AD01_R2_PD01EH.M07.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M08??>
                            ${PDA_AD01_R2_PD01EH.M08.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M09??>
                            ${PDA_AD01_R2_PD01EH.M09.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M10??>
                            ${PDA_AD01_R2_PD01EH.M10.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M11??>
                            ${PDA_AD01_R2_PD01EH.M11.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                    <td class="content_center no_border_top">
                        <#if PDA_AD01_R2_PD01EH.M12??>
                            ${PDA_AD01_R2_PD01EH.M12.PD01EJ01!}
                        <#else >
                        </#if>
                    </td>
                </tr>
            </#list>
        </table>
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
                    <td class="content_center">${map.PDA_AD01_R2_PD01FH.PD01FD01!}</td>
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
                        <td class="title_center no_border_top">${PDA_AD01_R2_PD01ZH.PD01ZD01!}</td>
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
                <td class="content_center">${PDA_AD01_R3.PD01AD02!}${PDA_AD01_R3.PD01AI02!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AI03!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AR01!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AJ02!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AJ03!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AD04!}</td>
                <td class="content_center">${PDA_AD01_R3.PD01AD07!}</td>
            </tr>
        </table>
        <#--最近一月表现信息 非 4-销户 5-呆账 6-未激活 状态下显示-->
        <#if !(PDA_AD01_R3.PD01BD01 == '4' || PDA_AD01_R3.PD01BD01 == '5' || PDA_AD01_R3.PD01BD01 == '6')>
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top" colspan="7" >截至${PDA_AD01_R3.PD01CR04!}</td>
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
                    <td class="content_center">${PDA_AD01_R3.PD01CD01!}</td>
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
        <#--最新表现信息-->
        <#if PDA_AD01_R3.PD01BD01 == '4' >
            <#--销户-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">截至${PDA_AD01_R3.PD01BR03!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">销户日期</td>
                </tr>
                <tr>
                    <td class="content_center">${PDA_AD01_R3.PD01BD01!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BR01!}</td>
                </tr>
            </table>
        <#elseif PDA_AD01_R3.PD01BD01 == '5'>
            <#--呆账-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">截至${PDA_AD01_R3.PD01BR03!}</td>
                </tr>
                <tr>
                    <td class="title_center">账户状态</td>
                    <td class="title_center">余额</td>
                    <td class="title_center">最近一次还款日期</td>
                </tr>
                <tr>
                    <td class="content_center">${PDA_AD01_R3.PD01BD01!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BJ01!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BR02!}</td>
                </tr>
            </table>
        <#elseif PDA_AD01_R3.PD01BD01 == '6'>
            <#--未激活-->
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">截至${PDA_AD01_R3.PD01BR03!}，账户状态为“未激活”。</td>
                </tr>
            </table>
        <#else >
            <table class="fixedTable">
                <tr>
                    <td class="title_center no_border_top">${PDA_AD01_R3.PD01BR03!}以后的最新还款记录</td>
                </tr>
                <tr>
                    <td class="title_center">五级分类</td>
                    <td class="title_center">余额</td>
                    <td class="title_center">还款日期</td>
                    <td class="title_center">还款金额</td>
                    <td class="title_center">当前还款状态</td>
                </tr>
                <tr>
                    <td class="content_center">${PDA_AD01_R3.PD01BD03!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BJ01!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BR02!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BJ02!}</td>
                    <td class="content_center">${PDA_AD01_R3.PD01BD04!}</td>
                </tr>
            </table>
        </#if>
        <#--最近5年历史表现信息 账户状态未激活状态下显示-->
        <#if PDA_AD01_R3.PD01BD01 != '6'>
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
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M02??>
                                ${PDA_AD01_R3_PD01EH.M02.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M03??>
                                ${PDA_AD01_R3_PD01EH.M03.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M04??>
                                ${PDA_AD01_R3_PD01EH.M04.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M05??>
                                ${PDA_AD01_R3_PD01EH.M05.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M06??>
                                ${PDA_AD01_R3_PD01EH.M06.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M07??>
                                ${PDA_AD01_R3_PD01EH.M07.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M08??>
                                ${PDA_AD01_R3_PD01EH.M08.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M09??>
                                ${PDA_AD01_R3_PD01EH.M09.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M10??>
                                ${PDA_AD01_R3_PD01EH.M10.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M11??>
                                ${PDA_AD01_R3_PD01EH.M11.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center" style="border-bottom: 1px dashed;">
                            <#if PDA_AD01_R3_PD01EH.M12??>
                                ${PDA_AD01_R3_PD01EH.M12.PD01ED01!}
                            <#else >
                            </#if>
                        </td>
                    </tr>
                    <tr>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M01??>
                                ${PDA_AD01_R3_PD01EH.M01.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M02??>
                                ${PDA_AD01_R3_PD01EH.M02.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M03??>
                                ${PDA_AD01_R3_PD01EH.M03.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M04??>
                                ${PDA_AD01_R3_PD01EH.M04.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M05??>
                                ${PDA_AD01_R3_PD01EH.M05.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M06??>
                                ${PDA_AD01_R3_PD01EH.M06.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M07??>
                                ${PDA_AD01_R3_PD01EH.M07.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M08??>
                                ${PDA_AD01_R3_PD01EH.M08.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M09??>
                                ${PDA_AD01_R3_PD01EH.M09.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M10??>
                                ${PDA_AD01_R3_PD01EH.M10.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M11??>
                                ${PDA_AD01_R3_PD01EH.M11.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                        <td class="content_center no_border_top">
                            <#if PDA_AD01_R3_PD01EH.M12??>
                                ${PDA_AD01_R3_PD01EH.M12.PD01EJ01!}
                            <#else >
                            </#if>
                        </td>
                    </tr>
                </#list>
            </table>
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
                    <td class="content_center">${map.PDA_AD01_R3_PD01FH.PD01FD01!}</td>
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
                        <td class="title_center no_border_top">${PDA_AD01_R3_PD01ZH.PD01ZD01!}</td>
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
        <h4 class="title_left" style="margin-left:20px;">账户${PCR_AD08_1_index}</h4>
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
                <td class="content_center">${PCR_AD08_1.PD03AD01}${PCR_AD08_1.PD03AQ01}</td>
                <td class="content_center">${PCR_AD08_1.PD03AD02}</td>
                <td class="content_center">${PCR_AD08_1.PD03AR01}</td>
                <td class="content_center">${PCR_AD08_1.PD03AR02}</td>
                <td class="content_center">${PCR_AD08_1.PD03AD03}</td>
                <td class="content_center">${PCR_AD08_1.PD03AJ01}</td>
                <td class="content_center">${PCR_AD08_1.PD03AD04}</td>
                <td class="content_center">${PCR_AD08_1.PD03AQ02}</td>
            </tr>
        </table>
        <table class="fixedTable">
            <tr>
                <td class="title_center no_border_top">截至${PCR_AD08_1.PD03AR03}</td>
            </tr>
            <tr>
                <td class="title_center">余额</td>
                <td class="title_center">五级分类</td>
                <td class="title_center">还款状态</td>
            </tr>
            <tr>
                <td class="content_center">${PCR_AD08_1.PD03AJ02}</td>
                <td class="content_center">${PCR_AD08_1.PD03AD05}</td>
                <td class="content_center">${PCR_AD08_1.PD03AD07}</td>
            </tr>
        </table>
        <#--标注及声明-->
       <#-- <#if map.PCR_AD08_1_PF03ZH??>
            <#list map.PCR_AD08_1_PF03ZH! as PCR_AD08_1_PF03ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${PCR_AD08_1_PF03ZH.PF03ZD01!}</td>
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
        <h4 class="title_left" style="margin-left:20px;">账户${PCR_AD08_2_index}</h4>
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
                <td class="content_center">${PCR_AD08_2.PD03AD01}${PCR_AD08_2.PD03AQ01}</td>
                <td class="content_center">${PCR_AD08_2.PD03AD02}</td>
                <td class="content_center">${PCR_AD08_2.PD03AR01}</td>
                <td class="content_center">${PCR_AD08_2.PD03AR02}</td>
                <td class="content_center">${PCR_AD08_2.PD03AD03}</td>
                <td class="content_center">${PCR_AD08_2.PD03AJ01}</td>
                <td class="content_center">${PCR_AD08_2.PD03AD04}</td>
                <td class="content_center">${PCR_AD08_2.PD03AQ02}</td>
            </tr>
        </table>
        <table class="fixedTable">
            <tr>
                <td class="title_center no_border_top">截至${PCR_AD08_2.PD03AR03}</td>
            </tr>
            <tr>
                <td class="title_center">余额</td>
                <td class="title_center">五级分类</td>
                <td class="title_center">逾期月数</td>
            </tr>
            <tr>
                <td class="content_center">${PCR_AD08_2.PD03AJ02}</td>
                <td class="content_center">${PCR_AD08_2.PD03AD05}</td>
                <td class="content_center">${PCR_AD08_2.PD03AS01}</td>
            </tr>
        </table>
        <#--标注及声明-->
        <#--<#if map.PCR_AD08_2_PF03ZH??>
            <#list map.PCR_AD08_2_PF03ZH! as PCR_AD08_2_PF03ZH>
                <table class="fixedTable">
                    <tr>
                        <td class="title_center no_border_top">${PCR_AD08_2_PF03ZH.PF03ZD01!}</td>
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
                <td class="content_center">${CR_PER_PCA.PD02AI03!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AI02!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AR01!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AR02!}</td>
                <td class="content_center">${CR_PER_PCA.PD02AD02!}</td>
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
                <td class="content_center">${CR_PER_PCA.PD02AD03!}</td>
            </tr>
        </table>
        <br>
    </#list>

    <h2>四  非信贷交易信息明细</h2>
    <h3>后付费记录</h3>
    <h4 class="title_left" style="margin-left:20px; ">账户</h4>
    <table class="fixedTable">
        <tr>
            <td class="title_center">机构名称</td>
            <td class="title_center">业务类型</td>
            <td class="title_center">业务开通日期</td>
            <td class="title_center">当前缴费状态</td>
            <td class="title_center">当前欠费金额</td>
            <td class="title_center">记账年月</td>
        </tr>
        <tr>
            <td class="content_center">中国铁通甘肃分公司</td>
            <td class="content_center">固定电话后付费</td>
            <td class="content_center">2011.09.29</td>
            <td class="content_center">欠费</td>
            <td class="content_center">10,000</td>
            <td class="content_center">2015.05</td>
        </tr>
    </table>
    <table class="fixedTable">
        <tr>
            <td class="title_center no_border_top" colspan="13">2013 年 06 月—2015 年 05 月的缴费记录 </td>
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
        <tr>
            <td class="title_center">2014</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center"></td>
            <td class="content_center"></td>
            <td class="content_center"></td>
        </tr>
        <tr>
            <td class="title_center">2013</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center">N</td>
            <td class="content_center"></td>
            <td class="content_center"></td>
            <td class="content_center"></td>
        </tr>
    </table>
    <br>
    <h4 class="title_left" style="margin-left:20px; ">账户</h4>
    <table class="fixedTable">
        <tr>
            <td class="title_center">机构名称</td>
            <td class="title_center">业务类型</td>
            <td class="title_center">业务开通日期</td>
            <td class="title_center">当前缴费状态</td>
            <td class="title_center">当前欠费金额</td>
            <td class="title_center">记账年月</td>
        </tr>
        <tr>
            <td class="content_center">中国铁通甘肃分公司</td>
            <td class="content_center">固定电话后付费</td>
            <td class="content_center">2011.09.29</td>
            <td class="content_center">欠费</td>
            <td class="content_center">10,000</td>
            <td class="content_center">2015.05</td>
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
                <td class="content_center">${CR_PER_POT_index!}</td>
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
                <td class="content_center">${CR_PER_PCJ_index!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AQ01!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AQ02!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AR01!}</td>
                <td class="content_center">${CR_PER_PCJ.PF02AD01!}</td>
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
                <td class="content_center">${CR_PER_PCJ_index!}</td>
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
                <td class="content_center">${CR_PER_PCE_index!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AQ01!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AQ02!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AR01!}</td>
                <td class="content_center">${CR_PER_PCE.PF03AD01!}</td>
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
                <td class="content_center">${CR_PER_PCE_index!}</td>
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
                <td class="content_center">${CR_PER_PAP_index!}</td>
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
                <td class="content_center">${CR_PER_PHF.PF05AD01!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AJ01!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AQ03!}</td>
                <td class="content_center">${CR_PER_PHF.PF05AQ02!}</td>
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
                <td class="content_center">${CR_PER_PBS_index!}</td>
                <td class="content_center">${CR_PER_PBS.PF06AD01!}</td>
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
                <td class="content_center">${CR_PER_PPQ_index!}</td>
                <td class="content_center">${CR_PER_PPQ.PF07AQ01!}</td>
                <td class="content_center">${CR_PER_PPQ.PF07AD01!}</td>
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
                <td class="content_center">${CR_PER_PAH_index!}</td>
                <td class="content_center">${CR_PER_PAH.PF08AQ01!}</td>
                <td class="content_center">${CR_PER_PAH.PF08AQ02!}</td>
                <td class="content_center">${CR_PER_PAH.PF08AR01!}</td>
                <td class="content_center">${CR_PER_PAH.PF08AR02!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h2>六  本人声明</h2>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">声明内容</td>
            <td class="title_center" width="10%">添加日期</td>
        </tr>
        <tr>
            <td class="content_center">1</td>
            <td class="content_center">本人身份证丢失，2013 年 11 月后的新业务均非本人办理。</td>
            <td class="content_center">2017.05.11</td>
        </tr>
    </table>
    <br>

    <h2>七  异议标注</h2>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center">标注内容</td>
            <td class="title_center" width="10%">添加日期</td>
        </tr>
        <tr>
            <td class="content_center">1</td>
            <td class="content_center">非本人信用报告。</td>
            <td class="content_center">2017.05.11</td>
        </tr>
        <tr>
            <td class="content_center">2</td>
            <td class="content_center">其他证件正处于异议处理期</td>
            <td class="content_center">2017.05.11</td>
        </tr>
    </table>
    <br>

    <h2>八  查询记录</h2>
    <table class="fixedTable">
        <tr>
            <td class="title_center" width="6%">编号</td>
            <td class="title_center" width="10%">查询日期</td>
            <td class="title_center">查询机构</td>
            <td class="title_center" width="30%">查询原因</td>
        </tr>
        <#list map.CR_PER_POQ! as CR_PER_POQ>
            <tr>
                <td class="content_center">${CR_PER_POQ_index!}</td>
                <td class="content_center">${CR_PER_POQ.PH010R01!}</td>
                <td class="content_center">${CR_PER_POQ.PH010Q02!}</td>
                <td class="content_center">${CR_PER_POQ.PH010Q03!}</td>
            </tr>
        </#list>
    </table>
    <br>

    <h2>报告说明</h2>
    <p>
        1.  本报告由中国人民银行征信中心出具，依据截至报告时点的个人征信系统记录的信息生成。除查询记录外，其他
        信息均由相关机构提供，征信中心不保证其真实性和准确性，但承诺在信息汇总、加工、整合的全过程中保持客
        观、中立的地位。
    </p>
    <p>
        2.  本报告中的“数字解读”仅供使用本信用报告的银行等授信机构参考，授信机构应自行承担使用“数字解读”的相
        关法律责任。
    </p>
    <p>
        3.  “数字解读”将信用报告内容解读为一个数值，是对信用主体未来信贷违约可能性的预测，其取值范围为 0 到 1000，
        分值越高，违约可能性越低；“相对位置”是信用主体的数字解读值在全部人群中的百分比排序位置，比如“>50%”
        代表该数字解读值高于 50%的信用主体；“说明”中的“影响因素”是影响信用主体获得更高数字解读值的原因，
        根据当前信用报告的实际情况给出，最多有两条。“数字解读”显示为“--”的，仅代表无法根据当前信用报告内
        容给出数字解读值，并无其他含义。无法给出数字解读值的具体原因见“说明”。
    </p>
    <p>
        4.  本报告的信贷交易信息提示中，“业务类型”为“其他”的汇总信息不包含“资产处置”和“垫款”业务。
    </p>
    <p>
        5.  本报告中如果没有“信贷交易违约信息概要”信息，说明信用主体最近 5 年内没有连续逾期。
    </p>
    <p>
        6.  对于存在授信限额的协议信息，信息主体的可用额度需结合“授信协议信息”中的授信额度、授信限额信息和余额
        进行估算。
    </p>
    <p>
        7.  本报告中的信贷交易授信及负债信息概要展示的信息是指未结清/未销户的授信及负债信息。
    </p>
    <p>
        8.  本报告的借贷交易明细信息中，循环贷账户的到期日期是指账户授信额度的到期日期。
    </p>
    <p>
        9.  本报告的借贷交易明细信息中，借贷账户展示最近 5 年的还款情况，包括当前还款状态和当前逾期总额。
    </p>
    <p>
        10.  对于通过自助渠道办理的“小额、高频”业务，金融机构将合并报送相关账户，展示在本报告的借贷交易明细信息
        中；此时账户的还款方式为“不区分还款方式”，该账户的还款频率统一约定为“月”，“还款期数”按月计算，其
        还款信息按月进行观测和更新。
    </p>
    <p>
        11.  本报告中的逾期准贷记卡账户是指该账户 60 天以上的透支行为。
    </p>
    <p>
        12.  本报告中的还款期数为“--”是指该账户是非分期还款。
    </p>
    <p>
        13.  本报告不展示 5 年前已经结束的违约行为，以及 5 年前的欠税记录、强制执行记录、民事判决记录、行政处罚记
        录、电信欠费记录。
    </p>
    <p>
        14.  机构说明是数据提供机构对具体业务添加的特别说明信息。
    </p>
    <p>
        15.  本人声明是信息主体对信用报告中的信息所附注的简要说明，信用主体对本人声明的真实性负责。
    </p>
    <p>
        16. 异议标注是征信中心添加的，用于说明信用主体对信用报告中的哪些信息有异议。
    </p>
    <p>
        17. 本报告内容涉及个人隐私，查询者应依法使用、妥善保管。因使用不当造成个人信息泄露的，征信中心将不承担相
        关责任。
    </p>
    <p>
        18. 本报告中所有金额（除“有相关还款责任的企业借款”中的金额外）均为人民币金额，参照查询日前一天的汇率。
    </p>
    <p>
        19. 本报告整合了数据提供机构以信息主体不同证件报送的信息。
    </p>
</div>
</body>
</html>