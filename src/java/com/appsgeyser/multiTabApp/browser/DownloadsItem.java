/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.browser;

import java.io.Serializable;

public class DownloadsItem
implements Serializable {
    private Long date;
    private String description = "";
    private String file_path;
    private long id_d;
    private String link_d;
    private String name;
    private Integer progress = 0;
    private Status status = Status.InProgress;

    public DownloadsItem(long l2, String string2, String string3) {
        this.id_d = l2;
        this.link_d = string3;
        this.name = string2;
    }

    public DownloadsItem(String string2) {
        this.name = string2;
    }

    public Long getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFile_path() {
        return this.file_path;
    }

    public long getId_d() {
        return this.id_d;
    }

    public String getName() {
        return this.name;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setDate(Long l2) {
        this.date = l2;
    }

    public void setDescription(String string2) {
        this.description = string2;
    }

    public void setFile_path(String string2) {
        this.file_path = string2;
    }

    public void setId_d(long l2) {
        this.id_d = l2;
    }

    public void setLink_d(String string2) {
        this.link_d = string2;
    }

    public void setProgress(Integer n2) {
        this.progress = n2;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static final class Status
    extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES;
        public static final /* enum */ Status Fail;
        public static final /* enum */ Status InProgress;
        public static final /* enum */ Status Ok;

        static {
            Ok = new Status();
            InProgress = new Status();
            Fail = new Status();
            Status[] arrstatus = new Status[]{Ok, InProgress, Fail};
            $VALUES = arrstatus;
        }

        public static Status valueOf(String string2) {
            return (Status)Enum.valueOf(Status.class, (String)string2);
        }

        public static Status[] values() {
            return (Status[])$VALUES.clone();
        }
    }

}

