package com.mall.entity;

import java.sql.Timestamp;

/**
 * 
 * @描述:  留言表
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月30日下午7:49:52
 */
public class Message {

	// Fields

	private Integer mid;
	private String title;
	private String content;
	private Timestamp addTime;
	private String reply;
	private Timestamp replyTime;

	private Member member;

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Member member, String title, String content,
			Timestamp addTime) {
		this.member = member;
		this.title = title;
		this.content = content;
		this.addTime = addTime;
	}

	/** full constructor */
	public Message(Member member, String title, String content,
			Timestamp addTime, String reply, Timestamp replyTime) {
		this.member = member;
		this.title = title;
		this.content = content;
		this.addTime = addTime;
		this.reply = reply;
		this.replyTime = replyTime;
	}

	// Property accessors
	
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

}