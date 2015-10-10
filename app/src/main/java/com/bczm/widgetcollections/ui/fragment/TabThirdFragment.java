package com.bczm.widgetcollections.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.bean.AudioInfo;
import com.bczm.widgetcollections.http.protocol.AudioProtocol;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 听音乐
 *
 * @author：Jorge on 2015/9/28 12:42
 * <p/>
 * step1  请求 音乐数据
 * step 2 加载布局
 */
public class TabThirdFragment extends BaseFragment {
    @Bind(R.id.tv_audio)
    TextView showAudio;
    AudioInfo audioInfo;
    @Override
    protected LoadingPage.LoadResult load() {
        AudioProtocol audioProtocol = new AudioProtocol();
         audioInfo  = audioProtocol.load(0, false);
        return check(audioInfo);
    }

    @Override
    protected View createLoadedView() {
        View view = UIUtils.inflate(R.layout.fragment_audio);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
