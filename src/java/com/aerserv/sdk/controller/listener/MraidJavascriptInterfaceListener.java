/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.Rect
 *  com.aerserv.sdk.view.component.ASMraidWebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.controller.listener;

import android.graphics.Point;
import android.graphics.Rect;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidAction;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidPlacementType;
import com.aerserv.sdk.adapter.asaerserv.mraid.MraidState;
import com.aerserv.sdk.view.component.ASMraidWebView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public interface MraidJavascriptInterfaceListener {
    public static final String PROPERTIES_KEY = "mraidJavascriptInterfaceListener";

    public void checkReady();

    public void cleanup();

    public void close();

    public void expand(JSONObject var1, String var2) throws JSONException;

    public void fireEvent(AerServEvent var1);

    public void fireEvent(AerServEvent var1, Object var2);

    public void fireEvent(AerServEvent var1, List<Object> var2);

    public Rect getCurrentPosition();

    public Point getMaxSize();

    public MraidPlacementType getPlacementType();

    public Point getScreenSize();

    public MraidState getState();

    public void isReady();

    public void onError(MraidAction var1, Exception var2);

    public void onSizeChange();

    public void open(String var1);

    public void playVideo(String var1);

    public void resize(JSONObject var1) throws JSONException;

    public void setAdView(ASMraidWebView var1);

    public void setOrientationProperties(JSONObject var1) throws JSONException;

    public void useCustomClose(boolean var1);
}

