package com.bczm.widgetcollections.http.parse;
import com.bczm.widgetcollections.bean.RecommendedChannel;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.UIUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：Jorge on 2015/9/11 17:11
 */
public  class JsonHelper {

    private static JSONObject jsonObject;

    //讲JSONArray 转成 存储信息的 list集合
    public static List JSONArrayToList(JSONArray array,List list,Class clazz){
        Gson gson = new Gson();
        for (int i = 0; i < array.length(); i++) {
            list.add(gson.fromJson(array.optString(i),clazz));
          LogUtils.e(array.optString(i).toString());
//                  LogUtils.log2File(info.toString(), FileUtils.getDownloadDir() + "log.txt");
        }
          return  list;
    }

    /**
     *  解析 推荐 频道
     * @param json
     * @return
     */
    public  static RecommendedChannel  parseRecommandChannel( String json){

        Gson gson= new Gson ();
        RecommendedChannel recommendedChannel= gson.fromJson(json,RecommendedChannel.class);
        LogUtils.e("---111:"+recommendedChannel.toString());
        return recommendedChannel;
    }

    public  static JSONObject String2JSONObject(String json){
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
