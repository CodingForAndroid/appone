package com.bczm.widgetcollections.bean;

/**
 * 封装 游客信息， 不全，只声明 几个具体参数返回值的 属性
 * @author：Jorge on 2015/9/11 13:28
 */
public class TouristInfo {
    //	{
//	    "access_token": "7c65d18d2b3fe55ae78fc470c5d3bc8c",
//	    "expires_in": 86400,
//	    "timestamp": 1441944296,
//	    "uid": "74559208",
//	    "login_type": 0,
//	    "ticket": "W150Z3PpdWsvFrpX40awwG008KpCel6UeflYSxrxBLS3hcoUwM4kh+dNkLizWYUjD754ba3HkQQs0wV9AWXQRA==",
//	    "show_alert": 0,
//	    "username": "",
//	    "nickname": "游客",
//	    "phone": "",
//	    "photo": "",
//	    "is_vip": 0,
//	    "is_show": 0,
//	    "user_type": 5,
//	    "need_logout": 0,
//	    "update_nickname": 0,
//	    "log_level": 0
//	}
    // token  每次请求 必带 参数， 具有时效性
    public  String  access_token;
    // 过期时间 86400  （24小时）
    public  String  expires_in;
    // 时间戳  System.CurrentMills 截取 前十位;
    public  String  timestamp;
    // user id
    public  String  uid;
    // login_type  未登录：0   注册用户登录：未知  第三方登陆：未知
    public  String  login_type;
    // ticket   未知参数
    public  String  ticket;


    @Override
    public String toString() {
        return "TouristInfo{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", uid='" + uid + '\'' +
                ", login_type='" + login_type + '\'' +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}
