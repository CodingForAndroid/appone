package com.bczm.widgetcollections.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.utils.AnimationUtil;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 *  launch page
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.run_image)
    ImageView runImage;

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void createContent() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void initViews() {


    }
    private void runAnimation() {
    AnimationUtil.runAnimation(runImage);

    }

    @Override
    protected void setListeners() {
        runAnimation();
    }

    @Override
    protected void free() {

    }
}
