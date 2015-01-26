package com.weichat.message.resp;

public class TextMessage extends BaseMessage{
	private String Content;//返回的消息

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
}
