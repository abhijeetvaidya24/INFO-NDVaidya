/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.startapp.android.publish.ads.video.c.b;

import android.text.TextUtils;
import com.startapp.android.publish.ads.video.c.a.a.b;
import com.startapp.android.publish.ads.video.c.a.c;
import com.startapp.android.publish.ads.video.c.a.e;
import com.startapp.common.a.g;
import java.util.List;

public class a {
    public static b a(e e2, c c2) {
        g.a("VASTModelPostValidator", 3, "validate");
        boolean bl = a.a(e2);
        b b2 = null;
        if (!bl) {
            g.a("VASTModelPostValidator", 3, "Validator returns: not valid (invalid model)");
            return null;
        }
        if (c2 != null) {
            b b3 = c2.a(e2.b());
            b2 = null;
            if (b3 != null) {
                String string = b3.a();
                boolean bl2 = TextUtils.isEmpty((CharSequence)string);
                b2 = null;
                if (!bl2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("mediaPicker selected mediaFile with URL ");
                    stringBuilder.append(string);
                    g.a("VASTModelPostValidator", 3, stringBuilder.toString());
                    b2 = b3;
                }
            }
        } else {
            g.a("VASTModelPostValidator", 5, "mediaPicker: We don't have a compatible media file to play.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Validator returns: ");
        String string = b2 != null ? "valid" : "not valid (no media file)";
        stringBuilder.append(string);
        g.a("VASTModelPostValidator", 3, stringBuilder.toString());
        return b2;
    }

    public static boolean a(e e2) {
        g.a("VASTModelPostValidator", 3, "validateModel");
        List<String> list = e2.d();
        boolean bl = list != null && list.size() != 0;
        List<b> list2 = e2.b();
        if (list2 == null || list2.size() == 0) {
            g.a("VASTModelPostValidator", 3, "Validator error: mediaFile list invalid");
            bl = false;
        }
        return bl;
    }
}

