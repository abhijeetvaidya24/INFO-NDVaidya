/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.KeyManagementException
 *  java.security.NoSuchAlgorithmException
 *  java.security.SecureRandom
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.TrustManager
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.fk;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class ez {
    private fk a;

    public ez(fk fk2) {
        this.a = fk2;
    }

    public SSLContext a() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        TrustManager[] arrtrustManager = new TrustManager[]{this.a};
        sSLContext.init(null, arrtrustManager, null);
        return sSLContext;
    }
}

