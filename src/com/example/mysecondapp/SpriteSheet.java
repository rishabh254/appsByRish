package com.example.mysecondapp;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class SpriteSheet extends Activity {
	
	
	Overview v;
	Bitmap blob;
	Animation animate;
	
	MediaPlayer play; static int score=0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new Overview(this);
		play = MediaPlayer.create(this, R.raw.game_face);
		blob = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
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

	
	public class Overview extends SurfaceView implements Runnable {
 
		Thread t = null;
		SurfaceHolder holder;
		boolean isItOk = false;
		
		public Overview(Context context) {
			super(context);
			holder = getHolder();
			
			// TODO Auto-generated constructor stub
		}

		 @SuppressLint("WrongCall")
		@Override
		public void run() {
			 animate = new Animation(Overview.this,blob);
			// TODO Auto-generated method stub
			while(isItOk==true){
				
				if(!holder.getSurface().isValid())
					continue;
				
				Canvas c = holder.lockCanvas();

				c.drawARGB(255, 255, 255, 255);
				
				animate.onDraw(c);				
				holder.unlockCanvasAndPost(c);
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
