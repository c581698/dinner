Ext.define("com.tp.performance.view.PerIndicatorForm",{
	extend : "com.dh.view.Form",
	buttonAlign : "center",
	//title : "指标详细",

	constructor : function(){
		var me = this;
		
		
		me.items = [{
			xtype : 'tabpanel',
			header : false,
			defaults : {
				layout : 'column',
				xtype : 'form',
				defaults : {
					xtype : 'textfield',
					columnWidth : .5,
					padding : 5,
					fieldLabel : {
						
					},
					labelWidth  : 55
				}
			},
			items : [{
				title : '关键业务系统无故障运行率',
				items : [{
					fieldLabel : '指标ID',
					xtype : 'hidden',
					name : 'perIndID'
				},{
					fieldLabel : '父指标ID',
					xtype : 'hidden',
					name : 'parentId'
				},{
					fieldLabel : '指标分类',
					name : 'perentName',
					disabled : true
				},{
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
				},{
					fieldLabel : '指标类型',
					name : 'perIndType',
					xtype : 'radiogroup',
					allowBlank : false,
					items : [
						{ boxLabel: '指标分类', name: 'perIndType', inputValue: 1 },
            			{ boxLabel: '指标项目', name: 'perIndType', inputValue: 2 }
					]
				},{
					fieldLabel : '指标状态',
					name : 'perIndState',
					xtype : 'radiogroup',
					items : [
						{ boxLabel: '正向', name: 'perIndState',readOnly : true, inputValue: 1 , checked: true},
            			{ boxLabel: '负向', name: 'perIndState',readOnly : true, inputValue: 2}
					]
				},{
					fieldLabel : '预警值',
					xtype : 'fieldcontainer',
					layout : 'hbox',
					items : [{
						xtype : 'numberfield',
						width : 73,
						emptyText : '正常值',
						maxValue : 100,
						minValue : 0,
						name : 'warningA'
					},{
						xtype : 'label',
						margin: '5 10',
						text : ' ~ '
					},{
						xtype : 'numberfield',
						width : 73,
						emptyText : '异常值',
						maxValue : 100,
						minValue : 0,
						name : 'warningA'
					}]
				},{
					fieldLabel : '服务窗口时间',
					name : 'hours',
					xtype : 'numberfield',
					maxValue : 24,
					minValue : 1,
					allowBlank : false
				},{
					fieldLabel : '说明',
					name : 'description',
					columnWidth : 1,
					xtype : 'textarea',
					rows : 7,
					maxLength : 1000
				}]
			},{
				title : '信息安全',
				items : [{
					fieldLabel : '指标ID',
					xtype : 'hidden',
					name : 'perIndID'
				},{
					fieldLabel : '父指标ID',
					xtype : 'hidden',
					name : 'parentId'
				},{
					fieldLabel : '指标分类',
					name : 'perentName',
					disabled : true
				},{
					fieldLabel : '指标名称',
					name : 'perIndName',
					allowBlank : false,
					maxLength : 100
				},{
					fieldLabel : '考核值',
					xtype : 'numberfield',
					name : 'perIndScore',
					maxValue : 100,
					minValue : 0,
					value : 0,
					decimalPrecision : 3
				},{
					fieldLabel : '指标类型',
					name : 'perIndType',
					xtype : 'radiogroup',
					allowBlank : false,
					items : [
						{ boxLabel: '指标分类', name: 'perIndType', inputValue: 1 },
            			{ boxLabel: '指标项目', name: 'perIndType', inputValue: 2 }
					]
				},{
					fieldLabel : '指标状态',
					name : 'perIndState',
					xtype : 'radiogroup',
					items : [
						{ boxLabel: '正向', name: 'perIndState', readOnly : true,inputValue: 1 },
            			{ boxLabel: '负向', name: 'perIndState', readOnly : true,inputValue: 2 , checked: true}
					]
				},{
					fieldLabel : '预警值',
					xtype : 'fieldcontainer',
					layout : 'hbox',
					items : [{
						xtype : 'numberfield',
						width : 73,
						emptyText : '正常值',
						maxValue : 100,
						minValue : 0,
						name : 'warningA'
					},{
						xtype : 'label',
						margin: '5 10',
						text : ' ~ '
					},{
						xtype : 'numberfield',
						width : 73,
						emptyText : '异常值',
						maxValue : 100,
						minValue : 0,
						name : 'warningA'
					}]
				},{
					fieldLabel : '说明',
					name : 'description',
					columnWidth : 1,
					xtype : 'textarea',
					rows : 9,
					maxLength : 1000
				}]
			},{
				title : '项目管理',
				items : [{
					fieldLabel : '指标ID',
					xtype : 'hidden',
					name : 'perIndID'
				},{
					fieldLabel : '父指标ID',
					xtype : 'hidden',
					name : 'parentId'
				},{
					fieldLabel : '指标分类',
					name : 'perentName',
					disabled : true
				},{
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
				},{
					fieldLabel : '指标类型',
					name : 'perIndType',
					xtype : 'radiogroup',
					allowBlank : false,
					items : [
						{ boxLabel: '指标分类', name: 'perIndType', inputValue: 1 },
            			{ boxLabel: '指标项目', name: 'perIndType', inputValue: 2 }
					]
				},{
					fieldLabel : '指标状态',
					name : 'perIndState',
					xtype : 'radiogroup',
					items : [
						{ boxLabel: '正向', name: 'perIndState', inputValue: 1 , checked: true},
            			{ boxLabel: '负向', name: 'perIndState', inputValue: 2}
					]
				},{
					fieldLabel : '预警值',
					xtype : 'fieldcontainer',
					layout : 'hbox',
					items : [{
						xtype : 'numberfield',
						width : 73,
						emptyText : '正常值',
						maxValue : 100,
						minValue : 0,
						name : 'warningA'
					},{
						xtype : 'label',
						margin: '5 10',
						text : ' ~ '
					},{
						xtype : 'numberfield',
						width : 73,
						emptyText : '异常值',
						maxValue : 100,
						minValue : 0,
						name : 'warningA'
					}]
				},{
					fieldLabel : '说明',
					name : 'description',
					columnWidth : 1,
					xtype : 'textarea',
					rows : 7,
					maxLength : 1000
				}]
			}]
		}];
		
		me.buttons = [{
			text : '保存',
			iconCls : 'Databasesave'
		},{
			text : '重置',
			iconCls :'Databasestart'
		}];
		
		me.callParent(arguments);
	}
});