Ext.onReady(function(){
	Ext.getDoc().on("contextmenu", function(e){   
	    e.stopEvent();   
	}); 
	
	Ext.tip.QuickTipManager.init();
	
	Ext.Loader.setConfig({
		enabled: true,
		paths: {
			'Ext': 'ext-4.2.1/src',
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
					height : 600,
					width : 1000,
					layout : 'fit',
					items : Ext.create("com.tp.performance.view.PerIndicatorTree")
				}).show();
			}
		},{
			text : '指标数据',
			handler : function(){
				Ext.create("widget.window",{
					title : '指标数据',
					height : 600,
					width : 1000,
					layout : 'fit',
					items : Ext.create("com.tp.performance.view.IndicatorPanel")
				}).show();
			}
		},{
			text : '统计',
			handler : function(){
				Ext.create("widget.grid",{
					title : '统计',
					width : 1000,
					height : 600,
					//headerPosition : 'left',
					columns : [{
						text : '关键业务无故障运行率数据'
					}]
				});
			}
		}]
	}).show();
});