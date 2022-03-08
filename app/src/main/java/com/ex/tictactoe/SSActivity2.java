package com.ex.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class SSActivity2 extends AppCompatActivity {

    VideoView vv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_s2);

        vv1=findViewById(R.id.videoView2);
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ssapp);
        vv1.setVideoURI(uri);
        vv1.start();
        vv1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(false);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SSActivity2.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },6000);

    }
}