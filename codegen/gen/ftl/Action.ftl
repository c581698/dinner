package ${packageName}.action<#if filePath!="">.${filePath}</#if>;

import ${packageName}.entity<#if filePath!="">.${filePath}</#if>.${name};
import ${packageName}.dao<#if filePath!="">.${filePath}</#if>.${name}Dao;
import com.cntaiping.fsc.budget2.v2.BaseAction;

public class ${name}Action extends BaseAction{
	
}