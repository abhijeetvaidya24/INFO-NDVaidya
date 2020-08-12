/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  dalvik.system.BaseDexClassLoader
 *  dalvik.system.DexClassLoader
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Array
 *  java.lang.reflect.Field
 *  java.util.ArrayList
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.Future
 *  java.util.concurrent.TimeUnit
 */
package com.adincube.sdk.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@TargetApi(value=14)
public class i {
    private static boolean a;

    private static Object a(BaseDexClassLoader baseDexClassLoader) {
        Field field = BaseDexClassLoader.class.getDeclaredField("pathList");
        field.setAccessible(true);
        Object object = field.get((Object)baseDexClassLoader);
        Field field2 = object.getClass().getDeclaredField("dexElements");
        field2.setAccessible(true);
        return field2.get(object);
    }

    private static Object a(Object object, Object object2) {
        IllegalArgumentException illegalArgumentException;
        Class class_ = object.getClass().getComponentType();
        if (class_ == object2.getClass().getComponentType()) {
            int n2 = Array.getLength((Object)object);
            int n3 = Array.getLength((Object)object2);
            Object object3 = Array.newInstance((Class)class_, (int)(n2 + n3));
            int n4 = 0;
            int n5 = 0;
            do {
                if (n4 >= n2) break;
                Array.set((Object)object3, (int)n5, (Object)Array.get((Object)object, (int)n4));
                ++n5;
                ++n4;
            } while (true);
            for (int i2 = 0; i2 < n3; ++i2) {
                Array.set((Object)object3, (int)n5, (Object)Array.get((Object)object2, (int)i2));
                ++n5;
            }
            return object3;
        }
        illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void a(final Context var0) {
        if (i.a != false) return;
        if (Build.VERSION.SDK_INT < 14) ** GOTO lbl34
        try {
            var1_1 = new ArrayList();
            var3_2 = var0.getAssets().list("");
            var4_3 = var3_2.length;
            var5_4 = 0;
        }
        catch (IOException var2_11) {
            a.c("Unable to read assets files", new Object[]{var2_11});
            ** GOTO lbl34
        }
        do {
            if (var5_4 < var4_3) {
                var6_5 = var3_2[var5_4];
                if (var6_5.startsWith("aic-") && var6_5.endsWith(".dex")) {
                    var1_1.add((Object)var6_5);
                }
            } else {
                if (var1_1.isEmpty()) {
                    return;
                }
                var8_6 = Executors.newFixedThreadPool((int)Math.min((int)var1_1.size(), (int)5));
                a.a("Detected dex files:", new Object[0]);
                for (final String var12_8 : var1_1) {
                    var13_9 = new StringBuilder("    ");
                    var13_9.append(var12_8);
                    a.a(var13_9.toString(), new Object[0]);
                    var8_6.submit(new Runnable(){

                        public final void run() {
                            try {
                                i.a(var0, var12_8);
                                return;
                            }
                            catch (Exception exception) {
                                StringBuilder stringBuilder = new StringBuilder("Unable to load DEX file [");
                                stringBuilder.append(var12_8);
                                stringBuilder.append("]");
                                a.c(stringBuilder.toString(), new Object[]{exception});
                                ErrorReportingHelper.report("DexLoader.loadAssetFile", exception);
                                return;
                            }
                        }
                    });
                }
                var8_6.shutdown();
                try {
                    var8_6.awaitTermination(4900L, TimeUnit.MILLISECONDS);
                }
                catch (InterruptedException var10_10) {
                    a.c("Dex loading took more than 10 seconds. Aborted.", new Object[]{var10_10});
                }
lbl34: // 4 sources:
                i.a = true;
                return;
            }
            ++var5_4;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static /* synthetic */ void a(Context context, String string) {
        File file = new File(context.getDir("aic-dex-tmp", 0), string);
        if (!file.exists()) {
            i.a(context, string, file);
        }
        File file2 = new File(context.getDir(new File("aic-dex").toString(), 0), string);
        file2.mkdir();
        ClassLoader classLoader = i.class.getClassLoader();
        if (classLoader instanceof BaseDexClassLoader) {
            Object object = i.a((BaseDexClassLoader)new DexClassLoader(file.getAbsolutePath(), file2.getAbsolutePath(), null, classLoader));
            Class<i> class_ = i.class;
            synchronized (i.class) {
                Object object2 = i.a((BaseDexClassLoader)classLoader);
                BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader)classLoader;
                Object object3 = i.a(object2, object);
                Field field = BaseDexClassLoader.class.getDeclaredField("pathList");
                field.setAccessible(true);
                Object object4 = field.get((Object)baseDexClassLoader);
                Field field2 = object4.getClass().getDeclaredField("dexElements");
                field2.setAccessible(true);
                field2.set(object4, object3);
                // ** MonitorExit[var14_6] (shouldn't be in output)
                return;
            }
        }
        throw new UnsupportedOperationException("Class loader not supported");
    }

    private static void a(Context context, String string, File file) {
        int n2;
        InputStream inputStream = context.getAssets().open(string);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] arrby = new byte[1024];
        while ((n2 = inputStream.read(arrby)) != -1) {
            fileOutputStream.write(arrby, 0, n2);
        }
        fileOutputStream.close();
        inputStream.close();
    }

}

