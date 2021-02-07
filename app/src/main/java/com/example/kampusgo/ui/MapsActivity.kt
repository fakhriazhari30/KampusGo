package com.example.kampusgo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kampusgo.R
import com.example.kampusgo.model.Kampus

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kampus.myapplication.R
import com.kampus.myapplication.model.Kampus

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object {
        const val EXTRA_KAMPUS = "extra_kampus"
    }

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val intent = intent.extras?.getParcelable<Kampus>(EXTRA_KAMPUS)
        val lat = intent?.latitude?.toDouble()
        val lng = intent?.longitude?.toDouble()

        // Add a marker in Sydney and move the camera
        val kampus = LatLng(lat ?: 0.0, lng ?: 0.0)
        mMap.addMarker(MarkerOptions().position(kampus).title("${intent?.nama_kampus}"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kampus))
    }
}