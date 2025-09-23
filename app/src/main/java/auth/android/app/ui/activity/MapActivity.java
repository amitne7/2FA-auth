package auth.android.app.ui.activity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.SearchView;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import auth.android.app.R;


public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    SearchView searchView;

    Button btnSelectLocation;
    private GoogleMap mMap;
    private Marker marker;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initViews();
        // Obtain the SupportMapFragment and get notified
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        // adding on listener for our search.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                String location = searchView.getQuery().toString();

                List<Address> addressList = null;


                if (location != null || !location.isEmpty()) {

                    Geocoder geocoder = new Geocoder(MapActivity.this);
                    try {
                        // getting location from the
                        // location name and adding that location to address list.
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(null != addressList && !addressList.isEmpty()) {
                        // getting the location
                        // from our list a first position.
                        Address address = addressList.get(0);

                        // creating a variable for location

                        latLng = new LatLng(address.getLatitude(), address.getLongitude());

                        // adding marker to that position.
                        marker = mMap.addMarker(new MarkerOptions().position(latLng).title(location));

                        // animate camera to that position.
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        // call map fragment to update.
        mapFragment.getMapAsync(this);
    }

    private void initViews() {
        searchView = findViewById(R.id.sv_location);
        btnSelectLocation = findViewById(R.id.btn_select_location);
        btnSelectLocation.setOnClickListener(view -> onClickLocationBtn());
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(8), 1000, null);
        googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                latLng = googleMap.getCameraPosition().target;
                if (null != marker) {
                    marker.setPosition(latLng);

                }
            }
        });
    }

    private void onClickLocationBtn() {
        Intent intent=new Intent();
        intent.putExtra("lat",String.valueOf(latLng.latitude));
        intent.putExtra("lng",String.valueOf(latLng.longitude));
        setResult(RESULT_OK,intent);
        finish();
    }
}