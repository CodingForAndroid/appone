package com.bczm.widgetcollections.http.protocol;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.http.parse.JsonHelper;
import com.bczm.widgetcollections.utils.FileUtils;
import com.bczm.widgetcollections.utils.LayoutGenetator;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SharedPreferenceUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author：Jorge on 2015/9/14 17:51
 */
public class RecomandProtocol  extends  BaseProtocol<List<String>>{


    @Override
    protected String loadFromNet(int index) {

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(NetUtils.FETCH_HOME_TOP_CONTENT,null, new Response.SuccessListener<JSONObject>() {
            @Override
            public void onResponse(JSONObject object) {
                LogUtils.e(object.toString());
                LogUtils.e(FileUtils.getDownloadDir()+"log.txt");
                LogUtils.log2File(object.toString(), FileUtils.getDownloadDir() + "log.txt");
                ArrayList<RecommandPositionInfo> resultList = new ArrayList<RecommandPositionInfo>();

                JSONArray arrays= object.optJSONArray("items");
                JsonHelper.JSONArrayToList(arrays, resultList, RecommandPositionInfo.class);
                // 此时list 已经包含信息
//                LayoutGenetator.getneratePagerView(resultList, getActivity(), relativeLayout);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                UIUtils.showToastSafe(volleyError.toString() );
                LogUtils.log2File(volleyError.toString(), FileUtils.DOWNLOAD_DIR+"abc.txt");
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
        HttpUtil.getRequestQueue().add(jsonObjectRequest);



        return null;
    }

    @Override
    protected String getKey() {
        return null;
    }

    @Override
    protected List<String> parseFromJson(String json) {
        return new ArrayList<String>();
    }
}
