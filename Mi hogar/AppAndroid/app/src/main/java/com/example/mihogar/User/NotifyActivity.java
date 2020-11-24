package com.example.mihogar.User;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.example.mihogar.Common.SplashScreen;
import com.example.mihogar.R;

public class NotifyActivity extends AppCompatActivity {

    ImageView btn_back_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        btn_back_notice = findViewById(R.id.back_btn_notify);

        btn_back_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotifyActivity.super.finish();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), SplashScreen.class);
                startActivity(intent);
                finish();
            }
        }, 180000);
    }

    @Override
    public void onBackPressed() {
    }

}