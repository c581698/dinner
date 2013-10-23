package com.tp.entity;

import com.tp.entity.BaseModel;
import java.math.BigDecimal;
import java.sql.Date;
/**
 * @auth gen 2013-10-22 15:45:18
 */
public class Project extends BaseModel{
	protected BigDecimal projectId;
	protected String projectName;
	protected BigDecimal projectType;
	protected BigDecimal managerOrgan;
	protected BigDecimal year;
	protected BigDecimal capitalAmt;
	protected BigDecimal expenseAmt;
	protected BigDecimal costOwnership;
	protected String memo;
	protected BigDecimal dept;
	protected BigDecimal budgetId;
	protected String startDate;
	protected BigDecimal projectAmt;
	protected BigDecimal hardAmt;
	protected BigDecimal softAmt;
	protected BigDecimal devAmt;
	protected BigDecimal projectNature;
	protected int hasOverYearProject;
	protected Date created;
	protected Date updatedDate;
	protected BigDecimal updatePerson;
	protected BigDecimal organ;
	protected BigDecimal editOrgan;
	protected BigDecimal creator;
	protected BigDecimal thisYearCapitalAmt;
	protected BigDecimal thisYearExpenseAmt;
	protected BigDecimal thisYearTotalAmt;
	protected BigDecimal nextYearCapitalAmt;
	protected BigDecimal nextYearExpenseAmt;
	protected BigDecimal nextYearTotalAmt;
	protected BigDecimal afterNextYearCapitalAmt;
	protected BigDecimal afterNextYearExpenseAmt;
	protected BigDecimal afterNextYearTotalAmt;
	protected BigDecimal usedCapital;
	protected BigDecimal usedExpense;
	protected String projectCode;
	protected int isMiddleYearChange;
	protected String endDate;
	protected String responsibilityPerson;
	protected BigDecimal overYearHardUsed;
	protected BigDecimal overYearSoftUsed;
	protected BigDecimal overYearDevUsed;
	protected BigDecimal status;
	protected String costOwnershipType;
	protected BigDecimal classifyId;
	protected String arrivalTime;
	
