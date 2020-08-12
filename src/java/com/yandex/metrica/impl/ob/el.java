/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Principal
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.ff;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class el
extends CertificateException {
    public el(ff ff2) {
        StringBuilder stringBuilder = new StringBuilder("There is not pinned certificates among chain ");
        stringBuilder.append(el.a(ff2.a()));
        super(stringBuilder.toString());
    }

    private static String a(X509Certificate[] arrx509Certificate) {
        StringBuilder stringBuilder = new StringBuilder();
        for (X509Certificate x509Certificate : arrx509Certificate) {
            StringBuilder stringBuilder2 = new StringBuilder("ISSUER=");
            stringBuilder2.append(x509Certificate.getIssuerDN().toString());
            stringBuilder2.append("\n");
            stringBuilder.append(stringBuilder2.toString());
        }
        return stringBuilder.toString();
    }
}

