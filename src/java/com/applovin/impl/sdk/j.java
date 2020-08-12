/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.preference.PreferenceManager
 *  android.text.TextUtils
 *  android.util.Log
 *  com.applovin.impl.sdk.AppLovinAdServiceImpl
 *  com.applovin.impl.sdk.EventServiceImpl
 *  com.applovin.impl.sdk.NativeAdServiceImpl
 *  com.applovin.impl.sdk.SdkConfigurationImpl
 *  com.applovin.impl.sdk.UserServiceImpl
 *  com.applovin.impl.sdk.VariableServiceImpl
 *  com.applovin.impl.sdk.d
 *  com.applovin.impl.sdk.d.k
 *  com.applovin.impl.sdk.i
 *  com.applovin.impl.sdk.network.PostbackServiceImpl
 *  com.applovin.impl.sdk.q
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.Iterator
 *  java.util.List
 */
package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.EventServiceImpl;
import com.applovin.impl.sdk.NativeAdServiceImpl;
import com.applovin.impl.sdk.SdkConfigurationImpl;
import com.applovin.impl.sdk.UserServiceImpl;
import com.applovin.impl.sdk.VariableServiceImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.c;
import com.applovin.impl.sdk.c.f;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.e.l;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.i;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.network.d;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.q;
import com.applovin.impl.sdk.t;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinUserService;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class j {
    protected static Context a;
    private c A;
    private t B;
    private com.applovin.impl.sdk.a C;
    private o D;
    private PostbackServiceImpl E;
    private d F;
    private MediationServiceImpl G;
    private final Object H = new Object();
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private AppLovinSdk.SdkInitializationListener M;
    private AppLovinSdk.SdkInitializationListener N;
    protected com.applovin.impl.sdk.b.c b;
    private String c;
    private WeakReference<Activity> d;
    private long e;
    private AppLovinSdkSettings f;
    private String g;
    private AppLovinAdServiceImpl h;
    private NativeAdServiceImpl i;
    private EventServiceImpl j;
    private UserServiceImpl k;
    private VariableServiceImpl l;
    private AppLovinSdk m;
    private p n;
    private com.applovin.impl.sdk.d.q o;
    private a p;
    private h q;
    private com.applovin.impl.sdk.c.j r;
    private k s;
    private com.applovin.impl.sdk.b.e t;
    private f u;
    private i v;
    private com.applovin.impl.sdk.d w;
    private q x;
    private n y;
    private e z;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void T() {
        try {
            try {
                if (this.b(com.applovin.impl.sdk.b.d.b, 0) < 90201) {
                    Log.i((String)"AppLovinSdk", (String)"SDK has been updated since last run. Continuing...");
                    this.v().c();
                    this.v().a();
                } else {
                    Log.d((String)"AppLovinSdk", (String)"SDK has not been updated since last run. Continuing...");
                }
            }
            catch (Exception exception) {
                this.u().b("AppLovinSdk", "Unable to check for SDK update", exception);
            }
        }
        catch (Throwable throwable2) {}
        this.a(com.applovin.impl.sdk.b.d.b, 90201);
        return;
        this.a(com.applovin.impl.sdk.b.d.b, 90201);
        throw throwable2;
    }

    public static Context x() {
        return a;
    }

    public boolean A() {
        return this.L;
    }

    public a B() {
        return this.p;
    }

    public com.applovin.impl.sdk.d.q C() {
        return this.o;
    }

    public h D() {
        return this.q;
    }

    public com.applovin.impl.sdk.c.j E() {
        return this.r;
    }

    public d F() {
        return this.F;
    }

    public k G() {
        return this.s;
    }

    public f H() {
        return this.u;
    }

    public i I() {
        return this.v;
    }

    public PostbackServiceImpl J() {
        return this.E;
    }

    public AppLovinSdk K() {
        return this.m;
    }

    public com.applovin.impl.sdk.d L() {
        return this.w;
    }

    public q M() {
        return this.x;
    }

    public n N() {
        return this.y;
    }

    public e O() {
        return this.z;
    }

    public c P() {
        return this.A;
    }

    public t Q() {
        return this.B;
    }

    public o R() {
        return this.D;
    }

    public com.applovin.impl.sdk.a S() {
        return this.C;
    }

    public MediationServiceImpl a(Activity activity) {
        this.G.maybeInitialize(activity);
        return this.G;
    }

    public <ST> b<ST> a(String string2, b<ST> b2) {
        return this.b.a(string2, b2);
    }

    public <T> T a(b<T> b2) {
        return this.b.a(b2);
    }

    public <T> T a(com.applovin.impl.sdk.b.d<T> d2) {
        return this.b(d2, null);
    }

    public <T> T a(String string2, T t2, Class class_, SharedPreferences sharedPreferences) {
        return this.t.a(string2, t2, class_, sharedPreferences);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object;
        Object object2 = object = this.H;
        synchronized (object2) {
            if (!this.I && !this.J) {
                this.b();
            }
            return;
        }
    }

    public void a(long l2) {
        this.v.a(l2);
    }

    public void a(SharedPreferences sharedPreferences) {
        this.t.a(sharedPreferences);
    }

    public <T> void a(com.applovin.impl.sdk.b.d<T> d2, T t2) {
        this.t.a(d2, t2);
    }

    public <T> void a(com.applovin.impl.sdk.b.d<T> d2, T t2, SharedPreferences sharedPreferences) {
        this.t.a(d2, t2, sharedPreferences);
    }

    public void a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        if (this.d()) {
            if (sdkInitializationListener != null) {
                sdkInitializationListener.onSdkInitialized((AppLovinSdkConfiguration)new SdkConfigurationImpl(this));
                return;
            }
        } else {
            this.M = sdkInitializationListener;
        }
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.m = appLovinSdk;
    }

    public void a(String string2) {
        this.b.a(b.el, string2);
        this.b.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.c = string2;
        this.e = System.currentTimeMillis();
        this.f = appLovinSdkSettings;
        a = context.getApplicationContext();
        if (context instanceof Activity) {
            this.d = new WeakReference((Object)((Activity)context));
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        try {
            try {
                this.n = new p(this);
                this.t = new com.applovin.impl.sdk.b.e(this);
                this.b = new com.applovin.impl.sdk.b.c(this);
                this.b.b();
                this.u = new f(this);
                this.u.b();
                this.T();
                this.y = new n(this);
                this.w = new com.applovin.impl.sdk.d(this);
                this.x = new q(this);
                this.z = new e(this);
                this.j = new EventServiceImpl(this);
                this.k = new UserServiceImpl(this);
                this.l = new VariableServiceImpl(this);
                this.A = new c(this);
                this.o = new com.applovin.impl.sdk.d.q(this);
                this.p = new a(this);
                this.q = new h(this);
                this.r = new com.applovin.impl.sdk.c.j(this);
                this.s = new k(this);
                this.C = new com.applovin.impl.sdk.a(this, context);
                this.h = new AppLovinAdServiceImpl(this);
                this.i = new NativeAdServiceImpl(this);
                this.B = new t(this);
                this.D = new o(this);
                this.E = new PostbackServiceImpl(this);
                this.F = new d(this);
                this.G = new MediationServiceImpl(this);
                this.v = new i(this);
                if (TextUtils.isEmpty((CharSequence)string2)) {
                    this.K = true;
                    Log.e((String)"AppLovinSdk", (String)"Unable to find AppLovin SDK key. Please add  meta-data android:name=\"applovin.sdk.key\" android:value=\"YOUR_SDK_KEY_HERE\" into AndroidManifest.xml.");
                    StringWriter stringWriter = new StringWriter();
                    new Throwable("").printStackTrace(new PrintWriter((Writer)stringWriter));
                    String string3 = stringWriter.toString();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Called with an invalid SDK key from: ");
                    stringBuilder.append(string3);
                    Log.e((String)"AppLovinSdk", (String)stringBuilder.toString());
                }
                if (!this.t()) {
                    SharedPreferences sharedPreferences;
                    String string4;
                    com.applovin.impl.sdk.b.e e2;
                    com.applovin.impl.sdk.b.d<String> d2;
                    if (this.b.a(b.ac).booleanValue()) {
                        appLovinSdkSettings.setTestAdsEnabled(m.b(context));
                        appLovinSdkSettings.setVerboseLogging(m.c(context));
                        this.v().a(appLovinSdkSettings);
                        this.v().a();
                    }
                    if (TextUtils.isEmpty((CharSequence)this.t.b(com.applovin.impl.sdk.b.d.a, null, sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)context)))) {
                        this.L = true;
                        e2 = this.t;
                        d2 = com.applovin.impl.sdk.b.d.a;
                        string4 = Boolean.toString((boolean)true);
                    } else {
                        e2 = this.t;
                        d2 = com.applovin.impl.sdk.b.d.a;
                        string4 = Boolean.toString((boolean)false);
                    }
                    e2.a(d2, string4, sharedPreferences);
                    if (TextUtils.isEmpty((CharSequence)this.a(com.applovin.impl.sdk.b.d.c))) {
                        int n2 = 1 + (int)(100.0 * Math.random());
                        this.a(com.applovin.impl.sdk.b.d.c, String.valueOf((int)n2));
                    }
                    this.b();
                } else {
                    this.a(false);
                }
            }
            catch (Throwable throwable3) {
                Log.e((String)"AppLovinSdk", (String)"Failed to load AppLovin SDK, ad serving will be disabled", (Throwable)throwable3);
                this.a(false);
            }
        }
        catch (Throwable throwable2) {}
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        return;
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        throw throwable2;
    }

    public <T> void a(String string2, T t2, SharedPreferences.Editor editor) {
        this.t.a(string2, t2, editor);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl) {
        Object object;
        Object object2 = object = this.H;
        synchronized (object2) {
            this.I = false;
            this.J = bl;
        }
        this.C().b();
    }

    public <T> T b(com.applovin.impl.sdk.b.d<T> d2, T t2) {
        return this.t.b(d2, t2);
    }

    public <T> T b(com.applovin.impl.sdk.b.d<T> d2, T t2, SharedPreferences sharedPreferences) {
        return this.t.b(d2, t2, sharedPreferences);
    }

    public List<String> b(b b2) {
        return this.b.b(b2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object;
        Object object2 = object = this.H;
        synchronized (object2) {
            this.I = true;
            this.C().a();
            com.applovin.impl.sdk.d.k k2 = new com.applovin.impl.sdk.d.k(this);
            this.C().a((com.applovin.impl.sdk.d.a)k2, q.a.a);
            return;
        }
    }

    public <T> void b(com.applovin.impl.sdk.b.d<T> d2) {
        this.t.a(d2);
    }

    public void b(String string2) {
        l.a(string2);
    }

    public void c(String string2) {
        this.g = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c() {
        Object object;
        Object object2 = object = this.H;
        synchronized (object2) {
            return this.I;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d() {
        Object object;
        Object object2 = object = this.H;
        synchronized (object2) {
            return this.J;
        }
    }

    public void e() {
        if (this.M != null) {
            this.n.a("AppLovinSdk", "Calling back publisher's initialization completion listener...");
            final AppLovinSdk.SdkInitializationListener sdkInitializationListener = this.M;
            if (this.d()) {
                this.M = null;
                this.N = null;
            } else {
                if (this.N == sdkInitializationListener) {
                    return;
                }
                if (this.a(b.ag).booleanValue()) {
                    this.M = null;
                } else {
                    this.N = sdkInitializationListener;
                }
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable(){

                public void run() {
                    SdkConfigurationImpl sdkConfigurationImpl = new SdkConfigurationImpl(j.this);
                    sdkInitializationListener.onSdkInitialized((AppLovinSdkConfiguration)sdkConfigurationImpl);
                }
            });
        }
    }

    public void f() {
        long l2 = this.q.b(g.g);
        this.b.c();
        this.b.a();
        this.q.a();
        this.A.b();
        this.r.b();
        this.q.b(g.g, l2 + 1L);
        this.b();
    }

    public boolean g() {
        Iterator iterator = com.applovin.impl.sdk.e.d.a(this.a(b.em)).iterator();
        while (iterator.hasNext()) {
            if (!((String)iterator.next()).equalsIgnoreCase(Build.MANUFACTURER)) continue;
            return true;
        }
        return false;
    }

    public void h() {
        this.B.a(a);
    }

    public boolean i() {
        return this.B.d();
    }

    boolean j() {
        return this.B.e();
    }

    public String k() {
        return l.a();
    }

    public AppLovinSdkSettings l() {
        return this.f;
    }

    public String m() {
        return this.g;
    }

    public AppLovinAdServiceImpl n() {
        return this.h;
    }

    public NativeAdServiceImpl o() {
        return this.i;
    }

    public AppLovinEventService p() {
        return this.j;
    }

    public AppLovinUserService q() {
        return this.k;
    }

    public VariableServiceImpl r() {
        return this.l;
    }

    public String s() {
        return this.c;
    }

    public boolean t() {
        return this.K;
    }

    public p u() {
        return this.n;
    }

    public com.applovin.impl.sdk.b.c v() {
        return this.b;
    }

    public Context w() {
        return a;
    }

    public Activity y() {
        WeakReference<Activity> weakReference = this.d;
        if (weakReference != null) {
            return (Activity)weakReference.get();
        }
        return null;
    }

    public long z() {
        return this.e;
    }

}

