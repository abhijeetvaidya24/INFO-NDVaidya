/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Pair
 *  java.io.UnsupportedEncodingException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URLEncoder
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Vector
 */
package com.ironsource.mediationsdk.server;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.environment.ApplicationContext;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class ServerURL {
    private static String BASE_URL_PREFIX = "https://init.supersonicads.com/sdk/v";
    private static String BASE_URL_SUFFIX = "?request=";

    private static String createURLParams(Vector<Pair<String, String>> vector) throws UnsupportedEncodingException {
        Iterator iterator = vector.iterator();
        String string = "";
        while (iterator.hasNext()) {
            Pair pair = (Pair)iterator.next();
            if (string.length() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("&");
                string = stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append((String)pair.first);
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode((String)((String)pair.second), (String)"UTF-8"));
            string = stringBuilder.toString();
        }
        return string;
    }

    private static String getBaseUrl(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BASE_URL_PREFIX);
        stringBuilder.append(string);
        stringBuilder.append(BASE_URL_SUFFIX);
        return stringBuilder.toString();
    }

    public static String getCPVProvidersURL(Context context, String string, String string2, String string3, String string4, Vector<Pair<String, String>> vector) throws UnsupportedEncodingException {
        String string5;
        Vector vector2 = new Vector();
        vector2.add((Object)new Pair((Object)"platform", (Object)"android"));
        vector2.add((Object)new Pair((Object)"applicationKey", (Object)string));
        vector2.add((Object)new Pair((Object)"applicationUserId", (Object)string2));
        vector2.add((Object)new Pair((Object)"sdkVersion", (Object)IronSourceUtils.getSDKVersion()));
        if (IronSourceUtils.getSerr() == 0) {
            vector2.add((Object)new Pair((Object)"serr", (Object)String.valueOf((int)IronSourceUtils.getSerr())));
        }
        if (!TextUtils.isEmpty((CharSequence)ConfigFile.getConfigFile().getPluginType())) {
            vector2.add((Object)new Pair((Object)"pluginType", (Object)ConfigFile.getConfigFile().getPluginType()));
        }
        if (!TextUtils.isEmpty((CharSequence)ConfigFile.getConfigFile().getPluginVersion())) {
            vector2.add((Object)new Pair((Object)"pluginVersion", (Object)ConfigFile.getConfigFile().getPluginVersion()));
        }
        if (!TextUtils.isEmpty((CharSequence)ConfigFile.getConfigFile().getPluginFrameworkVersion())) {
            vector2.add((Object)new Pair((Object)"plugin_fw_v", (Object)ConfigFile.getConfigFile().getPluginFrameworkVersion()));
        }
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            vector2.add((Object)new Pair((Object)"advId", (Object)string3));
        }
        if (!TextUtils.isEmpty((CharSequence)string4)) {
            vector2.add((Object)new Pair((Object)"mt", (Object)string4));
        }
        if (!TextUtils.isEmpty((CharSequence)(string5 = ApplicationContext.getPublisherApplicationVersion(context, context.getPackageName())))) {
            vector2.add((Object)new Pair((Object)"appVer", (Object)string5));
        }
        int n2 = Build.VERSION.SDK_INT;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n2);
        stringBuilder.append("");
        vector2.add((Object)new Pair((Object)"osVer", (Object)stringBuilder.toString()));
        vector2.add((Object)new Pair((Object)"devMake", (Object)Build.MANUFACTURER));
        vector2.add((Object)new Pair((Object)"devModel", (Object)Build.MODEL));
        String string6 = IronSourceUtils.getConnectionType(context);
        if (!TextUtils.isEmpty((CharSequence)string6)) {
            vector2.add((Object)new Pair((Object)"connType", (Object)string6));
        }
        if (vector != null) {
            vector2.addAll(vector);
        }
        String string7 = URLEncoder.encode((String)IronSourceAES.encode("C38FB23A402222A0C17D34A92F971D1F", ServerURL.createURLParams((Vector<Pair<String, String>>)vector2)), (String)"UTF-8");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(ServerURL.getBaseUrl(IronSourceUtils.getSDKVersion()));
        stringBuilder2.append(string7);
        return stringBuilder2.toString();
    }

    public static String getRequestURL(String string, boolean bl2, int n2) throws UnsupportedEncodingException {
        Vector vector = new Vector();
        vector.add((Object)new Pair((Object)"impression", (Object)Boolean.toString((boolean)bl2)));
        vector.add((Object)new Pair((Object)"placementId", (Object)Integer.toString((int)n2)));
        String string2 = ServerURL.createURLParams((Vector<Pair<String, String>>)vector);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("&");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

