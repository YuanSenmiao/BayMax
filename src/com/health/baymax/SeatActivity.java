package com.health.baymax;



import java.util.Timer;
import java.util.TimerTask;

import com.life.baymax.R;

import android.app.Activity;
import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.EditText;


public class SeatActivity extends Activity {

	EditText hour;
	EditText minute;
	EditText second;
	Button sure;
	private Vibrator vibrator = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seat);
		hour = (EditText) findViewById(R.id.hour);
		minute = (EditText) findViewById(R.id.minute);
		second = (EditText) findViewById(R.id.second);
		sure = (Button) findViewById(R.id.sure);
		@SuppressWarnings("unused")
		AnalogClock analogClock = (AnalogClock) findViewById(R.id.clock);
		vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
		sure.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				int h=0, m=0, s=0;
				if (!hour.getText().toString().equals("")) {
					 h=Integer.parseInt(hour.getText().toString());
				}
				if (!minute.getText().toString().equals("")) {
					 m=Integer.parseInt(minute.getText().toString());
				}
				if (!second.getText().toString().equals("")) {
					 s=Integer.parseInt(second.getText().toString());
				}
				
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					
					@Override
					public void run() {
						vibrator.vibrate(500); 
					}
				};
				timer.schedule(task, 1000*(s+m*60 +h*60*60));
			}
		});
	}
}
