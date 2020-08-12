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
 *  com.moat.analytics.mobile.iro.j
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
package com.moat.analytics.mobile.iro;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.moat.analytics.mobile.iro.MoatAnalytics;
import com.moat.analytics.mobile.iro.a;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.j;
import com.moat.analytics.mobile.iro.o;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class k
implements LocationListener {
    private static k \u02cf;
    private boolean \u02bc;
    private Location \u02bd;
    private ScheduledFuture<?> \u02ca;
    private ScheduledFuture<?> \u02cb;
    private LocationManager \u02ce;
    private ScheduledExecutorService \u0971;
    private boolean \u141d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private k() {
        try {
            boolean bl2 = this.\u141d = ((j)MoatAnalytics.getInstance()).\u02cf;
            if (bl2) {
                b.\u02cf(3, "LocationManager", this, "Moat location services disabled");
                return;
            }
            this.\u0971 = Executors.newScheduledThreadPool((int)1);
            this.\u02ce = (LocationManager)a.\u02ce().getSystemService("location");
            if (this.\u02ce.getAllProviders().size() == 0) {
                b.\u02cf(3, "LocationManager", this, "Device has no location providers");
                return;
            }
            this.\u02cf();
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
    }

    private Location \u02bb() {
        boolean bl2;
        boolean bl3;
        block7 : {
            bl2 = this.\u02cb\u0971();
            bl3 = this.\u0971\u02cb();
            if (!bl2 || !bl3) break block7;
            try {
                return k.\u02ca(this.\u02ce.getLastKnownLocation("gps"), this.\u02ce.getLastKnownLocation("network"));
            }
            catch (SecurityException securityException) {
                o.\u0971((Exception)((Object)securityException));
            }
        }
        if (bl2) {
            return this.\u02ce.getLastKnownLocation("gps");
        }
        if (bl3) {
            Location location = this.\u02ce.getLastKnownLocation("network");
            return location;
        }
        return null;
    }

    private void \u02bc() {
        ScheduledFuture<?> scheduledFuture = this.\u02ca;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.\u02ca.cancel(true);
            this.\u02ca = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u02bd() {
        boolean bl2;
        block2 : {
            boolean bl3;
            try {
                b.\u02cf(3, "LocationManager", this, "Stopping to update location");
                int n2 = ContextCompat.checkSelfPermission((Context)a.\u02ce().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION");
                bl2 = true;
                boolean bl4 = n2 == 0;
                if (bl4) break block2;
                if (ContextCompat.checkSelfPermission((Context)a.\u02ce().getApplicationContext(), (String)"android.permission.ACCESS_COARSE_LOCATION") != 0) return;
                bl3 = true;
            }
            catch (SecurityException securityException) {
                o.\u0971((Exception)((Object)securityException));
                return;
            }
            if (!bl3) return;
        }
        if (!bl2) return;
        if (this.\u02ce == null) return;
        this.\u02ce.removeUpdates((LocationListener)this);
        this.\u02bc = false;
    }

    private static Location \u02ca(Location location, Location location2) {
        boolean bl2 = k.\u02cb(location);
        boolean bl3 = k.\u02cb(location2);
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

    private void \u02ca\u0971() {
        ScheduledFuture<?> scheduledFuture = this.\u02cb;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.\u02cb.cancel(true);
            this.\u02cb = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u02cb(boolean bl2) {
        try {
            b.\u02cf(3, "LocationManager", this, "stopping location fetch");
            this.\u02bd();
            this.\u02ca\u0971();
            if (bl2) {
                this.\u02cf\u0971();
                return;
            }
            this.\u02bc();
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
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
        boolean bl2 = ContextCompat.checkSelfPermission((Context)a.\u02ce().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION") == 0;
        return bl2 && this.\u02ce.getProvider("gps") != null && this.\u02ce.isProviderEnabled("gps");
    }

    static k \u02ce() {
        if (\u02cf == null) {
            \u02cf = new k();
        }
        return \u02cf;
    }

    static boolean \u02ce(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return location != null && location2 != null && location.getTime() == location2.getTime();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u02cf() {
        try {
            if (!this.\u141d) {
                if (this.\u02ce == null) {
                    return;
                }
                boolean bl2 = this.\u02bc;
                if (bl2) {
                    b.\u02cf(3, "LocationManager", this, "already updating location");
                }
                b.\u02cf(3, "LocationManager", this, "starting location fetch");
                this.\u02bd = k.\u02ca(this.\u02bd, this.\u02bb());
                if (this.\u02bd != null) {
                    StringBuilder stringBuilder = new StringBuilder("Have a valid location, won't fetch = ");
                    stringBuilder.append(this.\u02bd.toString());
                    b.\u02cf(3, "LocationManager", this, stringBuilder.toString());
                    this.\u02cf\u0971();
                    return;
                }
                this.\u141d();
            }
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
    }

    private void \u02cf\u0971() {
        b.\u02cf(3, "LocationManager", this, "Resetting fetch timer");
        this.\u02bc();
        Location location = this.\u02bd;
        float f2 = 600.0f;
        if (location != null) {
            f2 = Math.max((float)(f2 - (float)((System.currentTimeMillis() - location.getTime()) / 1000L)), (float)0.0f);
        }
        long l2 = (long)f2;
        this.\u02ca = this.\u0971.schedule(new Runnable(this){
            private /* synthetic */ k \u02cb;
            {
                this.\u02cb = k2;
            }

            public final void run() {
                try {
                    b.\u02cf(3, "LocationManager", this, "fetchTimerCompleted");
                    this.\u02cb.\u02cf();
                    return;
                }
                catch (Exception exception) {
                    o.\u0971(exception);
                    return;
                }
            }
        }, l2, TimeUnit.SECONDS);
    }

    private boolean \u0971\u02cb() {
        boolean bl2;
        boolean bl3 = ContextCompat.checkSelfPermission((Context)a.\u02ce().getApplicationContext(), (String)"android.permission.ACCESS_FINE_LOCATION") == 0;
        boolean bl4 = bl3 || (bl2 = ContextCompat.checkSelfPermission((Context)a.\u02ce().getApplicationContext(), (String)"android.permission.ACCESS_COARSE_LOCATION") == 0);
        return bl4 && this.\u02ce.getProvider("network") != null && this.\u02ce.isProviderEnabled("network");
    }

    private void \u141d() {
        try {
            if (!this.\u02bc) {
                b.\u02cf(3, "LocationManager", this, "Attempting to start update");
                if (this.\u02cb\u0971()) {
                    b.\u02cf(3, "LocationManager", this, "start updating gps location");
                    this.\u02ce.requestLocationUpdates("gps", 0L, 0.0f, (LocationListener)this, Looper.getMainLooper());
                    this.\u02bc = true;
                }
                if (this.\u0971\u02cb()) {
                    b.\u02cf(3, "LocationManager", this, "start updating network location");
                    this.\u02ce.requestLocationUpdates("network", 0L, 0.0f, (LocationListener)this, Looper.getMainLooper());
                    this.\u02bc = true;
                }
                if (this.\u02bc) {
                    this.\u02ca\u0971();
                    this.\u02cb = this.\u0971.schedule(new Runnable(this){
                        private /* synthetic */ k \u0971;
                        {
                            this.\u0971 = k2;
                        }

                        public final void run() {
                            try {
                                b.\u02cf(3, "LocationManager", this, "fetchTimedOut");
                                this.\u0971.\u02cb(true);
                                return;
                            }
                            catch (Exception exception) {
                                o.\u0971(exception);
                                return;
                            }
                        }
                    }, 60L, TimeUnit.SECONDS);
                }
            }
            return;
        }
        catch (SecurityException securityException) {
            o.\u0971((Exception)((Object)securityException));
            return;
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
            b.\u02cf(3, "LocationManager", this, stringBuilder.toString());
            f2 = (System.currentTimeMillis() - location.getTime()) / 1000L;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
        if (!location.hasAccuracy() || !(location.getAccuracy() <= 100.0f) || !(f2 < 600.0f)) return;
        this.\u02bd = k.\u02ca(this.\u02bd, location);
        b.\u02cf(3, "LocationManager", this, "fetchCompleted");
        this.\u02cb(true);
    }

    public final void onProviderDisabled(String string2) {
    }

    public final void onProviderEnabled(String string2) {
    }

    public final void onStatusChanged(String string2, int n2, Bundle bundle) {
    }

    final void \u02ca() {
        this.\u02cb(false);
    }

    final void \u02cb() {
        this.\u02cf();
    }

    final Location \u0971() {
        if (!this.\u141d && this.\u02ce != null) {
            return this.\u02bd;
        }
        return null;
    }

}

