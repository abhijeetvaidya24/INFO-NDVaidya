/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.net.Uri
 *  android.net.wifi.WifiInfo
 *  android.net.wifi.WifiManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  com.tapjoy.TapjoyConnectFlag
 *  com.tapjoy.TapjoyConstants
 *  com.tapjoy.TapjoyDisplayMetricsUtil
 *  com.tapjoy.TapjoyErrorMessage
 *  com.tapjoy.TapjoyErrorMessage$ErrorType
 *  com.tapjoy.TapjoyException
 *  com.tapjoy.TapjoyGpsHelper
 *  com.tapjoy.TapjoyHttpURLResponse
 *  com.tapjoy.TapjoyIntegrationException
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.TapjoyURLConnection
 *  com.tapjoy.TapjoyUtil
 *  com.tapjoy.internal.aq
 *  com.tapjoy.internal.bs
 *  com.tapjoy.internal.ct
 *  com.tapjoy.internal.dc
 *  com.tapjoy.internal.dx
 *  com.tapjoy.internal.ed
 *  com.tapjoy.internal.ee
 *  com.tapjoy.internal.ek
 *  com.tapjoy.internal.ek$a
 *  com.tapjoy.internal.er
 *  com.tapjoy.internal.er$a
 *  com.tapjoy.internal.ev
 *  com.tapjoy.internal.ev$a
 *  com.tapjoy.internal.fd
 *  com.tapjoy.internal.fh
 *  com.tapjoy.internal.gc
 *  com.tapjoy.internal.gf
 *  com.tapjoy.internal.gm
 *  com.tapjoy.internal.gq
 *  com.tapjoy.internal.j
 *  com.tapjoy.internal.q
 *  com.tapjoy.internal.y
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Hashtable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Properties
 *  java.util.Set
 *  java.util.UUID
 *  java.util.Vector
 *  java.util.concurrent.ConcurrentHashMap
 *  org.w3c.dom.Document
 *  org.w3c.dom.NodeList
 */
