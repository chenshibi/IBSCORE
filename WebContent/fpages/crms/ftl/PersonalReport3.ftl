<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>二代个人信息核验</title>

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
    <h3 class="content_left" style="margin-left: 24px;"></h3>

    <h1>二代个人信息核验</h1>
    <h2>个人基本信息</h2>
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
        <tr>
            <td class="title_center" width="6%">编号(共${map.CR_PER_POM?size!}条)</td>
            <td class="title_center" colspan="4">单位电话</td>
            <td class="title_center" colspan="3">信息更新日期</td>
        </tr>
        <#list map.CR_PER_POM! as CR_PER_POM>
            <tr>
                <td class="content_center" colspan="1">${CR_PER_POM_index + 1!}</td>
                <td class="content_center" colspan="4">${CR_PER_POM.PB040Q03!}</td>
                <td class="content_center" colspan="3">${CR_PER_POM.PB040R02!}</td>
            </tr>
        </#list>
        <tr>
            <td class="title_center" width="6%">编号(共${map.CR_PER_PRM?size!}条)</td>
            <td class="title_center" colspan="4">住宅电话</td>
            <td class="title_center" colspan="3">信息更新日期</td>
        </tr>
        <#list map.CR_PER_PRM! as CR_PER_PRM>
            <tr>
                <td class="content_center" colspan="1">${CR_PER_PRM_index + 1!}</td>
                <td class="content_center" colspan="4">${CR_PER_PRM.PB030Q02!}</td>
                <td class="content_center" colspan="3">${CR_PER_PRM.PB030R01!}</td>
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
    
</div>
</body>
</html>