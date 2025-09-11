package auth.android.app.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;

import auth.android.app.R;
import auth.android.app.utils.PrefsUtil;

public class SplashActivity extends AppCompatActivity {
    //Set splash screen time duration
    private final static int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final PrefsUtil prefsUtil = new PrefsUtil(this);
        try {
            FirebaseMessaging.getInstance().subscribeToTopic("authApp");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent rIntent = new Intent(SplashActivity.this, AccountListActivity.class);
                startActivity(rIntent);
                finish();
            }
        }, SPLASH_TIME);
    }
}