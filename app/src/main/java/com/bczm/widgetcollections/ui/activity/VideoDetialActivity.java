package com.bczm.widgetcollections.ui.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.VideoBean;
import com.bczm.widgetcollections.bean.VideoDecorationBean;
import com.bczm.widgetcollections.http.protocol.VideoDetailProtocol;
import com.bczm.widgetcollections.ui.fragment.ChapterFragment;
import com.bczm.widgetcollections.ui.fragment.DetailFragment;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SystemUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 动画播放界面
 *
 * @author：Jorge on 2015/9/17 13:28
 */
public class VideoDetialActivity extends BaseActivity {
    @Bind(R.id.videoView)
    VideoView videoView;
    @Bind(R.id.radio_detail)
    RadioButton radioDetail;
    @Bind(R.id.radio_list)
    RadioButton radioList;
    @Bind(R.id.radiogroup)
    RadioGroup radiogroup;
    @Bind(R.id.ll_video_play_activity)
    LinearLayout llVideoPlayActivity;// 父布局
    private String trackid;
    private String content_id;
    private VideoDecorationBean videoDecorationBean;
    //tab 标签
    private  String  TAB_LSIT="tablist";//目录
    private  String  TAB_DETIAL="tabdetail";// 详情
    private FragmentTabHost mTabhost;

    @Override
    protected void createContent() {
        setContentView(R.layout.activity_video_play);
        ButterKnife.bind(this);
        radioDetail.setChecked(true);
        initTab();
        load();
    }

    @Override
    protected void onResume() {
        super.onResume();
        VideoBean videoBean = videoDecorationBean.items.get(0);
        String url = videoBean.url.split("\\?")[0];
        setVideoView(url);
    }

    @Override
    protected void setListeners() {
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radio_detail) {
                    radioDetail.setChecked(true);
                    radioDetail.setTextColor(getResources().getColor(android.R.color.white));
                    radioList.setChecked(false);
                    radioList.setTextColor(getResources().getColor(R.color.blue));
                    mTabhost.setCurrentTab(0);
                } else if (checkedId == R.id.radio_list) {
                    radioList.setChecked(true);
                    radioList.setTextColor(getResources().getColor(android.R.color.white));
                    radioDetail.setChecked(false);
                    radioDetail.setTextColor(getResources().getColor(R.color.blue));
                    mTabhost.setCurrentTab(1);

                }
            }
        });
    }

    @Override
    protected void free() {


    }

    /**
     * 加载数据
     */
    protected void load() {

        VideoDetailProtocol videoDetialProtocol = new VideoDetailProtocol();
        //彩泥喜欢
//        videoDetialProtocol.getGuessFavorite();
        //播放url
        videoDecorationBean = videoDetialProtocol.getVideoCurrentPlay();
        // 介绍
//        videoDetialProtocol.getVideoDetailDesc();

    }


    public void setVideoView(String url) {
//        String uri="http://streaming-http.icartoons.cn:7388/cmstest/20150710/7504/201507063200190322/W704.3gp";
        LogUtils.e("url===" + url);
        videoView.setVideoURI(Uri.parse(url));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                System.out.println("getBufferPercentage:" + videoView.getBufferPercentage());
                videoView.start();
                videoView.requestFocus();
            }
        });
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        mc.setKeepScreenOn(true);
        mc.setPadding(0, 0, 0, 1280 - UIUtils.dip2px(200));
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.FILL_PARENT,
//                SystemUtils.getScreenHeight()*2/5);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        videoView.setLayoutParams(new RelativeLayout.LayoutParams());
//        videoView.setLayoutParams(layoutParams);

        videoView.start();
        videoView.setMediaController(mc);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //播放结束后的动作
                UIUtils.showToastSafe("播放結束");

            }
        });
    }

    //初始化 tabhost
    public void initTab(){

        // 添加 分隔线
        TextView tvDivider=new TextView(UIUtils.getContext());
        LinearLayout.LayoutParams dividerParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,UIUtils.dip2px(1));
        tvDivider.setLayoutParams( dividerParams);
        llVideoPlayActivity.addView(tvDivider);

        // 添加 FragmentTabHost
        mTabhost = new FragmentTabHost(UIUtils.getContext());
        mTabhost.setId(R.id.tabhost);
        LinearLayout.LayoutParams tabHostParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        mTabhost.setLayoutParams(tabHostParams);
        llVideoPlayActivity.addView(mTabhost);

        FrameLayout  frameLayout=new FrameLayout(UIUtils.getContext());
        frameLayout.setId(R.id.tabcontent);
        LinearLayout.LayoutParams framParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        frameLayout.setLayoutParams(framParams);
        llVideoPlayActivity.addView(frameLayout);


        mTabhost.setup(UIUtils.getContext(), getSupportFragmentManager(), R.id.tabcontent);
        mTabhost.getTabWidget().setVisibility(View.GONE);

        mTabhost.addTab(mTabhost.newTabSpec(TAB_DETIAL).setIndicator(TAB_DETIAL), DetailFragment.class, null);
        mTabhost.addTab(mTabhost.newTabSpec(TAB_LSIT).setIndicator(TAB_LSIT), ChapterFragment.class, null);

//        mTabhost.setCurrentTab(ORIGIN_TAB);
    }
}
