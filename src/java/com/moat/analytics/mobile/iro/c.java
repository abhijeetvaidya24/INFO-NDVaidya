/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  android.view.View
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.iro.o
 *  com.moat.analytics.mobile.iro.y
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
package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.TrackerListener;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.f;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

abstract class c {
    private WeakReference<View> \u02bb;
    private final boolean \u02bc;
    private boolean \u02bd;
    TrackerListener \u02ca;
    private final y \u02ca\u0971;
    o \u02cb = null;
    final String \u02ce;
    f \u02cf;
    private boolean \u02cf\u0971;
    WeakReference<WebView> \u0971;
    final boolean \u141d;

    c(View view, boolean bl2, boolean bl3) {
        String string;
        b.\u02cf(3, "BaseTracker", this, "Initializing.");
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("m");
            stringBuilder.append(this.hashCode());
            string = stringBuilder.toString();
        } else {
            string = "";
        }
        this.\u02ce = string;
        this.\u02bb = new WeakReference((Object)view);
        this.\u02bc = bl2;
        this.\u141d = bl3;
        this.\u02bd = false;
        this.\u02cf\u0971 = false;
        this.\u02ca\u0971 = new y();
    }

    public void changeTargetView(View view) {
        StringBuilder stringBuilder = new StringBuilder("changing view to ");
        stringBuilder.append(b.\u0971(view));
        b.\u02cf(3, "BaseTracker", this, stringBuilder.toString());
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
            b.\u02cf(3, "BaseTracker", this, "In startTracking method.");
            this.\u02ce();
            if (this.\u02ca != null) {
                TrackerListener trackerListener = this.\u02ca;
                StringBuilder stringBuilder = new StringBuilder("Tracking started on ");
                stringBuilder.append(b.\u0971((View)this.\u02bb.get()));
                trackerListener.onTrackingStarted(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder("startTracking succeeded for ");
            stringBuilder.append(b.\u0971((View)this.\u02bb.get()));
            String string = stringBuilder.toString();
            b.\u02cf(3, "BaseTracker", this, string);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.\u02ca());
            stringBuilder2.append(" ");
            stringBuilder2.append(string);
            b.\u02ce("[SUCCESS] ", stringBuilder2.toString());
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
            b.\u02cf(3, "BaseTracker", this, "In stopTracking method.");
            this.\u02cf\u0971 = true;
            f f2 = this.\u02cf;
            bl2 = false;
            if (f2 != null) {
                this.\u02cf.\u02cf(this);
                bl2 = true;
            }
        }
        catch (Exception exception) {
            o.\u0971((Exception)exception);
        }
        StringBuilder stringBuilder = new StringBuilder("Attempt to stop tracking ad impression was ");
        String string = bl2 ? "" : "un";
        stringBuilder.append(string);
        stringBuilder.append("successful.");
        b.\u02cf(3, "BaseTracker", this, stringBuilder.toString());
        String string2 = bl2 ? "[SUCCESS] " : "[ERROR] ";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.\u02ca());
        stringBuilder2.append(" stopTracking ");
        String string3 = bl2 ? "succeeded" : "failed";
        stringBuilder2.append(string3);
        stringBuilder2.append(" for ");
        stringBuilder2.append(b.\u0971((View)this.\u02bb.get()));
        b.\u02ce(string2, stringBuilder2.toString());
        TrackerListener trackerListener = this.\u02ca;
        if (trackerListener != null) {
            trackerListener.onTrackingStopped("");
            this.\u02ca = null;
        }
    }

    final View \u02bb() {
        return (View)this.\u02bb.get();
    }

    final String \u02bc() {
        this.\u02ca\u0971.\u02ce(this.\u02ce, (View)this.\u02bb.get());
        return this.\u02ca\u0971.\u02ce;
    }

    final String \u02bd() {
        return b.\u0971((View)this.\u02bb.get());
    }

    abstract String \u02ca();

    final void \u02cb() throws o {
        if (this.\u02cb == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Tracker initialization failed: ");
        stringBuilder.append(this.\u02cb.getMessage());
        throw new o(stringBuilder.toString());
    }

    final void \u02cb(WebView webView) throws o {
        if (webView != null) {
            f f2;
            this.\u0971 = new WeakReference((Object)webView);
            if (this.\u02cf == null) {
                boolean bl2 = this.\u02bc || this.\u141d;
                if (!bl2) {
                    b.\u02cf(3, "BaseTracker", this, "Attempting bridge installation.");
                    if (this.\u0971.get() != null) {
                        this.\u02cf = new f((WebView)this.\u0971.get(), f.b.\u0971);
                        b.\u02cf(3, "BaseTracker", this, "Bridge installed.");
                    } else {
                        this.\u02cf = null;
                        b.\u02cf(3, "BaseTracker", this, "Bridge not installed, WebView is null.");
                    }
                }
            }
            if ((f2 = this.\u02cf) != null) {
                f2.\u02ce(this);
            }
        }
    }

    void \u02ce() throws o {
        b.\u02cf(3, "BaseTracker", this, "Attempting to start impression.");
        this.\u02cb();
        if (!this.\u02bd) {
            if (!this.\u02cf\u0971) {
                this.\u02cf((List<String>)new ArrayList());
                f f2 = this.\u02cf;
                if (f2 != null) {
                    f2.\u0971(this);
                    this.\u02bd = true;
                    b.\u02cf(3, "BaseTracker", this, "Impression started.");
                    return;
                }
                b.\u02cf(3, "BaseTracker", this, "Bridge is null, won't start tracking");
                throw new o("Bridge is null");
            }
            throw new o("Tracker already stopped");
        }
        throw new o("Tracker already started");
    }

    final void \u02cf() throws o {
        if (!this.\u02bd) {
            if (!this.\u02cf\u0971) {
                return;
            }
            throw new o("Tracker already stopped");
        }
        throw new o("Tracker already started");
    }

    void \u02cf(List<String> list) throws o {
        if ((View)this.\u02bb.get() == null && !this.\u141d) {
            list.add((Object)"Tracker's target view is null");
        }
        if (list.isEmpty()) {
            return;
        }
        throw new o(TextUtils.join((CharSequence)" and ", list));
    }

    final void \u0971(String string, Exception exception) {
        try {
            o.\u0971((Exception)exception);
            String string2 = o.\u0971((String)string, (Exception)exception);
            if (this.\u02ca != null) {
                this.\u02ca.onTrackingFailedToStart(string2);
            }
            b.\u02cf(3, "BaseTracker", this, string2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02ca());
            stringBuilder.append(" ");
            stringBuilder.append(string2);
            b.\u02ce("[ERROR] ", stringBuilder.toString());
        }
        catch (Exception exception2) {}
    }

    final boolean \u0971() {
        return this.\u02bd && !this.\u02cf\u0971;
    }
}

