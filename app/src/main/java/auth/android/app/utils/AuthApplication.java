package auth.android.app.utils;

import static auth.android.app.utils.Constants.PREF_DEVICE_ID;

import android.app.Application;
import android.provider.Settings;

public class AuthApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String device_id = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        PrefsUtil prefsUtil = new PrefsUtil(this);
        prefsUtil.saveString(PREF_DEVICE_ID, device_id);
    }
}
