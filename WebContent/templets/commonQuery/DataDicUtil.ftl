<#function getDataDic dataTypeNo dataNo="" >
    <#if dataNo="">
        <#return ""/>
    </#if>
    <#assign value = statics["com.huateng.ebank.business.common.DataDicUtils"].getDicName(dataTypeNo, dataNo)>
    <#return value/>
</#function>

<#function getPoint money="" >
    <#if money="">
        <#return ""/>
    </#if>
    <#assign value = statics["com.huateng.report.utils.MoneyPointUtil"].getPoint(money)>
    <#return value/>
</#function>