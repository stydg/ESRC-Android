package com.esrc.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class emotion_cheakActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emotion_cheak);

        Button emotion_cheak_btn_send;
        emotion_cheak_btn_send = findViewById(R.id.emotion_cheak_btn_send);
        emotion_cheak_btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(emotion_cheakActivity.this, FinishActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
