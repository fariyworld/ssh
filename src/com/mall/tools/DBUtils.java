package com.mall.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

/**
 * 
 * @描述: 数据库工具类
 * @类名: DBUtils 
 * @创建人: 黄土高坡的宝宝
 * @创建日期: 2017年11月17日
 */
public class DBUtils {
	
	private static DataSource ds;

	static {
		
		@SuppressWarnings("unused")
		ServletContext application = ServletActionContext.getServletContext();
		ApplicationContext act = ContextLoader.getCurrentWebApplicationContext();
		
		ds = act.getBean("dataSource", DataSource.class);

	}

	public DBUtils() {
		super();
	}
	
	
	
	/**
	 * 
	 * @描述：  静态查询 返回 BeanList
	 * @param con
	 * @param sql
	 * @param list
	 * @param clazz
	 * @return List<T>
	 */
	public static <T> List<T> query(Connection con, String sql, List<T> list, Class<T> clazz){
		
		try
		{
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			list = BeanListHandler(rs, clazz, list);
			
			rs.close(); pst.close(); con.close();
			
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * 
	 * @描述：  动态查询 返回 BeanList
	 * Object... args 可变参数：可以分开传参数、也可以数组
	 * @param con
	 * @param sql
	 * @param list
	 * @param clazz
	 * @param args
	 * @return List<T>
	 */
	public static <T> List<T> query(Connection con, String sql, List<T> list, Class<T> clazz, Object... args){
		
		try
		{
			PreparedStatement pst = con.prepareStatement(sql);
			
			/*动态设置占位符*/
			for (int i = 0; i < args.length; i++) {
				
				pst.setObject(i+1, args[i]);
			}
			/*执行SQL语句*/
			ResultSet rs = pst.executeQuery();
			
			list = BeanListHandler(rs, clazz, list);
		
			rs.close(); pst.close(); con.close();
			
		} catch (Exception e){
			
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * 
	 * @描述：  传递数据源  静态查询 返回 BeanList
	 * @param sql
	 * @param list
	 * @param clazz
	 * @return List<T>
	 */
	public static <T> List<T> query(String sql, List<T> list, Class<T> clazz){
		
		try
		{
			Connection con = ds.getConnection();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			list = BeanListHandler(rs, clazz, list);
			
			rs.close(); pst.close(); con.close();
			
		} catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * 
	 * @描述：  传递数据源  动态查询 返回 BeanList
	 * @param sql
	 * @param list
	 * @param clazz
	 * @param args
	 * @return List<T>
	 */
	public static <T> List<T> query(String sql, List<T> list, Class<T> clazz, Object... args){
		
		try
		{
			Connection con = ds.getConnection();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			/*动态设置占位符*/
			for (int i = 0; i < args.length; i++) {
				
				pst.setObject(i+1, args[i]);
			}
			/*执行SQL语句*/
			ResultSet rs = pst.executeQuery();
			
			list = BeanListHandler(rs, clazz, list);
		
			rs.close(); pst.close(); con.close();
			
		} catch (Exception e){
			
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	/**
	 * 
	 * @描述：  传递一个
	 * @param sql
	 * @param t
	 * @param args
	 * @return T
	 */
	public static <T> T query(String sql, Class<T> clazz, Object... args){
		
		Connection con = null;
		
		T t = null;
		
		try
		{
			con = ds.getConnection();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			/*动态设置占位符*/
			for (int i = 0; i < args.length; i++) {
				
				pst.setObject(i+1, args[i]);
			}
			
			ResultSet rs = pst.executeQuery();
			
			t = clazz.newInstance();
			
			t = BeanListHandler(rs, clazz, new ArrayList<T>()).get(0);
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}
		return t;
	}
	
	
	
	
	/**
	 * 
	 * @描述：  静态更新
	 * @param con
	 * @param sql
	 * @return boolean
	 */
	public static boolean update(Connection con, String sql){
		
		try
		{	
			con.setAutoCommit(false);
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			int iRes = pst.executeUpdate();
			
			pst.close(); 
			
			if(iRes > 0){
				con.commit();
				con.close();
				return true;
			}
			
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			try
			{
				con.rollback();
				con.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * @描述：  动态更新
	 * @param con
	 * @param sql
	 * @return boolean
	 */
	public static boolean update(Connection con, String sql, Object... args){
		
		try
		{	
			con.setAutoCommit(false);
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				
				pst.setObject(i+1, args[i]);
			}
			
			int iRes = pst.executeUpdate();
			
			pst.close(); 
			
			if(iRes > 0){
				con.commit();
				con.close();
				return true;
			}
			
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			try
			{
				con.rollback();
				con.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * @描述：  传递数据源，静态更新
	 * @param con
	 * @param sql
	 * @return boolean
	 */
	public static boolean update(String sql){
		
		Connection con = null;
		
		try
		{
			con = ds.getConnection();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			int iRes = pst.executeUpdate();
			
			pst.close(); 
			
			if(iRes > 0){
				con.commit();
				con.close();
				return true;
			}
			
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			try
			{
				con.rollback();
				con.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return false;
	}

	
	
	/**
	 * 
	 * @描述：  传递数据源，动态更新
	 * @param con
	 * @param sql
	 * @return boolean
	 */
	public static boolean update(String sql, Object... args){
		
		Connection con = null;
		
		try
		{
			con = ds.getConnection();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			for (int i = 0; i < args.length; i++) {
				
				pst.setObject(i+1, args[i]);
			}
			
			int iRes = pst.executeUpdate();
			
			pst.close();
			
			if(iRes > 0){
				con.commit();
				con.close();
				return true;
			}
			
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			try
			{
				con.rollback();
				con.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * @描述：  复制表数据到其他数据库
	 * @param srccon  源
	 * @param destcon 目标地
	 * @param srcTableName 表数据源
	 * @param sql	    插入sql语句
	 * @return boolean
	 */
	public static boolean moveTable(Connection srccon, Connection destcon, String srcTableName, String sql){
		
		return updateBatch(destcon, sql, ArrayListHandler(srccon, "select * from " + srcTableName));
	}
	
	
	
	/**
	 * 
	 * @描述：  处理Result结果集放入List<Object[]>
	 * @param srccon
	 * @param srcSql
	 * @return List<Object[]>
	 */
	public static List<Object[]> ArrayListHandler(Connection srccon, String srcSql) {
		
		List<Object[]> list = new ArrayList<Object[]>();
		
		try
		{
			PreparedStatement pst = srccon.prepareStatement(srcSql);
			
			ResultSet rs = pst.executeQuery();
			
			if( rs != null && rs.next() ){
				
				ResultSetMetaData rsmd = rs.getMetaData();
				
				int colCount = rsmd.getColumnCount();
				
				do{
					Object [] args = new Object [colCount];
					
					for (int i = 0; i < colCount; i++) {
						
						args[i] = rs.getObject(i+1);
					}
					list.add(args);
					
				} while (rs.next());
				
			}else{
				
				System.out.println("数据库返回结果集为空");
			}	
			rs.close(); pst.close(); srccon.close();
			
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	
	
	/**
	 * 
	 * @描述：  把数据放到List<Object[]> 批量更新
	 * @param destcon
	 * @param sql
	 * @param list
	 * @return boolean
	 */
	public static boolean updateBatch(Connection destcon, String sql, List<Object[]> list) {
		
		try
		{
			destcon.setAutoCommit(false);
			
			PreparedStatement pst = destcon.prepareStatement(sql);
			
			for (Object[] objects : list) {
				
				for (int i = 0; i < objects.length; i++) {
					
					pst.setObject(i + 1, objects[i]);
				}
				pst.addBatch();
			}
			
			pst.executeBatch(); pst.close();
			destcon.commit(); destcon.close();
			
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			
			try
			{
				destcon.rollback();
				destcon.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
		return false;
	}
	
	

	/**
	 * 
	 * @描述：  处理ResultSet 转换为 BeanList
	 * @param rs
	 * @param clazz
	 * @param list
	 * @return List<T>
	 */
	public static <T> List<T> BeanListHandler(ResultSet rs, Class<T> clazz, List<T> list){
		
		try
		{
			
			if( rs != null && rs.next() ){
				
				do{
					/**
					 * 游标存在，继续处理ResultSet
					 * 1.得到ResultSet元数据    ResultSetMetaData
					 * 2.获取ResultSet列的个数
					 * 3.获取JavaBean对象的属性数组
					 * 4.反射实例化对象class.newInstance
					 * 5.for循环取出Resulet每一列的值，
					 * 6.循环JavaBean对象的属性数组匹配列名和JavaBean对象的属性（忽略大小写）
					 * 7.赋值给匹配成功的属性
					 * 8.一行数据完成后把实例化对象放入List
					 * 9.return List
					 */
					ResultSetMetaData rsmd = rs.getMetaData();
					
					int colCount = rsmd.getColumnCount();//列的个数
					
					Field [] fields = clazz.getDeclaredFields();//JavaBean对象属性数组
					
					T t = clazz.newInstance();
					
					for (int i = 1; i <= colCount; i++) {
						
						Object value = rs.getObject(i);//获得每一列的值
						
						for (Field field : fields) {
							
							if(field.getName().equalsIgnoreCase(rsmd.getColumnName(i))){
								
								boolean flag = field.isAccessible();//获取此对象的可访问标志的值
								
								field.setAccessible(true);//设置为允许访问  取消封装
								
								field.set(t, value);//obj：应该修改字段的对象  value：为正在修改的obj的字段赋值
								
								field.setAccessible(flag);//设置回原来的值
							}
						}
					}
					list.add(t);
				
				}while(rs.next());
			
			}else{
				System.out.println("数据库返回结果集为空");
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return list;
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
	 * @描述：通过传递JavaBean的对象 获取javabean类中的get方法，执行把结果放入Object []
	 * @param t
	 * @return Object[]
	 */
	public static <T> Object [] getObjArrayByJavaBean(T t){
		
		Class<?> clazz = t.getClass();
		
		Field [] fields = clazz.getDeclaredFields();//JavaBean对象属性数组
		
		int len = fields.length;
		
		System.out.println("属性字段长度：--------》"+len);
		
		Object [] objects = new Object [len];
		
		try{
		
			for (int i = 0; i < len; i++) {
				
				Method getMethod = clazz.getMethod("get"+ initcap(fields[i].toString()));
				
//				fields[i].setAccessible(true);
//				Object val = fields[i].get(t);
//				fields[i].setAccessible(false);
				
				Object val = getMethod.invoke(t);
				
				objects[i] = val;
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return objects;
	}

	
	/**
	 * 
	 * @描述：  关闭数据库连接
	 * @param con 
	 */
	public static void closeConnection(Connection con){
		
		try{
			
			if(con != null && con.isClosed() == false){
				System.out.println("关闭成功");
				con.close();
			}
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}
	}

}
