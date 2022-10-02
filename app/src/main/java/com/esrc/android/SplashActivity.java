package com.esrc.android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity  extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceStare) {
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_splash);
        goMap();
    }

    public void goMap(){
        TimerTask goGeo = new TimerTask(){
            public void run(){
                Intent intent = new Intent(SplashActivity.this, ListViewActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(goGeo, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}