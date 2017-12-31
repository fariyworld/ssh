package com.mall.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

/**
 * 
 * @描述: 公共工具类
 * @类名: Tools 
 * @创建人: 黄土高坡的宝宝
 * @创建日期: 2017年11月17日
 */
public class Tools {
	
	/**
	 * 
	 * @描述: 遍历JavaBean类型的List集合  
	 * @param list void
	 */
	public static <T> void showList(List<T> list){
		
		int listsize = list.size();
		
		System.out.println("共有  "+ listsize +" 个 ");
		
		for (T t : list) {
			
			System.out.println(t);
		}
	}
	
	/**
	 * 
	 * @描述：  遍历 List<Object []>
	 * @param objlist
	 */
	public static void showList2(List<Object []> objlist){
		
		int listsize = objlist.size();
		
		System.out.println("共有  "+ listsize +" 个 ");
		
		for (Object [] objects : objlist) {
			
			for (Object object : objects) {
				
				System.out.println(object);
			}
		}
	}
	
	/**
	 * 
	 * @描述：  遍历数组
	 * @param arr
	 */
	public static <T> void showArray(T [] arr){
		
		int arrlen = arr.length;
		
		System.out.println("共有  "+ arrlen +" 个 元素");
		
		for (Object object : arr) {
			
			System.out.println(object);
		}
	}

	/**
	 * 
	 * @描述：  随机获得一个不重复的UUID 作为 User的主键
	 * @return String
	 */
	public static String getUID() {
		
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

	/**
	 * 
	 * @描述：  随机获得一个不重复的激活码  
	 * @return String
	 */
	public static String getActiveCode() {
		
		return getUID();
	}
	
	/**
	 * 
	 * @描述：  把当前时间转化为Timestamp， 注册时间
	 * @return Timestamp
	 */
	public static Timestamp getTimestamp(){
		
		return new Timestamp(new Date().getTime());
	}
	
	public static Timestamp getTimestamp(long checking_in_time){
		
		return new Timestamp(checking_in_time);
	}
	
	
	public static <T,K> List<T> pageBeanList(List<K> destList, Class<T> srcclazz, List<T> srcList){
		
		try {
			
			Field[] fields = srcclazz.getDeclaredFields();//目标JavaBean对象属性数组
			
			for (Object obj : destList) {
				
				Class<? extends Object> clazz1 = obj.getClass();
				
				T t = srcclazz.newInstance();
				
				for (Field field : fields) {
					
					Method getMethod = clazz1.getMethod("get"+ initcap(field.toString()));
					
					Object val = getMethod.invoke(obj);
					
					Method setMethod = srcclazz.getMethod("set"+ initcap(field.toString()), getMethod.getReturnType() );
					
					setMethod.invoke(t, val);
				}
				srcList.add(t);
			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return srcList;
	}
	
	/**
	 * 
	 * @描述：  首字母大写
	 * @param str
	 * @return String
	 */
	public static String initcap(String str){
		
		str = getPropertyName(str);
		
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
	
	
	/**
	 * 
	 * @描述：  获得属性名
	 * @param str
	 * @return String
	 */
	public static String getPropertyName(String str){
		
		return str.substring(str.lastIndexOf(".") + 1 );
	}
	
	/**
	 * 
	 * @描述: 获取某年某月和下一个月时间段
	 * @方法名: getMonthPeriod
	 * @param year
	 * @param month
	 * @return String[]  
	 */
	@SuppressWarnings("deprecation")
	public static String []  getMonthPeriod(int year, int month){
		
		String [] timestr = new String [2];
		
		//循环设置两个时间
		for (int i = 0; i < 2; i++) {
			
			//得到Date对象
			Date date = new Date();
			
			//设置年份 两个时间  年份一样
			date.setYear(year-1900);
			
			//设置月份 循环两次 分别为当月和下一个月
			date.setMonth(month-1+i);
			
			//设置初始日期   两个时间 均为 一号 
			date.setDate(1);
			
			//格式化Date
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			//把得到的时间String放入数组
			timestr[i] = dateString;
		}
		
		//返回数组
		return timestr;
	}

	/**
	 * 
	 * @描述: 获取某年某月某天的时间段
	 * @方法名: getDayPeriod
	 * @param year
	 * @param month
	 * @param day
	 * @return String[]  
	 */
	@SuppressWarnings("deprecation")
	public static String []  getDayPeriod(int year, int month, int day){
		
		String [] timestr = new String [2];
		
		for (int i = 0; i < 2; i++) {
			
			//得到Date对象
			Date date = new Date();
			
			//设置年份 两个时间  年份一样
			date.setYear(year-1900);
			
			//设置月份  两个时间  月份一样
			date.setMonth(month-1);
			
			//循环设置初始日期
			date.setDate(day+i);
			
			//格式化Date
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
			
			//把得到的时间String放入数组
			timestr[i] = dateString;

		}
		return timestr;
	}
	
	//获取系统时间的当天时间段  
	public static String[] getDayPeriodByCalendar(){
		
		String [] timestr = new String [2];
		
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DAY_OF_MONTH);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		for (int i = 0; i < timestr.length; i++) {
			
			c.set(year, month, date+i, 00, 00, 00);
			
			timestr[i] = sdf.format(c.getTime());
		}
		return timestr;
	}
	
	
	//获取系统时间当月时间段
	public static String[] getMonthPeriodByCalendar(){
		
		String [] timestr = new String [2];
		
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (int i = 0; i < timestr.length; i++) {
			
			c.set(year, month+i, 1, 00, 00, 00);
			
			timestr[i] = sdf.format(c.getTime());
		}
		return timestr;
	}
	
	@Test
	public void testCalendar() throws Exception {

		showArray(getMonthPeriodByCalendar());
	}
	
	
	//用来将放在map里的数据取出来放在对应的实体类中，并返回该实体类对象

	
	
}
