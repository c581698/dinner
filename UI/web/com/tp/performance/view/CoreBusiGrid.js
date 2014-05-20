Ext.define("com.tp.performance.view.CoreBusiGrid", {
			extend : "com.dh.view.Grid",
			frame : true,
			alias: "widget.CoreBusiGrid",
			
			requires : ["Ext.ux.form.DateTimeField"],

			constructor : function() {
				var me = this;

				me.plugins = [{
							clicksToEdit : 1,
							ptype : 'cellediting'
						}];

				me.features = [{
							ftype : 'groupingsummary',
							groupHeaderTpl : '{name}',
							hideGroupedHeader : true,
							enableGroupingMenu : false
						}];

				me.store = Ext.create('com.tp.performance.store.Indicator',{
					groupField: 'preIndName'
				});
				
				me.store.load({
					params : {
						type : 1
					}
				});
				
				me.columns = [{
					text : '故障',
					flex : 1,
					width : 120,
					dataIndex : 'title',
					hideable : false,
					summaryType : 'count',
					summaryRenderer : function(value, summaryData, dataIndex) {
						return  '(' + value + '项)';
					},
					field : {
						xtype : 'textfield',
						allowBlank : false,
						maxLength : 300
					}
				}, {
					header : '故障时长(分钟)',
					width : 85,
					sortable : true,
					dataIndex : 'indData',
					summaryType : 'sum',
					summaryRenderer : function(value, summaryData, dataIndex) {
						return  '(' + value + '分钟)';
					},
					field : {
						xtype : 'numberfield',
						minValue : 0,
						allowBlank : false,
						maxValue : 999999
					}
				}, {
					header : '故障发生时间',
					width : 120,
					sortable : true,
					dataIndex : 'indDate'/*,
					renderer : Ext.util.Format.dateRenderer('Y-m-d H:m:s'),
					field : {
						allowBlank : false,
						format : "Y-m-d H:m:s",
						xtype : 'datefield'
					}*/
				}, {
					header : '创建者',
					width : 75,
					sortable : true,
					dataIndex : 'creator'
				}, {
					header : '故障描述',
					width : 130,
					dataIndex : 'description',
					field : {
						xtype : 'textarea',
						maxLength : 1000
					}
				}, {
					header : '故障原因',
					width : 130,
					dataIndex : 'reason',
					field : {
						xtype : 'textarea',
						maxLength : 1000
					}
				}, {
					header : '改进措施',
					width : 130,
					dataIndex : 'improvement',
					field : {
						xtype : 'textarea',
						maxLength : 1000
					}
				}, {
					header : '备注',
					width : 130,
					dataIndex : 'comment',
					field : {
						xtype : 'textarea',
						maxLength : 1000
					}
				},{
					header : '状态',
					width : 50,
					dataIndex : 'state',
					renderer : function(value){
						if(!Ext.isEmpty(value)){
							switch (value){
								case 1:return '草稿';
								case 2:return '锁定';
								case 3:return '确认';
							}
						}
					}
				}];

				me.callParent(arguments);
			}
		});
