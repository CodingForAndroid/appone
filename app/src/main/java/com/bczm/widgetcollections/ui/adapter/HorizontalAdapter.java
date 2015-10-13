package com.bczm.widgetcollections.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.GuessFavoriteBean;
import com.bczm.widgetcollections.manager.ImageLoaderHelper;
import com.bczm.widgetcollections.utils.SystemUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 猜你喜欢 的适配器
 * @author：Jorge on 2015/9/21 16:51
 */
public class HorizontalAdapter extends ArrayAdapter<GuessFavoriteBean> {


    public HorizontalAdapter(Context context, GuessFavoriteBean[] beans) {

        super(context, R.layout.item_horizontal,beans);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder;
        if (convertView == null) {
            convertView = UIUtils.inflate(R.layout.item_horizontal);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(SystemUtils.getScreenWidth()*4/14, SystemUtils.getScreenHeight()/4);
        convertView.setLayoutParams(params);
        GuessFavoriteBean guessFavorite= getItem(position);
//        holder.imageView
        ImageLoaderHelper.getInstance().loadImage(guessFavorite.cover.split("\\?")[0],holder.imageView);
//        ImageLoader1.getInstance().imageLoaderRequest(holder.imageView,);
        holder.textView.setText(guessFavorite.title);
        return  convertView;
    }


    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_horizontal.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @Bind(R.id.image)
        ImageView imageView;
        @Bind(R.id.text)
        TextView textView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
