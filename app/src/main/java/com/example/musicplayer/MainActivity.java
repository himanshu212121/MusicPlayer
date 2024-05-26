package com.example.musicplayer;



//import static com.example.musicplayer.R.id.btn_play;
import com.example.musicplayer.R;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button play, stop, pause;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.btn_play);
        pause = findViewById(R.id.btn_pause);
        stop = findViewById(R.id.btn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override

        public void onClick(View view) {
            int id = view.getId();  // Get the ID of the clicked view
            if (id == R.id.btn_play) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.music);
                    mediaPlayer.setOnCompletionListener(mp -> stopMediaPlayer());
                }
                mediaPlayer.start();
            } else if (id == R.id.btn_pause) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            } else if (id == R.id.btn_stop) {
                stopMediaPlayer();
            }
        }

        private void stopMediaPlayer() {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            stopMediaPlayer();
        }
    }