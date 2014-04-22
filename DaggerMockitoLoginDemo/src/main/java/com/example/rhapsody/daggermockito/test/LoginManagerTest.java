package com.example.rhapsody.daggermockito.test;

import android.test.InstrumentationTestCase;
import com.example.rhapsody.daggermockito.service.login.LoginDataService;
import com.example.rhapsody.daggermockito.service.login.LoginManager;
import com.example.rhapsody.daggermockito.service.login.LoginResponseListener;
import com.example.rhapsody.daggermockito.service.user.UserManager;
import dagger.ObjectGraph;
import org.mockito.InjectMocks;

import javax.inject.Inject;

import static org.mockito.Mockito.*;

public class LoginManagerTest extends InstrumentationTestCase {

	public static final String JOHN_DOE = "John_Doe";
	public static final String PASSWORD = "password";

	@Inject UserManager mockUserManager;
	@Inject LoginResponseListener mockLoginResponseListener;
	@Inject LoginDataService mockLoginDataService;

	private LoginManager loginManager;

	@Override
	protected void setUp() throws Exception {
		// inject mocks by using TestAppModule
		ObjectGraph.create(new TestAppModule()).inject(this);

		// create loginManager using mocked objects
		loginManager = new LoginManager(mockUserManager, mockLoginDataService);
	}

	public void testLogOutClearsOutCurrentUser(){
		loginManager.logOut();
		verify(mockUserManager).clearUser();
	}

	public void testLoginCallsERemedyLogin(){
		// call behavior we want to test
		loginManager.logIn(JOHN_DOE, PASSWORD, mockLoginResponseListener);

		// verify that a method has been called
		verify(mockLoginDataService).doEremedyLogin(anyString(), anyString(), any(LoginResponseListener.class));
	}

	public void testLoginCallsERemedyLoginWithCorrectArguments(){
		// call behavior we want to test
		loginManager.logIn(JOHN_DOE, PASSWORD, mockLoginResponseListener);

		// verify that a method has been called
		verify(mockLoginDataService).doEremedyLogin(same(JOHN_DOE), same(PASSWORD), same(mockLoginResponseListener));
	}

	public void testLoginViaTestImplementation(){
		// create LoginDataService with implemented behavior for tests and provide it to LoginManager
		LoginDataService testLoginDataService = new TestLoginDataService();
		LoginManager loginManager = new LoginManager(mockUserManager, testLoginDataService);

		// call behavior we want to test
		loginManager.logIn(JOHN_DOE, PASSWORD, mockLoginResponseListener);

		// verify onSuccess() method with correct parameters was called
		verify(mockLoginResponseListener).onSuccess(same(JOHN_DOE), same(PASSWORD), same(TestLoginDataService.TEST_ACCOUNT_TYPE));
	}


	@Override
	protected void tearDown() throws Exception {
		reset(mockUserManager, 	mockLoginResponseListener, mockLoginDataService);
		super.tearDown();
	}
}
