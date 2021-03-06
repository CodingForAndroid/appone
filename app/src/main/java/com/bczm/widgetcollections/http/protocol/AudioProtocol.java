package com.bczm.widgetcollections.http.protocol;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bczm.widgetcollections.bean.MusicsListPackage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.utils.LogUtils;
import com.google.gson.Gson;

/**
 * @author：Jorge on 2015/10/10 11:48
 */
public class AudioProtocol extends BaseProtocol<MusicsListPackage> {
    boolean waitflag=true;
    String  result ="";
    @Override
    protected String loadFromNet(int index) {
        //随机获取一首歌曲
        StringRequest request=new StringRequest(NetUtils.FETCH_AUDIO,new Response.SuccessListener<String>() {
            @Override
            public void onResponse(String s) {
                result =s;
                waitflag=false;
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                LogUtils.e("onErrorResponse:"+volleyError.toString());
                result =null;
                waitflag=false;
            }
        }){

        };

        HttpUtil.getRequestQueue().add(request);
        while(waitflag){

        }
        return result;
    }

    @Override
    protected String getKey() {
        return "audioprotocol";
    }

    @Override
    protected MusicsListPackage parseFromJson(String json) {
        Gson gson= new Gson ();
        MusicsListPackage audioInfo= gson.fromJson(json, MusicsListPackage.class);
        return audioInfo;
    }
}
