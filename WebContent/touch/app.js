Ext.application({
			name : 'Demo',
			viewport : {
				autoMaximize : true
			// 该属性可以设置页面自动最大化（隐藏地址栏）
			},

			launch : function() {
				var panel = Ext
						.create(
								'Ext.Panel',
								{
									fullscreen : true,
									id : 'content',
									scroll : 'vertical',
									layout : {
										type : 'vbox',
										align : 'center'
									},
//									html : 'this is html content',
									items : [

											{//一般容器加载Sencha的logo
												xtype : 'container',
												height : 98,
												width : 96,
												html : '<img src="SenchaLogo.png" style="margin-top: 16px;"></img>'
											}, 
//											{
//											xtype : 'form',
//											id : 'loginform',
//											items : 
//												[ 
//											          {
//															xtype : 'textfield',
//															name : 'name',
//															required: true
//														}, {
//															xtype : 'passwordfield',
//															name : 'password',
//															required: true
//														}, {
//															xtype : 'emailfield',
//															name : 'email',
//															required: true
//														} 
//												]
//										 },

											//提交按钮，放在fieldset外面是为了使之与fieldset等宽
											{
												xtype: 'button',
												text: 'Login',
												ui: 'action'  //绿色按钮
											},
					                      
											//再用一个Container来放置链接文字
											{
												xtype: 'container',
												html: '<div style="width: 100%; text-align: center;"><a style="font-size: 14px; color: blue;">call us</a></div>',
												margin: '16 0 0 0'
											}
									],
									dockedItems: [
													{
														id: 'status',
														xtype: 'toolbar',
														ui: 'light',
														dock: 'top',
														title: "Swallretu Touch"
													},
													{
														xtype: 'toolbar',
														dock: 'bottom',
														ui: 'dark',
														items: [
															{
																xtype: 'button',
																ui: 'drastic',
																text: 'forget password'
															},
															{xtype: 'spacer'},
															{
																xtype: 'button',
																ui: 'action',
																text: 'regiest'
															}
														]
													}
												]
								})
				Ext.Viewport.add(panel);
			}
		});
