package com.yasin.model;

/**
 * Card entity. @author MyEclipse Persistence Tools
 */

public class Card implements java.io.Serializable {

	// Fields

	private Integer cid;
	private User user;
	private String cinfo;

	// Constructors

	/** default constructor */
	public Card() {
	}

	/** minimal constructor */
	public Card(User user) {
		this.user = user;
	}

	/** full constructor */
	public Card(User user, String cinfo) {
		this.user = user;
		this.cinfo = cinfo;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCinfo() {
		return this.cinfo;
	}

	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}

}