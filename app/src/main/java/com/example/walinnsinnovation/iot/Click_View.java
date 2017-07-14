package com.example.walinnsinnovation.iot;

import android.view.View;

import java.util.List;

/**
 * Created by walinnsinnovation on 29/06/17.
 */

public interface Click_View {
    public void onClick(View v, int position, List<String> wifi_list);
    //  detectDevice();



        /*
        if (mWifi.isConnected()) {
            // Do whatever
            pbHeaderProgress.setVisibility(View.VISIBLE);
            HomeSettings homeSettings=new HomeSettings("image","Lights");
            homeSettingsList.add(homeSettings);
            homeSettings=new HomeSettings("image","Camera");
            homeSettingsList.add(homeSettings);
            homeSettings=new HomeSettings("image","AC");
            homeSettingsList.add(homeSettings);
            homeSettings=new HomeSettings("image","Speaker");
            homeSettingsList.add(homeSettings);
            if(homeSettingsList.size()>0) {
                homeAdapter = new HomeAdapter(getActivity(), homeSettingsList);
                recyclerView.setAdapter(homeAdapter);
                pbHeaderProgress.setVisibility(View.GONE);

            }

        }else {
            final Dialog dialog=new Dialog(getActivity(),R.style.Theme_Dialog);
            Window window = dialog.getWindow();
            window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.CENTER);
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND); // This flag is required to set otherwise the setDimAmount method will not show any effect
            window.setDimAmount(0.5f); //0 for no dim to 1 for full dim
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
                    pbHeaderProgress.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(),"Please connect internet",Toast.LENGTH_SHORT).show();
                }
            });
            txtconnect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    dialog.dismiss();
                }
            });
            dialog.show();
        }*/
}
