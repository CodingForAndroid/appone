package com.bczm.widgetcollections.ui.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.utils.SystemUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import java.util.ArrayList;

/**
 * @author：Jorge on 2015/9/10 12:35
 */
public class CycleImageView  extends LinearLayout{

    private ViewPager mViepgaer;
    // 底部的 描述文字
    private TextView mDescText;
    //最下面 右下角 点的 容器
    private LinearLayout mPointLayout;
    private  Context mContext;
    //   添加 点的容器
    private ImageView[] mImageViews;
    //  是否 循环播放
    private boolean isLoop = true;
    // 所有的文字描述
    private ArrayList<String> mImageDescList;
    public CycleImageView(Context context) {
        super(context);
        this.mContext=context;
        init(context);
    }

    public CycleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public  void  init(Context cxt){
        generateBannerLayout(cxt);
        mViepgaer.addOnPageChangeListener(new PagerChangeListener());
        mViepgaer.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_UP:
                }
                return false;
            }
        });
    }

    /**
     * 开始轮播
     */
    private   void  startCycleTask(){
        stopCycleTask();

        UIUtils.post(cycleTask);
    }

    /**
     * 停止轮播
     */
    private  void stopCycleTask(){
        isLoop=false;
        UIUtils.removeCallbacks(cycleTask);
    }
    /**
     * 自动轮播
     */
    private  Runnable cycleTask= new Runnable() {
        @Override
        public void run() {
        if(mImageViews!=null){
                mViepgaer.setCurrentItem(mViepgaer.getCurrentItem() + 1);
            while(isLoop){
                UIUtils.postDelayed(this,3000);
            }
        }
        }
    };
    /**
     * 给 viewpager 以及其他view 适配上数据
     */
    public  void  fillData(ArrayList<String>imageUrls,ArrayList<String>descriptions){
        mImageDescList=descriptions;

        // 添加 圆点
        mPointLayout.removeAllViews();
        int  imageCount=   imageUrls.size();
        float den =mContext.getResources().getDisplayMetrics().density;
        mImageViews = new ImageView[imageCount];
        for (int i = 0; i < imageCount; i++) {
            ImageView  mImageView = new ImageView(mContext);
            int imageParams = (int) (den * 10 + 0.5f);// XP与DP转换，适应应不同分辨率
            int imagePadding = (int) (den * 5 + 0.5f);
            LayoutParams params=new LayoutParams(imageParams,imageParams);
            params.leftMargin=10;
            mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mImageView.setLayoutParams(params);
            mImageView.setPadding(imagePadding, imagePadding, imagePadding, imagePadding);

            mImageViews[i] = mImageView;
            if (i == 0) {
                mImageViews[i].setBackgroundResource(R.mipmap.banner_dot_focus);
            } else {
                mImageViews[i].setBackgroundResource(R.mipmap.banner_dot_normal);
            }
            mPointLayout.addView(mImageViews[i]);
        }
        mDescText.setText(descriptions.get(0));
        CycleImageAdapter  imageAdapter= new CycleImageAdapter(imageUrls);
        mViepgaer.setAdapter(imageAdapter);
    }

    /**
     * viewpager 的 适配器  生成具体item
     */
    private class CycleImageAdapter extends PagerAdapter{

        private  ArrayList<ClickableImageView> mImageCacheList=new ArrayList<ClickableImageView>();
        private  ArrayList<String>imageUrls=new ArrayList<String>();
        private ClickableImageView imageView;

        public  CycleImageAdapter(ArrayList<String>urls){
            imageUrls=urls;
        }
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
           String  url= imageUrls.get(position%imageUrls.size());

            if (mImageCacheList.isEmpty()){
                imageView = new ClickableImageView(mContext);
                imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }else{
                imageView=   mImageCacheList.remove(0);
            }
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            ClickableImageView  imageView= (ClickableImageView) object;
            mViepgaer.removeView(imageView);
            mImageCacheList.add(imageView);
        }
    }

    /**
     * 生成 基本布局
     * @param context
     * @return
     */
    public RelativeLayout generateBannerLayout(Context context){
        RelativeLayout  parentLayout= new RelativeLayout(context);
        RelativeLayout.LayoutParams  parentParams= new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, SystemUtils.getScreenHeight()*3/10);
        parentLayout.setLayoutParams(parentParams);
        //添加viewpager
        mViepgaer = new ViewPager(context);
        RelativeLayout.LayoutParams  pagerParams= new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        parentLayout.addView(mViepgaer, pagerParams);
        // 添加文字
        mDescText = new TextView(context);
        mDescText.setBackgroundResource(R.color.blue);
        mDescText.setGravity(Gravity.CENTER_VERTICAL);
        RelativeLayout.LayoutParams mDescTextParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        mDescTextParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        parentLayout.addView(mDescText, mDescTextParams);
        // 添加底部圆点
        mPointLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams mPointParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,  SystemUtils.getScreenHeight()*1/20);
        mPointParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mPointParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mPointLayout.setGravity(Gravity.CENTER);
        parentLayout.addView(mPointLayout,mPointParams);
        return  parentLayout;
    }

    /**
     * 页面切换指示器  设置 更换 文字 ，和  圆点类型
     */
    private class  PagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {
            position=position%mImageViews.length;
            // 设置当前显示的图片
//			mImageIndex = index;
            // 设置图片滚动指示器背
            mImageViews[position].setBackgroundResource(R.mipmap.banner_dot_focus);
            mDescText.setText(mImageDescList.get(position));
            for (int i = 0; i < mImageViews.length; i++) {
                if (position != i) {
                    mImageViews[i].setBackgroundResource(R.mipmap.banner_dot_normal);
                }
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
