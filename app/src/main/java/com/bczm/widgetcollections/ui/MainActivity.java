package com.bczm.widgetcollections.ui;


import android.media.MediaPlayer;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.fragment.MainFragment;

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

    MediaPlayer mp;
    @Override
    protected void onResume() {
        play();
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
    }

    public void play(){
        mp = MediaPlayer.create(MainActivity.this, R.raw.kiss);

        new Thread(){
            public void run() {
                mp.start();
            };
        }.start();
    }
}
