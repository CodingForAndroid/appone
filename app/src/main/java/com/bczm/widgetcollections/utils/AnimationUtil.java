package com.bczm.widgetcollections.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * 位移动画
 * @author：Jorge on 2015/9/1 16:51
 */
public  class AnimationUtil {

    private  static TranslateAnimation   right;
    private   static TranslateAnimation    left;
    public  static  void runAnimation(final View view){
        right = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, -1f,
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT,
                0f);
        left = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1f,
                Animation.RELATIVE_TO_PARENT, 0f, Animation.RELATIVE_TO_PARENT,
                0f, Animation.RELATIVE_TO_PARENT, 0f);
        right.setDuration(25000);
        left.setDuration(25000);
        right.setFillAfter(true);
        left.setFillAfter(true);

        right.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                view.startAnimation(left);
            }
        });
        left.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub
                view.startAnimation(right);
            }
        });
        view.startAnimation(right);
    }

    public  static  void stopAnimation( View view){
//        if(right!=null&&left!=null){
//            view.clearAnimation();
//        }
    }
}
