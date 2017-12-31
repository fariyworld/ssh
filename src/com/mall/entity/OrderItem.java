package com.mall.entity;

/**
 * 
 * @描述:  订单项
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月30日下午7:53:53
 */
public class OrderItem {

	// Fields

	private String OItemid;
	private Order order;
	private Double price;
	private Integer orderCount;

	private Product product;

	/** default constructor */
	public OrderItem() {
	}

	/** full constructor */
	public OrderItem(Product product, Order order, Double price,
			Integer orderCount) {
		this.product = product;
		this.order = order;
		this.price = price;
		this.orderCount = orderCount;
	}

	// Property accessors

	public String getOItemid() {
		return this.OItemid;
	}

	public void setOItemid(String OItemid) {
		this.OItemid = OItemid;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getOrderCount() {
		return this.orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

}