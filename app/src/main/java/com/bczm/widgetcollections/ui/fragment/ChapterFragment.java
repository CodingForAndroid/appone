package com.bczm.widgetcollections.ui.fragment;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.ChapterItem;
import com.bczm.widgetcollections.bean.ChapterSet;
import com.bczm.widgetcollections.http.protocol.VideoDetailProtocol;
import com.bczm.widgetcollections.ui.adapter.DefaultAdapter;
import com.bczm.widgetcollections.ui.holder.BaseHolder;
import com.bczm.widgetcollections.ui.holder.ChapterHolder;
import com.bczm.widgetcollections.ui.widget.BaseListView;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.utils.LayoutGenetator;
import com.bczm.widgetcollections.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 播放界面的 目录
 * @author：Jorge on 2015/9/23 08:52
 */
public class ChapterFragment  extends BaseFragment{



    @Override
    protected LoadingPage.LoadResult load() {
        VideoDetailProtocol videoDetailProtocol = new VideoDetailProtocol();
        return LoadingPage.LoadResult.SUCCEED;
    }

    @Override
    protected View createLoadedView() {
        LinearLayout linearLayout=new LinearLayout(UIUtils.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //添加清晰度
        LayoutGenetator.generateCellTable(R.id.comm_id_01, R.id.comm_id_02, R.id.comm_id_03, linearLayout);
        // 添加 集数
        generateList(linearLayout);
        return linearLayout;
    }


    // 生成列表
    public void  generateList(LinearLayout container){
        BaseListView listView=new BaseListView(UIUtils.getContext());
//        listView.setBackgroundColor(UIUtils.getColor(R.color.blue));
        RelativeLayout.LayoutParams cParams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT,  RelativeLayout.LayoutParams.WRAP_CONTENT) ;
        container.addView(listView, cParams);
        List list=  new ArrayList<Integer>();
        for(int i=0;i<1;i++){
            list.add(i);
        }
        listView.setAdapter(new ChapterAdapter(listView,list));

    }

    public class ChapterAdapter extends DefaultAdapter<Integer>{


        public ChapterAdapter(AbsListView listView, List<Integer> integers) {
            super(listView, integers);
        }

        @Override
        public boolean hasMore() {
            return false;
        }

        @Override
        protected BaseHolder getHolder() {
            return new ChapterHolder();
        }
    }

}
