<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sencha</title>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/sencha-touch.css" type="text/css">
<script src="<%=request.getContextPath() %>/sencha-touch.js"></script>
<script type="text/javascript">
	

//	  var pro1 = new Product("Mac air",3500);
//	  var pro2 = new Product("nothing","0");
//	var cheese = new Food('feta', -1);
//	alert(cheese.category);
	
//	var toy = new Food('toy', 40);
//	alert(toy.category);
var path = <%=request.getContextPath()%>;
var panel = Ext.create('Ext.Panel', {});

Ext.setup({
    icon: 'icon.png',
    tabletStartupScreen: 'tablet_startup.png',
    phoneStartupScreen: 'phone_startup.png',
    glossOnIcon: false,
    onReady: function() {
	
		//判断是否是手机设备，只有手机设备才使用此布局
//		if (Ext.is.Phone) {
			new Ext.Panel({  //使用一个Panel来填满屏幕
				fullscreen: true,  //是否全屏，选择true则横竖屏切换时仍可以保证自动适应尺寸
				id: 'content',
				scroll: 'vertical',  //滚动方向
				html: '这里放置核心内容',  //Panel里面放置的内容
				layout: {type: 'vbox', align: 'center'},  //布局方式，vbox纵向布局，且每行内容居中
				items: [
				        
								//从上往下第一个元素，logo图片
								{
									xtype: 'container',  //使用普通的Container容器即可
									height: 98,  //高度要跟图片尺寸相适应，由于我在下面html代码中给图片加了16px的margin-top，所以Container高度设置成图片高度+16，防止图片显示不完整
									width: 96,  //图片的宽度
									html: '<img src="logo.png" style="margin-top: 16px;" />'  //直接设定html代码来显示图片，注意有16像素的顶部margin
								},
								                    //从上往下第二个元素，form表单
								{
									xtype: 'form',  //xtype为form
									id: 'loginForm',  //为便于操作form，给它一个id
								                            //表单内有不止一个元素，因此又要给它添加items
									items: [
									{
										xtype: 'fieldset',  //加一个fieldset，可以将两个文本框放在一个圆角域组里面，更美观
										margin: '-2 0 16 0',  //使用margin调整与上面元素和下面元素之间的空隙
								                                    //fieldset里面包含两个文本框
										items: [
										{
											xtype: 'textfield',  //第一个文本框
											name: 'account',  //name用来获取值
											placeHolder: '您的账号',  //默认显示在文本框里的文字，点击和输入时它会消失
											required: true,  //必填字段
											useClearIcon: true  //输入内容后文本框后面会出现一个清空按钮
										},
										{
											xtype: 'passwordfield',  //密码文本框
											name: 'password', 
											placeHolder: '您的密码',
											required: true,
											useClearIcon: true
										}
										]
									},
								                            //提交按钮，放在fieldset外面是为了使之与fieldset等宽
									{
										xtype: 'button',
										text: '登录STDEMO',
										ui: 'confirm'  //绿色按钮
									},
								                            //再用一个Container来放置链接文字
									{
										xtype: 'container',
										html: '<div style="width: 100%; text-align: center;"><a style="font-size: 14px; color: blue;">需要合作？请联系我们……</a></div>',
										margin: '16 0 0 0'
									}
									]
								}
				        
				        ],  //这里放置容器内部的子元素
				dockedItems: [
				              	{
				              		
				              		id: 'status',  //给他一个ID
									xtype: 'toolbar',  //xtype类型是toolbar，完整的xtype枚举见这里http://docs.sencha.com/touch/1-1/#!/api/Ext.Component
									ui: 'light',  //light表示浅色的背景图案
									dock: 'top',  //工具栏放置在最顶部
									title: "Sencha Touch Demo"  //工具栏的标题
				              		
				              	},
                                //这里是新增加的底部工具栏
								{
									xtype: 'toolbar',
									dock: 'bottom',  //在这里声明工具栏附着在底部
									ui: 'dark',  //深色背景图案
			                                                //又看到了items，显然ST的items是可以嵌套的，好吧，我们一口气把这个工具栏上的按钮也给加上
									items: [
										{
											xtype: 'button',  //左侧一个button
											ui: 'round',  //drastic是button的颜色和样式定义
											text: '忘记密码'  //不解释
										},
										{xtype: 'spacer'},  //这个需要解释一下，spacer会自动充满剩余空间
										{
											xtype: 'button',  //最右侧的button
											ui: 'action',  //action样式是蓝色
											text: '注册使用'
										}
									]
								}
				              ]  //这里放置Panel本身所拥有的dock元素（你可以理解为自带工具栏）
			});
//		}
	}
});

	

</script>
</head>
<body>Sencha page
</body>
</html>