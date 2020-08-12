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
 *  com.moat.analytics.mobile.mpub.k
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
package com.moat.analytics.mobile.mpub;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.moat.analytics.mobile.mpub.MoatAnalytics;
import com.moat.analytics.mobile.mpub.a;
import com.moat.analytics.mobile.mpub.k;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class o
implements LocationListener {
    private static o a;
    private ScheduledExecutorService b;
    private ScheduledFuture<?> c;
    private ScheduledFuture<?> d;
    private LocationManager e;
    private boolean f;
    private Location g;
    private boolean h;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private o() {
        try {
            String string2;
            boolean bl2 = this.f = ((k)MoatAnalytics.getInstance()).c;
            if (bl2) {
                string2 = "Moat location services disabled";
            } else {
                this.b = Executors.newScheduledThreadPool((int)1);
                this.e = (LocationManager)a.a().getSystemService("location");
                if (this.e.getAllProviders().size() != 0) {
                    this.e();
                    return;
                }
                string2 = "Device has no location providers";
            }
            p.a(3, "LocationManager", this, string2);
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    static o a() {
        if (a == null) {
            a = new o();
        }
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(boolean bl2) {
        try {
            p.a(3, "LocationManager", this, "stopping location fetch");
            this.h();
            this.i();
            if (bl2) {
                this.k();
                return;
            }
            this.j();
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        if (location.getLatitude() == 0.0 && location.getLongitude() == 0.0) {
            return false;
        }
        if (location.getAccuracy() < 0.0f) {
            return false;
        }
        return !(o.b(location) >= 600.0f);
    }

    static boolean a(Location location, Location location2) {
        if (location == location2) {
            return true;
        }
        return location != null && location2 != null && location.getTime() == location2.getTime();
    }

    private static boolean a(String string2) {
        return ContextCompat.checkSelfPermission((Context)a.a().getApplicationContext(), (String)string2) == 0;
    }

    private static float b(Location location) {
        return (System.currentTimeMillis() - location.getTime()) / 1000L;
    }

    private static Location b(Location location, Location location2) {
        boolean bl2 = o.a(location);
        boolean bl3 = o.a(location2);
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
    private void e() {
        try {
            if (this.f) {
                return;
            }
            if (this.e == null) {
                return;
            }
            boolean bl2 = this.h;
            if (bl2) {
                p.a(3, "LocationManager", this, "already updating location");
            }
            p.a(3, "LocationManager", this, "starting location fetch");
            this.g = o.b(this.g, this.f());
            if (this.g != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Have a valid location, won't fetch = ");
                stringBuilder.append(this.g.toString());
                p.a(3, "LocationManager", this, stringBuilder.toString());
                this.k();
                return;
            }
            this.g();
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    private Location f() {
        boolean bl2;
        boolean bl3;
        block7 : {
            bl2 = this.l();
            bl3 = this.m();
            if (!bl2 || !bl3) break block7;
            try {
                return o.b(this.e.getLastKnownLocation("gps"), this.e.getLastKnownLocation("network"));
            }
            catch (SecurityException securityException) {
                m.a((Exception)((Object)securityException));
            }
        }
        if (bl2) {
            return this.e.getLastKnownLocation("gps");
        }
        if (bl3) {
            Location location = this.e.getLastKnownLocation("network");
            return location;
        }
        return null;
    }

    private void g() {
        try {
            if (!this.h) {
                p.a(3, "LocationManager", this, "Attempting to start update");
                if (this.l()) {
                    p.a(3, "LocationManager", this, "start updating gps location");
                    this.e.requestLocationUpdates("gps", 0L, 0.0f, (LocationListener)this, Looper.getMainLooper());
                    this.h = true;
                }
                if (this.m()) {
                    p.a(3, "LocationManager", this, "start updating network location");
                    this.e.requestLocationUpdates("network", 0L, 0.0f, (LocationListener)this, Looper.getMainLooper());
                    this.h = true;
                }
                if (this.h) {
                    this.i();
                    this.d = this.b.schedule(new Runnable(){

                        public void run() {
                            try {
                                p.a(3, "LocationManager", this, "fetchTimedOut");
                                o.this.a(true);
                                return;
                            }
                            catch (Exception exception) {
                                m.a(exception);
                                return;
                            }
                        }
                    }, 60L, TimeUnit.SECONDS);
                    return;
                }
            }
        }
        catch (SecurityException securityException) {
            m.a((Exception)((Object)securityException));
        }
    }

    private void h() {
        try {
            p.a(3, "LocationManager", this, "Stopping to update location");
            if (o.n() && this.e != null) {
                this.e.removeUpdates((LocationListener)this);
                this.h = false;
                return;
            }
        }
        catch (SecurityException securityException) {
            m.a((Exception)((Object)securityException));
        }
    }

    private void i() {
        ScheduledFuture<?> scheduledFuture = this.d;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    private void j() {
        ScheduledFuture<?> scheduledFuture = this.c;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.c.cancel(true);
            this.c = null;
        }
    }

    private void k() {
        p.a(3, "LocationManager", this, "Resetting fetch timer");
        this.j();
        Location location = this.g;
        float f2 = 600.0f;
        if (location != null) {
            f2 = Math.max((float)(f2 - o.b(location)), (float)0.0f);
        }
        long l2 = (long)f2;
        this.c = this.b.schedule(new Runnable(){

            public void run() {
                try {
                    p.a(3, "LocationManager", this, "fetchTimerCompleted");
                    o.this.e();
                    return;
                }
                catch (Exception exception) {
                    m.a(exception);
                    return;
                }
            }
        }, l2, TimeUnit.SECONDS);
    }

    private boolean l() {
        return o.a("android.permission.ACCESS_FINE_LOCATION") && this.e.getProvider("gps") != null && this.e.isProviderEnabled("gps");
    }

    private boolean m() {
        return o.n() && this.e.getProvider("network") != null && this.e.isProviderEnabled("network");
    }

    private static boolean n() {
        return o.a("android.permission.ACCESS_FINE_LOCATION") || o.a("android.permission.ACCESS_COARSE_LOCATION");
        {
        }
    }

    Location b() {
        if (!this.f && this.e != null) {
            return this.g;
        }
        return null;
    }

    void c() {
        this.e();
    }

    void d() {
        this.a(false);
    }

    public void onLocationChanged(Location location) {
        float f2;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Received an updated location = ");
            stringBuilder.append(location.toString());
            p.a(3, "LocationManager", this, stringBuilder.toString());
            f2 = o.b(location);
        }
        catch (Exception exception) {
            m.a(exception);
        }
        if (location.hasAccuracy() && location.getAccuracy() <= 100.0f && f2 < 600.0f) {
            this.g = o.b(this.g, location);
            p.a(3, "LocationManager", this, "fetchCompleted");
            this.a(true);
            return;
        }
    }

    public void onProviderDisabled(String string2) {
    }

    public void onProviderEnabled(String string2) {
    }

    public void onStatusChanged(String string2, int n2, Bundle bundle) {
    }

}

