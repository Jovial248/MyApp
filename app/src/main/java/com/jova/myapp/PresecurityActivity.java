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

public class PresecurityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presecurity1);

        Button continue_btn = findViewById(R.id.button);
         final EditText pw = (EditText) findViewById(R.id.editText);
         final EditText pwc = (EditText) findViewById(R.id.editText2);

        continue_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses
                String pw1 = pw.getText().toString();
                String pw2 = pwc.getText().toString();
                if(pw1.equals(pw2)){
                    SharedPreferences sharedPref_pw = getSharedPreferences(
                            getString(R.string.security_password), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref_pw.edit();
                    editor.putString("password", pw1);
                    editor.apply();

                    Context context = getApplicationContext();
                    CharSequence text = "Password saved!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    Intent i = new Intent(PresecurityActivity.this, SigninActivity.class);
                    startActivity(i);
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Password not matching!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

    }

}
