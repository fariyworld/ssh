package com.mall.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @描述:  商品表
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月30日下午7:54:27
 */
public class Product {

	// Fields

	private Integer pid;
	private String productId;
	private String productName;
	
	private String productType;
	private String productImg;
	private String description;
	
	private Double price;
	private Double nowPrice;
	private Integer stock;
	
	private String brand;
	private String isnewProduct;
	private String sale;
	
	private Integer viewCount;
	private Timestamp addTime;
	
	
	private Set<ProductComment> productComments = new HashSet<ProductComment>();
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();


	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String productId) {
		this.productId = productId;
	}

	/** full constructor */
	public Product(String productId, String productName, String productType,
			String productImg, String description, Double price,
			Double nowPrice, Integer stock, String brand, String isnewProduct,
			String sale, Integer viewCount, Timestamp addTime,
			Set<ProductComment> productComments, Set<OrderItem> orderItems) {
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productImg = productImg;
		this.description = description;
		this.price = price;
		this.nowPrice = nowPrice;
		this.stock = stock;
		this.brand = brand;
		this.isnewProduct = isnewProduct;
		this.sale = sale;
		this.viewCount = viewCount;
		this.addTime = addTime;
		this.productComments = productComments;
		this.orderItems = orderItems;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductImg() {
		return this.productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getNowPrice() {
		return this.nowPrice;
	}

	public void setNowPrice(Double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getIsnewProduct() {
		return this.isnewProduct;
	}

	public void setIsnewProduct(String isnewProduct) {
		this.isnewProduct = isnewProduct;
	}

	public String getSale() {
		return this.sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public Integer getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Set<ProductComment> getProductComments() {
		return this.productComments;
	}

	public void setProductComments(Set<ProductComment> productComments) {
		this.productComments = productComments;
	}

	public Set<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}