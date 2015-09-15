package com.bczm.widgetcollections.http.protocol;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
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
public class RecommandProtocol extends  BaseProtocol<ArrayList<RecommandPositionInfo>>{
    String  result ="";
    boolean waitflag=true;
    @Override
    protected String loadFromNet(int index ) {
        // 顶部轮播图数据
        JsonObjectRequest topContentRequest=new JsonObjectRequest(NetUtils.FETCH_HOME_TOP_CONTENT,null, new Response.SuccessListener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject object) {
                LogUtils.e(object.toString());
                result= object.toString();
                waitflag=false;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                UIUtils.showToastSafe(volleyError.toString());
//                LogUtils.log2File(volleyError.toString(), FileUtils.DOWNLOAD_DIR + "abc.txt");
                waitflag=false;
                result=null;
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("User-Agent", "Client(ERDO/4.0.11;Android/4.4.4;720*1280;G620S-UL00;PAYMD/1.0.02;)");
                headers.put("Cookie","sto-id-51017=BIBKKIMAMHEJ");
                String value = String.valueOf(System.currentTimeMillis()).subSequence(0, 10).toString();
                headers.put("timestamp",value);
                headers.put("app_id","dm_zk_6001100_81");
                headers.put("client_style","1");
                headers.put("access_token", SharedPreferenceUtils.getAccessToken());
                headers.put("promotion_id","020000000003");
                return headers;
            }
        };

//        topContentRequest.setRetryPolicy()
        HttpUtil.getRequestQueue().add(topContentRequest);

        while(waitflag){
        }
       return result;
    }
    @Override
    protected String getKey() {
        return "recommand";
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
            JSONArray arrays= object.optJSONArray("items");
            JsonHelper.JSONArrayToList(arrays, resultList, RecommandPositionInfo.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  resultList;
    }
}
