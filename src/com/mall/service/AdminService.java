package com.mall.service;

import java.util.List;
import java.util.Map;

import com.mall.entity.AttendanceSheet;

public interface AdminService {

	public boolean saveChecking_in_Record(AttendanceSheet as);
	
	/**
	 * 
	 * @描述：  查询出某一时间段 该管理员的考勤记录集合
	 * @param as
	 * @param args
	 * @return List<AttendanceSheet>
	 */
	public List<AttendanceSheet> findAllRecord(AttendanceSheet as, String... args);

	public String getAdminNameByUID(Integer uid);

	public boolean saveChecking_out_Record(AttendanceSheet as);

	public Map<Integer, String> getASTByUID(Integer uid);
}
