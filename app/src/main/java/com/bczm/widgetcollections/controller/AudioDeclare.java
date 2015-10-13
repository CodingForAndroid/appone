package com.bczm.widgetcollections.controller;

import com.bczm.widgetcollections.bean.MusicsListEntity;
import com.bczm.widgetcollections.bean.MusicsListPackage;

/**
 * 播放音乐界面的 方法
 * @author：Jorge on 2015/10/11 11:14
 */
 public abstract interface AudioDeclare {
   /**
    *    刷新播放列表
    * @param responseMusicsListentity  : 音乐信息
    */
    void refreshMusicsList(MusicsListPackage responseMusicsListentity);

   /**
    * 加载更多音乐
    * @param responseMusicsListentity
    */
    void addMoreMusicsList(MusicsListPackage responseMusicsListentity);

   /**
    * 由暂停到播放音乐
    */
    void rePlayMusic();

   /**
    * 开始播放音乐
    */
    void startPlayMusic();

   /**
    * 停止播放音乐
    */
    void stopPlayMusic();
   /**
    *暂停播放音乐
    */
    void pausePlayMusic();
   /**
    *播放下一首
    */
    void playNextMusic();
   /**
    *播放上一首
    */
    void playPrevMusic();

   /**
    * 进度条 移动到某位置
    * @param position :进度条位置
    */
    void seekToPosition(int position);

   /**
    * 刷新页面
    * @param audioInfo
    * @param totalDuration
    */
    void refreshPageInfo(MusicsListEntity audioInfo, int totalDuration);

   /**
    * 刷新播放进度
    * @param progress  播放进去
    */
    void refreshPlayProgress(int progress);

   /**
    * 刷新进度
    * @param progress
    */
    void refreshPlaySecondProgress(int progress);
}
