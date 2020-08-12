/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.util.Log;
import com.amazon.device.ads.Logger;

class LogcatLogger
implements Logger {
    private String logTag;

    LogcatLogger() {
    }

    @Override
    public void d(String string) {
        Log.d((String)this.logTag, (String)string);
    }

    @Override
    public void e(String string) {
        Log.e((String)this.logTag, (String)string);
    }

    @Override
    public void i(String string) {
        Log.i((String)this.logTag, (String)string);
    }

    @Override
    public void v(String string) {
        Log.v((String)this.logTag, (String)string);
    }

    @Override
    public void w(String string) {
        Log.w((String)this.logTag, (String)string);
    }

    @Override
    public LogcatLogger withLogTag(String string) {
        this.logTag = string;
        return this;
    }
}

