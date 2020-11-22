package com.example.mihogar.Common.Login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mihogar.R;

import java.util.Calendar;

public class RegisterSession_2 extends AppCompatActivity {

    //Variables
    ImageView backBtn;
    Button next, login;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_retail_2);


        //Hooks
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);
    }

    public void retroceder(View view) {
        onBackPressed();

    }

    public void call3rdSigupScreen(View view) {

        if (!validateAge() | !validateGender()) {
            return;
        }

        Intent intent = new Intent(getApplicationContext(), RegisterSession_3.class);
        startActivity(intent);
    }



    public void callLoginFromSignUp(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }



    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Seleccione tu género", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "Tu edad no está permitido", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }

}