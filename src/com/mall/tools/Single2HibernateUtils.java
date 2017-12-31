package com.mall.tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @描述:  <!-- 支持线程绑定session对象 -->
 * <property name="hibernate.current_session_context_class">thread</property>
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月23日下午8:16:56
 */
public class Single2HibernateUtils {

	private static final SessionFactory sf = bulidFactory();
	
	public static ThreadLocal<Session> lock = new ThreadLocal<Session>(); 

	private static SessionFactory bulidFactory() {
		
		return new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession(){
		
		Session session = lock.get();
		
		if( session == null ){
			
			session = sf.openSession();
			lock.set(session);
		}
		
		return session;
	}
	
	public static void closeSession(){
		
		Session session = lock.get();
		
		if( session != null ){
		
			session.close();
			lock.set(null);
		}
	}
	
	public static Session getCurrentSession(){
		
		return sf.getCurrentSession();
	}
}
