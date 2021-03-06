package com.bczm.widgetcollections.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.CommentBean;
import com.bczm.widgetcollections.bean.GuessFavoriteBean;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.bean.RecommendAppInfo;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.manager.ImageLoaderHelper;
import com.bczm.widgetcollections.ui.activity.VideoDetialActivity;
import com.bczm.widgetcollections.ui.adapter.CommentListAdapter;
import com.bczm.widgetcollections.ui.adapter.HorizontalAdapter;
import com.bczm.widgetcollections.ui.adapter.RecommendedPositionAdapter;
import com.bczm.widgetcollections.ui.widget.BaseListView;
import com.bczm.widgetcollections.ui.widget.ClickableImageView;
import com.bczm.widgetcollections.ui.widget.HorizontalListView;
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
        title.setTextSize(TypedValue.COMPLEX_UNIT_PX,sizeRes) ;
        title.setTextColor(colorRes) ;
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
    public static  void getneratePagerView(final List<RecommandPositionInfo> list,Context mActivity,LinearLayout layout_item_container){
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
               Intent intent=  new Intent(UIUtils.getContext(), VideoDetialActivity.class);
                intent.putExtra(ConfigManage.INTENT_EXTRA_TRACKID,"1442539345286084715c74b5215cc4b3-c1-2-5-");
                intent.putExtra(ConfigManage.INTENT_EXTRA_CONTENT_ID,"2S201507052200092708");
                //拿这两个参数去请求服务器获取 数据
                UIUtils.startActivity(intent);

                LogUtils.e(list.get(position).toString());
            }
            @Override
            public void displayImage(String imageURL,ImageView imageView) {
                ImageLoaderHelper.getInstance().loadImage(imageURL, imageView);
//                ImageLoader1.getInstance().imageLoaderRequest(imageView,);a
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
//        LogUtils.e("list:" + list.size());
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
    public static void  genenrateMoreChannels(LinearLayout layout_item_container,int textRes,int rightIconRes ){

        RelativeLayout mItemLayout = new RelativeLayout(UIUtils.getContext());
        mItemLayout.setBackgroundResource(R.drawable.selector_common_btn);
        mItemLayout.setClickable(true);
        RelativeLayout.LayoutParams mItemParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mItemParams.setMargins(10, 10, 10, 10);
//        mItemLayout.setLayoutParams(mItemParams);
        TextView btn = new TextView(UIUtils.getContext());
        btn.setGravity(Gravity.CENTER);
        Drawable drawable=UIUtils.getDrawable(rightIconRes);
        //这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        btn.setCompoundDrawables(drawable, null, null, null);
        btn.setText(textRes);
        btn.setTextSize(TypedValue.COMPLEX_UNIT_PX, UIUtils.getDimens(R.dimen.txt_size_classify_high));
        btn.setTextColor(UIUtils.getColor(R.color.blue));
        RelativeLayout.LayoutParams mRightImageParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, UIUtils.getDimens(R.dimen.comm_navigation_hei));
        mRightImageParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        btn.setPadding(0, 10, 0, 20);;
        mItemLayout.addView(btn, mRightImageParams);
        layout_item_container.addView(mItemLayout, mItemParams);
    }

    /**
     * 首页，推荐应用
     * @param layout_item_container
     * @param list
     */
    public  static  void  generateRecommendedApp(LinearLayout layout_item_container,List<RecommendAppInfo> list){

        addLine(layout_item_container);
        RelativeLayout mTitleLayout = new RelativeLayout(UIUtils.getContext());
        RelativeLayout.LayoutParams mTitleLayoutParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // 推荐应用 标题
        TextView  titleText=new TextView(UIUtils.getContext());
        titleText.setText(R.string.txt_recommend_app);
        titleText.setBackgroundResource(R.color.white);
        titleText.setTextAppearance(UIUtils.getContext(), R.style.ChannelTextStyle);
        // 距 顶部 间隙
        RelativeLayout.LayoutParams titleTextParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        titleTextParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mTitleLayout.addView(titleText, titleTextParams);
        layout_item_container.addView(mTitleLayout, mTitleLayoutParam);

        // app 父布局
        LinearLayout appParentLayout=new LinearLayout(UIUtils.getContext());
        appParentLayout.setBackgroundResource(R.color.white);
        LinearLayout.LayoutParams appLayoutParam= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        appParentLayout.setLayoutParams(appLayoutParam);
        appParentLayout.setOrientation(LinearLayout.HORIZONTAL);
        // 单个 app 布局
        for (RecommendAppInfo appInfo: list) {
            LinearLayout appItemLayout=new LinearLayout(UIUtils.getContext());
            LinearLayout.LayoutParams appItemLayoutParam= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            appItemLayout.setOrientation(LinearLayout.VERTICAL);
            appItemLayout.setGravity(Gravity.CENTER);
            appItemLayout.setLayoutParams(appItemLayoutParam);

            appItemLayoutParam.setMargins(15,10,15,20);
            // 图片
            ClickableImageView imageView=new ClickableImageView(UIUtils.getContext());
            LogUtils.e(appInfo.cover.split("\\?")[0]);
            ImageLoaderHelper.getInstance().loadImage(appInfo.cover.split("\\?")[0],imageView);
//            ImageLoader1.getInstance().imageLoaderRequest(imageView,appInfo.cover.split("\\?")[0]);
            // 文字
            TextView appNameText=new TextView(UIUtils.getContext());
            appNameText.setTextAppearance(UIUtils.getContext(), R.style.ChannelTextStyle);
            appNameText.setText(appInfo.title);
            // 添加图片文字
            appItemLayout.addView(imageView);
            appItemLayout.addView(appNameText);
            appParentLayout.addView(appItemLayout);
        }
        // 头部内容添加底部线
//        ImageView headerBottm = new ImageView(UIUtils.getContext());
//        headerBottm.setBackgroundResource(R.drawable.common_divider_line_black);
//        RelativeLayout.LayoutParams headerBottmp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        headerBottmp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        layout_item_container.addView(headerBottm, headerBottmp);
        addLine(layout_item_container);
        layout_item_container.addView(appParentLayout);
        addLine(layout_item_container);
    }

    /**
     * 添加底部分隔线
     * @param layout_item_container
     */
    public static void addLine(LinearLayout  layout_item_container){
        // 头部内容添加底部线
        ImageView headerBottm = new ImageView(UIUtils.getContext());
        headerBottm.setBackgroundResource(R.drawable.common_divider_line_black);
        RelativeLayout.LayoutParams headerBottmp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        headerBottmp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layout_item_container.addView(headerBottm, headerBottmp);
    }

    public static boolean  hasOpen=false;


    /**
     * 添加详情 头部信息
     * @param desc  视频描述想起
     * @param container  父布局
     */
    public static void generateDetail(final String desc, final LinearLayout container){
        //标题
        TextView videoTitle=new TextView(UIUtils.getContext());
        videoTitle.setText(R.string.txt_title);
        videoTitle.setTextSize(UIUtils.getDimens(R.dimen.txt_size_classify_less));
        videoTitle.setTextAppearance(UIUtils.getContext(),R.style.ChannelTextStyle);
        container.addView(videoTitle);
        // 设置最大字符长度
        final TextView descText=new TextView(UIUtils.getContext());
        LinearLayout.LayoutParams descParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        descText.setLayoutParams(descParams);
        descText.setText(desc.length() >= UIUtils.getInteger(R.integer.txt_desc_max_length) ? desc.substring(0, UIUtils.getInteger(R.integer.txt_desc_max_length))+"..." : desc);
        container.addView(descText);
        descText.setTextSize(UIUtils.getDimens(R.dimen.txt_size_classify_least));
        descText.setTextColor(UIUtils.getColor(R.color.black));
        descText.setPadding(0,5,0,0);
        // 添加查看详细 图标
        final TextView moreText=new TextView(UIUtils.getContext());
        LinearLayout.LayoutParams moreParams=new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        moreText.setBackgroundResource(R.mipmap.img_open_btn);
        moreText.setPadding(0,0,0,5);
        moreParams.gravity=Gravity.CENTER_HORIZONTAL;
        container.addView(moreText,moreParams);
        moreText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasOpen){
                    descText.setText(desc.length() >= UIUtils.getInteger(R.integer.txt_desc_max_length) ? desc.substring(0, UIUtils.getInteger(R.integer.txt_desc_max_length))+"..." : desc);
                    moreText.setBackgroundResource(R.mipmap.img_open_btn);
                    hasOpen=false;
                }else{
                    descText.setText(desc);
                    moreText.setBackgroundResource(R.mipmap.img_close_btn);
                    hasOpen=true;
                }
            }
        });
    }

    /**
     * 添加 horizontal  lsitview
     * @param container  父布局
     * @param beans    数据
     */
    public  static  void  generateGuessLike( GuessFavoriteBean[] beans,LinearLayout container){
        addLine(container);
        LinearLayout  recommendLayout=new LinearLayout(UIUtils.getContext());
        recommendLayout.setPadding(0,5,0,0);
        recommendLayout.setOrientation(LinearLayout.VERTICAL);
        //标题 推荐
        TextView  titleView=new TextView(UIUtils.getContext());
        titleView.setText(R.string.txt_recommend);
        titleView.setHeight(50);
        titleView.setWidth(SystemUtils.getScreenWidth());
        recommendLayout.addView(titleView);
        titleView.setTextAppearance(UIUtils.getContext(), R.style.ChannelTextStyle);
        //分隔线
        addLine(recommendLayout);
        // 添加水平方向的 listview
        HorizontalListView  horizontalListView=new HorizontalListView(UIUtils.getContext());
        horizontalListView.setHorizontalScrollBarEnabled(true);
        horizontalListView.setHorizontalFadingEdgeEnabled(false);
        horizontalListView.setDividerWidth(UIUtils.dip2px(2));
        // 设置 horizontal listview 的 高度  为 屏幕分辨率的 1/6
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,SystemUtils.getScreenHeight()/4+50);
        horizontalListView.setLayoutParams(params);
        horizontalListView.setAdapter(new HorizontalAdapter(UIUtils.getContext(), beans));
        recommendLayout.addView(horizontalListView);
        // 添加分隔线
        container.addView(recommendLayout, params);
        addLine(container);
    }


    /**
     * 添加评论列表
     * @param list  评论列表内容
     * @param container  父布局
     */
    public  static  void generateCommentList(List<CommentBean>list,LinearLayout container){
        //添加分隔线
        addLine(container);
        TextView  titleView=new TextView(UIUtils.getContext());
        titleView.setText(R.string.txt_comment);
        titleView.setHeight(50);
        titleView.setTextAppearance(UIUtils.getContext(), R.style.ChannelTextStyle);
        titleView.setWidth(SystemUtils.getScreenWidth());
        container.addView(titleView);
        addLine(container);

        BaseListView  listView=new BaseListView(UIUtils.getContext());

        RelativeLayout.LayoutParams cParams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT,  RelativeLayout.LayoutParams.WRAP_CONTENT) ;
        container.addView(listView, cParams);
        listView.setAdapter(new CommentListAdapter(listView, list));
    }


    /**
     * 添加 清晰度   缓存  倒序 等按钮
     * @param itemId  id
     * @param leftImageId  id
     * @param rightImageId id
     * @return
     */
    public static void  generateCellTable(int itemId, int leftImageId, int rightImageId ,LinearLayout container) {

        int margin = UIUtils.getDimens(R.dimen.txt_size_classify_little);
        RelativeLayout mItemLayout = new RelativeLayout(UIUtils.getContext());
        mItemLayout.setId(itemId);
        RelativeLayout.LayoutParams mItemParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,UIUtils.getResources().getDimensionPixelSize(R.dimen.comm_navigation_hei));
        mItemParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mItemLayout.setLayoutParams(mItemParams);

        //清晰度
        String[] defins=  UIUtils.getStringArray(R.array.definition);
        TextView leftText=  LayoutGenetator.gTextView(UIUtils.getContext(), UIUtils.getDimens(R.dimen.txt_size_classify_high), UIUtils.getColor(R.color.black), defins[0], true);
        RelativeLayout.LayoutParams mLeftImageParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        leftText.setId(leftImageId);
        mLeftImageParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        mLeftImageParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mLeftImageParams.setMargins(margin, 0, 0, 0);
        Drawable leftDrawable=UIUtils.getDrawable(R.mipmap.player_setting);
        leftDrawable.setBounds(0, 0, leftDrawable.getMinimumWidth(), leftDrawable.getMinimumHeight()) ;
        leftText.setCompoundDrawables(leftDrawable, null, null, null);
        mItemLayout.addView(leftText, mLeftImageParams);

        // 倒序、正序 排列
        //清晰度
        String[] sort=  UIUtils.getStringArray(R.array.sort);
        TextView mCenterText = LayoutGenetator.gTextView(UIUtils.getContext(), UIUtils.getDimens(R.dimen.txt_size_classify_high), UIUtils.getColor(R.color.black), sort[0], true);
        RelativeLayout.LayoutParams mLeftTextParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout. LayoutParams.WRAP_CONTENT);
        mLeftTextParams.addRule(RelativeLayout.RIGHT_OF, leftImageId);
        mLeftTextParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mLeftTextParams.setMargins(3*margin, 0, 0, 0);
        Drawable centerDrawable=UIUtils.getDrawable(R.mipmap.player_order_positive);
        centerDrawable.setBounds(0, 0, centerDrawable.getMinimumWidth(), centerDrawable.getMinimumHeight()) ;
        mCenterText.setCompoundDrawables(centerDrawable, null, null, null);
        mItemLayout.addView(mCenterText, mLeftTextParams);

        // 右边 缓存
        TextView rightText = LayoutGenetator.gTextView(UIUtils.getContext(), UIUtils.getDimens(R.dimen.txt_size_classify_high), UIUtils.getColor(R.color.black), UIUtils.getString(R.string.txt_download), true);
        rightText.setId(rightImageId);
        RelativeLayout.LayoutParams mRightImageParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout. LayoutParams.WRAP_CONTENT);
        mRightImageParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mRightImageParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mRightImageParams.setMargins(0, 0, margin, 0);
        Drawable rightDrawable=UIUtils.getDrawable(R.mipmap.ico_all);
        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight()) ;
        rightText.setCompoundDrawables(rightDrawable,null,null ,null );
        mItemLayout.addView(rightText, mRightImageParams);

        // 头部内容添加底部线
        ImageView headerBottm = new ImageView(UIUtils.getContext());
        headerBottm.setBackgroundResource(R.drawable.common_divider_line_black);
        RelativeLayout.LayoutParams headerBottmp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout. LayoutParams.WRAP_CONTENT);
        headerBottmp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mItemLayout.addView(headerBottm, headerBottmp);
        mItemLayout.setClickable(true);
