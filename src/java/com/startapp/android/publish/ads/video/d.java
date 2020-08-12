/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Base64
 *  com.startapp.android.publish.ads.video.d$2
 *  com.startapp.android.publish.ads.video.d$3
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.Iterator
 *  java.util.LinkedList
 */
package com.startapp.android.publish.ads.video;

import android.content.Context;
import android.util.Base64;
import com.startapp.android.publish.ads.video.c;
import com.startapp.android.publish.ads.video.d;
import com.startapp.android.publish.ads.video.g;
import com.startapp.android.publish.ads.video.h;
import com.startapp.android.publish.adsCommon.b;
import com.startapp.android.publish.adsCommon.n;
import com.startapp.common.a.e;
import com.startapp.common.g;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedList;

public class d {
    private static d a = new d();
    private LinkedList<com.startapp.android.publish.cache.h> b = new LinkedList();

    private d() {
    }

    public static d a() {
        return a;
    }

    private void a(Context context) {
        if (this.b == null) {
            this.b = e.a(context, "CachedAds", LinkedList.class);
            if (this.b == null) {
                this.b = new LinkedList();
            }
            if (this.a(b.a().H().b())) {
                this.b(context);
            }
        }
    }

    private void b(Context context) {
        e.b(context, "CachedAds", this.b);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Context context, String string, g.a a2, c.a a3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Full cache: ");
        stringBuilder.append(string);
        com.startapp.common.a.g.a("VideoAdCacheManager", 3, stringBuilder.toString());
        this.a(context);
        try {
            String string2;
            URL uRL = new URL(string);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(uRL.getHost());
            stringBuilder2.append(uRL.getPath().replace((CharSequence)"/", (CharSequence)"_"));
            String string3 = stringBuilder2.toString();
            try {
                String string4;
                String string5 = string3.substring(0, string3.lastIndexOf(46));
                String string6 = string3.substring(string3.lastIndexOf(46));
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(new String(Base64.encodeToString((byte[])MessageDigest.getInstance((String)"MD5").digest(string5.getBytes()), (int)0)).replaceAll("[^a-zA-Z0-9]+", "_"));
                stringBuilder3.append(string6);
                string2 = string4 = stringBuilder3.toString();
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("Error applying MD5 digest to filename ");
                stringBuilder4.append(string3);
                com.startapp.common.a.g.a("VideoAdCacheManager", 6, stringBuilder4.toString(), noSuchAlgorithmException);
                string2 = string3;
            }
            2 var22_16 = new 2(this, a2, new com.startapp.android.publish.cache.h(string2), context);
            3 var23_17 = new 3(this, a3);
            g g2 = new g(context, uRL, string2, (g.a)var22_16, (c.a)var23_17);
            g2.a();
            return;
        }
        catch (MalformedURLException malformedURLException) {
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Malformed url ");
            stringBuilder5.append(string);
            com.startapp.common.a.g.a("VideoAdCacheManager", 6, stringBuilder5.toString(), malformedURLException);
            if (a2 != null) {
                a2.a(null);
            }
            return;
        }
    }

    protected void a(Context context, com.startapp.android.publish.cache.h h2) {
        if (this.b.contains((Object)h2)) {
            this.b.remove((Object)h2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cachedVideoAds already contained ");
            stringBuilder.append(h2.a());
            stringBuilder.append(" - removed. Size = ");
            stringBuilder.append(this.b.size());
            com.startapp.common.a.g.a("VideoAdCacheManager", 3, stringBuilder.toString());
        }
        this.a(-1 + b.a().H().b());
        this.b.add((Object)h2);
        this.b(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Added ");
        stringBuilder.append(h2.a());
        stringBuilder.append(" to cachedVideoAds. Size = ");
        stringBuilder.append(this.b.size());
        com.startapp.common.a.g.a("VideoAdCacheManager", 3, stringBuilder.toString());
    }

    public void a(final Context context, final String string, final g.a a2, final c.a a3) {
        g.a a4 = g.a.b;
        Runnable runnable = new Runnable(){

            public void run() {
                d.this.b(context, string, a2, a3);
            }
        };
        com.startapp.common.g.a(a4, runnable);
    }

    public boolean a(int n2) {
        Iterator iterator = this.b.iterator();
        boolean bl = false;
        while (iterator.hasNext() && this.b.size() > n2) {
            com.startapp.android.publish.cache.h h2 = (com.startapp.android.publish.cache.h)iterator.next();
            if (h.a(h2.b())) continue;
            bl = true;
            iterator.remove();
            if (h2.b() == null) continue;
            new File(h2.b()).delete();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cachedVideoAds reached the maximum of ");
            stringBuilder.append(n2);
            stringBuilder.append(" videos - removed ");
            stringBuilder.append(h2.a());
            stringBuilder.append(" Size = ");
            stringBuilder.append(this.b.size());
            com.startapp.common.a.g.a("VideoAdCacheManager", 3, stringBuilder.toString());
        }
        return bl;
    }

}

