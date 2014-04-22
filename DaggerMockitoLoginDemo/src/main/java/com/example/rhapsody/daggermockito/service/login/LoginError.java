package com.example.rhapsody.daggermockito.service.login;

/**
 * Created by samizic on 14.04.14..
 */
public enum LoginError {

	NETWORK_ERROR("Something is wrong with the network"),
	INCORRECT_USERNAME_OR_PASSWORD("Login failed. Please check username and password"),
	UNKNOWN("Oops. Something went terribly wrong.");

	public String message;

	LoginError(String message) {
		this.message = message;
	}
}
