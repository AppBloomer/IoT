package com.example.walinnsinnovation.iot.Activity;

import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.walinnsinnovation.iot.R;
import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

import java.util.Random;

public class ColorPicker extends AppCompatActivity   {
         ImageView img_anim;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sample);
            img_anim=(ImageView)findViewById(R.id.img_anim);
            img_anim.setBackgroundResource(R.drawable.anim_demo);
            AnimationDrawable anim = (AnimationDrawable) img_anim.getBackground();
            anim.start();

        }



}
