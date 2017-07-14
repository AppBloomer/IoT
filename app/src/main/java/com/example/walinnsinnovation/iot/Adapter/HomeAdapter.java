package com.example.walinnsinnovation.iot.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.walinnsinnovation.iot.Activity.LightActivity;
import com.example.walinnsinnovation.iot.R;
import com.example.walinnsinnovation.iot.Singleton.HomeSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walinnsinnovation on 27/06/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    LayoutInflater mInflater;
    List<HomeSettings> homeSettingsList=new ArrayList<>();
    Context context;
    public HomeAdapter(Context context, List<HomeSettings> homeSettingsList_){
        this.context=context;
        this.homeSettingsList=homeSettingsList_;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.home_fragment, null, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.myTextView.setText(homeSettingsList.get(position).getText());
        holder.relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(homeSettingsList.get(position).getText().equals("Lights")){
                    Intent intent=new Intent(context, LightActivity.class);
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
        RelativeLayout relativelayout;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.myImageViewText);
            relativelayout=(RelativeLayout)itemView.findViewById(R.id.relativelayout);

        }


    }
}
