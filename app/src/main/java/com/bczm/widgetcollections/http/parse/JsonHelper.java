package com.bczm.widgetcollections.http.parse;
import com.bczm.widgetcollections.utils.UIUtils;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：Jorge on 2015/9/11 17:11
 */
public  class JsonHelper {

    //讲JSONArray 转成 存储信息的 list集合
    public static ArrayList JSONArrayToList(JSONArray array,ArrayList list,Class clazz){
        Gson gson = new Gson();
        for (int i = 0; i < array.length(); i++) {
            list.add(gson.fromJson(array.optString(i),clazz));
//            UIUtils.showToastSafe(array.optString(i));
//                  LogUtils.log2File(info.toString(), FileUtils.getDownloadDir() + "log.txt");
        }
          return  list;
    }


}
