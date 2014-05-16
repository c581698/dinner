Ext.define("com.tp.performance.view.PerIndicatorTree",{
	extend : "com.dh.view.Tree",
	rootVisible : false,
	
	constructor : function(){
		var me = this;
		
		me.store = Ext.create("com.tp.performance.store.PerIndicator",{
			autoLoad : true
		});
		
		me.root = {
		    expanded: true,
		    perIndID : 0,
		    perIndName: "Root"
		};
		
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
			handler : function(){
				Ext.create('widget.window',{
					layout : 'fit',
					title : "指标详细",
					modal : true,
					width : 500,
					height : 350,
					//items : Ext.create('com.tp.performance.view.PerIndicatorForm')
					items : [{
						xtype : 'form',
						defaults : {
							xtype : 'textfield',
							columnWidth : .5,
							anchor : '50%',
							fieldLabel : {
								
							},
							labelWidth  : 55
						},
						items : [{
							fieldLabel : '指标名称',
							name : 'perIndName',
							allowBlank : false,
							maxLength : 100
						},{
							fieldLabel : '权重',
							xtype : 'numberfield',
							name : 'weight',
							maxValue : 100,
							minValue : 0,
							value : 0
						},{
							fieldLabel : '考核值',
							xtype : 'numberfield',
							name : 'perIndScore',
							maxValue : 100,
							minValue : 0,
							value : 0,
							decimalPrecision : 3
						}]
					}]
				}).show();
			}
		},{
			text : '删除'
		},{
			text : '修改'
		},{
			text : '分配考核用户'
		},{
			text : '刷新'
		}];
		
		me.callParent(arguments);
	}
});