package com.bczm.widgetcollections.ui.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.adapter.CategoryAdapter;
import com.bczm.widgetcollections.ui.widget.LoadingPage.LoadResult;
import com.bczm.widgetcollections.utils.AnimationUtil;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.UIUtils;

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
    @Bind(R.id.tv_navi_left)
    TextView tvNaviLeft;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_navi_right)
    TextView tvNaviRight;
    @Bind(R.id.gridview)
    GridView mGridView;
    @Override
    protected LoadResult load() {
        LogUtils.e(" LoadResult.SUCCEED;");

        return LoadResult.SUCCEED;
    }

    @Override
    protected View createLoadedView() {
        View parentView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, null);
//        ButterKnife.bind(this, parentView);
//        CategoryAdapter adapter=  new CategoryAdapter(getActivity(),R.layout.item_main);
//        mGridView.setAdapter(adapter);
//        SwipeFlingAdapterView fra=  parentView.findViewById(R.id.swipe);
//        AnimationUtil.runAnimation(runImage);
        LogUtils.e("createLoadedView");
        return parentView;
    }



    @Override
    public void onResume() {
        super.onResume();
        show();
//        AnimationUtil.runAnimation(runImage);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    @Override
    public void onStop() {
        super.onStop();
//        AnimationUtil.stopAnimation(runImage);
    }


}
