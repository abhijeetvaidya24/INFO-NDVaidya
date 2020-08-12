/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 */
package com.appsgeyser.multiTabApp.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Constructor;

public class UserAgentManager {
    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String getDefaultUserAgent(Context context) {
        Constructor constructor;
        if (Build.VERSION.SDK_INT >= 17) {
            return NewApiWrapper.getDefaultUserAgent(context);
        }
        try {
            constructor = WebSettings.class.getDeclaredConstructor(new Class[]{Context.class, WebView.class});
            constructor.setAccessible(true);
        }
        catch (Exception exception) {
            return new WebView(context).getSettings().getUserAgentString();
        }
        String string2 = ((WebSettings)constructor.newInstance(new Object[]{context, null})).getUserAgentString();
        {
            catch (Throwable throwable) {
                constructor.setAccessible(false);
                throw throwable;
            }
        }
        constructor.setAccessible(false);
        return string2;
    }

    public static String getDesktopUserAgent(Context context) {
        return context.getString(2131755115);
    }

    @TargetApi(value=17)
    static class NewApiWrapper {
        static String getDefaultUserAgent(Context context) {
            return WebSettings.getDefaultUserAgent((Context)context);
        }
    }

}

