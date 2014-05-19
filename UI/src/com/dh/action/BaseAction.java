package com.dh.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	public String jsonString;
	
	public int type;
	
	public String listIndexs(){
		getData("indexs.json");
		
		return "success";
	}

	public String listIndicators(){
		if(type == 1){
			getData("corebusi.json");
		}else if(type == 2){
			getData("infosecu.json");
		}else{
			getData("pro.json");
		}
		
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}