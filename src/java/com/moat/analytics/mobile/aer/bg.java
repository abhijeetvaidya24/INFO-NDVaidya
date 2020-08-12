/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Package
 *  java.lang.String
 *  java.lang.reflect.Field
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.moat.analytics.mobile.aer;

import android.content.Context;
import android.util.Pair;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.aer.base.functional.a;
import com.moat.analytics.mobile.aer.be;
import com.moat.analytics.mobile.aer.bf;
import com.moat.analytics.mobile.aer.bh;
import com.moat.analytics.mobile.aer.bi;
import com.moat.analytics.mobile.aer.bj;
import com.moat.analytics.mobile.aer.bk;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

class bg
implements be {
    private static final AtomicReference<a<bk<WebViewClient>>> a = new AtomicReference();

    bg(Context context) {
        if (a.get() == null) {
            WebView webView = new WebView(context);
            WebViewClient webViewClient = new WebViewClient();
            webView.setWebViewClient(webViewClient);
            bk<WebViewClient> bk2 = this.a(webView, webViewClient);
            a.compareAndSet(null, a.b(bk2));
        }
    }

    private bk<WebViewClient> a(WebView webView, WebViewClient webViewClient) {
        HashSet hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        linkedList.add((Object)new bi(this, new Field[0], (Object)webView));
        int n2 = 0;
        block0 : while (!linkedList.isEmpty() && n2 < 250) {
            ++n2;
            bi bi2 = (bi)linkedList.poll();
            if (hashSet.contains((Object)bi2)) continue;
            hashSet.add((Object)bi2);
            Map<Field, Object> map = this.a(bi2.b);
            Iterator iterator = map.keySet().iterator();
            boolean bl = false;
            while (iterator.hasNext()) {
                Field field = (Field)iterator.next();
                if (n2 >= 250) continue block0;
                if (bl) {
                    ++n2;
                }
                Object object = map.get((Object)field);
                bi bi3 = new bi(this, bi2.a, field, object);
                if (object == webViewClient && WebViewClient.class.isAssignableFrom(field.getType())) {
                    return new bk<WebViewClient>(this, WebViewClient.class, bi3.a, null);
                }
                if (object != null && !(object instanceof bj) && bi3.a.length < 5) {
                    linkedList.add((Object)bi3);
                }
                bl = true;
            }
        }
        return null;
    }

    static /* synthetic */ Object a(bg bg2, Object object, Field field) {
        return bg2.a(object, field);
    }

    /*
     * Exception decompiling
     */
    private Object a(Object var1, Field var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl11 : ALOAD_2 : trying to set 1 previously set to 0
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

    private Map<Field, Object> a(Object object) {
        HashSet hashSet = new HashSet();
        for (Field field : object.getClass().getDeclaredFields()) {
            String string;
            Package package_;
            Class class_ = field.getType();
            if (class_.isPrimitive() || (string = (package_ = class_.getPackage()) != null ? package_.getName() : "") != null && string.equals((Object)"java.lang")) continue;
            hashSet.add((Object)field);
        }
        return this.a(object, (Set<Field>)hashSet);
    }

    private Map<Field, Object> a(Object object, Set<Field> set) {
        HashMap hashMap = new HashMap();
        for (Field field : set) {
            hashMap.put((Object)field, this.a(object, field));
        }
        return hashMap;
    }

    @Override
    public Pair<bf, a<WebViewClient>> a(WebView webView) {
        a a2 = (a)a.get();
        if (!a2.c()) {
            return new Pair((Object)bf.b, a.a());
        }
        Object object = ((bk)a2.b()).a((Object)webView);
        if (object != null && !(object instanceof WebViewClient)) {
            return new Pair((Object)bf.b, a.a());
        }
        return new Pair((Object)bf.a, a.a((WebViewClient)object));
    }
}

