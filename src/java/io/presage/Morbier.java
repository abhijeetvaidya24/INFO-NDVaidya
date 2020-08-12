/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URLDecoder
 */
package io.presage;

import io.presage.cl;
import java.net.URLDecoder;

public final class Morbier {
    public static final String a(String string2) {
        try {
            String string3 = URLDecoder.decode((String)string2, (String)"UTF-8");
            cl.a((Object)string3, "URLDecoder.decode(this, \"UTF-8\")");
            return string3;
        }
        catch (Exception exception) {
            return "";
        }
    }
}

