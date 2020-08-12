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
 *  com.moat.analytics.mobile.ogury.e
 *  com.moat.analytics.mobile.ogury.i
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
package com.moat.analytics.mobile.ogury;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.moat.analytics.mobile.ogury.MoatAnalytics;
import com.moat.analytics.mobile.ogury.a;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.i;
import com.moat.analytics.mobile.ogury.l;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class m
implements LocationListener {
    private static m \u02ca;
    private boolean \u02bb;
    private Location \u02bd;
    private ScheduledFuture<?> \u02cb;
    private ScheduledFuture<?> \u02ce;
    private ScheduledExecutorService \u02cf;
    private LocationManager \u0971;
    private boolean \u0971\u0971;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private m() {
        try {
            boolean bl2 = this.\u02bb = ((i)MoatAnalytics.getInstance()).\u02cb;
            if (bl2) {
                e.1.\u02cb(3, "LocationManager", this, "Moat location services disabled");
                return;
            }
            this.\u02cf = Executors.newScheduledThreadPool((int)1);
            this.\u0971 = (LocationManager)a.\u02cf().getSystemService("location");
            if (this.\u0971.getAllProviders().size() == 0) {
                e.1.\u02cb(3, "LocationManager", this, "Device has no location providers");
                return;
            }
            this.\u0971();
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
    }

    private void \u02bb() {
        ScheduledFuture<?> scheduledFuture = this.\u02cb;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.\u02cb.cancel(true);
            this.\u02cb = null;
        }
    }

    private void \u02bc() {
        ScheduledFuture<?> scheduledFuture = this.\u02ce;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.\u02ce.cancel(true);
            this.\u02ce = null;
        }
    }

    private void \u02bd() {
        try {
            if (!this.\u0971\u0971) {
                e.1.\u02cb(3, "LocationManager", this, "Attempting to start update");
                if (this.\u02cb\u0971()) {
                    e.1.\u02cb(3, "LocationManager", this, "start updating gps location");
                    this.\u0971.requestLocationUpdates("gps", 0L, 0.0f, (LocationListener)this, Looper.getMainLooper());
                    this.\u0971\u0971 = true;
                }
                if (this.\u02cf\u0971()) {
                    e.1.\u02cb(3, "LocationManager", this, "start updating network location");
                    this.\u0971.requestLocationUpdates("network", 0L, 0.0f, (LocationListener)this, Looper.getMainLooper());
                    this.\u0971\u0971 = true;
                }
                if (this.\u0971\u0971) {
                    this.\u02bc();
                    this.\u02ce = this.\u02cf.schedule(new Runnable(this){
                        private /* synthetic */ m \u02cf;
                        {
                            this.\u02cf = m2;
                        }

                        public final void run() {
                            try {
                                e.1.\u02cb(3, "LocationManager", this, "fetchTimedOut");
                                this.\u02cf.\u0971(true);
                                return;
                            }
                            catch (Exception exception) {
                                l.\u0971(exception);
                                return;
                            }
                        }
                    }, 60L, TimeUnit.SECONDS);
                }
            }
            return;
        }
        catch (SecurityException securityException) {
            l.\u0971((Exception)((Object)securityException));
            return;
        }
    }

    private void \u02ca\u0971() {
        e.1.\u02cb(3, "LocationManager", this, "Resetting fetch timer");
        this.\u02bb();
        Location location = this.\u02bd;
        float f2 = 600.0f;
        if (location != null) {
            f2 = Math.max((float)(f2 - (float)((System.currentTimeMillis() - location.getTime()) / 1000L)), (float)0.0f);
        }
        long l2 = (long)f2;
        this.\u02cb = this.\u02cf.schedule(new Runnable(this){
            private /* synthetic */ m \u02cb;
            {
                this.\u02cb = m2;
            }

            public final void run() {
                try {
                    e.1.\u02cb(3, "LocationManager", this, "fetchTimerCompleted");
                    this.\u02cb.\u0971();
                    return;
                }
                catch (Exception exception) {
                    l.\u0971(exception);
                    return;
                }
            }
        }, l2, TimeUnit.SECONDS);
    }

    private static boolean \u02cb(Location location) {
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

    private boolean \u02cb\u0971() {
        boolean bl2 = ContextCompat.checkSelfPermission((Context)a.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION") == 0;
        return bl2 && this.\u0971.getProvider("gps") != null && this.\u0971.isProviderEnabled("gps");
    }

    private static Location \u02ce(Location location, Location location2) {
        boolean bl2 = m.\u02cb(location);
        boolean bl3 = m.\u02cb(location2);
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

    static m \u02ce() {
        if (\u02ca == null) {
            \u02ca = new m();
        }
        return \u02ca;
    }

    private boolean \u02cf\u0971() {
        boolean bl2;
        boolean bl3 = ContextCompat.checkSelfPermission((Context)a.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION") == 0;
        boolean bl4 = bl3 || (bl2 = ContextCompat.checkSelfPermission((Context)a.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_COARSE_LOCATION") == 0);
        return bl4 && this.\u0971.getProvider("network") != null && this.\u0971.isProviderEnabled("network");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0971() {
        try {
            if (!this.\u02bb) {
                if (this.\u0971 == null) {
                    return;
                }
                boolean bl2 = this.\u0971\u0971;
                if (bl2) {
                    e.1.\u02cb(3, "LocationManager", this, "already updating location");
                }
                e.1.\u02cb(3, "LocationManager", this, "starting location fetch");
                this.\u02bd = m.\u02ce(this.\u02bd, this.\u0971\u0971());
                if (this.\u02bd != null) {
                    StringBuilder stringBuilder = new StringBuilder("Have a valid location, won't fetch = ");
                    stringBuilder.append(this.\u02bd.toString());
                    e.1.\u02cb(3, "LocationManager", this, stringBuilder.toString());
                    this.\u02ca\u0971();
                    return;
                }
                this.\u02bd();
            }
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0971(boolean bl2) {
        try {
            e.1.\u02cb(3, "LocationManager", this, "stopping location fetch");
            this.\u141d();
            this.\u02bc();
            if (bl2) {
                this.\u02ca\u0971();
                return;
            }
            this.\u02bb();
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
    }

    static boolean \u0971(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return location != null && location2 != null && location.getTime() == location2.getTime();
    }

    private Location \u0971\u0971() {
        boolean bl2;
        boolean bl3;
        block7 : {
            bl2 = this.\u02cb\u0971();
            bl3 = this.\u02cf\u0971();
            if (!bl2 || !bl3) break block7;
            try {
                return m.\u02ce(this.\u0971.getLastKnownLocation("gps"), this.\u0971.getLastKnownLocation("network"));
            }
            catch (SecurityException securityException) {
                l.\u0971((Exception)((Object)securityException));
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u141d() {
        boolean bl2;
        block2 : {
            boolean bl3;
            try {
                e.1.\u02cb(3, "LocationManager", this, "Stopping to update location");
                int n2 = ContextCompat.checkSelfPermission((Context)a.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION");
                bl2 = true;
                boolean bl4 = n2 == 0;
                if (bl4) break block2;
                if (ContextCompat.checkSelfPermission((Context)a.\u02cf().getApplicationContext(), (String)"android.permission.ACCESS_COARSE_LOCATION") != 0) return;
                bl3 = true;
            }
            catch (SecurityException securityException) {
                l.\u0971((Exception)((Object)securityException));
                return;
            }
            if (!bl3) return;
        }
        if (!bl2) return;
        if (this.\u0971 == null) return;
        this.\u0971.removeUpdates((LocationListener)this);
        this.\u0971\u0971 = false;
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
            e.1.\u02cb(3, "LocationManager", this, stringBuilder.toString());
            f2 = (System.currentTimeMillis() - location.getTime()) / 1000L;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
        if (!location.hasAccuracy() || !(location.getAccuracy() <= 100.0f) || !(f2 < 600.0f)) return;
        this.\u02bd = m.\u02ce(this.\u02bd, location);
        e.1.\u02cb(3, "LocationManager", this, "fetchCompleted");
        this.\u0971(true);
    }

    public final void onProviderDisabled(String string2) {
    }

    public final void onProviderEnabled(String string2) {
    }

    public final void onStatusChanged(String string2, int n2, Bundle bundle) {
    }

    final void \u02ca() {
        this.\u0971();
    }

    final void \u02cb() {
        this.\u0971(false);
    }

    final Location \u02cf() {
        if (!this.\u02bb && this.\u0971 != null) {
            return this.\u02bd;
        }
        return null;
    }

}

