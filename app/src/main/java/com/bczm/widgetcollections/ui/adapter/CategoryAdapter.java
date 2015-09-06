package com.bczm.widgetcollections.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.activity.FirstActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author：Jorge on 2015/9/6 17:21
 */
public class CategoryAdapter extends ArrayAdapter {
    public String[] itmes = {"引导页", "Material Design", "标题3", "标题4", "标题5", "标题6", "标题7", "标题8", "标题9", "标题10"};
    private Context cxt;
    public CategoryAdapter(Context context,int resource) {
        super(context, resource);
        this.cxt = context;

    }

    @Override
    public int getCount() {
        return itmes.length;
    }

    @Override
    public Object getItem(int position) {
        return itmes[position];
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
        }else
        {
            holder=(ViewHolder)convertView.getTag();
        }
        holder.text.setText(itmes[position]);
        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        cxt.startActivity(new Intent(cxt,FirstActivity.class));
                        break;
                }
            }
        });
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_main.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {

        TextView text;

        RelativeLayout relative;

        ViewHolder(View view) {
          if(text==null){
              text=(TextView)view.findViewById(R.id.tv_1);
              relative=(RelativeLayout)view.findViewById(R.id.rl_1);
          }
        }
    }
}