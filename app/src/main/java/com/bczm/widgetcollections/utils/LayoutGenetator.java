package com.bczm.widgetcollections.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.manager.ImageLoader;
import com.bczm.widgetcollections.ui.adapter.RecommendedPositionAdapter;
import com.bczm.widgetcollections.ui.widget.ImageCycleView;
import com.bczm.widgetcollections.ui.widget.MyGridView;

import java.util.ArrayList;
import java.util.List;

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


    /**
     *  顶部轮播
     * @param list ：infos 对象
     * @param mActivity  Context
     * @param layout_item_container： 父布局
     */
    public static  void getneratePagerView(List<RecommandPositionInfo> list,Context mActivity,LinearLayout layout_item_container){
        ImageCycleView    mImageCycleView = new ImageCycleView(mActivity) ;
        LinearLayout.LayoutParams cParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,  SystemUtils.getScreenHeight()*3/10) ;
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
                ImageLoader.getInstance().imageLoaderRequest(imageView,imageURL);
            }
        };
        mImageCycleView.setImageResources(mImageUrl, mImageName, mAdCycleViewListener);
        mImageCycleView.startImageCycle();
    }
    

    /**
     * 生成 六个  推荐 位置的 视频
     * @param list     数据集合
     * @param layout_item_container   父容器
     */
    public  static void  generateRecommendPosition(List<RecommandPositionInfo> list,LinearLayout layout_item_container){
        LogUtils.e("list:" + list.size());
        MyGridView gridView= new MyGridView(UIUtils.getContext());
        gridView.setNumColumns(2);
        RelativeLayout.LayoutParams cParams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT,  RelativeLayout.LayoutParams.WRAP_CONTENT) ;
        layout_item_container.addView(gridView, cParams);
        gridView.setAdapter(new RecommendedPositionAdapter(UIUtils.getContext(), list));
    }

    /**
     * 推荐更多 应用
     * @param layout_item_container 父容器
     */
    public static void  genenrateMoreChannels(LinearLayout layout_item_container){

        RelativeLayout mItemLayout = new RelativeLayout(UIUtils.getContext());
        mItemLayout.setBackgroundResource(R.drawable.selector_common_btn);
        mItemLayout.setClickable(true);
        RelativeLayout.LayoutParams mItemParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        mItemParams.setMargins(10,10 ,10,10);
        mItemLayout.setLayoutParams(mItemParams);
        TextView btn = new TextView(UIUtils.getContext());
        btn.setGravity(Gravity.CENTER);
        Drawable drawable=UIUtils.getDrawable(R.mipmap.ic_hot_click);
        //这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        btn.setCompoundDrawables(drawable, null, null, null);
        btn.setText(R.string.txt_recommend_more);
        btn.setTextSize(TypedValue.COMPLEX_UNIT_PX, UIUtils.getDimens(R.dimen.txt_size_classify_high));
        btn.setTextColor(UIUtils.getColor(R.color.blue));
        RelativeLayout.LayoutParams mRightImageParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, UIUtils.getDimens(R.dimen.comm_navigation_hei));
        mRightImageParams.addRule(RelativeLayout.CENTER_IN_PARENT);
//        mRightImageParams.setMargins(0,10 ,0,10);
        mRightImageParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mItemLayout.addView(btn, mRightImageParams);
        layout_item_container.addView(mItemLayout);
    }

}
