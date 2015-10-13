package com.bczm.widgetcollections.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.RecommandPositionInfo;
import com.bczm.widgetcollections.manager.ImageLoaderHelper;
import com.bczm.widgetcollections.utils.SystemUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import java.util.List;

/**
 * 推荐6个 展示位置适配数据
 * @author：Jorge on 2015/9/6 17:21
 */
public class RecommendedPositionAdapter extends ArrayAdapter implements View.OnClickListener {
    public String[] itmes = {"引导页", "Material Design", "标题3", "标题4"};
    private List<RecommandPositionInfo> mList;
    private Context cxt;
    public RecommendedPositionAdapter(Context context, List<RecommandPositionInfo> list) {
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
        int width=(SystemUtils.getScreenWidth())/2;
        int height=3*width/4;
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, AbsListView.LayoutParams.FILL_PARENT);
        params.height = height;
        params.width = width;
        convertView.setLayoutParams(params);
//        convertView.setPadding(0,5,0,0);
        RecommandPositionInfo info=  mList.get(position);
        // 显示图片
        ImageLoaderHelper.getInstance().loadImage( info.pic.split("\\?")[0],holder.mImageView);
//        ImageLoader1.getInstance().imageLoaderRequest(holder.mImageView, info.pic.split("\\?")[0]);
        // 设置文字信息
        holder.upDate.setText(String.format(UIUtils.getString(R.string.update_set),info.update_set));
        holder.title.setText(info.title);
        holder.sub_title.setText(info.sub_title);
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
        //要展示的图片
        ImageView mImageView;
        //更新到多少期
        TextView upDate;
        //底部标题
        TextView title;
        //底部子标题
        TextView sub_title;

//        "title": "推理神剧：乱步奇谭",
// 	            "sub_title": "每周五1:30更新",
        ViewHolder(View view) {
            if(mImageView==null){
              mImageView=(ImageView)view.findViewById(R.id.anchor_img);
            }
            if(upDate==null){
                upDate=(TextView)view.findViewById(R.id.update_set);
            }
            if(title==null){
                title=(TextView)view.findViewById(R.id.title);
            }
            if(sub_title==null){
                sub_title=(TextView)view.findViewById(R.id.sub_title);
            }
        }
    }
}