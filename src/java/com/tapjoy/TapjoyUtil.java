/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.io.BufferedInputStream
 *  java.io.ByteArrayInputStream
 *  java.io.File
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.security.MessageDigest
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  javax.xml.parsers.DocumentBuilder
 *  javax.xml.parsers.DocumentBuilderFactory
 *  org.json.JSONObject
 *  org.w3c.dom.Document
 *  org.w3c.dom.Element
 *  org.w3c.dom.Node
 *  org.w3c.dom.NodeList
 */
package com.tapjoy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tapjoy.TapjoyLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TapjoyUtil {
    private static String a;
    private static HashMap b;

    static {
        b = new HashMap();
    }

    public static String SHA1(String string2) {
        return TapjoyUtil.a("SHA-1", string2);
    }

    public static String SHA256(String string2) {
        return TapjoyUtil.a("SHA-256", string2);
    }

    private static String a(String string2, String string3) {
        MessageDigest messageDigest = MessageDigest.getInstance((String)string2);
        messageDigest.update(string3.getBytes("iso-8859-1"), 0, string3.length());
        byte[] arrby = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        block0 : for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = 15 & arrby[i2] >>> 4;
            int n3 = 0;
            do {
                if (n2 >= 0 && n2 <= 9) {
                    stringBuffer.append((char)(n2 + 48));
                } else {
                    stringBuffer.append((char)(97 + (n2 - 10)));
                }
                n2 = 15 & arrby[i2];
                int n4 = n3 + 1;
                if (n3 > 0) {
                    continue block0;
                }
                n3 = n4;
            } while (true);
        }
        return stringBuffer.toString();
    }

    public static Document buildDocument(String string2) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string2.getBytes("UTF-8"));
            Document document = documentBuilderFactory.newDocumentBuilder().parse((InputStream)byteArrayInputStream);
            return document;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder("buildDocument exception: ");
            stringBuilder.append(exception.toString());
            TapjoyLog.e("TapjoyUtil", stringBuilder.toString());
            return null;
        }
    }

    public static String convertURLParams(Map map, boolean bl2) {
        Iterator iterator = map.entrySet().iterator();
        String string2 = "";
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (string2.length() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append("&");
                string2 = stringBuilder.toString();
            }
            if (bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(Uri.encode((String)((String)entry.getKey())));
                stringBuilder.append("=");
                stringBuilder.append(Uri.encode((String)((String)entry.getValue())));
                string2 = stringBuilder.toString();
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append((String)entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String)entry.getValue());
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static Map convertURLParams(String string2, boolean bl2) {
        String string3;
        HashMap hashMap = new HashMap();
        String string4 = string3 = "";
        boolean bl3 = false;
        for (int i2 = 0; i2 < string2.length() && i2 != -1; ++i2) {
            char c2 = string2.charAt(i2);
            if (!bl3) {
                if (c2 == '=') {
                    if (bl2) {
                        string3 = Uri.decode((String)string3);
                    }
                    string4 = string3;
                    bl3 = true;
                    string3 = "";
                    continue;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(c2);
                string3 = stringBuilder.toString();
                continue;
            }
            if (!bl3) continue;
            if (c2 == '&') {
                if (bl2) {
                    string3 = Uri.decode((String)string3);
                }
                hashMap.put((Object)string4, (Object)string3);
                string3 = "";
                bl3 = false;
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(c2);
            string3 = stringBuilder.toString();
        }
        if (bl3 && string3.length() > 0) {
            if (bl2) {
                string3 = Uri.decode((String)string3);
            }
            hashMap.put((Object)string4, (Object)string3);
        }
        return hashMap;
    }

    public static String copyTextFromJarIntoString(String string2) {
        return TapjoyUtil.copyTextFromJarIntoString(string2, null);
    }

    /*
     * Exception decompiling
     */
    public static String copyTextFromJarIntoString(String var0, Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public static Bitmap createBitmapFromView(View view) {
        Bitmap bitmap = null;
        if (view != null) {
            int n2 = view.getLayoutParams().width;
            bitmap = null;
            if (n2 > 0) {
                int n3 = view.getLayoutParams().height;
                bitmap = null;
                if (n3 > 0) {
                    try {
                        bitmap = Bitmap.createBitmap((int)view.getLayoutParams().width, (int)view.getLayoutParams().height, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                        view.draw(canvas);
                        return bitmap;
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder = new StringBuilder("error creating bitmap: ");
                        stringBuilder.append(exception.toString());
                        TapjoyLog.d("TapjoyUtil", stringBuilder.toString());
                    }
                }
            }
        }
        return bitmap;
    }

    public static void deleteFileOrDirectory(File file) {
        File[] arrfile;
        if (file == null) {
            return;
        }
        if (file.isDirectory() && (arrfile = file.listFiles()) != null && arrfile.length > 0) {
            int n2 = arrfile.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                TapjoyUtil.deleteFileOrDirectory(arrfile[i2]);
            }
        }
        TapjoyLog.d("TapjoyUtil", "****************************************");
        StringBuilder stringBuilder = new StringBuilder("deleteFileOrDirectory: ");
        stringBuilder.append(file.getAbsolutePath());
        TapjoyLog.d("TapjoyUtil", stringBuilder.toString());
        TapjoyLog.d("TapjoyUtil", "****************************************");
        file.delete();
    }

    public static String determineMimeType(String string2) {
        String string3;
        if (string2.endsWith(".")) {
            string2 = string2.substring(0, -1 + string2.length());
        }
        if ((string3 = string2.lastIndexOf(46) != -1 ? string2.substring(1 + string2.lastIndexOf(46)) : "").equals((Object)"css")) {
            return "text/css";
        }
        if (string3.equals((Object)"js")) {
            return "text/javascript";
        }
        if (string3.equals((Object)"html")) {
            return "text/html";
        }
        return "application/octet-stream";
    }

    public static long fileOrDirectorySize(File file) {
        File[] arrfile = file.listFiles();
        int n2 = arrfile.length;
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            File file2 = arrfile[i2];
            long l3 = file2.isFile() ? file2.length() : TapjoyUtil.fileOrDirectorySize(file2);
            l2 += l3;
        }
        return l2;
    }

    public static String getNodeTrimValue(NodeList nodeList) {
        Element element = (Element)nodeList.item(0);
        if (element != null) {
            NodeList nodeList2 = element.getChildNodes();
            int n2 = nodeList2.getLength();
            String string2 = "";
            for (int i2 = 0; i2 < n2; ++i2) {
                Node node = nodeList2.item(i2);
                if (node == null) continue;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(node.getNodeValue());
                string2 = stringBuilder.toString();
            }
            if (string2 != null && !string2.equals((Object)"")) {
                return string2.trim();
            }
        }
        return null;
    }

    public static String getRedirectDomain(String string2) {
        if (string2 != null) {
            return string2.substring(2 + string2.indexOf("//"), string2.lastIndexOf("/"));
        }
        return "";
    }

    public static Object getResource(String string2) {
        return b.get((Object)string2);
    }

    public static Map jsonToStringMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != JSONObject.NULL) {
            hashMap = TapjoyUtil.toStringMap(jSONObject);
        }
        return hashMap;
    }

    /*
     * Exception decompiling
     */
    public static Bitmap loadBitmapFromJar(String var0, Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl179.1 : INVOKESTATIC : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    public static void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public static void safePut(Map map, String string2, Number number) {
        if (string2 != null && string2.length() > 0 && number != null) {
            map.put((Object)string2, (Object)number.toString());
        }
    }

    public static void safePut(Map map, String string2, String string3, boolean bl2) {
        if (string2 != null && string2.length() > 0 && string3 != null && string3.length() > 0) {
            if (bl2) {
                map.put((Object)Uri.encode((String)string2), (Object)Uri.encode((String)string3));
                return;
            }
            map.put((Object)string2, (Object)string3);
        }
    }

    public static View scaleDisplayAd(View view, int n2) {
        int n3 = view.getLayoutParams().width;
        int n4 = view.getLayoutParams().height;
        StringBuilder stringBuilder = new StringBuilder("wxh: ");
        stringBuilder.append(n3);
        stringBuilder.append("x");
        stringBuilder.append(n4);
        TapjoyLog.d("TapjoyUtil", stringBuilder.toString());
        if (n3 > n2) {
            int n5 = Double.valueOf((double)(100.0 * Double.valueOf((double)(Double.valueOf((double)n2) / Double.valueOf((double)n3))))).intValue();
            WebView webView = (WebView)view;
            webView.getSettings().setSupportZoom(true);
            webView.setPadding(0, 0, 0, 0);
            webView.setVerticalScrollBarEnabled(false);
            webView.setHorizontalScrollBarEnabled(false);
            webView.setInitialScale(n5);
            view.setLayoutParams(new ViewGroup.LayoutParams(n2, n4 * n2 / n3));
        }
        return view;
    }

    public static void setResource(String string2, Object object) {
        b.put((Object)string2, object);
    }

    public static Map toStringMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            hashMap.put((Object)string2, (Object)jSONObject.get(string2).toString());
        }
        return hashMap;
    }

    public static void writeFileToDevice(BufferedInputStream bufferedInputStream, OutputStream outputStream) {
        int n2;
        byte[] arrby = new byte[1024];
        while ((n2 = bufferedInputStream.read(arrby)) != -1) {
            outputStream.write(arrby, 0, n2);
        }
    }
}

