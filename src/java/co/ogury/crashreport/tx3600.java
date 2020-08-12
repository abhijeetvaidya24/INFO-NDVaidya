/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.tx2160
 *  co.ogury.crashreport.tx8640
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package co.ogury.crashreport;

import co.ogury.crashreport.tx2160;
import co.ogury.crashreport.tx8640;

public class tx3600
extends tx2160 {
    public final void a(Throwable throwable, Throwable throwable2) {
        tx8640.b((Object)throwable, (String)"cause");
        tx8640.b((Object)throwable2, (String)"exception");
    }
}

