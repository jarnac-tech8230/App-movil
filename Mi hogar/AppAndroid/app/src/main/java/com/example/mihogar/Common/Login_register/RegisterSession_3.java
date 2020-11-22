package com.example.mihogar.Common.Login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mihogar.R;
import com.example.mihogar.User.UserDashboard;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterSession_3 extends AppCompatActivity {

    TextInputLayout phoneNumber;

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
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
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

}