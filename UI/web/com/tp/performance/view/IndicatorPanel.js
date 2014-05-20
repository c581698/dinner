Ext.define("com.tp.performance.view.IndicatorPanel",{
	extend : "com.dh.view.Panel",
	layout : "border",
	height : 600,
	requires : ["com.tp.performance.view.PerIndicatorTree","Ext.ux.form.DateTimeField",
		"com.tp.performance.view.CoreBusiGrid","com.tp.performance.view.InfoSecu",
		"com.tp.performance.view.ProjectManagement"],
	
	constructor : function(){
		var me = this;
		
		me.items = [{
			xtype : 'form',
			region : 'north',
			layout : 'hbox',
			margin : 5,
			defaults : {
				padding : 5,
				labelWidth  : 60
			},
			items : [{
				xtype : 'pickerfield',
				fieldLabel : '指标名称 ',
				matchFieldWidth : false,
				width : 250,
				listeners : {
					collapse : {
						fn : function(field){
							if(!Ext.isEmpty(field.picker)){
								var records = field.picker.getSelectionModel().selected,
									_value = [],
									_text = [];
								
								if(records.getCount() > 0){
									records.each(function(item){
										_text.push(item.get('perIndName'));
										_value.push(item.get('perIndName'));
									});
									
									field._value = _value.toString();
									field._text  = _text.toString();
								}else{
									field._value = null;
									field._text  = null;
								}
								
								field.setRawValue(field._text);
							}
						}
					}
				},
				createPicker : function(){
					var me = this;
					
					return Ext.create('com.tp.performance.view.PerIndicatorTree',{
									isComp : true,
									width:200,
									floating:true,
									listeners : {
										beforeselect : {
											fn : function(sm,rec){
												if(sm.selected.getCount() == 0){
													sm.depth = null;
												}
												
												if(Ext.isEmpty(sm.depth)){
													sm.depth = rec.getDepth();
												}else if(sm.depth != rec.getDepth() ){
													return false;
												}
												
												return true;
											}
										}
									},
									minHeight : 250
								});
				}
			},{
				xtype : 'datefield',
				fieldLabel : '起始日期',
				format : 'Y-m-d'
			},{
				xtype : 'datefield',
				fieldLabel : '结束日期',
				format : 'Y-m-d'
			},{
				xtype : 'button',
				text : '查询',
				margin : '2 5',	
				iconCls : 'Zoom'
			},{
				xtype : 'button',
				text : '统计',
				margin : '2 5',	
				iconCls : 'Textlistnumbers',
				menu : {
					items : [{
						text : '按年份',
						iconCls : 'Year'
					},{
						text : '按月份',
						iconCls : 'Month'
					},{
						text : '按日期',
						iconCls : 'Day'
					}]
				}
			},{
				xtype : 'button',
				text : '功能',
				margin : '2 5',				
				iconCls : 'Action',
				menu : {
					maxWidth : 50,
					items :[{
						text : '新增',
						width : 40,
						iconCls : 'Add',
						iconCls : 'Lock'
					},{
						text : '删除',
						iconCls : 'Delete'
					}]
				}
			},{
				xtype : 'button',
				text : '状态',
				margin : '2 5',				
				iconCls : 'Arrowswitch',
				menu : {
					maxWidth : 50,
					items :[{
						text : '加锁',
						width : 40,
						iconCls : 'Lock'
					},{
						text : '解锁',
						iconCls : 'Lockopen'
					},{
						text : '确认',
						iconCls : 'Accept'
					}]
				}
			}]
		},{
			xtype : 'container',
			region : 'center',
			layout : 'fit',
			items : [{
				xtype : 'tabpanel',
				items : [{
					title : '关键业务系统无故障运行率',
					xtype : 'CoreBusiGrid'
				},{
					title : '信息安全',
					xtype : 'InfoSecu'
				},{
					title : '项目管理',
					xtype : 'ProjectManagement'
				}]
			}]
		}];

		me.callParent(arguments);
	}
});
