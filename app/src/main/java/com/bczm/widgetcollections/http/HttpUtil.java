package com.bczm.widgetcollections.http;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.GsonRequest;
import com.android.volley.toolbox.Volley;
import com.bczm.widgetcollections.bean.TouristInfo;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SharedPreferenceUtils;
import com.squareup.okhttp.OkHttpClient;

import java.util.HashMap;
import java.util.Map;

/**  prepare volley  requestqueue
 * @author：Jorge on 2015/9/7 14:35
 */
public class HttpUtil {

    private  static   RequestQueue mRequestQueue;

    /**
     * 初始化 Volley
     * @param context
     */
    public static void init(Context context) {
        mRequestQueue  = Volley.newRequestQueue(context,new OkHttpStack(new OkHttpClient()));
//        mImageLoader = new SimpleImageLoader(mRequestQueue, BitmapImageCache.getInstance(null));
//        Volley.newRequestQueue(getApplicationContext()).setRetryPolicy(getRetryPolicy())
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }


    /**
     * 保存 token
     */
    public static void getAssToken(){
        //  创建 request 对象
        GsonRequest<TouristInfo> getTouristInfoRequest= new GsonRequest<TouristInfo>(Request.Method.GET, NetUtils.FETCH_VALID_TOKEN, TouristInfo.class,new Response.SuccessListener<TouristInfo>() {
            @Override
            public void onResponse(TouristInfo touristInfo) {
                LogUtils.e(touristInfo.toString());
                SharedPreferenceUtils.persistenceToken(touristInfo.access_token);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
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
                headers.put("client_style","0");
                headers.put("access_token","");
                headers.put("promotion_id","020000000003");
                return headers;
            }

        };
        //获取 requestqueue 对象
        RequestQueue mQueue= HttpUtil.getRequestQueue();
        //  添加  request  到  queue 中
        getTouristInfoRequest.setTag("getTouristInfoRequest");
        mQueue.add(getTouristInfoRequest);
    }
}
