/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ironsource.mediationsdk.events.IronbeastEventsFormatter
 *  com.ironsource.mediationsdk.events.OutcomeEventsFormatter
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.ironsource.mediationsdk.events;

import com.ironsource.mediationsdk.events.AbstractEventsFormatter;
import com.ironsource.mediationsdk.events.IronbeastEventsFormatter;
import com.ironsource.mediationsdk.events.OutcomeEventsFormatter;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

class EventsFormatterFactory {
    static AbstractEventsFormatter getFormatter(String string, int n2) {
        if ("ironbeast".equals((Object)string)) {
            return new IronbeastEventsFormatter(n2);
        }
        if ("outcome".equals((Object)string)) {
            return new OutcomeEventsFormatter(n2);
        }
        if (n2 == 2) {
            return new IronbeastEventsFormatter(n2);
        }
        if (n2 == 3) {
            return new OutcomeEventsFormatter(n2);
        }
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EventsFormatterFactory failed to instantiate a formatter (type: ");
        stringBuilder.append(string);
        stringBuilder.append(", adUnit: ");
        stringBuilder.append(n2);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 2);
        return null;
    }
}

