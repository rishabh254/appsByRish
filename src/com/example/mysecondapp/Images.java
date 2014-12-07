package com.example.mysecondapp;

import java.io.IOException;
import java.io.InputStream;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Images extends Activity implements OnClickListener {

	int but;
	ImageView display;
	MediaPlayer buttonSound;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
		setContentView(R.layout.images);
		buttonSound=MediaPlayer.create(this,R.raw.button1);
	
		but=R.drawable.p2;
		
		ImageView p2 = (ImageView)findViewById(R.id.p2);
		ImageView p3 = (ImageView)findViewById(R.id.p3);
		ImageView p4 = (ImageView)findViewById(R.id.p4);
		ImageView p5 = (ImageView)findViewById(R.id.p5);
		ImageView p6 = (ImageView)findViewById(R.id.p6);
		ImageView p7 = (ImageView)findViewById(R.id.p7);
		ImageView p8 = (ImageView)findViewById(R.id.p8);
		ImageView p9 = (ImageView)findViewById(R.id.p9);
		display = (ImageView)findViewById(R.id.display);
		p2.setOnClickListener(this);
		p3.setOnClickListener(this);
		p4.setOnClickListener(this);
		p5.setOnClickListener(this);
		p6.setOnClickListener(this);
		p7.setOnClickListener(this);
		p8.setOnClickListener(this);
		p9.setOnClickListener(this);
		Button setter =(Button)findViewById(R.id.imagesetter);
		setter.setOnClickListener(this);
		
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{ case R.id.p2 :
			display.setImageResource(R.drawable.p2);
			but=R.drawable.p2;
		  break;
		  
		case R.id.p3 :
			display.setImageResource(R.drawable.p3);
			but=R.drawable.p3;
		  break;
		  
		case R.id.p4 :
			display.setImageResource(R.drawable.p4);
			but=R.drawable.p4;
		  break;
		  
		case R.id.p5 :
			display.setImageResource(R.drawable.p5);
			but=R.drawable.p5;
		  break;
		  
		case R.id.p6 :
			display.setImageResource(R.drawable.p6);
			but=R.drawable.p6;
		  break;
		  
		case R.id.p7 :
			display.setImageResource(R.drawable.p7);
			but=R.drawable.p7;
		  break;
		  
		case R.id.p8 :
			display.setImageResource(R.drawable.p8);
			but=R.drawable.p8;
		  break;
		  
		case R.id.p9 :
			display.setImageResource(R.drawable.p9);
			but=R.drawable.p9;
		  break;
		case R.id.imagesetter:
			buttonSound.start();
			InputStream hell = getResources().openRawResource(but);
			Bitmap pic = BitmapFactory.decodeStream(hell);
			try {
				getApplicationContext().setWallpaper(pic);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Toast.makeText(this, "Background set successfully!",Toast.LENGTH_LONG).show();
		  
		}
			
		
		
		}
	
	}
		
	
	
	


