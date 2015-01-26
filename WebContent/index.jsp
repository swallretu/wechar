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
	window.onload=parseMapJsonFromServlet;
	
	
	//使用jquery来解析json
/**	function conventStrToJson(){
		json格式
		{"userlist":[{"age":"24","name":"屈剑飞","sex":"男"},{"age":"22","name":"刘飞","sex":"女"},{"age":"14","name":"张龙","sex":"男"},{"age":"10","name":"徐玉","sex":"女"}]}
		
		var json = "{\"userlist\":[{\"age\":\"24\",\"name\":\"屈剑飞\",\"sex\":\"男\"},{\"age\":\"22\",\"name\":\"刘飞\",\"sex\":\"女\"},{\"age\":\"14\",\"name\":\"张龙\",\"sex\":\"男\"},{\"age\":\"10\",\"name\":\"徐玉\",\"sex\":\"女\"}]}";
		var dataObj = eval("("+json+")");
		$.each(json.userlist,fucntion(idx,item)){ 
			if(idx==0){ 
			return true; 
		};
	}
}		
*/	
	//解析后台返回Map类型的json
	function parseMapJsonFromServlet(){
		/**json格式
		{"name":"out","userlist":[{"age":"24","name":"屈剑飞","sex":"男"},{"age":"22","name":"刘飞","sex":"女"},{"age":"14","name":"张龙","sex":"男"},{"age":"10","name":"徐玉","sex":"女"}]}
		*/
		var json = ${jsonStr};
		var userlists = json.userlist;
		for(var i=0; i<userlists.length; i++){
			var user = userlists[i];
			alert(user.name+","+user.age+","+user.sex);
		}
	}
	
	function parseListJsonFromServlet(){
		/**json格式
		[{"age":"24","name":"屈剑飞","sex":"男"},{"age":"22","name":"刘飞","sex":"女"},{"age":"14","name":"张龙","sex":"男"},{"age":"10","name":"徐玉","sex":"女"}]
		*/
		
		var json = ${jsonStr};
		for(var i=0; i<json.length; i++){
			var user = json[i];
			alert(user.name+","+user.age+","+user.sex);
		}
		
		
		function testGetElValueFromJava(){
			alert(1);
			var user = ${user};
			alert(user);
			var student = {
					name : name,
					age : "20"
			}
			alert(student.name);
		}
	}
</script>
</head>
<body>
	request name is 
	<c:forEach items="${userlist }"  var="user">
		${user.name }
	</c:forEach><br>
	<button onclick="testGetElValueFromJava();">js对象通过El表达式获得后台的值</button>	
</body>
</html>