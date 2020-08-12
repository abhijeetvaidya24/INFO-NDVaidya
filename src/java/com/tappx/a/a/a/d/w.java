/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationManager
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.System
 *  java.text.SimpleDateFormat
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.tappx.a.a.a.j.c;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class w {
    public final String a;
    public final a b;

    public w(String string2, a a2) {
        this.a = string2;
        this.b = a2;
    }

    public static class a {
        public final double a;
        public final double b;
        public final long c;
        public final long d;

        public a(double d2, double d3, long l2, long l3) {
            this.a = d2;
            this.b = d3;
            this.c = l2;
            this.d = l3;
        }
    }

    public static class b {
        private static volatile b a;
        private final Context b;

        public b(Context context) {
            this.b = context;
        }

        private Location a(Location location, Location location2) {
            if (location == null) {
                return location2;
            }
            if (location2 == null) {
                return location;
            }
            if (location.getTime() > location2.getTime()) {
                return location;
            }
            return location2;
        }

        private Location a(String string2) {
            void var3_6;
            LocationManager locationManager = (LocationManager)this.b.getSystemService("location");
            try {
                Location location = locationManager.getLastKnownLocation(string2);
                return location;
            }
            catch (IllegalArgumentException illegalArgumentException) {
            }
            catch (SecurityException securityException) {
                // empty catch block
            }
            var3_6.printStackTrace();
            return null;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static final b a(Context context) {
            if (a != null) return a;
            Class<b> class_ = b.class;
            synchronized (b.class) {
                if (a != null) return a;
                a = new b(context);
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return a;
            }
        }

        private String b() {
            Date date = Calendar.getInstance((TimeZone)TimeZone.getTimeZone((String)"GMT"), (Locale)Locale.getDefault()).getTime();
            return new SimpleDateFormat("Z", Locale.US).format(date);
        }

        private a c() {
            Location location = this.d();
            if (location == null) {
                return null;
            }
            double d2 = location.getLatitude();
            double d3 = location.getLongitude();
            long l2 = (long)location.getAccuracy();
            long l3 = System.currentTimeMillis() - location.getTime();
            a a2 = new a(d2, d3, l2, l3);
            return a2;
        }

        private Location d() {
            return this.a(this.f(), this.e());
        }

        private Location e() {
            if (!c.a(this.b, "android.permission.ACCESS_FINE_LOCATION")) {
                return null;
            }
            return this.a("gps");
        }

        private Location f() {
            boolean bl2 = c.a(this.b, "android.permission.ACCESS_FINE_LOCATION") || c.a(this.b, "android.permission.ACCESS_COARSE_LOCATION");
            if (!bl2) {
                return null;
            }
            return this.a("network");
        }

        public w a() {
            return new w(this.b(), this.c());
        }
    }

}

