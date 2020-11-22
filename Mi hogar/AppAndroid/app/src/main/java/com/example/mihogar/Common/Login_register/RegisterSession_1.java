package com.example.mihogar.Common.Login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mihogar.R;
import com.example.mihogar.User.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class RegisterSession_1 extends AppCompatActivity {


    //Variables
    ImageView backBtn;
    Button next, login;
    TextInputLayout fullname, email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_retail_1);


        //Hooks for animation
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);

//        hooks validation

        fullname = findViewById(R.id.signup_fullname);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);


    }

    //los metodos

    public void callNextSigupScreen(View view) {

        if (!validateFullName() | !validateEmail() | !validatePassword()) {
            return;
        }
        startActivity(new Intent(getApplicationContext(), RegisterSession_2.class));

    }

    public void callLoginFromSignUp(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    public void retroceder(View view) {
        RegisterSession_1.super.finish();
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();

    }

    private boolean validateFullName() {
        String val = Objects.requireNonNull(fullname.getEditText()).getText().toString().trim();
        if (val.isEmpty()) {
            fullname.setError("Campo no puede estar vacío");

            return false;
        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;
        }
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