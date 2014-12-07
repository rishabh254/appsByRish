package com.example.mysecondapp;

import com.example.mysecondapp.SpriteSheet.Overview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Animation extends Activity  {
	Overview v;
	Bitmap b;
	int x,y,height,width;
	
	
	public Animation(Overview overview, Bitmap blob) {
		// TODO Auto-generated constructor stub
		v = overview;
		b = blob;
		x=0;y=0;
		height = b.getHeight();
		width = b.getWidth();
	}

	public void onDraw(Canvas c) {
		// TODO Auto-generated method stub
		Rect src = new Rect (0,0,width,height);
		Rect dst = new Rect (x,y,x+width,x+height);
		c.drawBitmap(b, src, dst, null);
		update();
		
	}

	
	
	public void update()
	{
		x=x+5;
		
		
		
	}
		
	
	

}
