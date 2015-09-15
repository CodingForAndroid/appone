package com.bczm.widgetcollections.bean;

import java.util.List;

/**
 *   推荐 的一个具体 分类
 * Created by Administrator on 2015/9/15.
 */
public class Channel {

    //底部长条
    public String data_cover;
    //data_id
    public String data_id;
     //类别  日韩  、搞笑
    public String data_name;
    //data_type  0
    public String data_type;
    //   同一类别的 channelitem
    public List<ChannelItemDetail> contents;

    @Override
    public String toString() {
        return "Channel{" +
                "data_cover='" + data_cover + '\'' +
                ", data_id='" + data_id + '\'' +
                ", data_name='" + data_name + '\'' +
                ", data_type='" + data_type + '\'' +
                ", contents=" + contents.get(0).toString() +
                ", contents.size=" + contents.size() +
                '}';
    }
}
