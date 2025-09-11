package auth.android.app.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import auth.android.app.remote.ApiClient;
import auth.android.app.remote.Webservice;
import auth.android.app.responsemodel.GeneralResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationReceiver extends BroadcastReceiver {
    private static NotificationListener notificationListener;
    private LocationTracker tracker;

    PrefsUtil prefsUtil;
    private String latLng;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (null != notificationListener) {
            notificationListener.notificationReceived(0);
        }

        prefsUtil = new PrefsUtil(context);

        Date currentDate = Calendar.getInstance(Locale.ENGLISH).getTime();
        int hours = Integer.valueOf(DateFormat.format("kk", currentDate).toString());
        String day = DateFormat.format("EEEE", currentDate).toString();
        init(context);
        tracker.getLocation();
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
                Location location = tracker.getLocation();
                latLng = tracker.getLatitude() + "," + tracker.getLongitude();
                Map<String, String> locationMap = new HashMap<>();
                locationMap.put("lat", String.valueOf(location.getLatitude()));
                locationMap.put("lng", String.valueOf(location.getLongitude()));
                locationMap.put("device_id", prefsUtil.getString(Constants.PREF_DEVICE_ID));
                locationMap.put("uid", String.valueOf(prefsUtil.getInt(Constants.PREF_USER_ID)));
                sendLocation(locationMap);

            }


        }
    };

    private void trackLocation() {
        if (tracker.canGetLocation()) {
            Location location = tracker.getLocation();
            latLng = tracker.getLatitude() + "," + tracker.getLongitude();
            Map<String, String> locationMap = new HashMap<>();
            locationMap.put("lat", String.valueOf(location.getLatitude()));
            locationMap.put("lng", String.valueOf(location.getLongitude()));
            locationMap.put("device_id", prefsUtil.getString(Constants.PREF_DEVICE_ID));
            locationMap.put("uid", String.valueOf(prefsUtil.getInt(Constants.PREF_USER_ID)));
            sendLocation(locationMap);

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
