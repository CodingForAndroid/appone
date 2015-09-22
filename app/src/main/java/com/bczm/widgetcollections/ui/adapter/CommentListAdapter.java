package com.bczm.widgetcollections.ui.adapter;

import android.widget.AbsListView;

import com.bczm.widgetcollections.bean.CommentBean;
import com.bczm.widgetcollections.http.protocol.VideoDetailProtocol;
import com.bczm.widgetcollections.ui.holder.BaseHolder;
import com.bczm.widgetcollections.ui.holder.CommentListHolder;

import java.util.List;

/**
 * 评论列表适配器
 * @author：Jorge on 2015/9/22 11:20
 */
public class CommentListAdapter extends DefaultAdapter<CommentBean> {
    public CommentListAdapter(AbsListView listView, List<CommentBean> objects) {
        super(listView, objects);
    }
    @Override
    protected BaseHolder getHolder() {
        return new CommentListHolder();
    }

    @Override
    public boolean hasMore() {
        return false;
    }
    //    @Override
//    public List<CommentBean> onLoadMore() {
//
//        VideoDetailProtocol protocol=new VideoDetailProtocol();
//        return protocol.getVideoCommentList();
////         super.onLoadMore();
////        return null ;
//    }
}
