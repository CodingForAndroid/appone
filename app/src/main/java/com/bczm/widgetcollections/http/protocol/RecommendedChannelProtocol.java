package com.bczm.widgetcollections.http.protocol;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bczm.widgetcollections.bean.RecommendedChannel;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.utils.FileUtils;
import com.bczm.widgetcollections.utils.LogUtils;
import com.google.gson.Gson;
import java.util.Map;

/**
 * 推荐频道请求
 * @author：Jorge on 2015/9/16 11:22
 */
public class RecommendedChannelProtocol extends  BaseProtocol<RecommendedChannel>{
    boolean waitflag=true;
    String  result ="";
    @Override
    protected String loadFromNet(int index) {
      //获取推荐频道
        StringRequest stringRequest=new StringRequest(NetUtils.FETCH_RECOMMEND_CHANNELS,new Response.SuccessListener<String>() {
            @Override
            public void onResponse(String s) {
                LogUtils.log2File(s, FileUtils.getDownloadDir()+"FETCH_RECOMMEND_CHANNELS.txt");
                  result =s;
                waitflag=false;
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                result =null;
                waitflag=false;
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return    ConfigManage.getHeaders();
            }
        };

        HttpUtil.getRequestQueue().add(stringRequest);
        while(waitflag){

        }
        return result;
    }

    @Override
    protected String getKey() {
        return "recommendedchannelprotocol";
    }

    @Override
    protected RecommendedChannel parseFromJson(String json) {
        Gson gson= new Gson ();
        RecommendedChannel recommendedChannel= gson.fromJson(json,RecommendedChannel.class);
        return recommendedChannel;
    }
}
