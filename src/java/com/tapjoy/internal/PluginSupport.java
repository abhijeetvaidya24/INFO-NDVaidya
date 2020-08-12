/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.bs
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.TreeMap
 */
package com.tapjoy.internal;

import com.tapjoy.internal.aq;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.ew;
import com.tapjoy.internal.fi;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@ew
public final class PluginSupport {
    private PluginSupport() {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @ew
    public static void trackUsage(String var0, String var1_1, String var2_2) {
        block9 : {
            if (aq.a(var1_1)) ** GOTO lbl13
            var4_3 = new TreeMap();
            var5_4 = bs.b((String)var1_1);
            var5_4.a((Map)var4_3);
            {
                catch (Throwable var6_5) {
                    var5_4.close();
                    throw var6_5;
                }
            }
            var5_4.close();
            break block9;
lbl13: // 1 sources:
            var4_3 = null;
        }
        var7_6 = aq.a(var2_2);
        var8_7 = null;
        if (var7_6) ** GOTO lbl32
        var8_7 = new HashMap();
        var9_8 = bs.b((String)var2_2);
        var9_8.h();
        while (var9_8.j()) {
            var8_7.put((Object)var9_8.l(), (Object)var9_8.q());
        }
        var9_8.i();
        {
            catch (Throwable var10_9) {
                var9_8.close();
                throw var10_9;
            }
        }
        try {
            var9_8.close();
lbl32: // 2 sources:
            fi.a(var0, var4_3, (Map)var8_7);
            return;
        }
        catch (Exception v0) {}
    }
}

