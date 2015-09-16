package com.bczm.widgetcollections.http.protocol;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.http.parse.JsonHelper;
import com.bczm.widgetcollections.utils.FileUtils;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * 顶部6个流行位置
 * @author：Jorge on 2015/9/16 10:57
 */
public class RecommendedPopProtocol extends BaseProtocol<ArrayList<RecommandPositionInfo>> {
    boolean waitflag=true;
    String  result ="";
    @Override
    protected String loadFromNet(int index) {
        // 轮播图下面的六个item
        StringRequest popContentRequest=new StringRequest(NetUtils.FETCH_POPULAR_CONTENT, new Response.SuccessListener<String>() {
            @Override
            public void onResponse( String s) {
                LogUtils.e("StringRequest:"+s.toString());
                result=s;
                waitflag=false;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                result= null;
                waitflag=false;
                UIUtils.showToastSafe(volleyError.toString());
                LogUtils.log2File(volleyError.toString(), FileUtils.getDownloadDir() + "abc.txt");
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                return    ConfigManage.getHeaders();
            }
        };

        HttpUtil.getRequestQueue().add(popContentRequest);
        while(waitflag){

        }
        return result;
    }

    @Override
    protected String getKey() {
        return "recommendedpopprotocol";
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
        LogUtils.e("StringRequest:"+resultList.size());
        return  resultList;
    }
}
