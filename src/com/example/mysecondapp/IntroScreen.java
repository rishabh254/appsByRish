package com.example.mysecondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntroScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

     Thread t = new Thread(){
     
     public void run(){
    	 try{
    		 
    		 sleep(2500);
    	 }
    	 
    	 catch(InterruptedException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 
    	 finally{
    		 
    		 startActivity(new Intent(IntroScreen.this,MainActivity.class));
    		 finish();
    		 
    	 }
     }
     };
     t.start();
    }
}

