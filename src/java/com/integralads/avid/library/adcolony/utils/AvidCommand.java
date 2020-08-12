/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.utils;

import org.json.JSONObject;

public class AvidCommand {
    public static String callAvidbridge(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript: if(window.avidbridge!==undefined){avidbridge.");
        stringBuilder.append(string);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String formatJavaScript(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript: ");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static String publishReadyEventForDeferredAdSession() {
        return AvidCommand.callAvidbridge("publishReadyEventForDeferredAdSession()");
    }

    public static String publishVideoEvent(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("publishVideoEvent(");
        stringBuilder.append(JSONObject.quote((String)string));
        stringBuilder.append(")");
        return AvidCommand.callAvidbridge(stringBuilder.toString());
    }

    public static String publishVideoEvent(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("publishVideoEvent(");
        stringBuilder.append(JSONObject.quote((String)string));
        stringBuilder.append(",");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return AvidCommand.callAvidbridge(stringBuilder.toString());
    }

    public static String setAppState(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setAppState(");
        stringBuilder.append(JSONObject.quote((String)string));
        stringBuilder.append(")");
        return AvidCommand.callAvidbridge(stringBuilder.toString());
    }

    public static String setAvidAdSessionContext(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setAvidAdSessionContext(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        return AvidCommand.callAvidbridge(stringBuilder.toString());
    }

    public static String setNativeViewState(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setNativeViewState(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        return AvidCommand.callAvidbridge(stringBuilder.toString());
    }
}

