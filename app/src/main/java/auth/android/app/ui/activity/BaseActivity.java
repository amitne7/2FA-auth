package auth.android.app.ui.activity;

import static auth.android.app.utils.Constants.PREF_LANGUAGE;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import java.util.Locale;

import auth.android.app.utils.PrefsUtil;

public class BaseActivity extends AppCompatActivity {
    private Locale currentLocale;
    private static PrefsUtil prefsUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = getLocale(this);
        Locale.setDefault(getLocale(this));
        conf.setLayoutDirection(getLocale(this));
        res.updateConfiguration(conf, dm);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Locale locale = getLocale(this);
        if (!locale.equals(currentLocale)) {
            currentLocale = locale;
            recreate();
        }
    }
    public static Locale getLocale(Context context){
        prefsUtil = new PrefsUtil(context);
        String lang = prefsUtil.getString(PREF_LANGUAGE, "english");
        switch (lang) {
            case "hindi":
                lang = "hi";
                break;
            case "english":
            default:
                lang = "en";
                break;
        }
        return new Locale(lang);
    }
}
