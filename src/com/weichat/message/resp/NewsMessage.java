package com.weichat.message.resp;

import java.util.List;

public class NewsMessage extends BaseMessage{

	private int ArticleCount;
	private List<Article> Ariticles;
	
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getAriticles() {
		return Ariticles;
	}
	public void setAriticles(List<Article> ariticles) {
		Ariticles = ariticles;
	}
	
}
