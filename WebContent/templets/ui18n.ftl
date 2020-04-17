<#ftl strip_whitespace=true>
<#macro message code>
	<#assign ui18n_value = statics["com.huateng.ebank.business.common.MessageResourceUtil"].getMessage(code)>
	${ui18n_value}
</#macro>