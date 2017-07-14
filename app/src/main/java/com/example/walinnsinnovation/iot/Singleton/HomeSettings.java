package com.example.walinnsinnovation.iot.Singleton;

import android.graphics.drawable.Drawable;

/**
 * Created by walinnsinnovation on 27/06/17.
 */

public class HomeSettings {
    Drawable image;
    String text;
    public HomeSettings(Drawable image_,String text_){
        this.image=image_;
        this.text=text_;

    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
