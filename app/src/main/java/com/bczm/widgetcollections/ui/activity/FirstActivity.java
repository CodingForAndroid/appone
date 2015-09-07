package com.bczm.widgetcollections.ui.activity;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.SuccessListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.ui.BaseActivity;
import com.bczm.widgetcollections.utils.FileUtils;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SystemUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Method;

/**
 * @author：Jorge on 2015/9/6 17:37
 */
public class FirstActivity extends BaseActivity implements TextureView.SurfaceTextureListener {
    @Override
    protected void createContent() {
//        UIUtils.showToastSafe("0");
//        ConfigManage.HOME_DATA
//        RequestQueue mQueue=       HttpUtil.getRequestQueue();
//        JsonObjectRequest request=new JsonObjectRequest(ConfigManage.HOME_DATA, null, new SuccessListener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//                UIUtils.showToastSafe("2");
//                UIUtils.showToastSafe(jsonObject.toString());
//              String lcoalpaht=  FileUtils.getDownloadDir()+"a.txt";
//                UIUtils.showToastSafe(lcoalpaht);
//                LogUtils.log2File(jsonObject.toString(),lcoalpaht);
//            }
//        }, new ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                UIUtils.showToastSafe("3");
//            }
//        });
//        UIUtils.showToastSafe("1");
//        mQueue.add(request);

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void free() {

    }

    @Override
    protected void initActionBar() {

    }

    public  void  init(){
        TextureView myTexture = new TextureView(this);
        myTexture.setSurfaceTextureListener(this);
        setContentView(myTexture);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Surface s = new Surface(surfaceTexture);
//        s.setSize(width,height);
        try{
            MediaPlayer    mPlayer = new MediaPlayer();
//            System.out.println("MMS mMediaUri :"+mMediaUri+" width:"+width
//                    +" height:"+height);
//            mPlayer.setDataSource(FirstActivity.this, mMediaUri, null);
            mPlayer.setSurface(s);
            mPlayer.prepare();
            mPlayer.start();
        }catch(Exception e)
        {
            System.out.println("AMMS Exception e:"+e);
        }
    }


    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }
}
