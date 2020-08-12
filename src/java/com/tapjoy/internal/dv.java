/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.opengl.GLSurfaceView
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.tapjoy.internal.ge
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Hashtable
 *  java.util.LinkedHashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJEventOptimizer;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TapjoyAppSettings;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyException;
import com.tapjoy.TapjoyIntegrationException;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.ac;
import com.tapjoy.internal.aq;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.cx;
import com.tapjoy.internal.d;
import com.tapjoy.internal.du;
import com.tapjoy.internal.eo;
import com.tapjoy.internal.fh;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fx;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.ge;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.r;
import com.tapjoy.internal.t;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

class dv
extends du {
    private boolean b = false;
    private String c = "";
    private TJCurrency d = null;
    private TapjoyCache e = null;

    dv() {
    }

    private boolean i(String string) {
        if (!this.a) {
            StringBuilder stringBuilder = new StringBuilder("Can not call ");
            stringBuilder.append(string);
            stringBuilder.append(" because Tapjoy SDK has not successfully connected.");
            TapjoyLog.w("TapjoyAPI", stringBuilder.toString());
            return false;
        }
        return true;
    }

    private boolean j(String string) {
        if (!this.b) {
            StringBuilder stringBuilder = new StringBuilder("Can not call ");
            stringBuilder.append(string);
            stringBuilder.append(" because Tapjoy SDK is not initialized.");
            this.c = stringBuilder.toString();
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, this.c));
            return false;
        }
        return true;
    }

    @Override
    public final TJPlacement a(String string, TJPlacementListener tJPlacementListener) {
        return TJPlacementManager.a(string, "", "", tJPlacementListener);
    }

    @Override
    public final void a(float f2) {
        if (this.j("setCurrencyMultiplier")) {
            TapjoyConnectCore.getInstance().setCurrencyMultiplier(f2);
        }
    }

    @Override
    public final void a(int n2) {
        gc gc2 = gc.a();
        if (gc2.c("setUserLevel")) {
            Object[] arrobject = new Object[]{n2};
            fz.a("setUserLevel({}) called", arrobject);
            gf gf2 = gc2.f;
            Integer n3 = n2 >= 0 ? Integer.valueOf((int)n2) : null;
            gf2.a(n3);
        }
    }

    @Override
    public final void a(int n2, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (this.d != null && this.i("awardCurrency")) {
            this.d.awardCurrency(n2, tJAwardCurrencyListener);
        }
    }

    @Override
    public final void a(int n2, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (this.d != null && this.i("spendCurrency")) {
            this.d.spendCurrency(n2, tJSpendCurrencyListener);
        }
    }

    @Override
    public final void a(int n2, String string) {
        gc gc2 = gc.a();
        if (gc2.c("setUserCohortVariable")) {
            boolean bl = n2 > 0 && n2 <= 5;
            if (fz.a && !bl) {
                fz.b("setCohortVariable: variableIndex is out of range");
            }
            if (bl) {
                Object[] arrobject = new Object[]{n2, string};
                fz.a("setUserCohortVariable({}, {}) called", arrobject);
                String string2 = fx.a(string);
                gc2.f.a(n2, string2);
            }
        }
    }

    @Override
    public final void a(Activity activity) {
        if (activity != null) {
            d.a(activity);
            return;
        }
        TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Cannot set activity to NULL"));
    }

    @Override
    public final void a(GLSurfaceView gLSurfaceView) {
        gc.a();
        gc.a(gLSurfaceView);
    }

    @Override
    public final void a(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        if (this.d != null && this.i("setEarnedCurrencyListener")) {
            this.d.setEarnedCurrencyListener(tJEarnedCurrencyListener);
        }
    }

    @Override
    public final void a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        if (this.d != null && this.i("getCurrencyBalance")) {
            this.d.getCurrencyBalance(tJGetCurrencyBalanceListener);
        }
    }

    @Override
    public final void a(TJVideoListener tJVideoListener) {
        if (this.j("setVideoListener")) {
            TJAdUnit.publisherVideoListener = tJVideoListener;
        }
    }

    @Override
    public final void a(String string) {
        fq.a(null, string, null, null, 0L);
    }

    @Override
    public final void a(String string, long l2) {
        fq.a(null, string, null, null, l2);
    }

    @Override
    public final void a(String string, TJSetUserIDListener tJSetUserIDListener) {
        if (this.j("setUserID")) {
            TapjoyConnectCore.setUserID(string, tJSetUserIDListener);
            gc gc2 = gc.a();
            if (gc2.c("setUserId")) {
                String string2 = fx.a(string);
                gc2.f.b(string2);
            }
            return;
        }
        if (tJSetUserIDListener != null) {
            tJSetUserIDListener.onSetUserIDFailure(this.c);
        }
    }

    @Override
    public final void a(String string, String string2) {
        fq.a(string, null, null, string2);
    }

    @Override
    public final void a(String string, String string2, double d2, String string3) {
        String string4;
        String string5;
        gc gc2 = gc.a();
        if (gc2.b("trackPurchase") && (string4 = fx.a(string, "trackPurchase", "productId")) != null && (string5 = fx.a(string2, "trackPurchase", "currencyCode")) != null) {
            if (string5.length() != 3) {
                fz.a("trackPurchase", "currencyCode", "invalid currency code");
                return;
            }
            String string6 = string5.toUpperCase(Locale.US);
            String string7 = fx.b(string3);
            gc2.g.a(string4, string6, d2, null, null, string7);
            fz.a("trackPurchase called");
        }
    }

    @Override
    public final void a(String string, String string2, long l2) {
        fq.a(string, string2, null, null, l2);
    }

    @Override
    public final void a(String string, String string2, String string3, String string4) {
        fq.a(string, string2, string3, string4);
    }

    @Override
    public final void a(String string, String string2, String string3, String string4, long l2) {
        fq.a(string, string2, string3, string4, l2);
    }

    @Override
    public final void a(String string, String string2, String string3, String string4, String string5, long l2) {
        fq.a(string, string2, string3, string4, string5, l2, null, 0L, null, 0L);
    }

    @Override
    public final void a(String string, String string2, String string3, String string4, String string5, long l2, String string6, long l3) {
        fq.a(string, string2, string3, string4, string5, l2, string6, l3, null, 0L);
    }

    @Override
    public final void a(String string, String string2, String string3, String string4, String string5, long l2, String string6, long l3, String string7, long l4) {
        fq.a(string, string2, string3, string4, string5, l2, string6, l3, string7, l4);
    }

    @Override
    public final void a(String string, String string2, String string3, String string4, Map map) {
        gc gc2 = gc.a();
        if (gc2.b("trackEvent") && !ct.c(string2)) {
            LinkedHashMap linkedHashMap = cx.b();
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    Object object = entry.getKey();
                    if (object == null) {
                        if (fz.a) {
                            ac.a("Tapjoy", "{}: {} must not be null", "trackEvent", "key in values map");
                        }
                        return;
                    }
                    if (!(object instanceof String)) continue;
                    String string5 = fx.a((String)object, "trackEvent", "key in values map");
                    if (string5 != null) {
                        Object object2 = entry.getValue();
                        if (object2 instanceof Number) {
                            linkedHashMap.put((Object)string5, (Object)((Number)object2).longValue());
                            continue;
                        }
                        fz.a("trackEvent", "value in values map", "must be a long");
                        return;
                    }
                    break;
                }
            } else {
                gc2.g.a(string, string2, string3, string4, (Map)linkedHashMap);
                fz.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", new Object[]{string, string2, string3, string4, linkedHashMap});
            }
        }
    }

    @Override
    public final void a(Set set) {
        gc.a().a(set);
    }

    @Override
    public final void a(boolean bl) {
        TapjoyLog.setDebugEnabled(bl);
    }

    @Override
    public final boolean a(Context context, String string) {
        return this.a(context, string, null, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a(final Context context, String string, Hashtable hashtable, final TJConnectListener tJConnectListener) {
        dv dv2 = this;
        synchronized (dv2) {
            Object object;
            if (hashtable != null && (object = hashtable.get((Object)"TJC_OPTION_ENABLE_LOGGING")) != null) {
                TapjoyLog.setDebugEnabled("true".equals((Object)object.toString()));
            }
            TapjoyConnectCore.setSDKType("event");
            if (context == null) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The application context is NULL"));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
            FiveRocksIntegration.a();
            try {
                TapjoyAppSettings.init(context);
                TapjoyConnectCore.requestTapjoyConnect(context, string, hashtable, new TJConnectListener(){

                    @Override
                    public final void onConnectFailure() {
                        TJConnectListener tJConnectListener2 = tJConnectListener;
                        if (tJConnectListener2 != null) {
                            tJConnectListener2.onConnectFailure();
                        }
                    }

                    @Override
                    public final void onConnectSuccess() {
                        dv.this.d = new TJCurrency(context);
                        dv.this.e = new TapjoyCache(context);
                        try {
                            TJEventOptimizer.init(context);
                        }
                        catch (RuntimeException runtimeException) {
                            TapjoyLog.w("TapjoyAPI", runtimeException.getMessage());
                            this.onConnectFailure();
                            return;
                        }
                        catch (InterruptedException interruptedException) {
                            this.onConnectFailure();
                            return;
                        }
                        dv.this.a = true;
                        TJConnectListener tJConnectListener2 = tJConnectListener;
                        if (tJConnectListener2 != null) {
                            tJConnectListener2.onConnectSuccess();
                        }
                        return;
                    }
                });
            }
            catch (TapjoyException tapjoyException) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, tapjoyException.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
            catch (TapjoyIntegrationException tapjoyIntegrationException) {
                TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, tapjoyIntegrationException.getMessage()));
                if (tJConnectListener != null) {
                    tJConnectListener.onConnectFailure();
                }
                return false;
            }
            this.b = true;
            if (Build.VERSION.SDK_INT < 14) {
                TapjoyLog.i("TapjoyAPI", "Automatic session tracking is not available on this device.");
            } else {
                boolean bl = false;
                if (hashtable != null) {
                    String string2 = String.valueOf((Object)hashtable.get((Object)"TJC_OPTION_DISABLE_AUTOMATIC_SESSION_TRACKING"));
                    bl = false;
                    if (string2 != null) {
                        boolean bl2 = string2.equalsIgnoreCase("true");
                        bl = false;
                        if (bl2) {
                            bl = true;
                        }
                    }
                }
                if (!bl) {
                    eo.a(context);
                } else {
                    TapjoyLog.i("TapjoyAPI", "Automatic session tracking is disabled.");
                }
            }
            return true;
        }
    }

    @Override
    public final String b() {
        return "11.12.2";
    }

    @Override
    public final void b(int n2) {
        gc gc2 = gc.a();
        if (gc2.c("setUserFriendCount")) {
            Object[] arrobject = new Object[]{n2};
            fz.a("setUserFriendCount({}) called", arrobject);
            gf gf2 = gc2.f;
            Integer n3 = n2 >= 0 ? Integer.valueOf((int)n2) : null;
            gf2.b(n3);
        }
    }

    @Override
    public final void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            eo.a();
        }
        gc.a().n = true;
        fq.a(activity);
    }

    @Override
    public final void b(String string) {
        gc gc2 = gc.a();
        if (gc2.c("setAppDataVersion")) {
            String string2 = fx.a(string);
            gc2.f.a(string2);
        }
    }

    @Override
    public final void b(String string, String string2, String string3, String string4) {
        fq.a(string, string2, string3, string4, 0L);
    }

    @Override
    public final void b(boolean bl) {
        gc gc2 = gc.a();
        if (gc2.c("setPushNotificationDisabled")) {
            Object[] arrobject;
            Object object;
            boolean bl2 = gc2.f.a(bl);
            int n2 = 1;
            String string = "setPushNotificationDisabled({}) called, but it is already {}";
            if (bl2) {
                Object[] arrobject2 = new Object[n2];
                object = bl;
                string = "setPushNotificationDisabled({}) called";
                arrobject = arrobject2;
                n2 = 0;
            } else {
                arrobject = new Object[2];
                arrobject[0] = bl;
                object = bl ? "disabled" : "enabled";
            }
            arrobject[n2] = object;
            fz.a(string, arrobject);
            if (bl2 && gc2.k && !ct.c(gc2.d)) {
                String string2;
                if (gc2.o != null) {
                    string2 = null;
                } else {
                    ge ge2 = ge.b((Context)gc2.e);
                    string2 = ct.b(ge2.b.b(ge2.a));
                }
                gc2.a(string2);
            }
        }
    }

    @Override
    public final float c() {
        if (this.j("getCurrencyMultiplier")) {
            return TapjoyConnectCore.getInstance().getCurrencyMultiplier();
        }
        return 1.0f;
    }

    @Override
    public final void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 14) {
            eo.a();
        }
        fq.b(activity);
    }

    @Override
    public final void c(String string) {
        if (ct.c(string)) {
            return;
        }
        gc gc2 = gc.a();
        Set set = gc2.c();
        if (set.add((Object)string)) {
            gc2.a(set);
        }
    }

    @Override
    public final void c(boolean bl) {
        fh fh2 = fh.a();
        fh2.a = bl;
        if (!fh2.b()) {
            fh2.c = true;
        }
    }

    @Override
    public final void d() {
        if (this.j("startSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                eo.a();
            }
            TapjoyConnectCore.getInstance().appResume();
            fq.a();
        }
    }

    @Override
    public final void d(String string) {
        if (ct.c(string)) {
            return;
        }
        gc gc2 = gc.a();
        Set set = gc2.c();
        if (set.remove((Object)string)) {
            gc2.a(set);
        }
    }

    @Override
    public final void e() {
        if (this.j("endSession")) {
            if (Build.VERSION.SDK_INT >= 14) {
                eo.a();
            }
            gc.a().n = false;
            TapjoyConnectCore.getInstance().appPause();
            fq.b();
        }
    }

    @Override
    public final void e(String string) {
        if (this.i("actionComplete")) {
            TapjoyConnectCore.getInstance().actionComplete(string);
        }
    }

    @Override
    public final Set f() {
        return gc.a().c();
    }

    @Override
    public final void f(String string) {
        gc gc2 = gc.a();
        fz.a("setGcmSender({}) called", string);
        gc2.d = ct.a(string);
        gc2.b();
    }

    @Override
    public final String g(String string) {
        if (this.i("getSupportURL")) {
            return TapjoyConnectCore.getSupportURL(string);
        }
        return null;
    }

    @Override
    public final void g() {
        gc.a().a((Set)null);
    }

    @Override
    public final void h(String string) {
        fh fh2 = fh.a();
        if (!aq.a(string)) {
            fh2.b = string;
            if (!fh2.c()) {
                fh2.c = true;
            }
        }
    }

    @Override
    public final boolean h() {
        gc gc2 = gc.a();
        if (!gc2.c("isPushNotificationDisabled")) {
            return false;
        }
        boolean bl = gc2.f.f();
        Object[] arrobject = new Object[]{bl};
        fz.a("isPushNotificationDisabled = {}", arrobject);
        return bl;
    }

    @Override
    public final boolean i() {
        return this.a;
    }

}

