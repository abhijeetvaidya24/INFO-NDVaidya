/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  java.io.Serializable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.appsgeyser.multiTabApp.configuration;

import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.configuration.UrlBarMenuButton;
import java.io.Serializable;
import java.util.ArrayList;

public class WebWidgetConfiguration
implements Serializable {
    private boolean acceptCookie = true;
    private String addUsageUrl;
    private String affiliateGetString = "";
    private String appGuid = "";
    private MainNavigationActivity.ApplicationMode appMode = MainNavigationActivity.ApplicationMode.UNKNOWN;
    private ApplicationThemes appTheme = ApplicationThemes.SLIDER;
    private int applicationId;
    private DownloadActions downloadAction = DownloadActions.OPEN;
    private boolean fullScreenBannerEnabled = false;
    private String httpAccessLogin;
    private String httpAccessPassword;
    private boolean isAboutScreenEnabled = true;
    private RedirectionTypes isRedirectEnabled = RedirectionTypes.REDIRECT_ALL;
    private boolean isSplashScreenEnabled = false;
    private String locationUrl;
    private boolean onExitFullScreenBannerEnabled = false;
    private boolean preventFromSleep;
    private String publisherName = "";
    private String pushAccount = "";
    private boolean rateItemVisibility = false;
    private String registeredUrl;
    private String shareExtraLink = "";
    private boolean showAboutMenuItem;
    private boolean showDownloadList;
    private boolean showExitMenuItem;
    private boolean showInAppMenuItem;
    private boolean showRefreshMenuItem;
    private boolean showSearchNotice = false;
    private boolean showSettings;
    private boolean showShareMenuItem;
    private boolean showStartupConfirmationDialog = false;
    private String splashScreenImage = "";
    private TabsEnabledHide tabsEnabledHide = TabsEnabledHide.DISABLED;
    private TabsPositions tabsPosition = TabsPositions.TOP;
    private UrlBarHide urlBarHide = UrlBarHide.DISABLED;
    private ArrayList<UrlBarMenuButton> urlBarMenuButtons = new ArrayList();
    private UrlBarStyles urlBarStyle = UrlBarStyles.BOTTOM;
    private UrlBarStates urlOverlayEnabled = UrlBarStates.DISABLED;
    private String widgetName;

    public void addUrlBarMenuButton(UrlBarMenuButton urlBarMenuButton) {
        this.urlBarMenuButtons.add((Object)urlBarMenuButton);
    }

    public String getAffiliateString() {
        return this.affiliateGetString;
    }

    public int getApplicationId() {
        return this.applicationId;
    }

    public MainNavigationActivity.ApplicationMode getApplicationMode() {
        return this.appMode;
    }

    public ApplicationThemes getApplicationTheme() {
        return this.appTheme;
    }

    public DownloadActions getDownloadAction() {
        return this.downloadAction;
    }

    public String getHttpAccessLogin() {
        return this.httpAccessLogin;
    }

    public String getHttpAccessPassword() {
        return this.httpAccessPassword;
    }

    public RedirectionTypes getIsRedirectEnabled() {
        return this.isRedirectEnabled;
    }

    public boolean getPreventFromSleep() {
        return this.preventFromSleep;
    }

    public boolean getRateItemVisibility() {
        return this.rateItemVisibility;
    }

    public String getShareExtraLink() {
        return this.shareExtraLink;
    }

    public boolean getShowDownloadList() {
        return this.showDownloadList;
    }

    public boolean getShowExitMenuItem() {
        return this.showExitMenuItem;
    }

    public boolean getShowRefreshMenuItem() {
        return this.showRefreshMenuItem;
    }

    public boolean getShowSearchNotice() {
        return this.showSearchNotice;
    }

    public boolean getShowSettings() {
        return this.showSettings;
    }

    public boolean getShowShareMenuItem() {
        return this.showShareMenuItem;
    }

    public String getSplashScreenImage() {
        return this.splashScreenImage;
    }

    public TabsPositions getTabsPosition() {
        return this.tabsPosition;
    }

    public ArrayList<UrlBarMenuButton> getUrlBarMenuButtons() {
        return this.urlBarMenuButtons;
    }

    public UrlBarStyles getUrlBarStyle() {
        return this.urlBarStyle;
    }

    public UrlBarStates getUrlOverlayState() {
        return this.urlOverlayEnabled;
    }

    public String getWidgetName() {
        return this.widgetName;
    }

    public boolean isSplashScreenEnabled() {
        return this.isSplashScreenEnabled;
    }

    public void setAcceptCookie(boolean bl) {
        this.acceptCookie = bl;
    }

    public void setAddUsageUrl(String string2) {
        this.addUsageUrl = string2;
    }

    public void setAffiliateString(String string2) {
        this.affiliateGetString = string2;
    }

    public void setApplicationId(int n2) {
        this.applicationId = n2;
    }

    public void setApplicationMode(MainNavigationActivity.ApplicationMode applicationMode) {
        this.appMode = applicationMode;
    }

    public void setApplicationTheme(ApplicationThemes applicationThemes) {
        this.appTheme = applicationThemes;
    }

    public void setDownloadAction(DownloadActions downloadActions) {
        this.downloadAction = downloadActions;
    }

    public void setFullscreenBannerEnabled(boolean bl) {
        this.fullScreenBannerEnabled = bl;
    }

    public void setHttpAccessLogin(String string2) {
        this.httpAccessLogin = string2;
    }

    public void setHttpAccessPassword(String string2) {
        this.httpAccessPassword = string2;
    }

    public void setIsAboutScreenEnabled(boolean bl) {
        this.isAboutScreenEnabled = bl;
    }

    public void setIsRedirectEnabled(RedirectionTypes redirectionTypes) {
        this.isRedirectEnabled = redirectionTypes;
    }

    public void setLocationUrl(String string2) {
        this.locationUrl = string2;
    }

    public void setOnExitFullscreenBannerEnabled(boolean bl) {
        this.onExitFullScreenBannerEnabled = bl;
    }

    public void setPreventFromSleep(boolean bl) {
        this.preventFromSleep = bl;
    }

    public void setPublisherName(String string2) {
        this.publisherName = string2;
    }

    public void setRateItemVisibility(boolean bl) {
        this.rateItemVisibility = bl;
    }

    public void setRegisteredUrl(String string2) {
        this.registeredUrl = string2;
    }

    public void setShareExtraLink(String string2) {
        this.shareExtraLink = string2;
    }

    public void setShowAboutMenuItem(boolean bl) {
        this.showAboutMenuItem = bl;
    }

    public void setShowDownloadList(boolean bl) {
        this.showDownloadList = bl;
    }

    public void setShowExitMenuItem(boolean bl) {
        this.showExitMenuItem = bl;
    }

    public void setShowInAppMenuItem(boolean bl) {
        this.showInAppMenuItem = bl;
    }

    public void setShowRefreshMenuItem(boolean bl) {
        this.showRefreshMenuItem = bl;
    }

    public void setShowSearchNotice(boolean bl) {
        this.showSearchNotice = bl;
    }

    public void setShowSettings(boolean bl) {
        this.showSettings = bl;
    }

    public void setShowShareMenuItem(boolean bl) {
        this.showShareMenuItem = bl;
    }

    public void setShowStartupConfirmationDialog(boolean bl) {
        this.showStartupConfirmationDialog = bl;
    }

    public void setSplashScreen(String string2) {
        if (string2 == null) {
            return;
        }
        this.isSplashScreenEnabled = true;
        this.splashScreenImage = string2;
    }

    public void setTabsEnabledHide(TabsEnabledHide tabsEnabledHide) {
        this.tabsEnabledHide = tabsEnabledHide;
    }

    public void setTabsPosition(TabsPositions tabsPositions) {
        this.tabsPosition = tabsPositions;
    }

    public void setUrlBarHide(UrlBarHide urlBarHide) {
        this.urlBarHide = urlBarHide;
    }

    public void setUrlBarStyle(UrlBarStyles urlBarStyles) {
        this.urlBarStyle = urlBarStyles;
    }

    public void setUrlOverlayState(UrlBarStates urlBarStates) {
        this.urlOverlayEnabled = urlBarStates;
    }

    public void setWidgetName(String string2) {
        this.widgetName = string2;
    }

    public static final class ApplicationThemes
    extends Enum<ApplicationThemes> {
        private static final /* synthetic */ ApplicationThemes[] $VALUES;
        public static final /* enum */ ApplicationThemes ACTION_BAR = new ApplicationThemes();
        public static final /* enum */ ApplicationThemes NO_MENU;
        public static final /* enum */ ApplicationThemes SLIDER;

        static {
            SLIDER = new ApplicationThemes();
            NO_MENU = new ApplicationThemes();
            ApplicationThemes[] arrapplicationThemes = new ApplicationThemes[]{ACTION_BAR, SLIDER, NO_MENU};
            $VALUES = arrapplicationThemes;
        }

        public static ApplicationThemes valueOf(String string2) {
            return (ApplicationThemes)Enum.valueOf(ApplicationThemes.class, (String)string2);
        }

        public static ApplicationThemes[] values() {
            return (ApplicationThemes[])$VALUES.clone();
        }
    }

    public static final class DownloadActions
    extends Enum<DownloadActions> {
        private static final /* synthetic */ DownloadActions[] $VALUES;
        public static final /* enum */ DownloadActions DIALOG;
        public static final /* enum */ DownloadActions OPEN;
        public static final /* enum */ DownloadActions SAVE;

        static {
            OPEN = new DownloadActions();
            SAVE = new DownloadActions();
            DIALOG = new DownloadActions();
            DownloadActions[] arrdownloadActions = new DownloadActions[]{OPEN, SAVE, DIALOG};
            $VALUES = arrdownloadActions;
        }

        public static DownloadActions valueOf(String string2) {
            return (DownloadActions)Enum.valueOf(DownloadActions.class, (String)string2);
        }

        public static DownloadActions[] values() {
            return (DownloadActions[])$VALUES.clone();
        }
    }

    public static final class RedirectionTypes
    extends Enum<RedirectionTypes> {
        private static final /* synthetic */ RedirectionTypes[] $VALUES;
        public static final /* enum */ RedirectionTypes NO_REDIRECT;
        public static final /* enum */ RedirectionTypes REDIRECT_ALL;
        public static final /* enum */ RedirectionTypes REDIRECT_EXTERNAL;

        static {
            REDIRECT_ALL = new RedirectionTypes();
            REDIRECT_EXTERNAL = new RedirectionTypes();
            NO_REDIRECT = new RedirectionTypes();
            RedirectionTypes[] arrredirectionTypes = new RedirectionTypes[]{REDIRECT_ALL, REDIRECT_EXTERNAL, NO_REDIRECT};
            $VALUES = arrredirectionTypes;
        }

        public static RedirectionTypes valueOf(String string2) {
            return (RedirectionTypes)Enum.valueOf(RedirectionTypes.class, (String)string2);
        }

        public static RedirectionTypes[] values() {
            return (RedirectionTypes[])$VALUES.clone();
        }
    }

    public static final class TabsEnabledHide
    extends Enum<TabsEnabledHide> {
        private static final /* synthetic */ TabsEnabledHide[] $VALUES;
        public static final /* enum */ TabsEnabledHide DISABLED;
        public static final /* enum */ TabsEnabledHide ENABLED;

        static {
            ENABLED = new TabsEnabledHide();
            DISABLED = new TabsEnabledHide();
            TabsEnabledHide[] arrtabsEnabledHide = new TabsEnabledHide[]{ENABLED, DISABLED};
            $VALUES = arrtabsEnabledHide;
        }

        public static TabsEnabledHide valueOf(String string2) {
            return (TabsEnabledHide)Enum.valueOf(TabsEnabledHide.class, (String)string2);
        }

        public static TabsEnabledHide[] values() {
            return (TabsEnabledHide[])$VALUES.clone();
        }
    }

    public static final class TabsPositions
    extends Enum<TabsPositions> {
        private static final /* synthetic */ TabsPositions[] $VALUES;
        public static final /* enum */ TabsPositions BOTTOM;
        public static final /* enum */ TabsPositions BOTTOM_MENU;
        public static final /* enum */ TabsPositions DRAWER;
        public static final /* enum */ TabsPositions TOP;

        static {
            TOP = new TabsPositions();
            BOTTOM = new TabsPositions();
            BOTTOM_MENU = new TabsPositions();
            DRAWER = new TabsPositions();
            TabsPositions[] arrtabsPositions = new TabsPositions[]{TOP, BOTTOM, BOTTOM_MENU, DRAWER};
            $VALUES = arrtabsPositions;
        }

        public static TabsPositions valueOf(String string2) {
            return (TabsPositions)Enum.valueOf(TabsPositions.class, (String)string2);
        }

        public static TabsPositions[] values() {
            return (TabsPositions[])$VALUES.clone();
        }
    }

    public static final class UrlBarHide
    extends Enum<UrlBarHide> {
        private static final /* synthetic */ UrlBarHide[] $VALUES;
        public static final /* enum */ UrlBarHide DISABLED;
        public static final /* enum */ UrlBarHide ENABLED;

        static {
            ENABLED = new UrlBarHide();
            DISABLED = new UrlBarHide();
            UrlBarHide[] arrurlBarHide = new UrlBarHide[]{ENABLED, DISABLED};
            $VALUES = arrurlBarHide;
        }

        public static UrlBarHide valueOf(String string2) {
            return (UrlBarHide)Enum.valueOf(UrlBarHide.class, (String)string2);
        }

        public static UrlBarHide[] values() {
            return (UrlBarHide[])$VALUES.clone();
        }
    }

    public static final class UrlBarStates
    extends Enum<UrlBarStates> {
        private static final /* synthetic */ UrlBarStates[] $VALUES;
        public static final /* enum */ UrlBarStates DISABLED;
        public static final /* enum */ UrlBarStates ENABLED;
        public static final /* enum */ UrlBarStates ENABLED_ON_EXTERNAL_URLS;

        static {
            ENABLED = new UrlBarStates();
            ENABLED_ON_EXTERNAL_URLS = new UrlBarStates();
            DISABLED = new UrlBarStates();
            UrlBarStates[] arrurlBarStates = new UrlBarStates[]{ENABLED, ENABLED_ON_EXTERNAL_URLS, DISABLED};
            $VALUES = arrurlBarStates;
        }

        public static UrlBarStates valueOf(String string2) {
            return (UrlBarStates)Enum.valueOf(UrlBarStates.class, (String)string2);
        }

        public static UrlBarStates[] values() {
            return (UrlBarStates[])$VALUES.clone();
        }
    }

    public static final class UrlBarStyles
    extends Enum<UrlBarStyles> {
        private static final /* synthetic */ UrlBarStyles[] $VALUES;
        public static final /* enum */ UrlBarStyles BOTTOM;
        public static final /* enum */ UrlBarStyles TOP;

        static {
            TOP = new UrlBarStyles();
            BOTTOM = new UrlBarStyles();
            UrlBarStyles[] arrurlBarStyles = new UrlBarStyles[]{TOP, BOTTOM};
            $VALUES = arrurlBarStyles;
        }

        public static UrlBarStyles valueOf(String string2) {
            return (UrlBarStyles)Enum.valueOf(UrlBarStyles.class, (String)string2);
        }

        public static UrlBarStyles[] values() {
            return (UrlBarStyles[])$VALUES.clone();
        }
    }

}

