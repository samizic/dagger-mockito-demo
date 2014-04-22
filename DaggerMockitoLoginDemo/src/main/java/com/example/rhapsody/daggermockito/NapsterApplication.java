package com.example.rhapsody.daggermockito;

import android.app.Application;
import com.example.rhapsody.daggermockito.dagger.AppModule;
import dagger.ObjectGraph;


/**
 * Created by samizic on 15.04.14..
 */
public class NapsterApplication extends Application {

	private ObjectGraph graph;


	@Override
	public void onCreate() {
		super.onCreate();

		graph = ObjectGraph.create(new AppModule());

	}

	public ObjectGraph getObjectGraph(){
		return graph;
	}
}
