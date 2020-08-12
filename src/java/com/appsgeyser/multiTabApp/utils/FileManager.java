/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.DownloadManager
 *  android.app.DownloadManager$Request
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.AssetManager
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.webkit.URLUtil
 *  androidx.core.app.ActivityCompat
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.io.BufferedReader
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.Reader
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Calendar
 */
package com.appsgeyser.multiTabApp.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.webkit.URLUtil;
import androidx.core.app.ActivityCompat;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.VideoPlayerActivity;
import com.appsgeyser.multiTabApp.utils.PermissionController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;

public class FileManager {
    private static String[] PERMISSIONS_STORAGE = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final ArrayList<String> list = new ArrayList<String>(){
        {
            this.add((Object)"video/mpeg4");
            this.add((Object)"video/mp4");
            this.add((Object)"video/3gp");
            this.add((Object)"video/3gpp");
            this.add((Object)"video/3gpp2");
            this.add((Object)"video/webm");
            this.add((Object)"video/avi");
            this.add((Object)"application/sdp");
            this.add((Object)"application/vnd.apple.mpegurl");
            this.add((Object)"application/x-mpegurl");
        }
    };

    public static long downloadFile(String string2, String string3, String string4, Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            FileManager.fireOpenFileIntent(string2, string3, context);
        }
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            FileManager.fireOpenFileIntent(string2, string3, context);
        }
        DownloadManager downloadManager = (DownloadManager)context.getSystemService("download");
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse((String)string2));
        String string5 = URLUtil.guessFileName((String)string2, (String)string4, (String)string3);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, string5);
        request.setMimeType(string3);
        if (Build.VERSION.SDK_INT >= 11) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
        }
        return downloadManager.enqueue(request);
    }

    public static void downloadFile(String string2, String string3, Context context) {
        FileManager.downloadFile(string2, null, string3, context);
    }

    public static void fireOpenFileIntent(String string2, String string3, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2), context, VideoPlayerActivity.class);
        if (string3 != null && string3.length() > 0) {
            intent.setDataAndType(Uri.parse((String)string2), string3);
        } else {
            intent.setData(Uri.parse((String)string2));
        }
        if (context.getPackageManager().resolveActivity(intent, 0) != null) {
            context.startActivity(intent);
            return;
        }
        Intent intent2 = list.contains((Object)string3) ? new Intent("android.intent.action.VIEW", Uri.parse((String)string2), context, VideoPlayerActivity.class) : new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse((String)string2));
        context.startActivity(intent2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String getStringFromAssetsFileWithFileName(String string2, Context context) {
        String string3;
        if (string2 == null) return "";
        if (string2.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        if (assetManager == null) return stringBuilder.toString();
        InputStream inputStream = assetManager.open(string2);
        if (inputStream == null) return stringBuilder.toString();
        BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(inputStream));
        while ((string3 = bufferedReader.readLine()) != null) {
            stringBuilder.append(string3);
            stringBuilder.append("\n");
        }
        {
            catch (Throwable throwable) {
                bufferedReader.close();
                throw throwable;
            }
        }
        try {
            bufferedReader.close();
            inputStream.close();
            return stringBuilder.toString();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static File saveBitmapToGallery(String string2, Bitmap bitmap, Context context) {
        try {
            File file;
            Calendar calendar = Calendar.getInstance();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(calendar.get(5));
            stringBuilder.append(calendar.get(2));
            stringBuilder.append(calendar.get(1));
            stringBuilder.append(calendar.get(11));
            stringBuilder.append(calendar.get(12));
            stringBuilder.append(calendar.get(13));
            String string3 = stringBuilder.toString();
            if (Build.VERSION.RELEASE.compareTo("2.3.3") >= 1) {
                if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission((Context)context, (String)"android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    PermissionController.getInstance().addPermissions(PERMISSIONS_STORAGE, 4);
                }
                if (!(file = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_PICTURES)).exists()) {
                    file.mkdirs();
                }
            } else {
                file = Environment.getExternalStorageDirectory();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(string3);
            stringBuilder2.append(".png");
            File file2 = new File(file, stringBuilder2.toString());
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            FileManager.scanPhoto(file2);
            return file2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static void scanPhoto(File file) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile((File)file));
        Factory.getInstance().getMainNavigationActivity().sendBroadcast(intent);
    }

}

