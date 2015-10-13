package com.bczm.widgetcollections.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.common.Constants;
import com.bczm.widgetcollections.http.ConfigManage;
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
        LayoutGenetator.generateTVChannel(R.string.channel_cibn, R.id.comm_id_02, parentView);
        LayoutGenetator.generateTVChannel(R.string.channel_hs, R.id.comm_id_03, parentView);
        LayoutGenetator.generateTVChannel(R.string.channel_fox, R.id.comm_id_04, parentView);
        LayoutGenetator.generateTVChannel(R.string.channel_czys, R.id.comm_id_05, parentView);
        LayoutGenetator.generateTVChannel(R.string.channel_tai, R.id.comm_id_06, parentView);
//        UIUtils.startActivity(new Intent(getActivity(), VideoPlayerActivity.class));
        RelativeLayout mHKTVLayout = (RelativeLayout) parentView.findViewById(getResources().getIdentifier("comm_id_01", "id", UIUtils.getContext().getPackageName()));
        RelativeLayout mCIBNTVLayout = (RelativeLayout) parentView.findViewById(getResources().getIdentifier("comm_id_02", "id", UIUtils.getContext().getPackageName()));
        RelativeLayout mHSTVLayout = (RelativeLayout) parentView.findViewById(getResources().getIdentifier("comm_id_03", "id", UIUtils.getContext().getPackageName()));
        RelativeLayout MFoxTVLayout = (RelativeLayout) parentView.findViewById(getResources().getIdentifier("comm_id_04", "id", UIUtils.getContext().getPackageName()));
        RelativeLayout MZCYSTVLayout = (RelativeLayout) parentView.findViewById(getResources().getIdentifier("comm_id_05", "id", UIUtils.getContext().getPackageName()));
        RelativeLayout mTaiTVLayout = (RelativeLayout) parentView.findViewById(getResources().getIdentifier("comm_id_06", "id", UIUtils.getContext().getPackageName()));

        mHKTVLayout.setOnClickListener(this);
        mCIBNTVLayout.setOnClickListener(this);
        mHSTVLayout.setOnClickListener(this);
        MFoxTVLayout.setOnClickListener(this);
        MZCYSTVLayout.setOnClickListener(this);
        mTaiTVLayout.setOnClickListener(this);
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
        Intent intent = null;
        switch (view.getId()){
            case  R.id.comm_id_01: // 香港卫视
                 intent=    new Intent(getActivity(), VideoPlayerActivity.class);
                intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_PATH, ConfigManage.CHANNEL_HK);
                intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_TITLE, UIUtils.getString(R.string.channel_hk));
//                intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL, "http://officetv.bupt.edu.cn/hls/cctv5hd.m3u8");
                break;
            case  R.id.comm_id_02: // CIBN 经典影视
                 intent=    new Intent(getActivity(), VideoPlayerActivity.class);
                intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_PATH, ConfigManage.CHANNEL_CIBN);
                intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_TITLE, UIUtils.getString(R.string.channel_cibn));
                break;
            case  R.id.comm_id_03: //华视HD
                 intent=    new Intent(getActivity(), VideoPlayerActivity.class);
                intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_PATH, ConfigManage.CHANNEL_HSHD);
                intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_TITLE, UIUtils.getString(R.string.channel_hs));
                break;
            case  R.id.comm_id_04: // Fox 台
                 intent=    new Intent(getActivity(), VideoPlayerActivity.class);
             intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_PATH, ConfigManage.CHANNEL_FOX);
             intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_TITLE, UIUtils.getString(R.string.channel_fox));
                break;
            case  R.id.comm_id_05: // 橙子影院
                 intent=    new Intent(getActivity(), VideoPlayerActivity.class);
             intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_PATH, ConfigManage.CHANNEL_CZYS);
             intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_TITLE, UIUtils.getString(R.string.channel_czys));
                break;
            case  R.id.comm_id_06: // 泰国中文台
                 intent=    new Intent(getActivity(), VideoPlayerActivity.class);
             intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_PATH, ConfigManage.CHANNEL_TAI);
             intent.putExtra(Constants.INTENT_BUNDLE_KEY_CHANNEL_TITLE, UIUtils.getString(R.string.channel_tai));
                break;
        }
                UIUtils.startActivity(intent);
    }
}
