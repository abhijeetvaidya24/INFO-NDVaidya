/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.yandex.metrica.impl.bk
 *  com.yandex.metrica.impl.ob.bm
 *  com.yandex.metrica.impl.ob.bw
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.ob.bm;
import com.yandex.metrica.impl.ob.bo;
import com.yandex.metrica.impl.ob.bq;
import com.yandex.metrica.impl.ob.br;
import com.yandex.metrica.impl.ob.bs;
import com.yandex.metrica.impl.ob.bv;
import com.yandex.metrica.impl.ob.bw;
import com.yandex.metrica.impl.ob.r;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class bp {
    private static volatile bp a;
    private final Map<String, bo> b = new HashMap();
    private final Map<String, bq> c = new HashMap();
    private final Context d;
    private bo e;
    private bq f;
    private bq g;
    private bq h;
    private br i;

    public bp(Context context) {
        this.d = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static bp a(Context context) {
        if (a != null) return a;
        Class<bp> class_ = bp.class;
        synchronized (bp.class) {
            if (a != null) return a;
            a = new bp(context);
            // ** MonitorExit[var2_1] (shouldn't be in output)
            return a;
        }
    }

    private String a(String string2) {
        if (bk.a((int)21)) {
            string2 = this.b(string2);
        }
        return string2;
    }

    private String b(String string2) {
        try {
            File file;
            File file2 = this.d.getNoBackupFilesDir();
            File file3 = new File(file2, string2);
            if (!file3.exists() && (file = this.d.getDatabasePath(string2)).exists() && file.renameTo(file3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("-journal");
                String string3 = stringBuilder.toString();
                this.d.getDatabasePath(string3).renameTo(new File(file2, string3));
            }
            string2 = file3.getAbsolutePath();
        }
        catch (Exception exception) {}
        return string2;
    }

    public bo a() {
        bp bp2 = this;
        synchronized (bp2) {
            if (this.e == null) {
                this.e = this.a("metrica_data.db", bm.b());
            }
            bo bo2 = this.e;
            return bo2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public bo a(r r2) {
        bp bp2 = this;
        synchronized (bp2) {
            StringBuilder stringBuilder = new StringBuilder("db_metrica_");
            stringBuilder.append((Object)r2);
            String string2 = stringBuilder.toString();
            bo bo2 = (bo)((Object)this.b.get((Object)string2));
            if (bo2 == null) {
                bo2 = this.a(string2, bm.a());
                this.b.put((Object)string2, (Object)bo2);
            }
            return bo2;
        }
    }

    bo a(String string2, bs bs2) {
        return new bo(this.d, this.a(string2), bs2);
    }

    public bq b() {
        bp bp2 = this;
        synchronized (bp2) {
            if (this.f == null) {
                this.f = new bq(this.a(), "preferences");
            }
            bq bq2 = this.f;
            return bq2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public bq b(r r2) {
        bp bp2 = this;
        synchronized (bp2) {
            String string2 = r2.toString();
            bq bq2 = (bq)this.c.get((Object)string2);
            if (bq2 == null) {
                bq2 = new bq(this.a(r2), "preferences");
                this.c.put((Object)string2, (Object)bq2);
            }
            return bq2;
        }
    }

    public br c() {
        bp bp2 = this;
        synchronized (bp2) {
            if (this.i == null) {
                this.i = new br(this.a(), "permissions");
            }
            br br2 = this.i;
            return br2;
        }
    }

    public bq d() {
        bp bp2 = this;
        synchronized (bp2) {
            if (this.g == null) {
                this.g = new bq(this.a(), "startup");
            }
            bq bq2 = this.g;
            return bq2;
        }
    }

    public bq e() {
        bp bp2 = this;
        synchronized (bp2) {
            if (this.h == null) {
                String string2 = this.a("metrica_client_data.db");
                this.h = new bq("preferences", (bv)new bw(this.d, string2));
            }
            bq bq2 = this.h;
            return bq2;
        }
    }
}

