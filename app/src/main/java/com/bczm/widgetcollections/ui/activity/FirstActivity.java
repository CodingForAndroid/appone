package com.bczm.widgetcollections.ui.activity;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView;

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
    protected void setListeners() {

    }

    @Override
    protected void free() {

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