	public Project(){}
	public Project(BigDecimal projectId,	String projectName,BigDecimal projectType,BigDecimal managerOrgan,BigDecimal year,BigDecimal capitalAmt,BigDecimal expenseAmt,BigDecimal costOwnership,	String memo,BigDecimal dept,BigDecimal budgetId,	String startDate,BigDecimal projectAmt,BigDecimal hardAmt,BigDecimal softAmt,BigDecimal devAmt,BigDecimal projectNature,int hasOverYearProject,Date created,Date updatedDate,BigDecimal updatePerson,BigDecimal organ,BigDecimal editOrgan,BigDecimal creator,BigDecimal thisYearCapitalAmt,BigDecimal thisYearExpenseAmt,BigDecimal thisYearTotalAmt,BigDecimal nextYearCapitalAmt,BigDecimal nextYearExpenseAmt,BigDecimal nextYearTotalAmt,BigDecimal afterNextYearCapitalAmt,BigDecimal afterNextYearExpenseAmt,BigDecimal afterNextYearTotalAmt,BigDecimal usedCapital,BigDecimal usedExpense,	String projectCode,int isMiddleYearChange,	String endDate,	String responsibilityPerson,BigDecimal overYearHardUsed,BigDecimal overYearSoftUsed,BigDecimal overYearDevUsed,BigDecimal status,	String costOwnershipType,BigDecimal classifyId,	String arrivalTime){
		this.projectId=projectId;this.projectName=projectName;this.projectType=projectType;this.managerOrgan=managerOrgan;this.year=year;this.capitalAmt=capitalAmt;this.expenseAmt=expenseAmt;this.costOwnership=costOwnership;this.memo=memo;this.dept=dept;this.budgetId=budgetId;this.startDate=startDate;this.projectAmt=projectAmt;this.hardAmt=hardAmt;this.softAmt=softAmt;this.devAmt=devAmt;this.projectNature=projectNature;this.hasOverYearProject=hasOverYearProject;this.created=created;this.updatedDate=updatedDate;this.updatePerson=updatePerson;this.organ=organ;this.editOrgan=editOrgan;this.creator=creator;this.thisYearCapitalAmt=thisYearCapitalAmt;this.thisYearExpenseAmt=thisYearExpenseAmt;this.thisYearTotalAmt=thisYearTotalAmt;this.nextYearCapitalAmt=nextYearCapitalAmt;this.nextYearExpenseAmt=nextYearExpenseAmt;this.nextYearTotalAmt=nextYearTotalAmt;this.afterNextYearCapitalAmt=afterNextYearCapitalAmt;this.afterNextYearExpenseAmt=afterNextYearExpenseAmt;this.afterNextYearTotalAmt=afterNextYearTotalAmt;this.usedCapital=usedCapital;this.usedExpense=usedExpense;this.projectCode=projectCode;this.isMiddleYearChange=isMiddleYearChange;this.endDate=endDate;this.responsibilityPerson=responsibilityPerson;this.overYearHardUsed=overYearHardUsed;this.overYearSoftUsed=overYearSoftUsed;this.overYearDevUsed=overYearDevUsed;this.status=status;this.costOwnershipType=costOwnershipType;this.classifyId=classifyId;this.arrivalTime=arrivalTime;
	}
	public void setProjectId(BigDecimal projectId){
		this.projectId = projectId;
	}
	/**
	 * ??ID???
	 */
	public BigDecimal getProjectId(){
		return projectId;
	}
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	/**
	 * ????
	 */
	public String getProjectName(){
		return projectName;
	}
	public void setProjectType(BigDecimal projectType){
		this.projectType = projectType;
	}
	/**
	 * 1为专属项目，2为共享项目
	 */
	public BigDecimal getProjectType(){
		return projectType;
	}
	public void setManagerOrgan(BigDecimal managerOrgan){
		this.managerOrgan = managerOrgan;
	}
	/**
	 * 管控单位
	 */
	public BigDecimal getManagerOrgan(){
		return managerOrgan;
	}
	public void setYear(BigDecimal year){
		this.year = year;
	}
	/**
	 * ????
	 */
	public BigDecimal getYear(){
		return year;
	}
	public void setCapitalAmt(BigDecimal capitalAmt){
		this.capitalAmt = capitalAmt;
	}
	/**
	 * ?????(??????)
	 */
	public BigDecimal getCapitalAmt(){
		return capitalAmt;
	}
	public void setExpenseAmt(BigDecimal expenseAmt){
		this.expenseAmt = expenseAmt;
	}
	/**
	 * ?????(??????)
	 */
	public BigDecimal getExpenseAmt(){
		return expenseAmt;
	}
	public void setCostOwnership(BigDecimal costOwnership){
		this.costOwnership = costOwnership;
	}
	/**
	 * ??????
	 */
	public BigDecimal getCostOwnership(){
		return costOwnership;
	}
	public void setMemo(String memo){
		this.memo = memo;
	}
	/**
	 * ????
	 */
	public String getMemo(){
		return memo;
	}
	public void setDept(BigDecimal dept){
		this.dept = dept;
	}
	/**
	 * ????
	 */
	public BigDecimal getDept(){
		return dept;
	}
	public void setBudgetId(BigDecimal budgetId){
		this.budgetId = budgetId;
	}
	/**
	 * ????
	 */
	public BigDecimal getBudgetId(){
		return budgetId;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	/**
	 * 项目开始时间
	 */
	public String getStartDate(){
		return startDate;
	}
	public void setProjectAmt(BigDecimal projectAmt){
		this.projectAmt = projectAmt;
	}
	/**
	 * 项目预算总金额
	 */
	public BigDecimal getProjectAmt(){
		return projectAmt;
	}
	public void setHardAmt(BigDecimal hardAmt){
		this.hardAmt = hardAmt;
	}
	/**
	 * 硬件总金额
	 */
	public BigDecimal getHardAmt(){
		return hardAmt;
	}
	public void setSoftAmt(BigDecimal softAmt){
		this.softAmt = softAmt;
	}
	/**
	 * 软件总金额
	 */
	public BigDecimal getSoftAmt(){
		return softAmt;
	}
	public void setDevAmt(BigDecimal devAmt){
		this.devAmt = devAmt;
	}
	/**
	 * 开发实施总金额
	 */
	public BigDecimal getDevAmt(){
		return devAmt;
	}
	public void setProjectNature(BigDecimal projectNature){
		this.projectNature = projectNature;
	}
	/**
	 * 项目性质
	 */
	public BigDecimal getProjectNature(){
		return projectNature;
	}
	public void setHasOverYearProject(int hasOverYearProject){
		this.hasOverYearProject = hasOverYearProject;
	}
	/**
	 * 是否历年延续项目
	 */
	public int getHasOverYearProject(){
		return hasOverYearProject;
	}
	public void setCreated(Date created){
		this.created = created;
	}
	/**
	 * 创建时间
	 */
	public Date getCreated(){
		return created;
	}
	public void setUpdatedDate(Date updatedDate){
		this.updatedDate = updatedDate;
	}
	/**
	 * 更新时间
	 */
	public Date getUpdatedDate(){
		return updatedDate;
	}
	public void setUpdatePerson(BigDecimal updatePerson){
		this.updatePerson = updatePerson;
	}
	/**
	 * 更新人(人员ID)
	 */
	public BigDecimal getUpdatePerson(){
		return updatePerson;
	}
	public void setOrgan(BigDecimal organ){
		this.organ = organ;
	}
	/**
	 * 管控单位(原始保留字段)
	 */
	public BigDecimal getOrgan(){
		return organ;
	}
	public void setEditOrgan(BigDecimal editOrgan){
		this.editOrgan = editOrgan;
	}
	/**
	 * 编制单位
	 */
	public BigDecimal getEditOrgan(){
		return editOrgan;
	}
	public void setCreator(BigDecimal creator){
		this.creator = creator;
	}
	/**
	 * 创建人(人员ID)
	 */
	public BigDecimal getCreator(){
		return creator;
	}
	public void setThisYearCapitalAmt(BigDecimal thisYearCapitalAmt){
		this.thisYearCapitalAmt = thisYearCapitalAmt;
	}
	/**
	 * 当年资本性金额
	 */
	public BigDecimal getThisYearCapitalAmt(){
		return thisYearCapitalAmt;
	}
	public void setThisYearExpenseAmt(BigDecimal thisYearExpenseAmt){
		this.thisYearExpenseAmt = thisYearExpenseAmt;
	}
	/**
	 * 当年费用性金额
	 */
	public BigDecimal getThisYearExpenseAmt(){
		return thisYearExpenseAmt;
	}
	public void setThisYearTotalAmt(BigDecimal thisYearTotalAmt){
		this.thisYearTotalAmt = thisYearTotalAmt;
	}
	/**
	 * 当年总金额
	 */
	public BigDecimal getThisYearTotalAmt(){
		return thisYearTotalAmt;
	}
	public void setNextYearCapitalAmt(BigDecimal nextYearCapitalAmt){
		this.nextYearCapitalAmt = nextYearCapitalAmt;
	}
	/**
	 * 明年资本性金额
	 */
	public BigDecimal getNextYearCapitalAmt(){
		return nextYearCapitalAmt;
	}
	public void setNextYearExpenseAmt(BigDecimal nextYearExpenseAmt){
		this.nextYearExpenseAmt = nextYearExpenseAmt;
	}
	/**
	 * 明年费用性金额
	 */
	public BigDecimal getNextYearExpenseAmt(){
		return nextYearExpenseAmt;
	}
	public void setNextYearTotalAmt(BigDecimal nextYearTotalAmt){
		this.nextYearTotalAmt = nextYearTotalAmt;
	}
	/**
	 * 明年总金额
	 */
	public BigDecimal getNextYearTotalAmt(){
		return nextYearTotalAmt;
	}
	public void setAfterNextYearCapitalAmt(BigDecimal afterNextYearCapitalAmt){
		this.afterNextYearCapitalAmt = afterNextYearCapitalAmt;
	}
	/**
	 * 明年以后资本性金额
	 */
	public BigDecimal getAfterNextYearCapitalAmt(){
		return afterNextYearCapitalAmt;
	}
	public void setAfterNextYearExpenseAmt(BigDecimal afterNextYearExpenseAmt){
		this.afterNextYearExpenseAmt = afterNextYearExpenseAmt;
	}
	/**
	 * 明年以后费用性金额
	 */
	public BigDecimal getAfterNextYearExpenseAmt(){
		return afterNextYearExpenseAmt;
	}
	public void setAfterNextYearTotalAmt(BigDecimal afterNextYearTotalAmt){
		this.afterNextYearTotalAmt = afterNextYearTotalAmt;
	}
	/**
	 * 明年以后总金额
	 */
	public BigDecimal getAfterNextYearTotalAmt(){
		return afterNextYearTotalAmt;
	}
	public void setUsedCapital(BigDecimal usedCapital){
		this.usedCapital = usedCapital;
	}
	/**
	 * 已执行资本性预算
	 */
	public BigDecimal getUsedCapital(){
		return usedCapital;
	}
	public void setUsedExpense(BigDecimal usedExpense){
		this.usedExpense = usedExpense;
	}
	/**
	 * 已执行费用性预算
	 */
	public BigDecimal getUsedExpense(){
		return usedExpense;
	}
	public void setProjectCode(String projectCode){
		this.projectCode = projectCode;
	}
	/**
	 * 项目编码
	 */
	public String getProjectCode(){
		return projectCode;
	}
	public void setIsMiddleYearChange(int isMiddleYearChange){
		this.isMiddleYearChange = isMiddleYearChange;
	}
	/**
	 * 是否年中调整,0为编制,1为调整,2为调整时新增,3.编制后的不定时调整时新增,4.调整后的不定时调整时新增
	 */
	public int getIsMiddleYearChange(){
		return isMiddleYearChange;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	/**
	 * 项目结束时间
	 */
	public String getEndDate(){
		return endDate;
	}
	public void setResponsibilityPerson(String responsibilityPerson){
		this.responsibilityPerson = responsibilityPerson;
	}
	/**
	 * 责任人
	 */
	public String getResponsibilityPerson(){
		return responsibilityPerson;
	}
	public void setOverYearHardUsed(BigDecimal overYearHardUsed){
		this.overYearHardUsed = overYearHardUsed;
	}
	/**
	 * 历年已付硬件费用
	 */
	public BigDecimal getOverYearHardUsed(){
		return overYearHardUsed;
	}
	public void setOverYearSoftUsed(BigDecimal overYearSoftUsed){
		this.overYearSoftUsed = overYearSoftUsed;
	}
	/**
	 * 历年已付软件费用
	 */
	public BigDecimal getOverYearSoftUsed(){
		return overYearSoftUsed;
	}
	public void setOverYearDevUsed(BigDecimal overYearDevUsed){
		this.overYearDevUsed = overYearDevUsed;
	}
	/**
	 * 历年已付开发实施费用
	 */
	public BigDecimal getOverYearDevUsed(){
		return overYearDevUsed;
	}
	public void setStatus(BigDecimal status){
		this.status = status;
	}
	/**
	 * 项目状态(
1	编制中
2	编制审核
3	年中调整
4	调整审核
5	已上报待批复
6	已批复
7	已关账)
	 */
	public BigDecimal getStatus(){
		return status;
	}
	public void setCostOwnershipType(String costOwnershipType){
		this.costOwnershipType = costOwnershipType;
	}
	/**
	 * 共享中心子级机构名称
	 */
	public String getCostOwnershipType(){
		return costOwnershipType;
	}
	public void setClassifyId(BigDecimal classifyId){
		this.classifyId = classifyId;
	}
	/**
	 * 项目分类编号
	 */
	public BigDecimal getClassifyId(){
		return classifyId;
	}
	public void setArrivalTime(String arrivalTime){
		this.arrivalTime = arrivalTime;
	}
	/**
	 * 采购到货时间
	 */
	public String getArrivalTime(){
		return arrivalTime;
	}
}