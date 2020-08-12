/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.yandex.metrica.impl.bi
 *  com.yandex.metrica.impl.ob.bz
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.List
 *  java.util.Map
 */
package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.text.TextUtils;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.ob.bz;
import java.util.List;
import java.util.Map;

public class dx {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private List<String> f;
    private long g;
    private String h;
    private String i;
    private final bz j;

    public dx(bz bz2, String string2) {
        this.j = bz2;
        this.b = this.j.b(null);
        this.c = this.j.c(null);
        this.d = this.j.d(null);
        this.f = this.j.b();
        this.a = this.j.a(null);
        this.g = this.j.a(0L);
        this.h = this.j.e(null);
        this.i = this.j.l(null);
        this.e = this.j.n(null);
        this.b(string2);
        this.e();
    }

    private void b(long l2) {
        dx dx2 = this;
        synchronized (dx2) {
            this.g = l2;
            return;
        }
    }

    private void b(Bundle bundle) {
        dx dx2 = this;
        synchronized (dx2) {
            this.b(bundle.getString("UuId"));
            String string2 = bundle.getString("DeviceId");
            if (!bi.a((String)string2)) {
                this.a(string2);
            }
            return;
        }
    }

    private void b(String string2) {
        if (bi.a((String)this.a) && !bi.a((String)string2)) {
            this.a = string2;
        }
    }

    private void c(Bundle bundle) {
        dx dx2 = this;
        synchronized (dx2) {
            String string2;
            String string3;
            String string4 = bundle.getString("AdUrlGet");
            if (!TextUtils.isEmpty((CharSequence)string4)) {
                this.c(string4);
            }
            if (!TextUtils.isEmpty((CharSequence)(string2 = bundle.getString("AdUrlReport")))) {
                this.d(string2);
            }
            if (!TextUtils.isEmpty((CharSequence)(string3 = bundle.getString("BindIdUrl")))) {
                this.e(string3);
            }
            return;
        }
    }

    private void c(String string2) {
        dx dx2 = this;
        synchronized (dx2) {
            this.c = string2;
            return;
        }
    }

    private void d(String string2) {
        dx dx2 = this;
        synchronized (dx2) {
            this.d = string2;
            return;
        }
    }

    private void e() {
        this.j.f(this.a).g(this.b).h(this.c).i(this.d).d(this.g).j(this.h).m(this.i).o(this.e).h();
    }

    private void e(String string2) {
        dx dx2 = this;
        synchronized (dx2) {
            this.e = string2;
            return;
        }
    }

    private boolean f() {
        dx dx2 = this;
        synchronized (dx2) {
            block3 : {
                String[] arrstring = new String[]{this.a, this.b};
                boolean bl2 = bi.a((String[])arrstring);
                if (bl2) break block3;
                return true;
            }
            return false;
        }
    }

    private boolean g() {
        dx dx2 = this;
        synchronized (dx2) {
            block3 : {
                String[] arrstring = new String[]{this.c};
                boolean bl2 = bi.a((String[])arrstring);
                if (bl2) break block3;
                return true;
            }
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean h() {
        dx dx2 = this;
        synchronized (dx2) {
            if (!this.f()) return false;
            boolean bl2 = this.g();
            if (!bl2) return false;
            return true;
        }
    }

    void a(long l2) {
        this.j.e(l2).h();
    }

    void a(Bundle bundle) {
        dx dx2 = this;
        synchronized (dx2) {
            String string2;
            this.b(bundle);
            this.c(bundle);
            this.b(bundle.getLong("ServerTimeOffset"));
            String string3 = bundle.getString("Clids");
            if (!bi.a((String)string3)) {
                this.h = string3;
            }
            if (!TextUtils.isEmpty((CharSequence)(string2 = bundle.getString("CookieBrowsers")))) {
                this.i = string2;
            }
            this.e();
            return;
        }
    }

    void a(String string2) {
        dx dx2 = this;
        synchronized (dx2) {
            this.b = string2;
            return;
        }
    }

    void a(List<String> list) {
        this.f = list;
        this.j.a(this.f);
    }

    void a(Map<String, String> map) {
        dx dx2 = this;
        synchronized (dx2) {
            this.b(map);
            this.c(map);
            return;
        }
    }

    boolean a() {
        long l2 = System.currentTimeMillis() / 1000L - this.j.b(0L);
        return l2 > 86400L || l2 < 0L;
        {
        }
    }

    boolean a(a a2) {
        dx dx2 = this;
        synchronized (dx2) {
            if (a.c == a2) {
                boolean bl2 = this.h();
                return bl2;
            }
            if (a.a == a2) {
                boolean bl3 = this.f();
                return bl3;
            }
            if (a.b == a2) {
                boolean bl4 = this.g();
                return bl4;
            }
            return false;
        }
    }

    List<String> b() {
        return this.f;
    }

    void b(Map<String, String> map) {
        dx dx2 = this;
        synchronized (dx2) {
            if (!bi.a((String)this.a)) {
                map.put((Object)"yandex_mobile_metrica_uuid", (Object)this.a);
            }
            if (!bi.a((String)this.b)) {
                map.put((Object)"yandex_mobile_metrica_device_id", (Object)this.b);
            }
            return;
        }
    }

    String c() {
        return this.a;
    }

    void c(Map<String, String> map) {
        dx dx2 = this;
        synchronized (dx2) {
            if (!bi.a((String)this.c)) {
                map.put((Object)"yandex_mobile_metrica_get_ad_url", (Object)this.c);
            }
            if (!bi.a((String)this.d)) {
                map.put((Object)"yandex_mobile_metrica_report_ad_url", (Object)this.d);
            }
            return;
        }
    }

    String d() {
        return this.b;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        private static final /* synthetic */ a[] d;

        static {
            a[] arra = new a[]{a, b, c};
            d = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])d.clone();
        }
    }

}

