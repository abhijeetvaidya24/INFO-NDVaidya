/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ThreadPoolExecutor
 *  org.json.JSONObject
 */
package com.integralads.avid.library.adcolony.walking.async;

import android.os.AsyncTask;
import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class AvidAsyncTask
extends AsyncTask<Object, Void, String> {
    private AvidAsyncTaskListener a;
    protected final StateProvider stateProvider;

    public AvidAsyncTask(StateProvider stateProvider) {
        this.stateProvider = stateProvider;
    }

    protected void onPostExecute(String string) {
        AvidAsyncTaskListener avidAsyncTaskListener = this.a;
        if (avidAsyncTaskListener != null) {
            avidAsyncTaskListener.onTaskCompleted(this);
        }
    }

    public void setListener(AvidAsyncTaskListener avidAsyncTaskListener) {
        this.a = avidAsyncTaskListener;
    }

    public void start(ThreadPoolExecutor threadPoolExecutor) {
        if (Build.VERSION.SDK_INT > 11) {
            this.executeOnExecutor((Executor)threadPoolExecutor, new Object[0]);
            return;
        }
        this.execute(new Object[0]);
    }

    public static interface AvidAsyncTaskListener {
        public void onTaskCompleted(AvidAsyncTask var1);
    }

    public static interface StateProvider {
        public JSONObject getPreviousState();

        public void setPreviousState(JSONObject var1);
    }

}

