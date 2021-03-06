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
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mihogar.Common.SplashScreen;
import com.example.mihogar.Entity.ItemsEntity;
import com.example.mihogar.HelperClasses.FeaturedAdapter;
import com.example.mihogar.HelperClasses.FeaturedAdapterMost;
import com.example.mihogar.HelperClasses.Help_1;
import com.example.mihogar.R;
import com.example.mihogar.Common.Login_register.LoginActivity;
import com.example.mihogar.Retrofit.APiClassService;
import com.example.mihogar.Retrofit.ApiClient;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    ApiClient apiClient;
    APiClassService aPiClassService;

    static final float END_SCALE = 0.7f;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuBtn;
    LinearLayout contentView;
    RecyclerView featureCard, mostViewedRecycler;
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
        mostViewedRecycler = findViewById(R.id.RecyclermostView);
        navigationDrawer();
        featureRecycle();
        RecyclermostView();
        retrofitInit();
         buscarProductos();

        Bundle p = getIntent().getExtras();


        if (p != null) {
//            Log.i("Array", p.getString("loginArray"));

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("!Bienvenido!\n Correo ingresado es : " + p.getString("loginArray"));
            alertDialogBuilder.setPositiveButton("Aceptar",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(UserDashboard.this, "Disfrute la app", Toast.LENGTH_LONG).show();
                        }
                    });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
//        textView.setText(String.valueOf(numbersList));

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
    protected void onResume() {
        super.onResume();


    }


    @Override
    protected void onStop() {
        super.onStop();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onDestroy();
            }
        }, 180000);
    }


    public void notificacion(View view) {
        startActivity(new Intent(this, NotifyActivity.class));
    }

    public void itemvista(View view) {
        startActivity(new Intent(this, Item_activity.class));
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
                        onDestroy();
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
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
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

        featuredLocations.add(new Help_1(R.drawable.casa3, "Jarnac's", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new Help_1(R.drawable.casa1, "Edenrobe", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));
        featuredLocations.add(new Help_1(R.drawable.casa8, "Walmart", "asbkd asudhlasn saudnas jasdjasl hisajdl asjdlnas"));

        adapter = new FeaturedAdapter(featuredLocations);
        featureCard.setAdapter(adapter);
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


    public void buscarProductos() {

        Call<List<ItemsEntity>> call = aPiClassService.listaItem();

        call.enqueue(new Callback<List<ItemsEntity>>() {
            @Override
            public void onResponse(Call<List<ItemsEntity>> call, Response<List<ItemsEntity>> response) {
                //Todo esta OK

                if (response.isSuccessful()) {
                    Toast.makeText(UserDashboard.this, "llegando Ok", Toast.LENGTH_SHORT).show();
//                    List<ProductoEntity> productoEntities = new ArrayList<>();
//                    productoEntities = response.body();
//
//                    productoEntities.forEach(productoEntity -> System.out.println("Imprimiendo Lote: "+ productoEntity.getLote()));
//

                } else {
                    Toast.makeText(UserDashboard.this, "Problema pero fue 200", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<ItemsEntity>> call, Throwable t) {
                Toast.makeText(UserDashboard.this, "Problema de conexion", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void retrofitInit() {
        apiClient = ApiClient.getInstance();
        aPiClassService = apiClient.getaPiClassService();
    }

}