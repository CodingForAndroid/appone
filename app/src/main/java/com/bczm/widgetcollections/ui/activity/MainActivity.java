package com.bczm.widgetcollections.ui.activity;

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
import android.widget.Button;
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

    @Bind(R.id.pager)
     ViewPager mViewPager;

    @Bind(R.id.btn_cartoon)
    Button mCartoonBtn;
    @Bind(R.id.btn_news)
    Button mNewsBtn;
    @Bind(R.id.btn_novel)
    Button mNovelBtn;
    @Bind(R.id.btn_mine)
    Button mMineBtn;
    private MainPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void createContent() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tabchange(0);
    }

    @Override
    protected void initViews() {


    }

    @Override
    protected void setListeners() {
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);

//        mViewPager.setOffscreenPageLimit(0);
        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    @Override
    protected void free() {

    }

    /**
     * ActionBar 的初始化
     */
    @Override
    protected void initActionBar() {
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
            fragment.show();// 调用show方法加载pager里面的数据

               tabchange(index);

        }
    }

    private void tabchange(int index) {
        switch (index){
            case 0:
                mCartoonBtn.setPressed(true);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.white));
                mNewsBtn.setPressed(false);
                mNewsBtn.setTextColor(getResources().getColor(R.color.blue));
                mNovelBtn.setPressed(false);
                mNovelBtn. setTextColor(getResources().getColor(R.color.blue));
                mMineBtn.setPressed(false);
                mMineBtn. setTextColor(getResources().getColor(R.color.blue));
                break;
            case 1:
                mCartoonBtn.setPressed(false);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mNewsBtn.setPressed(true);
                mNewsBtn.setTextColor(getResources().getColor(R.color.white));
                mNovelBtn.setPressed(false);
                mNovelBtn.setTextColor(getResources().getColor(R.color.blue));
                mMineBtn.setPressed(false);
                mMineBtn.setTextColor(getResources().getColor(R.color.blue));
                break;
            case 2:
                mCartoonBtn.setPressed(false);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mNewsBtn.setPressed(false);
                mNewsBtn.setTextColor(getResources().getColor(R.color.blue));
                mNovelBtn.setPressed(true);
                mNovelBtn.setTextColor(getResources().getColor(R.color.white));
                mMineBtn.setPressed(false);
                mMineBtn.setTextColor(getResources().getColor(R.color.blue));
                break;
            case 3:
                mCartoonBtn.setPressed(false);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mNewsBtn.setPressed(false);
                mNewsBtn.setTextColor(getResources().getColor(R.color.blue));
                mNovelBtn.setPressed(false);
                mNovelBtn.setTextColor(getResources().getColor(R.color.blue));
                mMineBtn.setPressed(true);
                mMineBtn.setTextColor(getResources().getColor(R.color.white));
                break;
            default:
                break;
        }
    }
}
