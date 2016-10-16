package com.hunhun.javaweb;

import java.util.List;

public class User {

	private String username;	//user1 = "AAA", user2 = "BBB"
	private List<Authority> authorities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public User(String userName, List<Authority> authorities) {
		super();
		this.username = userName;
		this.authorities = authorities;
	}

	public User() {
		super();
	}

}
