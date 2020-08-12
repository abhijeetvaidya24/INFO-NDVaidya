/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.io.BufferedWriter
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Writer
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.util.ArrayList
 */
package com.ironsource.eventsmodule;

import android.os.AsyncTask;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.eventsmodule.IEventsSenderResultListener;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class EventsSender
extends AsyncTask<Object, Void, Boolean> {
    private final String APPLICATION_JSON = "application/json";
    private final String CONTENT_TYPE_FIELD = "Content-Type";
    private final String SERVER_REQUEST_ENCODING = "UTF-8";
    private final String SERVER_REQUEST_METHOD = "POST";
    private final int SERVER_REQUEST_TIMEOUT = 15000;
    private ArrayList extraData;
    private IEventsSenderResultListener mResultListener;

    public EventsSender() {
    }

    public EventsSender(IEventsSenderResultListener iEventsSenderResultListener) {
        this.mResultListener = iEventsSenderResultListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected /* varargs */ Boolean doInBackground(Object ... arrobject) {
        boolean bl2;
        block2 : {
            bl2 = true;
            try {
                URL uRL = new URL((String)arrobject[bl2]);
                this.extraData = (ArrayList)arrobject[2];
                HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.setDoInput(bl2);
                httpURLConnection.setDoOutput(bl2);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter(outputStream, "UTF-8"));
                bufferedWriter.write((String)arrobject[0]);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                int n2 = httpURLConnection.getResponseCode();
                httpURLConnection.disconnect();
                if (n2 != 200) break block2;
                return bl2;
            }
            catch (Exception exception) {
                return false;
            }
        }
        bl2 = false;
        return bl2;
    }

    protected void onPostExecute(Boolean bl2) {
        IEventsSenderResultListener iEventsSenderResultListener = this.mResultListener;
        if (iEventsSenderResultListener != null) {
            iEventsSenderResultListener.onEventsSenderResult((ArrayList<EventData>)this.extraData, bl2);
        }
    }
}