//        mItemLayout.setBackgroundResource(R.drawable.selector_shape_white_gray_low_small);
        container.addView(mItemLayout);
//        return mItemLayout;
    }




    /**
     *
     * @param textResId
     *            ： 文字 内容 .
     * @param itemId
     *            ： 给 开关 设置的 id.
     * @return
     */
    public static void generateTVChannel(int textResId, int itemId, LinearLayout parentView) {
        // 左右边距
        int magrin = (int)UIUtils.getDimens(R.dimen.txt_size_classify_mid);
        // 观看动漫
        RelativeLayout mItemLayout = new RelativeLayout(UIUtils.getContext());
        mItemLayout.setId(itemId);
        RelativeLayout.LayoutParams mItemParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, UIUtils.getDimens(R.dimen.comm_navigation_hei));
        mItemParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mItemLayout.setLayoutParams(mItemParams);

        // 添加文字
        TextView mWatchCartoonTextView = new TextView(UIUtils.getContext());
        mWatchCartoonTextView.setText(textResId);
        mWatchCartoonTextView.setTextAppearance(UIUtils.getContext(),R.style.text_black_bg);
        RelativeLayout.LayoutParams mTextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout. LayoutParams.WRAP_CONTENT);
        mTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        mTextViewParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mTextViewParams.setMargins(magrin, 0, 0, 0);
        mItemLayout.addView(mWatchCartoonTextView, mTextViewParams);

        // 添加 开关
        ClickableImageView mToggleButton = new ClickableImageView(UIUtils.getContext());
        mToggleButton.setImageResource(R.mipmap.btn_send);
        RelativeLayout.LayoutParams mToggleParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mToggleParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mToggleParams.addRule(RelativeLayout.CENTER_VERTICAL);
        mToggleParams.setMargins(0, 0, magrin, 0);
        mItemLayout.addView(mToggleButton, mToggleParams);

        // 头部内容添加底部线
        ImageView headerBottm = new ImageView(UIUtils.getContext());
        headerBottm.setBackgroundResource(R.drawable.common_divider_line_black);
        RelativeLayout.LayoutParams headerBottmp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        headerBottmp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        mItemLayout.addView(headerBottm, headerBottmp);
        mItemLayout.setClickable(true);
        mItemLayout.setBackgroundResource(R.drawable.channel_selector);
        parentView.addView(mItemLayout);
    }

}
