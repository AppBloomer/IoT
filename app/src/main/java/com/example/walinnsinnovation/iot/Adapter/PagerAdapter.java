package com.example.walinnsinnovation.iot.Adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.walinnsinnovation.iot.R;

/**
 * Created by walinnsinnovation on 27/06/17.
 */

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    private int mSampleDurationTime = 1000; // 1 sec
    private boolean continueToRun = true;
    Handler mHandler;
    public PagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_layout, container, false);
        final ImageView image_view=(ImageView)itemView.findViewById(R.id.image_view);

        System.out.println("Position_value"+position);
        if(position==0){
            image_view.setBackgroundResource(R.drawable.anim_demo);

            image_view.post(new Runnable() {
                @Override
                public void run() {
                    AnimationDrawable frameAnimation =
                            (AnimationDrawable) image_view.getBackground();
                    frameAnimation.start();
                }
            });
        }else if(position==1){
            image_view.setBackgroundResource(R.drawable.anim_s);

            image_view.post(new Runnable() {
                @Override
                public void run() {
                    AnimationDrawable frameAnimation =
                            (AnimationDrawable) image_view.getBackground();
                    frameAnimation.start();
                }
            });
        }else if(position==2)
        {
            image_view.setBackgroundResource(R.drawable.anim_t);

            image_view.post(new Runnable() {
                @Override
                public void run() {
                    AnimationDrawable frameAnimation =
                            (AnimationDrawable) image_view.getBackground();
                    frameAnimation.start();
                }
            });
        }






        container.addView(itemView);

        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}