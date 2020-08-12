/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.SimpleDateFormat
 */
package com.appsgeyser.multiTabApp.media.camera;

import com.appsgeyser.multiTabApp.media.camera.AlbumStorageDirFactory;
import java.text.SimpleDateFormat;

public class AlbumStorageController {
    private String _albumName;
    private AlbumStorageDirFactory _albumStorageDirFactory = null;

    public AlbumStorageController(String string2) {
        if (string2 == null || string2.equals((Object)"")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("album_");
            stringBuilder.append(new SimpleDateFormat("yyyy-MM-dd").toString());
            string2 = stringBuilder.toString();
        }
        this._albumName = string2;
    }
}

