/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.webkit.JavascriptInterface
 *  com.aerserv.sdk.controller.command.CreateCalendarEventCommand
 *  com.aerserv.sdk.controller.command.DownloadImageCommand
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 *  org.json.JSONObject
 */
package com.aerserv.sdk.view.component;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.webkit.JavascriptInterface;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidAction;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidPlacementType;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidState;
import com.aerserv.sdk.controller.command.CreateCalendarEventCommand;
import com.aerserv.sdk.controller.command.DownloadImageCommand;
import com.aerserv.sdk.controller.listener.MraidJavascriptInterfaceListener;
import com.aerserv.sdk.utils.AerServLog;
import java.util.Arrays;
import org.json.JSONObject;

public class MraidJavascriptInterface {
    public static final String EXPAND_CUSTOM_CLOSE = "mraidExpandCustomClose";
    public static final String EXPAND_URL_KEY = "mraidExpandUrl";
    public static final String PLAY_VIDEO_URL_KEY = "mraidPlayVideoUrl";
    private static final String VERSION = "2.0";
    private Context context;
    private MraidJavascriptInterfaceListener mraidListener;

    public MraidJavascriptInterface(Context context, MraidJavascriptInterfaceListener mraidJavascriptInterfaceListener) {
        this.context = context;
        this.mraidListener = mraidJavascriptInterfaceListener;
    }

    @JavascriptInterface
    public void checkReady() {
        this.mraidListener.checkReady();
    }

    public void cleanup() {
        this.mraidListener.cleanup();
        this.mraidListener = null;
    }

