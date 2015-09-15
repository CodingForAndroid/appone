package com.bczm.widgetcollections.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.http.ConfigManage;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.http.parse.JsonHelper;
import com.bczm.widgetcollections.http.protocol.RecommandProtocol;
import com.bczm.widgetcollections.ui.widget.LoadingPage.LoadResult;
import com.bczm.widgetcollections.utils.FileUtils;
import com.bczm.widgetcollections.utils.LayoutGenetator;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SharedPreferenceUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommandFragment extends BaseFragment {
    // 存储顶部轮播图的集合
    private ArrayList<RecommandPositionInfo> resultList;
    @Override
    protected LoadResult load() {
        RecommandProtocol protocol = new RecommandProtocol();
        loadData();
        resultList = protocol.load(0);

        return check(resultList);
    }

    @Override
    protected View createLoadedView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommand, null);
//        ButterKnife.bind(this,view);
        // 此时list 已经包含信息
        LinearLayout rlView = (LinearLayout) view.findViewById(R.id.rl_view);
        LayoutGenetator.getneratePagerView(resultList, getActivity(), rlView);
        LayoutGenetator.generateGridView(popList, rlView);
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

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    private ArrayList<RecommandPositionInfo> popList=new ArrayList<RecommandPositionInfo>();
    public  void  loadData(){
      // 轮播图下面的六个item
        JsonObjectRequest popContentRequest=new JsonObjectRequest(NetUtils.FETCH_POPULAR_CONTENT,null, new Response.SuccessListener<JSONObject>() {
            @Override
            public void onResponse(final JSONObject object) {
             LogUtils.e(object.toString());
                JSONArray arrays= object.optJSONArray("items");
                JsonHelper.JSONArrayToList(arrays,popList , RecommandPositionInfo.class);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                UIUtils.showToastSafe(volleyError.toString());
                LogUtils.log2File(volleyError.toString(), FileUtils.DOWNLOAD_DIR+"abc.txt");
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                return    ConfigManage.getHeaders();
            }
        };
        HttpUtil.getRequestQueue().add(popContentRequest);

    }
}
