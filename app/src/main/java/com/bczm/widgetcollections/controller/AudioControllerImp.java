package com.bczm.widgetcollections.controller;

import android.content.Context;

import com.bczm.widgetcollections.bean.MusicsListEntity;

/**
 * 控制实现
 * @author：Jorge on 2015/10/11 12:38
 */
public class AudioControllerImp implements AudioController {

    private Context mContext = null;
    private AudioDeclare mAudioDeclare = null;

    public AudioControllerImp(Context context, AudioDeclare audioDeclare){
        mContext=context;
        mAudioDeclare=audioDeclare;
    }
    @Override
    public void loadListData(String requestTag, String keywords, int event_tag) {

    }

    @Override
    public void onNextClick() {
        mAudioDeclare.playNextMusic();
    }

    @Override
    public void onPrevClick() {
        mAudioDeclare.playPrevMusic();
    }

    @Override
    public void onStartPlay() {
        mAudioDeclare.startPlayMusic();
    }

    @Override
    public void onPausePlay() {
        mAudioDeclare.pausePlayMusic();
    }

    @Override
    public void onRePlay() {
        mAudioDeclare.rePlayMusic();
    }

    @Override
    public void seekTo(int position) {
        mAudioDeclare.seekToPosition(position);
    }

    @Override
    public void onStopPlay() {
        mAudioDeclare.stopPlayMusic();
    }

    @Override
    public void refreshPageInfo(MusicsListEntity entity, int totalDuration) {
        mAudioDeclare.refreshPageInfo(entity,totalDuration);
    }

    @Override
    public void refreshProgress(int progress) {
        mAudioDeclare.refreshPlayProgress(progress);
    }

    @Override
    public void refreshSecondProgress(int progress) {
        mAudioDeclare.refreshPlaySecondProgress(progress);
    }
}
