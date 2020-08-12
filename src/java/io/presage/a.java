/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  io.presage.FourmedAmbert
 *  io.presage.e
 *  io.presage.g
 *  io.presage.h
 *  io.presage.i
 *  io.presage.j
 *  io.presage.l
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package io.presage;

import android.content.Context;
import android.webkit.WebView;
import io.presage.BrillatSavarin;
import io.presage.FourmedAmbert;
import io.presage.FourmedAmbertBio;
import io.presage.Murol;
import io.presage.StRomans;
import io.presage.VieuxLille;
import io.presage.b;
import io.presage.c;
import io.presage.cl;
import io.presage.e;
import io.presage.g;
import io.presage.h;
import io.presage.i;
import io.presage.j;
import io.presage.l;
import java.util.List;

public final class a {
    public static final CamembertauCalvados a = new CamembertauCalvados(0);
    private final Context b;
    private long c;
    private final i d;
    private final VieuxLille e;

    public a(Context context, VieuxLille vieuxLille) {
        this.e = vieuxLille;
        this.b = context.getApplicationContext();
        this.c = 80000L;
        this.d = new i();
    }

    private final void a(BrillatSavarin brillatSavarin) {
        j j2 = this.b(brillatSavarin);
        if (j2 == null) {
            return;
        }
        StRomans.a((WebView)j2);
        this.d.a((h)new g(j2, brillatSavarin));
    }

    private static void a(c c2) {
        VieuxLille.a(c2);
    }

    private final j b(BrillatSavarin brillatSavarin) {
        Context context = this.b;
        cl.a((Object)context, "context");
        j j2 = l.a((Context)context, (BrillatSavarin)brillatSavarin);
        if (j2 != null) {
            Murol.a((WebView)j2);
        }
        return j2;
    }

    public final void a(c c2, List<BrillatSavarin> list, b b2) {
        this.d.a(b2);
        this.d.a();
        a.a(c2);
        Context context = this.b;
        cl.a((Object)context, "context");
        FourmedAmbert fourmedAmbert = FourmedAmbertBio.a(context);
        if (fourmedAmbert != null) {
            this.c = fourmedAmbert.j();
        }
        for (BrillatSavarin brillatSavarin : list) {
            Context context2 = this.b;
            cl.a((Object)context2, "context");
            j j2 = l.a((Context)context2, (BrillatSavarin)brillatSavarin);
            if (j2 != null) {
                Murol.a((WebView)j2);
                this.d.a((h)new e(j2, brillatSavarin, this.e, c2));
                boolean bl2 = ((CharSequence)brillatSavarin.o()).length() > 0;
                if (!bl2) continue;
                this.a(brillatSavarin);
                continue;
            }
            b2.b();
            return;
        }
        this.d.a(this.c, list.size());
    }

    public static final class CamembertauCalvados {
        private CamembertauCalvados() {
        }

        public /* synthetic */ CamembertauCalvados(byte by) {
            this();
        }

        public static a a(Context context) {
            return new a(context, VieuxLille.a);
        }
    }

}

