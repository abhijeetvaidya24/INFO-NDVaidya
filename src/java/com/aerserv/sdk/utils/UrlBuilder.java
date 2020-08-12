/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.KeyCharacterMap
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.widget.Toast
 *  com.aerserv.sdk.AerServBanner
 *  com.aerserv.sdk.view.ASVpaidInterstitalActivity
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.net.URLEncoder
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.aerserv.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.aerserv.sdk.AerServBanner;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.DisplayUtils;
import com.aerserv.sdk.view.ASVpaidInterstitalActivity;
import com.aerserv.sdk.view.View;
import com.aerserv.sdk.view.ViewLocator;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class UrlBuilder {
    private static final String ADVERTISER_ID_KEY = "adid";
    private static final String ANDROID_ID_KEY = "oid";
    private static final String BUNDLE_ID_KEY = "bundleid";
    private static final String CACHE_BUSTER_KEY = "cb";
    private static final String CELL_CARRIER_KEY = "carrier";
    private static final String DEVICE_HEIGHT = "dh";
    private static final String DEVICE_MAKE = "make";
    private static final String DEVICE_MODEL = "model";
    private static final String DEVICE_WIDTH = "dw";
    private static final String DNT_KEY = "dnt";
    private static final String GDPR_CONSENT_KEY = "gdpr_consent";
    private static final String GDPR_HAS_CONSENT_KEY = "GDPRConsent";
    private static final String KEYWORDS_KEY = "keywords";
    private static final String LANDSCAPE_HEIGHT = "lh";
    private static final String LANDSCAPE_WIDTH = "lw";
    private static final String LANG = "lang";
    private static final String LATITUDE_KEY = "lat";
    private static final String LOG_TAG = "UrlBuilder";
    private static final String LONGITUDE_KEY = "long";
    private static final String NETWORK_KEY = "network";
    private static final String OS_KEY = "os";
    private static final String OS_VERSION_KEY = "osv";
    private static final String PLATFORM_ID = "pp";
    private static final String PLC_KEY = "plc";
    private static final String PRELOAD_MODE = "pl";
    private static final String PUBKEYS_KEY = "publisher_keys";
    private static final String SDK_VERSION_KEY = "sdkv";
    private static final String SESSION_ID = "sid";
    public static final String SESSION_ID_URL_PARAMTER;
    private static final String SHARED_PREFERENCE_KEY = "AerServ";
    private static final int SOFT_KEYS_SIZE = 48;
    public static final String URL_ENCODING = "UTF-8";
    private static final String USER_ID = "vc_user_id";
    public static final String VERSION = "3.1.1";
    private static final String VIDEO_PLAYER_HEIGHT = "vph";
    private static final String VIDEO_PLAYER_WIDTH = "vpw";
    private static final String VPAID = "vpaid";
    private static final String WIFI = "wifi";
    private static volatile String adid;
    private static volatile Boolean isLimitAdTrackingEnabled;
    private static volatile boolean offProductionWarningRunning;
    private static JSONObject params;
    private static String userAgent;
    private Map<String, String> args;
    private String baseUrl;
    private Context context;
    private String userId;
    private String viewId;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&sid=");
        stringBuilder.append(AerServSettings.getSessionId());
        SESSION_ID_URL_PARAMTER = stringBuilder.toString();
        adid = null;
        isLimitAdTrackingEnabled = Boolean.FALSE;
        offProductionWarningRunning = false;
    }

    /*
     * Exception decompiling
     */
    public UrlBuilder(Context var1, String var2, List<String> var3, Map<String, String> var4, String var5, boolean var6, boolean var7, String var8, boolean var9, boolean var10, String var11) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl49 : ALOAD_3 : trying to set 1 previously set to 0
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

    public static void buildUserAgent(final Context context) {
        if (userAgent == null) {
            Runnable runnable = new Runnable(){

                public void run() {
                    try {
                        String string = new WebView(context).getSettings().getUserAgentString();
                        if (!string.toLowerCase().contains((CharSequence)"mobi") && !string.toLowerCase().contains((CharSequence)"tablet")) {
                            Point point = DisplayUtils.convertPointToDip(context, DisplayUtils.getActivitySize(context));
                            if (Math.min((int)point.x, (int)point.y) < 500) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(string);
                                stringBuilder.append(" Mobile");
                                string = stringBuilder.toString();
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(string);
                                stringBuilder.append(" Tablet");
                                string = stringBuilder.toString();
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string);
                        stringBuilder.append(" AerServSDK/");
                        stringBuilder.append(UrlBuilder.VERSION);
                        userAgent = stringBuilder.toString();
                    }
                    catch (Exception exception) {}
                    String string = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("UserAgent built: ");
                    stringBuilder.append(userAgent);
                    AerServLog.d(string, stringBuilder.toString());
                }
            };
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private void checkOffProductionWarning() {
        if (!offProductionWarningRunning && !this.baseUrl.equals((Object)"https://ads.aerserv.com/as/sdk/v3/")) {
            offProductionWarningRunning = true;
            new Thread(new Runnable(){

                public void run() {
                    for (int i2 = 0; i2 < 5; ++i2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable(){

                            public void run() {
                                Toast.makeText((Context)UrlBuilder.this.context, (CharSequence)"WARNING: NOT USING PRODUCTION URL", (int)0).show();
                            }
                        });
                        try {
                            Thread.sleep((long)3000L);
                            continue;
                        }
                        catch (InterruptedException interruptedException) {}
                    }
                    try {
                        offProductionWarningRunning = false;
                    }
                    catch (Exception exception) {}
                }

            }).start();
        }
    }

    private String encode() {
        StringBuilder stringBuilder;
        this.checkOffProductionWarning();
        stringBuilder = new StringBuilder(this.baseUrl);
        stringBuilder.append("?key=2");
        for (String string : this.args.keySet()) {
            try {
                params.put(string, this.args.get((Object)string));
                stringBuilder.append("&");
                stringBuilder.append(string);
                stringBuilder.append("=");
                stringBuilder.append(URLEncoder.encode((String)((String)this.args.get((Object)string)), (String)URL_ENCODING));
            }
            catch (Exception exception) {
                AerServLog.i(LOG_TAG, "UnsupportedEncodingException when trying to encode url", exception);
            }
        }
        try {
            params.put("ua", (Object)UrlBuilder.getUserAgent());
        }
        catch (Exception exception) {}
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    public static String getAdid(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl67 : GETSTATIC : trying to set 1 previously set to 0
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

    private void getBundleId() {
        this.args.put((Object)BUNDLE_ID_KEY, (Object)this.context.getPackageName());
    }

    private void getCellCarrier() {
        try {
            String string = ((TelephonyManager)this.context.getSystemService("phone")).getNetworkOperatorName();
            this.args.put((Object)CELL_CARRIER_KEY, (Object)string);
            return;
        }
        catch (Exception exception) {
            AerServLog.i(LOG_TAG, "Error when trying to get cell carrier", exception);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private void getDeviceDimensions() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl85 : ILOAD : trying to set 1 previously set to 0
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

    private void getDeviceMakeAndMode() {
        this.args.put((Object)DEVICE_MAKE, (Object)Build.MANUFACTURER);
        this.args.put((Object)DEVICE_MODEL, (Object)Build.MODEL);
    }

    @TargetApi(value=13)
    private void getLandscapeDimensions() {
        if (Build.VERSION.SDK_INT < 13) {
            return;
        }
        Display display = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int n2 = Math.max((int)point.x, (int)point.y);
        int n3 = DisplayUtils.convertPxToDip(this.context, n2);
        int n4 = Math.min((int)point.x, (int)point.y);
        int n5 = DisplayUtils.convertPxToDip(this.context, n4);
        if (!this.isPhone() && this.hasSoftKeys(display)) {
            n5 -= 48;
        }
        Map<String, String> map = this.args;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(n3);
        map.put((Object)LANDSCAPE_WIDTH, (Object)stringBuilder.toString());
        Map<String, String> map2 = this.args;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("");
        stringBuilder2.append(n5);
        map2.put((Object)LANDSCAPE_HEIGHT, (Object)stringBuilder2.toString());
    }

    private void getLanguage() {
        this.args.put((Object)LANG, (Object)Locale.getDefault().getLanguage());
    }

    /*
     * Exception decompiling
     */
    private void getLocation() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl45 : RETURN : trying to set 1 previously set to 0
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

    public static String getNetwork(Context context) {
        String string;
        block6 : {
            block4 : {
                NetworkInfo networkInfo;
                block5 : {
                    networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (networkInfo == null) break block4;
                    if (!networkInfo.isConnectedOrConnecting()) break block4;
                    if (networkInfo.getType() != 1) break block5;
                    string = WIFI;
                    break block6;
                }
                try {
                    if (networkInfo.getType() != 0) break block4;
                    string = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo().getSubtypeName();
                    break block6;
                }
                catch (Exception exception) {
                    AerServLog.i(LOG_TAG, "Error getting network", exception);
                }
            }
            return "";
        }
        return string;
    }

    public static JSONObject getParams() {
        return params;
    }

    private void getSdkVersion() {
        this.args.put((Object)SDK_VERSION_KEY, (Object)VERSION);
    }

    private void getSystemName() {
        this.args.put((Object)OS_KEY, (Object)"Android");
    }

    private void getSystemVersion() {
        this.args.put((Object)OS_VERSION_KEY, (Object)Build.VERSION.RELEASE);
    }

    public static String getUserAgent() {
        return userAgent;
    }

    private void getUserId() {
        this.args.put((Object)USER_ID, (Object)this.userId);
    }

    private void getVideoPlayerDimensions() {
        int n2;
        int n3;
        if (this.viewId != null) {
            View view = ViewLocator.getInstance().locateView(this.viewId);
            if (view != null && view instanceof AerServBanner) {
                AerServBanner aerServBanner = (AerServBanner)view;
                ViewGroup.LayoutParams layoutParams = aerServBanner.getLayoutParams();
                n3 = layoutParams != null && layoutParams.width > 0 ? layoutParams.width : (aerServBanner.getWidth() > 0 ? aerServBanner.getWidth() : 0);
                if (layoutParams != null && layoutParams.height > 0) {
                    n2 = layoutParams.height;
                } else {
                    int n4 = aerServBanner.getHeight();
                    n2 = 0;
                    if (n4 > 0) {
                        n2 = aerServBanner.getHeight();
                    }
                }
            } else {
                n2 = 0;
                n3 = 0;
            }
        } else {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            n3 = displayMetrics.widthPixels;
            n2 = displayMetrics.heightPixels;
        }
        this.args.put((Object)VIDEO_PLAYER_WIDTH, (Object)String.valueOf((int)n3));
        this.args.put((Object)VIDEO_PLAYER_HEIGHT, (Object)String.valueOf((int)n2));
    }

    private void getVpaidSupported() {
        ActivityInfo activityInfo = new Intent(this.context, ASVpaidInterstitalActivity.class).resolveActivityInfo(this.context.getPackageManager(), 0);
        boolean bl = false;
        if (activityInfo != null) {
            bl = true;
        }
        Map<String, String> map = this.args;
        String string = bl ? "1" : "0";
        map.put((Object)VPAID, (Object)string);
    }

    private boolean isPhone() {
        Context context = this.context;
        Point point = DisplayUtils.convertPointToDip(context, DisplayUtils.getActivitySize(context));
        return Math.min((int)point.x, (int)point.y) < 500;
    }

    public String buildUrl() {
        params = new JSONObject();
        this.getLocation();
        this.getCellCarrier();
        this.args.put((Object)NETWORK_KEY, (Object)UrlBuilder.getNetwork(this.context));
        this.getSdkVersion();
        this.getSystemName();
        this.getSystemVersion();
        this.getBundleId();
        this.getDeviceMakeAndMode();
        this.getUserId();
        this.getLandscapeDimensions();
        this.getVpaidSupported();
        this.getLanguage();
        this.getDeviceDimensions();
        this.getVideoPlayerDimensions();
        String string = this.encode();
        String string2 = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Url built: ");
        stringBuilder.append(string);
        AerServLog.d(string2, stringBuilder.toString());
        return string;
    }

    @TargetApi(value=14)
    public boolean hasSoftKeys(Display display) {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl = true;
        if (n2 < 14) {
            return bl;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getRealMetrics(displayMetrics);
            int n3 = displayMetrics.heightPixels;
            int n4 = displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            display.getMetrics(displayMetrics2);
            int n5 = displayMetrics2.heightPixels;
            if (n4 - displayMetrics2.widthPixels <= 0) {
                if (n3 - n5 > 0) {
                    return bl;
                }
                bl = false;
            }
            return bl;
        }
        boolean bl2 = ViewConfiguration.get((Context)this.context).hasPermanentMenuKey();
        boolean bl3 = KeyCharacterMap.deviceHasKey((int)4);
        if (!bl2 && !bl3) {
            return bl;
        }
        return false;
    }

}

