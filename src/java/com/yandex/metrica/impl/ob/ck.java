/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageItemInfo
 *  android.content.pm.ServiceInfo
 *  com.yandex.metrica.YandexMetrica
 *  com.yandex.metrica.impl.be
 *  com.yandex.metrica.impl.be$a
 *  com.yandex.metrica.impl.bi
 *  com.yandex.metrica.impl.ob.cg
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.ServiceInfo;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.be;
import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.ob.ce;
import com.yandex.metrica.impl.ob.cf;
import com.yandex.metrica.impl.ob.cg;
import com.yandex.metrica.impl.ob.ch;
import com.yandex.metrica.impl.ob.ci;
import com.yandex.metrica.impl.ob.cj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ck {
    private ci a;

    public ck(ci ci2) {
        this.a = ci2;
    }

    private static String a(Context context, ArrayList<cf> arrayList) {
        String string2 = context.getPackageName();
        Iterator iterator = arrayList.iterator();
        cf cf2 = null;
        cf cf3 = null;
        while (iterator.hasNext()) {
            cf cf4 = (cf)iterator.next();
            if (string2.equals((Object)((ce)cf4.d().get((int)0)).c().e)) {
                cf2 = cf4;
                continue;
            }
            cf3 = cf4;
        }
        if (cf2 == null) {
            return null;
        }
        if (!cf3.a()) {
            return cf3.c();
        }
        if (cf2.a()) {
            return cf3.c();
        }
        return cf2.c();
    }

    private String a(Context context, Map<String, cf> map) {
        ck.a(context, "method_carriers_count", map.size());
        ArrayList arrayList = new ArrayList();
        Iterator iterator = map.values().iterator();
        int n2 = 0;
        while (iterator.hasNext()) {
            cf cf2 = (cf)iterator.next();
            int n3 = cf2.b();
            if (n3 > n2) {
                arrayList.clear();
                arrayList.add((Object)cf2);
                n2 = n3;
                continue;
            }
            if (n3 != n2) continue;
            arrayList.add((Object)cf2);
        }
        if (arrayList.size() == 1) {
            return ((cf)arrayList.get(0)).c();
        }
        String string2 = ((cf)arrayList.get(0)).b() == 1 ? ck.a(context, (ArrayList<cf>)arrayList) : null;
        if (string2 == null) {
            List<cf> list = ck.a((List<cf>)arrayList);
            if (list == null) {
                return this.a(context, (List<cf>)arrayList);
            }
            return this.a(context, list);
        }
        return string2;
    }

    private static List<cf> a(List<cf> list) {
        ArrayList arrayList = new ArrayList();
        for (cf cf2 : list) {
            if (cf2.a()) continue;
            arrayList.add((Object)cf2);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static void a(Context context, String string2, final int n2) {
        YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("multiple_device_ids", (Map)new HashMap<String, Object>(){
            {
                this.put((Object)String.this, (Object)new HashMap<String, Object>(){
                    {
                        this.put((Object)"candidates_count", (Object)n2);
                    }
                });
            }

        });
    }

    private static String b(Context context, List<cf> list) {
        ck.a(context, "method_device_id_comparing", list.size());
        Iterator iterator = list.iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            cf cf2 = (cf)iterator.next();
            if (cf2.c().compareTo(string2) <= 0) continue;
            string2 = cf2.c();
        }
        return string2;
    }

    private static void c(Context context, List<ce> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ce ce2 : list) {
            stringBuilder.append(ce2.c().d.packageName);
            stringBuilder.append(" ");
            stringBuilder.append(ce2.toString());
            stringBuilder.append('\n');
        }
        YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("multiple_device_ids", (Map)new HashMap<String, Object>(){
            {
                this.put((Object)"data", (Object)StringBuilder.this.toString());
            }
        });
    }

    public String a(Context context) {
        return this.b(context);
    }

    String a(Context context, List<cf> list) {
        ck.a(context, "method_first_installed", list.size());
        ArrayList arrayList = new ArrayList();
        Long l2 = Long.MAX_VALUE;
        for (cf cf2 : list) {
            Long l3 = cf2.e();
            int n2 = l3.compareTo(l2);
            if (n2 < 0) {
                arrayList.clear();
                arrayList.add((Object)cf2);
                l2 = l3;
                continue;
            }
            if (n2 != 0) continue;
            arrayList.add((Object)cf2);
        }
        if (arrayList.size() == 1) {
            return ((cf)arrayList.get(0)).c();
        }
        return ck.b(context, (List<cf>)arrayList);
    }

    String b(Context context) {
        cj cj2 = new cj(context);
        List<be.a> list = this.c(context);
        ArrayList arrayList = new ArrayList(list.size());
        LinkedList linkedList = new LinkedList();
        for (be.a a2 : list) {
            Object object;
            if (be.a((PackageItemInfo)a2.d) < 29) {
                linkedList.add((Object)a2);
                continue;
            }
            if (this.a.e()) {
                String string2 = a2.d.applicationInfo.packageName;
                ch ch2 = this.a.a(context, string2);
                ch ch3 = this.a.b(context, string2);
                object = ch2 == null && ch3 == null ? null : new cg(a2, ch3, ch2);
            } else {
                String string3 = a2.d.applicationInfo.packageName;
                ch ch4 = this.a.a(context, string3);
                object = null;
                if (ch4 != null) {
                    boolean bl2 = bi.a((String)ch4.c());
                    object = null;
                    if (!bl2) {
                        object = new ce(a2, ch4);
                    }
                }
            }
            if (object == null) continue;
            arrayList.add(object);
        }
        for (be.a a3 : linkedList) {
            String string4 = a3.d.packageName;
            String string5 = this.a.f(context, string4);
            if (bi.a((String)string5)) continue;
            arrayList.add((Object)new ce(a3, new ch(string5, null, -1L)));
        }
        if (!arrayList.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (ce ce2 : arrayList) {
                String string6 = ce2.a();
                cf cf2 = (cf)hashMap.get((Object)string6);
                if (cf2 == null) {
                    cf2 = new cf(string6, cj2);
                    hashMap.put((Object)string6, (Object)cf2);
                }
                cf2.a(ce2);
            }
            if (hashMap.size() == 1) {
                Iterator iterator = hashMap.values().iterator();
                if (iterator.hasNext()) {
                    return ((cf)iterator.next()).c();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Smth wrong when iterate through initial candidates list");
                stringBuilder.append('\n');
                YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("multiple_device_ids", (Map)new HashMap<String, Object>(){
                    {
                        this.put((Object)"error", (Object)StringBuilder.this.toString());
                    }
                });
            } else {
                ck.c(context, (List<ce>)arrayList);
                return this.a(context, (Map<String, cf>)hashMap);
            }
        }
        return "";
    }

    List<be.a> c(Context context) {
        return be.b((Context)context);
    }

}

