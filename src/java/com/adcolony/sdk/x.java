/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.DataOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 *  java.nio.charset.Charset
 *  java.util.zip.GZIPOutputStream
 */
package com.adcolony.sdk;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

class x {
    URL a;

    public x(URL uRL) {
        this.a = uRL;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public int a(String string) throws IOException {
        DataOutputStream dataOutputStream;
        GZIPOutputStream gZIPOutputStream;
        HttpURLConnection httpURLConnection;
        void var7_14;
        boolean bl;
        block21 : {
            DataOutputStream dataOutputStream2;
            block23 : {
                boolean bl2;
                HttpURLConnection httpURLConnection2;
                block22 : {
                    block25 : {
                        block24 : {
                            int n2;
                            bl2 = true;
                            httpURLConnection2 = null;
                            httpURLConnection = (HttpURLConnection)this.a.openConnection();
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
                            httpURLConnection.setRequestProperty("Content-Type", "application/json");
                            httpURLConnection.setDoInput(bl2);
                            gZIPOutputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
                            dataOutputStream2 = new DataOutputStream((OutputStream)gZIPOutputStream);
                            dataOutputStream2.write(string.getBytes(Charset.forName((String)"UTF-8")));
                            dataOutputStream2.close();
                            try {
                                n2 = httpURLConnection.getResponseCode();
                            }
                            catch (Throwable throwable) {
                                dataOutputStream = dataOutputStream2;
                                bl = true;
                                break block21;
                            }
                            catch (IOException iOException) {
                                httpURLConnection2 = httpURLConnection;
                                break block22;
                            }
                            gZIPOutputStream.close();
                            if (httpURLConnection == null) return n2;
                            if (httpURLConnection.getInputStream() != null) {
                                httpURLConnection.getInputStream().close();
                            }
                            httpURLConnection.disconnect();
                            return n2;
                            catch (Throwable throwable) {
                                bl = false;
                                break block23;
                            }
                            catch (IOException iOException) {
                                break block24;
                            }
                            catch (Throwable throwable) {
                                dataOutputStream = null;
                                bl = false;
                                break block21;
                            }
                            catch (IOException iOException) {
                                dataOutputStream2 = null;
                                break block24;
                            }
                            catch (Throwable throwable) {
                                dataOutputStream = null;
                                bl = false;
                                gZIPOutputStream = null;
                                break block21;
                            }
                            catch (IOException iOException) {
                                gZIPOutputStream = null;
                                dataOutputStream2 = null;
                            }
                        }
                        httpURLConnection2 = httpURLConnection;
                        break block25;
                        catch (Throwable throwable) {
                            dataOutputStream = null;
                            bl = false;
                            httpURLConnection = null;
                            gZIPOutputStream = null;
                            break block21;
                        }
                        catch (IOException iOException) {
                            gZIPOutputStream = null;
                            dataOutputStream2 = null;
                        }
                    }
                    bl2 = false;
                }
                try {
                    void var4_21;
                    throw var4_21;
                }
                catch (Throwable throwable) {
                    bl = bl2;
                    httpURLConnection = httpURLConnection2;
                }
            }
            dataOutputStream = dataOutputStream2;
        }
        if (dataOutputStream != null && !bl) {
            dataOutputStream.close();
        }
        if (gZIPOutputStream != null) {
            gZIPOutputStream.close();
        }
        if (httpURLConnection == null) throw var7_14;
        if (httpURLConnection.getInputStream() != null) {
            httpURLConnection.getInputStream().close();
        }
        httpURLConnection.disconnect();
        throw var7_14;
    }
}

