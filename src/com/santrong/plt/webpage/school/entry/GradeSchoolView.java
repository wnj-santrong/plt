package com.santrong.plt.webpage.school.entry;

import java.util.List;

/**
 * @author weinianjie
 * @date 2014年10月9日
 * @time 下午7:20:10
 */
public class GradeSchoolView {
	private String gradeName;
	private int gradeGroup;
	private String gradeEnName;
	private List<SchoolTotalView> schoolList;
	
	public String getGradeEnName() {
		return gradeEnName;
	}
	public void setGradeEnName(String gradeEnName) {
		this.gradeEnName = gradeEnName;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public int getGradeGroup() {
		return gradeGroup;
	}
	public void setGradeGroup(int gradeGroup) {
		this.gradeGroup = gradeGroup;
	}
	public List<SchoolTotalView> getSchoolList() {
		return schoolList;
	}
	public void setSchoolList(List<SchoolTotalView> schoolList) {
		this.schoolList = schoolList;
	}
}
