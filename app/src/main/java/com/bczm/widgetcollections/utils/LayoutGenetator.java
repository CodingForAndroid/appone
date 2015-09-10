package com.bczm.widgetcollections.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.TextView;

/**
 *  generate comman layout
 * @author：Jorge on 2015/9/10 11:57
 */
public class LayoutGenetator {

    //////////////////////////////////////////////////布局方法
    public static TextView gTextView(Context activity , int sizeRes , int colorRes,String txt ,boolean singleline){
        TextView title = new TextView(activity) ;
        title.setTextSize(TypedValue.COMPLEX_UNIT_PX,activity.getResources().getDimension(sizeRes)) ;
        title.setTextColor(activity.getResources().getColor(colorRes)) ;
        title.setText(txt) ;
        if (singleline) {
            title.setSingleLine() ;
            title.setEllipsize(TextUtils.TruncateAt.END) ;
        }
        return title ;
    }
}
