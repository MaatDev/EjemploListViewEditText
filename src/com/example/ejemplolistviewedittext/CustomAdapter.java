package com.example.ejemplolistviewedittext;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

public class CustomAdapter extends BaseAdapter{

	public List<Integer> numeros = new ArrayList<Integer>();
	
	private LayoutInflater inflator;
	
	public CustomAdapter(Context context){
		
		this.inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return numeros.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return numeros.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View view, ViewGroup group) {
		
		ViewHolder holder;
		
		if( view == null ){
			
			view = this.inflator.inflate(R.layout.item, null);
			
			holder = new ViewHolder();
			
			holder.et_text = (EditText) view.findViewById(R.id.et_text);
			holder.et_text.setId(position);
			
			view.setTag(holder);
			
		}else{
			
			holder = (ViewHolder) view.getTag();
			
		}

		holder.et_text.setText( Integer.toString( this.numeros.get(position) ) );
		holder.et_text.setOnFocusChangeListener(new OnFocusChangeListener() {
			
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus){

                    final int position = v.getId();

                    final EditText Caption = (EditText) v;
                    numeros.set(position, Integer.valueOf( Caption.getText().toString() ));

                }

            }

        });

		return view;
	}
	
	private static class ViewHolder{
		
		EditText et_text;
		
	}

}
