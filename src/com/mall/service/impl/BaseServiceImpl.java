package com.mall.service.impl;

import com.mall.dao.BaseDao;
import com.mall.service.BaseService;

public class BaseServiceImpl implements BaseService {
	
	private BaseDao baseDao;

	@Override
	public Object checkLogin(String hql) {
		
		return baseDao.checkLogin(hql);
	}
	
/***************** 依赖注入setter 方法    ********************/	
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

/*********************************************************/	
}
