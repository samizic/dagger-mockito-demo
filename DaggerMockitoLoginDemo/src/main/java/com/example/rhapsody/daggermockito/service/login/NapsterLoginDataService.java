package com.example.rhapsody.daggermockito.service.login;

import javax.inject.Inject;


public class NapsterLoginDataService implements LoginDataService {

	public NapsterLoginDataService() {
	}

	public void doEremedyLogin(String username, String password, LoginResponseListener listener)
	{
		listener.onSuccess(username, password, "RoboguiceDemoUser");
	}

}
