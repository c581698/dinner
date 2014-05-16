Ext.define("com.tp.performance.view.IndicatorPanel",{
	extend : "com.dh.view.Panel",
	layout : "border",
	requires : ["com.tp.performance.view.PerIndicatorTree","Ext.ux.form.DateTimeField"],
	
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
			}]
		},{
			xtype : 'container',
			region : 'center',
			layout : 'fit',
			items : [{
				xtype : 'tabpanel',
				items : [{
					title : '关键业务系统无故障运行率'
				},{
					title : '信息安全'
				},{
					title : '项目管理'
				}]
			}]
		}];
		
		me.callParent(arguments);
	}
});