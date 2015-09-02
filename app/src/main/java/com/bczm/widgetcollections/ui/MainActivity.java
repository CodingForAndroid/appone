package com.bczm.widgetcollections.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.fragment.MainFragment;
import com.bczm.widgetcollections.utils.AnimationUtil;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * launch page
 */
public class MainActivity extends BaseActivity {


    @Override
    protected void createContent() {
    setContentView(R.layout.activity_main);
        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_frame,fragment,fragment.getClass().getName()).commit();
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



}
