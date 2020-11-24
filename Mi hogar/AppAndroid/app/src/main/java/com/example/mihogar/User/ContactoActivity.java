package com.example.mihogar.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.mihogar.Common.SplashScreen;
import com.example.mihogar.R;

public class ContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


    }


    public void back_btn(View view){
        super.onBackPressed();
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

}