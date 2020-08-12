/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.BufferedWriter
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Reader
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.URL
 *  java.net.URLConnection
 *  java.nio.charset.Charset
 *  javax.net.ssl.HttpsURLConnection
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.blue255;
import com.ogury.consent.manager.cf0;
import com.ogury.consent.manager.rtf1;
import com.ogury.consent.manager.tx3600;
import com.ogury.consent.manager.tx5040;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.ConsentException;
import com.ogury.consent.manager.vieww10800;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import javax.net.ssl.HttpsURLConnection;

public final class fonttbl {
    public static final rtf1 a = new rtf1(null);

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static String a(InputStream inputStream) {
        Throwable throwable3222;
        Closeable closeable = (Closeable)new BufferedReader((Reader)new InputStreamReader(inputStream, cf0.a), 8192);
        Throwable throwable2 = null;
        Reader reader = (Reader)((BufferedReader)closeable);
        tx6480.b((Object)reader, "$receiver");
        StringWriter stringWriter = new StringWriter();
        rtf1.rtf1.a(reader, (Writer)stringWriter, 8192);
        String string2 = stringWriter.toString();
        tx6480.a((Object)string2, "buffer.toString()");
        tx3600.a(closeable, null);
        return string2;
        {
            catch (Throwable throwable3222) {
            }
            catch (Throwable throwable4) {}
            throwable2 = throwable4;
            {
                throw throwable2;
            }
        }
        tx3600.a(closeable, throwable2);
        throw throwable3222;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(blue255 blue2552) {
        block7 : {
            HttpsURLConnection httpsURLConnection;
            block8 : {
                tx6480.b(blue2552, "request");
                try {
                    URLConnection uRLConnection = new URL(blue2552.c()).openConnection();
                    if (uRLConnection == null) break block7;
                    httpsURLConnection = (HttpsURLConnection)uRLConnection;
                    httpsURLConnection.setReadTimeout(10000);
                    httpsURLConnection.setConnectTimeout(150000);
                    httpsURLConnection.setRequestMethod(blue2552.a());
                    httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpsURLConnection.setRequestProperty("Accept", "application/json");
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpsURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(blue2552.b());
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    httpsURLConnection.connect();
                    int n2 = httpsURLConnection.getResponseCode();
                    com.ogury.consent.manager.util.consent.rtf1 rtf12 = blue2552.d();
                    if (200 <= n2 && 299 >= n2) {
                        if (rtf12 != null) {
                            InputStream inputStream = httpsURLConnection.getInputStream();
                            tx6480.a((Object)inputStream, "conn.inputStream");
                            rtf12.a(fonttbl.a(inputStream));
                        }
                        break block8;
                    }
                    if (rtf12 == null) break block8;
                    InputStream inputStream = httpsURLConnection.getErrorStream();
                    tx6480.a((Object)inputStream, "conn.errorStream");
                    rtf12.a(new ConsentException(fonttbl.a(inputStream), "system-error"));
                }
                catch (Exception exception) {
                    com.ogury.consent.manager.util.consent.rtf1 rtf13 = blue2552.d();
                    if (rtf13 == null) return;
                    rtf13.a(new ConsentException("server-not-responding", ""));
                    return;
                }
            }
            try {
                httpsURLConnection.disconnect();
                return;
            }
            catch (Exception exception) {}
            return;
        }
        throw new vieww10800("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
    }

    public static final class rtf1 {
        private rtf1() {
        }

        public /* synthetic */ rtf1(tx5040 tx50402) {
            this();
        }
    }

}

