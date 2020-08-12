/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Observable
 *  java.util.Observer
 *  java.util.Set
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.internal.el;
import com.tapjoy.internal.fc;
import com.tapjoy.internal.fw;
import com.tapjoy.internal.gn;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public final class es
extends fw
implements Observer {
    private final Map b = new HashMap();
    private final el c = new el();
    private boolean d;
    private final fc e = new fc(){

        @Override
        protected final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object object) {
            return TJPlacementManager.createPlacement(context, "AppLaunch", true, tJPlacementListener);
        }

        @Override
        protected final boolean a() {
            return super.a() && !gn.c();
        }
    };

    static {
        fw.a = new es();
    }

    private es() {
    }

    public static void a() {
    }

    @Override
    protected final void a(Activity activity) {
        block8 : {
            block7 : {
                block6 : {
                    boolean bl;
                    if (activity == null) break block6;
                    int n2 = activity.getTaskId();
                    if (n2 == -1) {
                        bl = false;
                    } else {
                        Intent intent = activity.getIntent();
                        bl = false;
                        if (intent != null) {
                            ComponentName componentName;
                            String string;
                            Integer n3;
                            Set set = intent.getCategories();
                            boolean bl2 = set != null && set.contains((Object)"android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals((Object)intent.getAction());
                            bl = !bl2 ? false : ((componentName = intent.getComponent()) == null ? false : (n3 = (Integer)this.b.put((Object)(string = componentName.getClassName()), (Object)n2)) == null || n3 != n2);
                        }
                    }
                    if (bl) break block7;
                }
                if (this.d || !this.c.a()) break block8;
            }
            this.e.c(null);
        }
        this.d = true;
    }

    public final void update(Observable observable, Object object) {
    }

}

