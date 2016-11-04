package com.yasin.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Card entity. @author MyEclipse Persistence Tools
 */

public class Card implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cinfo;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Card() {
	}

	/** full constructor */
	public Card(String cinfo, Set users) {
		this.cinfo = cinfo;
		this.users = users;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCinfo() {
		return this.cinfo;
	}

	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}