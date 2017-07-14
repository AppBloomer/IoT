package com.example.walinnsinnovation.iot.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.walinnsinnovation.iot.Activity.CommonActivity;
import com.example.walinnsinnovation.iot.Activity.LightSettings;
import com.example.walinnsinnovation.iot.Activity.PropertiesActivity;
import com.example.walinnsinnovation.iot.Adapter.GridAdapter;
import com.example.walinnsinnovation.iot.Adapter.HomeAdapter;
import com.example.walinnsinnovation.iot.R;
import com.example.walinnsinnovation.iot.Singleton.HomeSettings;
import com.flurry.android.FlurryAgent;
import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import java.util.ArrayList;
import java.util.List;

import static com.example.walinnsinnovation.iot.Activity.MenuActivity.containerfive;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.containerfour;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.containerthree;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.containertwo;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.frameLayout;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.img_home;
import static com.example.walinnsinnovation.iot.Activity.MenuActivity.toolbar;
import static com.example.walinnsinnovation.iot.Fragments.HomeFragment.tabLayout;

/**
 * Created by walinnsinnovation on 01/07/17.
 */

public class DeviceFragment extends Fragment implements View.OnClickListener {
    View view;
     List<HomeSettings> homeSettingsList = new ArrayList<>();
    HomeAdapter homeAdapter;
    GridView gridView;
    GridAdapter gridAdapter;
    LinearLayout linearLayout;
    TextView txttitle,txtaddevice,txtSubmit;
    RelativeLayout relColor;
    FloatingActionButton fab;
    Spinner spinner;
    EditText edtDeviceName;
     private String[] spinner_list;
    public static final String MIXPANEL_TOKEN = "964a8ccdd95636ea66e0a999eb96753b";
    MixpanelAPI mixpanel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        view = inflater.inflate(R.layout.recycler_view_fragment, container, false);

        mixpanel = MixpanelAPI.getInstance(getActivity(), MIXPANEL_TOKEN);

