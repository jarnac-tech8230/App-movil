package com.example.mihogar.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.mihogar.Common.Login_register.LoginActivity;
import com.example.mihogar.Common.SplashScreen;
import com.example.mihogar.HelperClasses.FeaturedAdapterMost;
import com.example.mihogar.HelperClasses.FeaturedCaroussel;
import com.example.mihogar.HelperClasses.Help_1;
import com.example.mihogar.HelperClasses.Help_2;
import com.example.mihogar.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Item_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView featureItem;
    Adapter adapter;
    static final float END_SCALE = 0.7f;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuBtn;
    LinearLayout contentView;
    RecyclerView mostViewedRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_activity);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.layoutDrawer);
        menuBtn = findViewById(R.id.btn_menu);
        contentView = findViewById(R.id.content);

        mostViewedRecycler = findViewById(R.id.RecyclermostView);

        featureItem = findViewById(R.id.featured_recycler_item);


        VideoView videoView = findViewById(R.id.video);
        String pathVideo = "android.resource://" + getPackageName() + "/" + R.raw.video1;
        Uri uri = Uri.parse(pathVideo);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }


    @Override
    protected void onStart() {
        super.onStart();
        navigationDrawer();
        featureRecycle();
        RecyclermostView();
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

    private void featureRecycle() {
        featureItem.setHasFixedSize(true);
        featureItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<Help_2> featuredLocations = new ArrayList<>();

        featuredLocations.add(new Help_2(R.drawable.casa8));
        featuredLocations.add(new Help_2(R.drawable.casa3));
        featuredLocations.add(new Help_2(R.drawable.casa8));

        featuredLocations.add(new Help_2(R.drawable.casa3));
        featuredLocations.add(new Help_2(R.drawable.casa1));
        featuredLocations.add(new Help_2(R.drawable.casa8));

        adapter = new FeaturedCaroussel(featuredLocations);
        featureItem.setAdapter(adapter);
    }

    public void notificacion(View view) {
        startActivity(new Intent(this, NotifyActivity.class));
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
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

        }

        return true;
    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void mapaView(View view) {

        startActivity(new Intent(getApplicationContext(), MapsActivity.class));


    }


    private void RecyclermostView() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ArrayList<Help_1> featuredLocations = new ArrayList<>();

        featuredLocations.add(new Help_1(R.drawable.casa1, "Jarnac's", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new Help_1(R.drawable.casa3, "Edenrobe", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new Help_1(R.drawable.casa8, "Walmart", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));

        featuredLocations.add(new Help_1(R.drawable.casa3, "Jarnac's", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new Help_1(R.drawable.casa1, "Edenrobe", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new Help_1(R.drawable.casa8, "Walmart", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));

        adapter = new FeaturedAdapterMost(featuredLocations);
        mostViewedRecycler.setAdapter(adapter);
    }
}


//    public void salir() {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setMessage("¿Estás seguro que deseas salir ?");
//        alertDialogBuilder.setPositiveButton("Salir",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface arg0, int arg1) {
//                        finish();
////                        Toast.makeText(SplashScreen.this,"You clicked yes button",Toast.LENGTH_LONG).show();
//                    }
//                });
//
//        alertDialogBuilder.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }


