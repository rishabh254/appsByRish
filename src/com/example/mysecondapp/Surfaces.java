package com.example.mysecondapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class Surfaces extends Activity implements OnTouchListener{
	
	
	Overview v;int cnt=0;long time=1400;
	Bitmap ball,blank;
	static float x,y,x1,y1;
	MediaPlayer play; static int score=0;
	static int MAX=0;
	
	 public static int randBetween(int start, int end) {
	        return start + (int)Math.round(Math.random() * (end - start));}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new Overview(this);
		v.setOnTouchListener(this);
		play = MediaPlayer.create(this, R.raw.game_face);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
		blank =  BitmapFactory.decodeResource(getResources(), R.drawable.blank);
		x=0;y=0;x1=0;y1=0;
		setContentView(v);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
	}

	@SuppressLint("ClickableViewAccessibility") @Override
	public boolean onTouch(View v, MotionEvent event) {
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			x1= event.getX();
			y1=event.getY();
			
		return true;
	}
	



class Overview extends SurfaceView implements Runnable {

	Thread t = null;
	SurfaceHolder holder;
	boolean isItOk = false;
	
	
	
	public Overview(Context context) {
		super(context);
		holder = getHolder();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isItOk==true){
			if(time==1200)
				{try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
			if(!holder.getSurface().isValid())
				continue;
			
			Canvas c = holder.lockCanvas();
			c.drawARGB(255, 255, 255, 255);
			x= randBetween(0,c.getWidth()-ball.getWidth());
			y=randBetween(0,c.getHeight()-ball.getHeight());
			
			c.drawBitmap(ball, x,y, null);
		
			holder.unlockCanvasAndPost(c);
			
			try  {
				Thread.sleep(time);
				
			cnt++;
				
				if(time==50)
					time=1400;
				if(cnt==1)
					{time=time-20;
					cnt=0;}
				
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Math.abs(x1-x)<80  && Math.abs(y- y1)<80)
				score++;
			else
				{ 
					MAX=score;
					score=0;
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Bundle b = new Bundle();
				b.putString("score", MAX+"");
				Intent i = new Intent(Surfaces.this,GameOver.class);
				i.putExtras(b);
				startActivity(i);
				}
			
		}
			
		
	}
	
	public void pause() {
		isItOk = false;
	
		try{t.join();
		}
		catch(InterruptedException e)
		{e.printStackTrace();}
		
		t= null;
	}
	
	public void resume() {
		
		isItOk = true;
		t = new Thread(this);
		t.start();

		
		
	}
	
	
}
}
