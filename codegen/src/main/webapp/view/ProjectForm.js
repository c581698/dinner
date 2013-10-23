Ext.define("com.tp.view.ProjectForm",{
	extend : "com.tp.app.BaseForm",
	
	constructor : function(){
		var me = this;
		
		me.items = [
			{
			name:"projectId"
				,xtype : 'numberfield'
,allowBlank : 
				false
				,tooltip : "??ID???"
			}
				,
			{
			name:"projectName"
				,xtype : 'textfield'
				,maxLength : 75
,allowBlank : 
				false
				,tooltip : "????"
			}
				,
			{
			name:"projectType"
				,xtype : 'numberfield'
,allowBlank : 
				false
				,tooltip : "1为专属项目，2为共享项目"
			}
				,
			{
			name:"managerOrgan"
				,xtype : 'numberfield'
,allowBlank : 
				false
				,tooltip : "管控单位"
			}
				,
			{
			name:"year"
				,xtype : 'numberfield'
,allowBlank : 
				false
				,tooltip : "????"
			}
				,
			{
			name:"capitalAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "?????(??????)"
				,value:0 
			}
				,
			{
			name:"expenseAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "?????(??????)"
				,value:0 
			}
				,
			{
			name:"costOwnership"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "??????"
			}
				,
			{
			name:"memo"
				,xtype : 'textfield'
				,maxLength : 1548
,allowBlank : 
				true
				,tooltip : "????"
			}
				,
			{
			name:"dept"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "????"
			}
				,
			{
			name:"budgetId"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "????"
			}
				,
			{
			name:"startDate"
				,xtype : 'textfield'
				,maxLength : 45
,allowBlank : 
				true
				,tooltip : "项目开始时间"
			}
				,
			{
			name:"projectAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "项目预算总金额"
				,value:0 
			}
				,
			{
			name:"hardAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "硬件总金额"
				,value:0 
			}
				,
			{
			name:"softAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "软件总金额"
				,value:0 
			}
				,
			{
			name:"devAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "开发实施总金额"
				,value:0 
			}
				,
			{
			name:"projectNature"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "项目性质"
			}
				,
			{
			name:"hasOverYearProject"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "是否历年延续项目"
				,value:0

			}
				,
			{
			name:"created"
				,xtype : 'datefield'
			,allowBlank : 
				true
				,tooltip : "创建时间"
			}
				,
			{
			name:"updatedDate"
				,xtype : 'datefield'
			,allowBlank : 
				true
				,tooltip : "更新时间"
			}
				,
			{
			name:"updatePerson"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "更新人(人员ID)"
			}
				,
			{
			name:"organ"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "管控单位(原始保留字段)"
			}
				,
			{
			name:"editOrgan"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "编制单位"
			}
				,
			{
			name:"creator"
				,xtype : 'numberfield'
,allowBlank : 
				true
				,tooltip : "创建人(人员ID)"
			}
				,
			{
			name:"thisYearCapitalAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "当年资本性金额"
				,value:0 
			}
				,
			{
			name:"thisYearExpenseAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "当年费用性金额"
				,value:0 
			}
				,
			{
			name:"thisYearTotalAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "当年总金额"
				,value:0 
			}
				,
			{
			name:"nextYearCapitalAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "明年资本性金额"
				,value:0 
			}
				,
			{
			name:"nextYearExpenseAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "明年费用性金额"
				,value:0 
			}
				,
			{
			name:"nextYearTotalAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "明年总金额"
				,value:0 
			}
				,
			{
			name:"afterNextYearCapitalAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "明年以后资本性金额"
				,value:0 
			}
				,
			{
			name:"afterNextYearExpenseAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "明年以后费用性金额"
				,value:0 
			}
				,
			{
			name:"afterNextYearTotalAmt"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "明年以后总金额"
				,value:0 
			}
				,
			{
			name:"usedCapital"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "已执行资本性预算"
				,value:0 
			}
				,
			{
			name:"usedExpense"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "已执行费用性预算"
				,value:0 
			}
				,
			{
			name:"projectCode"
				,xtype : 'textfield'
				,maxLength : 10
,allowBlank : 
				true
				,tooltip : "项目编码"
			}
				,
			{
			name:"isMiddleYearChange"
				,xtype : 'numberfield'
,allowBlank : 
				false
				,tooltip : "是否年中调整,0为编制,1为调整,2为调整时新增,3.编制后的不定时调整时新增,4.调整后的不定时调整时新增"
				,value:0 
			}
				,
			{
			name:"endDate"
				,xtype : 'textfield'
				,maxLength : 45
,allowBlank : 
				true
				,tooltip : "项目结束时间"
			}
				,
			{
			name:"responsibilityPerson"
				,xtype : 'textfield'
				,maxLength : 45
,allowBlank : 
				true
				,tooltip : "责任人"
			}
				,
			{
			name:"overYearHardUsed"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "历年已付硬件费用"
				,value:0 
			}
				,
			{
			name:"overYearSoftUsed"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "历年已付软件费用"
				,value:0 
			}
				,
			{
			name:"overYearDevUsed"
				,xtype : 'numberfield'
				,decimaPrecision:col.precision
,allowBlank : 
				false
				,tooltip : "历年已付开发实施费用"
				,value:0 
			}
				,
			{
			name:"status"
				,xtype : 'numberfield'
,allowBlank : 
				false
				,tooltip : "项目状态(
1	编制中
2	编制审核
3	年中调整
4	调整审核
5	已上报待批复
6	已批复
7	已关账)"
				,value:0

			}
				,
			{
			name:"costOwnershipType"
				,xtype : 'textfield'
				,maxLength : 10
,allowBlank : 
				true
				,tooltip : "共享中心子级机构名称"
			}
				,
			{
			name:"classifyId"
				,xtype : 'numberfield'
,allowBlank : 
				false
				,tooltip : "项目分类编号"
				,value:3

			}
				,
			{
			name:"arrivalTime"
				,xtype : 'textfield'
				,maxLength : 45
,allowBlank : 
				true
				,tooltip : "采购到货时间"
			}
	];
		
		me.callParent(arguments);
	}
});
