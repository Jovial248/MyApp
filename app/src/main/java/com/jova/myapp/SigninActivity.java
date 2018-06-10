package com.jova.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presecurity2);

        final EditText pw = findViewById(R.id.editText4);
        SharedPreferences sharedPref_pw = getSharedPreferences(
                getString(R.string.security_password), Context.MODE_PRIVATE);
        String pwr = sharedPref_pw.getString("password", null) ;

        Button signin_btn = findViewById(R.id.button2);
        signin_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(SigninActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}
