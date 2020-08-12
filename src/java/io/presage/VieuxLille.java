/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  io.presage.BleudAuvergnebio
 *  io.presage.FourmedAmbert
 *  io.presage.j
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.presage.Abondance;
import io.presage.Beaufort;
import io.presage.BleudAuvergnebio;
import io.presage.BrillatSavarin;
import io.presage.FourmedAmbert;
import io.presage.FourmedAmbertBio;
import io.presage.TrouduCru;
import io.presage.c;
import io.presage.cl;
import io.presage.j;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@SuppressLint(value={"StaticFieldLeak"})
public final class VieuxLille {
    public static final VieuxLille a = new VieuxLille();
    private static final Map<String, TrouduCru> b;
    private static Handler c;
    private static final Runnable d;
    private static Integer e;
    private static FourmedAmbertBio f;

    static {
        Map map = Collections.synchronizedMap((Map)((Map)new LinkedHashMap()));
        cl.a((Object)map, "Collections.synchronized\u2026tring, MraidCacheItem>())");
        b = map;
        c = new Handler(Looper.getMainLooper());
        d = CamembertauCalvados.a;
        f = FourmedAmbertBio.a;
    }

    private VieuxLille() {
    }

    public static void a() {
        Iterator iterator = b.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (!VieuxLille.c((TrouduCru)entry.getValue())) continue;
            iterator.remove();
            Abondance.a((Beaufort)new BleudAuvergnebio("expired", ((TrouduCru)entry.getValue()).c()));
            c c2 = (c)((TrouduCru)entry.getValue()).a().get();
            if (c2 == null) continue;
            c2.c();
        }
    }

    public static void a(TrouduCru trouduCru) {
        VieuxLille.b(trouduCru);
        VieuxLille.a(true);
        b.put((Object)trouduCru.c().a(), (Object)trouduCru);
        new StringBuilder("final cache size ").append(b.size());
    }

    public static void a(c c2) {
        Iterator iterator = b.entrySet().iterator();
        while (iterator.hasNext()) {
            if (!cl.a((Object)((c)((TrouduCru)((Map.Entry)iterator.next()).getValue()).a().get()), c2)) continue;
            iterator.remove();
        }
    }

    public static void a(String string2) {
        Iterator iterator = b.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (!cl.a((Object)((String)entry.getKey()), (Object)string2)) continue;
            iterator.remove();
            c c2 = (c)((TrouduCru)entry.getValue()).a().get();
            if (c2 == null) continue;
            c2.a(((TrouduCru)entry.getValue()).c());
        }
    }

    private static void a(boolean bl2) {
        new StringBuilder("clean cache ").append(b.size());
        Iterator iterator = b.entrySet().iterator();
        while (iterator.hasNext()) {
            if (((TrouduCru)((Map.Entry)iterator.next()).getValue()).a().get() != null) continue;
            iterator.remove();
        }
        if (bl2 || !b.isEmpty()) {
            c.removeCallbacksAndMessages(null);
            c.postDelayed(d, 1200000L);
        }
        new StringBuilder("after cache ").append(b.size());
    }

    public static j b(String string2) {
        boolean bl2 = b.containsKey((Object)string2);
        j j2 = null;
        if (bl2) {
            TrouduCru trouduCru = (TrouduCru)b.get((Object)string2);
            j2 = null;
            if (trouduCru != null) {
                j2 = trouduCru.b();
            }
            b.remove((Object)string2);
        }
        return j2;
    }

    private static void b(TrouduCru trouduCru) {
        if (e != null) {
            return;
        }
        Context context = trouduCru.b().getContext();
        cl.a((Object)context, "mraidCacheItem.webView.context");
        FourmedAmbert fourmedAmbert = FourmedAmbertBio.a(context);
        if (fourmedAmbert != null) {
            Integer n2 = fourmedAmbert.g() > 0 ? Integer.valueOf((int)fourmedAmbert.g()) : null;
            e = n2;
        }
    }

    private static boolean c(TrouduCru trouduCru) {
        Context context = trouduCru.b().getContext();
        cl.a((Object)context, "mraidCacheItem.webView.context");
        FourmedAmbert fourmedAmbert = FourmedAmbertBio.a(context);
        long l2 = System.currentTimeMillis() - trouduCru.d();
        return fourmedAmbert != null && l2 > fourmedAmbert.k();
    }

}

