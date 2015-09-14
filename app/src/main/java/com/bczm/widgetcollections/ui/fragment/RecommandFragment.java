package com.bczm.widgetcollections.ui.fragment;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.http.HttpUtil;
import com.bczm.widgetcollections.http.NetUtils;
import com.bczm.widgetcollections.http.parse.JsonHelper;
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
import java.util.Map;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommandFragment extends BaseFragment {

    @Bind(R.id.rl_main_parent)
    RelativeLayout rlMainParent;
    @Bind(R.id.tv_navi_left)
    TextView tvNaviLeft;

    @Override
    public void show() {
        super.show();
    }

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_navi_right)
    TextView tvNaviRight;

    private   RelativeLayout relativeLayout;
    @Override
    protected LoadResult load() {
        loadFromNet();

        return LoadResult.SUCCEED;
    }

    @Override
    protected View createLoadedView() {
         relativeLayout = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.fragment_recommand, null);
////        ButterKnife.bind(this, parentView);
////        CategoryAdapter adapter=  new CategoryAdapter(getActivity(),R.layout.item_main);
////        mGridView.setAdapter(adapter);
////        SwipeFlingAdapterView fra=  parentView.findViewById(R.id.swipe);
//            CycleImageView  cycleView= new CycleImageView(getActivity());
////        AnimationUtil.runAnimation(runImage);
        LogUtils.e("createLoadedView");
//         relativeLayout = new RelativeLayout(getActivity());
//        RelativeLayout.LayoutParams  params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        relativeLayout.setLayoutParams(params);
        return relativeLayout;
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
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onStop() {
        super.onStop();
//        AnimationUtil.stopAnimation(runImage);
    }


    public void loadFromNet(){

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(NetUtils.FETCH_HOME_TOP_CONTENT,null, new Response.SuccessListener<JSONObject>() {
            @Override
            public void onResponse(JSONObject object) {
                LogUtils.e(object.toString());
                ArrayList<RecommandPositionInfo> resultList = new ArrayList<RecommandPositionInfo>();

                JSONArray arrays= object.optJSONArray("items");
                JsonHelper.JSONArrayToList(arrays, resultList, RecommandPositionInfo.class);
                // 此时list 已经包含信息

                LayoutGenetator.getneratePagerView(resultList, getActivity(), relativeLayout);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                UIUtils.showToastSafe(volleyError.toString() );
                LogUtils.log2File(volleyError.toString(), FileUtils.DOWNLOAD_DIR+"abc.txt");
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("User-Agent", "Client(ERDO/4.0.11;Android/4.4.4;720*1280;G620S-UL00;PAYMD/1.0.02;)");
                headers.put("Cookie","sto-id-51017=BIBKKIMAMHEJ");
                String value = String.valueOf(System.currentTimeMillis()).subSequence(0, 10).toString();
                headers.put("timestamp",value);
                headers.put("app_id","dm_zk_6001100_81");
                headers.put("client_style","1");
                headers.put("access_token", SharedPreferenceUtils.getAccessToken());
                headers.put("promotion_id","020000000003");
                return headers;
            }
        };
        HttpUtil.getRequestQueue().add(jsonObjectRequest);
    }

}
