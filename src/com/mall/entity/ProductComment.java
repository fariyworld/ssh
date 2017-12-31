package com.mall.entity;

import java.sql.Timestamp;

/**
 * 
 * @描述:  商品评论表
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月30日下午7:56:05
 */
public class ProductComment {

	// Fields

	private Integer PCid;
	private Product product;
	private String content;
	private Timestamp addTime;

	private Member member;

	/** default constructor */
	public ProductComment() {
	}

	/** minimal constructor */
	public ProductComment(Member member, Product product, String content) {
		this.member = member;
		this.product = product;
		this.content = content;
	}

	/** full constructor */
	public ProductComment(Member member, Product product, String content,
			Timestamp addTime) {
		this.member = member;
		this.product = product;
		this.content = content;
		this.addTime = addTime;
	}

	// Property accessors

	public Integer getPCid() {
		return this.PCid;
	}

	public void setPCid(Integer PCid) {
		this.PCid = PCid;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}