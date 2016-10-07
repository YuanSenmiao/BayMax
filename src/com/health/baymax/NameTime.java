package com.health.baymax;

import android.widget.Button;

public class NameTime {
	String name;
	String time;
	Button button;
	public  NameTime(String name,String time, Button button){
		this.name = name;
		this.time = time;
		this.button=button;
	}

	public String getName(){
		return name;
	}
	
	public String getTime(){
		return time;
	}
	
	public Button getButton() {
		return button;
	}
}
