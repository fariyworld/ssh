package com.mall.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mall.dao.AdminDao;
import com.mall.entity.AttendanceSheet;
import com.mall.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

/***************** 依赖注入setter 方法    ********************/	
	
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
/*********************************************************/	

	@Override
	public boolean saveChecking_in_Record(AttendanceSheet as) {
		
		return adminDao.saveChecking_in_Record(as);
	}

	@Override
	public List<AttendanceSheet> findAllRecord(AttendanceSheet as, String... args) {
		
		return adminDao.findAllRecord(as.getAdminName(), args);
	}

	@Override
	public String getAdminNameByUID(Integer uid) {

		return adminDao.getAdminNameByUID(uid);
	}

	@Override
	public boolean saveChecking_out_Record(AttendanceSheet as) {
		
		return adminDao.saveChecking_out_Record(as);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Map<Integer, String> getASTByUID(Integer uid) {
		
		//向数据库 attendancesheet 表 查询该月 uid 对应的 admin 的 考勤记录List集合
		List<AttendanceSheet> list = adminDao.getASTByUID(uid);
		
		/*
		 * 处理list集合
		 * 1.循环取出AttendanceSheet--每一条记录
		 * 2.取出每条记录的 checking_in_time
		 * 	   	if checking_in_time null --> tips:"0"
		 * 			if checking_out_time null --> tips:"0"
		 * 			if checking_out_time not null --> tips:"1"
		 * 		if checking_in_time not null --> tips:"1"
		 * 			if checking_out_time null --> tips:"0"
		 * 			if checking_out_time not null --> tips:"1"
		 * "00" --> "未签到未签退" //数据库中不可能插入这样的记录
		 * "01" --> "未签到已签退"
		 * "10" --> "已签到未签退"
		 * "11" --> "已签到已签退"
		 * 把每一条处理结果放入Map集合  Map<Integer, String> key:checking_in_time.getDay()
		 * 											  vaule: String
		 */
		Map<Integer,String> asMap = new HashMap<Integer,String>();
		
		for (AttendanceSheet as : list) {
			
			String tips = "";
			Integer thatDay;
			
			if ( as.getCheckingInTime() == null ) {
				
				tips += "0";
				
				tips += "1"; thatDay = as.getCheckingOutTime().getDate();
			}else{
				
				tips += "1";
				
				thatDay = as.getCheckingInTime().getDate();
				
				System.out.println(as.getCheckingOutTime() == null);
				
				if ( as.getCheckingOutTime() == null ) tips += "0";
				
				else tips += "1"; 
			}
			
			System.out.print(tips + " -----> ");System.out.print(thatDay+"\n\r");
			asMap.put(thatDay, tips);
		}
		
		return asMap;
	}
	
	
	
}
