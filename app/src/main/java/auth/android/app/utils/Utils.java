package auth.android.app.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import auth.android.app.R;


public class Utils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static Typeface getFont(Context context, String type) {
        Typeface bold = Typeface.createFromAsset(context.getAssets(), Constants.TYPEFACE_BOLD);
        Typeface regular = Typeface.createFromAsset(context.getAssets(), Constants.TYPEFACE_REGULAR);
        Typeface medium = Typeface.createFromAsset(context.getAssets(), Constants.TYPEFACE_MEDIUM);
        Typeface italic = Typeface.createFromAsset(context.getAssets(), Constants.TYPEFACE_ITALIC);
        if (type.equalsIgnoreCase(Constants.MEDIUM)) {
            return medium;
        } else if (type.equalsIgnoreCase(Constants.BOLD)) {
            return bold;
        } else if (type.equalsIgnoreCase(Constants.ITALIC)) {
            return italic;
        } else {
            return regular;
        }
    }

    public static String acronym(String name) {

        if (name != null) {
            String after = name.trim().replaceAll(" +", " ");
            if (after.contains(" ")) {
                int spaceIndex = name.indexOf(" ");
                return after.substring(0, 1) + after.substring(spaceIndex + 1, spaceIndex + 2);
            } else {
                return after.substring(0, 2);
            }
        } else {
            return "";
        }
    }

    public static void showMessageOnMainThread(final Activity activity, final View containerView, final String message) {
        activity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                showMessageShort(containerView, message, activity);
            }
        });
    }

    public static void showMessageShort(View containerView, String message, Activity activity) {
        if (TextUtils.isEmpty(message)) return;
        Snackbar snackbar = Snackbar.make(containerView, message, Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.setBackgroundColor(activity.getColor(R.color.colorAccent));
        }
        TextView snackBarActionTextView = snackbar.getView().findViewById(R.id.snackbar_action);
        snackBarActionTextView.setTypeface(snackBarActionTextView.getTypeface(), Typeface.BOLD);
        snackBarActionTextView.setTextSize(16);
        snackbar.show();
    }
}
