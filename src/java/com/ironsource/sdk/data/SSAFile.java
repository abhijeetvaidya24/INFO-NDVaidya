/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.ironsource.sdk.data;

import com.ironsource.sdk.data.SSAObj;

public class SSAFile
extends SSAObj {
    private String FILE = "file";
    private String LAST_UPDATE_TIME = "lastUpdateTime";
    private String PATH = "path";
    private String mErrMsg;
    private String mFile;
    private String mLastUpdateTime;
    private String mPath;

    public SSAFile(String string) {
        super(string);
        if (this.containsKey(this.FILE)) {
            this.setFile(this.getString(this.FILE));
        }
        if (this.containsKey(this.PATH)) {
            this.setPath(this.getString(this.PATH));
        }
        if (this.containsKey(this.LAST_UPDATE_TIME)) {
            this.setLastUpdateTime(this.getString(this.LAST_UPDATE_TIME));
        }
    }

    public SSAFile(String string, String string2) {
        this.setFile(string);
        this.setPath(string2);
    }

    private void setFile(String string) {
        this.mFile = string;
    }

    private void setPath(String string) {
        this.mPath = string;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public String getFile() {
        return this.mFile;
    }

    public String getLastUpdateTime() {
        return this.mLastUpdateTime;
    }

    public String getPath() {
        return this.mPath;
    }

    public void setErrMsg(String string) {
        this.mErrMsg = string;
    }

    public void setLastUpdateTime(String string) {
        this.mLastUpdateTime = string;
    }
}

