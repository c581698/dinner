package ${packageName}.entity<#if filePath!="">.${filePath}</#if>;

import ${packageName}.entity.BaseModel;
import java.math.BigDecimal;
import java.sql.Date;
/**
 * @auth gen ${.now}
 */
public class ${name} extends BaseModel{<#list columns as col>
	<#switch col.type>
		<#case 3>
			<#if col.size <= 1>
				<#assign fieldType="int">
			<#else>
				<#assign fieldType="BigDecimal">
			</#if>
			<#break>
		<#case 93><#assign fieldType="Date"><#break>
		<#default>
			<#assign fieldType="String">
	</#switch>
	protected ${fieldType} ${col.name};</#list>
	
	public ${name?cap_first}(){}
	public ${name?cap_first}(<#list columns as col><#switch col.type>
		<#case 3>
			<#if col.size <= 1>
				<#assign fieldType="int">
			<#else>
				<#assign fieldType="BigDecimal">
			</#if>
			<#break>
		<#case 93><#assign fieldType="Date"><#break>
		<#default>
			<#assign fieldType="String">
	</#switch>${fieldType} ${col.name}<#if col_has_next>,</#if></#list>){
		<#list columns as col>this.${col.name}=${col.name};</#list>
	}
	<#list columns as col>
	<#switch col.type>
		<#case 3>
			<#if col.size <= 1>
				<#assign fieldType="int">
			<#else>
				<#assign fieldType="BigDecimal">
			</#if>
			<#break>
		<#case 93><#assign fieldType="Date"><#break>
		<#default>
			<#assign fieldType="String">
	</#switch>
	public void set${col.name?cap_first}(${fieldType} ${col.name}){
		this.${col.name} = ${col.name};
	}
	/**
	 * ${col.desc!""}
	 */
	public ${fieldType} get${col.name?cap_first}(){
		return ${col.name};
	}
	</#list>
}