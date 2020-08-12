/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.List
 */
package com.moat.analytics.mobile.mpub;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.mpub.TrackerListener;
import com.moat.analytics.mobile.mpub.j;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

abstract class b {
    m a = null;
    WeakReference<WebView> b;
    j c;
    TrackerListener d;
    final String e;
    final boolean f;
    private WeakReference<View> g;
    private final z h;
    private final boolean i;
    private boolean j;
    private boolean k;

    b(View view, boolean bl2, boolean bl3) {
        String string2;
        p.a(3, "BaseTracker", this, "Initializing.");
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("m");
            stringBuilder.append(this.hashCode());
            string2 = stringBuilder.toString();
        } else {
            string2 = "";
        }
        this.e = string2;
        this.g = new WeakReference((Object)view);
        this.i = bl2;
        this.f = bl3;
        this.j = false;
        this.k = false;
        this.h = new z();
    }

    private void i() {
        String string2;
        p.a(3, "BaseTracker", this, "Attempting bridge installation.");
        if (this.b.get() != null) {
            this.c = new j((WebView)this.b.get(), j.a.a);
            string2 = "Bridge installed.";
        } else {
            this.c = null;
            string2 = "Bridge not installed, WebView is null.";
        }
        p.a(3, "BaseTracker", this, string2);
    }

    private void j() {
        if (!this.j) {
            return;
        }
        throw new m("Tracker already started");
    }

    private void k() {
        if (!this.k) {
            return;
        }
        throw new m("Tracker already stopped");
    }

    private boolean l() {
        return this.i || this.f;
        {
        }
    }

    abstract String a();

    void a(WebView webView) {
        if (webView != null) {
            j j2;
            this.b = new WeakReference((Object)webView);
            if (this.c == null && !this.l()) {
                this.i();
            }
            if ((j2 = this.c) != null) {
                j2.a(this);
            }
        }
    }

    void a(j j2) {
        this.c = j2;
    }

    void a(String string2, Exception exception) {
        try {
            m.a(exception);
            String string3 = m.a(string2, exception);
            if (this.d != null) {
                this.d.onTrackingFailedToStart(string3);
            }
            p.a(3, "BaseTracker", this, string3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a());
            stringBuilder.append(" ");
            stringBuilder.append(string3);
            p.a("[ERROR] ", stringBuilder.toString());
        }
        catch (Exception exception2) {}
    }

    void a(List<String> list) {
        if (this.f() == null && !this.f) {
            list.add((Object)"Tracker's target view is null");
        }
        if (list.isEmpty()) {
            return;
        }
        throw new m(TextUtils.join((CharSequence)" and ", list));
    }

    void b() {
        p.a(3, "BaseTracker", this, "Attempting to start impression.");
        this.c();
        this.d();
        this.a((List<String>)new ArrayList());
        j j2 = this.c;
        if (j2 != null) {
            j2.b(this);
            this.j = true;
            p.a(3, "BaseTracker", this, "Impression started.");
            return;
        }
        p.a(3, "BaseTracker", this, "Bridge is null, won't start tracking");
        throw new m("Bridge is null");
    }

    void c() {
        if (this.a == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tracker initialization failed: ");
        stringBuilder.append(this.a.getMessage());
        throw new m(stringBuilder.toString());
    }

    public void changeTargetView(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("changing view to ");
        stringBuilder.append(p.a(view));
        p.a(3, "BaseTracker", this, stringBuilder.toString());
        this.g = new WeakReference((Object)view);
    }

    void d() {
        this.j();
        this.k();
    }

    boolean e() {
        return this.j && !this.k;
    }

    View f() {
        return (View)this.g.get();
    }

    String g() {
        return p.a(this.f());
    }

    String h() {
        this.h.a(this.e, this.f());
        return this.h.a;
    }

    public void removeListener() {
        this.d = null;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void setListener(TrackerListener trackerListener) {
        this.d = trackerListener;
    }

    public void startTracking() {
        try {
            p.a(3, "BaseTracker", this, "In startTracking method.");
            this.b();
            if (this.d != null) {
                TrackerListener trackerListener = this.d;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Tracking started on ");
                stringBuilder.append(this.g());
                trackerListener.onTrackingStarted(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("startTracking succeeded for ");
            stringBuilder.append(this.g());
            String string2 = stringBuilder.toString();
            p.a(3, "BaseTracker", this, string2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.a());
            stringBuilder2.append(" ");
            stringBuilder2.append(string2);
            p.a("[SUCCESS] ", stringBuilder2.toString());
            return;
        }
        catch (Exception exception) {
            this.a("startTracking", exception);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stopTracking() {
        boolean bl2 = false;
        try {
            p.a(3, "BaseTracker", this, "In stopTracking method.");
            this.k = true;
            j j2 = this.c;
            bl2 = false;
            if (j2 != null) {
                this.c.c(this);
                bl2 = true;
            }
        }
        catch (Exception exception) {
            m.a(exception);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempt to stop tracking ad impression was ");
        String string2 = bl2 ? "" : "un";
        stringBuilder.append(string2);
        stringBuilder.append("successful.");
        p.a(3, "BaseTracker", this, stringBuilder.toString());
        String string3 = bl2 ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.a());
        stringBuilder2.append(" stopTracking ");
        String string4 = bl2 ? "succeeded" : "failed";
        stringBuilder2.append(string4);
        stringBuilder2.append(" for ");
        stringBuilder2.append(this.g());
        p.a(string3, stringBuilder2.toString());
        TrackerListener trackerListener = this.d;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped("");
            this.d = null;
        }
    }
}

