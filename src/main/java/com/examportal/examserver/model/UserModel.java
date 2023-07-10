package com.examportal.examserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel {
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserModel() {
		super();
	}
	public UserModel(String password, String email, String userName) {
		super();
		this.password = password;
		this.email = email;
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserModel [password=" + password + ", email=" + email + ", userName=" + userName + "]";
	}
	private String password;
	private String email;
	private String userName;
}
