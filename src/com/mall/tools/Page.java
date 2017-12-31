package com.mall.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @描述:  分页工具类
 * @author: 黄土高坡的宝宝
 * @创建日期: 2017年11月23日下午7:28:54
 */
public class Page <T> {
	
	private Integer totalRecord; 	//总记录数
	private Integer totalPage;	 	//总页数
	private Integer pageSize;		//每页显示记录数
	private Integer currentPage;	//当前页
	
	private List<T> list = new ArrayList<T>();//查询结果集

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
