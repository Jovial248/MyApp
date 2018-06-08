package com.jova.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                SharedPreferences sharedPref_presecurity = getPreferences(Context.MODE_PRIVATE);
                int check_key = sharedPref_presecurity.getInt(getString(R.string.presecurity_key), 0);
                Intent i;
                if( check_key == 0 ){
                    i = new Intent(SplashActivity.this, PresecurityActivity.class);
                }
                else{
                    i = new Intent(SplashActivity.this, MainActivity.class);
                }
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
