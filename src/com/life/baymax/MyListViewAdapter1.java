package com.life.baymax;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListViewAdapter1 extends BaseAdapter {

	List<String>list;
	
	LayoutInflater inflater;
	
	FragmentActivity activity;
	private int resourceId;
	
	public MyListViewAdapter1(FragmentActivity fragmentActivity, List<String> list,int textViewResourceId) {
		this.list = list;
		this.activity = fragmentActivity;
		resourceId=textViewResourceId;
		inflater = (LayoutInflater) fragmentActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	
	@SuppressLint({ "ViewHolder", "InflateParams", "CutPasteId" })
	public View  getView(int position, View convertView, ViewGroup parent) {
//		Object  item = getItem(position);
		View view = inflater.inflate(resourceId, null);
		switch (position) {
		case 0:
			TextView item0 = (TextView) view.findViewById(R.id.item_name);
			item0.setText("喝水");
			break;
		case 1:
			TextView item1 = (TextView) view.findViewById(R.id.item_name);
			item1.setText("天气提醒");
			break;
		case 2:
			TextView item2= (TextView) view.findViewById(R.id.item_name);
			item2.setText("绑定只能穿戴设备");
			break;
		case 3:
			TextView item3= (TextView) view.findViewById(R.id.item_name);
			item3.setText("久坐提醒");
			break;
		case 4:
			TextView item4= (TextView) view.findViewById(R.id.item_name);
			item4.setText("吃药提醒");
			break;
		case 5:
			TextView item5= (TextView) view.findViewById(R.id.item_name);
			item5.setText("健康百科");
			break;
		default:
			break;
		}
		
		
		return view;
	}
	class ViewHolder {
		TextView tv;
		ImageView im;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

}
