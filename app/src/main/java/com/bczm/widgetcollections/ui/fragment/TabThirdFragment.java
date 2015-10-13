package com.bczm.widgetcollections.ui.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.MusicsListEntity;
import com.bczm.widgetcollections.bean.MusicsListPackage;
import com.bczm.widgetcollections.common.Constants;
import com.bczm.widgetcollections.controller.AudioController;
import com.bczm.widgetcollections.controller.AudioControllerImp;
import com.bczm.widgetcollections.controller.AudioDeclare;
import com.bczm.widgetcollections.http.protocol.AudioProtocol;
import com.bczm.widgetcollections.player.MusicPlayService;
import com.bczm.widgetcollections.player.MusicPlayState;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.ui.widget.MarqueTextView;
import com.bczm.widgetcollections.utils.AnimationUtil;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.StringUtils;
import com.bczm.widgetcollections.utils.TimeUtils;
import com.bczm.widgetcollections.utils.UIUtils;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 听音乐
 *
 * @author：Jorge on 2015/9/28 12:42
 * <p/>
 * step1  请求 音乐数据
 * step 2 加载布局
 */
public class TabThirdFragment extends BaseFragment implements AudioDeclare, View.OnClickListener {

    MusicsListPackage responseMusicsListentity;
    @Bind(R.id.iv_cover)  // 封面背景
            ImageView ivCover;
    @Bind(R.id.ll_content)  // 封面背景
            LinearLayout llCover;
    @Bind(R.id.musics_player_play_prev_btn) // 上一首
            ImageButton musicsPlayerPlayPrevBtn;
    @Bind(R.id.musics_player_play_ctrl_btn)  // 播放按钮
            ImageButton musicsPlayerPlayCtrlBtn;
    @Bind(R.id.musics_player_play_next_btn) // 下一首
            ImageButton musicsPlayerPlayNextBtn;
    @Bind(R.id.ll_controller)             //  播放器按钮布局
            LinearLayout llController;
    @Bind(R.id.musics_player_current_time) //  当前播放时间
            TextView musicsPlayerCurrentTime;
    @Bind(R.id.musics_player_seekbar)    // 进度条
            SeekBar musicsPlayerSeekbar;
    @Bind(R.id.musics_player_total_time) //  总时间
            TextView musicsPlayerTotalTime;
    @Bind(R.id.musics_player_progress_container)  // 进度条容器
            LinearLayout musicsPlayerProgressContainer;
    @Bind(R.id.tv_singer)
    TextView tvSinger;
    @Bind(R.id.tv_song)
    MarqueTextView tvSong;

    //是否正在播放
    private boolean isPlaying = false;
    private AudioProtocol audioProtocol;
    private AudioController audioContoller;
    private Context mContext = null;
    private PlayBundleBroadCast mBundleBroadCast;
    private PlayPositionBroadCast mPositionBroadCast;
    private PlaySecondProgressBroadCast mSecondProgressBroadCast;
    //当前界面是否显示在最前面
    private boolean isVisible;
    @Override
    protected void initViewsAndEvents() {

        //监听 上一首
        musicsPlayerPlayPrevBtn.setOnClickListener(this);
        // 下一首
        musicsPlayerPlayNextBtn.setOnClickListener(this);
        //播放
        musicsPlayerPlayCtrlBtn.setOnClickListener(this);
    }

    @Override
    protected LoadingPage.LoadResult load() {
        // 获取数据
        audioProtocol = new AudioProtocol();
        responseMusicsListentity = audioProtocol.load(0, false);

        return check(responseMusicsListentity);
    }


