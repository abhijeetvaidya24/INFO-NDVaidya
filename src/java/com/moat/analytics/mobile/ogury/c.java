/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  android.view.View
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.ogury.e
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
package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.TrackerListener;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.f;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

abstract class c {
    private final v \u02bb;
    private boolean \u02bc;
    private WeakReference<View> \u02bd;
    WeakReference<WebView> \u02ca;
    f \u02cb;
    private boolean \u02cb\u0971;
    l \u02ce = null;
    TrackerListener \u02cf;
    final String \u0971;
    private final boolean \u0971\u0971;
    final boolean \u141d;

    c(View view, boolean bl2, boolean bl3) {
        String string2;
        e.1.\u02cb(3, "BaseTracker", this, "Initializing.");
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("m");
            stringBuilder.append(this.hashCode());
            string2 = stringBuilder.toString();
        } else {
            string2 = "";
        }
        this.\u0971 = string2;
        this.\u02bd = new WeakReference((Object)view);
        this.\u0971\u0971 = bl2;
        this.\u141d = bl3;
        this.\u02bc = false;
        this.\u02cb\u0971 = false;
        this.\u02bb = new v();
    }

    public void changeTargetView(View view) {
        StringBuilder stringBuilder = new StringBuilder("changing view to ");
        stringBuilder.append(e.1.\u02cf(view));
        e.1.\u02cb(3, "BaseTracker", this, stringBuilder.toString());
        this.\u02bd = new WeakReference((Object)view);
    }

    public void removeListener() {
        this.\u02cf = null;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void setListener(TrackerListener trackerListener) {
        this.\u02cf = trackerListener;
    }

    public void startTracking() {
        try {
            e.1.\u02cb(3, "BaseTracker", this, "In startTracking method.");
            this.\u02ce();
            if (this.\u02cf != null) {
                TrackerListener trackerListener = this.\u02cf;
                StringBuilder stringBuilder = new StringBuilder("Tracking started on ");
                stringBuilder.append(e.1.\u02cf((View)this.\u02bd.get()));
                trackerListener.onTrackingStarted(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder("startTracking succeeded for ");
            stringBuilder.append(e.1.\u02cf((View)this.\u02bd.get()));
            String string2 = stringBuilder.toString();
            e.1.\u02cb(3, "BaseTracker", this, string2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.\u02cf());
            stringBuilder2.append(" ");
            stringBuilder2.append(string2);
            e.1.\u0971("[SUCCESS] ", stringBuilder2.toString());
            return;
        }
        catch (Exception exception) {
            this.\u02cb("startTracking", exception);
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
            e.1.\u02cb(3, "BaseTracker", this, "In stopTracking method.");
            this.\u02cb\u0971 = true;
            f f2 = this.\u02cb;
            bl2 = false;
            if (f2 != null) {
                this.\u02cb.\u02cf(this);
                bl2 = true;
            }
        }
        catch (Exception exception) {
            l.\u0971(exception);
        }
        StringBuilder stringBuilder = new StringBuilder("Attempt to stop tracking ad impression was ");
        String string2 = bl2 ? "" : "un";
        stringBuilder.append(string2);
        stringBuilder.append("successful.");
        e.1.\u02cb(3, "BaseTracker", this, stringBuilder.toString());
        String string3 = bl2 ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.\u02cf());
        stringBuilder2.append(" stopTracking ");
        String string4 = bl2 ? "succeeded" : "failed";
        stringBuilder2.append(string4);
        stringBuilder2.append(" for ");
        stringBuilder2.append(e.1.\u02cf((View)this.\u02bd.get()));
        e.1.\u0971(string3, stringBuilder2.toString());
        TrackerListener trackerListener = this.\u02cf;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped("");
            this.\u02cf = null;
        }
    }

    final String \u02bb() {
        return e.1.\u02cf((View)this.\u02bd.get());
    }

    final String \u02bd() {
        this.\u02bb.\u02ca(this.\u0971, (View)this.\u02bd.get());
        return this.\u02bb.\u02ce;
    }

    void \u02ca(List<String> list) throws l {
        if ((View)this.\u02bd.get() == null && !this.\u141d) {
            list.add((Object)"Tracker's target view is null");
        }
        if (list.isEmpty()) {
            return;
        }
        throw new l(TextUtils.join((CharSequence)" and ", list));
    }

    final boolean \u02ca() {
        return this.\u02bc && !this.\u02cb\u0971;
    }

    final void \u02cb() throws l {
        if (!this.\u02bc) {
            if (!this.\u02cb\u0971) {
                return;
            }
            throw new l("Tracker already stopped");
        }
        throw new l("Tracker already started");
    }

    final void \u02cb(WebView webView) throws l {
        if (webView != null) {
            f f2;
            this.\u02ca = new WeakReference((Object)webView);
            if (this.\u02cb == null) {
                boolean bl2 = this.\u0971\u0971 || this.\u141d;
                if (!bl2) {
                    e.1.\u02cb(3, "BaseTracker", this, "Attempting bridge installation.");
                    if (this.\u02ca.get() != null) {
                        this.\u02cb = new f((WebView)this.\u02ca.get(), f.a.\u02ca);
                        e.1.\u02cb(3, "BaseTracker", this, "Bridge installed.");
                    } else {
                        this.\u02cb = null;
                        e.1.\u02cb(3, "BaseTracker", this, "Bridge not installed, WebView is null.");
                    }
                }
            }
            if ((f2 = this.\u02cb) != null) {
                f2.\u02ce(this);
            }
        }
    }

    final void \u02cb(String string2, Exception exception) {
        try {
            l.\u0971(exception);
            String string3 = l.\u02cb(string2, exception);
            if (this.\u02cf != null) {
                this.\u02cf.onTrackingFailedToStart(string3);
            }
            e.1.\u02cb(3, "BaseTracker", this, string3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02cf());
            stringBuilder.append(" ");
            stringBuilder.append(string3);
            e.1.\u0971("[ERROR] ", stringBuilder.toString());
        }
        catch (Exception exception2) {}
    }

    void \u02ce() throws l {
        e.1.\u02cb(3, "BaseTracker", this, "Attempting to start impression.");
        this.\u0971();
        if (!this.\u02bc) {
            if (!this.\u02cb\u0971) {
                this.\u02ca((List<String>)new ArrayList());
                f f2 = this.\u02cb;
                if (f2 != null) {
                    f2.\u02cb(this);
                    this.\u02bc = true;
                    e.1.\u02cb(3, "BaseTracker", this, "Impression started.");
                    return;
                }
                e.1.\u02cb(3, "BaseTracker", this, "Bridge is null, won't start tracking");
                throw new l("Bridge is null");
            }
            throw new l("Tracker already stopped");
        }
        throw new l("Tracker already started");
    }

    abstract String \u02cf();

    final void \u0971() throws l {
        if (this.\u02ce == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Tracker initialization failed: ");
        stringBuilder.append(this.\u02ce.getMessage());
        throw new l(stringBuilder.toString());
    }

    final View \u0971\u0971() {
        return (View)this.\u02bd.get();
    }
}

