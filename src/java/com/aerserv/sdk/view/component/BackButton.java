/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.view.component;

import com.aerserv.sdk.utils.AerServLog;

public class BackButton {
    private static final String BACK_BUTTON_PRESS = "Back button pressed";
    private static final String LOG_TAG = "BackButton";
    private boolean backButtonEnable = false;
    private boolean isVideo = false;
    private int timeout = 0;
    private boolean timeoutOccured = false;

    public void enableForVideo() {
        this.timeoutOccured = true;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public boolean isBackButtonEnable() {
        AerServLog.v(LOG_TAG, BACK_BUTTON_PRESS);
        if (this.backButtonEnable && !this.isVideo) {
            return true;
        }
        return this.backButtonEnable && this.timeoutOccured;
    }

    public void setBackButtonEnable(boolean bl) {
        this.backButtonEnable = bl;
    }

    public void setTimeout(int n2) {
        this.timeout = n2;
    }

    public void setToVideo() {
        this.isVideo = true;
    }
}

