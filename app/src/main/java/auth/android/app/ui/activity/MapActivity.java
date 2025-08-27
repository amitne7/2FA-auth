package auth.android.app.ui.activity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import event.msvc.android.R;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    @BindView(R.id.sv_location)
    SearchView searchView;

    @BindView(R.id.btn_select_location)
    Button btnSelectLocation;

    private GoogleMap mMap;
    private Marker marker;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        // Obtain the SupportMapFragment and get notified
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        // adding on query listener for our search view.
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // on below line we are getting the
                // location name from search view.
                String location = searchView.getQuery().toString();

                // below line is to create a list of address
                // where we will store the list of all address.
                List<Address> addressList = null;

                // checking if the entered location is null or not.
                if (location != null || location.equals("")) {
                    // on below line we are creating and initializing a geo coder.
                    Geocoder geocoder = new Geocoder(MapActivity.this);
                    try {
                        // on below line we are getting location from the
                        // location name and adding that location to address list.
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // on below line we are getting the location
                    // from our list a first position.
                    Address address = addressList.get(0);

                    // on below line we are creating a variable for our location
                    // where we will add our locations latitude and longitude.
                     latLng = new LatLng(address.getLatitude(), address.getLongitude());

                    // on below line we are adding marker to that position.
                    marker = mMap.addMarker(new MarkerOptions().position(latLng).title(location));

                    // below line is to animate camera to that position.
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        // at last we calling our map fragment to update.
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(25), 1000, null);
        googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                latLng = googleMap.getCameraPosition().target;
                if (null != marker) {
                    marker.setPosition(latLng);
                    Log.e("LL", "" + latLng.toString());
                }
            }
        });
    }

    @OnClick(R.id.btn_select_location)
    void onClickLocationBtn() {
        Intent intent=new Intent();
        intent.putExtra("lat",String.valueOf(latLng.latitude));
        intent.putExtra("lng",String.valueOf(latLng.longitude));
        setResult(RESULT_OK,intent);
        finish();
    }
}