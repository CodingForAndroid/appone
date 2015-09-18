package com.bczm.widgetcollections.ui.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.VideoBean;
import com.bczm.widgetcollections.bean.VideoDecorationBean;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.protocol.VideoDetialProtocol;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.UIUtils;
import com.bczm.widgetcollections.utils.ViewUtils;

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
    private String trackid;
    private String content_id;
    private VideoDecorationBean videoDecorationBean;


    @Override
    protected void createContent() {
        setContentView(R.layout.activity_video_play);
        ButterKnife.bind(this);
        radioDetail.setChecked(true);

        load();
    }

    @Override
    protected void onResume() {
        super.onResume();
      VideoBean videoBean= videoDecorationBean.items.get(0);
        String  url=videoBean.url.split("\\?")[0];
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
                } else if (checkedId == R.id.radio_list) {
                    radioList.setChecked(true);
                    radioList.setTextColor(getResources().getColor(android.R.color.white));
                    radioDetail.setChecked(false);
                    radioDetail.setTextColor(getResources().getColor(R.color.blue));
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

        VideoDetialProtocol videoDetialProtocol = new VideoDetialProtocol();
        //彩泥喜欢
        videoDetialProtocol.getGuessFavouriate();
        //播放url
        videoDecorationBean = videoDetialProtocol.getVideoCrrentPlay();
        // 介绍
        videoDetialProtocol.getVideoDetailDesc();

    }


    public void setVideoView(String  url){
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
        MediaController   mc = new MediaController(this);
        mc.setAnchorView(videoView);
        mc.setKeepScreenOn(true);
        mc.setPadding(0, 0, 0,1280- UIUtils.dip2px(200));
//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.FILL_PARENT,
//                RelativeLayout.LayoutParams.FILL_PARENT);
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


}
