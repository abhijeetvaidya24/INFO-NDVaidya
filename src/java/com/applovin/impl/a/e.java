/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.webkit.URLUtil
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.e.n
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.p;

public class e {
    private a a;
    private Uri b;
    private String c;

    private e() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static e a(n var0, e var1_1, com.applovin.impl.sdk.j var2_2) {
        if (var0 == null) throw new IllegalArgumentException("No node specified.");
        if (var2_2 == null) throw new IllegalArgumentException("No sdk specified.");
        if (var1_1 != null) ** GOTO lbl6
        try {
            var1_1 = new e();
lbl6: // 2 sources:
            if (var1_1.b != null) return var1_1;
            if (j.b((String)var1_1.c) != false) return var1_1;
            var4_3 = e.a(var0, "StaticResource");
            if (URLUtil.isValidUrl((String)var4_3)) {
                var1_1.b = Uri.parse((String)var4_3);
                var1_1.a = a.b;
                return var1_1;
            }
            var5_4 = e.a(var0, "IFrameResource");
            if (j.b((String)var5_4)) {
                var1_1.a = a.c;
                if (URLUtil.isValidUrl((String)var5_4)) {
                    var1_1.b = Uri.parse((String)var5_4);
                    return var1_1;
                }
                var1_1.c = var5_4;
                return var1_1;
            }
            var6_5 = e.a(var0, "HTMLResource");
            if (j.b((String)var6_5) == false) return var1_1;
            var1_1.a = a.d;
            if (URLUtil.isValidUrl((String)var6_5)) {
                var1_1.b = Uri.parse((String)var6_5);
                return var1_1;
            }
            var1_1.c = var6_5;
            return var1_1;
        }
        catch (Throwable var3_6) {
            var2_2.u().b("VastNonVideoResource", "Error occurred while initializing", var3_6);
            return null;
        }
    }

    private static String a(n n2, String string) {
        n n3 = n2.b(string);
        if (n3 != null) {
            return n3.c();
        }
        return null;
    }

    public a a() {
        return this.a;
    }

    public void a(Uri uri) {
        this.b = uri;
    }

    public void a(String string) {
        this.c = string;
    }

    public Uri b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof e)) {
            return false;
        }
        e e2 = (e)object;
        if (this.a != e2.a) {
            return false;
        }
        Uri uri = this.b;
        if (uri != null ? !uri.equals((Object)e2.b) : e2.b != null) {
            return false;
        }
        String string = this.c;
        if (string != null) {
            return string.equals((Object)e2.c);
        }
        return e2.c == null;
    }

    public int hashCode() {
        a a2 = this.a;
        int n2 = a2 != null ? a2.hashCode() : 0;
        int n3 = n2 * 31;
        Uri uri = this.b;
        int n4 = uri != null ? uri.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        String string = this.c;
        int n6 = 0;
        if (string != null) {
            n6 = string.hashCode();
        }
        return n5 + n6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VastNonVideoResource{type=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", resourceUri=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", resourceContents='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
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

