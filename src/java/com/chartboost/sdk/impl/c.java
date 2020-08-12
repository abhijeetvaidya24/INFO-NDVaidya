/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.i;

public class c {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final boolean g;
    public final boolean h;

    private c(int n2, String string, String string2, String string3, String string4, String string5, boolean bl, boolean bl2) {
        this.a = n2;
        this.b = string;
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = string5;
        this.g = bl;
        this.h = bl2;
    }

    public static c a() {
        c c2 = new c(0, "interstitial", "interstitial", "/interstitial/get", "webview/%s/interstitial/get", "/interstitial/show", false, false);
        return c2;
    }

    public static c b() {
        c c2 = new c(1, "rewarded", "rewarded-video", "/reward/get", "webview/%s/reward/get", "/reward/show", true, false);
        return c2;
    }

    public static c c() {
        c c2 = new c(2, "inplay", null, "/inplay/get", "no webview endpoint", "/inplay/show", false, true);
        return c2;
    }

    public String a(int n2) {
        Object[] arrobject = new Object[2];
        arrobject[0] = this.c;
        String string = n2 == 1 ? "web" : "native";
        arrobject[1] = string;
        return String.format((String)"%s-%s", (Object[])arrobject);
    }

    public void a(String string) {
        if (i.c != null) {
            int n2 = this.a;
            if (n2 != 0) {
                if (n2 != 1) {
                    return;
                }
                i.c.didClickRewardedVideo(string);
                return;
            }
            i.c.didClickInterstitial(string);
        }
    }

    public void a(String string, CBError.CBImpressionError cBImpressionError) {
        if (i.c != null) {
            int n2 = this.a;
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return;
                    }
                    i.c.didFailToLoadInPlay(string, cBImpressionError);
                    return;
                }
                i.c.didFailToLoadRewardedVideo(string, cBImpressionError);
                return;
            }
            i.c.didFailToLoadInterstitial(string, cBImpressionError);
        }
    }

    public void b(String string) {
        if (i.c != null) {
            int n2 = this.a;
            if (n2 != 0) {
                if (n2 != 1) {
                    return;
                }
                i.c.didCloseRewardedVideo(string);
                return;
            }
            i.c.didCloseInterstitial(string);
        }
    }

    public void c(String string) {
        if (i.c != null) {
            int n2 = this.a;
            if (n2 != 0) {
                if (n2 != 1) {
                    return;
                }
                i.c.didDismissRewardedVideo(string);
                return;
            }
            i.c.didDismissInterstitial(string);
        }
    }

    public void d(String string) {
        if (i.c != null) {
            int n2 = this.a;
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        return;
                    }
                    i.c.didCacheInPlay(string);
                    return;
                }
                i.c.didCacheRewardedVideo(string);
                return;
            }
            i.c.didCacheInterstitial(string);
        }
    }

    public void e(String string) {
        if (i.c != null) {
            int n2 = this.a;
            if (n2 != 0) {
                if (n2 != 1) {
                    return;
                }
                i.c.didDisplayRewardedVideo(string);
                return;
            }
            i.c.didDisplayInterstitial(string);
        }
    }

    public boolean f(String string) {
        com.chartboost.sdk.a a2 = i.c;
        int n2 = 1;
        if (a2 != null) {
            int n3 = this.a;
            if (n3) {
                if (n3 != n2) {
                    return (boolean)n2;
                }
                return i.c.shouldDisplayRewardedVideo(string);
            }
            n2 = i.c.shouldDisplayInterstitial(string) ? 1 : 0;
        }
        return (boolean)n2;
    }

    public boolean g(String string) {
        com.chartboost.sdk.a a2 = i.c;
        boolean bl = true;
        if (a2 != null) {
            if (this.a != 0) {
                return bl;
            }
            bl = i.c.shouldRequestInterstitial(string);
        }
        return bl;
    }

    public class a
    implements Runnable {
        private final int b;
        private final String c;
        private final CBError.CBImpressionError d;

        public a(int n2, String string, CBError.CBImpressionError cBImpressionError) {
            this.b = n2;
            this.c = string;
            this.d = cBImpressionError;
        }

        public void run() {
            int n2 = this.b;
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 4) {
                                if (n2 != 5) {
                                    return;
                                }
                                c.this.e(this.c);
                                return;
                            }
                            c.this.a(this.c, this.d);
                            return;
                        }
                        c.this.c(this.c);
                        return;
                    }
                    c.this.b(this.c);
                    return;
                }
                c.this.a(this.c);
                return;
            }
            c.this.d(this.c);
        }
    }

}

