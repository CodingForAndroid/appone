package com.bczm.widgetcollections.http;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**  prepare volley  requestqueue
 * @author：Jorge on 2015/9/7 14:35
 */
public class HttpUtil {

    private  static   RequestQueue mRequestQueue;

    public static void init(Context context) {
        mRequestQueue  = Volley.newRequestQueue(context);
//        mImageLoader = new SimpleImageLoader(mRequestQueue, BitmapImageCache.getInstance(null));
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }
}
