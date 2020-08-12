/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage.common.network.models;

import io.presage.cl;
import java.io.Serializable;

public final class RewardItem
implements Serializable {
    private String a;
    private String b;

    public RewardItem(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public static /* synthetic */ RewardItem copy$default(RewardItem rewardItem, String string2, String string3, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = rewardItem.a;
        }
        if ((n2 & 2) != 0) {
            string3 = rewardItem.b;
        }
        return rewardItem.copy(string2, string3);
    }

    public final String component1() {
        return this.a;
    }

    public final String component2() {
        return this.b;
    }

    public final RewardItem copy(String string2, String string3) {
        return new RewardItem(string2, string3);
    }

    public final boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof RewardItem)) break block3;
                RewardItem rewardItem = (RewardItem)object;
                if (cl.a((Object)this.a, (Object)rewardItem.a) && cl.a((Object)this.b, (Object)rewardItem.b)) break block2;
            }
            return false;
        }
        return true;
    }

    public final String getName() {
        return this.a;
    }

    public final String getValue() {
        return this.b;
    }

    public final int hashCode() {
        String string2 = this.a;
        int n2 = string2 != null ? string2.hashCode() : 0;
        int n3 = n2 * 31;
        String string3 = this.b;
        int n4 = 0;
        if (string3 != null) {
            n4 = string3.hashCode();
        }
        return n3 + n4;
    }

    public final void setName(String string2) {
        this.a = string2;
    }

    public final void setValue(String string2) {
        this.b = string2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("RewardItem(name=");
        stringBuilder.append(this.a);
        stringBuilder.append(", value=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

