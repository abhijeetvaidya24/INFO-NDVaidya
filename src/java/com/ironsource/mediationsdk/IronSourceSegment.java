/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Pair
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.Vector
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class IronSourceSegment {
    private int mAge;
    private Vector<Pair<String, String>> mCustoms;
    private String mGender;
    private double mIapt;
    private AtomicBoolean mIsPaying;
    private int mLevel;
    private String mSegmentName;
    private long mUcd;

    public int getAge() {
        return this.mAge;
    }

    public String getGender() {
        return this.mGender;
    }

    public double getIapt() {
        return this.mIapt;
    }

    public AtomicBoolean getIsPaying() {
        return this.mIsPaying;
    }

    public int getLevel() {
        return this.mLevel;
    }

    Vector<Pair<String, String>> getSegmentData() {
        Vector vector = new Vector();
        if (this.mAge != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mAge);
            stringBuilder.append("");
            vector.add((Object)new Pair((Object)"age", (Object)stringBuilder.toString()));
        }
        if (!TextUtils.isEmpty((CharSequence)this.mGender)) {
            vector.add((Object)new Pair((Object)"gen", (Object)this.mGender));
        }
        if (this.mLevel != -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mLevel);
            stringBuilder.append("");
            vector.add((Object)new Pair((Object)"lvl", (Object)stringBuilder.toString()));
        }
        if (this.mIsPaying != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)this.mIsPaying);
            stringBuilder.append("");
            vector.add((Object)new Pair((Object)"pay", (Object)stringBuilder.toString()));
        }
        if (this.mIapt != -1.0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mIapt);
            stringBuilder.append("");
            vector.add((Object)new Pair((Object)"iapt", (Object)stringBuilder.toString()));
        }
        if (this.mUcd != 0L) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mUcd);
            stringBuilder.append("");
            vector.add((Object)new Pair((Object)"ucd", (Object)stringBuilder.toString()));
        }
        if (!TextUtils.isEmpty((CharSequence)this.mSegmentName)) {
            vector.add((Object)new Pair((Object)"segName", (Object)this.mSegmentName));
        }
        vector.addAll(this.mCustoms);
        return vector;
    }

    public long getUcd() {
        return this.mUcd;
    }
}

