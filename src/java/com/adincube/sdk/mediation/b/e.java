/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.adcolony.sdk.AdColony
 *  com.adcolony.sdk.AdColonyAppOptions
 *  com.adcolony.sdk.AdColonyUserMetadata
 *  com.adincube.sdk.h.b
 *  com.adincube.sdk.h.c
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.f.d
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.b.c
 *  com.adincube.sdk.mediation.n.a
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.List
 *  org.json.JSONObject
 */
package com.adincube.sdk.mediation.b;

import android.app.Activity;
import android.content.Context;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyUserMetadata;
import com.adincube.sdk.h.b;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.b.c;
import com.adincube.sdk.mediation.b.e;
import com.adincube.sdk.mediation.b.f;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.mediation.i.a;
import java.util.List;
import org.json.JSONObject;

public final class e
implements i {
    f a = null;
    g b = null;
    com.adincube.sdk.mediation.aa.b c = new com.adincube.sdk.mediation.aa.b("adcolony-inc");
    String d = null;
    List<String> e = null;
    d f = null;
    private com.adincube.sdk.mediation.c g = null;

    public e() {
        AdColony.class.getSimpleName();
    }

    @Override
    public final a a(Context context, com.adincube.sdk.h.c.c c2, boolean bl) {
        return null;
    }

    @Override
    public final com.adincube.sdk.mediation.n.a a(Activity activity) {
        c c2 = new c(this);
        c2.a = activity;
        return c2;
    }

    @Override
    public final void a(Context context) {
        com.adincube.sdk.mediation.c c2 = this.g;
        if (c2 != null) {
            c2.a();
        }
    }

    @Override
    public final void a(Context context, JSONObject jSONObject) {
        this.a = new f(jSONObject);
        this.g = new com.adincube.sdk.mediation.c(new Runnable(this, context){
            final /* synthetic */ Context a;
            final /* synthetic */ e b;
            {
                this.b = e2;
                this.a = context;
            }

            /*
             * Enabled aggressive block sorting
             */
            public final void run() {
                d d2;
                AdColonyAppOptions adColonyAppOptions;
                block5 : {
                    AdColonyAppOptions adColonyAppOptions2;
                    String string;
                    block7 : {
                        block6 : {
                            block4 : {
                                adColonyAppOptions = new AdColonyAppOptions();
                                d2 = this.b.c.a;
                                if (d2 != d.e) break block4;
                                adColonyAppOptions.setGDPRRequired(false);
                                break block5;
                            }
                            if (d2 != d.c) break block6;
                            adColonyAppOptions2 = adColonyAppOptions.setGDPRRequired(true);
                            string = "1";
                            break block7;
                        }
                        if (d2 != d.d) break block5;
                        adColonyAppOptions2 = adColonyAppOptions.setGDPRRequired(true);
                        string = "0";
                    }
                    adColonyAppOptions2.setGDPRConsentString(string);
                }
                if (!(com.adincube.sdk.util.r.a(this.b.a.k, this.b.d) && com.adincube.sdk.util.r.a(this.b.a.l, this.b.e) && com.adincube.sdk.util.r.a((Object)d2, (Object)this.b.f))) {
                    Activity activity = (Activity)this.a;
                    String string = this.b.a.k;
                    f f2 = this.b.a;
                    AdColony.configure((Activity)activity, (AdColonyAppOptions)adColonyAppOptions, (String)string, (String[])((String[])f2.l.toArray((Object[])new String[f2.l.size()])));
                }
                e e2 = this.b;
                e2.d = e2.a.k;
                e e3 = this.b;
                e3.e = e3.a.l;
                this.b.f = d2;
            }
        });
    }

    @Override
    public final void a(g g2) {
        AdColonyUserMetadata adColonyUserMetadata;
        block4 : {
            String string;
            block6 : {
                block5 : {
                    block1 : {
                        String string2;
                        block3 : {
                            block2 : {
                                this.b = g2;
                                adColonyUserMetadata = new AdColonyUserMetadata();
                                if (g2.a == null) break block1;
                                int n2 = 2.a[g2.a.ordinal()];
                                if (n2 == 1) break block2;
                                if (n2 != 2) break block1;
                                string2 = "female";
                                break block3;
                            }
                            string2 = "male";
                        }
                        adColonyUserMetadata.setUserGender(string2);
                    }
                    if (g2.b == null) break block4;
                    int n3 = 2.b[g2.b.ordinal()];
                    if (n3 == 1) break block5;
                    if (n3 != 2) break block4;
                    string = "married";
                    break block6;
                }
                string = "single";
            }
            adColonyUserMetadata.setUserMaritalStatus(string);
        }
        if (g2.d != null) {
            adColonyUserMetadata.setUserAge(g2.d.intValue());
        }
        AdColony.getAppOptions().setUserMetadata(adColonyUserMetadata);
    }

    @Override
    public final boolean a() {
        return this.a != null;
    }

    @Override
    public final com.adincube.sdk.mediation.c b() {
        return this.g;
    }

    @Override
    public final String b(Context context) {
        return "3.2.1";
    }

    @Override
    public final com.adincube.sdk.mediation.e c() {
        return this.a;
    }

    @Override
    public final boolean d() {
        return false;
    }

    @Override
    public final boolean e() {
        return true;
    }

    @Override
    public final String f() {
        return "AdColony";
    }

    @Override
    public final com.adincube.sdk.mediation.aa.c g() {
        return this.c;
    }
}

