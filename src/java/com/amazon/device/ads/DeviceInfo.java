/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.CharSequence
 *  java.lang.ExceptionInInitializerError
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.DisplayUtils;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.Size;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.UserAgentManager;
import com.amazon.device.ads.WebUtils;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

class DeviceInfo {
    private static final String LOGTAG = "DeviceInfo";
    public static final String ORIENTATION_LANDSCAPE = "landscape";
    public static final String ORIENTATION_PORTRAIT = "portrait";
    public static final String ORIENTATION_UNKNOWN = "unknown";
    private static final String dt = "android";
    private static final String os = "Android";
    private boolean bad_mac;
    private boolean bad_serial;
    private boolean bad_udid;
    private final AndroidBuildInfo buildInfo;
    private String carrier;
    private String country;
    private final MobileAdsInfoStore infoStore;
    private Size landscapeScreenSize;
    private String language;
    private final MobileAdsLogger logger;
    private boolean macFetched;
    private String make = Build.MANUFACTURER;
    private String model = Build.MODEL;
    private String osVersion = Build.VERSION.RELEASE;
    private Size portraitScreenSize;
    private float scalingFactor;
    private String scalingFactorAsString;
    private boolean serialFetched;
    private String sha1_mac;
    private String sha1_serial;
    private String sha1_udid;
    private boolean udidFetched;
    private UserAgentManager userAgentManager;

    public DeviceInfo(Context context, UserAgentManager userAgentManager) {
        this(context, userAgentManager, MobileAdsInfoStore.getInstance(), new MobileAdsLoggerFactory(), new AndroidBuildInfo());
    }

