package com.example.walinnsinnovation.iot;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.Toast;

import com.flurry.android.FlurryAgent;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import java.util.List;

import io.xlink.wifi.sdk.XDevice;
import io.xlink.wifi.sdk.XlinkAgent;
import io.xlink.wifi.sdk.bean.DataPoint;
import io.xlink.wifi.sdk.bean.EventNotify;
import io.xlink.wifi.sdk.listener.XlinkNetListener;

/**
 * Created by walinnsinnovation on 12/07/17.
 */

public class MyApp extends Application {
    private static MyApp application;
    public static SharedPreferences sharedPreferences;
    public boolean auth=false;
    private static final String TAG = "MyApp";
    public int appid;
    public String authKey;
    public String versionName;
    public int versionCode;
    public String packageName;
    private static Handler mainHandler = null;
    private String accessToken;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;


    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("ONCREATE_MANIFEST"+"onCreate");
        sAnalytics = GoogleAnalytics.getInstance(this);
        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .build(this, "TS37ZRDVKMCRZCHG2XYV");



    }
    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }

}
