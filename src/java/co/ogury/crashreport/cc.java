/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Object
 */
package co.ogury.crashreport;

class cc {
    public static boolean a(char c2, char c3, boolean bl) {
        if (c2 == c3) {
            return true;
        }
        if (!bl) {
            return false;
        }
        if (Character.toUpperCase((char)c2) == Character.toUpperCase((char)c3)) {
            return true;
        }
        return Character.toLowerCase((char)c2) == Character.toLowerCase((char)c3);
    }
}

