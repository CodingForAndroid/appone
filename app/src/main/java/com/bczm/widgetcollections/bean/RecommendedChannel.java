package com.bczm.widgetcollections.bean;

import java.util.List;

/**
 * 首页推荐频道 的集合
 * Created by Administrator on 2015/9/15.
 */
public class RecommendedChannel {

    // 类别个数
    public int  record_count;
    // 所有类别集合
    public List<Channel> items;


    @Override
    public String toString() {
        return "RecommendedChannel{" +
                "record_count=" + record_count +
                ", items=" + items.get(0).toString() +
                ", items.size=" + items.size() +
                '}';
    }
}
