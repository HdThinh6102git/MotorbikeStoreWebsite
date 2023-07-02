package com.MotorbikeStore.model;

import java.util.Date;

import com.opensymphony.module.sitemesh.html.Text;

public class blogModel {
	private int blogId; 
	private Text title; 
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public Text getTitle() {
		return title;
	}
	public void setTitle(Text title) {
		this.title = title;
	}
	public Text getBody() {
		return body;
	}
	public void setBody(Text body) {
		this.body = body;
	}
	public Date getDateWrite() {
		return dateWrite;
	}
	public void setDateWrite(Date dateWrite) {
		this.dateWrite = dateWrite;
	}
	private Text body; 
	private Date dateWrite;
	
}
