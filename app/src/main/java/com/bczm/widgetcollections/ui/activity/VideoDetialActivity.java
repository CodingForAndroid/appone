package com.bczm.widgetcollections.ui.activity;

import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SharedPreferenceUtils;
import com.bczm.widgetcollections.utils.UIUtils;
import com.bczm.widgetcollections.utils.ViewUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 动画播放界面
 * @author：Jorge on 2015/9/17 13:28
 */
public class VideoDetialActivity  extends BaseActivity {
    protected LoadingPage mContentView;
    private String trackid;
    private String content_id;

    @Override
    protected void createContent() {

        //每次ViewPager要展示该页面时，均会调用该方法获取显示的View
        if (mContentView == null) {//为null时，创建一个

            mContentView = new LoadingPage(this) {
                @Override
                public LoadResult load() {
                    return VideoDetialActivity.this.load();
                }

                @Override
                public View createLoadedView() {
                    return VideoDetialActivity.this.createLoadedView();
                }
            };
        } else {//不为null时，需要把自身从父布局中移除，因为ViewPager会再次添加
            ViewUtils.removeSelfFromParent(mContentView);
        }
            setContentView(mContentView);



//        LogUtils.e();
    }

    @Override
    protected void onResume() {

        super.onResume();
        mContentView.show();
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void free() {

    }
    /** 加载数据 */
    protected  LoadingPage.LoadResult load(){

        trackid = getIntent().getStringExtra(ConfigManage.INTENT_EXTRA_TRACKID);
        content_id = getIntent().getStringExtra(ConfigManage.INTENT_EXTRA_CONTENT_ID);


        return LoadingPage.LoadResult.SUCCEED;
    }

    /** 加载完成的View */
    protected  View createLoadedView(){
        String url="http://api.icartoons.cn/v4/contents/detail";
        StringRequest stringRequest=new StringRequest(url, new Response.SuccessListener<String>() {
            @Override
            public void onResponse(String s) {
            LogUtils.e("VideoPlay============"+s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                LogUtils.e("VideoPlay============"+volleyError.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                return  ConfigManage.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("User-Agent", "Client(ERDO/4.0.11;Android/4.4.4;720*1280;G620S-UL00;PAYMD/1.0.02;)");
                String sign="1442481456268017acdc617508cdb821" ;
                         params.put("sig",sign);
//                String value = String.valueOf(System.currentTimeMillis()).subSequence(0, 10).toString();
                params.put("content_id",content_id);
                params.put("trackid",trackid);

//                http://api.icartoons.cn/v4/contents/detail?
//                trackid=1442478763257496f2f3bfa41f4afb23-c1-4-1-&
//                        content_id=2S201507172200092782&
//                        sig=
//                        BlnPmVBHGBy6wyZsgnrfV7SM%2BjO6DzfDxKvpGrK8%2BzqMkz2Jks6%2F890KJzhH%2Fda4k0M3w7WQs2QLFURMzZRzrhYixqOgCcV%2FPxNlSh0PZxMFkNceDY%2BTLBvPGgqu6Zz00b7pXFTSBCzyckFCA9ubCmzjE2dIVmR2H7Zg4LNlF80%3D


                http://api.icartoons.cn/v4/contents/detail?
//                =1442478763257496f2f3bfa41f4afb23-c1-4-1-&
//                        content_id=2S201507172200092782&
//                        sig=BlnPmVBHGBy6wyZsgnrfV7SM%2BjO6DzfDxKvpGrK8%2BzqMkz2Jks6%2F890KJzhH%2Fda4k0M3w7WQs2QLFURMzZRzrhYixqOgCcV%2FPxNlSh0PZxMFkNceDY%2BTLBvPGgqu6Zz00b7pXFTSBCzyckFCA9ubCmzjE2dIVmR2H7Zg4LNlF80%3D

                return params;
            }
        };
        HttpUtil.getRequestQueue().add(stringRequest);
        TextView tv=     new TextView(UIUtils.getContext());
        tv   .setText("successs");
        return  tv;
    }

}
