package com.bczm.widgetcollections.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.bczm.widgetcollections.R;
import com.bczm.widgetcollections.ui.widget.LoadingPage;
import com.bczm.widgetcollections.utils.UIUtils;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class AppFragment extends BaseFragment {


//    @Bind(R.id.vitamio_videoView)
    VideoView vitamioVideoView;
    private Button btn;


    @Override
    protected LoadingPage.LoadResult load() {
//        iniVideo();
        return LoadingPage.LoadResult.SUCCEED;
    }

    @Override
    protected View createLoadedView() {
        View parentView = UIUtils.inflate(R.layout.fragment_live);
        vitamioVideoView= (VideoView) parentView.findViewById(R.id.vitamio_videoView);
        btn = (Button) parentView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIUtils.startActivity(new Intent(getActivity(),VideoPlayerActivity.class));
            }
        });
        iniVideo();
//        ButterKnife.bind(this, parentView);
        return parentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.unbind(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        show();

    }

    public void iniVideo(){
        String path="rtmp://live.hkstv.hk.lxdns.com/live/hks";
//        AnimationUtil.runAnimation(runImage);
//        vitamioVideoView
//        HashMap<String, String> options=new HashMap<>();
//        options.put("rtmp_playpath", "");
//        options.put("rtmp_swfurl", "");
//        options.put("rtmp_live", "1");
//        options.put("rtmp_pageurl", "");*/
        vitamioVideoView.setVideoPath(path);
        vitamioVideoView.requestFocus();

        //mVideoView.setVideoURI(Uri.parse(path), options);
        MediaController controller=new MediaController(UIUtils.getContext());
        vitamioVideoView.setMediaController(controller);
        vitamioVideoView.requestFocus();
        vitamioVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN, 0);
//        vitamioVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_FIT_PARENT, 0);
//        vitamioVideoView.getHolder().setSizeFromLayout();
        vitamioVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
//                VideoView.
//                vitamioVideoView.setVideoLayout();
            }
        });
//        vitamioVideoView.getHolder().setSizeFromLayout();
//        screenBean = LocUtil.getScreenPix(this);
    }

}
