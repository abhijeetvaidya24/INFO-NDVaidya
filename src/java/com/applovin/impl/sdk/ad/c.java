/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import android.util.Base64;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private final j a;
    private final String b;

    public c(String string2, j j2) {
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            if (j2 != null) {
                this.b = string2;
                this.a = j2;
                return;
            }
            throw new IllegalArgumentException("No sdk specified");
        }
        throw new IllegalArgumentException("Identifier is empty");
    }

    private String a(b<String> b2) {
        for (String string2 : this.a.b(b2)) {
            if (!this.b.startsWith(string2)) continue;
            return string2;
        }
        return null;
    }

    public String a() {
        return this.b;
    }

    public a b() {
        if (this.a(b.aI) != null) {
            return a.b;
        }
        if (this.a(b.aJ) != null) {
            return a.c;
        }
        return a.a;
    }

    public String c() {
        String string2 = this.a(b.aI);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            return string2;
        }
        String string3 = this.a(b.aJ);
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            return string3;
        }
        return null;
    }

    public JSONObject d() {
        if (this.b() == a.c) {
            int n2 = this.c().length();
            String string2 = new String(Base64.decode((String)this.b.substring(n2), (int)0), "UTF-8");
            try {
                JSONObject jSONObject = new JSONObject(string2);
                p p2 = this.a.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Decoded token into ad response: ");
                stringBuilder.append((Object)jSONObject);
                p2.a("AdToken", stringBuilder.toString());
                return jSONObject;
            }
            catch (JSONException jSONException) {
                try {
                    p p3 = this.a.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to decode token '");
                    stringBuilder.append(this.b);
                    stringBuilder.append("' into JSON");
                    p3.b("AdToken", stringBuilder.toString(), jSONException);
                }
                catch (Throwable throwable) {
                    p p4 = this.a.u();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to process ad response from token '");
                    stringBuilder.append(this.b);
                    stringBuilder.append("'");
                    p4.b("AdToken", stringBuilder.toString(), throwable);
                }
            }
        }
        return null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        c c2 = (c)object;
        String string2 = this.b;
        if (string2 != null) {
            return string2.equals((Object)c2.b);
        }
        return c2.b == null;
    }

    public int hashCode() {
        String string2 = this.b;
        if (string2 != null) {
            return string2.hashCode();
        }
        return 0;
    }

    public String toString() {
        String string2 = com.applovin.impl.sdk.e.j.a(32, this.b);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdToken{id=");
        stringBuilder.append(string2);
        stringBuilder.append(", type=");
        stringBuilder.append((Object)this.b());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a("UNSPECIFIED");
        public static final /* enum */ a b = new a("REGULAR");
        public static final /* enum */ a c = new a("AD_RESPONSE_JSON");
        private static final /* synthetic */ a[] e;
        private final String d;

        static {
            a[] arra = new a[]{a, b, c};
            e = arra;
        }

        private a(String string3) {
            this.d = string3;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])e.clone();
        }

        public String toString() {
            return this.d;
        }
    }

}

