package com.example.cutte.handimapsinternshipproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    /**
        I first tried to put a Google Maps fragment into an empty activity and kept getting errors, even when following the official Android documentation and its examples,
        I then tried to do it with the default Google Maps activity page and got it to work. If I had more time I would go back and try again to build the Maps Activity from scratch
     */


    private GoogleMap mMap;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Get text from parent and display it (Did this to refresh on how to get a message from an intent)
        TextView textView = findViewById(R.id.textView);
        intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.append(message);
    }



    /**
     --------------------------------------------------
     This function is the one I mostly messed with
     --------------------------------------------------
     */
    //This is automatically called when the Map Fragment is being created
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker to Lwtech and move the camera
        LatLng lwtech = new LatLng(47.704901, -122.167167);
        mMap.addMarker(new MarkerOptions().position(lwtech).title("Where I currently go to School"));

        //Move Maps camera to lwtech
        CameraPosition cameraPosition = new CameraPosition.Builder().target(lwtech).zoom(17).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        //set Camera Zoom boundary
        mMap.setMinZoomPreference(10.0f);

        //set panning boundary
        LatLngBounds schoolArea = new LatLngBounds(new LatLng(47.689336, -122.175567), new LatLng(47.711056, -122.154376));
        mMap.setLatLngBoundsForCameraTarget(schoolArea);

    }

    //Testing Intents and coming back from an activity
    public void goBack(View v)
    {
        intent.putExtra(MainActivity.EXTRA_MESSAGE,"Hello From the other Side");
        setResult(RESULT_OK, intent);
        finish();
    }
}
