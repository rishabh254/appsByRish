package com.example.mysecondapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.TextView;

public class HighScores extends Activity {

	TextView high;
String texting=Surfaces.MAX+"";	
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.high_scores);

SharedPreferences prefs1 = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);


//getting preferences



Editor editor = prefs1.edit();

{ if(prefs1.getInt("key", 0)<=Surfaces.MAX)
	{editor.putInt("key", Surfaces.MAX);
	editor.commit();
	}	

}
	
	
	


high = (TextView)findViewById(R.id.high);
high.setText(prefs1.getInt("key", 0)+"");


}

}
