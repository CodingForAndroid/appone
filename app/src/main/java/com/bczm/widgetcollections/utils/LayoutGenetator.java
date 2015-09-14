package com.bczm.widgetcollections.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.manager.ImageLoader;
import com.bczm.widgetcollections.ui.widget.ImageCycleView;

import java.util.ArrayList;

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



    public static  void getneratePagerView(ArrayList<RecommandPositionInfo>list,Context mActivity,RelativeLayout layout_item_container){
        ImageCycleView    mImageCycleView = new ImageCycleView(mActivity) ;
        //720 , 380
//        int width = SystemUtils.getScreenWidth(mActivity) ;
//        int heigh = LayoutGenrator.getAnoHeigh(720, 380, width) ;

        LinearLayout.LayoutParams cParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,  SystemUtils.getScreenHeight()*3/10) ;
//        mImageCycleView.setTag(R.id.id01, model.getSort()) ;
        layout_item_container.addView(mImageCycleView, cParams) ;

        ArrayList<String> mImageUrl = new ArrayList<String>();
        ArrayList<String> mImageName = new ArrayList<String>();

        for(RecommandPositionInfo info :list){
            String  url=  info.cover.split("\\?")[0];
            mImageUrl.add(url);
            mImageName.add(info.title);
        }

        ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
            @Override
            public void onImageClick(int position, View imageView) {
//                setRecommandEvent(imageView, model.getData().get(position), mActivity ) ;
            }
            @Override
            public void displayImage(String imageURL,ImageView imageView) {
//                ImageLoader.getInstance().displayImage(imageURL, imageView,ImageLoaderHelper.getInstance(mActivity).getOptions());// 此处本人使用了ImageLoader对图片进行加装！
//                imageView.setImageResource(R.mipmap.ic_launcher);
                ImageLoader.getInstance().imageLoaderRequest(imageView,imageURL);
            }
        };
        mImageCycleView.setImageResources(mImageUrl,mImageName, mAdCycleViewListener);
        mImageCycleView.startImageCycle();
    }


}
