package com.example.sharedprefrencesbynaveen;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class mypreferenceclass extends PreferenceActivity {
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.mypreferencelayout);
	}

}
