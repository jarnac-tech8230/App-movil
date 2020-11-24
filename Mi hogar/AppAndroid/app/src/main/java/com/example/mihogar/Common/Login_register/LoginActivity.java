package com.example.mihogar.Common.Login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mihogar.R;
import com.example.mihogar.User.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    Button registro;
    TextInputLayout email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.signin_email);
        password = findViewById(R.id.signin_password);


    }
//
//        registro = findViewById(R.id.id_registro);
//
//        registro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                vistaRegistro();
//            }
//        });
//    }

    public void vistaRegistro(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterSession_1.class));
        finish();
    }

    public void retroceder(View view) {
        LoginActivity.super.finish();
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();

    }

    public void inicio(View view) {
        if (!validateEmail() | !validatePassword()) {
            return;
        }

        Intent intent = new Intent(LoginActivity.this, UserDashboard.class);
        intent.putExtra("loginArray", email.getEditText().getText().toString());

        startActivity(intent);
//        finish();
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Campo no puede estar vacío");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Email invalído!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
//                ".{8,}" +               //at least 8 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Campo no puede estar vacío");
            return false;
//        } else if (!val.matches(checkPassword)) {
//            password.setError("Debe tener a menos 8 caracteres!");
//            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


}