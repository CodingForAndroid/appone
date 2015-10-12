package com.bczm.widgetcollections.controller;

import com.bczm.widgetcollections.bean.MusicsListEntity;


/**
 * 方法声明
 * @author：Jorge on 2015/10/11 12:36
 */
public abstract interface AudioController {
    void loadListData(String requestTag, String keywords, int event_tag);

    void onNextClick();

    void onPrevClick();

    void onStartPlay();

    void onPausePlay();

    void onRePlay();

    void seekTo(int position);

    void onStopPlay();

    void refreshPageInfo(MusicsListEntity entity, int totalDuration);

    void refreshProgress(int progress);

    void refreshSecondProgress(int progress);
}
