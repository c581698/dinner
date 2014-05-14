Ext.define("com.tp.performance.model.PerIndicator",{
	extend : "com.dh.model.TreeModel",
	
	fields : [{
		name : 'perIndID',
		type : 'int'
	},{
		name : 'perIndName',
		type : 'string'
	},{
		name : 'perIndType',	//指标类型，1、指标分类 2、指标项目
		type : 'int'
	},{
		name : 'perIndState',	//指标状态，1、正向 2、负向
		type : 'int'
	},{
		name : 'perInd',		//上级指标
		type : 'int'
	},{
		name : 'perIndScore',	//考核值
		type : 'float'
	},{
		name : 'warningA',		//预警值
		type : 'float'
	},{
		name : 'warningB',		//预警下限
		type : 'float'
	},{
		name : 'weight',		//权重
		type : 'float'
	}]
});