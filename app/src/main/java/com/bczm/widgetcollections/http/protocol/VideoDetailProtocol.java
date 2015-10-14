package com.bczm.widgetcollections.http.protocol;

import com.bczm.widgetcollections.bean.ChapterSet;
import com.bczm.widgetcollections.bean.CommentBean;
import com.bczm.widgetcollections.bean.GuessFavoriteBean;
import com.bczm.widgetcollections.bean.VideoDecorationBean;
import com.bczm.widgetcollections.bean.ChapterItem;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.parse.JsonHelper;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SharedPreferenceUtils;
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
    private String desc;
    private List<ChapterItem> list;


    //获取 猜你喜欢
    public  List<GuessFavoriteBean>  getGuessFavorite() {

        List<GuessFavoriteBean> list = null;
        try {
            list = new ArrayList<>();
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
        try {
            List<GuessFavoriteBean> list  = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(ConfigManage.GUESS_FAVOURIATE);
            JSONArray jsonArray = (JSONArray) jsonObject.opt("items");
            JsonHelper.JSONArrayToList(jsonArray, list, GuessFavoriteBean.class);
            beans = new GuessFavoriteBean[list.size()];
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
        try {
            JSONArray      jsonObject = new JSONArray(ConfigManage.VIDEO_DETAIL_DESC);
            desc = jsonObject.optJSONObject(0).opt("description").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return desc;
    }
    //获取评论列表
    public List<CommentBean>  getVideoCommentList(){
        List<CommentBean> list = null;
        try {
            list = new ArrayList<CommentBean>();
            JSONObject jsonObject = new JSONObject(ConfigManage.VIDEO_COMMENT_LIST);
            JSONArray jsonArray = (JSONArray) jsonObject.opt("items");
            JsonHelper.JSONArrayToList(jsonArray, list, CommentBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtils.e("getVideoCommentList:size" + list.size());

        if(SharedPreferenceUtils.getMoreDataTimes()<=1){
            SharedPreferenceUtils.setGetMoreTimes(SharedPreferenceUtils.getMoreDataTimes()+1);
            return list ;
        }else{
            return  null ;
        }
    }

    /**
     * 获取当前 已更新的 集数
     */
    public List<ChapterItem> getVideoSetSize(){

        try {
            list = new ArrayList<>();
            JSONObject jsonObject=new JSONObject(ConfigManage.VIDEO_SET);
            JSONArray  jsonArray = jsonObject.getJSONArray("items");
            JsonHelper.JSONArrayToList(jsonArray, list, ChapterItem.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtils.e("000000000--------"+list.size());
        return list;
    }


}
