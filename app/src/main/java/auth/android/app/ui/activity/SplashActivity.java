package auth.android.app.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;

import auth.android.app.R;

public class SplashActivity extends AppCompatActivity {
    //Set splash screen time duration
    private final static int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try {
            FirebaseMessaging.getInstance().subscribeToTopic("authApp");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(() -> {
            Intent rIntent = new Intent(SplashActivity.this, AccountListActivity.class);
            startActivity(rIntent);
            finish();
        }, SPLASH_TIME);
    }
}