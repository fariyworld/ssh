package com.mall.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @描述:  商城注册用户表Member
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月30日下午7:44:17
 */
public class Member {

	// Fields
	private Integer uid;
	private String userName;
	private String password;
	
	private String address;
	private String realName;
	private String idcard;
	
	private String cardType;
	private Integer grade;
	private Double totalMount;
	
	private String phone;
	private String email;
	private String loginStatus;
	
	private String activeCode;
	private String flag;
	private Timestamp regTime;
	private Timestamp modifyTime;
	
	
	private Set<Order> orders = new HashSet<Order>();
	private Set<Message> messages = new HashSet<Message>();
	private Set<ProductComment> productComments = new HashSet<ProductComment>();

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String userName, String password, Integer grade,
			Double totalMount) {
		this.userName = userName;
		this.password = password;
		this.grade = grade;
		this.totalMount = totalMount;
	}

	/** full constructor */
	public Member(String userName, String password, String address,
			String realName, String idcard, String cardType, Integer grade,
			Double totalMount, String phone, String email, String loginStatus,
			String activeCode, String flag, Timestamp regTime,
			Timestamp modifyTime, Set<Order> orders, Set<Message> messages, Set<ProductComment> productComments) {
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.realName = realName;
		this.idcard = idcard;
		this.cardType = cardType;
		this.grade = grade;
		this.totalMount = totalMount;
		this.phone = phone;
		this.email = email;
		this.loginStatus = loginStatus;
		this.activeCode = activeCode;
		this.flag = flag;
		this.regTime = regTime;
		this.modifyTime = modifyTime;
		this.orders = orders;
		this.messages = messages;
		this.productComments = productComments;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Double getTotalMount() {
		return this.totalMount;
	}

	public void setTotalMount(Double totalMount) {
		this.totalMount = totalMount;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginStatus() {
		return this.loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getActiveCode() {
		return this.activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public Set<ProductComment> getProductComments() {
		return this.productComments;
	}

	public void setProductComments(Set<ProductComment> productComments) {
		this.productComments = productComments;
	}

	@Override
	public String toString() {
		return "Member [uid=" + uid + ", userName=" + userName + ", password="
				+ password + ", address=" + address + ", realName=" + realName
				+ ", idcard=" + idcard + ", cardType=" + cardType + ", grade="
				+ grade + ", totalMount=" + totalMount + ", phone=" + phone
				+ ", email=" + email + ", loginStatus=" + loginStatus
				+ ", activeCode=" + activeCode + ", flag=" + flag
				+ ", regTime=" + regTime + ", modifyTime=" + modifyTime
				+ "]";
	}
	
}