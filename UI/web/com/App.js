Ext.onReady(function(){
	Ext.Loader.setConfig({
		enabled: true,
		paths: {
			'Ext': 'ext-4.2.1',
			'com': 'com'
		}
	});
	
	Ext.create("widget.menu",{
		renderTo : Ext.getBody(),
		items : [{
			text : '指标分类',
			handler : function(){
				Ext.create("widget.window",{
					title : '指标分类',
					height : 400,
					width : 300,
					items : Ext.create("com.tp.performance.view.PerIndicatorTree",{})
				});
			}
		},{
			text : '指标数据'
		}]
	}).show();
});