/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  com.ironsource.sdk.data.SSAFile
 *  java.io.ByteArrayInputStream
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.data.SSAEnums;
import com.ironsource.sdk.data.SSAFile;
import com.ironsource.sdk.utils.DeviceProperties;
import com.ironsource.sdk.utils.IronSourceAsyncHttpRequestTask;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;
import com.ironsource.sdk.utils.SDKUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceStorageUtils {
    private static JSONObject buildFilesMap(String string, String string2) {
        File file = new File(string, string2);
        JSONObject jSONObject = new JSONObject();
        File[] arrfile = file.listFiles();
        if (arrfile != null) {
            for (File file2 : arrfile) {
                try {
                    Object object = IronSourceStorageUtils.looping(file2);
                    if (object instanceof JSONArray) {
                        jSONObject.put("files", IronSourceStorageUtils.looping(file2));
                        continue;
                    }
                    if (!(object instanceof JSONObject)) continue;
                    jSONObject.put(file2.getName(), IronSourceStorageUtils.looping(file2));
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                    IronSourceAsyncHttpRequestTask ironSourceAsyncHttpRequestTask = new IronSourceAsyncHttpRequestTask();
                    Object[] arrobject = new String[1];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
                    stringBuilder.append(jSONException.getStackTrace()[0].getMethodName());
                    arrobject[0] = stringBuilder.toString();
                    ironSourceAsyncHttpRequestTask.execute(arrobject);
                }
            }
        }
        return jSONObject;
    }

    private static String createRootDirectory(Context context) {
        File file = IronSourceStorageUtils.getDiskCacheDir(context, "supersonicads");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getPath();
    }

    private static void deleteAllFiles(String string) {
        File[] arrfile = new File(string).listFiles();
        if (arrfile == null) {
            return;
        }
        for (File file : arrfile) {
            if (file.isDirectory()) {
                IronSourceStorageUtils.deleteAllFiles(file.getAbsolutePath());
                file.delete();
                continue;
            }
            file.delete();
        }
    }

    public static boolean deleteFile(String string, String string2, String string3) {
        Class<IronSourceStorageUtils> class_ = IronSourceStorageUtils.class;
        synchronized (IronSourceStorageUtils.class) {
            File[] arrfile;
            int n2;
            block8 : {
                File file;
                block7 : {
                    file = new File(string, string2);
                    boolean bl2 = file.exists();
                    if (bl2) break block7;
                    // ** MonitorExit[var11_3] (shouldn't be in output)
                    return false;
                }
                arrfile = file.listFiles();
                if (arrfile != null) break block8;
                // ** MonitorExit[var11_3] (shouldn't be in output)
                return false;
            }
            try {
                n2 = arrfile.length;
            }
            catch (Throwable throwable) {
                // ** MonitorExit[var11_3] (shouldn't be in output)
                throw throwable;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                File file = arrfile[i2];
                if (!file.isFile() || !file.getName().equalsIgnoreCase(string3)) continue;
                boolean bl3 = file.delete();
                // ** MonitorExit[var11_3] (shouldn't be in output)
                return bl3;
            }
            // ** MonitorExit[var11_3] (shouldn't be in output)
            return false;
        }
    }

    public static boolean deleteFolder(String string, String string2) {
        Class<IronSourceStorageUtils> class_ = IronSourceStorageUtils.class;
        synchronized (IronSourceStorageUtils.class) {
            boolean bl2;
            File file = new File(string, string2);
            boolean bl3 = IronSourceStorageUtils.deleteFolderContentRecursive(file) && (bl2 = file.delete());
            return bl3;
        }
    }

    private static boolean deleteFolderContentRecursive(File file) {
        File[] arrfile = file.listFiles();
        boolean bl2 = true;
        if (arrfile != null) {
            int n2 = arrfile.length;
            boolean bl3 = true;
            for (int i2 = 0; i2 < n2; ++i2) {
                File file2 = arrfile[i2];
                if (file2.isDirectory()) {
                    bl3 &= IronSourceStorageUtils.deleteFolderContentRecursive(file2);
                }
                if (file2.delete()) continue;
                bl3 = false;
            }
            bl2 = bl3;
        }
        return bl2;
    }

    public static String getCachedFilesMap(String string, String string2) {
        JSONObject jSONObject = IronSourceStorageUtils.buildFilesMap(string, string2);
        try {
            jSONObject.put("path", (Object)string2);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static File getDiskCacheDir(Context context, String string) {
        if (SDKUtils.isExternalStorageAvailable()) {
            File file = DeviceStatus.getExternalCacheDir(context);
            if (file != null) {
                String string2 = file.getPath();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(File.separator);
                stringBuilder.append(string);
                return new File(stringBuilder.toString());
            }
            String string3 = DeviceStatus.getInternalCacheDirPath(context);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(File.separator);
            stringBuilder.append(string);
            return new File(stringBuilder.toString());
        }
        String string4 = DeviceStatus.getInternalCacheDirPath(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string4);
        stringBuilder.append(File.separator);
        stringBuilder.append(string);
        return new File(stringBuilder.toString());
    }

    public static String initializeCacheDirectory(Context context) {
        IronSourceStorageUtils.createRootDirectory(context);
        return IronSourceStorageUtils.refreshRootDirectory(context);
    }

    public static boolean isFileCached(String string, SSAFile sSAFile) {
        Class<IronSourceStorageUtils> class_ = IronSourceStorageUtils.class;
        synchronized (IronSourceStorageUtils.class) {
            block5 : {
                int n2;
                File[] arrfile;
                try {
                    File file = new File(string, sSAFile.getPath());
                    if (file.listFiles() == null) break block5;
                    arrfile = file.listFiles();
                    n2 = arrfile.length;
                }
                catch (Throwable throwable) {
                    // ** MonitorExit[var9_2] (shouldn't be in output)
                    throw throwable;
                }
                for (int i2 = 0; i2 < n2; ++i2) {
                    boolean bl2;
                    File file = arrfile[i2];
                    if (!file.isFile() || !(bl2 = file.getName().equalsIgnoreCase(SDKUtils.getFileName(sSAFile.getFile())))) continue;
                    return true;
                }
            }
            // ** MonitorExit[var9_2] (shouldn't be in output)
            return false;
        }
    }

    public static boolean isPathExist(String string, String string2) {
        return new File(string, string2).exists();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object looping(File file) {
        File[] arrfile;
        int n2;
        int n3;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (file.isFile()) {
                jSONArray.put((Object)file.getName());
                return jSONArray;
            }
            arrfile = file.listFiles();
            n2 = arrfile.length;
            n3 = 0;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            IronSourceAsyncHttpRequestTask ironSourceAsyncHttpRequestTask = new IronSourceAsyncHttpRequestTask();
            Object[] arrobject = new String[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            stringBuilder.append(jSONException.getStackTrace()[0].getMethodName());
            arrobject[0] = stringBuilder.toString();
            ironSourceAsyncHttpRequestTask.execute(arrobject);
            return jSONObject;
        }
        do {
            if (n3 < n2) {
                File file2 = arrfile[n3];
                if (file2.isDirectory()) {
                    jSONObject.put(file2.getName(), IronSourceStorageUtils.looping(file2));
                } else {
                    jSONArray.put((Object)file2.getName());
                    jSONObject.put("files", (Object)jSONArray);
                }
            } else {
                String string;
                SSAEnums.ProductType productType;
                String string2;
                if (file.isDirectory() && (string2 = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getCampaignLastUpdate(file.getName())) != null) {
                    jSONObject.put("lastUpdateTime", (Object)string2);
                }
                if ((string = file.getName().toLowerCase()).startsWith(SSAEnums.ProductType.RewardedVideo.toString().toLowerCase())) {
                    productType = SSAEnums.ProductType.RewardedVideo;
                } else if (string.startsWith(SSAEnums.ProductType.OfferWall.toString().toLowerCase())) {
                    productType = SSAEnums.ProductType.OfferWall;
                } else {
                    boolean bl2 = string.startsWith(SSAEnums.ProductType.Interstitial.toString().toLowerCase());
                    productType = null;
                    if (bl2) {
                        productType = SSAEnums.ProductType.Interstitial;
                    }
                }
                if (productType == null) return jSONObject;
                {
                    jSONObject.put(SDKUtils.encodeString("applicationUserId"), (Object)SDKUtils.encodeString(IronSourceSharedPrefHelper.getSupersonicPrefHelper().getUniqueId(productType)));
                    jSONObject.put(SDKUtils.encodeString("applicationKey"), (Object)SDKUtils.encodeString(IronSourceSharedPrefHelper.getSupersonicPrefHelper().getApplicationKey(productType)));
                    return jSONObject;
                }
            }
            ++n3;
        } while (true);
    }

    public static String makeDir(String string, String string2) {
        File file = new File(string, string2);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        return file.getPath();
    }

    private static String refreshRootDirectory(Context context) {
        String string;
        String string2 = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getCurrentSDKVersion();
        if (!string2.equalsIgnoreCase(string = DeviceProperties.getSupersonicSdkVersion())) {
            IronSourceSharedPrefHelper.getSupersonicPrefHelper().setCurrentSDKVersion(string);
            File file = DeviceStatus.getExternalCacheDir(context);
            if (file != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append(File.separator);
                stringBuilder.append("supersonicads");
                stringBuilder.append(File.separator);
                IronSourceStorageUtils.deleteAllFiles(stringBuilder.toString());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(DeviceStatus.getInternalCacheDirPath(context));
            stringBuilder.append(File.separator);
            stringBuilder.append("supersonicads");
            stringBuilder.append(File.separator);
            IronSourceStorageUtils.deleteAllFiles(stringBuilder.toString());
            return IronSourceStorageUtils.createRootDirectory(context);
        }
        return IronSourceStorageUtils.getDiskCacheDir(context, "supersonicads").getPath();
    }

    public static boolean renameFile(String string, String string2) throws Exception {
        return new File(string).renameTo(new File(string2));
    }

    public static int saveFile(byte[] arrby, String string) throws Exception {
        int n2;
        byte[] arrby2;
        FileOutputStream fileOutputStream = new FileOutputStream(new File(string));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
        try {
            arrby2 = new byte[102400];
            n2 = 0;
        }
        catch (Throwable throwable) {
            fileOutputStream.close();
            byteArrayInputStream.close();
            throw throwable;
        }
        do {
            int n3 = byteArrayInputStream.read(arrby2);
            if (n3 == -1) break;
            fileOutputStream.write(arrby2, 0, n3);
            n2 += n3;
        } while (true);
        fileOutputStream.close();
        byteArrayInputStream.close();
        return n2;
    }
}

