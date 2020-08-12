/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Size;
import org.json.JSONObject;

class Position {
    private Size size;
    private int x;
    private int y;

    public Position() {
        this.size = new Size(0, 0);
        this.x = 0;
        this.y = 0;
    }

    public Position(Size size, int n, int n2) {
        this.size = size;
        this.x = n;
        this.y = n2;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof Position;
        boolean bl2 = false;
        if (bl) {
            Position position = (Position)object;
            boolean bl3 = this.size.equals(position.size);
            bl2 = false;
            if (bl3) {
                int n = this.x;
                int n2 = position.x;
                bl2 = false;
                if (n == n2) {
                    int n3 = this.y;
                    int n4 = position.y;
                    bl2 = false;
                    if (n3 == n4) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public Size getSize() {
        return this.size;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setX(int n) {
        this.x = n;
    }

    public void setY(int n) {
        this.y = n;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = this.size.toJSONObject();
        JSONUtils.put(jSONObject, "x", this.x);
        JSONUtils.put(jSONObject, "y", this.y);
        return jSONObject;
    }
}

