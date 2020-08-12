/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.banners;

public class BannerSize {
    public static final BannerSize BANNER = new BannerSize(320, 50, "BANNER");
    public static final BannerSize LARGE_BANNER = new BannerSize(320, 100, "LARGE_BANNER");
    public static final BannerSize MEDIUM_RECTANGLE = new BannerSize(300, 250, "MEDIUM_RECTANGLE");
    private int height;
    private String name;
    private int width;

    private BannerSize(int n2, int n3, String string2) {
        this.width = n2;
        this.height = n3;
        this.name = string2;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BannerSize)) {
            return false;
        }
        BannerSize bannerSize = (BannerSize)object;
        return this.width == bannerSize.width && this.height == bannerSize.height && this.name.equals((Object)bannerSize.name);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public String toString() {
        return this.name;
    }
}

