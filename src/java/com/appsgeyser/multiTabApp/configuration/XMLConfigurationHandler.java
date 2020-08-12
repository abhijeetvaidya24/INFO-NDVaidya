/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appsgeyser.multiTabApp.MainNavigationActivity
 *  com.appsgeyser.multiTabApp.configuration.UrlBarIcon
 *  com.appsgeyser.multiTabApp.configuration.UrlBarMenuLinkButton
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.xml.sax.Attributes
 *  org.xml.sax.SAXException
 *  org.xml.sax.helpers.DefaultHandler
 */
package com.appsgeyser.multiTabApp.configuration;

import com.appsgeyser.multiTabApp.MainNavigationActivity;
import com.appsgeyser.multiTabApp.configuration.IncludeScriptConfigEntity;
import com.appsgeyser.multiTabApp.configuration.UrlBarIcon;
import com.appsgeyser.multiTabApp.configuration.UrlBarMenuButton;
import com.appsgeyser.multiTabApp.configuration.UrlBarMenuLinkButton;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.controllers.WidgetsController;
import com.appsgeyser.multiTabApp.model.WidgetEntity;
import com.appsgeyser.multiTabApp.ui.views.TabContent;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLConfigurationHandler
extends DefaultHandler {
    private WidgetEntity _currentWidgetEntity;
    private StringBuilder builder;
    private String current2ndParentTag = "";
    private String currentParentTag = "";
    private Boolean inInjectJsTag;
    private Boolean scriptTagsFound;
    private WebWidgetConfiguration webWidgetConfiguration;
    private WidgetsController widgetsController;

    XMLConfigurationHandler(WebWidgetConfiguration webWidgetConfiguration, WidgetsController widgetsController) {
        Boolean bl;
        this.inInjectJsTag = bl = Boolean.valueOf((boolean)false);
        this.scriptTagsFound = bl;
        this._currentWidgetEntity = null;
        this.webWidgetConfiguration = webWidgetConfiguration;
        this.widgetsController = widgetsController;
    }

    public void characters(char[] arrc, int n2, int n3) throws SAXException {
        super.characters(arrc, n2, n3);
        String string2 = String.copyValueOf((char[])arrc, (int)n2, (int)n3).trim();
        if (string2.length() != 0) {
            this.builder.append(string2);
        }
    }

    public void endElement(String string2, String string3, String string4) throws SAXException {
        super.endElement(string2, string3, string4);
        boolean bl = string3.equalsIgnoreCase("fullScreenMode");
        Boolean bl2 = false;
        if (bl) {
            this.current2ndParentTag = "";
        } else if (!(string3.equalsIgnoreCase("registeredUrl") || string3.equalsIgnoreCase("usage") || string3.equalsIgnoreCase("locationUrl") || string3.equalsIgnoreCase("content") || string3.equalsIgnoreCase("contentProtection") || string3.equalsIgnoreCase("affiliate") || string3.equalsIgnoreCase("urlBarMenuItems"))) {
            if (this.current2ndParentTag.equalsIgnoreCase("fullScreenMode")) {
                if (this.currentParentTag.equalsIgnoreCase("content")) {
                    if (string3.equalsIgnoreCase("id")) {
                        WidgetEntity widgetEntity = this._currentWidgetEntity;
                        if (widgetEntity != null) {
                            widgetEntity.setId(this.builder.toString());
                        }
                    } else if (string3.equalsIgnoreCase("name")) {
                        WidgetEntity widgetEntity = this._currentWidgetEntity;
                        if (widgetEntity != null) {
                            widgetEntity.setName(this.builder.toString());
                        }
                    } else if (string3.equalsIgnoreCase("link")) {
                        WidgetEntity widgetEntity = this._currentWidgetEntity;
                        if (widgetEntity != null) {
                            widgetEntity.setLink(this.builder.toString());
                        }
                    } else if (string3.equalsIgnoreCase("update")) {
                        if (this._currentWidgetEntity != null) {
                            if (this.builder.toString().length() > 0) {
                                this._currentWidgetEntity.setUpdateTime(Integer.parseInt((String)this.builder.toString()));
                            } else {
                                this._currentWidgetEntity.setUpdateTime(0);
                            }
                        }
                    } else if (string3.equalsIgnoreCase("width")) {
                        WidgetEntity widgetEntity = this._currentWidgetEntity;
                        if (widgetEntity != null) {
                            widgetEntity.setWidth(Integer.parseInt((String)this.builder.toString()));
                        }
                    } else if (string3.equalsIgnoreCase("height")) {
                        WidgetEntity widgetEntity = this._currentWidgetEntity;
                        if (widgetEntity != null) {
                            widgetEntity.setHeight(Integer.parseInt((String)this.builder.toString()));
                        }
                    } else if (string3.equalsIgnoreCase("tabName")) {
                        WidgetEntity widgetEntity = this._currentWidgetEntity;
                        if (widgetEntity != null) {
                            widgetEntity.setTabName(this.builder.toString());
                        }
                    } else if (string3.equalsIgnoreCase("tabIcon")) {
                        WidgetEntity widgetEntity = this._currentWidgetEntity;
                        if (widgetEntity != null) {
                            widgetEntity.setTabIcon(this.builder.toString());
                        }
                    } else if (string3.equalsIgnoreCase("injectJS")) {
                        if (this._currentWidgetEntity != null && !this.scriptTagsFound.booleanValue()) {
                            this._currentWidgetEntity.setInjectJS(this.builder.toString());
                        }
                        this.scriptTagsFound = bl2;
                        this.inInjectJsTag = bl2;
                    } else if (string3.equalsIgnoreCase("loadingCurtain")) {
                        if (this._currentWidgetEntity != null) {
                            String string5 = this.builder.toString();
                            WidgetEntity.LoadingCurtainType loadingCurtainType = WidgetEntity.LoadingCurtainType.NONE;
                            if (string5.compareToIgnoreCase("none") == 0) {
                                loadingCurtainType = WidgetEntity.LoadingCurtainType.NONE;
                            } else if (string5.compareToIgnoreCase("default") == 0) {
                                loadingCurtainType = WidgetEntity.LoadingCurtainType.DEFAULT;
                            } else if (string5.compareToIgnoreCase("banner") == 0) {
                                loadingCurtainType = WidgetEntity.LoadingCurtainType.BANNER;
                            } else if (string5.compareToIgnoreCase("custom") == 0) {
                                loadingCurtainType = WidgetEntity.LoadingCurtainType.CUSTOM;
                            }
                            this._currentWidgetEntity.setLoadingCurtainType(loadingCurtainType);
                        }
                    } else if (string3.equalsIgnoreCase("tabType")) {
                        if (this._currentWidgetEntity != null) {
                            String string6 = this.builder.toString();
                            TabContent.TabType tabType = TabContent.TabType.WEB;
                            if (string6.compareToIgnoreCase("web") == 0) {
                                tabType = TabContent.TabType.WEB;
                            } else if (string6.compareToIgnoreCase("pdf") == 0) {
                                tabType = TabContent.TabType.PDF;
                            }
                            this._currentWidgetEntity.setTabType(tabType.toString());
                        }
                    } else if (string3.equalsIgnoreCase("userAgent")) {
                        WidgetEntity widgetEntity = this._currentWidgetEntity;
                        if (widgetEntity != null) {
                            widgetEntity.setUserAgent(this.builder.toString());
                        }
                    } else if (string3.equalsIgnoreCase("tabId")) {
                        this._currentWidgetEntity.setTabId(this.builder.toString());
                    } else if (string3.equalsIgnoreCase("showAsTab")) {
                        this._currentWidgetEntity.setShowAsTab(this.builder.toString().equalsIgnoreCase("true"));
                    }
                }
            } else if (this.currentParentTag.equalsIgnoreCase("registeredUrl")) {
                if (string3.equalsIgnoreCase("link")) {
                    this.webWidgetConfiguration.setRegisteredUrl(this.builder.toString());
                }
            } else if (this.currentParentTag.equalsIgnoreCase("usage")) {
                if (string3.equalsIgnoreCase("link")) {
                    this.webWidgetConfiguration.setAddUsageUrl(this.builder.toString());
                }
            } else if (this.currentParentTag.equalsIgnoreCase("locationUrl")) {
                if (string3.equalsIgnoreCase("link")) {
                    this.webWidgetConfiguration.setLocationUrl(this.builder.toString());
                }
            } else if (string3.equalsIgnoreCase("id")) {
                this.webWidgetConfiguration.setApplicationId(Integer.parseInt((String)this.builder.toString().replaceAll("\n", "").replaceAll("\t", "")));
            } else if (string3.equalsIgnoreCase("widgetName")) {
                this.webWidgetConfiguration.setWidgetName(this.builder.toString());
            } else if (this.currentParentTag.equalsIgnoreCase("contentProtection")) {
                if (string3.equalsIgnoreCase("login")) {
                    this.webWidgetConfiguration.setHttpAccessLogin(this.builder.toString());
                } else if (string3.equalsIgnoreCase("password")) {
                    this.webWidgetConfiguration.setHttpAccessPassword(this.builder.toString());
                }
            } else if (string3.equalsIgnoreCase("userInterface")) {
                String string7 = this.builder.toString();
                if (string7.equals((Object)"standard")) {
                    this.webWidgetConfiguration.setApplicationMode(MainNavigationActivity.ApplicationMode.COMMON);
                } else if (string7.equals((Object)"custom")) {
                    this.webWidgetConfiguration.setApplicationMode(MainNavigationActivity.ApplicationMode.CUSTOM);
                }
            } else if (string3.equalsIgnoreCase("rateItemVisibility")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setRateItemVisibility(true);
                } else {
                    this.webWidgetConfiguration.setRateItemVisibility(false);
                }
            } else if (string3.equalsIgnoreCase("acceptCookie")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setAcceptCookie(true);
                } else {
                    this.webWidgetConfiguration.setAcceptCookie(false);
                }
            } else if (string3.equalsIgnoreCase("preventFromSleep")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setPreventFromSleep(true);
                } else {
                    this.webWidgetConfiguration.setPreventFromSleep(false);
                }
            } else if (string3.equalsIgnoreCase("showRefreshMenuItem")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setShowRefreshMenuItem(true);
                } else {
                    this.webWidgetConfiguration.setShowRefreshMenuItem(false);
                }
            } else if (string3.equalsIgnoreCase("showShareMenuItem")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setShowShareMenuItem(true);
                } else {
                    this.webWidgetConfiguration.setShowShareMenuItem(false);
                }
            } else if (string3.equalsIgnoreCase("showDownloadList")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setShowDownloadList(true);
                } else {
                    this.webWidgetConfiguration.setShowDownloadList(false);
                }
            } else if (string3.equalsIgnoreCase("showAboutMenuItem")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setShowAboutMenuItem(true);
                } else {
                    this.webWidgetConfiguration.setShowAboutMenuItem(false);
                }
            } else if (string3.equalsIgnoreCase("showInAppsMenuItem")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setShowInAppMenuItem(true);
                } else {
                    this.webWidgetConfiguration.setShowInAppMenuItem(false);
                }
            } else if (string3.equalsIgnoreCase("showExitMenuItem")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setShowExitMenuItem(true);
                } else {
                    this.webWidgetConfiguration.setShowExitMenuItem(false);
                }
            } else if (string3.equalsIgnoreCase("showSettings")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setShowSettings(true);
                } else {
                    this.webWidgetConfiguration.setShowSettings(false);
                }
            } else if (string3.equalsIgnoreCase("shareExtraLink")) {
                this.webWidgetConfiguration.setShareExtraLink(this.builder.toString());
            } else if (string3.equalsIgnoreCase("enableFullScreenBanner")) {
                this.webWidgetConfiguration.setFullscreenBannerEnabled(this.builder.toString().equalsIgnoreCase("true"));
            } else if (string3.equalsIgnoreCase("enableOnExitFullScreenBanner")) {
                this.webWidgetConfiguration.setOnExitFullscreenBannerEnabled(this.builder.toString().equalsIgnoreCase("true"));
            } else if (string3.equalsIgnoreCase("showStartupConfirmationDialog")) {
                this.webWidgetConfiguration.setShowStartupConfirmationDialog(this.builder.toString().equalsIgnoreCase("true"));
            } else if (string3.equalsIgnoreCase("enableAboutScreen")) {
                this.webWidgetConfiguration.setIsAboutScreenEnabled(this.builder.toString().equalsIgnoreCase("true"));
            } else if (string3.equalsIgnoreCase("theme")) {
                String string8 = this.builder.toString();
                if (string8.equalsIgnoreCase("ACTION_BAR")) {
                    this.webWidgetConfiguration.setApplicationTheme(WebWidgetConfiguration.ApplicationThemes.ACTION_BAR);
                } else if (string8.equalsIgnoreCase("NO_MENU")) {
                    this.webWidgetConfiguration.setApplicationTheme(WebWidgetConfiguration.ApplicationThemes.NO_MENU);
                } else {
                    this.webWidgetConfiguration.setApplicationTheme(WebWidgetConfiguration.ApplicationThemes.SLIDER);
                }
            } else if (string3.equalsIgnoreCase("enableUrlBar")) {
                WebWidgetConfiguration.UrlBarStates urlBarStates = WebWidgetConfiguration.UrlBarStates.DISABLED;
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    urlBarStates = WebWidgetConfiguration.UrlBarStates.ENABLED;
                } else if (this.builder.toString().equalsIgnoreCase("on_external_urls")) {
                    urlBarStates = WebWidgetConfiguration.UrlBarStates.ENABLED_ON_EXTERNAL_URLS;
                }
                this.webWidgetConfiguration.setUrlOverlayState(urlBarStates);
            } else if (string3.equalsIgnoreCase("enableHideUrlBar")) {
                WebWidgetConfiguration.UrlBarHide urlBarHide = WebWidgetConfiguration.UrlBarHide.ENABLED;
                if (this.builder.toString().equalsIgnoreCase("false")) {
                    urlBarHide = WebWidgetConfiguration.UrlBarHide.DISABLED;
                }
                this.webWidgetConfiguration.setUrlBarHide(urlBarHide);
            } else if (string3.equalsIgnoreCase("showSearchNotice")) {
                if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setShowSearchNotice(true);
                } else {
                    this.webWidgetConfiguration.setShowSearchNotice(false);
                }
            } else if (string3.equalsIgnoreCase("urlBarStyle")) {
                WebWidgetConfiguration.UrlBarStyles urlBarStyles = WebWidgetConfiguration.UrlBarStyles.BOTTOM;
                if (this.builder.toString().equalsIgnoreCase("top")) {
                    urlBarStyles = WebWidgetConfiguration.UrlBarStyles.TOP;
                }
                this.webWidgetConfiguration.setUrlBarStyle(urlBarStyles);
            } else if (string3.equalsIgnoreCase("tabsPosition")) {
                WebWidgetConfiguration.TabsPositions tabsPositions = WebWidgetConfiguration.TabsPositions.TOP;
                if (this.builder.toString().equalsIgnoreCase("bottom")) {
                    tabsPositions = WebWidgetConfiguration.TabsPositions.BOTTOM;
                } else if (this.builder.toString().equalsIgnoreCase("drawer")) {
                    tabsPositions = WebWidgetConfiguration.TabsPositions.DRAWER;
                } else if (this.builder.toString().equalsIgnoreCase("bottom_menu")) {
                    tabsPositions = WebWidgetConfiguration.TabsPositions.BOTTOM_MENU;
                }
                this.webWidgetConfiguration.setTabsPosition(tabsPositions);
            } else if (string3.equalsIgnoreCase("enableHideTabBar")) {
                WebWidgetConfiguration.TabsEnabledHide tabsEnabledHide = WebWidgetConfiguration.TabsEnabledHide.ENABLED;
                if (this.builder.toString().equalsIgnoreCase("false")) {
                    tabsEnabledHide = WebWidgetConfiguration.TabsEnabledHide.DISABLED;
                }
                this.webWidgetConfiguration.setTabsEnabledHide(tabsEnabledHide);
            } else if (string3.equalsIgnoreCase("publisher")) {
                this.webWidgetConfiguration.setPublisherName(this.builder.toString());
            } else if (this.currentParentTag.equalsIgnoreCase("affiliate")) {
                if (string3.equalsIgnoreCase("getString")) {
                    this.webWidgetConfiguration.setAffiliateString(this.builder.toString());
                }
            } else if (string3.equalsIgnoreCase("enableRedirection")) {
                if (this.builder.toString().equalsIgnoreCase("false")) {
                    this.webWidgetConfiguration.setIsRedirectEnabled(WebWidgetConfiguration.RedirectionTypes.NO_REDIRECT);
                } else if (this.builder.toString().equalsIgnoreCase("true")) {
                    this.webWidgetConfiguration.setIsRedirectEnabled(WebWidgetConfiguration.RedirectionTypes.REDIRECT_ALL);
                } else {
                    this.webWidgetConfiguration.setIsRedirectEnabled(WebWidgetConfiguration.RedirectionTypes.REDIRECT_EXTERNAL);
                }
            } else if (string3.equalsIgnoreCase("downloadAction")) {
                String string9 = this.builder.toString().toLowerCase();
                WebWidgetConfiguration.DownloadActions downloadActions = WebWidgetConfiguration.DownloadActions.DIALOG;
                if (string9.equals((Object)"open")) {
                    downloadActions = WebWidgetConfiguration.DownloadActions.OPEN;
                } else if (string9.equals((Object)"save")) {
                    downloadActions = WebWidgetConfiguration.DownloadActions.SAVE;
                } else if (string9.equals((Object)"dialog")) {
                    downloadActions = WebWidgetConfiguration.DownloadActions.DIALOG;
                }
                this.webWidgetConfiguration.setDownloadAction(downloadActions);
            }
        } else {
            this.currentParentTag = "";
            if (string3.equalsIgnoreCase("content")) {
                this.widgetsController.addWidget(this._currentWidgetEntity);
                this._currentWidgetEntity = null;
            }
        }
        this.builder.setLength(0);
    }

    public void startDocument() throws SAXException {
        super.startDocument();
        this.builder = new StringBuilder();
    }

    public void startElement(String string2, String string3, String string4, Attributes attributes) throws SAXException {
        super.startElement(string2, string3, string4, attributes);
        if (string3.equalsIgnoreCase("fullScreenMode")) {
            this.current2ndParentTag = string3;
            return;
        }
        if (string3.equalsIgnoreCase("registeredUrl")) {
            this.currentParentTag = string3;
            return;
        }
        if (string3.equalsIgnoreCase("usage")) {
            this.currentParentTag = string3;
            return;
        }
        if (string3.equalsIgnoreCase("locationUrl")) {
            this.currentParentTag = string3;
            return;
        }
        if (string3.equalsIgnoreCase("content")) {
            this.currentParentTag = string3;
            this._currentWidgetEntity = new WidgetEntity();
            return;
        }
        if (string3.equalsIgnoreCase("contentProtection")) {
            this.currentParentTag = string3;
            return;
        }
        if (string3.equalsIgnoreCase("affiliate")) {
            this.currentParentTag = string3;
            return;
        }
        if (string3.equalsIgnoreCase("injectJS")) {
            this.inInjectJsTag = true;
            return;
        }
        if (string3.equalsIgnoreCase("script")) {
            String string5 = attributes.getValue("pattern");
            String string6 = attributes.getValue("regexp");
            String string7 = attributes.getValue("file");
            if (string7 != null && this._currentWidgetEntity != null && this.inInjectJsTag.booleanValue()) {
                this._currentWidgetEntity.addScript(new IncludeScriptConfigEntity(string5, string6, string7));
                this.scriptTagsFound = true;
                return;
            }
        } else {
            String string8;
            if (string3.equalsIgnoreCase("urlBarMenuItems")) {
                this.currentParentTag = string3;
                return;
            }
            if (this.currentParentTag.equalsIgnoreCase("urlBarMenuItems") && string3.equalsIgnoreCase("button")) {
                String string9 = attributes.getValue("name");
                if (string9.equalsIgnoreCase("back")) {
                    this.webWidgetConfiguration.addUrlBarMenuButton(new UrlBarMenuButton(UrlBarMenuButton.UrlBarMenuButtonTypes.BACK));
                    return;
                }
                if (string9.equalsIgnoreCase("forward")) {
                    this.webWidgetConfiguration.addUrlBarMenuButton(new UrlBarMenuButton(UrlBarMenuButton.UrlBarMenuButtonTypes.FORWARD));
                    return;
                }
                if (string9.equalsIgnoreCase("refresh")) {
                    this.webWidgetConfiguration.addUrlBarMenuButton(new UrlBarMenuButton(UrlBarMenuButton.UrlBarMenuButtonTypes.REFRESH));
                    return;
                }
                if (string9.equalsIgnoreCase("request_desktop")) {
                    this.webWidgetConfiguration.addUrlBarMenuButton(new UrlBarMenuButton(UrlBarMenuButton.UrlBarMenuButtonTypes.REQUEST_DESKTOP));
                    return;
                }
                if (string9.equalsIgnoreCase("add_to_home")) {
                    this.webWidgetConfiguration.addUrlBarMenuButton(new UrlBarMenuButton(UrlBarMenuButton.UrlBarMenuButtonTypes.ADD_TO_HOME));
                    return;
                }
                if (string9.equalsIgnoreCase("home")) {
                    this.webWidgetConfiguration.addUrlBarMenuButton(new UrlBarMenuButton(UrlBarMenuButton.UrlBarMenuButtonTypes.HOME));
                    return;
                }
                if (string9.equalsIgnoreCase("downloads_list")) {
                    this.webWidgetConfiguration.addUrlBarMenuButton(new UrlBarMenuButton(UrlBarMenuButton.UrlBarMenuButtonTypes.DOWNLOADS_LIST));
                    return;
                }
                if (string9.equalsIgnoreCase("link")) {
                    String string10 = attributes.getValue("title");
                    String string11 = attributes.getValue("url");
                    this.webWidgetConfiguration.addUrlBarMenuButton((UrlBarMenuButton)new UrlBarMenuLinkButton(string10, string11));
                    return;
                }
                if (string9.equalsIgnoreCase("icon")) {
                    String string12 = attributes.getValue("title");
                    String string13 = attributes.getValue("url");
                    String string14 = attributes.getValue("icon");
                    this.webWidgetConfiguration.addUrlBarMenuButton((UrlBarMenuButton)new UrlBarIcon(string12, string13, string14));
                    return;
                }
            } else if (string3.equalsIgnoreCase("splashScreen") && (string8 = attributes.getValue("image")) != null) {
                this.webWidgetConfiguration.setSplashScreen(string8);
            }
        }
    }
}

