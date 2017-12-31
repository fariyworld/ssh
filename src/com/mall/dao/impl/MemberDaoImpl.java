package com.mall.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.mall.dao.MemberDao;
import com.mall.entity.Member;
import com.mall.tools.DBUtils;
import com.mall.tools.Tools;


public class MemberDaoImpl implements MemberDao {
	
	private HibernateTemplate hbTemplate;
	
/***************** 依赖注入setter 方法    ********************/	
	
	public void setHbTemplate(HibernateTemplate hbTemplate) {
		this.hbTemplate = hbTemplate;
	}
	
/*********************************************************/	
	
	
	@Override
	public boolean verifyUserName(final String userName) {
		
		Member member = null;
		
		member = hbTemplate.execute(new HibernateCallback<Member>() {

			@Override
			public Member doInHibernate(Session session) throws HibernateException {
				
				String hql = "from Member where userName = ?";
				
				Query query = session.createQuery(hql);
				
				query.setParameter(0, userName);
				
				return (Member) query.uniqueResult();
			}
		});
		
		if ( member == null) return true;
		
		else return false;
	}

	@Override
	public boolean save(Member member) {
		
		System.out.println("保存注册用户dao");
		
		member.setActiveCode(Tools.getActiveCode());
		
		member.setRegTime(Tools.getTimestamp());
		
		if (hbTemplate.save(member) == null ) return false;
		
		else return true;
	}
	
	@Override
	public Member getMemberByUIDPWD(final Integer uid, final String pwd) {
		
		return hbTemplate.execute(new HibernateCallback<Member>() {

			@Override
			public Member doInHibernate(Session session) throws HibernateException {
				
				String hql = "from Member where uid = ? and password = ? ";
				
				Query query = session.createQuery(hql);
				
				query.setParameter(0, uid);
				query.setParameter(1, pwd);
				
				Member member = (Member) query.uniqueResult();
				
				System.out.println(member);
				
				return member;
			}
		});
	}
	
	
	@Override
	public void updateMemberPWD(Integer uid, String pwd) {
		
		Member member = hbTemplate.get(Member.class, uid);
		
		member.setPassword(pwd);
		
		hbTemplate.update(member);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getMemberList() {
		
		return (List<Member>) hbTemplate.find("from Member");
	}

	@Override
	public void deleteMemberByID(Integer uid) {
		
		hbTemplate.delete(hbTemplate.get(Member.class, uid));
	}

	@Override
	public Member getMemberByID(Integer uid) {
		
		return DBUtils.query("select * from member where uid = ?", Member.class, uid);
	}

	@Override
	public void updateMemberInfo(Member member) {
		
		Member member2 = hbTemplate.get(Member.class, member.getUid());
		
		member2.setAddress(member.getAddress());
		member2.setPhone(member.getPhone());
		member2.setEmail(member.getEmail());
		
		hbTemplate.update(member2);
	}

}
