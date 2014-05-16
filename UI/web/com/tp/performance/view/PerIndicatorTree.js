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
				iconCls : 'Grouplink'
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