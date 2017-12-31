package com.mall.service;

import java.util.List;

import com.mall.entity.Member;


public interface MemberService {
	
	public boolean verifyUserName(String userName);

	public boolean save(Member member);

	public Member getMemberByUIDPWD(Integer uid, String pwd);

	public void updateMemberPWD(Integer uid, String pwd);

	public List<Member> getMemberList();

	public void deleteMemberByID(Integer uid);

	public Member getMemberByID(Integer uid);

	public void updateMemberInfo(Member member);

}
