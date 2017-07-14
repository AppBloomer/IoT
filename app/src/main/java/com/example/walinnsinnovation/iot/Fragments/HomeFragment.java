package com.example.walinnsinnovation.iot.Fragments;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.walinnsinnovation.iot.Adapter.HomeAdapter;

import com.example.walinnsinnovation.iot.ClientScanResult;
import com.example.walinnsinnovation.iot.MyApp;
import com.example.walinnsinnovation.iot.R;
import com.example.walinnsinnovation.iot.Singleton.HomeSettings;
import com.flurry.android.FlurryAgent;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.mixpanel.android.mpmetrics.MixpanelAPI;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import io.xlink.wifi.sdk.XDevice;
import io.xlink.wifi.sdk.XlinkAgent;
import io.xlink.wifi.sdk.XlinkCode;
import io.xlink.wifi.sdk.bean.DataPoint;
import io.xlink.wifi.sdk.listener.ConnectDeviceListener;
import io.xlink.wifi.sdk.listener.GetSubscribeKeyListener;
import io.xlink.wifi.sdk.listener.SendPipeListener;
import io.xlink.wifi.sdk.listener.SubscribeDeviceListener;
import io.xlink.wifi.sdk.util.MyLog;

import static android.content.ContentValues.TAG;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.containerfive;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.containerfour;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.containerthree;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.containertwo;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.frameLayout;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.tab_fg;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.toolbar;

/**
 * Created by walinnsinnovation on 27/06/17.
 */

public class HomeFragment extends Fragment {
    View view;
    ViewPager viewPager;
    public static TabLayout tabLayout;
    ProgressBar progress;
    private Tracker mTracker;
    public static final String MIXPANEL_TOKEN = "964a8ccdd95636ea66e0a999eb96753b";
    FrameLayout tabs_frag;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        view = inflater.inflate(R.layout.home_frag_main, container, false);
        System.out.println("CLIKED_Frag"+"onCreate");
        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        progress=(ProgressBar)view.findViewById(R.id.progress);
        tabLayout = (TabLayout)view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(getActivity().getResources().getColor(R.color.white), getActivity().getResources().getColor(R.color.white));
        setupViewPager(viewPager);
        tabs_frag=(FrameLayout)view.findViewById(R.id.tab_frag);
        MyApp mApplication = (MyApp)getActivity().getApplication();
        mTracker = mApplication.getDefaultTracker();

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                System.out.println("TABLAYOUT_VIEW"+"...."+position);

                if(position==0) {
                    sendScreenImageName("Suite");

                }else {
                    sendScreenImageName("Device");

                }
            }
        });
        MixpanelAPI mixpanel = MixpanelAPI.getInstance(getActivity(), MIXPANEL_TOKEN);
        mixpanel.getDeviceInfo();
        mixpanel.getSuperProperties();
        System.out.println("MixPanelData"+mixpanel.getPeople());
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Logged in", true);
            mixpanel.track("MainActivity - onCreate called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
        mixpanel.getPeople();
        FlurryAgent.onPageView();

        return view;
    }




    @Override
    public void onStart() {
        super.onStart();
        System.out.println("CLIKED_Frag"+"onStart");

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new SuitsFragment(), "Suite");
        adapter.addFragment(new DeviceFragment(), "Device");
        viewPager.setAdapter(adapter);


    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("CLIKED_Frag"+"onResume");


    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            System.out.println("ViewPager title_item"+title);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    private void sendScreenImageName(String title) {
        String name = title;
        Log.i("HomeActivity", "Setting screen name: " + name);
        mTracker.setScreenName("Image~" + name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }


}
