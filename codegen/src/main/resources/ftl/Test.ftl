<#list columns as col>
${col.type}
	<#switch col.type>
		<#case 3>
		<#assign fieldType="asdfadf">
	</#switch>
	${fieldType}
</#list>