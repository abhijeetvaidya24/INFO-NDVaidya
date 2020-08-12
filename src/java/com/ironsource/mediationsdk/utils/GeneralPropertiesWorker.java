/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.location.Location
 *  android.location.LocationManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.StatFs
 *  android.telephony.TelephonyManager
 *  com.ironsource.mediationsdk.IronSourceObject
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.GregorianCalendar
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.TimeZone
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.GeneralProperties;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public class GeneralPropertiesWorker
implements Runnable {
    private final String ADVERTISING_ID = "advertisingId";
    private final String ADVERTISING_ID_IS_LIMIT_TRACKING = "isLimitAdTrackingEnabled";
    private final String ADVERTISING_ID_TYPE = "advertisingIdType";
    private final String ANDROID_OS_VERSION = "osVersion";
    private final String APPLICATION_KEY = "appKey";
    private final String BATTERY_LEVEL = "battery";
    private final String BUNDLE_ID = "bundleId";
    private final String CONNECTION_TYPE = "connectionType";
    private final String DEVICE_MODEL = "deviceModel";
    private final String DEVICE_OEM = "deviceOEM";
    private final String DEVICE_OS = "deviceOS";
    private final String EXTERNAL_FREE_MEMORY = "externalFreeMemory";
    private final String GMT_MINUTES_OFFSET = "gmtMinutesOffset";
    private final String INTERNAL_FREE_MEMORY = "internalFreeMemory";
    private final String KEY_IS_ROOT = "jb";
    private final String KEY_PLUGIN_FW_VERSION = "plugin_fw_v";
    private final String KEY_PLUGIN_TYPE = "pluginType";
    private final String KEY_PLUGIN_VERSION = "pluginVersion";
    private final String KEY_SESSION_ID = "sessionId";
    private final String LANGUAGE = "language";
    private final String LOCATION_LAT = "lat";
    private final String LOCATION_LON = "lon";
    private final String MEDIATION_TYPE = "mt";
    private final String MOBILE_CARRIER = "mobileCarrier";
    private final String PUBLISHER_APP_VERSION = "appVersion";
    private final String TAG = this.getClass().getSimpleName();
    private Context mContext;

    private GeneralPropertiesWorker() {
    }

    public GeneralPropertiesWorker(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /*
     * Exception decompiling
     */
    private Map<String, Object> collectInformation() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl72.1 : ALOAD_1 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
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

    private String getAndroidVersion() {
        String string;
        string = "";
        try {
            String string2 = Build.VERSION.RELEASE;
            int n2 = Build.VERSION.SDK_INT;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(n2);
            stringBuilder.append("(");
            stringBuilder.append(string2);
            stringBuilder.append(")");
            string = stringBuilder.toString();
        }
        catch (Exception exception) {}
        return string;
    }

    private String getApplicationKey() {
        return IronSourceObject.getInstance().getIronSourceAppKey();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int getBatteryLevel() {
        int n2;
        int n3;
        try {
            Intent intent = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            n3 = intent != null ? intent.getIntExtra("level", -1) : 0;
            n2 = 0;
            if (intent != null) {
                n2 = intent.getIntExtra("scale", -1);
            }
            if (n3 == -1 || n2 == -1) return -1;
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":getBatteryLevel()");
            ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
        }
        return (int)(100.0f * ((float)n3 / (float)n2));
        return -1;
    }

    private String getBundleId() {
        try {
            String string = this.mContext.getPackageName();
            return string;
        }
        catch (Exception exception) {
            return "";
        }
    }

    private String getDeviceModel() {
        try {
            String string = Build.MODEL;
            return string;
        }
        catch (Exception exception) {
            return "";
        }
    }

    private String getDeviceOEM() {
        try {
            String string = Build.MANUFACTURER;
            return string;
        }
        catch (Exception exception) {
            return "";
        }
    }

    private String getDeviceOS() {
        return "Android";
    }

    private long getExternalStorageFreeSize() {
        if (this.isExternalStorageAbvailable()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (long)statFs.getBlockSize() * (long)statFs.getAvailableBlocks() / 0x100000L;
        }
        return -1L;
    }

    private int getGmtMinutesOffset() {
        int n2;
        int n3 = 0;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            n3 = timeZone.getOffset(GregorianCalendar.getInstance((TimeZone)timeZone).getTimeInMillis()) / 1000 / 60;
            n2 = Math.round((float)(n3 / 15));
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":getGmtMinutesOffset()");
            ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
            return n3;
        }
        return n2 * 15;
    }

    private long getInternalStorageFreeSize() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long l2 = (long)statFs.getBlockSize() * (long)statFs.getAvailableBlocks() / 0x100000L;
            return l2;
        }
        catch (Exception exception) {
            return -1L;
        }
    }

    private String getLanguage() {
        try {
            String string = Locale.getDefault().getLanguage();
            return string;
        }
        catch (Exception exception) {
            return "";
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @SuppressLint(value={"MissingPermission"})
    private double[] getLastKnownLocation() {
        double[] arrd = new double[]{};
        if (!this.locationPermissionGranted()) return arrd;
        LocationManager locationManager = (LocationManager)this.mContext.getApplicationContext().getSystemService("location");
        Location location = null;
        Iterator iterator = locationManager.getAllProviders().iterator();
        long l2 = Long.MIN_VALUE;
        do {
            if (!iterator.hasNext()) break;
            Location location2 = locationManager.getLastKnownLocation((String)iterator.next());
            if (location2 == null) continue;
            if (location2.getTime() <= l2) continue;
            l2 = location2.getTime();
            location = location2;
            continue;
            break;
        } while (true);
        if (location == null) return arrd;
        try {
            return new double[]{location.getLatitude(), location.getLongitude()};
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":getLastLocation()");
            ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
            return new double[0];
        }
    }

    private String getMediationType() {
        return IronSourceObject.getInstance().getMediationType();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String getMobileCarrier() {
        TelephonyManager telephonyManager = (TelephonyManager)this.mContext.getSystemService("phone");
        if (telephonyManager == null) return "";
        try {
            String string = telephonyManager.getNetworkOperatorName();
            boolean bl2 = string.equals((Object)"");
            if (bl2) return "";
            return string;
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":getMobileCarrier()");
            ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
        }
        return "";
    }

    private String getPluginFrameworkVersion() {
        try {
            String string = ConfigFile.getConfigFile().getPluginFrameworkVersion();
            return string;
        }
        catch (Exception exception) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", (Throwable)exception);
            return "";
        }
    }

    private String getPluginType() {
        try {
            String string = ConfigFile.getConfigFile().getPluginType();
            return string;
        }
        catch (Exception exception) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", (Throwable)exception);
            return "";
        }
    }

    private String getPluginVersion() {
        try {
            String string = ConfigFile.getConfigFile().getPluginVersion();
            return string;
        }
        catch (Exception exception) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", (Throwable)exception);
            return "";
        }
    }

    private String getSDKVersion() {
        return IronSourceUtils.getSDKVersion();
    }

    private boolean isExternalStorageAbvailable() {
        try {
            boolean bl2 = Environment.getExternalStorageState().equals((Object)"mounted");
            return bl2;
        }
        catch (Exception exception) {
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    private boolean locationPermissionGranted() {
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

    private boolean validateGmtMinutesOffset(int n2) {
        return n2 <= 840 && n2 >= -720 && n2 % 15 == 0;
    }

    public void run() {
        try {
            Map<String, Object> map = this.collectInformation();
            GeneralProperties.getProperties().putKeys(map);
            IronSourceUtils.saveGeneralProperties(this.mContext, GeneralProperties.getProperties().toJSON());
            return;
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread name = ");
            stringBuilder.append(this.getClass().getSimpleName());
            ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), (Throwable)exception);
            return;
        }
    }
}

