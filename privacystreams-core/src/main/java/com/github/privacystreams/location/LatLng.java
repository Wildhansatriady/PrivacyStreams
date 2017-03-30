package com.github.privacystreams.location;

import java.util.Locale;

/**
 * Location latitude and longitude.
 */

public class LatLng {
    private double latitude;
    private double longitude;

    public LatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String toString() {
        return String.format(Locale.getDefault(),
                "<Latitude:%f,Longitude:%f>", latitude, longitude);
    }
}