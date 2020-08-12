/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URI
 *  java.net.URISyntaxException
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.WebUtils;
import java.net.URI;
import java.net.URISyntaxException;

class WebUtils2 {
    private final WebUtilsStatic webUtilsAdapter = new WebUtilsStatic();

    WebUtils2() {
    }

    public String encloseHtml(String string, boolean bl) {
        return this.webUtilsAdapter.encloseHtml(string, bl);
    }

    public void executeWebRequestInThread(String string, boolean bl) {
        this.webUtilsAdapter.executeWebRequestInThread(string, bl);
    }

    public String getScheme(String string) {
        return this.webUtilsAdapter.getScheme(string);
    }

    public String getURLDecodedString(String string) {
        return this.webUtilsAdapter.getURLDecodedString(string);
    }

    public String getURLEncodedString(String string) {
        return this.webUtilsAdapter.getURLEncodedString(string);
    }

    public boolean isUrlValid(String string) {
        try {
            new URI(string);
            return true;
        }
        catch (NullPointerException | URISyntaxException throwable) {
            return false;
        }
    }

    public boolean launchActivityForIntentLink(String string, Context context) {
        return this.webUtilsAdapter.launchActivityForIntentLink(string, context);
    }

    private static class WebUtilsStatic {
        private WebUtilsStatic() {
        }

        String encloseHtml(String string, boolean bl) {
            return WebUtils.encloseHtml(string, bl);
        }

        void executeWebRequestInThread(String string, boolean bl) {
            WebUtils.executeWebRequestInThread(string, bl);
        }

        String getScheme(String string) {
            return WebUtils.getScheme(string);
        }

        String getURLDecodedString(String string) {
            return WebUtils.getURLDecodedString(string);
        }

        String getURLEncodedString(String string) {
            return WebUtils.getURLEncodedString(string);
        }

        boolean launchActivityForIntentLink(String string, Context context) {
            return WebUtils.launchActivityForIntentLink(string, context);
        }
    }

}

