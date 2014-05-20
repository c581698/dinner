Ext.define("com.tp.performance.store.Statistics",{
	extend : "com.dh.store.Store",
	model : "com.tp.performance.model.Statistics",
	
	proxy : {
		type : 'ajax',
		url : 'listStatAction.action'
	},
	
	constructor : function(){
		var me = this;
		
		me.callParent(arguments);
	}
});