/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 */
package org.altbeacon.beacon.distance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.altbeacon.beacon.logging.LogManager;

public class DistanceConfigFetcher {
    protected Exception mException;
    protected String mResponse;
    private int mResponseCode = -1;
    private String mUrlString;
    private String mUserAgentString;

    public DistanceConfigFetcher(String string, String string2) {
        this.mUrlString = string;
        this.mUserAgentString = string2;
    }

    public Exception getException() {
        return this.mException;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public String getResponseString() {
        return this.mResponse;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void request() {
        int n2;
        this.mResponse = null;
        String string = this.mUrlString;
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection httpURLConnection = null;
        String string2 = string;
        int n3 = 0;
        do {
            HttpURLConnection httpURLConnection2;
            block17 : {
                SecurityException securityException;
                block20 : {
                    FileNotFoundException fileNotFoundException;
                    block19 : {
                        IOException iOException;
                        block18 : {
                            URL uRL;
                            if (n3 != 0) {
                                Object[] arrobject = new Object[]{this.mUrlString, httpURLConnection.getHeaderField("Location")};
                                LogManager.d("DistanceConfigFetcher", "Following redirect from %s to %s", arrobject);
                                string2 = httpURLConnection.getHeaderField("Location");
                            }
                            ++n3;
                            this.mResponseCode = -1;
                            try {
                                uRL = new URL(string2);
                            }
                            catch (Exception exception) {
                                Object[] arrobject = new Object[]{this.mUrlString};
                                LogManager.e("DistanceConfigFetcher", "Can't construct URL from: %s", arrobject);
                                this.mException = exception;
                                uRL = null;
                            }
                            if (uRL == null) {
                                LogManager.d("DistanceConfigFetcher", "URL is null.  Cannot make request", new Object[0]);
                                continue;
                            }
                            httpURLConnection2 = (HttpURLConnection)uRL.openConnection();
                            try {
                                httpURLConnection2.addRequestProperty("User-Agent", this.mUserAgentString);
                                this.mResponseCode = httpURLConnection2.getResponseCode();
                                Object[] arrobject = new Object[]{httpURLConnection2.getResponseCode()};
                                LogManager.d("DistanceConfigFetcher", "response code is %s", arrobject);
                                break block17;
                            }
                            catch (IOException iOException2) {
                                break block18;
                            }
                            catch (FileNotFoundException fileNotFoundException2) {
                                break block19;
                            }
                            catch (SecurityException securityException2) {
                                break block20;
                            }
                            catch (IOException iOException3) {
                                httpURLConnection2 = httpURLConnection;
                                iOException = iOException3;
                            }
                        }
                        LogManager.w(iOException, "DistanceConfigFetcher", "Can't reach server", new Object[0]);
                        this.mException = iOException;
                        break block17;
                        catch (FileNotFoundException fileNotFoundException3) {
                            httpURLConnection2 = httpURLConnection;
                            fileNotFoundException = fileNotFoundException3;
                        }
                    }
                    LogManager.w(fileNotFoundException, "DistanceConfigFetcher", "No data exists at \"+urlString", new Object[0]);
                    this.mException = fileNotFoundException;
                    break block17;
                    catch (SecurityException securityException3) {
                        httpURLConnection2 = httpURLConnection;
                        securityException = securityException3;
                    }
                }
                LogManager.w(securityException, "DistanceConfigFetcher", "Can't reach sever.  Have you added android.permission.INTERNET to your manifest?", new Object[0]);
                this.mException = securityException;
            }
            httpURLConnection = httpURLConnection2;
        } while (n3 < 10 && ((n2 = this.mResponseCode) == 302 || n2 == 301 || n2 == 303));
        if (this.mException != null) return;
        try {
            BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(httpURLConnection.getInputStream()));
            do {
                String string3;
                if ((string3 = bufferedReader.readLine()) == null) {
                    bufferedReader.close();
                    this.mResponse = stringBuilder.toString();
                    return;
                }
                stringBuilder.append(string3);
            } while (true);
        }
        catch (Exception exception) {
            this.mException = exception;
            LogManager.w(exception, "DistanceConfigFetcher", "error reading beacon data", new Object[0]);
        }
    }
}

