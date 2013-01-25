package com.merguez.apps.tripletriad;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;


public class ExpandAnimation extends Animation {
    
    int targetHeight;
    View view;
    boolean down;
    
    /**
     * Initialize the animation
     * @param view The layout we want to animate
     * @param duration The duration of the animation, in ms
     */
    public ExpandAnimation(Context context, View view, int targetHeight, boolean down) {
        this.view = view;
        this.targetHeight = targetHeight;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.targetHeight = (int)((targetHeight * displayMetrics.density) + 0.5);

        this.down = down;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        int newHeight;
        if (down) {
            newHeight = (int) (targetHeight * interpolatedTime);
        } else {
            newHeight = (int) (targetHeight * (1 - interpolatedTime));
        }
        view.getLayoutParams().height = newHeight;
        Log.d("merguez", interpolatedTime+": "+view.getLayoutParams().height);
        view.requestLayout();
    }
    
    @Override
    public boolean willChangeBounds() {
        return true;
    }

}

