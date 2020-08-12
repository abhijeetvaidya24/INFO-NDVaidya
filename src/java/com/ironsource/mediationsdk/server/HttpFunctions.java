/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.ironsource.mediationsdk.IronSourceObject
 *  java.io.BufferedReader
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 */
package com.ironsource.mediationsdk.server;

import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSourceObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpFunctions {
    public static String getStringFromURL(String string) throws Exception {
        return HttpFunctions.getStringFromURL(string, null);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String getStringFromURL(String string, IronSourceObject.IResponseListener iResponseListener) throws Exception {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        block19 : {
            Exception exception2;
            Throwable throwable;
            BufferedReader bufferedReader2;
            block18 : {
                String string2;
                block16 : {
                    block17 : {
                        block15 : {
                            bufferedReader2 = null;
                            httpURLConnection = (HttpURLConnection)new URL(string).openConnection();
                            httpURLConnection.setReadTimeout(15000);
                            httpURLConnection.setConnectTimeout(15000);
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.connect();
                            if (httpURLConnection.getResponseCode() != 400) break block15;
                            if (iResponseListener != null) {
                                iResponseListener.onUnrecoverableError("Bad Request - 400");
                            }
                            if (httpURLConnection == null) return null;
                            httpURLConnection.disconnect();
                            return null;
                        }
                        bufferedReader = new BufferedReader((Reader)new InputStreamReader(httpURLConnection.getInputStream()));
                        try {
                            String string3;
                            StringBuilder stringBuilder = new StringBuilder();
                            while ((string3 = bufferedReader.readLine()) != null) {
                                stringBuilder.append(string3);
                            }
                            string2 = stringBuilder.toString();
                            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                            if (!bl2) break block16;
                            if (httpURLConnection == null) break block17;
                        }
                        catch (Throwable throwable2) {
                            bufferedReader2 = bufferedReader;
                            throwable = throwable2;
                            break block18;
                        }
                        catch (Exception exception2) {
                            break block19;
                        }
                        httpURLConnection.disconnect();
                    }
                    bufferedReader.close();
                    return null;
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                bufferedReader.close();
                return string2;
                catch (Throwable throwable3) {
                    bufferedReader2 = null;
                    break block18;
                }
                catch (Exception exception2) {
                    bufferedReader = null;
                    break block19;
                }
                catch (Throwable throwable4) {
                    httpURLConnection = null;
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedReader2 == null) throw throwable;
            bufferedReader2.close();
            throw throwable;
            catch (Exception exception2) {
                httpURLConnection = null;
                bufferedReader = null;
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (bufferedReader == null) return null;
        bufferedReader.close();
        return null;
    }
}

