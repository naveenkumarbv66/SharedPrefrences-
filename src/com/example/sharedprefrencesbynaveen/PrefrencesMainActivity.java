package com.example.sharedprefrencesbynaveen;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class PrefrencesMainActivity extends Activity implements OnClickListener {

	
	Button read,set;
	TextView tv,name;
	EditText etv;
	CheckBox cb;
	
	SharedPreferences settings;
	
	OnSharedPreferenceChangeListener mypreferencelistener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prefrences_main);
		
		
		read=(Button)findViewById(R.id.read);
		set=(Button)findViewById(R.id.set);
		//tv=(TextView)findViewById(R.id.textView1);
		//etv=(EditText)findViewById(R.id.editText1);
		name=(TextView)findViewById(R.id.name);
		cb=(CheckBox)findViewById(R.id.checkBox1);
		
		read.setOnClickListener(this);
		set.setOnClickListener(this);
		
		//settings=getPreferences(MODE_PRIVATE);
		settings=PreferenceManager.getDefaultSharedPreferences(this);
		
		mypreferencelistener=new OnSharedPreferenceChangeListener() {
			@Override
			public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,String key) {
				// TODO Auto-generated method stub
				PrefrencesMainActivity.this.updatepreferencelistener();
			}
		};
		
		settings.registerOnSharedPreferenceChangeListener(mypreferencelistener);
		
	}
	
	public void updatepreferencelistener() {
		name.setText(settings.getString("pre_name", "null"));
		cb.setChecked(settings.getBoolean("pre_checkbox", false));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.set:
			/*SharedPreferences.Editor editor=settings.edit();
			editor.putString("name", etv.getText().toString());
			editor.commit();*/
			Intent i=new Intent(this, mypreferenceclass.class);
			startActivity(i);
			break;
		case R.id.read:
			/*String value=settings.getString("name", "No data found.!");
			tv.setText(value);*/
			
			break;

		default:
			break;
		}
		
	}



}
