Ext.define("com.tp.performance.view.ProjectManagement", {
			extend : "com.dh.view.Grid",
			frame : true,
			alias: "widget.ProjectManagement",
			
			requires : ["Ext.ux.form.DateTimeField"],

			constructor : function() {
				var me = this;
				
				me.store = Ext.create('com.tp.performance.store.Indicator',{
					id :'pro'
				});
				
				me.store.load({
					params : {
						type : 3
					}
				});
				
				me.plugins = [{
							clicksToEdit : 1,
							ptype : 'cellediting'
						}];

				me.columns = [{
					text : '考核项目',
					flex : 1,
					width : 120,
					dataIndex : 'preIndName',
					hideable : false,
					field : {
						xtype : 'combo',
						store : [['重点项目计划达成率','重点项目计划达成率'],['监管项目计划达成率','监管项目计划达成率'],
							['其他项目计划达成率','其他项目计划达成率'],['需求累计完成率','需求累计完成率']
							,['单位工作量开发缺陷数','单位工作量开发缺陷数']]
					}
				}, {
					header : '当前值',
					width : 75,
					dataIndex : 'indData'
				},{
					header : '考核时间',
					width : 80,
					sortable : true,
					dataIndex : 'indDate',
					//renderer : Ext.util.Format.dateRenderer('Y-m-d'),
					field : {
						allowBlank : false,
						format : "Y-m-d",
						xtype : 'datefield'
					}
				}, {
					header : '创建者',
					sortable : true,
					dataIndex : 'creator'
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