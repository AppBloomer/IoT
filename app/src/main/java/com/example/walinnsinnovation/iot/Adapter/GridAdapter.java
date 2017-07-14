package com.example.walinnsinnovation.iot.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.walinnsinnovation.iot.R;
import com.example.walinnsinnovation.iot.Singleton.HomeSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by walinnsinnovation on 01/07/17.
 */

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    List<HomeSettings>grid_items=new ArrayList<>();

    // Gets the context so it can be used later
    public GridAdapter(Context c,List<HomeSettings>grid_item_list) {
        this.mContext = c;
        this.grid_items=grid_item_list;
    }

    // Total number of things contained within the adapter
    public int getCount() {
        return grid_items.size();
    }

    // Require for structure, not really used in my code.
    public Object getItem(int position) {
        return position;
    }

    // Require for structure, not really used in my code. Can
    // be used to get the id of an item in the adapter for
    // manual control.
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.grid_layout, null);
        ImageView img_grid=(ImageView)convertView.findViewById(R.id.img_grid);
        img_grid.setImageDrawable(grid_items.get(position).getImage());
        TextView txtview=(TextView)convertView.findViewById(R.id.txtdevice);
        txtview.setText(grid_items.get(position).getText());
        System.out.println("GRID_ITEM_SIZE"+grid_items.size());


        return convertView;
    }
}