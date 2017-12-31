package com.mall.formBean;

import java.sql.Timestamp;

public class Member_Form {
	
	private Integer uid;
	private String userName;
	private String address;
	
	private String realName;
	private Integer grade;
	private String email;
	
	private String activeCode;
	private Timestamp regTime;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		return "Member_Form [uid=" + uid + ", userName=" + userName
				+ ", address=" + address + ", realName=" + realName
				+ ", grade=" + grade + ", email=" + email + ", activeCode="
				+ activeCode + ", regTime=" + regTime + "]";
	}
	
}
