/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.Properties
 */
package com.aerserv.sdk.factory;

import android.content.Context;
import com.aerserv.sdk.AerServAdType;
import com.aerserv.sdk.adapter.Provider;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.model.ad.ProviderAd;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.view.View;
import java.lang.reflect.Method;
import java.util.Properties;

public class ProviderFactory {
    private static final String CLASS_BANNER_POSTFIX = "BannerProvider";
    private static final String CLASS_INTERSTITIAL_POSTFIX = "InterstitialProvider";
    private static final String CLASS_PREFIX = "com.aerserv.sdk.adapter.";

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Provider buildProvider(ProviderAd providerAd, ProviderListener providerListener, Context context, AerServAdType aerServAdType, View view, String string, boolean bl, boolean bl2, Long l2, Boolean bl3, Integer n2) {
        Properties properties = new Properties();
        properties.put((Object)"providerAd", (Object)providerAd);
        properties.put((Object)"providerListener", (Object)providerListener);
        properties.put((Object)"context", (Object)context);
        if (view != null) {
            properties.put((Object)"viewGroup", (Object)view);
        }
        properties.put((Object)"controllerId", (Object)string);
        properties.put((Object)"isDebug", (Object)bl);
        properties.put((Object)"isPreload", (Object)bl2);
        properties.put((Object)"showAdTimeout", (Object)l2);
        properties.put((Object)"isBackButtonEnabled", (Object)bl3);
        properties.put((Object)"backButtonTimeout", (Object)n2);
        Class<?> class_ = ProviderFactory.getAdClass(providerAd.getProviderName(), aerServAdType);
        if (class_ == null) return null;
        Method method = class_.getMethod("getInstance", new Class[]{Properties.class});
        if (method == null) return null;
        try {
            return (Provider)method.invoke(null, new Object[]{properties});
        }
        catch (Exception exception) {
            AerServLog.e(ProviderFactory.class.getSimpleName(), "There was an error trying to create 3rd party provider.  No method found on class", exception);
        }
        return null;
    }

    private static Class<?> getAdClass(String string, AerServAdType aerServAdType) {
        Class class_;
        block3 : {
            block4 : {
                try {
                    String string2 = string.toLowerCase();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(CLASS_PREFIX);
                    stringBuilder.append(string2);
                    stringBuilder.append(".");
                    stringBuilder.append(string);
                    if (aerServAdType.equals((Object)AerServAdType.INTERSTITIAL)) {
                        stringBuilder.append(CLASS_INTERSTITIAL_POSTFIX);
                        class_ = Class.forName((String)stringBuilder.toString());
                        break block3;
                    }
                    if (!aerServAdType.equals((Object)AerServAdType.BANNER)) break block4;
                    stringBuilder.append(CLASS_BANNER_POSTFIX);
                    class_ = Class.forName((String)stringBuilder.toString());
                    break block3;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    AerServLog.w(ProviderFactory.class.getSimpleName(), "There was an error trying to create 3rd party provider.  No class in the classpath", (Exception)((Object)classNotFoundException));
                }
            }
            return null;
        }
        return class_;
    }
}

