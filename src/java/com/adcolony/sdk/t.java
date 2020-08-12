/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.BufferedWriter
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Reader
 *  java.io.Writer
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.LinkedList
 *  java.util.zip.GZIPInputStream
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import com.adcolony.sdk.a;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.af;
import com.adcolony.sdk.ap;
import com.adcolony.sdk.aq;
import com.adcolony.sdk.t;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedList;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

class t {
    private LinkedList<Runnable> a = new LinkedList();
    private boolean b;

    t() {
    }

    static /* synthetic */ boolean a(t t2, ad ad2) {
        return t2.f(ad2);
    }

    static /* synthetic */ boolean b(t t2, ad ad2) {
        return t2.g(ad2);
    }

    static /* synthetic */ boolean c(t t2, ad ad2) {
        return t2.h(ad2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean f(ad ad2) {
        JSONObject jSONObject = ad2.c();
        String string = w.b(jSONObject, "filepath");
        a.a().n().b();
        JSONObject jSONObject2 = w.a();
        try {
            int n2 = w.c(jSONObject, "offset");
            int n3 = w.c(jSONObject, "size");
            boolean bl = w.d(jSONObject, "gunzip");
            String string2 = w.b(jSONObject, "output_filepath");
            aq aq2 = new aq((InputStream)new FileInputStream(string), n2, n3);
            aq aq3 = bl ? new GZIPInputStream((InputStream)aq2, 1024) : aq2;
            if (string2.equals((Object)"")) {
                int n4;
                StringBuilder stringBuilder = new StringBuilder(aq3.available());
                byte[] arrby = new byte[1024];
                while ((n4 = aq3.read(arrby, 0, 1024)) >= 0) {
                    stringBuilder.append(new String(arrby, 0, n4, "ISO-8859-1"));
                }
                w.b(jSONObject2, "size", stringBuilder.length());
                w.a(jSONObject2, "data", stringBuilder.toString());
            } else {
                int n5;
                FileOutputStream fileOutputStream = new FileOutputStream(string2);
                byte[] arrby = new byte[1024];
                int n6 = 0;
                while ((n5 = aq3.read(arrby, 0, 1024)) >= 0) {
                    fileOutputStream.write(arrby, 0, n5);
                    n6 += n5;
                }
                fileOutputStream.close();
                w.b(jSONObject2, "size", n6);
            }
            aq3.close();
            w.a(jSONObject2, "success", true);
            ad2.a(jSONObject2).b();
            return true;
        }
        catch (OutOfMemoryError outOfMemoryError) {
            new y.a().a("Out of memory error - disabling AdColony.").a(y.g);
            a.a().a(true);
            w.a(jSONObject2, "success", false);
            ad2.a(jSONObject2).b();
            return false;
        }
        catch (IOException iOException) {
            w.a(jSONObject2, "success", false);
            ad2.a(jSONObject2).b();
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    private boolean g(ad var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl244 : NEW : trying to set 0 previously set to 1
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

    private boolean h(ad ad2) {
        JSONObject jSONObject;
        block3 : {
            String string = w.b(ad2.c(), "filepath");
            a.a().n().b();
            jSONObject = w.a();
            try {
                if (!new File(string).mkdir()) break block3;
                w.a(jSONObject, "success", true);
                ad2.a(jSONObject).b();
                return true;
            }
            catch (Exception exception) {
                w.a(jSONObject, "success", false);
                ad2.a(jSONObject).b();
                return false;
            }
        }
        w.a(jSONObject, "success", false);
        return false;
    }

    StringBuilder a(String string, boolean bl) throws IOException {
        String string2;
        File file = new File(string);
        StringBuilder stringBuilder = new StringBuilder((int)file.length());
        BufferedReader bufferedReader = bl ? new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(file.getAbsolutePath()), "UTF-8")) : new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(file.getAbsolutePath())));
        while ((string2 = bufferedReader.readLine()) != null) {
            stringBuilder.append(string2);
            stringBuilder.append("\n");
        }
        bufferedReader.close();
        return stringBuilder;
    }

    void a() {
        a.a("FileSystem.save", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 1 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        this.b.a.a(this.a);
                        this.b.a.b();
                    }
                });
            }
        });
        a.a("FileSystem.delete", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 2 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        File file = new File(w.b(this.a.c(), "filepath"));
                        this.b.a.a(this.a, file);
                        this.b.a.b();
                    }
                });
            }
        });
        a.a("FileSystem.listing", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 3 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        this.b.a.b(this.a);
                        this.b.a.b();
                    }
                });
            }
        });
        a.a("FileSystem.load", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 4 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        this.b.a.c(this.a);
                        this.b.a.b();
                    }
                });
            }
        });
        a.a("FileSystem.rename", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 5 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        this.b.a.d(this.a);
                        this.b.a.b();
                    }
                });
            }
        });
        a.a("FileSystem.exists", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 6 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        this.b.a.e(this.a);
                        this.b.a.b();
                    }
                });
            }
        });
        a.a("FileSystem.extract", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 7 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        t.a(this.b.a, this.a);
                        this.b.a.b();
                    }
                });
            }
        });
        a.a("FileSystem.unpack_bundle", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 8 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        t.b(this.b.a, this.a);
                        this.b.a.b();
                    }
                });
            }
        });
        a.a("FileSystem.create_directory", new af(this){
            final /* synthetic */ t a;
            {
                this.a = t2;
            }

            public void a(ad ad2) {
                this.a.a(new Runnable(this, ad2){
                    final /* synthetic */ ad a;
                    final /* synthetic */ 9 b;
                    {
                        this.b = var1_1;
                        this.a = ad2;
                    }

                    public void run() {
                        t.c(this.b.a, this.a);
                        this.b.a.b();
                    }
                });
            }
        });
    }

    void a(Runnable runnable) {
        if (this.a.isEmpty() && !this.b) {
            this.b = true;
            runnable.run();
            return;
        }
        this.a.push((Object)runnable);
    }

    void a(String string, String string2, boolean bl) throws IOException {
        BufferedWriter bufferedWriter = bl ? new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(string), "UTF-8")) : new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(string)));
        bufferedWriter.write(string2);
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    boolean a(ad ad2) {
        JSONObject jSONObject = ad2.c();
        String string = w.b(jSONObject, "filepath");
        String string2 = w.b(jSONObject, "data");
        String string3 = w.b(jSONObject, "encoding");
        boolean bl = string3 != null && string3.equals((Object)"utf8");
        a.a().n().b();
        JSONObject jSONObject2 = w.a();
        try {
            this.a(string, string2, bl);
            w.a(jSONObject2, "success", true);
            ad2.a(jSONObject2).b();
            return true;
        }
        catch (IOException iOException) {
            w.a(jSONObject2, "success", false);
            ad2.a(jSONObject2).b();
            return false;
        }
    }

    boolean a(ad ad2, File file) {
        a.a().n().b();
        JSONObject jSONObject = w.a();
        if (this.a(file)) {
            w.a(jSONObject, "success", true);
            ad2.a(jSONObject).b();
            return true;
        }
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

    boolean a(File file) {
        block6 : {
            try {
                if (file.isDirectory()) {
                    if (file.list().length == 0) {
                        return file.delete();
                    }
                    String[] arrstring = file.list();
                    if (arrstring.length > 0) {
                        return this.a(new File(file, arrstring[0]));
                    }
                    if (file.list().length == 0) {
                        return file.delete();
                    }
                    break block6;
                }
                boolean bl = file.delete();
                return bl;
            }
            catch (Exception exception) {
                return false;
            }
        }
        return false;
    }

    boolean a(String string) throws Exception {
        return new File(string).exists();
    }

    void b() {
        this.b = false;
        if (!this.a.isEmpty()) {
            this.b = true;
            ((Runnable)this.a.removeLast()).run();
        }
    }

    boolean b(ad ad2) {
        String string = w.b(ad2.c(), "filepath");
        a.a().n().b();
        JSONObject jSONObject = w.a();
        String[] arrstring = new File(string).list();
        if (arrstring != null) {
            JSONArray jSONArray = w.b();
            for (String string2 : arrstring) {
                JSONObject jSONObject2 = w.a();
                w.a(jSONObject2, "filename", string2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(string2);
                if (new File(stringBuilder.toString()).isDirectory()) {
                    w.a(jSONObject2, "is_folder", true);
                } else {
                    w.a(jSONObject2, "is_folder", false);
                }
                w.a(jSONArray, (Object)jSONObject2);
            }
            w.a(jSONObject, "success", true);
            w.a(jSONObject, "entries", jSONArray);
            ad2.a(jSONObject).b();
            return true;
        }
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

    String c(ad ad2) {
        JSONObject jSONObject = ad2.c();
        String string = w.b(jSONObject, "filepath");
        String string2 = w.b(jSONObject, "encoding");
        boolean bl = string2 != null && string2.equals((Object)"utf8");
        a.a().n().b();
        JSONObject jSONObject2 = w.a();
        try {
            StringBuilder stringBuilder = this.a(string, bl);
            w.a(jSONObject2, "success", true);
            w.a(jSONObject2, "data", stringBuilder.toString());
            ad2.a(jSONObject2).b();
            String string3 = stringBuilder.toString();
            return string3;
        }
        catch (IOException iOException) {
            w.a(jSONObject2, "success", false);
            ad2.a(jSONObject2).b();
            return "";
        }
    }

    boolean d(ad ad2) {
        JSONObject jSONObject;
        block3 : {
            JSONObject jSONObject2 = ad2.c();
            String string = w.b(jSONObject2, "filepath");
            String string2 = w.b(jSONObject2, "new_filepath");
            a.a().n().b();
            jSONObject = w.a();
            try {
                if (!new File(string).renameTo(new File(string2))) break block3;
                w.a(jSONObject, "success", true);
                ad2.a(jSONObject).b();
                return true;
            }
            catch (Exception exception) {
                w.a(jSONObject, "success", false);
                ad2.a(jSONObject).b();
                return false;
            }
        }
        w.a(jSONObject, "success", false);
        ad2.a(jSONObject).b();
        return false;
    }

    boolean e(ad ad2) {
        String string = w.b(ad2.c(), "filepath");
        a.a().n().b();
        JSONObject jSONObject = w.a();
        try {
            boolean bl = this.a(string);
            w.a(jSONObject, "result", bl);
            w.a(jSONObject, "success", true);
            ad2.a(jSONObject).b();
            return bl;
        }
        catch (Exception exception) {
            w.a(jSONObject, "result", false);
            w.a(jSONObject, "success", false);
            ad2.a(jSONObject).b();
            exception.printStackTrace();
            return false;
        }
    }
}

