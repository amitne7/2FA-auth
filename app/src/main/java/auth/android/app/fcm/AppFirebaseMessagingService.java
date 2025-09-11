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
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import java.util.Random;
import auth.android.app.ui.activity.AccountListActivity;
import auth.android.app.utils.NotificationReceiver;
import auth.android.app.R;
import static auth.android.app.utils.Constants.ACCESS_CODE;
import static auth.android.app.utils.Constants.SOURCE_SCREEN;

public class AppFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        RemoteMessage.Notification notificationData = remoteMessage.getNotification();
        String title = notificationData.getTitle();
        String body = notificationData.getBody();
        Map<String, String> dataMap = remoteMessage.getData();
        String accessCode = dataMap.get("access_code");

        Intent resultIntent = new Intent(this, AccountListActivity.class);
        resultIntent.putExtra(ACCESS_CODE, accessCode);
        resultIntent.putExtra(SOURCE_SCREEN, "notification");

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(AccountListActivity.class);
        taskStackBuilder.addNextIntent(resultIntent);
        final int flag = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE : PendingIntent.FLAG_UPDATE_CURRENT;
        PendingIntent contentIntent = taskStackBuilder
                .getPendingIntent(0, flag);


        NotificationCompat.Builder mBuilder = null;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            CharSequence name = "AuthApp";
            String description = "NotificationChannel";
            int importance = NotificationManagerCompat.IMPORTANCE_HIGH;
            @SuppressLint("WrongConstant") NotificationChannel channel = new NotificationChannel("01", name, importance);
            channel.setDescription(description);

            //Register the channel with the system
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

//        Intent intent = new Intent("auth.android.app.NOTI_LISTENER");
        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        sendBroadcast(intent);
    }
}
