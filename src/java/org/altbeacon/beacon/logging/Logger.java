/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.altbeacon.beacon.logging;

public interface Logger {
    public /* varargs */ void d(String var1, String var2, Object ... var3);

    public /* varargs */ void e(String var1, String var2, Object ... var3);

    public /* varargs */ void e(Throwable var1, String var2, String var3, Object ... var4);

    public /* varargs */ void i(String var1, String var2, Object ... var3);

    public /* varargs */ void w(String var1, String var2, Object ... var3);

    public /* varargs */ void w(Throwable var1, String var2, String var3, Object ... var4);
}

