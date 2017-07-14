package com.example.walinnsinnovation.iot.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.walinnsinnovation.iot.Adapter.HomeAdapter;
import com.example.walinnsinnovation.iot.Adapter.LightsAdapter;
import com.example.walinnsinnovation.iot.MyApp;
import com.example.walinnsinnovation.iot.R;

import java.util.ArrayList;
import java.util.List;

public class LightActivity extends AppCompatActivity implements View.OnClickListener {
    List<String> lights_list=new ArrayList<>();
    RecyclerView recyclerView;
    LightsAdapter adapter;
    ImageView left_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        left_arrow=(ImageView)findViewById(R.id.left_arrow);
        left_arrow.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lights_list.add("Light one");
        lights_list.add("Light two");
        lights_list.add("Light three");
        if(lights_list.size()>0) {
            adapter = new LightsAdapter(this, lights_list,"light_act");
            recyclerView.setAdapter(adapter);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_arrow:
                finish();
                break;
        }
    }
}
