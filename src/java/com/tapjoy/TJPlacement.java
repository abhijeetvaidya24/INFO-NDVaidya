/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.SystemClock
 *  com.tapjoy.TJCorePlacement$4
 *  com.tapjoy.TapjoyErrorMessage
 *  com.tapjoy.TapjoyErrorMessage$ErrorType
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.internal.ct
 *  com.tapjoy.internal.eq
 *  com.tapjoy.internal.et
 *  com.tapjoy.internal.ez
 *  com.tapjoy.internal.fi
 *  com.tapjoy.internal.fi$a
 *  com.tapjoy.internal.fv
 *  com.tapjoy.internal.fy
 *  com.tapjoy.internal.gc
 *  com.tapjoy.internal.gh
 *  com.tapjoy.internal.gj
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.UUID
 */
package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitActivity;
import com.tapjoy.TJCorePlacement;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJPlacementVideoListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.eq;
import com.tapjoy.internal.et;
import com.tapjoy.internal.ez;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.fy;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gh;
import com.tapjoy.internal.gj;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TJPlacement {
    TJPlacementListener a;
    private TJCorePlacement b;
    private TJPlacementListener c;
    private TJPlacementVideoListener d;
    private String e;
    public String pushId;

    @Deprecated
    public TJPlacement(Context context, String string, TJPlacementListener tJPlacementListener) {
        TJCorePlacement tJCorePlacement = TJPlacementManager.a(string);
        if (tJCorePlacement == null) {
            tJCorePlacement = TJPlacementManager.a(string, "", "", false);
        }
        tJCorePlacement.setContext(context);
        this.a(tJCorePlacement, tJPlacementListener);
    }

    TJPlacement(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        this.a(tJCorePlacement, tJPlacementListener);
    }

    private void a(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        this.b = tJCorePlacement;
        this.e = UUID.randomUUID().toString();
        this.c = tJPlacementListener;
        TJPlacementListener tJPlacementListener2 = tJPlacementListener != null ? (TJPlacementListener)eq.a((Object)tJPlacementListener, TJPlacementListener.class) : null;
        this.a = tJPlacementListener2;
        FiveRocksIntegration.addPlacementCallback(this.getName(), this);
    }

    private void a(TJError tJError) {
        this.b.a(this, TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, tJError);
    }

    public static void dismissContent() {
        TJPlacementManager.dismissContentShowing("true".equals((Object)TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISMISS_CONTENT_ALL")));
    }

    public String getGUID() {
        return this.e;
    }

    public TJPlacementListener getListener() {
        return this.c;
    }

    public String getName() {
        if (this.b.getPlacementData() != null) {
            return this.b.getPlacementData().getPlacementName();
        }
        return "";
    }

    public TJPlacementVideoListener getVideoListener() {
        return this.d;
    }

    public boolean isContentAvailable() {
        this.b.f.a(1);
        return this.b.isContentAvailable();
    }

    public boolean isContentReady() {
        boolean bl = this.b.isContentReady();
        ez ez2 = this.b.f;
        if (bl) {
            ez2.a(4);
            return bl;
        }
        ez2.a(2);
        return bl;
    }

    public void requestContent() {
        String string = this.getName();
        StringBuilder stringBuilder = new StringBuilder("requestContent() called for placement ");
        stringBuilder.append(string);
        TapjoyLog.i((String)"TJPlacement", (String)stringBuilder.toString());
        fi.a((String)"TJPlacement.requestContent").a("placement", (Object)string).a("placement_type", (Object)this.b.c.getPlacementType());
        if (!TapjoyConnectCore.isConnected()) {
            fi.b((String)"TJPlacement.requestContent").b("not connected").c();
            this.a(new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
            return;
        }
        if (this.b.getContext() == null) {
            fi.b((String)"TJPlacement.requestContent").b("no context").c();
            this.a(new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
            return;
        }
        if (ct.c((String)string)) {
            fi.b((String)"TJPlacement.requestContent").b("invalid name").c();
            this.a(new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
            return;
        }
        try {
            TJCorePlacement tJCorePlacement = this.b;
            tJCorePlacement.a("REQUEST", this);
            if (tJCorePlacement.e - SystemClock.elapsedRealtime() > 0L) {
                String string2 = TJCorePlacement.a;
                StringBuilder stringBuilder2 = new StringBuilder("Content has not expired yet for ");
                stringBuilder2.append(tJCorePlacement.c.getPlacementName());
                TapjoyLog.d((String)string2, (String)stringBuilder2.toString());
                boolean bl = tJCorePlacement.l;
                if (bl) {
                    fi.b((String)"TJPlacement.requestContent").a("content_type", (Object)tJCorePlacement.b()).a("from", (Object)"cache").c();
                    tJCorePlacement.k = false;
                    tJCorePlacement.a(this);
                    tJCorePlacement.c();
                } else {
                    fi.b((String)"TJPlacement.requestContent").a("content_type", (Object)"none").a("from", (Object)"cache").c();
                    tJCorePlacement.a(this);
                }
            } else {
                if (tJCorePlacement.l) {
                    fi.c((String)"TJPlacement.requestContent").a("was_available", (Object)true);
                }
                if (tJCorePlacement.m) {
                    fi.c((String)"TJPlacement.requestContent").a("was_ready", (Object)true);
                }
                if (ct.c((String)tJCorePlacement.p)) {
                    tJCorePlacement.a();
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put((Object)"mediation_agent", (Object)tJCorePlacement.p);
                    hashMap.put((Object)"mediation_id", (Object)tJCorePlacement.q);
                    tJCorePlacement.a(tJCorePlacement.c.getMediationURL(), (Map)hashMap);
                }
            }
            return;
        }
        finally {
            fi.d((String)"TJPlacement.requestContent");
        }
    }

    public void setAdapterVersion(String string) {
        this.b.o = string;
    }

    public void setMediationId(String string) {
        this.b.q = string;
    }

    public void setMediationName(String string) {
        StringBuilder stringBuilder = new StringBuilder("setMediationName=");
        stringBuilder.append(string);
        TapjoyLog.d((String)"TJPlacement", (String)stringBuilder.toString());
        if (!ct.c((String)string)) {
            TJCorePlacement tJCorePlacement = this.b;
            Context context = tJCorePlacement != null ? tJCorePlacement.getContext() : null;
            TJCorePlacement tJCorePlacement2 = this.b = TJPlacementManager.a(this.getName(), string, "", false);
            tJCorePlacement2.p = string;
            tJCorePlacement2.n = string;
            tJCorePlacement2.c.setPlacementType(string);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(TapjoyConnectCore.getPlacementURL());
            stringBuilder2.append("v1/apps/");
            stringBuilder2.append(TapjoyConnectCore.getAppID());
            stringBuilder2.append("/mediation_content?");
            String string2 = stringBuilder2.toString();
            tJCorePlacement2.c.setMediationURL(string2);
            if (context != null) {
                this.b.setContext(context);
            }
        }
    }

    public void setVideoListener(TJPlacementVideoListener tJPlacementVideoListener) {
        this.d = tJPlacementVideoListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showContent() {
        String string = this.getName();
        StringBuilder stringBuilder = new StringBuilder("showContent() called for placement ");
        stringBuilder.append(string);
        TapjoyLog.i((String)"TJPlacement", (String)stringBuilder.toString());
        TJCorePlacement tJCorePlacement = this.b;
        fi.a((String)"TJPlacement.showContent").a("placement", (Object)tJCorePlacement.c.getPlacementName()).a("placement_type", (Object)tJCorePlacement.c.getPlacementType()).a("content_type", (Object)tJCorePlacement.b());
        ez ez2 = tJCorePlacement.f;
        ez2.a(8);
        et et2 = ez2.a;
        if (et2 != null) {
            et2.a();
        }
        if (!this.b.isContentAvailable()) {
            TapjoyLog.e((String)"TJPlacement", (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "No placement content available. Can not show content for non-200 placement."));
            fi.b((String)"TJPlacement.showContent").b("no content").c();
            return;
        }
        try {
            TJCorePlacement tJCorePlacement2 = this.b;
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                TapjoyLog.w((String)TJCorePlacement.a, (String)"Only one view can be presented at a time.");
                fi.b((String)"TJPlacement.showContent").b("another content showing").c();
                return;
            } else {
                if (TapjoyConnectCore.isViewOpen()) {
                    TapjoyLog.w((String)TJCorePlacement.a, (String)"Will close N2E content.");
                    TJPlacementManager.dismissContentShowing(false);
                }
                tJCorePlacement2.a("SHOW", this);
                fi.a a2 = fi.d((String)"TJPlacement.showContent");
                if (tJCorePlacement2.g.isPrerendered()) {
                    a2.a("prerendered", (Object)true);
                }
                if (tJCorePlacement2.isContentReady()) {
                    a2.a("content_ready", (Object)true);
                }
                tJCorePlacement2.f.d = a2;
                String string2 = UUID.randomUUID().toString();
                if (tJCorePlacement2.i != null) {
                    tJCorePlacement2.i.f = string2;
                    int n2 = tJCorePlacement2.i == null ? 1 : (tJCorePlacement2.i instanceof fy ? 3 : (tJCorePlacement2.i instanceof gh ? 2 : 0));
                    TapjoyConnectCore.viewWillOpen(string2, n2);
                    TJCorePlacement.4 var18_10 = new TJCorePlacement.4(tJCorePlacement2, string2);
                    tJCorePlacement2.i.e = var18_10;
                    gc.a((Runnable)new Runnable(){

                        public final void run() {
                            TJCorePlacement.this.i.a(gc.a().p, TJCorePlacement.this.f);
                        }
                    });
                } else {
                    tJCorePlacement2.c.setContentViewId(string2);
                    Intent intent = new Intent(tJCorePlacement2.b, TJAdUnitActivity.class);
                    intent.putExtra("placement_data", (Serializable)tJCorePlacement2.c);
                    intent.setFlags(268435456);
                    tJCorePlacement2.b.startActivity(intent);
                }
                tJCorePlacement2.e = 0L;
                tJCorePlacement2.l = false;
                tJCorePlacement2.m = false;
            }
            return;
        }
        finally {
            fi.d((String)"TJPlacement.showContent");
        }
    }
}

