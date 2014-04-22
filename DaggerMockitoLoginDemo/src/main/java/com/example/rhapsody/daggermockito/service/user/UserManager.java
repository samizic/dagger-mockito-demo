package com.example.rhapsody.daggermockito.service.user;

import android.app.Application;
import javax.inject.Inject;

/**
 * Created by samizic on 14.04.14..
 */

public class UserManager {

	private UserDetails _user = UserDetails.EMPTY;

	public UserManager() { }

	public void setUser(UserDetails user){
		if(user != null){
			_user = user;
		}
	}

	public boolean isSignedIn(){
		return _user != UserDetails.EMPTY;
	}

	public void clearUser() {
		_user = UserDetails.EMPTY;
	}

	public UserDetails getUser() {
		return _user;
	}
}
