/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

@SuppressLint(value={"UseSparseArrays"})
class ac {
    final String a;
    private final int b;
    private HashMap<Integer, MediaPlayer> c;
    private HashMap<Integer, a> d;
    private HashMap<Integer, Boolean> e;
    private HashMap<Integer, Boolean> f;
    private ArrayList<MediaPlayer> g;

    ac(String string, int n2) {
        this.a = string;
        this.b = n2;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new ArrayList();
    }

    void a() {
        this.g.clear();
        for (MediaPlayer mediaPlayer : this.c.values()) {
            if (!mediaPlayer.isPlaying()) continue;
            mediaPlayer.pause();
            this.g.add((Object)mediaPlayer);
        }
    }

    /*
     * Exception decompiling
     */
    void a(ad var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl89 : ALOAD_2 : trying to set 1 previously set to 0
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

    void b() {
        Iterator iterator = this.g.iterator();
        while (iterator.hasNext()) {
            ((MediaPlayer)iterator.next()).start();
        }
        this.g.clear();
    }

    void b(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        if (((Boolean)this.f.get((Object)n2)).booleanValue()) {
            ((MediaPlayer)this.c.get((Object)n2)).pause();
        }
    }

    HashMap<Integer, MediaPlayer> c() {
        return this.c;
    }

    void c(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        if (((Boolean)this.e.get((Object)n2)).booleanValue()) {
            ((MediaPlayer)this.c.get((Object)n2)).start();
            this.f.put((Object)n2, (Object)true);
        }
    }

    void d(ad ad2) {
        ((MediaPlayer)this.c.remove((Object)w.c(ad2.c(), "id"))).release();
    }

    void e(ad ad2) {
        int n2 = w.c(ad2.c(), "id");
        if (((Boolean)this.f.get((Object)n2)).booleanValue()) {
            MediaPlayer mediaPlayer = (MediaPlayer)this.c.get((Object)n2);
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
    }

    private class a
    implements MediaPlayer.OnErrorListener,
    MediaPlayer.OnPreparedListener {
        int a;
        boolean b;

        a(int n2, boolean bl) {
            this.a = n2;
            this.b = bl;
        }

        public boolean onError(MediaPlayer mediaPlayer, int n2, int n3) {
            JSONObject jSONObject = w.a();
            w.b(jSONObject, "id", this.a);
            w.a(jSONObject, "ad_session_id", ac.this.a);
            new ad("AudioPlayer.on_error", ac.this.b, jSONObject).b();
            return true;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setLooping(this.b);
            ac.this.e.put((Object)this.a, (Object)true);
            JSONObject jSONObject = w.a();
            w.b(jSONObject, "id", this.a);
            w.a(jSONObject, "ad_session_id", ac.this.a);
            new ad("AudioPlayer.on_ready", ac.this.b, jSONObject).b();
        }
    }

}

