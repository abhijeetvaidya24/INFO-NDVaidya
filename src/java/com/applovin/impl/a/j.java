/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.webkit.MimeTypeMap
 *  com.applovin.impl.sdk.b.b
 *  com.applovin.impl.sdk.e.d
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.e.n
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.a.c;
import com.applovin.impl.a.g;
import com.applovin.impl.a.i;
import com.applovin.impl.a.k;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class j {
    private List<k> a = Collections.EMPTY_LIST;
    private List<String> b = Collections.EMPTY_LIST;
    private int c;
    private Uri d;
    private final Set<g> e = new HashSet();
    private final Map<String, Set<g>> f = new HashMap();

    private j() {
    }

    private j(c c2) {
        this.b = c2.h();
    }

    /*
     * Exception decompiling
     */
    private static int a(String var0, com.applovin.impl.sdk.j var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl69 : ICONST_0 : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static j a(n var0, j var1_1, c var2_2, com.applovin.impl.sdk.j var3_3) {
        if (var0 == null) throw new IllegalArgumentException("No node specified.");
        if (var2_2 == null) throw new IllegalArgumentException("No context specified.");
        if (var3_3 == null) throw new IllegalArgumentException("No sdk specified.");
        if (var1_1 != null) ** GOTO lbl7
        try {
            var1_1 = new j(var2_2);
lbl7: // 2 sources:
            if (var1_1.c == 0 && (var11_4 = var0.b("Duration")) != null && (var12_5 = j.a(var11_4.c(), var3_3)) > 0) {
                var1_1.c = var12_5;
            }
            if ((var5_6 = var0.b("MediaFiles")) != null && (var6_7 = j.a(var5_6, var3_3)) != null && var6_7.size() > 0) {
                if (var1_1.a != null) {
                    var6_7.addAll(var1_1.a);
                }
                var1_1.a = var6_7;
            }
            if ((var7_8 = var0.b("VideoClicks")) != null) {
                if (var1_1.d == null && (var8_9 = var7_8.b("ClickThrough")) != null && com.applovin.impl.sdk.e.j.b((String)(var9_10 = var8_9.c()))) {
                    var1_1.d = Uri.parse((String)var9_10);
                }
                i.a((List<n>)var7_8.a("ClickTracking"), var1_1.e, var2_2, var3_3);
            }
            i.a(var0, var1_1.f, var2_2, var3_3);
            return var1_1;
        }
        catch (Throwable var4_11) {
            var3_3.u().b("VastVideoCreative", "Error occurred while initializing", var4_11);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List<k> a(n n2, com.applovin.impl.sdk.j j2) {
        List list = n2.a("MediaFile");
        ArrayList arrayList = new ArrayList(list.size());
        List list2 = d.a((String)((String)j2.a(b.eR)));
        List list3 = d.a((String)((String)j2.a(b.eQ)));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            k k2 = k.a((n)iterator.next(), j2);
            if (k2 == null) continue;
            try {
                String string;
                String string2 = k2.d();
                if (com.applovin.impl.sdk.e.j.b((String)string2) && !list2.contains((Object)string2) || ((Boolean)j2.a(b.eS)).booleanValue() && com.applovin.impl.sdk.e.j.b((String)(string = MimeTypeMap.getFileExtensionFromUrl((String)k2.b().toString()))) && !list3.contains((Object)string)) {
                    arrayList.add((Object)k2);
                    continue;
                }
                p p2 = j2.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Video file not supported: ");
                stringBuilder.append((Object)k2);
                p2.c("VastVideoCreative", stringBuilder.toString());
            }
            catch (Throwable throwable) {
                p p3 = j2.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to validate vidoe file: ");
                stringBuilder.append((Object)k2);
                p3.b("VastVideoCreative", stringBuilder.toString(), throwable);
                continue;
            }
            break;
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public k a(a a2) {
        int n2;
        List<k> list = this.a;
        if (list == null || list.size() == 0) return null;
        List<k> list2 = new List<k>(3);
        for (String string : this.b) {
            for (k k2 : this.a) {
                String string2 = k2.d();
                if (!com.applovin.impl.sdk.e.j.b((String)string2) || !string.equalsIgnoreCase(string2)) continue;
                list2.add((Object)k2);
            }
            if (list2.isEmpty()) continue;
        }
        if (list2.isEmpty()) {
            list2 = this.a;
        }
        Collections.sort(list2, (Comparator)new Comparator<k>(){

            public int a(k k2, k k3) {
                return Integer.compare((int)k2.e(), (int)k3.e());
            }

            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((k)object, (k)object2);
            }
        });
        if (a2 == a.b) {
            n2 = 0;
            do {
                return (k)list2.get(n2);
                break;
            } while (true);
        }
        if (a2 == a.c) {
            n2 = list2.size() / 2;
            return (k)list2.get(n2);
        }
        n2 = -1 + list2.size();
        return (k)list2.get(n2);
    }

    public List<k> a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public Uri c() {
        return this.d;
    }

    public Set<g> d() {
        return this.e;
    }

    public Map<String, Set<g>> e() {
        return this.f;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof j)) {
            return false;
        }
        j j2 = (j)object;
        if (this.c != j2.c) {
            return false;
        }
        List<k> list = this.a;
        if (list != null ? !list.equals(j2.a) : j2.a != null) {
            return false;
        }
        Uri uri = this.d;
        if (uri != null ? !uri.equals((Object)j2.d) : j2.d != null) {
            return false;
        }
        Set<g> set = this.e;
        if (set != null ? !set.equals(j2.e) : j2.e != null) {
            return false;
        }
        Map<String, Set<g>> map = this.f;
        if (map != null) {
            return map.equals(j2.f);
        }
        return j2.f == null;
    }

    public int hashCode() {
        List<k> list = this.a;
        int n2 = list != null ? list.hashCode() : 0;
        int n3 = 31 * (n2 * 31 + this.c);
        Uri uri = this.d;
        int n4 = uri != null ? uri.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        Set<g> set = this.e;
        int n6 = set != null ? set.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        Map<String, Set<g>> map = this.f;
        int n8 = 0;
        if (map != null) {
            n8 = map.hashCode();
        }
        return n7 + n8;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VastVideoCreative{videoFiles=");
        stringBuilder.append(this.a);
        stringBuilder.append(", durationSeconds=");
        stringBuilder.append(this.c);
        stringBuilder.append(", destinationUri=");
        stringBuilder.append((Object)this.d);
        stringBuilder.append(", clickTrackers=");
        stringBuilder.append(this.e);
        stringBuilder.append(", eventTrackers=");
        stringBuilder.append(this.f);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        private static final /* synthetic */ a[] e;

        static {
            a[] arra = new a[]{a, b, c, d};
            e = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])e.clone();
        }
    }

}

