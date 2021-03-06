<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/common.jsp"%>
<c:set var="title" value="三简在线教育平台" ></c:set>
<c:set var="keywords" value="456" ></c:set>
<c:set var="description" value="789" ></c:set>
<%@ include file="../../inc/header.jsp"%>
<script type="text/javascript">
var Globals = {};
Globals.ctx = "${ctx}";
Globals.lang = "${lang}";
Globals.page = "Manage_myTrainMList";
</script>
</head>
<body>
	<%@ include file="../../inc/top_bg.jsp"%>
	<div id="container_box">
    	<div id="container_content">
			<div class="sectionMain clr">
		        <%@ include file="../../inc/leftmenu_teacher.jsp"%>
				<div class="sh_info_r">
					<div class="sh_title">
						<h2>试题列表</h2>
						<a href="${ctx}/manage/question/addOrModifyQuestion" class="sh_add">+新增</a>
					</div>
					<div class="sh_collection">
						<table border="1" class="sh_coll_tab">
							<colgroup>
								<col width="60">
								<col width="310">
								<col width="200">
								<col width="200">
								<col width="200">
							</colgroup>
							<thead>
								<tr>
									<th>序号</th>
									<th>试题描述</th>
									<th>试题类型</th>
									<th>创建时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${questionList}"  var="question" varStatus="qt">
									<tr>
										<td>${qt.index + 1 + (query.pageNum-1)*query.pageSize}</td>
										<td>${question.topic}</td>
										<td>${question.typeString}</td>
										<td><fmt:formatDate value="${question.cts}" type="date" dateStyle="default" /></td>
										<td class="btn_question_operation">
										<div class="btn_question_update">
											<form action="${ctx}/manage/question/addOrModifyQuestion" method="get">
												<input type="hidden" value="${question.id}" name="questionId" />
												<input type="submit" value="修改" />
											</form>
										</div>
										<div class="btn_question_delete">
											<form action="${ctx}/manage/question/delete" method="post">
												<input type="hidden" value="${question.id}" name="questionId" />
												<input type="submit" value="删除" />
											</form>
										</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<c:if test="${fn:length(query.pageSequence) > 1}">
								<tfoot>
									<tr>
										<td colspan="5">
											<c:set var="basicUrl" value="${ctx}/manage/question/list" />
				            				<%@ include file="../../inc/pagination.jsp"%>
										</td>
									</tr>
								</tfoot>
							</c:if>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../../inc/friendlylink.jsp"%>
	<%@ include file="../../inc/copyright.jsp"%>
</body>
</html>