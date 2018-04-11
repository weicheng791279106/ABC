package com.abc.po;

import java.util.List;

/**¶©µ¥*/
public class Order {

	private Integer id;
	private User user;
	private Double total; 
	private String addr;
	private List<Article> articleList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
}
