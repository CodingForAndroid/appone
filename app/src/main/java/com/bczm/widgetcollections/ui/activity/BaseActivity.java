package com.bczm.widgetcollections.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Jorge on 2015/8/26 18:03
 */
public abstract  class BaseActivity extends AppCompatActivity{
    /** 记录处于前台的Activity */
    private static BaseActivity mForegroundActivity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createContent();
        initViews();
        initActionBar();
        setListeners();
        free();


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