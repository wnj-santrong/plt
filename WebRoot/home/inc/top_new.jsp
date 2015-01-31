<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="menu">
	<div class="menu_top">
		<div class="logo">
			<img src="${ctx}/resource/images/logo.png" width="260" height="52">
		</div>
		<c:if test="${sessionScope.loginUser != null}">
			<div class="hea_new"><a href="${ctx}/study/syllabus">学习中心</a>|<a href="${ctx}/study/center">个人空间</a>|<a href="${ctx}/account/personalInfo">${sessionScope.loginUser.showName}</a></div>
		</c:if>
		<div class="hea_nav">
			<a href="${ctx}/" class="a_a">首页</a>
			<a href="${ctx}/weike" class="a_b">学堂</a>
			<a href="${ctx}/course" class="a_c">直播课</a>
			<a href="${ctx}/war" class="a_d">挑战</a>
		</div>
	</div>
</div>