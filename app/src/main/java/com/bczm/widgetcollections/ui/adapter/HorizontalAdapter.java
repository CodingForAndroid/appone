package com.bczm.widgetcollections.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.GuessFavoriteBean;
import com.bczm.widgetcollections.manager.ImageLoader;
import com.bczm.widgetcollections.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
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
        GuessFavoriteBean guessFavouriate= getItem(position);
//        holder.imageView
        ImageLoader.getInstance().imageLoaderRequest(holder.imageView,guessFavouriate.cover.split("\\?")[0]);
        holder.textView.setText(guessFavouriate.title);
        return super.getView(position, convertView, parent);
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
