package auth.android.app.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import auth.android.app.utils.Constants;
import auth.android.app.utils.PrefsUtil;
import event.msvc.android.R;

public class SplashActivity extends AppCompatActivity {
    //Set splash screen time duration
    private final static int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final PrefsUtil prefsUtil = new PrefsUtil(this);
        prefsUtil.saveString(Constants.PREF_EMAIL, "hello@mail.com");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (prefsUtil.getBoolean(Constants.IS_LOGGED_IN)) {
                    Intent mIntent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(mIntent);
                    finish();
                } else {
                    Intent rIntent = new Intent(SplashActivity.this, AccountListActivity.class);
                    startActivity(rIntent);
                    finish();
                }
            }
        }, SPLASH_TIME);
    }
}