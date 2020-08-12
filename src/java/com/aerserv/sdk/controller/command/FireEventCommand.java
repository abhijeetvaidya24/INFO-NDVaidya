/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package com.aerserv.sdk.controller.command;

import android.os.AsyncTask;
import com.aerserv.sdk.controller.command.Command;
import com.aerserv.sdk.http.HttpTask;
import com.aerserv.sdk.http.HttpTaskListener;
import com.aerserv.sdk.model.vast.TrackingEvent;
import com.aerserv.sdk.model.vast.TrackingEvents;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.AerServTestEventNotificationCenter;
import com.aerserv.sdk.utils.UrlBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FireEventCommand
implements Command {
    private List<String> events = new ArrayList();

    public FireEventCommand(TrackingEvent trackingEvent) {
        this.events.add((Object)trackingEvent.getTrackingUri());
    }

    public FireEventCommand(TrackingEvents trackingEvents) {
        Iterator iterator = trackingEvents.iterator();
        while (iterator.hasNext()) {
            TrackingEvent trackingEvent = (TrackingEvent)iterator.next();
            this.events.add((Object)trackingEvent.getTrackingUri());
        }
    }

    public FireEventCommand(String string) {
        this.events.add((Object)string);
    }

    public FireEventCommand(List<String> list) {
        this.events = list;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void execute() {
        var1_1 = this.events;
        if (var1_1 == null) return;
        var2_2 = var1_1.iterator();
        block2 : do {
            if (var2_2.hasNext() == false) return;
            var3_3 = (String)var2_2.next();
            var4_4 = this.getClass().getSimpleName();
            var5_5 = new StringBuilder();
            var5_5.append("Firing event ");
            var5_5.append(var3_3);
            AerServLog.d(var4_4, var5_5.toString());
            try {
                if (var3_3.contains((CharSequence)"ev=") && var3_3.contains((CharSequence)"?")) {
                    var10_7 = new StringBuilder();
                    var10_7.append(var3_3);
                    var10_7.append(UrlBuilder.SESSION_ID_URL_PARAMTER);
                    var3_3 = var10_7.toString();
                    var13_8 = new HashMap();
                    var14_9 = var3_3.substring(1 + var3_3.indexOf("?")).split("&");
                    var15_10 = var14_9.length;
                    var16_11 = 0;
                }
                ** GOTO lbl34
            }
            catch (Exception var8_6) {
                var8_6.printStackTrace();
                ** GOTO lbl34
            }
            do {
                if (var16_11 < var15_10) {
                    var17_12 = var14_9[var16_11].split("=");
                    if (var17_12.length == 2) {
                        var13_8.put((Object)var17_12[0], (Object)var17_12[1]);
                    }
                } else {
                    AerServTestEventNotificationCenter.fireAdvertiserEvent((Map<String, String>)var13_8);
lbl34: // 3 sources:
                    new HttpTask(var3_3, null).execute(new Object[0]);
                    continue block2;
                }
                ++var16_11;
            } while (true);
            break;
        } while (true);
    }
}

