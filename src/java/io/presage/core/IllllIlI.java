/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  io.presage.core.IIlIIllI
 *  java.lang.Object
 *  java.lang.Void
 *  java.util.concurrent.Executor
 */
package io.presage.core;

import android.os.AsyncTask;
import io.presage.core.IIlIIIll;
import io.presage.core.IIlIIlIl;
import io.presage.core.IIlIIllI;
import io.presage.core.lIIIIlII;
import java.util.concurrent.Executor;

public abstract class IllllIlI<Params, Result> {
    IIlIIllI IIIIIIII;
    boolean IIIIIIIl;
    private final IllllIlI<Params, Result> IIIIIIlI = new IIIIIIII();

    public /* varargs */ abstract Result IIIIIIII(Params ... var1);

    public final /* varargs */ void IIIIIIII(IIlIIllI iIlIIllI, boolean bl2, Params ... arrParams) {
        if (!iIlIIllI.isShutdown()) {
            this.IIIIIIII = iIlIIllI;
            this.IIIIIIIl = bl2;
            this.IIIIIIlI.executeOnExecutor((Executor)iIlIIllI, (Object[])arrParams);
            return;
        }
        throw new IIlIIIll();
    }

    public void IIIIIIII(Result Result) {
    }

    public final class IIIIIIII
    extends AsyncTask<Params, Void, Result> {
        protected final /* varargs */ Result doInBackground(Params ... arrParams) {
            return IllllIlI.this.IIIIIIII(arrParams);
        }

        protected final void onPostExecute(Result Result) {
            IllllIlI.this.IIIIIIII.IIIIIIII();
            if (IllllIlI.this.IIIIIIIl) {
                lIIIIlII.IIIIIIII((IIlIIlIl)IllllIlI.this.IIIIIIII);
            }
            IllllIlI.this.IIIIIIII(Result);
        }
    }

}

