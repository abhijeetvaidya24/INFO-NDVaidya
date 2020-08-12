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
package com.moat.analytics.mobile.tjy;

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
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.bh;
import com.moat.analytics.mobile.tjy.l;
import com.moat.analytics.mobile.tjy.m;
import com.moat.analytics.mobile.tjy.n;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class bi
implements bh,
m {
    private View a;
    private final WebView b;
    private boolean c;
    private final l d;
    private final com.moat.analytics.mobile.tjy.a e;
    private final ap f;
    private a g;

    bi(View view, WebView webView, boolean bl2, com.moat.analytics.mobile.tjy.a a2, ap ap2) {
        this(view, webView, bl2, new n(webView.getContext(), ap2), a2, ap2);
    }

    bi(View view, WebView webView, boolean bl2, l l2, com.moat.analytics.mobile.tjy.a a2, ap ap2) {
        com.moat.analytics.mobile.tjy.base.asserts.a.a((Object)view);
        com.moat.analytics.mobile.tjy.base.asserts.a.a((Object)webView);
        com.moat.analytics.mobile.tjy.base.asserts.a.a(a2);
        com.moat.analytics.mobile.tjy.base.asserts.a.a(l2);
        if (ap2.b()) {
            Log.d((String)"MoatViewTracker", (String)"In initialization method.");
        }
        this.e = a2;
        this.a = view;
        this.b = webView;
        this.c = bl2;
        this.d = l2;
        this.f = ap2;
        this.g = a.a();
    }

    private static String a(Rect rect) {
        int n2 = rect.left;
        int n3 = rect.top;
        int n4 = rect.right - rect.left;
        int n5 = rect.bottom - rect.top;
        StringBuilder stringBuilder = new StringBuilder("{\"x\":");
        stringBuilder.append(n2);
        stringBuilder.append(',');
        stringBuilder.append('\"');
        stringBuilder.append("y\":");
        stringBuilder.append(n3);
        stringBuilder.append(',');
        stringBuilder.append('\"');
        stringBuilder.append("w\":");
        stringBuilder.append(n4);
        stringBuilder.append(',');
        stringBuilder.append('\"');
        stringBuilder.append("h\":");
        stringBuilder.append(n5);
        stringBuilder.append('}');
        return String.valueOf((Object)stringBuilder);
    }

    private static String a(Map map, boolean bl2) {
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
            if (!bl2) {
                stringBuilder.append(string2);
                continue;
            }
            stringBuilder.append('\"');
            stringBuilder.append(string2);
            stringBuilder.append('\"');
        }
        stringBuilder.append("}");
        return String.valueOf((Object)stringBuilder);
    }

    private void a(Map map, String string, Rect rect) {
        map.put((Object)string, (Object)bi.a(this.b(rect)));
    }

    private Rect b(Rect rect) {
        float f2 = this.j().density;
        if (f2 == 0.0f) {
            return rect;
        }
        int n2 = Math.round((float)((float)rect.left / f2));
        int n3 = Math.round((float)((float)rect.right / f2));
        return new Rect(n2, Math.round((float)((float)rect.top / f2)), n3, Math.round((float)((float)rect.bottom / f2)));
    }

    private Rect c(Rect rect) {
        Rect rect2 = this.k();
        if (!this.a.getGlobalVisibleRect(rect2)) {
            rect2 = this.k();
        }
        rect2.left = Math.min((int)Math.max((int)0, (int)rect2.left), (int)rect.right);
        rect2.right = Math.min((int)Math.max((int)0, (int)rect2.right), (int)rect.right);
        rect2.top = Math.min((int)Math.max((int)0, (int)rect2.top), (int)rect.bottom);
        rect2.bottom = Math.min((int)Math.max((int)0, (int)rect2.bottom), (int)rect.bottom);
        return rect2;
    }

    private String g() {
        if (this.g.c()) {
            return (String)this.g.b();
        }
        String string = "_unknown_";
        try {
            Context context = this.b.getContext();
            string = context.getPackageManager().getApplicationLabel(context.getApplicationContext().getApplicationInfo()).toString();
            this.g = a.a(string);
            return string;
        }
        catch (Exception exception) {
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            return string;
        }
    }

    private boolean h() {
        return this.a.isShown() && !this.e.a();
    }

    private Rect i() {
        DisplayMetrics displayMetrics = this.j();
        return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private DisplayMetrics j() {
        return this.a.getContext().getResources().getDisplayMetrics();
    }

    private Rect k() {
        return new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public String a() {
        HashMap hashMap = new HashMap();
        try {
            Rect rect = this.i();
            Rect rect2 = this.c(rect);
            Rect rect3 = this.e();
            this.a((Map)hashMap, "screen", rect);
            this.a((Map)hashMap, "visible", rect2);
            this.a((Map)hashMap, "maybe", rect2);
            this.a((Map)hashMap, "view", rect3);
            int n2 = this.h() ? 1 : 0;
            hashMap.put((Object)"inFocus", (Object)String.valueOf((int)n2));
            DisplayMetrics displayMetrics = this.j();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(displayMetrics.density);
            hashMap.put((Object)"dr", (Object)stringBuilder.toString());
            return bi.a((Map)hashMap, false);
        }
        catch (Exception exception) {
            return "{}";
        }
    }

    @Override
    public void a(View view) {
        if (this.f.b()) {
            String string;
            StringBuilder stringBuilder = new StringBuilder("changing view to ");
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
    public String b() {
        try {
            String string = bi.a(this.f(), true);
            return string;
        }
        catch (Exception exception) {
            return "{}";
        }
    }

    @Override
    public boolean c() {
        if (this.f.b()) {
            Log.d((String)"MoatViewTracker", (String)"Attempting bridge installation.");
        }
        boolean bl2 = this.d.a(this.b, this);
        if (this.f.b()) {
            StringBuilder stringBuilder = new StringBuilder("Bridge ");
            String string = bl2 ? "" : "not ";
            stringBuilder.append(string);
            stringBuilder.append("installed.");
            Log.d((String)"MoatViewTracker", (String)stringBuilder.toString());
        }
        return bl2;
    }

    @Override
    public void d() {
        this.d.a();
    }

    @Override
    public Rect e() {
        int[] arrn = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.a.getLocationInWindow(arrn);
        int n2 = arrn[0];
        int n3 = arrn[1];
        return new Rect(n2, n3, n2 + this.a.getWidth(), n3 + this.a.getHeight());
    }

    public Map f() {
        HashMap hashMap = new HashMap();
        String string = this.g();
        String string2 = Integer.toString((int)Build.VERSION.SDK_INT);
        String string3 = this.c ? "1" : "0";
        hashMap.put((Object)"versionHash", (Object)"8ace5ca5da6b9adb3c0f055aad4a98c2aedf4bd7");
        hashMap.put((Object)"appName", (Object)string);
        hashMap.put((Object)"namespace", (Object)"TJY");
        hashMap.put((Object)"version", (Object)"1.7.10");
        hashMap.put((Object)"deviceOS", (Object)string2);
        hashMap.put((Object)"isNative", (Object)string3);
        return hashMap;
    }
}

