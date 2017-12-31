package com.mall.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.mall.constant.Constant;
import com.mall.dao.AdminDao;
import com.mall.entity.Admin;
import com.mall.entity.AttendanceSheet;
import com.mall.tools.Tools;

public class AdminDaoImpl implements AdminDao{
	
	private HibernateTemplate hbTemplate;

	
/***************** 依赖注入setter 方法    ********************/	
	
	public void setHbTemplate(HibernateTemplate hbTemplate) {
		this.hbTemplate = hbTemplate;
	}

/*********************************************************/	

	@Override
	public boolean saveChecking_in_Record(AttendanceSheet as) {
		
		/*
		 * 1.签到
		 * 	先查询该用户当天有没有签到记录
		 * 		if yes tip 已签到
		 * 		else no save record
		 */
		
		if ( findAllRecord(as.getAdminName(), Tools.getDayPeriodByCalendar()).size() == 0 ){
			
			hbTemplate.save(as);
			
			return true;
		
		}else return false;
		
	}

	//select * from attendance_sheet where adminName = 'admin' and checking_in_time BETWEEN '2017-12-05' and '2017-12-06';
	@SuppressWarnings("unchecked")
	public List<AttendanceSheet> findAllRecord(String adminName, String... args) {
		
		return (List<AttendanceSheet>) hbTemplate.find(Constant.HQL_CHECKING_IN, adminName, args[0], args[1]);
	}

	@Override
	public String getAdminNameByUID(Integer uid) {
		
		return hbTemplate.get(Admin.class, uid).getAdminName();
	}

	@Override
	public boolean saveChecking_out_Record(AttendanceSheet as) {
		
		/*
		 * 1.签到
		 * 	先查询该用户当天有没有签到记录
		 * 		if yes tip 已签到  --> 签退
		 * 		else no save record --> 请先签到再签退
		 */
		List<AttendanceSheet> list = findAllRecord(as.getAdminName(), Tools.getDayPeriodByCalendar());
		
		if ( list.size() > 0 ){
			
			AttendanceSheet as2 = list.get(0);
			
			if( as2.getCheckingOutTime() != null) return false;
			
			else as2.setCheckingOutTime(as.getCheckingOutTime());
			
			hbTemplate.update(as2);
			
			return true;
		
		}else return false;
	}

	@Override
	public List<AttendanceSheet> getASTByUID(Integer uid) {
		
		/*
		 * 汇总
		 * 	1.根据uid找到该用户名
		 *	2.在 attendanceSheet 表中去查询该月 该用户的考勤记录
		 */
		
		return findAllRecord(hbTemplate.get(Admin.class, uid).getAdminName(), Tools.getMonthPeriodByCalendar());
	}

}
