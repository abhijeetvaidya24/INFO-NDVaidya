/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.KeyStore
 *  java.security.KeyStoreException
 *  java.security.NoSuchAlgorithmException
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Iterator
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 */
package com.yandex.metrica.impl.ob;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class fc {
    private Collection<X509TrustManager> a = new ArrayList();

    public fc() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(null);
        for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
            if (!(trustManager instanceof X509TrustManager)) continue;
            this.a.add((Object)((X509TrustManager)trustManager));
        }
    }

    public boolean a(X509Certificate[] arrx509Certificate) {
        try {
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                ((X509TrustManager)iterator.next()).checkServerTrusted(arrx509Certificate, "RSA");
            }
            return true;
        }
        catch (CertificateException certificateException) {
            return false;
        }
    }

    public X509Certificate[] a() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            arrayList.addAll((Collection)Arrays.asList((Object[])((X509TrustManager)iterator.next()).getAcceptedIssuers()));
        }
        return (X509Certificate[])arrayList.toArray((Object[])new X509Certificate[arrayList.size()]);
    }
}

