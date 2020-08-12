/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.text.TextUtils
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.InputStream
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Process
 *  java.lang.ProcessBuilder
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.List
 */
package io.presage.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import io.presage.core.lIIIlIIl;
import io.presage.core.lIIIlIlI;
import io.presage.core.lIIlllIl;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@TargetApi(value=14)
public final class lIIllIll {
    static final String[] IIIIIIII;
    static final String[] IIIIIIIl;
    static final String[] IIIIIIlI;
    static final String[] IIIIIIll;
    static final String[] IIIIIlII;
    static final String[] IIIIIlIl;
    static final String[] IIIIIllI;
    static final String[] IIIIIlll;
    static final String IIIIlIII;
    static final String IIIIlIIl;
    static final String IIIIlIlI;
    static final lIIlllIl[] IIIIlIll;
    static final String IIIIllII;
    static final String IIIIllIl;
    static final String IIIIlllI;
    static final String IIIIllll;
    static final String IIIlIIII;
    static final String IIIlIIIl;
    static final String IIIlIIlI;
    static final String IIIlIIll;
    static final String IIIlIlII;
    static final String IIIlIlIl;
    static final String IIIlIllI;
    static final String IIIlIlll;
    static final String IIIllIII;
    private static final String[] IIIlllIl;
    private static final String IIIllllI;
    private static final String IIIlllll;
    private static final String IIlIIIII;
    private static final String IIlIIIIl;
    private static final String IIlIIIlI;
    private static final String IIlIIIll;
    private static final String IIlIIlII;
    private static final String IIlIIlIl;
    private static final String IIlIIllI;
    private static final String IIlIIlll;
    private static final String IIlIlIII;
    private static final String IIlIlIIl;
    private static final String IIlIlIlI;
    private static final String IIlIlIll;
    private static final String IIlIllII;
    @SuppressLint(value={"StaticFieldLeak"})
    private static lIIllIll IIlIllIl;
    final Context IIIllIIl;
    boolean IIIllIlI = false;
    boolean IIIllIll = true;
    List<String> IIIlllII = new ArrayList();

