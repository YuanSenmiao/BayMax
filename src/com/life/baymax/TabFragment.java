package com.life.baymax;

import java.util.ArrayList;
import java.util.List;

import com.health.baymax.MedicineActivity;
import com.health.baymax.SeatActivity;
import com.health.baymax.WaterActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class TabFragment extends Fragment
{
	private String key = null;
	static TabFragment newInstance(String s){
		TabFragment myFragment = new TabFragment();
		Bundle bundle = new Bundle();
		bundle.putString("key", s);
		myFragment.setArguments(bundle);
		return myFragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		Bundle bundle = getArguments();
		key = bundle != null? bundle.getString("key") : null;
		super.onCreate(savedInstanceState);
	}
	
	private ListView listView;
	private List<String> list;
//	private ListView listViewHealth;
//	private List<String> listHealth;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = null; 
	
		
		if (key == null || key.equals("Exercises")) {
			view =inflater.inflate(R.layout.exercises, container, false);
			listView = (ListView) view.findViewById(R.id.HealthList);
			list = getdataExercises();
			final MyListViewAdapter adapter = new MyListViewAdapter(getActivity(), list,R.layout.item);
			listView.setAdapter(adapter);
			
		}
		
		if (key != null && key.equals("Health")) {
			view =inflater.inflate(R.layout.exercises, container, false);
			listView = (ListView) view.findViewById(R.id.HealthList);
			list = getdataExercises();
			final MyListViewAdapter1 adapter = new MyListViewAdapter1(getActivity(), list,R.layout.item);
			listView.setAdapter(adapter);
		
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					switch (position) {
					case 0:
						Intent intent0 = new Intent(getActivity(),WaterActivity.class);
						startActivity(intent0);
						break;
					case 3:
						Intent intent1 = new Intent(getActivity(),SeatActivity.class);
						startActivity(intent1);
						break;
					case 4:
						Intent intent4 = new Intent(getActivity(),MedicineActivity.class);
						startActivity(intent4);
						break;
					default:
						break;
					}
					
				}
			});
		}
		
		if (key != null && key.equals("Learning")) {
		}
		
		if (key != null && key.equals("Rating")) {
	  }
	
		return view;
		
	}



		

//	private List<String> getdataHealth() {
//		int size = 0;
//		if (listHealth != null) {
//			size = listHealth.size();
//		}
//		if (listHealth == null) {
//			listHealth = new ArrayList<String>();
//			for (int i = 0; i < 5; i++) {
//				listHealth.add("item" + i + size);
//			}
//		}
//		return listHealth;
//	}
	private List<String> getdataExercises(){
		int size = 0;
		if (list != null) {
			size = list.size();
		}
		if (list == null) {
			list = new ArrayList<String>();
			for (int i = 0; i < 5; i++) {
				list.add("item" + i + size);
			}
		}
		return list;
	}
	

}
