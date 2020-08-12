/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.OutputStream
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package com.startapp.common.a;

import android.content.Context;
import com.startapp.common.a.g;
import com.startapp.common.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class e {
    public static <T> T a(Context context, String string, Class<T> class_) {
        return e.a(context, null, string, class_);
    }

    public static <T> T a(Context context, String string, String string2, Class<T> class_) {
        T t;
        if (string2 == null) {
            g.a(3, "readFromDisk::fileName is null");
            return null;
        }
        try {
            t = e.a(e.b(context, string), string2);
        }
        catch (Error error) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read from disk: ");
            stringBuilder.append(error.getLocalizedMessage());
            g.a("FileUtils", 6, stringBuilder.toString());
            return null;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read from disk: ");
            stringBuilder.append(exception.getLocalizedMessage());
            g.a("FileUtils", 6, stringBuilder.toString());
            return null;
        }
        return t;
    }

    private static <T> T a(String string, String string2) {
        File file = new File(string);
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(file, string2);
            boolean bl = file2.exists();
            T t = null;
            if (bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Reading file: ");
                stringBuilder.append(file2.getPath());
                g.a("FileUtils", 4, stringBuilder.toString());
                t = e.b(file2);
            }
            return t;
        }
        g.a("FileUtils", 3, "Files directory does not exist or not a directory");
        return null;
    }

    public static void a(Context context, String string) {
        if (string == null) {
            g.a(3, "deleteDirectory::dirPath == null");
            return;
        }
        e.a(new File(e.b(context, string)));
        e.a(new File(e.c(context, string)));
    }

    public static void a(Context context, String string, Serializable serializable) {
        e.a(context, null, string, serializable);
    }

    public static void a(Context context, String string, String string2, Serializable serializable) {
        if (string2 == null) {
            g.a("FileUtils", 3, "writeToDisk: fileName is null");
            return;
        }
        try {
            e.a(e.b(context, string), string2, serializable);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed writing to disk: ");
            stringBuilder.append(exception.getLocalizedMessage());
            g.a("FileUtils", 3, stringBuilder.toString());
            return;
        }
    }

    private static void a(File file) {
        if (file.isDirectory()) {
            File[] arrfile = file.listFiles();
            int n2 = arrfile.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                e.a(arrfile[i2]);
            }
        }
        file.delete();
    }

    private static void a(Serializable serializable, File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream((OutputStream)fileOutputStream);
        objectOutputStream.writeObject((Object)serializable);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    private static void a(String string, String string2, Serializable serializable) {
        File file = new File(string);
        if (!file.exists() && !file.mkdirs()) {
            g.a("FileUtils", 3, "Unable to create directories");
            return;
        }
        File file2 = new File(file, string2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Writing file: ");
        stringBuilder.append(file2.getPath());
        g.a("FileUtils", 4, stringBuilder.toString());
        e.a(serializable, file2);
    }

    public static <T> T b(Context context, String string, String string2, Class<T> class_) {
        T t;
        if (string2 == null) {
            g.a(3, "readFromDisk::fileName is null");
            return null;
        }
        try {
            t = e.a(e.c(context, string), string2);
        }
        catch (Error error) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read from disk: ");
            stringBuilder.append(error.getLocalizedMessage());
            g.a("FileUtils", 6, stringBuilder.toString());
            return null;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to read from disk: ");
            stringBuilder.append(exception.getLocalizedMessage());
            g.a("FileUtils", 6, stringBuilder.toString());
            return null;
        }
        return t;
    }

    private static <T> T b(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream((InputStream)fileInputStream);
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return (T)object;
    }

    private static String b(Context context, String string) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().toString());
        if (string != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(File.separator);
            stringBuilder2.append(string);
            string2 = stringBuilder2.toString();
        } else {
            string2 = "";
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static <T> List<T> b(Context context, String string, Class<T> class_) {
        ArrayList arrayList;
        block9 : {
            block7 : {
                String[] arrstring;
                File file;
                block8 : {
                    arrayList = new ArrayList();
                    file = new File(e.c(context, string));
                    if (!file.exists() || !file.isDirectory()) break block7;
                    arrstring = file.list();
                    if (arrstring != null) break block8;
                    g.a("FileUtils", 3, "Files directory is empty");
                    return null;
                }
                int n2 = arrstring.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    File file2 = new File(file, arrstring[i2]);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Reading file: ");
                    stringBuilder.append(file2.getPath());
                    g.a("FileUtils", 4, stringBuilder.toString());
                    arrayList.add(e.b(file2));
                }
                break block9;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Files directory does not exist or not a directory: ");
                stringBuilder.append(string);
                g.a("FileUtils", 3, stringBuilder.toString());
                return null;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to read from disk: ");
                stringBuilder.append(exception.getLocalizedMessage());
                g.a("FileUtils", 6, stringBuilder.toString());
            }
        }
        return arrayList;
    }

    public static void b(final Context context, final String string, final Serializable serializable) {
        com.startapp.common.g.a(g.a.a, new Runnable(){

            public void run() {
                e.a(context, null, string, serializable);
            }
        });
    }

    public static void b(Context context, String string, String string2, Serializable serializable) {
        if (string2 == null) {
            g.a("FileUtils", 3, "writeToDisk: fileName is null");
            return;
        }
        try {
            e.a(e.c(context, string), string2, serializable);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed writing to disk: ");
            stringBuilder.append(exception.getLocalizedMessage());
            g.a("FileUtils", 3, stringBuilder.toString());
            return;
        }
    }

    private static String c(Context context, String string) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getCacheDir().toString());
        if (string != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(File.separator);
            stringBuilder2.append(string);
            string2 = stringBuilder2.toString();
        } else {
            string2 = "";
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

}

