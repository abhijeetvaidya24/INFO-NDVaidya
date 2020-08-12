/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.appsgeyser.multiTabApp.model;

import android.net.Uri;
import com.appsgeyser.multiTabApp.configuration.IncludeScriptConfigEntity;
import java.io.Serializable;
import java.util.ArrayList;

public class WidgetEntity
implements Serializable {
    private int _height = 0;
    private String _id;
    private String _injectJS;
    private ArrayList<IncludeScriptConfigEntity> _injectScripts;
    private String _link;
    private LoadingCurtainType _loadingCurtainType;
    private String _name;
    private boolean _showAsTab = true;
    private String _tabIcon;
    private String _tabId;
    private String _tabName;
    private String _tabType;
    private int _updateTime = 0;
    private String _userAgent;
    private int _width = 0;

    public void addScript(IncludeScriptConfigEntity includeScriptConfigEntity) {
        if (this._injectScripts == null) {
            this._injectScripts = new ArrayList();
        }
        this._injectScripts.add((Object)includeScriptConfigEntity);
    }

    public int getHeight() {
        return this._height;
    }

    public String getHostFromLink() {
        return Uri.parse((String)this._link).getHost();
    }

    public String getId() {
        return this._id;
    }

    public String getInjectJS() {
        return this._injectJS;
    }

    public ArrayList<IncludeScriptConfigEntity> getInjectScripts() {
        return this._injectScripts;
    }

    public String getLink() {
        return this._link;
    }

    public LoadingCurtainType getLoadingCurtainType() {
        return this._loadingCurtainType;
    }

    public String getName() {
        return this._name;
    }

    public String getPathFromLink() {
        return Uri.parse((String)this._link).getPath();
    }

    public String getTabIcon() {
        return this._tabIcon;
    }

    public String getTabId() {
        return this._tabId;
    }

    public String getTabName() {
        return this._tabName;
    }

    public String getTabType() {
        return this._tabType;
    }

    public int getWidth() {
        return this._width;
    }

    public boolean isShowAsTab() {
        return this._showAsTab;
    }

    public void setHeight(int n2) {
        this._height = n2;
    }

    public void setId(String string2) {
        this._id = string2;
    }

    public void setInjectJS(String string2) {
        this._injectJS = string2;
    }

    public void setLink(String string2) {
        this._link = string2;
    }

    public void setLoadingCurtainType(LoadingCurtainType loadingCurtainType) {
        this._loadingCurtainType = loadingCurtainType;
    }

    public void setName(String string2) {
        this._name = string2;
    }

    public void setShowAsTab(boolean bl) {
        this._showAsTab = bl;
    }

    public void setTabIcon(String string2) {
        this._tabIcon = string2;
    }

    public void setTabId(String string2) {
        this._tabId = string2;
    }

    public void setTabName(String string2) {
        this._tabName = string2;
    }

    public void setTabType(String string2) {
        this._tabType = string2;
    }

    public void setUpdateTime(int n2) {
        this._updateTime = n2;
    }

    public void setUserAgent(String string2) {
        this._userAgent = string2;
    }

    public void setWidth(int n2) {
        this._width = n2;
    }

    public static final class LoadingCurtainType
    extends Enum<LoadingCurtainType> {
        private static final /* synthetic */ LoadingCurtainType[] $VALUES;
        public static final /* enum */ LoadingCurtainType BANNER;
        public static final /* enum */ LoadingCurtainType CUSTOM;
        public static final /* enum */ LoadingCurtainType DEFAULT;
        public static final /* enum */ LoadingCurtainType NONE;

        static {
            NONE = new LoadingCurtainType();
            DEFAULT = new LoadingCurtainType();
            BANNER = new LoadingCurtainType();
            CUSTOM = new LoadingCurtainType();
            LoadingCurtainType[] arrloadingCurtainType = new LoadingCurtainType[]{NONE, DEFAULT, BANNER, CUSTOM};
            $VALUES = arrloadingCurtainType;
        }

        public static LoadingCurtainType valueOf(String string2) {
            return (LoadingCurtainType)Enum.valueOf(LoadingCurtainType.class, (String)string2);
        }

        public static LoadingCurtainType[] values() {
            return (LoadingCurtainType[])$VALUES.clone();
        }
    }

}

