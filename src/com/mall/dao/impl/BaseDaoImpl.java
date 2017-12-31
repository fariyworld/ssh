package com.mall.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.mall.dao.BaseDao;

public class BaseDaoImpl implements BaseDao {
	
	private HibernateTemplate hbTemplate;

	@Override
	public Object checkLogin(final String hql) {
		
		return hbTemplate.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				Query query = session.createQuery(hql);
				
				return query.uniqueResult();
			}
		});
	}
	
/***************** 依赖注入setter 方法    ********************/	
	
	public void setHbTemplate(HibernateTemplate hbTemplate) {
		this.hbTemplate = hbTemplate;
	}

/*********************************************************/	

}
