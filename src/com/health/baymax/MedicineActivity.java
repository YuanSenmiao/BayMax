package com.health.baymax;



import com.life.baymax.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class MedicineActivity extends Activity {
	
	private ListView listMedicine;
	private AddNumberBaseAdpater addNumberBaseAdpater;
	public static Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_medicine);
		context=this;
		listMedicine = (ListView) findViewById(R.id.listMedicine);
		addNumberBaseAdpater=new AddNumberBaseAdpater(getApplicationContext());
		listMedicine.setAdapter(addNumberBaseAdpater);
	}

	
}
