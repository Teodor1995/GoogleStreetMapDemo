package com.demo.googlestreetmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.libraries.maps.SupportStreetViewPanoramaFragment
import com.google.android.libraries.maps.model.LatLng

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val streetViewPanoramaFragment =
            supportFragmentManager.findFragmentById(R.id.streetViewPanoramaFragment) as SupportStreetViewPanoramaFragment?

        streetViewPanoramaFragment?.getStreetViewPanoramaAsync { panorama ->
            // Only set the panorama to SYDNEY on startup (when no panoramas have been
            // loaded which is when the savedInstanceState is null).
            savedInstanceState ?: panorama.setPosition(SYDNEY)
        }
    }

    companion object {
        // George St, Sydney
        private val SYDNEY = LatLng(-33.87365, 151.20689)
    }
}