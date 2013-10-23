<#compress>
Ext.define("com.tp.view<#if filePath!="">.${filePath}</#if>.${name}View",{
	extend : "com.tp.app.BaseGrid",
	requires : ["com.tp.store.${name}"],
	title : "${name}",
	
	constructor : function(){
		var me = this;
		
		me.columns = [
			<#list columns as col>
			{
			dataIndex:"${col.name}",
			header : "${col.desc}"
			}
			<#if col_has_next>
				,
			</#if>
		</#list>
		];
		me.store = Ext.create("com.tp.store.${name}");
		
		me.callParent(arguments);
	}
});
</#compress>