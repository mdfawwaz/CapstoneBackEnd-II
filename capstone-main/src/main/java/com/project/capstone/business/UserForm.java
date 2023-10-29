package com.project.capstone.business;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    private String name;
    private String password;
    private String passwordRepeat;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
    
}