/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.zip.GZIPOutputStream
 */
package com.startapp.a.a.d;

import com.startapp.a.a.c.d;
import com.startapp.a.a.d.c;
import com.startapp.a.a.d.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class a
implements e {
    private final c a;

    public a(c c2) {
        this.a = c2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public String a(String string) {
        GZIPOutputStream gZIPOutputStream;
        void var5_9;
        block6 : {
            GZIPOutputStream gZIPOutputStream2;
            block7 : {
                String string2;
                gZIPOutputStream2 = null;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPOutputStream = new GZIPOutputStream((OutputStream)byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(string.getBytes());
                    d.a((OutputStream)gZIPOutputStream);
                    String string3 = com.startapp.a.a.c.a.a(byteArrayOutputStream.toByteArray());
                    string2 = this.a.a(string3);
                }
                catch (Throwable throwable) {
                    break block6;
                }
                catch (Exception exception) {
                    gZIPOutputStream2 = gZIPOutputStream;
                    break block7;
                }
                d.a((OutputStream)gZIPOutputStream);
                return string2;
                catch (Throwable throwable) {
                    gZIPOutputStream = null;
                    break block6;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            d.a(gZIPOutputStream2);
            return "";
        }
        d.a(gZIPOutputStream);
        throw var5_9;
    }
}

