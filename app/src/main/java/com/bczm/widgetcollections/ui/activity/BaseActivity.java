package com.bczm.widgetcollections.ui.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author Jorge on 2015/8/26 18:03
 */
public abstract  class BaseActivity extends FragmentActivity {
    /** 记录处于前台的Activity */
    private static BaseActivity mForegroundActivity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        createContent();
        initViews();
        initActionBar();
        setListeners();
    }

    @Override
    protected void onResume() {
        mForegroundActivity = this;
        super.onResume();
    }

    @Override
    protected void onPause() {
        mForegroundActivity = null;
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        free();
    }

    /** 获取当前处于前台的activity */
    public static BaseActivity getForegroundActivity() {
        return mForegroundActivity;
    }
    /**
     * setContentView(int layoutResID)
     */
    protected abstract  void  createContent();
    /**
     *  find views by  id
     */
    protected  abstract void    initViews();

    /**
     * all kinds of listener on views / such as onclicklistener
     */
    protected  abstract  void   setListeners();
    /**
     * release  memory
     */
    protected  abstract  void   free();


    protected abstract  void  initActionBar();

}