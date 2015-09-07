package com.bczm.widgetcollections.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.utils.AnimationUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AppFragment extends BaseFragment {

    @Bind(R.id.run_image)
    ImageView runImage;

    @Override
    protected LoadingPage.LoadResult load() {
        return null;
    }

    @Override
    protected View createLoadedView() {
        View parentView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, null);
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
