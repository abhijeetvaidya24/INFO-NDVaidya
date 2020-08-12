/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.location.LocationProvider
 *  android.os.Bundle
 *  android.os.Looper
 *  androidx.core.content.ContextCompat
 *  com.moat.analytics.mobile.cha.f
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.List
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package com.moat.analytics.mobile.cha;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.moat.analytics.mobile.cha.MoatAnalytics;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.c;
import com.moat.analytics.mobile.cha.f;
import com.moat.analytics.mobile.cha.o;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class n
implements LocationListener {
    private static n \u02ce;
    private Location \u02bb;
    private ScheduledExecutorService \u02ca;
    private boolean \u02ca\u0971;
    private ScheduledFuture<?> \u02cb;
    private ScheduledFuture<?> \u02cf;
    private LocationManager \u0971;
    private boolean \u141d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private n() {
        try {
            boolean bl2 = this.\u02ca\u0971 = ((f)MoatAnalytics.getInstance()).\u02cb;
            if (bl2) {
                a.\u02cf(3, "LocationManager", this, "Moat location services disabled");
                return;
            }
            this.\u02ca = Executors.newScheduledThreadPool((int)1);
            this.\u0971 = (LocationManager)c.\u02cf().getSystemService("location");
            if (this.\u0971.getAllProviders().size() == 0) {
                a.\u02cf(3, "LocationManager", this, "Device has no location providers");
                return;
            }
            this.\u02ce();
            return;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return;
        }
    }

    private void \u02bb() {
        try {
            if (!this.\u141d) {
                a.\u02cf(3, "LocationManager", this, "Attempting to start update");
                if (this.\u037a()) {
                    a.\u02cf(3, "LocationManager", this, "start updating gps location");
                    this.\u0971.requestLocationUpdates("gps", 0L, 0.0f, (LocationListener)this, Looper.getMainLooper());
                    this.\u141d = true;
                }
                if (this.\u0971\u02ca()) {
                    a.\u02cf(3, "LocationManager", this, "start updating network location");
                    this.\u0971.requestLocationUpdates("network", 0L, 0.0f, (LocationListener)this, Looper.getMainLooper());
                    this.\u141d = true;
                }
                if (this.\u141d) {
                    this.\u02ca\u0971();
                    this.\u02cf = this.\u02ca.schedule(new Runnable(this){
                        private /* synthetic */ n \u02cf;
                        {
                            this.\u02cf = n2;
                        }

                        public final void run() {
                            try {
                                a.\u02cf(3, "LocationManager", this, "fetchTimedOut");
                                this.\u02cf.\u0971(true);
                                return;
                            }
                            catch (Exception exception) {
                                o.\u02ce(exception);
                                return;
                            }
                        }
                    }, 60L, TimeUnit.SECONDS);
                }
            }
            return;
        }
        catch (SecurityException securityException) {
            o.\u02ce((Exception)((Object)securityException));
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u02bc() {
        boolean bl2;
        block2 : {
            boolean bl3;
            try {
                a.\u02cf(3, "LocationManager", this, "Stopping to update location");
                int n2 = ContextCompat.checkSelfPermission((Context)c.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION");
                bl2 = true;
                boolean bl4 = n2 == 0;
                if (bl4) break block2;
                if (ContextCompat.checkSelfPermission((Context)c.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_COARSE_LOCATION") != 0) return;
                bl3 = true;
            }
            catch (SecurityException securityException) {
                o.\u02ce((Exception)((Object)securityException));
                return;
            }
            if (!bl3) return;
        }
        if (!bl2) return;
        if (this.\u0971 == null) return;
        this.\u0971.removeUpdates((LocationListener)this);
        this.\u141d = false;
    }

    private Location \u02bd() {
        boolean bl2;
        boolean bl3;
        block7 : {
            bl2 = this.\u037a();
            bl3 = this.\u0971\u02ca();
            if (!bl2 || !bl3) break block7;
            try {
                return n.\u0971(this.\u0971.getLastKnownLocation("gps"), this.\u0971.getLastKnownLocation("network"));
            }
            catch (SecurityException securityException) {
                o.\u02ce((Exception)((Object)securityException));
            }
        }
        if (bl2) {
            return this.\u0971.getLastKnownLocation("gps");
        }
        if (bl3) {
            Location location = this.\u0971.getLastKnownLocation("network");
            return location;
        }
        return null;
    }

    private void \u02ca\u0971() {
        ScheduledFuture<?> scheduledFuture = this.\u02cf;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.\u02cf.cancel(true);
            this.\u02cf = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u02ce() {
        try {
            if (!this.\u02ca\u0971) {
                if (this.\u0971 == null) {
                    return;
                }
                boolean bl2 = this.\u141d;
                if (bl2) {
                    a.\u02cf(3, "LocationManager", this, "already updating location");
                }
                a.\u02cf(3, "LocationManager", this, "starting location fetch");
                this.\u02bb = n.\u0971(this.\u02bb, this.\u02bd());
                if (this.\u02bb != null) {
                    StringBuilder stringBuilder = new StringBuilder("Have a valid location, won't fetch = ");
                    stringBuilder.append(this.\u02bb.toString());
                    a.\u02cf(3, "LocationManager", this, stringBuilder.toString());
                    this.\u02cf\u0971();
                    return;
                }
                this.\u02bb();
            }
            return;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return;
        }
    }

    static boolean \u02ce(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return location != null && location2 != null && location.getTime() == location2.getTime();
    }

    static n \u02cf() {
        if (\u02ce == null) {
            \u02ce = new n();
        }
        return \u02ce;
    }

    private void \u02cf\u0971() {
        a.\u02cf(3, "LocationManager", this, "Resetting fetch timer");
        this.\u141d();
        Location location = this.\u02bb;
        float f2 = 600.0f;
        if (location != null) {
            f2 = Math.max((float)(f2 - (float)((System.currentTimeMillis() - location.getTime()) / 1000L)), (float)0.0f);
        }
        long l2 = (long)f2;
        this.\u02cb = this.\u02ca.schedule(new Runnable(this){
            private /* synthetic */ n \u02cb;
            {
                this.\u02cb = n2;
            }

            public final void run() {
                try {
                    a.\u02cf(3, "LocationManager", this, "fetchTimerCompleted");
                    this.\u02cb.\u02ce();
                    return;
                }
                catch (Exception exception) {
                    o.\u02ce(exception);
                    return;
                }
            }
        }, l2, TimeUnit.SECONDS);
    }

    private boolean \u037a() {
        boolean bl2 = ContextCompat.checkSelfPermission((Context)c.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION") == 0;
        return bl2 && this.\u0971.getProvider("gps") != null && this.\u0971.isProviderEnabled("gps");
    }

    private static Location \u0971(Location location, Location location2) {
        boolean bl2 = n.\u0971(location);
        boolean bl3 = n.\u0971(location2);
        if (!bl2) {
            if (!bl3) {
                return null;
            }
            return location2;
        }
        if (!bl3) {
            return location;
        }
        if (location.getAccuracy() < location.getAccuracy()) {
            return location;
        }
        return location2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0971(boolean bl2) {
        try {
            a.\u02cf(3, "LocationManager", this, "stopping location fetch");
            this.\u02bc();
            this.\u02ca\u0971();
            if (bl2) {
                this.\u02cf\u0971();
                return;
            }
            this.\u141d();
            return;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return;
        }
    }

    private static boolean \u0971(Location location) {
        if (location == null) {
            return false;
        }
        if (location.getLatitude() == 0.0 && location.getLongitude() == 0.0) {
            return false;
        }
        if (location.getAccuracy() < 0.0f) {
            return false;
        }
        return !((float)((System.currentTimeMillis() - location.getTime()) / 1000L) >= 600.0f);
    }

    private boolean \u0971\u02ca() {
        boolean bl2;
        boolean bl3 = ContextCompat.checkSelfPermission((Context)c.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION") == 0;
        boolean bl4 = bl3 || (bl2 = ContextCompat.checkSelfPermission((Context)c.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_COARSE_LOCATION") == 0);
        return bl4 && this.\u0971.getProvider("network") != null && this.\u0971.isProviderEnabled("network");
    }

    private void \u141d() {
        ScheduledFuture<?> scheduledFuture = this.\u02cb;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.\u02cb.cancel(true);
            this.\u02cb = null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void onLocationChanged(Location location) {
        float f2;
        try {
            StringBuilder stringBuilder = new StringBuilder("Received an updated location = ");
            stringBuilder.append(location.toString());
            a.\u02cf(3, "LocationManager", this, stringBuilder.toString());
            f2 = (System.currentTimeMillis() - location.getTime()) / 1000L;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return;
        }
        if (!location.hasAccuracy() || !(location.getAccuracy() <= 100.0f) || !(f2 < 600.0f)) return;
        this.\u02bb = n.\u0971(this.\u02bb, location);
        a.\u02cf(3, "LocationManager", this, "fetchCompleted");
        this.\u0971(true);
    }

    public final void onProviderDisabled(String string) {
    }

    public final void onProviderEnabled(String string) {
    }

    public final void onStatusChanged(String string, int n2, Bundle bundle) {
    }

    final Location \u02ca() {
        if (!this.\u02ca\u0971 && this.\u0971 != null) {
            return this.\u02bb;
        }
        return null;
    }

    final void \u02cb() {
        this.\u02ce();
    }

    final void \u0971() {
        this.\u0971(false);
    }

}

