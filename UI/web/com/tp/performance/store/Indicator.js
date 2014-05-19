Ext.define("com.tp.performance.store.Indicator",{
	extend : "com.dh.store.Store",
	model : "com.tp.performance.model.Indicator",
	
	proxy : {
		type : 'ajax',
		url : 'listIndicatorsAction.action'
	},
	
	constructor : function(){
		var me = this;
		
		me.callParent(arguments);
	}
});