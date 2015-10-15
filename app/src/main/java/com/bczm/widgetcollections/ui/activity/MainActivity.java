package com.bczm.widgetcollections.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.GsonRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.bczm.widgetcollections.BaseApplication;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.TouristInfo;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.ui.fragment.BaseFragment;
import com.bczm.widgetcollections.ui.fragment.FragmentFactory;
import com.bczm.widgetcollections.ui.widget.NoScrollViewPager;
import com.bczm.widgetcollections.utils.FileUtils;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SharedPreferenceUtils;
import com.bczm.widgetcollections.utils.UIUtils;
import com.android.volley.Request.Method;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * launch page
 */
public class MainActivity extends BaseActivity {
    @Bind(R.id.pager)
    NoScrollViewPager mViewPager;
    @Bind(R.id.btn_cartoon)
    Button mCartoonBtn;
    @Bind(R.id.btn_tv)
    Button mTVBtn;
    @Bind(R.id.btn_audio)
    Button mAudioBtn;
    @Bind(R.id.btn_video)
    Button mVideoBtn;

    // 双击退出  记时
    private static long DOUBLE_CLICK_TIME = 0L;
    private MainPagerAdapter pagerAdapter;
    @Override
    protected void createContent() {
        HttpUtil.getAssToken();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);initTabs();

        tabChange(0);
    }
    //底部 tab 的点击事件
    public  void onClick(View view){
      switch (view.getId()){
          case R.id.btn_cartoon: //第一页
              changeFragment(FragmentFactory.TAB_FIRST);
              break;
          case R.id.btn_tv://第2页
              changeFragment(FragmentFactory.TAB_SECOND);
              break;
          case R.id.btn_audio://第3页
              changeFragment(FragmentFactory.TAB_THIRD);
              break;
          case R.id.btn_video://第4页
              changeFragment(FragmentFactory.TAB_FOURTH);
              break;
      }
    }


    @Override
    protected void setListeners() {
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }
    @Override
    protected void free() {

    }

    MediaPlayer mp;
    @Override
    protected void onResume() {

//        play();
        super.onResume();
    }
    @Override
    protected void onStop() {
        super.onStop();
//        mp.stop();
    }

    public void play() {
        mp = MediaPlayer.create(MainActivity.this, R.raw.kiss);

        new Thread() {
            public void run() {
                mp.start();
            }

            ;
        }.start();
    }

    public void  initTabs(){
        String[] names= UIUtils.getStringArray(R.array.tab_names);
        Button[] mTabs={mCartoonBtn,mTVBtn,mAudioBtn,mVideoBtn};
        for (int i=0;i<mTabs.length;i++){
            mTabs[i].setText(""+names[i]);
        }
    }

    private void tabChange(int index) {

        switch (index){
            case 0:
                mCartoonBtn.setBackgroundResource(R.color.blue);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.white));
                mTVBtn.setBackgroundResource(R.color.transparent);
                mTVBtn.setTextColor(getResources().getColor(R.color.blue));
                mAudioBtn.setBackgroundResource(R.color.transparent);
                mAudioBtn. setTextColor(getResources().getColor(R.color.blue));
                mVideoBtn.setBackgroundResource(R.color.transparent);
                mVideoBtn. setTextColor(getResources().getColor(R.color.blue));
                break;
            case 1:
                mCartoonBtn.setBackgroundResource(R.color.transparent);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mTVBtn.setBackgroundResource(R.color.blue);
                mTVBtn.setTextColor(getResources().getColor(R.color.white));
                mAudioBtn.setBackgroundResource(R.color.transparent);
                mAudioBtn.setTextColor(getResources().getColor(R.color.blue));
                mVideoBtn.setBackgroundResource(R.color.transparent);
                mVideoBtn.setTextColor(getResources().getColor(R.color.blue));
                break;
            case 2:
                mCartoonBtn.setBackgroundResource(R.color.transparent);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mTVBtn.setBackgroundResource(R.color.transparent);
                mTVBtn.setTextColor(getResources().getColor(R.color.blue));
                mAudioBtn.setBackgroundResource(R.color.blue);
                mAudioBtn.setTextColor(getResources().getColor(R.color.white));
                mVideoBtn.setBackgroundResource(R.color.transparent);
                mVideoBtn.setTextColor(getResources().getColor(R.color.blue));
                break;
            case 3:
                mCartoonBtn.setBackgroundResource(R.color.transparent);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mTVBtn.setBackgroundResource(R.color.transparent);
                mTVBtn.setTextColor(getResources().getColor(R.color.blue));
                mAudioBtn.setBackgroundResource(R.color.transparent);
                mAudioBtn.setTextColor(getResources().getColor(R.color.blue));
                mVideoBtn.setBackgroundResource(R.color.blue);
                mVideoBtn.setTextColor(getResources().getColor(R.color.white));
                break;
            default:
                break;


        }
        mViewPager.setCurrentItem(index);
    }

    /** ViewPager的适配器 */
    public class MainPagerAdapter extends FragmentPagerAdapter {
        private String[] mTabTitle;

        public MainPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            mTabTitle = UIUtils.getStringArray(R.array.tab_names);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabTitle[position];
        }

        @Override
        public int getCount() {
            return mTabTitle.length;
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createFragment(position);
        }
    }
    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {
            //ViewPager滑动状态改变的回调
        }

        @Override
        public void onPageScrolled(int index, float offset, int offsetPx) {
            //ViewPager滑动时的回调
        }

        @Override
        public void onPageSelected(int index) {

            changeFragment(index);
        }
    }

    /**
     * 更换要显示的Fragment
     * @param index
     */
    public void  changeFragment(int index){
        // ViewPager页面被选中的回调
        BaseFragment fragment = FragmentFactory.createFragment(index);
        // 当页面被选中 再显示要加载的页面....防止ViewPager提前加载(ViewPager一般加载三个，自己，左一个，右一个)
        fragment.show();// 调用show方法加载pager里面的数据
        tabChange(index);
    }

    //双击退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis()-DOUBLE_CLICK_TIME>2000){// 2秒之内 双击两次退出
                UIUtils.showToastSafe("再点击一次 退出");
                DOUBLE_CLICK_TIME  = System.currentTimeMillis();
            }else{
                BaseApplication.getApplication().exitApp();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
