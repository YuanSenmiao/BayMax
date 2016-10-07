package com.health.baymax;


import com.life.baymax.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

public class WaterActivity extends Activity {
	
	private Button leftButton;
	private Button rightButton;
	private TextView waterNum;
	private TextView finishProgress;
	private int num=0;
	private TableRow[] rows= new TableRow[8];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_water);
		leftButton = (Button) findViewById(R.id.left);
		rightButton = (Button) findViewById(R.id.right);
		waterNum = (TextView) findViewById(R.id.numWater);
		finishProgress = (TextView) findViewById(R.id.finishProgress);
		rows[0] = (TableRow) findViewById(R.id.Row1);
		rows[1] = (TableRow) findViewById(R.id.Row2);
		rows[2] = (TableRow) findViewById(R.id.Row3);
		rows[3] = (TableRow) findViewById(R.id.Row4);
		rows[4]= (TableRow) findViewById(R.id.Row5);
		rows[5] = (TableRow) findViewById(R.id.Row6);
		rows[6] = (TableRow) findViewById(R.id.Row7);
		rows[7] = (TableRow) findViewById(R.id.Row8);
		waterNum.setText(num+"");
		leftButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {			
				if(num>0) {
					num--;
					waterNum.setText(num+"");
					int progress =100* num/8 ;
					finishProgress.setText(progress + "%");
					setWater(num);
				}
			}
		});
		
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(num<8) {
					num++;
					waterNum.setText(num+"");
					int progress = 100* num/8 ;
					finishProgress.setText(progress + "%");
					setWater(num);
				}
				
			}
		});
	}
	protected void setWater(int num) {
		for (int i = 0; i <num; i++) {
			rows[i].setBackgroundColor(Color.parseColor("#FF0099FF"));
		}
		for (int i = num; i <8; i++) {
			rows[i].setBackgroundColor(Color.parseColor("#FFFFFFFF"));
		}
		
	}

	
}
