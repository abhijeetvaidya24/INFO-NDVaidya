/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adincube.sdk.g.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.e.c;
import com.adincube.sdk.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {
    private static g c;
    List<a> a = new ArrayList();
    private Context b;

    private g(Context context) {
        this.b = context;
        this.a(context);
    }

    private a a(b b2, String string, boolean bl) {
        g g2 = this;
        synchronized (g2) {
            a a22;
            try {
                for (a a22 : this.a) {
                    boolean bl2;
                    if (a22.b != b2 || !a22.a.equals((Object)string) || (bl2 = a22.d) != bl) continue;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            return a22;
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static g a() {
        if (c != null) return c;
        Class<g> class_ = g.class;
        synchronized (g.class) {
            if (c != null) return c;
            c = new g(f.a());
            // ** MonitorExit[var1] (shouldn't be in output)
            return c;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(Context context) {
        g g2 = this;
        // MONITORENTER : g2
        if (context == null) {
            // MONITOREXIT : g2
            return;
        }
        JSONArray jSONArray = new JSONArray(context.getSharedPreferences("AIC-prefs", 0).getString("fhe", "[]"));
        for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            a a2 = new a();
            a2.a = jSONObject.getString("n");
            a2.b = b.a(jSONObject.getString("a"));
            if (jSONObject.has("f")) {
                a2.c = jSONObject.getInt("f");
            }
            a2.d = jSONObject.getBoolean("nf");
            a2.e = jSONObject.getLong("t");
            this.a.add((Object)a2);
        }
        return;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (Throwable throwable) {}
            {
                com.adincube.sdk.util.a.c("NetworkFillHistoryManager.reloadEntries", new Object[]{throwable});
                ErrorReportingHelper.report("NetworkFillHistoryManager.reloadEntries", throwable);
                // MONITOREXIT : g2
                return;
            }
        }
    }

    public final a a(b b2, String string) {
        g g2 = this;
        synchronized (g2) {
            a a2 = null;
            try {
                for (a a3 : this.a) {
                    if (a3.b != b2 || !a3.a.equals((Object)string)) continue;
                    if (a2 == null) break block5;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            {
                a a3;
                block5 : {
                    long l2 = a2.e;
                    long l3 = a3.e;
                    if (l2 >= l3) continue;
                }
                a2 = a3;
                continue;
            }
            return a2;
        }
    }

    public final List<a> a(b b2) {
        g g2 = this;
        synchronized (g2) {
            try {
                ArrayList arrayList = new ArrayList();
                for (a a2 : this.a) {
                    if (a2.b != b2 || a2.c == null) continue;
                    arrayList.add((Object)a2);
                }
                return arrayList;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void a(a a2) {
        g g2 = this;
        synchronized (g2) {
            a a3 = this.a(a2.b, a2.a, a2.d);
            if (a3 != null && a3.e < a2.e) {
                this.a.remove((Object)a3);
            }
            this.a.add((Object)a2);
            Context context = this.b;
            if (context == null) return;
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator iterator = this.a.iterator();
                do {
                    if (!iterator.hasNext()) {
                        c.a(context, "fhe", jSONArray.toString());
                        return;
                    }
                    a a4 = (a)iterator.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", (Object)a4.a);
                    jSONObject.put("a", (Object)a4.b.e);
                    if (a4.c != null) {
                        jSONObject.put("f", (Object)a4.c);
                    }
                    jSONObject.put("nf", a4.d);
                    jSONObject.put("t", a4.e);
                    jSONArray.put((Object)jSONObject);
                } while (true);
            }
            catch (Throwable throwable) {
                com.adincube.sdk.util.a.c("NetworkFillHistoryManager.saveEntries", new Object[]{throwable});
                ErrorReportingHelper.report("NetworkFillHistoryManager.saveEntries", throwable);
            }
            return;
        }
    }

    public static final class a {
        public String a;
        public b b;
        public Integer c;
        public boolean d;
        public long e;
    }

}

