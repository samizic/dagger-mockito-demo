package com.example.rhapsody.daggermockito.service.login;

import com.example.rhapsody.daggermockito.service.user.UserManager;

import javax.inject.Inject;


/**
 * Created by samizic on 14.04.14..
 */
public class LoginManager {

	UserManager _userManager;
	LoginDataService _loginDataService;

	@Inject
	public LoginManager(UserManager _userManager, LoginDataService _loginDataService) {
		this._userManager = _userManager;
		this._loginDataService = _loginDataService;
	}

	public void logIn(String username, String password, LoginResponseListener listener){

		if(!areCredentialsValid(username, password)){
			listener.onError(LoginError.INCORRECT_USERNAME_OR_PASSWORD);
		}
		else{
			doUserLogIn(username, password, listener);
		}

	}


	private void doUserLogIn(String username, String password, LoginResponseListener listener) {
		_loginDataService.doEremedyLogin(username, password, listener);
	}


	public void logOut(){
		_userManager.clearUser();
	}

	private boolean areCredentialsValid(String username, String password) {
		return username != null && username.length() > 0 && password != null && password.length() > 0;
	}

}
