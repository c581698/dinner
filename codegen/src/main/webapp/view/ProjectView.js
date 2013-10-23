Ext.define("com.tp.view.ProjectView",{
extend : "com.tp.app.BaseGrid",
requires : ["com.tp.store.Project"],
title : "Project",
constructor : function(){
var me = this;
me.columns = [
{
dataIndex:"projectId",
header : "??ID???"
}
,
{
dataIndex:"projectName",
header : "????"
}
,
{
dataIndex:"projectType",
header : "1为专属项目，2为共享项目"
}
,
{
dataIndex:"managerOrgan",
header : "管控单位"
}
,
{
dataIndex:"year",
header : "????"
}
,
{
dataIndex:"capitalAmt",
header : "?????(??????)"
}
,
{
dataIndex:"expenseAmt",
header : "?????(??????)"
}
,
{
dataIndex:"costOwnership",
header : "??????"
}
,
{
dataIndex:"memo",
header : "????"
}
,
{
dataIndex:"dept",
header : "????"
}
,
{
dataIndex:"budgetId",
header : "????"
}
,
{
dataIndex:"startDate",
header : "项目开始时间"
}
,
{
dataIndex:"projectAmt",
header : "项目预算总金额"
}
,
{
dataIndex:"hardAmt",
header : "硬件总金额"
}
,
{
dataIndex:"softAmt",
header : "软件总金额"
}
,
{
dataIndex:"devAmt",
header : "开发实施总金额"
}
,
{
dataIndex:"projectNature",
header : "项目性质"
}
,
{
dataIndex:"hasOverYearProject",
header : "是否历年延续项目"
}
,
{
dataIndex:"created",
header : "创建时间"
}
,
{
dataIndex:"updatedDate",
header : "更新时间"
}
,
{
dataIndex:"updatePerson",
header : "更新人(人员ID)"
}
,
{
dataIndex:"organ",
header : "管控单位(原始保留字段)"
}
,
{
dataIndex:"editOrgan",
header : "编制单位"
}
,
{
dataIndex:"creator",
header : "创建人(人员ID)"
}
,
{
dataIndex:"thisYearCapitalAmt",
header : "当年资本性金额"
}
,
{
dataIndex:"thisYearExpenseAmt",
header : "当年费用性金额"
}
,
{
dataIndex:"thisYearTotalAmt",
header : "当年总金额"
}
,
{
dataIndex:"nextYearCapitalAmt",
header : "明年资本性金额"
}
,
{
dataIndex:"nextYearExpenseAmt",
header : "明年费用性金额"
}
,
{
dataIndex:"nextYearTotalAmt",
header : "明年总金额"
}
,
{
dataIndex:"afterNextYearCapitalAmt",
header : "明年以后资本性金额"
}
,
{
dataIndex:"afterNextYearExpenseAmt",
header : "明年以后费用性金额"
}
,
{
dataIndex:"afterNextYearTotalAmt",
header : "明年以后总金额"
}
,
{
dataIndex:"usedCapital",
header : "已执行资本性预算"
}
,
{
dataIndex:"usedExpense",
header : "已执行费用性预算"
}
,
{
dataIndex:"projectCode",
header : "项目编码"
}
,
{
dataIndex:"isMiddleYearChange",
header : "是否年中调整,0为编制,1为调整,2为调整时新增,3.编制后的不定时调整时新增,4.调整后的不定时调整时新增"
}
,
{
dataIndex:"endDate",
header : "项目结束时间"
}
,
{
dataIndex:"responsibilityPerson",
header : "责任人"
}
,
{
dataIndex:"overYearHardUsed",
header : "历年已付硬件费用"
}
,
{
dataIndex:"overYearSoftUsed",
header : "历年已付软件费用"
}
,
{
dataIndex:"overYearDevUsed",
header : "历年已付开发实施费用"
}
,
{
dataIndex:"status",
header : "项目状态(
1 编制中
2 编制审核
3 年中调整
4 调整审核
5 已上报待批复
6 已批复
7 已关账)"
}
,
{
dataIndex:"costOwnershipType",
header : "共享中心子级机构名称"
}
,
{
dataIndex:"classifyId",
header : "项目分类编号"
}
,
{
dataIndex:"arrivalTime",
header : "采购到货时间"
}
];
me.store = Ext.create("com.tp.store.Project");
me.callParent(arguments);
}
});