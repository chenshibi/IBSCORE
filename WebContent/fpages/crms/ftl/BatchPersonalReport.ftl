<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<html>
<head>
    <title>个人信用报告</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <style>
        td {
            border: solid black 1px;
        }

        .labeltd {
            background: #f7fbfc;
            text-align: right;
            width: 15%;
            padding-right: 8px;
            color: blue;
            font-weight: bold;
            font-size: 12px;
        }

        .titletd {
            background: #f7fbfc;
            text-align: left;
            width: 15%;
            padding-left: 8px;
            color: black;
            font-weight: bold;
            font-size: 12px;
        }

        .datatd {
            background: #f7fbfc;
            white-space: nowrap;
            width: 35%;
            padding-left: 8px;
            font-size: 12px;
        }

        .datatd-number {
            background: #f7fbfc;
            white-space: nowrap;
            width: 35%;
            padding-left: 8px;
            font-size: 12px;
            text-align: right;
        }

        .tabletd {
            width: 100%;
        }

        .table-label-td {
            font-weight: bold;
            font-size: 12px;
        }

        .table-data-td {
            font-size: 12px;
        }

        .table-head-td {
            font-weight: bold;
            font-size: 12px;
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
    </script>
</head>

<body>
<div id="mainDiv">
    <h2>个人信用报告</h2>
    <fieldset>
        <#--CR_PER_PRH-->
        <legend align="center">报告头</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">报告编号</td>
                <td class="datatd">${map.PRH.PA01AI01!}</td>
                <td class="labeltd">报告时间</td>
                <td class="datatd">${map.PRH.PA01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">被查询者姓名</td>
                <td class="datatd">${map.PRH.PA01BQ01!}</td>
                <td class="labeltd">被查询者证件类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6002", map.PRH.PA01BD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">被查询者证件号码</td>
                <td class="datatd">${map.PRH.PA01BI01!}</td>
                <td class="labeltd">查询机构代码</td>
                <td class="datatd">${map.PRH.PA01BI02!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询原因代码</td>
                <td class="datatd">${DataDicUtil.getDataDic("6004",map.PRH.PA01BD02)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="2" class="table-head-td">其他身份标识列表(总计${map.PA01CH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">证件类型</td>
                            <td class="table-label-td" style="width:50%;">证件号码</td>
                        </tr>
                        <#list map.PA01CH! as PA01CH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6002",PA01CH.PA01CD01)!}</td>
                            <td class="table-data-td">${PA01CH.PA01CI01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="labeltd">防欺诈警示标志</td>
                <td class="datatd">${DataDicUtil.getDataDic("6003",map.PRH.PA01DQ01)!}</td>
                <td class="labeltd">防欺诈警示联系电话</td>
                <td class="datatd">${map.PRH.PA01DQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">防欺诈警示生效日期</td>
                <td class="datatd">${map.PRH.PA01DR01!}</td>
                <td class="labeltd">防欺诈警示截止日期</td>
                <td class="datatd">${map.PRH.PA01DR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">异议标注数目</td>
                <td class="datatd">${map.PRH.PA01ES01!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">身份信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">性别</td>
                <td class="datatd">${DataDicUtil.getDataDic("6059", map.PIM.PB01AD01)!}</td>
                <td class="labeltd">出生日期</td>
                <td class="datatd">${map.PIM.PB01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">学历</td>
                <td class="datatd">${DataDicUtil.getDataDic("6060", map.PIM.PB01AD02)!}</td>
                <td class="labeltd">学位</td>
                <td class="datatd">${DataDicUtil.getDataDic("6061", map.PIM.PB01AD03)!}</td>
            </tr>
            <tr>
                <td class="labeltd">就业状况</td>
                <td class="datatd">${DataDicUtil.getDataDic("6062", map.PIM.PB01AD04)!}</td>
                <td class="labeltd">电子邮箱</td>
                <td class="datatd">${map.PIM.PB01AQ01!}</td>
            </tr>
            <tr>
                <td class="labeltd">通讯地址</td>
                <td class="datatd" colspan="3">${map.PIM.PB01AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">户籍地址</td>
                <td class="datatd" colspan="3">${map.PIM.PB01AQ03!}</td>
            </tr>
            <tr>
                <td class="labeltd">国籍</td>
                <td class="datatd">${DataDicUtil.getDataDic("6056", map.PIM.PB01AD05)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="2" class="table-head-td">手机号码列表(总计${map.PB01BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">手机号码</td>
                            <td class="table-label-td" style="width:50%;">信息更新日期</td>
                        </tr>
                        <#list map.PB01BH! as PB01BH>
                        <tr>
                            <td class="table-data-td">${PB01BH.PB01BQ01!}</td>
                            <td class="table-data-td">${PB01BH.PB01BR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">婚姻信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">婚姻状况</td>
                <td class="datatd">${DataDicUtil.getDataDic("6063", map.PMM.PB020D01)!}</td>
                <td class="labeltd">配偶姓名</td>
                <td class="datatd">${map.PMM.PB020Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">配偶证件类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6002", map.PMM.PB020D02)!}</td>
                <td class="labeltd">配偶证件号码</td>
                <td class="datatd">${map.PMM.PB020I01!}</td>
            </tr>
            <tr>
                <td class="labeltd">配偶工作单位</td>
                <td class="datatd">${map.PMM.PB020Q02!}</td>
                <td class="labeltd">配偶联系电话</td>
                <td class="datatd">${map.PMM.PB020Q03!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">居住信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">居住状况</td>
                <td class="datatd">${DataDicUtil.getDataDic("6005", map.PRM.PB030D01)!}</td>
                <td class="labeltd">居住地址</td>
                <td class="datatd">${map.PRM.PB030Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">住宅电话</td>
                <td class="datatd">${map.PRM.PB030Q02!}</td>
                <td class="labeltd">信息更新日期</td>
                <td class="datatd">${map.PRM.PB030R01!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">职业信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">就业状况</td>
                <td class="datatd">${DataDicUtil.getDataDic("6062", map.POM.PB040D01)!}</td>
                <td class="labeltd">工作单位</td>
                <td class="datatd">${map.POM.PB040Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">单位性质</td>
                <td class="datatd">${DataDicUtil.getDataDic("6006", map.POM.PB040D02)!}</td>
                <td class="labeltd">行业</td>
                <td class="datatd">${DataDicUtil.getDataDic("6064", map.POM.PB040D03)!}</td>
            </tr>
            <tr>
                <td class="labeltd">单位地址</td>
                <td class="datatd">${map.POM.PB040Q02!}</td>
                <td class="labeltd">单位电话</td>
                <td class="datatd">${map.POM.PB040Q03!}</td>
            </tr>
            <tr>
                <td class="labeltd">职业</td>
                <td class="datatd">${DataDicUtil.getDataDic("6007", map.POM.PB040D04)!}</td>
                <td class="labeltd">职务</td>
                <td class="datatd">${DataDicUtil.getDataDic("6008", map.POM.PB040D05)!}</td>
            </tr>
            <tr>
                <td class="labeltd">职称</td>
                <td class="datatd">${DataDicUtil.getDataDic("6009", map.POM.PB040D06)!}</td>
                <td class="labeltd">进入本单位年份</td>
                <td class="datatd">${map.POM.PB040R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">信息更新日期</td>
                <td class="datatd">${map.POM.PB040R02!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">评分信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">数字解读</td>
                <td class="datatd">${map.PSM.PC010Q01!}</td>
                <td class="labeltd">相对位置</td>
                <td class="datatd">${map.PSM.PC010Q02!}</td>
            </tr>
            <tr>
                <td class="labeltd">分数说明条数</td>
                <td class="datatd">${map.PSM.PC010S01!}</td>
                <td class="labeltd">分数说明</td>
                <td class="datatd">${DataDicUtil.getDataDic("6010", map.PSM.PC010D01)!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">信贷交易信息概要</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>信贷交易提示信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户数合计</td>
                <td class="datatd">${map.PCO.PC02AS01!}</td>
                <#--<td class="labeltd">业务类型数量</td>-->
                <#--<td class="datatd">${map.PCO.PC02AS02!}</td>-->
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">信贷交易提示信息列表(总计${map.PC02AH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:25%;">业务类型</td>
                            <td class="table-label-td" style="width:25%;">业务大类</td>
                            <td class="table-label-td" style="width:25%;">账户数</td>
                            <td class="table-label-td" style="width:25%;">首笔业务发放月份</td>
                        </tr>
                        <#list map.PC02AH! as PC02AH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6011", PC02AH.PC02AD01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6012", PC02AH.PC02AD02)!}</td>
                            <td class="table-data-td">${PC02AH.PC02AS03!}</td>
                            <td class="table-data-td">${PC02AH.PC02AR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>被追偿汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户数合计</td>
                <td class="datatd">${map.PCO.PC02BS01!}</td>
                <td class="labeltd">余额合计</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02BJ01??>
                        ${map.PCO.PC02BJ01?string(',###')}
                    <#else >

                    </#if>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">业务类型数量</td>-->
                <#--<td class="datatd">${map.PCO.PC02BS02!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">被追偿汇总信息列表(总计${map.PC02BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">业务类型</td>
                            <td class="table-label-td" style="width:33%;">账户数</td>
                            <td class="table-label-td" style="width:33%;">余额</td>
                        </tr>
                        <#list map.PC02BH! as PC02BH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6013", PC02BH.PC02BD01)!}</td>
                            <td class="table-data-td">${PC02BH.PC02BS03!}</td>
                            <td class="table-data-td">
                                <#if PC02BH.PC02BJ02??>
                                    ${PC02BH.PC02BJ02?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>呆账汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02CS01!}</td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02CJ01??>
                        ${map.PCO.PC02CJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>逾期（透支）汇总信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">账户类型数量</td>-->
                <#--<td class="datatd">${map.PCO.PC02DS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">逾期（透支）汇总信息列表(总计${map.PC02DH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:20%;">账户类型</td>
                            <td class="table-label-td" style="width:20%;">账户数</td>
                            <td class="table-label-td" style="width:20%;">月份数</td>
                            <td class="table-label-td" style="width:20%;">单月最高逾期（透支）总额</td>
                            <td class="table-label-td" style="width:20%;">最长逾期（透支）月数</td>
                        </tr>
                        <#list map.PC02DH! as PC02DH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6014", PC02DH.PC02DD01)!}</td>
                            <td class="table-data-td">${PC02DH.PC02DS02!}</td>
                            <td class="table-data-td">${PC02DH.PC02DS03!}</td>
                            <td class="table-data-td">
                                <#if PC02DH.PC02DJ01??>
                                    ${PC02DH.PC02DJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                            <td class="table-data-td">${PC02DH.PC02DS04!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>非循环贷账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">管理机构数</td>
                <td class="datatd">${map.PCO.PC02ES01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02ES02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02EJ01??>
                        ${map.PCO.PC02EJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02EJ02??>
                        ${map.PCO.PC02EJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均应还款</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02EJ03??>
                        ${map.PCO.PC02EJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>循环额度下分账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">管理机构数</td>
                <td class="datatd">${map.PCO.PC02FS01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02FS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02FJ01??>
                        ${map.PCO.PC02FJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02FJ02??>
                        ${map.PCO.PC02FJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均应还款</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02FJ03??>
                        ${map.PCO.PC02FJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>循环贷账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">管理机构数</td>
                <td class="datatd">${map.PCO.PC02GS01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02GS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02GJ01??>
                        ${map.PCO.PC02GJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02GJ02??>
                        ${map.PCO.PC02GJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均应还款</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02GJ03??>
                        ${map.PCO.PC02GJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>贷记卡账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">发卡机构数</td>
                <td class="datatd">${map.PCO.PC02HS01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02HS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ01??>
                        ${map.PCO.PC02HJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">单家行最高授信额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ02??>
                        ${map.PCO.PC02HJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">单家行最低授信额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ03??>
                        ${map.PCO.PC02HJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ04??>
                        ${map.PCO.PC02HJ04?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均使用额度</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ05??>
                        ${map.PCO.PC02HJ05?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>准贷记卡账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">发卡机构数</td>
                <td class="datatd">${map.PCO.PC02IS01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02IS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ01??>
                        ${map.PCO.PC02IJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">单家行最高授信额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ02??>
                        ${map.PCO.PC02IJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">单家行最低授信额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ03??>
                        ${map.PCO.PC02IJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ04??>
                        ${map.PCO.PC02IJ04?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均使用额度</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ05??>
                        ${map.PCO.PC02IJ05?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>相关还款责任汇总信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">相关还款责任个数</td>-->
                <#--<td class="datatd">${map.PCO.PC02KS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">相关还款责任汇总信息列表(总计${map.PC02KH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:20%;">借款人身份类别</td>
                            <td class="table-label-td" style="width:20%;">还款责任类型</td>
                            <td class="table-label-td" style="width:20%;">账户数</td>
                            <td class="table-label-td" style="width:20%;">还款责任金额</td>
                            <td class="table-label-td" style="width:20%;">余额</td>
                        </tr>
                        <#list map.PC02KH! as PC02KH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6001", PC02KH.PC02KD01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6015", PC02KH.PC02KD02)!}</td>
                            <td class="table-data-td">${PC02KH.PC02KS02!}</td>
                            <td class="table-data-td">
                                <#if PC02KH.PC02KJ01??>
                                    ${PC02KH.PC02KJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                            <td class="table-data-td">
                                <#if PC02KH.PC02KJ02??>
                                    ${PC02KH.PC02KJ02?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">非信贷交易信息概要</legend>
        <table class="mainTable">
            <#--<tr>-->
                <#--<td class="labeltd">后付费业务类型数量</td>-->
                <#--<td class="datatd">${map.PNO.PC030S01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">后付费业务欠费信息汇总信息列表(总计${map.PC030H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">后付费业务类型</td>
                            <td class="table-label-td" style="width:33%;">欠费账户数</td>
                            <td class="table-label-td" style="width:33%;">欠费金额</td>
                        </tr>
                        <#list map.PC030H! as PC030H>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6016",PC030H.PC030D01)!}</td>
                            <td class="table-data-td">${PC030H.PC030S02!}</td>
                            <td class="table-data-td">
                                <#if PC030H.PC030J01??>
                                    ${PC030H.PC030J01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">公共信息概要</legend>
        <table class="mainTable">
            <#--<tr>-->
                <#--<td class="labeltd">公共信息类型数量</td>-->
                <#--<td class="datatd">${map.PPO.PC040S01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">公共信息概要信息列表(总计${map.PC040H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">公共信息类型</td>
                            <td class="table-label-td" style="width:33%;">记录数</td>
                            <td class="table-label-td" style="width:33%;">涉及金额</td>
                        </tr>
                        <#list map.PC040H! as PC040H>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6017",PC040H.PC040D01)!}</td>
                            <td class="table-data-td">${PC040H.PC040S02!}</td>
                            <td class="table-data-td">
                                <#if PC040H.PC040J01??>
                                    ${PC040H.PC040J01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">查询记录概要</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>上一次查询记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">查询日期</td>
                <td class="datatd">${map.PQO.PC05AR01!}</td>
                <td class="labeltd">查询机构机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6018",map.PQO.PC05AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询机构代码</td>
                <td class="datatd">${map.PQO.PC05AI01!}</td>
                <td class="labeltd">查询原因</td>
                <td class="datatd">${DataDicUtil.getDataDic("6004",map.PQO.PC05AQ01)!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>最近1个月内查询信息</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">查询机构数（贷款审批）</td>
                <td class="datatd">${map.PQO.PC05BS01!}</td>
                <td class="labeltd">查询机构数（信用卡审批）</td>
                <td class="datatd">${map.PQO.PC05BS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询次数（贷款审批）</td>
                <td class="datatd">${map.PQO.PC05BS03!}</td>
                <td class="labeltd">查询次数（信用卡审批）</td>
                <td class="datatd">${map.PQO.PC05BS04!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询次数（本人查询）</td>
                <td class="datatd">${map.PQO.PC05BS05!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>最近2年内查询信息</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">查询次数（贷后管理）</td>
                <td class="datatd">${map.PQO.PC05BS06!}</td>
                <td class="labeltd">查询次数（担保资格审查）</td>
                <td class="datatd">${map.PQO.PC05BS07!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询次数（特约商户实名审查）</td>
                <td class="datatd">${map.PQO.PC05BS08!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">借贷账户信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>基本信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户编号</td>
                <td class="datatd">${map.PDA.PD01AI01!}</td>
                <td class="labeltd">账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6019",map.PDA.PD01AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.PDA.PD01AD02)!}</td>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.PDA.PD01AI02!}</td>
            </tr>
            <tr>
                <td class="labeltd">账户标识</td>
                <td class="datatd">${map.PDA.PD01AI03!}</td>
                <td class="labeltd">授信协议编号</td>
                <td class="datatd">${map.PDA.PD01AI04!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务种类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6020",map.PDA.PD01AD03)!}</td>
                <td class="labeltd">开立日期</td>
                <td class="datatd">${map.PDA.PD01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("",map.PDA.PD01AD04)!}</td>
                <td class="labeltd">借款金额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01AJ01??>
                        ${map.PDA.PD01AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户授信额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01AJ02??>
                        ${map.PDA.PD01AJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">共享授信额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01AJ03??>
                        ${map.PDA.PD01AJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.PDA.PD01AR02!}</td>
                <td class="labeltd">还款方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6021",map.PDA.PD01AD05)!}</td>
            </tr>
            <tr>
                <td class="labeltd">还款频率</td>
                <td class="datatd">${DataDicUtil.getDataDic("6022",map.PDA.PD01AD06)!}</td>
                <td class="labeltd">还款期数</td>
                <td class="datatd">${map.PDA.PD01AS01!}</td>
            </tr>
            <tr>
                <td class="labeltd">担保方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6024",map.PDA.PD01AD07)!}</td>
                <td class="labeltd">贷款发放形式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6023",map.PDA.PD01AD08)!}</td>
            </tr>
            <tr>
                <td class="labeltd">共同借款标志</td>
                <td class="datatd">${DataDicUtil.getDataDic("6025",map.PDA.PD01AD09)!}</td>
                <td class="labeltd">债权转移时的还款状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6026",map.PDA.PD01AD10)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>最新表现信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6027",map.PDA.PD01BD01)!}</td>
                <td class="labeltd">关闭日期</td>
                <td class="datatd">${map.PDA.PD01BR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">转出月份</td>
                <td class="datatd">${map.PDA.PD01BR04!}</td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01BJ01??>
                        ${map.PDA.PD01BJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最近一次还款日期</td>
                <td class="datatd">${map.PDA.PD01BR02!}</td>
                <td class="labeltd">最近一次还款金额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01BJ02??>
                        ${map.PDA.PD01BJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.PDA.PD01BD03)!}</td>
                <td class="labeltd">还款状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6033",map.PDA.PD01BD04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.PDA.PD01BR03!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>最近一次月度表现信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">月份</td>
                <td class="datatd">${map.PDA.PD01CR01!}</td>
                <td class="labeltd">账户状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6027",map.PDA.PD01CD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ01??>
                        ${map.PDA.PD01CJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ02??>
                        ${map.PDA.PD01CJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">未出单的大额专项分期余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ03??>
                        ${map.PDA.PD01CJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.PDA.PD01CD02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">剩余还款期数</td>
                <td class="datatd">${map.PDA.PD01CS01!}</td>
                <td class="labeltd">结算/应还款日</td>
                <td class="datatd">${map.PDA.PD01CR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">本月应还款</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ04??>
                        ${map.PDA.PD01CJ04?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">本月实还款</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ05??>
                        ${map.PDA.PD01CJ05?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最近一次还款日期</td>
                <td class="datatd">${map.PDA.PD01CR03!}</td>
                <td class="labeltd">当前逾期期数</td>
                <td class="datatd">${map.PDA.PD01CS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">当前逾期总额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ06??>
                        ${map.PDA.PD01CJ06?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">逾期31—60天未还本金</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ07??>
                        ${map.PDA.PD01CJ07?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">逾期61－90天未还本金</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ08??>
                        ${map.PDA.PD01CJ08?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">逾期91－180天未还本金</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ09??>
                        ${map.PDA.PD01CJ09?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">逾期180天以上未还本金</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ10??>
                        ${map.PDA.PD01CJ10?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">透支180天以上未付余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ11??>
                        ${map.PDA.PD01CJ11?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最近6个月平均使用额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ12??>
                        ${map.PDA.PD01CJ12?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">最近6个月平均透支余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ13??>
                        ${map.PDA.PD01CJ13?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最大使用额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ14??>
                        ${map.PDA.PD01CJ14?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">最大透支余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ15??>
                        ${map.PDA.PD01CJ15?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.PDA.PD01CR04!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>最近24个月还款记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">起始年月</td>
                <td class="datatd">${map.PDA.PD01DR01!}</td>
                <td class="labeltd">截止年月</td>
                <td class="datatd">${map.PDA.PD01DR02!}</td>
            </tr>

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="2" class="table-head-td">还款状态信息列表(总计${map.PD01DH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">月份</td>
                            <td class="table-label-td" style="width:50%;">还款状态</td>
                        </tr>
                        <#list map.PD01DH! as PD01DH>
                        <tr>
                            <td class="table-data-td">${PD01DH.PD01DR03!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6033",PD01DH.PD01DD01)!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>最近5年内历史表现信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">起始年月</td>
                <td class="datatd">${map.PDA.PD01ER01!}</td>
                <td class="labeltd">截止年月</td>
                <td class="datatd">${map.PDA.PD01ER02!}</td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">月数</td>-->
                <#--<td class="datatd">${map.PDA.PD01ES01!}</td>-->
            <#--</tr>-->

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="3" class="table-head-td">历史表现信息列表(总计${map.PD01EH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">月份</td>
                            <td class="table-label-td" style="width:33%;">还款状态</td>
                            <td class="table-label-td" style="width:33%;">逾期（透支）总额</td>
                        </tr>
                        <#list map.PD01EH! as PD01EH>
                        <tr>
                            <td class="table-data-td">${PD01EH.PD01ER03!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6033",PD01EH.PD01ED01)!}</td>
                            <td class="table-data-td">
                                <#if PD01EH.PD01EJ01??>
                                    ${PD01EH.PD01EJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>特殊交易信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">特殊交易个数</td>-->
                <#--<td class="datatd">${map.PDA.PD01FS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">特殊交易信息列表(总计${map.PD01FH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:20%;">特殊交易类型</td>
                            <td class="table-label-td" style="width:20%;">特殊交易发生日期</td>
                            <td class="table-label-td" style="width:20%;">到期日期变更月数</td>
                            <td class="table-label-td" style="width:20%;">特殊交易发生金额</td>
                            <td class="table-label-td" style="width:20%;">特殊交易明细记录</td>
                        </tr>
                        <#list map.PD01FH! as PD01FH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6037",PD01FH.PD01FD01)!}</td>
                            <td class="table-data-td">${PD01FH.PD01FR01!}</td>
                            <td class="table-data-td">${PD01FH.PD01FS02!}</td>
                            <td class="table-data-td">
                                <#if PD01FH.PD01FJ01??>
                                    ${PD01FH.PD01FJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                            <td class="table-data-td">${PD01FH.PD01FQ01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>特殊事件说明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">特殊事件说明个数</td>-->
                <#--<td class="datatd">${map.PDA.PD01GS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">特殊事件说明信息列表(总计${map.PD01GH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">特殊事件发生月份</td>
                            <td class="table-label-td" style="width:50%;">特殊事件类型</td>
                        </tr>
                        <#list map.PD01GH! as PD01GH>
                        <tr>
                            <td class="table-data-td">${PD01GH.PD01GR01!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6038",PD01GH.PD01GD01)!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>大额专项分期信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">大额专项分期笔数</td>-->
                <#--<td class="datatd">${map.PDA.PD01HS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">大额专项分期信息列表(总计${map.PD01HH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:25%;">大额专项分期额度</td>
                            <td class="table-label-td" style="width:25%;">分期额度生效日期</td>
                            <td class="table-label-td" style="width:25%;">分期额度到期日期</td>
                            <td class="table-label-td" style="width:25%;">已用分期金额</td>
                        </tr>
                        <#list map.PD01HH! as PD01HH>
                        <tr>
                            <td class="table-data-td">
                                <#if PD01HH.PD01HJ01??>
                                    ${PD01HH.PD01HJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                            <td class="table-data-td">${PD01HH.PD01HR01!}</td>
                            <td class="table-data-td">${PD01HH.PD01HR02!}</td>
                            <td class="table-data-td">
                                <#if PD01HH.PD01HJ02??>
                                    ${PD01HH.PD01HJ02?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PDA.PD01ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PD01ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PD01ZH! as PD01ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PD01ZH.PD01ZD01)!}</td>
                            <td class="table-data-td">${PD01ZH.PD01ZQ01!}</td>
                            <td class="table-data-td">${PD01ZH.PD01ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">授信协议信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>基本信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">授信协议编号</td>
                <td class="datatd">${map.PCA.PD02AI01!}</td>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.PCA.PD02AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${map.PCA.PD02AI02!}</td>
                <td class="labeltd">授信协议标识</td>
                <td class="datatd">${map.PCA.PD02AI03!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信额度用途</td>
                <td class="datatd">${DataDicUtil.getDataDic("6040",map.PCA.PD02AD02)!}</td>
                <td class="labeltd">授信额度</td>
                <td class="datatd-number">
                    <#if map.PCA.PD02AJ01??>
                        ${map.PCA.PD02AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("",map.PCA.PD02AD03)!}</td>
                <td class="labeltd">生效日期</td>
                <td class="datatd">${map.PCA.PD02AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.PCA.PD02AR02!}</td>
                <td class="labeltd">授信协议状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6041",map.PCA.PD02AD04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                    <#if map.PCA.PD02AJ04??>
                        ${map.PCA.PD02AJ04?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">授信限额</td>
                <td class="datatd-number">
                    <#if map.PCA.PD02AJ03??>
                        ${map.PCA.PD02AJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">授信限额编号</td>
                <td class="datatd">${map.PCA.PD02AI04!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PCA.PD02ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PD02ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PD02ZH! as PD02ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PD02ZH.PD02ZD01)!}</td>
                            <td class="table-data-td">${PD02ZH.PD02ZQ01!}</td>
                            <td class="table-data-td">${PD02ZH.PD02ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">相关还款责任信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>相关还款责任信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">主借款人身份类别</td>
                <td class="datatd">${DataDicUtil.getDataDic("6001",map.PCR.PD03AD08)!}</td>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.PCR.PD03AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${map.PCR.PD03AQ01!}</td>
                <td class="labeltd">业务种类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6020",map.PCR.PD03AD02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">开立日期</td>
                <td class="datatd">${map.PCR.PD03AR01!}</td>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.PCR.PD03AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">相关还款责任人类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6044",map.PCR.PD03AD03)!}</td>
                <td class="labeltd">保证合同编号</td>
                <td class="datatd">${map.PCR.PD03AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">相关还款责任金额</td>
                <td class="datatd-number">
                    <#if map.PCR.PD03AJ01??>
                        ${map.PCR.PD03AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("",map.PCR.PD03AD04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCR.PD03AJ02??>
                        ${map.PCR.PD03AJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.PCR.PD03AD05)!}</td>
            </tr>
            <tr>
                <td class="labeltd">账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6019",map.PCR.PD03AD06)!}</td>
                <td class="labeltd">还款状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6033",map.PCR.PD03AD07)!}</td>
            </tr>
            <tr>
                <td class="labeltd">逾期月数</td>
                <td class="datatd">${map.PCR.PD03AS01!}</td>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.PCR.PD03AR03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PCR.PD03ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PD03ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PD03ZH! as PD03ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PD03ZH.PD03ZD01)!}</td>
                            <td class="table-data-td">${PD03ZH.PD03ZQ01!}</td>
                            <td class="table-data-td">${PD03ZH.PD03ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">后付费业务信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>后付费业务信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">后付费账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6045",map.PND.PE01AD01)!}</td>
                <td class="labeltd">机构名称</td>
                <td class="datatd">${map.PND.PE01AQ01!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6046",map.PND.PE01AD02)!}</td>
                <td class="labeltd">业务开通日期</td>
                <td class="datatd">${map.PND.PE01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">当前缴费状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6047",map.PND.PE01AD03)!}</td>
                <td class="labeltd">当前欠费金额</td>
                <td class="datatd-number">
                    <#if map.PND.PE01AJ01??>
                        ${map.PND.PE01AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">记账年月</td>
                <td class="datatd">${map.PND.PE01AR02!}</td>
                <td class="labeltd">最近24个月缴费记录</td>
                <td class="datatd">${map.PND.PE01AQ02!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PND.PE01ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PE01ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PE01ZH! as PE01ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PE01ZH.PE01ZD01!)!}</td>
                            <td class="table-data-td">${PE01ZH.PE01ZQ01!}</td>
                            <td class="table-data-td">${PE01ZH.PE01ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">欠税记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>欠税记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">主管税务机关</td>
                <td class="datatd">${map.POT.PF01AQ01!}</td>
                <td class="labeltd">欠税总额</td>
                <td class="datatd-number">
                    <#if map.POT.PF01AJ01??>
                        ${map.POT.PF01AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">欠税统计日期</td>
                <td class="datatd">${map.POT.PF01AR01!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.POT.PF01ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF01ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF01ZH! as PF01ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF01ZH.PF01ZD01)!}</td>
                            <td class="table-data-td">${PF01ZH.PF01ZQ01!}</td>
                            <td class="table-data-td">${PF01ZH.PF01ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">民事判决记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>民事判决记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">立案法院</td>
                <td class="datatd">${map.PCJ.PF02AQ01!}</td>
                <td class="labeltd">案由</td>
                <td class="datatd">${map.PCJ.PF02AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">立案日期</td>
                <td class="datatd">${map.PCJ.PF02AR01!}</td>
                <td class="labeltd">结案方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6049",map.PCJ.PF02AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">判决/调解结果</td>
                <td class="datatd">${map.PCJ.PF02AQ03!}</td>
                <td class="labeltd">判决/调解生效日期</td>
                <td class="datatd">${map.PCJ.PF02AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">诉讼标的</td>
                <td class="datatd">${map.PCJ.PF02AQ04!}</td>
                <td class="labeltd">诉讼标的金额</td>
                <td class="datatd-number">
                    <#if map.PCJ.PF02AJ01??>
                        ${map.PCJ.PF02AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PCJ.PF02ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF02ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF02ZH! as PF02ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF02ZH.PF02ZD01)!}</td>
                            <td class="table-data-td">${PF02ZH.PF02ZQ01!}</td>
                            <td class="table-data-td">${PF02ZH.PF02ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">强制执行记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>强制执行记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">执行法院</td>
                <td class="datatd">${map.PCE.PF03AQ01!}</td>
                <td class="labeltd">执行案由</td>
                <td class="datatd">${map.PCE.PF03AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">立案日期</td>
                <td class="datatd">${map.PCE.PF03AR01!}</td>
                <td class="labeltd">结案方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6050",map.PCE.PF03AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">案件状态</td>
                <td class="datatd">${map.PCE.PF03AQ03!}</td>
                <td class="labeltd">结案日期</td>
                <td class="datatd">${map.PCE.PF03AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">申请执行标的</td>
                <td class="datatd">${map.PCE.PF03AQ04!}</td>
                <td class="labeltd">申请执行标的金额</td>
                <td class="datatd-number">
                    <#if map.PCE.PF03AJ01??>
                        ${map.PCE.PF03AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">已执行标的</td>
                <td class="datatd">${map.PCE.PF03AQ05!}</td>
                <td class="labeltd">已执行标的金额</td>
                <td class="datatd-number">
                    <#if map.PCE.PF03AJ02??>
                        ${map.PCE.PF03AJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PCE.PF03ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF03ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF03ZH! as PF03ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF03ZH.PF03ZD01)!}</td>
                            <td class="table-data-td">${PF03ZH.PF03ZQ01!}</td>
                            <td class="table-data-td">${PF03ZH.PF03ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">行政处罚记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>行政处罚记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">处罚机构</td>
                <td class="datatd">${map.PAP.PF04AQ01!}</td>
                <td class="labeltd">处罚内容</td>
                <td class="datatd">${map.PAP.PF04AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚金额</td>
                <td class="datatd-number">
                    <#if map.PAP.PF04AJ01??>
                        ${map.PAP.PF04AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">处罚生效日期</td>
                <td class="datatd">${map.PAP.PF04AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚截止日期</td>
                <td class="datatd">${map.PAP.PF04AR02!}</td>
                <td class="labeltd">行政复议结果</td>
                <td class="datatd">${map.PAP.PF04AQ03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PAP.PF04ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF04ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF04ZH! as PF04ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF04ZH.PF04ZD01)!}</td>
                            <td class="table-data-td">${PF04ZH.PF04ZQ01!}</td>
                            <td class="table-data-td">${PF04ZH.PF04ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">住房公积金参缴记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>住房公积金参缴记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">参缴地</td>
                <td class="datatd">${map.PHF.PF05AQ01!}</td>
                <td class="labeltd">参缴日期</td>
                <td class="datatd">${map.PHF.PF05AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">缴费状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6051",map.PHF.PF05AD01)!}</td>
                <td class="labeltd">初缴月份</td>
                <td class="datatd">${map.PHF.PF05AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">缴至月份</td>
                <td class="datatd">${map.PHF.PF05AR03!}</td>
                <td class="labeltd">单位缴存比例</td>
                <td class="datatd">${map.PHF.PF05AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">个人缴存比例</td>
                <td class="datatd">${map.PHF.PF05AQ03!}</td>
                <td class="labeltd">月缴存额</td>
                <td class="datatd-number">
                    <#if map.PHF.PF05AJ01??>
                        ${map.PHF.PF05AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">缴费单位</td>
                <td class="datatd">${map.PHF.PF05AQ04!}</td>
                <td class="labeltd">信息更新日期</td>
                <td class="datatd">${map.PHF.PF05AR04!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PHF.PF05ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF05ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF05ZH! as PF05ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF05ZH.PF05ZD01)!}</td>
                            <td class="table-data-td">${PF05ZH.PF05ZQ01!}</td>
                            <td class="table-data-td">${PF05ZH.PF05ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">低保救助记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>低保救助记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">人员类别</td>
                <td class="datatd">${DataDicUtil.getDataDic("6052",map.PBS.PF06AD01)!}</td>
                <td class="labeltd">所在地</td>
                <td class="datatd">${map.PBS.PF06AQ01!}</td>
            </tr>
            <tr>
                <td class="labeltd">工作单位</td>
                <td class="datatd">${map.PBS.PF06AQ02!}</td>
                <td class="labeltd">家庭月收入</td>
                <td class="datatd-number">
                    <#if map.PBS.PF06AQ03??>
                        ${map.PBS.PF06AQ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">申请日期</td>
                <td class="datatd">${map.PBS.PF06AR01!}</td>
                <td class="labeltd">批准日期</td>
                <td class="datatd">${map.PBS.PF06AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">信息更新日期</td>
                <td class="datatd">${map.PBS.PF06AR03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <#--<tr>-->
                <#--<td class="labeltd">标注及声明个数</td>-->
                <#--<td class="datatd">${map.PBS.PF06ZS01!}</td>-->
            <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF06ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF06ZH! as PF06ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF06ZH.PF06ZD01)!}</td>
                            <td class="table-data-td">${PF06ZH.PF06ZQ01!}</td>
                            <td class="table-data-td">${PF06ZH.PF06ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">执业资格记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>执业资格记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">执业资格名称</td>
                <td class="datatd">${map.PPQ.PF07AQ01!}</td>
                <td class="labeltd">颁发机构</td>
                <td class="datatd">${map.PPQ.PF07AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">等级</td>
                <td class="datatd">${DataDicUtil.getDataDic("6053",map.PPQ.PF07AD01)!}</td>
                <td class="labeltd">机构所在地</td>
                <td class="datatd">${map.PPQ.PF07AD02!}</td>
            </tr>
            <tr>
                <td class="labeltd">获得年月</td>
                <td class="datatd">${map.PPQ.PF07AR01!}</td>
                <td class="labeltd">到期年月</td>
                <td class="datatd">${map.PPQ.PF07AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">吊销年月</td>
                <td class="datatd">${map.PPQ.PF07AR03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF07ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF07ZH! as PF07ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF07ZH.PF07ZD01)!}</td>
                            <td class="table-data-td">${PF07ZH.PF07ZQ01!}</td>
                            <td class="table-data-td">${PF07ZH.PF07ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">行政奖励记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>行政奖励记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">奖励机构</td>
                <td class="datatd">${map.PAH.PF08AQ01!}</td>
                <td class="labeltd">奖励内容</td>
                <td class="datatd">${map.PAH.PF08AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">生效年月</td>
                <td class="datatd">${map.PAH.PF08AR01!}</td>
                <td class="labeltd">截止年月</td>
                <td class="datatd">${map.PAH.PF08AR02!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PAH.PF08ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF08ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF08ZH! as PF08ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6120",PF08ZH.PF08ZD01)!}</td>
                            <td class="table-data-td">${PF08ZH.PF08ZQ01!}</td>
                            <td class="table-data-td">${PF08ZH.PF08ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">其他标注及声明信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">对象类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6054",map.POS.PG010D01)!}</td>
                <td class="labeltd">对象标识</td>
                <td class="datatd">${DataDicUtil.getDataDic("6055",map.POS.PG010D02)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PG010H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PG010H! as PG010H>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PG010H.PG010D03)!}</td>
                            <td class="table-data-td">${PG010H.PG010Q01!}</td>
                            <td class="table-data-td">${PG010H.PG010R01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">查询记录</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">查询日期</td>
                <td class="datatd">${map.POQ.PH010R01!}</td>
                <td class="labeltd">查询机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6018",map.POQ.PH010D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询机构</td>
                <td class="datatd">${map.POQ.PH010Q02!}</td>
                <td class="labeltd">查询原因</td>
                <td class="datatd">${DataDicUtil.getDataDic("6004",map.POQ.PH010Q03)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>




    <h2>个人信用报告</h2>

    <fieldset>
    <#--CR_PER_PRH-->
        <legend align="center">报告头</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">报告编号</td>
                <td class="datatd">${map.PRH.PA01AI01!}</td>
                <td class="labeltd">报告时间</td>
                <td class="datatd">${map.PRH.PA01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">被查询者姓名</td>
                <td class="datatd">${map.PRH.PA01BQ01!}</td>
                <td class="labeltd">被查询者证件类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6002", map.PRH.PA01BD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">被查询者证件号码</td>
                <td class="datatd">${map.PRH.PA01BI01!}</td>
                <td class="labeltd">查询机构代码</td>
                <td class="datatd">${map.PRH.PA01BI02!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询原因代码</td>
                <td class="datatd">${DataDicUtil.getDataDic("6004",map.PRH.PA01BD02)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="2" class="table-head-td">其他身份标识列表(总计${map.PA01CH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">证件类型</td>
                            <td class="table-label-td" style="width:50%;">证件号码</td>
                        </tr>
                        <#list map.PA01CH! as PA01CH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6002",PA01CH.PA01CD01)!}</td>
                            <td class="table-data-td">${PA01CH.PA01CI01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="labeltd">防欺诈警示标志</td>
                <td class="datatd">${DataDicUtil.getDataDic("6003",map.PRH.PA01DQ01)!}</td>
                <td class="labeltd">防欺诈警示联系电话</td>
                <td class="datatd">${map.PRH.PA01DQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">防欺诈警示生效日期</td>
                <td class="datatd">${map.PRH.PA01DR01!}</td>
                <td class="labeltd">防欺诈警示截止日期</td>
                <td class="datatd">${map.PRH.PA01DR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">异议标注数目</td>
                <td class="datatd">${map.PRH.PA01ES01!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">身份信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">性别</td>
                <td class="datatd">${DataDicUtil.getDataDic("6059", map.PIM.PB01AD01)!}</td>
                <td class="labeltd">出生日期</td>
                <td class="datatd">${map.PIM.PB01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">学历</td>
                <td class="datatd">${DataDicUtil.getDataDic("6060", map.PIM.PB01AD02)!}</td>
                <td class="labeltd">学位</td>
                <td class="datatd">${DataDicUtil.getDataDic("6061", map.PIM.PB01AD03)!}</td>
            </tr>
            <tr>
                <td class="labeltd">就业状况</td>
                <td class="datatd">${DataDicUtil.getDataDic("6062", map.PIM.PB01AD04)!}</td>
                <td class="labeltd">电子邮箱</td>
                <td class="datatd">${map.PIM.PB01AQ01!}</td>
            </tr>
            <tr>
                <td class="labeltd">通讯地址</td>
                <td class="datatd" colspan="3">${map.PIM.PB01AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">户籍地址</td>
                <td class="datatd" colspan="3">${map.PIM.PB01AQ03!}</td>
            </tr>
            <tr>
                <td class="labeltd">国籍</td>
                <td class="datatd">${DataDicUtil.getDataDic("6056", map.PIM.PB01AD05)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="2" class="table-head-td">手机号码列表(总计${map.PB01BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">手机号码</td>
                            <td class="table-label-td" style="width:50%;">信息更新日期</td>
                        </tr>
                        <#list map.PB01BH! as PB01BH>
                        <tr>
                            <td class="table-data-td">${PB01BH.PB01BQ01!}</td>
                            <td class="table-data-td">${PB01BH.PB01BR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">婚姻信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">婚姻状况</td>
                <td class="datatd">${DataDicUtil.getDataDic("6063", map.PMM.PB020D01)!}</td>
                <td class="labeltd">配偶姓名</td>
                <td class="datatd">${map.PMM.PB020Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">配偶证件类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6002", map.PMM.PB020D02)!}</td>
                <td class="labeltd">配偶证件号码</td>
                <td class="datatd">${map.PMM.PB020I01!}</td>
            </tr>
            <tr>
                <td class="labeltd">配偶工作单位</td>
                <td class="datatd">${map.PMM.PB020Q02!}</td>
                <td class="labeltd">配偶联系电话</td>
                <td class="datatd">${map.PMM.PB020Q03!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">居住信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">居住状况</td>
                <td class="datatd">${DataDicUtil.getDataDic("6005", map.PRM.PB030D01)!}</td>
                <td class="labeltd">居住地址</td>
                <td class="datatd">${map.PRM.PB030Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">住宅电话</td>
                <td class="datatd">${map.PRM.PB030Q02!}</td>
                <td class="labeltd">信息更新日期</td>
                <td class="datatd">${map.PRM.PB030R01!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">职业信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">就业状况</td>
                <td class="datatd">${DataDicUtil.getDataDic("6062", map.POM.PB040D01)!}</td>
                <td class="labeltd">工作单位</td>
                <td class="datatd">${map.POM.PB040Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">单位性质</td>
                <td class="datatd">${DataDicUtil.getDataDic("6006", map.POM.PB040D02)!}</td>
                <td class="labeltd">行业</td>
                <td class="datatd">${DataDicUtil.getDataDic("6064", map.POM.PB040D03)!}</td>
            </tr>
            <tr>
                <td class="labeltd">单位地址</td>
                <td class="datatd">${map.POM.PB040Q02!}</td>
                <td class="labeltd">单位电话</td>
                <td class="datatd">${map.POM.PB040Q03!}</td>
            </tr>
            <tr>
                <td class="labeltd">职业</td>
                <td class="datatd">${DataDicUtil.getDataDic("6007", map.POM.PB040D04)!}</td>
                <td class="labeltd">职务</td>
                <td class="datatd">${DataDicUtil.getDataDic("6008", map.POM.PB040D05)!}</td>
            </tr>
            <tr>
                <td class="labeltd">职称</td>
                <td class="datatd">${DataDicUtil.getDataDic("6009", map.POM.PB040D06)!}</td>
                <td class="labeltd">进入本单位年份</td>
                <td class="datatd">${map.POM.PB040R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">信息更新日期</td>
                <td class="datatd">${map.POM.PB040R02!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">评分信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">数字解读</td>
                <td class="datatd">${map.PSM.PC010Q01!}</td>
                <td class="labeltd">相对位置</td>
                <td class="datatd">${map.PSM.PC010Q02!}</td>
            </tr>
            <tr>
                <td class="labeltd">分数说明条数</td>
                <td class="datatd">${map.PSM.PC010S01!}</td>
                <td class="labeltd">分数说明</td>
                <td class="datatd">${DataDicUtil.getDataDic("6010", map.PSM.PC010D01)!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">信贷交易信息概要</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>信贷交易提示信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户数合计</td>
                <td class="datatd">${map.PCO.PC02AS01!}</td>
            <#--<td class="labeltd">业务类型数量</td>-->
            <#--<td class="datatd">${map.PCO.PC02AS02!}</td>-->
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">信贷交易提示信息列表(总计${map.PC02AH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:25%;">业务类型</td>
                            <td class="table-label-td" style="width:25%;">业务大类</td>
                            <td class="table-label-td" style="width:25%;">账户数</td>
                            <td class="table-label-td" style="width:25%;">首笔业务发放月份</td>
                        </tr>
                        <#list map.PC02AH! as PC02AH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6011", PC02AH.PC02AD01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6012", PC02AH.PC02AD02)!}</td>
                            <td class="table-data-td">${PC02AH.PC02AS03!}</td>
                            <td class="table-data-td">${PC02AH.PC02AR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>被追偿汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户数合计</td>
                <td class="datatd">${map.PCO.PC02BS01!}</td>
                <td class="labeltd">余额合计</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02BJ01??>
                        ${map.PCO.PC02BJ01?string(',###')}
                    <#else >

                    </#if>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">业务类型数量</td>-->
        <#--<td class="datatd">${map.PCO.PC02BS02!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">被追偿汇总信息列表(总计${map.PC02BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">业务类型</td>
                            <td class="table-label-td" style="width:33%;">账户数</td>
                            <td class="table-label-td" style="width:33%;">余额</td>
                        </tr>
                        <#list map.PC02BH! as PC02BH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6013", PC02BH.PC02BD01)!}</td>
                            <td class="table-data-td">${PC02BH.PC02BS03!}</td>
                            <td class="table-data-td">
                                <#if PC02BH.PC02BJ02??>
                                    ${PC02BH.PC02BJ02?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>呆账汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02CS01!}</td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02CJ01??>
                        ${map.PCO.PC02CJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>逾期（透支）汇总信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">账户类型数量</td>-->
        <#--<td class="datatd">${map.PCO.PC02DS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">逾期（透支）汇总信息列表(总计${map.PC02DH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:20%;">账户类型</td>
                            <td class="table-label-td" style="width:20%;">账户数</td>
                            <td class="table-label-td" style="width:20%;">月份数</td>
                            <td class="table-label-td" style="width:20%;">单月最高逾期（透支）总额</td>
                            <td class="table-label-td" style="width:20%;">最长逾期（透支）月数</td>
                        </tr>
                        <#list map.PC02DH! as PC02DH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6014", PC02DH.PC02DD01)!}</td>
                            <td class="table-data-td">${PC02DH.PC02DS02!}</td>
                            <td class="table-data-td">${PC02DH.PC02DS03!}</td>
                            <td class="table-data-td">
                                <#if PC02DH.PC02DJ01??>
                                    ${PC02DH.PC02DJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                            <td class="table-data-td">${PC02DH.PC02DS04!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>非循环贷账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">管理机构数</td>
                <td class="datatd">${map.PCO.PC02ES01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02ES02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02EJ01??>
                        ${map.PCO.PC02EJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02EJ02??>
                        ${map.PCO.PC02EJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均应还款</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02EJ03??>
                        ${map.PCO.PC02EJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>循环额度下分账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">管理机构数</td>
                <td class="datatd">${map.PCO.PC02FS01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02FS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02FJ01??>
                        ${map.PCO.PC02FJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02FJ02??>
                        ${map.PCO.PC02FJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均应还款</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02FJ03??>
                        ${map.PCO.PC02FJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>循环贷账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">管理机构数</td>
                <td class="datatd">${map.PCO.PC02GS01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02GS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02GJ01??>
                        ${map.PCO.PC02GJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02GJ02??>
                        ${map.PCO.PC02GJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均应还款</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02GJ03??>
                        ${map.PCO.PC02GJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>贷记卡账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">发卡机构数</td>
                <td class="datatd">${map.PCO.PC02HS01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02HS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ01??>
                        ${map.PCO.PC02HJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">单家行最高授信额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ02??>
                        ${map.PCO.PC02HJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">单家行最低授信额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ03??>
                        ${map.PCO.PC02HJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ04??>
                        ${map.PCO.PC02HJ04?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均使用额度</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02HJ05??>
                        ${map.PCO.PC02HJ05?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>准贷记卡账户汇总信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">发卡机构数</td>
                <td class="datatd">${map.PCO.PC02IS01!}</td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.PCO.PC02IS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信总额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ01??>
                        ${map.PCO.PC02IJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">单家行最高授信额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ02??>
                        ${map.PCO.PC02IJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">单家行最低授信额</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ03??>
                        ${map.PCO.PC02IJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ04??>
                        ${map.PCO.PC02IJ04?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">最近6个月平均使用额度</td>
                <td class="datatd-number">
                    <#if map.PCO.PC02IJ05??>
                        ${map.PCO.PC02IJ05?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>相关还款责任汇总信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">相关还款责任个数</td>-->
        <#--<td class="datatd">${map.PCO.PC02KS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">相关还款责任汇总信息列表(总计${map.PC02KH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:20%;">借款人身份类别</td>
                            <td class="table-label-td" style="width:20%;">还款责任类型</td>
                            <td class="table-label-td" style="width:20%;">账户数</td>
                            <td class="table-label-td" style="width:20%;">还款责任金额</td>
                            <td class="table-label-td" style="width:20%;">余额</td>
                        </tr>
                        <#list map.PC02KH! as PC02KH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6001", PC02KH.PC02KD01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6015", PC02KH.PC02KD02)!}</td>
                            <td class="table-data-td">${PC02KH.PC02KS02!}</td>
                            <td class="table-data-td">
                                <#if PC02KH.PC02KJ01??>
                                    ${PC02KH.PC02KJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                            <td class="table-data-td">
                                <#if PC02KH.PC02KJ02??>
                                    ${PC02KH.PC02KJ02?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">非信贷交易信息概要</legend>
        <table class="mainTable">
        <#--<tr>-->
        <#--<td class="labeltd">后付费业务类型数量</td>-->
        <#--<td class="datatd">${map.PNO.PC030S01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">后付费业务欠费信息汇总信息列表(总计${map.PC030H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">后付费业务类型</td>
                            <td class="table-label-td" style="width:33%;">欠费账户数</td>
                            <td class="table-label-td" style="width:33%;">欠费金额</td>
                        </tr>
                        <#list map.PC030H! as PC030H>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6016",PC030H.PC030D01)!}</td>
                            <td class="table-data-td">${PC030H.PC030S02!}</td>
                            <td class="table-data-td">
                                <#if PC030H.PC030J01??>
                                    ${PC030H.PC030J01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">公共信息概要</legend>
        <table class="mainTable">
        <#--<tr>-->
        <#--<td class="labeltd">公共信息类型数量</td>-->
        <#--<td class="datatd">${map.PPO.PC040S01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">公共信息概要信息列表(总计${map.PC040H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">公共信息类型</td>
                            <td class="table-label-td" style="width:33%;">记录数</td>
                            <td class="table-label-td" style="width:33%;">涉及金额</td>
                        </tr>
                        <#list map.PC040H! as PC040H>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6017",PC040H.PC040D01)!}</td>
                            <td class="table-data-td">${PC040H.PC040S02!}</td>
                            <td class="table-data-td">
                                <#if PC040H.PC040J01??>
                                    ${PC040H.PC040J01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">查询记录概要</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>上一次查询记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">查询日期</td>
                <td class="datatd">${map.PQO.PC05AR01!}</td>
                <td class="labeltd">查询机构机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6018",map.PQO.PC05AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询机构代码</td>
                <td class="datatd">${map.PQO.PC05AI01!}</td>
                <td class="labeltd">查询原因</td>
                <td class="datatd">${DataDicUtil.getDataDic("6004",map.PQO.PC05AQ01)!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>最近1个月内查询信息</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">查询机构数（贷款审批）</td>
                <td class="datatd">${map.PQO.PC05BS01!}</td>
                <td class="labeltd">查询机构数（信用卡审批）</td>
                <td class="datatd">${map.PQO.PC05BS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询次数（贷款审批）</td>
                <td class="datatd">${map.PQO.PC05BS03!}</td>
                <td class="labeltd">查询次数（信用卡审批）</td>
                <td class="datatd">${map.PQO.PC05BS04!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询次数（本人查询）</td>
                <td class="datatd">${map.PQO.PC05BS05!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>最近2年内查询信息</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">查询次数（贷后管理）</td>
                <td class="datatd">${map.PQO.PC05BS06!}</td>
                <td class="labeltd">查询次数（担保资格审查）</td>
                <td class="datatd">${map.PQO.PC05BS07!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询次数（特约商户实名审查）</td>
                <td class="datatd">${map.PQO.PC05BS08!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">借贷账户信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>基本信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户编号</td>
                <td class="datatd">${map.PDA.PD01AI01!}</td>
                <td class="labeltd">账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6019",map.PDA.PD01AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.PDA.PD01AD02)!}</td>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.PDA.PD01AI02!}</td>
            </tr>
            <tr>
                <td class="labeltd">账户标识</td>
                <td class="datatd">${map.PDA.PD01AI03!}</td>
                <td class="labeltd">授信协议编号</td>
                <td class="datatd">${map.PDA.PD01AI04!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务种类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6020",map.PDA.PD01AD03)!}</td>
                <td class="labeltd">开立日期</td>
                <td class="datatd">${map.PDA.PD01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("",map.PDA.PD01AD04)!}</td>
                <td class="labeltd">借款金额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01AJ01??>
                        ${map.PDA.PD01AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户授信额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01AJ02??>
                        ${map.PDA.PD01AJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">共享授信额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01AJ03??>
                        ${map.PDA.PD01AJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.PDA.PD01AR02!}</td>
                <td class="labeltd">还款方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6021",map.PDA.PD01AD05)!}</td>
            </tr>
            <tr>
                <td class="labeltd">还款频率</td>
                <td class="datatd">${DataDicUtil.getDataDic("6022",map.PDA.PD01AD06)!}</td>
                <td class="labeltd">还款期数</td>
                <td class="datatd">${map.PDA.PD01AS01!}</td>
            </tr>
            <tr>
                <td class="labeltd">担保方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6024",map.PDA.PD01AD07)!}</td>
                <td class="labeltd">贷款发放形式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6023",map.PDA.PD01AD08)!}</td>
            </tr>
            <tr>
                <td class="labeltd">共同借款标志</td>
                <td class="datatd">${DataDicUtil.getDataDic("6025",map.PDA.PD01AD09)!}</td>
                <td class="labeltd">债权转移时的还款状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6026",map.PDA.PD01AD10)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>最新表现信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6027",map.PDA.PD01BD01)!}</td>
                <td class="labeltd">关闭日期</td>
                <td class="datatd">${map.PDA.PD01BR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">转出月份</td>
                <td class="datatd">${map.PDA.PD01BR04!}</td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01BJ01??>
                        ${map.PDA.PD01BJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最近一次还款日期</td>
                <td class="datatd">${map.PDA.PD01BR02!}</td>
                <td class="labeltd">最近一次还款金额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01BJ02??>
                        ${map.PDA.PD01BJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.PDA.PD01BD03)!}</td>
                <td class="labeltd">还款状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6033",map.PDA.PD01BD04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.PDA.PD01BR03!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>最近一次月度表现信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">月份</td>
                <td class="datatd">${map.PDA.PD01CR01!}</td>
                <td class="labeltd">账户状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6027",map.PDA.PD01CD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ01??>
                        ${map.PDA.PD01CJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ02??>
                        ${map.PDA.PD01CJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">未出单的大额专项分期余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ03??>
                        ${map.PDA.PD01CJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.PDA.PD01CD02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">剩余还款期数</td>
                <td class="datatd">${map.PDA.PD01CS01!}</td>
                <td class="labeltd">结算/应还款日</td>
                <td class="datatd">${map.PDA.PD01CR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">本月应还款</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ04??>
                        ${map.PDA.PD01CJ04?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">本月实还款</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ05??>
                        ${map.PDA.PD01CJ05?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最近一次还款日期</td>
                <td class="datatd">${map.PDA.PD01CR03!}</td>
                <td class="labeltd">当前逾期期数</td>
                <td class="datatd">${map.PDA.PD01CS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">当前逾期总额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ06??>
                        ${map.PDA.PD01CJ06?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">逾期31—60天未还本金</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ07??>
                        ${map.PDA.PD01CJ07?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">逾期61－90天未还本金</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ08??>
                        ${map.PDA.PD01CJ08?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">逾期91－180天未还本金</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ09??>
                        ${map.PDA.PD01CJ09?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">逾期180天以上未还本金</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ10??>
                        ${map.PDA.PD01CJ10?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">透支180天以上未付余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ11??>
                        ${map.PDA.PD01CJ11?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最近6个月平均使用额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ12??>
                        ${map.PDA.PD01CJ12?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">最近6个月平均透支余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ13??>
                        ${map.PDA.PD01CJ13?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最大使用额度</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ14??>
                        ${map.PDA.PD01CJ14?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">最大透支余额</td>
                <td class="datatd-number">
                    <#if map.PDA.PD01CJ15??>
                        ${map.PDA.PD01CJ15?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.PDA.PD01CR04!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>最近24个月还款记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">起始年月</td>
                <td class="datatd">${map.PDA.PD01DR01!}</td>
                <td class="labeltd">截止年月</td>
                <td class="datatd">${map.PDA.PD01DR02!}</td>
            </tr>

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="2" class="table-head-td">还款状态信息列表(总计${map.PD01DH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">月份</td>
                            <td class="table-label-td" style="width:50%;">还款状态</td>
                        </tr>
                        <#list map.PD01DH! as PD01DH>
                        <tr>
                            <td class="table-data-td">${PD01DH.PD01DR03!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6033",PD01DH.PD01DD01)!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>最近5年内历史表现信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">起始年月</td>
                <td class="datatd">${map.PDA.PD01ER01!}</td>
                <td class="labeltd">截止年月</td>
                <td class="datatd">${map.PDA.PD01ER02!}</td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">月数</td>-->
        <#--<td class="datatd">${map.PDA.PD01ES01!}</td>-->
        <#--</tr>-->

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="3" class="table-head-td">历史表现信息列表(总计${map.PD01EH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">月份</td>
                            <td class="table-label-td" style="width:33%;">还款状态</td>
                            <td class="table-label-td" style="width:33%;">逾期（透支）总额</td>
                        </tr>
                        <#list map.PD01EH! as PD01EH>
                        <tr>
                            <td class="table-data-td">${PD01EH.PD01ER03!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6033",PD01EH.PD01ED01)!}</td>
                            <td class="table-data-td">
                                <#if PD01EH.PD01EJ01??>
                                    ${PD01EH.PD01EJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>特殊交易信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">特殊交易个数</td>-->
        <#--<td class="datatd">${map.PDA.PD01FS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">特殊交易信息列表(总计${map.PD01FH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:20%;">特殊交易类型</td>
                            <td class="table-label-td" style="width:20%;">特殊交易发生日期</td>
                            <td class="table-label-td" style="width:20%;">到期日期变更月数</td>
                            <td class="table-label-td" style="width:20%;">特殊交易发生金额</td>
                            <td class="table-label-td" style="width:20%;">特殊交易明细记录</td>
                        </tr>
                        <#list map.PD01FH! as PD01FH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6037",PD01FH.PD01FD01)!}</td>
                            <td class="table-data-td">${PD01FH.PD01FR01!}</td>
                            <td class="table-data-td">${PD01FH.PD01FS02!}</td>
                            <td class="table-data-td">
                                <#if PD01FH.PD01FJ01??>
                                    ${PD01FH.PD01FJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                            <td class="table-data-td">${PD01FH.PD01FQ01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>特殊事件说明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">特殊事件说明个数</td>-->
        <#--<td class="datatd">${map.PDA.PD01GS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">特殊事件说明信息列表(总计${map.PD01GH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">特殊事件发生月份</td>
                            <td class="table-label-td" style="width:50%;">特殊事件类型</td>
                        </tr>
                        <#list map.PD01GH! as PD01GH>
                        <tr>
                            <td class="table-data-td">${PD01GH.PD01GR01!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6038",PD01GH.PD01GD01)!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>大额专项分期信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">大额专项分期笔数</td>-->
        <#--<td class="datatd">${map.PDA.PD01HS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">大额专项分期信息列表(总计${map.PD01HH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:25%;">大额专项分期额度</td>
                            <td class="table-label-td" style="width:25%;">分期额度生效日期</td>
                            <td class="table-label-td" style="width:25%;">分期额度到期日期</td>
                            <td class="table-label-td" style="width:25%;">已用分期金额</td>
                        </tr>
                        <#list map.PD01HH! as PD01HH>
                        <tr>
                            <td class="table-data-td">
                                <#if PD01HH.PD01HJ01??>
                                    ${PD01HH.PD01HJ01?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                            <td class="table-data-td">${PD01HH.PD01HR01!}</td>
                            <td class="table-data-td">${PD01HH.PD01HR02!}</td>
                            <td class="table-data-td">
                                <#if PD01HH.PD01HJ02??>
                                    ${PD01HH.PD01HJ02?string(',###')!}
                                <#else >

                                </#if>
                            </td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>


            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PDA.PD01ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PD01ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PD01ZH! as PD01ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PD01ZH.PD01ZD01)!}</td>
                            <td class="table-data-td">${PD01ZH.PD01ZQ01!}</td>
                            <td class="table-data-td">${PD01ZH.PD01ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">授信协议信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>基本信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">授信协议编号</td>
                <td class="datatd">${map.PCA.PD02AI01!}</td>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.PCA.PD02AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${map.PCA.PD02AI02!}</td>
                <td class="labeltd">授信协议标识</td>
                <td class="datatd">${map.PCA.PD02AI03!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信额度用途</td>
                <td class="datatd">${DataDicUtil.getDataDic("6040",map.PCA.PD02AD02)!}</td>
                <td class="labeltd">授信额度</td>
                <td class="datatd-number">
                    <#if map.PCA.PD02AJ01??>
                        ${map.PCA.PD02AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("",map.PCA.PD02AD03)!}</td>
                <td class="labeltd">生效日期</td>
                <td class="datatd">${map.PCA.PD02AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.PCA.PD02AR02!}</td>
                <td class="labeltd">授信协议状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6041",map.PCA.PD02AD04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                    <#if map.PCA.PD02AJ04??>
                        ${map.PCA.PD02AJ04?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">授信限额</td>
                <td class="datatd-number">
                    <#if map.PCA.PD02AJ03??>
                        ${map.PCA.PD02AJ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">授信限额编号</td>
                <td class="datatd">${map.PCA.PD02AI04!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PCA.PD02ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PD02ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PD02ZH! as PD02ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PD02ZH.PD02ZD01)!}</td>
                            <td class="table-data-td">${PD02ZH.PD02ZQ01!}</td>
                            <td class="table-data-td">${PD02ZH.PD02ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">相关还款责任信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>相关还款责任信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">主借款人身份类别</td>
                <td class="datatd">${DataDicUtil.getDataDic("6001",map.PCR.PD03AD08)!}</td>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.PCR.PD03AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${map.PCR.PD03AQ01!}</td>
                <td class="labeltd">业务种类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6020",map.PCR.PD03AD02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">开立日期</td>
                <td class="datatd">${map.PCR.PD03AR01!}</td>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.PCR.PD03AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">相关还款责任人类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6044",map.PCR.PD03AD03)!}</td>
                <td class="labeltd">保证合同编号</td>
                <td class="datatd">${map.PCR.PD03AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">相关还款责任金额</td>
                <td class="datatd-number">
                    <#if map.PCR.PD03AJ01??>
                        ${map.PCR.PD03AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("",map.PCR.PD03AD04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                    <#if map.PCR.PD03AJ02??>
                        ${map.PCR.PD03AJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.PCR.PD03AD05)!}</td>
            </tr>
            <tr>
                <td class="labeltd">账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6019",map.PCR.PD03AD06)!}</td>
                <td class="labeltd">还款状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6033",map.PCR.PD03AD07)!}</td>
            </tr>
            <tr>
                <td class="labeltd">逾期月数</td>
                <td class="datatd">${map.PCR.PD03AS01!}</td>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.PCR.PD03AR03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PCR.PD03ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PD03ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PD03ZH! as PD03ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PD03ZH.PD03ZD01)!}</td>
                            <td class="table-data-td">${PD03ZH.PD03ZQ01!}</td>
                            <td class="table-data-td">${PD03ZH.PD03ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">后付费业务信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>后付费业务信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">后付费账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6045",map.PND.PE01AD01)!}</td>
                <td class="labeltd">机构名称</td>
                <td class="datatd">${map.PND.PE01AQ01!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6046",map.PND.PE01AD02)!}</td>
                <td class="labeltd">业务开通日期</td>
                <td class="datatd">${map.PND.PE01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">当前缴费状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6047",map.PND.PE01AD03)!}</td>
                <td class="labeltd">当前欠费金额</td>
                <td class="datatd-number">
                    <#if map.PND.PE01AJ01??>
                        ${map.PND.PE01AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">记账年月</td>
                <td class="datatd">${map.PND.PE01AR02!}</td>
                <td class="labeltd">最近24个月缴费记录</td>
                <td class="datatd">${map.PND.PE01AQ02!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PND.PE01ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PE01ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PE01ZH! as PE01ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PE01ZH.PE01ZD01!)!}</td>
                            <td class="table-data-td">${PE01ZH.PE01ZQ01!}</td>
                            <td class="table-data-td">${PE01ZH.PE01ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">欠税记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>欠税记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">主管税务机关</td>
                <td class="datatd">${map.POT.PF01AQ01!}</td>
                <td class="labeltd">欠税总额</td>
                <td class="datatd-number">
                    <#if map.POT.PF01AJ01??>
                        ${map.POT.PF01AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">欠税统计日期</td>
                <td class="datatd">${map.POT.PF01AR01!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.POT.PF01ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF01ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF01ZH! as PF01ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF01ZH.PF01ZD01)!}</td>
                            <td class="table-data-td">${PF01ZH.PF01ZQ01!}</td>
                            <td class="table-data-td">${PF01ZH.PF01ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">民事判决记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>民事判决记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">立案法院</td>
                <td class="datatd">${map.PCJ.PF02AQ01!}</td>
                <td class="labeltd">案由</td>
                <td class="datatd">${map.PCJ.PF02AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">立案日期</td>
                <td class="datatd">${map.PCJ.PF02AR01!}</td>
                <td class="labeltd">结案方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6049",map.PCJ.PF02AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">判决/调解结果</td>
                <td class="datatd">${map.PCJ.PF02AQ03!}</td>
                <td class="labeltd">判决/调解生效日期</td>
                <td class="datatd">${map.PCJ.PF02AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">诉讼标的</td>
                <td class="datatd">${map.PCJ.PF02AQ04!}</td>
                <td class="labeltd">诉讼标的金额</td>
                <td class="datatd-number">
                    <#if map.PCJ.PF02AJ01??>
                        ${map.PCJ.PF02AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PCJ.PF02ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF02ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF02ZH! as PF02ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF02ZH.PF02ZD01)!}</td>
                            <td class="table-data-td">${PF02ZH.PF02ZQ01!}</td>
                            <td class="table-data-td">${PF02ZH.PF02ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">强制执行记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>强制执行记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">执行法院</td>
                <td class="datatd">${map.PCE.PF03AQ01!}</td>
                <td class="labeltd">执行案由</td>
                <td class="datatd">${map.PCE.PF03AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">立案日期</td>
                <td class="datatd">${map.PCE.PF03AR01!}</td>
                <td class="labeltd">结案方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6050",map.PCE.PF03AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">案件状态</td>
                <td class="datatd">${map.PCE.PF03AQ03!}</td>
                <td class="labeltd">结案日期</td>
                <td class="datatd">${map.PCE.PF03AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">申请执行标的</td>
                <td class="datatd">${map.PCE.PF03AQ04!}</td>
                <td class="labeltd">申请执行标的金额</td>
                <td class="datatd-number">
                    <#if map.PCE.PF03AJ01??>
                        ${map.PCE.PF03AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">已执行标的</td>
                <td class="datatd">${map.PCE.PF03AQ05!}</td>
                <td class="labeltd">已执行标的金额</td>
                <td class="datatd-number">
                    <#if map.PCE.PF03AJ02??>
                        ${map.PCE.PF03AJ02?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PCE.PF03ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF03ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF03ZH! as PF03ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF03ZH.PF03ZD01)!}</td>
                            <td class="table-data-td">${PF03ZH.PF03ZQ01!}</td>
                            <td class="table-data-td">${PF03ZH.PF03ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">行政处罚记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>行政处罚记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">处罚机构</td>
                <td class="datatd">${map.PAP.PF04AQ01!}</td>
                <td class="labeltd">处罚内容</td>
                <td class="datatd">${map.PAP.PF04AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚金额</td>
                <td class="datatd-number">
                    <#if map.PAP.PF04AJ01??>
                        ${map.PAP.PF04AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
                <td class="labeltd">处罚生效日期</td>
                <td class="datatd">${map.PAP.PF04AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚截止日期</td>
                <td class="datatd">${map.PAP.PF04AR02!}</td>
                <td class="labeltd">行政复议结果</td>
                <td class="datatd">${map.PAP.PF04AQ03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PAP.PF04ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF04ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF04ZH! as PF04ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF04ZH.PF04ZD01)!}</td>
                            <td class="table-data-td">${PF04ZH.PF04ZQ01!}</td>
                            <td class="table-data-td">${PF04ZH.PF04ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">住房公积金参缴记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>住房公积金参缴记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">参缴地</td>
                <td class="datatd">${map.PHF.PF05AQ01!}</td>
                <td class="labeltd">参缴日期</td>
                <td class="datatd">${map.PHF.PF05AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">缴费状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6051",map.PHF.PF05AD01)!}</td>
                <td class="labeltd">初缴月份</td>
                <td class="datatd">${map.PHF.PF05AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">缴至月份</td>
                <td class="datatd">${map.PHF.PF05AR03!}</td>
                <td class="labeltd">单位缴存比例</td>
                <td class="datatd">${map.PHF.PF05AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">个人缴存比例</td>
                <td class="datatd">${map.PHF.PF05AQ03!}</td>
                <td class="labeltd">月缴存额</td>
                <td class="datatd-number">
                    <#if map.PHF.PF05AJ01??>
                        ${map.PHF.PF05AJ01?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">缴费单位</td>
                <td class="datatd">${map.PHF.PF05AQ04!}</td>
                <td class="labeltd">信息更新日期</td>
                <td class="datatd">${map.PHF.PF05AR04!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PHF.PF05ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF05ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF05ZH! as PF05ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF05ZH.PF05ZD01)!}</td>
                            <td class="table-data-td">${PF05ZH.PF05ZQ01!}</td>
                            <td class="table-data-td">${PF05ZH.PF05ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">低保救助记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>低保救助记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">人员类别</td>
                <td class="datatd">${DataDicUtil.getDataDic("6052",map.PBS.PF06AD01)!}</td>
                <td class="labeltd">所在地</td>
                <td class="datatd">${map.PBS.PF06AQ01!}</td>
            </tr>
            <tr>
                <td class="labeltd">工作单位</td>
                <td class="datatd">${map.PBS.PF06AQ02!}</td>
                <td class="labeltd">家庭月收入</td>
                <td class="datatd-number">
                    <#if map.PBS.PF06AQ03??>
                        ${map.PBS.PF06AQ03?string(',###')!}
                    <#else >

                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">申请日期</td>
                <td class="datatd">${map.PBS.PF06AR01!}</td>
                <td class="labeltd">批准日期</td>
                <td class="datatd">${map.PBS.PF06AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">信息更新日期</td>
                <td class="datatd">${map.PBS.PF06AR03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PBS.PF06ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF06ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF06ZH! as PF06ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF06ZH.PF06ZD01)!}</td>
                            <td class="table-data-td">${PF06ZH.PF06ZQ01!}</td>
                            <td class="table-data-td">${PF06ZH.PF06ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">执业资格记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>执业资格记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">执业资格名称</td>
                <td class="datatd">${map.PPQ.PF07AQ01!}</td>
                <td class="labeltd">颁发机构</td>
                <td class="datatd">${map.PPQ.PF07AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">等级</td>
                <td class="datatd">${DataDicUtil.getDataDic("6053",map.PPQ.PF07AD01)!}</td>
                <td class="labeltd">机构所在地</td>
                <td class="datatd">${map.PPQ.PF07AD02!}</td>
            </tr>
            <tr>
                <td class="labeltd">获得年月</td>
                <td class="datatd">${map.PPQ.PF07AR01!}</td>
                <td class="labeltd">到期年月</td>
                <td class="datatd">${map.PPQ.PF07AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">吊销年月</td>
                <td class="datatd">${map.PPQ.PF07AR03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF07ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF07ZH! as PF07ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PF07ZH.PF07ZD01)!}</td>
                            <td class="table-data-td">${PF07ZH.PF07ZQ01!}</td>
                            <td class="table-data-td">${PF07ZH.PF07ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">行政奖励记录</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>行政奖励记录信息段</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">奖励机构</td>
                <td class="datatd">${map.PAH.PF08AQ01!}</td>
                <td class="labeltd">奖励内容</td>
                <td class="datatd">${map.PAH.PF08AQ02!}</td>
            </tr>
            <tr>
                <td class="labeltd">生效年月</td>
                <td class="datatd">${map.PAH.PF08AR01!}</td>
                <td class="labeltd">截止年月</td>
                <td class="datatd">${map.PAH.PF08AR02!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>标注及声明信息段</li>
                </td>
            </tr>
        <#--<tr>-->
        <#--<td class="labeltd">标注及声明个数</td>-->
        <#--<td class="datatd">${map.PAH.PF08ZS01!}</td>-->
        <#--</tr>-->
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PF08ZH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PF08ZH! as PF08ZH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6120",PF08ZH.PF08ZD01)!}</td>
                            <td class="table-data-td">${PF08ZH.PF08ZQ01!}</td>
                            <td class="table-data-td">${PF08ZH.PF08ZR01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">其他标注及声明信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">对象类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6054",map.POS.PG010D01)!}</td>
                <td class="labeltd">对象标识</td>
                <td class="datatd">${DataDicUtil.getDataDic("6055",map.POS.PG010D02)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">标注及声明信息列表(总计${map.PG010H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:33%;">标注及声明类型</td>
                            <td class="table-label-td" style="width:33%;">标注或声明内容</td>
                            <td class="table-label-td" style="width:33%;">添加日期</td>
                        </tr>
                        <#list map.PG010H! as PG010H>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6039",PG010H.PG010D03)!}</td>
                            <td class="table-data-td">${PG010H.PG010Q01!}</td>
                            <td class="table-data-td">${PG010H.PG010R01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">查询记录</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">查询日期</td>
                <td class="datatd">${map.POQ.PH010R01!}</td>
                <td class="labeltd">查询机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6018",map.POQ.PH010D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">查询机构</td>
                <td class="datatd">${map.POQ.PH010Q02!}</td>
                <td class="labeltd">查询原因</td>
                <td class="datatd">${DataDicUtil.getDataDic("6004",map.POQ.PH010Q03)!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>
    <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/>
</div>
</body>

</html>