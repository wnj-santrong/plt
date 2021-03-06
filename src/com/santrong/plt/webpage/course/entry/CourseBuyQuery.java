package com.santrong.plt.webpage.course.entry;

import com.santrong.plt.opt.PageQuery;

/**
 * @author weinianjie
 * @date 2014年10月9日
 * @time 下午4:06:04
 */
public class CourseBuyQuery extends PageQuery{
	private String keywords;
	private String userId;
	private Integer orderStatus;
	
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
