package com.bczm.widgetcollections.http;

import com.bczm.widgetcollections.utils.SharedPreferenceUtils;

import java.util.HashMap;
import java.util.Map;

/**  常量类
 * @author：Jorge on 2015/9/7 14:45
 */
public class ConfigManage {


    public static final String HOME_DATA ="http://www.weather.com.cn/data/sk/101010100.html";

    // 点击  进入视频界面 传递 的intent 参数   trackid,content_id
    public static final String INTENT_EXTRA_TRACKID="trackid";
    public static final String INTENT_EXTRA_CONTENT_ID="content_id";

    /**
     *  api  get请求服务器  传递的 头信息
     * @return
     */
public static Map<String, String>  getHeaders(){
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("User-Agent", "Client(ERDO/4.0.11;Android/4.4.4;720*1280;G620S-UL00;PAYMD/1.0.02;)");
    headers.put("Cookie","sto-id-51017=BIBKKIMAMHEJ");
    String value = String.valueOf(System.currentTimeMillis()).subSequence(0, 10).toString();
    headers.put("timestamp",value);
    headers.put("app_id","dm_zk_6001100_81");
    headers.put("client_style","1");
    headers.put("access_token", SharedPreferenceUtils.getAccessToken());
    headers.put("promotion_id","020000000003");
    return  headers;
}

}
