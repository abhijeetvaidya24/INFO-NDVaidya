/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URISyntaxException
 *  java.net.URLDecoder
 *  java.net.URLEncoder
 *  java.nio.charset.IllegalCharsetNameException
 *  java.util.Locale
 */
package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;

class WebUtils {
    private static final String LOGTAG = "WebUtils";
    private static final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);

    WebUtils() {
    }

    public static final String encloseHtml(String string, boolean bl) {
        if (string != null) {
            if (string.indexOf("<html>") == -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<html>");
                stringBuilder.append(string);
                stringBuilder.append("</html>");
                string = stringBuilder.toString();
            }
            if (bl && string.indexOf("<!DOCTYPE html>") == -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<!DOCTYPE html>");
                stringBuilder.append(string);
                string = stringBuilder.toString();
            }
        }
        return string;
    }

    public static final void executeWebRequestInThread(final String string, final boolean bl) {
        ThreadUtils.scheduleRunnable(new Runnable(){

            public void run() {
                WebRequest webRequest = new WebRequest.WebRequestFactory().createWebRequest();
                webRequest.enableLog(true);
                webRequest.setUrlString(string);
                webRequest.setDisconnectEnabled(bl);
                try {
                    webRequest.makeCall();
                }
                catch (WebRequest.WebRequestException webRequestException) {}
            }
        });
    }

    public static final String getScheme(String string) {
        String string2 = Uri.parse((String)string).getScheme();
        if (string2 != null) {
            string2 = string2.toLowerCase(Locale.US);
        }
        return string2;
    }

    public static final String getURLDecodedString(String string) {
        if (string == null) {
            return null;
        }
        try {
            String string2 = URLDecoder.decode((String)string, (String)"UTF-8");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            logger.d("getURLDecodedString threw: %s", new Object[]{unsupportedEncodingException});
            return string;
        }
    }

    public static final String getURLEncodedString(String string) {
        if (string == null) {
            return null;
        }
        try {
            String string2 = URLEncoder.encode((String)string, (String)"UTF-8").replace((CharSequence)"+", (CharSequence)"%20").replace((CharSequence)"*", (CharSequence)"%2A").replace((CharSequence)"%7E", (CharSequence)"~");
            return string2;
        }
        catch (IllegalCharsetNameException illegalCharsetNameException) {
            logger.d("getURLEncodedString threw: %s", new Object[]{illegalCharsetNameException});
            return string;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            logger.d("getURLEncodedString threw: %s", new Object[]{unsupportedEncodingException});
            return string;
        }
    }

    public static boolean launchActivityForIntentLink(String string, Context context) {
        if (string == null || string.equals((Object)"")) {
            string = "about:blank";
        }
        MobileAdsLogger mobileAdsLogger = logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Launch Intent: ");
        stringBuilder.append(string);
        mobileAdsLogger.d(stringBuilder.toString());
        Intent intent = new Intent();
        if (string.startsWith("intent:")) {
            try {
                intent = Intent.parseUri((String)string, (int)1);
            }
            catch (URISyntaxException uRISyntaxException) {
                return false;
            }
        } else {
            intent.setData(Uri.parse((String)string));
        }
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            String string2 = intent.getAction();
            MobileAdsLogger mobileAdsLogger2 = logger;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Could not handle ");
            String string3 = string2.startsWith("market://") ? "market" : "intent";
            stringBuilder2.append(string3);
            stringBuilder2.append(" action: ");
            stringBuilder2.append(string2);
            mobileAdsLogger2.w(stringBuilder2.toString());
            return false;
        }
    }

}

