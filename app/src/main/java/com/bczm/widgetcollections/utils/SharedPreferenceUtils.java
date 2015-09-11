package com.bczm.widgetcollections.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author：Jorge on 2015/9/11 12:59
 */
public class SharedPreferenceUtils {

    public static void persistenceToken(String  access_token){
        SharedPreferences sp=UIUtils.getContext().getSharedPreferences("Constants", Context.MODE_APPEND);

        sp.edit().putString("access_token", access_token).commit();
    }

    public static String   getAccessToken(){
       return  UIUtils.getContext().getSharedPreferences("Constants", Context.MODE_APPEND).getString("access_token","");
    }
}
