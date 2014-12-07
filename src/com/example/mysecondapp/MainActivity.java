package com.example.mysecondapp;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class MainActivity extends Activity implements OnClickListener {
	MediaPlayer logoMusic,buttonSound;
	static int score;
	int data;
	Bitmap bmp;
	ImageView img;
	String s[] ={"goelrishabh5@gmail.com"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		logoMusic = MediaPlayer.create(this, R.raw.game_face);
		buttonSound=MediaPlayer.create(this,R.raw.button1);
		logoMusic.start();
		
		// Set up click listeners for all the buttons
		
		View imagesButton = findViewById(R.id.button1);
		View animationButton = findViewById(R.id.button2);
		imagesButton.setOnClickListener(this);
		animationButton.setOnClickListener(this);
		View highScoreButton = findViewById(R.id.button3);
		highScoreButton.setOnClickListener(this);
		View pacmanButton = findViewById(R.id.button4);
		pacmanButton.setOnClickListener(this);
		View emailButton = findViewById(R.id.button5);
		emailButton.setOnClickListener(this);
		View imageButton = findViewById(R.id.button6);
		imageButton.setOnClickListener(this);
		
	

		
	}

	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.button1:
			buttonSound.start();	
			startActivity(new Intent(this,Images.class));
			
			break;	
			
		case R.id.button2:
			buttonSound.start();	
			startActivity(new Intent(this,Surfaces.class));
			break;	
			
		case R.id.button3:
			buttonSound.start();
			startActivity(new Intent(this,HighScores.class));
			break;	
			
		case R.id.button4:
			buttonSound.start();	
			startActivity(new Intent(this,SpriteSheet.class));
			break;	
			
		case R.id.button5:
			buttonSound.start();	
			Intent email_intent = new Intent(android.content.Intent.ACTION_SEND);
			email_intent.putExtra(android.content.Intent.EXTRA_EMAIL, s);
			email_intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "hello");
			email_intent.setType("plain/text");
			email_intent.putExtra(android.content.Intent.EXTRA_TEXT, "this is a message");
			startActivity(email_intent);
			break;	
			
		case R.id.button6:
			buttonSound.start();	
			startActivity(new Intent(this,Capture.class));
			
			break;	
		
		// More buttons go here (if any) ...
		}
		}
	


	public boolean onCreateOptionsMenu(Menu menu) {
	super.onCreateOptionsMenu(menu);
	MenuInflater inflater = getMenuInflater();
	inflater.inflate(R.menu.menu, menu);
	return true;
	}

	
	public boolean onOptionsItemSelected(MenuItem item) {
	switch (item.getItemId()) {
	case R.id.settings:
	startActivity(new Intent(this, Prefs.class));
	return true;
			
		
		}
		return false;
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		super.onPostResume();
		logoMusic.start();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		logoMusic.pause();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		logoMusic.pause();
		
	}
	

	
}
