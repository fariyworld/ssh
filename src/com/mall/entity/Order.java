package com.mall.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @描述:  订单表
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月30日下午7:51:21
 */
public class Order {

	// Fields

	private Integer orderId;
	private Member member;
	private String realName;
	
	private String address;
	private String tel;
	private String pay;
	
	private String sendMethod;
	private Double totalMount;
	private Integer totalCount;
	
	private Double rebate;
	private String orderStatus;
	private String flag;
	private Timestamp orderTime;
	
	
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();


	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Member member, String realName, String address, String tel,
			String pay, String sendMethod, Double totalMount,
			Integer totalCount, String flag) {
		this.member = member;
		this.realName = realName;
		this.address = address;
		this.tel = tel;
		this.pay = pay;
		this.sendMethod = sendMethod;
		this.totalMount = totalMount;
		this.totalCount = totalCount;
		this.flag = flag;
	}

	/** full constructor */
	public Order(Member member, String realName, String address, String tel,
			String pay, String sendMethod, Double totalMount,
			Integer totalCount, Double rebate, String orderStatus, String flag,
			Timestamp orderTime, Set<OrderItem> orderItems) {
		this.member = member;
		this.realName = realName;
		this.address = address;
		this.tel = tel;
		this.pay = pay;
		this.sendMethod = sendMethod;
		this.totalMount = totalMount;
		this.totalCount = totalCount;
		this.rebate = rebate;
		this.orderStatus = orderStatus;
		this.flag = flag;
		this.orderTime = orderTime;
		this.orderItems = orderItems;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPay() {
		return this.pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getSendMethod() {
		return this.sendMethod;
	}

	public void setSendMethod(String sendMethod) {
		this.sendMethod = sendMethod;
	}

	public Double getTotalMount() {
		return this.totalMount;
	}

	public void setTotalMount(Double totalMount) {
		this.totalMount = totalMount;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Double getRebate() {
		return this.rebate;
	}

	public void setRebate(Double rebate) {
		this.rebate = rebate;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}