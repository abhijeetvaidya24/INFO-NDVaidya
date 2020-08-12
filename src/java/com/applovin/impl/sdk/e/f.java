/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  com.applovin.impl.sdk.AppLovinAdServiceImpl
 *  com.applovin.impl.sdk.NativeAdServiceImpl
 *  com.applovin.impl.sdk.VariableServiceImpl
 *  com.applovin.impl.sdk.d
 *  com.applovin.impl.sdk.q
 *  java.io.ByteArrayOutputStream
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.NativeAdServiceImpl;
import com.applovin.impl.sdk.VariableServiceImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.d;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.q;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private static final int[] a = new int[]{7, 4, 2, 1, 11};
    private static final int[] b = new int[]{5, 6, 10, 3, 9, 8, 14};
    private static final int[] c = new int[]{15, 12, 13};
    private static final String d = f.class.getSimpleName();

    private static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager;
        if (k.a("android.permission.ACCESS_NETWORK_STATE", context) && (connectivityManager = (ConnectivityManager)context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(InputStream inputStream, com.applovin.impl.sdk.j j2) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] arrby = new byte[j2.a(b.dW).intValue()];
            do {
                int n2;
                if ((n2 = inputStream.read(arrby)) <= 0) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(arrby, 0, n2);
            } while (true);
        }
        catch (Throwable throwable) {
            j2.u().b(d, "Encountered error while reading stream", throwable);
            return null;
        }
    }

    public static String a(String string2, com.applovin.impl.sdk.j j2) {
        return f.a(j2.a(b.aD), string2, j2);
    }

    public static String a(String string2, String string3, com.applovin.impl.sdk.j j2) {
        if (string2 != null && string2.length() >= 4) {
            if (string3 != null) {
                if (j2 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(string3);
                    return stringBuilder.toString();
                }
                throw new IllegalArgumentException("No sdk specified");
            }
            throw new IllegalArgumentException("No endpoint specified");
        }
        throw new IllegalArgumentException("Invalid domain specified");
    }

    public static JSONObject a(JSONObject jSONObject) throws JSONException {
        return (JSONObject)jSONObject.getJSONArray("results").get(0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void a(int n2, com.applovin.impl.sdk.j j2) {
        block6 : {
            void var3_6;
            c c2;
            String string2;
            block5 : {
                block4 : {
                    c2 = j2.v();
                    if (n2 != 401) break block4;
                    b<String> b2 = b.R;
                    string2 = "";
                    c2.a(b2, string2);
                    b<String> b3 = b.T;
                    break block5;
                }
                if (n2 != 418) break block6;
                b<Boolean> b4 = b.Q;
                string2 = Boolean.valueOf((boolean)true);
            }
            c2.a((b<?>)var3_6, string2);
            c2.a();
            return;
        }
        if (n2 >= 400 && n2 < 500 || n2 == -1) {
            j2.f();
        }
    }

    private static boolean a(int n2, int[] arrn) {
        int n3 = arrn.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (arrn[i2] != n2) continue;
            return true;
        }
        return false;
    }

    public static boolean a(Context context, com.applovin.impl.sdk.j j2) {
        boolean bl = k.a("android.permission.ACCESS_NETWORK_STATE", context) && context.getSystemService("connectivity") != null;
        if (bl) {
            NetworkInfo networkInfo = f.a(context);
            if (networkInfo != null) {
                return networkInfo.isConnected();
            }
            return j2.a(b.dR);
        }
        return true;
    }

    public static String b(String string2, com.applovin.impl.sdk.j j2) {
        return f.a(j2.a(b.aE), string2, j2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Map<String, String> c(com.applovin.impl.sdk.j j2) {
        HashMap hashMap;
        block4 : {
            String string2;
            String string3;
            block3 : {
                block2 : {
                    hashMap = new HashMap();
                    string2 = j2.a(b.T);
                    if (!j.b(string2)) break block2;
                    string3 = "device_token";
                    break block3;
                }
                if (j2.a(b.eX).booleanValue()) break block4;
                string2 = j2.s();
                string3 = "api_key";
            }
            hashMap.put((Object)string3, (Object)string2);
        }
        hashMap.put((Object)"sc", (Object)j.e(j2.a(b.V)));
        hashMap.put((Object)"sc2", (Object)j.e(j2.a(b.W)));
        hashMap.put((Object)"server_installed_at", (Object)j.e(j2.a(b.X)));
        m.a("persisted_data", j.e(j2.a(com.applovin.impl.sdk.b.d.r)), (Map<String, String>)hashMap);
        return hashMap;
    }

    public static void c(JSONObject jSONObject, com.applovin.impl.sdk.j j2) {
        String string2 = g.a(jSONObject, "persisted_data", null, j2);
        if (j.b(string2)) {
            j2.a(com.applovin.impl.sdk.b.d.r, string2);
            j2.u().b(d, "Updated persisted data");
        }
    }

    public static String d(com.applovin.impl.sdk.j j2) {
        NetworkInfo networkInfo = f.a(j2.w());
        String string2 = "unknown";
        if (networkInfo != null) {
            int n2 = networkInfo.getType();
            int n3 = networkInfo.getSubtype();
            if (n2 == 1) {
                string2 = "wifi";
            } else if (n2 == 0) {
                string2 = f.a(n3, a) ? "2g" : (f.a(n3, b) ? "3g" : (f.a(n3, c) ? "4g" : "mobile"));
            }
            p p2 = j2.u();
            String string3 = d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Network ");
            stringBuilder.append(n2);
            stringBuilder.append("/");
            stringBuilder.append(n3);
            stringBuilder.append(" resolved to ");
            stringBuilder.append(string2);
            p2.a(string3, stringBuilder.toString());
        }
        return string2;
    }

    public static void d(JSONObject jSONObject, com.applovin.impl.sdk.j j2) {
        if (jSONObject != null) {
            if (j2 != null) {
                try {
                    if (jSONObject.has("settings")) {
                        c c2 = j2.v();
                        if (!jSONObject.isNull("settings")) {
                            c2.a(jSONObject.getJSONObject("settings"));
                            c2.a();
                            j2.u().a(d, "New settings processed");
                            return;
                        }
                    }
                }
                catch (JSONException jSONException) {
                    j2.u().b(d, "Unable to parse settings out of API response", jSONException);
                }
                return;
            }
            throw new IllegalArgumentException("No sdk specified");
        }
        throw new IllegalArgumentException("No response specified");
    }

    public static String e(com.applovin.impl.sdk.j j2) {
        return f.a(j2.a(b.aB), "4.0/ad", j2);
    }

    public static void e(JSONObject jSONObject, com.applovin.impl.sdk.j j2) {
        JSONArray jSONArray = g.a(jSONObject, "zones", null, j2);
        if (jSONArray != null) {
            for (com.applovin.impl.sdk.ad.d d2 : j2.O().a(jSONArray)) {
                if (d2.d()) {
                    j2.o().preloadAds(d2);
                    continue;
                }
                j2.n().preloadAds(d2);
            }
            j2.L().a(j2.O().b());
            j2.M().a(j2.O().b());
        }
    }

    public static String f(com.applovin.impl.sdk.j j2) {
        return f.a(j2.a(b.aC), "4.0/ad", j2);
    }

    public static void f(JSONObject jSONObject, com.applovin.impl.sdk.j j2) {
        JSONObject jSONObject2 = g.a(jSONObject, "variables", null, j2);
        if (jSONObject2 != null) {
            j2.r().updateVariables(jSONObject2);
        }
    }
}

