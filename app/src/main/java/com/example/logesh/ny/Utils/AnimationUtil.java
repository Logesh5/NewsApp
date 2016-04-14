package com.example.logesh.ny.Utils;

import android.support.v7.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by logesh on 14-04-2016.
 */
public class AnimationUtil {

    public static void animate(RecyclerView.ViewHolder holder) {
        YoYo.with(Techniques.ZoomIn).duration(1000).playOn(holder.itemView);
    }
}
