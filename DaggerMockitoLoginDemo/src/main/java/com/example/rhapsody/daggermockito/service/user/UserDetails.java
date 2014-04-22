package com.example.rhapsody.daggermockito.service.user;

/**
 * Created by samizic on 14.04.14..
 */
public class UserDetails {

	public static final UserDetails EMPTY = new UserDetails("", "", "");

	private String _username;
	private String _password;
	private String _accountType;

	public UserDetails(String username, String password, String accountType) {
		_username = username;
		_password = password;
		_accountType = accountType;
	}

	public String getUsername() {
		return _username;
	}

	public String getPassword() {
		return _password;
	}

	public String getAccountType() {
		return _accountType;
	}

	public void setAccountType(String accountType) {
		_accountType = accountType;
	}
}
