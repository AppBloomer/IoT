package com.example.walinnsinnovation.iot.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.walinnsinnovation.iot.Adapter.GridAdapter;
import com.example.walinnsinnovation.iot.R;
import com.example.walinnsinnovation.iot.Singleton.HomeSettings;

import java.util.ArrayList;
import java.util.List;

public class CommonActivity extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;
    String device_type;
    ImageView img_back_arrow;
    TextView txttitle;
    List<HomeSettings> homeSettingsList = new ArrayList<>();
    GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        gridView=(GridView)findViewById(R.id.grid_view);
        if(getIntent().getStringExtra("device_type")!=null){
            device_type=getIntent().getStringExtra("device_type");
        }
        img_back_arrow=(ImageView) findViewById(R.id.img_back_arrow);
        img_back_arrow.setOnClickListener(this);
        txttitle=(TextView) findViewById(R.id.txttitle);

        if(device_type!=null) {
            txttitle.setText(device_type);
            getDeice(device_type);
        }

        if (homeSettingsList.size() > 0) {
            gridAdapter=new GridAdapter(this,homeSettingsList);
            gridView.setAdapter(gridAdapter);

        }

    }
    public void getDeice(String device_type){
        switch (device_type){
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
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.speaker), "Kitchen");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.speaker), "Hall");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.speaker), "Garden");
                homeSettingsList.add(homeSettings);
                homeSettings = new HomeSettings(getResources().getDrawable(R.mipmap.speaker), "Door Lock");
                homeSettingsList.add(homeSettings);
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_arrow:
                finish();
                break;
        }
    }
}
