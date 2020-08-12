/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 */
package co.ogury.crashreport;

import co.ogury.crashreport.tx6480;
import co.ogury.crashreport.tx8640;
import co.ogury.crashreport.vieww10800;

public final class tx1440 {
    public static final Thread a(boolean bl, boolean bl2, ClassLoader classLoader, String string, int n2, tx6480<vieww10800> tx64802) {
        tx8640.b(tx64802, "block");
        Thread thread = new Thread(tx64802){
            private /* synthetic */ tx6480 a;
            {
                this.a = tx64802;
            }

            public final void run() {
                this.a.a();
            }
        };
        if (bl2) {
            thread.setDaemon(true);
        }
        if (n2 > 0) {
            thread.setPriority(n2);
        }
        if (string != null) {
            thread.setName(string);
        }
        if (classLoader != null) {
            thread.setContextClassLoader(classLoader);
        }
        if (bl) {
            thread.start();
        }
        return thread;
    }

}

