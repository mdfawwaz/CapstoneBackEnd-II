package com.project.capstone.business;

import com.project.capstone.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoggedInUser {
	private User loggedIn;

	public User getLoggedInUser() {
		return loggedIn;
	}

	public void setLoggedInUser(User loggedIn) {
		this.loggedIn = loggedIn;
	}

}