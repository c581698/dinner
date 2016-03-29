package com.hd.helloworld.patterns.prototype;

public abstract class Shape implements Cloneable {
	private Long id;
	private String type;

	protected abstract void draw();
	
	@Override
	protected Object clone() {
		Object clone = null;
		
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return clone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(null != obj && obj instanceof Shape && ((Shape)obj).getType().equals(this.getType())){
			return true;
		}
		return false;
	}
}
