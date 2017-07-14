package com.example.walinnsinnovation.iot.Fragments;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.walinnsinnovation.iot.R;
import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

/**
 * Created by walinnsinnovation on 12/07/17.
 */

public class PropertiesFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    View view;
    private HSLColorPicker colorPicker;
    ImageView img_color;
    ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5;
    ScrollView scrollView;
    TextView textView,txttitle;
    Spinner spinner;
    private String[] arraySpinner;
    SeekBar seekbar;
    LinearLayout linear_start_timer,linear_end_timer;
    int hour,min;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        view = inflater.inflate(R.layout.properties_frag, container, false);
        img_color = (ImageView)view.findViewById(R.id.img_color);

        colorPicker = (HSLColorPicker) view.findViewById(R.id.colorPicker);
        imageButton1=(ImageButton)view. findViewById(R.id.imageButton1);
        imageButton2=(ImageButton)view. findViewById(R.id.imageButton2);
        imageButton3=(ImageButton)view. findViewById(R.id.imageButton3);
        imageButton4=(ImageButton)view. findViewById(R.id.imageButton4);
        imageButton5=(ImageButton)view. findViewById(R.id.imageButton5);
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener() {
            @Override
            public void onColorSelected(int color) {
                // Do whatever you want with the color
                img_color.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
            }
        });
       // scrollView=(ScrollView)view.findViewById(R.id.scroll_view);
        textView=(TextView)view.findViewById(R.id.textscroll);
        spinner=(Spinner)view.findViewById(R.id.spinner);
        seekbar=(SeekBar)view.findViewById(R.id.seekBar1);
        txttitle=(TextView)view.findViewById(R.id.txttitle);
        seekbar.setOnSeekBarChangeListener(this);
        linear_start_timer=(LinearLayout)view.findViewById(R.id.linear_start_timer);
        linear_end_timer=(LinearLayout)view.findViewById(R.id.linear_end_timer);
        linear_start_timer.setOnClickListener(this);
        linear_end_timer.setOnClickListener(this);
        this.arraySpinner = new String[] {
                "Phone", "Externel Strorage", "Bluetooth", "others"
        };
        if(getArguments()!=null){
            if(getArguments().getString("title")!=null){
                txttitle.setText(getArguments().getString("title"));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.linear_start_timer:

                TimePickerDialog.OnTimeSetListener mTimeSetListenerIni =
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(android.widget.TimePicker view,
                                                  int hourOfDay, int minute) {
                                Log.i("","Initial: "+hourOfDay+":"+minute);
                                hour=hourOfDay;
                                min=minute;
                            }
                        };

                TimePickerDialog yourFragment = new TimePickerDialog(getActivity(), mTimeSetListenerIni, hour, min, true);
                yourFragment.setButton(DialogInterface.BUTTON_POSITIVE, "OK", yourFragment);
                yourFragment.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", yourFragment);

                break;
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