    @JavascriptInterface
    public void close() {
        try {
            this.mraidListener.close();
            this.mraidListener.fireEvent(AerServEvent.MRAID_CLOSE);
            return;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.CLOSE, exception);
            return;
        }
    }

    @JavascriptInterface
    public void createCalendarEvent(String string) {
        try {
            new CreateCalendarEventCommand(this.context, string).execute();
            this.mraidListener.fireEvent(AerServEvent.MRAID_CREATE_CALENDAR_EVENT, string);
            return;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.CREATE_CALENDAR_EVENT, exception);
            return;
        }
    }

    @JavascriptInterface
    public void expand(String string, String string2) {
        block3 : {
            try {
                if (!string2.equals((Object)"undefined")) break block3;
                string2 = null;
            }
            catch (Exception exception) {
                this.mraidListener.onError(MraidAction.EXPAND, exception);
                return;
            }
        }
        this.mraidListener.expand(new JSONObject(string), string2);
        this.mraidListener.fireEvent(AerServEvent.MRAID_RESIZE, (Object)Arrays.asList((Object[])new String[]{string, string2}));
    }

    @JavascriptInterface
    public String getCurrentPosition() {
        try {
            Rect rect = this.mraidListener.getCurrentPosition();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\"x\":");
            stringBuilder.append(rect.left);
            stringBuilder.append(",\"y\":");
            stringBuilder.append(rect.top);
            stringBuilder.append(",\"width\":");
            stringBuilder.append(rect.width());
            stringBuilder.append(",\"height\":");
            stringBuilder.append(rect.height());
            stringBuilder.append("}");
            String string = stringBuilder.toString();
            return string;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.GET_CURRENT_POSITION, exception);
            return "{\"x\":0,\"y\":0,\"width\":0,\"height\":0}";
        }
    }

    @JavascriptInterface
    public String getMaxSize() {
        try {
            Point point = this.mraidListener.getMaxSize();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\"height\":");
            stringBuilder.append(point.y);
            stringBuilder.append(",\"width\":");
            stringBuilder.append(point.x);
            stringBuilder.append("}");
            String string = stringBuilder.toString();
            return string;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.GET_MAX_SIZE, exception);
            return "{\"height\":0,\"width\":0}";
        }
    }

    @JavascriptInterface
    public String getPlacementType() {
        return this.mraidListener.getPlacementType().getName();
    }

    @JavascriptInterface
    public String getScreenSize() {
        try {
            Point point = this.mraidListener.getScreenSize();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\"height\":");
            stringBuilder.append(point.y);
            stringBuilder.append(",\"width\":");
            stringBuilder.append(point.x);
            stringBuilder.append("}");
            String string = stringBuilder.toString();
            return string;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.GET_SCREEN_SIZE, exception);
            return "{\"height\":0,\"width\":0}";
        }
    }

    @JavascriptInterface
    public String getState() {
        return this.mraidListener.getState().getName();
    }

    @JavascriptInterface
    public String getVersion() {
        return VERSION;
    }

    @JavascriptInterface
    public void isReady() {
        this.mraidListener.isReady();
    }

    @JavascriptInterface
    public void onVpaidEvent(String string, String string2) {
        String string3 = this.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VPAID event fired with type: ");
        stringBuilder.append(string);
        stringBuilder.append(" and args: ");
        stringBuilder.append(string2);
        AerServLog.d(string3, stringBuilder.toString());
        if (string.equals((Object)"AdImpression")) {
            this.mraidListener.fireEvent(AerServEvent.AD_IMPRESSION);
            return;
        }
        if (string.equals((Object)"AdStarted")) {
            return;
        }
        if (string.equals((Object)"AdVideoStart")) {
            this.mraidListener.fireEvent(AerServEvent.VIDEO_START);
            return;
        }
        if (string.equals((Object)"AdVideoFirstQuartile")) {
            this.mraidListener.fireEvent(AerServEvent.VIDEO_25);
            return;
        }
        if (string.equals((Object)"AdVideoMidpoint")) {
            this.mraidListener.fireEvent(AerServEvent.VIDEO_50);
            return;
        }
        if (string.equals((Object)"AdVideoThirdQuartile")) {
            this.mraidListener.fireEvent(AerServEvent.VIDEO_75);
            return;
        }
        if (string.equals((Object)"AdVideoComplete")) {
            this.mraidListener.fireEvent(AerServEvent.VIDEO_COMPLETED);
            return;
        }
        if (string.equals((Object)"AdClickThru")) {
            this.mraidListener.fireEvent(AerServEvent.AD_CLICKED);
            return;
        }
        if (string.equals((Object)"AdInteraction")) {
            return;
        }
        if (string.equals((Object)"AdDurationChanged")) {
            return;
        }
        if (string.equals((Object)"AdUserAcceptInvitation")) {
            return;
        }
        if (string.equals((Object)"AdUserMinimize")) {
            return;
        }
        if (string.equals((Object)"AdUserClose")) {
            this.mraidListener.fireEvent(AerServEvent.AD_DISMISSED);
            return;
        }
        if (string.equals((Object)"AdPaused")) {
            return;
        }
        if (string.equals((Object)"AdPlaying")) {
            return;
        }
        if (string.equals((Object)"AdLog")) {
            return;
        }
        string.equals((Object)"AdError");
    }

    @JavascriptInterface
    public void open(String string) {
        try {
            this.mraidListener.open(string);
            this.mraidListener.fireEvent(AerServEvent.MRAID_OPEN, string);
            return;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.OPEN, exception);
            return;
        }
    }

    @JavascriptInterface
    public void playVideo(String string) {
        try {
            this.mraidListener.playVideo(string);
            this.mraidListener.fireEvent(AerServEvent.MRAID_PLAY_VIDEO, string);
            return;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.PLAY_VIDEO, exception);
            return;
        }
    }

    @JavascriptInterface
    public void resize(String string) {
        try {
            this.mraidListener.resize(new JSONObject(string));
            this.mraidListener.fireEvent(AerServEvent.MRAID_RESIZE, string);
            return;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.RESIZE, exception);
            return;
        }
    }

    @JavascriptInterface
    public void setOrientationProperties(String string) {
        try {
            this.mraidListener.setOrientationProperties(new JSONObject(string));
            return;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.SET_ORIENTATION_PROPERTIES, exception);
            return;
        }
    }

    @JavascriptInterface
    public void storePicture(String string) {
        try {
            new DownloadImageCommand(this.context, string).execute();
            this.mraidListener.fireEvent(AerServEvent.MRAID_STORE_PICTURE, string);
            return;
        }
        catch (Exception exception) {
            this.mraidListener.onError(MraidAction.STORE_PICTURE, exception);
            return;
        }
    }

    @JavascriptInterface
    public void useCustomClose(boolean bl) {
        this.mraidListener.useCustomClose(bl);
    }
}

