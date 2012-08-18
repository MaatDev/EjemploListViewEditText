package com.example.ejemplolistviewedittext;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.app.Activity;
public class MainActivity extends Activity {

	private ListView lv_list;
	private CustomAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.lv_list = (ListView) super.findViewById(R.id.lv_lista);      
        
        this.adapter = new CustomAdapter(this);
        
        this.lv_list.setAdapter(this.adapter);
                
    }

    //Agregar un nuevo objeto en el arreglo y actualizar el listview
    public void add(View view){
    	
    	this.adapter.numeros.add( new Integer(0) );
    	this.adapter.notifyDataSetChanged();

    }
    
    
    
}
