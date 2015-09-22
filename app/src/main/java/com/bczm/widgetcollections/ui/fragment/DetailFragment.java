package com.bczm.widgetcollections.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.CommentBean;
import com.bczm.widgetcollections.bean.GuessFavoriteBean;
import com.bczm.widgetcollections.http.protocol.VideoDetailProtocol;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.utils.LayoutGenetator;
import com.bczm.widgetcollections.utils.UIUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 播放视频 详情
 *
 * @author：Jorge on 2015/9/21 11:00
 */
public class DetailFragment extends BaseFragment {
    @Bind(R.id.ll_fragment_detail)
    LinearLayout llFragmentDetail;
    private GuessFavoriteBean[] array;
    private List<CommentBean> list;
    private String desc;

    @Override
    protected LoadingPage.LoadResult load() {
//        Boolean b = null
        VideoDetailProtocol videoDetailProtocol = new VideoDetailProtocol();
        //彩泥喜欢
        array = videoDetailProtocol.getGuessFavoriteArray();
        // 视频介绍
        desc = videoDetailProtocol.getVideoDetailDesc();
        // 获取评论 列表
        list = videoDetailProtocol.getVideoCommentList();
        return LoadingPage.LoadResult.SUCCEED;
    }

    @Override
    protected View createLoadedView() {
        View view = UIUtils.inflate(R.layout.fragment_detail);
        ButterKnife.bind(this, view);
        // 添加头部信息
        LayoutGenetator.generateDetail(desc, llFragmentDetail);
        //  添加推荐 video
        LayoutGenetator.generateGuessLike(array, llFragmentDetail);
        // 添加评论列表
        LayoutGenetator.generateCommentList(list,llFragmentDetail);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
