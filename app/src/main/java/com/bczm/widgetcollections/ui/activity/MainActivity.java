package com.bczm.widgetcollections.ui.activity;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.fragment.BaseFragment;
import com.bczm.widgetcollections.ui.fragment.FragmentFactory;
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
    protected void createContent() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tabChange(0);
    }

    //底部 tab 的点击事件
    public  void onClick(View view){
      switch (view.getId()){
          case R.id.btn_cartoon: //第一页
              changeFragment(FragmentFactory.TAB_FIRST);
              break;
          case R.id.btn_news://第2页
              changeFragment(FragmentFactory.TAB_SECOND);
              break;
          case R.id.btn_novel://第3页
              changeFragment(FragmentFactory.TAB_THIRD);
              break;
          case R.id.btn_mine://第4页
              changeFragment(FragmentFactory.TAB_FOURTH);
              break;
      }
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


    private void tabChange(int index) {
        switch (index){
            case 0:
                mCartoonBtn.setBackgroundResource(R.color.blue);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.white));
                mNewsBtn.setBackgroundResource(R.color.transparent);
                mNewsBtn.setTextColor(getResources().getColor(R.color.blue));
                mNovelBtn.setBackgroundResource(R.color.transparent);
                mNovelBtn. setTextColor(getResources().getColor(R.color.blue));
                mMineBtn.setBackgroundResource(R.color.transparent);
                mMineBtn. setTextColor(getResources().getColor(R.color.blue));
                break;
            case 1:
                mCartoonBtn.setBackgroundResource(R.color.transparent);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mNewsBtn.setBackgroundResource(R.color.blue);
                mNewsBtn.setTextColor(getResources().getColor(R.color.white));
                mNovelBtn.setBackgroundResource(R.color.transparent);
                mNovelBtn.setTextColor(getResources().getColor(R.color.blue));
                mMineBtn.setBackgroundResource(R.color.transparent);
                mMineBtn.setTextColor(getResources().getColor(R.color.blue));
                break;
            case 2:
                mCartoonBtn.setBackgroundResource(R.color.transparent);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mNewsBtn.setBackgroundResource(R.color.transparent);
                mNewsBtn.setTextColor(getResources().getColor(R.color.blue));
                mNovelBtn.setBackgroundResource(R.color.blue);
                mNovelBtn.setTextColor(getResources().getColor(R.color.white));
                mMineBtn.setBackgroundResource(R.color.transparent);
                mMineBtn.setTextColor(getResources().getColor(R.color.blue));
                break;
            case 3:
                mCartoonBtn.setBackgroundResource(R.color.transparent);
                mCartoonBtn.setTextColor(getResources().getColor(R.color.blue));
                mNewsBtn.setBackgroundResource(R.color.transparent);
                mNewsBtn.setTextColor(getResources().getColor(R.color.blue));
                mNovelBtn.setBackgroundResource(R.color.transparent);
                mNovelBtn.setTextColor(getResources().getColor(R.color.blue));
                mMineBtn.setBackgroundResource(R.color.blue);
                mMineBtn.setTextColor(getResources().getColor(R.color.white));
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
}
