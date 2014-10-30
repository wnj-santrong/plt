package com.santrong.plt.webpage.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;
import com.santrong.plt.criteria.Statement;
import com.santrong.plt.log.Log;
import com.santrong.plt.opt.ThreadUtils;
import com.santrong.plt.util.AreaUtils;
import com.santrong.plt.util.BeanUtils;
import com.santrong.plt.util.MyUtils;
import com.santrong.plt.webpage.BaseDao;
import com.santrong.plt.webpage.course.entry.CourseDetailView;
import com.santrong.plt.webpage.course.entry.CourseItem;
import com.santrong.plt.webpage.course.entry.CourseQuery;
import com.santrong.plt.webpage.course.entry.CourseView;

/**
 * @author weinianjie
 * @date 2014年10月10日
 * @time 上午10:54:10
 */
public class CourseDao extends BaseDao {
	
	// 根据年级和地区获取课程，首页
	public List<CourseView> selectForIndexList(int gradeGroup, String areaCode) {
		CourseMapper mapper = this.getMapper(CourseMapper.class);
		if(mapper != null) {
			return mapper.selectForIndexList(gradeGroup, areaCode);
		}
		return null;
	}
	
	// 获取课程详细信息
	public CourseDetailView selectDetailById(String id) {
		CourseMapper mapper = this.getMapper(CourseMapper.class);
		if(mapper != null) {
			return mapper.selectDetailById(id);
		}
		return null;
	}
	
	// 根据具体搜索条件查询
	public List<CourseItem> selectByQuery() {
		CourseMapper mapper = this.getMapper(CourseMapper.class);
		if(mapper != null) {
			return mapper.selectByQuery();
		}
		return null;
	}
	
	/**
	 * 查询某位老师的所有课程信息
	 * @author huangweihua
	 * @param  ownerId
	 * @return List<CourseItem>
	 */
	public List<CourseItem> selectByUserid(String userid){
		CourseMapper mapper = this.getMapper(CourseMapper.class);
		if(mapper != null) {
			return mapper.selectByUserid(userid);
		}
		return null;
	}

	/**
	 * 根据具体搜索条件查询课程
	 * @param query
	 * @return
	 */
	public 	List<CourseItem> selectByQuery(CourseQuery query) {
		List<CourseItem> list = new ArrayList<CourseItem>();
		
		try{
			Statement criteria = new Statement("course", "a");
			criteria.setFields("a.*");
			criteria.ljoin("subject", "b", "a.subjectId", "b.id");
			criteria.ljoin("grade", "c", "a.gradeId", "c.id");
			criteria.ljoin("user", "d", "a.ownerId", "d.id");
			criteria.ljoin("school", "e", "d.schoolId", "e.id");
			
			// 关键词
			if(!StringUtils.isNullOrEmpty(query.getKeywords())) {
				criteria.where(or(
						like("a.courseName", "?")));
				criteria.setStringParam("%" + query.getKeywords() + "%");
			}
			// 科目条件
			if(MyUtils.isNotNull(query.getSubjectEnName())) {
				criteria.where(eq("b.subjectEnName", "?"));
				criteria.setStringParam(query.getSubjectEnName());
			}
			// 类别条件
			if(MyUtils.isNotNull(query.getGradeEnName())) {
				criteria.where(eq("c.gradeEnName", "?"));
				criteria.setStringParam(query.getGradeEnName());
			}
			// 年级条件
			if(MyUtils.isNotNull(query.getLevelEnName())) {
				criteria.where(eq("c.LevelEnName", "?"));
				criteria.setStringParam(query.getLevelEnName());
			}
			// 是否含有直播
			if(query.isLive()) {
				
			}
			// 所属区域
			if(MyUtils.isNotNull(query.getAreaCode())) {
				criteria.where(like("e.areaCode", "?"));
				criteria.setStringParam(AreaUtils.lostTail(query.getAreaCode()) + "%");
			}
			// 排序
			if(!StringUtils.isNullOrEmpty(query.getOrderBy())) {
				if("desc".equalsIgnoreCase(query.getOrderRule())) {
					criteria.desc("a." + query.getOrderBy());
				}else {
					criteria.asc("a." + query.getOrderBy());
				}
			}
			
			// 分页
			criteria.limit(query.getLimitBegin(), query.getLimitEnd());
			
			Connection conn = ThreadUtils.currentConnection();
			PreparedStatement stm = criteria.getRealStatement(conn);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				CourseItem item = new CourseItem();
				BeanUtils.Rs2Bean(rs, item);
				list.add(item);
			}
			
		}catch(Exception e){
			Log.printStackTrace(e);
		}
		
		return list;
	}	
	
	/**
	 * 根据具体搜索条件查询课程总数
	 * @param query
	 * @return
	 */
	public 	int selectCountByQuery(CourseQuery query) {
		int count = 0;
		
		try{
			Statement criteria = new Statement("course", "a");
			criteria.setFields("count(*) cn");
			criteria.ljoin("subject", "b", "a.subjectId", "b.id");
			criteria.ljoin("grade", "c", "a.gradeId", "c.id");
			criteria.ljoin("user", "d", "a.ownerId", "d.id");
			criteria.ljoin("school", "e", "d.schoolId", "e.id");
			
			// 关键词
			if(!StringUtils.isNullOrEmpty(query.getKeywords())) {
				criteria.where(or(
						like("a.courseName", "?")));
				criteria.setStringParam("%" + query.getKeywords() + "%");
			}
			// 科目条件
			if(MyUtils.isNotNull(query.getSubjectEnName())) {
				criteria.where(eq("b.subjectEnName", "?"));
				criteria.setStringParam(query.getSubjectEnName());
			}
			// 类别条件
			if(MyUtils.isNotNull(query.getGradeEnName())) {
				criteria.where(eq("c.gradeEnName", "?"));
				criteria.setStringParam(query.getGradeEnName());
			}
			// 年级条件
			if(MyUtils.isNotNull(query.getLevelEnName())) {
				criteria.where(eq("c.LevelEnName", "?"));
				criteria.setStringParam(query.getLevelEnName());
			}
			// 是否含有直播
			if(query.isLive()) {
				
			}
			// 所属区域
			if(MyUtils.isNotNull(query.getAreaCode())) {
				criteria.where(like("e.areaCode", "?"));
				criteria.setStringParam(AreaUtils.lostTail(query.getAreaCode()) + "%");
			}
			
			Connection conn = ThreadUtils.currentConnection();
			PreparedStatement stm = criteria.getRealStatement(conn);
			ResultSet rs = stm.executeQuery();
			rs.next();
			count = rs.getInt("cn");
			
		}catch(Exception e){
			Log.printStackTrace(e);
		}
		
		return count;
	}
	
	/**
	 * 查询某间学校的所有课程信息
	 * @author huangweihua
	 * @param  schoolId
	 * @return List<CourseItem>
	 */
	public List<CourseItem> selectCourseBySchoolId(String schoolId) {
		CourseMapper mapper = this.getMapper(CourseMapper.class);
		if(mapper != null){
			return mapper.selectCourseBySchoolId(schoolId);
		}
		return null;
	}
	
}