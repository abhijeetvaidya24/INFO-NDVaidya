/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.a.a
 *  com.adincube.sdk.a.b
 *  com.adincube.sdk.a.b.a
 *  com.adincube.sdk.a.b.b$3
 *  com.adincube.sdk.a.b.c
 *  com.adincube.sdk.a.c
 *  com.adincube.sdk.g.b.h
 *  com.adincube.sdk.h.f.d
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.adincube.sdk.a.b;

import com.adincube.sdk.a.a;
import com.adincube.sdk.a.b.b;
import com.adincube.sdk.a.b.c;
import com.adincube.sdk.g.b.h;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.i;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.ogury.consent.manager.ConsentListener;
import com.ogury.consent.manager.ConsentManager;
import com.ogury.consent.manager.util.consent.ConsentException;

public final class b
implements a {
    boolean a = false;
    boolean b = false;
    public com.adincube.sdk.a.c c = null;
    public c d = null;
    public c e = null;
    public final ConsentListener f = new ConsentListener(){

        @Override
        public final void onComplete(ConsentManager.Answer answer) {
            try {
                b.this.a = true;
                b.this.b = false;
                if (b.this.c != null) {
                    b.this.c.a((a)b.this);
                }
                if (b.this.d != null) {
                    b.this.d.a(b.a(answer));
                }
                return;
            }
            catch (Throwable throwable) {
                com.adincube.sdk.util.a.c("OguryConsentManagerProviderAdapter#askConsentListener.onComplete", new Object[]{throwable});
                ErrorReportingHelper.report("OguryConsentManagerProviderAdapter#askConsentListener.onComplete", throwable);
                return;
            }
        }

        @Override
        public final void onError(ConsentException consentException) {
            b b2 = b.this;
            b2.a = true;
            b2.b = true;
            if (b2.d != null) {
                com.adincube.sdk.a.b b3 = new com.adincube.sdk.a.b((a)b.this, consentException.getType());
                b.this.d.a(b3);
            }
        }
    };
    public final ConsentListener g = new ConsentListener(){

        @Override
        public final void onComplete(ConsentManager.Answer answer) {
            try {
                b.this.a = true;
                b.this.b = false;
                if (b.this.c != null) {
                    b.this.c.a((a)b.this);
                }
                if (b.this.e != null) {
                    b.this.e.a(b.a(answer));
                }
                return;
            }
            catch (Throwable throwable) {
                com.adincube.sdk.util.a.c("OguryConsentManagerProviderAdapter#editConsentListener.onComplete", new Object[]{throwable});
                ErrorReportingHelper.report("OguryConsentManagerProviderAdapter#editConsentListener.onComplete", throwable);
                return;
            }
        }

        @Override
        public final void onError(ConsentException consentException) {
            b b2 = b.this;
            b2.a = true;
            b2.b = true;
            if (b2.e != null) {
                com.adincube.sdk.a.b b3 = new com.adincube.sdk.a.b((a)b.this, consentException.getType());
                b.this.e.a(b3);
            }
        }
    };
    private h h = null;

    static /* synthetic */ com.adincube.sdk.a.b.a a(ConsentManager.Answer answer) {
        int n2 = 3.b[answer.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 == 4) {
                        return com.adincube.sdk.a.b.a.d;
                    }
                    StringBuilder stringBuilder = new StringBuilder("Unknown answer ");
                    stringBuilder.append(answer.name());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                return com.adincube.sdk.a.b.a.c;
            }
            return com.adincube.sdk.a.b.a.b;
        }
        return com.adincube.sdk.a.b.a.a;
    }

    public final d a(String string) {
        com.adincube.sdk.mediation.aa.c c2;
        i i2 = this.h.a(string);
        String string2 = i2 == null ? null : ((c2 = i2.g()) == null ? null : c2.b());
        if (string2 == null) {
            return d.a;
        }
        if (this.b) {
            return d.a;
        }
        if (!this.a) {
            return d.b;
        }
        if (ConsentManager.isAccepted(string2)) {
            return d.c;
        }
        return d.d;
    }

    public final String a() {
        return "Ogury Consent Manager";
    }

    public final void a(com.adincube.sdk.a.c c2) {
        this.c = c2;
    }

    public final void b() {
        this.h = h.a();
    }

    public final boolean c() {
        return this.h != null;
    }

    public final String d() {
        if (this.b) {
            return null;
        }
        return ConsentManager.getIabString();
    }

}

