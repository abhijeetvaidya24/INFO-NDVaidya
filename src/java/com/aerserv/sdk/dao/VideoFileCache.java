/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 *  java.io.BufferedInputStream
 *  java.io.BufferedOutputStream
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URL
 *  java.net.URLConnection
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package com.aerserv.sdk.dao;

import android.content.Context;
import android.os.Environment;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.IOUtils;
import com.aerserv.sdk.utils.VideoFileName;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class VideoFileCache {
    private static final int DOWNLOAD_BUFFER_SIZE = 1024;
    private static final String LOG_TAG = "VideoFileCache";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void cacheVideo(Context context, String string, String string2) throws Exception {
        try {
            if (VideoFileCache.getCachedPath(context, string) != null) {
                String string3 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("File already cached from ");
                stringBuilder.append(string);
                AerServLog.d(string3, stringBuilder.toString());
                AerServEventListenerLocator.fireEvent(string2, AerServEvent.INTERNAL_PRECACHE_READY);
                return;
            }
            String string4 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Beginning caching of file at ");
            stringBuilder.append(string);
            AerServLog.d(string4, stringBuilder.toString());
            VideoFileName videoFileName = new VideoFileName(context, string);
            URLConnection uRLConnection = new URL(string).openConnection();
            uRLConnection.setUseCaches(false);
            int n2 = uRLConnection.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(uRLConnection.getInputStream());
            new File(videoFileName.getPath()).mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(videoFileName.getFile()));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)fileOutputStream, 1024);
            byte[] arrby = new byte[1024];
            int n3 = 0;
            boolean bl = false;
            do {
                int n4;
                if ((n4 = bufferedInputStream.read(arrby, 0, arrby.length)) < 0) {
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    return;
                }
                bufferedOutputStream.write(arrby, 0, n4);
                if (bl || (n3 += n4) < n2) continue;
                AerServEventListenerLocator.fireEvent(string2, AerServEvent.INTERNAL_PRECACHE_READY);
                bl = true;
            } while (true);
        }
        catch (Exception exception) {
            String string5 = VideoFileCache.class.getClass().getSimpleName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception caught while trying to cache video at URL ");
            stringBuilder.append(string);
            AerServLog.e(string5, stringBuilder.toString(), exception);
            throw exception;
        }
        catch (IOException iOException) {
            AerServLog.d(LOG_TAG, "Unable to preload mediafile url. Connection to endpoint failed.", (Exception)((Object)iOException));
            throw iOException;
        }
        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
            AerServLog.d(LOG_TAG, "Unable to preload mediafile url. Secure connection failed.", (Exception)((Object)sSLPeerUnverifiedException));
            throw sSLPeerUnverifiedException;
        }
        catch (FileNotFoundException fileNotFoundException) {
            AerServLog.d(LOG_TAG, "Unable to preload mediafile url. Failed to find file.", (Exception)((Object)fileNotFoundException));
            throw fileNotFoundException;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void clearCache(Context var0) {
        try {
            var7_1 = new VideoFileName(var0, "/").getPath();
            var8_2 = VideoFileCache.LOG_TAG;
            var9_3 = new StringBuilder();
            var9_3.append("Clearing cache at ");
            var9_3.append(var7_1);
            AerServLog.d(var8_2, var9_3.toString());
            IOUtils.deleteDirectory(new File(var7_1));
            ** GOTO lbl-1000
        }
        catch (Exception v0) {
            try lbl-1000: // 2 sources:
            {
                var2_4 = new StringBuilder();
                var2_4.append((Object)Environment.getExternalStorageDirectory());
                var2_4.append("/aerserv/download/");
                IOUtils.deleteDirectory(new File(var2_4.toString()));
                return;
            }
            catch (Exception v1) {}
        }
    }

    public static String getCachedPath(Context context, String string) {
        VideoFileName videoFileName = new VideoFileName(context, string);
        if (new File(videoFileName.getFile()).exists()) {
            return videoFileName.getFile();
        }
        return null;
    }
}

