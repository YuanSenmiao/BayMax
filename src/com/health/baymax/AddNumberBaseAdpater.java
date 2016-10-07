package com.health.baymax;
import java.util.ArrayList;

import com.life.baymax.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddNumberBaseAdpater extends BaseAdapter {

	 private LayoutInflater mInflater;
	 private ArrayList<NameTime> medicineList;
	 private Button button;

	 public AddNumberBaseAdpater(Context context) {
		 medicineList = new ArrayList<NameTime>();
		 medicineList.add(new NameTime("药品名称", "吃药时间", button));
		  this.mInflater = LayoutInflater.from(context);
	 }

	 public int getCount() {
	  return medicineList.size();
	 }

	 public Object getItem(int position) {
	  return medicineList.get(position);
	 }
	
	 public long getItemId(int position) {
	  return position;
	 }
	
	 @SuppressLint("InflateParams")
	public View getView(final int position, View convertView, ViewGroup parent) {
	  ViewHolder holder = new ViewHolder();
	  if (convertView == null) {
		  convertView = mInflater.inflate(R.layout.medicine_item, null);
		  holder.name = (TextView) convertView.findViewById(R.id.medicine_name);
		  holder.time = (TextView) convertView .findViewById(R.id.time);		  
		  holder.button=(Button) convertView.findViewById(R.id.medicineSure);
	      convertView.setTag(holder);
	  } 
	    else {    	
	   holder = (ViewHolder) convertView.getTag();
	  }
	  switch (position) {
	case 0:
		holder.name.setText(medicineList.get(position).getName());
		holder.time.setText(medicineList.get(position).getTime());		
		holder.button.setBackgroundResource(R.drawable.ic_input_add);
		break;
	default:
		holder.name.setText(medicineList.get(position).getName());
		holder.time.setText(medicineList.get(position).getTime());	
		holder.button.setBackgroundResource(R.drawable.btn_check_buttonless_on);
		break;
	}
	  
	  holder.name.setOnClickListener(new OnClickListener() {	
		@Override
		public void onClick(View v) {
			if (position>0) {
				 AlertDialog.Builder builder = new AlertDialog.Builder(MedicineActivity.context);
	                builder.setIcon(R.drawable.ic_launcher);
	                builder.setTitle("请输入用药名和吃药时间");
	                //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
	                View view = LayoutInflater.from(MedicineActivity.context).inflate(R.layout.medicine_dialog, null);
	                builder.setView(view);
	                final EditText ename  =(EditText) view.findViewById(R.id.eName);
	                final EditText etime = (EditText) view.findViewById(R.id.eTime);
	                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
	                {
	                    @Override
	                    public void onClick(DialogInterface dialog, int which)
	                    {
	                        String a = ename.getText().toString().trim();
	                        String b = etime.getText().toString().trim();
	                        medicineList.get(position).name=a;
	    	                medicineList.get(position).time=b;
	                    } 
	                });
	                builder.show();
	                
			}
			notifyDataSetChanged();
		}
	});
	  holder.button.setOnClickListener(new OnClickListener() {		
		@Override
		public void onClick(View v) {
			if (position==0) {
				medicineList.add(new NameTime("", "", button));
			}
			notifyDataSetChanged();
		}
	});
	  
	  holder.time.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				if (position>0) {
					 AlertDialog.Builder builder = new AlertDialog.Builder(MedicineActivity.context);
		                builder.setIcon(R.drawable.ic_launcher);
		                builder.setTitle("请输入用药名和吃药时间");
		                //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
		                View view = LayoutInflater.from(MedicineActivity.context).inflate(R.layout.medicine_dialog, null);
		                builder.setView(view);
		                final EditText ename  =(EditText) view.findViewById(R.id.eName);
		                final EditText etime = (EditText) view.findViewById(R.id.eTime);
		                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
		                {
		                    @Override
		                    public void onClick(DialogInterface dialog, int which)
		                    {
		                        String a = ename.getText().toString().trim();
		                        String b = etime.getText().toString().trim();
		                        medicineList.get(position).name=a;
		    	                medicineList.get(position).time=b;
		                    } 
		                });
		                builder.show();
		                
				}
				notifyDataSetChanged();
			}
		});
		  holder.button.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				if (position==0) {
					medicineList.add(new NameTime("", "", button));
				}
				notifyDataSetChanged();
			}
		});
	 
	
	  return convertView;
	 }
	
	 public final class ViewHolder {
	  public TextView name;
	  public TextView time;
	  public Button button;
	
	 }
}

//holder.name.setOnClickListener(new OnClickListener() {	
//	@Override
//	public void onClick(View v) {
//		 AlertDialog.Builder builder = new AlertDialog.Builder(MedicineActivity.context);
//		 LayoutInflater layoutInflater = LayoutInflater.from(MedicineActivity.context);
//		 final View editView = layoutInflater.inflate(R.layout.medicine_item1, null);
//		 builder.setTitle("输入药品名称");
//		 builder.setView(editView);
//		 builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//			
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		 
//		 builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					final EditText ename= (EditText) editView.findViewById(R.id.edit_name);
//					final EditText etime= (EditText) editView.findViewById(R.id.edit_time);
//					holder.name.setText(ename.getText());
//					holder.time.setText(etime.getText());
//				}
//			});
//		 
//		builder.show();
//		notifyDataSetChanged();
//	}
//	
//});


 
