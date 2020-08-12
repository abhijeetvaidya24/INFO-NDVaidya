/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.moat.analytics.mobile.aer;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.az;
import com.moat.analytics.mobile.aer.ba;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.l;
import com.moat.analytics.mobile.aer.m;
import com.moat.analytics.mobile.aer.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class bb
implements ba,
m {
    private View a;
    private final WebView b;
    private boolean c;
    private final l d;
    private final com.moat.analytics.mobile.aer.a e;
    private final al f;
    private com.moat.analytics.mobile.aer.base.functional.a<String> g;

    bb(View view, WebView webView, boolean bl, com.moat.analytics.mobile.aer.a a2, al al2) {
        this(view, webView, bl, new n(webView.getContext(), al2), a2, al2);
    }

    bb(View view, WebView webView, boolean bl, l l2, com.moat.analytics.mobile.aer.a a2, al al2) {
        com.moat.analytics.mobile.aer.base.asserts.a.a((Object)view);
        com.moat.analytics.mobile.aer.base.asserts.a.a((Object)webView);
        com.moat.analytics.mobile.aer.base.asserts.a.a(a2);
        com.moat.analytics.mobile.aer.base.asserts.a.a(l2);
        if (al2.b()) {
            Log.d((String)"MoatViewTracker", (String)"In initialization method.");
        }
        this.e = a2;
        this.a = view;
        this.b = webView;
        this.c = bl;
        this.d = l2;
        this.f = al2;
        this.g = com.moat.analytics.mobile.aer.base.functional.a.a();
    }

    private static String a(Rect rect) {
        int n2 = rect.left;
        int n3 = rect.top;
        int n4 = rect.right - rect.left;
        int n5 = rect.bottom - rect.top;
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append('\"');
        stringBuilder.append("x");
        stringBuilder.append('\"');
        stringBuilder.append(":");
        stringBuilder.append(n2);
        stringBuilder.append(',');
        stringBuilder.append('\"');
        stringBuilder.append("y");
        stringBuilder.append('\"');
        stringBuilder.append(":");
        stringBuilder.append(n3);
        stringBuilder.append(',');
        stringBuilder.append('\"');
        stringBuilder.append("w");
        stringBuilder.append('\"');
        stringBuilder.append(":");
        stringBuilder.append(n4);
        stringBuilder.append(',');
        stringBuilder.append('\"');
        stringBuilder.append("h");
        stringBuilder.append('\"');
        stringBuilder.append(":");
        stringBuilder.append(n5);
        stringBuilder.append('}');
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append((Object)stringBuilder);
        stringBuilder2.append("");
        return stringBuilder2.toString();
    }

    private static String a(Map<String, String> map, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (Map.Entry entry : map.entrySet()) {
            String string = (String)entry.getKey();
            String string2 = (String)entry.getValue();
            if (stringBuilder.length() > 1) {
                stringBuilder.append(',');
            }
            stringBuilder.append('\"');
            stringBuilder.append(string);
            stringBuilder.append('\"');
            stringBuilder.append(':');
            if (!bl) {
                stringBuilder.append(string2);
                continue;
            }
            stringBuilder.append('\"');
            stringBuilder.append(string2);
            stringBuilder.append('\"');
        }
        stringBuilder.append("}");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("");
        stringBuilder2.append((Object)stringBuilder);
        return stringBuilder2.toString();
    }

    private void a(Map<String, String> map, String string, Rect rect) {
        map.put((Object)string, (Object)bb.a(this.b(rect)));
    }

    private Rect b(Rect rect) {
        float f2 = this.h().density;
        if (f2 == 0.0f) {
            return rect;
        }
        int n2 = Math.round((float)((float)rect.left / f2));
        int n3 = Math.round((float)((float)rect.right / f2));
        return new Rect(n2, Math.round((float)((float)rect.top / f2)), n3, Math.round((float)((float)rect.bottom / f2)));
    }

    private Rect c(Rect rect) {
        Rect rect2 = this.i();
        this.a.getGlobalVisibleRect(rect2);
        rect2.left = Math.min((int)Math.max((int)0, (int)rect2.left), (int)rect.right);
        rect2.right = Math.min((int)Math.max((int)0, (int)rect2.right), (int)rect.right);
        rect2.top = Math.min((int)Math.max((int)0, (int)rect2.top), (int)rect.bottom);
        rect2.bottom = Math.min((int)Math.max((int)0, (int)rect2.bottom), (int)rect.bottom);
        return rect2;
    }

    private String e() {
        if (this.g.c()) {
            return this.g.b();
        }
        String string = "_unknown_";
        try {
            Context context = this.b.getContext();
            string = context.getPackageManager().getApplicationLabel(context.getApplicationContext().getApplicationInfo()).toString();
            this.g = com.moat.analytics.mobile.aer.base.functional.a.a(string);
            return string;
        }
        catch (Exception exception) {
            a.a(exception);
            return string;
        }
    }

    private boolean f() {
        return this.a.isShown() && !this.e.a();
    }

    private Rect g() {
        DisplayMetrics displayMetrics = this.h();
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private DisplayMetrics h() {
        return this.a.getContext().getResources().getDisplayMetrics();
    }

    private Rect i() {
        return new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    /*
     * Exception decompiling
     */
    @Override
    public az a(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl110 : NEW : trying to set 1 previously set to 0
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

    @Override
    public String a() {
        try {
            String string = bb.a(this.d(), true);
            return string;
        }
        catch (Exception exception) {
            return "{}";
        }
    }

    @Override
    public void a(View view) {
        if (this.f.b()) {
            String string;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("changing view to ");
            if (view != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(view.getClass().getSimpleName());
                stringBuilder2.append("@");
                stringBuilder2.append(view.hashCode());
                string = stringBuilder2.toString();
            } else {
                string = "null";
            }
            stringBuilder.append(string);
            Log.d((String)"MoatViewTracker", (String)stringBuilder.toString());
        }
        this.a = view;
    }

    @Override
    public boolean b() {
        if (this.f.b()) {
            Log.d((String)"MoatViewTracker", (String)"Attempting bridge installation.");
        }
        boolean bl = this.d.a("moat-bridge", this.b, this);
        if (this.f.b()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bridge ");
            String string = bl ? "" : "not ";
            stringBuilder.append(string);
            stringBuilder.append("installed.");
            Log.d((String)"MoatViewTracker", (String)stringBuilder.toString());
        }
        return bl;
    }

    @Override
    public Rect c() {
        int[] arrn = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.a.getLocationInWindow(arrn);
        int n2 = arrn[0];
        int n3 = arrn[1];
        return new Rect(n2, n3, n2 + this.a.getWidth(), n3 + this.a.getHeight());
    }

    public Map<String, String> d() {
        HashMap hashMap = new HashMap();
        String string = this.e();
        String string2 = Integer.toString((int)Build.VERSION.SDK_INT);
        String string3 = this.c ? "1" : "0";
        hashMap.put((Object)"versionHash", (Object)"481942b5989dff650ea9b6e20f5b140729ba4512");
        hashMap.put((Object)"appName", (Object)string);
        hashMap.put((Object)"namespace", (Object)"AER");
        hashMap.put((Object)"version", (Object)"1.7.5");
        hashMap.put((Object)"deviceOS", (Object)string2);
        hashMap.put((Object)"isNative", (Object)string3);
        return hashMap;
    }
}

