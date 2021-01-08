package com.example.mihogar.Common.Login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mihogar.Entity.ResponseEntity;
import com.example.mihogar.Entity.UserRegister;
import com.example.mihogar.R;
import com.example.mihogar.Retrofit.APiClassService;
import com.example.mihogar.Retrofit.ApiClient;
import com.example.mihogar.User.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterSession_3 extends AppCompatActivity {

    TextInputLayout phoneNumber;
    ApiClient apiClient;
    APiClassService aPiClassService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_retail_3);


//        Hooks numbre
        phoneNumber = findViewById(R.id.signup_phone_number);
    }



    public void callLoginFromSignUp(View view) {


        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    public void inicio(View view) {

        if (!validatePhoneNumber()) {
        return;
    }
        retrofitInit();
        registrarUsuario();

    }


    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
//        String checkspaces = "Aw{1,20}z";
        if (val.isEmpty()) {
            phoneNumber.setError("Enter valid phone number");
            return false;
//        } else if (!val.matches(checkspaces)) {
//            phoneNumber.setError("No White spaces are allowed!");
//            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }
    public void retroceder(View view) {
        onBackPressed();

    }


    private void registrarUsuario()
    {

        //validar los campos
        String telefono = phoneNumber.getEditText().getText().toString().trim();


        UserRegister userRegisterEntity = new UserRegister();

        Call<ResponseEntity> call = aPiClassService.RegistrarUsuario(userRegisterEntity);

        call.enqueue(new Callback<ResponseEntity>() {
            @Override
            public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                if(response.isSuccessful())
                {

                    ResponseEntity ResponseEntity = response.body();

                    if (ResponseEntity.getCode()== 200 && ResponseEntity.getMsg()== "ok" ){
                        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
                        finish();
                    }
                }
                else
                {
                    Toast.makeText(RegisterSession_3.this, "Hubo un error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseEntity> call, Throwable t) {
                Toast.makeText(RegisterSession_3.this, "Problema de conexion, Intente Luego", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void retrofitInit() {
        apiClient = ApiClient.getInstance();
        aPiClassService = apiClient.getaPiClassService();
    }
}