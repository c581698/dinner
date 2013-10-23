<#setting number_format="0.##">
Ext.define("com.tp.view<#if filePath!="">.${filePath}</#if>.${name}Form",{
	extend : "com.tp.app.BaseForm",
	
	constructor : function(){
		var me = this;
		
		me.items = [
		<#list columns as col>
			{
			name:"${col.name}"
			<#if col.type == 12>
				,xtype : 'textfield'
				,maxLength : ${col.size/2}
			</#if>
			<#if col.type == 3>
				,xtype : 'numberfield'
				<#if col.precision != 0>
				,decimaPrecision:col.precision
				</#if>
			</#if>
			<#if col.type == 93>
				,xtype : 'datefield'
			</#if>,allowBlank : 
			<#if col.allowBlank == 0>
				false
			<#else>
				true
			</#if>
			<#if (col.desc)??>
				,tooltip : "${col.desc}"
			</#if>
			<#if (col.default)??>
				,value:${col.default}
			</#if>
			}
			<#if col_has_next>
				,
			</#if>
		</#list>
	];
		
		me.callParent(arguments);
	}
});
