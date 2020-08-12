/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  java.io.InputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  javax.xml.parsers.SAXParser
 *  javax.xml.parsers.SAXParserFactory
 *  org.xml.sax.helpers.DefaultHandler
 */
package com.appsgeyser.multiTabApp.configuration;

import android.content.Context;
import android.content.res.Resources;
import com.appsgeyser.multiTabApp.Factory;
import com.appsgeyser.multiTabApp.configuration.WebWidgetConfiguration;
import com.appsgeyser.multiTabApp.configuration.XMLConfigurationHandler;
import com.appsgeyser.multiTabApp.controllers.WidgetsController;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

public class XMLConfigurationParser {
    private Context context;

    public XMLConfigurationParser(Context context) {
        this.context = context;
    }

    private InputStream getConfigurationStream() throws Exception {
        try {
            InputStream inputStream = this.context.getResources().openRawResource(2131689472);
            return inputStream;
        }
        catch (Exception exception) {
            throw new Exception("Couldn't find configuration file");
        }
    }

    public WebWidgetConfiguration parse() throws Exception {
        SAXParserFactory sAXParserFactory = SAXParserFactory.newInstance();
        try {
            WidgetsController widgetsController = Factory.getInstance().getWidgetsController();
            WebWidgetConfiguration webWidgetConfiguration = new WebWidgetConfiguration();
            widgetsController.removeAll();
            SAXParser sAXParser = sAXParserFactory.newSAXParser();
            XMLConfigurationHandler xMLConfigurationHandler = new XMLConfigurationHandler(webWidgetConfiguration, widgetsController);
            sAXParser.parse(this.getConfigurationStream(), (DefaultHandler)xMLConfigurationHandler);
            return webWidgetConfiguration;
        }
        catch (Exception exception) {
            throw new Exception("Wrong format of configuration.xml file");
        }
    }
}

