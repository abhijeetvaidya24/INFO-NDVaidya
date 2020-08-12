/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.ByteArrayInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.security.KeyManagementException
 *  java.security.KeyStore
 *  java.security.KeyStoreException
 *  java.security.NoSuchAlgorithmException
 *  java.security.UnrecoverableKeyException
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateFactory
 *  java.security.cert.X509Certificate
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocketFactory
 *  org.apache.http.conn.ssl.SSLSocketFactory
 *  org.apache.http.conn.ssl.X509HostnameVerifier
 */
package com.yandex.metrica.impl.ob;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class ex {
    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static X509Certificate a(InputStream inputStream) {
        Throwable throwable32222;
        block12 : {
            CertificateFactory certificateFactory = CertificateFactory.getInstance((String)"X.509");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            X509Certificate x509Certificate = (X509Certificate)certificateFactory.generateCertificate((InputStream)bufferedInputStream);
            bufferedInputStream.close();
            try {
                inputStream.close();
                return x509Certificate;
            }
            catch (IOException iOException) {}
            return x509Certificate;
            catch (Throwable throwable2) {
                try {
                    bufferedInputStream.close();
                    throw throwable2;
                }
                catch (Throwable throwable32222) {
                    break block12;
                }
                catch (Exception exception) {
                    throw new RuntimeException((Throwable)exception);
                }
            }
        }
        try {
            inputStream.close();
            throw throwable32222;
        }
        catch (IOException iOException) {}
        throw throwable32222;
    }

    public static X509Certificate a(String string2) {
        try {
            X509Certificate x509Certificate = ex.a((InputStream)new ByteArrayInputStream(string2.getBytes()));
            return x509Certificate;
        }
        catch (Exception exception) {
            throw new RuntimeException((Throwable)exception);
        }
    }

    private static class a
    extends org.apache.http.conn.ssl.SSLSocketFactory {
        private final SSLContext a;

        public a(SSLContext sSLContext) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
            super(null);
            this.a = sSLContext;
            this.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }

        public Socket createSocket() throws IOException {
            return this.a.getSocketFactory().createSocket();
        }

        public Socket createSocket(Socket socket, String string2, int n2, boolean bl2) throws IOException {
            return this.a.getSocketFactory().createSocket(socket, string2, n2, bl2);
        }
    }

}

