Ext.define("com.tp.performance.model.Statistics",{
	extend : "com.dh.model.Model",
	idProperty : "name",
	fields : [{
		name : "statId",
		type : "int"
	},{
		name : "preIndName",
		type : "string"
	},{
		name : "indName",
		type : "string"
	},{
		name : "perIndScore",
		type : "float"
	},{
		name : "exectime",
		type : "int"/*,
		convert : getRes*/
	},{
		name : "operRate",
		type : "float"/*,
		convert : getRate
		//defaultValue : 10
*/	},{
		name : "hours",
		type : "int"
	},{
		name : "days",
		type : "int"
	},{
		name : "downtime",
		type : "int"
	}]
});

function getRate(v,rec){
	return parseFloat(Ext.util.Format.number(((rec.get('exectime') * 60 - rec.get('downtime')) / (rec.get('exectime') * 60)) * 100,'0.00'));
	//return parseFloat(Ext.util.Format.number(((rec.get('exectime') * 60 - rec.get('downtime')) / (rec.get('exectime') * 60)),'0.00'));
}

function getRes(v,rec){
	var hours = rec.get('hours'),
		days = rec.get('days');
		
	if(hours == 0 || days == 0){
		return 0;
	}else{
		return hours * days;
	}
}