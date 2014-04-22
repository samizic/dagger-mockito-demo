package com.example.rhapsody.daggermockito.test;

import com.example.rhapsody.daggermockito.service.login.LoginDataService;
import com.example.rhapsody.daggermockito.service.login.LoginResponseListener;
import com.example.rhapsody.daggermockito.service.login.NapsterLoginDataService;
import com.example.rhapsody.daggermockito.service.user.UserManager;
import dagger.Module;
import dagger.Provides;
import org.mockito.Mockito;

import javax.inject.Inject;


@Module( injects = LoginManagerTest.class)
public class TestAppModule {

	@Provides UserManager provideUserManager(){
		return Mockito.mock(UserManager.class);
	}

	@Provides LoginResponseListener provideLoginResponseListener(){
		return Mockito.mock(LoginResponseListener.class);
	}

	@Provides LoginDataService mockLoginDataService(){
		return Mockito.mock(NapsterLoginDataService.class);
	}

}
