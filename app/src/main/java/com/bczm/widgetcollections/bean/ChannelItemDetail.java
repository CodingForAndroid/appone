package com.bczm.widgetcollections.bean;

/**
 * 推荐 频道 一个推荐单位 的详细信息
 * Created by Administrator on 2015/9/15.
 */
public class ChannelItemDetail {

    //http://img0.icartoons.cn/opftp/20150718/7504/201507172200092782/cover/720x405.jpg?... 需要截取
    public  String  pic;
    //http://img0.icartoons.cn/opftp/c4x_pic/position/201508/20150812114009332619.jpg?.... 需要截取
    public  String  cover;
    //2S201507172200092782
    public String serial_id;
    //0
    public String serial_status;
    //1
    public String serial_type;
    //偶像大师女孩灰姑娘2
    public String title;
    //每周六12:00更新
    public String sub_title;
//    老牌艺人事务所“346Production”旗下拥有众多偶像艺人。如今事务所推出了全新组合“CINDERELLA PROJECT（灰姑娘计划）”，被选中的少女们从此走上了偶像演艺之路。
public String desc;
    //8  更新到 第几集
    public String update_set;
    // 0
    public String w_type;
    // ""
    public String superscript;
    //144193462087532696eb757e02b6f42a-c15-365-1-
    public String trackid;

    @Override
    public String toString() {
        return "ChannelItemDetail{" +
                "pic='" + pic + '\'' +
                ", cover='" + cover + '\'' +
                ", serial_id='" + serial_id + '\'' +
                ", serial_status='" + serial_status + '\'' +
                ", serial_type='" + serial_type + '\'' +
                ", title='" + title + '\'' +
                ", sub_title='" + sub_title + '\'' +
                ", desc='" + desc + '\'' +
                ", update_set='" + update_set + '\'' +
                ", w_type='" + w_type + '\'' +
                ", superscript='" + superscript + '\'' +
                ", trackid='" + trackid + '\'' +
                '}';
    }
}
