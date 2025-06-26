package com.sjprogramming.bankapp;

import org.springframework.stereotype.Component;

@Component
public class Table {
	private String username;
	private String email;
	private String password;
	private String repeatpassword;
	public Table() {
		super();
	}
	public Table(String username, String email, String password, String repeatpassword) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.repeatpassword = repeatpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatpassword() {
		return repeatpassword;
	}
	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}
	

}
