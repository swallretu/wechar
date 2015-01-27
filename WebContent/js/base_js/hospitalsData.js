function getHospital(){
	var hospitals = "";
	$.ajax({
		url : 'http://localhost:8080/WeChat/hospitals.json',
		type : 'GET',
		dataType : 'json',
		async : false,
		success : function(data){
			hospitals = data.hospitals;
			console.log(hospitals);
		},
		error : function(){
				console.log("ajax获取信息失败");
		}
	});
	return hospitals;
}