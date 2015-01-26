package com.weichat.message.resp;

/**
 * @author 剑飞
 * 开发者响应给用户的消息基类
 */
public class BaseMessage {
	private String ToUserName;//收取方(用户微信)
	private String FromUserName;//发送方(开发者微信)
	private long CreateTime;//创建时间
	private String MsgType;//消息类型(text/music/news)
	private int FuncFlag;// 位0x0001被标志时，星标刚收到的消息   
	
	
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
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public int getFuncFlag() {
		return FuncFlag;
	}
	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}
}
