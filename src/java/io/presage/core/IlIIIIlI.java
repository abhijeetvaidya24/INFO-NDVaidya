/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIIlIlll
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package io.presage.core;

import io.presage.core.IIIIIlIl;
import io.presage.core.IlIIIIIl;
import io.presage.core.lIIIlIlI;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class IlIIIIlI {
    private static final String IIIIIIII = lIIIlIlI.IIIlIlll.IIIIIIII;
    private static final String IIIIIIIl = lIIIlIlI.IIIlIlll.IIIIIIIl;

    public final JSONObject IIIIIIII(IIIIIlIl iIIIIlIl) {
        if (iIIIIlIl != null) {
            void var3_5;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IIIIIIII, iIIIIlIl.IIIIIIII());
                jSONObject.put(IIIIIIIl, iIIIIlIl.IIIIIIII);
                this.IIIIIIII(jSONObject, iIIIIlIl);
                return jSONObject;
            }
            catch (ClassCastException classCastException) {
            }
            catch (JSONException jSONException) {
                // empty catch block
            }
            throw new IlIIIIIl((Throwable)var3_5);
        }
        throw new IlIIIIIl();
    }

    public abstract void IIIIIIII(JSONObject var1, IIIIIlIl var2);
}

