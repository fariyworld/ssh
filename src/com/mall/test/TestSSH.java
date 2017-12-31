package com.mall.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.mall.entity.Admin;
import com.mall.tools.DBUtils;


public class TestSSH {
	
	/**
	 * 
	 * @描述：  测试建表(sshdemo)
	 * @throws Exception void
	 */
	@Test
	public void testBulidTable() throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		tr.commit();
		
		session.close();
		sessionFactory.close();
		context.close();
	}
	
	/**
	 * 
	 * @描述：  测试HibernateTemplate
	 * @throws Exception void
	 */
	@Test
	public void testHibernateTemplate() throws Exception {
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hbTemplate");
		
		System.out.println(hibernateTemplate.get(Admin.class, 1));
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		
		DBUtils.update("update member set loginStatus = 0 where uid = 2");
	}
	
}
