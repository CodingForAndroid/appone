package com.bczm.widgetcollections.ui.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 启动页
 *
 * @author：Jorge on 2015/10/13 10:00
 */
public class SplashActivity extends BaseActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {
    @Bind(R.id.videoView)
    VideoView videoView;
    @Bind(R.id.iv_close)
    ImageView ivClose;

    @Override
    protected void createContent() {
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initVideoView();
    }

    /**
     * 准备播放工作
     */
    private void initVideoView() {
        String uri = ConfigManage.URL_SPLASH;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setOnPreparedListener(this);

        // 设置全屏
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        videoView.setLayoutParams(layoutParams);

        videoView.setOnCompletionListener(this);
    }

    @Override
    protected void setListeners() {
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMainActivity();
            }
        });
    }

    @Override
    protected void free() {
        ButterKnife.unbind(this);
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        videoView.start();


        videoView.requestFocus();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        goToMainActivity();
    }

    /**
     * 跳转到主页
     */
    public void goToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        UIUtils.startActivity(intent);
//        startActivity(intent);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
