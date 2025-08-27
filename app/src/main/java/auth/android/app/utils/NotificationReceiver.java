package auth.android.app.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import auth.android.app.utils.LocationTracker;

import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.responsemodel.GeneralResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static auth.android.app.utils.Constants.PREF_EMAIL;

public class NotificationReceiver extends BroadcastReceiver {
    private static NotificationListener notificationListener;
    private LocationTracker tracker;
    private StringBuilder stringBuilder = new StringBuilder();
    PrefsUtil prefsUtil;
    private String latLng;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (null != notificationListener) {
            notificationListener.notificationReceived(0);
        }
        Log.e("CHECK", "On Receive");
        stringBuilder = new StringBuilder();
        stringBuilder.append("inside the tracking service\n");
        prefsUtil = new PrefsUtil(context);

        stringBuilder.append("User found: " + prefsUtil.getString(PREF_EMAIL));
        Date currentDate = Calendar.getInstance(Locale.ENGLISH).getTime();
        int hours = Integer.valueOf(DateFormat.format("kk", currentDate).toString());
        String day = DateFormat.format("EEEE", currentDate).toString();
        init(context);
        tracker.getLocation();
        stringBuilder.append("\nGetting the location");
        handler.postDelayed(runnable, 5000);
    }
    public static void bindListener(NotificationListener listener) {
        notificationListener = listener;
    }

    private void init(Context context) {
        tracker = new LocationTracker(context);
    }

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (tracker.canGetLocation()) {
                stringBuilder.append("\nGPS Enabled: true");
                Location location = tracker.getLocation();
                latLng = tracker.getLatitude() + "," + tracker.getLongitude();
                stringBuilder.append("\nCurrent latLong: " + latLng);
                Log.e("LOCATION", latLng +"");
                Map<String, String> locationMap = new HashMap<>();
                locationMap.put("lat", String.valueOf(location.getLatitude()));
                locationMap.put("lng", String.valueOf(location.getLongitude()));
                locationMap.put("email", prefsUtil.getString(Constants.PREF_EMAIL));
                locationMap.put("uid", String.valueOf(prefsUtil.getInt(Constants.PREF_USER_ID)));
                sendLocation(locationMap);

            } else {
                stringBuilder.append("\nGPS Enabled: false");

            }
            Log.e("ERR", stringBuilder.toString());

        }
    };

    private void trackLocation() {
        if (tracker.canGetLocation()) {
            stringBuilder.append("\nGPS Enabled: true");
            Location location = tracker.getLocation();
            latLng = tracker.getLatitude() + "," + tracker.getLongitude();
            stringBuilder.append("\nCurrent latLong: " + latLng);
            Map<String, String> locationMap = new HashMap<>();
            locationMap.put("lat", String.valueOf(location.getLatitude()));
            locationMap.put("lng", String.valueOf(location.getLongitude()));
            locationMap.put("mobile", prefsUtil.getString(Constants.PREF_EMAIL));
            locationMap.put("uid", String.valueOf(prefsUtil.getInt(Constants.PREF_USER_ID)));
            sendLocation(locationMap);

        } else {
            stringBuilder.append("\nGPS Enabled: false");

        }
    }

    private void sendLocation(Map<String, String> locationMap) {
        Webservice webservice = ApiClient.getRetrofitClient(Constants.BASE_URL).create(Webservice.class);
        Call<GeneralResponse> call = webservice.sendLocation(locationMap);
        call.enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });
    }

}
