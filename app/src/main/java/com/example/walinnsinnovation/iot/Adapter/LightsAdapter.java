package com.example.walinnsinnovation.iot.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.walinnsinnovation.iot.Activity.LightSettings;
import com.example.walinnsinnovation.iot.Click_View;
import com.example.walinnsinnovation.iot.R;
import com.example.walinnsinnovation.iot.Singleton.HomeSettings;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by walinnsinnovation on 27/06/17.
 */

public class LightsAdapter extends RecyclerView.Adapter<LightsAdapter.ViewHolder> {
    LayoutInflater mInflater;
    List<String> homeSettingsList=new ArrayList<>();
    Context context;
    String come_from;
    Click_View click_view;
    public LightsAdapter(Context context, List<String> homeSettingsList_,String come_from_){
        this.context=context;
        this.homeSettingsList=homeSettingsList_;
        this.come_from=come_from_;
        click_view = (Click_View) context;

    }

    @Override
    public LightsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.lights_item, null, false);
        return new LightsAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(LightsAdapter.ViewHolder holder, final int position) {
        System.out.println("WIFILIST_ada"+homeSettingsList.get(position));
        holder.myTextView.setText(homeSettingsList.get(position));
        holder.myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(come_from.equals("wifi")){
//
//                    connectWifi(homeSettingsList.get(position));
                    click_view.onClick(v,position,homeSettingsList);


                }else {
                    Intent intent = new Intent(context, LightSettings.class);
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeSettingsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView myTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.txtlight);

        }


    }

}
