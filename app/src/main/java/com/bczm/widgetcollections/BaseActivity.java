package com.bczm.widgetcollections;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

/**
 * @author£ºJorge on 2015/8/26 18:03
 */
public abstract  class BaseActivity extends FragmentActivity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
          createContent();
          initViews();
          setListeners();
          free();
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



}
