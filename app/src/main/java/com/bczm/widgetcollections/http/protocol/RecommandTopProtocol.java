package com.bczm.widgetcollections.http.protocol;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.http.parse.JsonHelper;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SharedPreferenceUtils;
import com.bczm.widgetcollections.utils.UIUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 顶部轮播图的请求
 * @author：Jorge on 2015/9/14 17:51
 */
public class RecommandTopProtocol extends  BaseProtocol<ArrayList<RecommandPositionInfo>>{
    String  result ="";
    boolean waitflag=true;
    @Override
    protected String loadFromNet(int index ) {
        // 顶部轮播图数据
        JsonObjectRequest topContentRequest=new JsonObjectRequest(NetUtils.FETCH_HOME_TOP_CONTENT,null, new Response.SuccessListener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject object) {
                result= object.toString();
                waitflag=false;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                UIUtils.showToastSafe(volleyError.toString());
                waitflag=false;
                result=null;
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return ConfigManage.getHeaders();
            }
        };

        topContentRequest.setTag("topContentRequest");
        HttpUtil.getRequestQueue().add(topContentRequest);
        HttpUtil.getRequestQueue().addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
                LogUtils.e("topContentRequest:onRequestFinished----"+request.getTag());
            }
        });

        while(waitflag){
        }
       return result;
    }
    @Override
    protected String getKey() {
        return "recommandtopprotocol";
    }

    @Override
    protected ArrayList<RecommandPositionInfo> parseFromJson(String json) {
        return parseJson(json);
    }

    public  ArrayList<RecommandPositionInfo>  parseJson(String json){
        ArrayList<RecommandPositionInfo> resultList = null;
        try {
            JSONObject  object= new JSONObject(json);
            resultList = new ArrayList<RecommandPositionInfo>();
            if(!object.has("items"))
                return  null;
            JSONArray arrays= object.optJSONArray("items");
            JsonHelper.JSONArrayToList(arrays, resultList, RecommandPositionInfo.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  resultList;
    }
}
