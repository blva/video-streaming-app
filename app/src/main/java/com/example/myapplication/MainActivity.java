package com.example.myapplication;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button watchButton = findViewById(R.id.button);


        watchButton.setOnClickListener( view -> {
            String videoLink = "https://www.radiantmediaplayer.com/media/bbb-360p.mp4";
            VideoView myView = findViewById(R.id.video);

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(myView);
            myView.setMediaController(mediaController);
            myView.setVideoURI(Uri.parse(videoLink));
            myView.setVideoPath(videoLink);
            myView.requestFocus();
            myView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    myView.start();
                }
            });
        });

    }
}
