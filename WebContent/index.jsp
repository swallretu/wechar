<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testServlet</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	window.onload = initailiza;
	
	function toLogin(){
		var loginDiv = $("#loginDiv");
		loginDiv.show();
	}
	
	function initailize(){
		console.log("初始化开始。。。");
		var loginDiv = $("#loginDiv");
		loginDiv.hide();
	}
</script>
</head>
<body>
	<button type="button" onclick="toLogin()">登陆</button>
	
	<div id="loginDiv" style="width: 300px;height: 400px;">
		
	</div>
</body>
</html>