    @Override
    protected View createLoadedView() {
        View view = UIUtils.inflate(R.layout.fragment_audio);
        ButterKnife.bind(this, view);
        //mvp模式
        audioContoller = new AudioControllerImp(UIUtils.getContext(), this);
        if (responseMusicsListentity != null) {
            refreshMusicsList(responseMusicsListentity);
        }
        AnimationUtil.runAnimation(ivCover);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.e("87：" + (responseMusicsListentity == null));

            //        监听广播
            mBundleBroadCast = new PlayBundleBroadCast();
            IntentFilter bundleFilter = new IntentFilter();
            bundleFilter.addAction(Constants.ACTION_MUSIC_BUNDLE_BROADCAST);

            mContext.registerReceiver(mBundleBroadCast, bundleFilter);

            mPositionBroadCast = new PlayPositionBroadCast();
            IntentFilter posFilter = new IntentFilter();
            posFilter.addAction(Constants.ACTION_MUSIC_CURRENT_PROGRESS_BROADCAST);

            mContext.registerReceiver(mPositionBroadCast, posFilter);

            mSecondProgressBroadCast = new PlaySecondProgressBroadCast();
            IntentFilter secondProgressFilter = new IntentFilter();
            secondProgressFilter.addAction(Constants.ACTION_MUSIC_SECOND_PROGRESS_BROADCAST);

            mContext.registerReceiver(mSecondProgressBroadCast, secondProgressFilter);

            mContext.startService(new Intent(mContext, MusicPlayService.class));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void refreshMusicsList(MusicsListPackage data) {
        if (null != data) {
            List<MusicsListEntity> mPlayListData = data.getSong();
            if (null != mPlayListData && !mPlayListData.isEmpty()) {
                MusicPlayService.refreshMusicList(mPlayListData);
                audioContoller.onStartPlay();
            }
        }
    }

    @Override
    public void addMoreMusicsList(MusicsListPackage data) {

    }

    @Override
    public void rePlayMusic() {
        isPlaying = true;
        musicsPlayerPlayCtrlBtn.setImageResource(R.drawable.btn_audio_pause_selector);
        mContext.sendBroadcast(new Intent(MusicPlayState.ACTION_MUSIC_REPLAY));
    }

    @Override
    public void startPlayMusic() {
        isPlaying = true;
        musicsPlayerPlayCtrlBtn.setImageResource(R.drawable.btn_audio_pause_selector);
        mContext.sendBroadcast(new Intent(MusicPlayState.ACTION_MUSIC_PLAY));
    }

    @Override
    public void stopPlayMusic() {
        if(musicsPlayerPlayCtrlBtn!=null){
            isPlaying = false;
            mContext.sendBroadcast(new Intent(MusicPlayState.ACTION_MUSIC_STOP));
            musicsPlayerPlayCtrlBtn.setImageResource(R.drawable.btn_audio_play_selector);
        }

    }

    @Override
    public void pausePlayMusic() {
        if(musicsPlayerPlayCtrlBtn!=null){
            isPlaying = false;
            musicsPlayerPlayCtrlBtn.setImageResource(R.drawable.btn_audio_play_selector);
            mContext.sendBroadcast(new Intent(MusicPlayState.ACTION_MUSIC_PAUSE));
        }

    }

    @Override
    public void playNextMusic() {
        isPlaying = true;
        musicsPlayerPlayCtrlBtn.setImageResource(R.drawable.btn_audio_play_selector);
        if (audioProtocol == null) {
            audioProtocol = new AudioProtocol();
        }
        refreshMusicsList(audioProtocol.load(0, false));
    }

    @Override
    public void playPrevMusic() {
        isPlaying = true;
        musicsPlayerPlayCtrlBtn.setImageResource(R.drawable.btn_audio_play_selector);
        if (audioProtocol == null) {
            audioProtocol = new AudioProtocol();
        }
        refreshMusicsList(audioProtocol.load(0, false));
    }

    @Override
    public void seekToPosition(int position) {
        LogUtils.e("seekToPosition-------------------->>:" + position);
        mContext.sendBroadcast(new Intent(MusicPlayState.ACTION_SEEK_TO).putExtra(Constants.KEY_PLAYER_SEEK_TO_PROGRESS, position));

    }

    @Override
    public void refreshPageInfo(MusicsListEntity entity, int totalDuration) {
        if (null != entity) {
            tvSong.setText(entity.getTitle());
            StringBuilder sb = new StringBuilder();
            sb.append("--\t");
            sb.append(entity.getArtist());
            sb.append("\t--");
            tvSinger.setText(sb.toString().trim());
        }

        if (totalDuration > 0) {
            musicsPlayerSeekbar.setMax(totalDuration);
        }

        String imageUrl = entity.getPicture();
        if (!StringUtils.isEmpty(imageUrl)) {

        } else {

        }

        String totalTime = TimeUtils.convertTime(totalDuration);
        if (null != totalTime && !TextUtils.isEmpty(totalTime)) {
            musicsPlayerTotalTime.setText(totalTime);
        }
    }

    @Override
    public void refreshPlayProgress(int progress) {

        musicsPlayerSeekbar.setProgress(progress);
        String currentTime = TimeUtils.convertTime(progress);
        if (null != currentTime && !TextUtils.isEmpty(currentTime)) {
            musicsPlayerCurrentTime.setText(currentTime);
        }
    }

    @Override
    public void refreshPlaySecondProgress(int progress) {
        musicsPlayerSeekbar.setSecondaryProgress(progress);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mContext.unregisterReceiver(mBundleBroadCast);
        mContext.unregisterReceiver(mPositionBroadCast);
        mContext.unregisterReceiver(mSecondProgressBroadCast);
        if(audioContoller!=null)
        audioContoller.onStopPlay();

    }


    @Override
    public void onPause() {
        super.onPause();
        if(audioContoller!=null)
        audioContoller.onPausePlay();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible=isVisibleToUser;
        if(isVisibleToUser&&audioContoller!=null){
            audioContoller.onRePlay();
        }else{
           if(audioContoller!=null)
               audioContoller.onPausePlay();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.musics_player_play_prev_btn:
                audioContoller.onPrevClick();
                break;
            case R.id.musics_player_play_ctrl_btn:
                if (isPlaying) {
                    audioContoller.onPausePlay();
                } else {
                    audioContoller.onRePlay();
                }
                break;
            case R.id.musics_player_play_next_btn:
                audioContoller.onNextClick();
                break;
        }
    }


    private class PlayBundleBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (null != action && !TextUtils.isEmpty(action)) {
                if (action.equals(Constants.ACTION_MUSIC_BUNDLE_BROADCAST)) {
                    Bundle extras = intent.getExtras();
                    if (null != extras) {
                        MusicsListEntity entity = extras.getParcelable(Constants.KEY_MUSIC_PARCELABLE_DATA);
                        int totalDuration = extras.getInt(Constants.KEY_MUSIC_TOTAL_DURATION);
                        audioContoller.refreshPageInfo(entity, totalDuration);
                    }
                }
            }
        }

    }

    private class PlayPositionBroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (null != action && !TextUtils.isEmpty(action)) {
                if (action.equals(Constants.ACTION_MUSIC_CURRENT_PROGRESS_BROADCAST)) {
                    Bundle extras = intent.getExtras();
                    if (null != extras) {
                        int progress = extras.getInt(Constants.KEY_MUSIC_CURRENT_DUTATION);
                        audioContoller.refreshProgress(progress);
                    }
                }
            }

        }
    }

    private class PlaySecondProgressBroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (null != action && !TextUtils.isEmpty(action)) {
                if (action.equals(Constants.ACTION_MUSIC_SECOND_PROGRESS_BROADCAST)) {
                    Bundle extras = intent.getExtras();
                    if (null != extras) {
                        int progress = extras.getInt(Constants.KEY_MUSIC_SECOND_PROGRESS);
                        audioContoller.refreshSecondProgress(progress);
                    }
                }
            }

        }
    }
}
