/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.util.Arrays
 *  java.util.List
 */
package com.startapp.android.publish.omsdk;

import com.startapp.android.publish.omsdk.VerificationDetails;
import com.startapp.common.c.f;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class AdVerification
implements Serializable {
    private static final long serialVersionUID = 1L;
    @f(b="Lcom/startapp/android/publish/omsdk/VerificationDetails;", f="adVerifications")
    private VerificationDetails[] adVerification;

    public AdVerification() {
    }

    public AdVerification(VerificationDetails[] arrverificationDetails) {
        this.adVerification = arrverificationDetails;
    }

    public List<VerificationDetails> getAdVerification() {
        Object[] arrobject = this.adVerification;
        if (arrobject == null) {
            return null;
        }
        return Arrays.asList((Object[])arrobject);
    }
}

