package com.example.walinnsinnovation.iot.Activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.walinnsinnovation.iot.R;
import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

public class PropertiesActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private HSLColorPicker colorPicker;
    ImageView img_color;
    ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5;
    ScrollView scrollView;
    TextView textView;
    Spinner spinner;
    private String[] arraySpinner;
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);
        img_color = (ImageView) findViewById(R.id.img_color);

        colorPicker = (HSLColorPicker) findViewById(R.id.colorPicker);
        imageButton1=(ImageButton) findViewById(R.id.imageButton1);
        imageButton2=(ImageButton) findViewById(R.id.imageButton2);
        imageButton3=(ImageButton) findViewById(R.id.imageButton3);
        imageButton4=(ImageButton) findViewById(R.id.imageButton4);
        imageButton5=(ImageButton) findViewById(R.id.imageButton5);
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
       // scrollView=(ScrollView)findViewById(R.id.scroll_view);
        textView=(TextView)findViewById(R.id.textscroll);
        spinner=(Spinner)findViewById(R.id.spinner);
        seekbar=(SeekBar)findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);
        this.arraySpinner = new String[] {
                "Phone", "Externel Strorage", "Bluetooth", "others"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof ImageButton){
            final int color = ((ColorDrawable) ((ImageButton) v).getDrawable()).getColor();
            img_color.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
            colorPicker.setColor(color);
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
