package com.bczm.widgetcollections.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.widget.LoadingPage.LoadResult;
import com.bczm.widgetcollections.utils.AnimationUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {
    @Bind(R.id.run_image)
    ImageView runImage;
    @Bind(R.id.rl_main_parent)
    RelativeLayout rlMainParent;

    @Override
    protected LoadResult load() {
        return LoadResult.SUCCEED;
    }
    @Override
    protected View createLoadedView(LayoutInflater inflater) {
        View parentView = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, parentView);
        return parentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        AnimationUtil.runAnimation(runImage);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

}
