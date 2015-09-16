package com.bczm.widgetcollections.http.protocol;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.bczm.widgetcollections.bean.RecommendAppInfo;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.http.parse.JsonHelper;
import com.bczm.widgetcollections.utils.FileUtils;
import com.bczm.widgetcollections.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取推荐应用协议
 * @author：Jorge on 2015/9/16 16:52
 */
public class RecommendedAppProtocol extends BaseProtocol <List<RecommendAppInfo>> {
    boolean waitflag=true;
    String  result ="";
    private ArrayList<RecommendAppInfo> list;

    @Override
    protected String loadFromNet(int index) {
        StringRequest stringRequest=new StringRequest(NetUtils.FETCH_RECOMMENDED_APP,new Response.SuccessListener<String>() {
            @Override
            public void onResponse(String s) {
//                LogUtils.log2File(s, FileUtils.getDownloadDir() + "FETCH_RECOMMEND_CHANNELS.txt");
                LogUtils.e("RecommendedAppProtocol:"+s);
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
        return "recommendedappprotocol";
    }

    @Override
    protected List<RecommendAppInfo> parseFromJson(String json) {
        try {

          JSONObject jsonObject=new JSONObject(json);
            if(!jsonObject.has("items"))
                return  null;
            list = new ArrayList<>();
            JSONArray arrays=  jsonObject.optJSONArray("items");
            JsonHelper.JSONArrayToList(arrays, list,RecommendAppInfo.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null ;
        }
        return list;
    }
}
