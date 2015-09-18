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
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.bean.RecommendAppInfo;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.manager.ImageLoader;
import com.bczm.widgetcollections.ui.activity.VideoDetialActivity;
import com.bczm.widgetcollections.ui.adapter.RecommendedPositionAdapter;
import com.bczm.widgetcollections.ui.widget.ClickableImageView;
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
//                setRecommandEvent(imageView, model.getData().get(position), mActivity ) ;
               Intent intent=  new Intent(UIUtils.getContext(), VideoDetialActivity.class);
                //trackid
//                intent.putExtra(ConfigManage.INTENT_EXTRA_TRACKID,list.get(position).trackid);
                intent.putExtra(ConfigManage.INTENT_EXTRA_TRACKID,"1442539345286084715c74b5215cc4b3-c1-2-5-");
                //serial_id
//                intent.putExtra(ConfigManage.INTENT_EXTRA_CONTENT_ID,list.get(position).serial_id);
                intent.putExtra(ConfigManage.INTENT_EXTRA_CONTENT_ID,"2S201507052200092708");
                //拿这两个参数去请求服务器获取 数据
                UIUtils.startActivity(intent);
//                RecommadPositonInfo{
//                    click_action='2',
//                            data_type='1',
//                            title='六花的勇者',
//                            sub_title='每周日3:30更新',
//                            cover='http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201509/20150912221221976879.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442539345286084715c74b5215cc4b3&trackid=1442539345286084715c74b5215cc4b3----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862',
//                            url='',
//                            trackid='1442539345286084715c74b5215cc4b3-c1-2-5-',
//                            serial_id='2S201507052200092708',
//                            serial_status='0',
//                            update_set='11',
//                            desc='【爱动漫日漫新番同步首发】传说，当魔物从黑暗深渊觉醒，世间化为地狱之时，命运之神会选出六位勇者并将授予此六人拯救世界之力。现在开始所要讲述的，便是背负着拯救世界使命的勇者们的故事。',
//                            pic='http://img0.icartoons.cn/spftp/temp/2015070610364100000062612542/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442539345286084715c74b5215cc4b3&trackid=1442539345286084715c74b5215cc4b3----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862'}

                LogUtils.e(list.get(position).toString());
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
    public static void  genenrateMoreChannels(LinearLayout layout_item_container,int textRes,int rightIconRes){

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
//        mRightImageParams.setMargins(10,10,10,20);
////        mRightImageParams.setMargins(0, 10, 0, 20);
        btn.setPadding(0, 10, 0, 20);;
        mItemLayout.addView(btn, mRightImageParams);
        layout_item_container.addView(mItemLayout,mItemParams);

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
        mTitleLayout.addView(titleText,titleTextParams);
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
            ImageLoader.getInstance().imageLoaderRequest(imageView,appInfo.cover.split("\\?")[0]);
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
     *
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
}
