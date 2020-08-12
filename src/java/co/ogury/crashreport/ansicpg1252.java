/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.BufferedWriter
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.net.URLConnection
 */
package co.ogury.crashreport;

import co.ogury.crashreport.margl1440;
import co.ogury.crashreport.tx8640;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final class ansicpg1252 {
    public static final ansicpg1252 a = new ansicpg1252();

    private ansicpg1252() {
    }

    public static int a(String string, String string2) {
        tx8640.b(string, "crashJson");
        tx8640.b(string2, "url");
        URLConnection uRLConnection = new URL(string2).openConnection();
        if (uRLConnection != null) {
            HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            httpURLConnection.connect();
            return httpURLConnection.getResponseCode();
        }
        throw new margl1440("null cannot be cast to non-null type java.net.HttpURLConnection");
    }
}

