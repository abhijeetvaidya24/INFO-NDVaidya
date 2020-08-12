/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.location.Location
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.GoogleApiClient
 *  com.google.android.gms.common.api.GoogleApiClient$Builder
 *  com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
 *  com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.location.FusedLocationProviderApi
 *  com.google.android.gms.location.LocationListener
 *  com.google.android.gms.location.LocationRequest
 *  com.google.android.gms.location.LocationServices
 *  com.onesignal.LocationGMS$GoogleApiClientListener
 *  com.onesignal.LocationGMS$LocationUpdateListener
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.math.BigDecimal
 *  java.math.RoundingMode
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.onesignal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.AndroidSupportV4Compat;
import com.onesignal.GoogleApiClientCompatProxy;
import com.onesignal.LocationGMS;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalPrefs;
import com.onesignal.OneSignalSyncServiceUtils;
import com.onesignal.PermissionsActivity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Exception performing whole class analysis.
 */
class LocationGMS {
    private static Context classContext;
    private static Thread fallbackFailThread;
    private static boolean locationCoarse;
    private static LocationHandlerThread locationHandlerThread;
    private static ConcurrentHashMap<CALLBACK_TYPE, LocationHandler> locationHandlers;
    static LocationUpdateListener locationUpdateListener;
    private static GoogleApiClientCompatProxy mGoogleApiClient;
    private static Location mLastLocation;
    static String requestPermission;
    protected static final Object syncLock;

    static {
        syncLock = new Object(){};
        locationHandlers = new ConcurrentHashMap();
    }

    LocationGMS() {
    }

    static /* synthetic */ Location access$300() {
        return mLastLocation;
    }

    static /* synthetic */ Location access$302(Location location) {
        mLastLocation = location;
        return location;
    }

    static /* synthetic */ GoogleApiClientCompatProxy access$400() {
        return mGoogleApiClient;
    }

    static /* synthetic */ void access$500(Location location) {
        LocationGMS.fireCompleteForLocation(location);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static void fireComplete(LocationPoint locationPoint) {
        HashMap hashMap = new HashMap();
        Class<LocationGMS> class_ = LocationGMS.class;
        // MONITORENTER : com.onesignal.LocationGMS.class
        hashMap.putAll(locationHandlers);
        locationHandlers.clear();
        Thread thread = fallbackFailThread;
        // MONITOREXIT : class_
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            ((LocationHandler)hashMap.get((Object)((CALLBACK_TYPE)((Object)iterator.next())))).complete(locationPoint);
        }
        if (thread != null && !Thread.currentThread().equals((Object)thread)) {
            thread.interrupt();
        }
        if (thread == fallbackFailThread) {
            class_ = LocationGMS.class;
            // MONITORENTER : com.onesignal.LocationGMS.class
            if (thread == fallbackFailThread) {
                fallbackFailThread = null;
            }
            // MONITOREXIT : class_
        }
        LocationGMS.setLastLocationTime(System.currentTimeMillis());
        return;
        {
            catch (Throwable throwable) {}
            {
                // MONITOREXIT : class_
                throw throwable;
            }
        }
    }

