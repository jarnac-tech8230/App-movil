package com.example.mihogar.Retrofit;
import com.example.mihogar.Entity.ItemsEntity;
import com.example.mihogar.Entity.ResponseEntity;
import com.example.mihogar.Entity.UserRegister;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APiClassService {

    @GET("api/servicioapi.php")
    Call<List<ItemsEntity>> listaItem();

    @POST("api/registrar.php")
    Call<ResponseEntity>RegistrarUsuario(@Body UserRegister userRegisterEntity);

}
