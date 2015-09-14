package com.bczm.widgetcollections.manager;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.utils.UIUtils;

/**网络图片 显示
 * @author：Jorge on 2015/9/14 13:09
 */
public class ImageLoader {

    public static  ImageLoader  getInstance(){
        ImageLoader imageLoader=new ImageLoader();
        return  imageLoader;
    }
    public void imageLoaderRequest(ImageView imageView,String  imageUrl){
        RequestQueue mQueue = Volley.newRequestQueue(UIUtils.getContext());
        com.android.volley.toolbox. ImageLoader imageLoader = new   com.android.volley.toolbox.ImageLoader(mQueue, new BitmapCache());
        com.android.volley.toolbox.ImageLoader.ImageListener listener = imageLoader.getImageListener(imageView,
                R.mipmap.loadingpic, R.mipmap.loadingpic);

        imageLoader.get(imageUrl, listener);

    }


    public void imageRequest(String  path, final NetworkImageView  imageview){

        RequestQueue mQueue = Volley.newRequestQueue(UIUtils.getContext());
        com.android.volley.toolbox.ImageLoader imageLoader = new com.android.volley.toolbox.ImageLoader(mQueue, new BitmapCache());


        imageview.setImageUrl(path,imageLoader);
    }
     class BitmapCache implements com.android.volley.toolbox.ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            int maxSize = 10 * 1024 * 1024;
            mCache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }

    }

}
