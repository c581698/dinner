<#compress>
Ext.define("com.tp.model<#if filePath!="">.${filePath}</#if>.${name}",{
	extend : "com.tp.app.BaseModel",
	fields : [
		<#list columns as col>
			"${col.name}"<#if col_has_next>,</#if>
		</#list>
	]
});
</#compress>