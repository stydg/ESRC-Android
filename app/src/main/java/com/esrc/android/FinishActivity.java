package com.esrc.android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FinishActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceStare) {
        super.onCreate(savedInstanceStare);
        setContentView(R.layout.activity_finish);

        Button btn1 = (Button) findViewById(R.id.button_001);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    public void btn(View v){
        Toast.makeText(getApplicationContext(), "button click", Toast.LENGTH_LONG).show();
        onPause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
