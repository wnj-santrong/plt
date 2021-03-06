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
Globals.page = "Manage_chapterList";
</script>
</head>
<body>
	<%@ include file="../../inc/top_bg.jsp"%>
	<div id="container_box">
		<div id="container_content">
			<div class="sectionMain clr">
				<%@ include file="../../inc/leftmenu_teacher.jsp"%>
				
				<div class="sh_info_r">
		            <div class="st_titile_r sh_title">
						<a href="${ctx}/manage/course/modify?courseId=${course.id}">基本信息</a>
						<a href="${ctx}/manage/course/chapterEditor?courseId=${course.id}">章节维护</a>
						<input type="hidden" id="courseId" name="courseId" value="${course.id}">
		            </div>
		            <div class="sh_collection">
						<c:forEach items="${course.chapterDetailList}" var="chapter" varStatus="st">
							<dl id="${chapter.id}" class="sh_add_chapter">
								<input type="hidden" id="chapterId" name="chapterId" value="${chapter.id}"/>
								<dt>
									<div class="sh_add_opera">
										<h2>第${st.count}课:</h2>
										<p class="show_remark">${chapter.remark}</p>
										<p class="hide_remark">
											<input type='text' value='${chapter.remark}' name='remark' id='remark' class='chapter_remark'> 
											<a href='javascript:void(0);' class='chapter_submit'>保存</a>
											<a href='javascript:void(0);' class='chapter_cancel'>取消</a>
											<span>5-30个字符支持汉字、数字、“_”</span>
										</p>
										<span class="sh_operation">
											<a href="javascript:void(0);" class="removeMaxChapter">删除</a>
											<a href="javascript:void(0);" class="editMaxChapter">修改</a>
										</span>
									</div>
								</dt>
								<c:forEach items="${chapter.resourceList}" var="resource">
									<dd class="pt10">
										<a class="sh_resource" href="${ctx}/${resource.typeEnString}?resId=${resource.id}" target="_blank" >${resource.title}</a>
										<span class="sh_operation_2">
											<input type="hidden" id="resourceId" name="resourceId" value="${resource.id}"/>
											<input type="hidden" id="resourceType" name="resourceType" value="${resource.type}"/>
											<a href="javascript:void(0);" class="removeResource">删除</a>
											<a href="javascript:void(0);" class="editResource">修改</a>
										</span>
									</dd>
								</c:forEach>
								<dd class="pt11">
									<a href="javascript:void(0);" class="add_resource_file" ><b>+</b>课件</a>
									<a href="javascript:void(0);" class="add_resource_live" ><b>+</b>直播</a>
									<a href="javascript:void(0);" class="add_resource_train" ><b>+</b>试题</a>
								</dd>
							</dl>
							<c:if test="${st.last}">
								<input type="hidden" value="${st.count}" id="priority" name="priority" >
							</c:if>
						</c:forEach>
						<a href="javascript:void(0);" class="sh_addop_a"><b>+添加章节</b></a> 
		             </div>
		        </div>
				
			</div>
		</div>
	</div>

	<%@ include file="../../inc/friendlylink.jsp"%>
</body>
</html>
