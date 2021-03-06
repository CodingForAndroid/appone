package com.bczm.widgetcollections.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.ui.widget.LoadingPage.LoadResult;
import com.bczm.widgetcollections.utils.UIUtils;
import com.bczm.widgetcollections.utils.ViewUtils;
import java.util.List;

import io.vov.vitamio.LibsChecker;

public abstract class BaseFragment extends Fragment {
    protected LoadingPage mContentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //每次ViewPager要展示该页面时，均会调用该方法获取显示的View
        if (mContentView == null) {//为null时，创建一个

            mContentView = new LoadingPage(getActivity()) {
                @Override
                public LoadResult load() {
                    return BaseFragment.this.load();
                }

                @Override
                public View createLoadedView() {
                    View view=   BaseFragment.this.createLoadedView();
                    initViewsAndEvents();
                    return view;
                }
            };
        } else {//不为null时，需要把自身从父布局中移除，因为ViewPager会再次添加
            ViewUtils.removeSelfFromParent(mContentView);
        }

        return mContentView;
    }

    protected abstract void initViewsAndEvents();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    /** 当显示的时候，加载该页面 */
    public void show() {
        if (mContentView != null) {
            mContentView.show();
        }
    }

    public LoadResult check(Object obj) {
        if (obj == null) {
            return LoadResult.ERROR;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 0) {
                return LoadResult.EMPTY;
            }
        }
        return LoadResult.SUCCEED;
    }

    /** 加载数据 */
    protected abstract LoadResult load();

    /** 加载完成的View */
    protected abstract View createLoadedView();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(getActivity()))
            return;
    }
}