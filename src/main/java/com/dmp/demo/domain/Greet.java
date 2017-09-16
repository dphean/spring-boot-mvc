package com.dmp.demo.domain;

import com.dmp.demo.error.CustomErrorType;

public class Greet {
	private long id;
	private int content;
	private int grp;
	private String back;
	
	@SuppressWarnings("unused")
	public Greet(int grp, long id, int q, String b) throws CustomErrorType {
		super();
		this.id = id;
		this.content = q;
		this.grp = grp;
		this.back = b;
		
		if (false) throw new CustomErrorType(100, "ccccc");
	}
	
	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public int getGrp() {
		return grp;
	}

	public void setGrp(int grp) {
		this.grp = grp;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
	}
	
	

}
