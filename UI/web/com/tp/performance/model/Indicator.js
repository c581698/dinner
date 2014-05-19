Ext.define("com.tp.performance.model.Indicator",{
	extend : "com.dh.model.Model",
	idProperty : "indicatorId",
	fields : [{
		name : "indicatorId",
		type : "int"
	},{
		name : "title",
		type : "string"
	},{
		name : "preIndId",
		type : "int"
	},{
		name : "preIndName",
		type : "string"
	},{
		name : "indData",
		type : "int"
	},{
		name : "indDate",
		type : "string",
		dateReadFormat : "Y-m-d H:i:s"
	},{
		name : "state",
		type : "int"
	},{
		name : "description",
		type : "string"
	},{
		name : "improvement",
		type : "string"
	},{
		name : "reason",
		type : "string"
	},{
		name : "comment",
		type : "string"
	},{
		name : "createDate",
		type : "date"
	},{
		name : "creator",
		type : "string"
	},{
		name : "updated",
		type : "int"
	},{
		name : "updatedDate",
		type : "date"
	}]
});