/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Timer
 *  java.util.TimerTask
 */
package com.amazon.device.ads;

import java.util.Timer;
import java.util.TimerTask;

class AdTimer {
    private Timer timer;

    AdTimer() {
    }

    public void cancelTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
    }

    public void restartTimer() {
        this.cancelTimer();
        this.timer = new Timer();
    }

    public void scheduleTask(TimerTask timerTask, long l2) {
        this.timer.schedule(timerTask, l2);
    }
}

