package auth.android.app.fcm;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Random;

import auth.android.app.responsemodel.home.PageDataList;
import auth.android.app.ui.activity.AccountListActivity;
import auth.android.app.ui.activity.RegistrationActivity;
import auth.android.app.utils.NotificationReceiver;
import auth.android.app.utils.PrefsUtil;
import event.msvc.android.R;
import auth.android.app.utils.Constants;

public class AppFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        PrefsUtil prefsUtil = new PrefsUtil(getApplicationContext());
        int count = prefsUtil.getInt(Constants.PREF_NOTIFICATION_COUNTER, 0);
        count++;
        Map<String, String> dataMap = remoteMessage.getData();
        String title = dataMap.get("title");
        String body = dataMap.get("body");

        String event_tab_id = dataMap.get("access_code");
//        String listing = dataMap.get("listing");
//        String mListing = "";
        Log.d("EVENT TAB ID", event_tab_id + "");

        Intent resultIntent = new Intent(this, AccountListActivity.class);
        resultIntent.putExtra("event_tab_id", event_tab_id);
        resultIntent.putExtra("source", "notification");

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(AccountListActivity.class);
        taskStackBuilder.addNextIntent(resultIntent);
        final int flag = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE : PendingIntent.FLAG_UPDATE_CURRENT;
        PendingIntent contentIntent = taskStackBuilder
                .getPendingIntent(0, flag);

        /*PendingIntent contentIntent = taskStackBuilder
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);*/

        NotificationCompat.Builder mBuilder = null;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            CharSequence name = "Test";
            String description = "My CHANNEL";
            int importance = NotificationManagerCompat.IMPORTANCE_HIGH;
            @SuppressLint("WrongConstant") NotificationChannel channel = new NotificationChannel("01", name, importance);
            channel.setDescription(description);
            // Register the channel with the system
//            NotificationManager notificationManager = NotificationManager.
//            notificationManager.createNotificationChannel(channel);


            mNotifyMgr.createNotificationChannel(channel);

            mBuilder = new NotificationCompat.Builder(this, "01")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setContentIntent(contentIntent)
                    .setPriority(NotificationCompat.PRIORITY_MAX).setAutoCancel(true);


        } else {
            mBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(body)
                    .setContentText(title)
                    .setContentIntent(contentIntent)
                    .setPriority(NotificationCompat.PRIORITY_MAX).setAutoCancel(true);
        }

        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        // Builds the notification and issues it.
        mNotifyMgr.notify(m, mBuilder.build());

        prefsUtil.saveInt(Constants.PREF_NOTIFICATION_COUNTER, count);
//        Intent intent = new Intent("auth.android.app.NOTI_LISTENER");
        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        sendBroadcast(intent);
    }
}
