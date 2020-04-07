package com.hazira.mobilelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class YoutubePlayerActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    YouTubePlayer.OnFullscreenListener onFullscreenListener;

    TextView tv;
    ExtendedFloatingActionButton fabPlay;
    ExtendedFloatingActionButton backToLesson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        Intent intents = getIntent();
        String vidLink = intents.getExtras().getString("videoURI", "fsdsd");
        String vidTitle = intents.getExtras().getString("videoTitle", "something wrong");
//        Toolbar toolbar = findViewById(R.id.toolbarYt);
//        setSupportActionBar(toolbar);
//        tv = (TextView) findViewById(R.id.id_video_play_text);
//
//        fabPlay = (ExtendedFloatingActionButton) findViewById(R.id.fabVideo);
//        backToLesson = (ExtendedFloatingActionButton) findViewById(R.id.fabBackLesson);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.playerYT);

//        tv.setText(vidTitle);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(vidLink); //"K68X3RvME2k"
//                youTubePlayer.cueVideo(vidLink,5000);
                youTubePlayer.setFullscreen(true);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.initialize(PlayerConfig.API_KEY, onInitializedListener);




//        fabPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                youTubePlayerView.initialize(PlayerConfig.API_KEY, onInitializedListener);
//            }
//        });
//
//        backToLesson.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

//    public void backToLesson(){
//        finish();
//    }
//
//    public void playVideo(){
//        youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
//    }

}