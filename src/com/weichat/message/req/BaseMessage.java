package com.weichat.message.req;

/**
 * @author 剑飞
 * 用户请求到开发者的消息基类
 */
public class BaseMessage {
	
	private String ToUserName;//开发者微信号
	private String FromUserName;//发送方账号
	private long createTime;//创建时间
	private String MsgType;//消息类型(text/image/link/location)
	private long MsgId;//消息Id
	
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public long getMsgId() {
		return MsgId;
	}
	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
	
}
