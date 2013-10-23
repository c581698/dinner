<#compress>
Ext.define("com.tp.store<#if filePath!="">.${filePath}</#if>.${name}",{
	extend : "com.tp.app.BaseStore",
	requires : ["com.tp.model.${name}"],
	model : "com.tp.model.${name}",
	
	proxy : {
		type : 'ajax',
		url : APP_CONTEXT_PATH+'/list${name}.action'
	}
});
</#compress>