package com.tapjoy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TapjoyAppSettings;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.TapjoyDisplayMetricsUtil;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyException;
import com.tapjoy.TapjoyGpsHelper;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyIntegrationException;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.internal.aq;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.dc;
import com.tapjoy.internal.dx;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ee;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.er;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.fd;
import com.tapjoy.internal.fh;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.gq;
import com.tapjoy.internal.j;
import com.tapjoy.internal.q;
import com.tapjoy.internal.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class TapjoyConnectCore {
    private static float A = 0.0f;
    private static int B = 0;
    private static String C;
    private static String D;
    public static final float DEFAULT_CURRENCY_MULTIPLIER = 1.0f;
    private static String E;
    private static String F;
    private static String G;
    private static String H;
    private static String I;
    private static String J;
    private static String K;
    private static String L;
    private static String M;
    private static String N;
    private static String O;
    private static String P;
    private static float Q;
    private static boolean R;
    private static String S;
    private static String T;
    private static String U;
    private static String V;
    private static String W;
    private static long Z;
    protected static int a;
    private static Integer aA;
    private static Long aB;
    private static Long aC;
    private static Long aD;
    private static String aE;
    private static Integer aF;
    private static Double aG;
    private static Double aH;
    private static Long aI;
    private static Integer aJ;
    private static Integer aK;
    private static Integer aL;
    private static String aM;
    private static String aN;
    private static String aO;
    private static boolean ab;
    private static PackageManager ac;
    private static Hashtable ae;
    private static String af;
    private static Map ag;
    private static String ah;
    private static String ai;
    private static String aj;
    private static String ak;
    private static Integer al;
    private static String am;
    private static String an;
    private static Long ao;
    private static String ap;
    private static Integer aq;
    private static Integer ar;
    private static String as;
    private static String at;
    private static String au;
    private static String av;
    private static String aw;
    private static Set ax;
    private static Integer ay;
    private static Integer az;
    protected static int b;
    protected static String c;
    protected static boolean d;
    protected static String e;
    protected static String f;
    private static Context g;
    private static String h;
    private static TapjoyConnectCore i;
    private static TapjoyURLConnection j;
    private static TJConnectListener k;
    private static TJSetUserIDListener l;
    private static Vector m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    private static String v;
    private static String w;
    private static String x;
    private static String y;
    private static int z;
    private long X = 0L;
    private boolean Y = false;
    private boolean aa = false;
    private TapjoyGpsHelper ad;

    static {
        m = new Vector((Collection)Arrays.asList((Object[])TapjoyConstants.dependencyClassNames));
        n = "";
        o = "";
        p = "";
        q = "";
        r = "";
        s = "";
        t = "";
        u = "";
        v = "";
        w = "";
        x = "";
        y = "";
        z = 1;
        A = 1.0f;
        B = 1;
        C = "";
        D = "";
        E = "";
        F = "";
        G = "";
        H = "";
        I = "";
        J = "";
        K = "";
        L = "";
        M = "";
        N = "native";
        O = "";
        P = "";
        Q = 1.0f;
        R = false;
        S = "";
        T = "";
        U = "";
        V = "";
        W = null;
        Z = 0L;
        a = 0;
        b = 0;
        c = "";
        e = "";
        f = "";
        ae = TapjoyConnectFlag.CONNECT_FLAG_DEFAULTS;
        af = "";
        ag = new ConcurrentHashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TapjoyConnectCore(Context context) {
        g = context;
        fh.a().a(context);
        fd.a().a(context);
        j = new TapjoyURLConnection();
        ac = g.getPackageManager();
        this.ad = new TapjoyGpsHelper(g);
        try {
            String string;
            TelephonyManager telephonyManager;
            int n2;
            block38 : {
                boolean bl;
                String string2;
                if (ae == null) {
                    ae = new Hashtable();
                }
                TapjoyConnectCore.i();
                int n3 = g.getResources().getIdentifier("raw/tapjoy_config", null, g.getPackageName());
                Properties properties = new Properties();
                try {
                    properties.load(g.getResources().openRawResource(n3));
                    TapjoyConnectCore.a(properties);
                }
                catch (Exception exception) {}
                if (ct.c((String)TapjoyConnectCore.getConnectFlagValue("unit_test_mode"))) {
                    this.j();
                }
                n = string2 = Settings.Secure.getString((ContentResolver)g.getContentResolver(), (String)"android_id");
                if (string2 != null) {
                    n = n.toLowerCase();
                }
                try {
                    w = TapjoyConnectCore.ac.getPackageInfo((String)TapjoyConnectCore.g.getPackageName(), (int)0).versionName;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    throw new TapjoyException(nameNotFoundException.getMessage());
                }
                t = "android";
                D = "android";
                r = Build.MODEL;
                s = Build.MANUFACTURER;
                u = Build.VERSION.RELEASE;
                x = "11.12.2";
                y = "1.0.11";
                try {
                    if (Build.VERSION.SDK_INT > 3) {
                        TapjoyDisplayMetricsUtil tapjoyDisplayMetricsUtil = new TapjoyDisplayMetricsUtil(g);
                        z = tapjoyDisplayMetricsUtil.getScreenDensityDPI();
                        A = tapjoyDisplayMetricsUtil.getScreenDensityScale();
                        B = tapjoyDisplayMetricsUtil.getScreenLayoutSize();
                    }
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder("Error getting screen density/dimensions/layout: ");
                    stringBuilder.append(exception.toString());
                    TapjoyLog.e((String)"TapjoyConnect", (String)stringBuilder.toString());
                }
                if (bl = TapjoyConnectCore.e("android.permission.ACCESS_WIFI_STATE")) {
                    try {
                        String string3;
                        WifiInfo wifiInfo;
                        WifiManager wifiManager = (WifiManager)g.getSystemService("wifi");
                        if (wifiManager == null || (wifiInfo = wifiManager.getConnectionInfo()) == null) break block38;
                        p = string3 = wifiInfo.getMacAddress();
                        if (string3 != null) {
                            p = p.replace((CharSequence)":", (CharSequence)"").toLowerCase();
                        }
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder = new StringBuilder("Error getting device mac address: ");
                        stringBuilder.append(exception.toString());
                        TapjoyLog.e((String)"TapjoyConnect", (String)stringBuilder.toString());
                    }
                } else {
                    TapjoyLog.d((String)"TapjoyConnect", (String)"*** ignore macAddress");
                }
            }
            if ((telephonyManager = (TelephonyManager)g.getSystemService("phone")) != null) {
                E = telephonyManager.getNetworkOperatorName();
                F = telephonyManager.getNetworkCountryIso();
                String string4 = telephonyManager.getNetworkOperator();
                if (string4 != null && (string4.length() == 5 || string4.length() == 6)) {
                    G = string4.substring(0, 3);
                    H = string4.substring(3);
                }
            }
            SharedPreferences sharedPreferences = g.getSharedPreferences("tjcPrefrences", 0);
            q = string = sharedPreferences.getString("tapjoyInstallId", "");
            if (string == null || (n2 = q.length()) == 0) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(UUID.randomUUID().toString());
                    stringBuilder.append(System.currentTimeMillis());
                    q = TapjoyUtil.SHA256((String)stringBuilder.toString());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("tapjoyInstallId", q);
                    editor.commit();
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder("Error generating install id: ");
                    stringBuilder.append(exception.toString());
                    TapjoyLog.e((String)"TapjoyConnect", (String)stringBuilder.toString());
                }
            }
            if (TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_STORE_NAME") != null && TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_STORE_NAME").length() > 0) {
                K = TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_STORE_NAME");
                if (!new ArrayList((Collection)Arrays.asList((Object[])TapjoyConnectFlag.STORE_ARRAY)).contains((Object)K)) {
                    StringBuilder stringBuilder = new StringBuilder("Warning -- undefined STORE_NAME: ");
                    stringBuilder.append(K);
                    TapjoyLog.w((String)"TapjoyConnect", (String)stringBuilder.toString());
                }
            }
            try {
                boolean bl;
                String string5 = K;
                Intent intent = new Intent("android.intent.action.VIEW");
                if (string5.length() <= 0) {
                    intent.setData(Uri.parse((String)"market://details"));
                    int n4 = ac.queryIntentActivities(intent, 0).size();
                    bl = false;
                    if (n4 > 0) {
                        bl = true;
                    }
                } else if (string5.equals((Object)"gfan")) {
                    bl = TapjoyConnectCore.d("com.mappn.gfan");
                } else {
                    boolean bl2 = string5.equals((Object)"skt");
                    bl = false;
                    if (bl2) {
                        bl = TapjoyConnectCore.d("com.skt.skaf.TSCINSTALL");
                    }
                }
                R = bl;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder("Error trying to detect store intent on devicee: ");
                stringBuilder.append(exception.toString());
                TapjoyLog.e((String)"TapjoyConnect", (String)stringBuilder.toString());
            }
            TapjoyConnectCore.g();
            if (TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS") != null && TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS").length() > 0) {
                f = TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS");
            }
            if (TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK") != null && TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK").length() > 0) {
                e = TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISABLE_ADVERTISING_ID_CHECK");
            }
            if (TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_USER_ID") != null && TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_USER_ID").length() > 0) {
                StringBuilder stringBuilder = new StringBuilder("Setting userID to: ");
                stringBuilder.append(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_USER_ID"));
                TapjoyLog.i((String)"TapjoyConnect", (String)stringBuilder.toString());
                TapjoyConnectCore.setUserID(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_USER_ID"), null);
            }
            P = TapjoyUtil.getRedirectDomain((String)TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_SERVICE_URL"));
            if (ae != null) {
                TapjoyConnectCore.h();
            }
            this.callConnect();
            this.aa = true;
            return;
        }
        catch (TapjoyException tapjoyException) {
            TapjoyLog.e((String)"TapjoyConnect", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, tapjoyException.getMessage()));
            TapjoyConnectCore.d();
            ev.b.notifyObservers((Object)Boolean.FALSE);
            return;
        }
        catch (TapjoyIntegrationException tapjoyIntegrationException) {
            TapjoyLog.e((String)"TapjoyConnect", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, tapjoyIntegrationException.getMessage()));
            TapjoyConnectCore.d();
            ev.b.notifyObservers((Object)Boolean.FALSE);
            return;
        }
    }

    private static String a(long l2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(v);
            stringBuilder.append(":");
            stringBuilder.append(TapjoyConnectCore.o());
            stringBuilder.append(":");
            stringBuilder.append(l2);
            stringBuilder.append(":");
            stringBuilder.append(L);
            String string = TapjoyUtil.SHA256((String)stringBuilder.toString());
            return string;
        }
        catch (Exception exception) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            StringBuilder stringBuilder = new StringBuilder("Error in computing verifier value -- ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TapjoyConnect", (TapjoyErrorMessage)new TapjoyErrorMessage(errorType, stringBuilder.toString()));
            return "";
        }
    }

    private static String a(long l2, String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(v);
            stringBuilder.append(":");
            stringBuilder.append(TapjoyConnectCore.o());
            stringBuilder.append(":");
            stringBuilder.append(l2);
            stringBuilder.append(":");
            stringBuilder.append(L);
            stringBuilder.append(":");
            stringBuilder.append(string);
            String string2 = TapjoyUtil.SHA256((String)stringBuilder.toString());
            return string2;
        }
        catch (Exception exception) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            StringBuilder stringBuilder = new StringBuilder("Error in computing packageNamesVerifier -- ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TapjoyConnect", (TapjoyErrorMessage)new TapjoyErrorMessage(errorType, stringBuilder.toString()));
            return "";
        }
    }

    private static void a(String string, String string2) {
        if ((string.equals((Object)"TJC_OPTION_SERVICE_URL") || string.equals((Object)"TJC_OPTION_PLACEMENT_SERVICE_URL")) && !string2.endsWith("/")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("/");
            string2 = stringBuilder.toString();
        }
        ae.put((Object)string, (Object)string2);
    }

    private static void a(List list) {
        Class<TapjoyConnectCore> class_ = TapjoyConnectCore.class;
        synchronized (TapjoyConnectCore.class) {
            try {
                af = "";
                for (ApplicationInfo applicationInfo : ac.getInstalledApplications(0)) {
                    if ((1 & applicationInfo.flags) == 1 || !list.contains((Object)applicationInfo.packageName)) continue;
                    StringBuilder stringBuilder = new StringBuilder("MATCH: installed packageName: ");
                    stringBuilder.append(applicationInfo.packageName);
                    TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
                    if (af.length() > 0) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(af);
                        stringBuilder2.append(",");
                        af = stringBuilder2.toString();
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(af);
                    stringBuilder3.append(applicationInfo.packageName);
                    af = stringBuilder3.toString();
                }
                // ** MonitorExit[var12_1] (shouldn't be in output)
                return;
            }
            catch (Throwable throwable) {
                // ** MonitorExit[var12_1] (shouldn't be in output)
                throw throwable;
            }
        }
    }

    /*
     * Exception decompiling
     */
    private static void a(Properties var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl4 : ALOAD_1 : trying to set 1 previously set to 0
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

    static /* synthetic */ void a(boolean bl) {
        if (bl) {
            TapjoyLog.i((String)"TapjoyConnect", (String)"Set userID is successful");
            TJSetUserIDListener tJSetUserIDListener = l;
            if (tJSetUserIDListener != null) {
                tJSetUserIDListener.onSetUserIDSuccess();
                return;
            }
        } else {
            TapjoyLog.e((String)"TapjoyConnect", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to set userID"));
            TJSetUserIDListener tJSetUserIDListener = l;
            if (tJSetUserIDListener != null) {
                tJSetUserIDListener.onSetUserIDFailure("Failed to set userID");
            }
        }
    }

    static /* synthetic */ boolean a(String string) {
        Document document = TapjoyUtil.buildDocument((String)string);
        if (document != null) {
            String string2;
            String string3 = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("PackageNames"));
            if (string3 != null && string3.length() > 0) {
                Vector vector = new Vector();
                int n2 = 0;
                do {
                    int n3;
                    if ((n3 = string3.indexOf(44, n2)) == -1) {
                        StringBuilder stringBuilder = new StringBuilder("parse: ");
                        stringBuilder.append(string3.substring(n2).trim());
                        TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
                        vector.add((Object)string3.substring(n2).trim());
                        TapjoyConnectCore.a((List)vector);
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder("parse: ");
                    stringBuilder.append(string3.substring(n2, n3).trim());
                    TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
                    vector.add((Object)string3.substring(n2, n3).trim());
                    n2 = n3 + 1;
                } while (true);
            }
            if ((string2 = TapjoyUtil.getNodeTrimValue((NodeList)document.getElementsByTagName("Success"))) == null || !string2.equals((Object)"true")) {
                return false;
            }
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    private static boolean a(String var0, boolean var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl244.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean c(String var0) {
        block11 : {
            block13 : {
                block12 : {
                    block10 : {
                        var3_1 = bs.b((String)var0);
                        if (!var3_1.a()) break block10;
                        var3_1.s();
                        TapjoyLog.d((String)"TapjoyConnect", (String)"Successfully sent completed Pay-Per-Action to Tapjoy server.");
                        var3_1.close();
                        dc.a(null);
                        return true;
                    }
                    try {
                        var3_1.close();
                    }
                    catch (Throwable var4_2) {
                        break block11;
                    }
                    catch (RuntimeException var6_5) {
                        ** GOTO lbl-1000
                    }
                    catch (IOException var2_7) {
                        ** GOTO lbl34
                    }
                    dc.a(null);
                    break block13;
                    catch (Throwable var4_3) {
                        var3_1 = null;
                        break block11;
                    }
                    catch (RuntimeException var5_9) {
                        var6_6 = var5_9;
                        var3_1 = null;
                        ** GOTO lbl-1000
                    }
                    catch (IOException var1_10) {
                        var2_8 = var1_10;
                        var3_1 = null;
                        ** GOTO lbl34
                    }
lbl-1000: // 2 sources:
                    {
                        TapjoyLog.v((String)"TapjoyConnect", (String)var6_6.getMessage());
                        break block12;
lbl34: // 2 sources:
                        TapjoyLog.v((String)"TapjoyConnect", (String)var2_8.getMessage());
                    }
                }
                dc.a((Closeable)var3_1);
            }
            TapjoyLog.e((String)"TapjoyConnect", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Completed Pay-Per-Action call failed."));
            return false;
        }
        dc.a((Closeable)var3_1);
        throw var4_4;
    }

    private static void d() {
        TJConnectListener tJConnectListener;
        if (!ct.c((String)M)) {
            gc.a().a(g, h, "11.12.2", "https://rpc.tapjoy.com/", M, L);
        }
        if ((tJConnectListener = k) != null) {
            tJConnectListener.onConnectFailure();
        }
    }

    private static boolean d(String string) {
        Iterator iterator = ac.getInstalledApplications(0).iterator();
        while (iterator.hasNext()) {
            if (!((ApplicationInfo)iterator.next()).packageName.startsWith(string)) continue;
            return true;
        }
        return false;
    }

    private static Map e() {
        int n2;
        String string;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        TapjoyUtil.safePut((Map)hashMap3, (String)"plugin", (String)N, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap3, (String)"sdk_type", (String)O, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap3, (String)"app_id", (String)v, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap3, (String)"library_version", (String)x, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap3, (String)"library_revision", (String)"0859594bd", (boolean)true);
        TapjoyUtil.safePut((Map)hashMap3, (String)"bridge_version", (String)y, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap3, (String)"app_version", (String)w, (boolean)true);
        hashMap2.putAll((Map)hashMap3);
        HashMap hashMap4 = new HashMap();
        TapjoyUtil.safePut((Map)hashMap4, (String)"device_name", (String)r, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"platform", (String)D, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"os_version", (String)u, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"device_manufacturer", (String)s, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"device_type", (String)t, (boolean)true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(B);
        TapjoyUtil.safePut((Map)hashMap4, (String)"screen_layout_size", (String)stringBuilder.toString(), (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"store_name", (String)K, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"store_view", (String)String.valueOf((boolean)R), (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"carrier_name", (String)E, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"carrier_country_code", (String)F, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"mobile_network_code", (String)H, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"mobile_country_code", (String)G, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"country_code", (String)Locale.getDefault().getCountry(), (boolean)true);
        TapjoyUtil.safePut((Map)hashMap4, (String)"language_code", (String)Locale.getDefault().getLanguage(), (boolean)true);
        I = TapjoyConnectCore.getConnectionType();
        TapjoyUtil.safePut((Map)hashMap4, (String)"connection_type", (String)I, (boolean)true);
        J = TapjoyConnectCore.getConnectionSubType();
        TapjoyUtil.safePut((Map)hashMap4, (String)"connection_subtype", (String)J, (boolean)true);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(z);
        TapjoyUtil.safePut((Map)hashMap4, (String)"screen_density", (String)stringBuilder2.toString(), (boolean)true);
        hashMap2.putAll((Map)hashMap4);
        HashMap hashMap5 = new HashMap();
        if (TapjoyConnectCore.l()) {
            TapjoyUtil.safePut((Map)hashMap5, (String)"advertising_id", (String)c, (boolean)true);
            TapjoyUtil.safePut((Map)hashMap5, (String)"ad_tracking_enabled", (String)String.valueOf((boolean)d), (boolean)true);
        }
        if (!TapjoyConnectCore.m()) {
            TapjoyUtil.safePut((Map)hashMap5, (String)"android_id", (String)n, (boolean)true);
            TapjoyUtil.safePut((Map)hashMap5, (String)"mac_address", (String)p, (boolean)true);
        }
        TapjoyUtil.safePut((Map)hashMap5, (String)"install_id", (String)q, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap5, (String)"publisher_user_id", (String)C, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap5, (String)"ad_id_check_disabled", (String)e, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap5, (String)"persistent_ids_disabled", (String)f, (boolean)true);
        int n3 = a;
        if (n3 != 0) {
            TapjoyUtil.safePut((Map)hashMap5, (String)"packaged_gps_version", (String)Integer.toString((int)n3), (boolean)true);
        }
        if ((n2 = b) != 0) {
            TapjoyUtil.safePut((Map)hashMap5, (String)"device_gps_version", (String)Integer.toString((int)n2), (boolean)true);
        }
        if ((string = o) != null && string.length() != 0 && System.currentTimeMillis() - Z <= 1800000L) {
            Z = System.currentTimeMillis();
        } else {
            o = TapjoyConnectCore.n();
        }
        TapjoyUtil.safePut((Map)hashMap5, (String)"session_id", (String)o, (boolean)true);
        hashMap2.putAll((Map)hashMap5);
        HashMap hashMap6 = new HashMap();
        TapjoyUtil.safePut((Map)hashMap6, (String)"app_group_id", (String)S, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap6, (String)"store", (String)T, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap6, (String)"analytics_api_key", (String)U, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap6, (String)"managed_device_id", (String)V, (boolean)true);
        hashMap2.putAll((Map)hashMap6);
        fh fh2 = fh.a();
        HashMap hashMap7 = new HashMap();
        if (fh2.a != null) {
            String string2 = fh2.a != false ? "1" : "0";
            TapjoyUtil.safePut((Map)hashMap7, (String)"gdpr", (String)string2, (boolean)true);
        }
        if (!aq.a((CharSequence)fh2.b)) {
            TapjoyUtil.safePut((Map)hashMap7, (String)"cgdpr", (String)fh2.b, (boolean)true);
        }
        hashMap2.putAll((Map)hashMap7);
        if (TapjoyCache.getInstance() != null && TapjoyCache.getInstance().getCachedOfferIDs() != null && TapjoyCache.getInstance().getCachedOfferIDs().length() > 0) {
            TapjoyUtil.safePut((Map)hashMap2, (String)"cached_ids", (String)TapjoyCache.getInstance().getCachedOfferIDs(), (boolean)true);
        }
        TapjoyUtil.safePut((Map)hashMap2, (String)"display_multiplier", (String)Float.toString((float)Q), (boolean)true);
        hashMap.putAll((Map)hashMap2);
        HashMap hashMap8 = new HashMap();
        TapjoyConnectCore.g();
        HashMap hashMap9 = new HashMap();
        TapjoyUtil.safePut((Map)hashMap9, (String)"analytics_id", (String)ah, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap9, (String)"pkg_id", (String)ai, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap9, (String)"pkg_sign", (String)aj, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap9, (String)"display_d", (Number)aJ);
        TapjoyUtil.safePut((Map)hashMap9, (String)"display_w", (Number)aK);
        TapjoyUtil.safePut((Map)hashMap9, (String)"display_h", (Number)aL);
        TapjoyUtil.safePut((Map)hashMap9, (String)"country_sim", (String)aM, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap9, (String)"timezone", (String)aN, (boolean)true);
        hashMap8.putAll((Map)hashMap9);
        HashMap hashMap10 = new HashMap();
        TapjoyUtil.safePut((Map)hashMap10, (String)"pkg_ver", (String)ak, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap10, (String)"pkg_rev", (Number)al);
        TapjoyUtil.safePut((Map)hashMap10, (String)"pkg_data_ver", (String)am, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap10, (String)"installer", (String)an, (boolean)true);
        if (ct.c((String)K)) {
            TapjoyUtil.safePut((Map)hashMap10, (String)"store_name", (String)aO, (boolean)true);
        }
        hashMap8.putAll((Map)hashMap10);
        hashMap8.putAll(TapjoyConnectCore.f());
        hashMap.putAll((Map)hashMap8);
        return hashMap;
    }

    private static boolean e(String string) {
        return ac.checkPermission(string, g.getPackageName()) == 0;
    }

    private static Map f() {
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut((Map)hashMap, (String)"installed", (Number)ao);
        TapjoyUtil.safePut((Map)hashMap, (String)"referrer", (String)ap, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap, (String)"user_level", (Number)aq);
        TapjoyUtil.safePut((Map)hashMap, (String)"friend_count", (Number)ar);
        TapjoyUtil.safePut((Map)hashMap, (String)"uv1", (String)as, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap, (String)"uv2", (String)at, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap, (String)"uv3", (String)au, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap, (String)"uv4", (String)av, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap, (String)"uv5", (String)aw, (boolean)true);
        Iterator iterator = ax.iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            StringBuilder stringBuilder = new StringBuilder("user_tags[");
            int n3 = n2 + 1;
            stringBuilder.append(n2);
            stringBuilder.append("]");
            TapjoyUtil.safePut((Map)hashMap, (String)stringBuilder.toString(), (String)string, (boolean)true);
            n2 = n3;
        }
        TapjoyUtil.safePut((Map)hashMap, (String)"fq7", (Number)ay);
        TapjoyUtil.safePut((Map)hashMap, (String)"fq30", (Number)az);
        TapjoyUtil.safePut((Map)hashMap, (String)"session_total_count", (Number)aA);
        TapjoyUtil.safePut((Map)hashMap, (String)"session_total_length", (Number)aB);
        TapjoyUtil.safePut((Map)hashMap, (String)"session_last_at", (Number)aC);
        TapjoyUtil.safePut((Map)hashMap, (String)"session_last_length", (Number)aD);
        TapjoyUtil.safePut((Map)hashMap, (String)"purchase_currency", (String)aE, (boolean)true);
        TapjoyUtil.safePut((Map)hashMap, (String)"purchase_total_count", (Number)aF);
        TapjoyUtil.safePut((Map)hashMap, (String)"purchase_total_price", (Number)aG);
        TapjoyUtil.safePut((Map)hashMap, (String)"purchase_last_price", (Number)aH);
        TapjoyUtil.safePut((Map)hashMap, (String)"purchase_last_at", (Number)aI);
        return hashMap;
    }

    private static void g() {
        ee ee2 = gc.a((Context)g).a(true);
        ed ed2 = ee2.d;
        ah = ed2.h;
        ai = ed2.r;
        aj = ed2.s;
        aJ = ed2.m;
        aK = ed2.n;
        aL = ed2.o;
        aM = ed2.u;
        aN = ed2.q;
        dx dx2 = ee2.e;
        ak = dx2.e;
        al = dx2.f;
        am = dx2.g;
        an = dx2.h;
        aO = dx2.i;
        ek ek2 = ee2.f;
        ao = ek2.s;
        ap = ek2.t;
        aq = ek2.J;
        ar = ek2.K;
        as = ek2.L;
        at = ek2.M;
        au = ek2.N;
        av = ek2.O;
        aw = ek2.P;
        ax = new HashSet((Collection)ek2.Q);
        ay = ek2.u;
        az = ek2.v;
        aA = ek2.x;
        aB = ek2.y;
        aC = ek2.z;
        aD = ek2.A;
        aE = ek2.B;
        aF = ek2.C;
        aG = ek2.D;
        aH = ek2.F;
        aI = ek2.E;
    }

    public static String getAndroidID() {
        return n;
    }

    public static String getAppID() {
        return v;
    }

    public static String getAwardCurrencyVerifier(long l2, int n2, String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(v);
            stringBuilder.append(":");
            stringBuilder.append(TapjoyConnectCore.o());
            stringBuilder.append(":");
            stringBuilder.append(l2);
            stringBuilder.append(":");
            stringBuilder.append(L);
            stringBuilder.append(":");
            stringBuilder.append(n2);
            stringBuilder.append(":");
            stringBuilder.append(string);
            String string2 = TapjoyUtil.SHA256((String)stringBuilder.toString());
            return string2;
        }
        catch (Exception exception) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            StringBuilder stringBuilder = new StringBuilder("Error in computing awardCurrencyVerifier -- ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TapjoyConnect", (TapjoyErrorMessage)new TapjoyErrorMessage(errorType, stringBuilder.toString()));
            return "";
        }
    }

    public static String getCarrierName() {
        return E;
    }

    public static String getConnectFlagValue(String string) {
        Hashtable hashtable = ae;
        if (hashtable != null && hashtable.get((Object)string) != null) {
            return ae.get((Object)string).toString();
        }
        return "";
    }

    public static String getConnectURL() {
        return "https://connect.tapjoy.com/";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String getConnectionSubType() {
        String string = "";
        ConnectivityManager connectivityManager = (ConnectivityManager)g.getSystemService("connectivity");
        if (connectivityManager == null) return string;
        try {
            string = connectivityManager.getActiveNetworkInfo().getSubtypeName();
            StringBuilder stringBuilder = new StringBuilder("connection_sub_type: ");
            stringBuilder.append(string);
            TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
            return string;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("getConnectionSubType error: ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TapjoyConnect", (String)stringBuilder.toString());
        }
        return string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getConnectionType() {
        String string = "";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager)g.getSystemService("connectivity");
            if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) return string;
            {
                int n2 = connectivityManager.getActiveNetworkInfo().getType();
                string = n2 != 1 && n2 != 6 ? "mobile" : "wifi";
                StringBuilder stringBuilder = new StringBuilder("connectivity: ");
                stringBuilder.append(connectivityManager.getActiveNetworkInfo().getType());
                TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder("connection_type: ");
                stringBuilder2.append(string);
                TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder2.toString());
                return string;
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("getConnectionType error: ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TapjoyConnect", (String)stringBuilder.toString());
        }
        return string;
    }

    public static Context getContext() {
        return g;
    }

    public static float getDeviceScreenDensityScale() {
        return A;
    }

    public static Map getGenericURLParams() {
        Map map = TapjoyConnectCore.e();
        TapjoyUtil.safePut((Map)map, (String)"app_id", (String)v, (boolean)true);
        return map;
    }

    public static String getHostURL() {
        return TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_SERVICE_URL");
    }

    public static TapjoyConnectCore getInstance() {
        return i;
    }

    public static String getMacAddress() {
        return p;
    }

    public static String getPlacementURL() {
        return TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_PLACEMENT_SERVICE_URL");
    }

    public static String getRedirectDomain() {
        return P;
    }

    public static String getSecretKey() {
        return L;
    }

    public static String getSha1MacAddress() {
        try {
            String string = TapjoyUtil.SHA1((String)p);
            return string;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("Error generating sha1 of macAddress: ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TapjoyConnect", (String)stringBuilder.toString());
            return null;
        }
    }

    public static String getSupportURL(String string) {
        if (string == null) {
            string = v;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TapjoyConnectCore.getHostURL());
        stringBuilder.append("support_requests/new?currency_id=");
        stringBuilder.append(string);
        stringBuilder.append("&app_id=");
        stringBuilder.append(v);
        stringBuilder.append("&udid=");
        stringBuilder.append(V);
        stringBuilder.append("&language_code=");
        stringBuilder.append(Locale.getDefault().getLanguage());
        return stringBuilder.toString();
    }

    public static Map getTimeStampAndVerifierParams() {
        long l2 = System.currentTimeMillis() / 1000L;
        String string = TapjoyConnectCore.a(l2);
        HashMap hashMap = new HashMap();
        TapjoyUtil.safePut((Map)hashMap, (String)"timestamp", (String)String.valueOf((long)l2), (boolean)true);
        TapjoyUtil.safePut((Map)hashMap, (String)"verifier", (String)string, (boolean)true);
        return hashMap;
    }

    public static Map getURLParams() {
        Map map = TapjoyConnectCore.getGenericURLParams();
        map.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        return map;
    }

    public static String getUserID() {
        return C;
    }

    private static void h() {
        TapjoyLog.i((String)"TapjoyConnect", (String)"Connect Flags:");
        TapjoyLog.i((String)"TapjoyConnect", (String)"--------------------");
        for (Map.Entry entry : ae.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder("key: ");
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append(", value: ");
            stringBuilder.append(Uri.encode((String)entry.getValue().toString()));
            TapjoyLog.i((String)"TapjoyConnect", (String)stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder("hostURL: [");
        stringBuilder.append(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_SERVICE_URL"));
        stringBuilder.append("]");
        TapjoyLog.i((String)"TapjoyConnect", (String)stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder("redirectDomain: [");
        stringBuilder2.append(P);
        stringBuilder2.append("]");
        TapjoyLog.i((String)"TapjoyConnect", (String)stringBuilder2.toString());
        TapjoyLog.i((String)"TapjoyConnect", (String)"--------------------");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void i() {
        String[] arrstring;
        int n2;
        ApplicationInfo applicationInfo;
        int n3;
        try {
            block9 : {
                block8 : {
                    if (ac == null) break block8;
                    applicationInfo = ac.getApplicationInfo(g.getPackageName(), 128);
                    if (applicationInfo != null && applicationInfo.metaData != null) break block9;
                    TapjoyLog.d((String)"TapjoyConnect", (String)"No metadata present.");
                }
                return;
            }
            arrstring = TapjoyConnectFlag.FLAG_ARRAY;
            n3 = arrstring.length;
            n2 = 0;
        }
        catch (Exception exception) {
            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SDK_ERROR;
            StringBuilder stringBuilder = new StringBuilder("Error reading manifest meta-data -- ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TapjoyConnect", (TapjoyErrorMessage)new TapjoyErrorMessage(errorType, stringBuilder.toString()));
            return;
        }
        do {
            if (n2 >= n3) {
                TapjoyLog.d((String)"TapjoyConnect", (String)"Metadata successfully loaded");
                return;
            }
            String string = arrstring[n2];
            Bundle bundle = applicationInfo.metaData;
            StringBuilder stringBuilder = new StringBuilder("tapjoy.");
            stringBuilder.append(string);
            String string2 = bundle.getString(stringBuilder.toString());
            if (string2 != null) {
                StringBuilder stringBuilder2 = new StringBuilder("Found manifest flag: ");
                stringBuilder2.append(string);
                stringBuilder2.append(", ");
                stringBuilder2.append(string2);
                TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder2.toString());
                TapjoyConnectCore.a(string, string2);
            }
            ++n2;
        } while (true);
    }

    public static boolean isConnected() {
        return ab;
    }

    public static boolean isFullScreenViewOpen() {
        Iterator iterator = ag.values().iterator();
        while (iterator.hasNext()) {
            int n2 = (Integer)iterator.next();
            if (n2 != 1 && n2 != 2) continue;
            return true;
        }
        return false;
    }

    public static boolean isUnitTestMode() {
        return TapjoyConnectCore.getConnectFlagValue("unit_test_mode") == "true";
    }

    public static boolean isViewOpen() {
        StringBuilder stringBuilder = new StringBuilder("isViewOpen: ");
        stringBuilder.append(ag.size());
        TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
        return !ag.isEmpty();
    }

    /*
     * Exception decompiling
     */
    private void j() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl318.1 : ALOAD : trying to set 1 previously set to 0
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

    private static void k() {
        Vector vector = new Vector();
        String[] arrstring = TapjoyConstants.dependencyPermissions;
        int n2 = arrstring.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string = arrstring[i2];
            if (TapjoyConnectCore.e(string)) continue;
            vector.add((Object)string);
        }
        if (vector.size() != 0) {
            if (vector.size() == 1) {
                StringBuilder stringBuilder = new StringBuilder("Missing 1 permission in manifest: ");
                stringBuilder.append(vector.toString());
                throw new TapjoyIntegrationException(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder("Missing ");
            stringBuilder.append(vector.size());
            stringBuilder.append(" permissions in manifest: ");
            stringBuilder.append(vector.toString());
            throw new TapjoyIntegrationException(stringBuilder.toString());
        }
        Vector vector2 = new Vector();
        String[] arrstring2 = TapjoyConstants.optionalPermissions;
        int n4 = arrstring2.length;
        while (n3 < n4) {
            String string = arrstring2[n3];
            if (!TapjoyConnectCore.e(string)) {
                vector2.add((Object)string);
            }
            ++n3;
        }
        if (vector2.size() != 0) {
            if (vector2.size() == 1) {
                StringBuilder stringBuilder = new StringBuilder("WARNING -- ");
                stringBuilder.append(vector2.toString());
                stringBuilder.append(" permission was not found in manifest. The exclusion of this permission could cause problems.");
                TapjoyLog.w((String)"TapjoyConnect", (String)stringBuilder.toString());
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("WARNING -- ");
            stringBuilder.append(vector2.toString());
            stringBuilder.append(" permissions were not found in manifest. The exclusion of these permissions could cause problems.");
            TapjoyLog.w((String)"TapjoyConnect", (String)stringBuilder.toString());
        }
    }

    private static boolean l() {
        String string = c;
        return string != null && string.length() > 0;
    }

    private static boolean m() {
        return TapjoyConnectCore.l() && TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS") != null && TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISABLE_PERSISTENT_IDS").equals((Object)"true");
    }

    private static String n() {
        TapjoyLog.i((String)"TapjoyConnect", (String)"generating sessionID...");
        String string = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis() / 1000L);
            stringBuilder.append(v);
            string = TapjoyUtil.SHA256((String)stringBuilder.toString());
            Z = System.currentTimeMillis();
            return string;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("unable to generate session id: ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e((String)"TapjoyConnect", (String)stringBuilder.toString());
            return string;
        }
    }

    private static String o() {
        if (TapjoyConnectCore.m()) {
            return c;
        }
        String string = p;
        boolean bl = true;
        boolean bl2 = string != null && string.length() > 0;
        if (bl2) {
            return p;
        }
        if (TapjoyConnectCore.l()) {
            return c;
        }
        String string2 = n;
        if (string2 == null || string2.length() <= 0) {
            bl = false;
        }
        if (bl) {
            return n;
        }
        TapjoyLog.e((String)"TapjoyConnect", (String)"Error -- no valid device identifier");
        return null;
    }

    private static String p() {
        String string;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(v);
        stringBuilder.append(w);
        stringBuilder.append(x);
        stringBuilder.append(c);
        stringBuilder.append(q);
        string = stringBuilder.toString();
        try {
            string = TapjoyUtil.SHA1((String)string);
        }
        catch (Exception exception) {}
        return string;
    }

    public static void requestTapjoyConnect(Context context, String string) {
        TapjoyConnectCore.requestTapjoyConnect(context, string, null);
    }

    public static void requestTapjoyConnect(Context context, String string, Hashtable hashtable) {
        TapjoyConnectCore.requestTapjoyConnect(context, string, hashtable, null);
    }

    public static void requestTapjoyConnect(Context context, String string, Hashtable hashtable, TJConnectListener tJConnectListener) {
        block4 : {
            er er2;
            try {
                er2 = new er(string);
                er.a a2 = er2.a;
                er.a a3 = er.a.SDK_ANDROID;
                if (a2 != a3) break block4;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new TapjoyIntegrationException(illegalArgumentException.getMessage());
            }
            h = string;
            v = er2.b;
            L = er2.c;
            M = er2.d;
            if (hashtable != null) {
                ae.putAll((Map)hashtable);
                fd.b().a(hashtable);
            }
            gc.a((Context)context).j = string;
            k = tJConnectListener;
            i = new TapjoyConnectCore(context);
            return;
        }
        throw new IllegalArgumentException("The given API key was not for Android.");
    }

    public static void setPlugin(String string) {
        N = string;
    }

    public static void setSDKType(String string) {
        O = string;
    }

    public static void setUserID(String string, TJSetUserIDListener tJSetUserIDListener) {
        C = string;
        l = tJSetUserIDListener;
        StringBuilder stringBuilder = new StringBuilder("URL parameters: ");
        stringBuilder.append((Object)TapjoyConnectCore.getURLParams());
        TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
        new Thread(new Runnable(){

            public final void run() {
                StringBuilder stringBuilder = new StringBuilder("Setting userID to ");
                stringBuilder.append(C);
                TapjoyLog.i((String)"TapjoyConnect", (String)stringBuilder.toString());
                TapjoyURLConnection tapjoyURLConnection = j;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(TapjoyConnectCore.getHostURL());
                stringBuilder2.append("set_publisher_user_id?");
                TapjoyHttpURLResponse tapjoyHttpURLResponse = tapjoyURLConnection.getResponseFromURL(stringBuilder2.toString(), TapjoyConnectCore.getURLParams());
                boolean bl = tapjoyHttpURLResponse.response != null ? TapjoyConnectCore.a(tapjoyHttpURLResponse.response) : false;
                TapjoyConnectCore.a(bl);
            }
        }).start();
    }

    public static void setViewShowing(boolean bl) {
        if (bl) {
            ag.put((Object)"", (Object)1);
            return;
        }
        ag.clear();
    }

    public static void viewDidClose(String string) {
        StringBuilder stringBuilder = new StringBuilder("viewDidClose: ");
        stringBuilder.append(string);
        TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
        ag.remove((Object)string);
        ev.e.notifyObservers();
    }

    public static void viewWillOpen(String string, int n2) {
        StringBuilder stringBuilder = new StringBuilder("viewWillOpen: ");
        stringBuilder.append(string);
        TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder.toString());
        ag.put((Object)string, (Object)n2);
    }

    public void actionComplete(String string) {
        StringBuilder stringBuilder = new StringBuilder("actionComplete: ");
        stringBuilder.append(string);
        TapjoyLog.i((String)"TapjoyConnect", (String)stringBuilder.toString());
        Map map = TapjoyConnectCore.e();
        TapjoyUtil.safePut((Map)map, (String)"app_id", (String)string, (boolean)true);
        map.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        StringBuilder stringBuilder2 = new StringBuilder("PPA URL parameters: ");
        stringBuilder2.append((Object)map);
        TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder2.toString());
        new Thread((Runnable)new PPAThread(map)).start();
    }

    public void appPause() {
        this.Y = true;
    }

    public void appResume() {
        if (this.Y) {
            TapjoyConnectCore.n();
            this.Y = false;
        }
    }

    public void callConnect() {
        this.fetchAdvertisingID();
    }

    public void completeConnectCall() {
        String string;
        boolean bl;
        TapjoyLog.d((String)"TapjoyConnect", (String)"starting connect call...");
        String string2 = TapjoyConnectCore.getHostURL() != "https://ws.tapjoyads.com/" ? TapjoyConnectCore.getHostURL() : "https://connect.tapjoy.com/";
        if (!TapjoyConnectCore.isConnected() && (string = TapjoyAppSettings.getInstance().getConnectResult(TapjoyConnectCore.p(), y.b())) != null && TapjoyConnectCore.a(string, true)) {
            TapjoyLog.i((String)"TapjoyConnect", (String)"Connect using stored connect result");
            ab = true;
            TJConnectListener tJConnectListener = k;
            if (tJConnectListener != null) {
                tJConnectListener.onConnectSuccess();
            }
            ev.a.notifyObservers();
            bl = true;
        } else {
            bl = false;
        }
        TapjoyURLConnection tapjoyURLConnection = j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("api/connect/v3.json?");
        TapjoyHttpURLResponse tapjoyHttpURLResponse = tapjoyURLConnection.getResponseFromURL(stringBuilder.toString(), null, null, TapjoyConnectCore.getURLParams());
        if (tapjoyHttpURLResponse != null && tapjoyHttpURLResponse.statusCode == 200) {
            if (TapjoyConnectCore.a(tapjoyHttpURLResponse.response, false)) {
                TapjoyLog.i((String)"TapjoyConnect", (String)"Successfully connected to Tapjoy");
                ab = true;
                for (Map.Entry entry : TapjoyConnectCore.getGenericURLParams().entrySet()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append((String)entry.getKey());
                    stringBuilder2.append(": ");
                    stringBuilder2.append((String)entry.getValue());
                    TapjoyLog.d((String)"TapjoyConnect", (String)stringBuilder2.toString());
                }
                if (!bl) {
                    TJConnectListener tJConnectListener = k;
                    if (tJConnectListener != null) {
                        tJConnectListener.onConnectSuccess();
                    }
                    ev.a.notifyObservers();
                }
                ev.b.notifyObservers((Object)Boolean.TRUE);
            } else {
                if (!bl) {
                    TapjoyConnectCore.d();
                }
                ev.b.notifyObservers((Object)Boolean.FALSE);
            }
            if (af.length() > 0) {
                Map map = TapjoyConnectCore.getGenericURLParams();
                TapjoyUtil.safePut((Map)map, (String)"package_names", (String)af, (boolean)true);
                long l2 = System.currentTimeMillis() / 1000L;
                String string3 = TapjoyConnectCore.a(l2, af);
                TapjoyUtil.safePut((Map)map, (String)"timestamp", (String)String.valueOf((long)l2), (boolean)true);
                TapjoyUtil.safePut((Map)map, (String)"verifier", (String)string3, (boolean)true);
                TapjoyURLConnection tapjoyURLConnection2 = new TapjoyURLConnection();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(TapjoyConnectCore.getHostURL());
                stringBuilder3.append("apps_installed?");
                TapjoyHttpURLResponse tapjoyHttpURLResponse2 = tapjoyURLConnection2.getResponseFromURL(stringBuilder3.toString(), map);
                if (tapjoyHttpURLResponse2 != null && tapjoyHttpURLResponse2.statusCode == 200) {
                    TapjoyLog.d((String)"TapjoyConnect", (String)"Successfully pinged sdkless api.");
                }
                return;
            }
        } else {
            if (!bl) {
                TapjoyConnectCore.d();
            }
            ev.b.notifyObservers((Object)Boolean.FALSE);
        }
    }

    public void fetchAdvertisingID() {
        new Thread(new Runnable(){

            public final void run() {
                TapjoyConnectCore.this.ad.loadAdvertisingId();
                if (TapjoyConnectCore.this.ad.isGooglePlayServicesAvailable() && TapjoyConnectCore.this.ad.isGooglePlayManifestConfigured()) {
                    TapjoyConnectCore.b = TapjoyConnectCore.this.ad.getDeviceGooglePlayServicesVersion();
                    TapjoyConnectCore.a = TapjoyConnectCore.this.ad.getPackagedGooglePlayServicesVersion();
                }
                if (TapjoyConnectCore.this.ad.isAdIdAvailable()) {
                    TapjoyConnectCore.d = TapjoyConnectCore.this.ad.isAdTrackingEnabled();
                    TapjoyConnectCore.c = TapjoyConnectCore.this.ad.getAdvertisingId();
                    gc gc2 = gc.a();
                    String string = TapjoyConnectCore.c;
                    boolean bl = true ^ TapjoyConnectCore.d;
                    gf gf2 = gc2.f;
                    String string2 = gf2.c.A.a();
                    gf2.b.q = string;
                    gf2.b.r = bl;
                    gf2.c.A.a(string);
                    gf2.c.B.a(bl);
                    gq.a((String)string, (boolean)bl);
                    if (!ct.c((String)string2) && !string.equals((Object)string2)) {
                        gf2.c.a(false);
                    }
                }
                if (TapjoyConnectCore.m()) {
                    TapjoyLog.i((String)"TapjoyConnect", (String)"Disabling persistent IDs. Do this only if you are not using Tapjoy to manage currency.");
                }
                TapjoyConnectCore.this.completeConnectCall();
            }
        }).start();
    }

    public float getCurrencyMultiplier() {
        return Q;
    }

    public boolean isInitialized() {
        return this.aa;
    }

    public void release() {
        i = null;
        j = null;
        TapjoyLog.d((String)"TapjoyConnect", (String)"Releasing core static instance.");
    }

    public void setCurrencyMultiplier(float f2) {
        StringBuilder stringBuilder = new StringBuilder("setVirtualCurrencyMultiplier: ");
        stringBuilder.append(f2);
        TapjoyLog.i((String)"TapjoyConnect", (String)stringBuilder.toString());
        Q = f2;
    }

    public class PPAThread
    implements Runnable {
        private Map b;

        public PPAThread(Map map) {
            this.b = map;
        }

        public void run() {
            TapjoyURLConnection tapjoyURLConnection = j;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(TapjoyConnectCore.getHostURL());
            stringBuilder.append("api/connect/v3.json?");
            TapjoyHttpURLResponse tapjoyHttpURLResponse = tapjoyURLConnection.getResponseFromURL(stringBuilder.toString(), null, null, this.b);
            if (tapjoyHttpURLResponse.response != null) {
                TapjoyConnectCore.c(tapjoyHttpURLResponse.response);
            }
        }
    }

}

