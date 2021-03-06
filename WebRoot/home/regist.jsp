<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/common.jsp"%>
<c:set var="title" value="三简在线教育平台-用户注册" ></c:set>
<c:set var="keywords" value="456" ></c:set>
<c:set var="description" value="789" ></c:set>
<%@ include file="inc/header.jsp"%>
<script type="text/javascript">
var Globals = {};
Globals.ctx = "${ctx}";
Globals.lang = "${lang}";
Globals.page = "Index_regist";
</script>
</head>
<style type="text/css">
.system_tip { width:300px; line-height:26px; margin:10px auto; border:solid 1px #F5D8A7; border-radius:2px; background-color:#FFF6DB;padding-left: 10px; text-align: center; }
</style>
<body>

	<%@ include file="inc/top.jsp"%>
	<div id="container_box">
		<div id="container_content">
			<div class="sectionMain clr">
				<div class="form_page">
					<div id="demo_zone">
						<c:if test="${tipError != null && fn:length(tipError)  > 0}">
							<div class="system_tip">
								<c:forEach items="${tipError}" var="tip">
								<p>${tip.msg}</p>
								</c:forEach>
							</div>
						</c:if>
						
						<form action="${ctx}/account/regist" method="post" class="form_vertical common_form">
							<div class="form_item">
								<label for="username">用&nbsp; 户  名：</label>
								<div class="form_field">
									<input placeholder="5-32个字符" class="form_text" name="username" type="text" required required_MinLength="5"/>
									<span class="not-empty" title='此项为必填项'>*</span>
								</div>
							</div>
							<div class="form_item">
								<label for="pwd">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
								<div class="form_field">
									<input name="password" id="pwd" class="form_text" type="password" required />
									<span class="not-empty" title='此项为必填项'>*</span>
								</div>
							</div>
							<div class="form_item">
								<label for="confirmPwd">确认密码：</label>
								<div class="form_field">
									<input name="confirmPwd" id="pwd" class="form_text" type="password" required equalTo="password" />
									<span class="not-empty" title='此项为必填项'>*</span>
								</div>
							</div>
							<div class="form_item">
								<label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
								<div class="form_field">
									<input name="email" class="form_text" type="text" required required_Mail />
									<span class="not-empty" title='此项为必填项'>*</span>
									<span class="not-empty" ><a href="${ctx}/account/forgotPwd" target="_blank" class="login_forgot">忘记密码?</a></span>
								</div>
							</div>				
							<div class="form_action">
								<input class="btn_regist" type="submit" value="立即注册" name="regist" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="inc/footer.jsp"%>
	
</body>
</html>