package com.bczm.widgetcollections.bean;

/**
 * 首页顶部 推荐位置的信息
 * @author：Jorge on 2015/9/11 16:00
 */
public class RecommadPositonInfo {
   //具体字段意思 看下面 JSON，
    private String data_type;
    private String title;
    private String sub_title;
    private String cover;
    private String click_action;
    private String url;
    private String trackid;
    private String serial_id;
    private String serial_status;
    private String update_set;
    private String desc;
    private String pic;


//    {
//        "data_type": 1,
//            "title": "创圣的大天使LOGOS",
//            "sub_title": "每周五00:30更新",
//            "cover": "http://img0.icartoons.cn/opftp/c4x_pic/c4x_position/201509/20150911005111413924.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862",
//            "click_action": "2",
//            "url": "",
//            "trackid": "144193462087532696eb757e02b6f42a-c1-2-1-",
//            "serial_id": "2S201509012200092907",
//            "serial_status": 0,
//            "update_set": "11",
//            "desc": "过去，曾有过人类的声音唤醒万物真理的时代。但，经由某种发明，人类的历史迎来巨大的转换期。“文字”——它作为优越的传达手段在瞬间普及，并令声音与真理之间的“LOGOS世界”诞生了。",
//            "pic": "http://img0.icartoons.cn/spftp/temp/2015090602091300000096712542/720x405.jpg?flow_flag=74559224&flow_type=1&flow_channel=api&dm_sid=144193462087532696eb757e02b6f42a&trackid=144193462087532696eb757e02b6f42a----&loginfo=74559224|2947916703|6|68a0f6a3d862|000000000000000|68a0f6a3d862"
//    }

    @Override
    public String toString() {
        return "RecommadPositonInfo{" +
                "click_action='" + click_action + '\'' +
                ", data_type='" + data_type + '\'' +
                ", title='" + title + '\'' +
                ", sub_title='" + sub_title + '\'' +
                ", cover='" + cover + '\'' +
                ", url='" + url + '\'' +
                ", trackid='" + trackid + '\'' +
                ", serial_id='" + serial_id + '\'' +
                ", serial_status='" + serial_status + '\'' +
                ", update_set='" + update_set + '\'' +
                ", desc='" + desc + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
