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
 *  java.util.Locale
 *  java.util.Map
 */
package com.applovin.impl.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.p;
import java.util.Locale;
import java.util.Map;

public class k {
    private Uri a;
    private Uri b;
    private a c;
    private String d;
    private int e;
    private int f;
    private int g;

    private k() {
    }

    private static a a(String string) {
        if (j.b((String)string)) {
            if ("progressive".equalsIgnoreCase(string)) {
                return a.a;
            }
            if ("streaming".equalsIgnoreCase(string)) {
                return a.b;
            }
        }
        return a.a;
    }

    public static k a(n n2, com.applovin.impl.sdk.j j2) {
        if (n2 != null) {
            if (j2 != null) {
                block5 : {
                    String string = n2.c();
                    if (!URLUtil.isValidUrl((String)string)) break block5;
                    Uri uri = Uri.parse((String)string);
                    k k2 = new k();
                    k2.a = uri;
                    k2.b = uri;
                    k2.g = j.a((String)((String)n2.b().get((Object)"bitrate")));
                    k2.c = k.a((String)n2.b().get((Object)"delivery"));
                    k2.f = j.a((String)((String)n2.b().get((Object)"height")));
                    k2.e = j.a((String)((String)n2.b().get((Object)"width")));
                    k2.d = ((String)n2.b().get((Object)"type")).toLowerCase(Locale.ENGLISH);
                    return k2;
                }
                try {
                    j2.u().d("VastVideoFile", "Unable to create video file. Could not find URL.");
                }
                catch (Throwable throwable) {
                    j2.u().b("VastVideoFile", "Error occurred while initializing", throwable);
                }
                return null;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }
        throw new IllegalArgumentException("No node specified.");
    }

    public Uri a() {
        return this.a;
    }

    public void a(Uri uri) {
        this.b = uri;
    }

    public Uri b() {
        return this.b;
    }

    public boolean c() {
        return this.c == a.b;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.g;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof k)) {
            return false;
        }
        k k2 = (k)object;
        if (this.e != k2.e) {
            return false;
        }
        if (this.f != k2.f) {
            return false;
        }
        if (this.g != k2.g) {
            return false;
        }
        Uri uri = this.a;
        if (uri != null ? !uri.equals((Object)k2.a) : k2.a != null) {
            return false;
        }
        Uri uri2 = this.b;
        if (uri2 != null ? !uri2.equals((Object)k2.b) : k2.b != null) {
            return false;
        }
        if (this.c != k2.c) {
            return false;
        }
        String string = this.d;
        if (string != null) {
            return string.equals((Object)k2.d);
        }
        return k2.d == null;
    }

    public int hashCode() {
        Uri uri = this.a;
        int n2 = uri != null ? uri.hashCode() : 0;
        int n3 = n2 * 31;
        Uri uri2 = this.b;
        int n4 = uri2 != null ? uri2.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        a a2 = this.c;
        int n6 = a2 != null ? a2.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        String string = this.d;
        int n8 = 0;
        if (string != null) {
            n8 = string.hashCode();
        }
        return 31 * (31 * (31 * (n7 + n8) + this.e) + this.f) + this.g;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VastVideoFile{sourceVideoUri=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", videoUri=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", deliveryType=");
        stringBuilder.append((Object)this.c);
        stringBuilder.append(", fileType='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", width=");
        stringBuilder.append(this.e);
        stringBuilder.append(", height=");
        stringBuilder.append(this.f);
        stringBuilder.append(", bitrate=");
        stringBuilder.append(this.g);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        private static final /* synthetic */ a[] c;

        static {
            a[] arra = new a[]{a, b};
            c = arra;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])c.clone();
        }
    }

}

