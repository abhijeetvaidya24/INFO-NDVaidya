/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Observer
 */
package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.el;
import com.tapjoy.internal.fc;
import com.tapjoy.internal.gn;
import java.util.Observer;

public final class fa
extends gn {
    private final fc b = new fc(){

        @Override
        protected final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object object) {
            gn.a a2 = (gn.a)object;
            TJPlacement tJPlacement = TJPlacementManager.createPlacement(TapjoyConnectCore.getContext(), a2.b, false, tJPlacementListener);
            tJPlacement.pushId = a2.a;
            return tJPlacement;
        }

        @Override
        protected final boolean a() {
            return true;
        }

        @Override
        protected final boolean a(Observer observer) {
            if (TapjoyConnectCore.isViewOpen()) {
                TJPlacementManager.dismissContentShowing(true);
            }
            return super.a(observer);
        }

        @Override
        protected final /* synthetic */ fc.a b(Object object) {
            gn.a a2 = (gn.a)object;
            return new TJPlacementListener(this, a2, a2.d){
                final /* synthetic */ fc a;
                private final Object b;
                private final el c;
                private volatile boolean d;
                private TJPlacement e;
                {
                    this(fc2, object, new el(10000L));
                }
                {
                    this.a = fc2;
                    this.b = object;
                    this.c = el2;
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                private void a(String string) {
                    fc fc2;
                    fc.a a2 = this;
                    synchronized (a2) {
                        String string2 = this.a.a(this.b);
                        if (string == null) {
                            java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder("Placement ");
                            stringBuilder.append(string2);
                            stringBuilder.append(" is presented now");
                            com.tapjoy.TapjoyLog.i("SystemPlacement", stringBuilder.toString());
                        } else {
                            java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder("Cannot show placement ");
                            stringBuilder.append(string2);
                            stringBuilder.append(" now (");
                            stringBuilder.append(string);
                            stringBuilder.append(")");
                            com.tapjoy.TapjoyLog.i("SystemPlacement", stringBuilder.toString());
                        }
                        this.d = true;
                        this.e = null;
                        com.tapjoy.internal.ev.a.deleteObserver((Observer)this);
                        com.tapjoy.internal.ev.e.deleteObserver((Observer)this);
                        com.tapjoy.internal.ev.c.deleteObserver((Observer)this);
                    }
                    fc fc3 = fc2 = this.a;
                    synchronized (fc3) {
                        if (fc2.b == this) {
                            fc2.b = null;
                        }
                        return;
                    }
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                final void a() {
                    fc.a a2 = this;
                    synchronized (a2) {
                        if (this.d) {
                            return;
                        }
                        if (this.c.a()) {
                            this.a("Timed out");
                            return;
                        }
                        if (!TapjoyConnectCore.isConnected()) {
                            com.tapjoy.internal.ev.a.addObserver((Observer)this);
                            if (!TapjoyConnectCore.isConnected()) {
                                return;
                            }
                            com.tapjoy.internal.ev.a.deleteObserver((Observer)this);
                        }
                        if (this.e == null) {
                            if (!this.a.a()) {
                                this.a("Cannot request");
                                return;
                            }
                            this.e = this.a.a(TapjoyConnectCore.getContext(), this, this.b);
                            this.e.requestContent();
                            return;
                        }
                        if (!this.e.isContentReady()) {
                            return;
                        }
                        if (!this.a.a(this)) {
                            return;
                        }
                        this.e.showContent();
                        this.a(null);
                        return;
                    }
                }

                public final void onContentDismiss(TJPlacement tJPlacement) {
                }

                public final void onContentReady(TJPlacement tJPlacement) {
                    this.a();
                }

                public final void onContentShow(TJPlacement tJPlacement) {
                }

                public final void onPurchaseRequest(TJPlacement tJPlacement, com.tapjoy.TJActionRequest tJActionRequest, String string) {
                }

                public final void onRequestFailure(TJPlacement tJPlacement, com.tapjoy.TJError tJError) {
                    this.a(tJError.message);
                }

                public final void onRequestSuccess(TJPlacement tJPlacement) {
                }

                public final void onRewardRequest(TJPlacement tJPlacement, com.tapjoy.TJActionRequest tJActionRequest, String string, int n2) {
                }

                public final void update(java.util.Observable observable, Object object) {
                    this.a();
                }
            };
        }
    };

    static {
        gn.a(new fa());
    }

    private fa() {
    }

    public static void a() {
    }

    @Override
    protected final void a(gn.a a2) {
        this.b.c(a2);
    }

    @Override
    protected final boolean b() {
        return this.b.b != null;
    }

}

