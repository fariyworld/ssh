package com.mall.service.impl;

import java.util.List;

import com.mall.dao.MemberDao;
import com.mall.entity.Member;
import com.mall.service.MemberService;


public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
/***************** 依赖注入setter 方法    ********************/	

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
/*********************************************************/	

	@Override
	public boolean verifyUserName(String userName) {
		
		return memberDao.verifyUserName(userName);
	}

	@Override
	public boolean save(Member member) {
		
		return memberDao.save(member);
	}
	
	@Override
	public Member getMemberByUIDPWD(Integer uid, String pwd) {
		
		return memberDao.getMemberByUIDPWD(uid, pwd);
	}
	
	@Override
	public void updateMemberPWD(Integer uid, String pwd) {
		
		memberDao.updateMemberPWD(uid, pwd);
	}
	
	@Override
	public List<Member> getMemberList() {
		
		return memberDao.getMemberList();
	}
	
	@Override
	public void deleteMemberByID(Integer uid) {
		
		memberDao.deleteMemberByID(uid);
	}
	@Override
	public Member getMemberByID(Integer uid) {
		
		return memberDao.getMemberByID(uid);
	}
	@Override
	public void updateMemberInfo(Member member) {
		
		memberDao.updateMemberInfo(member);
	}
	
}
