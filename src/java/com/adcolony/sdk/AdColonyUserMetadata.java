/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.location.Location;
import com.adcolony.sdk.au;
import com.adcolony.sdk.w;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColonyUserMetadata {
    JSONArray b = w.b();
    JSONObject c = w.a();
    Location d;

    public AdColonyUserMetadata setMetadata(String string, double d2) {
        if (au.d(string)) {
            w.a(this.c, string, d2);
        }
        return this;
    }

    public AdColonyUserMetadata setMetadata(String string, String string2) {
        if (au.d(string2) && au.d(string)) {
            w.a(this.c, string, string2);
        }
        return this;
    }

    public AdColonyUserMetadata setUserAge(int n2) {
        this.setMetadata("adc_age", n2);
        return this;
    }

    public AdColonyUserMetadata setUserGender(String string) {
        if (au.d(string)) {
            this.setMetadata("adc_gender", string);
        }
        return this;
    }

    public AdColonyUserMetadata setUserLocation(Location location) {
        this.d = location;
        this.setMetadata("adc_longitude", location.getLongitude());
        this.setMetadata("adc_latitude", location.getLatitude());
        this.setMetadata("adc_speed", location.getSpeed());
        this.setMetadata("adc_altitude", location.getAltitude());
        this.setMetadata("adc_time", location.getTime());
        this.setMetadata("adc_accuracy", location.getAccuracy());
        return this;
    }

    public AdColonyUserMetadata setUserMaritalStatus(String string) {
        if (au.d(string)) {
            this.setMetadata("adc_marital_status", string);
        }
        return this;
    }
}

