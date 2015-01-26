<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form</title>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/sencha-touch.css" type="text/css">
<script src="<%=request.getContextPath() %>/sencha-touch.js"></script>
<script type="text/javascript">



Ext.setup({
	onReady: function() {
	//		alert(1);
			Ext.Viewport.add(
					Ext.create('Ext.form.Panel', {
					    items: [
					        {
					            xtype: 'textfield',
					            name: 'name',
					            label: 'Name'
					        },
					        {
					        	xtype:'passwordfield',
					        	name:'password',
					        	label:'Password'
					        },
					        {
					        	xtype:'emailfield',
					        	name:'email',
					        	label:'Email'
					        }
					    ]
					})
			);
	}
});

</script>
</head>
<body>

</body>
</html>