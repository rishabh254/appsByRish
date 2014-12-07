package com.example.mysecondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GameOver extends Activity {

	TextView scores ;
	

	
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.game_over);
Intent i  = getIntent();
Bundle b = i.getExtras();
 String text = b.getString("score");
scores= (TextView)findViewById(R.id.scores);
scores.setText(text);

}

@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	super.onBackPressed();
	startActivity(new Intent(GameOver.this, MainActivity.class));
}

}



