package com.example.rhapsody.daggermockito.test;

import com.example.rhapsody.daggermockito.service.login.LoginDataService;
import com.example.rhapsody.daggermockito.service.login.LoginResponseListener;


public class TestLoginDataService implements LoginDataService {

	public static final String TEST_ACCOUNT_TYPE = "TestAccountType";

	@Override
	public void doEremedyLogin(String username, String password, LoginResponseListener listener) {
		listener.onSuccess(username, password, TEST_ACCOUNT_TYPE);
	}
}
