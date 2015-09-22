package com.bczm.widgetcollections.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.Channel;
import com.bczm.widgetcollections.bean.ChannelItemDetail;
import com.bczm.widgetcollections.manager.ImageLoader;
import com.bczm.widgetcollections.utils.UIUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author：Jorge on 2015/9/16 12:25
 */
public class ChannelHolder extends BaseHolder<Channel> {


    @Bind(R.id.iv_1)
    ImageView iv1;
    @Bind(R.id.tv_1_title)
    TextView tv1Title;
    @Bind(R.id.tv_1_sub_title)
    TextView tv1SubTitle;
    @Bind(R.id.rl_1)
    RelativeLayout rl1;
    @Bind(R.id.iv_2)
    ImageView iv2;
    @Bind(R.id.tv_2_title)
    TextView tv2Title;
    @Bind(R.id.tv_2_sub_title)
    TextView tv2SubTitle;
    @Bind(R.id.rl_2)
    RelativeLayout rl2;
    @Bind(R.id.iv_3)
    ImageView iv3;
    @Bind(R.id.tv_3_title)
    TextView tv3Title;
    @Bind(R.id.tv_3_sub_title)
    TextView tv3SubTitle;
    @Bind(R.id.rl_3)
    RelativeLayout rl3;
    @Bind(R.id.iv_4)
    ImageView iv4;
    @Bind(R.id.tv_4_title)
    TextView tv4Title;
    @Bind(R.id.tv_4_sub_title)
    TextView tv4SubTitle;
    @Bind(R.id.rl_4)
    RelativeLayout rl4;
    @Bind(R.id.iv_5)
    ImageView iv5;
    @Bind(R.id.tv_5_title)
    TextView tv5Title;
    @Bind(R.id.tv_5_sub_title)
    TextView tv5SubTitle;
    @Bind(R.id.rl_5)
    RelativeLayout rl5;
    @Bind(R.id.iv_6)
    ImageView iv6;
    @Bind(R.id.tv_6_title)
    TextView tv6Title;
    @Bind(R.id.tv_6_sub_title)
    TextView tv6SubTitle;
    @Bind(R.id.rl_6)
    RelativeLayout rl6;
    @Bind(R.id.iv_7)
    ImageView iv7;
    @Bind(R.id.tv_7_title)
    TextView tv7Title;
    @Bind(R.id.tv_7_sub_title)
    TextView tv7SubTitle;
    @Bind(R.id.rl_7)
    RelativeLayout rl7;
    @Bind(R.id.iv_8)
    ImageView iv8;
    @Bind(R.id.tv_8_title)
    TextView tv8Title;
    @Bind(R.id.tv_8_sub_title)
    TextView tv8SubTitle;
    @Bind(R.id.rl_8)
    RelativeLayout rl8;
    @Bind(R.id.iv_9)
    ImageView iv9;
    @Bind(R.id.tv_9_title)
    TextView tv9Title;
    @Bind(R.id.tv_9_sub_title)
    TextView tv9SubTitle;
    @Bind(R.id.rl_9)
    RelativeLayout rl9;

    @Override
    protected View initView() {
        View view = UIUtils.inflate(R.layout.item_recommended_channel);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void refreshView() {
        ImageView[] covers = {iv2, iv3, iv4, iv5, iv6,iv7,iv8,iv9};
        TextView[] titles = {tv2Title, tv3Title, tv4Title, tv5Title, tv6Title,tv7Title,tv8Title,tv9Title};
        TextView[] subTitles = {tv2SubTitle, tv3SubTitle, tv4SubTitle, tv5SubTitle, tv6SubTitle,tv7SubTitle,tv8SubTitle,tv9SubTitle};
        RelativeLayout[] layouts={rl2,rl3,rl4,rl5,rl6,rl7,rl8,rl9};
        for(int i=0;i<layouts.length;i++){
            layouts[i].setVisibility(View.GONE);
        }
        String cover = getData().data_cover.split("\\?")[0];
        List<ChannelItemDetail> itemDetailList = getData().contents;
        ImageLoader.getInstance().imageLoaderRequest(iv1, cover);
        for (int i = 0; i < itemDetailList.size(); i++) {
            ChannelItemDetail item = itemDetailList.get(i);
            ImageLoader.getInstance().imageLoaderRequest(covers[i], item.cover.split("\\?")[0]);
            titles[i].setText(item.title);
            subTitles[i].setText(item.sub_title);
            layouts[i].setVisibility(View.VISIBLE);
        }

    }
}
