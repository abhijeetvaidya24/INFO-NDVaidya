/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.browser.customtabs.CustomTabsClient
 *  androidx.browser.customtabs.CustomTabsServiceConnection
 *  com.onesignal.OneSignalChromeTab$OneSignalCustomTabsServiceConnection
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.SecureRandom
 */
package com.onesignal;

import android.content.Context;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalChromeTab;
import com.onesignal.OneSignalRemoteParams;
import java.security.SecureRandom;

/*
 * Exception performing whole class analysis.
 */
class OneSignalChromeTab {
    private static boolean opened;

    static void setup(Context context, String string2, String string3, String string4) {
        if (opened) {
            return;
        }
        if (OneSignal.remoteParams.enterprise) {
            return;
        }
        if (string3 == null) {
            return;
        }
        try {
            Class.forName((String)"androidx.browser.customtabs.CustomTabsServiceConnection");
        }
        catch (ClassNotFoundException classNotFoundException) {}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("?app_id=");
        stringBuilder.append(string2);
        stringBuilder.append("&user_id=");
        stringBuilder.append(string3);
        String string5 = stringBuilder.toString();
        if (string4 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string5);
            stringBuilder2.append("&ad_id=");
            stringBuilder2.append(string4);
            string5 = stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string5);
        stringBuilder3.append("&cbs_id=");
        stringBuilder3.append(new SecureRandom().nextInt(Integer.MAX_VALUE));
        opened = CustomTabsClient.bindCustomTabsService((Context)context, (String)"com.android.chrome", (CustomTabsServiceConnection)new /* Unavailable Anonymous Inner Class!! */);
    }
}

