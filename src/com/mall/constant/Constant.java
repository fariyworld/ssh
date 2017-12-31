package com.mall.constant;

public interface Constant {

	public int USER_PAGE_SIZE = 1;  //用户分页查询 页面大小
	
	public String CODE_SOURCE = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnoprstuvwxyz0123456789"; 	//设定可能的字符串
	
	public String FONT_NAME = "Arial Black"; 
	
	public String HQL_CHECKING_IN = "from AttendanceSheet where adminName = ? and checking_in_time between ? and ?";
}
