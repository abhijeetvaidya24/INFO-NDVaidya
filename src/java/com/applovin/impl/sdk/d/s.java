/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.d.s$b
 *  com.applovin.impl.sdk.d.s$c
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.d;

import com.applovin.impl.a.d;
import com.applovin.impl.a.i;
import com.applovin.impl.sdk.d.q;
import com.applovin.impl.sdk.d.s;
import com.applovin.impl.sdk.d.v;
import com.applovin.impl.sdk.d.y;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.List;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
abstract class s
extends com.applovin.impl.sdk.d.a {
    private final AppLovinAdLoadListener a;
    private final a c;

    s(com.applovin.impl.a.c c2, AppLovinAdLoadListener appLovinAdLoadListener, j j2) {
        super("TaskProcessVastResponse", j2);
        if (c2 != null) {
            this.a = appLovinAdLoadListener;
            this.c = (a)c2;
            return;
        }
        throw new IllegalArgumentException("No context specified.");
    }

    public static s a(n n2, com.applovin.impl.a.c c2, AppLovinAdLoadListener appLovinAdLoadListener, j j2) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static s a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b b2, AppLovinAdLoadListener appLovinAdLoadListener, j j2) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    void a(d d2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to process VAST response due to VAST error code ");
        stringBuilder.append((Object)d2);
        this.d(stringBuilder.toString());
        i.a(this.c, this.a, d2, -6, this.b);
    }

    void a(n n2) {
        d d2;
        block5 : {
            block6 : {
                com.applovin.impl.sdk.d.a a2;
                block4 : {
                    block2 : {
                        int n3;
                        block3 : {
                            int n4 = this.c.a();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Finished parsing XML at depth ");
                            stringBuilder.append(n4);
                            this.a(stringBuilder.toString());
                            this.c.a(n2);
                            if (!i.a(n2)) break block2;
                            n3 = this.b.a(com.applovin.impl.sdk.b.b.eO);
                            if (n4 >= n3) break block3;
                            this.a("VAST response is wrapper. Resolving...");
                            a2 = new y(this.c, this.a, this.b);
                            break block4;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Reached beyond max wrapper depth of ");
                        stringBuilder.append(n3);
                        this.d(stringBuilder.toString());
                        d2 = d.e;
                        break block5;
                    }
                    if (!i.b(n2)) break block6;
                    this.a("VAST response is inline. Rendering ad...");
                    a2 = new v(this.c, this.a, this.b);
                }
                this.b.C().a(a2);
                return;
            }
            this.d("VAST response is an error");
            d2 = d.f;
        }
        this.a(d2);
    }

    private static final class a
    extends com.applovin.impl.a.c {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b b2, j j2) {
            super(jSONObject, jSONObject2, b2, j2);
        }

        void a(n n2) {
            if (n2 != null) {
                this.a.add((Object)n2);
                return;
            }
            throw new IllegalArgumentException("No aggregated vast response specified");
        }
    }

}

