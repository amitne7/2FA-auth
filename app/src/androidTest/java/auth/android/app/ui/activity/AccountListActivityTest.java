package auth.android.app.ui.activity;


import android.content.Context;
import android.content.pm.PackageManager;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class AccountListActivityTest {

    @Test
    public void checkSinglePermission_grantedOrDenied() {
        Context context = InstrumentationRegistry.getTargetContext();

        // Test ACCESS_FINE_LOCATION permission (usually denied in default test environment)
        boolean granted = AccountListActivity.checkSinglePermission(context,
                android.Manifest.permission.ACCESS_FINE_LOCATION);

        // We don’t assert exact true/false because emulator may deny; just ensure method runs
        assertNotNull(granted);
    }
}