package com.bczm.widgetcollections.ui.holder;

import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.TextView;
import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.utils.SystemUtils;
import com.bczm.widgetcollections.utils.UIUtils;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 其他章节的 holder
 *
 * @author：Jorge on 2015/9/23 11:36
 */
public class ChapterHolder extends BaseHolder<Integer> implements View.OnClickListener {
    @Bind(R.id.tv_chapter_01)
    TextView tvChapter01;
    @Bind(R.id.tv_chapter_02)
    TextView tvChapter02;
    @Bind(R.id.tv_chapter_03)
    TextView tvChapter03;
    @Bind(R.id.tv_chapter_04)
    TextView tvChapter04;
    @Bind(R.id.tv_chapter_05)
    TextView tvChapter05;

    private TextView[] arr={tvChapter01,tvChapter02,tvChapter03,tvChapter04,tvChapter05};
    @Override
    protected View initView() {
        View view = UIUtils.inflate(R.layout.item_chapter);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, SystemUtils.getScreenWidth() / 5);
//        SystemUtils.getScreenWidth()/5
        view.setLayoutParams(layoutParams);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void refreshView() {
        tvChapter01.setText("01");
        tvChapter02.setText("02");
        tvChapter03.setText("03");
        tvChapter04.setText("04");
        tvChapter05.setText("05");
    }

    @Override
    public void onClick(View view) {
        UIUtils.showToastSafe("01");
       if(view==tvChapter01){
           UIUtils.showToastSafe("01");
       }else if(view==tvChapter02){
           UIUtils.showToastSafe("02");
       }else if(view==tvChapter03){
           UIUtils.showToastSafe("03");
       }else if(view==tvChapter04){
           UIUtils.showToastSafe("04");

       }else if(view==tvChapter05){
           UIUtils.showToastSafe("05");
       }
      for(int i=0;i<arr.length;i++){
          arr[i].setBackgroundResource(R.color.orange_light);
          arr[i].setTextColor(UIUtils.getColor(R.color.gray));
          if(view==arr[i]){
              arr[i].setBackgroundResource(R.color.blue);
              arr[i].setTextColor(UIUtils.getColor(R.color.white));
          }
      }
    }
}
