/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  java.lang.String
 */
package com.appnext.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.appnext.core.o;

public final class b
extends o {
    String am;
    String an;
    String ao;
    String ap;
    String aq;
    String ar;
    String as;
    ResultReceiver at;
    String guid;

    public b() {
    }

    public b(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, ResultReceiver resultReceiver) {
        this.am = string;
        this.an = string2;
        this.guid = string3;
        this.ao = string4;
        this.ap = string5;
        this.at = resultReceiver;
        this.aq = string6;
        this.ar = string7;
        this.as = string8;
    }

    @Override
    public final void a(Context context) {
        super.a(context);
        this.at = null;
    }

    @Override
    protected final void a(Intent intent) {
        intent.putExtra("added_info", 8348);
        intent.putExtra("package", this.am);
        intent.putExtra("link", this.an);
        intent.putExtra("guid", this.guid);
        intent.putExtra("bannerid", this.ao);
        intent.putExtra("placementid", this.ap);
        intent.putExtra("receiver", (Parcelable)this.at);
        intent.putExtra("vid", this.aq);
        intent.putExtra("tid", this.ar);
        intent.putExtra("auid", this.as);
    }

    public final void a(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, ResultReceiver resultReceiver) {
        this.am = string;
        this.an = string2;
        this.guid = string3;
        this.ao = string4;
        this.ap = string5;
        this.at = resultReceiver;
        this.aq = string6;
        this.ar = string7;
        this.as = string8;
    }
}

