package com.mall.dao;

import java.util.List;

import com.mall.entity.AttendanceSheet;


public interface AdminDao {

	public boolean saveChecking_in_Record(AttendanceSheet as);

	public List<AttendanceSheet> findAllRecord(String adminName, String... args);

	public String getAdminNameByUID(Integer uid);

	public boolean saveChecking_out_Record(AttendanceSheet as);

	public List<AttendanceSheet> getASTByUID(Integer uid);
	
}
