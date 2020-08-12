/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  com.applovin.impl.sdk.ad.g
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.io.UnsupportedEncodingException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.MalformedURLException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicReference
 */
package com.applovin.impl.sdk.d;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.network.b;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

abstract class c
extends a {
    protected final g a;
    private AppLovinAdLoadListener c;
    private final n d;
    private final Collection<Character> e;
    private final e f;

    c(String string, g g2, j j2, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(string, j2);
        if (g2 != null) {
            this.a = g2;
            this.c = appLovinAdLoadListener;
            this.d = j2.N();
            this.e = this.h();
            this.f = new e();
            return;
        }
        throw new IllegalArgumentException("No ad specified.");
    }

    private Uri a(Uri uri, String string) {
        String string2;
        StringBuilder stringBuilder;
        if (uri != null) {
            String string3 = uri.toString();
            if (com.applovin.impl.sdk.e.j.b(string3)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Caching ");
                stringBuilder2.append(string);
                stringBuilder2.append(" image...");
                this.a(stringBuilder2.toString());
                return this.f(string3);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to cache ");
            stringBuilder.append(string);
            string2 = " image";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("No ");
            stringBuilder.append(string);
            string2 = " image to cache";
        }
        stringBuilder.append(string2);
        this.a(stringBuilder.toString());
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private String a(String string, String string2) {
        File file;
        StringBuilder stringBuilder;
        String string3 = string2.replace((CharSequence)"/", (CharSequence)"_");
        String string4 = this.a.H();
        if (com.applovin.impl.sdk.e.j.b(string4)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string4);
            stringBuilder2.append(string3);
            string3 = stringBuilder2.toString();
        }
        if ((file = this.d.a(string3, this.b.w(), true)) == null) {
            return null;
        }
        if (file.exists()) {
            this.f.b(file.length());
            stringBuilder = new StringBuilder();
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string);
            stringBuilder3.append(string2);
            String string5 = stringBuilder3.toString();
            List list = Arrays.asList((Object[])new String[]{string});
            if (!this.d.a(file, string5, (List<String>)list, this.f)) {
                return null;
            }
            stringBuilder = new StringBuilder();
        }
        stringBuilder.append("file://");
        stringBuilder.append(file.getAbsolutePath());
        return stringBuilder.toString();
    }

    private Collection<Character> h() {
        HashSet hashSet = new HashSet();
        char[] arrc = this.b.a(b.bt).toCharArray();
        int n2 = arrc.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            hashSet.add((Object)Character.valueOf((char)arrc[i2]));
        }
        hashSet.add((Object)Character.valueOf((char)'\"'));
        return hashSet;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Uri a(String string, List<String> list, boolean bl) {
        try {
            if (!com.applovin.impl.sdk.e.j.b(string)) return null;
            {
                String string2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Caching video ");
                stringBuilder.append(string);
                stringBuilder.append("...");
                this.a(stringBuilder.toString());
                String string3 = this.d.a(this.d(), string, this.a.H(), list, bl, this.f);
                if (com.applovin.impl.sdk.e.j.b(string3)) {
                    File file = this.d.a(string3, this.d(), false);
                    if (file != null) {
                        Uri uri = Uri.fromFile((File)file);
                        if (uri != null) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Finish caching video for ad #");
                            stringBuilder2.append(this.a.getAdIdNumber());
                            stringBuilder2.append(". Updating ad with cachedVideoFilename = ");
                            stringBuilder2.append(string3);
                            this.a(stringBuilder2.toString());
                            return uri;
                        }
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Unable to create URI from cached video file = ");
                        stringBuilder3.append((Object)file);
                        string2 = stringBuilder3.toString();
                    } else {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Unable to cache video = ");
                        stringBuilder4.append(string);
                        stringBuilder4.append("Video file was missing or null - please make sure your app has the WRITE_EXTERNAL_STORAGE permission!");
                        string2 = stringBuilder4.toString();
                    }
                } else {
                    if (this.b.a(b.by).booleanValue()) {
                        this.d("Failed to cache video");
                        m.a(this.c, this.a.getAdZone(), -202, this.b);
                        this.c = null;
                        return null;
                    }
                    string2 = "Failed to cache video, but not failing ad load";
                }
                this.d(string2);
                return null;
            }
        }
        catch (Exception exception) {
            this.a("Encountered exception while attempting to cache video.", exception);
        }
        return null;
    }

    String a(String string, List<String> list) {
        return this.c(string, list, true);
    }

    String a(String string, List<String> list, g g2) {
        if (!com.applovin.impl.sdk.e.j.b(string)) {
            return string;
        }
        if (!this.b.a(b.bx).booleanValue()) {
            this.a("Resource caching is disabled, skipping cache...");
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        boolean bl = g2.shouldCancelHtmlCachingIfShown();
        for (String string2 : list) {
            int n2 = 0;
            int n3 = 0;
            while (n2 < stringBuilder.length() && (n2 = stringBuilder.indexOf(string2, n3)) != -1) {
                int n4;
                int n5 = stringBuilder.length();
                for (n4 = n2; !this.e.contains((Object)Character.valueOf((char)stringBuilder.charAt(n4))) && n4 < n5; ++n4) {
                }
                if (n4 > n2 && n4 != n5) {
                    String string3 = stringBuilder.substring(n2 + string2.length(), n4);
                    if (com.applovin.impl.sdk.e.j.b(string3)) {
                        if (bl && g2.hasShown()) {
                            this.a("Cancelling HTML caching due to ad being shown already");
                            this.f.a();
                            return string;
                        }
                        String string4 = this.a(string2, string3);
                        if (string4 != null) {
                            stringBuilder.replace(n2, n4, string4);
                            this.f.e();
                        } else {
                            this.f.f();
                        }
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Skip caching of non-resource ");
                        stringBuilder2.append(string3);
                        this.a(stringBuilder2.toString());
                    }
                    n3 = n4;
                    continue;
                }
                this.d("Unable to cache resource; ad HTML is invalid.");
                return string;
            }
        }
        return stringBuilder.toString();
    }

    protected void a(AppLovinAdBase appLovinAdBase) {
        com.applovin.impl.sdk.c.d.a(this.f, appLovinAdBase, this.b);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Uri b(String string, List<String> list, boolean bl) {
        String string2;
        block5 : {
            block4 : {
                try {
                    String string3 = this.d.a(this.d(), string, this.a.H(), list, bl, this.f);
                    if (!com.applovin.impl.sdk.e.j.b(string3)) return null;
                    File file = this.d.a(string3, this.d(), false);
                    if (file != null) {
                        Uri uri = Uri.fromFile((File)file);
                        if (uri != null) {
                            return uri;
                        }
                        break block4;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unable to retrieve File from cached image filename = ");
                    stringBuilder.append(string3);
                    string2 = stringBuilder.toString();
                    break block5;
                }
                catch (MalformedURLException malformedURLException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to cache image at url = ");
                    stringBuilder.append(string);
                    this.a(stringBuilder.toString(), malformedURLException);
                }
                return null;
            }
            string2 = "Unable to extract Uri from image file";
        }
        this.d(string2);
        return null;
    }

    String c(String string, List<String> list, boolean bl) {
        if (com.applovin.impl.sdk.e.j.b(string)) {
            ByteArrayOutputStream byteArrayOutputStream;
            File file;
            Uri uri = Uri.parse((String)string);
            if (uri == null) {
                this.a("Nothing to cache, skipping...");
                return null;
            }
            String string2 = uri.getLastPathSegment();
            if (com.applovin.impl.sdk.e.j.b(this.a.H())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.H());
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            }
            if ((byteArrayOutputStream = (file = this.d.a(string2, this.d(), true)) != null && file.exists() ? this.d.a(file) : null) == null) {
                byteArrayOutputStream = this.d.a(string, list, bl);
                if (byteArrayOutputStream != null) {
                    this.d.a(byteArrayOutputStream, file);
                    this.f.a(byteArrayOutputStream.size());
                }
            } else {
                this.f.b(byteArrayOutputStream.size());
            }
            try {
                String string3 = byteArrayOutputStream.toString("UTF-8");
                return string3;
            }
            catch (Throwable throwable) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("String resource at ");
                stringBuilder.append(string);
                stringBuilder.append(" failed to load.");
                this.a(stringBuilder.toString(), throwable);
                return null;
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                this.a("UTF-8 encoding not supported.", unsupportedEncodingException);
            }
        }
        return null;
    }

    Uri e(String string) {
        return this.a(string, (List<String>)this.a.G(), true);
    }

    Uri f(String string) {
        return this.b(string, (List<String>)this.a.G(), true);
    }

    void f() {
        Uri uri;
        this.a("Caching mute images...");
        Uri uri2 = this.a(this.a.av(), "mute");
        if (uri2 != null) {
            this.a.b(uri2);
        }
        if ((uri = this.a(this.a.aw(), "unmute")) != null) {
            this.a.c(uri);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ad updated with muteImageFilename = ");
        stringBuilder.append((Object)this.a.av());
        stringBuilder.append(", unmuteImageFilename = ");
        stringBuilder.append((Object)this.a.aw());
        this.a(stringBuilder.toString());
    }

    String g(final String string) {
        if (!com.applovin.impl.sdk.e.j.b(string)) {
            return null;
        }
        com.applovin.impl.sdk.network.b<String> b2 = com.applovin.impl.sdk.network.b.a(this.b).a(string).b("GET").a("").a((String)false).a();
        final AtomicReference atomicReference = new AtomicReference(null);
        this.b.B().a(b2, new a.a(), new a.b<String>(){

            @Override
            public void a(int n2) {
                c c2 = c.this;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to load resource from '");
                stringBuilder.append(string);
                stringBuilder.append("'");
                c2.d(stringBuilder.toString());
            }

            @Override
            public void a(String string2, int n2) {
                atomicReference.set((Object)string2);
            }
        });
        String string2 = (String)atomicReference.get();
        if (string2 != null) {
            this.f.a(string2.length());
        }
        return string2;
    }

    void g() {
        if (this.c != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Rendered new ad:");
            stringBuilder.append((Object)this.a);
            this.a(stringBuilder.toString());
            this.c.adReceived((AppLovinAd)this.a);
            this.c = null;
        }
    }

}

