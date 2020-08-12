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
package com.moat.analytics.mobile.cha;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.cha.TrackerListener;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.j;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

abstract class d {
    private WeakReference<View> \u02bb;
    private final boolean \u02bc;
    final boolean \u02bd;
    TrackerListener \u02ca;
    private boolean \u02ca\u0971;
    final String \u02cb;
    j \u02ce;
    WeakReference<WebView> \u02cf;
    private boolean \u037a;
    o \u0971 = null;
    private final u \u141d;

    d(View view, boolean bl2, boolean bl3) {
        String string;
        a.\u02cf(3, "BaseTracker", this, "Initializing.");
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("m");
            stringBuilder.append(this.hashCode());
            string = stringBuilder.toString();
        } else {
            string = "";
        }
        this.\u02cb = string;
        this.\u02bb = new WeakReference((Object)view);
        this.\u02bc = bl2;
        this.\u02bd = bl3;
        this.\u02ca\u0971 = false;
        this.\u037a = false;
        this.\u141d = new u();
    }

    public void changeTargetView(View view) {
        StringBuilder stringBuilder = new StringBuilder("changing view to ");
        stringBuilder.append(a.\u02cf(view));
        a.\u02cf(3, "BaseTracker", this, stringBuilder.toString());
        this.\u02bb = new WeakReference((Object)view);
    }

    public void removeListener() {
        this.\u02ca = null;
    }

    @Deprecated
    public void setActivity(Activity activity) {
    }

    public void setListener(TrackerListener trackerListener) {
        this.\u02ca = trackerListener;
    }

    public void startTracking() {
        try {
            a.\u02cf(3, "BaseTracker", this, "In startTracking method.");
            this.\u02cf();
            if (this.\u02ca != null) {
                TrackerListener trackerListener = this.\u02ca;
                StringBuilder stringBuilder = new StringBuilder("Tracking started on ");
                stringBuilder.append(a.\u02cf((View)this.\u02bb.get()));
                trackerListener.onTrackingStarted(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder("startTracking succeeded for ");
            stringBuilder.append(a.\u02cf((View)this.\u02bb.get()));
            String string = stringBuilder.toString();
            a.\u02cf(3, "BaseTracker", this, string);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.\u02cb());
            stringBuilder2.append(" ");
            stringBuilder2.append(string);
            a.\u02ca("[SUCCESS] ", stringBuilder2.toString());
            return;
        }
        catch (Exception exception) {
            this.\u0971("startTracking", exception);
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
            a.\u02cf(3, "BaseTracker", this, "In stopTracking method.");
            this.\u037a = true;
            j j2 = this.\u02ce;
            bl2 = false;
            if (j2 != null) {
                this.\u02ce.\u02cb(this);
                bl2 = true;
            }
        }
        catch (Exception exception) {
            o.\u02ce(exception);
        }
        StringBuilder stringBuilder = new StringBuilder("Attempt to stop tracking ad impression was ");
        String string = bl2 ? "" : "un";
        stringBuilder.append(string);
        stringBuilder.append("successful.");
        a.\u02cf(3, "BaseTracker", this, stringBuilder.toString());
        String string2 = bl2 ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.\u02cb());
        stringBuilder2.append(" stopTracking ");
        String string3 = bl2 ? "succeeded" : "failed";
        stringBuilder2.append(string3);
        stringBuilder2.append(" for ");
        stringBuilder2.append(a.\u02cf((View)this.\u02bb.get()));
        a.\u02ca(string2, stringBuilder2.toString());
        TrackerListener trackerListener = this.\u02ca;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped("");
            this.\u02ca = null;
        }
    }

    final String \u02bb() {
        return a.\u02cf((View)this.\u02bb.get());
    }

    final View \u02bc() {
        return (View)this.\u02bb.get();
    }

    final String \u02bd() {
        this.\u141d.\u02cb(this.\u02cb, (View)this.\u02bb.get());
        return this.\u141d.\u0971;
    }

    final boolean \u02ca() {
        return this.\u02ca\u0971 && !this.\u037a;
    }

    abstract String \u02cb();

    void \u02cb(List<String> list) throws o {
        if ((View)this.\u02bb.get() == null && !this.\u02bd) {
            list.add((Object)"Tracker's target view is null");
        }
        if (list.isEmpty()) {
            return;
        }
        throw new o(TextUtils.join((CharSequence)" and ", list));
    }

    final void \u02ce() throws o {
        if (this.\u0971 == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Tracker initialization failed: ");
        stringBuilder.append(this.\u0971.getMessage());
        throw new o(stringBuilder.toString());
    }

    void \u02cf() throws o {
        a.\u02cf(3, "BaseTracker", this, "Attempting to start impression.");
        this.\u02ce();
        if (!this.\u02ca\u0971) {
            if (!this.\u037a) {
                this.\u02cb((List<String>)new ArrayList());
                j j2 = this.\u02ce;
                if (j2 != null) {
                    j2.\u02ce(this);
                    this.\u02ca\u0971 = true;
                    a.\u02cf(3, "BaseTracker", this, "Impression started.");
                    return;
                }
                a.\u02cf(3, "BaseTracker", this, "Bridge is null, won't start tracking");
                throw new o("Bridge is null");
            }
            throw new o("Tracker already stopped");
        }
        throw new o("Tracker already started");
    }

    final void \u0971() throws o {
        if (!this.\u02ca\u0971) {
            if (!this.\u037a) {
                return;
            }
            throw new o("Tracker already stopped");
        }
        throw new o("Tracker already started");
    }

    final void \u0971(WebView webView) throws o {
        if (webView != null) {
            j j2;
            this.\u02cf = new WeakReference((Object)webView);
            if (this.\u02ce == null) {
                boolean bl2 = this.\u02bc || this.\u02bd;
                if (!bl2) {
                    a.\u02cf(3, "BaseTracker", this, "Attempting bridge installation.");
                    if (this.\u02cf.get() != null) {
                        this.\u02ce = new j((WebView)this.\u02cf.get(), j.e.\u02cf);
                        a.\u02cf(3, "BaseTracker", this, "Bridge installed.");
                    } else {
                        this.\u02ce = null;
                        a.\u02cf(3, "BaseTracker", this, "Bridge not installed, WebView is null.");
                    }
                }
            }
            if ((j2 = this.\u02ce) != null) {
                j2.\u02ca(this);
            }
        }
    }

    final void \u0971(String string, Exception exception) {
        try {
            o.\u02ce(exception);
            String string2 = o.\u02ce(string, exception);
            if (this.\u02ca != null) {
                this.\u02ca.onTrackingFailedToStart(string2);
            }
            a.\u02cf(3, "BaseTracker", this, string2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02cb());
            stringBuilder.append(" ");
            stringBuilder.append(string2);
            a.\u02ca("[ERROR] ", stringBuilder.toString());
        }
        catch (Exception exception2) {}
    }
}

