package com.hd.berkeley.entity;

import com.sleepycat.persist.model.Entity;
import com.sleepycat.persist.model.PrimaryKey;

@Entity
public class Article extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6240112124348060328L;

	@PrimaryKey
	private String key;
	private String content;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
