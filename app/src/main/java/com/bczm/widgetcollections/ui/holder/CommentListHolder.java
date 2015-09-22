package com.bczm.widgetcollections.ui.holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.CommentBean;
import com.bczm.widgetcollections.manager.ImageLoader;
import com.bczm.widgetcollections.utils.DateFormatUtil;
import com.bczm.widgetcollections.utils.LogUtils;
import com.bczm.widgetcollections.utils.SystemUtils;
import com.bczm.widgetcollections.utils.UIUtils;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 评论列表的 初始化 刷新
 *
 * @author：Jorge on 2015/9/22 11:53
 */
public class CommentListHolder extends BaseHolder<CommentBean> {

    @Bind(R.id.profile_image)
    CircleImageView profileImage;
    @Bind(R.id.tv_nick)
    TextView tvNick;
    @Bind(R.id.tv_time)
    TextView tvTime;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.ll_content)
    LinearLayout llContent;

    @Override
    protected View initView() {
        View view = UIUtils.inflate(R.layout.item_comment_list);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void refreshView() {
        CommentBean commentBean = getData();
        // 头像
        ImageLoader.getInstance().imageLoaderRequest(profileImage, commentBean.photo);
        // 昵称 时间 内容
        tvNick.setText(commentBean.nickname);
        tvNick.setTextColor(UIUtils.getColor(R.color.blue));
        long time=Long.parseLong(commentBean.create_time+"000");
        tvTime.setTextColor(UIUtils.getColor(R.color.gray));
        tvTime.setText(DateFormatUtil.formatTime(DateFormatUtil.format(time)));
        tvContent.setText(commentBean.text);
        tvContent.setTextColor(UIUtils.getColor(R.color.black));
    }
}
