/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.Throwable
 */
package io.presage.core;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class lIIIllIl {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final long IIIIIIII(InputStream inputStream, OutputStream outputStream, boolean bl2, boolean bl3) {
        int n2;
        block9 : {
            if (inputStream == null || outputStream == null) {
                if (inputStream != null && bl2) {
                    inputStream.close();
                }
                if (outputStream != null && bl3) {
                    outputStream.close();
                }
                return -1L;
            }
            byte[] arrby = new byte[2048];
            n2 = 0;
            try {
                int n3;
                while ((n3 = inputStream.read(arrby)) != -1) {
                    outputStream.write(arrby, 0, n3);
                    n2 += n3;
                }
                if (!bl2) break block9;
            }
            catch (Throwable throwable) {
                if (bl2) {
                    inputStream.close();
                }
                if (bl3) {
                    outputStream.close();
                }
                throw throwable;
            }
            inputStream.close();
        }
        if (bl3) {
            outputStream.close();
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final byte[] IIIIIIII(InputStream inputStream, boolean bl2) {
        ByteArrayOutputStream byteArrayOutputStream;
        block4 : {
            if (inputStream == null) {
                return null;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int n2;
                byte[] arrby = new byte[2048];
                while ((n2 = inputStream.read(arrby)) != -1) {
                    byteArrayOutputStream.write(arrby, 0, n2);
                }
                if (!bl2) break block4;
            }
            catch (Throwable throwable) {
                if (!bl2) throw throwable;
                inputStream.close();
                throw throwable;
            }
            inputStream.close();
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}

