package com.bczm.widgetcollections.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.manager.ImageLoader;
import com.bczm.widgetcollections.ui.activity.FirstActivity;
import com.bczm.widgetcollections.utils.SystemUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author：Jorge on 2015/9/6 17:21
 */
public class CategoryAdapter extends ArrayAdapter implements View.OnClickListener {
    public String[] itmes = {"引导页", "Material Design", "标题3", "标题4"};
    private List<RecommandPositionInfo> mList;
    private Context cxt;
    public CategoryAdapter(Context context,List<RecommandPositionInfo> list) {
        super(context, R.layout.item_main);
        this.cxt = context;
        mList=list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
        convertView = LayoutInflater.from(cxt).inflate(R.layout.item_main, null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
        int width=(SystemUtils.getScreenWidth()-20)/2;
        int height=3*width/4;
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.FILL_PARENT);
        params.height = height;
        params.width = width;
        convertView.setLayoutParams(params);
        RecommandPositionInfo info=  mList.get(position);
        ImageLoader.getInstance().imageLoaderRequest(holder.mImageView, info.pic.split("\\?")[0]);
        return convertView;
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_main.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        ImageView mImageView;
        ViewHolder(View view) {
            if(mImageView==null){
              mImageView=(ImageView)view.findViewById(R.id.anchor_img);
            }
        }
    }
}