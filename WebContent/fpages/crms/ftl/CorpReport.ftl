<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<html>
<head>
    <title>企业信用报告</title>
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
    <h2>企业信用报告</h2>
    <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/>
    <fieldset>
        <legend align="center">报告头</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">报告编号</td>
                <td class="datatd">${map.EAA.EA01AI01!}</td>
                <td class="labeltd">报告时间</td>
                <td class="datatd">${map.EAA.EA01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">企业身份标识个数</td>
                <td class="datatd" >${map.EAA.EA01CS01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="2" class="table-head-td">企业身份标识列表(总计${map.EA01CH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">被查询者企业身份标识类型</td>
                            <td class="table-label-td" style="width:50%;">被查询者企业身份标识号码</td>
                        </tr>
                        <#list map.EA01CH! as EA01CH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6065",EA01CH.EA01CD01)!}</td>
                            <td class="table-data-td">${EA01CH.EA01CI01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
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
    </fieldset>
    <fieldset>
        <legend align="center">信用提示信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>信贷交易提示信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">首次有信贷交易的年份</td>
                <td class="datatd">${map.EBA.EB01AR01!}</td>
                <td class="labeltd">首次有相关还款责任的年份</td>
                <td class="datatd">${map.EBA.EB01AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">发生信贷交易的机构数</td>
                <td class="datatd">${map.EBA.EB01AS01!}</td>
                <td class="labeltd">当前有未结清信贷交易的机构数</td>
                <td class="datatd">${map.EBA.EB01AS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">借贷交易余额</td>
                <td class="datatd-number">
                 <#if map.EBA.EB01AJ01??>
                    ${ map.EBA.EB01AJ01?string(',###')}
                <#else >
                </#if>
               </td>
                <td class="labeltd">被追偿的借贷交易余额</td>
                <td class="datatd-number">
                     <#if map.EBA.EB01AJ02??>
                         ${ map.EBA.EB01AJ02?string(',###')}
                     <#else >
                     </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">关注类借贷交易余额</td>
                <td class="datatd-number">
                  <#if map.EBA.EB01AJ03??>
                      ${ map.EBA.EB01AJ03?string(',###')}
                  <#else >
                  </#if>
                 </td>
                <td class="labeltd">不良类借贷交易余额</td>
                <td class="datatd-number">
                    <#if map.EBA.EB01AJ04??>
                        ${ map.EBA.EB01AJ04?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">担保交易余额</td>
                <td class="datatd-number" >
                     <#if map.EBA.EB01AJ05??>
                         ${ map.EBA.EB01AJ05?string(',###')}
                     <#else >
                     </#if>
                </td>
                <td class="labeltd">关注类担保交易余额</td>
                <td class="datatd-number" >
                      <#if map.EBA.EB01AJ06??>
                          ${ map.EBA.EB01AJ06?string(',###')}
                      <#else >
                      </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">不良类担保交易余额</td>
                <td class="datatd-number">
                    <#if map.EBA.EB01AJ07??>
                        ${ map.EBA.EB01AJ07?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>非信贷交易提示信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">非信贷交易账户数</td>
                <td class="datatd">${map.EBA.EB01BS01!}</td>
                <td class="labeltd">欠税记录条数</td>
                <td class="datatd">${map.EBA.EB01BS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">民事判决记录条数</td>
                <td class="datatd">${map.EBA.EB01BS03!}</td>
                <td class="labeltd">强制执行记录条数</td>
                <td class="datatd">${map.EBA.EB01BS04!}</td>
            </tr>
            <tr>
                <td class="labeltd">行政处罚记录条数</td>
                <td class="datatd">${map.EBA.EB01BS05!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">借贷交易汇总信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>未结清借贷交易汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资产处置业务账户数</td>
                <td class="datatd">${map.EBB.EB02AS01!}</td>
                <td class="labeltd">资产处置业务余额</td>
                <td class="datatd-number">
                     <#if map.EBB.EB02AJ01??>
                         ${ map.EBB.EB02AJ01?string(',###')}
                     <#else >
                     </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">最近一次处置日期</td>
                <td class="datatd">${map.EBB.EB02AR01!}</td>
                <td class="labeltd">垫款业务账户数</td>
                <td class="datatd">${map.EBB.EB02AS02!}</td>
            </tr>
            <tr>
                <td class="labeltd">垫款业务余额</td>
                <td class="datatd-number">
                      <#if map.EBB.EB02AJ02??>
                          ${ map.EBB.EB02AJ02?string(',###')}
                      <#else >
                      </#if>
                </td>
                <td class="labeltd">垫款最近一次还款日期</td>
                <td class="datatd">${map.EBB.EB02AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">逾期总额</td>
                <td class="datatd-number">
                  <#if map.EBB.EB02AJ03??>
                      ${ map.EBB.EB02AJ03?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">逾期本金</td>
                <td class="datatd-number">
                    <#if map.EBB.EB02AJ04??>
                        ${ map.EBB.EB02AJ04?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">逾期利息及其他</td>
                <td class="datatd-number">
                       <#if map.EBB.EB02AJ05??>
                           ${ map.EBB.EB02AJ05?string(',###')}
                       <#else >
                       </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他借贷交易分类汇总条目数量</td>
                <td class="datatd">${map.EBB.EB02AS03!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">其他借贷交易分类汇总列表(总计${map.EB02AH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">业务类型</td>
                            <td class="table-label-td" style="width:50%;">资产质量分类</td>
                            <td class="table-label-td" style="width:50%;">账户数</td>
                            <td class="table-label-td" style="width:50%;">余额</td>
                        </tr>
                        <#list map.EB02AH! as EB02AH>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6076", EB02AH.EB02AD01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6078", EB02AH.EB02AD02)!}</td>
                            <td class="table-data-td">${EB02AH.EB02AS04!}</td>
                            <td class="table-data-td">
                               <#if EB02AH.EB02AJ06??>
                                   ${EB02AH.EB02AJ06?string(',###')}
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
                    <li>已结清借贷交易汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资产处置业务账户数</td>
                <td class="datatd">${map.EBB.EB02BS01!}</td>
                <td class="labeltd">资产处置业务金额</td>
                <td class="datatd-number">
                  <#if map.EBB.EB02BJ01??>
                      ${map.EBB.EB02BJ01?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">处置完成日期</td>
                <td class="datatd">${map.EBB.EB02BR01!}</td>
                <td class="labeltd">结清日期</td>
                <td class="datatd">${map.EBB.EB02BR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">垫款业务账户数</td>
                <td class="datatd">${map.EBB.EB02BS02!}</td>
                <td class="labeltd">垫款业务金额</td>
                <td class="datatd-number">
                     <#if map.EBB.EB02BJ02??>
                         ${map.EBB.EB02BJ02?string(',###')}
                     <#else >
                     </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他借贷交易分类汇总条目数量</td>
                <td class="datatd">${map.EBB.EB02BS03!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="3" class="table-head-td">其他借贷交易分类汇总列表(总计${map.EB02BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="table-label-td" style="width:50%;">业务类型</td>
                            <td class="table-label-td" style="width:50%;">资产质量分类</td>
                            <td class="table-label-td" style="width:50%;">账户数</td>
                        </tr>
                        <#list map.EB02BH! as EB02BH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6076",EB02BH.EB02BD01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6078",EB02BH.EB02BD02)!}</td>
                            <td class="table-data-td">${EB02BH.EB02BS04!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>负债历史汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">月份数</td>
                <td class="datatd">${map.EBB.EB02CS01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="11" class="table-head-td">负债历史汇总信息列表(总计${map.EB02CH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">月份</td>
                            <td class="labeltd">全部负债账户数</td>
                            <td class="labeltd">全部负债余额</td>
                            <td class="labeltd">关注类负债账户数</td>
                            <td class="labeltd">关注类负债余额</td>
                            <td class="labeltd">不良类负债账户数</td>
                            <td class="labeltd">不良类负债余额</td>
                            <td class="labeltd">逾期账户数</td>
                            <td class="labeltd">逾期总额</td>
                            <td class="labeltd">逾期本金账户数</td>
                            <td class="labeltd">逾期本金</td>
                        </tr>
                        <#list map.EB02CH! as EB02CH>
                        <tr>
                            <td class="table-data-td">${EB02CH.EB02CR01!}</td>
                            <td class="table-data-td">${EB02CH.EB02CS02!}</td>
                            <td class="table-data-td">
                               <#if EB02CH.EB02CJ01??>
                                   ${EB02CH.EB02CJ01?string(',###')}
                               <#else >
                               </#if>
                            </td>
                            <td class="table-data-td">${EB02CH.EB02CS03!}</td>
                            <td class="table-data-td">
                              <#if EB02CH.EB02CJ02??>
                                  ${EB02CH.EB02CJ02?string(',###')}
                              <#else >
                              </#if>
                            </td>
                            <td class="table-data-td">${EB02CH.EB02CS04!}</td>
                            <td class="table-data-td">
                                  <#if EB02CH.EB02CJ03??>
                                      ${EB02CH.EB02CJ03?string(',###')}
                                  <#else >
                                  </#if>
                            </td>
                            <td class="table-data-td">${EB02CH.EB02CS05!}</td>
                            <td class="table-data-td">
                              <#if EB02CH.EB02CJ04??>
                                  ${EB02CH.EB02CJ04?string(',###')}
                              <#else >
                              </#if>
                             </td>
                            <td class="table-data-td">${EB02CH.EB02CS06!}</td>
                            <td class="table-data-td">${EB02CH.EB02CJ05!}
                                <#if EB02CH.EB02CJ05??>
                                    ${EB02CH.EB02CJ05?string(',###')}
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
        <legend align="center">担保交易汇总信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>未结清担保交易汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">担保交易分类汇总条目数量</td>
                <td class="datatd">${map.EBC.EB03AS01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">未结清担保交易汇总信息列表(总计${map.EB03AH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">业务类型</td>
                            <td class="labeltd">资产质量分类</td>
                            <td class="labeltd">账户数</td>
                            <td class="labeltd">余额</td>
                        </tr>
                        <#list map.EB03AH! as EB03AH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6077", EB03AH.EB03AD01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6078", EB03AH.EB03AD02)!}</td>
                            <td class="table-data-td">${EB03AH.EB03AS02!}</td>
                            <td class="table-data-td">
                                 <#if EB03AH.EB03AJ01??>
                                     ${EB03AH.EB03AJ01?string(',###')}
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
                    <li>已结清担保交易汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">担保交易分类汇总条目数量</td>
                <td class="datatd">${map.EBC.EB03BS01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="3" class="table-head-td">已结清担保交易汇总信息列表(总计${map.EB03BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">业务类型</td>
                            <td class="labeltd">资产质量分类</td>
                            <td class="labeltd">账户数</td>
                        </tr>
                        <#list map.EB03BH! as EB03BH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6077", EB03BH.EB03BD01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6078", EB03BH.EB03BD02)!}</td>
                            <td class="table-data-td">${EB03BH.EB03BS02!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">授信协议汇总信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">非循环信用额度合计</td>
                <td class="datatd-number">
                  <#if map.EBD.EB040J01??>
                      ${map.EBD.EB040J01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">已使用的非循环信用额度合计</td>
                <td class="datatd-number">
                  <#if map.EBD.EB040J02??>
                      ${map.EBD.EB040J02?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">剩余可用的非循环额度合计</td>
                <td class="datatd-number">
                      <#if map.EBD.EB040J03??>
                          ${map.EBD.EB040J03?string(',###')}
                      <#else >
                      </#if>
                </td>
                <td class="labeltd">循环信用额度合计</td>
                <td class="datatd-number">
                      <#if map.EBD.EB040J04??>
                          ${map.EBD.EB040J04?string(',###')}
                      <#else >
                      </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd">已使用的循环信用额度合计</td>
                <td class="datatd-number">
                      <#if map.EBD.EB040J05??>
                          ${map.EBD.EB040J05?string(',###')}
                      <#else >
                      </#if>
                 </td>
                <td class="labeltd">剩余可用的循环额度合计</td>
                <td class="datatd-number">
                    <#if map.EBD.EB040J06??>
                        ${map.EBD.EB040J06?string(',###')}
                    <#else >
                    </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd">是否包含授信限额</td>
                <td class="datatd-number">${map.EBD.EB040D01!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">相关还款责任汇总信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>借贷交易相关还款责任汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">还款责任类型数量</td>
                <td class="datatd">${map.EBE.EB05AS01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="9" class="table-head-td">借贷交易相关还款责任汇总信息列表(总计${map.EB05AH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">责任类型</td>
                            <td class="labeltd">被追偿账户的还款责任金额</td>
                            <td class="labeltd">被追偿账户数</td>
                            <td class="labeltd">被追偿账户余额</td>
                            <td class="labeltd">其他借贷交易的还款责任金额</td>
                            <td class="labeltd">其他借贷交易账户数</td>
                            <td class="labeltd">其他借贷交易账户余额</td>
                            <td class="labeltd">其他借贷交易账户关注类余额</td>
                            <td class="labeltd">其他借贷交易账户不良类余额</td>
                        </tr>
                        <#list map.EB05AH! as EB05AH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6080", EB05AH.EB05AD01)!}</td>
                            <td class="table-data-td">
                               <#if EB05AH.EB05AJ01??>
                                   ${EB05AH.EB05AJ01?string(',###')}
                               <#else >
                               </#if>
                            </td>
                            <td class="table-data-td">${EB05AH.EB05AS02!}</td>
                            <td class="table-data-td">
                                  <#if EB05AH.EB05AJ02??>
                                      ${EB05AH.EB05AJ02?string(',###')}
                                  <#else >
                                  </#if>
                            </td>
                            <td class="table-data-td">${EB05AH.EB05AJ02!}
                                 <#if EB05AH.EB05AJ02??>
                                     ${EB05AH.EB05AJ02?string(',###')}
                                 <#else >
                                 </#if>
                            </td>
                            <td class="table-data-td">${EB05AH.EB05AS03!}</td>
                            <td class="table-data-td">
                                <#if EB05AH.EB05AJ04??>
                                    ${EB05AH.EB05AJ04?string(',###')}
                                <#else >
                                </#if>
                             </td>
                            <td class="table-data-td">${EB05AH.EB05AJ05!}
                                 <#if EB05AH.EB05AJ05??>
                                     ${EB05AH.EB05AJ05?string(',###')}
                                 <#else >
                                 </#if>
                            </td>
                            <td class="table-data-td">
                              <#if EB05AH.EB05AJ06??>
                                  ${EB05AH.EB05AJ06?string(',###')}
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
                    <li>担保交易相关还款责任汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">还款责任类型数量</td>
                <td class="datatd">${map.EBE.EB05BS01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="6" class="table-head-td">担保交易相关还款责任汇总信息列表(总计${map.EB05BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">责任类型</td>
                            <td class="labeltd">还款责任金额</td>
                            <td class="labeltd">账户数</td>
                            <td class="labeltd">余额</td>
                            <td class="labeltd">关注类余额</td>
                            <td class="labeltd">不良类余额</td>
                        </tr>
                        <#list map.EB05BH! as EB05BH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6080", EB05BH.EB05BD01)!}</td>
                            <td class="table-data-td">
                               <#if EB05BH.EB05BJ01??>
                                   ${EB05BH.EB05BJ01?string(',###')}
                               <#else >
                               </#if>
                            </td>
                            <td class="table-data-td">${EB05BH.EB05BS02!}</td>
                            <td class="table-data-td">
                                 <#if EB05BH.EB05BJ02??>
                                     ${EB05BH.EB05BJ02?string(',###')}
                                 <#else >
                                 </#if>
                            </td>
                            <td class="table-data-td">
                                 <#if EB05BH.EB05BJ03??>
                                     ${EB05BH.EB05BJ03?string(',###')}
                                 <#else >
                                 </#if>
                            </td>
                            <td class="table-data-td">
                                  <#if EB05BH.EB05BJ04??>
                                      ${EB05BH.EB05BJ04?string(',###')}
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
        <legend align="center">基本信息</legend>
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
                <td class="labeltd">登记地址</td>
                <td class="datatd">${map.ECA.EC010Q01!}</td>
                <td class="labeltd">成立年份</td>
                <td class="datatd">${map.ECA.EC010R01!}</td>
            </tr>

            <tr>
                <td class="labeltd">登记证书有效截止日期</td>
                <td class="datatd">${map.ECA.EC010R02!}</td>
                <td class="labeltd">办公/经营地址</td>
                <td class="datatd">${map.ECA.EC010Q02!}</td>
            </tr>
            <tr>
                <td class="labeltd">存续状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6068", map.ECA.EC010D05)!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>注册资本及主要出资人信息单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd">注册资本（折人民币合计）</td>
                <td class="datatd-number">${map.ECA.EC020J01!}
                   <#if map.ECA.EC020J01??>
                       ${map.ECA.EC020J01?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">主要出资人个数</td>
                <td class="datatd">${map.ECA.EC020S01!}</td>
            </tr>

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="6" class="table-head-td">出资人信息列表(总计${map.EC020H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">出资人类型</td>
                            <td class="labeltd">出资人身份类别</td>
                            <td class="labeltd">出资人名称</td>
                            <td class="labeltd">出资人身份标识类型</td>
                            <td class="labeltd">出资人身份标识号码</td>
                            <td class="labeltd">出资比例</td>
                        </tr>
                        <#list map.EC020H! as EC020H>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6069", EC020H.EC020D01)!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6001", EC020H.EC020D02)!}</td>
                            <td class="table-data-td">${EC020H.EC020Q01!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6065", EC020H.EC020Q01)!}</td>
                            <td class="table-data-td">${EC020H.EC020I01!}</td>
                            <td class="table-data-td">${EC020H.EC020Q02!}%</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>主要组成人员信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">主要组成人员个数</td>
                <td class="datatd">${map.ECA.EC030S01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">主要组成人员信息列表(总计${map.EC030H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">姓名</td>
                            <td class="labeltd">证件类型</td>
                            <td class="labeltd">证件号码</td>
                            <td class="labeltd">职位</td>
                        </tr>
                        <#list map.EC030H! as EC030H>
                        <tr>
                            <td class="table-data-td">${EC030H.EC030Q01!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6002", EC030H.EC030D01)!}</td>
                            <td class="table-data-td">${EC030H.EC030I01!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6070", EC030H.EC030D02)!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>上级机构信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">上级机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6071", map.ECA.EC040D01)!}</td>
                <td class="labeltd">上级机构名称</td>
                <td class="datatd">${map.ECA.EC040Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">上级机构身份标识类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6071", map.ECA.EC040D02)!}</td>
                <td class="labeltd">上级机构身份标识号码</td>
                <td class="datatd">${map.ECA.EC040I01!}</td>
            </tr>

            <tr>
                <td class="labeltd">更新日期</td>
                <td class="datatd">${map.ECA.EC040R01!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>实际控制人信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">实际控制人个数</td>
                <td class="datatd">${map.ECA.EC050S01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">实际控制人信息列表(总计${map.EC050H?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">实际控制人身份类型</td>
                            <td class="labeltd">实际控制人名称</td>
                            <td class="labeltd">实际控制人身份标识类型</td>
                            <td class="labeltd">实际控制人身份标识号码</td>
                        </tr>
                        <#list map.EC050H! as EC050H>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("8030", EC050H.EC050D01)!}</td>
                            <td class="table-data-td">${EC050H.EC050Q01!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6025", EC050H.EC050D02)!}</td>
                            <td class="table-data-td">${EC050H.EC050I01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>
            <tr>
                <td class="labeltd">更新日期</td>
                <td class="datatd">${map.ECA.EC050R01!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">借贷账户信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>基本信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">借贷账户编号</td>
                <td class="datatd">${map.EDA.ED01AI01!}</td>
                <td class="labeltd">账户活动状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6072", map.EDA.ED01AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">借贷账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6073", map.EDA.ED01AD02)!}</td>
                <td class="labeltd">借款期限</td>
                <td class="datatd">${map.EDA.ED01AD03!}</td>
            </tr>

            <tr>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EDA.ED01AD04)!}</td>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EDA.ED01AI02!}</td>
            </tr>

            <tr>
                <td class="labeltd">授信协议编号</td>
                <td class="datatd">${map.EDA.ED01AI03!}</td>
                <td class="labeltd">借贷业务种类大类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6083", map.EDA.ED01AD05)!}</td>
            </tr>

            <tr>
                <td class="labeltd">借贷业务种类细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6086",map.EDA.ED01AD06)!}</td>
                <td class="labeltd">开户日期</td>
                <td class="datatd">${map.EDA.ED01AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("6058",map.EDA.ED01AD07)!}</td>
                <td class="labeltd">借款金额</td>
                <td class="datatd-number">
                 <#if map.EDA.ED01AJ01??>
                     ${map.EDA.ED01AJ01?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信用额度</td>
                <td class="datatd-number">
                    <#if map.EDA.ED01AJ02??>
                        ${map.EDA.ED01AJ02?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.EDA.ED01AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">担保方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6096",map.EDA.ED01AD08)!}</td>
                <td class="labeltd">其他还款保证方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6097",map.EDA.ED01AD09)!}</td>
            </tr>
            <tr>
                <td class="labeltd">发放形式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6099",map.EDA.ED01AD10)!}</td>
                <td class="labeltd">共同借款标识</td>
                <td class="datatd">${DataDicUtil.getDataDic("6100",map.EDA.ED01AD11)!}</td>
            </tr>
            <tr>
                <td class="labeltd">关闭日期</td>
                <td class="datatd">${map.EDA.ED01AR03!}</td>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.EDA.ED01AR04!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>还款表现信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">还款表现记录条数</td>
                <td class="datatd">${map.EDA.ED01BS01!}</td>
            </tr>

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="14" class="table-head-td">还款表现信息(总计${map.ED01BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">信息报告日期</td>
                            <td class="labeltd">余额</td>
                            <td class="labeltd">余额变化日期</td>
                            <td class="labeltd">五级分类</td>
                            <td class="labeltd">五级分类认定日期</td>
                            <td class="labeltd">最近一次实际还款日期</td>
                            <td class="labeltd">最近一次实际还款总额</td>
                            <td class="labeltd">最近一次还款形式</td>
                            <td class="labeltd">最近一次约定还款日期</td>
                            <td class="labeltd">最近一次应还总额</td>
                            <td class="labeltd">逾期总额</td>
                            <td class="labeltd">逾期本金</td>
                            <td class="labeltd">逾期月数</td>
                            <td class="labeltd">剩余还款月数</td>
                        </tr>
                        <#list map.ED01BH! as ED01BH>
                        <tr>
                            <td class="table-data-td">${ED01BH.ED01BR01!}</td>
                            <td class="table-data-td">
                               <#if ED01BH.ED01BJ01??>
                                   ${ED01BH.ED01BJ01?string(',###')}
                               <#else >
                               </#if>
                            </td>
                            <td class="table-data-td">${ED01BH.ED01BR02!}</td>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6032", ED01BH.ED01BD01)!}</td>
                            <td class="table-data-td">${ED01BH.ED01BR03!}</td>
                            <td class="table-data-td">${ED01BH.ED01BR04!}</td>
                            <td class="table-data-td">
                              <#if ED01BH.ED01BJ02??>
                                  ${ED01BH.ED01BJ02?string(',###')}
                              <#else >
                              </#if>
                            </td>
                            <td class="table-data-td">${ED01BH.ED01BD02!}</td>
                            <td class="table-data-td">${ED01BH.ED01BR05!}</td>
                            <td class="table-data-td">
                                 <#if ED01BH.ED01BJ03??>
                                     ${ED01BH.ED01BJ03?string(',###')}
                                 <#else >
                                 </#if>
                            </td>
                            <td class="table-data-td">
                               <#if ED01BH.ED01BJ04??>
                                   ${ED01BH.ED01BJ04?string(',###')}
                               <#else >
                               </#if>
                            </td>
                            <td class="table-data-td">
                               <#if ED01BH.ED01BJ05??>
                                   ${ED01BH.ED01BJ05?string(',###')}
                               <#else >
                               </#if>
                            </td>
                            <td class="table-data-td">${ED01BH.ED01BS02!}</td>
                            <td class="table-data-td">${ED01BH.ED01BS03!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>特定交易信息单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd">特定交易个数</td>
                <td class="datatd">${map.EDA.ED01CS01!}</td>
            </tr>

            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="5" class="table-head-td">特定交易信息(总计${map.ED01CH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">交易类型</td>
                            <td class="labeltd">交易日期</td>
                            <td class="labeltd">交易金额</td>
                            <td class="labeltd">到期日期变更月数</td>
                            <td class="labeltd">交易明细信息</td>
                        </tr>
                        <#list map.ED01CH! as ED01CH>
                        <tr>
                            <td class="table-data-td">${DataDicUtil.getDataDic("6102", ED01CH.ED01CD01)!}</td>
                            <td class="table-data-td">${ED01CH.ED01CR01!}</td>
                            <td class="table-data-td">
                              <#if ED01CH.ED01CJ01??>
                                  ${ED01CH.ED01CJ01?string(',###')}
                              <#else >
                              </#if>
                            </td>
                            <td class="table-data-td">${ED01CH.ED01CS02!}</td>
                            <td class="table-data-td">${ED01CH.ED01CQ01!}</td>
                        </tr>
                        </#list>
                    </table>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>贴现账户分机构汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">贴现账户分机构汇总信息编号</td>
                <td class="datatd">${map.EDA.ED020I01!}</td>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EDA.ED020D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务种类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6091", map.EDA.ED020D02)!}</td>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032", map.EDA.ED020D03)!}</td>
            </tr>
            <tr>
                <td class="labeltd">未结清账户数</td>
                <td class="datatd">${map.EDA.ED020S01!}</td>
                <td class="labeltd">余额合计</td>
                <td class="datatd-number">
                     <#if map.EDA.ED020J01??>
                         ${map.EDA.ED020J01?string(',###')}
                     <#else >
                     </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">逾期总额合计</td>
                <td class="datatd-number">
                      <#if map.EDA.ED020J02??>
                          ${map.EDA.ED020J02?string(',###')}
                      <#else >
                      </#if>
                 </td>
                <td class="labeltd">逾期本金合计</td>
                <td class="datatd-number">
                  <#if map.EDA.ED020J03??>
                      ${map.EDA.ED020J03?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">已结清账户数</td>
                <td class="datatd">${map.EDA.ED020S02!}</td>
                <td class="labeltd">已结清账户贴现金额合计</td>
                <td class="datatd-number">
                     <#if map.EDA.ED020J04??>
                         ${map.EDA.ED020J04?string(',###')}
                     <#else >
                     </#if>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>欠息信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">欠息信息编号</td>
                <td class="datatd">${map.EDA.ED030I01!}</td>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EDA.ED030D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EDA.ED030I02!}</td>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("6058", map.EDA.ED030D02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">欠息余额</td>
                <td class="datatd-number">
                     <#if map.EDA.ED030J01??>
                         ${map.EDA.ED030J01?string(',###')}
                     <#else >
                     </#if>
                </td>
                <td class="labeltd">余额变化日期</td>
                <td class="datatd">${map.EDA.ED030R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">欠息类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6103",map.EDA.ED030R01)!}</td>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.EDA.ED030R02!}</td>
            </tr>
        </table>
    </fieldset>


    <fieldset>
        <legend align="center">担保账户信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>担保账户信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">担保账户编号</td>
                <td class="datatd">${map.EDB.ED04AI01!}</td>
                <td class="labeltd">担保账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6103",map.EDB.ED04AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.EDB.ED04AD02)!}</td>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EDB.ED04AI02!}</td>
            </tr>

            <tr>
                <td class="labeltd">授信协议编号</td>
                <td class="datatd">${map.EDB.ED04AI03!}</td>
                <td class="labeltd">担保交易业务种类细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6095",map.EDB.ED04AD03)!}</td>
            </tr>

            <tr>
                <td class="labeltd">开立日期</td>
                <td class="datatd">${map.EDB.ED04AR01!}</td>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("6058",map.EDB.ED04AD04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">金额</td>
                <td class="datatd-number">
                  <#if map.EDB.ED04AJ01??>
                      ${map.EDB.ED04AJ01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.EDB.ED04AR02!}</td>
            </tr>
            <tr>
                <td class="labeltd">反担保方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6096",map.EDB.ED04AD05)!}</td>
                <td class="labeltd">其他还款保证方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6097",map.EDB.ED04AD06)!}</td>
            </tr>
            <tr>
                <td class="labeltd">保证金比例</td>
                <td class="datatd">${map.EDB.ED04AQ01!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>在保责任信息单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.EDB.ED04BR01!}</td>
                <td class="labeltd">账户活动状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6072",map.EDB.ED04BD01)!}</td>
            </tr>

            <tr>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                       <#if map.EDB.ED04BJ01??>
                           ${map.EDB.ED04BJ01?string(',###')}
                       <#else >
                       </#if>
                </td>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.EDB.ED04BD02)!}</td>
            </tr>

            <tr>
                <td class="labeltd">风险敞口</td>
                <td class="datatd-number">
                   <#if map.EDB.ED04BJ02??>
                       ${map.EDB.ED04BJ02?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">代偿（垫款）标志</td>
                <td class="datatd">${DataDicUtil.getDataDic("6075",map.EDB.ED04BD03)!}</td>
            </tr>

            <tr>
                <td class="labeltd">共同债务标识</td>
                <td class="datatd">${DataDicUtil.getDataDic("6100",map.EDB.ED04BD04)!}</td>
                <td class="labeltd">关闭日期</td>
                <td class="datatd">${map.EDB.ED04BR02!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>担保账户分机构汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">担保账户分机构汇总信息编号</td>
                <td class="datatd">${map.EDB.ED050I01!}</td>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.EDB.ED050D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EDB.ED050I02!}</td>
                <td class="labeltd">担保交易业务种类细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6095",map.EDB.ED050D02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.EDB.ED050D03)!}</td>
                <td class="labeltd">未结清账户数</td>
                <td class="datatd">${map.EDB.ED050S01!}</td>
            </tr>
            <tr>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                   <#if map.EDB.ED050J01??>
                       ${map.EDB.ED050J01?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">30天内到期的余额</td>
                <td class="datatd-number">
                    <#if map.EDB.ED050J02??>
                        ${map.EDB.ED050J02?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">60天内到期的余额</td>
                <td class="datatd-number">
                    <#if map.EDB.ED050J03??>
                        ${map.EDB.ED050J03?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">90天内到期的余额</td>
                <td class="datatd-number">
                  <#if map.EDB.ED050J04??>
                      ${map.EDB.ED050J04?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">90天后到期的余额</td>
                <td class="datatd-number">
                   <#if map.EDB.ED050J05??>
                       ${map.EDB.ED050J05?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">已结清账户数</td>
                <td class="datatd">${map.EDB.ED050S02!}</td>
            </tr>
            <tr>
                <td class="labeltd">垫款标志</td>
                <td class="datatd">${DataDicUtil.getDataDic("6075",map.EDB.ED050D04)!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>授信协议信息</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">授信协议编号</td>
                <td class="datatd">${map.EDC.ED060I01!}</td>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.EDC.ED060D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EDC.ED060I02!}</td>
                <td class="labeltd">授信额度类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6098",map.EDC.ED060D02)!}</td>
            </tr>
            <tr>
                <td class="labeltd">额度循环标志</td>
                <td class="datatd">${DataDicUtil.getDataDic("6104",map.EDC.ED060D03)!}</td>
                <td class="labeltd">币种</td>
                <td class="datatd">${DataDicUtil.getDataDic("6058",map.EDC.ED060D04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">授信额度</td>
                <td class="datatd-number">
                  <#if map.EDC.ED060J01??>
                      ${map.EDC.ED060J01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">已用额度</td>
                <td class="datatd-number">
                  <#if map.EDC.ED060J04??>
                      ${map.EDC.ED060J04?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">授信限额</td>
                <td class="datatd-number">
                   <#if map.EDC.ED060J03??>
                       ${map.EDC.ED060J03?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">授信限额编号</td>
                <td class="datatd">${map.EDC.ED060I03!}</td>
            </tr>
            <tr>
                <td class="labeltd">生效日期</td>
                <td class="datatd">${map.EDC.ED060R01!}</td>
                <td class="labeltd">终止日期</td>
                <td class="datatd">${map.EDC.ED060R02!}</td>
            </tr>
            <tr>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.EDC.ED060R03!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">相关还款责任信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>相关还款责任借贷账户（不含贴现）信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">账户编号</td>
                <td class="datatd">${map.EDD.ED070I01!}</td>
                <td class="labeltd">主借款人身份类别</td>
                <td class="datatd">${DataDicUtil.getDataDic("6001",map.EDD.ED070D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">账户类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6073",map.EDD.ED070D02)!}</td>
                <td class="labeltd">相关还款责任人类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6044",map.EDD.ED070D03)!}</td>
            </tr>

            <tr>
                <td class="labeltd">币种（相关还款责任金额）</td>
                <td class="datatd-number">${map.EDD.ED070D10!}</td>
                <td class="labeltd">相关还款责任金额</td>
                <td class="datatd-number">
                      <#if map.EDD.ED070J01??>
                          ${map.EDD.ED070J01?string(',###')}
                      <#else >
                      </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd"> ${DataDicUtil.getDataDic("6082",map.EDD.ED070D04)!}</td>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EDD.ED070I02!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务种类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6083",map.EDD.ED070D05)!}</td>
                <td class="labeltd">业务种类细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6085",map.EDD.ED070D06)!}</td>
            </tr>
            <tr>
                <td class="labeltd">开立日期</td>
                <td class="datatd">${map.EDD.ED070R01!}</td>
                <td class="labeltd">到期日期</td>
                <td class="datatd">${map.EDD.ED070R02!}</td>
            </tr>
            <tr>
                <td class="labeltd">币种</td>
                <td class="datatd">${map.EDD.ED070D07!}</td>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                  <#if map.EDD.ED070J02??>
                      ${map.EDD.ED070J02?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.EDD.ED070D08)!}</td>
                <td class="labeltd">逾期总额</td>
                <td class="datatd-number">
                     <#if map.EDD.ED070J03??>
                         ${map.EDD.ED070J03?string(',###')}
                     <#else >
                     </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">逾期本金</td>
                <td class="datatd-number">
                   <#if map.EDD.ED070J04??>
                       ${map.EDD.ED070J04?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">逾期月数</td>
                <td class="datatd">${map.EDD.ED070S01!}</td>
            </tr>
            <tr>
                <td class="labeltd">还款状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6026",map.EDD.ED070D09)!}</td>
                <td class="labeltd">剩余还款月数</td>
                <td class="datatd">${map.EDD.ED070S02!}</td>
            </tr>
            <tr>
                <td class="labeltd">信息报告日期</td>
                <td class="datatd">${map.EDD.ED070R03!}</td>
                <td class="labeltd">借款金</td>
                <td class="datatd-number">
                     <#if map.EDD.ED070J05??>
                         ${map.EDD.ED070J05?string(',###')}
                     <#else >
                     </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信用额</td>
                <td class="datatd-number">
                      <#if map.EDD.ED070J06??>
                          ${map.EDD.ED070J06?string(',###')}
                      <#else >
                      </#if>
                </td>
                <td class="labeltd">保证合同编号</td>
                <td class="datatd">${map.EDD.ED070I03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>相关还款责任贴现账户分机构汇总信息单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd">贴现账户分机构汇总信息编号</td>
                <td class="datatd">${map.EDD.ED080I01!}</td>
                <td class="labeltd">相关还款责任类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6080",map.EDD.ED080D01)!}</td>
            </tr>

            <tr>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.EDD.ED080D02)!}</td>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EDD.ED080I02!}</td>
            </tr>

            <tr>
                <td class="labeltd">业务种类细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6091",map.EDD.ED080D03)!}</td>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.EDD.ED080D04)!}</td>
            </tr>

            <tr>
                <td class="labeltd">相关还款责任金额</td>
                <td class="datatd-number">
                      <#if map.EDD.ED080J01??>
                          ${map.EDD.ED080J01?string(',###')}
                      <#else >
                      </#if>
                </td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.EDD.ED080S01!}</td>
            </tr>
            <tr>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                   <#if map.EDD.ED080J02??>
                       ${map.EDD.ED080J02?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">逾期总额</td>
                <td class="datatd-number">
                   <#if map.EDD.ED080J03??>
                       ${map.EDD.ED080J03?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">逾期本金</td>
                <td class="datatd-number">
                     <#if map.EDD.ED080J04??>
                         ${map.EDD.ED080J04?string(',###')}
                     <#else >
                     </#if>
                </td>
                <td class="labeltd">借款金额</td>
                <td class="datatd-number">
                  <#if map.EDD.ED080J05??>
                      ${map.EDD.ED080J05?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">保证合同编号</td>
                <td class="datatd">${map.EDD.ED080I03!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>相关还款责任担保账户分机构汇总信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">担保账户分机构汇总信息编号</td>
                <td class="datatd">${map.EDD.ED090I01!}</td>
                <td class="labeltd">相关还款责任类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6080",map.EDD.ED090D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082",map.EDD.ED090D02)!}</td>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EDD.ED090I02!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务种类细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6095",map.EDD.ED090D03)!}</td>
                <td class="labeltd">五级分类</td>
                <td class="datatd">${DataDicUtil.getDataDic("6032",map.EDD.ED090D04)!}</td>
            </tr>
            <tr>
                <td class="labeltd">相关还款责任金额</td>
                <td class="datatd-number">
                   <#if map.EDD.ED090J01??>
                       ${map.EDD.ED090J01?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">账户数</td>
                <td class="datatd">${map.EDD.ED090S01!}</td>
            </tr>
            <tr>
                <td class="labeltd">余额</td>
                <td class="datatd-number">
                     <#if map.EDD.ED090J02??>
                         ${map.EDD.ED090J02?string(',###')}
                     <#else >
                     </#if>
                </td>
                <td class="labeltd">担保金额</td>
                <td class="datatd-number">
                     <#if map.EDD.ED100J03??>
                         ${map.EDD.ED100J03?string(',###')}
                     <#else >
                     </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">保证合同编号</td>
                <td class="datatd">${map.EDD.ED090I03!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">公用事业缴费账户信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>公共事业缴费信息基本信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">公用事业缴费账户编号</td>
                <td class="datatd">${map.EEA.EE01AI01!}</td>
                <td class="labeltd">公用事业单位名称</td>
                <td class="datatd">${map.EEA.EE01AQ01!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6105",map.EEA.EE01AD01)!}</td>
                <td class="labeltd">缴费状态</td>
                <td class="datatd">${DataDicUtil.getDataDic("6107",map.EEA.EE01AD02)!}</td>
            </tr>

            <tr>
                <td class="labeltd">累计欠费金额</td>
                <td class="datatd-number">
                    <#if map.EEA.EE01AJ01??>
                        ${map.EEA.EE01AJ01?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">统计年月</td>
                <td class="datatd">${map.EEA.EE01AR01!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>过去24个月缴费情况信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
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
                            <td class="table-data-td">${EE01BH.EE01BR01!}</td>
                            <td class="table-data-td">${EE01BH.EE01BD01!}</td>
                            <td class="table-data-td">
                               <#if EE01BH.EE01BJ01??>
                                   ${EE01BH.EE01BJ01?string(',###')}
                               <#else >
                               </#if>
                            </td>
                            <td class="table-data-td">
                              <#if EE01BH.EE01BJ02??>
                                  ${EE01BH.EE01BJ02?string(',###')}
                              <#else >
                              </#if>
                            </td>
                            <td class="table-data-td">
                              <#if EE01BH.EE01BJ03??>
                                  ${EE01BH.EE01BJ03?string(',###')}
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
        <legend align="center">欠税信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>欠税记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">欠税记录编号</td>
                <td class="datatd">${map.EFA.EF010I01!}</td>
                <td class="labeltd">主管税务机关名称</td>
                <td class="datatd">${map.EFA.EF010Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">欠税总额</td>
                <td class="datatd-number">
                   <#if map.EFA.EF010J01??>
                       ${map.EFA.EF010J01?string(',###')}
                   <#else>
                   </#if>
                </td>
                <td class="labeltd">欠税统计时间</td>
                <td class="datatd">${map.EFA.EF010R01!}</td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend align="center">法院信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>民事判决记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">民事判决记录编号</td>
                <td class="datatd">${map.EFB.EF020I01!}</td>
                <td class="labeltd">立案法院名称</td>
                <td class="datatd">${map.EFB.EF020Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">案号</td>
                <td class="datatd">${map.EFB.EF020I02!}</td>
                <td class="labeltd">立案日期</td>
                <td class="datatd">${map.EFB.EF020R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">案由</td>
                <td class="datatd">${map.EFB.EF020Q02!}</td>
                <td class="labeltd">诉讼地位</td>
                <td class="datatd">${DataDicUtil.getDataDic("6109", map.EFB.EF020D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">审判程序</td>
                <td class="datatd">${DataDicUtil.getDataDic("6110", map.EFB.EF020D02)!}</td>
                <td class="labeltd">诉讼标的</td>
                <td class="datatd">${map.EFB.EF020Q03!}</td>
            </tr>
            <tr>
                <td class="labeltd">诉讼标的金额</td>
                <td class="datatd-number">
                    <#if map.EFB.EF020J01??>
                        ${map.EFB.EF020J01?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">结案方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6111", map.EFB.EF020D03)!}</td>
            </tr>
            <tr>
                <td class="labeltd">判决/调解生效日期</td>
                <td class="datatd">${map.EFB.EF020R02!}</td>
                <td class="labeltd">判决/调解结果</td>
                <td class="datatd">${map.EFB.EF020Q04!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>强制执行记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">强制执行记录编号</td>
                <td class="datatd">${map.EFB.EF030I01!}</td>
                <td class="labeltd">执行法院名称</td>
                <td class="datatd">${map.EFB.EF030Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">案号</td>
                <td class="datatd">${map.EFB.EF030I02!}</td>
                <td class="labeltd">立案日期</td>
                <td class="datatd">${map.EFB.EF030R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">执行案由</td>
                <td class="datatd">${map.EFB.EF030Q02!}</td>
                <td class="labeltd">申请执行标的</td>
                <td class="datatd">${map.EFB.EF030Q03!}</td>
            </tr>
            <tr>
                <td class="labeltd">申请执行标的金额</td>
                <td class="datatd-number">
                      <#if map.EFB.EF030J01??>
                          ${map.EFB.EF030J01?string(',###')}
                      <#else >
                      </#if>
                </td>
                <td class="labeltd">案件状态</td>
                <td class="datatd">${map.EFB.EF030Q04!}</td>
            </tr>
            <tr>
                <td class="labeltd">结案方式</td>
                <td class="datatd">${DataDicUtil.getDataDic("6112", map.EFB.EF030D01)!}</td>
                <td class="labeltd">已执行标的</td>
                <td class="datatd">${map.EFB.EF030Q05!}</td>
            </tr>
            <tr>
                <td class="labeltd">已执行标的金额</td>
                <td class="datatd-number">
                   <#if map.EFB.EF030J02??>
                       ${map.EFB.EF030J02?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">行政处罚信息</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>行政处罚记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">行政处罚记录编号</td>
                <td class="datatd">${map.EFC.EF040I01!}</td>
                <td class="labeltd">处罚机构名称</td>
                <td class="datatd">${map.EFC.EF040Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚决定书文号</td>
                <td class="datatd">${map.EFC.EF040I02!}</td>
                <td class="labeltd">违法行为</td>
                <td class="datatd">${map.EFC.EF040Q02!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚决定</td>
                <td class="datatd">${map.EFC.EF040Q03!}</td>
                <td class="labeltd">处罚日期</td>
                <td class="datatd">${map.EFC.EF040R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">处罚金额</td>
                <td class="datatd-number">
                  <#if map.EFC.EF040J01??>
                      ${map.EFC.EF040J01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">处罚执行情况</td>
                <td class="datatd">${map.EFC.EF040Q04!}</td>
            </tr>
            <tr>
                <td class="labeltd">行政复议结果</td>
                <td class="datatd">${map.EFC.EF040Q05!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">住房公积金参缴信息单元</legend>
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
                <td class="datatd-number">
                     <#if map.EFD.EF05AJ01??>
                         ${map.EFD.EF05AJ01?string(',###')}
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
                <td class="datatd-number">
                  <#if map.EFD.EF05AJ02??>
                      ${map.EFD.EF05AJ02?string(',###')}
                  <#else>
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">统计年月</td>
                <td class="datatd">${map.EFD.EF05AR04!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>过去24个月缴费情况信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">缴费记录条数</td>
                <td class="datatd">${map.EFD.EF05BS01!}</td>
            </tr>
            <tr>
                <td class="tabletd" colspan="4">
                    <table class="secondTable">
                        <tr>
                            <td colspan="4" class="table-head-td">缴费情况信息列表(总计${map.EF05BH?size!}条记录)</td>
                        </tr>
                        <tr>
                            <td class="labeltd">统计年月</td>
                            <td class="labeltd">缴费状态</td>
                            <td class="labeltd">本月应缴金额</td>
                            <td class="labeltd">本月实缴金额</td>
                            <td class="labeltd">累计欠费金额</td>
                        </tr>
                        <#list map.EF05BH! as EF05BH>
                        <tr>
                            <td class="table-data-td">${EF05BH.EF05BR01!}</td>
                            <td class="table-data-td">${EF05BH.EF05BD01!}</td>
                            <td class="table-data-td">
                                 <#if EF05BH.EF05BJ01??>
                                     ${EF05BH.EF05BJ01?string(',###')}
                                 <#else >
                                 </#if>
                            </td>
                            <td class="table-data-td">
                               <#if EF05BH.EF05BJ02??>
                                   ${EF05BH.EF05BJ02?string(',###')}
                               <#else >
                               </#if>
                            </td>
                            <td class="table-data-td">
                                <#if EF05BH.EF05BJ03??>
                                    ${EF05BH.EF05BJ03?string(',###')}
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
        <legend align="center">获得认证/奖励相关信息单元</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>获得许可记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">许可记录编号</td>
                <td class="datatd">${map.EFE.EF060I01!}</td>
                <td class="labeltd">许可部门名称</td>
                <td class="datatd">${map.EFE.EF060Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">许可类型</td>
                <td class="datatd">${map.EFE.EF060Q02!}</td>
                <td class="labeltd">许可日期</td>
                <td class="datatd">${map.EFE.EF060R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">截止日期</td>
                <td class="datatd">${map.EFE.EF060R02!}</td>
                <td class="labeltd">许可内容</td>
                <td class="datatd">${map.EFE.EF060Q03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>获得认证记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">认证记录编号</td>
                <td class="datatd">${map.EFE.EF070I01!}</td>
                <td class="labeltd">认证部门名称</td>
                <td class="datatd">${map.EFE.EF070Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">认证类型</td>
                <td class="datatd">${map.EFE.EF070Q02!}</td>
                <td class="labeltd">认证日期</td>
                <td class="datatd">${map.EFE.EF070R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">截止日期</td>
                <td class="datatd">${map.EFE.EF070R02!}</td>
                <td class="labeltd">认证内容</td>
                <td class="datatd">${map.EFE.EF070Q03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>获得资质记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资质记录编号</td>
                <td class="datatd">${map.EFE.EF080I01!}</td>
                <td class="labeltd">认定部门名称</td>
                <td class="datatd">${map.EFE.EF080Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">资质类型</td>
                <td class="datatd">${map.EFE.EF080Q02!}</td>
                <td class="labeltd">批准日期</td>
                <td class="datatd">${map.EFE.EF080R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">截止日期</td>
                <td class="datatd">${map.EFE.EF080R02!}</td>
                <td class="labeltd">资质内容</td>
                <td class="datatd">${map.EFE.EF080Q03!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>获得奖励记录信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">奖励记录编号</td>
                <td class="datatd">${map.EFE.EF090I01!}</td>
                <td class="labeltd">奖励部门名称</td>
                <td class="datatd">${map.EFE.EF090Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">奖励名称</td>
                <td class="datatd">${map.EFE.EF090Q02!}</td>
                <td class="labeltd">授予日期</td>
                <td class="datatd">${map.EFE.EF090R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">截止日期</td>
                <td class="datatd">${map.EFE.EF090R02!}</td>
                <td class="labeltd">奖励内容</td>
                <td class="datatd">${map.EFE.EF090Q03!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>拥有专利情况信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="datatd">${map.EFE.EF100I01!}</td>
                <td class="labeltd">专利名称</td>
                <td class="datatd">${map.EFE.EF100Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">专利号</td>
                <td class="datatd">${map.EFE.EF100I02!}</td>
                <td class="labeltd">申请日期</td>
                <td class="datatd">${map.EFE.EF100R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">授予日期</td>
                <td class="datatd">${map.EFE.EF100R02!}</td>
                <td class="labeltd">专利有效期</td>
                <td class="datatd">${map.EFE.EF100S01!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">进出口检验相关信息单元</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>出入境检验检疫绿色通道信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="datatd">${map.EFF.EF110I01!}</td>
                <td class="labeltd">批准部门名称</td>
                <td class="datatd">${map.EFF.EF110Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">出口商品名称</td>
                <td class="datatd">${map.EFF.EF110Q02!}</td>
                <td class="labeltd">生效日期</td>
                <td class="datatd">${map.EFF.EF110R01!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>进出口商品免验信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="datatd">${map.EFF.EF120I01!}</td>
                <td class="labeltd">批准部门名称</td>
                <td class="datatd">${map.EFF.EF120Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">免验商品名称</td>
                <td class="datatd">${map.EFF.EF120Q02!}</td>
                <td class="labeltd">免验号</td>
                <td class="datatd">${map.EFF.EF120I01!}</td>
            </tr>
            <tr>
                <td class="labeltd">截止日期</td>
                <td class="datatd">${map.EFF.EF120R02!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>进出口商品检验分类监管信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="datatd">${map.EFF.EF130I01!}</td>
                <td class="labeltd">监管部门名称</td>
                <td class="datatd">${map.EFF.EF130Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">管辖直属局</td>
                <td class="datatd">${map.EFF.EF130Q02!}</td>
                <td class="labeltd">监管级别</td>
                <td class="datatd">${DataDicUtil.getDataDic("6114", map.EFF.EF130D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">生效日期</td>
                <td class="datatd">${map.EFF.EF130R01!}</td>
                <td class="labeltd">截至日期</td>
                <td class="datatd">${map.EFF.EF130R02!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">融资规模控制信息单元</legend>
        <table class="mainTable">
            <tr>
                <td class="titletd" colspan="4">
                    <li>融资规模控制信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">信息编号</td>
                <td class="datatd">${map.EFG.EF140I01!}</td>
                <td class="labeltd">所属名录</td>
                <td class="datatd">${DataDicUtil.getDataDic("6115", map.EFG.EF140D01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">融资控制类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6116", map.EFG.EF140D02)!}</td>
                <td class="labeltd">年度</td>
                <td class="datatd">${map.EFG.EF140R01!}</td>
            </tr>
            <tr>
                <td class="labeltd">规模</td>
                <td class="datatd-number">
                  <#if map.EFG.EF140J01??>
                      ${map.EFG.EF140J01?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
        </table>
    </fieldset>

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
                      ${map.EGA.EG01BJ01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">短期投资</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ02??>
                       ${map.EGA.EG01BJ02?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收票据</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ03??>
                       ${map.EGA.EG01BJ03?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">应收股利</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ04??>
                       ${map.EGA.EG01BJ04?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收利息</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ05??>
                       ${map.EGA.EG01BJ05?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">应收账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ06??>
                       ${map.EGA.EG01BJ06?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他应收款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ07??>
                       ${map.EGA.EG01BJ07?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">预付账款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ08??>
                      ${map.EGA.EG01BJ08?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">期货保证金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ09??>
                       ${map.EGA.EG01BJ09?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">应收补贴款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ10??>
                       ${map.EGA.EG01BJ10?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收出口退税</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ11??>
                       ${map.EGA.EG01BJ11?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">存货</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ12??>
                       ${map.EGA.EG01BJ12?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">存货原材料</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ13??>
                       ${map.EGA.EG01BJ13?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">存货产成品</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ14??>
                       ${map.EGA.EG01BJ14?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待摊费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ15??>
                       ${map.EGA.EG01BJ15?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">待处理流动资产净损失</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ16??>
                       ${map.EGA.EG01BJ16?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">一年内到期的长期债权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ17??>
                        ${map.EGA.EG01BJ17?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">其他流动资产</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ18??>
                        ${map.EGA.EG01BJ18?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">流动资产合计</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ19??>
                        ${map.EGA.EG01BJ19?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">长期投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ20??>
                        ${map.EGA.EG01BJ20?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期股权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ21??>
                        ${map.EGA.EG01BJ21?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">长期债权投资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ22??>
                        ${map.EGA.EG01BJ22?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">合并价差</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ23??>
                        ${map.EGA.EG01BJ23?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">长期投资合计</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ24??>
                        ${map.EGA.EG01BJ24?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产原价</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ25??>
                        ${map.EGA.EG01BJ25?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">累计折旧</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ26??>
                        ${map.EGA.EG01BJ26?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产净值</td>
                <td class="datatd-number">
                     <#if map.EGA.EG01BJ27??>
                         ${map.EGA.EG01BJ27?string(',###')}
                     <#else >
                     </#if>
                </td>
                <td class="labeltd">固定资产值减值准备</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ28??>
                        ${map.EGA.EG01BJ28?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产净额</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ29??>
                        ${map.EGA.EG01BJ29?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">固定资产清理</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ30??>
                        ${map.EGA.EG01BJ30?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">工程物资</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ31??>
                        ${map.EGA.EG01BJ31?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">在建工程</td>
                <td class="datatd-number">
                    <#if map.EGA.EG01BJ32??>
                        ${map.EGA.EG01BJ32?string(',###')}
                    <#else >
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待处理固定资产净损失</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ33??>
                       ${map.EGA.EG01BJ33?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">固定资产合计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ34??>
                       ${map.EGA.EG01BJ34?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">无形资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ35??>
                       ${map.EGA.EG01BJ35?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">（无形资产科目下）土地使用权</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ36??>
                       ${map.EGA.EG01BJ36?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ37??>
                       ${map.EGA.EG01BJ37?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">（递延资产科目下）固定资产修理</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ38??>
                       ${map.EGA.EG01BJ38?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（递延资产科目下）固定资产改良支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ39??>
                       ${map.EGA.EG01BJ39?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">其他长期资产</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ40??>
                       ${map.EGA.EG01BJ40?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（其他长期资产科目下）特准储备物资</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ41??>
                     ${map.EGA.EG01BJ41?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">无形及其他资产合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ42??>
                     ${map.EGA.EG01BJ42?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延税款借项</td>
                <td class="datatd-number">
                 <#if map.EGA.EG01BJ43??>
                     ${map.EGA.EG01BJ43?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">资产总计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ44??>
                       ${map.EGA.EG01BJ44?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">短期借款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ45??>
                       ${map.EGA.EG01BJ45?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">应付票据</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ46??>
                       ${map.EGA.EG01BJ46?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应付账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ47??>
                       ${map.EGA.EG01BJ47?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">预收账款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ48??>
                       ${map.EGA.EG01BJ48?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应付工资</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ49??>
                       ${map.EGA.EG01BJ49?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">应付福利费</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ50??>
                       ${map.EGA.EG01BJ50?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应付利润</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ51??>
                      ${map.EGA.EG01BJ51?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">应交税金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ52??>
                      ${map.EGA.EG01BJ52?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他应交款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ53??>
                       ${map.EGA.EG01BJ53?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">其他应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ54??>
                      ${map.EGA.EG01BJ54?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">预提费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ55??>
                       ${map.EGA.EG01BJ55?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">预计负债</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ56??>
                       ${map.EGA.EG01BJ56?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">一年内到期的长期负债</td>
                <td class="datatd-number">
                   <#if map.EGA.EG01BJ57??>
                       ${map.EGA.EG01BJ57?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">其他流动负债</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ58??>
                      ${map.EGA.EG01BJ58?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">流动负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ59??>
                      ${map.EGA.EG01BJ59?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">长期借款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ60??>
                      ${map.EGA.EG01BJ60?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应付债券</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ61??>
                      ${map.EGA.EG01BJ61?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">长期应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ62??>
                      ${map.EGA.EG01BJ62?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">专项应付款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ63??>
                      ${map.EGA.EG01BJ63?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">其他长期负债</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ64??>
                      ${map.EGA.EG01BJ64?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（其他长期负债科目下）特准储备基金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ65??>
                      ${map.EGA.EG01BJ65?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">长期负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ66??>
                      ${map.EGA.EG01BJ66?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延税款贷项</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ67??>
                      ${map.EGA.EG01BJ67?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">负债合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ68??>
                      ${map.EGA.EG01BJ68?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">少数股东权益</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ69??>
                      ${map.EGA.EG01BJ69?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">实收资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ70??>
                      ${map.EGA.EG01BJ70?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">国家资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ71??>
                      ${map.EGA.EG01BJ71?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">集体资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ72??>
                      ${map.EGA.EG01BJ72?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ73??>
                      ${map.EGA.EG01BJ73?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">（法人资本科目下）国有法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ74??>
                      ${map.EGA.EG01BJ74?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（法人资本科目下）集体法人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ75??>
                      ${map.EGA.EG01BJ75?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">个人资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ76??>
                      ${map.EGA.EG01BJ76?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">外商资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ77??>
                      ${map.EGA.EG01BJ77?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">资本公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ78??>
                      ${map.EGA.EG01BJ78?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">盈余公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ79??>
                      ${map.EGA.EG01BJ79?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">（盈余公积科目下）法定盈余公积</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ80??>
                      ${map.EGA.EG01BJ80?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（盈余公积科目下）公益金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ81??>
                      ${map.EGA.EG01BJ81?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">（盈余公积科目下）补充流动资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ82??>
                      ${map.EGA.EG01BJ82?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">未确认的投资损失</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ83??>
                      ${map.EGA.EG01BJ83?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">未分配利润</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ84??>
                      ${map.EGA.EG01BJ84?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">外币报表折算差额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ85??>
                      ${map.EGA.EG01BJ85?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">所有者权益合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ86??>
                      ${map.EGA.EG01BJ86?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">负债和所有者权益总计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG01BJ87??>
                      ${map.EGA.EG01BJ87?string(',###')}
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
                     ${map.EGA.EG02BJ01?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">交易性金融资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ02??>
                    ${map.EGA.EG02BJ02?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收票据</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ03??>
                     ${map.EGA.EG02BJ03?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应收账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ04??>
                    ${map.EGA.EG02BJ04?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">预付账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ05??>
                    ${map.EGA.EG02BJ05?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">应收利息</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ06??>
                    ${map.EGA.EG02BJ06?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收股利</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ07??>
                    ${map.EGA.EG02BJ07?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">其他应收款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ08??>
                    ${map.EGA.EG02BJ08?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">存货</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ09??>
                    ${map.EGA.EG02BJ09?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">一年内到期的非流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ10??>
                    ${map.EGA.EG02BJ10?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ11??>
                    ${map.EGA.EG02BJ11?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">流动资产合计</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ12??>
                    ${map.EGA.EG02BJ12?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">可供出售的金融资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ13??>
                    ${map.EGA.EG02BJ13?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">持有至到期投资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ14??>
                    ${map.EGA.EG02BJ14?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期股权投资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ15??>
                    ${map.EGA.EG02BJ15?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">长期应收款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ16??>
                    ${map.EGA.EG02BJ16?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资性房地产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ17??>
                    ${map.EGA.EG02BJ17?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">固定资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ18??>
                    ${map.EGA.EG02BJ18?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">在建工程</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ19??>
                    ${map.EGA.EG02BJ19?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">工程物资</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ20??>
                    ${map.EGA.EG02BJ20?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产清理</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ21??>
                    ${map.EGA.EG02BJ21?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">生产性生物资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ22??>
                    ${map.EGA.EG02BJ22?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">油气资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ23??>
                    ${map.EGA.EG02BJ23?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">无形资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ24??>
                    ${map.EGA.EG02BJ24?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">开发支出</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ25??>
                    ${map.EGA.EG02BJ25?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">商誉</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ26??>
                    ${map.EGA.EG02BJ26?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期待摊费用</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ27??>
                    ${map.EGA.EG02BJ27?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">递延所得税资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ28??>
                    ${map.EGA.EG02BJ28?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他非流动资产</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ29??>
                    ${map.EGA.EG02BJ29?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">非流动资产合计</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ30??>
                    ${map.EGA.EG02BJ30?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资产总计</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ31??>
                    ${map.EGA.EG02BJ31?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">短期借款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ32??>
                    ${map.EGA.EG02BJ32?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">交易性金融负债</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ33??>
                    ${map.EGA.EG02BJ33?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">应付票据</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ34??>
                    ${map.EGA.EG02BJ34?string(',###')}
                <#else >
                </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应付账款</td>
                <td class="datatd-number">
                <#if map.EGA.EG02BJ35??>
                    ${map.EGA.EG02BJ35?string(',###')}
                <#else >
                </#if>
                </td>
                <td class="labeltd">预收账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ36??>
                     ${map.EGA.EG02BJ36?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应付利息</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ37??>
                     ${map.EGA.EG02BJ37?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应付职工薪酬</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ38??>
                     ${map.EGA.EG02BJ38?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应交税费</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ39??>
                     ${map.EGA.EG02BJ39?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应付股利</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ40??>
                     ${map.EGA.EG02BJ40?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ41??>
                     ${map.EGA.EG02BJ41?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">一年内到期的非流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ42??>
                     ${map.EGA.EG02BJ42?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ43??>
                     ${map.EGA.EG02BJ43?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">流动负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ44??>
                     ${map.EGA.EG02BJ44?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期借款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ45??>
                     ${map.EGA.EG02BJ45?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应付债券</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ46??>
                     ${map.EGA.EG02BJ46?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ47??>
                     ${map.EGA.EG02BJ47?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">专项应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ48??>
                     ${map.EGA.EG02BJ48?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">预计负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ49??>
                     ${map.EGA.EG02BJ49?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">递延所得税负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ50??>
                     ${map.EGA.EG02BJ50?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他非流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ51??>
                     ${map.EGA.EG02BJ51?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">非流动负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ52??>
                     ${map.EGA.EG02BJ52?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ53??>
                     ${map.EGA.EG02BJ53?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">实收资本（或股本）</td>
                <td class="datatd-number">
                  <#if map.EGA.EG02BJ54??>
                      ${map.EGA.EG02BJ54?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资本公积</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ55??>
                     ${map.EGA.EG02BJ55?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">减：库存股</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ56??>
                     ${map.EGA.EG02BJ56?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">盈余公积</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ57??>
                     ${map.EGA.EG02BJ57?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">未分配利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ58??>
                     ${map.EGA.EG02BJ58?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">所有者权益合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ59??>
                     ${map.EGA.EG02BJ59?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">负债和所有者权益合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG02BJ60??>
                     ${map.EGA.EG02BJ60?string(',###')}
                 <#else >
                 </#if>
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
                <td class="labeltd">主营业务收入</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ01??>
                      ${map.EGA.EG03BJ01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">（主营业务收入科目下）出口产品销售收入</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ02??>
                      ${map.EGA.EG03BJ02?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（主营业务收入科目下）进口产品销售收入</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ03??>
                      ${map.EGA.EG03BJ03?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">销售折扣与折让</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ04??>
                      ${map.EGA.EG03BJ04?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">主营业务收入净额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ05??>
                      ${map.EGA.EG03BJ05?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">主营业务成本</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ06??>
                     ${map.EGA.EG03BJ06?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">主营业务成本科目下）出口产品销售成本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ07??>
                      ${map.EGA.EG03BJ07?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">主营业务税金及附加</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ08??>
                      ${map.EGA.EG03BJ08?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营费用</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ09??>
                      ${map.EGA.EG03BJ09?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">其他（业务成本）</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ10??>
                      ${map.EGA.EG03BJ10?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延收益</td>
                <td class="datatd-number">
                  <#if map.EGA.EG03BJ11??>
                      ${map.EGA.EG03BJ11?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">代购代销收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ12??>
                     ${map.EGA.EG03BJ12?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他（收入）</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ13??>
                     ${map.EGA.EG03BJ13?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">主营业务利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ14??>
                     ${map.EGA.EG03BJ14?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他业务利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ15??>
                     ${map.EGA.EG03BJ15?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">营业费用</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ16??>
                     ${map.EGA.EG03BJ16?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">管理费用</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ17??>
                     ${map.EGA.EG03BJ17?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">财务费用</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ18??>
                     ${map.EGA.EG03BJ18?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他（费用）</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ19??>
                     ${map.EGA.EG03BJ19?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">营业利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ20??>
                     ${map.EGA.EG03BJ20?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资收益</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ21??>
                     ${map.EGA.EG03BJ21?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">期货收益</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ22??>
                     ${map.EGA.EG03BJ22?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">补贴收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ23??>
                     ${map.EGA.EG03BJ23?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">（补贴收入科目下）补贴前亏损的企业补贴收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ24??>
                     ${map.EGA.EG03BJ24?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">营业外收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ25??>
                     ${map.EGA.EG03BJ25?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">（营业外收入科目下）处置固定资产净收益</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ26??>
                     ${map.EGA.EG03BJ26?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（营业外收入科目下）非货币性交易收益</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ27??>
                     ${map.EGA.EG03BJ27?string(',###')}
                 <#else>
                 </#if>
                </td>
                <td class="labeltd">（营业外收入科目下）出售无形资产收益<</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ28??>
                     ${map.EGA.EG03BJ28?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（营业外收入科目下）罚款净收入/td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ29??>
                     ${map.EGA.EG03BJ29?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">其他（利润）</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ30??>
                     ${map.EGA.EG03BJ30?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（其他科目下）用以前年度含量工资节余弥补利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ31??>
                     ${map.EGA.EG03BJ31?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">营业外支出</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ32??>
                     ${map.EGA.EG03BJ32?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（营业外支出科目下）处置固定资产净损失</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ33??>
                     ${map.EGA.EG03BJ33?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">（营业外支出科目下）债务重组损失</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ34??>
                     ${map.EGA.EG03BJ34?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（营业外支出科目下）罚款支出</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ35??>
                     ${map.EGA.EG03BJ35?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">（营业外支出科目下）捐赠支出</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ36??>
                     ${map.EGA.EG03BJ36?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他支出</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ37??>
                     ${map.EGA.EG03BJ37?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">（其他支出）结转的含量工资包干节余</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ38??>
                     ${map.EGA.EG03BJ38?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">利润总额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ39??>
                     ${map.EGA.EG03BJ39?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">所得税</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ40??>
                     ${map.EGA.EG03BJ40?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">少数股东损益</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ41??>
                     ${map.EGA.EG03BJ41?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">未确认的投资损失</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ42??>
                     ${map.EGA.EG03BJ42?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">净利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ43??>
                     ${map.EGA.EG03BJ43?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">年初未分配利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ44??>
                     ${map.EGA.EG03BJ44?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">盈余公积补亏</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ45??>
                     ${map.EGA.EG03BJ45?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">其他调整因素</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ46??>
                     ${map.EGA.EG03BJ46?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">可供分配的利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ47??>
                     ${map.EGA.EG03BJ47?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">单项留用的利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ48??>
                     ${map.EGA.EG03BJ48?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">补充流动资本</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ49??>
                     ${map.EGA.EG03BJ49?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">提取法定盈余公积</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ50??>
                     ${map.EGA.EG03BJ50?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">提取法定公益金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ51??>
                     ${map.EGA.EG03BJ51?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">提取职工奖励及福利基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ52??>
                     ${map.EGA.EG03BJ52?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">提取储备基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ53??>
                     ${map.EGA.EG03BJ53?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">提取企业发展基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ54??>
                     ${map.EGA.EG03BJ54?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">利润归还投资</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ55??>
                     ${map.EGA.EG03BJ55?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">（可供分配的利润科目下）其他</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ56??>
                     ${map.EGA.EG03BJ56?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">可供投资者分配的利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ57??>
                     ${map.EGA.EG03BJ57?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应付优先股股利</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ58??>
                     ${map.EGA.EG03BJ58?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">提取任意盈余公积</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ59??>
                     ${map.EGA.EG03BJ59?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应付普通股股利</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ60??>
                     ${map.EGA.EG03BJ60?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">转作资本的普通股股利</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ61??>
                     ${map.EGA.EG03BJ61?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">（可供投资者分配的利润科目下）其他</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ62??>
                     ${map.EGA.EG03BJ62?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">未分配利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ63??>
                     ${map.EGA.EG03BJ63?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">（未分配利润科目下）应由以后年度税前利润弥补的亏损</td>
                <td class="datatd-number">
                 <#if map.EGA.EG03BJ64??>
                     ${map.EGA.EG03BJ64?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>企业利润表及利润分配表（2007版）信息单元</li>
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
                <td class="labeltd">营业收入</td>
                <td class="datatd-number">
                    <#if map.EGA.EG04BJ01??>
                        ${map.EGA.EG04BJ01?string(',###')}
                    <#else >
                    </#if>
                </td>
                <td class="labeltd">营业成本</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ02??>
                       ${map.EGA.EG04BJ02?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">营业税金及附加</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ03??>
                       ${map.EGA.EG04BJ03?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">销售费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ04??>
                       ${map.EGA.EG04BJ04?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">管理费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ05??>
                       ${map.EGA.EG04BJ05?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">财务费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ06??>
                       ${map.EGA.EG04BJ06?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资产减值损失</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ07??>
                       ${map.EGA.EG04BJ07?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">公允价值变动净收益</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ08??>
                       ${map.EGA.EG04BJ08?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资净收益</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ09??>
                       ${map.EGA.EG04BJ09?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">对联营企业和合营企业的投资收益</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ10??>
                       ${map.EGA.EG04BJ10?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">营业利润</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ11??>
                       ${map.EGA.EG04BJ11?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">营业外收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ12??>
                       ${map.EGA.EG04BJ12?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">营业外支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ13??>
                       ${map.EGA.EG04BJ13?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">非流动资产损失（其中：非流动资产处置损失）</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ14??>
                       ${map.EGA.EG04BJ14?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">利润总额</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ15??>
                       ${map.EGA.EG04BJ15?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">所得税费用</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ16??>
                       ${map.EGA.EG04BJ16?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">净利润</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ17??>
                       ${map.EGA.EG04BJ17?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">基本每股收益</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ18??>
                       ${map.EGA.EG04BJ18?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">稀释每股收益</td>
                <td class="datatd-number">
                   <#if map.EGA.EG04BJ19??>
                       ${map.EGA.EG04BJ19?string(',###')}
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
                <td class="labeltd">销售商品和提供劳务收到的现金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG05BJ01??>
                       ${map.EGA.EG05BJ01?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">收到的税费返还</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ02??>
                      ${map.EGA.EG05BJ02?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">收到的其他与经营活动有关的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ03??>
                      ${map.EGA.EG05BJ03?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">经营活动现金流入小计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ04??>
                      ${map.EGA.EG05BJ04?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">购买商品、接受劳务支付的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ05??>
                      ${map.EGA.EG05BJ05?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">支付给职工以及为职工支付的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ06??>
                      ${map.EGA.EG05BJ06?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">支付的各项税费</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ07??>
                      ${map.EGA.EG05BJ07?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">支付的其他与经营活动有关的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ08??>
                      ${map.EGA.EG05BJ08?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营活动现金流出小计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ09??>
                      ${map.EGA.EG05BJ09?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">经营活动产生的现金流量净额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ10??>
                      ${map.EGA.EG05BJ10?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">收回投资所收到的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ11??>
                      ${map.EGA.EG05BJ11?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">取得投资收益所收到的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ12??>
                      ${map.EGA.EG05BJ12?string(',###')}
                  <#else>
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">处置固定资产无形资产和其他长期资产所收回的现金净额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ13??>
                      ${map.EGA.EG05BJ13?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">收到的其他与投资活动有关的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ14??>
                      ${map.EGA.EG05BJ14?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资活动现金流入小计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ15??>
                      ${map.EGA.EG05BJ15?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">购建固定资产无形资产和其他长期资产所支付的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ16??>
                      ${map.EGA.EG05BJ16?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资所支付的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ17??>
                      ${map.EGA.EG05BJ17?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">支付的其他与投资活动有关的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ18??>
                      ${map.EGA.EG05BJ18?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资活动现金流出小计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG04BJ19??>
                      ${map.EGA.EG04BJ19?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">投资活动产生的现金流量净额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ20??>
                      ${map.EGA.EG05BJ20?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">吸收投资所收到的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ21??>
                      ${map.EGA.EG05BJ21?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">借款所收到的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ22??>
                      ${map.EGA.EG05BJ22?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">收到的其他与筹资活动有关的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ23??>
                      ${map.EGA.EG05BJ23?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">筹资活动现金流入小计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ24??>
                      ${map.EGA.EG05BJ24?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">偿还债务所支付的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ25??>
                      ${map.EGA.EG05BJ25?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">分配股利、利润或偿付利息所支付的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ26??>
                      ${map.EGA.EG05BJ26?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">支付的其他与筹资活动有关的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ27??>
                      ${map.EGA.EG05BJ27?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">筹资活动现金流出小计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ28??>
                      ${map.EGA.EG05BJ28?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">筹集活动产生的现金流量净额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ29??>
                      ${map.EGA.EG05BJ29?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">汇率变动对现金的影响</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ30??>
                      ${map.EGA.EG05BJ30?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">现金及现金等价物净增加额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ31??>
                      ${map.EGA.EG05BJ31?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">净利润</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ32??>
                      ${map.EGA.EG05BJ32?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">计提的资产减值准备</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ33??>
                      ${map.EGA.EG05BJ33?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">固定资产拆旧</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ34??>
                      ${map.EGA.EG05BJ34?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">无形资产摊销</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ35??>
                      ${map.EGA.EG05BJ35?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">长期待摊费用摊销</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ36??>
                      ${map.EGA.EG05BJ36?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待摊费用减少</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ37??>
                      ${map.EGA.EG05BJ37?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">预提费用增加</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ38??>
                      ${map.EGA.EG05BJ38?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">处置固定资产无形资产和其他长期资产的损失</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ39??>
                      ${map.EGA.EG05BJ39?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">固定资产报废损失</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ40??>
                      ${map.EGA.EG05BJ40?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财务费用</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ41??>
                      ${map.EGA.EG05BJ41?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">投资损失</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ42??>
                      ${map.EGA.EG05BJ42?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">递延税款贷项</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ43??>
                      ${map.EGA.EG05BJ43?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">存货的减少</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ44??>
                      ${map.EGA.EG05BJ44?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营性应收项目的减少</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ45??>
                      ${map.EGA.EG05BJ45?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">经营性应付项目的增加</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ46??>
                      ${map.EGA.EG05BJ46?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（净利润调节为经营活动现金流量科目下）其他</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ47??>
                      ${map.EGA.EG05BJ47?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">经营活动产生的现金流量净额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ48??>
                      ${map.EGA.EG05BJ48?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">债务转为资本</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ49??>
                      ${map.EGA.EG05BJ49?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">一年内到期的可转换公司债券</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ50??>
                      ${map.EGA.EG05BJ50?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">融资租入固定资产</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ51??>
                      ${map.EGA.EG05BJ51?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">（不涉及现金收支的投资和筹资活动科目下）其他</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ52??>
                      ${map.EGA.EG05BJ52?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">现金的期末余额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ53??>
                      ${map.EGA.EG05BJ53?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">现金的期初余额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ54??>
                      ${map.EGA.EG05BJ54?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">现金等价物的期末余额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ55??>
                      ${map.EGA.EG05BJ55?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">现金等价物的期初余额</td>
                <td class="datatd-number">${map.EGA.EG05BJ56!}
                  <#if map.EGA.EG05BJ56??>
                      ${map.EGA.EG05BJ56?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">现金及现金等价物净增加额</td>
                <td class="datatd-number">
                  <#if map.EGA.EG05BJ57??>
                      ${map.EGA.EG05BJ57?string(',###')}
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
                <td class="datatd">${map.EGA.EG07AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG07AD01)!}</td>
            </tr>

            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG07AI02!}</td>
                <td class="labeltd">报表年份</td>
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
                    <li>企业现金流量表（2007版）单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd">销售商品和提供劳务收到的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG06BJ01??>
                      ${map.EGA.EG06BJ01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">收到的税费返还</td>
                <td class="datatd-number">
                  <#if map.EGA.EG06BJ02??>
                      ${map.EGA.EG06BJ02?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">收到其他与经营活动有关的现金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG06BJ03??>
                      ${map.EGA.EG06BJ03?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">经营活动现金流入小计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ04??>
                     ${map.EGA.EG06BJ04?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">购买商品、接受劳务支付的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ05??>
                     ${map.EGA.EG06BJ05?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">支付给职工以及为职工支付的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ06??>
                     ${map.EGA.EG06BJ06?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">支付的各项税费</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ07??>
                     ${map.EGA.EG06BJ07?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">支付其他与经营活动有关的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ08??>
                     ${map.EGA.EG06BJ08?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营活动现金流出小计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ09??>
                     ${map.EGA.EG06BJ09?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">经营活动产生的现金流量净额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ10??>
                     ${map.EGA.EG06BJ10?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">收回投资所收到的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ11??>
                     ${map.EGA.EG06BJ11?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">取得投资收益所收到的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ12??>
                     ${map.EGA.EG06BJ12?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">处置固定资产无形资产和其他长期资产所收回的现金净额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ13??>
                     ${map.EGA.EG06BJ13?string(',###')}
                 <#else>
                 </#if>
                </td>
                <td class="labeltd">处置子公司及其他营业单位收到的现金净额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ14??>
                     ${map.EGA.EG06BJ14?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">收到其他与投资活动有关的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ15??>
                     ${map.EGA.EG06BJ15?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">投资活动现金流入小计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ16??>
                     ${map.EGA.EG06BJ16?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">购建固定资产无形资产和其他长期资产所支付的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ17??>
                     ${map.EGA.EG06BJ17?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">投资所支付的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ18??>
                     ${map.EGA.EG06BJ18?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">取得子公司及其他营业单位支付的现金净额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ19??>
                     ${map.EGA.EG06BJ19?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">支付其他与投资活动有关的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ20??>
                     ${map.EGA.EG06BJ20?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资活动现金流出小计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ21??>
                     ${map.EGA.EG06BJ21?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">投资活动产生的现金流量净额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ22??>
                     ${map.EGA.EG06BJ22?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">吸收投资收到的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ23??>
                     ${map.EGA.EG06BJ23?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">取得借款收到的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ24??>
                     ${map.EGA.EG06BJ24?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">收到其他与筹资活动有关的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ25??>
                     ${map.EGA.EG06BJ25?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">筹资活动现金流入小计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ26??>
                     ${map.EGA.EG06BJ26?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">偿还债务所支付的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ27??>
                     ${map.EGA.EG06BJ27?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">分配股利、利润或偿付利息所支付的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ28??>
                     ${map.EGA.EG06BJ28?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">支付其他与筹资活动有关的现金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ29??>
                     ${map.EGA.EG06BJ29?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">筹资活动现金流出小计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ30??>
                     ${map.EGA.EG06BJ30?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">筹集活动产生的现金流量净额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ31??>
                     ${map.EGA.EG06BJ31?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">汇率变动对现金及现金等价物的影响</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ32??>
                     ${map.EGA.EG06BJ32?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">现金及现金等价物净增加额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ33??>
                     ${map.EGA.EG06BJ33?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">期初现金及现金等价物余额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ34??>
                     ${map.EGA.EG06BJ34?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">期末现金及现金等价物余额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ35??>
                     ${map.EGA.EG06BJ35?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">净利润</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ36??>
                     ${map.EGA.EG06BJ36?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资产减值准备</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ37??>
                     ${map.EGA.EG06BJ37?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">固定资产折旧、油气资产折耗、生产性生物资产折旧</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ38??>
                     ${map.EGA.EG06BJ38?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">无形资产摊销</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ39??>
                     ${map.EGA.EG06BJ39?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">长期待摊费用摊销</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ40??>
                     ${map.EGA.EG06BJ40?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待摊费用减少</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ41??>
                     ${map.EGA.EG06BJ41?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">预提费用增加</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ42??>
                     ${map.EGA.EG06BJ42?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">处置固定资产无形资产和其他长期资产的损失</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ43??>
                     ${map.EGA.EG06BJ43?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">固定资产报废损失</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ44??>
                     ${map.EGA.EG06BJ44?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">公允价值变动损失</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ45??>
                     ${map.EGA.EG06BJ45?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">财务费用</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ46??>
                     ${map.EGA.EG06BJ46?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">投资损失</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ47??>
                     ${map.EGA.EG06BJ47?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">递延所得税资产减少</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ48??>
                     ${map.EGA.EG06BJ48?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">递延所得税负债增加</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ49??>
                     ${map.EGA.EG06BJ49?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">存货的减少</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ50??>
                     ${map.EGA.EG06BJ50?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营性应收项目的减少</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ51??>
                     ${map.EGA.EG06BJ51?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">经营性应付项目的增加</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ52??>
                     ${map.EGA.EG06BJ52?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（净利润调节为经营活动现金流量科目下）其他</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ53??>
                     ${map.EGA.EG06BJ53?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">经营活动产生的现金流量净额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ54??>
                     ${map.EGA.EG06BJ54?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">债务转为资本</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ55??>
                     ${map.EGA.EG06BJ55?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">一年内到期的可转换公司债券</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ56??>
                     ${map.EGA.EG06BJ56?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">融资租入固定资产</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ57??>
                     ${map.EGA.EG06BJ57?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">现金的期末余额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ58??>
                     ${map.EGA.EG06BJ58?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">现金的期初余额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ59??>
                     ${map.EGA.EG06BJ59?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">现金等价物的期末余额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ60??>
                     ${map.EGA.EG06BJ60?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">现金等价物的期初余额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ61??>
                     ${map.EGA.EG06BJ61?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">现金及现金等价物净增加额</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ62??>
                     ${map.EGA.EG06BJ62?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">（不涉及现金收支的投资和筹资活动科目下）其他</td>
                <td class="datatd-number">
                 <#if map.EGA.EG06BJ63??>
                     ${map.EGA.EG06BJ63?string(',###')}
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
                <td class="labeltd">报表年份</td>
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
                <td class="labeltd">现金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG07BJ01??>
                       ${map.EGA.EG07BJ01?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">银行存款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ02??>
                     ${map.EGA.EG07BJ02?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收票据</td>
                <td class="datatd-number">
                  <#if map.EGA.EG07BJ03??>
                      ${map.EGA.EG07BJ03?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">应收账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ04??>
                     ${map.EGA.EG07BJ04?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">预付账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ05??>
                     ${map.EGA.EG07BJ05?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">其他应收款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ06??>
                     ${map.EGA.EG07BJ06?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">材料</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ07??>
                     ${map.EGA.EG07BJ07?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">产成品</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ08??>
                     ${map.EGA.EG07BJ08?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">对外投资</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ09??>
                     ${map.EGA.EG07BJ09?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">固定资产</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ10??>
                     ${map.EGA.EG07BJ10?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">无形资产</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ11??>
                     ${map.EGA.EG07BJ11?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">资产合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG07BJ12??>
                      ${map.EGA.EG07BJ12?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">拨出经费</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ13??>
                     ${map.EGA.EG07BJ13?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">拨出专款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ14??>
                     ${map.EGA.EG07BJ14?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">专款支出</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ15??>
                     ${map.EGA.EG07BJ15?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">事业支出</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ16??>
                     ${map.EGA.EG07BJ16?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营支出</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ17??>
                     ${map.EGA.EG07BJ17?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">成本费用</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ18??>
                     ${map.EGA.EG07BJ18?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">销售税金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ19??>
                     ${map.EGA.EG07BJ19?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">上缴上级支出</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ20??>
                     ${map.EGA.EG07BJ20?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">对附属单位补助</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ21??>
                     ${map.EGA.EG07BJ21?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">结转自筹基建</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ22??>
                     ${map.EGA.EG07BJ22?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">支出合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ23??>
                     ${map.EGA.EG07BJ23?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">资产部类总计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ24??>
                     ${map.EGA.EG07BJ24?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">借记款项</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ25??>
                     ${map.EGA.EG07BJ25?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应付票据</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ26??>
                     ${map.EGA.EG07BJ26?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应付账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ27??>
                     ${map.EGA.EG07BJ27?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">预收账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ28??>
                     ${map.EGA.EG07BJ28?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ29??>
                     ${map.EGA.EG07BJ29?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应缴预算款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ30??>
                     ${map.EGA.EG07BJ30?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应缴财政专户款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ31??>
                     ${map.EGA.EG07BJ31?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应交税金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ32??>
                     ${map.EGA.EG07BJ32?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ33??>
                     ${map.EGA.EG07BJ33?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">事业基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ34??>
                     ${map.EGA.EG07BJ34?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">一般基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ35??>
                     ${map.EGA.EG07BJ35?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">投资基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ36??>
                     ${map.EGA.EG07BJ36?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">固定基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ37??>
                     ${map.EGA.EG07BJ37?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">专用基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ38??>
                     ${map.EGA.EG07BJ38?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">事业结余</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ39??>
                     ${map.EGA.EG07BJ39?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">经营结余</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ40??>
                     ${map.EGA.EG07BJ40?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">净资产合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ41??>
                     ${map.EGA.EG07BJ41?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">财政补助收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ42??>
                     ${map.EGA.EG07BJ42?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">上级补助收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ43??>
                     ${map.EGA.EG07BJ43?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">拨入专款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ44??>
                     ${map.EGA.EG07BJ44?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">事业收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ45??>
                     ${map.EGA.EG07BJ45?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">经营收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ46??>
                     ${map.EGA.EG07BJ46?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">附属单位缴款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ47??>
                     ${map.EGA.EG07BJ47?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">其他收入</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ48??>
                     ${map.EGA.EG07BJ48?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">收入合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ49??>
                     ${map.EGA.EG07BJ49?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">负债部类总计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG07BJ50??>
                     ${map.EGA.EG07BJ50?string(',###')}
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
                <td class="labeltd">货币资金</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ01??>
                      ${map.EGA.EG08BJ01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">短期投资</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ02??>
                      ${map.EGA.EG08BJ02?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财政应返还额度</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ03??>
                      ${map.EGA.EG08BJ03?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">应收票据</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ04??>
                      ${map.EGA.EG08BJ04?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应收账款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ05??>
                      ${map.EGA.EG08BJ05?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">预付账款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ06??>
                      ${map.EGA.EG08BJ06?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">其他应收款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ07??>
                      ${map.EGA.EG08BJ07?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">存货</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ08??>
                      ${map.EGA.EG08BJ08?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他流动资产</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ09??>
                      ${map.EGA.EG08BJ09?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">流动资产合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ10??>
                      ${map.EGA.EG08BJ10?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期投资</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ11??>
                      ${map.EGA.EG08BJ11?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">固定资产</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ12??>
                      ${map.EGA.EG08BJ12?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">固定资产原价</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ13??>
                      ${map.EGA.EG08BJ13?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">累计折旧</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ14??>
                      ${map.EGA.EG08BJ14?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">在建工程</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ15??>
                      ${map.EGA.EG08BJ15?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">无形资产</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ16??>
                      ${map.EGA.EG08BJ16?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">无形资产原价</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ17??>
                     ${map.EGA.EG08BJ17?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">累计摊销</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ18??>
                      ${map.EGA.EG08BJ18?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">待处置资产损溢</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ19??>
                     ${map.EGA.EG08BJ19?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">非流动资产合计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG08BJ20??>
                      ${map.EGA.EG08BJ20?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">资产总计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ21??>
                     ${map.EGA.EG08BJ21?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">短期借款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ22??>
                     ${map.EGA.EG08BJ22?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应缴税费</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ23??>
                     ${map.EGA.EG08BJ23?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应缴国库款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ24??>
                     ${map.EGA.EG08BJ24?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应缴财政专户款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ25??>
                     ${map.EGA.EG08BJ25?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应付职工薪酬</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ26??>
                     ${map.EGA.EG08BJ26?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应付票据</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ27??>
                     ${map.EGA.EG08BJ27?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">应付账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ28??>
                     ${map.EGA.EG08BJ28?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">预收账款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ29??>
                     ${map.EGA.EG08BJ29?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">其他应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ30??>
                     ${map.EGA.EG08BJ30?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他流动负债</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ31??>
                     ${map.EGA.EG08BJ31?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">流动负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ32??>
                     ${map.EGA.EG08BJ32?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">长期借款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ33??>
                     ${map.EGA.EG08BJ33?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">长期应付款</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ34??>
                     ${map.EGA.EG08BJ34?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">非流动负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ35??>
                     ${map.EGA.EG08BJ35?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">负债合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ36??>
                     ${map.EGA.EG08BJ36?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">事业基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ37??>
                     ${map.EGA.EG08BJ37?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">非流动资产基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ38??>
                     ${map.EGA.EG08BJ38?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>

            <tr>
                <td class="labeltd">专用基金</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ39??>
                     ${map.EGA.EG08BJ39?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">财政补助结转</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ40??>
                     ${map.EGA.EG08BJ40?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财政补助结余</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ41??>
                     ${map.EGA.EG08BJ41?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">非财政补助结转</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ42??>
                     ${map.EGA.EG08BJ42?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">非财政补助结余</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ43??>
                     ${map.EGA.EG08BJ43?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">事业结余</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ44??>
                     ${map.EGA.EG08BJ44?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营结余</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ45??>
                     ${map.EGA.EG08BJ45?string(',###')}
                 <#else >
                 </#if>
                </td>
                <td class="labeltd">净资产合计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ46??>
                     ${map.EGA.EG08BJ46?string(',###')}
                 <#else >
                 </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">负债和净资产总计</td>
                <td class="datatd-number">
                 <#if map.EGA.EG08BJ47??>
                     ${map.EGA.EG08BJ47?string(',###')}
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
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG09AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG09AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG09AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG09AR01!}</td>
            </tr>

            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG09AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG09AD03)!}</td>
            </tr>

            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位收入支出表（1997）版单元</li>
                </td>
            </tr>

            <tr>
                <td class="labeltd">财政补助收入</td>
                <td class="datatd-number">
                  <#if map.EGA.EG09BJ01??>
                      ${map.EGA.EG09BJ01?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">上级补助收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ02??>
                       ${map.EGA.EG09BJ02?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">附属单位缴款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ03??>
                       ${map.EGA.EG09BJ03?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">事业收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ04??>
                       ${map.EGA.EG09BJ04?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">预算外资金收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ05??>
                       ${map.EGA.EG09BJ05?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">其他收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ06??>
                       ${map.EGA.EG09BJ06?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">事业收入小计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ07??>
                       ${map.EGA.EG09BJ07?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">经营收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ08??>
                       ${map.EGA.EG09BJ08?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营收入小计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ09??>
                       ${map.EGA.EG09BJ09?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">拨入专款</td>
                <td class="datatd-number">
                  <#if map.EGA.EG09BJ10??>
                      ${map.EGA.EG09BJ10?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">拨入专款小计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ11??>
                       ${map.EGA.EG09BJ11?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">收入总计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ12??>
                       ${map.EGA.EG09BJ12?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">拨出经费</td>
                <td class="datatd-number">
                  <#if map.EGA.EG09BJ13??>
                      ${map.EGA.EG09BJ13?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">上缴上级支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ14??>
                       ${map.EGA.EG09BJ14?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">对附属单位补助</td>
                <td class="datatd-number">
                  <#if map.EGA.EG09BJ15??>
                      ${map.EGA.EG09BJ15?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">事业支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ16??>
                       ${map.EGA.EG09BJ16?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财政补助支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ17??>
                       ${map.EGA.EG09BJ17?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">预算外资金支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ18??>
                       ${map.EGA.EG09BJ18?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">销售税金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ19??>
                       ${map.EGA.EG09BJ19?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">结转自筹基建</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ20??>
                       ${map.EGA.EG09BJ20?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">事业支出小计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ21??>
                       ${map.EGA.EG09BJ21?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">经营支出</td>
                <td class="datatd-number">
                  <#if map.EGA.EG09BJ22??>
                      ${map.EGA.EG09BJ22?string(',###')}
                  <#else >
                  </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd">销售税金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ23??>
                       ${map.EGA.EG09BJ23?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">经营支出小计</td>
                <td class="datatd-number">
                  <#if map.EGA.EG09BJ24??>
                      ${map.EGA.EG09BJ24?string(',###')}
                  <#else >
                  </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">拨出专款</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ25??>
                       ${map.EGA.EG09BJ25?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">专款支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ26??>
                       ${map.EGA.EG09BJ26?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">专款小计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ27??>
                       ${map.EGA.EG09BJ27?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">支出总计</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ28??>
                       ${map.EGA.EG09BJ28?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">事业结余</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ29??>
                       ${map.EGA.EG09BJ29?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">正常收入结余</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ30??>
                       ${map.EGA.EG09BJ30?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">收回以前年度事业支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ31??>
                       ${map.EGA.EG09BJ31?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">经营结余</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ33??>
                       ${map.EGA.EG09BJ33?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">以前年度经营亏损</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ33??>
                       ${map.EGA.EG09BJ33?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">结余分配</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ34??>
                       ${map.EGA.EG09BJ34?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应交所得税</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ35??>
                       ${map.EGA.EG09BJ35?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">提取专用基金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ36??>
                       ${map.EGA.EG09BJ36?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">转入事业基金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ37??>
                       ${map.EGA.EG09BJ37?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">其他结余分配</td>
                <td class="datatd-number">
                   <#if map.EGA.EG09BJ38??>
                       ${map.EGA.EG09BJ38?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位收入支出表（2013）版信息单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">财务报表编号</td>
                <td class="datatd">${map.EGA.EG10AI01!}</td>
                <td class="labeltd">业务管理机构</td>
                <td class="datatd">${DataDicUtil.getDataDic("6082", map.EGA.EG10AD01)!}</td>
            </tr>
            <tr>
                <td class="labeltd">业务管理机构代码</td>
                <td class="datatd">${map.EGA.EG10AI02!}</td>
                <td class="labeltd">报表年份</td>
                <td class="datatd">${map.EGA.EG10AR01!}</td>
            </tr>
            <tr>
                <td class="labeltd">报表类型</td>
                <td class="datatd">${DataDicUtil.getDataDic("6117", map.EGA.EG10AD02)!}</td>
                <td class="labeltd">报表类型细分</td>
                <td class="datatd">${DataDicUtil.getDataDic("6118", map.EGA.EG10AD03)!}</td>
            </tr>
            <tr>
                <td class="titletd" colspan="4">
                    <li>事业单位收入支出表（2013）版单元</li>
                </td>
            </tr>
            <tr>
                <td class="labeltd">本期财政补助结转结余</td>
                <td class="datatd-number">${map.EGA.EG10BJ01!}
                      <#if map.EGA.EG09BJ38??>
                          ${map.EGA.EG09BJ38?string(',###')}
                      <#else >
                      </#if>
                </td>
                <td class="labeltd">财政补助收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ02??>
                       ${map.EGA.EG10BJ02?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">事业支出（财政补助支出）</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ03??>
                       ${map.EGA.EG10BJ03?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">本期事业结转结余</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ04??>
                       ${map.EGA.EG10BJ04?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">事业类收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ05??>
                       ${map.EGA.EG10BJ05?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">事业收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ06??>
                       ${map.EGA.EG10BJ06?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">上级补助收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ07??>
                       ${map.EGA.EG10BJ07?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">附属单位上缴收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ08??>
                       ${map.EGA.EG10BJ08?string(',###')}
                   <#else >
                   </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd">其他收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ09??>
                       ${map.EGA.EG10BJ09?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">（其他收入科目下）捐赠收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ10??>
                       ${map.EGA.EG10BJ10?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">事业类支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ11??>
                       ${map.EGA.EG10BJ11?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">事业支出（非财政补助支出）</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ12??>
                       ${map.EGA.EG10BJ12?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">上缴上级支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ13??>
                       ${map.EGA.EG10BJ13?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">对附属单位补助支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ14??>
                       ${map.EGA.EG10BJ14?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">其他支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ15??>
                       ${map.EGA.EG10BJ15?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">本期经营结余</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ16??>
                       ${map.EGA.EG10BJ16?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">经营收入</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ17??>
                       ${map.EGA.EG10BJ17?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">经营支出</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ18??>
                       ${map.EGA.EG10BJ18?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">弥补以前年度亏损后的经营结余</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ19??>
                       ${map.EGA.EG10BJ19?string(',###')}
                   <#else >
                   </#if>
                </td>
                <td class="labeltd">本年非财政补助结转结余</td>
                <td class="datatd-number">
                  <#if map.EGA.EG10BJ20??>
                      ${map.EGA.EG10BJ20?string(',###')}
                  <#else >
                  </#if>
                 </td>
            </tr>
            <tr>
                <td class="labeltd">非财政补助结转</td>
                <td class="datatd-number">
                  <#if map.EGA.EG10BJ21??>
                      ${map.EGA.EG10BJ21?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">本年非财政补助结余</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ22??>
                       ${map.EGA.EG10BJ22?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">应缴企业所得税</td>
                <td class="datatd-number">
                  <#if map.EGA.EG10BJ23??>
                      ${map.EGA.EG10BJ23?string(',###')}
                  <#else >
                  </#if>
                </td>
                <td class="labeltd">提取专用基金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ24??>
                       ${map.EGA.EG10BJ24?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
            <tr>
                <td class="labeltd">转入事业基金</td>
                <td class="datatd-number">
                   <#if map.EGA.EG10BJ25??>
                       ${map.EGA.EG10BJ25?string(',###')}
                   <#else >
                   </#if>
                </td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">评级信息</legend>
        <table class="mainTable">
            <tr>
                <td class="labeltd">评级信息编号</td>
                <td class="datatd">${map.EHA.EH010I01!}</td>
                <td class="labeltd">评级机构名称</td>
                <td class="datatd">${map.EHA.EH010Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">评级日期</td>
                <td class="datatd">${map.EHA.EH010R01!}</td>
                <td class="labeltd">评级结果</td>
                <td class="datatd">${map.EHA.EH010D01!}</td>
            </tr>
        </table>
    </fieldset>

    <fieldset>
        <legend align="center">声明及标注信息</legend>
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
                <td class="labeltd">标注或声明内容</td>
                <td class="datatd">${map.EIA.EI010Q01!}</td>
            </tr>
            <tr>
                <td class="labeltd">添加日期</td>
                <td class="datatd">${map.EIA.EI010R01!}</td>
            </tr>
        </table>
    </fieldset>
    <input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/>
</div>
</body>

</html>