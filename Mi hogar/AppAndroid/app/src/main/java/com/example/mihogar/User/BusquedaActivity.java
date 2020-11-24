package com.example.mihogar.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mihogar.Common.Login_register.LoginActivity;
import com.example.mihogar.Common.SplashScreen;
import com.example.mihogar.R;
import com.google.android.material.navigation.NavigationView;

public class BusquedaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {


    static final float END_SCALE = 0.7f;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuBtn;
    LinearLayout contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);


//Hooks
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.layoutDrawer);
        menuBtn = findViewById(R.id.btn_menu);
        contentView = findViewById(R.id.content);
        navigationDrawer();

    }

    private void navigationDrawer() {
        //Nav drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_busqueda);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        drawerLayout.setScrimColor(getResources().getColor(R.color.lightWhite));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });

    }


    @Override
    public void onBackPressed() {
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                break;
            case R.id.nav_busqueda :
                startActivity(new Intent(getApplicationContext(), BusquedaActivity.class));
                break;
            case R.id.nav_categoria:
                startActivity(new Intent(getApplicationContext(), CategoriaActivity.class));
                break;
            case R.id.nav_contacto:
                startActivity(new Intent(getApplicationContext(), ContactoActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_login :
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

        }

        return true;
    }
}