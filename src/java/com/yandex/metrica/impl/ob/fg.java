/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Base64
 *  com.yandex.metrica.impl.ob.fl
 *  com.yandex.metrica.impl.ob.fn
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.GeneralSecurityException
 *  java.security.KeyStore
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PublicKey
 *  java.security.SecureRandom
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.List
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  org.apache.http.client.HttpClient
 *  org.apache.http.conn.ClientConnectionManager
 *  org.apache.http.conn.scheme.PlainSocketFactory
 *  org.apache.http.conn.scheme.Scheme
 *  org.apache.http.conn.scheme.SchemeRegistry
 *  org.apache.http.conn.scheme.SocketFactory
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager
 *  org.apache.http.params.BasicHttpParams
 *  org.apache.http.params.HttpParams
 */
package com.yandex.metrica.impl.ob;

import android.os.Build;
import android.util.Base64;
import com.yandex.metrica.impl.ob.ex;
import com.yandex.metrica.impl.ob.fd;
import com.yandex.metrica.impl.ob.fl;
import com.yandex.metrica.impl.ob.fm;
import com.yandex.metrica.impl.ob.fn;
import com.yandex.metrica.impl.ob.fq;
import com.yandex.metrica.impl.ob.fs;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

class fg {
    static fs a(List<X509Certificate> list) throws GeneralSecurityException, IOException {
        TrustManager[] arrtrustManager;
        fn fn2;
        if (list != null && !list.isEmpty()) {
            KeyStore keyStore = KeyStore.getInstance((String)KeyStore.getDefaultType());
            keyStore.load(null, null);
            for (int i2 = 0; i2 < list.size(); ++i2) {
                StringBuilder stringBuilder = new StringBuilder("ca");
                stringBuilder.append(i2);
                keyStore.setCertificateEntry(stringBuilder.toString(), (Certificate)list.get(i2));
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            arrtrustManager = trustManagerFactory.getTrustManagers();
        } else {
            arrtrustManager = null;
        }
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        sSLContext.init(null, arrtrustManager, null);
        if (Build.VERSION.SDK_INT >= 9) {
            fn2 = new fn(sSLContext.getSocketFactory());
        } else {
            ex.a a2 = new ex.a(sSLContext);
            PlainSocketFactory plainSocketFactory = PlainSocketFactory.getSocketFactory();
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", (SocketFactory)plainSocketFactory, 80));
            schemeRegistry.register(new Scheme("https", (SocketFactory)a2, 443));
            fn2 = new fl((HttpClient)new DefaultHttpClient((ClientConnectionManager)new ThreadSafeClientConnManager((HttpParams)basicHttpParams, schemeRegistry), (HttpParams)basicHttpParams));
        }
        return new fs(new fq((fm)fn2));
    }

    static String a(X509Certificate x509Certificate) {
        try {
            String string2 = Base64.encodeToString((byte[])MessageDigest.getInstance((String)"SHA-256").digest(x509Certificate.getPublicKey().getEncoded()), (int)2);
            return string2;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError((Object)noSuchAlgorithmException);
        }
    }

    static boolean a(fd fd2) {
        return !"https://certificate.mobile.yandex.net/api/v1/pins".equals((Object)fd2.b());
    }
}

