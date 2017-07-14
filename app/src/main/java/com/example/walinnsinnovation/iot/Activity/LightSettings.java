package com.example.walinnsinnovation.iot.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.walinnsinnovation.iot.R;
import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

public class LightSettings extends AppCompatActivity implements View.OnClickListener, NumberPicker.OnValueChangeListener {
//    TextView txthr,txtmin,txthrvisible,txtminvisible;
//    LinearLayout lineartimer;
     private HSLColorPicker colorPicker;
     private ImageView img_color,left_arrow;
     private String[] mode_irems_list;
     Spinner s;
    RelativeLayout rel_picker;
    LinearLayout rel_repeat;
    RadioButton once,every_day,mon_fri,custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_settings_activity);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        colorPicker = (HSLColorPicker) findViewById(R.id.colorPicker);
        s = (Spinner) findViewById(R.id.spinmode);
        img_color = (ImageView) findViewById(R.id.img_color);
        rel_picker=(RelativeLayout)findViewById(R.id.rel_picker);
        left_arrow=(ImageView)findViewById(R.id.left_arrow);
        rel_repeat=(LinearLayout)findViewById(R.id.rel_repeat);
        rel_repeat.setOnClickListener(this);
        left_arrow.setOnClickListener(this);


//        txthr=(TextView)findViewById(R.id.txthr);
//        txtmin=(TextView)findViewById(R.id.txtmin);
//        txthrvisible=(TextView)findViewById(R.id.txthrvisible);
//        txtminvisible=(TextView)findViewById(R.id.txtminvisible);
//        lineartimer=(LinearLayout)findViewById(R.id.lineartimer);
//        lineartimer.setOnClickListener(this);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//


        mode_irems_list = new String[] {
                "Day", "Night", "Read", "Custom"
        };
//        Spinner s = (Spinner) findViewById(R.id.spinmode);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, mode_irems_list);
        //s.setAdapter(adapter);

        ArrayAdapter spinClockInWorkSiteAdapter = new ArrayAdapter(this, R.layout.spinner_item, mode_irems_list);
        s.setAdapter(spinClockInWorkSiteAdapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final TextView textView = (TextView)s.getSelectedView();
                String result = textView.getText().toString();
                System.out.println("SELECTED_ITEM_TEXT"+result);
                setSPinner(result,textView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener() {
            @Override
            public void onColorSelected(int color) {
                // Do whatever you want with the color
                img_color.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
            }
        });

//        if(once.isChecked()){
//            every_day.setChecked(false);
//            custom.setChecked(false);
//            mon_fri.setChecked(false);
//        }else if(custom.isChecked()){
//            every_day.setChecked(false);
//            once.setChecked(false);
//            mon_fri.setChecked(false);
//        }else if(every_day.isChecked()){
//            once.setChecked(false);
//            custom.setChecked(false);
//            mon_fri.setChecked(false);
//        }else if(mon_fri.isChecked()){
//            once.setChecked(false);
//            custom.setChecked(false);
//            every_day.setChecked(false);
//        }





    }

    private void setSPinner(String result, final TextView textView) {
        if(result!=null){
            textView.setPadding(0,0,0,1);
        }
        switch (result){
            case "Custom":
                rel_picker.setVisibility(View.VISIBLE);
                break;
            default:
                rel_picker.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.lineartimer:
////                final Dialog d = new Dialog(LightSettings.this);
////                d.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
////                d.setContentView(R.layout.number_picker);
////                final NumberPicker numberPickerHr = (NumberPicker) d.findViewById(R.id.numberPickerHr);
////                final NumberPicker numberPickerMin = (NumberPicker) d.findViewById(R.id.numberPickerMin);
////                numberPickerHr.setMaxValue(24);
////                numberPickerHr.setMinValue(0);
////                numberPickerHr.setWrapSelectorWheel(false);
////                numberPickerHr.setOnValueChangedListener(this);
////                numberPickerMin.setMaxValue(60);
////                numberPickerMin.setMinValue(0);
////                numberPickerMin.setWrapSelectorWheel(false);
////                numberPickerMin.setOnValueChangedListener(this);
////                d.show();
//
//                Intent intent=new Intent(LightSettings.this,ColorPicker.class);
//                startActivity(intent);
//                break;
            case R.id.left_arrow:
                finish();
                break;
            case R.id.rel_repeat:
                final Dialog d = new Dialog(LightSettings.this);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE); //before
                d.setContentView(R.layout.repeat_mode_item);
                once=(RadioButton)d.findViewById(R.id.btnradio1);
                every_day=(RadioButton)d.findViewById(R.id.btnradio2);
                mon_fri=(RadioButton)d.findViewById(R.id.btnradio3);
                custom=(RadioButton)d.findViewById(R.id.btnradio4);
                System.out.println("RADIO_BUTTON_CHECKED"+once.isChecked());


                d.show();
                break;
        }
    }

    private void radioButton(View v) {
        switch (v.getId()){
            case R.id.btnradio1:
                if(((RadioButton) v).isChecked()){
                    System.out.println("FIRST_CHECKED"+"(((((");
                }
                break;
        }
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        System.out.println("TIMERVALUE"+ oldVal+".....new"+ newVal+"...");
        switch (picker.getId()){
            case R.id.numberPickerHr:
                System.out.println("TIMERVALUEHRR"+ oldVal+".....new"+ newVal+"...");

                break;
            case R.id.numberPickerMin:
                System.out.println("TIMERVALUEMINNN"+ oldVal+".....new"+ newVal+"...");

                break;
        }
    }
}
