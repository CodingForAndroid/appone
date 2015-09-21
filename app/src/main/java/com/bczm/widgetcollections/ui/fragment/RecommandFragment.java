package com.bczm.widgetcollections.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.Channel;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.bean.RecommendAppInfo;
import com.bczm.widgetcollections.bean.RecommendedChannel;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.http.parse.JsonHelper;
import com.bczm.widgetcollections.http.protocol.RecommandTopProtocol;
import com.bczm.widgetcollections.http.protocol.RecommendedAppProtocol;
import com.bczm.widgetcollections.http.protocol.RecommendedChannelProtocol;
import com.bczm.widgetcollections.http.protocol.RecommendedPopProtocol;
import com.bczm.widgetcollections.ui.adapter.DefaultAdapter;
import com.bczm.widgetcollections.ui.holder.BaseHolder;
import com.bczm.widgetcollections.ui.holder.ChannelADHolder;
import com.bczm.widgetcollections.ui.holder.ChannelHolder;
import com.bczm.widgetcollections.ui.widget.BaseListView;
import com.bczm.widgetcollections.ui.widget.LoadingPage.LoadResult;
import com.bczm.widgetcollections.ui.widget.MyGridView;
import com.bczm.widgetcollections.utils.FileUtils;
import com.bczm.widgetcollections.utils.LayoutGenetator;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommandFragment extends BaseFragment {
    // 存储顶部轮播图的集合
    private ArrayList<RecommandPositionInfo> resultList;
    private LinearLayout rlView;
    // 推荐频道的容器
    private RecommendedChannel recommendedChannel;
    // 推荐应用的容器
    private List<RecommendAppInfo> appList;
    @Override
    protected LoadResult load() {
        // 顶部轮播
        RecommandTopProtocol protocol = new RecommandTopProtocol();
        resultList = protocol.load(0);
        loadData();
        return check(resultList);
    }
    @Override
    protected View createLoadedView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommand, null);
        // 此时list 已经包含信息
        rlView = (LinearLayout) view.findViewById(R.id.rl_view);
        //添加viewpager
        LayoutGenetator.getneratePagerView(resultList, getActivity(), rlView);
        // 添加6个推荐位置
        LayoutGenetator.generateRecommendPosition(popList, rlView);
        //添加 推荐频道
        generateRecommendedChannels(recommendedChannel, rlView);

        // 添加更多频道按钮
        LayoutGenetator.genenrateMoreChannels(rlView, R.string.txt_recommend_more, R.mipmap.ic_hot_click);
        // 添加 应用推荐 模块
        LayoutGenetator.generateRecommendedApp(rlView,appList);
        // 添加更多应用
        LayoutGenetator.genenrateMoreChannels(rlView,R.string.txt_recommend_more_app,R.mipmap.ic_like_click);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    // 推荐位置
    private ArrayList<RecommandPositionInfo> popList=new ArrayList<RecommandPositionInfo>();
    public  void  loadData(){
        // 顶部六个 位置
        RecommendedPopProtocol popProtocol=new RecommendedPopProtocol();
        if(null!=popProtocol.load(0))
        popList= popProtocol.load(0);
        // 推荐频道
        RecommendedChannelProtocol recommendedChannelProtocol=new RecommendedChannelProtocol();
        recommendedChannel = recommendedChannelProtocol.load(0);
        // 推荐应用
        RecommendedAppProtocol recommendedAppProtocol= new RecommendedAppProtocol();
        appList=recommendedAppProtocol.load(0);
    }

/**********************************************适配器  适配数据**************************************************************/
    /**
     * 生成推荐频道
     * @param recommendeChannel  推荐频道 item
     * @param layout_item_container  父容器
     */
    public   void  generateRecommendedChannels(RecommendedChannel  recommendeChannel,LinearLayout layout_item_container){

        List<Channel> list=recommendeChannel.items;
        BaseListView listView=new BaseListView(UIUtils.getContext());
        RelativeLayout.LayoutParams cParams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT,  RelativeLayout.LayoutParams.WRAP_CONTENT) ;
        layout_item_container.addView(listView, cParams);
        listView.setAdapter(new ChannelAdapter(listView, list));
    }

    private class ChannelAdapter extends DefaultAdapter<Channel>{

        private int mCurrentPosition;

        public ChannelAdapter(AbsListView listView, List<Channel> channels) {
            super(listView, channels);
            LogUtils.e(" List<Channel> channels:" + channels.size());
        }

        @Override
        public boolean hasMore() {
            return false;
        }

        //告诉 有几种布局
        @Override
        public int getViewTypeCount() {
            return super.getViewTypeCount()+1;
        }

        @Override
        public int getItemViewTypeInner(int position) {
            Channel channel= getData().get(position);
            if(channel.contents==null||channel.contents.size()==0){
                //广告布局
                return super.getItemViewTypeInner(position) + 1;
            }else{
                // 推荐位置布局
                return super.getItemViewTypeInner(position) ;
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            mCurrentPosition = position;
            return super.getView(position, convertView, parent);
        }

        @Override
        protected BaseHolder getHolder() {
            Channel channel= getData().get(mCurrentPosition);
            if(channel.contents==null||channel.contents.size()==0){
                //广告布局
                return  new ChannelADHolder();
            }else{
                // 推荐位置布局
                return  new ChannelHolder();
            }
        }
    }
/**********************************************适配器**************************************************************/
}
