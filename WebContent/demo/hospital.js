//返回一个对象的方法
function getHospital(){
	var hosp = "";
	$.ajax({
		url : 'http://localhost:8080/WeChat/demo/hospitals.json',
		type : 'GET',
		dataType : 'json',
		async : false,//设置异步为false，否则有可能取不到值
		success : function(data){
			hosp = data.hospitals;
		},
		error : function(){
			
		}
	});	
	return hosp;
}
