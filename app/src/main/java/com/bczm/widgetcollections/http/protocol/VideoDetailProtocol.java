package com.bczm.widgetcollections.http.protocol;

import com.bczm.widgetcollections.bean.GuessFavoriteBean;
import com.bczm.widgetcollections.bean.VideoDecorationBean;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.parse.JsonHelper;
import com.bczm.widgetcollections.utils.LogUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 视频播放页 协议
 * @author：Jorge on 2015/9/17 15:49
 */
public class VideoDetailProtocol {

    private GuessFavoriteBean[] beans;

    //获取 猜你喜欢
    public  List<GuessFavoriteBean>    getGuessFavorite() {

        List<GuessFavoriteBean> list = null;
        try {
            list = new ArrayList<GuessFavoriteBean>();
            JSONObject jsonObject = new JSONObject(ConfigManage.GUESS_FAVOURIATE);
            JSONArray jsonArray = (JSONArray) jsonObject.opt("items");
            JsonHelper.JSONArrayToList(jsonArray, list, GuessFavoriteBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    //获取 猜你喜欢
    public  GuessFavoriteBean[] getGuessFavoriteArray() {

//        List<GuessFavoriteBean> list = null;
        try {
            List<GuessFavoriteBean> list  = new ArrayList<GuessFavoriteBean>();
            JSONObject jsonObject = new JSONObject(ConfigManage.GUESS_FAVOURIATE);
            JSONArray jsonArray = (JSONArray) jsonObject.opt("items");
            JsonHelper.JSONArrayToList(jsonArray, list, GuessFavoriteBean.class);
            beans = new GuessFavoriteBean[list.size()];
            LogUtils.e("-----------------47"+list.size());
           for(int i=0;i<list.size();i++){
               beans[i]=list.get(i);
           }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beans;
    }

    //获取 当前播放视频url
    public VideoDecorationBean   getVideoCurrentPlay(){
        return  new Gson().fromJson( ConfigManage.VIDEO_CURRENT_PLAY, VideoDecorationBean.class);
    }
    //获取 视频介绍
    public String   getVideoDetailDesc(){

        return ConfigManage.VIDEO_DETAIL_DESC;
    }


}
