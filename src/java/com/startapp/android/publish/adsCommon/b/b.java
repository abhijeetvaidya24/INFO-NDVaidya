/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package com.startapp.android.publish.adsCommon.b;

import android.content.Context;
import com.startapp.android.publish.adsCommon.b.a;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.f.f;
import com.startapp.common.a.g;
import com.startapp.common.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class b {
    private List<a> a;
    private Context b;
    private List<String> c = new ArrayList();

    public b(Context context, List<a> list) {
        this.a = list;
        this.b = context;
    }

    private String a(String string) {
        return string.split("tracking/adImpression[?]d=")[1];
    }

    private void a(List<a> list, List<String> list2) {
        g.a(3, "in getAppPresenceDParameter()");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a a2 : list) {
            if (a2.c()) continue;
            String string = this.a(a2.a());
            if (a2.d()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("d=");
                stringBuilder.append(string);
                arrayList.add((Object)stringBuilder.toString());
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("d=");
            stringBuilder.append(string);
            arrayList2.add((Object)stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("appPresence tracking size = ");
        stringBuilder.append(arrayList.size());
        stringBuilder.append(" normal size = ");
        stringBuilder.append(arrayList2.size());
        g.a(3, stringBuilder.toString());
        if (!arrayList.isEmpty()) {
            list2.addAll(c.a((List<String>)arrayList, "false", "true"));
        }
        if (!arrayList2.isEmpty()) {
            list2.addAll(c.a((List<String>)arrayList2, "false", "false"));
        }
    }

    private void c() {
        this.a(this.a, this.c);
        for (int j = 0; j < this.c.size(); ++j) {
            String string = (String)this.c.get(j);
            if (string.length() == 0) continue;
            c.a(this.b, string, new com.startapp.android.publish.adsCommon.d.b().setNonImpressionReason("APP_PRESENCE"));
        }
    }

    public void a() {
        com.startapp.common.g.a(g.a.a, new Runnable(){

            public void run() {
                b.this.b();
            }
        });
    }

    protected Boolean b() {
        boolean bl;
        g.a(3, "in doInBackground handler");
        try {
            this.c();
            bl = true;
        }
        catch (Exception exception) {
            f.a(this.b, d.b, "AppPresenceHandler.doInBackground - sendAdImpressions failed", exception.getMessage(), "");
            bl = false;
        }
        return bl;
    }

}

