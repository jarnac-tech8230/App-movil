package com.example.mihogar.Common;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mihogar.R;
import com.example.mihogar.User.UserDashboard;

import static android.net.ConnectivityManager.TYPE_MOBILE;
import static android.net.ConnectivityManager.TYPE_WIFI;

public class SplashScreen extends AppCompatActivity {

    private static int splash_screen = 3000;
    ImageView image;
    Animation bottom_ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (!isConnec(this)) {
            open();
        } else {

            setContentView(R.layout.splash_screen);
            bottom_ani = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
            image = findViewById(R.id.imageView2);
            image.setAnimation(bottom_ani);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                    startActivity(intent);
                    finish();
                }
            }, splash_screen);

        }

    }


    //metodo para mostrar dialogo de conexion

    public void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("No hay connexión, intente más tarde...");
        alertDialogBuilder.setPositiveButton("conectar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
//                        Toast.makeText(SplashScreen.this,"You clicked yes button",Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("cancelar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



    //metodo para comprobar si hay conexion
    private boolean isConnec(SplashScreen splashScreen) {

        ConnectivityManager connectivityManager = (ConnectivityManager) splashScreen.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(TYPE_WIFI);
        NetworkInfo mobil = connectivityManager.getNetworkInfo(TYPE_MOBILE);

        if ((wifi != null && wifi.isConnected()) || (mobil != null && mobil.isConnected())) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}