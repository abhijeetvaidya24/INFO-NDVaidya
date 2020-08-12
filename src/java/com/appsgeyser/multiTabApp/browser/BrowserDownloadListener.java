/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.webkit.DownloadListener
 *  android.webkit.MimeTypeMap
 *  android.webkit.URLUtil
 *  android.webkit.ValueCallback
 *  android.widget.Toast
 *  androidx.core.app.ActivityCompat
 *  androidx.core.content.ContextCompat
 *  com.appsgeyser.multiTabApp.DownloadsListActivity
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.controllers.WebContentController
 *  java.io.Serializable
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.appsgeyser.multiTabApp.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.appsgeyser.multiTabApp.DownloadsListActivity;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.browser.DownloadsItem;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.controllers.WebContentController;
import com.appsgeyser.multiTabApp.storage.DatabaseOpenHelper;
import com.appsgeyser.multiTabApp.ui.dialog.SimpleDialogs;
import com.appsgeyser.multiTabApp.utils.FileManager;
import java.io.Serializable;

public class BrowserDownloadListener
implements DownloadListener {
    private WebContentController _webController;

    public BrowserDownloadListener(WebContentController webContentController) {
        this._webController = webContentController;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void addIntoDataBase(MainNavigationActivity mainNavigationActivity, String string2, long l2, String string3) {
        SQLiteDatabase sQLiteDatabase = new DatabaseOpenHelper((Context)mainNavigationActivity).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        try {
            try {
                contentValues.put("id_d", Long.valueOf((long)l2));
                contentValues.put("name", string3);
                contentValues.put("status", DownloadsItem.Status.InProgress.toString());
                contentValues.put("link_d", string2);
                contentValues.put("description", string2);
                sQLiteDatabase.insert("downloadsList", null, contentValues);
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Error while add string into table downloadsList ");
                stringBuilder.append((Object)exception);
                Log.e((String)"Error", (String)stringBuilder.toString());
            }
        }
        catch (Throwable throwable2) {}
        sQLiteDatabase.close();
        return;
        sQLiteDatabase.close();
        throw throwable2;
    }

    private void download(final String string2, final String string3, final String string4, final MainNavigationActivity mainNavigationActivity) {
        if (ContextCompat.checkSelfPermission((Context)mainNavigationActivity, (String)"android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            long l2 = FileManager.downloadFile(string2, string4, string3, (Context)mainNavigationActivity);
            String string5 = URLUtil.guessFileName((String)string2, (String)string3, (String)string4);
            this.addIntoDataBase(mainNavigationActivity, string2, l2, string5);
            this.sendMessageToActivity(mainNavigationActivity, l2, string5, string2);
            return;
        }
        ActivityCompat.requestPermissions((Activity)mainNavigationActivity, (String[])new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, (int)35);
        ValueCallback<Integer> valueCallback = new ValueCallback<Integer>(){

            public void onReceiveValue(Integer n2) {
                if (n2 == 0) {
                    long l2 = FileManager.downloadFile(string2, string4, string3, (Context)mainNavigationActivity);
                    String string22 = URLUtil.guessFileName((String)string2, (String)string3, (String)string4);
                    BrowserDownloadListener.this.addIntoDataBase(mainNavigationActivity, string2, l2, string22);
                    BrowserDownloadListener.this.sendMessageToActivity(mainNavigationActivity, l2, string22, string2);
                    return;
                }
                Toast.makeText((Context)mainNavigationActivity, (int)2131755146, (int)1).show();
            }
        };
        mainNavigationActivity.setPermissionCallback((ValueCallback)valueCallback);
    }

    private void sendMessageToActivity(MainNavigationActivity mainNavigationActivity, long l2, String string2, String string3) {
        Intent intent = new Intent();
        intent.putExtra("type", 100);
        intent.putExtra("item", (Serializable)new DownloadsItem(l2, string2, string3));
        intent.setAction(DownloadsListActivity.DOWNLOAD_LIST_MSG);
        mainNavigationActivity.sendBroadcast(intent);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDownloadStart(final String string2, String string3, final String string4, String string5, long l2) {
        try {
            final MainNavigationActivity mainNavigationActivity = Factory.getInstance().getMainNavigationActivity();
            String string6 = MimeTypeMap.getFileExtensionFromUrl((String)string2);
            String string7 = string6 != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(string6) : null;
            final String string8 = string7 == null ? string5 : string7;
            WebWidgetConfiguration.DownloadActions downloadActions = mainNavigationActivity.getConfig().getDownloadAction();
            if (Build.VERSION.SDK_INT < 9) {
                downloadActions = WebWidgetConfiguration.DownloadActions.OPEN;
            }
            if (downloadActions == WebWidgetConfiguration.DownloadActions.OPEN) {
                FileManager.fireOpenFileIntent(string2, string8, (Context)mainNavigationActivity);
                return;
            }
            WebWidgetConfiguration.DownloadActions downloadActions2 = WebWidgetConfiguration.DownloadActions.SAVE;
            if (downloadActions == downloadActions2) {
                try {
                    this.download(string2, null, string8, mainNavigationActivity);
                    return;
                }
                catch (Exception exception) {
                    FileManager.fireOpenFileIntent(string2, string8, (Context)mainNavigationActivity);
                    return;
                }
            }
            WebWidgetConfiguration.DownloadActions downloadActions3 = WebWidgetConfiguration.DownloadActions.DIALOG;
            if (downloadActions != downloadActions3) return;
            {
                try {
                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener(){

                        public void onClick(DialogInterface dialogInterface, int n2) {
                            FileManager.fireOpenFileIntent(string2, string8, (Context)mainNavigationActivity);
                        }
                    };
                    DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener(){

                        public void onClick(DialogInterface dialogInterface, int n2) {
                            BrowserDownloadListener.this.download(string2, string4, string8, mainNavigationActivity);
                        }
                    };
                    SimpleDialogs.showOpenOrSaveDialog((Context)mainNavigationActivity, onClickListener, onClickListener2);
                    return;
                }
                catch (Exception exception) {
                    FileManager.fireOpenFileIntent(string2, string5, (Context)mainNavigationActivity);
                    return;
                }
            }
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onDownloadStart :");
            stringBuilder.append(activityNotFoundException.getMessage());
            Log.e((String)"ANFE", (String)stringBuilder.toString());
        }
    }

}

