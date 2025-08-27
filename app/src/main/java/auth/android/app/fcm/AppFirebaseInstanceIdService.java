package auth.android.app.fcm;

import android.util.Log;


import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import auth.android.app.utils.PrefsUtil;
import auth.android.app.utils.Constants;

public class AppFirebaseInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        PrefsUtil prefsUtil = new PrefsUtil(getApplicationContext());
        Log.i("TOKEN", FirebaseInstanceId.getInstance().getToken());
        prefsUtil.saveString(Constants.PREF_FCM_TOKEN, FirebaseInstanceId.getInstance().getToken());
    }
}
