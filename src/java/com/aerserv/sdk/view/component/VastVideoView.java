/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.VideoView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.aerserv.sdk.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.view.component.VastVideoViewSizeChangedEventHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VastVideoView
extends VideoView {
    private static final String LOG_TAG = "com.aerserv.sdk.view.component.VastVideoView";
    private List<VastVideoViewSizeChangedEventHandler> vastVideoViewSizeChangedEventHandlers = new ArrayList();
    private int videoDuration;

    public VastVideoView(Context context) {
        super(context);
    }

    public VastVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VastVideoView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
    }

    public void addVastVideoViewSizeChangedEventHandler(VastVideoViewSizeChangedEventHandler vastVideoViewSizeChangedEventHandler) {
        this.vastVideoViewSizeChangedEventHandlers.add((Object)vastVideoViewSizeChangedEventHandler);
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        try {
            Iterator iterator = this.vastVideoViewSizeChangedEventHandlers.iterator();
            while (iterator.hasNext()) {
                ((VastVideoViewSizeChangedEventHandler)iterator.next()).onVastVideoViewSizeChanged(n2, n3, n4, n5);
            }
        }
        catch (Exception exception) {
            AerServLog.e(LOG_TAG, "Exception caught", exception);
        }
    }

    public void removeVastVideoViewSizeChangedEventHandler(VastVideoViewSizeChangedEventHandler vastVideoViewSizeChangedEventHandler) {
        if (this.vastVideoViewSizeChangedEventHandlers.contains((Object)vastVideoViewSizeChangedEventHandler)) {
            this.vastVideoViewSizeChangedEventHandlers.remove((Object)vastVideoViewSizeChangedEventHandler);
        }
    }

    public void setVideoDuration(int n2) {
        this.videoDuration = n2;
    }
}

