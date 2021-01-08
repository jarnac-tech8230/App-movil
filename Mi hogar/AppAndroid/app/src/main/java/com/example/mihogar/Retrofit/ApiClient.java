package com.example.mihogar.Retrofit;


import com.example.mihogar.Admin.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient instance = null;
    private APiClassService aPiClassService;
    private Retrofit retrofit;

    public ApiClient() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aPiClassService = retrofit.create(APiClassService.class);
    }

    //Patron Singleton
    public static ApiClient getInstance(){
        if(instance == null){
            instance = new ApiClient();
        }

        return instance;
    }

    public APiClassService getaPiClassService(){
        return aPiClassService;
    }
}
