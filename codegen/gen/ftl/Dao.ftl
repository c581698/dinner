package ${packageName}.dao<#if filePath!="">.${filePath}</#if>;
<#assign obj=name?uncap_first>
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ${packageName}.entity<#if filePath!="">.${filePath}</#if>.${name};

public class ${name}Dao{
	public static void remove(Connection conn, ${name} ${obj}) throws Exception{
		PreparedStatement ps = conn.prepareStatement("DELETE ${tableName} WHERE ${pkName}=?");
		
		ps.setObject(1,${obj}.get${pk?cap_first}());
		
		ps.execute();
	}
	
	public static List<${name}> list(Connection conn) throws Exception{
		List<${name}> list = new ArrayList<${name}>();
	
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ${tableName}");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			list.add(wrap(rs));
		}
		
		return list;
	}
	
	public static ${name} get(Connection conn,${name} ${obj}) throws Exception{
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ${tableName} WHERE ${pkName}=?");
		
		ps.setObject(1,${obj}.get${pk?cap_first}());
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			${obj} = wrap(rs);
		}
		
		return ${obj};
	}
	
	public static void insert(Connection conn, ${name} ${obj}) throws Exception{
		PreparedStatement ps = conn.prepareStatement("INERT INTO ${tableName}(<#list columns as col>${col.columnName}<#if col_has_next>,</#if></#list>) VALUES(<#list columns as col>?<#if col_has_next>,</#if></#list>)");
		
		<#list columns as col>
		ps.setObject(${col_index+1},${obj}.get${col.name?cap_first}());
		</#list>
		
		ps.execute();
	}
	
	public static ${name} wrap(ResultSet rs) throws Exception{
		return new ${name}(<#list columns as col>rs.get<#switch col.type><#case 3><#if col.size <= 1>Int<#else>BigDecimal</#if><#break><#case 93>Date<#break><#default>String</#switch>("${col.columnName}")<#if col_has_next>,</#if></#list>);
	}
}