    DeviceInfo(Context context, UserAgentManager userAgentManager, MobileAdsInfoStore mobileAdsInfoStore, MobileAdsLoggerFactory mobileAdsLoggerFactory, AndroidBuildInfo androidBuildInfo) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.infoStore = mobileAdsInfoStore;
        this.buildInfo = androidBuildInfo;
        this.setCountry();
        this.setCarrier(context);
        this.setLanguage();
        this.setScalingFactor(context);
        this.userAgentManager = userAgentManager;
    }

    private void setCarrier(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        if (telephonyManager != null) {
            String string = telephonyManager.getNetworkOperatorName();
            if (string == null || string.length() <= 0) {
                string = null;
            }
            this.carrier = string;
        }
    }

    private void setCountry() {
        String string = Locale.getDefault().getCountry();
        if (string == null || string.length() <= 0) {
            string = null;
        }
        this.country = string;
    }

    private void setLanguage() {
        String string = Locale.getDefault().getLanguage();
        if (string == null || string.length() <= 0) {
            string = null;
        }
        this.language = string;
    }

    private void setMacAddressIfNotFetched() {
        if (!this.macFetched) {
            this.setMacAddress();
        }
    }

    private void setScalingFactor(Context context) {
        if (this.make.equals((Object)"motorola") && this.model.equals((Object)"MB502")) {
            this.scalingFactor = 1.0f;
        } else {
            WindowManager windowManager = (WindowManager)context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.scalingFactor = displayMetrics.scaledDensity;
        }
        this.scalingFactorAsString = Float.toString((float)this.scalingFactor);
    }

    /*
     * Exception decompiling
     */
    private void setSerial() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl11 : ALOAD_1 : trying to set 1 previously set to 0
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

    private void setSerialIfNotFetched() {
        if (!this.serialFetched) {
            this.setSerial();
        }
    }

    private void setUdid() {
        String string = Settings.Secure.getString((ContentResolver)this.infoStore.getApplicationContext().getContentResolver(), (String)"android_id");
        if (!StringUtils.isNullOrEmpty(string) && !string.equalsIgnoreCase("9774d56d682e549c")) {
            this.sha1_udid = WebUtils.getURLEncodedString(StringUtils.sha1(string));
        } else {
            this.sha1_udid = null;
            this.bad_udid = true;
        }
        this.udidFetched = true;
    }

    private void setUdidIfNotFetched() {
        if (!this.udidFetched) {
            this.setUdid();
        }
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getCountry() {
        return this.country;
    }

    public JSONObject getDInfoProperty() {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.put(jSONObject, "make", this.getMake());
        JSONUtils.put(jSONObject, "model", this.getModel());
        JSONUtils.put(jSONObject, "os", this.getOS());
        JSONUtils.put(jSONObject, "osVersion", this.getOSVersion());
        JSONUtils.put(jSONObject, "scalingFactor", this.getScalingFactorAsString());
        JSONUtils.put(jSONObject, "language", this.getLanguage());
        JSONUtils.put(jSONObject, "country", this.getCountry());
        JSONUtils.put(jSONObject, "carrier", this.getCarrier());
        return jSONObject;
    }

    public String getDeviceType() {
        return dt;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMacSha1() {
        this.setMacAddressIfNotFetched();
        return this.sha1_mac;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getOS() {
        return os;
    }

    public String getOSVersion() {
        return this.osVersion;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String getOrientation() {
        int n = DisplayUtils.determineCanonicalScreenOrientation(this.infoStore.getApplicationContext(), this.buildInfo);
        if (n == 0) return ORIENTATION_LANDSCAPE;
        if (n == 1) return ORIENTATION_PORTRAIT;
        if (n == 8) return ORIENTATION_LANDSCAPE;
        if (n == 9) return ORIENTATION_PORTRAIT;
        return ORIENTATION_UNKNOWN;
    }

    public float getScalingFactorAsFloat() {
        return this.scalingFactor;
    }

    public String getScalingFactorAsString() {
        return this.scalingFactorAsString;
    }

    public Size getScreenSize(String string) {
        Size size;
        Size size2;
        if (string.equals((Object)ORIENTATION_PORTRAIT) && (size2 = this.portraitScreenSize) != null) {
            return size2;
        }
        if (string.equals((Object)ORIENTATION_LANDSCAPE) && (size = this.landscapeScreenSize) != null) {
            return size;
        }
        WindowManager windowManager = (WindowManager)this.infoStore.getApplicationContext().getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf((int)displayMetrics.widthPixels));
        stringBuilder.append("x");
        stringBuilder.append(String.valueOf((int)displayMetrics.heightPixels));
        String string2 = stringBuilder.toString();
        if (string.equals((Object)ORIENTATION_PORTRAIT)) {
            this.portraitScreenSize = new Size(string2);
            return this.portraitScreenSize;
        }
        if (string.equals((Object)ORIENTATION_LANDSCAPE)) {
            this.landscapeScreenSize = new Size(string2);
            return this.landscapeScreenSize;
        }
        return new Size(string2);
    }

    public String getSerialSha1() {
        this.setSerialIfNotFetched();
        return this.sha1_serial;
    }

    public String getUdidSha1() {
        this.setUdidIfNotFetched();
        return this.sha1_udid;
    }

    public String getUserAgentString() {
        return this.userAgentManager.getUserAgentString();
    }

    public boolean isMacBad() {
        this.setMacAddressIfNotFetched();
        return this.bad_mac;
    }

    public boolean isSerialBad() {
        this.setSerialIfNotFetched();
        return this.bad_serial;
    }

    public boolean isUdidBad() {
        this.setUdidIfNotFetched();
        return this.bad_udid;
    }

    public void populateUserAgentString(Context context) {
        this.userAgentManager.populateUserAgentString(context);
    }

    protected void setMacAddress() {
        WifiInfo wifiInfo;
        block10 : {
            WifiManager wifiManager = (WifiManager)this.infoStore.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                try {
                    wifiInfo = wifiManager.getConnectionInfo();
                    break block10;
                }
                catch (ExceptionInInitializerError exceptionInInitializerError) {
                    this.logger.d("Unable to get Wifi connection information: %s", new Object[]{exceptionInInitializerError});
                }
                catch (SecurityException securityException) {
                    this.logger.d("Unable to get Wifi connection information: %s", new Object[]{securityException});
                }
            }
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            this.sha1_mac = null;
        } else {
            String string = wifiInfo.getMacAddress();
            if (string != null && string.length() != 0) {
                if (!Pattern.compile((String)"((([0-9a-fA-F]){1,2}[-:]){5}([0-9a-fA-F]){1,2})").matcher((CharSequence)string).find()) {
                    this.sha1_mac = null;
                    this.bad_mac = true;
                } else {
                    this.sha1_mac = WebUtils.getURLEncodedString(StringUtils.sha1(string));
                }
            } else {
                this.sha1_mac = null;
                this.bad_mac = true;
            }
        }
        this.macFetched = true;
    }

    public void setUserAgentManager(UserAgentManager userAgentManager) {
        this.userAgentManager = userAgentManager;
    }

    public void setUserAgentString(String string) {
        this.userAgentManager.setUserAgentString(string);
    }

    JSONObject toJsonObject(String string) {
        JSONObject jSONObject = this.getDInfoProperty();
        JSONUtils.put(jSONObject, "orientation", string);
        JSONUtils.put(jSONObject, "screenSize", this.getScreenSize(string).toString());
        JSONUtils.put(jSONObject, "connectionType", new ConnectionInfo(this.infoStore).getConnectionType());
        return jSONObject;
    }

    public String toJsonString() {
        return this.toJsonObject(this.getOrientation()).toString();
    }
}

