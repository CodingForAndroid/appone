package com.bczm.widgetcollections.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.Channel;
import com.bczm.widgetcollections.manager.ImageLoader;
import com.bczm.widgetcollections.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author：Jorge on 2015/9/16 12:24
 */
public class ChannelADHolder extends BaseHolder<Channel> {

    @Bind(R.id.iv_ad)
    ImageView ivAD;

    @Override
    protected View initView() {
       View view= UIUtils.inflate(R.layout.item_recommended_ad);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void refreshView() {
        String cover = getData().data_cover.split("\\?")[0];
        ImageLoader.getInstance().imageLoaderRequest(ivAD, cover);

    }
}
