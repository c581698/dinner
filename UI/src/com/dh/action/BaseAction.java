package com.dh.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	public String jsonString;

	public String listIndexs(){
		getData("indexs.json");
		
		return "success";
	}

	private void getData(String fileName) {
		try {
			String filePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/"+fileName);
			
			jsonString = FileUtils.readFileToString(new File(filePath),"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}