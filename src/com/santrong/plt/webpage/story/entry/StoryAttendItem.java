package com.santrong.plt.webpage.story.entry;

import java.util.Date;


/**
 * @author weinianjie
 * @date 2015年2月2日
 * @time 上午11:43:34
 */
public class StoryAttendItem {
	
	private String id;
	private String userId;
	private String storyId;
	private int attendType;
	private Date cts;
	private Date uts;
	
	public static  int Type_View = 0;// 观看

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}

	public int getAttendType() {
		return attendType;
	}

	public void setAttendType(int attendType) {
		this.attendType = attendType;
	}

	public Date getCts() {
		return cts;
	}

	public void setCts(Date cts) {
		this.cts = cts;
	}

	public Date getUts() {
		return uts;
	}

	public void setUts(Date uts) {
		this.uts = uts;
	}
}
