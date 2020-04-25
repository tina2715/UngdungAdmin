package com.udgs123.ungdungadmin;

import android.app.Application;
import android.os.SystemClock;

public class SleepSplashScreen extends Application {
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(2000);
    }
}
