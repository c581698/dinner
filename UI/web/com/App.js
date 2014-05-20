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
				Ext.define('Task', {
				    extend: 'Ext.data.Model',
				    idProperty: 'taskId',
				    fields: [
				        {name: 'projectId', type: 'int'},
				        {name: 'project', type: 'string'},
				        {name: 'taskId', type: 'int'},
				        {name: 'description', type: 'string'},
				        {name: 'estimate', type: 'float'},
				        {name: 'rate', type: 'float'},
				        {name: 'due', type: 'date', dateFormat:'m/d/Y'}
				    ]
				});

				Ext.require("com.tp.performance.model.Statistics");
				
var store = Ext.create('com.tp.performance.store.Statistics', {
        autoLoad : true,
        groupField: 'preIndName'
    });

    var datatip = Ext.create('Ext.ux.DataTip', {
        tpl: 'Click to edit {description}'
    });
    var showSummary = true;
    var grid = Ext.create('Ext.grid.Panel', {
        width: 1000,
        height: 650,
        frame: true,
        titleAlign : 'center',
        title: '关键业务系统无故障运行率数据(2014-1-10 ~ 2014-02-10)',
        renderTo: document.body,
        columnLines : true,
        store: store,
        plugins: [
        ],
        listeners: {
            beforeshowtip: function(grid, tip, data) {
                var cellNode = tip.triggerEvent.getTarget(tip.view.getCellSelector());
                if (cellNode) {
                    data.colName = tip.view.headerCt.columnManager.getHeaderAtIndex(cellNode.cellIndex).text;
                }
            }
        },
        features: [{
            id: 'group',
            ftype: 'groupingsummary',
            groupHeaderTpl: '{name}',
            hideGroupedHeader: true,
            enableGroupingMenu: false
        }, {
            ftype: 'summary',
            dock: 'bottom'
        }],
        columns: [{
            text: '考核项目',
            width: 300,
            locked: true,
            tdCls: 'task',
            sortable: true,
            dataIndex: 'indName',
            hideable: false,
            summaryType: 'count',
            summaryRenderer: function(value) {
				if(value > 10){
					return '总计';
				}else if(value < 10){
					return '小计';
				}
            }
        }, {
        	header : '考核值',
        	dataIndex : 'perIndScore'
        },{
            header: '系统无故障运行率',
            dataIndex : 'operRate',
            summaryType: 'count',
            renderer : function(value,md){
            	if(value < 99.9 && value > 99.5){
            		md.style = 'background-color: yellow';
            	}else if(value < 99.5){
            		md.style = 'background-color: red';
            	}
            	
            	return value;
            },
            summaryRenderer: function(value, summaryData, rec) {
                var comput = Ext.util.Format.number(((rec.get('exectime') * 60 - rec.get('downtime')) / (rec.get('exectime') * 60)) * 100,'0.00');
                
                return comput;
            }
        }, {
            header: '总运行时间(小时)',
            dataIndex : 'exectime',
            summaryType: 'sum'
        }, {
            header: '服务窗口时间(小时)',
            width : 200,
            dataIndex : 'hours'
        },{
            header: '总计天数',
            dataIndex : 'days',
            summaryType: 'sum'
        }, {
            header: '累计故障时间(分钟)',
            width : 200,
            dataIndex : 'downtime',
            summaryType: 'sum'
        }]
    });
			}
		},{
			text : '信息安全',
			handler : function(){
				var store = Ext.create("Ext.data.Store",{
						groupField: 'preIndName',
						data : [{
							indName : '客户信息丢失',
							preIndName : '信息安全',
							perIndScore : 0,
							operRate : 1
						},{
							indName : '财务系统信息丢失',
							preIndName : '信息安全',
							perIndScore : 0,
							operRate : 0
						},{
							indName : '关键业务系统服务连续中断',
							preIndName : '信息安全',
							perIndScore : 0,
							operRate : 1
						},{
							indName : '呼叫中心系统服务连续中断',
							preIndName : '信息安全',
							perIndScore : 0,
							operRate : 0
						},{
							indName : '财务系统服务连续中断',
							preIndName : '信息安全',
							perIndScore : 0,
							operRate : 0
						}],
						fields : [{
							name : 'indName'
						},{
							name : 'preIndName'
						},{
							name : 'perIndScore'
						},{
							name : 'operRate'
						}]
					});
				
				var grid = Ext.create('Ext.grid.Panel', {
				        width: 500,
				        height: 200,
				        frame: true,
				        titleAlign : 'center',
				        title: '信息安全数据统计数据(2014-01 ~ 2014-04)',
				        renderTo: document.body,
				        columnLines : true,
				        store: store,
				        plugins: [
				        ],
				        features: [/*{
				            id: 'group',
				            ftype: 'groupingsummary',
				            groupHeaderTpl: '{name}',
				            hideGroupedHeader: true,
				            enableGroupingMenu: false
				        }, */{
				            ftype: 'summary',
				            dock: 'bottom'
				        }],
				        columns: [{
				            text: '考核项目',
				            width: 300,
				            locked: true,
				            tdCls: 'task',
				            sortable: true,
				            dataIndex: 'indName',
				            hideable: false,
				            summaryType: 'count',
				            summaryRenderer: function(value) {
				                return '总计';
				            }
				        }, {
				        	header : '考核值',
				        	dataIndex : 'perIndScore'
				        },{
				            header: '当期累积',
				            dataIndex : 'operRate',
				            summaryType: 'count',
				            renderer : function(value,md){
				            	if(value > 0){
				            		md.style = 'background-color: red';
				            	}
				            	
				            	return value;
				            },
				            summaryRenderer: function(value, summaryData, rec) {
				                return value;
				            }
				        }]
				    });
			}
		},{
			text : '项目',
			handler : function(){
				Ext.create("Ext.grid.Panel",{
						renderTo : Ext.getBody(),
						width : 800,
						title : '项目管理考核数据(2014-01 ~ 2014-05)',
						titleAlign : 'center',
						height : 200,
						forceFit  : true,
						store : Ext.create('Ext.data.Store',{
							fields : ['month','data1','data2','data3','data4','data5'],
							data : [{
								month : '一月',
								data1 : 99.95,
								data2 : 99.91,
								data3 : 97.90,
								data4 : 96.93,
								data5 : 9.12
							},{
								month : '二月',
								data1 : 99.84,
								data2 : 97.97,
								data3 : 94.42,
								data4 : 91.95,
								data5 : 5.42
							},{
								month : '三月',
								data1 : 100,
								data2 : 100,
								data3 : 100,
								data4 : 100,
								data5 : 0
							},{
								month : '四月',
								data1 : 99.98,
								data2 : 99.97,
								data3 : 99.95,
								data4 : 99.93,
								data5 : 7.72
							},{
								month : '五月',
								data1 : 92.99,
								data2 : 92.95,
								data3 : 91.97,
								data4 : 97.94,
								data5 : 1.72
							}]
						}),
						columns : [{
							text : '日期',
							dataIndex : 'month'
						},{
							text : '重点项目计划达成率',
							dataIndex : 'data1'
						},{
							text : '监管项目计划达成率',
							dataIndex : 'data2'
						},{
							text : '其他项目计划达成率',
							dataIndex : 'data3',
							renderer : function(val,md){
								if(val < 92){
									md.style = 'background-color:red';
								}else if(val > 92 && val < 96){
									md.style = 'background-color:yellow';
								}
								
								return val;
							}
						},{
							text : '需求累计完成率',
							dataIndex : 'data4'
						},{
							text : '单位工作量开发缺陷数',
							dataIndex : 'data5'
						}]
					}).show();
			}
		}]
	}).show();
});
