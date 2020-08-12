/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.webkit.URLUtil
 *  com.applovin.impl.a.a
 *  com.applovin.impl.sdk.ad.d
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.e.m
 *  com.applovin.impl.sdk.e.n
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.network.d
 *  com.applovin.impl.sdk.network.e
 *  com.applovin.impl.sdk.network.e$a
 *  com.applovin.impl.sdk.p
 *  com.applovin.sdk.AppLovinAdLoadListener
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.text.DateFormat
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Random
 *  java.util.Set
 *  java.util.TimeZone
 *  java.util.concurrent.TimeUnit
 */
package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.a.a;
import com.applovin.impl.a.b;
import com.applovin.impl.a.c;
import com.applovin.impl.a.d;
import com.applovin.impl.a.e;
import com.applovin.impl.a.g;
import com.applovin.impl.a.j;
import com.applovin.impl.a.k;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class i {
    private static DateFormat a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static Random b = new Random(System.currentTimeMillis());

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Uri a(String string, long l2, Uri uri, d d2, com.applovin.impl.sdk.j j2) {
        if (URLUtil.isValidUrl((String)string)) {
            String string2;
            block5 : {
                try {
                    string2 = string.replace((CharSequence)"[ERRORCODE]", (CharSequence)Integer.toString((int)d2.a()));
                    if (l2 < 0L) break block5;
                }
                catch (Throwable throwable) {
                    p p2 = j2.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to replace macros in URL string ");
                    stringBuilder.append(string);
                    p2.b("VastUtils", stringBuilder.toString(), throwable);
                    return null;
                }
                string2 = string2.replace((CharSequence)"[CONTENTPLAYHEAD]", (CharSequence)i.a(l2));
            }
            if (uri == null) return Uri.parse((String)string2.replace((CharSequence)"[CACHEBUSTING]", (CharSequence)i.a()).replace((CharSequence)"[TIMESTAMP]", (CharSequence)i.b()));
            string2 = string2.replace((CharSequence)"[ASSETURI]", (CharSequence)uri.toString());
            return Uri.parse((String)string2.replace((CharSequence)"[CACHEBUSTING]", (CharSequence)i.a()).replace((CharSequence)"[TIMESTAMP]", (CharSequence)i.b()));
        }
        j2.u().d("VastUtils", "Unable to replace macros in invalid URL string.");
        return null;
    }

    public static d a(a a2) {
        if (!i.b(a2) && !i.c(a2)) {
            return d.c;
        }
        return null;
    }

    private static String a() {
        return Integer.toString((int)(10000000 + b.nextInt(89999999)));
    }

    private static String a(long l2) {
        if (l2 > 0L) {
            long l3 = TimeUnit.SECONDS.toHours(l2);
            long l4 = TimeUnit.SECONDS.toMinutes(l2) % TimeUnit.MINUTES.toSeconds(1L);
            long l5 = l2 % TimeUnit.MINUTES.toSeconds(1L);
            Object[] arrobject = new Object[]{l3, l4, l5};
            return String.format((String)"%02d:%02d:%02d.000", (Object[])arrobject);
        }
        return "00:00:00.000";
    }

    public static String a(c c2) {
        if (c2 != null) {
            n n2;
            List<n> list = c2.b();
            int n3 = c2.b().size();
            if (n3 > 0 && (n2 = ((n)list.get(n3 - 1)).c("VASTAdTagURI")) != null) {
                return n2.c();
            }
            return null;
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    public static String a(n n2, String string, String string2) {
        String string3;
        n n3 = n2.b(string);
        if (n3 != null && com.applovin.impl.sdk.e.j.b((String)(string3 = n3.c()))) {
            return string3;
        }
        return string2;
    }

    private static Set<g> a(c c2, com.applovin.impl.sdk.j j2) {
        if (c2 != null) {
            List<n> list = c2.b();
            Set<g> set = new Set<g>(list.size());
            for (n n2 : list) {
                n n3 = n2.c("Wrapper");
                if (n3 == null) {
                    n3 = n2.c("InLine");
                }
                List list2 = n3 != null ? n3.a("Error") : n2.a("Error");
                set = i.a(set, (List<n>)list2, c2, j2);
            }
            p p2 = j2.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Retrieved ");
            stringBuilder.append(set.size());
            stringBuilder.append(" top level error trackers: ");
            stringBuilder.append(set);
            p2.a("VastUtils", stringBuilder.toString());
            return set;
        }
        return null;
    }

    private static Set<g> a(Set<g> set, List<n> list, c c2, com.applovin.impl.sdk.j j2) {
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                g g2 = g.a((n)iterator.next(), c2, j2);
                if (g2 == null) continue;
                set.add((Object)g2);
            }
        }
        return set;
    }

    public static void a(c c2, AppLovinAdLoadListener appLovinAdLoadListener, d d2, int n2, com.applovin.impl.sdk.j j2) {
        if (j2 != null) {
            m.a((AppLovinAdLoadListener)appLovinAdLoadListener, (com.applovin.impl.sdk.ad.d)c2.g(), (int)n2, (com.applovin.impl.sdk.j)j2);
            i.a(i.a(c2, j2), d2, j2);
            return;
        }
        throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(n n2, Map<String, Set<g>> map, c c2, com.applovin.impl.sdk.j j2) {
        block9 : {
            String string;
            p p2;
            block8 : {
                block7 : {
                    if (j2 == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
                        throw illegalArgumentException;
                    }
                    if (n2 != null) break block7;
                    p2 = j2.u();
                    string = "Unable to render event trackers; null node provided";
                    break block8;
                }
                if (map != null) break block9;
                p2 = j2.u();
                string = "Unable to render event trackers; null event trackers provided";
            }
            p2.d("VastUtils", string);
            return;
        }
        n n3 = n2.b("TrackingEvents");
        if (n3 == null) return;
        List list = n3.a("Tracking");
        if (list == null) return;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            n n4 = (n)iterator.next();
            String string = (String)n4.b().get((Object)"event");
            if (com.applovin.impl.sdk.e.j.b((String)string)) {
                g g2 = g.a(n4, c2, j2);
                if (g2 == null) continue;
                Set set = (Set)map.get((Object)string);
                if (set != null) {
                    set.add((Object)g2);
                    continue;
                }
                HashSet hashSet = new HashSet();
                hashSet.add((Object)g2);
                map.put((Object)string, (Object)hashSet);
                continue;
            }
            p p3 = j2.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find event for tracking node = ");
            stringBuilder.append((Object)n4);
            p3.d("VastUtils", stringBuilder.toString());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(List<n> list, Set<g> set, c c2, com.applovin.impl.sdk.j j2) {
        block7 : {
            p p2;
            String string;
            block6 : {
                block5 : {
                    if (j2 == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to render trackers. No sdk specified.");
                        throw illegalArgumentException;
                    }
                    if (list != null) break block5;
                    p2 = j2.u();
                    string = "Unable to render trackers; null nodes provided";
                    break block6;
                }
                if (set != null) break block7;
                p2 = j2.u();
                string = "Unable to render trackers; null trackers provided";
            }
            p2.d("VastUtils", string);
            return;
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            g g2 = g.a((n)iterator.next(), c2, j2);
            if (g2 == null) continue;
            set.add((Object)g2);
        }
    }

    public static void a(Set<g> set, long l2, Uri uri, d d2, com.applovin.impl.sdk.j j2) {
        IllegalArgumentException illegalArgumentException;
        if (j2 != null) {
            if (set != null && !set.isEmpty()) {
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Uri uri2 = i.a(((g)iterator.next()).b(), l2, uri, d2, j2);
                    if (uri2 == null) continue;
                    j2.F().a(com.applovin.impl.sdk.network.e.j().a(uri2.toString()).a(false).a(), false);
                }
            }
            return;
        }
        illegalArgumentException = new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        throw illegalArgumentException;
    }

    public static void a(Set<g> set, d d2, com.applovin.impl.sdk.j j2) {
        i.a(set, -1L, null, d2, j2);
    }

    public static void a(Set<g> set, com.applovin.impl.sdk.j j2) {
        i.a(set, -1L, null, d.a, j2);
    }

    public static boolean a(n n2) {
        if (n2 != null) {
            return n2.c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    private static String b() {
        a.setTimeZone(TimeZone.getDefault());
        return a.format(new Date());
    }

    public static boolean b(a a2) {
        if (a2 == null) {
            return false;
        }
        j j2 = a2.a();
        boolean bl = false;
        if (j2 != null) {
            List<k> list = j2.a();
            bl = false;
            if (list != null) {
                boolean bl2 = list.isEmpty();
                bl = false;
                if (!bl2) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public static boolean b(n n2) {
        if (n2 != null) {
            return n2.c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    public static boolean c(a a2) {
        boolean bl;
        block4 : {
            block5 : {
                if (a2 == null) {
                    return false;
                }
                b b2 = a2.d();
                bl = false;
                if (b2 == null) break block4;
                e e2 = b2.b();
                bl = false;
                if (e2 == null) break block4;
                if (e2.b() != null) break block5;
                boolean bl2 = com.applovin.impl.sdk.e.j.b((String)e2.c());
                bl = false;
                if (!bl2) break block4;
            }
            bl = true;
        }
        return bl;
    }
}

