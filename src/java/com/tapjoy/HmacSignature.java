/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.tapjoy.TapjoyLog
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Key
 *  java.util.Collection
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeSet
 *  javax.crypto.Mac
 *  javax.crypto.spec.SecretKeySpec
 */
package com.tapjoy;

import android.net.Uri;
import com.tapjoy.TapjoyLog;
import java.security.Key;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSignature {
    private String a;
    private String b;

    public HmacSignature(String string, String string2) {
        this.a = string;
        this.b = string2;
    }

    private static String a(Map map) {
        TreeSet treeSet = new TreeSet((Collection)map.keySet());
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : treeSet) {
            String string2 = (String)map.get((Object)string);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append("=");
            stringBuilder2.append(string2);
            stringBuilder2.append("&");
            stringBuilder.append(stringBuilder2.toString());
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("&"));
        StringBuilder stringBuilder3 = new StringBuilder("Unhashed String: ");
        stringBuilder3.append(stringBuilder.toString());
        TapjoyLog.v((String)"HmacSignature", (String)stringBuilder3.toString());
        return stringBuilder.toString();
    }

    public boolean matches(String string, Map map, String string2) {
        return this.sign(string, map).equals((Object)string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String sign(String string, Map map) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.b.getBytes(), this.a);
            Mac mac = Mac.getInstance((String)this.a);
            mac.init((Key)secretKeySpec);
            Uri uri = Uri.parse((String)string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(uri.getScheme());
            stringBuilder.append("://");
            stringBuilder.append(uri.getHost());
            String string2 = stringBuilder.toString();
            boolean bl = uri.getScheme().equals((Object)"http");
            int n2 = 0;
            boolean bl2 = bl && uri.getPort() == 80 || uri.getScheme().equals((Object)"https") && uri.getPort() == 443;
            if (!bl2 && -1 != uri.getPort()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string2);
                stringBuilder2.append(":");
                stringBuilder2.append(uri.getPort());
                string2 = stringBuilder2.toString();
            }
            String string3 = string2.toLowerCase();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string3);
            stringBuilder3.append(uri.getPath());
            String string4 = stringBuilder3.toString();
            String string5 = HmacSignature.a(map);
            StringBuilder stringBuilder4 = new StringBuilder("POST&");
            stringBuilder4.append(Uri.encode((String)string4));
            stringBuilder4.append("&");
            stringBuilder4.append(Uri.encode((String)string5));
            String string6 = stringBuilder4.toString();
            StringBuilder stringBuilder5 = new StringBuilder("Base Url: ");
            stringBuilder5.append(string6);
            TapjoyLog.v((String)"HmacSignature", (String)stringBuilder5.toString());
            byte[] arrby = mac.doFinal(string6.getBytes());
            StringBuilder stringBuilder6 = new StringBuilder();
            int n3 = arrby.length;
            while (n2 < n3) {
                String string7 = Integer.toHexString((int)(255 & arrby[n2]));
                if (string7.length() == 1) {
                    stringBuilder6.append('0');
                }
                stringBuilder6.append(string7);
                ++n2;
            }
            return stringBuilder6.toString();
        }
        catch (Exception exception) {
            return null;
        }
    }
}

