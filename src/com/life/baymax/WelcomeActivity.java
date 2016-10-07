package com.life.baymax;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_welcome);
		final Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				startActivity(intent);	
			}
		};
		timer.schedule(task, 1000*3);
	}
}