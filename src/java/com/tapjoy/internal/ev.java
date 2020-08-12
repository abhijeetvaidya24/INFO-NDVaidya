/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Observable
 */
package com.tapjoy.internal;

import java.util.Observable;

public final class ev {
    public static final a a = new a();
    public static final a b = new a();
    public static final a c = new a();
    public static final a d = new a();
    public static final a e = new a();

    public static final class a
    extends Observable {
        public final void notifyObservers() {
            this.setChanged();
            super.notifyObservers();
        }

        public final void notifyObservers(Object object) {
            this.setChanged();
            super.notifyObservers(object);
        }
    }

}