    static {
        String[] arrstring = new String[]{lIIIlIlI.IIIlIIll.IIIIIIII, lIIIlIlI.IIIlIIll.IIIIIIIl, lIIIlIlI.IIIlIIll.IIIIIIlI, lIIIlIlI.IIIlIIll.IIIIIIll, lIIIlIlI.IIIlIIll.IIIIIlII, lIIIlIlI.IIIlIIll.IIIIIlIl, lIIIlIlI.IIIlIIll.IIIIIllI, lIIIlIlI.IIIlIIll.IIIIIlll, lIIIlIlI.IIIlIIll.IIIIlIII, lIIIlIlI.IIIlIIll.IIIIlIIl, lIIIlIlI.IIIlIIll.IIIIlIlI, lIIIlIlI.IIIlIIll.IIIIlIll, lIIIlIlI.IIIlIIll.IIIIllII, lIIIlIlI.IIIlIIll.IIIIllIl, lIIIlIlI.IIIlIIll.IIIIlllI, lIIIlIlI.IIIlIIll.IIIIllll};
        IIIIIIII = arrstring;
        String[] arrstring2 = new String[]{lIIIlIlI.IIIlIIll.IIIlIIII, lIIIlIlI.IIIlIIll.IIIlIIIl, lIIIlIlI.IIIlIIll.IIIlIIlI};
        IIIIIIIl = arrstring2;
        String[] arrstring3 = new String[]{lIIIlIlI.IIIlIIll.IIIlIIll};
        IIIIIIlI = arrstring3;
        String[] arrstring4 = new String[]{lIIIlIlI.IIIlIIll.IIIlIlII, lIIIlIlI.IIIlIIll.IIIlIlIl};
        IIIIIIll = arrstring4;
        String[] arrstring5 = new String[]{lIIIlIlI.IIIlIIll.IIIlIllI};
        IIIlllIl = arrstring5;
        String[] arrstring6 = new String[]{lIIIlIlI.IIIlIIll.IIIlIlll, lIIIlIlI.IIIlIIll.IIIllIII};
        IIIIIlII = arrstring6;
        String[] arrstring7 = new String[]{lIIIlIlI.IIIlIIll.IIIllIIl, lIIIlIlI.IIIlIIll.IIIllIlI, lIIIlIlI.IIIlIIll.IIIllIll, lIIIlIlI.IIIlIIll.IIIlllII, lIIIlIlI.IIIlIIll.IIIlllIl, lIIIlIlI.IIIlIIll.IIIllllI, lIIIlIlI.IIIlIIll.IIIlllll, lIIIlIlI.IIIlIIll.IIlIIIII};
        IIIIIlIl = arrstring7;
        String[] arrstring8 = new String[]{lIIIlIlI.IIIlIIll.IIlIIIIl, lIIIlIlI.IIIlIIll.IIlIIIlI};
        IIIIIllI = arrstring8;
        String[] arrstring9 = new String[]{lIIIlIlI.IIIlIIll.IIlIIIll, lIIIlIlI.IIIlIIll.IIlIIlII, lIIIlIlI.IIIlIIll.IIlIIlIl};
        IIIIIlll = arrstring9;
        IIIllllI = lIIIlIlI.IIIlIIll.IIlllIIl;
        IIIIlIII = lIIIlIlI.IIIlIIll.IIlllIlI;
        IIIIlIIl = lIIIlIlI.IIIlIIll.IIlllIll;
        IIIIlIlI = lIIIlIlI.IIIlIIll.IIllllII;
        IIIlllll = lIIIlIlI.IIIlIIll.IIllllIl;
        lIIlllIl[] arrlIIlllIl = new lIIlllIl[]{new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIIllI, null), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIIlll, null), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIlIII, null), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIlIIl, null), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIlIlI, null), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIlIll, IIIllllI), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIllII, IIIllllI), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIllIl, IIIIlIII), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIlllI, null), new lIIlllIl(lIIIlIlI.IIIlIIll.IIlIllll, null), new lIIlllIl(lIIIlIlI.IIIlIIll.IIllIIII, IIIlllll), new lIIlllIl(lIIIlIlI.IIIlIIll.IIllIIIl, IIIIlIIl), new lIIlllIl(lIIIlIlI.IIIlIIll.IIllIIlI, IIIIlIlI), new lIIlllIl(lIIIlIlI.IIIlIIll.IIllIIll, IIIIlIlI), new lIIlllIl(lIIIlIlI.IIIlIIll.IIllIlII, null)};
        IIIIlIll = arrlIIlllIl;
        IIlIIIII = lIIIlIlI.IIIlIIll.IIllIlIl;
        IIlIIIIl = lIIIlIlI.IIIlIIll.IIllIllI;
        IIlIIIlI = lIIIlIlI.IIIlIIll.IIllIlll;
        IIlIIIll = lIIIlIlI.IIIlIIll.IIlllIII;
        IIIIllII = lIIIlIlI.IIIlIIll.IIlllllI;
        IIIIllIl = lIIIlIlI.IIIlIIll.IIllllll;
        IIIIlllI = lIIIlIlI.IIIlIIll.IlIIIIII;
        IIIIllll = lIIIlIlI.IIIlIIll.IlIIIIIl;
        IIIlIIII = lIIIlIlI.IIIlIIll.IlIIIIlI;
        IIIlIIIl = lIIIlIlI.IIIlIIll.IlIIIIll;
        IIIlIIlI = lIIIlIlI.IIIlIIll.IlIIIlII;
        IIIlIIll = lIIIlIlI.IIIlIIll.IlIIIlIl;
        IIIlIlII = lIIIlIlI.IIIlIIll.IlIIIllI;
        IIIlIlIl = lIIIlIlI.IIIlIIll.IlIIIlll;
        IIIlIllI = lIIIlIlI.IIIlIIll.IlIIlIII;
        IIIlIlll = lIIIlIlI.IIIlIIll.IlIIlIIl;
        IIIllIII = lIIIlIlI.IIIlIIll.IlIIlIlI;
        IIlIIlII = lIIIlIlI.IIIlIIll.IlIIlIll;
        IIlIIlIl = lIIIlIlI.IIIlIIll.IlIIllII;
        IIlIIllI = lIIIlIlI.IIIlIIll.IlIIllIl;
        IIlIIlll = lIIIlIlI.IIIlIIll.IlIIlllI;
        IIlIlIII = lIIIlIlI.IIIlIIll.IlIIllll;
        IIlIlIIl = lIIIlIlI.IIIlIIll.IlIlIIII;
        IIlIlIlI = lIIIlIlI.IIIlIIll.IlIlIIIl;
        IIlIlIll = lIIIlIlI.IIIlIIll.IlIlIIlI;
        IIlIllII = lIIIlIlI.IIIlIIll.IlIlIIll;
    }

    private lIIllIll(Context context) {
        this.IIIllIIl = context;
        this.IIIlllII.add((Object)IIlIIIIl);
        this.IIIlllII.add((Object)IIlIIIlI);
        this.IIIlllII.add((Object)IIlIIIll);
    }

    public static lIIllIll IIIIIIII(Context context) {
        if (context != null) {
            if (IIlIllIl == null) {
                IIlIllIl = new lIIllIll(context.getApplicationContext());
            }
            return IIlIllIl;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    static String IIIIIIII(Context context, String string) {
        try {
            Class class_ = context.getClassLoader().loadClass(IIlIlIll);
            String string2 = (String)class_.getMethod(IIlIllII, new Class[]{String.class}).invoke((Object)class_, new Object[]{string});
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    static boolean IIIIIIII() {
        File[] arrfile = new File[]{new File(IIlIIlII), new File(IIlIIlIl)};
        for (int i2 = 0; i2 < 2; ++i2) {
            File file = arrfile[i2];
            if (!file.exists() || !file.canRead()) continue;
            byte[] arrby = new byte[1024];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(arrby);
                fileInputStream.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            String string = new String(arrby);
            String[] arrstring = IIIlllIl;
            int n2 = arrstring.length;
            for (int i3 = 0; i3 < n2; ++i3) {
                if (!string.contains((CharSequence)arrstring[i3])) continue;
                return true;
            }
        }
        return false;
    }

    static boolean IIIIIIII(String[] arrstring, String string) {
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!new File(arrstring[i2]).exists()) continue;
            new Object[1][0] = string;
            return true;
        }
        return false;
    }

    final boolean IIIIIIIl() {
        if (lIIIlIIl.IIIIIIII(this.IIIllIIl, "android.permission.INTERNET")) {
            StringBuilder stringBuilder;
            String[] arrstring = new String[]{IIlIIllI};
            stringBuilder = new StringBuilder();
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(arrstring);
                processBuilder.directory(new File(IIlIIlll));
                processBuilder.redirectErrorStream(true);
                InputStream inputStream = processBuilder.start().getInputStream();
                byte[] arrby = new byte[1024];
                while (inputStream.read(arrby) != -1) {
                    stringBuilder.append(new String(arrby));
                }
                inputStream.close();
            }
            catch (Exception exception) {}
            String string = stringBuilder.toString();
            if (!TextUtils.isEmpty((CharSequence)string)) {
                for (String string2 : string.split("\n")) {
                    if (!string2.contains((CharSequence)IIlIlIII) && !string2.contains((CharSequence)IIlIlIIl) && !string2.contains((CharSequence)IIlIlIlI) || !string2.contains((CharSequence)IIlIIIII)) continue;
                    return true;
                }
            }
        }
        return false;
    }
}

