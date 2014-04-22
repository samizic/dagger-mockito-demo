package com.example.rhapsody.daggermockito.dagger;

import android.app.Application;
import com.example.rhapsody.daggermockito.activity.HomeActivity;
import com.example.rhapsody.daggermockito.activity.SignInActivity;
import com.example.rhapsody.daggermockito.service.login.LoginDataService;
import com.example.rhapsody.daggermockito.service.login.LoginManager;
import com.example.rhapsody.daggermockito.service.login.NapsterLoginDataService;
import com.example.rhapsody.daggermockito.service.user.UserManager;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by samizic on 20.4.2014..
 */
@Module(
		injects = { HomeActivity.class, SignInActivity.class,
				LoginManager.class, NapsterLoginDataService.class, UserManager.class},
		library = true
)
public class AppModule {

	public AppModule() {
	}

	@Provides @Singleton
	UserManager provideUserManager(){
		return new UserManager();
	}

	@Provides @Singleton
	LoginManager provideLoginManager(UserManager userManager, LoginDataService loginDataService){
		return new LoginManager(userManager, loginDataService);
	}

	@Provides @Singleton
	LoginDataService provideLoginDataService(){
		return new NapsterLoginDataService();
	}

}
