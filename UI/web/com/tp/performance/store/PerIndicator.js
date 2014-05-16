Ext.define("com.tp.performance.store.PerIndicator",{
	extend : "com.dh.store.TreeStore",
	model : "com.tp.performance.model.PerIndicator",
	
	proxy : {
		type : 'ajax',
		url : 'listIndexsAction.action'
	},
	
	constructor : function(){
		var me = this;
		
		me.callParent(arguments);
	}
});