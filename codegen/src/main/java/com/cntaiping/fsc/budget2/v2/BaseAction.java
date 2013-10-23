package com.cntaiping.fsc.budget2.v2;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	public static final String SESSION_KEY = "FSC_WEB_SESSION_KEY";
	public static final String RESULT_TYPE_JSON="json";
	public String jsonString;

	public String getJsonString() {
		return jsonString;
	}
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
}
