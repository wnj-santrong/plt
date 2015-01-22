package com.santrong.plt.webpage.course.resource.train.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.santrong.plt.webpage.course.resource.train.entry.KnowledgeItem;
import com.santrong.plt.webpage.course.resource.train.entry.KnowledgePointerView;

/**
 * @author huangweihua
 * @date 2014年12月25日
 * @time 下午4:38:42
 */
public interface KnowledgeMapper {
	
	@Insert("insert into knowledge values( #{id}, #{code}, #{level}, #{knowledgeName}, #{subjectId}, #{gradeId}, #{unitId}, #{priority})")
	int insert(KnowledgeItem knowledgeItem);
	
	@Update("update knowledge set code=#{code},level=#{level},knowledgeName = #{knowledgeName}, subjectId = #{subjectId}, gradeId = #{gradeId},unitId=#{unitId},priority=#{priority} where id = #{id}")
	int update(KnowledgeItem knowledgeItem);
	
	@Delete("delete from knowledge where id = #{id}")
	int deleteById(String id);
	
	@Select("select * from knowledge where id = #{id}")
	KnowledgeItem selectById(String id);
	
	@Select("select count(*) from knowledge where knowledgeName = #{knowledgeName} and gradeId = #{gradeId} and subjectId = #{subjectId} and unitId = #{unitId} ")
	int exists(@Param("knowledgeName")String knowledgeName, @Param("gradeId")String gradeId, @Param("subjectId")String subjectId, @Param("unitId")String unitId);
	
	@Select("select * from knowledge where knowledgeName = #{knowledgeName} order by code asc")
	List<KnowledgeItem> selectByName(String knowledgeName);
	
	@Select("select * from knowledge where id in (${ids}) order by code asc")
	List<KnowledgeItem> selectByIds(@Param("ids")String ids);
	
	/**
	 * 根据gradeId（年级）、subjectId（学科），获取多个知识点
	 * @author huangweihua
	 * @param gradeId
	 * @param subjectId
	 * @return
	 */
	@Select("select * from knowledge where gradeId = #{gradeId} and subjectId = #{subjectId} order by code asc,priority asc")
	List<KnowledgeItem> selectByGIdAndSId(@Param("gradeId")String gradeId, @Param("subjectId")String subjectId);
	
	/**
	 * 根据unitId（单元），获取多个知识点
	 * @author huangweihua
	 * @param unitId
	 * @return
	 */
	@Select("select * from knowledge where unitId = #{unitId} order by code asc,priority asc")
	List<KnowledgeItem> selectByUnitId(String unitId);
	
	@Select("select * from knowledge order by code, priority")
	List<KnowledgeItem> selectAll();
	
	/**
	 * 根据code范围和level树的级别，获取知识点的列表记录
	 * @param maxCode
	 * @param minCode
	 * @param level
	 * @return
	 */
	@Select("select * from knowledge where code <= #{maxCode} and code >= #{minCode} and level = #{level} order by code asc,priority asc")
	List<KnowledgeItem> selectByCodeRange(@Param("maxCode")int maxCode, @Param("minCode")int minCode, @Param("level")int level);
	
	@Select("select max(priority) from knowledge where code <= #{maxCode} and code >= #{minCode} and level = #{level} order by code asc")
	int selectMaxPriorityByCodeRange(@Param("maxCode")int maxCode, @Param("minCode")int minCode, @Param("level")int level);
	
	// 获取用户的知识图表
	@Select("select e.*,count(*) as total, sum(b.result) as goal from competition_attend a "
			+ "left join competition_history b on a.id=b.attendId and a.userId=#{userId}"
			+ "left join resource_train_question c on b.questionId=c.id "
			+ "left join question_to_knowledge d on c.id=d.questionId "
			+ "right join knowledge e on d.knowledgeId=e.id "
			+ "where e.subjectId=#{subjectId} and e.gradeId=#{gradeId} group by e.id "
			+ "order by e.unitId asc, e.priority asc")
	List<KnowledgePointerView> selectUserKnowledgeMap(@Param("userId")String userId, @Param("subjectId")String subjectId, @Param("gradeId")String gradeId);
	
}
