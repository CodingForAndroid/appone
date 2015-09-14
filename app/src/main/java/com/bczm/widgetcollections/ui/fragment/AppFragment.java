package com.bczm.widgetcollections.ui.fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.widget.LoadingPage;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AppFragment extends BaseFragment {


    @Override
    protected LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.EMPTY;
    }

    @Override
    protected View createLoadedView() {
        View parentView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommand, null);
        ButterKnife.bind(this, parentView);
        return parentView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
//        AnimationUtil.runAnimation(runImage);
    }
}
