package com.example.alex.matematicamente;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 5000;
    SubsamplingScaleImageView imageView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash_screen);

        imageView = (SubsamplingScaleImageView) findViewById(R.id.image);
        imageView.setImage(ImageSource.resource(R.drawable.splash_icon));
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String username = preferences.getString("user", "");
                String password = preferences.getString("password","");
                Log.e("--->", username + password);
                if (username.equals("")){
                    Log.e("--->","NO SE HA REALIZADO REGISTRO");
                    Intent intent = new Intent(SplashScreenActivity.this,RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Log.e("--->","REGISTRO EXITOSO");
                    Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