    private static void fireCompleteForLocation(Location location) {
        LocationPoint locationPoint = new LocationPoint();
        locationPoint.accuracy = Float.valueOf((float)location.getAccuracy());
        locationPoint.bg = true ^ OneSignal.isForeground();
        locationPoint.type = true ^ locationCoarse;
        locationPoint.timeStamp = location.getTime();
        if (locationCoarse) {
            locationPoint.lat = new BigDecimal(location.getLatitude()).setScale(7, RoundingMode.HALF_UP).doubleValue();
            locationPoint.log = new BigDecimal(location.getLongitude()).setScale(7, RoundingMode.HALF_UP).doubleValue();
        } else {
            locationPoint.lat = location.getLatitude();
            locationPoint.log = location.getLongitude();
        }
        LocationGMS.fireComplete(locationPoint);
        LocationGMS.scheduleUpdate(classContext);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void fireFailedComplete() {
        Object object;
        PermissionsActivity.answered = false;
        Object object2 = object = syncLock;
        synchronized (object2) {
            if (mGoogleApiClient != null) {
                mGoogleApiClient.disconnect();
            }
            mGoogleApiClient = null;
        }
        LocationGMS.fireComplete(null);
    }

    private static int getApiFallbackWait() {
        return 30000;
    }

    private static long getLastLocationTime() {
        return OneSignalPrefs.getLong(OneSignalPrefs.PREFS_ONESIGNAL, "OS_LAST_LOCATION_TIME", -600000L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void getLocation(Context context, boolean bl2, LocationHandler locationHandler) {
        int n2;
        classContext = context;
        locationHandlers.put((Object)locationHandler.getType(), (Object)locationHandler);
        if (!OneSignal.shareLocation) {
            LocationGMS.fireFailedComplete();
            return;
        }
        int n3 = AndroidSupportV4Compat.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION");
        if (n3 == (n2 = -1)) {
            n2 = AndroidSupportV4Compat.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
            locationCoarse = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (n3 != 0 && n2 != 0) {
                locationHandler.complete(null);
                return;
            }
            LocationGMS.startGetLocation();
            return;
        }
        if (n3 == 0) {
            LocationGMS.startGetLocation();
            return;
        }
        try {
            List list = Arrays.asList((Object[])context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)4096).requestedPermissions);
            if (list.contains((Object)"android.permission.ACCESS_FINE_LOCATION")) {
                requestPermission = "android.permission.ACCESS_FINE_LOCATION";
            } else if (list.contains((Object)"android.permission.ACCESS_COARSE_LOCATION") && n2 != 0) {
                requestPermission = "android.permission.ACCESS_COARSE_LOCATION";
            }
            if (requestPermission != null && bl2) {
                PermissionsActivity.startPrompt();
                return;
            }
            if (n2 == 0) {
                LocationGMS.startGetLocation();
                return;
            }
            LocationGMS.fireFailedComplete();
            return;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return;
        }
    }

    private static boolean hasLocationPermission(Context context) {
        return AndroidSupportV4Compat.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || AndroidSupportV4Compat.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
        {
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void onFocusChange() {
        Object object;
        Object object2 = object = syncLock;
        synchronized (object2) {
            if (mGoogleApiClient != null && mGoogleApiClient.realInstance().isConnected()) {
                GoogleApiClient googleApiClient = mGoogleApiClient.realInstance();
                if (locationUpdateListener != null) {
                    LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, (LocationListener)locationUpdateListener);
                }
                locationUpdateListener = new /* Unavailable Anonymous Inner Class!! */;
                return;
            }
            return;
        }
    }

    static boolean scheduleUpdate(Context context) {
        if (LocationGMS.hasLocationPermission(context) && OneSignal.shareLocation) {
            long l2 = System.currentTimeMillis() - LocationGMS.getLastLocationTime();
            long l3 = OneSignal.isForeground() ? 300L : 600L;
            Long.signum((long)l3);
            OneSignalSyncServiceUtils.scheduleLocationUpdateTask(context, l3 * 1000L - l2);
            return true;
        }
        return false;
    }

    private static void setLastLocationTime(long l2) {
        OneSignalPrefs.saveLong(OneSignalPrefs.PREFS_ONESIGNAL, "OS_LAST_LOCATION_TIME", l2);
    }

    private static void startFallBackThread() {
        fallbackFailThread = new Thread(new Runnable(){

            public void run() {
                try {
                    Thread.sleep((long)LocationGMS.getApiFallbackWait());
                    OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.");
                    LocationGMS.fireFailedComplete();
                    LocationGMS.scheduleUpdate(classContext);
                }
                catch (InterruptedException interruptedException) {}
            }
        }, "OS_GMS_LOCATION_FALLBACK");
        fallbackFailThread.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static void startGetLocation() {
        if (fallbackFailThread != null) {
            return;
        }
        try {
            Object object;
            Object object2 = object = syncLock;
            // MONITORENTER : object2
        }
        catch (Throwable throwable) {
            OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "Location permission exists but there was an error initializing: ", throwable);
            LocationGMS.fireFailedComplete();
            return;
        }
        LocationGMS.startFallBackThread();
        if (locationHandlerThread == null) {
            locationHandlerThread = new LocationHandlerThread();
        }
        if (mGoogleApiClient != null && mLastLocation != null) {
            if (mLastLocation == null) return;
            {
                LocationGMS.fireCompleteForLocation(mLastLocation);
                return;
            }
        } else {
            GoogleApiClientListener googleApiClientListener = new /* Unavailable Anonymous Inner Class!! */;
            mGoogleApiClient = new GoogleApiClientCompatProxy(new GoogleApiClient.Builder(classContext).addApi(LocationServices.API).addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)googleApiClientListener).addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)googleApiClientListener).setHandler(LocationGMS.locationHandlerThread.mHandler).build());
            mGoogleApiClient.connect();
        }
        // MONITOREXIT : object2
    }

    static final class CALLBACK_TYPE
    extends Enum<CALLBACK_TYPE> {
        private static final /* synthetic */ CALLBACK_TYPE[] $VALUES;
        public static final /* enum */ CALLBACK_TYPE PROMPT_LOCATION;
        public static final /* enum */ CALLBACK_TYPE STARTUP;
        public static final /* enum */ CALLBACK_TYPE SYNC_SERVICE;

        static {
            STARTUP = new CALLBACK_TYPE();
            PROMPT_LOCATION = new CALLBACK_TYPE();
            SYNC_SERVICE = new CALLBACK_TYPE();
            CALLBACK_TYPE[] arrcALLBACK_TYPE = new CALLBACK_TYPE[]{STARTUP, PROMPT_LOCATION, SYNC_SERVICE};
            $VALUES = arrcALLBACK_TYPE;
        }

        public static CALLBACK_TYPE valueOf(String string2) {
            return (CALLBACK_TYPE)Enum.valueOf(CALLBACK_TYPE.class, (String)string2);
        }

        public static CALLBACK_TYPE[] values() {
            return (CALLBACK_TYPE[])$VALUES.clone();
        }
    }

    static class FusedLocationApiWrapper {
        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static Location getLastLocation(GoogleApiClient googleApiClient) {
            Object object;
            Object object2 = object = LocationGMS.syncLock;
            synchronized (object2) {
                if (!googleApiClient.isConnected()) return null;
                return LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        static void requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            try {
                Object object;
                Object object2 = object = LocationGMS.syncLock;
                // MONITORENTER : object2
            }
            catch (Throwable throwable) {
                OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "FusedLocationApi.requestLocationUpdates failed!", throwable);
                return;
            }
            if (googleApiClient.isConnected()) {
                LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, locationListener);
            }
            // MONITOREXIT : object2
        }
    }

    static interface LocationHandler {
        public void complete(LocationPoint var1);

        public CALLBACK_TYPE getType();
    }

    private static class LocationHandlerThread
    extends HandlerThread {
        Handler mHandler;

        LocationHandlerThread() {
            super("OSH_LocationHandlerThread");
            this.start();
            this.mHandler = new Handler(this.getLooper());
        }
    }

    static class LocationPoint {
        Float accuracy;
        Boolean bg;
        Double lat;
        Double log;
        Long timeStamp;
        Integer type;

        LocationPoint() {
        }
    }

}

