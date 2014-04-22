package com.example.rhapsody.daggermockito.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.rhapsody.daggermockito.NapsterApplication;
import com.example.rhapsody.daggermockito.R;
import com.example.rhapsody.daggermockito.dagger.AppModule;
import com.example.rhapsody.daggermockito.service.login.LoginManager;
import com.example.rhapsody.daggermockito.service.user.UserDetails;
import com.example.rhapsody.daggermockito.service.user.UserManager;
import dagger.ObjectGraph;

import javax.inject.Inject;


/**
 * Created by samizic on 14.04.14..
 */
public class HomeActivity extends Activity{

	private TextView _username;
	private TextView _accountType;
	private Button _signOut;

	@Inject LoginManager _loginManager;
	@Inject UserManager _userManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_home);

		_username = (TextView) findViewById(R.id.username_textView);
		_accountType = (TextView) findViewById(R.id.account_type_textView);
		_signOut = (Button) findViewById(R.id.btn_sign_out);

		ObjectGraph objectGraph = ObjectGraph.create(new AppModule());
		objectGraph.inject(this);

		UserDetails user = _userManager.getUser();

		//_username.setText(user.getUsername());
		//_accountType.setText(user.getAccountType());

		_signOut.setOnClickListener(new SignOutClickListener());
	}

	private class SignOutClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			//_loginManager.logOut();

/*			if(_userManager.isSignedIn()){
				Toast.makeText(HomeActivity.this, "There was a problem while signing out. User is still signed in.", Toast.LENGTH_LONG).show();
				return;
			}*/

			startActivity(new Intent(HomeActivity.this, SignInActivity.class));
			finish();
		}
	}
}
