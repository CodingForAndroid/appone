package com.bczm.widgetcollections.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.utils.LayoutGenetator;
import com.bczm.widgetcollections.utils.UIUtils;

/**
 * 看电视
 */
public class TabSecondFragment extends BaseFragment implements View.OnClickListener {


    private LinearLayout parentView;

    @Override
    protected void initViewsAndEvents() {


    }

    @Override
    protected LoadingPage.LoadResult load() {
//        iniVideo();
        return LoadingPage.LoadResult.SUCCEED;
    }

    @Override
    protected View createLoadedView() {
        parentView = (LinearLayout) UIUtils.inflate(R.layout.fragment_live);

          LayoutGenetator.generateTVChannel(R.string.channel_hk, R.id.comm_id_01, parentView);
//        UIUtils.startActivity(new Intent(getActivity(), VideoPlayerActivity.class));
        RelativeLayout mHKTVLayout = (RelativeLayout) parentView.findViewById(getResources().getIdentifier("comm_id_01", "id", UIUtils.getContext().getPackageName()));
        mHKTVLayout.setOnClickListener(this);
        return parentView;
    }


    @Override
    public void onResume() {
        super.onResume();
//        show();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View view) {
        UIUtils.startActivity(new Intent(getActivity(), VideoPlayerActivity.class));
    }
}
