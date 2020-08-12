/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 */
package org.altbeacon.beacon.distance;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import org.altbeacon.beacon.distance.AndroidModel;
import org.altbeacon.beacon.distance.DistanceConfigFetcher;

public class ModelSpecificDistanceUpdater
extends AsyncTask<Void, Void, Void> {
    private Exception exception = null;
    private CompletionHandler mCompletionHandler;
    private Context mContext;
    private DistanceConfigFetcher mDistanceConfigFetcher;
    private String response = null;
    private String urlString = null;

    public ModelSpecificDistanceUpdater(Context context, String string, CompletionHandler completionHandler) {
        this.mContext = context;
        this.mDistanceConfigFetcher = new DistanceConfigFetcher(string, this.getUserAgentString());
        this.mCompletionHandler = completionHandler;
    }

    private String getInstallId() {
        return Settings.Secure.getString((ContentResolver)this.mContext.getContentResolver(), (String)"android_id");
    }

    private String getModel() {
        return AndroidModel.forThisDevice().toString();
    }

    private String getPackage() {
        return this.mContext.getPackageName();
    }

    private String getUserAgentString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Android Beacon Library;");
        stringBuilder.append(this.getVersion());
        stringBuilder.append(";");
        stringBuilder.append(this.getPackage());
        stringBuilder.append(";");
        stringBuilder.append(this.getInstallId());
        stringBuilder.append(";");
        stringBuilder.append(this.getModel());
        return stringBuilder.toString();
    }

    private String getVersion() {
        return "2.13.1";
    }

    protected /* varargs */ Void doInBackground(Void ... arrvoid) {
        this.mDistanceConfigFetcher.request();
        CompletionHandler completionHandler = this.mCompletionHandler;
        if (completionHandler != null) {
            completionHandler.onComplete(this.mDistanceConfigFetcher.getResponseString(), this.mDistanceConfigFetcher.getException(), this.mDistanceConfigFetcher.getResponseCode());
        }
        return null;
    }

    static interface CompletionHandler {
        public void onComplete(String var1, Exception var2, int var3);
    }

}

