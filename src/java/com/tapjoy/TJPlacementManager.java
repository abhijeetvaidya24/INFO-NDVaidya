/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.internal.be
 *  com.tapjoy.internal.ct
 *  com.tapjoy.internal.fy
 *  com.tapjoy.internal.gh
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy;

import android.content.Context;
import com.tapjoy.TJAdUnitActivity;
import com.tapjoy.TJCorePlacement;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.be;
import com.tapjoy.internal.ct;
import com.tapjoy.internal.fy;
import com.tapjoy.internal.gh;

public class TJPlacementManager {
    private static final be a = be.a();
    private static int b = 0;
    private static int c = 0;
    private static int d = 3;
    private static int e = 3;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static TJCorePlacement a(String string) {
        be be2;
        be be3 = be2 = a;
        synchronized (be3) {
            return (TJCorePlacement)a.get((Object)string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static TJCorePlacement a(String string, String string2, String string3, boolean bl) {
        be be2;
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = bl ? "!SYSTEM!" : "";
        stringBuilder.append(string4);
        String string5 = !ct.c((String)string) ? string : "";
        stringBuilder.append(string5);
        if (ct.c((String)string2)) {
            string2 = "";
        }
        stringBuilder.append(string2);
        if (ct.c((String)string3)) {
            string3 = "";
        }
        stringBuilder.append(string3);
        String string6 = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder("TJCorePlacement key=");
        stringBuilder2.append(string6);
        TapjoyLog.d((String)"TJPlacementManager", (String)stringBuilder2.toString());
        be be3 = be2 = a;
        synchronized (be3) {
            TJCorePlacement tJCorePlacement = TJPlacementManager.a(string6);
            if (tJCorePlacement == null) {
                tJCorePlacement = new TJCorePlacement(string, string6);
                a.put((Object)string6, (Object)tJCorePlacement);
                StringBuilder stringBuilder3 = new StringBuilder("Created TJCorePlacement with GUID: ");
                stringBuilder3.append(tJCorePlacement.d);
                TapjoyLog.d((String)"TJPlacementManager", (String)stringBuilder3.toString());
            }
            return tJCorePlacement;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static TJPlacement a(String string, String string2, String string3, TJPlacementListener tJPlacementListener) {
        be be2;
        be be3 = be2 = a;
        synchronized (be3) {
            return new TJPlacement(TJPlacementManager.a(string, string2, string3, false), tJPlacementListener);
        }
    }

    public static boolean canCachePlacement() {
        return TJPlacementManager.getCachedPlacementCount() < TJPlacementManager.getCachedPlacementLimit();
    }

    public static boolean canPreRenderPlacement() {
        return TJPlacementManager.getPreRenderedPlacementCount() < TJPlacementManager.getPreRenderedPlacementLimit();
    }

    public static TJPlacement createPlacement(Context context, String string, boolean bl, TJPlacementListener tJPlacementListener) {
        TJCorePlacement tJCorePlacement = TJPlacementManager.a(string, null, null, bl);
        tJCorePlacement.j = bl;
        tJCorePlacement.c.setPlacementType("sdk");
        tJCorePlacement.setContext(context);
        return new TJPlacement(tJCorePlacement, tJPlacementListener);
    }

    public static void decrementPlacementCacheCount() {
        int n2;
        b = n2 = -1 + b;
        if (n2 < 0) {
            b = 0;
        }
        TJPlacementManager.printPlacementCacheInformation();
    }

    public static void decrementPlacementPreRenderCount() {
        int n2;
        c = n2 = -1 + c;
        if (n2 < 0) {
            c = 0;
        }
    }

    public static void dismissContentShowing(boolean bl) {
        if (bl) {
            TJAdUnitActivity.a();
        }
        gh.a();
        fy.a();
    }

    public static int getCachedPlacementCount() {
        return b;
    }

    public static int getCachedPlacementLimit() {
        return d;
    }

    public static int getPreRenderedPlacementCount() {
        return c;
    }

    public static int getPreRenderedPlacementLimit() {
        return e;
    }

    public static void incrementPlacementCacheCount() {
        int n2;
        b = n2 = 1 + b;
        int n3 = d;
        if (n2 > n3) {
            b = n3;
        }
        TJPlacementManager.printPlacementCacheInformation();
    }

    public static void incrementPlacementPreRenderCount() {
        int n2;
        c = n2 = 1 + c;
        int n3 = e;
        if (n2 > n3) {
            c = n3;
        }
    }

    public static void printPlacementCacheInformation() {
        StringBuilder stringBuilder = new StringBuilder("Space available in placement cache: ");
        stringBuilder.append(b);
        stringBuilder.append(" out of ");
        stringBuilder.append(d);
        TapjoyLog.i((String)"TJPlacementManager", (String)stringBuilder.toString());
    }

    public static void printPlacementPreRenderInformation() {
        StringBuilder stringBuilder = new StringBuilder("Space available for placement pre-render: ");
        stringBuilder.append(c);
        stringBuilder.append(" out of ");
        stringBuilder.append(e);
        TapjoyLog.i((String)"TJPlacementManager", (String)stringBuilder.toString());
    }

    public static void setCachedPlacementLimit(int n2) {
        d = n2;
    }

    public static void setPreRenderedPlacementLimit(int n2) {
        e = n2;
    }
}

