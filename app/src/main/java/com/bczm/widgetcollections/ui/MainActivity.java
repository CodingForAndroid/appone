package com.bczm.widgetcollections.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.FrameLayout;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.fragment.BaseFragment;
import com.bczm.widgetcollections.ui.fragment.FragmentFactory;
import com.bczm.widgetcollections.ui.widget.NoScrollViewPager;
import com.bczm.widgetcollections.ui.widget.PagerTab;
import com.bczm.widgetcollections.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * launch page
 */
public class MainActivity extends BaseActivity {


    @Bind(R.id.tabs)
    PagerTab mPageTabs;
    @Bind(R.id.viewPager)
    NoScrollViewPager mViewPager;
    @Bind(R.id.start_drawer)
    FrameLayout mDrawer;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private  ActionBarDrawerToggle mDrawerToggle;
    private MainPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void createContent() {

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // 设置阴影
        mDrawerLayout.setDrawerShadow(R.drawable.ic_drawer_shadow, GravityCompat.START);
        // 设置drawer的开关监听
        mDrawerLayout.setDrawerListener(new DefaultDrawerListener());
//        MainFragment fragment = new MainFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.content_frame,fragment,fragment.getClass().getName()).commit();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void setListeners() {
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mPageTabs.setViewPager(mViewPager);
        mPageTabs.setOnPageChangeListener(new MyOnPageChangeListener());
        mViewPager.setOffscreenPageLimit(1);
    }



    @Override
    protected void free() {

    }

    /**
     * ActionBar 的初始化
     */
    @Override
    protected void initActionBar() {
        ActionBar mActionBar = getSupportActionBar();
        // 设置标题
        mActionBar.setTitle(R.string.app_name);
        //设置显示左侧按钮
        mActionBar.setDisplayHomeAsUpEnabled(true);
        //设置左侧按钮可点
        mActionBar.setHomeButtonEnabled(true);
        //初始化开关，并和drawer关联
       mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close);
        //该方法会自动和actionBar关联
        mDrawerToggle.syncState();
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
            // ViewPager页面被选中的回调
            BaseFragment fragment = FragmentFactory.createFragment(index);
            // 当页面被选中 再显示要加载的页面....防止ViewPager提前加载(ViewPager一般加载三个，自己，左一个，右一个)
//            fragment.show();// 调用show方法加载pager里面的数据
        }
    }
    /** drawer的监听 */
    private class DefaultDrawerListener implements DrawerLayout.DrawerListener {
        @Override
        public void onDrawerOpened(View drawerView) {// 打开drawer
            mDrawerToggle.onDrawerOpened(drawerView);//需要把开关也变为打开
        }

        @Override
        public void onDrawerClosed(View drawerView) {// 关闭drawer
            mDrawerToggle.onDrawerClosed(drawerView);//需要把开关也变为关闭
        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {// drawer滑动的回调
            mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
        }

        @Override
        public void onDrawerStateChanged(int newState) {// drawer状态改变的回调
            mDrawerToggle.onDrawerStateChanged(newState);
        }
    }
}
