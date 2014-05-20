Ext.define("com.tp.performance.view.PerIndicatorTree",{
	extend : "com.dh.view.Tree",
	rootVisible : false,
	alias: "widget.PerIndicatorTree",
	
	isComp : false,//是否作为组件创建
	
	constructor : function(){
		var me = this;
		
		Ext.apply(me,arguments[0]);
		
		me.store = Ext.create("com.tp.performance.store.PerIndicator",{
			autoLoad : true
		});
		
		me.root = {
		    expanded: true,
		    perIndID : 0,
		    perIndName: "Root"
		};
		
		if(!me.isComp){
			me.columns = [{
				xtype: 'treecolumn',
				text : '指标名称',
				width : 360,
				dataIndex : 'perIndName'
			},{
				text : '权重',
				width : 60,
				align : 'center',
				dataIndex : 'weight',
				renderer : function(val,md,rec){
					if(rec.get('perIndType') == 2){
						return '';
					}else{
						return val;
					}
				}
			},{
				text : '考核值',
				width : 100,
				dataIndex : 'perIndScore',
				renderer : function(val,md,rec){
					if(rec.get('perIndType') == 2){
						return '';
					}else{
						return val;
					}
				}
			},{
				text : '预警值',
				width : 60,
				renderer : function(val,md,rec){
					var A = rec.get('warningA'),
						B = rec.get('warningB');
					
					if(A != 0 && B != 0){
						return A+'~'+B;
					}else{
						return '';
					}
				}
			},{
				text : '服务窗口时间',
				dataIndex : 'hours',
				renderer : function(val,md,rec){
					if(rec.get('hours') == 0){
						return '';
					}else{
						return val;
					}
				}
			},{
				text : '考核用户',
				dataIndex : 'users',
				width : 200,
				renderer : function(val,md,rec){
					if(rec.get('perIndType') != 2){
						return '';
					}else{
						return val;
					}
				}
			}];
			
			me.tbar = [{
				text : '新增',
				iconCls : 'Add',
				handler : function(){
					Ext.create('widget.window',{
						layout : 'fit',
						title : "指标详细",
						modal : true,
						width : 500,
						height : 350,
						items : Ext.create('com.tp.performance.view.PerIndicatorForm')
					}).show();
				}
			},{
				text : '删除',
				iconCls : 'Delete'
			},{
				text : '修改',
				iconCls : 'Overlays'
			},{
				text : '分配考核用户',
				iconCls : 'Grouplink',
				handler : function(){
					Ext.widget('window',{
							title : '用户选择器',
							height : 300,
							width : 210,
							layout : 'border',
							modal : true,
							items : [{
									xtype : 'form',
									margin : 5,
									region : 'north',
									items : [{
										xtype : 'textfield',
										labelWidth : 30,
										fieldLabel : '查询',
										emptyText : '根据用户名查询'
									}]
								},{
							    xtype : 'treepanel',
							   	region : 'center',
							    store: Ext.create('Ext.data.TreeStore', {
								    root: {
								        expanded: true,
								        children: [{
											id : 2,
											text : '太平人寿',
											checked : false,
											children : [{
												id : 3,
												text : '太平人寿总公司',
												checked : false,
												children : []
											}]
										},{
											id : 4,
											text : '太平英国',
											checked : false,
											children : [{
												id : 5,
												text : '太平人寿总公司',
												checked : false,
												children : []
											}]
										},{
											id : 6,
											text : '太平物业及龙壁',
											checked : false,
											children : [{
												id : 7,
												checked : false,
												text : '太平人寿总公司',
												children : []
											}]
										},{
											id : 8,
											text : '太平欧洲',
											checked : false,
											children : [{
												id : 9,
												text : '太平人寿总公司',
												children : []
											}]
										},{
											id : 10,
											text : '太平置业',
											checked : false,
											children : [{
												id : 11,
												text : '太平人寿总公司',
												children : []
											}]
										},{
											id : 12,
											text : '太平财险',
											checked : false,
											children : [{
												id : 13,
												text : '太平人寿总公司',
												children : []
											}]
										},{
											id : 14,
											text : '共享中心',
											checked : false,
											children : [{
												id : 15,
												text : '共享中心总公司',
												checked : false,
												children : [{
													id : 100,
													checked : false,
													text : '流程规划部',
													children : [{
														id : 104,
														checked : false,
														text : '预算编制室',
														children : [{
															id : 110,
															text : 'test',
															checked : false,
															children : []
														},{
															id : 111,
															text : 'test2',
															checked : false,
															children : []
														},{
															id : 112,
															text : 'test27',
															checked : false,
															children : []
														},{
															id : 113,
															checked : false,
															text : 'test4',
															children : []
														}]
													},{
														id : 105,
														checked : false,
														text : '项目管理室',
														children : []
													},{
														id : 106,
														text : '经理室',
														checked : false,
														children : []
													}]
												},{
													id : 101,
													text : '项目三部',
													checked : false,
													children : []
												},{
													id : 102,
													checked : false,
													text : '项目四部',
													children : []
												}]
											}]
										}]
								    }
								}),
							    rootVisible: false
							}]
						}).show();
				}
			},{
				text : '刷新',
				iconCls : 'Pagewhiterefresh'
			}];
		}else{
			me.columns = [{
				xtype: 'treecolumn',
				text : '指标名称',
				width : 360,
				dataIndex : 'perIndName'
			}];

			me.selModel = {
				selection: 'treemodel',
				mode : 'SIMPLE'
			};
		}
		
		me.callParent(arguments);
	}
});