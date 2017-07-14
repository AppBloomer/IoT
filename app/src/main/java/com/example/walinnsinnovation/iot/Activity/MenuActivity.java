package com.example.walinnsinnovation.iot.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.walinnsinnovation.iot.Click_View;
import com.example.walinnsinnovation.iot.Fragments.HomeFragment;
import com.example.walinnsinnovation.iot.Fragments.MyProfileFragment;
import com.example.walinnsinnovation.iot.Fragments.NotificationFragment;
import com.example.walinnsinnovation.iot.Fragments.SettingsFragment;
import com.example.walinnsinnovation.iot.Fragments.UpdateFragment;
import com.example.walinnsinnovation.iot.MainActivity;
import com.example.walinnsinnovation.iot.R;
import com.flurry.android.FlurryAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener,Click_View {
    private DrawerLayout drawerLayout;
    public static Toolbar toolbar;
    public static FrameLayout frameLayout,containertwo,containerthree,containerfour,containerfive,tab_fg;
    NavigationView navigationView;
    Dialog dialog;
    RecyclerView recyclerView;
    public static ImageView img_home;
    TextView txtlogout;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

         toolbar = (Toolbar) findViewById(R.id.toolbar);img_home=(ImageView)findViewById(R.id.img_home);
         img_home.setOnClickListener(this);
        frameLayout=(FrameLayout)findViewById(R.id.containerone);
        containertwo=(FrameLayout)findViewById(R.id.containertwo);
        containerthree=(FrameLayout)findViewById(R.id.containerthree);
        containerfour=(FrameLayout)findViewById(R.id.containerfour);
         containerfive=(FrameLayout)findViewById(R.id.containerfive);
         tab_fg=(FrameLayout)findViewById(R.id.tab_fg);

       //  E1:5A:90:5E:13:43:8C:71:7F:6F:BB:8C:19:D3:FA:C2:AB:13:AE:40
       // setSupportActionBar(toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
         txtlogout=(TextView)navigationView.findViewById(R.id.txtlogout);
         txtlogout.setOnClickListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                if (item != null && item.getItemId() == android.R.id.home) {
                    if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                        drawerLayout.closeDrawer(Gravity.RIGHT);
                    }
                    else {
                        drawerLayout.openDrawer(Gravity.RIGHT);
                    }

                }
                return false;
            }
        };
         drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //Default View
        frameLayout.setVisibility(View.VISIBLE);
        toolbar.setTitle("");
        Fragment newFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerone, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
         drawerLayout.closeDrawers();
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.recycler_only);
        recyclerView=(RecyclerView)dialog.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


         FlurryAgent.getAgentVersion();
         FlurryAgent.getSessionId();
         FlurryAgent.getReleaseVersion();
         FlurryAgent.setReportLocation(true);
         FlurryAgent.setLocation((float)11.016844,(float)76.955832);






    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homeScreen:
                frameLayout.setVisibility(View.GONE);
                containertwo.setVisibility(View.VISIBLE);
                toolbar.setTitle("");
                toolbar.setVisibility(View.VISIBLE);
                MyProfileFragment fragment = new MyProfileFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containertwo, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                drawerLayout.closeDrawers();
                 break;
            case R.id.hall:
                frameLayout.setVisibility(View.GONE);
                containertwo.setVisibility(View.GONE);
                containerthree.setVisibility(View.VISIBLE);
                toolbar.setTitle("");
                toolbar.setVisibility(View.VISIBLE);
                UpdateFragment updateFragment = new UpdateFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containerthree, updateFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.garden:
                frameLayout.setVisibility(View.GONE);
                containertwo.setVisibility(View.GONE);
                containerthree.setVisibility(View.GONE);
                containerfour.setVisibility(View.VISIBLE);
                toolbar.setTitle("");
                toolbar.setVisibility(View.VISIBLE);
                NotificationFragment notificationFragment = new NotificationFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containerfour, notificationFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.work:
                containerfive.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
                containertwo.setVisibility(View.GONE);
                containerthree.setVisibility(View.GONE);
                containerfour.setVisibility(View.GONE);
                toolbar.setTitle("");
                toolbar.setVisibility(View.VISIBLE);
                SettingsFragment settingsFragment = new SettingsFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containerfive, settingsFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_home:
                System.out.println("HOMEBUTTON"+"CLICKED"+"..."+containertwo.getVisibility()==View.VISIBLE+"..."+frameLayout.getVisibility());
                containertwo.setVisibility(View.GONE);
                containerthree.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
                toolbar.setTitle("");
                toolbar.setVisibility(View.VISIBLE);
                Fragment newFragment = new HomeFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containerone, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();

                break;
            case R.id.txtlogout:
                Intent intent=new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intent);
                break;

        }

    }

    @Override
    public void onClick(View v, final int position, final List<String> wifi_lists) {
        System.out.println("INTERFACE_ITEM"+position+"....."+wifi_lists);
        final Dialog dialog=new Dialog(this);
        dialog.setTitle(wifi_lists.get(position));
        dialog.setContentView(R.layout.wifi_connect);
        TextView txtsignal,txtcancel,txtconnect;
        final EditText edtPassword;
        txtsignal=(TextView)dialog.findViewById(R.id.txtsignal);
        txtcancel=(TextView)dialog.findViewById(R.id.txtcancel);
        txtconnect=(TextView)dialog.findViewById(R.id.txtconnect);
        edtPassword=(EditText)dialog.findViewById(R.id.txtpass);
        txtcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        txtconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
             }
        });
        dialog.show();
    }


    @Override
    protected void onStart() {
        super.onStart();
         FlurryAgent.onStartSession(this);
    }
}
