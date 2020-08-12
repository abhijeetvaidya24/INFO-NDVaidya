/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.a.a
 *  com.adincube.sdk.a.c
 *  com.adincube.sdk.g.g.c
 *  com.adincube.sdk.g.g.e
 *  com.adincube.sdk.h.f.a
 *  com.adincube.sdk.h.f.d
 *  com.adincube.sdk.h.f.e
 *  com.adincube.sdk.util.g.d
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Set
 */
package com.adincube.sdk.g.g;

import com.adincube.sdk.g.g.c;
import com.adincube.sdk.g.g.e;
import com.adincube.sdk.g.g.f;
import com.adincube.sdk.h.f.a;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.g.b;
import com.adincube.sdk.util.g.d;
import com.adincube.sdk.util.o;
import com.adincube.sdk.util.x;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class d
implements com.adincube.sdk.a.c {
    private static d c;
    public Set<e> a = new HashSet();
    private c b;

    private d(c c2) {
        this.b = c2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d a() {
        if (c != null) return c;
        Class<d> class_ = d.class;
        synchronized (d.class) {
            if (c != null) return c;
            c = new d(c.a());
            f f2 = new f();
            if (!f.a()) return c;
            c.a(f2);
            // ** MonitorExit[var2] (shouldn't be in output)
            return c;
        }
    }

    private static com.adincube.sdk.h.f.e a(com.adincube.sdk.a.a a2, String string) {
        block3 : {
            com.adincube.sdk.h.f.d d2;
            try {
                d2 = a2.a(string);
                if (d2 == null) break block3;
            }
            catch (Throwable throwable) {
                Locale locale = Locale.US;
                Object[] arrobject = new Object[]{a2.a(), string};
                throw new com.adincube.sdk.d.e.a(String.format((Locale)locale, (String)"Failed to retrieve consent status from '%s' for '%s' consent manager provider.", (Object[])arrobject), throwable);
            }
            com.adincube.sdk.h.f.e e2 = new com.adincube.sdk.h.f.e(d2, a2.a());
            return e2;
        }
        return null;
    }

    private static a b(com.adincube.sdk.a.a a2) {
        try {
            if (!x.c(a2.d())) {
                a a3 = new a(a2.d(), a2.a());
                return a3;
            }
            return null;
        }
        catch (Throwable throwable) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{a2.a()};
            throw new com.adincube.sdk.d.e.a(String.format((Locale)locale, (String)"Failed to retrieve consent string from '%s' consent manager provider.", (Object[])arrobject), throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final com.adincube.sdk.h.f.e a(String string) {
        com.adincube.sdk.h.f.e e2 = new com.adincube.sdk.h.f.e(com.adincube.sdk.h.f.d.a, null);
        try {
            boolean bl;
            Iterator iterator = this.b.b().iterator();
            while (e2.a == com.adincube.sdk.h.f.d.a && (bl = iterator.hasNext())) {
                try {
                    com.adincube.sdk.a.a a2 = (com.adincube.sdk.a.a)iterator.next();
                    c.a((com.adincube.sdk.a.a)a2);
                    a2.a((com.adincube.sdk.a.c)this);
                    com.adincube.sdk.h.f.e e3 = d.a(a2, string);
                    if (e3 == null) continue;
                    e2 = e3;
                }
                catch (com.adincube.sdk.d.e.a a3) {
                    ErrorReportingHelper.report("ConsentManagerProviderManager.getConsentStatusForNonIABVendor", (Throwable)((Object)a3));
                    a3.a();
                }
            }
            return e2;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("ConsentManagerProviderManager.getConsentStatusForNonIABVendor", new Object[]{throwable});
            ErrorReportingHelper.report("ConsentManagerProviderManager.getConsentStatusForNonIABVendor", throwable);
        }
        return e2;
    }

    public final void a(com.adincube.sdk.a.a a2) {
        try {
            if (a2 != this.b.a) {
                return;
            }
            o.a("ConsentManagerProviderManager.onConsentStatusChanged", this.a, new com.adincube.sdk.util.c.a<e>(){

                @Override
                public final /* synthetic */ void a(Object object) {
                    ((e)object).r();
                }
            });
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("ConsentManagerProviderManager.onConsentStatusChanged", new Object[]{throwable});
            ErrorReportingHelper.report("ConsentManagerProviderManager.onConsentStatusChanged", throwable);
            return;
        }
    }

    public final void a(e e2) {
        this.a.add((Object)e2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final a b() {
        a a2 = new a(null, null);
        try {
            boolean bl;
            Iterator iterator = this.b.b().iterator();
            while (x.c(a2.a) && (bl = iterator.hasNext())) {
                try {
                    com.adincube.sdk.a.a a3 = (com.adincube.sdk.a.a)iterator.next();
                    c.a((com.adincube.sdk.a.a)a3);
                    a3.a((com.adincube.sdk.a.c)this);
                    a a4 = d.b(a3);
                    if (a4 == null) continue;
                    a2 = a4;
                }
                catch (com.adincube.sdk.d.e.a a5) {
                    ErrorReportingHelper.report("ConsentManagerProviderManager.getIABConsentString", (Throwable)((Object)a5));
                    a5.a();
                }
            }
            return a2;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("ConsentManagerProviderManager.getIABConsentString", new Object[]{throwable});
            ErrorReportingHelper.report("ConsentManagerProviderManager.getIABConsentString", throwable);
        }
        return a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final com.adincube.sdk.h.f.e c() {
        com.adincube.sdk.h.f.e e2;
        a a2;
        b b2;
        block10 : {
            e2 = new com.adincube.sdk.h.f.e(com.adincube.sdk.h.f.d.a, null);
            a2 = this.b();
            if (a2 == null) return e2;
            if (x.c(a2.a)) return e2;
            new com.adincube.sdk.util.g.c();
            byte[] arrby = com.adincube.sdk.util.e.b(a2.a);
            int n2 = new com.adincube.sdk.util.g.a(arrby).b(6);
            if (n2 > 1) {
                b2 = new b();
                b2.a = n2;
                break block10;
            }
            new com.adincube.sdk.util.g.e();
            com.adincube.sdk.util.g.a a3 = new com.adincube.sdk.util.g.a(arrby);
            b2 = new com.adincube.sdk.util.g.d();
            ((com.adincube.sdk.util.g.d)b2).a = a3.b(6);
            ((com.adincube.sdk.util.g.d)b2).b = com.adincube.sdk.util.g.e.a(a3);
            ((com.adincube.sdk.util.g.d)b2).c = com.adincube.sdk.util.g.e.a(a3);
            ((com.adincube.sdk.util.g.d)b2).d = a3.b(12);
            ((com.adincube.sdk.util.g.d)b2).e = a3.b(12);
            ((com.adincube.sdk.util.g.d)b2).f = a3.b(6);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < 2; ++i2) {
                stringBuilder.appendCodePoint(65 + a3.b(6));
            }
            ((com.adincube.sdk.util.g.d)b2).g = stringBuilder.toString();
            ((com.adincube.sdk.util.g.d)b2).h = a3.b(12);
            ((com.adincube.sdk.util.g.d)b2).i = com.adincube.sdk.util.g.e.a(a3, 24);
            ((com.adincube.sdk.util.g.d)b2).j = a3.b(16);
            int n3 = a3.a();
            boolean bl = n3 == 0;
            ((com.adincube.sdk.util.g.d)b2).k = bl;
            boolean bl2 = n3 == 1;
            ((com.adincube.sdk.util.g.d)b2).m = bl2;
            if (((com.adincube.sdk.util.g.d)b2).k) {
                ((com.adincube.sdk.util.g.d)b2).l = com.adincube.sdk.util.g.e.a(a3, ((com.adincube.sdk.util.g.d)b2).j);
            }
            if (!((com.adincube.sdk.util.g.d)b2).m) break block10;
            boolean bl3 = a3.a() == 1;
            ((com.adincube.sdk.util.g.d)b2).n = bl3;
            int n4 = a3.b(12);
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < n4; ++i3) {
                if (a3.a() == 0) {
                    int n5 = a3.b(16);
                    hashSet.add((Object)new d.a(n5, n5));
                } else {
                    hashSet.add((Object)new d.a(a3.b(16), a3.b(16)));
                }
                ((com.adincube.sdk.util.g.d)b2).o = hashSet;
            }
        }
        try {
            if (!b2.a()) return new com.adincube.sdk.h.f.e(com.adincube.sdk.h.f.d.a, a2.b);
            return new com.adincube.sdk.h.f.e(com.adincube.sdk.h.f.d.c, a2.b);
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("ConsentManagerProviderManager.getConsentStatusForIABVendor", new Object[]{throwable});
            ErrorReportingHelper.report("ConsentManagerProviderManager.getConsentStatusForIABVendor", throwable);
        }
        return e2;
    }

}

