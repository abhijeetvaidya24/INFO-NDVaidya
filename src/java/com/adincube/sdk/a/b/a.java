/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.String
 */
package com.adincube.sdk.a.b;

import com.adincube.sdk.AdinCube;

public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a(AdinCube.UserConsent.Answer.FULL_APPROVAL);
    public static final /* enum */ a b = new a(AdinCube.UserConsent.Answer.PARTIAL_APPROVAL);
    public static final /* enum */ a c = new a(AdinCube.UserConsent.Answer.REFUSAL);
    public static final /* enum */ a d = new a(AdinCube.UserConsent.Answer.NO_ANSWER);
    private static final /* synthetic */ a[] f;
    public final AdinCube.UserConsent.Answer e;

    static {
        a[] arra = new a[]{a, b, c, d};
        f = arra;
    }

    private a(AdinCube.UserConsent.Answer answer) {
        this.e = answer;
    }
}

