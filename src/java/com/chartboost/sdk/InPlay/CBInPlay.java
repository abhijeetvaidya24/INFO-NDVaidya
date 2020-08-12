/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.h
 *  com.chartboost.sdk.impl.ad
 *  com.chartboost.sdk.impl.ah
 *  com.chartboost.sdk.impl.aj
 *  com.chartboost.sdk.impl.aj$a
 *  com.chartboost.sdk.impl.ak
 *  com.chartboost.sdk.impl.ap
 *  com.chartboost.sdk.impl.bh
 *  com.chartboost.sdk.impl.c
 *  com.chartboost.sdk.impl.c$a
 *  com.chartboost.sdk.impl.e
 *  com.chartboost.sdk.impl.e$a
 *  com.chartboost.sdk.impl.f
 *  com.chartboost.sdk.impl.g
 *  com.chartboost.sdk.impl.s
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Map
 *  java.util.concurrent.Executor
 *  java.util.concurrent.atomic.AtomicReference
 *  org.json.JSONObject
 */
package com.chartboost.sdk.InPlay;

import android.graphics.Bitmap;
import android.os.Handler;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.g;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.b;
import com.chartboost.sdk.h;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.aj;
import com.chartboost.sdk.impl.ak;
import com.chartboost.sdk.impl.ap;
import com.chartboost.sdk.impl.bh;
import com.chartboost.sdk.impl.c;
import com.chartboost.sdk.impl.e;
import com.chartboost.sdk.impl.f;
import com.chartboost.sdk.impl.s;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class CBInPlay {
    private final e a;
    public final String appName;
    private final ah b;
    private final ap c;
    private final a d;
    private final ak e;
    private final com.chartboost.sdk.Model.a f;
    private Bitmap g;
    public final File largeAppIconFile;
    public final String largeAppIconUrl;
    public final String location;

    private CBInPlay(e e2, ah ah2, ap ap2, a a2, ak ak2, com.chartboost.sdk.Model.a a3, String string2, File file, String string3) {
        this.a = e2;
        this.b = ah2;
        this.c = ap2;
        this.d = a2;
        this.e = ak2;
        this.f = a3;
        this.appName = a3.q;
        this.largeAppIconUrl = string2;
        this.largeAppIconFile = file;
        this.location = string3;
    }

    public static void cacheInPlay(String string2) {
        h h2 = h.a();
        if (h2 != null) {
            if (!b.a()) {
                return;
            }
            if (s.a().a((CharSequence)string2)) {
                CBLogging.b("CBInPlay", "cacheInPlay location cannot be empty");
                Handler handler = h2.p;
                c c2 = h2.e;
                c2.getClass();
                handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INVALID_LOCATION));
                return;
            }
            com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)h2.m.get();
            if (e2.y && e2.z || e2.e && e2.f) {
                e e3 = h2.d;
                e3.getClass();
                e.a a2 = new e.a(e3, 3, string2, null, null);
                h2.a.execute((Runnable)a2);
                return;
            }
            Handler handler = h2.p;
            c c3 = h2.e;
            c3.getClass();
            handler.post((Runnable)new c.a(c3, 4, string2, CBError.CBImpressionError.END_POINT_DISABLED));
        }
    }

    public static CBInPlay getInPlay(String string2) {
        CBInPlay cBInPlay;
        block11 : {
            CBError.CBImpressionError cBImpressionError;
            h h2;
            block13 : {
                block12 : {
                    h2 = h.a();
                    cBInPlay = null;
                    if (h2 == null) break block11;
                    if (!b.a()) {
                        return null;
                    }
                    if (s.a().a((CharSequence)string2)) {
                        CBLogging.b("CBInPlay", "Inplay location cannot be empty");
                        Handler handler = h2.p;
                        c c2 = h2.e;
                        c2.getClass();
                        handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INVALID_LOCATION));
                        return null;
                    }
                    com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)h2.m.get();
                    cBImpressionError = CBError.CBImpressionError.NO_AD_FOUND;
                    if (e2.y && e2.z) break block12;
                    boolean bl = e2.e;
                    cBInPlay = null;
                    if (!bl) break block13;
                    boolean bl2 = e2.f;
                    cBInPlay = null;
                    if (!bl2) break block13;
                }
                com.chartboost.sdk.Model.a a2 = h2.d.a(string2);
                cBInPlay = null;
                if (a2 != null) {
                    com.chartboost.sdk.Model.b b2 = (com.chartboost.sdk.Model.b)a2.c.get((Object)"lg");
                    cBInPlay = null;
                    if (b2 != null) {
                        File file = b2.a(h2.d.b.d().a);
                        if (!file.exists()) {
                            cBImpressionError = CBError.CBImpressionError.ASSET_MISSING;
                            cBInPlay = null;
                        } else {
                            e e3 = h2.d;
                            ah ah2 = h2.h;
                            ap ap2 = h2.j;
                            a a3 = h2.o;
                            ak ak2 = h2.r;
                            String string3 = b2.c;
                            cBInPlay = new CBInPlay(e3, ah2, ap2, a3, ak2, a2, string3, file, string2);
                        }
                    }
                    Executor executor = h2.a;
                    e e4 = h2.d;
                    e4.getClass();
                    e.a a4 = new e.a(e4, 8, string2, null, null);
                    executor.execute((Runnable)a4);
                }
                if (cBInPlay == null) {
                    Executor executor = h2.a;
                    e e5 = h2.d;
                    e5.getClass();
                    e.a a5 = new e.a(e5, 3, string2, null, null);
                    executor.execute((Runnable)a5);
                }
            }
            if (cBInPlay == null) {
                Handler handler = h2.p;
                c c3 = h2.e;
                c3.getClass();
                handler.post((Runnable)new c.a(c3, 4, string2, cBImpressionError));
            }
        }
        return cBInPlay;
    }

    public static boolean hasInPlay(String string2) {
        h h2 = h.a();
        boolean bl = false;
        if (h2 != null) {
            if (!b.a()) {
                return false;
            }
            if (s.a().a((CharSequence)string2)) {
                CBLogging.b("CBInPlay", "hasInPlay location cannot be empty");
                Handler handler = h2.p;
                c c2 = h2.e;
                c2.getClass();
                handler.post((Runnable)new c.a(c2, 4, string2, CBError.CBImpressionError.INVALID_LOCATION));
                return false;
            }
            com.chartboost.sdk.Model.a a2 = h2.d.a(string2);
            bl = false;
            if (a2 != null) {
                bl = true;
            }
        }
        return bl;
    }

    public void click() {
        String string2 = this.f.j;
        String string3 = this.f.i;
        String string4 = !string3.isEmpty() && this.e.a(string3) ? string3 : string2;
        aj aj2 = new aj("/api/click", this.c, this.d, 2, null);
        aj2.a("location", (Object)this.location);
        aj2.a("to", (Object)this.f.m);
        aj2.a("cgn", (Object)this.f.g);
        aj2.a("creative", (Object)this.f.h);
        aj2.a("ad_id", (Object)this.f.f);
        aj2.a("type", (Object)"native");
        if (string4 != null && !string4.isEmpty()) {
            this.e.a(null, string4, aj2);
            return;
        }
        this.e.a(null, false, string4, CBError.CBClickError.URI_INVALID, aj2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap getAppIcon() throws Exception {
        if (this.g != null) return this.g;
        try {
            byte[] arrby = bh.b((File)this.largeAppIconFile);
            if (arrby != null) {
                this.g = s.a().a(arrby);
            }
            if (this.g != null) return this.g;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error decoding inplay bitmap ");
            stringBuilder.append(this.largeAppIconFile.getAbsolutePath());
            CBLogging.b("CBInPlay", stringBuilder.toString());
            if (this.largeAppIconFile.delete()) throw new Exception("decodeByteArrayToBitmap returned null");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unable to delete corrupt inplay bitmap ");
            stringBuilder2.append(this.largeAppIconFile.getAbsolutePath());
            CBLogging.b("CBInPlay", stringBuilder2.toString());
            throw new Exception("decodeByteArrayToBitmap returned null");
        }
        catch (OutOfMemoryError outOfMemoryError) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Out of memory decoding inplay bitmap ");
            stringBuilder.append(this.largeAppIconFile.getAbsolutePath());
            CBLogging.b("CBInPlay", stringBuilder.toString());
            throw new Exception((Throwable)outOfMemoryError);
        }
    }

    public String getAppName() {
        return this.appName;
    }

    public String getLocation() {
        return this.location;
    }

    public void show() {
        com.chartboost.sdk.impl.g g2 = new com.chartboost.sdk.impl.g(this.a, this.location);
        aj aj2 = new aj("/inplay/show", this.c, this.d, 2, (aj.a)g2);
        aj2.j = 1;
        aj2.a("inplay-dictionary", (Object)this.f.a);
        aj2.a("location", (Object)this.location);
        this.b.a((ad)aj2);
    }
}

