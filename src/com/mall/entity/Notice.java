package com.mall.entity;

import java.sql.Timestamp;

/**
 * 
 * @描述:  Notice 公告表 管理员发布
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月30日下午7:42:52
 */
public class Notice {

	// Fields

	private Integer nid;
	private String title;
	private String content;
	private Timestamp publishTime;

	private Admin admin;
	
	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Admin admin, String title, String content) {
		this.admin = admin;
		this.title = title;
		this.content = content;
	}

	/** full constructor */
	public Notice(Admin admin, String title, String content,
			Timestamp publishTime) {
		this.admin = admin;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
	}

	// Property accessors

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

}