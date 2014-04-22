package com.example.rhapsody.daggermockito.service.login;

/**
 * Created by samizic on 14.04.14..
 */
public interface LoginResponseListener {

	public void onSuccess(String username, String password, String accountType);

	public void onError(LoginError error);
}
