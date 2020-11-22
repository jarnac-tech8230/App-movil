package com.example.mihogar.User;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
    public void onBackPressed() {
    }

}