<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- 适应移动端缩放 -->
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- 非响应式布局样式 -->
<link rel="stylesheet" href="css/non_response.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<title>登陆</title>
<script type="text/javascript">
function login(){
	
//	var email = document.getElementsByName("email")[0].value;//获取email input的值
//	var passwd = document.getElementsByName("passwd")[0].value;//获取email input的值

	var form = $("#loginform");
	form.serialize();
	form.submit();
}
</script>
</head>
<body>
	<div align="center" style="width: 50%;height:40%; margin-left: 25%;">
		<div class="container">
			<div class="row">
					<form id="loginform" action="<%=request.getContextPath()%>/loginServlet">
						<h2>欢迎登陆swallretu</h2>
						<div class="form-group">
							<label for="inputEmail" class="sr-only">Email address</label> <input
								type="email" id="email" class="form-control"
								placeholder="Email address" required="" autofocus="" name="email">
						</div>
						<div class="form-group">
							<label for="inputPassword" class="sr-only">Password</label> <input
								type="password" id="passwd" class="form-control"
								placeholder="Password" required="" name="passwd">
						</div>
						<div class="checkbox">
							<label> <input type="checkbox" value="remember-me">
								Remember me
							</label>
						</div>
						<button class="btn btn-lg btn-primary btn-block" type="button" onclick="login();">Sign
							in</button>
					</form>	
			</div>
		</div>
	</div>
</body>
</html>