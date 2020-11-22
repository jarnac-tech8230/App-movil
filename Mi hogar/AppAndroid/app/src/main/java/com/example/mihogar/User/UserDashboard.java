package com.example.mihogar.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mihogar.HelperClasses.FeaturedAdapter;
import com.example.mihogar.HelperClasses.Help_1;
import com.example.mihogar.R;
import com.example.mihogar.Common.Login_register.LoginActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuBtn;
    LinearLayout contentView;
    RecyclerView featureCard;
//    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    Adapter adapter;
//    private GradientDrawable gradient1, gradient2, gradient3, gradient4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


//Hooks
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.layoutDrawer);
        menuBtn = findViewById(R.id.btn_menu);
        contentView = findViewById(R.id.content);
        featureCard = findViewById(R.id.featured_recycler);
        navigationDrawer();
        featureRecycle();


    }


    private void navigationDrawer() {
        //Nav drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);
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


    public void notificacion(View view) {
        startActivity(new Intent(this, NotifyActivity.class));
    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            salir();
        }
    }


        public void salir() {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("¿Estás seguro que deseas salir ?");
            alertDialogBuilder.setPositiveButton("Salir",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                           finish();
//                        Toast.makeText(SplashScreen.this,"You clicked yes button",Toast.LENGTH_LONG).show();
                        }
                    });

            alertDialogBuilder.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                break;
            case R.id.nav_busqueda:
                startActivity(new Intent(getApplicationContext(), BusquedaActivity.class));
                break;
            case R.id.nav_categoria:
                startActivity(new Intent(getApplicationContext(), CategoriaActivity.class));
                break;
            case R.id.nav_contacto:
                startActivity(new Intent(getApplicationContext(), ContactoActivity.class));
                break;
            case R.id.nav_ayuda:
                startActivity(new Intent(getApplicationContext(), AyudaActivity.class));
                break;
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;

        }

        return true;
    }



    private void featureRecycle() {
        featureCard.setHasFixedSize(true);
        featureCard.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<Help_1> featuredLocations = new ArrayList<>();

        featuredLocations.add(new Help_1(R.drawable.casa1, "Jarnac's", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new Help_1(R.drawable.casa3, "Edenrobe", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new Help_1(R.drawable.casa8, "Walmart", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));

        adapter = new FeaturedAdapter(featuredLocations);
        featureCard.setAdapter(adapter);
    }

}