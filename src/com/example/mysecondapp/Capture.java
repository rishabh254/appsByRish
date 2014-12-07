package com.example.mysecondapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

public class Capture extends Activity implements android.view.View.OnClickListener {

	 ImageView img;int data;
	MediaPlayer buttonSound;
	Bitmap bmp;
	View setImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.capture);
		
		View captureImage = findViewById(R.id.takepic);
		captureImage.setOnClickListener(this);
		setImage = findViewById(R.id.setpic);
		
		
	    img = (ImageView)findViewById(R.id.pictha);
		img.setOnClickListener(this);
		
		buttonSound = MediaPlayer.create(this, R.raw.button1);
		try {
			store();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public void store() throws IOException
{	String s ="yipee";
	
	File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	File myFile = new File(file,"yeah.txt");
	FileOutputStream fout = null;
	try {
		fout = new FileOutputStream(myFile);
		fout.write(s.getBytes());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally{
		if(fout!=null)
			fout.close();
	}
	
}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK)
		{
			setImage.setOnClickListener(this);
			Bundle extras  = data.getExtras();
			bmp = (Bitmap)extras.get("data");
		    img.setImageBitmap(bmp);
			
		}
	}



	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		
		{
		case R.id.takepic:
			
			buttonSound.start();	
			Intent image = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(image,data);
			break;
		
		case R.id.setpic :
			
			
			buttonSound.start();
			
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		
	}


	
	
}
