package com.mall.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @描述:  管理员表
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月30日下午7:37:47
 */
public class Admin {

	// Fields
	private Integer aid;
	private String adminName;
	private String password;
	private String headPortrait; //头像
	
	private Set<Notice> notices = new HashSet<Notice>();


	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String adminName, String password, String headPortrait) {
		super();
		this.adminName = adminName;
		this.password = password;
		this.headPortrait = headPortrait;
	}

	/** full constructor */
	public Admin(String adminName, String password, String headPortrait,
			Set<Notice> notices) {
		super();
		this.adminName = adminName;
		this.password = password;
		this.headPortrait = headPortrait;
		this.notices = notices;
	}
	
	// Property accessors
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Notice> getNotices() {
		return this.notices;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	
}