package com.tp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.tp.entity.Project;

public class ProjectDao{
	public static void remove(Connection conn, Project project) throws Exception{
		PreparedStatement ps = conn.prepareStatement("DELETE IBS_PROJECT WHERE PROJECT_ID=?");
		
		ps.setObject(1,project.getProjectId());
		
		ps.execute();
	}
	
	public static List<Project> list(Connection conn) throws Exception{
		List<Project> list = new ArrayList<Project>();
	
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM IBS_PROJECT");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			list.add(wrap(rs));
		}
		
		return list;
	}
	
	public static Project get(Connection conn,Project project) throws Exception{
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM IBS_PROJECT WHERE PROJECT_ID=?");
		
		ps.setObject(1,project.getProjectId());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			project = wrap(rs);
		}
		
		return project;
	}
	
	public static void insert(Connection conn, Project project) throws Exception{
		PreparedStatement ps = conn.prepareStatement("INERT INTO IBS_PROJECT(PROJECT_ID,PROJECT_NAME,PROJECT_TYPE,MANAGER_ORGAN,YEAR,CAPITAL_AMT,EXPENSE_AMT,COST_OWNERSHIP,MEMO,DEPT,BUDGET_ID,START_DATE,PROJECT_AMT,HARD_AMT,SOFT_AMT,DEV_AMT,PROJECT_NATURE,HAS_OVER_YEAR_PROJECT,CREATED,UPDATED_DATE,UPDATE_PERSON,ORGAN,EDIT_ORGAN,CREATOR,THIS_YEAR_CAPITAL_AMT,THIS_YEAR_EXPENSE_AMT,THIS_YEAR_TOTAL_AMT,NEXT_YEAR_CAPITAL_AMT,NEXT_YEAR_EXPENSE_AMT,NEXT_YEAR_TOTAL_AMT,AFTER_NEXT_YEAR_CAPITAL_AMT,AFTER_NEXT_YEAR_EXPENSE_AMT,AFTER_NEXT_YEAR_TOTAL_AMT,USED_CAPITAL,USED_EXPENSE,PROJECT_CODE,IS_MIDDLE_YEAR_CHANGE,END_DATE,RESPONSIBILITY_PERSON,OVER_YEAR_HARD_USED,OVER_YEAR_SOFT_USED,OVER_YEAR_DEV_USED,STATUS,COST_OWNERSHIP_TYPE,CLASSIFY_ID,ARRIVAL_TIME) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setObject(1,project.getProjectId());
		ps.setObject(2,project.getProjectName());
		ps.setObject(3,project.getProjectType());
		ps.setObject(4,project.getManagerOrgan());
		ps.setObject(5,project.getYear());
		ps.setObject(6,project.getCapitalAmt());
		ps.setObject(7,project.getExpenseAmt());
		ps.setObject(8,project.getCostOwnership());
		ps.setObject(9,project.getMemo());
		ps.setObject(10,project.getDept());
		ps.setObject(11,project.getBudgetId());
		ps.setObject(12,project.getStartDate());
		ps.setObject(13,project.getProjectAmt());
		ps.setObject(14,project.getHardAmt());
		ps.setObject(15,project.getSoftAmt());
		ps.setObject(16,project.getDevAmt());
		ps.setObject(17,project.getProjectNature());
		ps.setObject(18,project.getHasOverYearProject());
		ps.setObject(19,project.getCreated());
		ps.setObject(20,project.getUpdatedDate());
		ps.setObject(21,project.getUpdatePerson());
		ps.setObject(22,project.getOrgan());
		ps.setObject(23,project.getEditOrgan());
		ps.setObject(24,project.getCreator());
		ps.setObject(25,project.getThisYearCapitalAmt());
		ps.setObject(26,project.getThisYearExpenseAmt());
		ps.setObject(27,project.getThisYearTotalAmt());
		ps.setObject(28,project.getNextYearCapitalAmt());
		ps.setObject(29,project.getNextYearExpenseAmt());
		ps.setObject(30,project.getNextYearTotalAmt());
		ps.setObject(31,project.getAfterNextYearCapitalAmt());
		ps.setObject(32,project.getAfterNextYearExpenseAmt());
		ps.setObject(33,project.getAfterNextYearTotalAmt());
		ps.setObject(34,project.getUsedCapital());
		ps.setObject(35,project.getUsedExpense());
		ps.setObject(36,project.getProjectCode());
		ps.setObject(37,project.getIsMiddleYearChange());
		ps.setObject(38,project.getEndDate());
		ps.setObject(39,project.getResponsibilityPerson());
		ps.setObject(40,project.getOverYearHardUsed());
		ps.setObject(41,project.getOverYearSoftUsed());
		ps.setObject(42,project.getOverYearDevUsed());
		ps.setObject(43,project.getStatus());
		ps.setObject(44,project.getCostOwnershipType());
		ps.setObject(45,project.getClassifyId());
		ps.setObject(46,project.getArrivalTime());
		
		ps.execute();
	}
	
	public static Project wrap(ResultSet rs) throws Exception{
		return new Project(rs.getBigDecimal("PROJECT_ID"),rs.getString("PROJECT_NAME"),rs.getBigDecimal("PROJECT_TYPE"),rs.getBigDecimal("MANAGER_ORGAN"),rs.getBigDecimal("YEAR"),rs.getBigDecimal("CAPITAL_AMT"),rs.getBigDecimal("EXPENSE_AMT"),rs.getBigDecimal("COST_OWNERSHIP"),rs.getString("MEMO"),rs.getBigDecimal("DEPT"),rs.getBigDecimal("BUDGET_ID"),rs.getString("START_DATE"),rs.getBigDecimal("PROJECT_AMT"),rs.getBigDecimal("HARD_AMT"),rs.getBigDecimal("SOFT_AMT"),rs.getBigDecimal("DEV_AMT"),rs.getBigDecimal("PROJECT_NATURE"),rs.getInt("HAS_OVER_YEAR_PROJECT"),rs.getDate("CREATED"),rs.getDate("UPDATED_DATE"),rs.getBigDecimal("UPDATE_PERSON"),rs.getBigDecimal("ORGAN"),rs.getBigDecimal("EDIT_ORGAN"),rs.getBigDecimal("CREATOR"),rs.getBigDecimal("THIS_YEAR_CAPITAL_AMT"),rs.getBigDecimal("THIS_YEAR_EXPENSE_AMT"),rs.getBigDecimal("THIS_YEAR_TOTAL_AMT"),rs.getBigDecimal("NEXT_YEAR_CAPITAL_AMT"),rs.getBigDecimal("NEXT_YEAR_EXPENSE_AMT"),rs.getBigDecimal("NEXT_YEAR_TOTAL_AMT"),rs.getBigDecimal("AFTER_NEXT_YEAR_CAPITAL_AMT"),rs.getBigDecimal("AFTER_NEXT_YEAR_EXPENSE_AMT"),rs.getBigDecimal("AFTER_NEXT_YEAR_TOTAL_AMT"),rs.getBigDecimal("USED_CAPITAL"),rs.getBigDecimal("USED_EXPENSE"),rs.getString("PROJECT_CODE"),rs.getInt("IS_MIDDLE_YEAR_CHANGE"),rs.getString("END_DATE"),rs.getString("RESPONSIBILITY_PERSON"),rs.getBigDecimal("OVER_YEAR_HARD_USED"),rs.getBigDecimal("OVER_YEAR_SOFT_USED"),rs.getBigDecimal("OVER_YEAR_DEV_USED"),rs.getBigDecimal("STATUS"),rs.getString("COST_OWNERSHIP_TYPE"),rs.getBigDecimal("CLASSIFY_ID"),rs.getString("ARRIVAL_TIME"));
	}
}