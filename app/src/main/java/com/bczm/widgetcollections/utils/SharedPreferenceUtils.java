package com.bczm.widgetcollections.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author：Jorge on 2015/9/11 12:59
 */
public class SharedPreferenceUtils {

    public static void persistenceToken(String  access_token){
        SharedPreferences sp=UIUtils.getContext().getSharedPreferences("Constants", Context.MODE_PRIVATE);

        sp.edit().putString("access_token", access_token).commit();
    }

    public static String   getAccessToken(){
       return  UIUtils.getContext().getSharedPreferences("Constants", Context.MODE_PRIVATE).getString("access_token","");
    }

    /**
     * 加载更多  获取
     * @return
     */
    public static int   getMoreDataTimes(){
       return  UIUtils.getContext().getSharedPreferences("Constants", Context.MODE_PRIVATE).getInt("onceMore", 0);
    }
    // 保存加载次数
    public static  void setGetMoreTimes(int  times){
        SharedPreferences sp=UIUtils.getContext().getSharedPreferences("Constants", Context.MODE_PRIVATE);

        sp.edit().putInt("onceMore", times).commit();
    }
}
