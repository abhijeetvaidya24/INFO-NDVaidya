/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.os.Bundle
 *  com.adincube.sdk.d.b.e
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.adincube.sdk.util.d;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.adincube.sdk.d.b.e;
import com.adincube.sdk.util.b.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class b {
    public List<a> a = new ArrayList();
    private String b;
    private Context c;
    private ApplicationInfo d;

    public b(String string, Context context) {
        this.b = string;
        this.c = context;
        try {
            this.d = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        }
        catch (Exception exception) {}
    }

    private static List<String> a(String string, String string2, Map<String, String> map, List<b> list) {
        ArrayList arrayList;
        block6 : {
            String string3;
            block7 : {
                block5 : {
                    arrayList = new ArrayList();
                    arrayList.add((Object)"Add the following lines in <application> of your AndroidManifest.xml:");
                    if (map == null || map.isEmpty()) break block5;
                    StringBuilder stringBuilder = new StringBuilder("<");
                    stringBuilder.append(string);
                    arrayList.add((Object)stringBuilder.toString());
                    arrayList.add((Object)String.format((Locale)Locale.US, (String)"    android:name=\"%s\"", (Object[])new Object[]{string2}));
                    Iterator iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry entry = (Map.Entry)iterator.next();
                        Locale locale = Locale.US;
                        Object[] arrobject = new Object[]{entry.getKey(), entry.getValue()};
                        String string4 = String.format((Locale)locale, (String)"    %s=\"%s\"", (Object[])arrobject);
                        if (!iterator.hasNext()) {
                            StringBuilder stringBuilder2;
                            String string5;
                            if (list.size() == 0) {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(string4);
                                string5 = String.format((String)"></%s>", (Object[])new Object[]{string});
                            } else {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(string4);
                                string5 = ">";
                            }
                            stringBuilder2.append(string5);
                            string4 = stringBuilder2.toString();
                        }
                        arrayList.add((Object)string4);
                    }
                    if (list.size() <= 0) break block6;
                    Iterator iterator2 = list.iterator();
                    while (iterator2.hasNext()) {
                        arrayList.addAll(((b)iterator2.next()).a());
                    }
                    string3 = String.format((String)"</%s>", (Object[])new Object[]{string});
                    break block7;
                }
                string3 = String.format((Locale)Locale.US, (String)"<%s android:name=\"%s\"></%s>", (Object[])new Object[]{string, string2, string});
            }
            arrayList.add((Object)string3);
        }
        return arrayList;
    }

    private List<String> b() {
        ArrayList arrayList = new ArrayList();
        for (a a2 : this.a) {
            StringBuilder stringBuilder = new StringBuilder("    - ");
            stringBuilder.append(a2.a);
            arrayList.add((Object)stringBuilder.toString());
            for (String string : a2.b) {
                StringBuilder stringBuilder2 = new StringBuilder("        ");
                stringBuilder2.append(string);
                arrayList.add((Object)stringBuilder2.toString());
            }
        }
        return arrayList;
    }

    public final void a() {
        if (this.a.isEmpty()) {
            return;
        }
        throw new e(this.b, this.b());
    }

    public final void a(String string) {
        if (!f.a(this.c, string)) {
            a a2 = new a();
            a2.a("Missing permission '%s'", string);
            a2.b("Add <uses-permission android:name=\"%s\" /> in AndroidManifest.xml", string);
            this.a.add((Object)a2);
        }
    }

    public final void a(String string, Map<String, String> map) {
        this.a(string, map, (List<b>)Collections.emptyList());
    }

    public final void a(String string, Map<String, String> map, List<b> list) {
        Intent intent;
        try {
            Class class_ = Class.forName((String)string);
            intent = new Intent(this.c, class_);
        }
        catch (ClassNotFoundException classNotFoundException) {
            a a2 = new a();
            a2.a("Missing activity class '%s'", string);
            a2.b("Add '-keep public class %s { *; }' in your proguard config.", string);
            this.a.add((Object)a2);
            return;
        }
        if (this.c.getPackageManager().resolveActivity(intent, 65536) == null) {
            a a3 = new a();
            a3.a("Missing activity '%s'.", string);
            a3.a((Collection<String>)b.a("activity", string, map, list));
            this.a.add((Object)a3);
        }
    }

    public final void b(String string) {
        this.b(string, null, (List<b>)Collections.emptyList());
    }

    public final void b(String string, Map<String, String> map, List<b> list) {
        Intent intent;
        try {
            Class class_ = Class.forName((String)string);
            intent = new Intent(this.c, class_);
        }
        catch (ClassNotFoundException classNotFoundException) {
            a a2 = new a();
            a2.a("Missing service class '%s'", string);
            a2.b("Add '-keep public class %s { *; }' in your proguard config.", string);
            this.a.add((Object)a2);
            return;
        }
        if (this.c.getPackageManager().resolveService(intent, 65536) == null) {
            a a3 = new a();
            a3.a("Missing service '%s'.", string);
            a3.a((Collection<String>)b.a("service", string, map, list));
            this.a.add((Object)a3);
        }
    }

    public final void c(String string) {
        try {
            Class.forName((String)string);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            a a2 = new a();
            a2.a("Missing receiver class '%s'", string);
            a2.b("Add '-keep public class %s { *; }' in your proguard config.", string);
            this.a.add((Object)a2);
            return;
        }
    }

    public final void d(String string) {
        ApplicationInfo applicationInfo = this.d;
        if (applicationInfo == null) {
            return;
        }
        if (!applicationInfo.metaData.containsKey(string)) {
            a a2 = new a();
            a2.a("Missing meta-data '%s'", string);
            a2.b("Add <meta-data android:name=\"%s\" android:value=... /> in <application> of you AndroidManifest.xml", string);
            a2.b("Check the online documentation to know the value you must configure.", new Object[0]);
        }
    }

    public static final class a {
        String a;
        List<String> b = new ArrayList();

        public final /* varargs */ void a(String string, Object ... arrobject) {
            this.a = String.format((Locale)Locale.US, (String)string, (Object[])arrobject);
        }

        public final void a(Collection<String> collection) {
            this.b.addAll(collection);
        }

        public final /* varargs */ void b(String string, Object ... arrobject) {
            String string2 = String.format((Locale)Locale.US, (String)string, (Object[])arrobject);
            this.b.add((Object)string2);
        }
    }

    public static final class b {
        public List<String> a = new ArrayList();
        private List<String> b = new ArrayList();

        public final List<String> a() {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Object)"    <intent-filter>");
            Iterator iterator = this.b.iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)String.format((String)"        <category android:name=\"%s\" />", (Object[])new Object[]{(String)iterator.next()}));
            }
            Iterator iterator2 = this.a.iterator();
            while (iterator2.hasNext()) {
                arrayList.add((Object)String.format((String)"        <action android:name=\"%s\" />", (Object[])new Object[]{(String)iterator2.next()}));
            }
            arrayList.add((Object)"    </intent-filter>");
            return arrayList;
        }
    }

}

