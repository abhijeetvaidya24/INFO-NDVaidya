/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.location.Criteria
 *  android.location.Location
 *  android.location.LocationListener
 *  android.location.LocationManager
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.environment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.ironsource.environment.ApplicationContext;

public class LocationService {
    private static String TAG = "LocationService";

    /*
     * Exception decompiling
     */
    public static Location getLastLocation(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SuppressLint(value={"MissingPermission"})
    public static void getPreciseLocation(Context context, final ISLocationListener iSLocationListener) {
        if (!ApplicationContext.isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION")) {
            Log.d((String)TAG, (String)"Location Permission Not Granted (ACCESS_FINE_LOCATION)");
            if (iSLocationListener != null) {
                iSLocationListener.onLocationChanged(null);
                return;
            }
        }
        try {
            LocationManager locationManager = (LocationManager)context.getSystemService("location");
            if (iSLocationListener != null && !locationManager.isProviderEnabled("gps")) {
                Log.d((String)TAG, (String)"GPS Provider is turned off");
                iSLocationListener.onLocationChanged(null);
                return;
            }
            LocationListener locationListener = new LocationListener(){

                public void onLocationChanged(Location location) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onLocationChanged ");
                    stringBuilder.append(location.getProvider());
                    Log.d((String)"LocationService", (String)stringBuilder.toString());
                    ISLocationListener iSLocationListener2 = iSLocationListener;
                    if (iSLocationListener2 != null) {
                        iSLocationListener2.onLocationChanged(location);
                    }
                }

                public void onProviderDisabled(String string) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onProviderDisabled ");
                    stringBuilder.append(string);
                    Log.d((String)"LocationService", (String)stringBuilder.toString());
                }

                public void onProviderEnabled(String string) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onProviderEnabled ");
                    stringBuilder.append(string);
                    Log.d((String)"LocationService", (String)stringBuilder.toString());
                }

                public void onStatusChanged(String string, int n2, Bundle bundle) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onStatusChanged ");
                    stringBuilder.append(string);
                    Log.d((String)"LocationService", (String)stringBuilder.toString());
                }
            };
            locationManager.requestSingleUpdate(new Criteria(), locationListener, Looper.myLooper());
            return;
        }
        catch (Exception exception) {
            if (iSLocationListener != null) {
                iSLocationListener.onLocationChanged(null);
            }
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public static boolean locationServicesEnabled(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public static interface ISLocationListener {
        public void onLocationChanged(Location var1);
    }

}

