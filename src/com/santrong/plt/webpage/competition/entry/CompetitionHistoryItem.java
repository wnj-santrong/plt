package com.santrong.plt.webpage.competition.entry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.santrong.plt.util.MyUtils;
import com.santrong.plt.webpage.course.resource.train.entry.TrainQuestionItem;

/**
 * @author weinianjie
 * @date   2014年11月6日 
 * @time   下午3:44:18
 */
public class CompetitionHistoryItem {

	private String id;
	private String attendId;
	private String questionId;
	private String answer;
	private int result;
	private Date cts;
	private Date uts;
	
	/**
	 * 答题正确，结果为1
	 */
	public static final int ANSWER_IS_RIGHT		=	1;
	/**
	 * 答题错误，结果为0
	 */
	public static final int ANSWER_IS_WRONG		=	0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAttendId() {
		return attendId;
	}
	public void setAttendId(String attendId) {
		this.attendId = attendId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
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
	
	/**
	 * 通过算法计算出答案的总和<br>
	 * 适用范围：单选题、多选题、判断题
	 * @author huangweihua
	 * @param answer
	 * @return int
	 */
	public int getSumAnswer() {
		int sum = 0;
		String[] answerArray = getAnswerArray();
		if (answerArray.length > 0) {
			for (String str : answerArray) {
				sum += MyUtils.stringToInt(str);
			}
		}
		return sum;
	}
	
	/**
	 * 把答案转成字符串数组的格式<br>
	 * 目前答案保存格式为 1,2,4,8<br>
	 * 适用范围：单选题、多选题、判断题
	 * @author huangweihua
	 * @param answer
	 * @return String[]
	 */
	public String[] getAnswerArray() {
		String[] answerArray = null;
		answerArray = this.answer.split(","); 
		return answerArray;
	}
	
	/**
	 * 把答案的总和通过位运算后，获取答案选项对应的字母{"A","B","C","D"。。。}<br>
	 * 适用范围：单选题、多选题、判断题
	 * @return List<\String>
	 */
	public List<String> getAnswerString() {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<TrainQuestionItem.Answers.length;i++) {
			if((getSumAnswer() & TrainQuestionItem.Answers[i]) == TrainQuestionItem.Answers[i]) {
				list.add(TrainQuestionItem.Answers_Options[i]);
			}
		}
		return list;
	}
}