        gridView = (GridView)view.findViewById(R.id.grid_view);
        linearLayout=(LinearLayout)view.findViewById(R.id.linear_action);
        txttitle=(TextView)view.findViewById(R.id.txttitle);
        relColor=(RelativeLayout)view.findViewById(R.id.relColor);
        txtaddevice=(TextView)view.findViewById(R.id.txtaddevice);
        fab=(FloatingActionButton)view.findViewById(R.id.fab);
        img_home.setOnClickListener(this);
        fab.setOnClickListener(this);
      //  img_home.setOnClickListener(this);
        System.out.println("DEVICEFRAGMENT"+"DEVICE_FRAG");
        Toast.makeText(getActivity(),"DEVICE",Toast.LENGTH_SHORT).show();
        setAdapter();


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView)view.findViewById(R.id.txtdevice);
                System.out.println("DEVICE_NAME"+textView.getText().toString());
                if(textView.getText().toString()!=null) {
                    getDeice(textView.getText().toString());
                }


            }
        });

        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    System.out.println("Back_Arrow_Value"+txttitle.getText().toString());
                    return true;
                }
                return false;
            }
        } );

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
    public void getDeice(String device_type) {
        linearLayout.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.GONE);
        txttitle.setText(device_type);
        FlurryAgent.logEvent(device_type);
        mixpanel.timeEvent(device_type);
        mixpanel.track(device_type);

        homeSettingsList.clear();
        switch (device_type) {
            case "Bulb":
                 HomeSettings homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Kitchen");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Hall");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Garden");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Door Lock");
                homeSettingsList.add(homeSettings);
                break;
            case "Television":
                 homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.tv), "Kitchen");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.tv), "Hall");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.tv), "Garden");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.tv), "Door Lock");
                homeSettingsList.add(homeSettings);
                break;
            case "Ac":
                 homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.ac), "Kitchen");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.ac), "Hall");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.ac), "Garden");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.ac), "Door Lock");
                homeSettingsList.add(homeSettings);
                break;
            case "Camera":
                 homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.camera), "Kitchen");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.camera), "Hall");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.camera), "Garden");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.camera), "Door Lock");
                homeSettingsList.add(homeSettings);
                break;
            case "Door Lock":
                relColor.setVisibility(View.GONE);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.lock), "Kitchen");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.lock), "Hall");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.lock), "Garden");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.lock), "Door Lock");
                homeSettingsList.add(homeSettings);
                break;
            case "Speaker":
                relColor.setVisibility(View.GONE);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.speaker), "Kitchen");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.speaker), "Hall");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.speaker), "Garden");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.speaker), "DoorLock");
                homeSettingsList.add(homeSettings);
                break;
            case "Kitchen":
                 txtaddevice.setVisibility(View.GONE);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Bulb1");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Bulb2");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Bulb3");
                homeSettingsList.add(homeSettings);

                break;
            case "Hall":

                txtaddevice.setVisibility(View.GONE);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Bulb1");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Bulb2");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Bulb3");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.tv), "Bulb3");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.ac), "Bulb3");
                homeSettingsList.add(homeSettings);
                break;
            case "Garden":
                 txtaddevice.setVisibility(View.GONE);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Bulb1");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.bulb), "Bulb2");
                homeSettingsList.add(homeSettings);
                break;
            case "Bulb1":
                Fragment newFragment = new PropertiesFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.containerone, newFragment);
                Bundle bundle=new Bundle();
                bundle.putString("title", "Bulb1");
                //set Fragmentclass Arguments
                newFragment.setArguments(bundle);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case "Bulb2":
                Intent intent=new Intent(getActivity(), PropertiesActivity.class);
                startActivity(intent);
                break;
            case "Bulb3":
                intent=new Intent(getActivity(), PropertiesActivity.class);
                startActivity(intent);
                break;




        }
        if (homeSettingsList.size() > 0) {
            gridAdapter = new GridAdapter(getActivity(), homeSettingsList);
            gridView.setAdapter(gridAdapter);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.fab:
                final Dialog dialog=new Dialog(getActivity(),R.style.Theme_Dialog);
                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                window.setGravity(Gravity.CENTER);
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND); // This flag is required to set otherwise the setDimAmount method will not show any effect
                window.setDimAmount(0.5f); //0 for no dim to 1 for full dim
                dialog.setContentView(R.layout.add_device_dialog);

                spinner=(Spinner)dialog.findViewById(R.id.spinner);
                edtDeviceName=(EditText)dialog.findViewById(R.id.edtdevicename);
                txtSubmit=(TextView)dialog.findViewById(R.id.txtSubmit);
                txtSubmit.setOnClickListener(this);
                spinner_list = new String[] {
                        "Light", "Camera", "Security devices", "Sensors","Speakers","Wifi Adaptor","Ac Controls"
                };
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, spinner_list);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                spinner.setAdapter(adapter);
                dialog.show();
                break;
            case R.id.txtSubmit:
                final TextView textView = (TextView) spinner.getSelectedView();
                String result = textView.getText().toString();
                System.out.println("SELECTED_ITEM_TEXT_onclik" + result+"....."+edtDeviceName.getText().toString());
                break;

        }

    }
    public void setAdapter(){

        HomeSettings homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.bulb), "Bulb");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.tv), "Television");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.ac), "Ac");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.camera), "Camera");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.lock), "Door Lock");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.speaker), "Speaker");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.lock), "Door Lock");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.speaker), "Speaker");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.lock), "Door Lock");
        homeSettingsList.add(homeSettings);
        homeSettings = new HomeSettings(getActivity().getResources().getDrawable(R.mipmap.speaker), "Speaker");
        homeSettingsList.add(homeSettings);
        System.out.println("DEVICEFRAGMENT_SIZE"+homeSettingsList.size());

        if (homeSettingsList.size() > 0) {
            gridAdapter=new GridAdapter(getActivity(),homeSettingsList);
            gridView.setAdapter(gridAdapter);

        }

    }

}
