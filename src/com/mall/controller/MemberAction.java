package com.mall.controller;

import java.util.ArrayList;
import java.util.List;

import com.mall.entity.Member;
import com.mall.formBean.Member_Form;
import com.mall.service.BaseService;
import com.mall.service.MemberService;
import com.mall.tools.Tools;


public class MemberAction {
	
/***********  接收页面数据    ****************/	
	
	private String role;
	private String account;
	private String password;
	private String userName;
	private Member member;
	
	private Integer uid;
	private String pwd;
	private String tips;

/*************  回传数据  ******************/
	
	private Object object;
	private String result;
	private List<Member_Form> memList = new ArrayList<Member_Form>();
	
/*************  依赖对象  ******************/
	
	private BaseService baseService;
	private MemberService memberService;
	
/*************  请求处理方法  ***************/	
	
	public String login(){
		
		/*把表单的三个数据拼接成一条hql语句，传到baseservice中 调用 checkLogin（）验证*/
		String hql = "";
		
		if ( role.equals("Admin") ) hql = "from "+ role +" where adminName = '"+ account +"' and password = '"+password +"'";
		
		else hql = "from "+ role +" where userName = '"+ account +"' and password = '"+password +"'";
		
		object = baseService.checkLogin(hql);
		
		if ( object != null) return "success";
			
		else return "failure";
	}
	
	public String register(){
		
		if (memberService.save(member)) result = "成功跳转至action，注册用户成功";
		
		else result = "注册失败，回到action";
		
		return "ajax";
	}
	
	public String checkUserNameisExist(){
		
		if ( !memberService.verifyUserName(userName)) result = "1";
		
		else result="0";

		return "ajax";
	}
	
	public String checkPWD(){
		
		Member mem = memberService.getMemberByUIDPWD(uid, pwd);
		
		if( mem == null) result = "0";
		
		else result = "1";
		
		return "ajax";
	}
	
	public String updatePWD(){
		
		memberService.updateMemberPWD(uid, pwd);
		
		result = "修改成功";
		
		return "ajax";
	}
	
	public String queryMember(){
		
		memList = Tools.pageBeanList(memberService.getMemberList(), Member_Form.class, memList);
		
		return "ajax";
		
	}
	
	public String deleteMember(){
		
		System.out.println("调用service方法删除用户---->"+ uid);
		
		memberService.deleteMemberByID(uid);
		
		result = "delete success";
		
		return "ajax";
	}
	
	public String updateMember(){
		
		if(tips.equals("w")){
			
			System.out.println("回显数据--主键---》"+ uid);
			
			member = memberService.getMemberByID(uid);
			
		}else{
			
			System.out.println("页面数据--主键-->"+ member.getUid());
			
			memberService.updateMemberInfo(member);
			
			result = "update memberInfo success";
		}
		return "ajax";
	}
/*************** setter-getter 方法  ***********************/	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public List<Member_Form> getMemList() {
		return memList;
	}

	public void setMemList(List<Member_Form> memList) {
		this.memList = memList;
	}
	
	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

/***************** 依赖注入setter 方法    ********************/	
	
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
/*********************************************************/	
}
