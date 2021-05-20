package com.nirmitthummar.practical_11_videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView clip = findViewById(R.id.clip);
        clip.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.animals);
        MediaController mediaController = new MediaController(this);
        clip.setMediaController(mediaController);
        mediaController.setAnchorView(clip);
        clip.start();
    }
}