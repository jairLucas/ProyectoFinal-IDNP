package com.jk.proyectofinal_idnp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient mFusedLocationClient;



    //inicializacion de variables
    TextView playerPosition, playerDuration;
    SeekBar seekbar;
    ImageView btnPlay, btnPause, btnFf, btnRew;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;
    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asignando variables
        playerPosition= findViewById(R.id.player_position);
        playerDuration= findViewById(R.id.player_duration);
        seekbar= findViewById(R.id.seek_bar);
        btnFf=findViewById(R.id.btn_ff);
        btnRew=findViewById(R.id.btn_rew);
        btnPlay=findViewById(R.id.btn_play);
        btnPause=findViewById(R.id.btn_pause);


        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.comienzo){
                    return true;

                }
                if(item.getItemId()==R.id.trayectoria){
                    return true;
                }
                if(item.getItemId()==R.id.musica){
                    return true;
                }
                if(item.getItemId()==R.id.mas){
                    return true;
                }
                return false;
            }
        });

        //inicializando mediaplayer
        mediaPlayer = MediaPlayer.create(this,R.raw.music);
        //inicializando runnable
        runnable =  new Runnable() {
            @Override
            public void run() {
                //set progress in seekbar
                seekbar.setProgress(mediaPlayer.getCurrentPosition());
                //handler post delay 0.5 seconds
                handler.postDelayed(this, 500);

            }

        };
        //get duration of mediaplayer
        int duration = mediaPlayer.getDuration();
        //converting milliseconds to minute and seconds
        String sduration = convertFormat(duration);
        //set duration on text view
        playerDuration.setText(sduration);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide play btn
                btnPlay.setVisibility(View.GONE);
                //show pasue btn
                btnPause.setVisibility(View.VISIBLE);
                //START MEDIA PLAYER
                mediaPlayer.start();
                //set max on seekbar
                seekbar.setMax(mediaPlayer.getDuration());
                //start handler
                handler.postDelayed(runnable, 0 );


            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hide pause btn
                btnPause.setVisibility(View.GONE);
                //show play btn
                btnPlay.setVisibility(View.VISIBLE);
                mediaPlayer.pause();
                //stop handler
                handler.removeCallbacks(runnable);


            }
        });

        btnFf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get current position of media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                //get duration of media playet
                int duration= mediaPlayer.getDuration();
                //check condition
                if (mediaPlayer.isPlaying()&& duration != currentPosition){
                    //cuando media player se esta reproduciendo y la duracion no es igual a la posicion actual
                    //fast forward aumenta 5 sec
                    currentPosition = currentPosition + 5000;
                    //cambiar la posicion actual en el textview
                    playerPosition.setText(convertFormat(currentPosition));
                    //cambiar progreso en seekbar
                    mediaPlayer.seekTo(currentPosition);

                }
            }
        });

        btnRew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get current position of media player
                int currentPosition = mediaPlayer.getCurrentPosition();
                //check condition
                if (mediaPlayer.isPlaying()&& currentPosition > 5000){
                    //cuando media player se esta reproduciendo y la duracion no es igual a la posicion actual
                    //fast forward aumenta 5 sec
                    currentPosition = currentPosition - 5000;
                    //cambiar la posicion actual en el textview
                    playerPosition.setText(convertFormat(currentPosition));
                    //cambiar progreso en seekbar
                    mediaPlayer.seekTo(currentPosition);

                }
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    //actualizar el progreso
                    mediaPlayer.seekTo(progress);
                }
                //cambiar posicion actual en text view
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //hide pause btn
                btnPause.setVisibility(View.GONE);
                //show play btn
                btnPlay.setVisibility(View.VISIBLE);
                //set mp to initial posit
                mediaPlayer.seekTo(0);

            }
        });



    }

    private String convertFormat(int duration) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration)- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));

    }
}