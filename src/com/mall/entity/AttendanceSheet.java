package com.mall.entity;

import java.sql.Timestamp;


public class AttendanceSheet {

	// Fields

	private Integer asId;
	private String adminName;
	private Timestamp checkingInTime;
	private Timestamp checkingOutTime;

	// Constructors

	/** default constructor */
	public AttendanceSheet() {
	}

	/** minimal constructor */
	public AttendanceSheet(String adminName) {
		this.adminName = adminName;
	}

	/** full constructor */
	public AttendanceSheet(String adminName, Timestamp checkingInTime,
			Timestamp checkingOutTime) {
		this.adminName = adminName;
		this.checkingInTime = checkingInTime;
		this.checkingOutTime = checkingOutTime;
	}

	// Property accessors

	public Integer getAsId() {
		return this.asId;
	}

	public void setAsId(Integer asId) {
		this.asId = asId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Timestamp getCheckingInTime() {
		return this.checkingInTime;
	}

	public void setCheckingInTime(Timestamp checkingInTime) {
		this.checkingInTime = checkingInTime;
	}

	public Timestamp getCheckingOutTime() {
		return this.checkingOutTime;
	}

	public void setCheckingOutTime(Timestamp checkingOutTime) {
		this.checkingOutTime = checkingOutTime;
	}

	@Override
	public String toString() {
		return "AttendanceSheet [asId=" + asId + ", adminName=" + adminName
				+ ", checkingInTime=" + checkingInTime + ", checkingOutTime="
				+ checkingOutTime + "]";
	}

}