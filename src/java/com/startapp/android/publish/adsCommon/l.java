/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Pair
 *  com.startapp.android.publish.adsCommon.l$2
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package com.startapp.android.publish.adsCommon;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Pair;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.adsCommon.l;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.metaData.h;
import com.startapp.common.Constants;
import com.startapp.common.a.c;
import com.startapp.common.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class l {
    private static List<PackageInfo> a;
    private static List<PackageInfo> b;
    private static long c = 0L;
    private static Pair<a, String> d;
    private static Pair<a, String> e;
    private static boolean f = true;
    private static boolean g;
    private static a h;

    static {
        h = a.c;
    }

    public static long a() {
        return c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Pair<String, String> a(Context context, boolean bl, boolean bl2, boolean bl3) {
        Class<l> class_ = l.class;
        synchronized (l.class) {
            Pair<a, String> pair;
            boolean bl4;
            Pair<a, String> pair2;
            block7 : {
                com.startapp.common.a.g.a("SimpleToken", 3, "getSimpleToken entered");
                pair2 = new Pair<a, String>((Object)a.a, (Object)"");
                if (!bl) return new Pair((Object)((a)((Object)((Object)((Object)pair2.first)))).toString(), pair2.second);
                try {
                    if (h == a.c) {
                        bl4 = f;
                        pair = g && !f ? l.f(context) : l.e(context);
                        break block7;
                    }
                    Pair<a, String> pair3 = h == a.a ? l.e(context) : l.f(context);
                    pair2 = pair3;
                    return new Pair((Object)((a)((Object)pair2.first)).toString(), pair2.second);
                }
                catch (Exception exception) {
                    com.startapp.common.a.g.a("SimpleToken", 6, "failed to get simpleToken ", exception);
                }
                return new Pair((Object)((a)((Object)pair2.first)).toString(), pair2.second);
            }
            if (!bl3) {
                bl4 = !g;
            }
            g = bl4;
            if (!bl2) {
                if (k.a(context, "shared_prefs_simple_token", "").equals(pair.second)) return new Pair((Object)((a)((Object)((Object)((Object)pair2.first)))).toString(), pair2.second);
            }
            pair2 = pair;
            return new Pair((Object)((a)((Object)((Object)((Object)pair2.first)))).toString(), pair2.second);
        }
    }

    private static List<String> a(List<PackageInfo> list) {
        com.startapp.common.a.g.a("SimpleToken", 3, "getPackagesNames entered");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            arrayList.add((Object)((PackageInfo)iterator.next()).packageName);
        }
        return arrayList;
    }

    public static void a(Context context) {
        l.c(context);
        f = true;
        g = false;
        h = a.c;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        context.getApplicationContext().registerReceiver(new BroadcastReceiver(){

            public void onReceive(Context context, Intent intent) {
                l.b();
                l.c(context);
            }
        }, intentFilter);
        MetaData.getInstance().addMetaDataListener((com.startapp.android.publish.common.metaData.d)new 2(context));
    }

    public static void a(Context context, boolean bl) {
        com.startapp.common.a.g.a("SimpleToken", 3, "initSimpleToken entered");
        if ((d == null || e == null) && bl) {
            try {
                l.g(context);
                d = new Pair((Object)a.a, (Object)com.startapp.common.f.a(l.a(a)));
                e = new Pair((Object)a.b, (Object)com.startapp.common.f.a(l.a(b)));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("simpleToken : [");
                stringBuilder.append(d);
                stringBuilder.append("]");
                com.startapp.common.a.g.a("SimpleToken", 3, stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("simpleToken2 : [");
                stringBuilder2.append(e);
                stringBuilder2.append("]");
                com.startapp.common.a.g.a("SimpleToken", 3, stringBuilder2.toString());
                return;
            }
            catch (Exception exception) {
                com.startapp.common.a.g.a("SimpleToken", 6, "initSimpleToken failed", exception);
                f.a(context, d.b, "initSimpleToken", exception.getMessage(), "");
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(PackageInfo packageInfo, PackageManager packageManager, Set<String> set) {
        String string = packageManager.getInstallerPackageName(packageInfo.packageName);
        if (set == null) return;
        try {
            if (!set.contains((Object)string)) return;
            b.add((Object)packageInfo);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("addToPackagesFromInstallers - can't add app to list ");
            stringBuilder.append(exception.getMessage());
            com.startapp.common.a.g.a("SimpleToken", 6, stringBuilder.toString());
        }
    }

    public static void a(Pair<String, String> pair) {
        com.startapp.common.a.g.a("SimpleToken", 3, "errorSendingToken entered");
        h = a.valueOf((String)pair.first);
    }

    private static List<PackageInfo> b(List<PackageInfo> list) {
        if (list.size() <= 100) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        l.c((List<PackageInfo>)arrayList);
        return arrayList.subList(0, 100);
    }

    public static void b() {
        d = null;
        e = null;
    }

    public static void b(Context context) {
        l.a(context, MetaData.getInstance().getSimpleTokenConfig().b(context));
    }

    public static Pair<String, String> c() {
        Pair<a, String> pair = d;
        if (pair != null) {
            return new Pair((Object)((a)((Object)pair.first)).toString(), l.d.second);
        }
        return new Pair((Object)a.a.toString(), (Object)"");
    }

    public static void c(final Context context) {
        com.startapp.common.a.g.a("SimpleToken", 3, "initSimpleTokenAsync entered");
        try {
            if ((d == null || e == null) && MetaData.getInstance().getSimpleTokenConfig().b(context)) {
                g.a(g.a.b, new Runnable(){

                    public void run() {
                        l.b(context);
                    }
                });
                return;
            }
        }
        catch (Exception exception) {
            com.startapp.common.a.g.a("SimpleToken", 6, "initSimpleTokenAsync failed", exception);
            f.a(context, d.b, "initSimpleTokenAsync", exception.getMessage(), "");
        }
    }

    private static void c(List<PackageInfo> list) {
        if (Build.VERSION.SDK_INT >= 9) {
            Collections.sort(list, (Comparator)new Comparator<PackageInfo>(){

                @SuppressLint(value={"InlinedApi"})
                public int a(PackageInfo packageInfo, PackageInfo packageInfo2) {
                    long l2 = packageInfo.firstInstallTime;
                    long l3 = packageInfo2.firstInstallTime;
                    if (l2 > l3) {
                        return -1;
                    }
                    return l2 != l3;
                }

                @SuppressLint(value={"InlinedApi"})
                public /* synthetic */ int compare(Object object, Object object2) {
                    return this.a((PackageInfo)object, (PackageInfo)object2);
                }
            });
        }
    }

    public static Pair<String, String> d() {
        Pair<a, String> pair = e;
        if (pair != null) {
            return new Pair((Object)((a)((Object)pair.first)).toString(), l.e.second);
        }
        return new Pair((Object)a.b.toString(), (Object)"");
    }

    public static Pair<String, String> d(Context context) {
        return l.a(context, MetaData.getInstance().getSimpleTokenConfig().b(context), MetaData.getInstance().isAlwaysSendToken(), MetaData.getInstance().isToken1Mandatory());
    }

    private static Pair<a, String> e(Context context) {
        if (d == null) {
            l.b(context);
        }
        k.b(context, "shared_prefs_simple_token", (String)l.d.second);
        f = false;
        h = a.c;
        return new Pair((Object)a.a, l.d.second);
    }

    private static Pair<a, String> f(Context context) {
        if (e == null) {
            l.b(context);
        }
        k.b(context, "shared_prefs_simple_token2", (String)l.e.second);
        f = false;
        h = a.c;
        return new Pair((Object)a.b, l.e.second);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void g(Context context) {
        Class<l> class_ = l.class;
        synchronized (l.class) {
            long l2;
            List<PackageInfo> list;
            com.startapp.common.a.g.a("SimpleToken", 3, "getPackages entered");
            PackageManager packageManager = context.getPackageManager();
            Set<String> set = MetaData.getInstance().getInstallersList();
            Set<String> set2 = MetaData.getInstance().getPreInstalledPackages();
            a = new CopyOnWriteArrayList();
            b = new CopyOnWriteArrayList();
            try {
                list = c.a(packageManager);
                l2 = Build.VERSION.SDK_INT >= 9 ? Long.MAX_VALUE : 0L;
            }
            catch (Exception exception) {
                com.startapp.common.a.g.a("SimpleToken", 6, "Could not complete getInstalledPackages", exception);
                // ** MonitorExit[var14_1] (shouldn't be in output)
                return;
            }
            c = l2;
            PackageInfo packageInfo = null;
            Iterator iterator = list.iterator();
            do {
                if (!iterator.hasNext()) {
                    a = l.b(a);
                    b = l.b(b);
                    if (packageInfo == null) return;
                    a.add(0, packageInfo);
                    // ** MonitorExit[var14_1] (shouldn't be in output)
                    return;
                }
                PackageInfo packageInfo2 = (PackageInfo)iterator.next();
                if (Build.VERSION.SDK_INT >= 9 && c > packageInfo2.firstInstallTime) {
                    c = packageInfo2.firstInstallTime;
                }
                if (!c.a(packageInfo2)) {
                    a.add((Object)packageInfo2);
                    l.a(packageInfo2, packageManager, set);
                    continue;
                }
                if (set2.contains((Object)packageInfo2.packageName)) {
                    a.add((Object)packageInfo2);
                    continue;
                }
                if (!packageInfo2.packageName.equals((Object)Constants.a)) continue;
                packageInfo = packageInfo2;
            } while (true);
        }
    }

    private static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("token");
        public static final /* enum */ a b = new a("token2");
        public static final /* enum */ a c = new a("");
        private static final /* synthetic */ a[] d;
        private final String text;

        static {
            a[] arra = new a[]{a, b, c};
            d = arra;
        }

        private a(String string2) {
            this.text = string2;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])d.clone();
        }

        public String toString() {
            return this.text;
        }
    }

}

