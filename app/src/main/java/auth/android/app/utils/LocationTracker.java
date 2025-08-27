package auth.android.app.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.Date;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

/**
 * Created by amitkumar on 20/06/2024.
 */

public class LocationTracker extends Service implements com.google.android.gms.location.LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "LocationTracker";
    private static final long INTERVAL = 1000 * 10;
    private static final long FASTEST_INTERVAL = 1000 * 5;

    private static final long ONE_MIN = 1000 * 60;
    private static final long TWO_MIN = ONE_MIN * 2;
    private static final long FIVE_MIN = ONE_MIN * 5;
    private static final long POLLING_FREQ = 1000 * 30;
    private static final long FASTEST_UPDATE_FREQ = 1000 * 5;
    private static final float MIN_ACCURACY = 25.0f;
    private static final float MIN_LAST_READ_ACCURACY = 500.0f;
    private static final int REQUEST_CHECK_SETTINGS = 0102;
    private Context context;
    private double latitude;
    private double longitude;
    private long time;

    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mCurrentLocation;
    String mLastUpdateTime;
    private MarkerOptions markerOptions;
    private Task<LocationSettingsResponse> result;
    private boolean canGetLocation = false;
    private Activity activity;
    private Dialog dialog;
    private AlertDialog locationDialog;

    public LocationTracker(Context context) {
        this(context, 0L, 0L);
    }

    public LocationTracker(Context context, long minTime, long minDistance) {
        this.context = context;
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        if (mGoogleApiClient != null) {
            mGoogleApiClient.connect();
        }
        markerOptions = new MarkerOptions();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (servicesAvailable()) {
            getLastLocation();
            canGetLocation = true;
            requestLocationUpdates();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public boolean servicesAvailable() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (ConnectionResult.SUCCESS == resultCode) {
            return true;
        } else {
            return false;
        }
    }


    public void requestLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        getFusedLocationProviderClient(context).requestLocationUpdates(mLocationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        onLocationChanged(locationResult.getLastLocation());
                    }
                },
                Looper.myLooper());
    }


    private OnSuccessListener<Location> onSuccessListener = new OnSuccessListener<Location>() {
        @Override
        public void onSuccess(Location location) {
            if (location != null) {
                canGetLocation = true;
                mCurrentLocation = location;
                Log.e("loca", location.toString());
            }
        }
    };

    public void onLocationChanged(Location location) {
        if (location == null) {
            return;
        }

        mCurrentLocation = location;
        canGetLocation = true;

    }

    public double getLatitude() {
        if (mCurrentLocation != null) {
            latitude = mCurrentLocation.getLatitude();
        }
        return latitude;
    }

    public double getLongitude() {
        if (mCurrentLocation != null) {
            longitude = mCurrentLocation.getLongitude();
        }
        return longitude;
    }

    public Date getTime() {
        if (mCurrentLocation != null) {
            time = mCurrentLocation.getTime();
        }
        return new Date();
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("GPS is settings");
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        context.startActivity(intent);
                    }
                });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
     locationDialog =   alertDialog.create();
        alertDialog.show();
    }
    public void hideDialog(){
        if(locationDialog != null && locationDialog.isShowing()){
            locationDialog.dismiss();
        }
    }

    public boolean canGetLocation() {
        Log.w("LOC", canGetLocation +"");
        return this.canGetLocation;
    }

    public Location getLocation() {
        return mCurrentLocation;
    }

    private OnCompleteListener<LocationSettingsResponse> locationSettingsResponseOnCompleteListener = new OnCompleteListener<LocationSettingsResponse>() {
        @Override
        public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
            try {
                LocationSettingsResponse response = task.getResult(ApiException.class);
                canGetLocation = true;
                getLastLocation();
                requestLocationUpdates();

            } catch (ApiException exception) {
                switch (exception.getStatusCode()) {
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        Toast.makeText(context, "Location is not Enabled", Toast.LENGTH_LONG).show();
                        canGetLocation = false;
                        // showSettingDialog();
                        // Location settings are not satisfied. But could be fixed by showing the
                        // user a dialog.
                        try {
                            // Cast to a resolvable exception.
                            ResolvableApiException resolvable = (ResolvableApiException) exception;
                        } catch (ClassCastException e) {
                            // Ignore, should be an impossible error.
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        canGetLocation = false;
                        Toast.makeText(context, "Location settings are not satisfied. However, we have no way to fix the", Toast.LENGTH_LONG).show();
                        // Location settings are not satisfied. However, we have no way to fix the
                        // settings so we won't show the dialog.

                        break;
                    case LocationSettingsStatusCodes.SUCCESS:
                        Toast.makeText(context, "Location Enabled", Toast.LENGTH_LONG).show();
                        break;

                }
            }
        }
    };

    @SuppressLint("RestrictedApi")
    public void getLastLocation() {
        if (servicesAvailable()) {
            mLocationRequest = new LocationRequest();
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            mLocationRequest.setInterval(INTERVAL);
            mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
            lastLocation.addOnSuccessListener(onSuccessListener);
        }
    }

    public void showSettingDialog() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);//Setting priotity of Location request to high
        locationRequest.setInterval(30 * 1000);
        locationRequest.setFastestInterval(5 * 1000);//5 sec Time interval for location update
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
         //builder.setAlwaysShow(true); //this is the key ingredient to show dialog always when GPS is off
         result = LocationServices.getSettingsClient(context).checkLocationSettings(builder.build());
         result.addOnCompleteListener(locationSettingsResponseOnCompleteListener);


    }
    public void setMarkerTitle(String title){
        markerOptions.title(title);
    }



}
